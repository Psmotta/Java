import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Sistema {

    private final ArrayList<Vetor> vetores = new ArrayList<>();

    public Sistema() throws FileNotFoundException {

        lerArquivo();

    }

    public ArrayList<Vetor> getVetores() {
        return vetores;
    }

    public void lerArquivo() throws FileNotFoundException {

        File arquivo = new File("Vetores.txt");
        Scanner sc = new Scanner(arquivo);
        ArrayList<String> lista_auxiliar = new ArrayList<>();
        String[] vetor_auxiliar;

        while(sc.hasNext()){

            String[] linhas = sc.nextLine().split("\n");
            lista_auxiliar.add(linhas[0]);

        }

        for (String linha : lista_auxiliar) {

            vetor_auxiliar = linha.split(";");
            adcionarVetorLista(vetor_auxiliar);

        }

    }

    private void adcionarVetorLista(String[] vetor_auxiliar){

        int[] vetor_lido = new int[vetor_auxiliar.length];

        for(int i = 0, z = 0; i<vetor_auxiliar.length; i++, z++){

            vetor_lido[z] = Integer.parseInt(vetor_auxiliar[i]);

        }

        Vetor vetor = new Vetor(vetor_lido);

        vetores.add(vetor);

    }

}
