package fr.okiwi.mongolink;

public class Sujet {

    protected Sujet() {

    }

    public Sujet(final String nom) {
        this.nom = nom;
    }


    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        final Sujet sujet = (Sujet) o;

        if (!nom.equals(sujet.nom)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return nom.hashCode();
    }

    public String getNom() {
        return nom;
    }

    private String nom;
}
