package br.ufc.quixada.backontrackservertest.model;

/**
 * Created by samue on 22/11/2017.
 */

public class Midia {

    private int id;
    private String pathVideo;
    private String pathAudio;

    public Midia(){}

    public Midia(String pathVideo, String pathAudio){
        this.pathVideo = pathVideo;
        this.pathAudio = pathAudio;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPathVideo() {
        return pathVideo;
    }

    public void setPathVideo(String pathVideo) {
        this.pathVideo = pathVideo;
    }

    public String getPathAudio() {
        return pathAudio;
    }

    public void setPathAudio(String pathAudio) {
        this.pathAudio = pathAudio;
    }
}
