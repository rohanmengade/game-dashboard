package com.game.dashboard.service;

import com.game.dashboard.dao.GameData;
import com.game.dashboard.repository.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameDashboardService {

    private GameRepository gameRepository;

    @Autowired
    public GameDashboardService(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    public void batchStore(List<GameData> gameData) {
        gameRepository.saveAll(gameData);
    }

    public void store(GameData gameData) {
        gameRepository.save(gameData);
    }
}
