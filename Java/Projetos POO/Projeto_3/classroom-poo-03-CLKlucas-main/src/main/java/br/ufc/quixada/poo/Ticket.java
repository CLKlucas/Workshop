package br.ufc.quixada.poo;

import java.time.LocalDateTime;
import java.time.Duration;

public class Ticket {
    private Veiculo veiculo;
    private double valorPago;
    private boolean is_pago;
    private LocalDateTime entrada;



    public Ticket(Veiculo veiculo) {
        this.veiculo = veiculo;
        this.is_pago = false;
        this.entrada = LocalDateTime.now();
    }

    public double getValorPago() {
        return valorPago;
    }

    public void Pagar(LocalDateTime saida){
        Pagamento(saida);
    }

    private void Pagamento(LocalDateTime HorarioSaida){

        double CalcTempo;

        double tempo = Duration.between(entrada,HorarioSaida).toMinutes();
        if (veiculo.getTipoVeiculo().equals("carro")){
            CalcTempo = tempo * 0.10;
            if (CalcTempo < 5)
                valorPago = 5;
            
            else
                valorPago = CalcTempo;



        }
        else if(veiculo.getTipoVeiculo().equals("moto")) {
            CalcTempo = tempo * 0.05;
            if (CalcTempo < 3)
                valorPago = 3;

            else
                valorPago = CalcTempo;


        }
        else
            valorPago = 3;

        is_pago = true;
    }

    public boolean isPago() {
        return is_pago;
    }

    public LocalDateTime getHoraEntrada() {
        return entrada;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

}