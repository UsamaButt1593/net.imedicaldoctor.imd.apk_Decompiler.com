package com.google.firebase.tracing;

import android.os.Trace;

public final class FirebaseTrace {
    private FirebaseTrace() {
    }

    public static void a() {
        Trace.endSection();
    }

    public static void b(String str) {
        Trace.beginSection(str);
    }
}
