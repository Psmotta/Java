import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Sistema {

    private final ArrayList<String> tecnologias = new ArrayList<>();
    private final ArrayList<Candidato> candidatos = new ArrayList<>();
    private final ArrayList<String> lista_arquivo2 = new ArrayList<>();

    public Sistema() throws FileNotFoundException {

        lerArquivos();

    }

    public ArrayList<String> getTecnologias() {
        return tecnologias;
    }

    public void lerArquivos() throws FileNotFoundException {

        File arquivo1 = new File("Arquivo1.txt");
        File arquivo2 = new File("Arquivo2.txt");

        Scanner scanner1 = new Scanner(arquivo1);
        Scanner scanner2 = new Scanner(arquivo2);

        String[] vetor_aux;

        while(scanner1.hasNext()){

           String[] linhas = scanner1.nextLine().split("\n");
           tecnologias.add(linhas[0]);

        }

        while(scanner2.hasNext()){

            String[] linhas = scanner2.nextLine().split("\n");
            lista_arquivo2.add(linhas[0]);

        }

        for (String auxiliar : lista_arquivo2) {

            vetor_aux = auxiliar.split(";");
            adcionarCandidato(vetor_aux);

        }
    }

    public void adcionarCandidato(String[] vetor_aux){

        String nome;
        int[] habilidade = new int[vetor_aux.length-1];

        nome = vetor_aux[0];

        for(int i = 1, z = 0; i< vetor_aux.length; i++, z++){

            habilidade[z] = Integer.parseInt(vetor_aux[i]);

        }

        Candidato candidato = new Candidato(nome, habilidade);

        candidatos.add(candidato);

    }

    public ArrayList<String> melhorCandidato1(int opcao){

        int habilidade_maior=0;
        ArrayList<String> nome_candidato = new ArrayList<>();
        int maior;

        for (Candidato candidato_loop : candidatos) {

            int[] habilidade = candidato_loop.getHabilidades();
            maior = habilidade[opcao - 1];

            if (habilidade_maior < maior) {

                habilidade_maior = maior;

            }
        }

        for (Candidato candidato_loop : candidatos) {

            int[] habilidade = candidato_loop.getHabilidades();

            if(habilidade[opcao-1] == habilidade_maior){

                nome_candidato.add(candidato_loop.getNome());

            }
        }

        return nome_candidato;

    }

    public ArrayList<String> melhorCandidato2(int opcao1, int opcao2){

        int habilidade_maior=0;
        ArrayList<String> nome_candidato1 = new ArrayList<>();
        ArrayList<String> nome_candidato2 = new ArrayList<>();
        ArrayList<String> candidato;
        int maior;

        for (Candidato candidato_loop : candidatos) {

            int[] habilidade = candidato_loop.getHabilidades();
            maior = habilidade[opcao1 - 1];

            if (habilidade_maior < maior) {

                habilidade_maior = maior;

            }
        }

        for (Candidato candidato_loop : candidatos) {

            int[] habilidade = candidato_loop.getHabilidades();

            if(habilidade[opcao1-1] == habilidade_maior){

                nome_candidato1.add(candidato_loop.getNome());

            }
        }

        if(nome_candidato1.size() > 1){

            habilidade_maior=0;

            for (Candidato candidato_loop : candidatos) {

                if(nome_candidato1.contains(candidato_loop.getNome())) {

                    int[] habilidade = candidato_loop.getHabilidades();
                    maior = habilidade[opcao2 - 1];

                    if (habilidade_maior < maior) {

                        habilidade_maior = maior;

                    }
                }
            }

            for (Candidato candidato_loop : candidatos) {

                int[] habilidade = candidato_loop.getHabilidades();

                if(habilidade[opcao2-1] == habilidade_maior && nome_candidato1.contains(candidato_loop.getNome())){

                    nome_candidato2.add(candidato_loop.getNome());

                }
            }
        }

        candidato = nome_candidato2;
        candidato.retainAll(nome_candidato1);

        return candidato;

    }


}
