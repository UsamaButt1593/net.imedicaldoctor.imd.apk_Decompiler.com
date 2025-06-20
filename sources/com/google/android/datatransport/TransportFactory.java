package com.google.android.datatransport;

public interface TransportFactory {
    @Deprecated
    <T> Transport<T> a(String str, Class<T> cls, Transformer<T, byte[]> transformer);

    <T> Transport<T> b(String str, Class<T> cls, Encoding encoding, Transformer<T, byte[]> transformer);
}
