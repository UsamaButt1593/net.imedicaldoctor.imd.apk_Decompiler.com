package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.GeneratedMessageLite;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

public final class DoubleValue extends GeneratedMessageLite<DoubleValue, Builder> implements DoubleValueOrBuilder {
    /* access modifiers changed from: private */
    public static final DoubleValue DEFAULT_INSTANCE;
    private static volatile Parser<DoubleValue> PARSER = null;
    public static final int VALUE_FIELD_NUMBER = 1;
    private double value_;

    /* renamed from: androidx.datastore.preferences.protobuf.DoubleValue$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f7103a;

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
                f7103a = r0
                androidx.datastore.preferences.protobuf.GeneratedMessageLite$MethodToInvoke r1 = androidx.datastore.preferences.protobuf.GeneratedMessageLite.MethodToInvoke.NEW_MUTABLE_INSTANCE     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f7103a     // Catch:{ NoSuchFieldError -> 0x001d }
                androidx.datastore.preferences.protobuf.GeneratedMessageLite$MethodToInvoke r1 = androidx.datastore.preferences.protobuf.GeneratedMessageLite.MethodToInvoke.NEW_BUILDER     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f7103a     // Catch:{ NoSuchFieldError -> 0x0028 }
                androidx.datastore.preferences.protobuf.GeneratedMessageLite$MethodToInvoke r1 = androidx.datastore.preferences.protobuf.GeneratedMessageLite.MethodToInvoke.BUILD_MESSAGE_INFO     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f7103a     // Catch:{ NoSuchFieldError -> 0x0033 }
                androidx.datastore.preferences.protobuf.GeneratedMessageLite$MethodToInvoke r1 = androidx.datastore.preferences.protobuf.GeneratedMessageLite.MethodToInvoke.GET_DEFAULT_INSTANCE     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = f7103a     // Catch:{ NoSuchFieldError -> 0x003e }
                androidx.datastore.preferences.protobuf.GeneratedMessageLite$MethodToInvoke r1 = androidx.datastore.preferences.protobuf.GeneratedMessageLite.MethodToInvoke.GET_PARSER     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = f7103a     // Catch:{ NoSuchFieldError -> 0x0049 }
                androidx.datastore.preferences.protobuf.GeneratedMessageLite$MethodToInvoke r1 = androidx.datastore.preferences.protobuf.GeneratedMessageLite.MethodToInvoke.GET_MEMOIZED_IS_INITIALIZED     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                int[] r0 = f7103a     // Catch:{ NoSuchFieldError -> 0x0054 }
                androidx.datastore.preferences.protobuf.GeneratedMessageLite$MethodToInvoke r1 = androidx.datastore.preferences.protobuf.GeneratedMessageLite.MethodToInvoke.SET_MEMOIZED_IS_INITIALIZED     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.DoubleValue.AnonymousClass1.<clinit>():void");
        }
    }

    public static final class Builder extends GeneratedMessageLite.Builder<DoubleValue, Builder> implements DoubleValueOrBuilder {
        private Builder() {
            super(DoubleValue.DEFAULT_INSTANCE);
        }

        public double getValue() {
            return ((DoubleValue) this.X).getValue();
        }

        public Builder o3() {
            g3();
            ((DoubleValue) this.X).O2();
            return this;
        }

        public Builder p3(double d2) {
            g3();
            ((DoubleValue) this.X).g3(d2);
            return this;
        }

        /* synthetic */ Builder(AnonymousClass1 r1) {
            this();
        }
    }

    static {
        DoubleValue doubleValue = new DoubleValue();
        DEFAULT_INSTANCE = doubleValue;
        GeneratedMessageLite.J2(DoubleValue.class, doubleValue);
    }

    private DoubleValue() {
    }

    /* access modifiers changed from: private */
    public void O2() {
        this.value_ = 0.0d;
    }

    public static DoubleValue P2() {
        return DEFAULT_INSTANCE;
    }

    public static Builder Q2() {
        return (Builder) DEFAULT_INSTANCE.i0();
    }

    public static Builder R2(DoubleValue doubleValue) {
        return (Builder) DEFAULT_INSTANCE.j0(doubleValue);
    }

    public static DoubleValue S2(double d2) {
        return (DoubleValue) Q2().p3(d2).build();
    }

    public static DoubleValue T2(InputStream inputStream) throws IOException {
        return (DoubleValue) GeneratedMessageLite.N1(DEFAULT_INSTANCE, inputStream);
    }

    public static DoubleValue U2(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (DoubleValue) GeneratedMessageLite.P1(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static DoubleValue V2(ByteString byteString) throws InvalidProtocolBufferException {
        return (DoubleValue) GeneratedMessageLite.V1(DEFAULT_INSTANCE, byteString);
    }

    public static DoubleValue W2(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (DoubleValue) GeneratedMessageLite.W1(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static DoubleValue X2(CodedInputStream codedInputStream) throws IOException {
        return (DoubleValue) GeneratedMessageLite.X1(DEFAULT_INSTANCE, codedInputStream);
    }

    public static DoubleValue Y2(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (DoubleValue) GeneratedMessageLite.Y1(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }

    public static DoubleValue Z2(InputStream inputStream) throws IOException {
        return (DoubleValue) GeneratedMessageLite.Z1(DEFAULT_INSTANCE, inputStream);
    }

    public static DoubleValue a3(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (DoubleValue) GeneratedMessageLite.c2(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static DoubleValue b3(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return (DoubleValue) GeneratedMessageLite.h2(DEFAULT_INSTANCE, byteBuffer);
    }

    public static DoubleValue c3(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (DoubleValue) GeneratedMessageLite.l2(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static DoubleValue d3(byte[] bArr) throws InvalidProtocolBufferException {
        return (DoubleValue) GeneratedMessageLite.o2(DEFAULT_INSTANCE, bArr);
    }

    public static DoubleValue e3(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (DoubleValue) GeneratedMessageLite.s2(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static Parser<DoubleValue> f3() {
        return DEFAULT_INSTANCE.q2();
    }

    /* access modifiers changed from: private */
    public void g3(double d2) {
        this.value_ = d2;
    }

    /* access modifiers changed from: protected */
    public final Object B0(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        switch (AnonymousClass1.f7103a[methodToInvoke.ordinal()]) {
            case 1:
                return new DoubleValue();
            case 2:
                return new Builder((AnonymousClass1) null);
            case 3:
                return GeneratedMessageLite.J1(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001\u0000", new Object[]{"value_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<DoubleValue> parser = PARSER;
                if (parser == null) {
                    synchronized (DoubleValue.class) {
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

    public double getValue() {
        return this.value_;
    }
}
