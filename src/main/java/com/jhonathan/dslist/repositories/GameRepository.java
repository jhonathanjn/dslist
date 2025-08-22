package com.jhonathan.dslist.repositories;

import com.jhonathan.dslist.entities.Game;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameRepository extends JpaRepository<Game, Long> {

}
