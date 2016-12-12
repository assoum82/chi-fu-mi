package Chifoumie;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ChifoumieController implements Initializable {

    @FXML
    private Label scoreMe;
    @FXML
    private Label scoreOrdi;

    @FXML
    private Label win;
    @FXML
    private Label choisOrdi;
    @FXML
    private Label choisMe;


    private int calculScoreOrdi;
    private int calculScoreMe;

    private String me;
    private String ordi;


    private int aleatoire() {
        return (int) ((1 + ((Math.random() * 3)) + (1 + (Math.random() * 3))) / 2);
    }


    private void choise(int x) {
        switch (x) {
            case 1:
                ordi = "pierre";

                break;
            case 2:
                ordi = "feuille";
                break;
            case 3:
                ordi = "ciseau";
                break;
        }
        choisOrdi.setText(ordi);
    }

    private void score() {
        switch (me) {
            case "pierre":
                if (ordi.equals("pierre")) {
                    win.setText("Match Null");
                }
                if (ordi.equals("feuille")) {
                    calculScoreOrdi++;
                    win.setText("Ordinateur");
                }
                if (ordi.equals("ciseau")) {
                    calculScoreMe++;
                    win.setText("Vous");
                }
                break;
            case "feuille":
                if (ordi.equals("pierre")) {
                    calculScoreMe++;
                    win.setText("Vous");
                }
                if (ordi.equals("feuille")) {
                    win.setText("Match Null");

                }
                if (ordi.equals("ciseau")) {
                    calculScoreOrdi++;
                    win.setText("Ordinateur");
                }
                break;
            case "ciseau":
                if (ordi.equals("pierre")) {
                    calculScoreOrdi++;
                    win.setText("Ordinateur");
                }
                if (ordi.equals("feuille")) {
                    calculScoreMe++;
                    win.setText("Vous");

                }
                if (ordi.equals("ciseau")) {
                    win.setText("Match Null");
                }
                break;
        }
    }


    @FXML
    private void games(ActionEvent event) {
        me = ((Button) event.getSource()).getText();
        choisMe.setText(me);
        choise(aleatoire());
        score();
        scoreMe.setText(String.valueOf(calculScoreMe));
        scoreOrdi.setText(String.valueOf(calculScoreOrdi));


    }


    @FXML
    private void reset() {
        scoreMe.setText("");
        scoreOrdi.setText("");
        win.setText("");
        choisOrdi.setText("");
        choisMe.setText("");
        calculScoreMe = 0;
        calculScoreOrdi = 0;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        reset();
    }

    @FXML
    private void retour(ActionEvent event) throws IOException {
        ((Node) (event.getSource())).getScene().getWindow().hide();
        Parent root = FXMLLoader.load(getClass().getResource("/Chifoumie/Demarrer.fxml"));
        Stage primaryStage = new Stage();
        primaryStage.setTitle("Chifoumie");
        primaryStage.setScene(new Scene(root));
        primaryStage.setResizable(false);
        primaryStage.show();
    }
}
