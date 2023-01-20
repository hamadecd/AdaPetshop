import enums.EstadoAnimal;
import enums.Higiene;
import enums.Porte;
import enums.Vacinas;
import modelos.*;
import vo.ResponseVO;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Petshop petshop = new Petshop();

        // ************ Esquema Vacinal *******************
        EsquemaVacinal esquemaVacinal1 = new EsquemaVacinal(LocalDate.of(2023, 1, 19), Vacinas.VACINA_1, "Vacina 1");
        EsquemaVacinal esquemaVacinal2 = new EsquemaVacinal(LocalDate.of(2022, 2, 15), Vacinas.VACINA_2, "Vacina 2");
        EsquemaVacinal esquemaVacinal3 = new EsquemaVacinal(LocalDate.of(2021, 3, 13), Vacinas.VACINA_3, "Vacina 3");
        EsquemaVacinal esquemaVacinal4 = new EsquemaVacinal(LocalDate.of(2020, 1, 14), Vacinas.VACINA_4, "Vacina 4");
        EsquemaVacinal esquemaVacinal5 = new EsquemaVacinal(LocalDate.of(2019, 5, 29), Vacinas.VACINA_5, "Vacina 5");
        List<EsquemaVacinal> esquemaVacinalList = Arrays.asList(esquemaVacinal1, esquemaVacinal2, esquemaVacinal3, esquemaVacinal4, esquemaVacinal5);
        List<EsquemaVacinal> esquemaVacinalList1 = Arrays.asList(esquemaVacinal3, esquemaVacinal4, esquemaVacinal5);

        // ************ Animais *******************
        Gato gato1 = new Gato("Videl", LocalDate.of(2021, Month.MAY, 10), "Siamês", Porte.MEDIO, 2.0, EstadoAnimal.SUJO, esquemaVacinalList, "Manhosa");
        Gato gato2 = new Gato("Neguinha", LocalDate.of(2021, Month.SEPTEMBER, 6), "SRD", Porte.PEQUENO, 1.8, EstadoAnimal.NORMAL, esquemaVacinalList, "Brincalhona");
        Gato gato3 = new Gato("Xaninha", LocalDate.of(2021, Month.FEBRUARY, 2), "SRD", Porte.PEQUENO, 1.5, EstadoAnimal.NORMAL, esquemaVacinalList, "Não gosta que pega");
        Cachorro cachorro1 = new Cachorro("Billy", LocalDate.of(2019, Month.NOVEMBER, 9), "Blue Heeler", Porte.MEDIO, 20.0, EstadoAnimal.LIMPO, esquemaVacinalList1, null);
        List<Animais> animaisList1 = Arrays.asList(gato1,gato2, gato3);
        List<Animais> animaisList2 = Arrays.asList(cachorro1);

        // ************ Clientes *******************
        Clientes cliente1 = new Clientes(1, animaisList1, "Samir", "08906194587", "samir@hotmail.com", "037998046256",
                new Endereco("Rua Principal", "Único", "casa", 666, "38900-666", "Córrego Danta", "MM", "Lugar nenhum"));
        Clientes cliente2 = new Clientes(2, animaisList2, "Fulano", "08906194587", "fulano@hotmail.com", "037998046256",
                new Endereco("Rua Maranhão", "Bairro Grande", "apartamento 1", 777, "38900-666", "Sá Paulo", "GG", "Lugar nenhum"));

        // ************ Testes cliente com um Pet *******************
//        ResponseVO atendimentoClinico = petshop.atendimentoClinico(cliente2, cliente2.getPets(), "Tomar vacina 2");
//        System.out.println(atendimentoClinico.toString());
        ResponseVO higienizar = petshop.higienizar(cliente2, cliente2.getPets(), Higiene.BANHO, null);
//        System.out.println(higienizar);
        List<Vacinas> vacinas = Arrays.asList(Vacinas.VACINA_4);
        System.out.println(cliente2.toString());

//        ResponseVO higienizar = petshop.higienizar(cliente1, cliente1.getPets(), Higiene.BANHO, null);
    }
}