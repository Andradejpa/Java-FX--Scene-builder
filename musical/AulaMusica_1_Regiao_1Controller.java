/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
import javafx.scene.media.AudioClip;
import javafx.stage.Stage;

public class AulaMusica_1_Regiao_1Controller implements Initializable {

    AudioClip note = new AudioClip(this.getClass().getResource("/Music/Vitor Kley - O Sol.mp3").toString());

    @FXML
    void continuar(ActionEvent event) {
        note.stop();
        Parent tableViewParent = null;
        try {
            tableViewParent = FXMLLoader.load(getClass().getResource("Regiao_1_P2.fxml"));
        } catch (IOException ex) {
            Logger.getLogger(AulaMusica_1_Regiao_1Controller.class.getName()).log(Level.SEVERE, null, ex);
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

    private void play() {
        note.play();

    }

}
