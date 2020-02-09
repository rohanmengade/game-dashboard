package com.game.dashboard;

import com.game.dashboard.dao.GameData;
import com.game.dashboard.repository.GameRepository;
import com.game.dashboard.service.GameDashboardService;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;


@ExtendWith( SpringExtension.class )
public class GameDashboardServiceTest {

    GameRepository gameRepository;
    GameDashboardService gameDashboardService;

    @Before
    public void init() {
        gameRepository = Mockito.mock(GameRepository.class);
        gameDashboardService = Mockito.spy(new GameDashboardService(gameRepository));
    }

    @Test
    public void testBatchStore_ShouldAbleToStoreBatchRecord() {

        List<GameData> gameData = new ArrayList<>();
        GameData game1 = new GameData();
        game1.setId(1);
        game1.setGameName("PUBG");
        game1.setPlatform("OS");
        GameData game2 = new GameData();
        game2.setId(1);
        game2.setGameName("GOT");
        game2.setPlatform("OS");
        gameData.add(game1);
        gameData.add(game2);


        when(gameRepository.saveAll(gameData)).thenReturn(any());

        Assertions.assertDoesNotThrow(() -> {
            gameDashboardService.batchStore(gameData);
        });

    }

    @Test
    public void testBatchStore_ShouldThrowException() {

        List<GameData> gameData = new ArrayList<>();
        GameData game1 = new GameData();
        game1.setId(1);
        game1.setGameName("PUBG");
        game1.setPlatform("OS");
        GameData game2 = new GameData();
        game2.setId(1);
        game2.setGameName("GOT");
        game2.setPlatform("OS");
        gameData.add(game1);
        gameData.add(game2);

        when(gameRepository.saveAll(gameData)).thenThrow(RuntimeException.class);

        Assertions.assertThrows(RuntimeException.class, () -> {
            gameDashboardService.batchStore(gameData);
        });

    }

    @Test
    public void testStore_ShouldAbleToStoreRecord() {
        GameData game1 = new GameData();
        game1.setId(1);
        game1.setGameName("PUBG");
        game1.setPlatform("OS");
        when(gameRepository.save(game1)).thenReturn(any());

        Assertions.assertDoesNotThrow(() -> {
            gameDashboardService.store(game1);
        });
    }

    @Test
    public void testStore_ShouldAbleToThrowException() {
        GameData game1 = new GameData();
        game1.setId(1);
        game1.setGameName("PUBG");
        game1.setPlatform("OS");
        when(gameRepository.save(game1)).thenThrow(RuntimeException.class);

        Assertions.assertThrows(RuntimeException.class, () -> {
            gameDashboardService.store(game1);
        });
    }
}