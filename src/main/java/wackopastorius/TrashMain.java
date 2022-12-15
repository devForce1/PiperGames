package wackopastorius;

import java.util.List;
import java.util.Scanner;

public class TrashMain {

    public static void main(String[] args) {

        PlayerController playerController = new PlayerController();
        DbController dbController = new DbController();
        TeamController teamController = new TeamController();
        GameController gameController = new GameController();

        dbController.addATeam(teamController, gameController);

        //test delete methods




    }
}
