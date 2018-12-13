package model;
public class Case implements Cloneable{

    /* peut etre une pille */

    /**
     * le tapis sur la case
     */
    private Tapis tapi;

    /**
     * permet de construire la case
     */
    public Case(){
        tapi=null;
    }

    /**
     * permet de placer un tapis
     * @param t le tapis
     */
    public void placerTapis(Tapis t){
        tapi = t;
    }

    /**
     * permet de récupérer le tapis
     * @return un tapis
     */
    public Tapis recupererTapis(){
        return tapi;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Case c = (Case) super.clone();
        c.tapi = (Tapis)this.tapi.clone();
        return c;
    }

}
