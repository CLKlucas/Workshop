public class Fone {
    private String numero;
    private Tipo numeroTipo;


    public Fone(Tipo tipo, String numero){
        this.numero = numero;
        this.numeroTipo = tipo;
    }

    public static boolean eValido(String numero){
        String validos = "0123456789()-";
        int contador = 0;

        for (int n = 0; n < numero.length();n++){

            for (int v = 0; v < validos.length();v++){
                if (numero.charAt(n) == validos.charAt(v)){
                    contador++;

                }

            }
            if(contador == numero.length())
                return true;
       }
        return false;
    }

    public Tipo getTipo() {
        return numeroTipo;
    }

    public String getNumero() {
        return numero;
    }

}
