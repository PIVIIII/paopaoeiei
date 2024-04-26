package game;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


import java.io.IOException;

public class SceneController {
    private Stage stage;


    public void homeToChoose(ActionEvent event) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("chooseCharacter.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();

        stage.setScene(new Scene(root));
//        stage.setMaximized(true);
        stage.setResizable(false);
        stage.show();
    }

}
