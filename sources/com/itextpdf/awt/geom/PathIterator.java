package com.itextpdf.awt.geom;

public interface PathIterator {

    /* renamed from: a  reason: collision with root package name */
    public static final int f25585a = 0;

    /* renamed from: b  reason: collision with root package name */
    public static final int f25586b = 1;

    /* renamed from: c  reason: collision with root package name */
    public static final int f25587c = 0;

    /* renamed from: d  reason: collision with root package name */
    public static final int f25588d = 1;

    /* renamed from: e  reason: collision with root package name */
    public static final int f25589e = 2;

    /* renamed from: f  reason: collision with root package name */
    public static final int f25590f = 3;

    /* renamed from: g  reason: collision with root package name */
    public static final int f25591g = 4;

    int a(double[] dArr);

    int b(float[] fArr);

    int c();

    boolean isDone();

    void next();
}
