package com.itextpdf.text.pdf.parser;

import java.util.List;

public class PathConstructionRenderInfo {

    /* renamed from: d  reason: collision with root package name */
    public static final int f26985d = 1;

    /* renamed from: e  reason: collision with root package name */
    public static final int f26986e = 2;

    /* renamed from: f  reason: collision with root package name */
    public static final int f26987f = 3;

    /* renamed from: g  reason: collision with root package name */
    public static final int f26988g = 4;

    /* renamed from: h  reason: collision with root package name */
    public static final int f26989h = 5;

    /* renamed from: i  reason: collision with root package name */
    public static final int f26990i = 6;

    /* renamed from: j  reason: collision with root package name */
    public static final int f26991j = 7;

    /* renamed from: a  reason: collision with root package name */
    private int f26992a;

    /* renamed from: b  reason: collision with root package name */
    private List<Float> f26993b;

    /* renamed from: c  reason: collision with root package name */
    private Matrix f26994c;

    public PathConstructionRenderInfo(int i2, Matrix matrix) {
        this(i2, (List<Float>) null, matrix);
    }

    public Matrix a() {
        return this.f26994c;
    }

    public int b() {
        return this.f26992a;
    }

    public List<Float> c() {
        return this.f26993b;
    }

    public PathConstructionRenderInfo(int i2, List<Float> list, Matrix matrix) {
        this.f26992a = i2;
        this.f26993b = list;
        this.f26994c = matrix;
    }
}
