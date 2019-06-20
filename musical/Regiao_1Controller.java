package musical;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;

import javafx.scene.control.Label;
import javafx.scene.layout.Region;
import javafx.scene.media.AudioClip;
import javafx.stage.Stage;

public class Regiao_1Controller implements Initializable {

    AudioClip note = new AudioClip(this.getClass().getResource("/Music/Vitor Kley - O Sol.mp3").toString());
    @FXML
    private Label label;

    public static int pontos;

    @FXML
    void proximaPergunta(ActionEvent event) {
        note.stop();
        label.setText("Reposta Correta");
        pontos = 200;

        Parent tableViewParent = null;
        try {
            tableViewParent = FXMLLoader.load(getClass().getResource("Regiao_1_P2.fxml"));
        } catch (IOException ex) {
            Logger.getLogger(Regiao_1Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
        Scene tableViewScene = new Scene(tableViewParent);

        //This line gets the Stage information
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

        window.setScene(tableViewScene);
        window.show();

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        play();
    }

    @FXML
    void respostaIncorreta(ActionEvent event) {
        note.stop();
        label.setText("Reposta Incorreta");
        pontos = 100;
        Parent tableViewParent = null;
        try {
            tableViewParent = FXMLLoader.load(getClass().getResource("AulaMusica_1_Regiao_1.fxml"));
        } catch (IOException ex) {
            Logger.getLogger(Regiao_1Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
        Scene tableViewScene = new Scene(tableViewParent);

        //This line gets the Stage information
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

        window.setScene(tableViewScene);
        window.show();

    }

    private void play() {

        note.play();

    }

}
