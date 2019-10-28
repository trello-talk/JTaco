package io.trellotalk.jtaco.user;

import java.io.IOException;
import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;

import io.trellotalk.jtaco.auth.TrelloAuth;
import io.trellotalk.jtaco.json.TacoJson;

public class UserInfoHandler extends TacoJson {

	private static final String REQUEST_URL = "members/%s?boards=open&board_fields" +
		"=subscribed,starred,pinned,name,shortLink,shortUrl&";

	public UserInfoHandler(String userId, TrelloAuth auth) throws IOException {
		super(String.format(REQUEST_URL, userId), auth);
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
