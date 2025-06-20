package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.GeneratedMessageLite;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class ExtensionRegistryLite {

    /* renamed from: b  reason: collision with root package name */
    private static volatile boolean f7110b = false;

    /* renamed from: c  reason: collision with root package name */
    private static boolean f7111c = true;

    /* renamed from: d  reason: collision with root package name */
    static final String f7112d = "androidx.datastore.preferences.protobuf.Extension";

    /* renamed from: e  reason: collision with root package name */
    private static final Class<?> f7113e = h();

    /* renamed from: f  reason: collision with root package name */
    private static volatile ExtensionRegistryLite f7114f;

    /* renamed from: g  reason: collision with root package name */
    static final ExtensionRegistryLite f7115g = new ExtensionRegistryLite(true);

    /* renamed from: a  reason: collision with root package name */
    private final Map<ObjectIntPair, GeneratedMessageLite.GeneratedExtension<?, ?>> f7116a;

    private static final class ObjectIntPair {

        /* renamed from: a  reason: collision with root package name */
        private final Object f7117a;

        /* renamed from: b  reason: collision with root package name */
        private final int f7118b;

        ObjectIntPair(Object obj, int i2) {
            this.f7117a = obj;
            this.f7118b = i2;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof ObjectIntPair)) {
                return false;
            }
            ObjectIntPair objectIntPair = (ObjectIntPair) obj;
            return this.f7117a == objectIntPair.f7117a && this.f7118b == objectIntPair.f7118b;
        }

        public int hashCode() {
            return (System.identityHashCode(this.f7117a) * 65535) + this.f7118b;
        }
    }

    ExtensionRegistryLite() {
        this.f7116a = new HashMap();
    }

    public static ExtensionRegistryLite d() {
        ExtensionRegistryLite extensionRegistryLite = f7114f;
        if (extensionRegistryLite == null) {
            synchronized (ExtensionRegistryLite.class) {
                try {
                    extensionRegistryLite = f7114f;
                    if (extensionRegistryLite == null) {
                        extensionRegistryLite = f7111c ? ExtensionRegistryFactory.b() : f7115g;
                        f7114f = extensionRegistryLite;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return extensionRegistryLite;
    }

    public static boolean f() {
        return f7110b;
    }

    public static ExtensionRegistryLite g() {
        return f7111c ? ExtensionRegistryFactory.a() : new ExtensionRegistryLite();
    }

    static Class<?> h() {
        try {
            return Class.forName(f7112d);
        } catch (ClassNotFoundException unused) {
            return null;
        }
    }

    public static void i(boolean z) {
        f7110b = z;
    }

    public final void a(ExtensionLite<?, ?> extensionLite) {
        if (GeneratedMessageLite.GeneratedExtension.class.isAssignableFrom(extensionLite.getClass())) {
            b((GeneratedMessageLite.GeneratedExtension) extensionLite);
        }
        if (f7111c && ExtensionRegistryFactory.d(this)) {
            try {
                getClass().getMethod("add", new Class[]{f7113e}).invoke(this, new Object[]{extensionLite});
            } catch (Exception e2) {
                throw new IllegalArgumentException(String.format("Could not invoke ExtensionRegistry#add for %s", new Object[]{extensionLite}), e2);
            }
        }
    }

    public final void b(GeneratedMessageLite.GeneratedExtension<?, ?> generatedExtension) {
        this.f7116a.put(new ObjectIntPair(generatedExtension.h(), generatedExtension.d()), generatedExtension);
    }

    public <ContainingType extends MessageLite> GeneratedMessageLite.GeneratedExtension<ContainingType, ?> c(ContainingType containingtype, int i2) {
        return this.f7116a.get(new ObjectIntPair(containingtype, i2));
    }

    public ExtensionRegistryLite e() {
        return new ExtensionRegistryLite(this);
    }

    ExtensionRegistryLite(ExtensionRegistryLite extensionRegistryLite) {
        this.f7116a = extensionRegistryLite == f7115g ? Collections.emptyMap() : Collections.unmodifiableMap(extensionRegistryLite.f7116a);
    }

    ExtensionRegistryLite(boolean z) {
        this.f7116a = Collections.emptyMap();
    }
}
