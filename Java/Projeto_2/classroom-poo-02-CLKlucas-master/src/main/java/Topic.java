public class Topic {

    private Passageiro[] preferencias;
    private Passageiro[] normais;
    private int capacidade;
    private int qtdPreferenciais;


    public Topic(int capacidade, int qtdPrioritatios) {
        this.capacidade = capacidade;
        this.qtdPreferenciais = qtdPrioritatios;
        preferencias = new Passageiro[qtdPreferenciais];
        normais = new Passageiro[capacidade - qtdPreferenciais];
    }

    public int getNumeroAssentosPrioritarios() {
        return qtdPreferenciais;
    }

    public int getNumeroAssentosNormais() {
        return capacidade - qtdPreferenciais;
    }

    public Passageiro getPassageiroAssentoPrioritario(int lugar) {
        if (lugar >= 0){
            if(lugar < preferencias.length){
                return preferencias[lugar];
            }
        }
        return null;
    }

    public Passageiro getPassageiroAssentoNormal(int lugar) {
        if (lugar >= 0){
            if(lugar < normais.length){
                return normais[lugar];
            }
        }
        return null;
    }

    public int getVagas() {
        int vagaslivre = 0;
        for (int i = 0; i < preferencias.length; i++) {
            if (preferencias[i] == null)
                vagaslivre++;
        }
        for (int i = 0; i < normais.length; i++) {
            if (normais[i] == null)
                vagaslivre++;
        }
        return vagaslivre;
    }
    public String toString(){
        String formatacao = "[";
        for (int i = 0; i < preferencias.length; i++) {
            if (preferencias[i] == null)
                formatacao = formatacao + "@ ";
             else
                formatacao = formatacao + "@" + preferencias[i].getNome() + ":" + preferencias[i].getIdade() + " ";

        }

        for (int i = 0; i < normais.length; i++) {
            if (normais[i] == null)
                formatacao = formatacao + "= ";
             else
                formatacao = formatacao + "=" + normais[i].getNome() + ":" + normais[i].getIdade() + " ";

        }
        return formatacao + "]";
    }

    public boolean subir(Passageiro passageiro) {
        if (isTopicCheia())
            return false;

        if (isPassageiroPresente(passageiro.getNome()))
            return false;

        if (passageiro.ePrioritario())
            alocarPreferencial(passageiro);

        if (!passageiro.ePrioritario())
            alocarNormal(passageiro);

        return true;
    }

    public boolean descer(String nome) {
        for (int i = 0; i < preferencias.length; i++) {
            if (preferencias[i] != null && preferencias[i].getNome().equals(nome)) {
                preferencias[i] = null;
                return true;
            }
        }
        for (int i = 0; i < normais.length; i++) {
            if (normais[i] != null && normais[i].getNome().equals(nome)){
                normais[i] = null;
                return true;
            }

        }
        System.out.println("O passageiro nao esta na topic");
        return false;
    }

    private boolean isTopicCheia() {
        int contador = 0;
        for (int i = 0; i < normais.length; i++) {
            if (normais[i] != null)
                contador++;
        }
        for (int i = 0; i < preferencias.length; i++) {
            if (preferencias[i] != null)
                contador++;
        }
        if (contador == normais.length + preferencias.length) {
            System.out.println("Topic lotada");
            return true;
        }
        return false;
    }

    private boolean isPassageiroPresente(String id) {
        for (int i = 0; i < normais.length; i++) {
            if (normais[i] != null && normais[i].getNome().equals(id)) {
                System.out.println("Passageiro ja esta na topic");
                return true;
            }
        }
        for (int i = 0; i < preferencias.length; i++) {
            if (preferencias[i] != null && preferencias[i].getNome().equals(id)) {
                System.out.println("Passageiro ja esta na topic");
                return true;
            }
        }
        return false;
    }

    private void alocarPreferencial(Passageiro passageiro) {
        for (int i = 0; i < preferencias.length; i++) {
            if (preferencias[i] == null){
                preferencias[i] = passageiro;
                return;
            }
        }
        alocarNormal(passageiro);
    }

    private void alocarNormal(Passageiro passageiro) {
        for (int i = 0; i < normais.length; i++) {
            if (normais[i] == null) {
                normais[i] = passageiro;
                return;
            }
        }
        alocarPreferencial(passageiro);
    }
}

