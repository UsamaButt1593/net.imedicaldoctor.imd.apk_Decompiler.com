package com.google.android.datatransport.runtime;

import com.google.android.datatransport.Encoding;
import com.google.android.datatransport.Transformer;
import com.google.android.datatransport.Transport;
import com.google.android.datatransport.TransportFactory;
import java.util.Set;

final class TransportFactoryImpl implements TransportFactory {

    /* renamed from: a  reason: collision with root package name */
    private final Set<Encoding> f19443a;

    /* renamed from: b  reason: collision with root package name */
    private final TransportContext f19444b;

    /* renamed from: c  reason: collision with root package name */
    private final TransportInternal f19445c;

    TransportFactoryImpl(Set<Encoding> set, TransportContext transportContext, TransportInternal transportInternal) {
        this.f19443a = set;
        this.f19444b = transportContext;
        this.f19445c = transportInternal;
    }

    public <T> Transport<T> a(String str, Class<T> cls, Transformer<T, byte[]> transformer) {
        return b(str, cls, Encoding.b("proto"), transformer);
    }

    public <T> Transport<T> b(String str, Class<T> cls, Encoding encoding, Transformer<T, byte[]> transformer) {
        if (this.f19443a.contains(encoding)) {
            return new TransportImpl(this.f19444b, str, encoding, transformer, this.f19445c);
        }
        throw new IllegalArgumentException(String.format("%s is not supported byt this factory. Supported encodings are: %s.", new Object[]{encoding, this.f19443a}));
    }
}
