package com.example.ratatouille;

import android.content.Context;
import android.database.Cursor;

import java.util.ArrayList;

public class PlatDAO {
    private static String base = "BDRatatouille";
    private static int version = 1;
    private BdSQLiteOpenHelper accesBD;

    public PlatDAO(Context ct) { accesBD = new BdSQLiteOpenHelper(ct, base, null, version);}

    public Plat getPlat(long idP) {
        Plat lePlat = null;
        Cursor curseur;
        curseur = accesBD.getReadableDatabase().rawQuery(
                "select * from plat where idP=" + idP + ";",
                null);
        if (curseur.getCount() > 0) {
            curseur.moveToFirst();
            lePlat = new Plat(idP, curseur.getString(1), curseur.getLong(2));
        }
        return lePlat;
    }

    public ArrayList<Plat> getPlats() {
        Cursor curseur;
        String req = "select * from plat;";
        curseur = accesBD.getReadableDatabase().rawQuery(req, null);
        return cursorToPlatArrayList(curseur);
    }

    private ArrayList<Plat> cursorToPlatArrayList(Cursor curseur) {
        ArrayList<Plat> listePlats = new ArrayList<Plat>();
        long idP;
        String libelleP;
        long idTP;

        curseur.moveToFirst();
        while (!curseur.isAfterLast()) {
            idP = curseur.getLong(0);
            libelleP = curseur.getString(1);
            idTP = curseur.getLong(2);
            listePlats.add(new Plat(idP, libelleP, idTP));
            curseur.moveToNext();
        }
        return listePlats;
    }
}
