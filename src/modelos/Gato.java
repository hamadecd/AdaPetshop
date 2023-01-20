package modelos;

import enums.EstadoAnimal;
import enums.Porte;

import java.time.LocalDate;
import java.util.List;

public class Gato extends Animais {

    public Gato() {
    }

    public Gato(String nome, LocalDate nascimento, String raca, Porte porte, double peso, EstadoAnimal estadoAnimal, List<EsquemaVacinal> vacinas, String observacoes) {
        super(nome, nascimento, raca, porte, peso, estadoAnimal, vacinas, observacoes);
    }
}
