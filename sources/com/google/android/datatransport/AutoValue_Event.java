package com.google.android.datatransport;

import androidx.annotation.Nullable;

final class AutoValue_Event<T> extends Event<T> {

    /* renamed from: a  reason: collision with root package name */
    private final Integer f19191a;

    /* renamed from: b  reason: collision with root package name */
    private final T f19192b;

    /* renamed from: c  reason: collision with root package name */
    private final Priority f19193c;

    /* renamed from: d  reason: collision with root package name */
    private final ProductData f19194d;

    /* renamed from: e  reason: collision with root package name */
    private final EventContext f19195e;

    AutoValue_Event(@Nullable Integer num, T t, Priority priority, @Nullable ProductData productData, @Nullable EventContext eventContext) {
        this.f19191a = num;
        if (t != null) {
            this.f19192b = t;
            if (priority != null) {
                this.f19193c = priority;
                this.f19194d = productData;
                this.f19195e = eventContext;
                return;
            }
            throw new NullPointerException("Null priority");
        }
        throw new NullPointerException("Null payload");
    }

    @Nullable
    public Integer a() {
        return this.f19191a;
    }

    @Nullable
    public EventContext b() {
        return this.f19195e;
    }

    public T c() {
        return this.f19192b;
    }

    public Priority d() {
        return this.f19193c;
    }

    @Nullable
    public ProductData e() {
        return this.f19194d;
    }

    public boolean equals(Object obj) {
        ProductData productData;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Event)) {
            return false;
        }
        Event event = (Event) obj;
        Integer num = this.f19191a;
        if (num != null ? num.equals(event.a()) : event.a() == null) {
            if (this.f19192b.equals(event.c()) && this.f19193c.equals(event.d()) && ((productData = this.f19194d) != null ? productData.equals(event.e()) : event.e() == null)) {
                EventContext eventContext = this.f19195e;
                EventContext b2 = event.b();
                if (eventContext == null) {
                    if (b2 == null) {
                        return true;
                    }
                } else if (eventContext.equals(b2)) {
                    return true;
                }
            }
        }
        return false;
    }

    public int hashCode() {
        Integer num = this.f19191a;
        int i2 = 0;
        int hashCode = ((((((num == null ? 0 : num.hashCode()) ^ 1000003) * 1000003) ^ this.f19192b.hashCode()) * 1000003) ^ this.f19193c.hashCode()) * 1000003;
        ProductData productData = this.f19194d;
        int hashCode2 = (hashCode ^ (productData == null ? 0 : productData.hashCode())) * 1000003;
        EventContext eventContext = this.f19195e;
        if (eventContext != null) {
            i2 = eventContext.hashCode();
        }
        return hashCode2 ^ i2;
    }

    public String toString() {
        return "Event{code=" + this.f19191a + ", payload=" + this.f19192b + ", priority=" + this.f19193c + ", productData=" + this.f19194d + ", eventContext=" + this.f19195e + "}";
    }
}
