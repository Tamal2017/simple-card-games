package org.jo.training.models;

import java.text.MessageFormat;

/**
 * @author Joseph T
 * Implemeting Decoretor Design pattern
 */
public class WinningPlayer implements IPlayer {

  private IPlayer winner;

  public WinningPlayer(IPlayer player) {
    winner = player;
  }

  @Override
  public String getName() {
    return MessageFormat.format(" ====== {0} ====== ", winner.getName());
  }

  @Override
  public void addCardToHand(PlayingCard card) {
    winner.addCardToHand(card);
  }

  @Override
  public PlayingCard getCard(int index) {
    return winner.getCard(index);
  }

  @Override
  public PlayingCard removeCard() {
    return winner.removeCard();
  }
}
