package org.jo.training;

import org.jo.training.controllers.GameController;
import org.jo.training.utils.DeckFactory;
import org.jo.training.games.HighCardGameEvaluator;
import org.jo.training.models.DeckType;
import org.jo.training.view.GameSwingView;

/**
 * @author Joseph T
 */
public class SimpleCardGames {

  public static void main(String[] args) {
    GameSwingView gameSwingView = new GameSwingView();
    gameSwingView.createAndShowGUI();
    new GameController(DeckFactory.getDeck(DeckType.NORMAL), gameSwingView, new HighCardGameEvaluator()).run();
  }
}
