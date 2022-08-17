import java.util.Timer;
import java.util.TimerTask;

public class Timer_Microondas {

    Timer timer;

    public void iniciarTimer(int minutos, int segundos){

        timer = new Timer();

        if(minutos!=0){

            segundos+=(minutos*60);

        }

        timer.schedule(new EncerrarTimer(), segundos* 1000L);

    }

    public class EncerrarTimer extends TimerTask{
        public void run() {

            System.out.println("Beep, Beep, Beep");
            timer.cancel();

        }
    }

}

