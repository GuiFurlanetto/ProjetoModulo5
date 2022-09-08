import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static void main (String [] args) throws IOException {

         //Path path = Paths.get("CampeonatoBrasileiro.txt");
         // Path path = Paths.get("C:/GUILHERME/ESTUDOS/Lets Code/Modulo 5 - Tecnicas de Programação/Projeto/CampeonatoBrasileiro.txt");

        Stream<Path> arquivo = Files.list(Path.of("C:/GUILHERME/ESTUDOS/Lets Code/Modulo 5 - Tecnicas de Programação/Projeto"));
        arquivo.forEach(partida -> {
            try {
//                1.Quantas partidas aconteceram no total?
                System.out.println(partida);
                Long contarid = Files.lines(partida.toAbsolutePath())
                        .skip(1)
                        .map(dados -> mapToDados(dados))
                        .mapToInt(dados -> dados.getID())
                        .count();
                System.out.println( "1. Quantas partidas aconteceram no total?");
                System.out.println(contarid);
                System.out.println("-------");

//                2.Quantos gols tiveram no total?
                Integer totalGols = Files.lines(partida.toAbsolutePath())
                        .skip(1)
                        .map(dados -> mapToDados(dados))
                        .mapToInt(gol -> gol.getMandante_placar() + gol.getVisitante_placar())
                        .sum();
                System.out.println( "2. Quantos gols tiveram no total?");
                System.out.println(totalGols);
                System.out.println("-------");

//                3.Quantas partidas ocorreram ente 2010 e 2015?
                Map<Object, Long> jogos = Files.lines(partida.toAbsolutePath())
                        .skip(1)
                        .map(dados -> mapToDados(dados))
                        .collect(Collectors.groupingBy(dados -> dados.getData().getYear(), Collectors.counting()));

                System.out.println( "3. Quantas partidas ocorreram ente 2010 e 2015?");
                System.out.println(jogos);
                System.out.println("-------");

                //4.Qual o jogo que teve mais gols no campeonato?
                Optional<Dados> maxgols = Files.lines(partida.toAbsolutePath())
                        .skip(1)
                        .map(dados -> mapToDados(dados))
                        .max((gol1, gol2) -> gol1.getVisitante_placar().compareTo(gol2.getMandante_placar()));

                System.out.println( "4. Qual o jogo que teve mais gols no campeonato?");
                System.out.println(maxgols.get().getMandante() + " - " + maxgols.get().getMandante_placar() + " x " +
                        maxgols.get().getVisitante_placar() + " - " + maxgols.get().getVisitante());
                System.out.println("-------");

                //               5.Qual o time que fez mais gols?
                Map<Object, Long> timemaxgols = Files.lines(partida.toAbsolutePath())
                        .skip(1)
                        .map(dados -> mapToDados(dados))
                        .collect(Collectors.groupingBy(dados -> dados.getVisitante_placar() + dados.getMandante_placar(),Collectors.counting()));

                System.out.println( "5. Qual o time que fez mais gols?");
                System.out.println(timemaxgols);
                System.out.println("-------");

//                7.Qual o time teve mais vitórias?
                Map<String, Long> timemaxvitora = Files.lines(partida.toAbsolutePath())
                        .skip(1)
                        .map(dados -> mapToDados(dados))
                        .collect(Collectors.groupingBy(dados-> dados.getVencedor(), Collectors.counting()));

                System.out.println( "7. Qual o time teve mais vitórias?");
                System.out.println(timemaxvitora);

            }catch ( Exception e ){
                e.printStackTrace();
            }
        });

    }
    private static Dados mapToDados (String dados) {
        String[] data = dados.split(",");
        Dados d = new Dados();
        d.setID(Integer.parseInt(data[0]));
        d.setRodada(Integer.parseInt(data[1]));
        d.setData(LocalDate.parse(data[2]));
        d.setHora(LocalTime.parse(data[3]));
        d.setDia(data[4]);
        d.setMandante(data[5]);
        d.setVisitante(data[6]);
        d.setVencedor(data[11]);
        d.setMandante_placar(Integer.valueOf(data[13]));
        d.setVisitante_placar(Integer.valueOf(data[14]));
        d.setEstado_vencedor(data[17]);
        d.toString();
        return d;
    }

    }




