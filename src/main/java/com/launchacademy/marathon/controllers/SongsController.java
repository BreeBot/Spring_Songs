package com.launchacademy.marathon.controllers;

import com.launchacademy.marathon.models.Song;
import com.launchacademy.marathon.repositories.SongRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/songs")
public class SongsController {

  private SongRepository songRepo;

  @Autowired
  public SongsController(SongRepository songRepo) {
    this.songRepo = songRepo;
  }

//  @GetMapping
//  public Page<Song> getSongs(Pageable pageableBanana) {
//    return songRepo.findAll(pageableBanana);
//  }

  @GetMapping
  public String getSongs(Model model) {
    model.addAttribute("songs", songRepo.findByOrderByTitleDesc());
    return "songs/index";
  }


  @GetMapping("/new")
  public String newSongForm(@ModelAttribute Song song) {
    return "songs/new";
  }

  @PostMapping
  public String createSong(@ModelAttribute Song song) {
    songRepo.save(song);
    return "redirect:/songs";
  }

}






















