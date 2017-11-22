package br.ufc.quixada.backontrackservertest.model;

/**
 * Created by samue on 22/11/2017.
 */

import java.util.List;


public class Recommendation {
    private int id;
    private List<Serie> serie;

    public Recommendation(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Serie> getSerie() {
        return serie;
    }

    public void setSerie(List<Serie> serie) {
        this.serie = serie;
    }

}