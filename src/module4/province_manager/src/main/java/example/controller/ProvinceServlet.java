package example.controller;

import example.model.Province;
import example.service.province.IProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/province")
public class ProvinceServlet {
    @Autowired
    private IProvinceService provinceService;
    @GetMapping("")
    public String homeProvince(Model model) {
        List<Province> provinces = provinceService.findAll();
        model.addAttribute("provinces", provinces);
        return "province/index";
    }

    @GetMapping("/create")
    public String createProvince(Model model) {
        model.addAttribute("province", new Province());
        return "province/create";
    }

    @PostMapping("/save")
    public String saveProvince(@ModelAttribute("province") Province province) {
        provinceService.save(province);
        return "redirect:/province";
    }

    @GetMapping("/delete")
    public String deleteProvince(@RequestParam("id") int id) {
        provinceService.delete(id);
        return "redirect:/province";
    }

    @GetMapping("/edit")
    public String editProvince(@RequestParam("id") int id, Model model) {
        Province province= provinceService.findById(id);
        model.addAttribute("province", province);
        return "province/update";
    }

    @PostMapping("/edit")
    public String editProvince(@ModelAttribute("province") Province province) {
        provinceService.save(province);
        return "redirect:/province";
    }

    @GetMapping("/view")
    public String viewProvince(@RequestParam("id") int id, Model model) {
        Province province = provinceService.findById(id);
        model.addAttribute("province",province);
        return "province/view";
    }

    @GetMapping("/statistical")
    public String statisticalProvince(@RequestParam("id") long id, Model model) {
        long count = provinceService.countCustomer(id);
        model.addAttribute("count",count);

        Province provinceName =provinceService.findById(id);
        model.addAttribute("provinceName",provinceName.getName());

        List<Province> provinces = provinceService.findAll();
        model.addAttribute("provinces",provinces);
        return "/province/index";
    }
}
