

public class PlateauJeu {

    /* x,y */
    private Case[][] cases;

    public PlateauJeu(){
        cases = new Case[7][7];
        for (int i=0; i<7; i++) {
            for (int j=0; j<7; j++) {
                cases[i][j]= new Case();
            }
        }
    }


    public void placerTapis(Tapis tapi){

        Coord[] pos = tapi.position();
        cases[pos[0].getX()][pos[0].getY()].placerTapis(tapi);
        cases[pos[1].getX()][pos[1].getY()].placerTapis(tapi);

    }

    public boolean peutPlacerTapis(Tapis tapi){

        Coord[] pos = tapi.position();
        Tapis tapi1,tapi2;
        tapi1 = cases[pos[0].getX()][pos[0].getY()].recupererTapis();
        tapi2 = cases[pos[1].getX()][pos[1].getY()].recupererTapis();
        if (tapi1 == tapi2) {
            return false;
        }
        return true;

    }

    // public int compteDime(Coord coord){
    //
    //
    // }



}
