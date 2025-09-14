package model;


public class ID {
    private String id;

    public ID(String identificacao) {
        this.id = identificacao;
    }

    public String getIdentificador() {
        return id;
    }

    // APENAS RAIVA, O QUE EU DEMOREI PARA FAZER ISSO AQUI FOI UMA BRINCADEIRA, NÃO SABIA NEM PARA ONDE IA
    // PASSEI FOI É TEMPO PESQUISANDO ATE QUE CONSEGUI CHEGAR NESSA SOBREESCRITA NÃO SEI SE É A MELHOR FORMA
    // MAS TA AI, PASSOU :)

    @Override
    public boolean equals(Object obj) {
        ID comparar = (ID) obj;
        if(this.id == comparar.id)
            return true;

        return false;
    }
}