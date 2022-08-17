public class Microondas {

    private final Timer_Microondas timer_microondas = new Timer_Microondas();

    public void ligarMicrioondas(int minutos, int segundos){


        timer_microondas.iniciarTimer(minutos, segundos);

    }

    public void desligarMicroondas(){

        timer_microondas.timer.cancel();

    }

}
