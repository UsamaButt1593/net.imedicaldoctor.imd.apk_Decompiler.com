package com.google.common.escape;

import com.google.common.annotations.GwtCompatible;

@GwtCompatible(emulated = true)
@ElementTypesAreNonnullByDefault
final class Platform {

    /* renamed from: a  reason: collision with root package name */
    private static final ThreadLocal<char[]> f22544a = new ThreadLocal<char[]>() {
        /* access modifiers changed from: protected */
        /* renamed from: a */
        public char[] initialValue() {
            return new char[1024];
        }
    };

    private Platform() {
    }

    static char[] a() {
        return f22544a.get();
    }
}
