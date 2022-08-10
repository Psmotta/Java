import javax.naming.directory.InvalidAttributesException;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class App {

    public static void main(String[] args) throws FileNotFoundException, InvalidAttributesException {

        Sistema sistema = new Sistema();
        int opcao1;
        int opcao2;
        Scanner sc = new Scanner(System.in);

        System.out.println("Escolha uma opcao: ");
        System.out.println("1 - Dada uma habilidade, quem seria o melhor candidato?");
        System.out.println("2 - Dadas uma habilidade obrigatoria e uma importante, quem seria o melhor candidato?");
        System.out.println("3 - Considerando o conjunto de habilidades, quem seria mais interessante para uma vaga?");
        System.out.println("Opcao: ");
        opcao1 = sc.nextInt();

        switch (opcao1) {
            case 1 -> {

                System.out.println("Lista de tecnologias: ");

                for (int i = 0; i < sistema.getTecnologias().size(); i++) {

                    System.out.println((i + 1) + " - " + sistema.getTecnologias().get(i));

                }

                System.out.println("\nEscolha uma tecnologia: ");
                opcao1 = sc.nextInt();

                if (opcao1 <= 0 || opcao1 > sistema.getTecnologias().size()) {

                    throw new InvalidAttributesException("Opcao invalida!");

                } else
                    System.out.println("Os melhores candidados para essa opcao sao: " + sistema.melhorCandidato1(opcao1).toString());
            }
            case 2 -> {

                System.out.println("Lista de tecnologias: ");

                for (int i = 0; i < sistema.getTecnologias().size(); i++) {

                    System.out.println((i + 1) + " - " + sistema.getTecnologias().get(i));

                }

                System.out.println("\nEscolha a tecnologia obrigatoria: ");
                opcao1 = sc.nextInt();

                if (opcao1 <= 0 || opcao1 > sistema.getTecnologias().size()) {

                    throw new InvalidAttributesException("Opcao invalida!");

                } else {

                    System.out.println("\nEscolha a tecnologia importante: ");
                    opcao2 = sc.nextInt();

                    if (opcao2 <= 0 || opcao2 > sistema.getTecnologias().size()) {

                        throw new InvalidAttributesException("Opcao invalida!");

                    } else
                        System.out.println("O melhor candidato para essas tecnologias e: " + sistema.melhorCandidato2(opcao1, opcao2));

                }
            }

            case 3 -> System.out.println(sistema.melhorCandidato3().toString());

            default -> throw new InvalidAttributesException("Opcao invalida!");
        }
    }
}
