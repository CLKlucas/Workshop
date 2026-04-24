package br.ufc.quixada.poo;



public abstract class Veiculo {
  protected String identificador;

  public Veiculo(String identificador){
    this.identificador = identificador;
  }

  public String getIdentificador() {
    return identificador;
  }

  public abstract TipoVaga getTipoVaga();

  public abstract String getTipoVeiculo();
}