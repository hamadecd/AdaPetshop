import enums.EstadoAnimal;
import enums.Higiene;
import enums.Porte;
import enums.Vacinas;
import modelos.*;
import vo.ResponseVO;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Main {
    public static void main(String[] args) {

        Petshop petshop = new Petshop();

        // ************ Esquema Vacinal *******************
//        EsquemaVacinal esquemaVacinal1 = new EsquemaVacinal(LocalDate.of(2023, 1, 19), Vacinas.VACINA_1, "Vacina 1");
//        EsquemaVacinal esquemaVacinal2 = new EsquemaVacinal(LocalDate.of(2022, 2, 15), Vacinas.VACINA_2, "Vacina 2");
//        EsquemaVacinal esquemaVacinal3 = new EsquemaVacinal(LocalDate.of(2021, 3, 13), Vacinas.VACINA_3, "Vacina 3");
//        EsquemaVacinal esquemaVacinal4 = new EsquemaVacinal(LocalDate.of(2020, 1, 14), Vacinas.VACINA_4, "Vacina 4");
//        EsquemaVacinal esquemaVacinal5 = new EsquemaVacinal(LocalDate.of(2019, 5, 29), Vacinas.VACINA_5, "Vacina 5");
//        List<EsquemaVacinal> esquemaVacinalList = Arrays.asList(esquemaVacinal1, esquemaVacinal2, esquemaVacinal3, esquemaVacinal4, esquemaVacinal5);
//        List<EsquemaVacinal> esquemaVacinalList1 = Arrays.asList(esquemaVacinal3, esquemaVacinal4, esquemaVacinal5);

        // ************ Animais *******************
        Gato gato1 = new Gato("Videl", LocalDate.of(2021, Month.MAY, 10), "Siamês", Porte.MEDIO, 2.0, EstadoAnimal.SUJO, null, "Manhosa");
        Gato gato2 = new Gato("Neguinha", LocalDate.of(2021, Month.SEPTEMBER, 6), "SRD", Porte.PEQUENO, 1.8, EstadoAnimal.NORMAL, null, "Brincalhona");
        Gato gato3 = new Gato("Xaninha", LocalDate.of(2021, Month.FEBRUARY, 2), "SRD", Porte.PEQUENO, 1.5, EstadoAnimal.NORMAL, null, "Não gosta que pega");
        Cachorro cachorro1 = new Cachorro("Billy", LocalDate.of(2019, Month.NOVEMBER, 9), "Blue Heeler", Porte.MEDIO, 20.0, EstadoAnimal.LIMPO, null, null);
        List<Animais> animaisList1 = Arrays.asList(gato1, gato2, gato3);
        List<Animais> animaisList2 = Arrays.asList(cachorro1);

        // ************ Clientes *******************
        Clientes cliente1 = new Clientes(1, animaisList2, "Fulano", "08906194587", "fulano@hotmail.com", "037998046256",
                new Endereco("Rua Maranhão", "Bairro Grande", "apartamento 1", 777, "38900-666", "Sá Paulo", "GG", "Lugar nenhum"));
        Clientes cliente2 = new Clientes(2, animaisList1, "Samir", "08906194587", "samir@hotmail.com", "037998046256",
                new Endereco("Rua Principal", "Único", "casa", 666, "38900-666", "Córrego Danta", "MM", "Lugar nenhum"));

        // ************ Testes cliente com um Pet *******************

        System.out.println("ATENDIMENTO CLINICO");
        ResponseVO atendimentoClinico = petshop.atendimentoClinico(cliente1, cliente1.getPets(), null);
        for (Animais animal : atendimentoClinico.getCliente().getPets()) {
            System.out.println(animal.getNome() + " - " + animal.getObservacoes() + "\n");
        }
        System.out.println(atendimentoClinico);

//        vacinasList.forEach(vacinas -> System.out.println(vacinas));
        System.out.println("\nVACINAÇÃO\n");
        List<Vacinas> vacinasList = new ArrayList<>();

        for (int i = 0; i < atendimentoClinico.getCliente().getPets().size(); i++) {
            vacinasList.add(Vacinas.valueOf(atendimentoClinico.getCliente().getPets().get(i).getObservacoes()));
        }

        ResponseVO vacinacao = petshop.vacinacao(cliente1, cliente1.getPets(), vacinasList, null);
        for (Animais animal : vacinacao.getCliente().getPets()) {
            System.out.println(animal.getNome() + " - " + animal.getVacinas() + "\n");
        }
        System.out.println(vacinacao);

        System.out.println("\nHIGIENIZAÇÃO\n");
        ResponseVO higienizar = petshop.higienizar(cliente1, cliente1.getPets(), Higiene.BANHO_E_TOSA, null);
        System.out.println(higienizar + "\n");

        System.out.println("************* Lista de Remédios *************");
        petshop.verRemedios();
        System.out.println("************* Lista de Alimentos *************");
        petshop.verAlimentos();

        List<Integer> listaDeItens = new ArrayList<>();
        listaDeItens.add(atendimentoClinico.getId());
        listaDeItens.add(vacinacao.getId());
        listaDeItens.add(higienizar.getId());
        listaDeItens.add(21);
        listaDeItens.add(24);
        System.out.print("\nValor a pagar do cliente que tem apenas um pet: ");
        petshop.pagamentos(listaDeItens);

//      ************ Testes cliente com mais de um Pet *******************

        System.out.println("\nATENDIMENTO CLINICO\n");
        ResponseVO atendimentoClinico2 = petshop.atendimentoClinico(cliente2, cliente2.getPets(), null);
        for (Animais animal : atendimentoClinico2.getCliente().getPets()) {
            System.out.println(animal.getNome() + " - " + animal.getObservacoes() + "\n");
        }
        System.out.println(atendimentoClinico2);

        System.out.println("\nVACINAÇÃO\n");
        List<Vacinas> vacinasList2 = new ArrayList<>();

        for (int i = 0; i < atendimentoClinico2.getCliente().getPets().size(); i++) {
            vacinasList2.add(Vacinas.valueOf(atendimentoClinico2.getCliente().getPets().get(i).getObservacoes()));
        }

        ResponseVO vacinacao2 = petshop.vacinacao(cliente2, cliente2.getPets(), vacinasList2, null);
        System.out.println(vacinacao2);

        System.out.println("\nHIGIENIZAÇÃO\n");
        ResponseVO higienizar2 = petshop.higienizar(cliente2, cliente2.getPets(), Higiene.BANHO, null);
        System.out.println(higienizar2 + "\n");

        System.out.println("************* Lista de Remédios *************");
        petshop.verRemedios();
        System.out.println("************* Lista de Alimentos *************");
        petshop.verAlimentos();

        List<Integer> listaDeItens2 = new ArrayList<>();
        listaDeItens2.add(atendimentoClinico2.getId());
        listaDeItens2.add(atendimentoClinico2.getId());
        listaDeItens2.add(atendimentoClinico2.getId());
        listaDeItens2.add(vacinacao2.getId());
        listaDeItens2.add(vacinacao2.getId());
        listaDeItens2.add(vacinacao2.getId());
        listaDeItens2.add(higienizar2.getId());
        listaDeItens2.add(higienizar2.getId());
        listaDeItens2.add(higienizar2.getId());
        listaDeItens2.add(11);
        listaDeItens2.add(13);
        listaDeItens2.add(22);
        listaDeItens2.add(23);
        System.out.print("\nValor a pagar do cliente que tem mais de um pet: ");
        petshop.pagamentos(listaDeItens2);
    }
}