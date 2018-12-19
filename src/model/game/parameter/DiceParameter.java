package model.game.parameter;

/**
  * Classe enumeration representant les differents parametres du jeu concernant le de
*/
public enum DiceParameter
{
  /**
    * les joueurs utilisent un de classique
  */
  CLASSICDICE(0),
  /**
    * les joueurs utilisent une variante du de
  */
  VARDICE(1),
  /**
    * les joueurs n'utilisent pas de de
  */
  NODICE(2);

  /**
    * parametre du de
  */
  private int parameter;

  /**
    * le nombre de parametres
  */
  private static final int size = DiceParameter.values().length;

  /**
      * Constructeur prenant en argument le parametre voulu
      *
      * @param parameter
  */
  DiceParameter(int parameter)
  {
    this.parameter = parameter;
  }

  /**
      * Methode retournant un parametre du de
      *
      * @return parameter
  */
  public int getParameter()
  {
    return this.parameter;
  }

  /**
      * Methode retournant le nombre de parametres du de
      *
      * @return size
  */
  public int getLength()
  {
    return this.size;
  }

  /**
      * Methode retournant un parametre du de sous forme de String
      *
      * @return Une chaine de caracteres de parameter
  */
  public String toString()
  {
    return this.parameter + "";
  }
}