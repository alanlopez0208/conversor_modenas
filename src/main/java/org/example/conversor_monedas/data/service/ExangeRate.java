package org.example.conversor_monedas.data.service;

import com.google.gson.Gson;
import org.example.conversor_monedas.domain.models.Conversion;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.concurrent.CompletableFuture;
import java.util.function.Function;

public class ExangeRate {
    final String URL_API =  "https://v6.exchangerate-api.com/v6/28bb4d84a250c089e5e0a1bd/pair/";


    public CompletableFuture<Conversion> getConversion(String codeOring, String codeResult, double amount){
        String url = URL_API + codeOring + "/" + codeResult +"/" + amount;
        URI uri = URI.create(url);


        HttpRequest httpRequest = HttpRequest.newBuilder()
                .uri(uri)
                .GET()
                .build();

        HttpClient client = HttpClient.newHttpClient();

        return client.sendAsync(httpRequest, HttpResponse.BodyHandlers.ofString()).thenApply(new Function<HttpResponse<String>, Conversion>() {
            @Override
            public Conversion apply(HttpResponse<String> stringHttpResponse) {
                Gson json = new Gson();

                return json.fromJson(stringHttpResponse.body(), Conversion.class);
            }
        }).exceptionally(new Function<Throwable, Conversion>() {
            @Override
            public Conversion apply(Throwable throwable) {
                throwable.printStackTrace();
                return null;
            }
        });
    }


}
