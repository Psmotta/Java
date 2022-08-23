public class Porta {

    private boolean porta_microondas=false;
    private boolean trava;

    public void abrirPorta(){
        if(!trava){
            porta_microondas = true;
        }else{
            throw new RuntimeException("Porta Travada!");
        }

    }

    public void fecharPorta(){
        porta_microondas = false;
    }

    public void travarTrava(){
        trava=true;
    }

    public void destravarTrava(){
        trava=false;
    }

    public boolean verificarPortaAbertaOuFechada(){
        return porta_microondas;
    }

}
