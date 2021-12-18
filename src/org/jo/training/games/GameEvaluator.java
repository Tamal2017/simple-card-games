package org.jo.training.games;

import java.util.List;
import org.jo.training.models.IPlayer;

/**
 * @author Joseph T
 */
public interface GameEvaluator {

  IPlayer evaluateWinner(List<IPlayer> players);
}
