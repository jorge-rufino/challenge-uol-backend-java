package com.rufino.uolhost.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rufino.uolhost.dto.PlayerDto;
import com.rufino.uolhost.model.Player;
import com.rufino.uolhost.service.PlayerService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/players")
public class PlayerController {
	
	@Autowired
	private PlayerService playerService;
	
	@PostMapping
	public ResponseEntity<Player> createPlayer(@RequestBody @Valid PlayerDto playerDto){
		
		Player newPlayer =  playerService.createPlayer(playerDto);
		
		return new ResponseEntity<>(newPlayer,HttpStatus.CREATED);
	}

	@GetMapping
	public ResponseEntity<List<Player>> findAll(){
		return new ResponseEntity<>(playerService.findAll(), HttpStatus.OK);
	}
}
