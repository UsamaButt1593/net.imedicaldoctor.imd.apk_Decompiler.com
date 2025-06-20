package androidx.datastore.preferences.protobuf;

final class MapFieldSchemas {

    /* renamed from: a  reason: collision with root package name */
    private static final MapFieldSchema f7197a = c();

    /* renamed from: b  reason: collision with root package name */
    private static final MapFieldSchema f7198b = new MapFieldSchemaLite();

    MapFieldSchemas() {
    }

    static MapFieldSchema a() {
        return f7197a;
    }

    static MapFieldSchema b() {
        return f7198b;
    }

    private static MapFieldSchema c() {
        try {
            return (MapFieldSchema) Class.forName("androidx.datastore.preferences.protobuf.MapFieldSchemaFull").getDeclaredConstructor((Class[]) null).newInstance((Object[]) null);
        } catch (Exception unused) {
            return null;
        }
    }
}
