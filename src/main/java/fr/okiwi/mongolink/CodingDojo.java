package fr.okiwi.mongolink;

import java.util.ArrayList;
import java.util.List;

public class CodingDojo {

    protected CodingDojo() {
        // pour mongolink
    }

    public CodingDojo(final String nom) {
        this.nom = nom;
    }

    public String getIdentifiant() {
        return identifiant;
    }

    public String getNom() {
        return nom;
    }

    public void ajouterUnParticipant(final String nom) {
        participants.add(nom);
    }

    public List<String> getParticipants() {
        return participants;
    }

    public void ajouteSujet(String nom) {
        sujets.add(new Sujet(nom));
    }

    public List<Sujet> getSujets() {
        return sujets;
    }



    private String identifiant;
    private String nom;
    private List<String> participants = new ArrayList<String>();
    private final ArrayList<Sujet> sujets = new ArrayList<Sujet>();
}
