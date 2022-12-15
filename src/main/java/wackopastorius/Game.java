package wackopastorius;

/*
* Author: Mikael Petersson
*
* */

import javax.persistence.*;

@Entity
@Table(name = "game")
public class Game {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "gameID")
    private int gameID;

    @Column(name = "gameName")
    private String name;

    @Column(name = "multiplayer")
    private boolean multiplayer;


    public Game(String name, boolean multiplayer) {
        this.name = name;
        this.multiplayer = multiplayer;
    }

    public Game() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



    public int getGameID() {
        return gameID;
    }

    public void setGameID(int gameID) {
        this.gameID = gameID;
    }

    public boolean isMultiplayer() {
        return multiplayer;
    }

    public void setMultiplayer(boolean multiplayer) {
        this.multiplayer = multiplayer;
    }

    @Override
    public String toString() {
        return "GameID " + gameID + " = " + name + "\n";
    }
}
