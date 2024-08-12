
import javax.swing.*;

public class Teatro extends Evento {
    Teatro(String nome, String hora, String local, String data, double precoIngresso) {
        super(nome, hora, local, data, precoIngresso);
        super.quantiaIngressos = 250;
    }

    @Override
    public void add_I(Ingresso novo_I) {
        if (ingressos_V.size() < quantiaIngressos) {
            if (novo_I.tipo == 'M' && ingressos_MeiaDisp() <= quantiaIngressos * 0.2 && ingressos_MeiaDisp()>0) {
                this.ingressos_V.add(novo_I);
            } else if (novo_I.tipo == 'V' || novo_I.tipo == 'C') {
                this.ingressos_V.add(novo_I);
            } else if(novo_I.tipo == 'M' && ingressos_MeiaDisp() > quantiaIngressos * 0.2 ){
                JOptionPane.showMessageDialog(null, "Os ingressos Meia-Entrada para a peça de teatro já esgotaram :(", "*ERRO*", JOptionPane.ERROR_MESSAGE);
            }
        }else{
            JOptionPane.showMessageDialog(null, "Os ingressos para a peça de teatro já esgotaram :(", "*ERRO*", JOptionPane.ERROR_MESSAGE);
        }
    }

    @Override
    public int ingressos_MeiaDisp() {
        int i = 0;
        for (Ingresso atual : this.ingressos_V) {
            if(atual != null && atual.tipo == 'M') {
                i++;
            }
        }
        return  (int)(quantiaIngressos * 0.1 - i);
    }

}

