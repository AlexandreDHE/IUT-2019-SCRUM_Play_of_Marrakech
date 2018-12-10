package model.parameter;

public enum DiceParameter
{
  CLASSICDICE(0),
  NODICE(1);

  private int parameter;
  private static final int size = DiceParameter.values().length;

  DiceParameter(int parameter)
  {
    this.parameter = parameter;
  }

  public int getParameter()
  {
    return this.parameter;
  }

   public int getLength()
  {
    return this.size;
  }

  public String toString()
  {
    return this.parameter + "";
  }
}