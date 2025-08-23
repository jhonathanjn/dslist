package com.jhonathan.dslist.services;

import com.jhonathan.dslist.dto.GameDto;
import com.jhonathan.dslist.dto.GameListDto;
import com.jhonathan.dslist.entities.Game;
import com.jhonathan.dslist.entities.GameList;
import com.jhonathan.dslist.projections.GameMinProjection;
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

    @Autowired
    private GameRepository gameRepository;

    @Transactional(readOnly = true)
    public GameListDto findById(Long id){
        GameList result = gameListRepository.findById(id).get();
        return new GameListDto(result);
    }

    @Transactional(readOnly = true)
    public List<GameListDto> findAll(){
        List<GameList> result = gameListRepository.findAll();
        return result.stream().map(x -> new GameListDto(x)).toList();

    }
    @Transactional
    public void move(Long listId, int sourceIndex, int destinationIndex){
        List<GameMinProjection> list = gameRepository.searchByList(listId);
        GameMinProjection obj = list.remove(sourceIndex);
        list.add(destinationIndex, obj);

        int min = sourceIndex < destinationIndex ? sourceIndex : destinationIndex;
        int max = sourceIndex < destinationIndex ? destinationIndex : sourceIndex;

        for (int i = min; i < max; i++){
            gameListRepository.updateBelongingPosition(listId, list.get(i).getId(), i);
        }

    }
}
