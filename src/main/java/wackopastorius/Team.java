package wackopastorius;

/*
*
* Author: Lada Egolaeva
*
*/

import javax.persistence.*;
import java.util.List;
import java.util.Scanner;

@Entity
@Table(name = "team")
public class Team {
    //properties
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "teamID")
    private int teamID;

    @Column(name = "teamName")
    private String teamName;

    @Column(name = "gameID")
    private int gameID;

    //constructors
    public Team() {
    }

    //Constructor for adding new teams in DbController
    public Team(String teamName, GameController gameController) {
        List<Game> gameList = gameController.getAllGames();
        System.out.println(gameList.toString());
        System.out.println("Please enter gameID to connect team to: ");
        Scanner scan = new Scanner(System.in);
        int gameID = scan.nextInt();
        scan.nextLine();
        this.gameID = gameID;
        this.teamName = teamName;

    }

    //getters & setters
    public int getTeamID() {
        return teamID;
    }
    public void setTeamID(int teamID) {
        this.teamID = teamID;
    }

    public String getTeamName() {
        return teamName;
    }
    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    //toString
    @Override
    public String toString() {
        return "Team{" +
                "teamID=" + teamID +
                ", teamName='" + teamName + '\'' +
                '}';
    }
}
