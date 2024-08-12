import javax.swing.*;
import java.util.ArrayList;
import java.util.Date;

public class Main {
    public static void main(String[] args) {
        ArrayList<Evento> eventos = new ArrayList<>();

        Evento moana = new Filme("Moana2", "17:30", "Del Rey", "28/11/2024", 35.00);
        Evento PTOGQJA = new Filme("Para Todos Os Garotos Que Já Amei", "19:30", "Del Rey", "30/8/2024", 15.00);
        Evento UTG = new Teatro("Um Tal Guimarães", "17:30", "Casa De Teatro", "16/08/2024", 45.00);
        Evento orquestra = new Concerto("Orquestra", "16:00", "Sala De Minas", "20/08/2024", 50.00);

        eventos.add(moana);
        eventos.add(PTOGQJA);
        eventos.add(UTG);
        eventos.add(orquestra);

        // Simulação de venda de ingressos
        moana.add_I(new Ingresso(new Date(), 35.00, 'C'));
        moana.add_I(new Vip(new Date(), 35.00)); // Valor base, será multiplicado por 2
        moana.add_I(new Meia_Entrada(new Date(), 35.00)); // Valor base, será dividido por 2

        PTOGQJA.add_I(new Ingresso(new Date(), 15.00, 'C'));
        PTOGQJA.add_I(new Meia_Entrada(new Date(), 15.00)); // Valor base, será dividido por 2

        UTG.add_I(new Ingresso(new Date(), 45.00, 'C'));
        UTG.add_I(new Vip(new Date(), 45.00)); // Valor base, será multiplicado por 2

        orquestra.add_I(new Ingresso(new Date(), 50.00, 'C'));
        orquestra.add_I(new Vip(new Date(), 50.00)); // Valor base, será multiplicado por 2

        // Exibição de Eventos
        listarEventos(eventos);

        // Exibição da receita total acumulada
        exibirReceitaTotalAcumulada(eventos);
    }

    private static void listarEventos(ArrayList<Evento> eventos) {
        for (Evento evento : eventos) {
            double receita = evento.somaTotal_Receita();
            JOptionPane.showMessageDialog(null,
                    String.format("==== Evento ====\nNome: %s\nData: %s\nHora: %s\nLocal: %s\nReceita Total: R$ %.2f\nIngressos Vendidos: %d\nIngressos Disponíveis: %d\n",
                            evento.getNome(), evento.getData(), evento.getHora(), evento.getLocal(), receita, evento.ingressosVendidos(), evento.assentos_Disp()),
                    "Detalhes do Evento", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private static void exibirReceitaTotalAcumulada(ArrayList<Evento> eventos) {
        double receitaTotal = 0;
        for (Evento evento : eventos) {
            receitaTotal += evento.somaTotal_Receita();
        }
        JOptionPane.showMessageDialog(null,
                String.format("Receita Total Acumulada: R$ %.2f", receitaTotal),
                "Receita Total", JOptionPane.INFORMATION_MESSAGE);

        // Exibição dos detalhes dos ingressos vendidos
        for (Evento evento : eventos) {
            if (evento.getNome().equals("Moana2") ||
                    evento.getNome().equals("Para Todos Os Garotos Que Já Amei") ||
                    evento.getNome().equals("Um Tal Guimarães") ||
                    evento.getNome().equals("Orquestra")) {
                String detalhes = "Detalhes dos Ingressos para o Evento " + evento.getNome() + ":\n";
                for (Ingresso ingresso : evento.ingressos_V) {
                    detalhes += ingresso.toString() + "\n";
                }
                JOptionPane.showMessageDialog(null, detalhes, "Ingressos Vendidos", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }
}

