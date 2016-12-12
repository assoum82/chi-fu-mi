package Chifoumie;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Created by chawki on 12/12/16.
 */
public class DemarrerController {


    @FXML
    private void playGame(ActionEvent event) throws IOException {
        ((Node) (event.getSource())).getScene().getWindow().hide();
        Parent root = FXMLLoader.load(getClass().getResource("/Chifoumie/Chifoumie.fxml"));
        Stage primaryStage = new Stage();
        primaryStage.setTitle("Chifoumie");
        primaryStage.setScene(new Scene(root));
        primaryStage.setResizable(false);
        primaryStage.show();
    }


    @FXML
    void closeGame(ActionEvent event) throws IOException {
        ((Node) (event.getSource())).getScene().getWindow().hide();

    }
}
