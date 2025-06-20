package com.google.firebase.crashlytics.internal.stacktrace;

public class MiddleOutFallbackStrategy implements StackTraceTrimmingStrategy {

    /* renamed from: a  reason: collision with root package name */
    private final int f24312a;

    /* renamed from: b  reason: collision with root package name */
    private final StackTraceTrimmingStrategy[] f24313b;

    /* renamed from: c  reason: collision with root package name */
    private final MiddleOutStrategy f24314c;

    public MiddleOutFallbackStrategy(int i2, StackTraceTrimmingStrategy... stackTraceTrimmingStrategyArr) {
        this.f24312a = i2;
        this.f24313b = stackTraceTrimmingStrategyArr;
        this.f24314c = new MiddleOutStrategy(i2);
    }

    public StackTraceElement[] a(StackTraceElement[] stackTraceElementArr) {
        if (stackTraceElementArr.length <= this.f24312a) {
            return stackTraceElementArr;
        }
        StackTraceElement[] stackTraceElementArr2 = stackTraceElementArr;
        for (StackTraceTrimmingStrategy stackTraceTrimmingStrategy : this.f24313b) {
            if (stackTraceElementArr2.length <= this.f24312a) {
                break;
            }
            stackTraceElementArr2 = stackTraceTrimmingStrategy.a(stackTraceElementArr);
        }
        return stackTraceElementArr2.length > this.f24312a ? this.f24314c.a(stackTraceElementArr2) : stackTraceElementArr2;
    }
}
