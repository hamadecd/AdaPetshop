package modelos;

import java.util.ArrayList;
import java.util.List;

public class Clientes extends Pessoa {
    private int id;
    private List<Animais> pets = new ArrayList<>();

    public Clientes() {};

    public Clientes(int id, List<Animais> pets, String nome, String cpf, String email, String telefone, Endereco endereco) {
        super(nome, cpf, email, telefone, endereco);
        this.id = id;
        this.pets = pets;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Animais> getPets() {
        return pets;
    }

    public void setPets(List<Animais> pets) {
        this.pets = pets;
    }

    @Override
    public String toString() {

        return "Clientes{" +
                "id=" + id +
                ", nome=" + this.getNome() +
                ", pets=" + pets +
                '}';
    }
}
