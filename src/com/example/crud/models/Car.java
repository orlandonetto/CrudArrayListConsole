package com.example.crud.models;

// Entidade
public class Car implements Comparable {

    private String placa;
    private String marca;
    private String modelo;
    private String cor;
    private double quilometragem;
    private int anoFabricacao;
    private int anoModelo;
    private int cilindradas;
    private double precoFIPE;
    private String combustivel;
    private String finalplaca;

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa.toUpperCase();
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca.toUpperCase();
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo.toUpperCase();
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor.toUpperCase();
    }

    public double getQuilometragem() {
        return quilometragem;
    }

    public void setQuilometragem(double quilometragem) {
        this.quilometragem = quilometragem;
    }

    public int getAnoFabricacao() {
        return anoFabricacao;
    }

    public void setAnoFabricacao(int anoFabricacao) {
        this.anoFabricacao = anoFabricacao;
    }

    public int getAnoModelo() {
        return anoModelo;
    }

    public void setAnoModelo(int anoModelo) {
        this.anoModelo = anoModelo;
    }

    public int getCilindradas() {
        return cilindradas;
    }

    public void setCilindradas(int cilindradas) {
        this.cilindradas = cilindradas;
    }

    public double getPrecoFIPE() {
        return precoFIPE;
    }

    public void setPrecoFIPE(double precoFIPE) {
        this.precoFIPE = precoFIPE;
    }

    public String getCombustivel() {
        return combustivel.toUpperCase();
    }

    public void setCombustivel(String combustivel) {
        this.combustivel = combustivel.toUpperCase();
    }

    public String getFinalplaca() {
        return finalplaca;
    }

    public void setFinalplaca(String finalplaca) {
        this.finalplaca = finalplaca.toUpperCase();
    }

    @Override
    public String toString() {
        return "Car{" +
                "placa='" + placa + '\'' +
                ", marca='" + marca + '\'' +
                ", modelo='" + modelo + '\'' +
                ", cor='" + cor + '\'' +
                ", quilometragem=" + quilometragem +
                ", anoFabricacao=" + anoFabricacao +
                ", anoModelo=" + anoModelo +
                ", cilindradas=" + cilindradas +
                ", precoFIPE=" + precoFIPE +
                ", combustivel=" + combustivel +
                ", finalplaca='" + finalplaca + '\'' +
                '}';
    }

    @Override
    public int compareTo(Object o) {
        Car c = (Car) o;

        return this.placa.compareToIgnoreCase(c.getPlaca());
    }
}