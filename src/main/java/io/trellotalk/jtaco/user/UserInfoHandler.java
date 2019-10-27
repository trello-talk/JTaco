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

    public UserInfoHandler(String userId, TrelloAuth auth, String method) throws IOException {
        super(String.format(REQUEST_URL, userId), auth, method);
    }

    public java.util.List<String> getBoardList() {

        JSONArray array = getJSONArray("boards");
        java.util.List<String> boardList = new ArrayList<>();
        for (Object element : array) {
            JSONObject obj = (JSONObject) element;
            boardList.add((String) obj.get("name"));
        }
        return boardList;
    }
}
