package io.reactivex.rxjava3.internal.fuseable;

public interface QueueFuseable<T> extends SimpleQueue<T> {
    public static final int I2 = 0;
    public static final int J2 = 1;
    public static final int K2 = 2;
    public static final int L2 = 3;
    public static final int M2 = 4;

    int r(int i2);
}
