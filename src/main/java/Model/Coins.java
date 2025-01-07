package Model;

import ConverterAPI.CoinAPI;

public class Coins {
    private String coinFirs;
    private String coinSec;
    private String dateCoin;
    private Double cot;
    private Double sumConverter;
    private Double finaL;

    public void setFinaL(Double finaL) {
        this.finaL = finaL;
    }

    public Coins(CoinAPI coinAPI) {
        this.coinFirs = coinAPI.coinB();
        this.coinSec = coinAPI.coinT();

        this.cot = coinAPI.coinCota();
        this.sumConverter = coinAPI.sumCon();

    }

    public void showCoin(){
        System.out.println("O valor " + finaL + " " + coinFirs + " é " + sumConverter + " " + coinSec + " seguindo a cotação " + cot + " na data de " +dateCoin);
    }

    @Override
    public String toString(){
        return finaL + " " + coinFirs + " " + sumConverter + " " + coinSec + " " + cot;
    }
}
