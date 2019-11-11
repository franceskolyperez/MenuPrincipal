package com.franceskoly.menuprincipal;

public class Postre {

    private String imagen;
    private String nomnbre_food;

    public Postre(String imagen, String nomnbre_food) {
        this.imagen = imagen;
        this.nomnbre_food = nomnbre_food;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getNomnbre_food() {
        return nomnbre_food;
    }

    public void setNomnbre_food(String nomnbre_food) {
        this.nomnbre_food = nomnbre_food;
    }
}
