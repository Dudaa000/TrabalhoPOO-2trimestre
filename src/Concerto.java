

import javax.swing.*;

public class Concerto extends Evento {
    Concerto(String nome, String hora, String local, String data, double precoIngresso) {
        super(nome, hora, local, data, precoIngresso);
        super.quantiaIngressos = 150;
    }

    @Override
    public void add_I(Ingresso novo_I) {
        if (ingressos_V.size() < quantiaIngressos) {
            if (novo_I.tipo == 'V' && ingressos_VipDisp() <= quantiaIngressos * 0.1 && ingressos_VipDisp()>  0 ||(novo_I.tipo == 'C' || novo_I.tipo == 'M')) {
                this.ingressos_V.add(novo_I);
            } else {
                JOptionPane.showMessageDialog(null, "Os ingressos VIP já esgotaram para o concerto :(", "*ERRO*", JOptionPane.ERROR_MESSAGE);
            }
        }else{
            JOptionPane.showMessageDialog(null, "Os ingressos para o concerto evento já esgotaram :(", "*ERRO*", JOptionPane.ERROR_MESSAGE);
        }
    }

    @Override
    public int ingressos_VipDisp() {
        int i = 0;
        for (Ingresso atual : this.ingressos_V) {
            if(atual != null && atual.tipo == 'V') {
                i++;
            }
        }
        return  (int)(quantiaIngressos * 0.1 - i);
    }

}


