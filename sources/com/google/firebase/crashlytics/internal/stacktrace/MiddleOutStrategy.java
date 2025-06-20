package com.google.firebase.crashlytics.internal.stacktrace;

public class MiddleOutStrategy implements StackTraceTrimmingStrategy {

    /* renamed from: a  reason: collision with root package name */
    private final int f24315a;

    public MiddleOutStrategy(int i2) {
        this.f24315a = i2;
    }

    public StackTraceElement[] a(StackTraceElement[] stackTraceElementArr) {
        int length = stackTraceElementArr.length;
        int i2 = this.f24315a;
        if (length <= i2) {
            return stackTraceElementArr;
        }
        int i3 = i2 / 2;
        int i4 = i2 - i3;
        StackTraceElement[] stackTraceElementArr2 = new StackTraceElement[i2];
        System.arraycopy(stackTraceElementArr, 0, stackTraceElementArr2, 0, i4);
        System.arraycopy(stackTraceElementArr, stackTraceElementArr.length - i3, stackTraceElementArr2, i4, i3);
        return stackTraceElementArr2;
    }
}
