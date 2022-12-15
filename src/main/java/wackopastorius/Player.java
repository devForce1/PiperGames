package wackopastorius;

/*
*
* Author: Lada Egolaeva
*
* */

import javax.persistence.*;

@Entity
@Table(name = "player")
public class Player {
    //properties
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "playerID")
    private int playerID;

    @Column(name = "firstName")
    private String firstName;

    @Column(name = "lastName")
    private String lastName;

    @Column(name = "nickname")
    private String nickname;

    @Column(name = "address")
    private String address;

    @Column(name = "country")
    private String country;

    @Column(name = "email")
    private String email;

    @Column(name = "teamID")
    private int teamID;

    //constructors
    public Player() {
    }

    public Player(String firstName, String lastName, String nickname, String address, String country, String email, int teamID) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.nickname = nickname;
        this.address = address;
        this.country = country;
        this.email = email;
        this.teamID = teamID;
    }

    //getters & setters
    public int getPlayerID() {
        return playerID;
    }
    public void setPlayerID(int playerID) {
        this.playerID = playerID;
    }

    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getNickname() {
        return nickname;
    }
    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }

    public String getCountry() {
        return country;
    }
    public void setCountry(String country) {
        this.country = country;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public int getTeamID() {
        return teamID;
    }
    public void setTeamID(int teamID) {
        this.teamID = teamID;
    }

    //toString
    @Override
    public String toString() {
        return "Player{" +
                "playerID=" + playerID +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", nickname='" + nickname + '\'' +
                ", address='" + address + '\'' +
                ", country='" + country + '\'' +
                ", email='" + email + '\'' +
                ", teamID=" + teamID +
                '}';
    }
}
