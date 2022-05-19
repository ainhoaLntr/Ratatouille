package com.example.ratatouille;

import java.util.ArrayList;

public class Modele {
    public static ArrayList<Commande> lesCommandes = new ArrayList<Commande>();

    public int newCommande() {
        Commande uneCommande = new Commande();
        lesCommandes.add(uneCommande);
        return lesCommandes.indexOf(uneCommande);
    }

    public ArrayList<Commande> getLesCommandes() {
        return lesCommandes;
    }

    public static ArrayList<String> lesPlats = new ArrayList<String>();

    public static void initPlats() {
        lesPlats.add("Aucun");
        lesPlats.add("Magret de canard");
        lesPlats.add("Burger du chef");
        lesPlats.add("Lasagnes");
        lesPlats.add("Pavé de merlu");
    }

    public static ArrayList<String> lesEntrees = new ArrayList<String>();

    public static void initEntrees() {
        lesEntrees.add("Aucun");
        lesEntrees.add("Foie gras fait maison");
        lesEntrees.add("Saumon fumé");
        lesEntrees.add("Salade verte");
        lesEntrees.add("Gambas poelées");
    }

    public static ArrayList<String> lesDesserts = new ArrayList<String>();

    public static void initDesserts() {
        lesDesserts.add("Aucun");
        lesDesserts.add("Tiramisu");
        lesDesserts.add("Crème brûlée");
        lesDesserts.add("Tarte tatin");
        lesDesserts.add("Fondant au chocolat");
    }
}
