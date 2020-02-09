package com.game.dashboard.repository;

import com.game.dashboard.dao.GameData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameRepository extends JpaRepository<GameData, Integer> {
}
