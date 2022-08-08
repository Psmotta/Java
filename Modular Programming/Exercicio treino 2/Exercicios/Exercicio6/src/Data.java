import javax.management.InvalidAttributeValueException;

public class Data {

    private final int dia;
    private final int mes;
    private final int ano;
    private static final int[] MAX_DIA = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    private static final int[] DIAS_SEMANA = {1, 2, 3, 4, 5, 6, 7};

    public Data(int dia,int mes,int ano) throws InvalidAttributeValueException {
        this.ano=ano;
        if(mes>=1 && mes<=12)this.mes=mes;
        else throw new InvalidAttributeValueException("Valor de mes invalido");
        if(dia>=1 && dia<=this.getMAX_DIA())this.dia=dia;
        else throw new InvalidAttributeValueException("Valor de dia invalido");
    }

    //Metodos get
    private int getMAX_DIA(int mes){
        return MAX_DIA[mes-1];
    }
    private int getMAX_DIA(){
        return this.getMAX_DIA(this.mes);
    }

}
