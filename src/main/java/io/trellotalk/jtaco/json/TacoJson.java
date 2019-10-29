package io.trellotalk.jtaco.json;

import io.trellotalk.jtaco.auth.TrelloAuth;
import org.json.JSONObject;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;

public class TacoJson extends JSONObject {

    private static final String URL_BASE = "https://api.trello.com/1/";
    private static final String AUTH_FORMAT = "key=%s&" + "token=%s";

    private final java.net.URL REQUEST_URL;

    protected TacoJson(String requestUrl, TrelloAuth auth, HttpMethod method) throws IOException {

        super(JsonHandler.getJsonContentFromURL(buildUrl(requestUrl, auth), method));
        REQUEST_URL = buildUrl(requestUrl, auth);
    }

    private static java.net.URL buildUrl(String requestUrl, TrelloAuth auth) {
        try {
            String authUrl = String.format(AUTH_FORMAT, auth.getApiKey(), auth.getToken());
            return new java.net.URI(URL_BASE + requestUrl + authUrl).toURL();
        }
        catch (URISyntaxException | MalformedURLException e) {
            throw new IllegalArgumentException();
        }
    }
}
