import java.util.Arrays;
import java.util.Scanner;

public class Vetor {

    //Variaveis
    private int[] vetor1 = new int[6];
    private int[] vetor2 = new int[6];

    //Construtor
    public Vetor(int[] vetor1){

        setVetor1(vetor1);
        inverterVetor();
    }

    //Metodos get
    public String getVetor1() {return Arrays.toString(vetor1);}
    public String getVetor2() {return Arrays.toString(vetor2);}

    //Metodos set
    public void setVetor1(int[] vetor1) {this.vetor1 = vetor1;}
    public void setVetor2(int[] vetor2) {this.vetor2 = vetor2;}

    //Metodo inverter Vetor
    public void inverterVetor(){

        int i;
        int z;

        for(z=vetor1.length - 1, i=0; z>=0; z--, i++){
            vetor2[z] = vetor1[i];
        }

    }

    public void preencherVetor(){

        Scanner sc = new Scanner(System.in);
        for(int i=0; i<6; i++){
            System.out.println("Digite um numero: ");
            vetor1[i] = sc.nextInt();
        }

    }

}
