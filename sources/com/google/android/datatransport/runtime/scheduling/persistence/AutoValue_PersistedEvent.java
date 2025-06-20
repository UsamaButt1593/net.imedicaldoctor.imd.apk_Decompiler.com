package com.google.android.datatransport.runtime.scheduling.persistence;

import com.google.android.datatransport.runtime.EventInternal;
import com.google.android.datatransport.runtime.TransportContext;

final class AutoValue_PersistedEvent extends PersistedEvent {

    /* renamed from: a  reason: collision with root package name */
    private final long f19638a;

    /* renamed from: b  reason: collision with root package name */
    private final TransportContext f19639b;

    /* renamed from: c  reason: collision with root package name */
    private final EventInternal f19640c;

    AutoValue_PersistedEvent(long j2, TransportContext transportContext, EventInternal eventInternal) {
        this.f19638a = j2;
        if (transportContext != null) {
            this.f19639b = transportContext;
            if (eventInternal != null) {
                this.f19640c = eventInternal;
                return;
            }
            throw new NullPointerException("Null event");
        }
        throw new NullPointerException("Null transportContext");
    }

    public EventInternal b() {
        return this.f19640c;
    }

    public long c() {
        return this.f19638a;
    }

    public TransportContext d() {
        return this.f19639b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof PersistedEvent)) {
            return false;
        }
        PersistedEvent persistedEvent = (PersistedEvent) obj;
        return this.f19638a == persistedEvent.c() && this.f19639b.equals(persistedEvent.d()) && this.f19640c.equals(persistedEvent.b());
    }

    public int hashCode() {
        long j2 = this.f19638a;
        return this.f19640c.hashCode() ^ ((((((int) (j2 ^ (j2 >>> 32))) ^ 1000003) * 1000003) ^ this.f19639b.hashCode()) * 1000003);
    }

    public String toString() {
        return "PersistedEvent{id=" + this.f19638a + ", transportContext=" + this.f19639b + ", event=" + this.f19640c + "}";
    }
}
