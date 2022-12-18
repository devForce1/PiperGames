package org.example;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class TestController extends Application {
    @Override
    public void start(Stage stage) {
        try {

            String s = "piper_test.fxml";
            Parent root = FXMLLoader.load(getClass().getClassLoader().getResource(s));
            Scene scene = new Scene(root);
            //scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
            stage.setScene(scene);
            stage.show();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }


    public void buttonTest(ActionEvent e) {
        System.out.println("the button works");

    }

    public void playerName(ActionEvent e){

    }
}
