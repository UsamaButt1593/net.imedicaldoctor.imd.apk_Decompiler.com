package com.airbnb.lottie.model;

public class Marker {

    /* renamed from: d  reason: collision with root package name */
    private static String f17123d = "\r";

    /* renamed from: a  reason: collision with root package name */
    private final String f17124a;

    /* renamed from: b  reason: collision with root package name */
    public final float f17125b;

    /* renamed from: c  reason: collision with root package name */
    public final float f17126c;

    public Marker(String str, float f2, float f3) {
        this.f17124a = str;
        this.f17126c = f3;
        this.f17125b = f2;
    }

    public boolean a(String str) {
        if (this.f17124a.equalsIgnoreCase(str)) {
            return true;
        }
        if (this.f17124a.endsWith(f17123d)) {
            String str2 = this.f17124a;
            if (str2.substring(0, str2.length() - 1).equalsIgnoreCase(str)) {
                return true;
            }
        }
        return false;
    }
}
