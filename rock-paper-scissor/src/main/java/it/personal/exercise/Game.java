package it.personal.exercise;

import java.util.Scanner;

/**
 * 
 * @author nawazk
 * 
 */
public class Game {

	public static void main(String[] args) {

		GameModel model = new GameModel();
		Scanner scanner = new Scanner(System.in);

		// input loop, play games until the user quits
		while (true) {

			System.out.println("Rock, paper, scissors... shoot! (Type ROCK, PAPER, or SCISSORS)");
			String playerChoice = scanner.nextLine().toUpperCase();

			String computerChoice = model.getRandomChoice();

			System.out.println("You chose " + playerChoice + ".");
			System.out.println("The computer chose " + computerChoice + ".");

			GameModel.GameOutcome outcome = model.getGameOutcome(playerChoice, computerChoice);

			if (outcome == GameModel.GameOutcome.WIN) {
				System.out.println("You won the game!");
			} else if (outcome == GameModel.GameOutcome.LOSE) {
				System.out.println("The computer won the game!");
			} else {
				System.out.println("The game was a tie!");
			}

			System.out.println("Wins: " + model.getWins());
			System.out.println("Losses: " + model.getLosses());
			System.out.println("Ties: " + model.getTies());

			System.out.println("Do you want to play again? (yes/no)");

			String answer = scanner.nextLine();
			if (answer.equalsIgnoreCase("no")) {
				// user wants to quit, end the input loop
				break;
			}

		}

		scanner.close();
	}

}

/**
 * SubClass (Game Model.)
 * @author nawazk
 *
 */
class GameModel {

	private int wins = 0;
	private int losses = 0;
	private int ties = 0;

	public static enum GameOutcome {
		WIN, LOSE, TIE;
	}

	public GameOutcome getGameOutcome(String userChoice, String computerChoice) {

		if (userChoice.equalsIgnoreCase("ROCK")) {

			if (computerChoice.equalsIgnoreCase("PAPER")) {
				// rock is covered by paper
				losses++;
				return GameOutcome.LOSE;
			} else if (computerChoice.equalsIgnoreCase("SCISSORS")) {
				// rock smashes scissors
				wins++;
				return GameOutcome.WIN;
			}
		} else if (userChoice.equalsIgnoreCase("PAPER")) {

			if (computerChoice.equalsIgnoreCase("SCISSORS")) {
				// paper is cut by scissors
				losses++;
				return GameOutcome.LOSE;
			} else if (computerChoice.equalsIgnoreCase("ROCK")) {
				// paper covers rock
				wins++;
				return GameOutcome.WIN;
			}
		} else if (userChoice.equalsIgnoreCase("SCISSORS")) {

			if (computerChoice.equalsIgnoreCase("ROCK")) {
				// scissors are smashed by rock
				losses++;
				return GameOutcome.LOSE;
			} else if (computerChoice.equalsIgnoreCase("PAPER")) {
				// scissors cut paper
				wins++;
				return GameOutcome.WIN;
			}
		}

		// if none of the above if statements is the case, then the choices must
		// be the same
		ties++;
		return GameOutcome.TIE;
	}

	/**
	 * Random Choices.
	 * 
	 * @return
	 */
	public String getRandomChoice() {
		double d = Math.random();

		if (d < .33) {
			return "ROCK";
		} else if (d < .66) {
			return "PAPER";
		} else {
			return "SCISSORS";
		}
	}

	public int getWins() {
		return wins;
	}

	public int getLosses() {
		return losses;
	}

	public int getTies() {
		return ties;
	}
}
