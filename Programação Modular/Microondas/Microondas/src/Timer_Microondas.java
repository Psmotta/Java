public class Timer_Microondas {

    private int segundos;
    private int minutos;
    private boolean pausado;

    //Contrutos da classes Timer
    public Timer_Microondas(int minutos, int segundos){

        setMinutos(minutos);
        setSegundos(segundos);

    }

    //Metodos set
    private void setSegundos(int segundos) {
        this.segundos = segundos;
    }
    private void setMinutos(int minutos) {
        this.minutos = minutos;
    }
    private void setPausado(boolean pausado) {
        this.pausado = pausado;
    }

    //Metodos get
    public boolean getPausado(){ return pausado; }

    //Metodos da classe timer
    public void iniciarTimer(){

        //Aqui iniciaria o timer

    }

    public void desligarTimer(){

        //Aqui desligaria o timer

    }

    public void pausarTimer(){

        setPausado(true);
        //Aqui pausaria o timer

    }

    public void retomarTimer(){

        setPausado(false);
        //Aqui retomaria o timer

    }

    public void atualizarTimer(int minutos, int segundos){

        setMinutos(minutos);
        setSegundos(segundos);

    }

}

