package androidx.datastore.preferences.protobuf;

final class NewInstanceSchemas {

    /* renamed from: a  reason: collision with root package name */
    private static final NewInstanceSchema f7225a = c();

    /* renamed from: b  reason: collision with root package name */
    private static final NewInstanceSchema f7226b = new NewInstanceSchemaLite();

    NewInstanceSchemas() {
    }

    static NewInstanceSchema a() {
        return f7225a;
    }

    static NewInstanceSchema b() {
        return f7226b;
    }

    private static NewInstanceSchema c() {
        try {
            return (NewInstanceSchema) Class.forName("androidx.datastore.preferences.protobuf.NewInstanceSchemaFull").getDeclaredConstructor((Class[]) null).newInstance((Object[]) null);
        } catch (Exception unused) {
            return null;
        }
    }
}
