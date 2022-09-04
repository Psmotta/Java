public class Veiculo {

    private String tipo;
    private String marca;
    private String modelo;
    private double kmRodado;
    private double tanqueDoCarroTotal;
    private double kmPorLitro;
    private Data dataDeCompra;
    private double valorTotalAbastecido;

    //Construtor da classe Veiculo
    public Veiculo(String tipo, String marca, String modelo, Data dataDeCompra, int kmRodado, double tanqueDoCarroTotal){
        setTipo(tipo);
        setMarca(marca);
        setModelo(modelo);
        setKmRodado(kmRodado);
        setTanqueDoCarroTotal(tanqueDoCarroTotal);
        setDataDeCompra(dataDeCompra);
    }

    //Metodos set
    private void setMarca(String marca) {
        this.marca = marca;
    }
    private void setModelo(String modelo) {
        this.modelo = modelo;
    }
    private void setTipo(String tipo) {
        this.tipo = tipo;
    }
    private void setTanqueDoCarroTotal(double tanqueDoCarroTotal) {
        this.tanqueDoCarroTotal = tanqueDoCarroTotal;
    }
    private void setKmRodado(int kmRodado) {
        this.kmRodado = kmRodado;
    }
    private void setKmPorLitro(double kmPorLitro) {
        this.kmPorLitro = kmPorLitro;
    }
    private void setDataDeCompra(Data dataDeCompra) {
        this.dataDeCompra = dataDeCompra;
    }

    //Metodos get
    public double getKmPorLitro() {
        return kmPorLitro;
    }
    public double getKmRodado() {
        return kmRodado;
    }
    public double getValorTotalAbastecido() {
        return valorTotalAbastecido;
    }

    //Metodos Veiculo
    public void registrarConsumoEmKmPorLitros(double distanciaTotal){

        setKmPorLitro(distanciaTotal/tanqueDoCarroTotal);

    }
    public void calcularKmRodadoDoVeiculo(double distanciaPercorrida){

        kmRodado+=distanciaPercorrida;

    }
    public double calcularKmMediaEntreDuasRotas(double rota1, double rota2){

        return (rota1 + rota2) / 2;

    }
    public void abastecerVeiculo(double precoGasolina){

        valorTotalAbastecido+= tanqueDoCarroTotal*precoGasolina;

    }

    @Override
    public String toString() {
        return "TIPO: " + tipo +
        ", MARCA: " + marca +
        ", MODELO: " + modelo +
        ", CONSUMO: " + kmPorLitro + " Km/L" +
        ", KM RODADO: " + kmRodado +
        ", COMPRA: " + dataDeCompra;
    }
}
