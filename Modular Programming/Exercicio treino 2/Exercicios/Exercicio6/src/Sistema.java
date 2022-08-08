import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Sistema {

    private ArrayList<Data> lista_datas = new ArrayList<>();
    private int quantidade_linhas_arquivo;
    public Sistema() throws FileNotFoundException {

        lerArquivo();

    }

    private void lerArquivo() throws FileNotFoundException {

        File datas = new File("Datas.txt");
        Scanner scanner = new Scanner(datas);
        ArrayList<String> datas_lidas_arquivo = new ArrayList<>();

        while(scanner.hasNext()){

            String[] linhas = scanner.nextLine().split("\n");
            datas_lidas_arquivo.add(linhas[0]);

        }

        quantidade_linhas_arquivo = Integer.parseInt(datas_lidas_arquivo.get(0));

    }

    private void adcionarListaDatas(){



    }

}
