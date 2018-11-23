

public class Tapis {

    private Joueur joueur;
    private Coord coord1;
    private Coord coord2;


    public Tapis(Joueur j, Coord coord1, Coord coord2){
        joueur = j;
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


}
