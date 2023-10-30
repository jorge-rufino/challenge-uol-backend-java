package com.rufino.uolhost.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rufino.uolhost.model.Player;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Long>{

}
