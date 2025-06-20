package com.airbnb.lottie.model;

import androidx.annotation.RestrictTo;
import com.airbnb.lottie.model.content.ShapeGroup;
import java.util.List;

@RestrictTo({RestrictTo.Scope.LIBRARY})
public class FontCharacter {

    /* renamed from: a  reason: collision with root package name */
    private final List<ShapeGroup> f17112a;

    /* renamed from: b  reason: collision with root package name */
    private final char f17113b;

    /* renamed from: c  reason: collision with root package name */
    private final double f17114c;

    /* renamed from: d  reason: collision with root package name */
    private final double f17115d;

    /* renamed from: e  reason: collision with root package name */
    private final String f17116e;

    /* renamed from: f  reason: collision with root package name */
    private final String f17117f;

    public FontCharacter(List<ShapeGroup> list, char c2, double d2, double d3, String str, String str2) {
        this.f17112a = list;
        this.f17113b = c2;
        this.f17114c = d2;
        this.f17115d = d3;
        this.f17116e = str;
        this.f17117f = str2;
    }

    public static int e(char c2, String str, String str2) {
        return (((c2 * 31) + str.hashCode()) * 31) + str2.hashCode();
    }

    public List<ShapeGroup> a() {
        return this.f17112a;
    }

    /* access modifiers changed from: package-private */
    public double b() {
        return this.f17114c;
    }

    /* access modifiers changed from: package-private */
    public String c() {
        return this.f17116e;
    }

    public double d() {
        return this.f17115d;
    }

    public int hashCode() {
        return e(this.f17113b, this.f17117f, this.f17116e);
    }
}
