package musical;

public class ListaPontos {

    private Node first;
    private Node last;
    private int qtd;

    public void Cadastrar(Node N) {
        if (isEmpty() == true) {
            first = N;
            last = N;
            qtd++;
            return;
        } else {
            if (N.getInfo().getScore() > first.getInfo().getScore()) {//maior, insere inicio
                N.setNext(first);
                first = N;
                this.qtd++;
                return;
            } else if (N.getInfo().getScore() < last.getInfo().getScore()) {// menor insere final
                last.setNext(N);
                last = N;
                this.qtd++;
                return;
            } else {
                Node anterior = first;
                Node atual = first.getNext();
                while (N.getInfo().getScore() < atual.getInfo().getScore()) {
                    anterior = atual;
                    atual = atual.getNext();

                }
                anterior.setNext(N);
                N.setNext(atual);
                this.qtd++;
                return;
            }
        }
    }

    public boolean isEmpty() {
        if (qtd == 0) {
            return true;
        } else {
            return false;
        }
    }

    public void Exibir() {

        Node aux = first;
        while (aux != null) {
            System.out.println(aux.getInfo());
            aux = aux.getNext();
        }
    }

    public void gravarLista(String nomeArq) {
        Node aux = this.first;

        if (this.isEmpty() == true) {
            System.out.println("Lista vazia");
        } else {
            Arquivo arq = new Arquivo();
            arq.openToWrite(nomeArq);
            while (aux != null) {
                arq.gravarDados(aux.getInfo());
                aux = aux.getNext();
            }
            arq.closeWriteFile();
        }
    }

    public void carregarLista(String nomeArq) {
        Arquivo arq = new Arquivo();
        Score C;

        boolean exists = arq.openToRead(nomeArq);
        if (exists == true) {
            C = arq.lerDados();
            while (C != null) {
                Node novo = new Node(C);
                this.Cadastrar(novo);
                C = arq.lerDados();
            }
            arq.closeReadFile();
        }
    }

}
