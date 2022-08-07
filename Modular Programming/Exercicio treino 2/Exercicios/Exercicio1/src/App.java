import java.util.Scanner;

public class App {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int[] vetor1 = new int[6];
        int i;

        for(i=0; i<6; i++){
            System.out.println("Digite um numero: ");
            vetor1[i] = sc.nextInt();
        }

        Vetor vetor = new Vetor(vetor1);

        System.out.println("Vetor 1: " + vetor.getVetor1());
        System.out.println("Vetor Invertido: " + vetor.getVetor2());


    }
}
