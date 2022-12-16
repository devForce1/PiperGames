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
        primarystage.setScene(new Scene(root, 800, 600));
        primarystage.show();

    }

}

