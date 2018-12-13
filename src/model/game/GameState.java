package model.game;

public enum GameState 
{
  NOTSTARTED(0),
  STARTED(1),
  ASSAMORIENTED(2),
  DICETHROWN(3),
  ASSAMMOVED(4),
  DIHMPAID(5),
  CARPETPUT(6),
  CARPETORIENTED(7),
  CARPETVALIDATE(8),
  OVER(9);

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