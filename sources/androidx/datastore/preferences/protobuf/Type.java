package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.Field;
import androidx.datastore.preferences.protobuf.GeneratedMessageLite;
import androidx.datastore.preferences.protobuf.Internal;
import androidx.datastore.preferences.protobuf.Option;
import androidx.datastore.preferences.protobuf.SourceContext;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.List;

public final class Type extends GeneratedMessageLite<Type, Builder> implements TypeOrBuilder {
    /* access modifiers changed from: private */
    public static final Type DEFAULT_INSTANCE;
    public static final int FIELDS_FIELD_NUMBER = 2;
    public static final int NAME_FIELD_NUMBER = 1;
    public static final int ONEOFS_FIELD_NUMBER = 3;
    public static final int OPTIONS_FIELD_NUMBER = 4;
    private static volatile Parser<Type> PARSER = null;
    public static final int SOURCE_CONTEXT_FIELD_NUMBER = 5;
    public static final int SYNTAX_FIELD_NUMBER = 6;
    private Internal.ProtobufList<Field> fields_ = GeneratedMessageLite.U0();
    private String name_ = "";
    private Internal.ProtobufList<String> oneofs_ = GeneratedMessageLite.U0();
    private Internal.ProtobufList<Option> options_ = GeneratedMessageLite.U0();
    private SourceContext sourceContext_;
    private int syntax_;

    /* renamed from: androidx.datastore.preferences.protobuf.Type$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f7268a;

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
                f7268a = r0
                androidx.datastore.preferences.protobuf.GeneratedMessageLite$MethodToInvoke r1 = androidx.datastore.preferences.protobuf.GeneratedMessageLite.MethodToInvoke.NEW_MUTABLE_INSTANCE     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f7268a     // Catch:{ NoSuchFieldError -> 0x001d }
                androidx.datastore.preferences.protobuf.GeneratedMessageLite$MethodToInvoke r1 = androidx.datastore.preferences.protobuf.GeneratedMessageLite.MethodToInvoke.NEW_BUILDER     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f7268a     // Catch:{ NoSuchFieldError -> 0x0028 }
                androidx.datastore.preferences.protobuf.GeneratedMessageLite$MethodToInvoke r1 = androidx.datastore.preferences.protobuf.GeneratedMessageLite.MethodToInvoke.BUILD_MESSAGE_INFO     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f7268a     // Catch:{ NoSuchFieldError -> 0x0033 }
                androidx.datastore.preferences.protobuf.GeneratedMessageLite$MethodToInvoke r1 = androidx.datastore.preferences.protobuf.GeneratedMessageLite.MethodToInvoke.GET_DEFAULT_INSTANCE     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = f7268a     // Catch:{ NoSuchFieldError -> 0x003e }
                androidx.datastore.preferences.protobuf.GeneratedMessageLite$MethodToInvoke r1 = androidx.datastore.preferences.protobuf.GeneratedMessageLite.MethodToInvoke.GET_PARSER     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = f7268a     // Catch:{ NoSuchFieldError -> 0x0049 }
                androidx.datastore.preferences.protobuf.GeneratedMessageLite$MethodToInvoke r1 = androidx.datastore.preferences.protobuf.GeneratedMessageLite.MethodToInvoke.GET_MEMOIZED_IS_INITIALIZED     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                int[] r0 = f7268a     // Catch:{ NoSuchFieldError -> 0x0054 }
                androidx.datastore.preferences.protobuf.GeneratedMessageLite$MethodToInvoke r1 = androidx.datastore.preferences.protobuf.GeneratedMessageLite.MethodToInvoke.SET_MEMOIZED_IS_INITIALIZED     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.Type.AnonymousClass1.<clinit>():void");
        }
    }

    public static final class Builder extends GeneratedMessageLite.Builder<Type, Builder> implements TypeOrBuilder {
        private Builder() {
            super(Type.DEFAULT_INSTANCE);
        }

        public Builder A3(Option option) {
            g3();
            ((Type) this.X).F3(option);
            return this;
        }

        public Builder B3() {
            g3();
            ((Type) this.X).G3();
            return this;
        }

        public String C0(int i2) {
            return ((Type) this.X).C0(i2);
        }

        public Builder C3() {
            g3();
            ((Type) this.X).H3();
            return this;
        }

        public int D1() {
            return ((Type) this.X).D1();
        }

        public Builder D3() {
            g3();
            ((Type) this.X).I3();
            return this;
        }

        public Builder E3() {
            g3();
            ((Type) this.X).J3();
            return this;
        }

        public Builder F3() {
            g3();
            ((Type) this.X).K3();
            return this;
        }

        public Builder G3() {
            g3();
            ((Type) this.X).L3();
            return this;
        }

        public Builder H3(SourceContext sourceContext) {
            g3();
            ((Type) this.X).U3(sourceContext);
            return this;
        }

        public Builder I3(int i2) {
            g3();
            ((Type) this.X).k4(i2);
            return this;
        }

        public Builder J3(int i2) {
            g3();
            ((Type) this.X).l4(i2);
            return this;
        }

        public Builder K3(int i2, Field.Builder builder) {
            g3();
            ((Type) this.X).m4(i2, builder);
            return this;
        }

        public Builder L3(int i2, Field field) {
            g3();
            ((Type) this.X).n4(i2, field);
            return this;
        }

        public Builder M3(String str) {
            g3();
            ((Type) this.X).o4(str);
            return this;
        }

        public Builder N3(ByteString byteString) {
            g3();
            ((Type) this.X).p4(byteString);
            return this;
        }

        public Builder O3(int i2, String str) {
            g3();
            ((Type) this.X).q4(i2, str);
            return this;
        }

        public Builder P3(int i2, Option.Builder builder) {
            g3();
            ((Type) this.X).r4(i2, builder);
            return this;
        }

        public Builder Q3(int i2, Option option) {
            g3();
            ((Type) this.X).s4(i2, option);
            return this;
        }

        public Builder R3(SourceContext.Builder builder) {
            g3();
            ((Type) this.X).t4(builder);
            return this;
        }

        public Builder S3(SourceContext sourceContext) {
            g3();
            ((Type) this.X).u4(sourceContext);
            return this;
        }

        public Builder T3(Syntax syntax) {
            g3();
            ((Type) this.X).v4(syntax);
            return this;
        }

        public Builder U3(int i2) {
            g3();
            ((Type) this.X).w4(i2);
            return this;
        }

        public ByteString a() {
            return ((Type) this.X).a();
        }

        public int b() {
            return ((Type) this.X).b();
        }

        public Field b0(int i2) {
            return ((Type) this.X).b0(i2);
        }

        public List<Option> c() {
            return Collections.unmodifiableList(((Type) this.X).c());
        }

        public Option e(int i2) {
            return ((Type) this.X).e(i2);
        }

        public Syntax f() {
            return ((Type) this.X).f();
        }

        public int g() {
            return ((Type) this.X).g();
        }

        public String getName() {
            return ((Type) this.X).getName();
        }

        public SourceContext h() {
            return ((Type) this.X).h();
        }

        public boolean l() {
            return ((Type) this.X).l();
        }

        public List<Field> l0() {
            return Collections.unmodifiableList(((Type) this.X).l0());
        }

        public ByteString l1(int i2) {
            return ((Type) this.X).l1(i2);
        }

        public Builder o3(Iterable<? extends Field> iterable) {
            g3();
            ((Type) this.X).t3(iterable);
            return this;
        }

        public int p() {
            return ((Type) this.X).p();
        }

        public Builder p3(Iterable<String> iterable) {
            g3();
            ((Type) this.X).u3(iterable);
            return this;
        }

        public Builder q3(Iterable<? extends Option> iterable) {
            g3();
            ((Type) this.X).v3(iterable);
            return this;
        }

        public Builder r3(int i2, Field.Builder builder) {
            g3();
            ((Type) this.X).w3(i2, builder);
            return this;
        }

        public Builder s3(int i2, Field field) {
            g3();
            ((Type) this.X).x3(i2, field);
            return this;
        }

        public Builder t3(Field.Builder builder) {
            g3();
            ((Type) this.X).y3(builder);
            return this;
        }

        public Builder u3(Field field) {
            g3();
            ((Type) this.X).z3(field);
            return this;
        }

        public Builder v3(String str) {
            g3();
            ((Type) this.X).A3(str);
            return this;
        }

        public Builder w3(ByteString byteString) {
            g3();
            ((Type) this.X).B3(byteString);
            return this;
        }

        public List<String> x() {
            return Collections.unmodifiableList(((Type) this.X).x());
        }

        public Builder x3(int i2, Option.Builder builder) {
            g3();
            ((Type) this.X).C3(i2, builder);
            return this;
        }

        public Builder y3(int i2, Option option) {
            g3();
            ((Type) this.X).D3(i2, option);
            return this;
        }

        public Builder z3(Option.Builder builder) {
            g3();
            ((Type) this.X).E3(builder);
            return this;
        }

        /* synthetic */ Builder(AnonymousClass1 r1) {
            this();
        }
    }

    static {
        Type type = new Type();
        DEFAULT_INSTANCE = type;
        GeneratedMessageLite.J2(Type.class, type);
    }

    private Type() {
    }

    /* access modifiers changed from: private */
    public void A3(String str) {
        str.getClass();
        N3();
        this.oneofs_.add(str);
    }

    /* access modifiers changed from: private */
    public void B3(ByteString byteString) {
        byteString.getClass();
        AbstractMessageLite.C(byteString);
        N3();
        this.oneofs_.add(byteString.o0());
    }

    /* access modifiers changed from: private */
    public void C3(int i2, Option.Builder builder) {
        O3();
        this.options_.add(i2, builder.build());
    }

    /* access modifiers changed from: private */
    public void D3(int i2, Option option) {
        option.getClass();
        O3();
        this.options_.add(i2, option);
    }

    /* access modifiers changed from: private */
    public void E3(Option.Builder builder) {
        O3();
        this.options_.add(builder.build());
    }

    /* access modifiers changed from: private */
    public void F3(Option option) {
        option.getClass();
        O3();
        this.options_.add(option);
    }

    /* access modifiers changed from: private */
    public void G3() {
        this.fields_ = GeneratedMessageLite.U0();
    }

    /* access modifiers changed from: private */
    public void H3() {
        this.name_ = P3().getName();
    }

    /* access modifiers changed from: private */
    public void I3() {
        this.oneofs_ = GeneratedMessageLite.U0();
    }

    /* access modifiers changed from: private */
    public void J3() {
        this.options_ = GeneratedMessageLite.U0();
    }

    /* access modifiers changed from: private */
    public void K3() {
        this.sourceContext_ = null;
    }

    /* access modifiers changed from: private */
    public void L3() {
        this.syntax_ = 0;
    }

    private void M3() {
        if (!this.fields_.P2()) {
            this.fields_ = GeneratedMessageLite.G1(this.fields_);
        }
    }

    private void N3() {
        if (!this.oneofs_.P2()) {
            this.oneofs_ = GeneratedMessageLite.G1(this.oneofs_);
        }
    }

    private void O3() {
        if (!this.options_.P2()) {
            this.options_ = GeneratedMessageLite.G1(this.options_);
        }
    }

    public static Type P3() {
        return DEFAULT_INSTANCE;
    }

    /* access modifiers changed from: private */
    public void U3(SourceContext sourceContext) {
        sourceContext.getClass();
        SourceContext sourceContext2 = this.sourceContext_;
        if (!(sourceContext2 == null || sourceContext2 == SourceContext.Q2())) {
            sourceContext = (SourceContext) ((SourceContext.Builder) SourceContext.S2(this.sourceContext_).k3(sourceContext)).M1();
        }
        this.sourceContext_ = sourceContext;
    }

    public static Builder V3() {
        return (Builder) DEFAULT_INSTANCE.i0();
    }

    public static Builder W3(Type type) {
        return (Builder) DEFAULT_INSTANCE.j0(type);
    }

    public static Type X3(InputStream inputStream) throws IOException {
        return (Type) GeneratedMessageLite.N1(DEFAULT_INSTANCE, inputStream);
    }

    public static Type Y3(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (Type) GeneratedMessageLite.P1(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static Type Z3(ByteString byteString) throws InvalidProtocolBufferException {
        return (Type) GeneratedMessageLite.V1(DEFAULT_INSTANCE, byteString);
    }

    public static Type a4(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (Type) GeneratedMessageLite.W1(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static Type b4(CodedInputStream codedInputStream) throws IOException {
        return (Type) GeneratedMessageLite.X1(DEFAULT_INSTANCE, codedInputStream);
    }

    public static Type c4(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (Type) GeneratedMessageLite.Y1(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }

    public static Type d4(InputStream inputStream) throws IOException {
        return (Type) GeneratedMessageLite.Z1(DEFAULT_INSTANCE, inputStream);
    }

    public static Type e4(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (Type) GeneratedMessageLite.c2(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static Type f4(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return (Type) GeneratedMessageLite.h2(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Type g4(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (Type) GeneratedMessageLite.l2(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static Type h4(byte[] bArr) throws InvalidProtocolBufferException {
        return (Type) GeneratedMessageLite.o2(DEFAULT_INSTANCE, bArr);
    }

    public static Type i4(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (Type) GeneratedMessageLite.s2(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static Parser<Type> j4() {
        return DEFAULT_INSTANCE.q2();
    }

    /* access modifiers changed from: private */
    public void k4(int i2) {
        M3();
        this.fields_.remove(i2);
    }

    /* access modifiers changed from: private */
    public void l4(int i2) {
        O3();
        this.options_.remove(i2);
    }

    /* access modifiers changed from: private */
    public void m4(int i2, Field.Builder builder) {
        M3();
        this.fields_.set(i2, builder.build());
    }

    /* access modifiers changed from: private */
    public void n4(int i2, Field field) {
        field.getClass();
        M3();
        this.fields_.set(i2, field);
    }

    /* access modifiers changed from: private */
    public void o4(String str) {
        str.getClass();
        this.name_ = str;
    }

    /* access modifiers changed from: private */
    public void p4(ByteString byteString) {
        byteString.getClass();
        AbstractMessageLite.C(byteString);
        this.name_ = byteString.o0();
    }

    /* access modifiers changed from: private */
    public void q4(int i2, String str) {
        str.getClass();
        N3();
        this.oneofs_.set(i2, str);
    }

    /* access modifiers changed from: private */
    public void r4(int i2, Option.Builder builder) {
        O3();
        this.options_.set(i2, builder.build());
    }

    /* access modifiers changed from: private */
    public void s4(int i2, Option option) {
        option.getClass();
        O3();
        this.options_.set(i2, option);
    }

    /* access modifiers changed from: private */
    public void t3(Iterable<? extends Field> iterable) {
        M3();
        AbstractMessageLite.k(iterable, this.fields_);
    }

    /* access modifiers changed from: private */
    public void t4(SourceContext.Builder builder) {
        this.sourceContext_ = (SourceContext) builder.build();
    }

    /* access modifiers changed from: private */
    public void u3(Iterable<String> iterable) {
        N3();
        AbstractMessageLite.k(iterable, this.oneofs_);
    }

    /* access modifiers changed from: private */
    public void u4(SourceContext sourceContext) {
        sourceContext.getClass();
        this.sourceContext_ = sourceContext;
    }

    /* access modifiers changed from: private */
    public void v3(Iterable<? extends Option> iterable) {
        O3();
        AbstractMessageLite.k(iterable, this.options_);
    }

    /* access modifiers changed from: private */
    public void v4(Syntax syntax) {
        syntax.getClass();
        this.syntax_ = syntax.d();
    }

    /* access modifiers changed from: private */
    public void w3(int i2, Field.Builder builder) {
        M3();
        this.fields_.add(i2, builder.build());
    }

    /* access modifiers changed from: private */
    public void w4(int i2) {
        this.syntax_ = i2;
    }

    /* access modifiers changed from: private */
    public void x3(int i2, Field field) {
        field.getClass();
        M3();
        this.fields_.add(i2, field);
    }

    /* access modifiers changed from: private */
    public void y3(Field.Builder builder) {
        M3();
        this.fields_.add(builder.build());
    }

    /* access modifiers changed from: private */
    public void z3(Field field) {
        field.getClass();
        M3();
        this.fields_.add(field);
    }

    /* access modifiers changed from: protected */
    public final Object B0(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        switch (AnonymousClass1.f7268a[methodToInvoke.ordinal()]) {
            case 1:
                return new Type();
            case 2:
                return new Builder((AnonymousClass1) null);
            case 3:
                return GeneratedMessageLite.J1(DEFAULT_INSTANCE, "\u0000\u0006\u0000\u0000\u0001\u0006\u0006\u0000\u0003\u0000\u0001Ȉ\u0002\u001b\u0003Ț\u0004\u001b\u0005\t\u0006\f", new Object[]{"name_", "fields_", Field.class, "oneofs_", "options_", Option.class, "sourceContext_", "syntax_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<Type> parser = PARSER;
                if (parser == null) {
                    synchronized (Type.class) {
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

    public String C0(int i2) {
        return this.oneofs_.get(i2);
    }

    public int D1() {
        return this.oneofs_.size();
    }

    public FieldOrBuilder Q3(int i2) {
        return this.fields_.get(i2);
    }

    public List<? extends FieldOrBuilder> R3() {
        return this.fields_;
    }

    public OptionOrBuilder S3(int i2) {
        return this.options_.get(i2);
    }

    public List<? extends OptionOrBuilder> T3() {
        return this.options_;
    }

    public ByteString a() {
        return ByteString.B(this.name_);
    }

    public int b() {
        return this.options_.size();
    }

    public Field b0(int i2) {
        return this.fields_.get(i2);
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

    public boolean l() {
        return this.sourceContext_ != null;
    }

    public List<Field> l0() {
        return this.fields_;
    }

    public ByteString l1(int i2) {
        return ByteString.B(this.oneofs_.get(i2));
    }

    public int p() {
        return this.fields_.size();
    }

    public List<String> x() {
        return this.oneofs_;
    }
}
