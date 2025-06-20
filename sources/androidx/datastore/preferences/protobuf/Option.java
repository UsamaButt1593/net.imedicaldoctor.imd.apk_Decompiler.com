package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.Any;
import androidx.datastore.preferences.protobuf.GeneratedMessageLite;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

public final class Option extends GeneratedMessageLite<Option, Builder> implements OptionOrBuilder {
    /* access modifiers changed from: private */
    public static final Option DEFAULT_INSTANCE;
    public static final int NAME_FIELD_NUMBER = 1;
    private static volatile Parser<Option> PARSER = null;
    public static final int VALUE_FIELD_NUMBER = 2;
    private String name_ = "";
    private Any value_;

    /* renamed from: androidx.datastore.preferences.protobuf.Option$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f7231a;

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
                f7231a = r0
                androidx.datastore.preferences.protobuf.GeneratedMessageLite$MethodToInvoke r1 = androidx.datastore.preferences.protobuf.GeneratedMessageLite.MethodToInvoke.NEW_MUTABLE_INSTANCE     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f7231a     // Catch:{ NoSuchFieldError -> 0x001d }
                androidx.datastore.preferences.protobuf.GeneratedMessageLite$MethodToInvoke r1 = androidx.datastore.preferences.protobuf.GeneratedMessageLite.MethodToInvoke.NEW_BUILDER     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f7231a     // Catch:{ NoSuchFieldError -> 0x0028 }
                androidx.datastore.preferences.protobuf.GeneratedMessageLite$MethodToInvoke r1 = androidx.datastore.preferences.protobuf.GeneratedMessageLite.MethodToInvoke.BUILD_MESSAGE_INFO     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f7231a     // Catch:{ NoSuchFieldError -> 0x0033 }
                androidx.datastore.preferences.protobuf.GeneratedMessageLite$MethodToInvoke r1 = androidx.datastore.preferences.protobuf.GeneratedMessageLite.MethodToInvoke.GET_DEFAULT_INSTANCE     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = f7231a     // Catch:{ NoSuchFieldError -> 0x003e }
                androidx.datastore.preferences.protobuf.GeneratedMessageLite$MethodToInvoke r1 = androidx.datastore.preferences.protobuf.GeneratedMessageLite.MethodToInvoke.GET_PARSER     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = f7231a     // Catch:{ NoSuchFieldError -> 0x0049 }
                androidx.datastore.preferences.protobuf.GeneratedMessageLite$MethodToInvoke r1 = androidx.datastore.preferences.protobuf.GeneratedMessageLite.MethodToInvoke.GET_MEMOIZED_IS_INITIALIZED     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                int[] r0 = f7231a     // Catch:{ NoSuchFieldError -> 0x0054 }
                androidx.datastore.preferences.protobuf.GeneratedMessageLite$MethodToInvoke r1 = androidx.datastore.preferences.protobuf.GeneratedMessageLite.MethodToInvoke.SET_MEMOIZED_IS_INITIALIZED     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.Option.AnonymousClass1.<clinit>():void");
        }
    }

    public static final class Builder extends GeneratedMessageLite.Builder<Option, Builder> implements OptionOrBuilder {
        private Builder() {
            super(Option.DEFAULT_INSTANCE);
        }

        public boolean D0() {
            return ((Option) this.X).D0();
        }

        public ByteString a() {
            return ((Option) this.X).a();
        }

        public String getName() {
            return ((Option) this.X).getName();
        }

        public Any getValue() {
            return ((Option) this.X).getValue();
        }

        public Builder o3() {
            g3();
            ((Option) this.X).T2();
            return this;
        }

        public Builder p3() {
            g3();
            ((Option) this.X).U2();
            return this;
        }

        public Builder q3(Any any) {
            g3();
            ((Option) this.X).W2(any);
            return this;
        }

        public Builder r3(String str) {
            g3();
            ((Option) this.X).m3(str);
            return this;
        }

        public Builder s3(ByteString byteString) {
            g3();
            ((Option) this.X).n3(byteString);
            return this;
        }

        public Builder t3(Any.Builder builder) {
            g3();
            ((Option) this.X).o3(builder);
            return this;
        }

        public Builder u3(Any any) {
            g3();
            ((Option) this.X).p3(any);
            return this;
        }

        /* synthetic */ Builder(AnonymousClass1 r1) {
            this();
        }
    }

    static {
        Option option = new Option();
        DEFAULT_INSTANCE = option;
        GeneratedMessageLite.J2(Option.class, option);
    }

    private Option() {
    }

    /* access modifiers changed from: private */
    public void T2() {
        this.name_ = V2().getName();
    }

    /* access modifiers changed from: private */
    public void U2() {
        this.value_ = null;
    }

    public static Option V2() {
        return DEFAULT_INSTANCE;
    }

    /* access modifiers changed from: private */
    public void W2(Any any) {
        any.getClass();
        Any any2 = this.value_;
        if (!(any2 == null || any2 == Any.T2())) {
            any = (Any) ((Any.Builder) Any.V2(this.value_).k3(any)).M1();
        }
        this.value_ = any;
    }

    public static Builder X2() {
        return (Builder) DEFAULT_INSTANCE.i0();
    }

    public static Builder Y2(Option option) {
        return (Builder) DEFAULT_INSTANCE.j0(option);
    }

    public static Option Z2(InputStream inputStream) throws IOException {
        return (Option) GeneratedMessageLite.N1(DEFAULT_INSTANCE, inputStream);
    }

    public static Option a3(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (Option) GeneratedMessageLite.P1(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static Option b3(ByteString byteString) throws InvalidProtocolBufferException {
        return (Option) GeneratedMessageLite.V1(DEFAULT_INSTANCE, byteString);
    }

    public static Option c3(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (Option) GeneratedMessageLite.W1(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static Option d3(CodedInputStream codedInputStream) throws IOException {
        return (Option) GeneratedMessageLite.X1(DEFAULT_INSTANCE, codedInputStream);
    }

    public static Option e3(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (Option) GeneratedMessageLite.Y1(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }

    public static Option f3(InputStream inputStream) throws IOException {
        return (Option) GeneratedMessageLite.Z1(DEFAULT_INSTANCE, inputStream);
    }

    public static Option g3(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (Option) GeneratedMessageLite.c2(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static Option h3(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return (Option) GeneratedMessageLite.h2(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Option i3(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (Option) GeneratedMessageLite.l2(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static Option j3(byte[] bArr) throws InvalidProtocolBufferException {
        return (Option) GeneratedMessageLite.o2(DEFAULT_INSTANCE, bArr);
    }

    public static Option k3(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (Option) GeneratedMessageLite.s2(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static Parser<Option> l3() {
        return DEFAULT_INSTANCE.q2();
    }

    /* access modifiers changed from: private */
    public void m3(String str) {
        str.getClass();
        this.name_ = str;
    }

    /* access modifiers changed from: private */
    public void n3(ByteString byteString) {
        byteString.getClass();
        AbstractMessageLite.C(byteString);
        this.name_ = byteString.o0();
    }

    /* access modifiers changed from: private */
    public void o3(Any.Builder builder) {
        this.value_ = (Any) builder.build();
    }

    /* access modifiers changed from: private */
    public void p3(Any any) {
        any.getClass();
        this.value_ = any;
    }

    /* access modifiers changed from: protected */
    public final Object B0(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        switch (AnonymousClass1.f7231a[methodToInvoke.ordinal()]) {
            case 1:
                return new Option();
            case 2:
                return new Builder((AnonymousClass1) null);
            case 3:
                return GeneratedMessageLite.J1(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001Ȉ\u0002\t", new Object[]{"name_", "value_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<Option> parser = PARSER;
                if (parser == null) {
                    synchronized (Option.class) {
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

    public boolean D0() {
        return this.value_ != null;
    }

    public ByteString a() {
        return ByteString.B(this.name_);
    }

    public String getName() {
        return this.name_;
    }

    public Any getValue() {
        Any any = this.value_;
        return any == null ? Any.T2() : any;
    }
}
