import java.util.ArrayList;
import javax.swing.*;

public abstract class Evento implements RelatorioReceita {
    private String nome;
    private String hora;
    private String local;
    private double precoIngresso;
    protected int quantiaIngressos;
    private String data;
    protected ArrayList<Ingresso> ingressos_V;

    Evento(String nome, String hora, String local, String data, double precoIngresso) {
        this.nome = nome;
        this.hora = hora;
        this.local = local;
        this.data = data;
        this.precoIngresso = precoIngresso;
        this.ingressos_V = new ArrayList<>();
    }

    public int assentos_Disp() {
        return quantiaIngressos - ingressos_V.size();
    }

    public int ingressosVendidos() {
        return ingressos_V.size();
    }

    public abstract void add_I(Ingresso novo_I);

    public int ingressos_Disp() {
        int quant = 0;
        for (Ingresso atual : this.ingressos_V) {
            if (atual != null && atual.tipo == 'C') {
                quant++;
            }
        }
        return assentos_Disp() - quant;
    }

    public int ingressos_MeiaDisp() {
        int quant = 0;
        for (Ingresso atual : this.ingressos_V) {
            if (atual != null && atual.tipo == 'M') {
                quant++;
            }
        }
        return assentos_Disp() - quant;
    }

    public int ingressos_VipDisp() {
        int quant = 0;
        for (Ingresso atual : this.ingressos_V) {
            if (atual != null && atual.tipo == 'V') {
                quant++;
            }
        }
        return assentos_Disp() - quant;
    }

    @Override
    public double somaTotal_Receita() {
        double somaTotal = 0;
        for (Ingresso ingresso : ingressos_V) {
            if (ingresso != null) {
                somaTotal += ingresso.valor;
            }
        }
        return somaTotal;
    }


    @Override
    public void extrato_Receita() {
        JOptionPane.showMessageDialog(null, toString(), "Detalhes do Evento", JOptionPane.INFORMATION_MESSAGE);
    }

    @Override
    public String toString() {
        return "==== Detalhes do Evento ====\nEvento: " + nome + "\nData: " + data + "\nLocal: " + local + "\nReceita Total: R$ " + somaTotal_Receita() + "\n===========================";
    }

    public void listarIngressosVendidos() {
        String resultado = "Detalhes dos Ingressos Vendidos para o Evento: " + getNome() + "\n";
        for (Ingresso ingresso : ingressos_V) {
            resultado += "Data de Venda: " + ingresso.data_venda + "\n";
            resultado += "Tipo de Ingresso: " + ingresso.tipo + "\n";
            resultado += "Valor: R$ " + ingresso.valor + "\n";
            resultado += "-----------------------------------\n";
        }
        JOptionPane.showMessageDialog(null, resultado, "Ingressos Vendidos", JOptionPane.INFORMATION_MESSAGE);
    }


    public String getNome() {
        return nome;
    }

    public double getprecoIngresso() {
        return precoIngresso;
    }

    public Object getData() {
        return data;
    }

    public Object getHora() {
        return hora;
    }

    public Object getLocal() {
        return local;
    }
}
