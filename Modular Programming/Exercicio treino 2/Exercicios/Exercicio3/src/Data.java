import javax.management.InvalidAttributeValueException;

public class Data {

    private int dia;
    private int mes;
    private int ano;
    private static final int[] MAX_DIA = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    private static final int[] MAX_DIA_BISEXTO={31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    public Data(int dia,int mes,int ano) throws InvalidAttributeValueException {
        this.ano=ano;
        if(mes>=1 && mes<=12)this.mes=mes;
        else throw new InvalidAttributeValueException("Valor de mes invalido");
        if(dia>=1 && dia<=this.getMAX_DIA())this.dia=dia;
        else throw new InvalidAttributeValueException("Valor de dia invalido");
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
        return (this.ano%4==0) ? MAX_DIA_BISEXTO[mes-1] : MAX_DIA[mes-1];
    }
    private int getMAX_DIA(){
        return this.getMAX_DIA(this.mes);
    }

    @Override
    public String toString() {
        return this.dia + "/" + this.mes + "/" + this.ano;
    }
}
