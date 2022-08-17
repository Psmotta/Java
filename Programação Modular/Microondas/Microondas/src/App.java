import java.util.Scanner;

public class App {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Microondas microondas = new Microondas();
        int opcao=1;
        int minutos, segundos;

        System.out.println("Segundos: ");
        segundos = sc.nextInt();
        System.out.println("Minutos: ");
        minutos = sc.nextInt();

        while(opcao!=0){

            System.out.println("1 - Ligar Microondas\n2 - Desligar Microondas\nOpcao: ");
            opcao = sc.nextInt();

            switch (opcao) {
                case 1 -> microondas.ligarMicrioondas(minutos, segundos);
                case 2 -> microondas.desligarMicroondas();
                default -> System.out.println("Opcao Invalida!");
            }

        }

    }

}
