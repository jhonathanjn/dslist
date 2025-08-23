package com.jhonathan.dslist.controllers;

import com.jhonathan.dslist.dto.GameDto;
import com.jhonathan.dslist.dto.GameListDto;
import com.jhonathan.dslist.dto.GameMinDto;
import com.jhonathan.dslist.services.GameListService;

import com.jhonathan.dslist.services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/lists")
public class GameListController {
    @Autowired
    private GameListService gameListService;
    @Autowired
    private GameService gameService;

    @GetMapping(value = "/{id}")
    public GameListDto findById(@PathVariable Long id){
        GameListDto result = gameListService.findById(id);
        return result;
    }
    @GetMapping
    public List<GameListDto> findAll(){
        List<GameListDto> result = gameListService.findAll();
        return result;
    }

    @GetMapping(value = "/{listId}/games")
    public List<GameMinDto> findByList(@PathVariable Long listId){
        List<GameMinDto> result = gameService.findByList(listId);
        return result;
    }
}
