import java.util.Scanner;

public class PrincipalCandidatos {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite o tamanho do array de candidatos (entre 1 e 100):");
        int tamanho = scanner.nextInt();
        scanner.nextLine(); //nova linha após o nextInt()
        Candidato[][] candidatos = new Candidato[tamanho][tamanho];

        // preenchendo o array com informações do usuário
        for (int i = 0; i < tamanho; i++) {
            for (int j = 0; j < tamanho; j++) {
                System.out.println("Digite o nome do candidato:");
                String nome = scanner.nextLine();
                System.out.println("Digite o partido do candidato:");
                String partido = scanner.nextLine();
                System.out.println("Digite as intenções de voto do candidato:");
                int votos = scanner.nextInt();
                scanner.nextLine(); //nova linha após o nextInt()
                candidatos[i][j] = new Candidato(nome, partido, votos);
            }
        }

        //ordenando os candidatos
        ordenaCandidatosPorNome(candidatos);
        ordenaCandidatosPorPartido(candidatos);
        ordenaCandidatosPorVotos(candidatos);

        //imprimindo em tela os candidatos ordenados
        System.out.println("Candidatos ordenados:");
        for (int i = 0; i < tamanho; i++) {
            for (int j = 0; j < tamanho; j++) {
                System.out.println(candidatos[i][j]);
            }
        }

        // tentando fazer o método de pesquisa funcionar
        System.out.println("\nDigite o nome do candidato que deseja pesquisar:");
        String nomePesquisa = scanner.nextLine();
        int posicao = pesquisaBinariaCandidatos(candidatos, nomePesquisa);
        if (posicao != -1) {
            System.out.println("Candidato encontrado na posição " + posicao + ": " + candidatos[posicao]);
        } else {
            System.out.println("Candidato não encontrado.");
        }

        scanner.close();
    }

    public static void ordenaCandidatosPorNome(Candidato[][] candidatos) {
        for (int i = 0; i < candidatos.length; i++) {
            for (int j = 0; j < candidatos[i].length - 1; j++) {
                for (int k = 0; k < candidatos[i].length - j - 1; k++) {
                    if (candidatos[i][k].getNome().compareTo(candidatos[i][k + 1].getNome()) > 0) {
                        Candidato temp = candidatos[i][k];
                        candidatos[i][k] = candidatos[i][k + 1];
                        candidatos[i][k + 1] = temp;
                    }
                }
            }
        }
    }

    public static void ordenaCandidatosPorVotos(Candidato[][] candidatos) {
        for (int i = 0; i < candidatos.length; i++) {
            for (int j = 0; j < candidatos[i].length - 1; j++) {
                for (int k = 0; k < candidatos[i].length - j - 1; k++) {
                    if (candidatos[i][k].getIntencoesVotos() < candidatos[i][k + 1].getIntencoesVotos()) {
                        Candidato temp = candidatos[i][k];
                        candidatos[i][k] = candidatos[i][k + 1];
                        candidatos[i][k + 1] = temp;
                    }
                }
            }
        }
    }

    public static void ordenaCandidatosPorPartido(Candidato[][] candidatos) {
        for (int i = 0; i < candidatos.length; i++) {
            for (int j = 0; j < candidatos[i].length - 1; j++) {
                for (int k = 0; k < candidatos[i].length - j - 1; k++) {
                    if (candidatos[i][k].getPartido().compareTo(candidatos[i][k + 1].getPartido()) > 0) {
                        Candidato temp = candidatos[i][k];
                        candidatos[i][k] = candidatos[i][k + 1];
                        candidatos[i][k + 1] = temp;
                    }
                }
            }
        }
    }

    public static int pesquisaBinariaCandidatos(Candidato [][] candidatos, String nome) {
        for (int i = 0; i < candidatos.length; i++) {
            for (int j = 0; j < candidatos[i].length; j++) {
                if (candidatos[i][j].getNome().equals(nome)) {
                    return i; // vai retornar a posição onde o candidato foi encontrado
                }
            }
        }
        return -1; // aqui retorna -1 se o candidato não for encontrado
    }
}