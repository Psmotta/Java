import javax.naming.directory.InvalidAttributesException;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class App {

    public static void main(String[] args) throws FileNotFoundException, InvalidAttributesException {

        Sistema sistema = new Sistema();
        int opcao;
        Scanner sc = new Scanner(System.in);

        System.out.println("Escolha uma opcao: ");
        System.out.println("1 - Dada uma habilidade, quem seria o melhor candidato?");
        System.out.println("2 - Dadas uma habilidade obrigatória e uma importante, quem seria o melhor candidato?");
        System.out.println("3 - Considerando o conjunto de habilidades, quem seria mais interessante para uma vaga?");
        System.out.println("Opcao: ");
        opcao = sc.nextInt();

        switch (opcao) {

            case 1:

                System.out.println("Lista de tecnologias: ");

                for(int i=0; i<sistema.getTecnologias().size(); i++){

                    System.out.println((i+1) + " - " + sistema.getTecnologias().get(i));

                }

                System.out.println("\nEscolha uma tecnologia: ");
                opcao = sc.nextInt();

                if(opcao<=0 || opcao>sistema.getTecnologias().size()){

                    throw new InvalidAttributesException("Opcao invalida!");

                }else  System.out.println("Os melhores candidados para essa opcao sao: " + sistema.melhorCandidato1(opcao).toString());

                break;
            case 2:

                break;
            case 3:

                break;

            default:
                throw new InvalidAttributesException("Opcao invalida!");

        }
    }
}
