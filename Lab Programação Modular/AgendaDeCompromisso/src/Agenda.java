import javax.management.InvalidAttributeValueException;
import java.util.ArrayList;

public class Agenda {

    //#region variaveis para uso do construtor
    private final ArrayList<Data> datas = new ArrayList<>();
    private final ArrayList<String> compromissos = new ArrayList<>();
    private int quantidadeCompromissosNaLista=0;

    /**
     *
     * @param compromisso recebe o título do compromisso
     * @param data recebe a data correspondente
     * @param repetirCada_X_Dias dias para repetições
     * @param qtdeVezesCompromisso quantidade de repetições
     * @throws InvalidAttributeValueException valida se houve inserção de dados incorretos
     */
    public void addCompromisso(String compromisso, Data data, int repetirCada_X_Dias, int qtdeVezesCompromisso) throws InvalidAttributeValueException {

        for(int i=0; i<qtdeVezesCompromisso; i++){

            int dia = data.getDia();
            int mes = data.getMes();
            int ano = data.getAno();

            Data data_auxiliar = new Data(dia, mes, ano);

            datas.add(data_auxiliar);
            compromissos.add(compromisso);
            quantidadeCompromissosNaLista++;
            data.addDias(repetirCada_X_Dias);
        }


    }

    /**
     * Método que prepara o envio dos compromissos formatados
     * @return datas, compromisos, repetições
     */
    public String verTodosCompromissos(){

        StringBuilder output = new StringBuilder();
        for(int i = 0, z = 1; i< quantidadeCompromissosNaLista; i++, z++){
            output.append(z);
            output.append("-");
            output.append(compromissos.get(i));
            output.append(", ");
            output.append(datas.get(i));
            output.append("\n");
        }

        return output.toString();

    }

    /**
     Método que especifica compromissos entre datas
     * @param dataInicial data de inicio para verificação
     * @param dataFinal data final para verificação
     * @return quais são os compromissos
     */
    public String listarCompromissosEntreDuasDatas(Data dataInicial, Data dataFinal) {

        StringBuilder output = new StringBuilder();

        for (int i =0; i<datas.size(); i++ ){

            if(datas.get(i).compareTo(dataInicial) >= 0) {
                if(dataFinal.compareTo(datas.get(i)) >= 0) {

                    output.append("Compromisso - ")
                          .append(compromissos.get(i))
                          .append(": ")
                          .append(datas.get(i))
                          .append("\n");

                }
            }        
        }

        return output.toString();

    }

}
