package androidx.media3.exoplayer;

import android.annotation.SuppressLint;
import androidx.media3.exoplayer.RendererCapabilities;

public final /* synthetic */ class V0 {
    public static int c(int i2) {
        return e(i2, 0, 0, 0);
    }

    public static int d(int i2, int i3, int i4) {
        return g(i2, i3, i4, 0, 128, 0);
    }

    public static int e(int i2, int i3, int i4, int i5) {
        return g(i2, i3, i4, 0, 128, i5);
    }

    public static int f(int i2, int i3, int i4, int i5, int i6) {
        return g(i2, i3, i4, i5, i6, 0);
    }

    @SuppressLint({"WrongConstant"})
    public static int g(int i2, int i3, int i4, int i5, int i6, int i7) {
        return i2 | i3 | i4 | i5 | i6 | i7;
    }

    @SuppressLint({"WrongConstant"})
    public static int h(int i2) {
        return i2 & 24;
    }

    @SuppressLint({"WrongConstant"})
    public static int i(int i2) {
        return i2 & RendererCapabilities.Q;
    }

    @SuppressLint({"WrongConstant"})
    public static int j(int i2) {
        return i2 & RendererCapabilities.M;
    }

    @SuppressLint({"WrongConstant"})
    public static int k(int i2) {
        return i2 & 7;
    }

    @SuppressLint({"WrongConstant"})
    public static int l(int i2) {
        return i2 & 64;
    }

    @SuppressLint({"WrongConstant"})
    public static int m(int i2) {
        return i2 & 32;
    }

    public static void b(RendererCapabilities rendererCapabilities, RendererCapabilities.Listener listener) {
    }

    public static void a(RendererCapabilities rendererCapabilities) {
    }
}
