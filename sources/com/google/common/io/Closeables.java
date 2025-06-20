package com.google.common.io;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.J2ktIncompatible;
import com.google.common.annotations.VisibleForTesting;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.CheckForNull;

@ElementTypesAreNonnullByDefault
@GwtIncompatible
@J2ktIncompatible
public final class Closeables {
    @VisibleForTesting

    /* renamed from: a  reason: collision with root package name */
    static final Logger f22776a = Logger.getLogger(Closeables.class.getName());

    private Closeables() {
    }

    public static void a(@CheckForNull Closeable closeable, boolean z) throws IOException {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e2) {
                if (z) {
                    f22776a.log(Level.WARNING, "IOException thrown while closing Closeable.", e2);
                    return;
                }
                throw e2;
            }
        }
    }

    public static void b(@CheckForNull InputStream inputStream) {
        try {
            a(inputStream, true);
        } catch (IOException e2) {
            throw new AssertionError(e2);
        }
    }

    public static void c(@CheckForNull Reader reader) {
        try {
            a(reader, true);
        } catch (IOException e2) {
            throw new AssertionError(e2);
        }
    }
}
