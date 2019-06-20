package musical;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
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
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;

import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

public class MapaController implements Initializable, KeyListener {

    private double x = 0;
    private double y = 0;

    @FXML
    private Button botao;
    @FXML
    private ImageView personagem;

    MediaPlayer mediaplayer;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    @FXML
    void proximaCena(ActionEvent event) {
        Parent tableViewParent = null;
        try {
            tableViewParent = FXMLLoader.load(getClass().getResource("Regiao_1.fxml"));

        } catch (IOException ex) {
            Logger.getLogger(MapaController.class.getName()).log(Level.SEVERE, null, ex);
        }
        Scene tableViewScene = new Scene(tableViewParent);

        //This line gets the Stage information
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

        window.setScene(tableViewScene);

        window.show();
    }

    @Override
    public void keyPressed(KeyEvent e) {
        // int k = e.getKeyCode();
        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
            System.out.println("Cima");
        }

    }

    @Override
    public void keyTyped(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyReleased(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
