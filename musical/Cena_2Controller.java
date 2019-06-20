/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package musical;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Administrador JP
 */
public class Cena_2Controller implements Initializable {

    @FXML
    private CheckBox personagem1;
    @FXML
    private CheckBox personagem2;
    @FXML
    private Label lab;
    @FXML
    private TextField nomeJogador;

    public static String jogador;

    @FXML
    void display(ActionEvent event) throws IOException {

        lab.setText(nomeJogador.getText());
        jogador = nomeJogador.getText();
        if (personagem1.isSelected() || personagem2.isSelected()) {
            Parent tableViewParent = FXMLLoader.load(getClass().getResource("Mapa.fxml"));
            Scene tableViewScene = new Scene(tableViewParent);

            //This line gets the Stage information
            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

            window.setScene(tableViewScene);
            window.show();
        } else {
            lab.setText("Escolha seu personagem");
        }

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

}
