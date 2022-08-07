import java.util.Arrays;

public class Vetor {

    private int[] vetor_lido;
    private int[] vetor_somado;

    public Vetor(int[] vetor1){

        setVetor_lido(vetor1);
        somarNumVetor(vetor1);

    }

    public void setVetor_lido(int[] vetor_lido) {
        this.vetor_lido = vetor_lido;
    }

    public void somarNumVetor(int[] vetor1){

        int tamanho = this.vetor_lido.length;
        int nTamanho = tamanho/2;

        int i;
        int z;

        if (tamanho % 2 == 0){

            vetor_somado = new int[nTamanho];

            for(i=0, z=0; i<tamanho; z++, i++, i++){

                vetor_somado[z] = vetor1[i] + vetor1[i+1];

            }

        }else{

            int aux = tamanho - 1;
            vetor_somado = new int[nTamanho+1];

            for(i=0, z=0; i<aux; z++, i++, i++){

                vetor_somado[z] = vetor1[i] + vetor1[i+1];

            }

            vetor_somado[z] = vetor1[aux] + vetor1[aux];

        }

    }

    @Override
    public String toString() {
        return "\nVetor lido: " + Arrays.toString(vetor_lido) + "\nVetor somado" + Arrays.toString(vetor_somado) + "\n";
    }
}
