package musical;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

public class ScoreController implements Initializable {

    @FXML
    private Label label;

    @FXML
    private Label label2;

    int valor;
    String nomeArq = "cadastro.dat";

    ListaPontos lista = new ListaPontos();

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        lista.carregarLista(nomeArq);

        Score score = new Score(Cena_2Controller.jogador);
        score.setScore(valor);

        Node n = new Node(score);
        lista.Cadastrar(n);
        lista.gravarLista(nomeArq);

        pegarScore();

        label2.setText(Cena_2Controller.jogador);
        label.setText(pegarScore() + "pontos");

    }

    private int pegarScore() {

        valor = Regiao_1Controller.pontos + Regiao_1_P2Controller.pontos + Regiao_1_P3Controller.pontos + Regiao_1_P4Controller.pontos;
        return valor;
    }

}
