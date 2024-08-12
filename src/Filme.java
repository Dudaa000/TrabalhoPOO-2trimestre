
import javax.swing.*;

public class Filme extends Evento {
    Filme(String nome, String hora, String local, String data, double precoIngresso) {
        super(nome, hora, local, data, precoIngresso);
        super.quantiaIngressos = 200;
    }

    @Override
    public void add_I(Ingresso novo_I) {
        if (ingressos_V.size() < quantiaIngressos) {
            if (novo_I.tipo != 'V') {
                this.ingressos_V.add(novo_I);
            } else if(novo_I.tipo == 'V'){
                JOptionPane.showMessageDialog(null, "Ingressos VIP não estão disponíveis para o cinema!", "*ERRO*", JOptionPane.ERROR_MESSAGE);
            }
        }else{
            JOptionPane.showMessageDialog(null, "Não há mais ingressos para este evento :(", "*ERRO*", JOptionPane.ERROR_MESSAGE);
        }
    }

}


