public class Microondas{

    private int minutos = 0;
    private int segundos = 0;
    private boolean ligado;
    private Timer_Microondas timer_microondas;
    private final Porta porta = new Porta();
    private final Luz luz = new Luz();
    private final BaseGiratoria baseGiratoria = new BaseGiratoria();

    //Metodos set
    public void setMinutos(int minutos) {
        this.minutos = minutos;
    }
    public void setSegundos(int segundos) {
        this.segundos = segundos;
    }
    public void setLigado(boolean ligado) {
        this.ligado = ligado;
    }

    //Metodos get
    public int getMinutos() {
        return minutos;
    }
    public int getSegundos() {
        return segundos;
    }
    public boolean getLigado(){ return ligado; }
    public boolean getPauseTimer(){ return timer_microondas.getPausado(); }

    //Metodos Microondas
    public void ligarMicrioondas(){

        if(!portaEstaAberta()){

            if(minutos == 0 && segundos == 0){
                setSegundos(30);
            }
            timer_microondas.iniciarTimer();
            setLigado(true);
            porta.travarTrava();
            luz.ascenderLuz();
            baseGiratoria.girarBase();

        }
        else{
            throw new RuntimeException("Porta Aberta!");
        }

    }

    public void desligarMicroondas(){

        setLigado(false);
        porta.destravarTrava();
        baseGiratoria.desligarBase();
        luz.desligarLuz();
        timer_microondas.desligarTimer();

    }

    public void pausarMicroondas(){

        if(ligado){

            setLigado(false);
            timer_microondas.pausarTimer();

        }
        else{
            throw new RuntimeException("Nao esta ligado");
        }
    }

    public void retomarMicroondas(){

        if(getPauseTimer()){
            setLigado(true);
            timer_microondas.retomarTimer();
        }
        else throw new RuntimeException("Microondas nao foi pausado");
    }

    public void abrirPorta(){
        if(!ligado){
            porta.abrirPorta();
        }
        else throw new RuntimeException("Microondas esta ligado!");

    }

    public void fecharPorta(){
        porta.fecharPorta();
    }

    private boolean portaEstaAberta(){
        return porta.verificarPortaAbertaOuFechada();
    }

    public void escolherTempoMicroondas(int minutos, int segundos){

            setMinutos(minutos);
            setSegundos(segundos);
            timer_microondas = new Timer_Microondas(minutos, segundos);

    }

    public void atualizarTempoMicroondas(int minutos, int segundos){

        if(ligado){
            setMinutos(minutos);
            setSegundos(segundos);
            timer_microondas.atualizarTimer(minutos, segundos);
        }
        //Caso de esse erro, voce apenas deve utilizar a funcao escolherTempoMicroondas para setar o tempo
        else throw new RuntimeException("Nao esta ligado para ter que atualizar o tempo, apenas digite o tempo");


    }

    public void verificarDesligarQuandoTempoZerar(){

        if(ligado){
            if(minutos == 0 && segundos == 0){
                desligarMicroondas();
            }
        }

    }

}
