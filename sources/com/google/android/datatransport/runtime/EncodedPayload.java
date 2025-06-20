package com.google.android.datatransport.runtime;

import androidx.annotation.NonNull;
import com.google.android.datatransport.Encoding;
import java.util.Arrays;

public final class EncodedPayload {

    /* renamed from: a  reason: collision with root package name */
    private final Encoding f19438a;

    /* renamed from: b  reason: collision with root package name */
    private final byte[] f19439b;

    public EncodedPayload(@NonNull Encoding encoding, @NonNull byte[] bArr) {
        if (encoding == null) {
            throw new NullPointerException("encoding is null");
        } else if (bArr != null) {
            this.f19438a = encoding;
            this.f19439b = bArr;
        } else {
            throw new NullPointerException("bytes is null");
        }
    }

    public byte[] a() {
        return this.f19439b;
    }

    public Encoding b() {
        return this.f19438a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof EncodedPayload)) {
            return false;
        }
        EncodedPayload encodedPayload = (EncodedPayload) obj;
        if (!this.f19438a.equals(encodedPayload.f19438a)) {
            return false;
        }
        return Arrays.equals(this.f19439b, encodedPayload.f19439b);
    }

    public int hashCode() {
        return ((this.f19438a.hashCode() ^ 1000003) * 1000003) ^ Arrays.hashCode(this.f19439b);
    }

    public String toString() {
        return "EncodedPayload{encoding=" + this.f19438a + ", bytes=[...]}";
    }
}
