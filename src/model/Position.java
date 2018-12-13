package model;


public class Position implements Cloneable{

    private int x;
    private int y;

    public Position(int x, int y){

        this.x = x;
        this.y = y;

    }


    /**
     * @param y the y to set
     */
    public void setY(int y) {
    	this.y = y;
    }

    /**
     * @param x the x to set
     */
    public void setX(int x) {
    	this.x = x;
    }

    /**
     * @return the y
     */
    public int getY() {
    	return y;
    }

    /**
     * @return the x
     */
    public int getX() {
    	return x;
    }

    /**
     * redefinit la sortie
     */
    @Override
    public String toString() {
        return "x= " + x + " y= " + y;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

}
