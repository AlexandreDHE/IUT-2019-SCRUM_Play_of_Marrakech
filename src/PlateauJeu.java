

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

    public void payerDime(Assam ass, Joueur j){

        /* position assam */

        Tapis tapi = cases[][].recupererTapis();
        int cjoueur = j.couleur;
        int cadversaire = tapi.getCouleur();


        if (cjoueur == cadversaire) {
            return null;
        }

        int due = compter(cadversaire, new Coord(), 1);

    }

    private int compter(int cadversaire,Coord coord, int i){

        int x = coord.getX();
        int y = coord.getY();

        if (cases[x+1][y].getCouleur() == cadversaire) {
            i++;
            i = compter(cadversaire, new Coord(x+1,y),i);
        }
        if (cases[x-1][y].getCouleur() == cadversaire) {
            i++;
            i = compter(cadversaire, new Coord(x-1,y),i);
        }
        if (cases[x][y+1].getCouleur() == cadversaire) {
            i++;
            i = compter(cadversaire, new Coord(x,y+1),i);
        }
        if (cases[x][y-1].getCouleur() == cadversaire) {
            i++;
            i = compter(cadversaire, new Coord(x,y-1),i);
        }

        return i;
    }

}
