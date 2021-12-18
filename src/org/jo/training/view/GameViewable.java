package org.jo.training.view;

import org.jo.training.controllers.GameController;

public interface GameViewable {

  void setController(GameController gameController);

  void promptForPlayerName();

  void promptForFlip();

  void promptForNewGame();

  void showWinner(String winnerName);

  void showPlayerName(int playerIndex, String name);

  void showFaceDownCardForPlayer(int playerIndex, String name);

  void showCardForPlayer(int playerIndex, String name, String rank, String suit);
}
