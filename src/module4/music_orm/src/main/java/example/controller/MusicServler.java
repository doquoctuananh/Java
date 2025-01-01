package example.controller;

import example.model.Song;
import example.model.SongForm;
import example.service.ISongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Controller
public class MusicServler {
    @Autowired
    private ISongService songService;
    @GetMapping("")
    public String index(Model model) {
        List<Song> songs = songService.findALl();
        model.addAttribute("songs", songs);
        return "index";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("songForm", new SongForm());
        return "create";
    }

    @Value("${uploadFile}")
    private String uploadFile;

    @PostMapping("/save")
    public String save(Model model, @ModelAttribute SongForm songForm) {
        MultipartFile multipartFile = songForm.getFilepath();
        String filename = multipartFile.getOriginalFilename();
        try{
            FileCopyUtils.copy(songForm.getFilepath().getBytes(),new File(uploadFile+filename));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Song song = new Song(songForm.getName(),songForm.getArtist(),songForm.getType(),filename);
        songService.save(song);
        return "redirect:/";
    }

//    @GetMapping("/musicfile/${filepath}")
//    public String musicfile(Model model, @PathVariable String filepath) {
//        return "views";
//    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable int id){
        songService.delete(id);
        return "redirect:/";
    }

    @GetMapping("/update/{id}")
    public String update(@PathVariable int id, Model model){
        Song song = songService.findById(id);
        model.addAttribute("id", song.getId());
        model.addAttribute("songForm", song);
        return "update";
    }

    @PostMapping("/updateForm")
    public String updateForm(@ModelAttribute SongForm songForm, @RequestParam int id){
        MultipartFile multipartFile = songForm.getFilepath();
        String filename = multipartFile.getOriginalFilename();
        try{
            FileCopyUtils.copy(songForm.getFilepath().getBytes(),new File(uploadFile+filename));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Song song = new Song(id,songForm.getName(),songForm.getArtist(),songForm.getType(),filename);
        songService.update(song);
        return "redirect:/";
    }
}
