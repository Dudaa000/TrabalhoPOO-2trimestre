import java.util.Date;

public class Vip extends Ingresso {
    Vip(Date data_venda, double valor) {
        super(data_venda, valor * 2, 'V'); // Multiplicando o valor por 2 e definindo o tipo como 'V'
    }
}
