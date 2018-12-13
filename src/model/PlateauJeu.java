package model;

import model.Assam;
import model.Position;

/**
 * class contenant le plateau du jeu
 */
public class PlateauJeu implements Cloneable{

    /* x,y */
    /**
     * contient toutes les cases du jeu
     */
    private Case[][] cases;

    /**
     * @return les cases
     */
    public Case[][] getCases() {
        return cases;
    }

    /**
     * @param cases les cases
     */
    public void setCases(Case[][] cases) {
        this.cases = cases;
    }

    /**
     * contient si la case a été comptée
     */
    private boolean[][] casecompter;

    /**
     * initialise le plateau du jeu
     */
    public PlateauJeu() {
        cases = new Case[7][7];
        casecompter = new boolean[7][7];
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 7; j++) {
                cases[i][j] = new Case();
            }
        }
    }

    public PlateauJeu(int lignes) {
        cases = new Case[lignes+2][lignes+2];
        casecompter = new boolean[lignes+2][lignes+2];
        for (int i = 0; i < lignes; i++) {
            for (int j = 0; j < lignes; j++) {
                cases[i][j] = new Case();
            }
        }
    }


    /**
     * permet de placer un tapis
     * 
     * @param tapi le tapis avec ses coordonnées
     */
    public void placerTapis(Tapis tapi) {

        Position[] pos = tapi.position();
        cases[pos[0].getX()][pos[0].getY()].placerTapis(tapi);
        cases[pos[1].getX()][pos[1].getY()].placerTapis(tapi);

    }

    /**
     * permet de savoir si on peut placer le tapis
     * 
     * @param tapi le tapis avec ses coordonnées
     * @return si c'est possible
     */
    public boolean peutPlacerTapis(Tapis tapi) {

        Position[] pos = tapi.position();
        Tapis tapi1, tapi2;
        tapi1 = cases[pos[0].getX()][pos[0].getY()].recupererTapis();
        tapi2 = cases[pos[1].getX()][pos[1].getY()].recupererTapis();
        if ((tapi1 == tapi2) && (tapi1 != null)) {
            return false;
        }
        return true;
    }

    /**
     * permet de payer les dimes au joueur correspondant
     * 
     * @param ass la position d'assam
     * @param j   le joueur qui est arrivé sur la case
     */
    public int payerDime(Assam ass, Joueur j) {

        Position coord = ass.getCoord();

        Tapis tapi = cases[coord.getX()][coord.getY()].recupererTapis();
        int cjoueur = j.getCouleur();
        int cadversaire = tapi.getCouleur();

        if (cjoueur == cadversaire) {
            return 0;
        }

        for (int i = 0; i < 7; i++) {
            for (int jc = 0; jc < 7; jc++) {
                casecompter[i][jc] = false;
            }
        }

        int du = compter(cadversaire, coord, 1);

        return du;

    }

    /**
     * fonction recursive qui permet de compter le total dû
     * 
     * @param cadversaire la couleur de l'adversaire
     * @param coord       les coordonnées de la case
     * @param i           le total dû
     * @return le total dû
     */
    private int compter(int cadversaire, Position coord, int i) {

        int x = coord.getX();
        int y = coord.getY();

        System.out.println(coord);

        System.out.println(i);

        casecompter[x][y] = true;

        if (x + 1 < 7) {
            if (cases[x + 1][y].recupererTapis() != null) {
                if ((cases[x + 1][y].recupererTapis().getCouleur() == cadversaire) && (casecompter[x + 1][y] != true)) {
                    i++;
                    i = compter(cadversaire, new Position(x + 1, y), i);
                }
            }
        }

        if (x - 1 < 0) {
            if (cases[x - 1][y].recupererTapis() != null) {
                if ((cases[x - 1][y].recupererTapis().getCouleur() == cadversaire) && (casecompter[x - 1][y] != true)) {
                    i++;
                    i = compter(cadversaire, new Position(x - 1, y), i);
                }
            }
        }

        if (y + 1 < 7) {
            if (cases[x][y + 1].recupererTapis() != null) {
                if ((cases[x][y + 1].recupererTapis().getCouleur() == cadversaire) && (casecompter[x - 1][y] != true)) {
                    i++;
                    i = compter(cadversaire, new Position(x, y + 1), i);
                }
            }
        }

        if (y - 1 < 0) {
            if (cases[x][y - 1].recupererTapis() != null) {
                if ((cases[x][y - 1].recupererTapis().getCouleur() == cadversaire) && (casecompter[x][y - 1] != true)) {
                    i++;
                    i = compter(cadversaire, new Position(x, y - 1), i);
                }
            }
        }

        return i;
    }
    
    public Case[][] getGameGrid()
    {
    	return this.cases;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        PlateauJeu p = (PlateauJeu)super.clone();
        for (int i = 0; i < p.cases.length; i++) {
            for (int j = 0; j < p.cases[0].length; j++) {
                p.cases[i][j] = this.cases[i][j];
            }
        }
        return p;
    }

}
