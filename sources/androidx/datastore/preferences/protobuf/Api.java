package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.GeneratedMessageLite;
import androidx.datastore.preferences.protobuf.Internal;
import androidx.datastore.preferences.protobuf.Method;
import androidx.datastore.preferences.protobuf.Mixin;
import androidx.datastore.preferences.protobuf.Option;
import androidx.datastore.preferences.protobuf.SourceContext;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.List;

public final class Api extends GeneratedMessageLite<Api, Builder> implements ApiOrBuilder {
    /* access modifiers changed from: private */
    public static final Api DEFAULT_INSTANCE;
    public static final int METHODS_FIELD_NUMBER = 2;
    public static final int MIXINS_FIELD_NUMBER = 6;
    public static final int NAME_FIELD_NUMBER = 1;
    public static final int OPTIONS_FIELD_NUMBER = 3;
    private static volatile Parser<Api> PARSER = null;
    public static final int SOURCE_CONTEXT_FIELD_NUMBER = 5;
    public static final int SYNTAX_FIELD_NUMBER = 7;
    public static final int VERSION_FIELD_NUMBER = 4;
    private Internal.ProtobufList<Method> methods_ = GeneratedMessageLite.U0();
    private Internal.ProtobufList<Mixin> mixins_ = GeneratedMessageLite.U0();
    private String name_ = "";
    private Internal.ProtobufList<Option> options_ = GeneratedMessageLite.U0();
    private SourceContext sourceContext_;
    private int syntax_;
    private String version_ = "";

    /* renamed from: androidx.datastore.preferences.protobuf.Api$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f6974a;

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
                f6974a = r0
                androidx.datastore.preferences.protobuf.GeneratedMessageLite$MethodToInvoke r1 = androidx.datastore.preferences.protobuf.GeneratedMessageLite.MethodToInvoke.NEW_MUTABLE_INSTANCE     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f6974a     // Catch:{ NoSuchFieldError -> 0x001d }
                androidx.datastore.preferences.protobuf.GeneratedMessageLite$MethodToInvoke r1 = androidx.datastore.preferences.protobuf.GeneratedMessageLite.MethodToInvoke.NEW_BUILDER     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f6974a     // Catch:{ NoSuchFieldError -> 0x0028 }
                androidx.datastore.preferences.protobuf.GeneratedMessageLite$MethodToInvoke r1 = androidx.datastore.preferences.protobuf.GeneratedMessageLite.MethodToInvoke.BUILD_MESSAGE_INFO     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f6974a     // Catch:{ NoSuchFieldError -> 0x0033 }
                androidx.datastore.preferences.protobuf.GeneratedMessageLite$MethodToInvoke r1 = androidx.datastore.preferences.protobuf.GeneratedMessageLite.MethodToInvoke.GET_DEFAULT_INSTANCE     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = f6974a     // Catch:{ NoSuchFieldError -> 0x003e }
                androidx.datastore.preferences.protobuf.GeneratedMessageLite$MethodToInvoke r1 = androidx.datastore.preferences.protobuf.GeneratedMessageLite.MethodToInvoke.GET_PARSER     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = f6974a     // Catch:{ NoSuchFieldError -> 0x0049 }
                androidx.datastore.preferences.protobuf.GeneratedMessageLite$MethodToInvoke r1 = androidx.datastore.preferences.protobuf.GeneratedMessageLite.MethodToInvoke.GET_MEMOIZED_IS_INITIALIZED     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                int[] r0 = f6974a     // Catch:{ NoSuchFieldError -> 0x0054 }
                androidx.datastore.preferences.protobuf.GeneratedMessageLite$MethodToInvoke r1 = androidx.datastore.preferences.protobuf.GeneratedMessageLite.MethodToInvoke.SET_MEMOIZED_IS_INITIALIZED     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.Api.AnonymousClass1.<clinit>():void");
        }
    }

    public static final class Builder extends GeneratedMessageLite.Builder<Api, Builder> implements ApiOrBuilder {
        private Builder() {
            super(Api.DEFAULT_INSTANCE);
        }

        public Builder A3(int i2, Option option) {
            g3();
            ((Api) this.X).M3(i2, option);
            return this;
        }

        public Builder B3(Option.Builder builder) {
            g3();
            ((Api) this.X).N3(builder);
            return this;
        }

        public Builder C3(Option option) {
            g3();
            ((Api) this.X).O3(option);
            return this;
        }

        public Builder D3() {
            g3();
            ((Api) this.X).P3();
            return this;
        }

        public Builder E3() {
            g3();
            ((Api) this.X).Q3();
            return this;
        }

        public int F1() {
            return ((Api) this.X).F1();
        }

        public Builder F3() {
            g3();
            ((Api) this.X).R3();
            return this;
        }

        public Builder G3() {
            g3();
            ((Api) this.X).S3();
            return this;
        }

        public Builder H3() {
            g3();
            ((Api) this.X).T3();
            return this;
        }

        public Builder I3() {
            g3();
            ((Api) this.X).U3();
            return this;
        }

        public Builder J3() {
            g3();
            ((Api) this.X).V3();
            return this;
        }

        public Builder K3(SourceContext sourceContext) {
            g3();
            ((Api) this.X).g4(sourceContext);
            return this;
        }

        public Builder L3(int i2) {
            g3();
            ((Api) this.X).w4(i2);
            return this;
        }

        public Method M0(int i2) {
            return ((Api) this.X).M0(i2);
        }

        public Builder M3(int i2) {
            g3();
            ((Api) this.X).x4(i2);
            return this;
        }

        public Builder N3(int i2) {
            g3();
            ((Api) this.X).y4(i2);
            return this;
        }

        public Builder O3(int i2, Method.Builder builder) {
            g3();
            ((Api) this.X).z4(i2, builder);
            return this;
        }

        public Builder P3(int i2, Method method) {
            g3();
            ((Api) this.X).A4(i2, method);
            return this;
        }

        public Builder Q3(int i2, Mixin.Builder builder) {
            g3();
            ((Api) this.X).B4(i2, builder);
            return this;
        }

        public Builder R3(int i2, Mixin mixin) {
            g3();
            ((Api) this.X).C4(i2, mixin);
            return this;
        }

        public Builder S3(String str) {
            g3();
            ((Api) this.X).D4(str);
            return this;
        }

        public Builder T3(ByteString byteString) {
            g3();
            ((Api) this.X).E4(byteString);
            return this;
        }

        public Builder U3(int i2, Option.Builder builder) {
            g3();
            ((Api) this.X).F4(i2, builder);
            return this;
        }

        public Builder V3(int i2, Option option) {
            g3();
            ((Api) this.X).G4(i2, option);
            return this;
        }

        public Builder W3(SourceContext.Builder builder) {
            g3();
            ((Api) this.X).H4(builder);
            return this;
        }

        public Builder X3(SourceContext sourceContext) {
            g3();
            ((Api) this.X).I4(sourceContext);
            return this;
        }

        public List<Method> Y0() {
            return Collections.unmodifiableList(((Api) this.X).Y0());
        }

        public Builder Y3(Syntax syntax) {
            g3();
            ((Api) this.X).J4(syntax);
            return this;
        }

        public Builder Z3(int i2) {
            g3();
            ((Api) this.X).K4(i2);
            return this;
        }

        public ByteString a() {
            return ((Api) this.X).a();
        }

        public Builder a4(String str) {
            g3();
            ((Api) this.X).L4(str);
            return this;
        }

        public int b() {
            return ((Api) this.X).b();
        }

        public Builder b4(ByteString byteString) {
            g3();
            ((Api) this.X).M4(byteString);
            return this;
        }

        public List<Option> c() {
            return Collections.unmodifiableList(((Api) this.X).c());
        }

        public Option e(int i2) {
            return ((Api) this.X).e(i2);
        }

        public Syntax f() {
            return ((Api) this.X).f();
        }

        public int g() {
            return ((Api) this.X).g();
        }

        public String getName() {
            return ((Api) this.X).getName();
        }

        public String getVersion() {
            return ((Api) this.X).getVersion();
        }

        public SourceContext h() {
            return ((Api) this.X).h();
        }

        public ByteString k0() {
            return ((Api) this.X).k0();
        }

        public boolean l() {
            return ((Api) this.X).l();
        }

        public Mixin n2(int i2) {
            return ((Api) this.X).n2(i2);
        }

        public Builder o3(Iterable<? extends Method> iterable) {
            g3();
            ((Api) this.X).A3(iterable);
            return this;
        }

        public Builder p3(Iterable<? extends Mixin> iterable) {
            g3();
            ((Api) this.X).B3(iterable);
            return this;
        }

        public Builder q3(Iterable<? extends Option> iterable) {
            g3();
            ((Api) this.X).C3(iterable);
            return this;
        }

        public Builder r3(int i2, Method.Builder builder) {
            g3();
            ((Api) this.X).D3(i2, builder);
            return this;
        }

        public int s0() {
            return ((Api) this.X).s0();
        }

        public Builder s3(int i2, Method method) {
            g3();
            ((Api) this.X).E3(i2, method);
            return this;
        }

        public Builder t3(Method.Builder builder) {
            g3();
            ((Api) this.X).F3(builder);
            return this;
        }

        public Builder u3(Method method) {
            g3();
            ((Api) this.X).G3(method);
            return this;
        }

        public Builder v3(int i2, Mixin.Builder builder) {
            g3();
            ((Api) this.X).H3(i2, builder);
            return this;
        }

        public Builder w3(int i2, Mixin mixin) {
            g3();
            ((Api) this.X).I3(i2, mixin);
            return this;
        }

        public Builder x3(Mixin.Builder builder) {
            g3();
            ((Api) this.X).J3(builder);
            return this;
        }

        public List<Mixin> y0() {
            return Collections.unmodifiableList(((Api) this.X).y0());
        }

        public Builder y3(Mixin mixin) {
            g3();
            ((Api) this.X).K3(mixin);
            return this;
        }

        public Builder z3(int i2, Option.Builder builder) {
            g3();
            ((Api) this.X).L3(i2, builder);
            return this;
        }

        /* synthetic */ Builder(AnonymousClass1 r1) {
            this();
        }
    }

    static {
        Api api = new Api();
        DEFAULT_INSTANCE = api;
        GeneratedMessageLite.J2(Api.class, api);
    }

    private Api() {
    }

    /* access modifiers changed from: private */
    public void A3(Iterable<? extends Method> iterable) {
        W3();
        AbstractMessageLite.k(iterable, this.methods_);
    }

    /* access modifiers changed from: private */
    public void A4(int i2, Method method) {
        method.getClass();
        W3();
        this.methods_.set(i2, method);
    }

    /* access modifiers changed from: private */
    public void B3(Iterable<? extends Mixin> iterable) {
        X3();
        AbstractMessageLite.k(iterable, this.mixins_);
    }

    /* access modifiers changed from: private */
    public void B4(int i2, Mixin.Builder builder) {
        X3();
        this.mixins_.set(i2, builder.build());
    }

    /* access modifiers changed from: private */
    public void C3(Iterable<? extends Option> iterable) {
        Y3();
        AbstractMessageLite.k(iterable, this.options_);
    }

    /* access modifiers changed from: private */
    public void C4(int i2, Mixin mixin) {
        mixin.getClass();
        X3();
        this.mixins_.set(i2, mixin);
    }

    /* access modifiers changed from: private */
    public void D3(int i2, Method.Builder builder) {
        W3();
        this.methods_.add(i2, builder.build());
    }

    /* access modifiers changed from: private */
    public void D4(String str) {
        str.getClass();
        this.name_ = str;
    }

    /* access modifiers changed from: private */
    public void E3(int i2, Method method) {
        method.getClass();
        W3();
        this.methods_.add(i2, method);
    }

    /* access modifiers changed from: private */
    public void E4(ByteString byteString) {
        byteString.getClass();
        AbstractMessageLite.C(byteString);
        this.name_ = byteString.o0();
    }

    /* access modifiers changed from: private */
    public void F3(Method.Builder builder) {
        W3();
        this.methods_.add(builder.build());
    }

    /* access modifiers changed from: private */
    public void F4(int i2, Option.Builder builder) {
        Y3();
        this.options_.set(i2, builder.build());
    }

    /* access modifiers changed from: private */
    public void G3(Method method) {
        method.getClass();
        W3();
        this.methods_.add(method);
    }

    /* access modifiers changed from: private */
    public void G4(int i2, Option option) {
        option.getClass();
        Y3();
        this.options_.set(i2, option);
    }

    /* access modifiers changed from: private */
    public void H3(int i2, Mixin.Builder builder) {
        X3();
        this.mixins_.add(i2, builder.build());
    }

    /* access modifiers changed from: private */
    public void H4(SourceContext.Builder builder) {
        this.sourceContext_ = (SourceContext) builder.build();
    }

    /* access modifiers changed from: private */
    public void I3(int i2, Mixin mixin) {
        mixin.getClass();
        X3();
        this.mixins_.add(i2, mixin);
    }

    /* access modifiers changed from: private */
    public void I4(SourceContext sourceContext) {
        sourceContext.getClass();
        this.sourceContext_ = sourceContext;
    }

    /* access modifiers changed from: private */
    public void J3(Mixin.Builder builder) {
        X3();
        this.mixins_.add(builder.build());
    }

    /* access modifiers changed from: private */
    public void J4(Syntax syntax) {
        syntax.getClass();
        this.syntax_ = syntax.d();
    }

    /* access modifiers changed from: private */
    public void K3(Mixin mixin) {
        mixin.getClass();
        X3();
        this.mixins_.add(mixin);
    }

    /* access modifiers changed from: private */
    public void K4(int i2) {
        this.syntax_ = i2;
    }

    /* access modifiers changed from: private */
    public void L3(int i2, Option.Builder builder) {
        Y3();
        this.options_.add(i2, builder.build());
    }

    /* access modifiers changed from: private */
    public void L4(String str) {
        str.getClass();
        this.version_ = str;
    }

    /* access modifiers changed from: private */
    public void M3(int i2, Option option) {
        option.getClass();
        Y3();
        this.options_.add(i2, option);
    }

    /* access modifiers changed from: private */
    public void M4(ByteString byteString) {
        byteString.getClass();
        AbstractMessageLite.C(byteString);
        this.version_ = byteString.o0();
    }

    /* access modifiers changed from: private */
    public void N3(Option.Builder builder) {
        Y3();
        this.options_.add(builder.build());
    }

    /* access modifiers changed from: private */
    public void O3(Option option) {
        option.getClass();
        Y3();
        this.options_.add(option);
    }

    /* access modifiers changed from: private */
    public void P3() {
        this.methods_ = GeneratedMessageLite.U0();
    }

    /* access modifiers changed from: private */
    public void Q3() {
        this.mixins_ = GeneratedMessageLite.U0();
    }

    /* access modifiers changed from: private */
    public void R3() {
        this.name_ = Z3().getName();
    }

    /* access modifiers changed from: private */
    public void S3() {
        this.options_ = GeneratedMessageLite.U0();
    }

    /* access modifiers changed from: private */
    public void T3() {
        this.sourceContext_ = null;
    }

    /* access modifiers changed from: private */
    public void U3() {
        this.syntax_ = 0;
    }

    /* access modifiers changed from: private */
    public void V3() {
        this.version_ = Z3().getVersion();
    }

    private void W3() {
        if (!this.methods_.P2()) {
            this.methods_ = GeneratedMessageLite.G1(this.methods_);
        }
    }

    private void X3() {
        if (!this.mixins_.P2()) {
            this.mixins_ = GeneratedMessageLite.G1(this.mixins_);
        }
    }

    private void Y3() {
        if (!this.options_.P2()) {
            this.options_ = GeneratedMessageLite.G1(this.options_);
        }
    }

    public static Api Z3() {
        return DEFAULT_INSTANCE;
    }

    /* access modifiers changed from: private */
    public void g4(SourceContext sourceContext) {
        sourceContext.getClass();
        SourceContext sourceContext2 = this.sourceContext_;
        if (!(sourceContext2 == null || sourceContext2 == SourceContext.Q2())) {
            sourceContext = (SourceContext) ((SourceContext.Builder) SourceContext.S2(this.sourceContext_).k3(sourceContext)).M1();
        }
        this.sourceContext_ = sourceContext;
    }

    public static Builder h4() {
        return (Builder) DEFAULT_INSTANCE.i0();
    }

    public static Builder i4(Api api) {
        return (Builder) DEFAULT_INSTANCE.j0(api);
    }

    public static Api j4(InputStream inputStream) throws IOException {
        return (Api) GeneratedMessageLite.N1(DEFAULT_INSTANCE, inputStream);
    }

    public static Api k4(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (Api) GeneratedMessageLite.P1(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static Api l4(ByteString byteString) throws InvalidProtocolBufferException {
        return (Api) GeneratedMessageLite.V1(DEFAULT_INSTANCE, byteString);
    }

    public static Api m4(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (Api) GeneratedMessageLite.W1(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static Api n4(CodedInputStream codedInputStream) throws IOException {
        return (Api) GeneratedMessageLite.X1(DEFAULT_INSTANCE, codedInputStream);
    }

    public static Api o4(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (Api) GeneratedMessageLite.Y1(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }

    public static Api p4(InputStream inputStream) throws IOException {
        return (Api) GeneratedMessageLite.Z1(DEFAULT_INSTANCE, inputStream);
    }

    public static Api q4(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (Api) GeneratedMessageLite.c2(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static Api r4(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return (Api) GeneratedMessageLite.h2(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Api s4(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (Api) GeneratedMessageLite.l2(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static Api t4(byte[] bArr) throws InvalidProtocolBufferException {
        return (Api) GeneratedMessageLite.o2(DEFAULT_INSTANCE, bArr);
    }

    public static Api u4(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (Api) GeneratedMessageLite.s2(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static Parser<Api> v4() {
        return DEFAULT_INSTANCE.q2();
    }

    /* access modifiers changed from: private */
    public void w4(int i2) {
        W3();
        this.methods_.remove(i2);
    }

    /* access modifiers changed from: private */
    public void x4(int i2) {
        X3();
        this.mixins_.remove(i2);
    }

    /* access modifiers changed from: private */
    public void y4(int i2) {
        Y3();
        this.options_.remove(i2);
    }

    /* access modifiers changed from: private */
    public void z4(int i2, Method.Builder builder) {
        W3();
        this.methods_.set(i2, builder.build());
    }

    /* access modifiers changed from: protected */
    public final Object B0(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        switch (AnonymousClass1.f6974a[methodToInvoke.ordinal()]) {
            case 1:
                return new Api();
            case 2:
                return new Builder((AnonymousClass1) null);
            case 3:
                return GeneratedMessageLite.J1(DEFAULT_INSTANCE, "\u0000\u0007\u0000\u0000\u0001\u0007\u0007\u0000\u0003\u0000\u0001Ȉ\u0002\u001b\u0003\u001b\u0004Ȉ\u0005\t\u0006\u001b\u0007\f", new Object[]{"name_", "methods_", Method.class, "options_", Option.class, "version_", "sourceContext_", "mixins_", Mixin.class, "syntax_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<Api> parser = PARSER;
                if (parser == null) {
                    synchronized (Api.class) {
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

    public int F1() {
        return this.mixins_.size();
    }

    public Method M0(int i2) {
        return this.methods_.get(i2);
    }

    public List<Method> Y0() {
        return this.methods_;
    }

    public ByteString a() {
        return ByteString.B(this.name_);
    }

    public MethodOrBuilder a4(int i2) {
        return this.methods_.get(i2);
    }

    public int b() {
        return this.options_.size();
    }

    public List<? extends MethodOrBuilder> b4() {
        return this.methods_;
    }

    public List<Option> c() {
        return this.options_;
    }

    public MixinOrBuilder c4(int i2) {
        return this.mixins_.get(i2);
    }

    public List<? extends MixinOrBuilder> d4() {
        return this.mixins_;
    }

    public Option e(int i2) {
        return this.options_.get(i2);
    }

    public OptionOrBuilder e4(int i2) {
        return this.options_.get(i2);
    }

    public Syntax f() {
        Syntax a2 = Syntax.a(this.syntax_);
        return a2 == null ? Syntax.UNRECOGNIZED : a2;
    }

    public List<? extends OptionOrBuilder> f4() {
        return this.options_;
    }

    public int g() {
        return this.syntax_;
    }

    public String getName() {
        return this.name_;
    }

    public String getVersion() {
        return this.version_;
    }

    public SourceContext h() {
        SourceContext sourceContext = this.sourceContext_;
        return sourceContext == null ? SourceContext.Q2() : sourceContext;
    }

    public ByteString k0() {
        return ByteString.B(this.version_);
    }

    public boolean l() {
        return this.sourceContext_ != null;
    }

    public Mixin n2(int i2) {
        return this.mixins_.get(i2);
    }

    public int s0() {
        return this.methods_.size();
    }

    public List<Mixin> y0() {
        return this.mixins_;
    }
}
