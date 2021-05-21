package com.zinio.web.utilities;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class JsonUtils {
    public static JsonObject getJsonFromUrl(String url) {
        try {
            URL apiUrl = new URL(url);
            HttpURLConnection request = (HttpURLConnection) apiUrl.openConnection();
            request.connect();
            return new JsonParser().parse(new InputStreamReader((InputStream) request.getContent())).getAsJsonObject();
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public static HttpResponse sendRequestWithJson(String url, JsonObject jsonObject) {
        try {
            CloseableHttpClient httpClient = HttpClientBuilder.create().build();
            HttpPost request = new HttpPost(url);
            StringEntity params = new StringEntity(jsonObject.toString());
            request.addHeader("content-type", "application/json");
            request.addHeader("Accept", "application/json");
            request.setEntity(params);
            HttpResponse response = httpClient.execute(request);
            return response;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public static String reponseValue(String url, JsonObject jsonObject, String key) {
        String value ="";
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
        try {

            HttpResponse response = sendRequestWithJson(url,jsonObject);

            String json = EntityUtils.toString(response.getEntity(),"UTF-8");
            value = getDataFromKey(json,key).toString();
            httpClient.close();
            return value;

        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }

    }

    public static Object getDataFromKey(String jsonPath, String key) {
        Object value = "";
        String[] values = {};
        JSONParser parser = new JSONParser();
        try {
            Object resultObject = parser.parse(jsonPath);

            if (resultObject instanceof JSONArray) {
                for (Object object : (JSONArray) resultObject) {
                    JSONObject obj = (JSONObject) object;
                    values = StringUtils.addStringToArray(values,obj.get(key).toString());
                }
                value = values;
            } else if (resultObject instanceof JSONObject) {
                JSONObject obj = (JSONObject) resultObject;
                if (obj.containsKey(key))
                    value = obj.get(key).toString();
                else {
                    JSONObject objChild = (JSONObject) obj.get("data");
                    value = objChild.get(key).toString();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return value;
    }

}