package com.itextpdf.text;

import java.util.List;

public interface Element {
    public static final int A0 = 17;
    public static final int B0 = 23;
    public static final int C0 = 29;
    public static final int D0 = 30;
    public static final int E0 = 32;
    public static final int F0 = 33;
    public static final int G0 = 34;
    public static final int H0 = 35;
    public static final int I0 = 36;
    public static final int J0 = 37;
    public static final int K0 = 38;
    public static final int L0 = 50;
    public static final int M0 = 55;
    public static final int N0 = 666;
    public static final int O0 = -1;
    public static final int P0 = 0;
    public static final int Q0 = 1;
    public static final int R0 = 2;
    public static final int S0 = 3;
    public static final int T0 = 4;
    public static final int U0 = 5;
    public static final int V0 = 6;
    public static final int W0 = 7;
    public static final int X0 = 8;
    public static final int Y0 = 256;
    public static final int Z0 = 257;
    public static final int a1 = 258;
    public static final int b1 = 1;
    public static final int c1 = 2;
    public static final int d1 = 4;
    public static final int e1 = 8;
    public static final int k0 = 0;
    public static final int l0 = 1;
    public static final int m0 = 2;
    public static final int n0 = 3;
    public static final int o0 = 4;
    public static final int p0 = 5;
    public static final int q0 = 6;
    public static final int r0 = 7;
    public static final int s0 = 8;
    public static final int t0 = 10;
    public static final int u0 = 11;
    public static final int v0 = 12;
    public static final int w0 = 13;
    public static final int x0 = 14;
    public static final int y0 = 15;
    public static final int z0 = 16;

    boolean V();

    List<Chunk> Y();

    boolean t(ElementListener elementListener);

    String toString();

    int type();

    boolean x();
}
