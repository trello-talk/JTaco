package io.trellotalk.jtaco.json;

public enum HttpMethod {
    GET("GET"),
    POST("POST"),
    PUT("PUT"),
    PATCH("PATCH"),
    DELETE("DELETE");

    final String value;

    HttpMethod(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }

}
