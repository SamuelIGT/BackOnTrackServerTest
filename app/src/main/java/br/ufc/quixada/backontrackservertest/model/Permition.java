package br.ufc.quixada.backontrackservertest.model;

/**
 * Created by samue on 22/11/2017.
 */

public class Permition {
    private int id;
    private boolean isUnlocked;
    private Grasp grasp;
    private Patient patient;

    public Permition(){
        this.isUnlocked = false;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isUnlocked() {
        return isUnlocked;
    }

    public void setUnlocked(boolean unlocked) {
        isUnlocked = unlocked;
    }

    public Grasp getGrasp() {
        return grasp;
    }

    public void setGrasp(Grasp grasp) {
        this.grasp = grasp;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }
}
