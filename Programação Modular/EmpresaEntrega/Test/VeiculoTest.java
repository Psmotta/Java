import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import javax.management.InvalidAttributeValueException;

public class VeiculoTest {

    Sistema sistema;
    Veiculo veiculo1;
    Veiculo veiculo2;
    Data data1;
    Data data2;

    //Inicia os objetos e variaveis necessarios para os testes
    @BeforeEach
    public void init() throws InvalidAttributeValueException {

        sistema = new Sistema();
        data1 = new Data(20,2,2022);
        data2 = new Data(9,3,2022);
        veiculo1 = new Veiculo("Carro", "Volkswagen", "Gol", data1, 0, 50);
        veiculo2 = new Veiculo("Carro","Toyota","Etios", data2, 0, 60);

    }

    //Teste que verifica a lista de veiculos adquirido pela empresa, return de string
    @Test
    public void verificandoCompra(){

        sistema.registrarAquisicaoVeiculo(veiculo1);
        sistema.registrarAquisicaoVeiculo(veiculo2);

        Assertions.assertEquals("""
                1-TIPO: Carro, MARCA: Volkswagen, MODELO: Gol, CONSUMO: 15.0 Km/L, KM RODADO: 900.0, COMPRA: 20/02/2022
                2-TIPO: Carro, MARCA: Toyota, MODELO: Etios, CONSUMO: 10.0 Km/L, KM RODADO: 650.0, COMPRA: 09/03/2022
                """, sistema.verificarListaCompletaVeiculosRegistrados());

    }

    //Teste para verificar o consumo do carro em Km/L
    @Test
    public void registrarConsumoDoCarroEmKmPorLitro(){

        veiculo1.registrarConsumoEmKmPorLitros(750);
        veiculo2.registrarConsumoEmKmPorLitros(600);

        Assertions.assertEquals(15, veiculo1.getKmPorLitro());
        Assertions.assertEquals(10, veiculo2.getKmPorLitro());

    }

    //Verifica a quilometragem total do carro
    @Test
    public void verificarKmTotalVeiculo(){

        veiculo1.calcularKmRodadoDoVeiculo(900);
        veiculo2.calcularKmRodadoDoVeiculo(650);

        Assertions.assertEquals(900, veiculo1.getKmRodado());
        Assertions.assertEquals(650, veiculo2.getKmRodado());

    }

    //Calcula a media entre duas rotas realizadas pelo veiculo
    @Test
    public void calcularKmMedia(){

        double rota1 = 340.2;
        double rota2 = 720.5;

        Assertions.assertEquals(530.35, veiculo1.calcularKmMediaEntreDuasRotas(rota1, rota2));

    }

    //Abastece o veiculo e verifica o valor gasto total por todos os abastecimentos
    @Test
    public void abastecerVeiculo(){

        double precoGasolina = 5.0;

        for(int i=0; i<3; i++){
            veiculo1.abastecerVeiculo(precoGasolina);
        }

        Assertions.assertEquals(750, veiculo1.getValorTotalAbastecido());

    }

}
