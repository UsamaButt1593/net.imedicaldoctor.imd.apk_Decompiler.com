package com.google.android.datatransport.runtime;

import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import com.google.android.datatransport.Priority;
import com.google.android.datatransport.runtime.TransportContext;
import java.util.Arrays;

final class AutoValue_TransportContext extends TransportContext {

    /* renamed from: a  reason: collision with root package name */
    private final String f19427a;

    /* renamed from: b  reason: collision with root package name */
    private final byte[] f19428b;

    /* renamed from: c  reason: collision with root package name */
    private final Priority f19429c;

    static final class Builder extends TransportContext.Builder {

        /* renamed from: a  reason: collision with root package name */
        private String f19430a;

        /* renamed from: b  reason: collision with root package name */
        private byte[] f19431b;

        /* renamed from: c  reason: collision with root package name */
        private Priority f19432c;

        Builder() {
        }

        public TransportContext a() {
            String str = "";
            if (this.f19430a == null) {
                str = str + " backendName";
            }
            if (this.f19432c == null) {
                str = str + " priority";
            }
            if (str.isEmpty()) {
                return new AutoValue_TransportContext(this.f19430a, this.f19431b, this.f19432c);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        public TransportContext.Builder b(String str) {
            if (str != null) {
                this.f19430a = str;
                return this;
            }
            throw new NullPointerException("Null backendName");
        }

        public TransportContext.Builder c(@Nullable byte[] bArr) {
            this.f19431b = bArr;
            return this;
        }

        public TransportContext.Builder d(Priority priority) {
            if (priority != null) {
                this.f19432c = priority;
                return this;
            }
            throw new NullPointerException("Null priority");
        }
    }

    private AutoValue_TransportContext(String str, @Nullable byte[] bArr, Priority priority) {
        this.f19427a = str;
        this.f19428b = bArr;
        this.f19429c = priority;
    }

    public String b() {
        return this.f19427a;
    }

    @Nullable
    public byte[] c() {
        return this.f19428b;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public Priority d() {
        return this.f19429c;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof TransportContext)) {
            return false;
        }
        TransportContext transportContext = (TransportContext) obj;
        if (this.f19427a.equals(transportContext.b())) {
            return Arrays.equals(this.f19428b, transportContext instanceof AutoValue_TransportContext ? ((AutoValue_TransportContext) transportContext).f19428b : transportContext.c()) && this.f19429c.equals(transportContext.d());
        }
    }

    public int hashCode() {
        return ((((this.f19427a.hashCode() ^ 1000003) * 1000003) ^ Arrays.hashCode(this.f19428b)) * 1000003) ^ this.f19429c.hashCode();
    }
}
