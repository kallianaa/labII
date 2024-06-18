import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Labirinto {
    private char[][] labirinto;
    private int linhas;
    private int colunas;

    public Labirinto(String filename) {
        criaLabirinto(filename);
    }

    public void criaLabirinto(String filename) {
        try {
            Scanner fileScanner = new Scanner(new File(filename));
            linhas = fileScanner.nextInt();
            colunas = fileScanner.nextInt();
            fileScanner.nextLine(); //proxima linha

            labirinto = new char[linhas][colunas];

            for (int i = 0; i < linhas; i++) {
                String linha = fileScanner.nextLine();
                for (int j = 0; j < colunas; j++) {
                    labirinto[i][j] = linha.charAt(j);
                }
            }
            fileScanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public boolean percorreLabirinto() {
        return percorreLabirinto(0, 0);
    }

    private boolean percorreLabirinto(int x, int y) {
        if (x < 0 || y < 0 || x >= linhas || y >= colunas || labirinto[x][y] == 'X' || labirinto[x][y] == '*') {
            return false;
        }
        if (labirinto[x][y] == 'D') {
            return true;
        }

        labirinto[x][y] = '*'; //marcando como visitado

        //movendo para cima, baixo, esquerda e direita
        boolean encontrado = percorreLabirinto(x - 1, y) || percorreLabirinto(x + 1, y) ||
                percorreLabirinto(x, y - 1) || percorreLabirinto(x, y + 1);

        labirinto[x][y] = ' '; //desmarca se não encontrou o final

        return encontrado;
    }

    public void imprimeLabirinto() {
        for (int i = 0; i < linhas; i++) {
            for (int j = 0; j < colunas; j++) {
                System.out.print(labirinto[i][j]);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Labirinto labirinto = new Labirinto("labirinto.txt");
        labirinto.imprimeLabirinto();
        if (labirinto.percorreLabirinto()) {
            System.out.println("Há uma saída para o labirinto.");
        } else {
            System.out.println("Não há saída para o labirinto.");
        }
    }
}