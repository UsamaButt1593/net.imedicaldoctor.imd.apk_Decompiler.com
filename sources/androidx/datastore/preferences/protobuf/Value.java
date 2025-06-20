package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.GeneratedMessageLite;
import androidx.datastore.preferences.protobuf.ListValue;
import androidx.datastore.preferences.protobuf.Struct;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

public final class Value extends GeneratedMessageLite<Value, Builder> implements ValueOrBuilder {
    public static final int BOOL_VALUE_FIELD_NUMBER = 4;
    /* access modifiers changed from: private */
    public static final Value DEFAULT_INSTANCE;
    public static final int LIST_VALUE_FIELD_NUMBER = 6;
    public static final int NULL_VALUE_FIELD_NUMBER = 1;
    public static final int NUMBER_VALUE_FIELD_NUMBER = 2;
    private static volatile Parser<Value> PARSER = null;
    public static final int STRING_VALUE_FIELD_NUMBER = 3;
    public static final int STRUCT_VALUE_FIELD_NUMBER = 5;
    private int kindCase_ = 0;
    private Object kind_;

    /* renamed from: androidx.datastore.preferences.protobuf.Value$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f7300a;

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
                f7300a = r0
                androidx.datastore.preferences.protobuf.GeneratedMessageLite$MethodToInvoke r1 = androidx.datastore.preferences.protobuf.GeneratedMessageLite.MethodToInvoke.NEW_MUTABLE_INSTANCE     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f7300a     // Catch:{ NoSuchFieldError -> 0x001d }
                androidx.datastore.preferences.protobuf.GeneratedMessageLite$MethodToInvoke r1 = androidx.datastore.preferences.protobuf.GeneratedMessageLite.MethodToInvoke.NEW_BUILDER     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f7300a     // Catch:{ NoSuchFieldError -> 0x0028 }
                androidx.datastore.preferences.protobuf.GeneratedMessageLite$MethodToInvoke r1 = androidx.datastore.preferences.protobuf.GeneratedMessageLite.MethodToInvoke.BUILD_MESSAGE_INFO     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f7300a     // Catch:{ NoSuchFieldError -> 0x0033 }
                androidx.datastore.preferences.protobuf.GeneratedMessageLite$MethodToInvoke r1 = androidx.datastore.preferences.protobuf.GeneratedMessageLite.MethodToInvoke.GET_DEFAULT_INSTANCE     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = f7300a     // Catch:{ NoSuchFieldError -> 0x003e }
                androidx.datastore.preferences.protobuf.GeneratedMessageLite$MethodToInvoke r1 = androidx.datastore.preferences.protobuf.GeneratedMessageLite.MethodToInvoke.GET_PARSER     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = f7300a     // Catch:{ NoSuchFieldError -> 0x0049 }
                androidx.datastore.preferences.protobuf.GeneratedMessageLite$MethodToInvoke r1 = androidx.datastore.preferences.protobuf.GeneratedMessageLite.MethodToInvoke.GET_MEMOIZED_IS_INITIALIZED     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                int[] r0 = f7300a     // Catch:{ NoSuchFieldError -> 0x0054 }
                androidx.datastore.preferences.protobuf.GeneratedMessageLite$MethodToInvoke r1 = androidx.datastore.preferences.protobuf.GeneratedMessageLite.MethodToInvoke.SET_MEMOIZED_IS_INITIALIZED     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.Value.AnonymousClass1.<clinit>():void");
        }
    }

    public static final class Builder extends GeneratedMessageLite.Builder<Value, Builder> implements ValueOrBuilder {
        private Builder() {
            super(Value.DEFAULT_INSTANCE);
        }

        public Builder A3(NullValue nullValue) {
            g3();
            ((Value) this.X).H3(nullValue);
            return this;
        }

        public Builder B3(int i2) {
            g3();
            ((Value) this.X).I3(i2);
            return this;
        }

        public Builder C3(double d2) {
            g3();
            ((Value) this.X).J3(d2);
            return this;
        }

        public Builder D3(String str) {
            g3();
            ((Value) this.X).K3(str);
            return this;
        }

        public Builder E3(ByteString byteString) {
            g3();
            ((Value) this.X).L3(byteString);
            return this;
        }

        public double F0() {
            return ((Value) this.X).F0();
        }

        public Builder F3(Struct.Builder builder) {
            g3();
            ((Value) this.X).M3(builder);
            return this;
        }

        public Builder G3(Struct struct) {
            g3();
            ((Value) this.X).N3(struct);
            return this;
        }

        public boolean T1() {
            return ((Value) this.X).T1();
        }

        public ListValue a2() {
            return ((Value) this.X).a2();
        }

        public String c1() {
            return ((Value) this.X).c1();
        }

        public boolean e2() {
            return ((Value) this.X).e2();
        }

        public int g1() {
            return ((Value) this.X).g1();
        }

        public ByteString g2() {
            return ((Value) this.X).g2();
        }

        public NullValue h1() {
            return ((Value) this.X).h1();
        }

        public Builder o3() {
            g3();
            ((Value) this.X).f3();
            return this;
        }

        public Struct p2() {
            return ((Value) this.X).p2();
        }

        public Builder p3() {
            g3();
            ((Value) this.X).g3();
            return this;
        }

        public Builder q3() {
            g3();
            ((Value) this.X).h3();
            return this;
        }

        public KindCase r2() {
            return ((Value) this.X).r2();
        }

        public Builder r3() {
            g3();
            ((Value) this.X).i3();
            return this;
        }

        public Builder s3() {
            g3();
            ((Value) this.X).j3();
            return this;
        }

        public Builder t3() {
            g3();
            ((Value) this.X).k3();
            return this;
        }

        public Builder u3() {
            g3();
            ((Value) this.X).l3();
            return this;
        }

        public boolean v0() {
            return ((Value) this.X).v0();
        }

        public Builder v3(ListValue listValue) {
            g3();
            ((Value) this.X).n3(listValue);
            return this;
        }

        public Builder w3(Struct struct) {
            g3();
            ((Value) this.X).o3(struct);
            return this;
        }

        public Builder x3(boolean z) {
            g3();
            ((Value) this.X).E3(z);
            return this;
        }

        public Builder y3(ListValue.Builder builder) {
            g3();
            ((Value) this.X).F3(builder);
            return this;
        }

        public Builder z3(ListValue listValue) {
            g3();
            ((Value) this.X).G3(listValue);
            return this;
        }

        /* synthetic */ Builder(AnonymousClass1 r1) {
            this();
        }
    }

    public enum KindCase {
        NULL_VALUE(1),
        NUMBER_VALUE(2),
        STRING_VALUE(3),
        BOOL_VALUE(4),
        STRUCT_VALUE(5),
        LIST_VALUE(6),
        KIND_NOT_SET(0);
        
        private final int s;

        private KindCase(int i2) {
            this.s = i2;
        }

        public static KindCase a(int i2) {
            switch (i2) {
                case 0:
                    return KIND_NOT_SET;
                case 1:
                    return NULL_VALUE;
                case 2:
                    return NUMBER_VALUE;
                case 3:
                    return STRING_VALUE;
                case 4:
                    return BOOL_VALUE;
                case 5:
                    return STRUCT_VALUE;
                case 6:
                    return LIST_VALUE;
                default:
                    return null;
            }
        }

        @Deprecated
        public static KindCase b(int i2) {
            return a(i2);
        }

        public int d() {
            return this.s;
        }
    }

    static {
        Value value = new Value();
        DEFAULT_INSTANCE = value;
        GeneratedMessageLite.J2(Value.class, value);
    }

    private Value() {
    }

    public static Value A3(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (Value) GeneratedMessageLite.l2(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static Value B3(byte[] bArr) throws InvalidProtocolBufferException {
        return (Value) GeneratedMessageLite.o2(DEFAULT_INSTANCE, bArr);
    }

    public static Value C3(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (Value) GeneratedMessageLite.s2(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static Parser<Value> D3() {
        return DEFAULT_INSTANCE.q2();
    }

    /* access modifiers changed from: private */
    public void E3(boolean z) {
        this.kindCase_ = 4;
        this.kind_ = Boolean.valueOf(z);
    }

    /* access modifiers changed from: private */
    public void F3(ListValue.Builder builder) {
        this.kind_ = builder.build();
        this.kindCase_ = 6;
    }

    /* access modifiers changed from: private */
    public void G3(ListValue listValue) {
        listValue.getClass();
        this.kind_ = listValue;
        this.kindCase_ = 6;
    }

    /* access modifiers changed from: private */
    public void H3(NullValue nullValue) {
        nullValue.getClass();
        this.kindCase_ = 1;
        this.kind_ = Integer.valueOf(nullValue.d());
    }

    /* access modifiers changed from: private */
    public void I3(int i2) {
        this.kindCase_ = 1;
        this.kind_ = Integer.valueOf(i2);
    }

    /* access modifiers changed from: private */
    public void J3(double d2) {
        this.kindCase_ = 2;
        this.kind_ = Double.valueOf(d2);
    }

    /* access modifiers changed from: private */
    public void K3(String str) {
        str.getClass();
        this.kindCase_ = 3;
        this.kind_ = str;
    }

    /* access modifiers changed from: private */
    public void L3(ByteString byteString) {
        byteString.getClass();
        AbstractMessageLite.C(byteString);
        this.kindCase_ = 3;
        this.kind_ = byteString.o0();
    }

    /* access modifiers changed from: private */
    public void M3(Struct.Builder builder) {
        this.kind_ = builder.build();
        this.kindCase_ = 5;
    }

    /* access modifiers changed from: private */
    public void N3(Struct struct) {
        struct.getClass();
        this.kind_ = struct;
        this.kindCase_ = 5;
    }

    /* access modifiers changed from: private */
    public void f3() {
        if (this.kindCase_ == 4) {
            this.kindCase_ = 0;
            this.kind_ = null;
        }
    }

    /* access modifiers changed from: private */
    public void g3() {
        this.kindCase_ = 0;
        this.kind_ = null;
    }

    /* access modifiers changed from: private */
    public void h3() {
        if (this.kindCase_ == 6) {
            this.kindCase_ = 0;
            this.kind_ = null;
        }
    }

    /* access modifiers changed from: private */
    public void i3() {
        if (this.kindCase_ == 1) {
            this.kindCase_ = 0;
            this.kind_ = null;
        }
    }

    /* access modifiers changed from: private */
    public void j3() {
        if (this.kindCase_ == 2) {
            this.kindCase_ = 0;
            this.kind_ = null;
        }
    }

    /* access modifiers changed from: private */
    public void k3() {
        if (this.kindCase_ == 3) {
            this.kindCase_ = 0;
            this.kind_ = null;
        }
    }

    /* access modifiers changed from: private */
    public void l3() {
        if (this.kindCase_ == 5) {
            this.kindCase_ = 0;
            this.kind_ = null;
        }
    }

    public static Value m3() {
        return DEFAULT_INSTANCE;
    }

    /* access modifiers changed from: private */
    public void n3(ListValue listValue) {
        listValue.getClass();
        MessageLite messageLite = listValue;
        if (this.kindCase_ == 6) {
            messageLite = listValue;
            if (this.kind_ != ListValue.c3()) {
                messageLite = ((ListValue.Builder) ListValue.g3((ListValue) this.kind_).k3(listValue)).M1();
            }
        }
        this.kind_ = messageLite;
        this.kindCase_ = 6;
    }

    /* access modifiers changed from: private */
    public void o3(Struct struct) {
        struct.getClass();
        MessageLite messageLite = struct;
        if (this.kindCase_ == 5) {
            messageLite = struct;
            if (this.kind_ != Struct.N2()) {
                messageLite = ((Struct.Builder) Struct.S2((Struct) this.kind_).k3(struct)).M1();
            }
        }
        this.kind_ = messageLite;
        this.kindCase_ = 5;
    }

    public static Builder p3() {
        return (Builder) DEFAULT_INSTANCE.i0();
    }

    public static Builder q3(Value value) {
        return (Builder) DEFAULT_INSTANCE.j0(value);
    }

    public static Value r3(InputStream inputStream) throws IOException {
        return (Value) GeneratedMessageLite.N1(DEFAULT_INSTANCE, inputStream);
    }

    public static Value s3(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (Value) GeneratedMessageLite.P1(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static Value t3(ByteString byteString) throws InvalidProtocolBufferException {
        return (Value) GeneratedMessageLite.V1(DEFAULT_INSTANCE, byteString);
    }

    public static Value u3(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (Value) GeneratedMessageLite.W1(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static Value v3(CodedInputStream codedInputStream) throws IOException {
        return (Value) GeneratedMessageLite.X1(DEFAULT_INSTANCE, codedInputStream);
    }

    public static Value w3(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (Value) GeneratedMessageLite.Y1(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }

    public static Value x3(InputStream inputStream) throws IOException {
        return (Value) GeneratedMessageLite.Z1(DEFAULT_INSTANCE, inputStream);
    }

    public static Value y3(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (Value) GeneratedMessageLite.c2(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static Value z3(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return (Value) GeneratedMessageLite.h2(DEFAULT_INSTANCE, byteBuffer);
    }

    /* access modifiers changed from: protected */
    public final Object B0(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        switch (AnonymousClass1.f7300a[methodToInvoke.ordinal()]) {
            case 1:
                return new Value();
            case 2:
                return new Builder((AnonymousClass1) null);
            case 3:
                return GeneratedMessageLite.J1(DEFAULT_INSTANCE, "\u0000\u0006\u0001\u0000\u0001\u0006\u0006\u0000\u0000\u0000\u0001?\u0000\u00023\u0000\u0003Ȼ\u0000\u0004:\u0000\u0005<\u0000\u0006<\u0000", new Object[]{"kind_", "kindCase_", Struct.class, ListValue.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<Value> parser = PARSER;
                if (parser == null) {
                    synchronized (Value.class) {
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

    public double F0() {
        if (this.kindCase_ == 2) {
            return ((Double) this.kind_).doubleValue();
        }
        return 0.0d;
    }

    public boolean T1() {
        return this.kindCase_ == 5;
    }

    public ListValue a2() {
        return this.kindCase_ == 6 ? (ListValue) this.kind_ : ListValue.c3();
    }

    public String c1() {
        return this.kindCase_ == 3 ? (String) this.kind_ : "";
    }

    public boolean e2() {
        if (this.kindCase_ == 4) {
            return ((Boolean) this.kind_).booleanValue();
        }
        return false;
    }

    public int g1() {
        if (this.kindCase_ == 1) {
            return ((Integer) this.kind_).intValue();
        }
        return 0;
    }

    public ByteString g2() {
        return ByteString.B(this.kindCase_ == 3 ? (String) this.kind_ : "");
    }

    public NullValue h1() {
        if (this.kindCase_ != 1) {
            return NullValue.NULL_VALUE;
        }
        NullValue a2 = NullValue.a(((Integer) this.kind_).intValue());
        return a2 == null ? NullValue.UNRECOGNIZED : a2;
    }

    public Struct p2() {
        return this.kindCase_ == 5 ? (Struct) this.kind_ : Struct.N2();
    }

    public KindCase r2() {
        return KindCase.a(this.kindCase_);
    }

    public boolean v0() {
        return this.kindCase_ == 6;
    }
}
