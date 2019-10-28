package io.trellotalk.jtaco.auth;

import io.trellotalk.jtaco.Config;

public class TrelloAuth {

	private final String API_KEY = Config.getValue(Config.Key.TRELLO_API_KEY);
	private final String TOKEN = Config.getValue(Config.Key.TRELLO_TOKEN);

	public String getApiKey() {
		return API_KEY;
	}

	public String getToken() {
		return TOKEN;
	}
}
