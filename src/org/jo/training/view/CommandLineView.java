package org.jo.training.view;

import java.util.Scanner;
import org.jo.training.controllers.GameController;

public class CommandLineView implements GameViewable {

  GameController gameController;
  Scanner keyboard = new Scanner(System.in);

  @Override
  public void setController(GameController gameController) {
    this.gameController = gameController;
  }

  @Override
  public void promptForPlayerName() {
    System.out.println("Please enter a player name:");
    String name = keyboard.nextLine();
    if (name.isEmpty()) {
      gameController.startGame();
    } else {
      gameController.addPlayer(name);
    }
  }

  @Override
  public void promptForFlip() {
    System.out.println("Please press Enter to reveal card:");
    keyboard.nextLine();
    gameController.flipCards();
  }

  @Override
  public void promptForNewGame() {

    System.out.println("Please press Enter to deal again or +q to exit:");
    gameController.nextAction(keyboard.nextLine());
  }

  @Override
  public void showWinner(String winnerName) {
    System.out.println("The winner is " + winnerName + " !");
  }

  @Override
  public void showPlayerName(int playerIndex, String name) {
    System.out.println("[" + playerIndex + "][" + name + "]");
  }

  @Override
  public void showFaceDownCardForPlayer(int playerIndex, String name) {
    System.out.println("[" + playerIndex + "][" + name + "][X][X]");
  }

  @Override
  public void showCardForPlayer(int playerIndex, String name, String rank, String suit) {
    System.out.println("[" + playerIndex + "][" + name + "][" + rank + "][" + suit + "]");
  }
}
