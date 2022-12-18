package wackopastorius;

/*
*
* Author so far: Robin Andersson
*
* */

public class SpMatch {

    private Player[] players;

    public SpMatch() {}

    public SpMatch(Player[] players) {
        this.players = players;}

    public Player[] getPlayers() {return players;}

    public void setPlayers(Player[] players) {this.players = players;}

    //Methods

    public void choosePlayer1(Player player1) {
        player1.getNickname();
    }

    public void choosePlayer2(Player player2) {
        player2.getNickname();
    }
}
