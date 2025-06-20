package com.google.android.datatransport.runtime;

import android.annotation.SuppressLint;
import androidx.annotation.WorkerThread;
import com.google.android.datatransport.Priority;
import com.google.android.datatransport.Transport;
import com.google.android.datatransport.runtime.logging.Logging;

public final class ForcedSender {

    /* renamed from: a  reason: collision with root package name */
    private static final String f19441a = "ForcedSender";

    private ForcedSender() {
    }

    @WorkerThread
    @SuppressLint({"DiscouragedApi"})
    public static void a(Transport<?> transport, Priority priority) {
        if (transport instanceof TransportImpl) {
            TransportRuntime.c().e().u(((TransportImpl) transport).d().f(priority), 1);
            return;
        }
        Logging.i(f19441a, "Expected instance of `TransportImpl`, got `%s`.", transport);
    }
}
