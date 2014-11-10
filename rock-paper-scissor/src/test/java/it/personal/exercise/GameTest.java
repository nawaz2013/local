package it.personal.exercise;

import junit.framework.TestCase;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class GameTest extends TestCase {
	GameModel gModel = null;

	@Before
	@BeforeClass
	public void setUp() throws Exception {
		gModel = new GameModel();
	}

	@Test
	public void testGameMode() {

		assertNotNull(GameModel.GameOutcome.valueOf(gModel.getGameOutcome(gModel.getRandomChoice(),
				gModel.getRandomChoice()).name()));

	}

}
