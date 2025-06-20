package com.google.android.datatransport.runtime.backends;

import android.content.Context;
import androidx.annotation.NonNull;
import com.google.android.datatransport.runtime.time.Clock;

final class AutoValue_CreationContext extends CreationContext {

    /* renamed from: b  reason: collision with root package name */
    private final Context f19467b;

    /* renamed from: c  reason: collision with root package name */
    private final Clock f19468c;

    /* renamed from: d  reason: collision with root package name */
    private final Clock f19469d;

    /* renamed from: e  reason: collision with root package name */
    private final String f19470e;

    AutoValue_CreationContext(Context context, Clock clock, Clock clock2, String str) {
        if (context != null) {
            this.f19467b = context;
            if (clock != null) {
                this.f19468c = clock;
                if (clock2 != null) {
                    this.f19469d = clock2;
                    if (str != null) {
                        this.f19470e = str;
                        return;
                    }
                    throw new NullPointerException("Null backendName");
                }
                throw new NullPointerException("Null monotonicClock");
            }
            throw new NullPointerException("Null wallClock");
        }
        throw new NullPointerException("Null applicationContext");
    }

    public Context c() {
        return this.f19467b;
    }

    @NonNull
    public String d() {
        return this.f19470e;
    }

    public Clock e() {
        return this.f19469d;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CreationContext)) {
            return false;
        }
        CreationContext creationContext = (CreationContext) obj;
        return this.f19467b.equals(creationContext.c()) && this.f19468c.equals(creationContext.f()) && this.f19469d.equals(creationContext.e()) && this.f19470e.equals(creationContext.d());
    }

    public Clock f() {
        return this.f19468c;
    }

    public int hashCode() {
        return ((((((this.f19467b.hashCode() ^ 1000003) * 1000003) ^ this.f19468c.hashCode()) * 1000003) ^ this.f19469d.hashCode()) * 1000003) ^ this.f19470e.hashCode();
    }

    public String toString() {
        return "CreationContext{applicationContext=" + this.f19467b + ", wallClock=" + this.f19468c + ", monotonicClock=" + this.f19469d + ", backendName=" + this.f19470e + "}";
    }
}
