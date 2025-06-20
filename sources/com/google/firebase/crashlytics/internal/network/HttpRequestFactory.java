package com.google.firebase.crashlytics.internal.network;

import java.util.Collections;
import java.util.Map;

public class HttpRequestFactory {
    public HttpGetRequest a(String str) {
        return b(str, Collections.emptyMap());
    }

    public HttpGetRequest b(String str, Map<String, String> map) {
        return new HttpGetRequest(str, map);
    }
}
