package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.ArrayDecoders;
import java.io.IOException;

interface Schema<T> {
    void a(T t, T t2);

    void b(T t, Reader reader, ExtensionRegistryLite extensionRegistryLite) throws IOException;

    void c(T t);

    boolean d(T t);

    void e(T t, Writer writer) throws IOException;

    boolean f(T t, T t2);

    int g(T t);

    T h();

    void i(T t, byte[] bArr, int i2, int i3, ArrayDecoders.Registers registers) throws IOException;

    int j(T t);
}
