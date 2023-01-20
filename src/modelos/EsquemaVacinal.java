package modelos;

import enums.Vacinas;

import java.time.LocalDate;

public class EsquemaVacinal {
    private LocalDate data;
    private Vacinas vacina;
    private String observacoes;

    public EsquemaVacinal(LocalDate data, Vacinas vacina, String observacoes) {
        this.data = data;
        this.vacina = vacina;
        this.observacoes = observacoes;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public Vacinas getVacina() {
        return vacina;
    }

    public void setVacina(Vacinas vacina) {
        this.vacina = vacina;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    @Override
    public String toString() {
        return "EsquemaVacinal{" +
                "data=" + data +
                ", vacina=" + vacina +
                ", observacoes='" + observacoes + '\'' +
                '}';
    }
}
