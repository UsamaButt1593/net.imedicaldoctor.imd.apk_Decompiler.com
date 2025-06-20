package androidx.datastore.preferences.protobuf;

import java.io.IOException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

final class Protobuf {

    /* renamed from: c  reason: collision with root package name */
    private static final Protobuf f7232c = new Protobuf();

    /* renamed from: a  reason: collision with root package name */
    private final SchemaFactory f7233a = new ManifestSchemaFactory();

    /* renamed from: b  reason: collision with root package name */
    private final ConcurrentMap<Class<?>, Schema<?>> f7234b = new ConcurrentHashMap();

    private Protobuf() {
    }

    public static Protobuf a() {
        return f7232c;
    }

    /* access modifiers changed from: package-private */
    public int b() {
        int i2 = 0;
        for (Schema next : this.f7234b.values()) {
            if (next instanceof MessageSchema) {
                i2 += ((MessageSchema) next).x();
            }
        }
        return i2;
    }

    public <T> boolean c(T t) {
        return j(t).d(t);
    }

    public <T> void d(T t) {
        j(t).c(t);
    }

    public <T> void e(T t, Reader reader) throws IOException {
        f(t, reader, ExtensionRegistryLite.d());
    }

    public <T> void f(T t, Reader reader, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        j(t).b(t, reader, extensionRegistryLite);
    }

    public Schema<?> g(Class<?> cls, Schema<?> schema) {
        Internal.e(cls, "messageType");
        Internal.e(schema, "schema");
        return this.f7234b.putIfAbsent(cls, schema);
    }

    public Schema<?> h(Class<?> cls, Schema<?> schema) {
        Internal.e(cls, "messageType");
        Internal.e(schema, "schema");
        return this.f7234b.put(cls, schema);
    }

    public <T> Schema<T> i(Class<T> cls) {
        Internal.e(cls, "messageType");
        Schema<T> schema = this.f7234b.get(cls);
        if (schema != null) {
            return schema;
        }
        Schema<T> a2 = this.f7233a.a(cls);
        Schema<?> g2 = g(cls, a2);
        return g2 != null ? g2 : a2;
    }

    public <T> Schema<T> j(T t) {
        return i(t.getClass());
    }

    public <T> void k(T t, Writer writer) throws IOException {
        j(t).e(t, writer);
    }
}
