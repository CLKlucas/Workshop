package br.ufc.quixada.poo;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Estacionamento {
  private int vagasCarro;
  private int vagasMotoBike;
  private Ticket[] entradaTickets;
  private int veiculosEstacionados;

  public Estacionamento(int vagasCarro, int vagasMotoBike) {
    this.vagasCarro = vagasCarro;
    this.vagasMotoBike = vagasMotoBike;
    this.entradaTickets = new Ticket[vagasCarro + vagasMotoBike];

  }

  public boolean registrarEntrada(Veiculo veiculo) {
    for (int i = 0; i < entradaTickets.length;i++) {
      if (entradaTickets[i] != null && entradaTickets[i].getVeiculo().getIdentificador().equals(veiculo.getIdentificador())){
        return false;
      }
    }

    if (vagasDisponiveisPara(veiculo.getTipoVaga()) > 0){
      if (veiculo.getTipoVaga() == TipoVaga.CARRO)
        vagasCarro -= 1;
      else
        vagasMotoBike -= 1;

      for (int i = 0; i < entradaTickets.length; i++){
        if (entradaTickets[i] == null){
          entradaTickets[i] = new Ticket(veiculo);
          veiculosEstacionados += 1;
          return true;
        }
      }
      return true;
    }
    else {
      System.out.println("Não tem vaga de " + veiculo.getTipoVeiculo() +" no momento");
      return false;
    }
  }

  public boolean registrarSaida(String identificador, LocalDateTime horaDeSaida) {
    for (int i = 0; i < entradaTickets.length; i++){

      if((entradaTickets[i] != null && entradaTickets[i].getVeiculo().getIdentificador().equals(identificador))) {

        if (entradaTickets[i].isPago()){
          return false;
        }

        entradaTickets[i].Pagar(horaDeSaida);
        veiculosEstacionados -= 1;

        if(entradaTickets[i].getVeiculo().getTipoVaga() == TipoVaga.CARRO){
          vagasCarro += 1;
        }
        else{
          vagasMotoBike += 1;
        }
        entradaTickets[i] = null;
        return true;
      }
    }
    return false;
  }

  public Ticket getTicketBy(String identificador) {
    for (int i = 0; i < entradaTickets.length; i++){
      if(entradaTickets[i].getVeiculo().getIdentificador().equals(identificador))
        return entradaTickets[i];
    }
    return null;
  }

  public Veiculo[] listarVeiculosEstacionados() {
    Veiculo[] estacionados = new Veiculo[veiculosEstacionados];
    for (int i = 0; i < entradaTickets.length; i++){
      if (entradaTickets[i] != null){
        estacionados[i] = entradaTickets[i].getVeiculo();
      }
    }
    return estacionados;
  }

  public int vagasDisponiveisPara(TipoVaga tipo) {
    if (tipo == TipoVaga.CARRO)
      return vagasCarro;

    return vagasMotoBike;

  }


}