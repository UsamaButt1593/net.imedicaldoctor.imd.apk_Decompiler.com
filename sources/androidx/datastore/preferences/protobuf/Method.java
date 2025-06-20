package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.GeneratedMessageLite;
import androidx.datastore.preferences.protobuf.Internal;
import androidx.datastore.preferences.protobuf.Option;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.List;

public final class Method extends GeneratedMessageLite<Method, Builder> implements MethodOrBuilder {
    /* access modifiers changed from: private */
    public static final Method DEFAULT_INSTANCE;
    public static final int NAME_FIELD_NUMBER = 1;
    public static final int OPTIONS_FIELD_NUMBER = 6;
    private static volatile Parser<Method> PARSER = null;
    public static final int REQUEST_STREAMING_FIELD_NUMBER = 3;
    public static final int REQUEST_TYPE_URL_FIELD_NUMBER = 2;
    public static final int RESPONSE_STREAMING_FIELD_NUMBER = 5;
    public static final int RESPONSE_TYPE_URL_FIELD_NUMBER = 4;
    public static final int SYNTAX_FIELD_NUMBER = 7;
    private String name_ = "";
    private Internal.ProtobufList<Option> options_ = GeneratedMessageLite.U0();
    private boolean requestStreaming_;
    private String requestTypeUrl_ = "";
    private boolean responseStreaming_;
    private String responseTypeUrl_ = "";
    private int syntax_;

    /* renamed from: androidx.datastore.preferences.protobuf.Method$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f7222a;

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
                f7222a = r0
                androidx.datastore.preferences.protobuf.GeneratedMessageLite$MethodToInvoke r1 = androidx.datastore.preferences.protobuf.GeneratedMessageLite.MethodToInvoke.NEW_MUTABLE_INSTANCE     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f7222a     // Catch:{ NoSuchFieldError -> 0x001d }
                androidx.datastore.preferences.protobuf.GeneratedMessageLite$MethodToInvoke r1 = androidx.datastore.preferences.protobuf.GeneratedMessageLite.MethodToInvoke.NEW_BUILDER     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f7222a     // Catch:{ NoSuchFieldError -> 0x0028 }
                androidx.datastore.preferences.protobuf.GeneratedMessageLite$MethodToInvoke r1 = androidx.datastore.preferences.protobuf.GeneratedMessageLite.MethodToInvoke.BUILD_MESSAGE_INFO     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f7222a     // Catch:{ NoSuchFieldError -> 0x0033 }
                androidx.datastore.preferences.protobuf.GeneratedMessageLite$MethodToInvoke r1 = androidx.datastore.preferences.protobuf.GeneratedMessageLite.MethodToInvoke.GET_DEFAULT_INSTANCE     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = f7222a     // Catch:{ NoSuchFieldError -> 0x003e }
                androidx.datastore.preferences.protobuf.GeneratedMessageLite$MethodToInvoke r1 = androidx.datastore.preferences.protobuf.GeneratedMessageLite.MethodToInvoke.GET_PARSER     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = f7222a     // Catch:{ NoSuchFieldError -> 0x0049 }
                androidx.datastore.preferences.protobuf.GeneratedMessageLite$MethodToInvoke r1 = androidx.datastore.preferences.protobuf.GeneratedMessageLite.MethodToInvoke.GET_MEMOIZED_IS_INITIALIZED     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                int[] r0 = f7222a     // Catch:{ NoSuchFieldError -> 0x0054 }
                androidx.datastore.preferences.protobuf.GeneratedMessageLite$MethodToInvoke r1 = androidx.datastore.preferences.protobuf.GeneratedMessageLite.MethodToInvoke.SET_MEMOIZED_IS_INITIALIZED     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.Method.AnonymousClass1.<clinit>():void");
        }
    }

    public static final class Builder extends GeneratedMessageLite.Builder<Method, Builder> implements MethodOrBuilder {
        private Builder() {
            super(Method.DEFAULT_INSTANCE);
        }

        public ByteString A() {
            return ((Method) this.X).A();
        }

        public Builder A3(int i2) {
            g3();
            ((Method) this.X).Q3(i2);
            return this;
        }

        public Builder B3(String str) {
            g3();
            ((Method) this.X).R3(str);
            return this;
        }

        public boolean C1() {
            return ((Method) this.X).C1();
        }

        public ByteString C2() {
            return ((Method) this.X).C2();
        }

        public Builder C3(ByteString byteString) {
            g3();
            ((Method) this.X).S3(byteString);
            return this;
        }

        public Builder D3(int i2, Option.Builder builder) {
            g3();
            ((Method) this.X).T3(i2, builder);
            return this;
        }

        public Builder E3(int i2, Option option) {
            g3();
            ((Method) this.X).U3(i2, option);
            return this;
        }

        public Builder F3(boolean z) {
            g3();
            ((Method) this.X).V3(z);
            return this;
        }

        public Builder G3(String str) {
            g3();
            ((Method) this.X).W3(str);
            return this;
        }

        public Builder H3(ByteString byteString) {
            g3();
            ((Method) this.X).X3(byteString);
            return this;
        }

        public Builder I3(boolean z) {
            g3();
            ((Method) this.X).Y3(z);
            return this;
        }

        public Builder J3(String str) {
            g3();
            ((Method) this.X).Z3(str);
            return this;
        }

        public Builder K3(ByteString byteString) {
            g3();
            ((Method) this.X).a4(byteString);
            return this;
        }

        public Builder L3(Syntax syntax) {
            g3();
            ((Method) this.X).b4(syntax);
            return this;
        }

        public Builder M3(int i2) {
            g3();
            ((Method) this.X).c4(i2);
            return this;
        }

        public String R1() {
            return ((Method) this.X).R1();
        }

        public boolean S0() {
            return ((Method) this.X).S0();
        }

        public ByteString a() {
            return ((Method) this.X).a();
        }

        public int b() {
            return ((Method) this.X).b();
        }

        public List<Option> c() {
            return Collections.unmodifiableList(((Method) this.X).c());
        }

        public Option e(int i2) {
            return ((Method) this.X).e(i2);
        }

        public Syntax f() {
            return ((Method) this.X).f();
        }

        public int g() {
            return ((Method) this.X).g();
        }

        public String getName() {
            return ((Method) this.X).getName();
        }

        public Builder o3(Iterable<? extends Option> iterable) {
            g3();
            ((Method) this.X).l3(iterable);
            return this;
        }

        public Builder p3(int i2, Option.Builder builder) {
            g3();
            ((Method) this.X).m3(i2, builder);
            return this;
        }

        public Builder q3(int i2, Option option) {
            g3();
            ((Method) this.X).n3(i2, option);
            return this;
        }

        public Builder r3(Option.Builder builder) {
            g3();
            ((Method) this.X).o3(builder);
            return this;
        }

        public Builder s3(Option option) {
            g3();
            ((Method) this.X).p3(option);
            return this;
        }

        public Builder t3() {
            g3();
            ((Method) this.X).q3();
            return this;
        }

        public Builder u3() {
            g3();
            ((Method) this.X).r3();
            return this;
        }

        public String v() {
            return ((Method) this.X).v();
        }

        public Builder v3() {
            g3();
            ((Method) this.X).s3();
            return this;
        }

        public Builder w3() {
            g3();
            ((Method) this.X).t3();
            return this;
        }

        public Builder x3() {
            g3();
            ((Method) this.X).u3();
            return this;
        }

        public Builder y3() {
            g3();
            ((Method) this.X).v3();
            return this;
        }

        public Builder z3() {
            g3();
            ((Method) this.X).w3();
            return this;
        }

        /* synthetic */ Builder(AnonymousClass1 r1) {
            this();
        }
    }

    static {
        Method method = new Method();
        DEFAULT_INSTANCE = method;
        GeneratedMessageLite.J2(Method.class, method);
    }

    private Method() {
    }

    public static Builder B3() {
        return (Builder) DEFAULT_INSTANCE.i0();
    }

    public static Builder C3(Method method) {
        return (Builder) DEFAULT_INSTANCE.j0(method);
    }

    public static Method D3(InputStream inputStream) throws IOException {
        return (Method) GeneratedMessageLite.N1(DEFAULT_INSTANCE, inputStream);
    }

    public static Method E3(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (Method) GeneratedMessageLite.P1(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static Method F3(ByteString byteString) throws InvalidProtocolBufferException {
        return (Method) GeneratedMessageLite.V1(DEFAULT_INSTANCE, byteString);
    }

    public static Method G3(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (Method) GeneratedMessageLite.W1(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static Method H3(CodedInputStream codedInputStream) throws IOException {
        return (Method) GeneratedMessageLite.X1(DEFAULT_INSTANCE, codedInputStream);
    }

    public static Method I3(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (Method) GeneratedMessageLite.Y1(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }

    public static Method J3(InputStream inputStream) throws IOException {
        return (Method) GeneratedMessageLite.Z1(DEFAULT_INSTANCE, inputStream);
    }

    public static Method K3(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (Method) GeneratedMessageLite.c2(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static Method L3(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return (Method) GeneratedMessageLite.h2(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Method M3(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (Method) GeneratedMessageLite.l2(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static Method N3(byte[] bArr) throws InvalidProtocolBufferException {
        return (Method) GeneratedMessageLite.o2(DEFAULT_INSTANCE, bArr);
    }

    public static Method O3(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (Method) GeneratedMessageLite.s2(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static Parser<Method> P3() {
        return DEFAULT_INSTANCE.q2();
    }

    /* access modifiers changed from: private */
    public void Q3(int i2) {
        x3();
        this.options_.remove(i2);
    }

    /* access modifiers changed from: private */
    public void R3(String str) {
        str.getClass();
        this.name_ = str;
    }

    /* access modifiers changed from: private */
    public void S3(ByteString byteString) {
        byteString.getClass();
        AbstractMessageLite.C(byteString);
        this.name_ = byteString.o0();
    }

    /* access modifiers changed from: private */
    public void T3(int i2, Option.Builder builder) {
        x3();
        this.options_.set(i2, builder.build());
    }

    /* access modifiers changed from: private */
    public void U3(int i2, Option option) {
        option.getClass();
        x3();
        this.options_.set(i2, option);
    }

    /* access modifiers changed from: private */
    public void V3(boolean z) {
        this.requestStreaming_ = z;
    }

    /* access modifiers changed from: private */
    public void W3(String str) {
        str.getClass();
        this.requestTypeUrl_ = str;
    }

    /* access modifiers changed from: private */
    public void X3(ByteString byteString) {
        byteString.getClass();
        AbstractMessageLite.C(byteString);
        this.requestTypeUrl_ = byteString.o0();
    }

    /* access modifiers changed from: private */
    public void Y3(boolean z) {
        this.responseStreaming_ = z;
    }

    /* access modifiers changed from: private */
    public void Z3(String str) {
        str.getClass();
        this.responseTypeUrl_ = str;
    }

    /* access modifiers changed from: private */
    public void a4(ByteString byteString) {
        byteString.getClass();
        AbstractMessageLite.C(byteString);
        this.responseTypeUrl_ = byteString.o0();
    }

    /* access modifiers changed from: private */
    public void b4(Syntax syntax) {
        syntax.getClass();
        this.syntax_ = syntax.d();
    }

    /* access modifiers changed from: private */
    public void c4(int i2) {
        this.syntax_ = i2;
    }

    /* access modifiers changed from: private */
    public void l3(Iterable<? extends Option> iterable) {
        x3();
        AbstractMessageLite.k(iterable, this.options_);
    }

    /* access modifiers changed from: private */
    public void m3(int i2, Option.Builder builder) {
        x3();
        this.options_.add(i2, builder.build());
    }

    /* access modifiers changed from: private */
    public void n3(int i2, Option option) {
        option.getClass();
        x3();
        this.options_.add(i2, option);
    }

    /* access modifiers changed from: private */
    public void o3(Option.Builder builder) {
        x3();
        this.options_.add(builder.build());
    }

    /* access modifiers changed from: private */
    public void p3(Option option) {
        option.getClass();
        x3();
        this.options_.add(option);
    }

    /* access modifiers changed from: private */
    public void q3() {
        this.name_ = y3().getName();
    }

    /* access modifiers changed from: private */
    public void r3() {
        this.options_ = GeneratedMessageLite.U0();
    }

    /* access modifiers changed from: private */
    public void s3() {
        this.requestStreaming_ = false;
    }

    /* access modifiers changed from: private */
    public void t3() {
        this.requestTypeUrl_ = y3().R1();
    }

    /* access modifiers changed from: private */
    public void u3() {
        this.responseStreaming_ = false;
    }

    /* access modifiers changed from: private */
    public void v3() {
        this.responseTypeUrl_ = y3().v();
    }

    /* access modifiers changed from: private */
    public void w3() {
        this.syntax_ = 0;
    }

    private void x3() {
        if (!this.options_.P2()) {
            this.options_ = GeneratedMessageLite.G1(this.options_);
        }
    }

    public static Method y3() {
        return DEFAULT_INSTANCE;
    }

    public ByteString A() {
        return ByteString.B(this.requestTypeUrl_);
    }

    public List<? extends OptionOrBuilder> A3() {
        return this.options_;
    }

    /* access modifiers changed from: protected */
    public final Object B0(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        switch (AnonymousClass1.f7222a[methodToInvoke.ordinal()]) {
            case 1:
                return new Method();
            case 2:
                return new Builder((AnonymousClass1) null);
            case 3:
                return GeneratedMessageLite.J1(DEFAULT_INSTANCE, "\u0000\u0007\u0000\u0000\u0001\u0007\u0007\u0000\u0001\u0000\u0001Ȉ\u0002Ȉ\u0003\u0007\u0004Ȉ\u0005\u0007\u0006\u001b\u0007\f", new Object[]{"name_", "requestTypeUrl_", "requestStreaming_", "responseTypeUrl_", "responseStreaming_", "options_", Option.class, "syntax_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<Method> parser = PARSER;
                if (parser == null) {
                    synchronized (Method.class) {
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

    public boolean C1() {
        return this.responseStreaming_;
    }

    public ByteString C2() {
        return ByteString.B(this.responseTypeUrl_);
    }

    public String R1() {
        return this.requestTypeUrl_;
    }

    public boolean S0() {
        return this.requestStreaming_;
    }

    public ByteString a() {
        return ByteString.B(this.name_);
    }

    public int b() {
        return this.options_.size();
    }

    public List<Option> c() {
        return this.options_;
    }

    public Option e(int i2) {
        return this.options_.get(i2);
    }

    public Syntax f() {
        Syntax a2 = Syntax.a(this.syntax_);
        return a2 == null ? Syntax.UNRECOGNIZED : a2;
    }

    public int g() {
        return this.syntax_;
    }

    public String getName() {
        return this.name_;
    }

    public String v() {
        return this.responseTypeUrl_;
    }

    public OptionOrBuilder z3(int i2) {
        return this.options_.get(i2);
    }
}
