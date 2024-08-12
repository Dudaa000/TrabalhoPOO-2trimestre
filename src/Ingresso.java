import javax.swing.*;
import java.util.Date;

public class Ingresso implements RelatorioReceita {
    Date data_venda;
    double valor;
    char tipo;

    Ingresso(Date data_venda, double valor, char tipo) {
        this.data_venda = data_venda;
        this.valor = valor;
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "==== Receita do Ingresso ====\nData: " + data_venda + "\nTipo: " + tipo + "\nPreço: R$ " + valor + "\n=============================";
    }

    @Override
    public double somaTotal_Receita() {
        return valor;
    }

    @Override
    public void extrato_Receita() {
        System.out.println(this.toString());
    }
}
