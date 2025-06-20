package com.google.android.datatransport;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public final class Encoding {

    /* renamed from: a  reason: collision with root package name */
    private final String f19207a;

    private Encoding(@NonNull String str) {
        if (str != null) {
            this.f19207a = str;
            return;
        }
        throw new NullPointerException("name is null");
    }

    public static Encoding b(@NonNull String str) {
        return new Encoding(str);
    }

    public String a() {
        return this.f19207a;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Encoding)) {
            return false;
        }
        return this.f19207a.equals(((Encoding) obj).f19207a);
    }

    public int hashCode() {
        return this.f19207a.hashCode() ^ 1000003;
    }

    @NonNull
    public String toString() {
        return "Encoding{name=\"" + this.f19207a + "\"}";
    }
}
