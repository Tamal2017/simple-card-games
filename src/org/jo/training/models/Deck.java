package org.jo.training.models;

import java.util.Collections;
import java.util.List;

/**
 * @author Joseph T
 */
public abstract class Deck {

  protected List<PlayingCard> cards;


  public void shuffle() {
    Collections.shuffle(cards);
  }

  public PlayingCard removeTopCard() {
    shuffle();
    return cards.remove(0);
  }

  public void returnCardToDeck(PlayingCard card) {
    cards.add(card);
  }

  public List<PlayingCard> getCards() {
    return cards;
  }
}
