package model;
public class Case {

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


}
