package androidx.datastore.preferences.protobuf;

final class ExtensionRegistryFactory {

    /* renamed from: a  reason: collision with root package name */
    static final String f7108a = "androidx.datastore.preferences.protobuf.ExtensionRegistry";

    /* renamed from: b  reason: collision with root package name */
    static final Class<?> f7109b = e();

    ExtensionRegistryFactory() {
    }

    public static ExtensionRegistryLite a() {
        if (f7109b != null) {
            try {
                return c("newInstance");
            } catch (Exception unused) {
            }
        }
        return new ExtensionRegistryLite();
    }

    public static ExtensionRegistryLite b() {
        if (f7109b != null) {
            try {
                return c("getEmptyRegistry");
            } catch (Exception unused) {
            }
        }
        return ExtensionRegistryLite.f7115g;
    }

    private static final ExtensionRegistryLite c(String str) throws Exception {
        return (ExtensionRegistryLite) f7109b.getDeclaredMethod(str, (Class[]) null).invoke((Object) null, (Object[]) null);
    }

    static boolean d(ExtensionRegistryLite extensionRegistryLite) {
        Class<?> cls = f7109b;
        return cls != null && cls.isAssignableFrom(extensionRegistryLite.getClass());
    }

    static Class<?> e() {
        try {
            return Class.forName(f7108a);
        } catch (ClassNotFoundException unused) {
            return null;
        }
    }
}
