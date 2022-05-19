package com.example.ratatouille;

import java.util.HashMap;

public class Commande {
    private HashMap<String, Integer> lesPlats;
    private HashMap<String, Integer> lesEntrees;
    private HashMap<String, Integer> lesDesserts;
    private String remarques;

    public Commande() {
        lesPlats = new HashMap<String, Integer>();
        lesEntrees = new HashMap<String, Integer>();
        lesDesserts = new HashMap<String, Integer>();
        remarques="";
    }

    public HashMap<String, Integer> getLesPlats() {
        return lesPlats;
    }

    public HashMap<String, Integer> getLesEntrees() {
        return lesEntrees;
    }

    public HashMap<String, Integer> getLesDesserts() {
        return lesDesserts;
    }

    public String getRemarques() {
        return remarques;
    }

    public void setRemarques(String remarques) {
        this.remarques = remarques;
    }
}
