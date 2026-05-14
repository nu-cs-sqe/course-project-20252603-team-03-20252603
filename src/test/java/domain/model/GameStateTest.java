package domain.model;

import domain.enums.GameStatus;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;

public class GameStateTest {

	@Test
	public void isActive_StatusEnded_ReturnsFalse() {
		GameState gameState = new GameState(GameStatus.ENDED);
		assertFalse(gameState.isActive());
	}
}
