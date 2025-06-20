package androidx.core.view;

import android.view.MotionEvent;
import androidx.annotation.NonNull;

public final class MotionEventCompat {
    @Deprecated
    public static final int A = 17;
    @Deprecated
    public static final int B = 18;
    @Deprecated
    public static final int C = 19;
    @Deprecated
    public static final int D = 20;
    @Deprecated
    public static final int E = 21;
    @Deprecated
    public static final int F = 22;
    @Deprecated
    public static final int G = 23;
    @Deprecated
    public static final int H = 24;
    @Deprecated
    public static final int I = 25;
    public static final int J = 26;
    public static final int K = 27;
    public static final int L = 28;
    @Deprecated
    public static final int M = 32;
    @Deprecated
    public static final int N = 33;
    @Deprecated
    public static final int O = 34;
    @Deprecated
    public static final int P = 35;
    @Deprecated
    public static final int Q = 36;
    @Deprecated
    public static final int R = 37;
    @Deprecated
    public static final int S = 38;
    @Deprecated
    public static final int T = 39;
    @Deprecated
    public static final int U = 40;
    @Deprecated
    public static final int V = 41;
    @Deprecated
    public static final int W = 42;
    @Deprecated
    public static final int X = 43;
    @Deprecated
    public static final int Y = 44;
    @Deprecated
    public static final int Z = 45;
    @Deprecated

    /* renamed from: a  reason: collision with root package name */
    public static final int f6441a = 255;
    @Deprecated
    public static final int a0 = 46;
    @Deprecated

    /* renamed from: b  reason: collision with root package name */
    public static final int f6442b = 5;
    @Deprecated
    public static final int b0 = 47;
    @Deprecated

    /* renamed from: c  reason: collision with root package name */
    public static final int f6443c = 6;
    @Deprecated
    public static final int c0 = 1;
    @Deprecated

    /* renamed from: d  reason: collision with root package name */
    public static final int f6444d = 7;
    @Deprecated

    /* renamed from: e  reason: collision with root package name */
    public static final int f6445e = 8;
    @Deprecated

    /* renamed from: f  reason: collision with root package name */
    public static final int f6446f = 65280;
    @Deprecated

    /* renamed from: g  reason: collision with root package name */
    public static final int f6447g = 8;
    @Deprecated

    /* renamed from: h  reason: collision with root package name */
    public static final int f6448h = 9;
    @Deprecated

    /* renamed from: i  reason: collision with root package name */
    public static final int f6449i = 10;
    @Deprecated

    /* renamed from: j  reason: collision with root package name */
    public static final int f6450j = 0;
    @Deprecated

    /* renamed from: k  reason: collision with root package name */
    public static final int f6451k = 1;
    @Deprecated

    /* renamed from: l  reason: collision with root package name */
    public static final int f6452l = 2;
    @Deprecated

    /* renamed from: m  reason: collision with root package name */
    public static final int f6453m = 3;
    @Deprecated

    /* renamed from: n  reason: collision with root package name */
    public static final int f6454n = 4;
    @Deprecated
    public static final int o = 5;
    @Deprecated
    public static final int p = 6;
    @Deprecated
    public static final int q = 7;
    @Deprecated
    public static final int r = 8;
    @Deprecated
    public static final int s = 9;
    @Deprecated
    public static final int t = 10;
    @Deprecated
    public static final int u = 11;
    @Deprecated
    public static final int v = 12;
    @Deprecated
    public static final int w = 13;
    @Deprecated
    public static final int x = 14;
    @Deprecated
    public static final int y = 15;
    @Deprecated
    public static final int z = 16;

    private MotionEventCompat() {
    }

    @Deprecated
    public static int a(MotionEvent motionEvent, int i2) {
        return motionEvent.findPointerIndex(i2);
    }

    @Deprecated
    public static int b(MotionEvent motionEvent) {
        return motionEvent.getActionIndex();
    }

    @Deprecated
    public static int c(MotionEvent motionEvent) {
        return motionEvent.getActionMasked();
    }

    @Deprecated
    public static float d(MotionEvent motionEvent, int i2) {
        return motionEvent.getAxisValue(i2);
    }

    @Deprecated
    public static float e(MotionEvent motionEvent, int i2, int i3) {
        return motionEvent.getAxisValue(i2, i3);
    }

    @Deprecated
    public static int f(MotionEvent motionEvent) {
        return motionEvent.getButtonState();
    }

    @Deprecated
    public static int g(MotionEvent motionEvent) {
        return motionEvent.getPointerCount();
    }

    @Deprecated
    public static int h(MotionEvent motionEvent, int i2) {
        return motionEvent.getPointerId(i2);
    }

    @Deprecated
    public static int i(MotionEvent motionEvent) {
        return motionEvent.getSource();
    }

    @Deprecated
    public static float j(MotionEvent motionEvent, int i2) {
        return motionEvent.getX(i2);
    }

    @Deprecated
    public static float k(MotionEvent motionEvent, int i2) {
        return motionEvent.getY(i2);
    }

    public static boolean l(@NonNull MotionEvent motionEvent, int i2) {
        return (motionEvent.getSource() & i2) == i2;
    }
}
