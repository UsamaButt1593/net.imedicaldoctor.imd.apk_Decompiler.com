package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.GeneratedMessageLite;
import androidx.datastore.preferences.protobuf.Internal;
import androidx.datastore.preferences.protobuf.Option;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.List;

public final class EnumValue extends GeneratedMessageLite<EnumValue, Builder> implements EnumValueOrBuilder {
    /* access modifiers changed from: private */
    public static final EnumValue DEFAULT_INSTANCE;
    public static final int NAME_FIELD_NUMBER = 1;
    public static final int NUMBER_FIELD_NUMBER = 2;
    public static final int OPTIONS_FIELD_NUMBER = 3;
    private static volatile Parser<EnumValue> PARSER;
    private String name_ = "";
    private int number_;
    private Internal.ProtobufList<Option> options_ = GeneratedMessageLite.U0();

    /* renamed from: androidx.datastore.preferences.protobuf.EnumValue$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f7107a;

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
                f7107a = r0
                androidx.datastore.preferences.protobuf.GeneratedMessageLite$MethodToInvoke r1 = androidx.datastore.preferences.protobuf.GeneratedMessageLite.MethodToInvoke.NEW_MUTABLE_INSTANCE     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f7107a     // Catch:{ NoSuchFieldError -> 0x001d }
                androidx.datastore.preferences.protobuf.GeneratedMessageLite$MethodToInvoke r1 = androidx.datastore.preferences.protobuf.GeneratedMessageLite.MethodToInvoke.NEW_BUILDER     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f7107a     // Catch:{ NoSuchFieldError -> 0x0028 }
                androidx.datastore.preferences.protobuf.GeneratedMessageLite$MethodToInvoke r1 = androidx.datastore.preferences.protobuf.GeneratedMessageLite.MethodToInvoke.BUILD_MESSAGE_INFO     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f7107a     // Catch:{ NoSuchFieldError -> 0x0033 }
                androidx.datastore.preferences.protobuf.GeneratedMessageLite$MethodToInvoke r1 = androidx.datastore.preferences.protobuf.GeneratedMessageLite.MethodToInvoke.GET_DEFAULT_INSTANCE     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = f7107a     // Catch:{ NoSuchFieldError -> 0x003e }
                androidx.datastore.preferences.protobuf.GeneratedMessageLite$MethodToInvoke r1 = androidx.datastore.preferences.protobuf.GeneratedMessageLite.MethodToInvoke.GET_PARSER     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = f7107a     // Catch:{ NoSuchFieldError -> 0x0049 }
                androidx.datastore.preferences.protobuf.GeneratedMessageLite$MethodToInvoke r1 = androidx.datastore.preferences.protobuf.GeneratedMessageLite.MethodToInvoke.GET_MEMOIZED_IS_INITIALIZED     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                int[] r0 = f7107a     // Catch:{ NoSuchFieldError -> 0x0054 }
                androidx.datastore.preferences.protobuf.GeneratedMessageLite$MethodToInvoke r1 = androidx.datastore.preferences.protobuf.GeneratedMessageLite.MethodToInvoke.SET_MEMOIZED_IS_INITIALIZED     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.EnumValue.AnonymousClass1.<clinit>():void");
        }
    }

    public static final class Builder extends GeneratedMessageLite.Builder<EnumValue, Builder> implements EnumValueOrBuilder {
        private Builder() {
            super(EnumValue.DEFAULT_INSTANCE);
        }

        public Builder A3(int i2, Option.Builder builder) {
            g3();
            ((EnumValue) this.X).F3(i2, builder);
            return this;
        }

        public Builder B3(int i2, Option option) {
            g3();
            ((EnumValue) this.X).G3(i2, option);
            return this;
        }

        public ByteString a() {
            return ((EnumValue) this.X).a();
        }

        public int b() {
            return ((EnumValue) this.X).b();
        }

        public List<Option> c() {
            return Collections.unmodifiableList(((EnumValue) this.X).c());
        }

        public int d() {
            return ((EnumValue) this.X).d();
        }

        public Option e(int i2) {
            return ((EnumValue) this.X).e(i2);
        }

        public String getName() {
            return ((EnumValue) this.X).getName();
        }

        public Builder o3(Iterable<? extends Option> iterable) {
            g3();
            ((EnumValue) this.X).a3(iterable);
            return this;
        }

        public Builder p3(int i2, Option.Builder builder) {
            g3();
            ((EnumValue) this.X).b3(i2, builder);
            return this;
        }

        public Builder q3(int i2, Option option) {
            g3();
            ((EnumValue) this.X).c3(i2, option);
            return this;
        }

        public Builder r3(Option.Builder builder) {
            g3();
            ((EnumValue) this.X).d3(builder);
            return this;
        }

        public Builder s3(Option option) {
            g3();
            ((EnumValue) this.X).e3(option);
            return this;
        }

        public Builder t3() {
            g3();
            ((EnumValue) this.X).f3();
            return this;
        }

        public Builder u3() {
            g3();
            ((EnumValue) this.X).g3();
            return this;
        }

        public Builder v3() {
            g3();
            ((EnumValue) this.X).h3();
            return this;
        }

        public Builder w3(int i2) {
            g3();
            ((EnumValue) this.X).B3(i2);
            return this;
        }

        public Builder x3(String str) {
            g3();
            ((EnumValue) this.X).C3(str);
            return this;
        }

        public Builder y3(ByteString byteString) {
            g3();
            ((EnumValue) this.X).D3(byteString);
            return this;
        }

        public Builder z3(int i2) {
            g3();
            ((EnumValue) this.X).E3(i2);
            return this;
        }

        /* synthetic */ Builder(AnonymousClass1 r1) {
            this();
        }
    }

    static {
        EnumValue enumValue = new EnumValue();
        DEFAULT_INSTANCE = enumValue;
        GeneratedMessageLite.J2(EnumValue.class, enumValue);
    }

    private EnumValue() {
    }

    public static Parser<EnumValue> A3() {
        return DEFAULT_INSTANCE.q2();
    }

    /* access modifiers changed from: private */
    public void B3(int i2) {
        i3();
        this.options_.remove(i2);
    }

    /* access modifiers changed from: private */
    public void C3(String str) {
        str.getClass();
        this.name_ = str;
    }

    /* access modifiers changed from: private */
    public void D3(ByteString byteString) {
        byteString.getClass();
        AbstractMessageLite.C(byteString);
        this.name_ = byteString.o0();
    }

    /* access modifiers changed from: private */
    public void E3(int i2) {
        this.number_ = i2;
    }

    /* access modifiers changed from: private */
    public void F3(int i2, Option.Builder builder) {
        i3();
        this.options_.set(i2, builder.build());
    }

    /* access modifiers changed from: private */
    public void G3(int i2, Option option) {
        option.getClass();
        i3();
        this.options_.set(i2, option);
    }

    /* access modifiers changed from: private */
    public void a3(Iterable<? extends Option> iterable) {
        i3();
        AbstractMessageLite.k(iterable, this.options_);
    }

    /* access modifiers changed from: private */
    public void b3(int i2, Option.Builder builder) {
        i3();
        this.options_.add(i2, builder.build());
    }

    /* access modifiers changed from: private */
    public void c3(int i2, Option option) {
        option.getClass();
        i3();
        this.options_.add(i2, option);
    }

    /* access modifiers changed from: private */
    public void d3(Option.Builder builder) {
        i3();
        this.options_.add(builder.build());
    }

    /* access modifiers changed from: private */
    public void e3(Option option) {
        option.getClass();
        i3();
        this.options_.add(option);
    }

    /* access modifiers changed from: private */
    public void f3() {
        this.name_ = j3().getName();
    }

    /* access modifiers changed from: private */
    public void g3() {
        this.number_ = 0;
    }

    /* access modifiers changed from: private */
    public void h3() {
        this.options_ = GeneratedMessageLite.U0();
    }

    private void i3() {
        if (!this.options_.P2()) {
            this.options_ = GeneratedMessageLite.G1(this.options_);
        }
    }

    public static EnumValue j3() {
        return DEFAULT_INSTANCE;
    }

    public static Builder m3() {
        return (Builder) DEFAULT_INSTANCE.i0();
    }

    public static Builder n3(EnumValue enumValue) {
        return (Builder) DEFAULT_INSTANCE.j0(enumValue);
    }

    public static EnumValue o3(InputStream inputStream) throws IOException {
        return (EnumValue) GeneratedMessageLite.N1(DEFAULT_INSTANCE, inputStream);
    }

    public static EnumValue p3(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (EnumValue) GeneratedMessageLite.P1(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static EnumValue q3(ByteString byteString) throws InvalidProtocolBufferException {
        return (EnumValue) GeneratedMessageLite.V1(DEFAULT_INSTANCE, byteString);
    }

    public static EnumValue r3(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (EnumValue) GeneratedMessageLite.W1(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static EnumValue s3(CodedInputStream codedInputStream) throws IOException {
        return (EnumValue) GeneratedMessageLite.X1(DEFAULT_INSTANCE, codedInputStream);
    }

    public static EnumValue t3(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (EnumValue) GeneratedMessageLite.Y1(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }

    public static EnumValue u3(InputStream inputStream) throws IOException {
        return (EnumValue) GeneratedMessageLite.Z1(DEFAULT_INSTANCE, inputStream);
    }

    public static EnumValue v3(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (EnumValue) GeneratedMessageLite.c2(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static EnumValue w3(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return (EnumValue) GeneratedMessageLite.h2(DEFAULT_INSTANCE, byteBuffer);
    }

    public static EnumValue x3(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (EnumValue) GeneratedMessageLite.l2(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static EnumValue y3(byte[] bArr) throws InvalidProtocolBufferException {
        return (EnumValue) GeneratedMessageLite.o2(DEFAULT_INSTANCE, bArr);
    }

    public static EnumValue z3(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (EnumValue) GeneratedMessageLite.s2(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    /* access modifiers changed from: protected */
    public final Object B0(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        switch (AnonymousClass1.f7107a[methodToInvoke.ordinal()]) {
            case 1:
                return new EnumValue();
            case 2:
                return new Builder((AnonymousClass1) null);
            case 3:
                return GeneratedMessageLite.J1(DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0001\u0000\u0001Ȉ\u0002\u0004\u0003\u001b", new Object[]{"name_", "number_", "options_", Option.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<EnumValue> parser = PARSER;
                if (parser == null) {
                    synchronized (EnumValue.class) {
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

    public ByteString a() {
        return ByteString.B(this.name_);
    }

    public int b() {
        return this.options_.size();
    }

    public List<Option> c() {
        return this.options_;
    }

    public int d() {
        return this.number_;
    }

    public Option e(int i2) {
        return this.options_.get(i2);
    }

    public String getName() {
        return this.name_;
    }

    public OptionOrBuilder k3(int i2) {
        return this.options_.get(i2);
    }

    public List<? extends OptionOrBuilder> l3() {
        return this.options_;
    }
}
