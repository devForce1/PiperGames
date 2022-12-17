package wackopastorius;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class ControllerFx {

    public MenuItem menu;

    public void handlestaffMember () throws Exception {
        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("mainMenu.fxml"));
        Stage primarystage = new Stage();
        primarystage.initModality(Modality.APPLICATION_MODAL);
        primarystage.setTitle("Main Menu");
        primarystage.setScene(new Scene(root, 1200, 715));
        primarystage.show();
        primarystage.setResizable(false);

    }

    public void handleAddPlayerMenu () throws Exception {
        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("addPlayer.fxml"));
        Stage primarystage = new Stage();
        primarystage.initModality(Modality.APPLICATION_MODAL);
        primarystage.setTitle("Main Menu");
        primarystage.setScene(new Scene(root, 1200, 715));
        primarystage.show();
        primarystage.setResizable(false);

    }

    public void handleAddTeamMenu () throws Exception {
        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("addTeams.fxml"));
        Stage primarystage = new Stage();
        primarystage.initModality(Modality.APPLICATION_MODAL);
        primarystage.setTitle("Main Menu");
        primarystage.setScene(new Scene(root, 1200, 715));
        primarystage.show();
        primarystage.setResizable(false);

    }

    public void handleAddGamesMenu () throws Exception {
        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("addGames.fxml"));
        Stage primarystage = new Stage();
        primarystage.initModality(Modality.APPLICATION_MODAL);
        primarystage.setTitle("Main Menu");
        primarystage.setScene(new Scene(root, 1200, 715));
        primarystage.show();
        primarystage.setResizable(false);

    }

    public void handleAddFirstNameText() throws Exception {

    }

    public void handleAddLastNameText() throws Exception {

    }

    public void handleAddNickNameText() throws Exception {

    }

    public void handleAddAdressText() throws Exception {

    }

    public void handleAddCountryText() throws Exception {

    }

    public void handleAddEmailText() throws Exception {

    }

    public void handleAddTeamNameText() throws Exception {

    }

    public void handleAddGameId() throws Exception {

    }

    public void handleAddGameText() throws Exception {

    }


    public void handleAddPlayerButton() throws Exception {

    }

    public void handleAddTeamButton() throws Exception {

    }

    public void handleAddGamesButton() throws Exception {

    }

}

