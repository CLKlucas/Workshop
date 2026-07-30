import static javax.management.Query.or;

public class Conta {
    private int numero;
    private double saldo;
    private double limite;
    private double[] extrato;
    private int operacoesRealizadas;


    public Conta(int numero, double saldo) {
        this.numero = numero;
        this.saldo = saldo;
        this.limite = 100;
        this.extrato = new double[10];
        this.operacoesRealizadas = 0;
    }

    
    public int getNumero() {
        return this.numero;
    }
    
    public double getSaldo() {
        return this.saldo + this.limite;
    }

    
    public double getLimite() {
        return this.limite;
    }
    
    public boolean sacar(double valor) {
        if (operacoesRealizadas > 10)
                return false;
        if(valor > getSaldo() || valor < 0){
            return false;
        }
        else {
            if(valor > this.saldo) {
                this.saldo = valor - this.saldo;
                this.limite = this.limite - this.saldo;
                this.saldo = 0;
            }
            else{
                this.saldo = this.saldo - valor;
            }
            this.extrato[operacoesRealizadas] = -valor;
            operacoesRealizadas++;
            return true;
        }
    }

   
    public boolean depositar(double valor) {
        if (operacoesRealizadas > 10)
            return false;
        if(valor < 0){return false;}

        else{
            if (this.limite != 100){
                double faltante = 100 - this.limite;
                if (faltante < valor){
                    this.limite = 100;
                    valor = valor - faltante;
                    this.saldo = this.saldo + valor;
                    this.extrato[operacoesRealizadas] = valor;
                    operacoesRealizadas++;
                    return true;
                }
                else{
                    this.limite = this.limite + valor;
                    this.extrato[operacoesRealizadas] = valor;
                    operacoesRealizadas++;
                    return true;
                }
            }
            this.saldo = this.saldo + valor;
            this.extrato[operacoesRealizadas] = valor;
            operacoesRealizadas++;
            return true;
        }
    }

    
    public boolean transferir(Conta destino, double valor) {
        if (operacoesRealizadas > 10)
            return false;

        if(!sacar(valor)){return false;}

        else{
            destino.depositar(valor);
            return true;
        }

    }


    public double[] verExtrato() {

        return this.extrato;
    }
}