package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.MessageLite;
import androidx.datastore.preferences.protobuf.WireFormat;
import java.io.IOException;
import java.util.AbstractMap;
import java.util.Map;

public class MapEntryLite<K, V> {

    /* renamed from: d  reason: collision with root package name */
    private static final int f7187d = 1;

    /* renamed from: e  reason: collision with root package name */
    private static final int f7188e = 2;

    /* renamed from: a  reason: collision with root package name */
    private final Metadata<K, V> f7189a;

    /* renamed from: b  reason: collision with root package name */
    private final K f7190b;

    /* renamed from: c  reason: collision with root package name */
    private final V f7191c;

    /* renamed from: androidx.datastore.preferences.protobuf.MapEntryLite$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f7192a;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|(3:5|6|8)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        static {
            /*
                androidx.datastore.preferences.protobuf.WireFormat$FieldType[] r0 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f7192a = r0
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r1 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.MESSAGE     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f7192a     // Catch:{ NoSuchFieldError -> 0x001d }
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r1 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.ENUM     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f7192a     // Catch:{ NoSuchFieldError -> 0x0028 }
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r1 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.GROUP     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.MapEntryLite.AnonymousClass1.<clinit>():void");
        }
    }

    static class Metadata<K, V> {

        /* renamed from: a  reason: collision with root package name */
        public final WireFormat.FieldType f7193a;

        /* renamed from: b  reason: collision with root package name */
        public final K f7194b;

        /* renamed from: c  reason: collision with root package name */
        public final WireFormat.FieldType f7195c;

        /* renamed from: d  reason: collision with root package name */
        public final V f7196d;

        public Metadata(WireFormat.FieldType fieldType, K k2, WireFormat.FieldType fieldType2, V v) {
            this.f7193a = fieldType;
            this.f7194b = k2;
            this.f7195c = fieldType2;
            this.f7196d = v;
        }
    }

    private MapEntryLite(Metadata<K, V> metadata, K k2, V v) {
        this.f7189a = metadata;
        this.f7190b = k2;
        this.f7191c = v;
    }

    static <K, V> int b(Metadata<K, V> metadata, K k2, V v) {
        return FieldSet.o(metadata.f7193a, 1, k2) + FieldSet.o(metadata.f7195c, 2, v);
    }

    public static <K, V> MapEntryLite<K, V> f(WireFormat.FieldType fieldType, K k2, WireFormat.FieldType fieldType2, V v) {
        return new MapEntryLite<>(fieldType, k2, fieldType2, v);
    }

    static <K, V> Map.Entry<K, V> h(CodedInputStream codedInputStream, Metadata<K, V> metadata, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        K k2 = metadata.f7194b;
        V v = metadata.f7196d;
        while (true) {
            int Y = codedInputStream.Y();
            if (Y == 0) {
                break;
            } else if (Y == WireFormat.c(1, metadata.f7193a.b())) {
                k2 = i(codedInputStream, extensionRegistryLite, metadata.f7193a, k2);
            } else if (Y == WireFormat.c(2, metadata.f7195c.b())) {
                v = i(codedInputStream, extensionRegistryLite, metadata.f7195c, v);
            } else if (!codedInputStream.g0(Y)) {
                break;
            }
        }
        return new AbstractMap.SimpleImmutableEntry(k2, v);
    }

    static <T> T i(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, WireFormat.FieldType fieldType, T t) throws IOException {
        int i2 = AnonymousClass1.f7192a[fieldType.ordinal()];
        if (i2 == 1) {
            MessageLite.Builder E = ((MessageLite) t).E();
            codedInputStream.I(E, extensionRegistryLite);
            return E.M1();
        } else if (i2 == 2) {
            return Integer.valueOf(codedInputStream.z());
        } else {
            if (i2 != 3) {
                return FieldSet.N(codedInputStream, fieldType, true);
            }
            throw new RuntimeException("Groups are not allowed in maps.");
        }
    }

    static <K, V> void l(CodedOutputStream codedOutputStream, Metadata<K, V> metadata, K k2, V v) throws IOException {
        FieldSet.R(codedOutputStream, metadata.f7193a, 1, k2);
        FieldSet.R(codedOutputStream, metadata.f7195c, 2, v);
    }

    public int a(int i2, K k2, V v) {
        return CodedOutputStream.X0(i2) + CodedOutputStream.D0(b(this.f7189a, k2, v));
    }

    public K c() {
        return this.f7190b;
    }

    /* access modifiers changed from: package-private */
    public Metadata<K, V> d() {
        return this.f7189a;
    }

    public V e() {
        return this.f7191c;
    }

    public Map.Entry<K, V> g(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return h(byteString.R(), this.f7189a, extensionRegistryLite);
    }

    public void j(MapFieldLite<K, V> mapFieldLite, CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        int t = codedInputStream.t(codedInputStream.N());
        Metadata<K, V> metadata = this.f7189a;
        K k2 = metadata.f7194b;
        V v = metadata.f7196d;
        while (true) {
            int Y = codedInputStream.Y();
            if (Y == 0) {
                break;
            } else if (Y == WireFormat.c(1, this.f7189a.f7193a.b())) {
                k2 = i(codedInputStream, extensionRegistryLite, this.f7189a.f7193a, k2);
            } else if (Y == WireFormat.c(2, this.f7189a.f7195c.b())) {
                v = i(codedInputStream, extensionRegistryLite, this.f7189a.f7195c, v);
            } else if (!codedInputStream.g0(Y)) {
                break;
            }
        }
        codedInputStream.a(0);
        codedInputStream.s(t);
        mapFieldLite.put(k2, v);
    }

    public void k(CodedOutputStream codedOutputStream, int i2, K k2, V v) throws IOException {
        codedOutputStream.g2(i2, 2);
        codedOutputStream.h2(b(this.f7189a, k2, v));
        l(codedOutputStream, this.f7189a, k2, v);
    }

    private MapEntryLite(WireFormat.FieldType fieldType, K k2, WireFormat.FieldType fieldType2, V v) {
        this.f7189a = new Metadata<>(fieldType, k2, fieldType2, v);
        this.f7190b = k2;
        this.f7191c = v;
    }
}
