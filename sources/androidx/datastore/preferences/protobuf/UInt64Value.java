package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.GeneratedMessageLite;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

public final class UInt64Value extends GeneratedMessageLite<UInt64Value, Builder> implements UInt64ValueOrBuilder {
    /* access modifiers changed from: private */
    public static final UInt64Value DEFAULT_INSTANCE;
    private static volatile Parser<UInt64Value> PARSER = null;
    public static final int VALUE_FIELD_NUMBER = 1;
    private long value_;

    /* renamed from: androidx.datastore.preferences.protobuf.UInt64Value$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f7270a;

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
                f7270a = r0
                androidx.datastore.preferences.protobuf.GeneratedMessageLite$MethodToInvoke r1 = androidx.datastore.preferences.protobuf.GeneratedMessageLite.MethodToInvoke.NEW_MUTABLE_INSTANCE     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f7270a     // Catch:{ NoSuchFieldError -> 0x001d }
                androidx.datastore.preferences.protobuf.GeneratedMessageLite$MethodToInvoke r1 = androidx.datastore.preferences.protobuf.GeneratedMessageLite.MethodToInvoke.NEW_BUILDER     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f7270a     // Catch:{ NoSuchFieldError -> 0x0028 }
                androidx.datastore.preferences.protobuf.GeneratedMessageLite$MethodToInvoke r1 = androidx.datastore.preferences.protobuf.GeneratedMessageLite.MethodToInvoke.BUILD_MESSAGE_INFO     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f7270a     // Catch:{ NoSuchFieldError -> 0x0033 }
                androidx.datastore.preferences.protobuf.GeneratedMessageLite$MethodToInvoke r1 = androidx.datastore.preferences.protobuf.GeneratedMessageLite.MethodToInvoke.GET_DEFAULT_INSTANCE     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = f7270a     // Catch:{ NoSuchFieldError -> 0x003e }
                androidx.datastore.preferences.protobuf.GeneratedMessageLite$MethodToInvoke r1 = androidx.datastore.preferences.protobuf.GeneratedMessageLite.MethodToInvoke.GET_PARSER     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = f7270a     // Catch:{ NoSuchFieldError -> 0x0049 }
                androidx.datastore.preferences.protobuf.GeneratedMessageLite$MethodToInvoke r1 = androidx.datastore.preferences.protobuf.GeneratedMessageLite.MethodToInvoke.GET_MEMOIZED_IS_INITIALIZED     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                int[] r0 = f7270a     // Catch:{ NoSuchFieldError -> 0x0054 }
                androidx.datastore.preferences.protobuf.GeneratedMessageLite$MethodToInvoke r1 = androidx.datastore.preferences.protobuf.GeneratedMessageLite.MethodToInvoke.SET_MEMOIZED_IS_INITIALIZED     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.UInt64Value.AnonymousClass1.<clinit>():void");
        }
    }

    public static final class Builder extends GeneratedMessageLite.Builder<UInt64Value, Builder> implements UInt64ValueOrBuilder {
        private Builder() {
            super(UInt64Value.DEFAULT_INSTANCE);
        }

        public long getValue() {
            return ((UInt64Value) this.X).getValue();
        }

        public Builder o3() {
            g3();
            ((UInt64Value) this.X).O2();
            return this;
        }

        public Builder p3(long j2) {
            g3();
            ((UInt64Value) this.X).g3(j2);
            return this;
        }

        /* synthetic */ Builder(AnonymousClass1 r1) {
            this();
        }
    }

    static {
        UInt64Value uInt64Value = new UInt64Value();
        DEFAULT_INSTANCE = uInt64Value;
        GeneratedMessageLite.J2(UInt64Value.class, uInt64Value);
    }

    private UInt64Value() {
    }

    /* access modifiers changed from: private */
    public void O2() {
        this.value_ = 0;
    }

    public static UInt64Value P2() {
        return DEFAULT_INSTANCE;
    }

    public static Builder Q2() {
        return (Builder) DEFAULT_INSTANCE.i0();
    }

    public static Builder R2(UInt64Value uInt64Value) {
        return (Builder) DEFAULT_INSTANCE.j0(uInt64Value);
    }

    public static UInt64Value S2(long j2) {
        return (UInt64Value) Q2().p3(j2).build();
    }

    public static UInt64Value T2(InputStream inputStream) throws IOException {
        return (UInt64Value) GeneratedMessageLite.N1(DEFAULT_INSTANCE, inputStream);
    }

    public static UInt64Value U2(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (UInt64Value) GeneratedMessageLite.P1(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static UInt64Value V2(ByteString byteString) throws InvalidProtocolBufferException {
        return (UInt64Value) GeneratedMessageLite.V1(DEFAULT_INSTANCE, byteString);
    }

    public static UInt64Value W2(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (UInt64Value) GeneratedMessageLite.W1(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static UInt64Value X2(CodedInputStream codedInputStream) throws IOException {
        return (UInt64Value) GeneratedMessageLite.X1(DEFAULT_INSTANCE, codedInputStream);
    }

    public static UInt64Value Y2(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (UInt64Value) GeneratedMessageLite.Y1(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }

    public static UInt64Value Z2(InputStream inputStream) throws IOException {
        return (UInt64Value) GeneratedMessageLite.Z1(DEFAULT_INSTANCE, inputStream);
    }

    public static UInt64Value a3(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (UInt64Value) GeneratedMessageLite.c2(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static UInt64Value b3(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return (UInt64Value) GeneratedMessageLite.h2(DEFAULT_INSTANCE, byteBuffer);
    }

    public static UInt64Value c3(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (UInt64Value) GeneratedMessageLite.l2(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static UInt64Value d3(byte[] bArr) throws InvalidProtocolBufferException {
        return (UInt64Value) GeneratedMessageLite.o2(DEFAULT_INSTANCE, bArr);
    }

    public static UInt64Value e3(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (UInt64Value) GeneratedMessageLite.s2(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static Parser<UInt64Value> f3() {
        return DEFAULT_INSTANCE.q2();
    }

    /* access modifiers changed from: private */
    public void g3(long j2) {
        this.value_ = j2;
    }

    /* access modifiers changed from: protected */
    public final Object B0(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        switch (AnonymousClass1.f7270a[methodToInvoke.ordinal()]) {
            case 1:
                return new UInt64Value();
            case 2:
                return new Builder((AnonymousClass1) null);
            case 3:
                return GeneratedMessageLite.J1(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001\u0003", new Object[]{"value_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<UInt64Value> parser = PARSER;
                if (parser == null) {
                    synchronized (UInt64Value.class) {
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

    public long getValue() {
        return this.value_;
    }
}
