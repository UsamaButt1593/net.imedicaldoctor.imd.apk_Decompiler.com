package com.google.firebase.crashlytics.internal.stacktrace;

import androidx.annotation.Nullable;
import java.util.Stack;

public class TrimmedThrowableData {

    /* renamed from: a  reason: collision with root package name */
    public final String f24317a;

    /* renamed from: b  reason: collision with root package name */
    public final String f24318b;

    /* renamed from: c  reason: collision with root package name */
    public final StackTraceElement[] f24319c;
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    public final TrimmedThrowableData f24320d;

    private TrimmedThrowableData(String str, String str2, StackTraceElement[] stackTraceElementArr, @Nullable TrimmedThrowableData trimmedThrowableData) {
        this.f24317a = str;
        this.f24318b = str2;
        this.f24319c = stackTraceElementArr;
        this.f24320d = trimmedThrowableData;
    }

    public static TrimmedThrowableData a(Throwable th, StackTraceTrimmingStrategy stackTraceTrimmingStrategy) {
        Stack stack = new Stack();
        while (th != null) {
            stack.push(th);
            th = th.getCause();
        }
        TrimmedThrowableData trimmedThrowableData = null;
        while (!stack.isEmpty()) {
            Throwable th2 = (Throwable) stack.pop();
            trimmedThrowableData = new TrimmedThrowableData(th2.getLocalizedMessage(), th2.getClass().getName(), stackTraceTrimmingStrategy.a(th2.getStackTrace()), trimmedThrowableData);
        }
        return trimmedThrowableData;
    }
}
