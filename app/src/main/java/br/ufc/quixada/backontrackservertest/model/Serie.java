package br.ufc.quixada.backontrackservertest.model;

/**
 * Created by samue on 22/11/2017.
 */

public class Serie {
    private int id;
    private int sets;
    private int repeats;

    public Serie(int sets, int repeats){
        this.sets = sets;
        this.repeats = repeats;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSets() {
        return sets;
    }

    public void setSets(int sets) {
        this.sets = sets;
    }

    public int getRepeats() {
        return repeats;
    }

    public void setRepeats(int repeats) {
        this.repeats = repeats;
    }
}
