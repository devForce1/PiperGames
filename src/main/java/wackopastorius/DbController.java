package wackopastorius;

/*
*
* Author: Mikael Petersson
*
*/


import java.util.List;
import java.util.Scanner;

public class DbController {
    public DbController() {
    }

    //Make methods to add all types of data to a database

    //Method to add a player to db
    public void addAPlayer(PlayerController playerController){
        Scanner scan = new Scanner(System.in);

        System.out.println("First name: ");
        String firstName = scan.nextLine();
        System.out.println("Last name: ");
        String lastName = scan.nextLine();
        System.out.println("Nickname: ");
        String nickname = scan.nextLine();
        System.out.println("Address: ");
        String address = scan.nextLine();
        System.out.println("Country: ");
        String country = scan.nextLine();
        System.out.println("Email: ");
        String email = scan.nextLine();
        System.out.println("TeamID: ");
        int teamID = scan.nextInt();

        boolean isRetired = false;
        Player thePlayerToAdd = new Player(firstName, lastName, nickname, address, country, email, teamID);
        if (playerController.addPlayer(thePlayerToAdd)) {
            System.out.println("Player added to database: " + thePlayerToAdd.getNickname());
        } else {
            System.out.println("Couldn't add player");
        }
    }

    //method to add a game to a db

    public void addAGame(GameController gameController){
        Scanner scan = new Scanner(System.in);

        System.out.println("Game name: ");
        String gameName = scan.nextLine();
        boolean isMultiplayer;
        while(true) {
            System.out.println("Type 1 for Single Player, 2 for Multiplayer: ");
            int multiCheck = scan.nextInt();
            if (multiCheck < 1 || multiCheck > 2) {
                System.out.println("Invalid entry, try again!");
            } else if (multiCheck == 1){
                isMultiplayer = false;
                break;
            } else if (multiCheck == 2) {
                isMultiplayer = true;
                break;
            }
        }
        boolean isRetired = false;
        Game theGameToAdd = new Game(gameName, isMultiplayer);
        if (gameController.addGame(theGameToAdd)) {
            System.out.println("Added game: " + gameName);
        } else {
            System.out.println("Something went wrong, couldnt add game: " + gameName);
        }
    }


    //Method to add a Team to db
    public void addATeam(TeamController teamController, GameController gameController){
        Scanner scan = new Scanner(System.in);
        boolean isMultiplayer;

        System.out.println("Team name: ");
        String teamName = scan.nextLine();

        boolean isRetired = false;
        Team theTeamToAdd = new Team(teamName, gameController);
        if (teamController.addTeam(theTeamToAdd)) {
            System.out.println("Added Team: " + teamName);
        } else {
            System.out.println("Something went wrong, couldn't add Team: " + teamName);
        }
    }

    //Methods to delete Players, games and teams


    //Delete a player
    public void deleteAPlayer(PlayerController playerController) {

        List<Player> players = playerController.getAllPlayers();
        System.out.println("------ Registered Players -------");
        for(Player player : players) {
            System.out.println("Enter Player ID: " + player.getPlayerID() + " to delete " + player.getNickname());
        }
        Scanner scan = new Scanner(System.in);
        int playerIdToDelete = scan.nextInt();
        // On the line below we can also use otherDeleteCar method if we want to use SQL-query to perform the delete.
        if(playerController.deletePlayer(playerIdToDelete)) {
            System.out.println("Deleted Player with Id :" + playerIdToDelete);
        } else {
            System.out.println("Could not delete player");
        }
    }

    //delete a game

    public void deleteAGame(GameController gameController) {

        List<Game> games = gameController.getAllGames();
        System.out.println("------ Registered Games -------");
        for(Game game : games) {
            System.out.println("Enter Game ID: " + game.getGameID() + " to delete " + game.getGameID());
        }
        Scanner scan = new Scanner(System.in);
        int gameIdToDelete = scan.nextInt();
        // On the line below we can also use otherDeleteCar method if we want to use SQL-query to perform the delete.

        //add to
        if(gameController.deleteGame(gameIdToDelete)) {
            System.out.println("Deleted Game with Id :" + gameIdToDelete);
        } else {
            System.out.println("Could not delete game");
        }
    }


}
