package com.google.common.io;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.J2ktIncompatible;
import java.io.Flushable;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

@ElementTypesAreNonnullByDefault
@GwtIncompatible
@J2ktIncompatible
public final class Flushables {

    /* renamed from: a  reason: collision with root package name */
    private static final Logger f22786a = Logger.getLogger(Flushables.class.getName());

    private Flushables() {
    }

    public static void a(Flushable flushable, boolean z) throws IOException {
        try {
            flushable.flush();
        } catch (IOException e2) {
            if (z) {
                f22786a.log(Level.WARNING, "IOException thrown while flushing Flushable.", e2);
                return;
            }
            throw e2;
        }
    }

    @Beta
    public static void b(Flushable flushable) {
        try {
            a(flushable, true);
        } catch (IOException e2) {
            f22786a.log(Level.SEVERE, "IOException should not have been thrown.", e2);
        }
    }
}
