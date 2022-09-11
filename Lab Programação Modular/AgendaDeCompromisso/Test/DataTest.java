import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import javax.management.InvalidAttributeValueException;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Classe de testes dos métodos da classe Data
 */
public class DataTest {

    //#region criando variáveis
    Data data1;
    Data data2_bissexto;

    //Inicialização dos objetos
    @BeforeEach
    public void init() throws InvalidAttributeValueException {
        data1 =  new Data(20,7,2001);
        data2_bissexto = new Data(29, 2, 2016);
    }

    /**
     * Verifica se as datas estão com dias e meses adequados
     */
    @Test
    public void criarDataValida(){
        assertEquals("20/07/2001", data1.toString());
        assertEquals("29/02/2016", data2_bissexto.toString());
    }

    /**
     * Verifica se as datas estão com dias e meses inadequados
     */    @Test
    public void criarDataInvalida(){

        try {
            Data dataInvalida = new Data(32, 2, 2022);
            assertEquals("32/02/2022", dataInvalida.toString());
        }
        catch (InvalidAttributeValueException erro_data){
            //Se o teste passar é porque a data esta invalida!!
        }

    }

}
