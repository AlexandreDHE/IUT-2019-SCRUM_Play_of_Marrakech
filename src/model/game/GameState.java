package model.game;

/**
 * Classe enumeration representant les differents etats du jeu
*/
public enum GameState 
{
  NOTSTARTED(0),
  STARTED(1),
  ASSAMORIENTED(2),
  DICETHROWN(3),
  ASSAMMOVED(4),
  DIHMPAID(5),
  CARPETPUT(6),
  CARPETPUTVALIDATE(7),
  CARPETORIENTED(8),
  CARPETORIENTEDVALIDATE(9),
  OVER(10);

  private int state;
  private static final int size = GameState.values().length;

  GameState (int state)
  {
    this.state = state;
  }

  public int getState()
  {
    return this.state;
  }

   public int getLength()
  {
    return this.size;
  }

  public String toString()
  {
    return this.state + "";
  }
}