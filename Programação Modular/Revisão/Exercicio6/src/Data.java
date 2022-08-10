public class Data {

    private final int dia;
    private final int mes;
    private final int ano;
    private static final int[] MAX_DIA = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    private static final int[] MAX_DIA_BISEXTO={31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    private static final int[] DIAS_SEMANA = {7, 1, 2, 3, 4, 5, 6};

    public Data(int dia,int mes,int ano) {
        this.ano=ano;
        this.mes=mes;
        this.dia=dia;
    }

    //Metodos get
    private int getMAX_DIA(int mes){
        return (this.ano%4==0) ? MAX_DIA_BISEXTO[mes-1] : MAX_DIA[mes-1];
    }
    private int getMAX_DIA(){
        return this.getMAX_DIA(this.mes);
    }

    public void verificarDataValida(){

        if(mes<1 || mes>12){

            System.out.println("Mes: " + mes + " invalido!\n");

        }else if(dia<1 || dia>this.getMAX_DIA()){

            System.out.println("Dia: " + dia + " invalido!\n");

        }else verificarDiaSemana();

    }

    private void verificarDiaSemana(){

        float data_em_dias=0;
        float pegar_resto;

        if(ano%4==0){

            for(int i=0; i<mes; i++){

                data_em_dias+=MAX_DIA_BISEXTO[i];

            }

            pegar_resto = (data_em_dias%7);

            if(pegar_resto>0){

                pegar_resto=pegar_resto-1;

            }

        }else{

            for(int i=0; i<mes; i++){

                data_em_dias+=MAX_DIA[i];


            }

            pegar_resto = data_em_dias%7;

        }

        switch (DIAS_SEMANA[(int) pegar_resto]){
            case 1 -> System.out.println("Domingo\n");
            case 2 -> System.out.println("Segunda\n");
            case 3 -> System.out.println("Terca\n");
            case 4 -> System.out.println("Quarta\n");
            case 5 -> System.out.println("Quinta\n");
            case 6 -> System.out.println("Sexta\n");
            case 7 -> System.out.println("Sabado\n");
        }

    }

    @Override
    public String toString() {
        return this.dia + "/" + this.mes + "/" + this.ano;
    }

}
