import java.util.Arrays;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int[] vetor1;
        int tamanho;

        System.out.println("Digite o tamanho do vetor: ");
        tamanho = sc.nextInt();
        vetor1 = new int[tamanho];

        for (int i=0; i<tamanho; i++){

            System.out.println("Digite um numero: ");
            vetor1[i] = sc.nextInt();

        }

        System.out.println("Seu vetor e: " + Arrays.toString(vetor1));

        Vetor vet = new Vetor(vetor1);

        System.out.println("O novo vetor e: " + Arrays.toString(vet.getVetor2()));

    }

}
