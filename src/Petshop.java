import enums.EstadoAnimal;
import enums.Higiene;
import enums.Servicos;
import enums.Vacinas;
import modelos.*;
import vo.ResponseVO;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

public class Petshop {
    private final int HIGIENIZAR = 1;
    private final int ATENDIMENTO = 2;
    private final int VACINACAO = 3;

    private String cnpj;
    private Endereco endereco;

    private static List<Remedio> remedioList = criarListaRemedios();
    private static List<Alimentos> alimentosList = criarListaAlimentos();

    private static List<Alimentos> criarListaAlimentos() {
        var alimento1 = new Alimentos(1, "Ração de carne", new BigDecimal("35.0"));
        var alimento2 = new Alimentos(2, "Petisco", new BigDecimal("15.0"));
        var alimento3 = new Alimentos(3, "Ração para animal castrado", new BigDecimal("50.0"));
        var alimento4 = new Alimentos(4, "Ração úmida", new BigDecimal("45.0"));
        var alimento5 = new Alimentos(5, "Ração de frango", new BigDecimal("35.0"));
        return Arrays.asList(alimento1, alimento2, alimento3, alimento4, alimento5);
    }

    private static List<Remedio> criarListaRemedios() {
        var remedio1 = new Remedio(1, "Isoflurano", new BigDecimal("35.0"));
        var remedio2 = new Remedio(2, "Sevoflurano", new BigDecimal("45.0"));
        var remedio3 = new Remedio(3, "Hidroxizina", new BigDecimal("25.0"));
        var remedio4 = new Remedio(4, "Clorfenamina", new BigDecimal("15.0"));
        var remedio5 = new Remedio(5, "Dextrano", new BigDecimal("10.0"));
        return Arrays.asList(remedio1, remedio2, remedio3, remedio4, remedio5);
    }

    public ResponseVO higienizar(Clientes cliente, List<Animais> animal, Higiene higiene, String observacao) {
        // retornar o id do servico, o nome dele, o valor e a classe cliente

        for (int i = 0; i < animal.size(); i++) {
            switch (higiene) {
                case TOSA:
                    animal.get(i).setEstadoAnimal(EstadoAnimal.TOSADO);
                    break;
                case BANHO:
                    animal.get(i).setEstadoAnimal(EstadoAnimal.LIMPO);
                    break;
                case BANHO_E_TOSA:
                    animal.get(i).setEstadoAnimal(EstadoAnimal.LIMPO_E_TOSADO);
                    break;
            }
        }
        BigDecimal valor = BigDecimal.valueOf(animal.size());
        return new ResponseVO(HIGIENIZAR, Servicos.HIGIENIZAR, new BigDecimal("100").multiply(valor), cliente);
    }

    public ResponseVO atendimentoClinico(Clientes cliente, List<Animais> animal, String observacao) {
        animal.get(0).setObservacoes(observacao);
        return new ResponseVO(ATENDIMENTO, Servicos.ATENDIMENTO_CLINICO, new BigDecimal("300.0"), cliente);
    }

    public ResponseVO vacinacao(Clientes cliente, List<Vacinas> vacina, Higiene higiene, String observacao) {
        //Só pode receber uma vacina por animal e deve retornar o id do servico, o nome dele, o valor e a classe cliente




        ResponseVO responseVO = new ResponseVO(VACINACAO, Servicos.VACINACAO, new BigDecimal("50"), cliente);
        return null;
    }

    public void verAlimentos() {
        alimentosList.forEach(alimentos -> System.out.println(alimentos));
    }

    public void verRemedios() {
        remedioList.forEach(remedio -> System.out.println(remedio));
    }

    public void pagamentos(List<Integer> itens) {

    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    @Override
    public String toString() {
        return "Petshop{" +
                "cnpj='" + cnpj + '\'' +
                ", endereco=" + endereco +
                '}';
    }
}
