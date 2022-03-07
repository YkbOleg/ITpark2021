package lesson26.service;

import org.json.JSONObject;

import java.util.List;


public interface ExchangeRateable {

    String input();
    JSONObject getJsonFromUrl();
    List<String> jsonMappingValutes();
    Double  jsonMappingValute(String valute);
}
