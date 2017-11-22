package br.ufc.quixada.backontrackservertest.model;

/**
 * Created by samue on 22/11/2017.
 */

import java.util.Date;
import java.util.List;


public class Grasp {
    private int id;
    private Exercise exercise;
    private Level level;
    private Recommendation recommendation;
    private Date date;
    private String tip;
    private Date update;
    private int sequence;

    public Grasp() {

    }

    public Grasp(Exercise exercise, Level level, Date date, String tip, int sequence){
        this.exercise = exercise;
        this.level = level;
        this.date = date;
        this.tip = tip;
        this.sequence = sequence;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Exercise getExercise() {
        return exercise;
    }

    public void setExercise(Exercise exercise) {
        this.exercise = exercise;
    }

    public Level getLevel() {
        return level;
    }

    public void setLevel(Level level) {
        this.level = level;
    }

    public Recommendation getRecommendation() {
        return recommendation;
    }

    public void setRecommendation(Recommendation recommendation) {
        this.recommendation = recommendation;
    }

    public Date getDate() { return date; }

    public void setDate(Date date) { this.date = date; }

    public String getTip() {
        return tip;
    }

    public void setTip(String tip) {
        this.tip = tip;
    }

    public Date getUpdate() {
        return update;
    }

    public void setUpdate(Date update) {
        this.update = update;
    }

    public int getSequence() { return sequence; }

    public void setSequence(int sequence) { this.sequence = sequence; }

}