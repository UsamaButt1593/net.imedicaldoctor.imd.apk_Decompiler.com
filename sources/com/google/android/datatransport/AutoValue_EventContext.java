package com.google.android.datatransport;

import androidx.annotation.Nullable;
import com.google.android.datatransport.EventContext;
import java.util.Arrays;

final class AutoValue_EventContext extends EventContext {

    /* renamed from: a  reason: collision with root package name */
    private final String f19196a;

    /* renamed from: b  reason: collision with root package name */
    private final byte[] f19197b;

    /* renamed from: c  reason: collision with root package name */
    private final byte[] f19198c;

    static final class Builder extends EventContext.Builder {

        /* renamed from: a  reason: collision with root package name */
        private String f19199a;

        /* renamed from: b  reason: collision with root package name */
        private byte[] f19200b;

        /* renamed from: c  reason: collision with root package name */
        private byte[] f19201c;

        Builder() {
        }

        public EventContext a() {
            return new AutoValue_EventContext(this.f19199a, this.f19200b, this.f19201c);
        }

        public EventContext.Builder b(byte[] bArr) {
            this.f19200b = bArr;
            return this;
        }

        public EventContext.Builder c(byte[] bArr) {
            this.f19201c = bArr;
            return this;
        }

        public EventContext.Builder d(String str) {
            this.f19199a = str;
            return this;
        }
    }

    private AutoValue_EventContext(@Nullable String str, @Nullable byte[] bArr, @Nullable byte[] bArr2) {
        this.f19196a = str;
        this.f19197b = bArr;
        this.f19198c = bArr2;
    }

    @Nullable
    public byte[] b() {
        return this.f19197b;
    }

    @Nullable
    public byte[] c() {
        return this.f19198c;
    }

    @Nullable
    public String d() {
        return this.f19196a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof EventContext)) {
            return false;
        }
        EventContext eventContext = (EventContext) obj;
        String str = this.f19196a;
        if (str != null ? str.equals(eventContext.d()) : eventContext.d() == null) {
            boolean z = eventContext instanceof AutoValue_EventContext;
            if (Arrays.equals(this.f19197b, z ? ((AutoValue_EventContext) eventContext).f19197b : eventContext.b())) {
                if (Arrays.equals(this.f19198c, z ? ((AutoValue_EventContext) eventContext).f19198c : eventContext.c())) {
                    return true;
                }
            }
        }
        return false;
    }

    public int hashCode() {
        String str = this.f19196a;
        return (((((str == null ? 0 : str.hashCode()) ^ 1000003) * 1000003) ^ Arrays.hashCode(this.f19197b)) * 1000003) ^ Arrays.hashCode(this.f19198c);
    }

    public String toString() {
        return "EventContext{pseudonymousId=" + this.f19196a + ", experimentIdsClear=" + Arrays.toString(this.f19197b) + ", experimentIdsEncrypted=" + Arrays.toString(this.f19198c) + "}";
    }
}
