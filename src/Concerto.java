public class Concerto extends Evento {
    public Concerto(String nome, String hora, String local, String data, double precoIngresso) {
        super(nome, hora, local, data, precoIngresso);
        this.quantiaIngressos = 200; // Exemplo de quantidade para concertos
    }

    @Override
    public void add_I(Ingresso novo_I) {
        if (assentos_Disp() > 0) {
            this.ingressos_V.add(novo_I);
        } else {
            System.out.println("Sem assentos disponíveis para o evento: " + getNome());
        }
    }
}
