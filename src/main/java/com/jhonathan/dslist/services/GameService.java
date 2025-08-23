package com.jhonathan.dslist.services;

import com.jhonathan.dslist.dto.GameDto;
import com.jhonathan.dslist.dto.GameMinDto;
import com.jhonathan.dslist.entities.Game;
import com.jhonathan.dslist.projections.GameMinProjection;
import com.jhonathan.dslist.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GameService {
    @Autowired
    private GameRepository gameRepository;
    @Transactional(readOnly = true)
    public GameDto findById(Long id){
        Game result = gameRepository.findById(id).get();
        return new GameDto(result);
    }
    @Transactional(readOnly = true)
    public List<GameMinDto> findAll(){
        List<Game> result = gameRepository.findAll();
        List<GameMinDto> dto = result.stream().map(x -> new GameMinDto(x)).toList();
        return dto;
    }

    @Transactional(readOnly = true)
    public List<GameMinDto> findByList(Long lisdtId){
        List<GameMinProjection> result = gameRepository.searchByList(lisdtId);
        List<GameMinDto> dto = result.stream().map(x -> new GameMinDto(x)).toList();
        return dto;
    }
}
