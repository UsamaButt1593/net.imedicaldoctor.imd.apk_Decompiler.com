package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.EnumValue;
import androidx.datastore.preferences.protobuf.GeneratedMessageLite;
import androidx.datastore.preferences.protobuf.Internal;
import androidx.datastore.preferences.protobuf.Option;
import androidx.datastore.preferences.protobuf.SourceContext;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.List;

public final class Enum extends GeneratedMessageLite<Enum, Builder> implements EnumOrBuilder {
    /* access modifiers changed from: private */
    public static final Enum DEFAULT_INSTANCE;
    public static final int ENUMVALUE_FIELD_NUMBER = 2;
    public static final int NAME_FIELD_NUMBER = 1;
    public static final int OPTIONS_FIELD_NUMBER = 3;
    private static volatile Parser<Enum> PARSER = null;
    public static final int SOURCE_CONTEXT_FIELD_NUMBER = 4;
    public static final int SYNTAX_FIELD_NUMBER = 5;
    private Internal.ProtobufList<EnumValue> enumvalue_ = GeneratedMessageLite.U0();
    private String name_ = "";
    private Internal.ProtobufList<Option> options_ = GeneratedMessageLite.U0();
    private SourceContext sourceContext_;
    private int syntax_;

    /* renamed from: androidx.datastore.preferences.protobuf.Enum$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f7106a;

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
                f7106a = r0
                androidx.datastore.preferences.protobuf.GeneratedMessageLite$MethodToInvoke r1 = androidx.datastore.preferences.protobuf.GeneratedMessageLite.MethodToInvoke.NEW_MUTABLE_INSTANCE     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f7106a     // Catch:{ NoSuchFieldError -> 0x001d }
                androidx.datastore.preferences.protobuf.GeneratedMessageLite$MethodToInvoke r1 = androidx.datastore.preferences.protobuf.GeneratedMessageLite.MethodToInvoke.NEW_BUILDER     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f7106a     // Catch:{ NoSuchFieldError -> 0x0028 }
                androidx.datastore.preferences.protobuf.GeneratedMessageLite$MethodToInvoke r1 = androidx.datastore.preferences.protobuf.GeneratedMessageLite.MethodToInvoke.BUILD_MESSAGE_INFO     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f7106a     // Catch:{ NoSuchFieldError -> 0x0033 }
                androidx.datastore.preferences.protobuf.GeneratedMessageLite$MethodToInvoke r1 = androidx.datastore.preferences.protobuf.GeneratedMessageLite.MethodToInvoke.GET_DEFAULT_INSTANCE     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = f7106a     // Catch:{ NoSuchFieldError -> 0x003e }
                androidx.datastore.preferences.protobuf.GeneratedMessageLite$MethodToInvoke r1 = androidx.datastore.preferences.protobuf.GeneratedMessageLite.MethodToInvoke.GET_PARSER     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = f7106a     // Catch:{ NoSuchFieldError -> 0x0049 }
                androidx.datastore.preferences.protobuf.GeneratedMessageLite$MethodToInvoke r1 = androidx.datastore.preferences.protobuf.GeneratedMessageLite.MethodToInvoke.GET_MEMOIZED_IS_INITIALIZED     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                int[] r0 = f7106a     // Catch:{ NoSuchFieldError -> 0x0054 }
                androidx.datastore.preferences.protobuf.GeneratedMessageLite$MethodToInvoke r1 = androidx.datastore.preferences.protobuf.GeneratedMessageLite.MethodToInvoke.SET_MEMOIZED_IS_INITIALIZED     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.Enum.AnonymousClass1.<clinit>():void");
        }
    }

    public static final class Builder extends GeneratedMessageLite.Builder<Enum, Builder> implements EnumOrBuilder {
        private Builder() {
            super(Enum.DEFAULT_INSTANCE);
        }

        public Builder A3() {
            g3();
            ((Enum) this.X).A3();
            return this;
        }

        public Builder B3() {
            g3();
            ((Enum) this.X).B3();
            return this;
        }

        public Builder C3() {
            g3();
            ((Enum) this.X).C3();
            return this;
        }

        public Builder D3(SourceContext sourceContext) {
            g3();
            ((Enum) this.X).K3(sourceContext);
            return this;
        }

        public Builder E3(int i2) {
            g3();
            ((Enum) this.X).a4(i2);
            return this;
        }

        public Builder F3(int i2) {
            g3();
            ((Enum) this.X).b4(i2);
            return this;
        }

        public Builder G3(int i2, EnumValue.Builder builder) {
            g3();
            ((Enum) this.X).c4(i2, builder);
            return this;
        }

        public Builder H3(int i2, EnumValue enumValue) {
            g3();
            ((Enum) this.X).d4(i2, enumValue);
            return this;
        }

        public Builder I3(String str) {
            g3();
            ((Enum) this.X).e4(str);
            return this;
        }

        public Builder J3(ByteString byteString) {
            g3();
            ((Enum) this.X).f4(byteString);
            return this;
        }

        public Builder K3(int i2, Option.Builder builder) {
            g3();
            ((Enum) this.X).g4(i2, builder);
            return this;
        }

        public List<EnumValue> L0() {
            return Collections.unmodifiableList(((Enum) this.X).L0());
        }

        public Builder L3(int i2, Option option) {
            g3();
            ((Enum) this.X).h4(i2, option);
            return this;
        }

        public Builder M3(SourceContext.Builder builder) {
            g3();
            ((Enum) this.X).i4(builder);
            return this;
        }

        public Builder N3(SourceContext sourceContext) {
            g3();
            ((Enum) this.X).j4(sourceContext);
            return this;
        }

        public Builder O3(Syntax syntax) {
            g3();
            ((Enum) this.X).k4(syntax);
            return this;
        }

        public Builder P3(int i2) {
            g3();
            ((Enum) this.X).l4(i2);
            return this;
        }

        public ByteString a() {
            return ((Enum) this.X).a();
        }

        public int b() {
            return ((Enum) this.X).b();
        }

        public List<Option> c() {
            return Collections.unmodifiableList(((Enum) this.X).c());
        }

        public Option e(int i2) {
            return ((Enum) this.X).e(i2);
        }

        public Syntax f() {
            return ((Enum) this.X).f();
        }

        public int g() {
            return ((Enum) this.X).g();
        }

        public String getName() {
            return ((Enum) this.X).getName();
        }

        public SourceContext h() {
            return ((Enum) this.X).h();
        }

        public int k1() {
            return ((Enum) this.X).k1();
        }

        public boolean l() {
            return ((Enum) this.X).l();
        }

        public Builder o3(Iterable<? extends EnumValue> iterable) {
            g3();
            ((Enum) this.X).o3(iterable);
            return this;
        }

        public Builder p3(Iterable<? extends Option> iterable) {
            g3();
            ((Enum) this.X).p3(iterable);
            return this;
        }

        public Builder q3(int i2, EnumValue.Builder builder) {
            g3();
            ((Enum) this.X).q3(i2, builder);
            return this;
        }

        public Builder r3(int i2, EnumValue enumValue) {
            g3();
            ((Enum) this.X).r3(i2, enumValue);
            return this;
        }

        public Builder s3(EnumValue.Builder builder) {
            g3();
            ((Enum) this.X).s3(builder);
            return this;
        }

        public Builder t3(EnumValue enumValue) {
            g3();
            ((Enum) this.X).t3(enumValue);
            return this;
        }

        public Builder u3(int i2, Option.Builder builder) {
            g3();
            ((Enum) this.X).u3(i2, builder);
            return this;
        }

        public Builder v3(int i2, Option option) {
            g3();
            ((Enum) this.X).v3(i2, option);
            return this;
        }

        public Builder w3(Option.Builder builder) {
            g3();
            ((Enum) this.X).w3(builder);
            return this;
        }

        public Builder x3(Option option) {
            g3();
            ((Enum) this.X).x3(option);
            return this;
        }

        public Builder y3() {
            g3();
            ((Enum) this.X).y3();
            return this;
        }

        public EnumValue z0(int i2) {
            return ((Enum) this.X).z0(i2);
        }

        public Builder z3() {
            g3();
            ((Enum) this.X).z3();
            return this;
        }

        /* synthetic */ Builder(AnonymousClass1 r1) {
            this();
        }
    }

    static {
        Enum enumR = new Enum();
        DEFAULT_INSTANCE = enumR;
        GeneratedMessageLite.J2(Enum.class, enumR);
    }

    private Enum() {
    }

    /* access modifiers changed from: private */
    public void A3() {
        this.options_ = GeneratedMessageLite.U0();
    }

    /* access modifiers changed from: private */
    public void B3() {
        this.sourceContext_ = null;
    }

    /* access modifiers changed from: private */
    public void C3() {
        this.syntax_ = 0;
    }

    private void D3() {
        if (!this.enumvalue_.P2()) {
            this.enumvalue_ = GeneratedMessageLite.G1(this.enumvalue_);
        }
    }

    private void E3() {
        if (!this.options_.P2()) {
            this.options_ = GeneratedMessageLite.G1(this.options_);
        }
    }

    public static Enum F3() {
        return DEFAULT_INSTANCE;
    }

    /* access modifiers changed from: private */
    public void K3(SourceContext sourceContext) {
        sourceContext.getClass();
        SourceContext sourceContext2 = this.sourceContext_;
        if (!(sourceContext2 == null || sourceContext2 == SourceContext.Q2())) {
            sourceContext = (SourceContext) ((SourceContext.Builder) SourceContext.S2(this.sourceContext_).k3(sourceContext)).M1();
        }
        this.sourceContext_ = sourceContext;
    }

    public static Builder L3() {
        return (Builder) DEFAULT_INSTANCE.i0();
    }

    public static Builder M3(Enum enumR) {
        return (Builder) DEFAULT_INSTANCE.j0(enumR);
    }

    public static Enum N3(InputStream inputStream) throws IOException {
        return (Enum) GeneratedMessageLite.N1(DEFAULT_INSTANCE, inputStream);
    }

    public static Enum O3(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (Enum) GeneratedMessageLite.P1(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static Enum P3(ByteString byteString) throws InvalidProtocolBufferException {
        return (Enum) GeneratedMessageLite.V1(DEFAULT_INSTANCE, byteString);
    }

    public static Enum Q3(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (Enum) GeneratedMessageLite.W1(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static Enum R3(CodedInputStream codedInputStream) throws IOException {
        return (Enum) GeneratedMessageLite.X1(DEFAULT_INSTANCE, codedInputStream);
    }

    public static Enum S3(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (Enum) GeneratedMessageLite.Y1(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }

    public static Enum T3(InputStream inputStream) throws IOException {
        return (Enum) GeneratedMessageLite.Z1(DEFAULT_INSTANCE, inputStream);
    }

    public static Enum U3(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (Enum) GeneratedMessageLite.c2(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static Enum V3(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return (Enum) GeneratedMessageLite.h2(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Enum W3(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (Enum) GeneratedMessageLite.l2(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static Enum X3(byte[] bArr) throws InvalidProtocolBufferException {
        return (Enum) GeneratedMessageLite.o2(DEFAULT_INSTANCE, bArr);
    }

    public static Enum Y3(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (Enum) GeneratedMessageLite.s2(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static Parser<Enum> Z3() {
        return DEFAULT_INSTANCE.q2();
    }

    /* access modifiers changed from: private */
    public void a4(int i2) {
        D3();
        this.enumvalue_.remove(i2);
    }

    /* access modifiers changed from: private */
    public void b4(int i2) {
        E3();
        this.options_.remove(i2);
    }

    /* access modifiers changed from: private */
    public void c4(int i2, EnumValue.Builder builder) {
        D3();
        this.enumvalue_.set(i2, builder.build());
    }

    /* access modifiers changed from: private */
    public void d4(int i2, EnumValue enumValue) {
        enumValue.getClass();
        D3();
        this.enumvalue_.set(i2, enumValue);
    }

    /* access modifiers changed from: private */
    public void e4(String str) {
        str.getClass();
        this.name_ = str;
    }

    /* access modifiers changed from: private */
    public void f4(ByteString byteString) {
        byteString.getClass();
        AbstractMessageLite.C(byteString);
        this.name_ = byteString.o0();
    }

    /* access modifiers changed from: private */
    public void g4(int i2, Option.Builder builder) {
        E3();
        this.options_.set(i2, builder.build());
    }

    /* access modifiers changed from: private */
    public void h4(int i2, Option option) {
        option.getClass();
        E3();
        this.options_.set(i2, option);
    }

    /* access modifiers changed from: private */
    public void i4(SourceContext.Builder builder) {
        this.sourceContext_ = (SourceContext) builder.build();
    }

    /* access modifiers changed from: private */
    public void j4(SourceContext sourceContext) {
        sourceContext.getClass();
        this.sourceContext_ = sourceContext;
    }

    /* access modifiers changed from: private */
    public void k4(Syntax syntax) {
        syntax.getClass();
        this.syntax_ = syntax.d();
    }

    /* access modifiers changed from: private */
    public void l4(int i2) {
        this.syntax_ = i2;
    }

    /* access modifiers changed from: private */
    public void o3(Iterable<? extends EnumValue> iterable) {
        D3();
        AbstractMessageLite.k(iterable, this.enumvalue_);
    }

    /* access modifiers changed from: private */
    public void p3(Iterable<? extends Option> iterable) {
        E3();
        AbstractMessageLite.k(iterable, this.options_);
    }

    /* access modifiers changed from: private */
    public void q3(int i2, EnumValue.Builder builder) {
        D3();
        this.enumvalue_.add(i2, builder.build());
    }

    /* access modifiers changed from: private */
    public void r3(int i2, EnumValue enumValue) {
        enumValue.getClass();
        D3();
        this.enumvalue_.add(i2, enumValue);
    }

    /* access modifiers changed from: private */
    public void s3(EnumValue.Builder builder) {
        D3();
        this.enumvalue_.add(builder.build());
    }

    /* access modifiers changed from: private */
    public void t3(EnumValue enumValue) {
        enumValue.getClass();
        D3();
        this.enumvalue_.add(enumValue);
    }

    /* access modifiers changed from: private */
    public void u3(int i2, Option.Builder builder) {
        E3();
        this.options_.add(i2, builder.build());
    }

    /* access modifiers changed from: private */
    public void v3(int i2, Option option) {
        option.getClass();
        E3();
        this.options_.add(i2, option);
    }

    /* access modifiers changed from: private */
    public void w3(Option.Builder builder) {
        E3();
        this.options_.add(builder.build());
    }

    /* access modifiers changed from: private */
    public void x3(Option option) {
        option.getClass();
        E3();
        this.options_.add(option);
    }

    /* access modifiers changed from: private */
    public void y3() {
        this.enumvalue_ = GeneratedMessageLite.U0();
    }

    /* access modifiers changed from: private */
    public void z3() {
        this.name_ = F3().getName();
    }

    /* access modifiers changed from: protected */
    public final Object B0(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        switch (AnonymousClass1.f7106a[methodToInvoke.ordinal()]) {
            case 1:
                return new Enum();
            case 2:
                return new Builder((AnonymousClass1) null);
            case 3:
                return GeneratedMessageLite.J1(DEFAULT_INSTANCE, "\u0000\u0005\u0000\u0000\u0001\u0005\u0005\u0000\u0002\u0000\u0001Ȉ\u0002\u001b\u0003\u001b\u0004\t\u0005\f", new Object[]{"name_", "enumvalue_", EnumValue.class, "options_", Option.class, "sourceContext_", "syntax_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<Enum> parser = PARSER;
                if (parser == null) {
                    synchronized (Enum.class) {
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

    public EnumValueOrBuilder G3(int i2) {
        return this.enumvalue_.get(i2);
    }

    public List<? extends EnumValueOrBuilder> H3() {
        return this.enumvalue_;
    }

    public OptionOrBuilder I3(int i2) {
        return this.options_.get(i2);
    }

    public List<? extends OptionOrBuilder> J3() {
        return this.options_;
    }

    public List<EnumValue> L0() {
        return this.enumvalue_;
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

    public SourceContext h() {
        SourceContext sourceContext = this.sourceContext_;
        return sourceContext == null ? SourceContext.Q2() : sourceContext;
    }

    public int k1() {
        return this.enumvalue_.size();
    }

    public boolean l() {
        return this.sourceContext_ != null;
    }

    public EnumValue z0(int i2) {
        return this.enumvalue_.get(i2);
    }
}
