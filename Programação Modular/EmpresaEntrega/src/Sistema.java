import java.util.ArrayList;

public class Sistema {

    private final ArrayList<Veiculo> veiculosRegistrados = new ArrayList<>();

    public void registrarAquisicaoVeiculo(Veiculo veiculo){

        veiculosRegistrados.add(veiculo);

    }

    public String verificarListaCompletaVeiculosRegistrados(){

        StringBuilder output = new StringBuilder();

        for(int i=0, z=1; i<veiculosRegistrados.size(); i++, z++){
            output.append(z);
            output.append("-");
            output.append(veiculosRegistrados.get(i));
            output.append("\n");
        }

        return output.toString();
    }

}
