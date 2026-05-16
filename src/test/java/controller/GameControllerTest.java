package controller;

import domain.model.GameState;
import domain.model.TurnState;
import org.easymock.EasyMock;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;

import static org.junit.jupiter.api.Assertions.*;

public class GameControllerTest {

	private GameController createControllerWithGameState(GameState gameState) throws Exception {
		IGameDisplay mockDisplay = EasyMock.createMock(IGameDisplay.class);
		IPlayerInput mockInput = EasyMock.createMock(IPlayerInput.class);
		GameController controller = new GameController(mockDisplay, mockInput);
		Field field = GameController.class.getDeclaredField("gameState");
		field.setAccessible(true);
		field.set(controller, gameState);
		return controller;
	}

	private GameState mockGameStateReturning(TurnState turnState) {
		GameState mockGameState = EasyMock.createMock(GameState.class);
		EasyMock.expect(mockGameState.turnState()).andReturn(turnState).anyTimes();
		return mockGameState;
	}

	@Test
	void hasToPlayATurn_isAttackingIsTrue_ReturnsFalse() throws Exception {
		TurnState mockTurnState = EasyMock.createMock(TurnState.class);
		EasyMock.expect(mockTurnState.isAttacking()).andReturn(true);

		GameState mockGameState = mockGameStateReturning(mockTurnState);
		EasyMock.replay(mockGameState, mockTurnState);

		GameController controller = createControllerWithGameState(mockGameState);
		assertFalse(controller.hasToPlayATurn());

		EasyMock.verify(mockGameState, mockTurnState);
	}

	@Test
	void hasToPlayATurn_isAttackingIsFalse_turnsRemainingIsZero_ReturnsFalse() throws Exception {
		TurnState mockTurnState = EasyMock.createMock(TurnState.class);
		EasyMock.expect(mockTurnState.isAttacking()).andReturn(false);
		EasyMock.expect(mockTurnState.turnsRemaining()).andReturn(0);

		GameState mockGameState = mockGameStateReturning(mockTurnState);
		EasyMock.replay(mockGameState, mockTurnState);

		GameController controller = createControllerWithGameState(mockGameState);
		assertFalse(controller.hasToPlayATurn());

		EasyMock.verify(mockGameState, mockTurnState);
	}

	@Test
	void hasToPlayATurn_isAttackingIsFalse_turnsRemainingIsOne_ReturnsTrue() throws Exception {
		TurnState mockTurnState = EasyMock.createMock(TurnState.class);
		EasyMock.expect(mockTurnState.isAttacking()).andReturn(false);
		EasyMock.expect(mockTurnState.turnsRemaining()).andReturn(1);

		GameState mockGameState = mockGameStateReturning(mockTurnState);
		EasyMock.replay(mockGameState, mockTurnState);

		GameController controller = createControllerWithGameState(mockGameState);
		assertTrue(controller.hasToPlayATurn());

		EasyMock.verify(mockGameState, mockTurnState);
	}

	@Test
	void hasToPlayATurn_isAttackingIsFalse_turnsRemainingIsGreaterThanOne_ReturnsTrue() throws Exception {
		TurnState mockTurnState = EasyMock.createMock(TurnState.class);
		EasyMock.expect(mockTurnState.isAttacking()).andReturn(false);
		EasyMock.expect(mockTurnState.turnsRemaining()).andReturn(2);

		GameState mockGameState = mockGameStateReturning(mockTurnState);
		EasyMock.replay(mockGameState, mockTurnState);

		GameController controller = createControllerWithGameState(mockGameState);
		assertTrue(controller.hasToPlayATurn());

		EasyMock.verify(mockGameState, mockTurnState);
	}

	@Test
	void hasToPlayATurn_isAttackingIsFalse_turnsRemainingIsIntMax_ReturnsTrue() throws Exception {
		TurnState mockTurnState = EasyMock.createMock(TurnState.class);
		EasyMock.expect(mockTurnState.isAttacking()).andReturn(false);
		EasyMock.expect(mockTurnState.turnsRemaining()).andReturn(Integer.MAX_VALUE);

		GameState mockGameState = mockGameStateReturning(mockTurnState);
		EasyMock.replay(mockGameState, mockTurnState);

		GameController controller = createControllerWithGameState(mockGameState);
		assertTrue(controller.hasToPlayATurn());

		EasyMock.verify(mockGameState, mockTurnState);
	}
}