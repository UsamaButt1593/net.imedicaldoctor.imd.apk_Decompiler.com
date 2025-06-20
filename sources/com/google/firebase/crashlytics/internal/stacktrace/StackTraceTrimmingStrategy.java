package com.google.firebase.crashlytics.internal.stacktrace;

public interface StackTraceTrimmingStrategy {
    StackTraceElement[] a(StackTraceElement[] stackTraceElementArr);
}
