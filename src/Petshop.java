import enums.EstadoAnimal;
import enums.Higiene;
import enums.Servicos;
import enums.Vacinas;
import modelos.*;
import vo.ResponseVO;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Petshop {
    private final int HIGIENIZAR = 1;
    private final int ATENDIMENTO = 2;
    private final int VACINACAO = 3;

    private String cnpj;
    private Endereco endereco;

    private static List<Remedio> remedioList = criarListaRemedios();
    private static List<Alimentos> alimentosList = criarListaAlimentos();

    private static List<Alimentos> criarListaAlimentos() {
        var alimento1 = new Alimentos(11, "Ração de carne", new BigDecimal("35.0"));
        var alimento2 = new Alimentos(12, "Petisco", new BigDecimal("15.0"));
        var alimento3 = new Alimentos(13, "Ração para animal castrado", new BigDecimal("50.0"));
        var alimento4 = new Alimentos(14, "Ração úmida", new BigDecimal("45.0"));
        var alimento5 = new Alimentos(15, "Ração de frango", new BigDecimal("35.0"));
        return Arrays.asList(alimento1, alimento2, alimento3, alimento4, alimento5);
    }

    private static List<Remedio> criarListaRemedios() {
        var remedio1 = new Remedio(21, "Isoflurano", new BigDecimal("35.0"));
        var remedio2 = new Remedio(22, "Sevoflurano", new BigDecimal("45.0"));
        var remedio3 = new Remedio(23, "Hidroxizina", new BigDecimal("25.0"));
        var remedio4 = new Remedio(24, "Clorfenamina", new BigDecimal("15.0"));
        var remedio5 = new Remedio(25, "Dextrano", new BigDecimal("10.0"));
        return Arrays.asList(remedio1, remedio2, remedio3, remedio4, remedio5);
    }

    public ResponseVO higienizar(Clientes cliente, List<Animais> animais, Higiene higiene, String observacao) {
        // retornar o id do servico, o nome dele, o valor e a classe cliente

        for (int i = 0; i < animais.size(); i++) {
            switch (higiene) {
                case TOSA:
                    animais.get(i).setEstadoAnimal(EstadoAnimal.TOSADO);
                    break;
                case BANHO:
                    animais.get(i).setEstadoAnimal(EstadoAnimal.LIMPO);
                    break;
                case BANHO_E_TOSA:
                    animais.get(i).setEstadoAnimal(EstadoAnimal.LIMPO_E_TOSADO);
                    break;
            }
        }
        BigDecimal quantidade = BigDecimal.valueOf(animais.size());
        return new ResponseVO(HIGIENIZAR, Servicos.HIGIENIZAR, new BigDecimal("100").multiply(quantidade), cliente);
    }

    public ResponseVO atendimentoClinico(Clientes cliente, List<Animais> animais, String observacao) {
        // retornar resultado do atendimento no campo Observação do próprio animal além do id do servico, o nome dele, o valor e a classe cliente
        Random random = new Random();

        try {
            for (int i = 0; i < animais.size(); i++) {
                int aleatorio = random.nextInt(1, 6);
                switch (aleatorio) {
                    case 1:
                        animais.get(i).setObservacoes(String.valueOf(Vacinas.VACINA_1));
                        break;
                    case 2:
                        animais.get(i).setObservacoes(String.valueOf(Vacinas.VACINA_2));
                        break;
                    case 3:
                        animais.get(i).setObservacoes(String.valueOf(Vacinas.VACINA_3));
                        break;
                    case 4:
                        animais.get(i).setObservacoes(String.valueOf(Vacinas.VACINA_4));
                        break;
                    case 5:
                        animais.get(i).setObservacoes(String.valueOf(Vacinas.VACINA_5));
                        break;
                }
            }
        } catch (Exception e) {
            System.err.println("Não foi possível fazer atendimento clínico, verifique as informações.\n" + e.getMessage());
        }
        return new ResponseVO(ATENDIMENTO, Servicos.ATENDIMENTO_CLINICO, new BigDecimal("300").multiply(BigDecimal.valueOf(animais.size())), cliente);
    }

    public ResponseVO vacinacao(Clientes cliente, List<Animais> animais, List<Vacinas> vacinas, String observacao) {
        //Só pode receber uma vacina por animal e deve retornar o id do servico, o nome dele, o valor e a classe cliente

        for (int i = 0; i < animais.size(); i++) {
            List<EsquemaVacinal> esquemaVacinalList = Arrays.asList(new EsquemaVacinal(LocalDate.now(), vacinas.get(i), "VACINADO"));
            animais.get(i).setVacinas(esquemaVacinalList);
        }

        BigDecimal quantidade = BigDecimal.valueOf(animais.size());
        return new ResponseVO(VACINACAO, Servicos.VACINACAO, new BigDecimal("50").multiply(quantidade), cliente);
    }

    public void verAlimentos() {
        alimentosList.forEach(alimentos -> System.out.println(alimentos));
    }

    public void verRemedios() {
        remedioList.forEach(remedio -> System.out.println(remedio));
    }

    public void pagamentos(List<Integer> itens) {
        BigDecimal valor = BigDecimal.ZERO;
        for (int i = 0; i < itens.size(); i++) {
            switch (itens.get(i)) {
                case 1:
                    valor = valor.add(new BigDecimal("100"));
                    break;
                case 2:
                    valor = valor.add(new BigDecimal("300"));
                    break;
                case 3:
                    valor = valor.add(new BigDecimal("50"));
                    break;
                case 11:
                    valor = valor.add(new BigDecimal("35"));
                    break;
                case 12:
                    valor = valor.add(new BigDecimal("15"));
                    break;
                case 13:
                    valor = valor.add(new BigDecimal("50"));
                    break;
                case 14:
                    valor = valor.add(new BigDecimal("45"));
                    break;
                case 15:
                    valor = valor.add(new BigDecimal("35"));
                    break;
                case 21:
                    valor = valor.add(new BigDecimal("35"));
                    break;
                case 22:
                    valor = valor.add(new BigDecimal("45"));
                    break;
                case 23:
                    valor = valor.add(new BigDecimal("25"));
                    break;
                case 24:
                    valor = valor.add(new BigDecimal("15"));
                    break;
                case 25:
                    valor = valor.add(new BigDecimal("10"));
                    break;
            }
        }
        System.out.print(valor + "\n");
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
