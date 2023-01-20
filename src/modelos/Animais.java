package modelos;

import enums.EstadoAnimal;
import enums.Porte;

import java.time.LocalDate;
import java.util.List;

public abstract class Animais {
    private String nome;
    private LocalDate nascimento;
    private String raca;
    private Porte porte;
    private double peso;
    private EstadoAnimal estadoAnimal;
    private List<EsquemaVacinal> vacinas;
    private String observacoes;

    public Animais() {};

    public Animais(String nome, LocalDate nascimento, String raca, Porte porte, double peso, EstadoAnimal estadoAnimal, List<EsquemaVacinal> vacinas, String observacoes) {
        this.nome = nome;
        this.nascimento = nascimento;
        this.raca = raca;
        this.porte = porte;
        this.peso = peso;
        this.estadoAnimal = estadoAnimal;
        this.vacinas = vacinas;
        this.observacoes = observacoes;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getNascimento() {
        return nascimento;
    }

    public void setNascimento(LocalDate nascimento) {
        this.nascimento = nascimento;
    }

    public String getRaca() {
        return raca;
    }

    public void setRaca(String raca) {
        this.raca = raca;
    }

    public Porte getPorte() {
        return porte;
    }

    public void setPorte(Porte porte) {
        this.porte = porte;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public EstadoAnimal getEstadoAnimal() {
        return estadoAnimal;
    }

    public void setEstadoAnimal(EstadoAnimal estadoAnimal) {
        this.estadoAnimal = estadoAnimal;
    }

    public List<EsquemaVacinal> getVacinas() {
        return vacinas;
    }

    public void setVacinas(List<EsquemaVacinal> vacinas) {
        this.vacinas = vacinas;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    @Override
    public String toString() {
        return "Animais{" +
                "nome='" + nome + '\'' +
                ", nascimento=" + nascimento +
                ", raca='" + raca + '\'' +
                ", porte=" + porte +
                ", peso=" + peso +
                ", estadoAnimal=" + estadoAnimal +
                ", vacinas=" + vacinas +
                ", observacoes='" + observacoes + '\'' +
                '}';
    }
}
