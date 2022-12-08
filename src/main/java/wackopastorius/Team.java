package wackopastorius;

import javax.persistence.*;

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

    //constructors
    public Team() {
    }

    public Team(int teamID, String teamName) {
        this.teamID = teamID;
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
