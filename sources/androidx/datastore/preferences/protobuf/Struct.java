package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.GeneratedMessageLite;
import androidx.datastore.preferences.protobuf.WireFormat;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.Map;

public final class Struct extends GeneratedMessageLite<Struct, Builder> implements StructOrBuilder {
    /* access modifiers changed from: private */
    public static final Struct DEFAULT_INSTANCE;
    public static final int FIELDS_FIELD_NUMBER = 1;
    private static volatile Parser<Struct> PARSER;
    private MapFieldLite<String, Value> fields_ = MapFieldLite.f();

    /* renamed from: androidx.datastore.preferences.protobuf.Struct$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f7251a;

        /* JADX WARNING: Can't wrap try/catch for region: R(14:0|1|2|3|4|5|6|7|8|9|10|11|12|(3:13|14|16)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(16:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|16) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0049 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                androidx.datastore.preferences.protobuf.GeneratedMessageLite$MethodToInvoke[] r0 = androidx.datastore.preferences.protobuf.GeneratedMessageLite.MethodToInvoke.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f7251a = r0
                androidx.datastore.preferences.protobuf.GeneratedMessageLite$MethodToInvoke r1 = androidx.datastore.preferences.protobuf.GeneratedMessageLite.MethodToInvoke.NEW_MUTABLE_INSTANCE     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f7251a     // Catch:{ NoSuchFieldError -> 0x001d }
                androidx.datastore.preferences.protobuf.GeneratedMessageLite$MethodToInvoke r1 = androidx.datastore.preferences.protobuf.GeneratedMessageLite.MethodToInvoke.NEW_BUILDER     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f7251a     // Catch:{ NoSuchFieldError -> 0x0028 }
                androidx.datastore.preferences.protobuf.GeneratedMessageLite$MethodToInvoke r1 = androidx.datastore.preferences.protobuf.GeneratedMessageLite.MethodToInvoke.BUILD_MESSAGE_INFO     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f7251a     // Catch:{ NoSuchFieldError -> 0x0033 }
                androidx.datastore.preferences.protobuf.GeneratedMessageLite$MethodToInvoke r1 = androidx.datastore.preferences.protobuf.GeneratedMessageLite.MethodToInvoke.GET_DEFAULT_INSTANCE     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = f7251a     // Catch:{ NoSuchFieldError -> 0x003e }
                androidx.datastore.preferences.protobuf.GeneratedMessageLite$MethodToInvoke r1 = androidx.datastore.preferences.protobuf.GeneratedMessageLite.MethodToInvoke.GET_PARSER     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = f7251a     // Catch:{ NoSuchFieldError -> 0x0049 }
                androidx.datastore.preferences.protobuf.GeneratedMessageLite$MethodToInvoke r1 = androidx.datastore.preferences.protobuf.GeneratedMessageLite.MethodToInvoke.GET_MEMOIZED_IS_INITIALIZED     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                int[] r0 = f7251a     // Catch:{ NoSuchFieldError -> 0x0054 }
                androidx.datastore.preferences.protobuf.GeneratedMessageLite$MethodToInvoke r1 = androidx.datastore.preferences.protobuf.GeneratedMessageLite.MethodToInvoke.SET_MEMOIZED_IS_INITIALIZED     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.Struct.AnonymousClass1.<clinit>():void");
        }
    }

    public static final class Builder extends GeneratedMessageLite.Builder<Struct, Builder> implements StructOrBuilder {
        private Builder() {
            super(Struct.DEFAULT_INSTANCE);
        }

        public Value E2(String str) {
            str.getClass();
            Map<String, Value> u0 = ((Struct) this.X).u0();
            if (u0.containsKey(str)) {
                return u0.get(str);
            }
            throw new IllegalArgumentException();
        }

        @Deprecated
        public Map<String, Value> b1() {
            return u0();
        }

        public Value d1(String str, Value value) {
            str.getClass();
            Map<String, Value> u0 = ((Struct) this.X).u0();
            return u0.containsKey(str) ? u0.get(str) : value;
        }

        public Builder o3() {
            g3();
            ((Struct) this.X).O2().clear();
            return this;
        }

        public int p() {
            return ((Struct) this.X).u0().size();
        }

        public Builder p3(Map<String, Value> map) {
            g3();
            ((Struct) this.X).O2().putAll(map);
            return this;
        }

        public Builder q3(String str, Value value) {
            str.getClass();
            value.getClass();
            g3();
            ((Struct) this.X).O2().put(str, value);
            return this;
        }

        public Builder r3(String str) {
            str.getClass();
            g3();
            ((Struct) this.X).O2().remove(str);
            return this;
        }

        public Map<String, Value> u0() {
            return Collections.unmodifiableMap(((Struct) this.X).u0());
        }

        public boolean w0(String str) {
            str.getClass();
            return ((Struct) this.X).u0().containsKey(str);
        }

        /* synthetic */ Builder(AnonymousClass1 r1) {
            this();
        }
    }

    private static final class FieldsDefaultEntryHolder {

        /* renamed from: a  reason: collision with root package name */
        static final MapEntryLite<String, Value> f7252a = MapEntryLite.f(WireFormat.FieldType.STRING, "", WireFormat.FieldType.MESSAGE, Value.m3());

        private FieldsDefaultEntryHolder() {
        }
    }

    static {
        Struct struct = new Struct();
        DEFAULT_INSTANCE = struct;
        GeneratedMessageLite.J2(Struct.class, struct);
    }

    private Struct() {
    }

    public static Struct N2() {
        return DEFAULT_INSTANCE;
    }

    /* access modifiers changed from: private */
    public Map<String, Value> O2() {
        return Q2();
    }

    private MapFieldLite<String, Value> P2() {
        return this.fields_;
    }

    private MapFieldLite<String, Value> Q2() {
        if (!this.fields_.l()) {
            this.fields_ = this.fields_.o();
        }
        return this.fields_;
    }

    public static Builder R2() {
        return (Builder) DEFAULT_INSTANCE.i0();
    }

    public static Builder S2(Struct struct) {
        return (Builder) DEFAULT_INSTANCE.j0(struct);
    }

    public static Struct T2(InputStream inputStream) throws IOException {
        return (Struct) GeneratedMessageLite.N1(DEFAULT_INSTANCE, inputStream);
    }

    public static Struct U2(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (Struct) GeneratedMessageLite.P1(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static Struct V2(ByteString byteString) throws InvalidProtocolBufferException {
        return (Struct) GeneratedMessageLite.V1(DEFAULT_INSTANCE, byteString);
    }

    public static Struct W2(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (Struct) GeneratedMessageLite.W1(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static Struct X2(CodedInputStream codedInputStream) throws IOException {
        return (Struct) GeneratedMessageLite.X1(DEFAULT_INSTANCE, codedInputStream);
    }

    public static Struct Y2(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (Struct) GeneratedMessageLite.Y1(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }

    public static Struct Z2(InputStream inputStream) throws IOException {
        return (Struct) GeneratedMessageLite.Z1(DEFAULT_INSTANCE, inputStream);
    }

    public static Struct a3(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (Struct) GeneratedMessageLite.c2(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static Struct b3(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return (Struct) GeneratedMessageLite.h2(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Struct c3(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (Struct) GeneratedMessageLite.l2(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static Struct d3(byte[] bArr) throws InvalidProtocolBufferException {
        return (Struct) GeneratedMessageLite.o2(DEFAULT_INSTANCE, bArr);
    }

    public static Struct e3(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (Struct) GeneratedMessageLite.s2(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static Parser<Struct> f3() {
        return DEFAULT_INSTANCE.q2();
    }

    /* access modifiers changed from: protected */
    public final Object B0(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        switch (AnonymousClass1.f7251a[methodToInvoke.ordinal()]) {
            case 1:
                return new Struct();
            case 2:
                return new Builder((AnonymousClass1) null);
            case 3:
                return GeneratedMessageLite.J1(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u00012", new Object[]{"fields_", FieldsDefaultEntryHolder.f7252a});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<Struct> parser = PARSER;
                if (parser == null) {
                    synchronized (Struct.class) {
                        try {
                            parser = PARSER;
                            if (parser == null) {
                                parser = new GeneratedMessageLite.DefaultInstanceBasedParser<>(DEFAULT_INSTANCE);
                                PARSER = parser;
                            }
                        } catch (Throwable th) {
                            throw th;
                        }
                    }
                }
                return parser;
            case 6:
                return (byte) 1;
            case 7:
                return null;
            default:
                throw new UnsupportedOperationException();
        }
    }

    public Value E2(String str) {
        str.getClass();
        MapFieldLite<String, Value> P2 = P2();
        if (P2.containsKey(str)) {
            return P2.get(str);
        }
        throw new IllegalArgumentException();
    }

    @Deprecated
    public Map<String, Value> b1() {
        return u0();
    }

    public Value d1(String str, Value value) {
        str.getClass();
        MapFieldLite<String, Value> P2 = P2();
        return P2.containsKey(str) ? P2.get(str) : value;
    }

    public int p() {
        return P2().size();
    }

    public Map<String, Value> u0() {
        return Collections.unmodifiableMap(P2());
    }

    public boolean w0(String str) {
        str.getClass();
        return P2().containsKey(str);
    }
}
