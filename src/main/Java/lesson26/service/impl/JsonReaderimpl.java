package lesson26.service.impl;

import lesson26.service.ExchangeRateable;
import lombok.SneakyThrows;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import java.io.*;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class JsonReaderimpl implements ExchangeRateable {

    private final String url = "https://www.cbr-xml-daily.ru/daily_json.js";

    //-------------------Чтение объекта--------------------------------------------------------------
    private String readAll(Reader rd) throws IOException {
        StringBuilder sb = new StringBuilder();
        int cp;
        while ((cp = rd.read()) != -1) {
            sb.append((char) cp);
        }
        return sb.toString();
    }

    //-----------------Получение JSONObject из JSON полученного по URL--------------------------------
    @SneakyThrows
    public JSONObject getJsonFromUrl() throws JSONException {
        InputStream is = new URL(url).openStream();
        try {
            BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
            String jsonText = readAll(rd);
            JSONObject json = new JSONObject(jsonText);
            return json;
        } finally {
            is.close();
        }
    }

    //-------------------Получение списка валют из JSONObject----------------------------------------
    @Override
    @SneakyThrows
    public List<String> jsonMappingValutes() {
        JSONObject jsonValutes = (JSONObject) getJsonFromUrl().get("Valute");
        List<String> valutes = Arrays.stream(JSONObject.getNames(jsonValutes))
                .map(v -> v + " - " + jsonValutes.getJSONObject(v).getString("Name")).collect(Collectors.toList());
        return valutes;
    }

    //-----------------Получение курса валюты из JSONObject
    @Override
    @SneakyThrows
    public Double jsonMappingValute(String valute) {
        JSONObject jsonObject = getJsonFromUrl();
        return jsonObject.getJSONObject("Valute").getJSONObject(valute).getDouble("Value");
    }


    /***
     * Ввод информации с консоли
     * @return - Информация введённая пользователем
     */
    @Override
    public String input() {
        Scanner scannerIn = new Scanner(System.in);
        return scannerIn.next();
    }
}
