package model;

public class Tapis implements Cloneable{

    /**
     * la couleur du tapis
     */
    private int couleur;

    /**
     * les coord 1
     */
    private Position coord1;

    /**
     * les coord 2
     */
    private Position coord2;

    /**
     * permet de créer un tapis aux coordonnées 1 et 2
     * 
     * @param c      la couleur du joueur
     * @param coord1 les coord 1
     * @param coord2 les coord 2
     */
    public Tapis(int c, Position coord1, Position coord2) {
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
        this.coord1 = new Position(-1, -1);
        this.coord2 = new Position(-1, -1);

    }

    /**
     * permet de redefinir la position du tapis
     * 
     * @param coord1 les coordonnées 1
     * @param coord2 les coordonnées 2
     */
    public void setPosition(Position coord1, Position coord2) {
        this.coord1 = coord1;
        this.coord2 = coord2;
    }

    /**
     * donne les coordonnées du tapis
     * 
     * @return deux coordonnées
     */
    public Position[] position() {
        return new Position[] { coord1, coord2 };
    }

    /**
     * @return la couleur
     */
    public int getCouleur() {
        return couleur;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Tapis t = (Tapis)super.clone();
        t.coord1 = (Position)this.coord1.clone();
        t.coord2 = (Position)this.coord2.clone();
        return t;
    }

}
