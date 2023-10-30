package com.rufino.uolhost.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "tb_players")
@Getter
@Setter
@EqualsAndHashCode(of = "id")
public class Player {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank
	private String name;
	
	@NotBlank
	@Email
	private String email;
	
	private String phone;
	private String codiname;
	private GroupType groupType;
}
