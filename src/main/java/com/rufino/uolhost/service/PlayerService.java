package com.rufino.uolhost.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rufino.uolhost.dto.PlayerDto;
import com.rufino.uolhost.infra.CodinameHandler;
import com.rufino.uolhost.model.GroupType;
import com.rufino.uolhost.model.Player;
import com.rufino.uolhost.repository.PlayerRepository;

@Service
public class PlayerService {

	@Autowired
	private PlayerRepository playerRepository;

	@Autowired
	private CodinameHandler codinameHandler;
	
	public Player createPlayer(PlayerDto playerDto) {
		Player newPlayer = new Player(playerDto);
		
		String codiname = getCodiname(playerDto.groupType());
		newPlayer.setCodiname(codiname);
		
		return playerRepository.save(newPlayer);
	}

	public String getCodiname(GroupType groupType) {
		return codinameHandler.findCodiname(groupType);
	}
	
	public List<Player> findAll(){
		return playerRepository.findAll();
	}
	
}
