import javax.management.InvalidAttributeValueException;

public class Data {

    private int dia;
    private int mes;
    private int ano;
    private static final int[] MAX_DIA = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    private static final int[] DIAS_SEMANA = {1, 2, 3, 4, 5, 6, 7};

    public Data(int dia,int mes,int ano) throws InvalidAttributeValueException {
        if(ano!=2022){
            throw new InvalidAttributeValueException("Valor de ano invalido");
        }else this.ano=ano;
        if(mes>=1 && mes<=12){
            this.mes=mes;
        }else throw new InvalidAttributeValueException("Valor de mes invalido");
        if(dia>=1 && dia<=this.getMAX_DIA()){
            this.dia=dia;
        } else throw new InvalidAttributeValueException("Valor de dia invalido");
    }

    //Metodos get
    public int getDia() {
        return dia;
    }
    public int getMes() {
        return mes;
    }
    public int getAno() {
        return ano;
    }
    private int getMAX_DIA(int mes){
        return MAX_DIA[mes-1];
    }
    private int getMAX_DIA(){
        return this.getMAX_DIA(this.mes);
    }

    //Metodo verificar dia semana
    public void verificarDiaSemana(){

        int dias=0;
        int dia_semana = 0;

        if(mes!=1){
            for(int i=0; i<mes-1; i++){

                dias+=MAX_DIA[i];

            }
            dias = dias + this.dia;
        }
        else{
            dias = this.dia;
        }

        //Retirar o dia de sabado (1/1/2022)
        dias = dias-1;

        while(dias!=0){

            for(int i=0; i<DIAS_SEMANA.length; i++){

                dia_semana = DIAS_SEMANA[i];
                dias--;
                if(dias==0){
                    break;
                }

            }

        }

        switch (dia_semana){

            case 1:
                System.out.println("Domingo");
                break;

            case 2:
                System.out.println("Segunda");
                break;

            case 3:
                System.out.println("Terca");
                break;

            case 4:
                System.out.println("Quarta");
                break;

            case 5:
                System.out.println("Quinta");
                break;

            case 6:
                System.out.println("Sexta");
                break;

            case 7:
                System.out.println("Sabado");
                break;
        }
    }

    @Override
    public String toString() {
        return this.dia + "/" + this.mes + "/" + this.ano;
    }
}
