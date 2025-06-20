package com.google.common.eventbus;

import androidx.core.app.NotificationCompat;
import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;

@ElementTypesAreNonnullByDefault
public class DeadEvent {

    /* renamed from: a  reason: collision with root package name */
    private final Object f22546a;

    /* renamed from: b  reason: collision with root package name */
    private final Object f22547b;

    public DeadEvent(Object obj, Object obj2) {
        this.f22546a = Preconditions.E(obj);
        this.f22547b = Preconditions.E(obj2);
    }

    public Object a() {
        return this.f22547b;
    }

    public Object b() {
        return this.f22546a;
    }

    public String toString() {
        return MoreObjects.c(this).f("source", this.f22546a).f(NotificationCompat.I0, this.f22547b).toString();
    }
}
