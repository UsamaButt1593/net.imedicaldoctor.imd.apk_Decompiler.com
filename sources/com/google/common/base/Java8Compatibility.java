package com.google.common.base;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.J2ktIncompatible;
import java.nio.Buffer;

@ElementTypesAreNonnullByDefault
@GwtIncompatible
@J2ktIncompatible
final class Java8Compatibility {
    private Java8Compatibility() {
    }

    static void a(Buffer buffer) {
        buffer.clear();
    }

    static void b(Buffer buffer) {
        buffer.flip();
    }

    static void c(Buffer buffer, int i2) {
        buffer.limit(i2);
    }

    static void d(Buffer buffer, int i2) {
        buffer.position(i2);
    }
}
