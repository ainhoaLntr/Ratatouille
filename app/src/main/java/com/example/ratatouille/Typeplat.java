package com.example.ratatouille;

public class Typeplat {
    private long idTP;
    private String libelleTP;

    public Typeplat(long idTP, String libelleTP) {
        this.idTP = idTP;
        this.libelleTP = libelleTP;
    }

    public long getIdTP() {
        return idTP;
    }

    public String getLibelleTP() {
        return libelleTP;
    }

    public void setIdTP(long idTP) {
        this.idTP = idTP;
    }

    public void setLibelleTP(String libelleTP) {
        this.libelleTP = libelleTP;
    }

    @Override
    public String toString() {
        return "Typeplat{" +
                "idTP=" + idTP +
                ", libelleTP='" + libelleTP + '\'' +
                '}';
    }
}
