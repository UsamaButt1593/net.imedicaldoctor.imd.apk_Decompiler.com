package com.google.firebase.crashlytics.internal.network;

public class HttpResponse {

    /* renamed from: a  reason: collision with root package name */
    private final int f24191a;

    /* renamed from: b  reason: collision with root package name */
    private final String f24192b;

    public HttpResponse(int i2, String str) {
        this.f24191a = i2;
        this.f24192b = str;
    }

    public String a() {
        return this.f24192b;
    }

    public int b() {
        return this.f24191a;
    }
}
