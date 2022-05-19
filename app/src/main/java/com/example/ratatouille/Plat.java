package com.example.ratatouille;

public class Plat {
    private long idP;
    private String libelleP;
    private long idTP;

    public Plat(long idP, String libelleP, long idTP) {
        this.idP = idP;
        this.libelleP = libelleP;
        this.idTP = idTP;
    }

    public long getIdP() {
        return idP;
    }

    public void setIdP(long idP) {
        this.idP = idP;
    }

    public String getLibelleP() {
        return libelleP;
    }

    public void setLibelleP(String libelleP) {
        this.libelleP = libelleP;
    }

    public long getIdTP() {
        return idTP;
    }

    public void setIdTP(long idTP) {
        this.idTP = idTP;
    }

    @Override
    public String toString() {
        return "Plat{" +
                "idP=" + idP +
                ", libelleP='" + libelleP + '\'' +
                ", idTP=" + idTP +
                '}';
    }
}
