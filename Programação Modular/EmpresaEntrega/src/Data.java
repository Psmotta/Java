import javax.management.InvalidAttributeValueException;

public class Data implements Comparable<Data>{

    //Declaracao das variaveis
    private Integer dia;
    private Integer mes;
    private Integer ano;
    private static final int[] MAX_DIA = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    private static final int[] MAX_DIA_BISEXTO={31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    private static final int MAX_MES=12;

    //Metodo construtor da classe data
    public Data(int dia,int mes,int ano) throws InvalidAttributeValueException{
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
    private int getMesesEmDias(){
        int dias=0;
        for (int i=1;i<=mes;i++) {
            dias+=getMAX_DIA(i);
        }
        return dias;
    }
    private int getDataEmDias(){
        int anosBisextos=this.ano/4;
        int dias=anosBisextos*366;
        dias+=(this.ano-anosBisextos)*365;
        dias+=(this.ano<0)?-1*getMesesEmDias():getMesesEmDias();
        dias+=(this.ano<0)?-1*getDia():getDia();
        return dias;
    }

    /*
    * Esse metodo maiorData(Data o) chama o metodo compareTo(o) e compara 2 datas
    * assim retornando se a data é igual, ou maior que a outra.
    */
    public String maiorData(Data o) {
        return switch (this.compareTo(o)) {
            case -1 -> "A mais futura e: " + o.toString();
            case 0 -> "As datas são iguais.";
            case 1 -> "A mais futura e: " + this.toString();
            default -> "Não foi possível comparar as datas.";
        };
    }

    /*
    * Esse metodo adciona dias na sua data. Caso sua data seja 01/01/2022 e
    * voce chame esse metodo e adcione 3 dias, sua data passa a ser 04/01/2022
    */
    public void addDias(int dias){
        this.dia+=dias;
        while(this.dia>this.getMAX_DIA()){
            this.dia-=this.getMAX_DIA();
            this.addMeses(1);
        }
    }

    //Metodo adciona meses na sua data
    public void addMeses(int meses){
        int vezes=0;
        this.mes+=meses;
        while(this.mes> MAX_MES){
            this.mes-= MAX_MES;
            vezes++;
        }
        addAnos(vezes);
    }

    //Metodo que adciona anos na sua data
    public void addAnos(int anos){
        this.ano+=anos;
    }

    //Retorna a data em string no padrao DD/MM/AAAA
    @Override
    public String toString() {
        // TODO Auto-generated method stub
        String output=(this.dia.toString().length()==1)?"0"+this.dia.toString():this.dia.toString();
        output+="/";
        output+=(this.mes.toString().length()==1)?"0"+this.mes.toString():this.mes.toString();
        output+="/";
        output+=(this.ano <0)?(this.ano *-1)+"a.C":this.ano.toString();
        return output;
    }

    /*
    * Esse metodo compara duas datas e retorna -1, 0 ou 1.
    * -1: A data comparada é maior
    * 0: Elas são iguais
    * 1: A maior data é a própria data
    */
    @Override
    public int compareTo(Data o) {
        // TODO Auto-generated method stub
        return Integer.compare(this.getDataEmDias(), o.getDataEmDias());
    }

}
