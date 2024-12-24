package com.example.bai_2.controller;

import com.example.bai_2.model.Music;
import com.example.bai_2.service.IMusicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.NoSuchElementException;

@Controller
@RequestMapping("/list")
public class MusicController {
    @Autowired
    private IMusicService musicService;
    @GetMapping("")
    public ModelAndView list(Model model){
        return new ModelAndView("list", "musics", musicService.getAll());
    }
    @GetMapping("/show-add")
    public String showAddMusicForm(Model model){
        model.addAttribute("music", new Music());
        return "add";
    }
    @PostMapping("/add")
    public String addMusic(@ModelAttribute("music")Music music,
                           BindingResult bindingResult,
                           RedirectAttributes redirectAttributes,
                           Model model){
        if(bindingResult.hasErrors()){
            model.addAttribute("error", bindingResult.getAllErrors());
            return "list";
        }
        if(music.getId() == null || musicService.findById(music.getId()) != null){
                musicService.addNewMusic(music);
        } else {
            throw new DuplicateKeyException("Music already exits");
        }
        redirectAttributes.addFlashAttribute("message", "Music added successfully");
        return "redirect:/list";
    }
    @GetMapping("/{id}/show-update")
    public String showUpdateMusicForm(@PathVariable("id") int id,
                                      @ModelAttribute("list") Music music, Model model){
        if(musicService.findById(id) != null){
            model.addAttribute("list", music);
            model.addAttribute("musics", musicService.getAll());
            return "update";
        }else {
            throw new NoSuchElementException("Not found with this id to update");
        }
    }
    @PostMapping("{id}/update")
public String updateMusic(@PathVariable("id") int id, @ModelAttribute("music") Music music,
                          BindingResult bindingResult,
                          RedirectAttributes redirectAttributes,
                          Model model){
        if(bindingResult.hasErrors()){
            model.addAttribute("error", bindingResult.getAllErrors());
            return "list";
        }
        music.setId(id);
        musicService.updateMusic(id, music);
        redirectAttributes.addFlashAttribute("message", "Music updated successfully");
        return "redirect:/list";
    }
}
