public class Passageiro {

    private String id;
    private int idade;

    public Passageiro(String nome, int idade) {
        this.id = nome;
        this.idade = idade;
    }
    public boolean ePrioritario() {
        if (idade >= 65)
            return true;
        return false;
    }

   public String getNome(){return id;}


    public int getIdade(){return idade;}

    @Override
    public String toString(){
        return id + ":" + idade;
    }
}