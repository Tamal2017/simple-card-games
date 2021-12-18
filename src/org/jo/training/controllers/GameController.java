package org.jo.training.controllers;

import java.util.ArrayList;
import java.util.List;
import org.jo.training.games.GameEvaluator;
import org.jo.training.models.Deck;
import org.jo.training.models.IPlayer;
import org.jo.training.models.Player;
import org.jo.training.models.PlayingCard;
import org.jo.training.models.WinningPlayer;
import org.jo.training.view.GameViewable;

/**
 * @author Joseph T
 */
public class GameController {

  Deck deck;
  List<IPlayer> players;
  IPlayer winner;
  GameViewable view;
  GameEvaluator evaluator;
  GameState gameState;

  /**
   * @param deck
   * @param view
   * @param evaluator
   */
  public GameController(Deck deck, GameViewable view, GameEvaluator evaluator) {
    this.deck = deck;
    this.evaluator = evaluator;
    this.players = new ArrayList<>();
    this.gameState = GameState.ADDING_PLAYERS;
    this.view = view;
    this.view.setController(this);
  }

  public void run() {
    while (gameState == GameState.ADDING_PLAYERS) {
      view.promptForPlayerName();
    }
    switch (gameState) {
      case CARDS_DEALT:
        view.promptForFlip();
        break;
      case WINNER_REVEALED:
        view.promptForNewGame();
        break;
      default:
        System.out.println("Something goes wrong!");
        break;
    }
  }

  public void addPlayer(String playerName) {
    if (gameState == GameState.ADDING_PLAYERS) {
      players.add(new Player(playerName));
      view.showPlayerName(players.size(), playerName);
    }
  }

  public void startGame() {
    if (gameState != GameState.CARDS_DEALT) {
      deck.shuffle();
      int playerIndex = 1;
      for (IPlayer player : players) {
        player.addCardToHand(deck.removeTopCard());
        view.showFaceDownCardForPlayer(playerIndex++, player.getName());
      }
      gameState = GameState.CARDS_DEALT;
    }
    run();
  }

  public void flipCards() {
    int playerIndex = 1;
    for (IPlayer player : players) {
      PlayingCard pc = player.getCard(0);
      pc.flip();
      view.showCardForPlayer(playerIndex++, player.getName(), pc.getRank().toString(),
          pc.getSuit().toString());
    }
    evaluateWinner();
    displayWinner();
    rebuildDeck();
    gameState = GameState.WINNER_REVEALED;
    run();
  }

  void evaluateWinner() {
    winner = new WinningPlayer(evaluator.evaluateWinner(players));
  }

  void displayWinner() {
    view.showWinner(winner.getName());
  }

  void rebuildDeck() {
    for (IPlayer player : players) {
      deck.returnCardToDeck(player.removeCard());
    }
  }

  void exitGame() {
    System.exit(0);
  }

  public void nextAction(String code) {
    if ("+q".equals(code)) {
      exitGame();
    } else {
      startGame();
    }
  }

  enum GameState {
    ADDING_PLAYERS, CARDS_DEALT, WINNER_REVEALED
  }
}
