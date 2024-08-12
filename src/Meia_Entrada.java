import java.util.Date;

public class Meia_Entrada extends Ingresso {
    Meia_Entrada(Date data_venda, double valor) {
        super(data_venda, valor / 2, 'M'); // Dividindo o valor por 2 e definindo o tipo como 'M'
    }
}
