package model;

public class Tapis {

    private int couleur;
    private Coord coord1;
    private Coord coord2;


    public Tapis(int c, Coord coord1, Coord coord2){
        couleur = c;
        this.coord1 = coord1;
        this.coord2 = coord2;


    }

    public void nouvelPosition(Coord coord1, Coord coord2){
        this.coord1 = coord1;
        this.coord2 = coord2;
    }

    public Coord[] position(){
        return new Coord[]{coord1,coord2};
    }

    /**
     * @return the couleur
     */
    public int getCouleur() {
    	return couleur;
    }

}
