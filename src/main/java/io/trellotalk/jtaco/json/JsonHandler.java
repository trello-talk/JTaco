package io.trellotalk.jtaco.json;

import java.io.IOException;
import java.util.Scanner;

import io.trellotalk.jtaco.auth.TrelloAuth;
import io.trellotalk.jtaco.user.UserInfoHandler;

public class JsonHandler {

	public static String getJsonContentFromURL(java.net.URL url) throws IOException {

		Scanner scan = new Scanner(url.openStream());
		String result = "";
		while (scan.hasNext())
			result += scan.nextLine();
		scan.close();

		return result;
	}

	public static UserInfoHandler getUserInfo(String id, TrelloAuth auth) throws IOException {
		return new UserInfoHandler(id, auth);
	}
}
