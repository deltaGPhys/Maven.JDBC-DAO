package models;

import java.time.Year;

public class BoardGame extends Game {

    private Integer id;
    private String name;
    private String mfr;
    private Integer year;
    private Integer numPlayers;

    public BoardGame() {
    }

    public BoardGame(Integer id, String name, String mfr, Integer year, Integer numPlayers) {
        this.id = id;
        this.name = name;
        this.mfr = mfr;
        this.year = year;
        this.numPlayers = numPlayers;
    }

    public BoardGame(String name, String mfr, Integer year, Integer numPlayers) {
        this.name = name;
        this.mfr = mfr;
        this.year = year;
        this.numPlayers = numPlayers;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMfr() {
        return mfr;
    }

    public void setMfr(String mfr) {
        this.mfr = mfr;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Integer getNumPlayers() {
        return numPlayers;
    }

    public void setNumPlayers(Integer numPlayers) {
        this.numPlayers = numPlayers;
    }

    @Override
    public String toString() {
        return "BoardGame{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", mfr='" + mfr + '\'' +
                ", year=" + year +
                ", numPlayers=" + numPlayers +
                '}';
    }
}
