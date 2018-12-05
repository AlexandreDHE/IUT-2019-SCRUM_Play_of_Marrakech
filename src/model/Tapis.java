package model;

public class Tapis {

    /**
     * la couleur du tapis
     */
    private int couleur;

    /**
     * les coord 1
     */
    private Coord coord1;

    /**
     * les coord 2
     */
    private Coord coord2;

    /**
     * permet de créer un tapis aux coordonnées 1 et 2
     * 
     * @param c      la couleur du joueur
     * @param coord1 les coord 1
     * @param coord2 les coord 2
     */
    public Tapis(int c, Coord coord1, Coord coord2) {
        couleur = c;
        this.coord1 = coord1;
        this.coord2 = coord2;

    }

    /**
     * permet de créer un tapis sans coordonnées
     * 
     * @param c la couleur du joueur
     */
    public Tapis(int c) {
        couleur = c;
        this.coord1 = new Coord(-1, -1);
        this.coord2 = new Coord(-1, -1);

    }

    /**
     * permet de redefinir la position du tapis
     * 
     * @param coord1 les coordonnées 1
     * @param coord2 les coordonnées 2
     */
    public void setPosition(Coord coord1, Coord coord2) {
        this.coord1 = coord1;
        this.coord2 = coord2;
    }

    /**
     * donne les coordonnées du tapis
     * 
     * @return deux coordonnées
     */
    public Coord[] position() {
        return new Coord[] { coord1, coord2 };
    }

    /**
     * @return la couleur
     */
    public int getCouleur() {
        return couleur;
    }

}
