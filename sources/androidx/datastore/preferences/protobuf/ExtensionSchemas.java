package androidx.datastore.preferences.protobuf;

final class ExtensionSchemas {

    /* renamed from: a  reason: collision with root package name */
    private static final ExtensionSchema<?> f7120a = new ExtensionSchemaLite();

    /* renamed from: b  reason: collision with root package name */
    private static final ExtensionSchema<?> f7121b = c();

    ExtensionSchemas() {
    }

    static ExtensionSchema<?> a() {
        ExtensionSchema<?> extensionSchema = f7121b;
        if (extensionSchema != null) {
            return extensionSchema;
        }
        throw new IllegalStateException("Protobuf runtime is not correctly loaded.");
    }

    static ExtensionSchema<?> b() {
        return f7120a;
    }

    private static ExtensionSchema<?> c() {
        try {
            return (ExtensionSchema) Class.forName("androidx.datastore.preferences.protobuf.ExtensionSchemaFull").getDeclaredConstructor((Class[]) null).newInstance((Object[]) null);
        } catch (Exception unused) {
            return null;
        }
    }
}
