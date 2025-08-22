package com.jhonathan.dslist.services;

import com.jhonathan.dslist.dto.GameDto;
import com.jhonathan.dslist.dto.GameListDto;
import com.jhonathan.dslist.dto.GameMinDto;
import com.jhonathan.dslist.entities.Game;
import com.jhonathan.dslist.entities.GameList;
import com.jhonathan.dslist.repositories.GameListRepository;
import com.jhonathan.dslist.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GameListService {
    @Autowired
    private GameListRepository gameListRepository;

    @Transactional(readOnly = true)
    public List<GameListDto> findAll(){
        List<GameList> result = gameListRepository.findAll();
        return result.stream().map(x -> new GameListDto(x)).toList();

    }
}
