package org.example.conversor_monedas.domain.repository;

import org.example.conversor_monedas.domain.models.Conversion;

import java.util.concurrent.CompletableFuture;

public interface ConversasionRepository {
    public CompletableFuture<Conversion> getConversion(String codeOring, String codeResult, double amount);
}
