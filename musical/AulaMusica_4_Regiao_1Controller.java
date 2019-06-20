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

public class AulaMusica_4_Regiao_1Controller implements Initializable {

    AudioClip note = new AudioClip(this.getClass().getResource("/Music/Música - Você quer Brincar na neve.mp3").toString());

    @FXML
    void continuar(ActionEvent event) {
        note.stop();
        Parent tableViewParent = null;
        try {
            tableViewParent = FXMLLoader.load(getClass().getResource("Regiao_1_Fim.fxml"));
        } catch (IOException ex) {
            Logger.getLogger(AulaMusica_1_Regiao_1Controller.class.getName()).log(Level.SEVERE, null, ex);
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

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        play();
    }

}
