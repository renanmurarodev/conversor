package ConverterAPI;

import Main.History;
import Model.Coins;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Conversor {
    private String apiKEY = "fbade084a17f13f7a6808f9c";
    private String urlAPI = "https://v6.exchangerate-api.com/v6/" + apiKEY + "/pair/";



    private History historySearch;

    public Conversor(History historySearch){
        this.historySearch = historySearch;
    }

    Gson gson = new GsonBuilder()
            .setFieldNamingPolicy(FieldNamingPolicy.IDENTITY)
            .setPrettyPrinting()
            .create();

    public void Conv(String coinFirs, String coinSec, Double finaL){

        String urlEn = urlAPI + coinFirs + "/" + coinSec;


        try{
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder().uri(URI.create(urlEn)).build();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() != 200) {
                throw new RuntimeException("Requisição com erro: " + response.statusCode());
            }

            String json = response.body();

            CoinAPI newCoin = gson.fromJson(json, CoinAPI.class);
            Coins coin = new Coins(newCoin);
            coin.setFinaL(finaL);
            coin.showCoin();
            historySearch.Add(coin);

        } catch (Exception e) {
            throw new RuntimeException("Erro ao realizar a conversão: " + e.getMessage(), e);
        }
    }
}
