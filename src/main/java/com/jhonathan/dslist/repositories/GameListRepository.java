package com.jhonathan.dslist.repositories;

import com.jhonathan.dslist.entities.Game;
import com.jhonathan.dslist.entities.GameList;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameListRepository extends JpaRepository<GameList, Long> {

}
