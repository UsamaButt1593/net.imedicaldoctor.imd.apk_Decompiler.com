package androidx.datastore.preferences.protobuf;

final class Android {

    /* renamed from: a  reason: collision with root package name */
    private static final Class<?> f6971a = a("libcore.io.Memory");

    /* renamed from: b  reason: collision with root package name */
    private static final boolean f6972b = (a("org.robolectric.Robolectric") != null);

    Android() {
    }

    private static <T> Class<T> a(String str) {
        try {
            return Class.forName(str);
        } catch (Throwable unused) {
            return null;
        }
    }

    static Class<?> b() {
        return f6971a;
    }

    static boolean c() {
        return f6971a != null && !f6972b;
    }
}
