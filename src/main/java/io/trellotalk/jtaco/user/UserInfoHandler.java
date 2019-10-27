package io.trellotalk.jtaco.user;

import io.trellotalk.jtaco.auth.TrelloAuth;
import io.trellotalk.jtaco.json.TacoJson;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;

public class UserInfoHandler extends TacoJson {

    private static final String REQUEST_URL = "members/%s?boards=open&board_fields" +
            "=subscribed,starred,pinned,name,shortLink,shortUrl&";

    public UserInfoHandler(String userId, TrelloAuth auth) throws IOException {
        super(String.format(REQUEST_URL, userId), auth);
    }

}
