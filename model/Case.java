package model;
public class Case {

    /* peut etre une pille */

    private Tapis tapi;

    public Case(){
        tapi=null;
    }

    public void placerTapis(Tapis t){
        tapi = t;
    }

    public Tapis recupererTapis(){
        return tapi;
    }


}
