import javax.swing.JOptionPane;

public class Filme extends Evento {
    public Filme(String nome, String hora, String local, String data, double precoIngresso) {
        super(nome, hora, local, data, precoIngresso);
        this.quantiaIngressos = 100; // Exemplo de quantidade para filmes
    }

    @Override
    public void add_I(Ingresso novo_I) {
        if (novo_I.tipo != 'V') {
            this.ingressos_V.add(novo_I);
        } else {
            JOptionPane.showMessageDialog(null, "Ingressos VIP não estão disponíveis para este tipo de evento!! (FILME)", "ERRO", JOptionPane.ERROR_MESSAGE);
        }
    }
}

