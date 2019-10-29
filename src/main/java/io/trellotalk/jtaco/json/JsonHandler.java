package io.trellotalk.jtaco.json;

import io.trellotalk.jtaco.auth.TrelloAuth;
import io.trellotalk.jtaco.user.UserInfoHandler;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.util.Scanner;

public class JsonHandler {

    public static String getJsonContentFromURL(java.net.URL url, HttpMethod method) throws IOException {

        HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
        urlConnection.setRequestMethod(method.toString());

        Scanner scan = new Scanner(urlConnection.getInputStream());
        String result = "";
        while (scan.hasNext())
            result += scan.nextLine();
        scan.close();

        return result;
    }

    public static UserInfoHandler getUserInfo(String id, TrelloAuth auth) throws IOException {
        return new UserInfoHandler(id, auth, HttpMethod.GET);
    }
}
