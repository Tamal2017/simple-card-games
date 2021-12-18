package org.jo.training.games;

import java.util.List;
import org.jo.training.models.IPlayer;
import org.jo.training.models.PlayingCard;

public class LowCardGameEvaluator implements GameEvaluator {

  @Override
  public IPlayer evaluateWinner(List<IPlayer> players) {
    IPlayer bestPlayer = null;
    int bestRank = -1;
    int bestSuit = -1;
    for (IPlayer player : players) {
      boolean newBestPlayer = false;
      if (bestPlayer == null) {
        newBestPlayer = true;
      } else {
        PlayingCard card = player.getCard(0);
        int currentRank = card.getRank().value();
        if (currentRank <= bestRank) {
          if (currentRank < bestRank) {
            newBestPlayer = true;
          } else {
            if (card.getSuit().value() < bestSuit) {
              newBestPlayer = true;
            }
          }
        }
      }
      if (newBestPlayer) {
        bestPlayer = player;
        PlayingCard card = player.getCard(0);
        bestRank = card.getRank().value();
        bestSuit = card.getSuit().value();
      }
    }
    return bestPlayer;
  }
}
