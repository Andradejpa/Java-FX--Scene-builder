package musical;

import java.io.Serializable;

public class Score implements Serializable{

    private static int score;
    String nome;

    public Score(String nome) {
        this.nome=nome;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String toString() {
        return "" + this.score;
    }

}
