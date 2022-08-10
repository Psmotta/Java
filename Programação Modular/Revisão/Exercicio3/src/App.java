import javax.management.InvalidAttributeValueException;
import java.util.Scanner;

public class App {

    public static void main(String[] args) throws InvalidAttributeValueException {

        Scanner sc = new Scanner(System.in);
        int dia;
        int mes;
        int ano;

        System.out.println("Digite um dia: ");
        dia = sc.nextInt();
        System.out.println("Digite um mes: ");
        mes = sc.nextInt();
        System.out.println("Digite um ano: ");
        ano = sc.nextInt();

        Data data = new Data(dia, mes, ano);

        System.out.println("A data e: " + data);



    }

}
