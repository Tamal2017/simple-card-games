package org.jo.training.utils;

import org.jo.training.models.Deck;
import org.jo.training.models.DeckType;
import org.jo.training.models.NormalDeck;
import org.jo.training.models.SmallDeck;
import org.jo.training.models.TestDeck;

/**
 * @author Joseph T
 * Implementing Factory design pattern
 */
public class DeckFactory {

  private DeckFactory() {}

  public static Deck getDeck(DeckType type) {

    switch (type) {
      case NORMAL:
        return new NormalDeck();
      case SMALL:
        return new SmallDeck();
      case TEST:
        return new TestDeck();
      default:
        throw new UnsupportedOperationException("");
    }
  }
}
