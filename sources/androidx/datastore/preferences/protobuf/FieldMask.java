package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.GeneratedMessageLite;
import androidx.datastore.preferences.protobuf.Internal;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.List;

public final class FieldMask extends GeneratedMessageLite<FieldMask, Builder> implements FieldMaskOrBuilder {
    /* access modifiers changed from: private */
    public static final FieldMask DEFAULT_INSTANCE;
    private static volatile Parser<FieldMask> PARSER = null;
    public static final int PATHS_FIELD_NUMBER = 1;
    private Internal.ProtobufList<String> paths_ = GeneratedMessageLite.U0();

    /* renamed from: androidx.datastore.preferences.protobuf.FieldMask$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f7138a;

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
                f7138a = r0
                androidx.datastore.preferences.protobuf.GeneratedMessageLite$MethodToInvoke r1 = androidx.datastore.preferences.protobuf.GeneratedMessageLite.MethodToInvoke.NEW_MUTABLE_INSTANCE     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f7138a     // Catch:{ NoSuchFieldError -> 0x001d }
                androidx.datastore.preferences.protobuf.GeneratedMessageLite$MethodToInvoke r1 = androidx.datastore.preferences.protobuf.GeneratedMessageLite.MethodToInvoke.NEW_BUILDER     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f7138a     // Catch:{ NoSuchFieldError -> 0x0028 }
                androidx.datastore.preferences.protobuf.GeneratedMessageLite$MethodToInvoke r1 = androidx.datastore.preferences.protobuf.GeneratedMessageLite.MethodToInvoke.BUILD_MESSAGE_INFO     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f7138a     // Catch:{ NoSuchFieldError -> 0x0033 }
                androidx.datastore.preferences.protobuf.GeneratedMessageLite$MethodToInvoke r1 = androidx.datastore.preferences.protobuf.GeneratedMessageLite.MethodToInvoke.GET_DEFAULT_INSTANCE     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = f7138a     // Catch:{ NoSuchFieldError -> 0x003e }
                androidx.datastore.preferences.protobuf.GeneratedMessageLite$MethodToInvoke r1 = androidx.datastore.preferences.protobuf.GeneratedMessageLite.MethodToInvoke.GET_PARSER     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = f7138a     // Catch:{ NoSuchFieldError -> 0x0049 }
                androidx.datastore.preferences.protobuf.GeneratedMessageLite$MethodToInvoke r1 = androidx.datastore.preferences.protobuf.GeneratedMessageLite.MethodToInvoke.GET_MEMOIZED_IS_INITIALIZED     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                int[] r0 = f7138a     // Catch:{ NoSuchFieldError -> 0x0054 }
                androidx.datastore.preferences.protobuf.GeneratedMessageLite$MethodToInvoke r1 = androidx.datastore.preferences.protobuf.GeneratedMessageLite.MethodToInvoke.SET_MEMOIZED_IS_INITIALIZED     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.FieldMask.AnonymousClass1.<clinit>():void");
        }
    }

    public static final class Builder extends GeneratedMessageLite.Builder<FieldMask, Builder> implements FieldMaskOrBuilder {
        private Builder() {
            super(FieldMask.DEFAULT_INSTANCE);
        }

        public int G0() {
            return ((FieldMask) this.X).G0();
        }

        public ByteString W0(int i2) {
            return ((FieldMask) this.X).W0(i2);
        }

        public String m2(int i2) {
            return ((FieldMask) this.X).m2(i2);
        }

        public Builder o3(Iterable<String> iterable) {
            g3();
            ((FieldMask) this.X).R2(iterable);
            return this;
        }

        public Builder p3(String str) {
            g3();
            ((FieldMask) this.X).S2(str);
            return this;
        }

        public Builder q3(ByteString byteString) {
            g3();
            ((FieldMask) this.X).T2(byteString);
            return this;
        }

        public Builder r3() {
            g3();
            ((FieldMask) this.X).U2();
            return this;
        }

        public Builder s3(int i2, String str) {
            g3();
            ((FieldMask) this.X).m3(i2, str);
            return this;
        }

        public List<String> t0() {
            return Collections.unmodifiableList(((FieldMask) this.X).t0());
        }

        /* synthetic */ Builder(AnonymousClass1 r1) {
            this();
        }
    }

    static {
        FieldMask fieldMask = new FieldMask();
        DEFAULT_INSTANCE = fieldMask;
        GeneratedMessageLite.J2(FieldMask.class, fieldMask);
    }

    private FieldMask() {
    }

    /* access modifiers changed from: private */
    public void R2(Iterable<String> iterable) {
        V2();
        AbstractMessageLite.k(iterable, this.paths_);
    }

    /* access modifiers changed from: private */
    public void S2(String str) {
        str.getClass();
        V2();
        this.paths_.add(str);
    }

    /* access modifiers changed from: private */
    public void T2(ByteString byteString) {
        byteString.getClass();
        AbstractMessageLite.C(byteString);
        V2();
        this.paths_.add(byteString.o0());
    }

    /* access modifiers changed from: private */
    public void U2() {
        this.paths_ = GeneratedMessageLite.U0();
    }

    private void V2() {
        if (!this.paths_.P2()) {
            this.paths_ = GeneratedMessageLite.G1(this.paths_);
        }
    }

    public static FieldMask W2() {
        return DEFAULT_INSTANCE;
    }

    public static Builder X2() {
        return (Builder) DEFAULT_INSTANCE.i0();
    }

    public static Builder Y2(FieldMask fieldMask) {
        return (Builder) DEFAULT_INSTANCE.j0(fieldMask);
    }

    public static FieldMask Z2(InputStream inputStream) throws IOException {
        return (FieldMask) GeneratedMessageLite.N1(DEFAULT_INSTANCE, inputStream);
    }

    public static FieldMask a3(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (FieldMask) GeneratedMessageLite.P1(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static FieldMask b3(ByteString byteString) throws InvalidProtocolBufferException {
        return (FieldMask) GeneratedMessageLite.V1(DEFAULT_INSTANCE, byteString);
    }

    public static FieldMask c3(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (FieldMask) GeneratedMessageLite.W1(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static FieldMask d3(CodedInputStream codedInputStream) throws IOException {
        return (FieldMask) GeneratedMessageLite.X1(DEFAULT_INSTANCE, codedInputStream);
    }

    public static FieldMask e3(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (FieldMask) GeneratedMessageLite.Y1(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }

    public static FieldMask f3(InputStream inputStream) throws IOException {
        return (FieldMask) GeneratedMessageLite.Z1(DEFAULT_INSTANCE, inputStream);
    }

    public static FieldMask g3(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (FieldMask) GeneratedMessageLite.c2(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static FieldMask h3(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return (FieldMask) GeneratedMessageLite.h2(DEFAULT_INSTANCE, byteBuffer);
    }

    public static FieldMask i3(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (FieldMask) GeneratedMessageLite.l2(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static FieldMask j3(byte[] bArr) throws InvalidProtocolBufferException {
        return (FieldMask) GeneratedMessageLite.o2(DEFAULT_INSTANCE, bArr);
    }

    public static FieldMask k3(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (FieldMask) GeneratedMessageLite.s2(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static Parser<FieldMask> l3() {
        return DEFAULT_INSTANCE.q2();
    }

    /* access modifiers changed from: private */
    public void m3(int i2, String str) {
        str.getClass();
        V2();
        this.paths_.set(i2, str);
    }

    /* access modifiers changed from: protected */
    public final Object B0(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        switch (AnonymousClass1.f7138a[methodToInvoke.ordinal()]) {
            case 1:
                return new FieldMask();
            case 2:
                return new Builder((AnonymousClass1) null);
            case 3:
                return GeneratedMessageLite.J1(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001Ț", new Object[]{"paths_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<FieldMask> parser = PARSER;
                if (parser == null) {
                    synchronized (FieldMask.class) {
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

    public int G0() {
        return this.paths_.size();
    }

    public ByteString W0(int i2) {
        return ByteString.B(this.paths_.get(i2));
    }

    public String m2(int i2) {
        return this.paths_.get(i2);
    }

    public List<String> t0() {
        return this.paths_;
    }
}
