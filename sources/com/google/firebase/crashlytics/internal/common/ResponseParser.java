package com.google.firebase.crashlytics.internal.common;

public class ResponseParser {

    /* renamed from: a  reason: collision with root package name */
    public static final int f23673a = 0;

    /* renamed from: b  reason: collision with root package name */
    public static final int f23674b = 1;

    public static int a(int i2) {
        if (i2 < 200 || i2 > 299) {
            return ((i2 < 300 || i2 > 399) && i2 >= 400 && i2 <= 499) ? 0 : 1;
        }
        return 0;
    }
}
