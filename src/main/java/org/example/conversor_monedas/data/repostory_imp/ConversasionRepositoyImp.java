package org.example.conversor_monedas.data.repostory_imp;

import org.example.conversor_monedas.data.service.ExangeRate;
import org.example.conversor_monedas.domain.models.Conversion;
import org.example.conversor_monedas.domain.repository.ConversasionRepository;

import java.util.concurrent.CompletableFuture;

public class ConversasionRepositoyImp implements ConversasionRepository {

    final ExangeRate exangeRate;

    public ConversasionRepositoyImp(){
        exangeRate = new ExangeRate();
    }


    @Override
    public CompletableFuture<Conversion> getConversion(String codeOring, String codeResult, double amount) {
        System.out.println(codeOring+codeResult+amount);
       return  exangeRate.getConversion(codeOring,codeResult, amount);
    }
}
