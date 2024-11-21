package org.example.conversor_monedas.domain.models;

public record Conversion(String result, String base_code, String target_code, String conversion_rate, double conversion_result) {
}
