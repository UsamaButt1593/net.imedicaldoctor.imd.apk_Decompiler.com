package com.google.android.datatransport.runtime;

import com.google.android.datatransport.Encoding;
import com.google.android.datatransport.Event;
import com.google.android.datatransport.Transformer;
import com.google.android.datatransport.Transport;
import com.google.android.datatransport.TransportScheduleCallback;

final class TransportImpl<T> implements Transport<T> {

    /* renamed from: a  reason: collision with root package name */
    private final TransportContext f19446a;

    /* renamed from: b  reason: collision with root package name */
    private final String f19447b;

    /* renamed from: c  reason: collision with root package name */
    private final Encoding f19448c;

    /* renamed from: d  reason: collision with root package name */
    private final Transformer<T, byte[]> f19449d;

    /* renamed from: e  reason: collision with root package name */
    private final TransportInternal f19450e;

    TransportImpl(TransportContext transportContext, String str, Encoding encoding, Transformer<T, byte[]> transformer, TransportInternal transportInternal) {
        this.f19446a = transportContext;
        this.f19447b = str;
        this.f19448c = encoding;
        this.f19449d = transformer;
        this.f19450e = transportInternal;
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void e(Exception exc) {
    }

    public void a(Event<T> event) {
        b(event, new a());
    }

    public void b(Event<T> event, TransportScheduleCallback transportScheduleCallback) {
        this.f19450e.a(SendRequest.a().f(this.f19446a).c(event).g(this.f19447b).e(this.f19449d).b(this.f19448c).a(), transportScheduleCallback);
    }

    /* access modifiers changed from: package-private */
    public TransportContext d() {
        return this.f19446a;
    }
}
