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

    public ArrayList<String> melhorCandidato1(int opcao){

        int habilidade_maior = calcularMaior(opcao-1);

        return nomeCandidato(habilidade_maior, opcao-1);

    }

    public ArrayList<String> melhorCandidato2(int opcao1, int opcao2){

        ArrayList<String> nome_candidato2 = null;
        ArrayList<String> candidato;
        int numero_maior;

        int habilidade_maior = calcularMaior(opcao1-1);

        ArrayList<String> nome_candidato1 = nomeCandidato(habilidade_maior, opcao1-1);

        if(nome_candidato1.size() > 1){

            habilidade_maior=0;

            for (Candidato candidato_loop : candidatos) {

                if(nome_candidato1.contains(candidato_loop.getNome())) {

                    int[] habilidade = candidato_loop.getHabilidades();
                    numero_maior = habilidade[opcao2 - 1];

                    if (habilidade_maior < numero_maior) {

                        habilidade_maior = numero_maior;

                    }
                }
            }

            nome_candidato2 = nomeCandidato(habilidade_maior, opcao2-1);

        }

        candidato = nome_candidato2;
        candidato.retainAll(nome_candidato1);

        return candidato;

    }

    public ArrayList<String> melhorCandidato3(){

        ArrayList<String> nome_candidato = new ArrayList<>();
        ArrayList<String> arrayAuxiliar = new ArrayList<>();
        ArrayList<String> candidato;
        int maior_repetido=0;

        for(int i=0; i<tecnologias.size(); i++){

            int habilidade_maior = calcularMaior(i);
            candidato = nomeCandidato(habilidade_maior, i);
            nome_candidato.addAll(candidato);

        }

        for(int i=0; i<nome_candidato.size(); i++){

            int repetiu=0;

            for (String nome : nome_candidato) {

                if(nome.equals(nome_candidato.get(i))){

                    repetiu++;

                }

            }

            if(maior_repetido<repetiu){

                maior_repetido=repetiu;

            }

        }

        for(int i=0; i<nome_candidato.size(); i++){

            int repetiu=0;

            for (String nome : nome_candidato) {

                if(nome.equals(nome_candidato.get(i))){

                    repetiu++;

                }

            }

            if(maior_repetido==repetiu){

                if(!arrayAuxiliar.contains(nome_candidato.get(i))) {
                    arrayAuxiliar.add(nome_candidato.get(i));
                }

            }

        }


        nome_candidato = arrayAuxiliar;


        return nome_candidato;
    }

    private int calcularMaior(int i){

        int habilidade_maior=0;
        int numero_maior;

        for (Candidato candidato_loop : candidatos) {

            int[] habilidade = candidato_loop.getHabilidades();
            numero_maior = habilidade[i];

            if (habilidade_maior < numero_maior) {

                habilidade_maior = numero_maior;

            }
        }

        return habilidade_maior;
    }

    private ArrayList<String> nomeCandidato(int habilidade_maior, int i){

        ArrayList<String> nome_candidato = new ArrayList<>();

        for (Candidato candidato_loop : candidatos) {

            int[] habilidade = candidato_loop.getHabilidades();

            if(habilidade[i] == habilidade_maior){

                nome_candidato.add(candidato_loop.getNome());

            }
        }

        return nome_candidato;

    }

    private void adcionarCandidato(String[] vetor_aux){

        String nome;
        int[] habilidade = new int[vetor_aux.length-1];

        nome = vetor_aux[0];

        for(int i = 1, z = 0; i< vetor_aux.length; i++, z++){

            habilidade[z] = Integer.parseInt(vetor_aux[i]);

        }

        Candidato candidato = new Candidato(nome, habilidade);

        candidatos.add(candidato);

    }

}
