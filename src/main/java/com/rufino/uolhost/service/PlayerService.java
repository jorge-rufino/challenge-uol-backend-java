package com.rufino.uolhost.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rufino.uolhost.dto.PlayerDto;
import com.rufino.uolhost.model.Player;
import com.rufino.uolhost.repository.PlayerRepository;

@Service
public class PlayerService {

	@Autowired
	private PlayerRepository playerRepository;
	
	public Player createPlayer(PlayerDto playerDto) {
		Player newPlayer = new Player(playerDto);
		
		return playerRepository.save(newPlayer);
	}

}
