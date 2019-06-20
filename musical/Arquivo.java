package musical;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

class Arquivo {

    private ObjectInputStream input;
    private ObjectOutputStream output;

    public void openToWrite(String nomeArq) {
        try {
            File arq = new File(nomeArq);
            if (arq.exists() == false) {
                FileOutputStream fileOut = new FileOutputStream(arq);
                output = new ObjectOutputStream(fileOut);
                System.out.println("Arquivo criado");
            } else {//sobrescrevendo
                FileOutputStream fileOut = new FileOutputStream(arq, true);
                output = new ObjectOutputStream(fileOut);
                System.out.println("Arquivo aberto para anexar");
            }

        } catch (IOException ioException) {
            System.err.println("Erro ao tentar criar o arquivo para gravação");
            System.exit(1);
        }
    }

    public boolean openToRead(String nomeArq) {
        try {
            File arq = new File(nomeArq);
            if (arq.exists() == false) {
                return false;
            } else {
                FileInputStream fileIn = new FileInputStream(arq);
                input = new ObjectInputStream(fileIn);
                return true;
            }
        } catch (IOException ioException) {
            System.err.println("Erro ao tentar abrir o arquivo para leitura");
            return false;
        }
    }

    public void closeWriteFile() {
        try {
            if (output != null) {
                output.flush();
                output.close();
                output = null;
            }
        } catch (IOException ioException) {
            System.err.println("Erro ao tentar fechar o arquivo após gravação");
            System.exit(1);
        }
    }

    public void closeReadFile() {
        try {
            if (input != null) {
                input.close();
                input = null;
            }
        } catch (IOException ioException) {
            System.err.println("Erro ao tentar fechar o arquivo após leitura");
            System.exit(1);
        }
    }

    public void gravarDados(Score S) {
        try {
            output.writeObject(S);
        } catch (IOException ioException) {
            System.err.println("Erro de gravação");
            System.exit(1);
        }
    }

    public Score lerDados() {
        Score S;

        try {
            S = (Score) input.readObject();
            return S;
        } catch (EOFException endOfFileException) {
            return null; //fim de arquivo
        } catch (ClassNotFoundException classNotFoundException) {
            return null;
        } catch (IOException ioException) {
            return null;
        }
    }

}
