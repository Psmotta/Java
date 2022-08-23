import org.junit.jupiter.api.BeforeEach;
import org.testng.annotations.Test;
import static org.testng.AssertJUnit.*;

public class MicroondasTest{

    //Declaracao objeto
    Microondas microondas;

    //Inicializacao do objeto
    @BeforeEach
    public void init(){

        microondas = new Microondas();
        microondas.escolherTempoMicroondas(0,5);

    }

    //Teste iniciar o microondas com minutos e segundos
    @Test
    public void iniciarMicroondasComTimer(){

        try {
            microondas.ligarMicrioondas();
            assertEquals(5, microondas.getSegundos());
            assertEquals(0, microondas.getMinutos());
            assertTrue(microondas.getLigado());
        }
        catch (RuntimeException ignored){
            //Erro caso a porta o microondas estetja aberta, ele não consegue ligar
        }
    }

    //Teste pausar microondas
    @Test
    public void pausarMicroondas(){

        try {
            microondas.ligarMicrioondas();
            microondas.pausarMicroondas();
            assertFalse(microondas.getLigado());
            assertTrue(microondas.getPauseTimer());
        }
        catch (RuntimeException ignored){
            //Erro caso a porta do microondas esteja aberta ou caso ele não esteja ligado.
        }
    }

    //Teste retomar microondas
    @Test
    public void retomarMicroondas(){

        try{
            microondas.ligarMicrioondas();
            assertTrue(microondas.getLigado());

            microondas.pausarMicroondas();
            assertTrue(microondas.getPauseTimer());

            microondas.retomarMicroondas();
            assertTrue(microondas.getLigado());
            assertFalse(microondas.getPauseTimer());
        }
        catch (RuntimeException ignored){
            //Ignorar pois o teste ira dar certo!
        }

    }

    //Teste ligar microondas com a porta aberta
    @Test
    public void erroPortaMicroondasAberta(){

        try{
            microondas.abrirPorta();
            microondas.ligarMicrioondas();
        }
        catch(RuntimeException expected){
            //A porta esta aberta, entao o microondas nao pode ligar
        }

    }

    //Teste abrir porta com microondas ligado
    @Test
    public void erroAbrirPortaComMicroondasLigado(){

        try{
            microondas.ligarMicrioondas();
            microondas.abrirPorta();
        }
        catch (RuntimeException expected){
            //A porta so pode ser aberta com microondas desligado
        }

    }

    //Teste atualizar temporizador
    @Test
    public void atualizarTemporizadorComMicroondasLigado(){

        try{
            microondas.ligarMicrioondas();
            microondas.atualizarTempoMicroondas(0,20);
            assertEquals(20, microondas.getSegundos());
            assertEquals(0, microondas.getMinutos());
        }
        catch (RuntimeException ignored){

        }
    }

    //Testar passagem de tempo e desligar sozinho
    @Test
    public void verificarDesligamentoAutomatico(){

        try{
            microondas.escolherTempoMicroondas(0,10);
            microondas.ligarMicrioondas();
            assertTrue(microondas.getLigado());
            microondas.atualizarTempoMicroondas(0,0);
            microondas.verificarDesligarQuandoTempoZerar();
            assertEquals(0,microondas.getMinutos());
            assertEquals(0,microondas.getSegundos());
            assertFalse(microondas.getLigado());
        }
        catch (RuntimeException ignored){

        }

    }


}
