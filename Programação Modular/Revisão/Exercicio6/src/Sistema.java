import javax.naming.directory.InvalidAttributesException;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Sistema {

    private final ArrayList<Data> lista_datas = new ArrayList<>();

    public Sistema() throws FileNotFoundException, InvalidAttributesException{

        lerArquivo();

    }

    public void mostrarDatasValidas(){


        for (Data data : lista_datas) {
            System.out.println(data);
            data.verificarDataValida();

        }

    }

    private void lerArquivo() throws FileNotFoundException, InvalidAttributesException{

        File datas = new File("Datas.txt");
        Scanner scanner = new Scanner(datas);
        ArrayList<String> datas_lidas_arquivo = new ArrayList<>();
        String vetor_auxiliar;

        while(scanner.hasNext()){

            String[] linhas = scanner.nextLine().split("\n");
            datas_lidas_arquivo.add(linhas[0]);

        }

        int quantidade_linhas_arquivo = Integer.parseInt(datas_lidas_arquivo.get(0));

        if(quantidade_linhas_arquivo != datas_lidas_arquivo.size()-1){

            throw new InvalidAttributesException("O numero de datas e invalido a quantidade de dadas!");

        }else{

            for(int i=1; i<datas_lidas_arquivo.size(); i++){

                vetor_auxiliar = datas_lidas_arquivo.get(i);
                adcionarListaDatas(vetor_auxiliar);

            }

        }

    }

    private void adcionarListaDatas(String vetor_auxiliar){

        int dia;
        int mes;
        int ano;
        String[] dividir_data;

        dividir_data = vetor_auxiliar.split("/");
        dia = Integer.parseInt(dividir_data[0]);
        mes = Integer.parseInt(dividir_data[1]);
        ano = Integer.parseInt(dividir_data[2]);

        Data data = new Data(dia, mes, ano);

        lista_datas.add(data);

    }

}
