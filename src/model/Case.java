package model;
public class Case implements Cloneable{

    /* peut etre une pille */

    /**
     * le tapis sur la case
     */
    private Carpet tapi;

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
    public void placerTapis(Carpet t){
        tapi = t;
    }

    public void removeCarpet()
    {
        this.tapi = null;
    }

    /**
     * permet de récupérer le tapis
     * @return un tapis
     */
    public Carpet recupererTapis(){
        return tapi;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Case c = (Case) super.clone();
        c.tapi = (Carpet)this.tapi.clone();
        return c;
    }

}
