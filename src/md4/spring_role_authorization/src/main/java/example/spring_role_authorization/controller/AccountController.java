package example.spring_role_authorization.controller;

import example.spring_role_authorization.common.CustomBcryptPasswordUtils;
import example.spring_role_authorization.model.Account;
import example.spring_role_authorization.model.DTO.AccountDTO;
import example.spring_role_authorization.model.Roles;
import example.spring_role_authorization.repository.IAccountRepository;
import example.spring_role_authorization.repository.IRoleRepository;
import example.spring_role_authorization.service.Impl.MailService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/account")
public class AccountController {
    @Autowired
    private IAccountRepository accountRepository;
    @Autowired
    private IRoleRepository roleRepository;

    @Autowired
    private MailService mailService;

    private String otpCache;

    @GetMapping("/create")
    public String createAccount(Model model) {
        model.addAttribute("accountDTO",new AccountDTO());
        return "/create-account";
    }

    @PostMapping("/create")
    public String createAccountUser(Model model,
                                    @Valid @ModelAttribute("accountDTO") AccountDTO accountDTO,
                                    BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("accountDTO", accountDTO);
            return "/create-account";
        }
        String username = accountDTO.getUsername();
        Account accountUserName = accountRepository.findByUsername(username);
        Account accountEmail = accountRepository.findByEmail(accountDTO.getEmail());

        if (accountUserName != null) {
            model.addAttribute("error", "username already exist");
            model.addAttribute("accountDTO", accountDTO);
            return "/create-account";
        } else if (accountEmail != null) {
            model.addAttribute("error", "email already exist");
            model.addAttribute("accountDTO", accountDTO);
            return "/create-account";
        } else {
            Account account = new Account();
            BeanUtils.copyProperties(accountDTO, account);

            Roles role = roleRepository.findByName("ROLE_USER");
            account.setRoles(role);

            String bcryptPassword = CustomBcryptPasswordUtils.customBcryptPasswordEncoder(account.getPassword());
            account.setPassword(bcryptPassword);

            accountRepository.save(account);
            model.addAttribute("error", "");
            return "redirect:/login";
        }
    }
    @GetMapping("/forget")
    public String forgetAccount(Model model) {
            return "/forget-account";
    }

    @PostMapping("forget")
    public String forgetAccount(Model model,@RequestParam(name = "email") String email) {
        Account account = accountRepository.findByEmail(email);
        if(account == null) {
            model.addAttribute("error","email not exits");
            return "/forget-account";
        }
        model.addAttribute("error","");
        
        return "/otp-account";

    }

    @GetMapping("otp")
    public String otp(Model model) {

        return "otp-account";
    }

    @PostMapping("otp")
    public String otpConfirm(Model model,@RequestParam(name = "otp") String otp){
        if(otpCache.equals(otp)) {
            return "resetpassword-account";
        }
        model.addAttribute("error", "OTP not exists");
        return "otp-account";
    }
}
