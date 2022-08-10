public class Vetor {

    //Variaveis
    private int[] vetor1;
    private int[] vetor2;

    //Construtor
    public Vetor(int[] vetor){
        setVetor1(vetor);
        somarNumVetor(vetor1);
    }

    //Metodos set
    public void setVetor1(int[] vetor1) {this.vetor1 = vetor1;}

    //Metodos get
    public int[] getVetor2() {return vetor2;}

    //Metodo de criar vetor 2
    public void somarNumVetor(int[] vetor1){

        int tamanho = this.vetor1.length;
        int nTamanho = tamanho/2;

        int i;
        int z;

        if (tamanho % 2 == 0){

            vetor2 = new int[nTamanho];

            for(i=0, z=0; i<tamanho; z++, i++, i++){

                vetor2[z] = vetor1[i] + vetor1[i+1];

            }

        }else{

            int aux = tamanho - 1;
            vetor2 = new int[nTamanho+1];

            for(i=0, z=0; i<aux; z++, i++, i++){

                vetor2[z] = vetor1[i] + vetor1[i+1];

            }

            vetor2[z] = vetor1[aux] + vetor1[aux];

        }

    }

}
