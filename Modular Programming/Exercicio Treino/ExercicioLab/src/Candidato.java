import java.util.Arrays;

public class Candidato {

    private String nome;
    private int[] habilidades;
    public Candidato(String nome, int[] habilidades){

        setNome(nome);
        setHabilidades(habilidades);

    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setHabilidades(int[] habilidades) {
        this.habilidades = habilidades;
    }

    public String getNome() {
        return nome;
    }

    public int[] getHabilidades() {
        return habilidades;
    }

    @Override
    public String toString() {
        return "\nNome: " + nome +
                "\nHabilidade: " + Arrays.toString(habilidades) +
                "\n";
    }
}
