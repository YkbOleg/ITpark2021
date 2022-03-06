package lesson26.service;

import org.json.JSONObject;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Currency;
import java.util.List;
import java.util.Map;

public interface ExchangeRateable {

    String input();
    List<String> jsonMappingValute();
    Double  jsonMappingValutes(String valute);
}
