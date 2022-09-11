import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import javax.management.InvalidAttributeValueException;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class AgendaTest {

    //#region criando variáveis
    Data data1;
    Data data2;
    Data data3;
    Data data4;
    Data data5;
    
    Agenda agenda = new Agenda();

    //Inicialização dos construtores
    @BeforeEach
    public void init() throws InvalidAttributeValueException {
        data1 = new Data(20, 7,2022);
        data2 = new Data(19, 12, 2022);
        data3 = new Data(15, 10, 2022);
        data4 = new Data(19, 10, 2022);
        data5 = new Data(15, 11, 2022);

        //Adciona os compromissos na lista incluindo a data
        agenda.addCompromisso("Dentista", data1, 2, 2);
        agenda.addCompromisso("Ir ao mercado", data2, 0, 1);
        agenda.addCompromisso("Reuniao", data3, 0, 1);
        agenda.addCompromisso("Casamento", data4, 0, 1);
        agenda.addCompromisso("Viagem", data5, 0, 1);

    }

    //Verifica se os compromissos foram adicionados na lista de forma correta
    @Test
    public void verCompromissosNaLista(){

        assertEquals("""
                    1-Dentista, 20/07/2022
                    2-Dentista, 22/07/2022
                    3-Ir ao mercado, 19/12/2022
                    4-Reuniao, 15/10/2022
                    5-Casamento, 19/10/2022
                    6-Viagem, 15/11/2022
                    """, agenda.verTodosCompromissos());

    }

                     
     //Verifica os compromissos na lista entre as datas iniciais e finais escolhidas pelo usuario
    @Test
    public void listarCompromissosEntreDuasDatas(){

        assertEquals("""
                    Compromisso - Reuniao: 15/10/2022
                    Compromisso - Casamento: 19/10/2022
                    Compromisso - Viagem: 15/11/2022
                    """, agenda.listarCompromissosEntreDuasDatas(data3, data5));

        }

}

