package com.example.ratatouille;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class BdSQLiteOpenHelper extends SQLiteOpenHelper {
    private String table_typeplat = "create table typeplat("
            + "idTP INTEGER PRIMARY KEY,"
            + "libelleTP TEXT NOT NULL);";

    private String table_plat = "create table plat("
            + "idP INTEGER PRIMARY KEY,"
            + "libelleP TEXT NOT NULL,"
            + "idTP INTEGER,"
            + "foreign key (idTP) references typeplat(idTP));";

    public BdSQLiteOpenHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(table_plat);
        db.execSQL(table_typeplat);

        db.execSQL("insert into typeplat (idTP, libelleTP) values(1, 'entrée')");
        db.execSQL("insert into typeplat (idTP, libelleTP) values(2, 'plat')");
        db.execSQL("insert into typeplat (idTP, libelleTP) values(3, 'dessert')");

        db.execSQL("insert into plat (idP, libelleP, idTP) values(1, 'Aucun', 1)");
        db.execSQL("insert into plat (idP, libelleP, idTP) values(2, 'Foie gras fait maison', 1)");
        db.execSQL("insert into plat (idP, libelleP, idTP) values(3, 'Saumon fumé', 1)");
        db.execSQL("insert into plat (idP, libelleP, idTP) values(4, 'Salade verte', 1)");
        db.execSQL("insert into plat (idP, libelleP, idTP) values(5, 'Gambas poelées', 1)");

        db.execSQL("insert into plat (idP, libelleP, idTP) values(6, 'Aucun', 2)");
        db.execSQL("insert into plat (idP, libelleP, idTP) values(7, 'Magret de canard', 2)");
        db.execSQL("insert into plat (idP, libelleP, idTP) values(8, 'Burger du chef', 2)");
        db.execSQL("insert into plat (idP, libelleP, idTP) values(9, 'Lasagnes', 2)");
        db.execSQL("insert into plat (idP, libelleP, idTP) values(10, 'Pavé de merlu', 2)");

        db.execSQL("insert into plat (idP, libelleP, idTP) values(11, 'Aucun', 3)");
        db.execSQL("insert into plat (idP, libelleP, idTP) values(12, 'Tiramisu', 3)");
        db.execSQL("insert into plat (idP, libelleP, idTP) values(13, 'Crème brûlée', 3)");
        db.execSQL("insert into plat (idP, libelleP, idTP) values(14, 'Tarte tatin', 3)");
        db.execSQL("insert into plat (idP, libelleP, idTP) values(15, 'Fondant au chocolat', 3)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
