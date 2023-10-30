package com.rufino.uolhost.infra;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.rufino.uolhost.model.GroupType;
import com.rufino.uolhost.service.CodinameService;

@Component
public class CodinameHandler {

	@Autowired
	private CodinameService codinameService;
	
	public String findCodiname(GroupType groupType) {
		if (groupType.equals(GroupType.VINGADORES)) {
			String firstCodiname = codinameService.getVingadoresCodinamesList().stream()
					.findFirst()
					.orElseThrow();
			
			codinameService.getVingadoresCodinamesList().remove(firstCodiname);
			
			return firstCodiname;
			
		}
		
		String firstCodiname = codinameService.getLigaDaJusticaCodinamesList().stream()
				.findFirst()
				.orElseThrow();
		
		codinameService.getLigaDaJusticaCodinamesList().remove(firstCodiname);
		
		return firstCodiname;
	}
	
}
