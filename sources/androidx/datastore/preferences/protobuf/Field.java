package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.GeneratedMessageLite;
import androidx.datastore.preferences.protobuf.Internal;
import androidx.datastore.preferences.protobuf.Option;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.List;

public final class Field extends GeneratedMessageLite<Field, Builder> implements FieldOrBuilder {
    public static final int CARDINALITY_FIELD_NUMBER = 2;
    /* access modifiers changed from: private */
    public static final Field DEFAULT_INSTANCE;
    public static final int DEFAULT_VALUE_FIELD_NUMBER = 11;
    public static final int JSON_NAME_FIELD_NUMBER = 10;
    public static final int KIND_FIELD_NUMBER = 1;
    public static final int NAME_FIELD_NUMBER = 4;
    public static final int NUMBER_FIELD_NUMBER = 3;
    public static final int ONEOF_INDEX_FIELD_NUMBER = 7;
    public static final int OPTIONS_FIELD_NUMBER = 9;
    public static final int PACKED_FIELD_NUMBER = 8;
    private static volatile Parser<Field> PARSER = null;
    public static final int TYPE_URL_FIELD_NUMBER = 6;
    private int cardinality_;
    private String defaultValue_ = "";
    private String jsonName_ = "";
    private int kind_;
    private String name_ = "";
    private int number_;
    private int oneofIndex_;
    private Internal.ProtobufList<Option> options_ = GeneratedMessageLite.U0();
    private boolean packed_;
    private String typeUrl_ = "";

    /* renamed from: androidx.datastore.preferences.protobuf.Field$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f7122a;

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
                f7122a = r0
                androidx.datastore.preferences.protobuf.GeneratedMessageLite$MethodToInvoke r1 = androidx.datastore.preferences.protobuf.GeneratedMessageLite.MethodToInvoke.NEW_MUTABLE_INSTANCE     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f7122a     // Catch:{ NoSuchFieldError -> 0x001d }
                androidx.datastore.preferences.protobuf.GeneratedMessageLite$MethodToInvoke r1 = androidx.datastore.preferences.protobuf.GeneratedMessageLite.MethodToInvoke.NEW_BUILDER     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f7122a     // Catch:{ NoSuchFieldError -> 0x0028 }
                androidx.datastore.preferences.protobuf.GeneratedMessageLite$MethodToInvoke r1 = androidx.datastore.preferences.protobuf.GeneratedMessageLite.MethodToInvoke.BUILD_MESSAGE_INFO     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f7122a     // Catch:{ NoSuchFieldError -> 0x0033 }
                androidx.datastore.preferences.protobuf.GeneratedMessageLite$MethodToInvoke r1 = androidx.datastore.preferences.protobuf.GeneratedMessageLite.MethodToInvoke.GET_DEFAULT_INSTANCE     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = f7122a     // Catch:{ NoSuchFieldError -> 0x003e }
                androidx.datastore.preferences.protobuf.GeneratedMessageLite$MethodToInvoke r1 = androidx.datastore.preferences.protobuf.GeneratedMessageLite.MethodToInvoke.GET_PARSER     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = f7122a     // Catch:{ NoSuchFieldError -> 0x0049 }
                androidx.datastore.preferences.protobuf.GeneratedMessageLite$MethodToInvoke r1 = androidx.datastore.preferences.protobuf.GeneratedMessageLite.MethodToInvoke.GET_MEMOIZED_IS_INITIALIZED     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                int[] r0 = f7122a     // Catch:{ NoSuchFieldError -> 0x0054 }
                androidx.datastore.preferences.protobuf.GeneratedMessageLite$MethodToInvoke r1 = androidx.datastore.preferences.protobuf.GeneratedMessageLite.MethodToInvoke.SET_MEMOIZED_IS_INITIALIZED     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.Field.AnonymousClass1.<clinit>():void");
        }
    }

    public static final class Builder extends GeneratedMessageLite.Builder<Field, Builder> implements FieldOrBuilder {
        private Builder() {
            super(Field.DEFAULT_INSTANCE);
        }

        public Builder A3() {
            g3();
            ((Field) this.X).F3();
            return this;
        }

        public ByteString B2() {
            return ((Field) this.X).B2();
        }

        public Builder B3() {
            g3();
            ((Field) this.X).G3();
            return this;
        }

        public Builder C3() {
            g3();
            ((Field) this.X).H3();
            return this;
        }

        public Builder D3(int i2) {
            g3();
            ((Field) this.X).b4(i2);
            return this;
        }

        public Builder E3(Cardinality cardinality) {
            g3();
            ((Field) this.X).c4(cardinality);
            return this;
        }

        public Builder F3(int i2) {
            g3();
            ((Field) this.X).d4(i2);
            return this;
        }

        public Builder G3(String str) {
            g3();
            ((Field) this.X).e4(str);
            return this;
        }

        public int H0() {
            return ((Field) this.X).H0();
        }

        public Builder H3(ByteString byteString) {
            g3();
            ((Field) this.X).f4(byteString);
            return this;
        }

        public Builder I3(String str) {
            g3();
            ((Field) this.X).g4(str);
            return this;
        }

        public Builder J3(ByteString byteString) {
            g3();
            ((Field) this.X).h4(byteString);
            return this;
        }

        public Builder K3(Kind kind) {
            g3();
            ((Field) this.X).i4(kind);
            return this;
        }

        public Builder L3(int i2) {
            g3();
            ((Field) this.X).j4(i2);
            return this;
        }

        public Cardinality M() {
            return ((Field) this.X).M();
        }

        public Builder M3(String str) {
            g3();
            ((Field) this.X).k4(str);
            return this;
        }

        public Builder N3(ByteString byteString) {
            g3();
            ((Field) this.X).l4(byteString);
            return this;
        }

        public Builder O3(int i2) {
            g3();
            ((Field) this.X).m4(i2);
            return this;
        }

        public Builder P3(int i2) {
            g3();
            ((Field) this.X).n4(i2);
            return this;
        }

        public Builder Q3(int i2, Option.Builder builder) {
            g3();
            ((Field) this.X).o4(i2, builder);
            return this;
        }

        public Builder R3(int i2, Option option) {
            g3();
            ((Field) this.X).p4(i2, option);
            return this;
        }

        public String S1() {
            return ((Field) this.X).S1();
        }

        public Builder S3(boolean z) {
            g3();
            ((Field) this.X).q4(z);
            return this;
        }

        public Builder T3(String str) {
            g3();
            ((Field) this.X).r4(str);
            return this;
        }

        public Builder U3(ByteString byteString) {
            g3();
            ((Field) this.X).s4(byteString);
            return this;
        }

        public ByteString a() {
            return ((Field) this.X).a();
        }

        public int b() {
            return ((Field) this.X).b();
        }

        public List<Option> c() {
            return Collections.unmodifiableList(((Field) this.X).c());
        }

        public int d() {
            return ((Field) this.X).d();
        }

        public int d2() {
            return ((Field) this.X).d2();
        }

        public Option e(int i2) {
            return ((Field) this.X).e(i2);
        }

        public boolean f0() {
            return ((Field) this.X).f0();
        }

        public String getName() {
            return ((Field) this.X).getName();
        }

        public ByteString h0() {
            return ((Field) this.X).h0();
        }

        public String n() {
            return ((Field) this.X).n();
        }

        public Builder o3(Iterable<? extends Option> iterable) {
            g3();
            ((Field) this.X).t3(iterable);
            return this;
        }

        public Builder p3(int i2, Option.Builder builder) {
            g3();
            ((Field) this.X).u3(i2, builder);
            return this;
        }

        public ByteString q() {
            return ((Field) this.X).q();
        }

        public Builder q3(int i2, Option option) {
            g3();
            ((Field) this.X).v3(i2, option);
            return this;
        }

        public Kind r() {
            return ((Field) this.X).r();
        }

        public int r1() {
            return ((Field) this.X).r1();
        }

        public Builder r3(Option.Builder builder) {
            g3();
            ((Field) this.X).w3(builder);
            return this;
        }

        public String s() {
            return ((Field) this.X).s();
        }

        public Builder s3(Option option) {
            g3();
            ((Field) this.X).x3(option);
            return this;
        }

        public Builder t3() {
            g3();
            ((Field) this.X).y3();
            return this;
        }

        public Builder u3() {
            g3();
            ((Field) this.X).z3();
            return this;
        }

        public Builder v3() {
            g3();
            ((Field) this.X).A3();
            return this;
        }

        public Builder w3() {
            g3();
            ((Field) this.X).B3();
            return this;
        }

        public Builder x3() {
            g3();
            ((Field) this.X).C3();
            return this;
        }

        public Builder y3() {
            g3();
            ((Field) this.X).D3();
            return this;
        }

        public Builder z3() {
            g3();
            ((Field) this.X).E3();
            return this;
        }

        /* synthetic */ Builder(AnonymousClass1 r1) {
            this();
        }
    }

    public enum Cardinality implements Internal.EnumLite {
        CARDINALITY_UNKNOWN(0),
        CARDINALITY_OPTIONAL(1),
        CARDINALITY_REQUIRED(2),
        CARDINALITY_REPEATED(3),
        UNRECOGNIZED(-1);
        
        public static final int Z2 = 0;
        public static final int a3 = 1;
        public static final int b3 = 2;
        public static final int c3 = 3;
        private static final Internal.EnumLiteMap<Cardinality> d3 = null;
        private final int s;

        private static final class CardinalityVerifier implements Internal.EnumVerifier {

            /* renamed from: a  reason: collision with root package name */
            static final Internal.EnumVerifier f7123a = null;

            static {
                f7123a = new CardinalityVerifier();
            }

            private CardinalityVerifier() {
            }

            public boolean a(int i2) {
                return Cardinality.a(i2) != null;
            }
        }

        static {
            d3 = new Internal.EnumLiteMap<Cardinality>() {
                /* renamed from: b */
                public Cardinality a(int i2) {
                    return Cardinality.a(i2);
                }
            };
        }

        private Cardinality(int i2) {
            this.s = i2;
        }

        public static Cardinality a(int i2) {
            if (i2 == 0) {
                return CARDINALITY_UNKNOWN;
            }
            if (i2 == 1) {
                return CARDINALITY_OPTIONAL;
            }
            if (i2 == 2) {
                return CARDINALITY_REQUIRED;
            }
            if (i2 != 3) {
                return null;
            }
            return CARDINALITY_REPEATED;
        }

        public static Internal.EnumLiteMap<Cardinality> b() {
            return d3;
        }

        public static Internal.EnumVerifier c() {
            return CardinalityVerifier.f7123a;
        }

        @Deprecated
        public static Cardinality e(int i2) {
            return a(i2);
        }

        public final int d() {
            if (this != UNRECOGNIZED) {
                return this.s;
            }
            throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
        }
    }

    public enum Kind implements Internal.EnumLite {
        TYPE_UNKNOWN(0),
        TYPE_DOUBLE(1),
        TYPE_FLOAT(2),
        TYPE_INT64(3),
        TYPE_UINT64(4),
        TYPE_INT32(5),
        TYPE_FIXED64(6),
        TYPE_FIXED32(7),
        TYPE_BOOL(8),
        TYPE_STRING(9),
        TYPE_GROUP(10),
        TYPE_MESSAGE(11),
        TYPE_BYTES(12),
        TYPE_UINT32(13),
        TYPE_ENUM(14),
        TYPE_SFIXED32(15),
        TYPE_SFIXED64(16),
        TYPE_SINT32(17),
        TYPE_SINT64(18),
        UNRECOGNIZED(-1);
        
        public static final int A3 = 12;
        public static final int B3 = 13;
        public static final int C3 = 14;
        public static final int D3 = 15;
        public static final int E3 = 16;
        public static final int F3 = 17;
        public static final int G3 = 18;
        private static final Internal.EnumLiteMap<Kind> H3 = null;
        public static final int o3 = 0;
        public static final int p3 = 1;
        public static final int q3 = 2;
        public static final int r3 = 3;
        public static final int s3 = 4;
        public static final int t3 = 5;
        public static final int u3 = 6;
        public static final int v3 = 7;
        public static final int w3 = 8;
        public static final int x3 = 9;
        public static final int y3 = 10;
        public static final int z3 = 11;
        private final int s;

        private static final class KindVerifier implements Internal.EnumVerifier {

            /* renamed from: a  reason: collision with root package name */
            static final Internal.EnumVerifier f7124a = null;

            static {
                f7124a = new KindVerifier();
            }

            private KindVerifier() {
            }

            public boolean a(int i2) {
                return Kind.a(i2) != null;
            }
        }

        static {
            H3 = new Internal.EnumLiteMap<Kind>() {
                /* renamed from: b */
                public Kind a(int i2) {
                    return Kind.a(i2);
                }
            };
        }

        private Kind(int i2) {
            this.s = i2;
        }

        public static Kind a(int i2) {
            switch (i2) {
                case 0:
                    return TYPE_UNKNOWN;
                case 1:
                    return TYPE_DOUBLE;
                case 2:
                    return TYPE_FLOAT;
                case 3:
                    return TYPE_INT64;
                case 4:
                    return TYPE_UINT64;
                case 5:
                    return TYPE_INT32;
                case 6:
                    return TYPE_FIXED64;
                case 7:
                    return TYPE_FIXED32;
                case 8:
                    return TYPE_BOOL;
                case 9:
                    return TYPE_STRING;
                case 10:
                    return TYPE_GROUP;
                case 11:
                    return TYPE_MESSAGE;
                case 12:
                    return TYPE_BYTES;
                case 13:
                    return TYPE_UINT32;
                case 14:
                    return TYPE_ENUM;
                case 15:
                    return TYPE_SFIXED32;
                case 16:
                    return TYPE_SFIXED64;
                case 17:
                    return TYPE_SINT32;
                case 18:
                    return TYPE_SINT64;
                default:
                    return null;
            }
        }

        public static Internal.EnumLiteMap<Kind> b() {
            return H3;
        }

        public static Internal.EnumVerifier c() {
            return KindVerifier.f7124a;
        }

        @Deprecated
        public static Kind e(int i2) {
            return a(i2);
        }

        public final int d() {
            if (this != UNRECOGNIZED) {
                return this.s;
            }
            throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
        }
    }

    static {
        Field field = new Field();
        DEFAULT_INSTANCE = field;
        GeneratedMessageLite.J2(Field.class, field);
    }

    private Field() {
    }

    /* access modifiers changed from: private */
    public void A3() {
        this.jsonName_ = J3().S1();
    }

    /* access modifiers changed from: private */
    public void B3() {
        this.kind_ = 0;
    }

    /* access modifiers changed from: private */
    public void C3() {
        this.name_ = J3().getName();
    }

    /* access modifiers changed from: private */
    public void D3() {
        this.number_ = 0;
    }

    /* access modifiers changed from: private */
    public void E3() {
        this.oneofIndex_ = 0;
    }

    /* access modifiers changed from: private */
    public void F3() {
        this.options_ = GeneratedMessageLite.U0();
    }

    /* access modifiers changed from: private */
    public void G3() {
        this.packed_ = false;
    }

    /* access modifiers changed from: private */
    public void H3() {
        this.typeUrl_ = J3().s();
    }

    private void I3() {
        if (!this.options_.P2()) {
            this.options_ = GeneratedMessageLite.G1(this.options_);
        }
    }

    public static Field J3() {
        return DEFAULT_INSTANCE;
    }

    public static Builder M3() {
        return (Builder) DEFAULT_INSTANCE.i0();
    }

    public static Builder N3(Field field) {
        return (Builder) DEFAULT_INSTANCE.j0(field);
    }

    public static Field O3(InputStream inputStream) throws IOException {
        return (Field) GeneratedMessageLite.N1(DEFAULT_INSTANCE, inputStream);
    }

    public static Field P3(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (Field) GeneratedMessageLite.P1(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static Field Q3(ByteString byteString) throws InvalidProtocolBufferException {
        return (Field) GeneratedMessageLite.V1(DEFAULT_INSTANCE, byteString);
    }

    public static Field R3(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (Field) GeneratedMessageLite.W1(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static Field S3(CodedInputStream codedInputStream) throws IOException {
        return (Field) GeneratedMessageLite.X1(DEFAULT_INSTANCE, codedInputStream);
    }

    public static Field T3(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (Field) GeneratedMessageLite.Y1(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }

    public static Field U3(InputStream inputStream) throws IOException {
        return (Field) GeneratedMessageLite.Z1(DEFAULT_INSTANCE, inputStream);
    }

    public static Field V3(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (Field) GeneratedMessageLite.c2(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static Field W3(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return (Field) GeneratedMessageLite.h2(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Field X3(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (Field) GeneratedMessageLite.l2(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static Field Y3(byte[] bArr) throws InvalidProtocolBufferException {
        return (Field) GeneratedMessageLite.o2(DEFAULT_INSTANCE, bArr);
    }

    public static Field Z3(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (Field) GeneratedMessageLite.s2(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static Parser<Field> a4() {
        return DEFAULT_INSTANCE.q2();
    }

    /* access modifiers changed from: private */
    public void b4(int i2) {
        I3();
        this.options_.remove(i2);
    }

    /* access modifiers changed from: private */
    public void c4(Cardinality cardinality) {
        cardinality.getClass();
        this.cardinality_ = cardinality.d();
    }

    /* access modifiers changed from: private */
    public void d4(int i2) {
        this.cardinality_ = i2;
    }

    /* access modifiers changed from: private */
    public void e4(String str) {
        str.getClass();
        this.defaultValue_ = str;
    }

    /* access modifiers changed from: private */
    public void f4(ByteString byteString) {
        byteString.getClass();
        AbstractMessageLite.C(byteString);
        this.defaultValue_ = byteString.o0();
    }

    /* access modifiers changed from: private */
    public void g4(String str) {
        str.getClass();
        this.jsonName_ = str;
    }

    /* access modifiers changed from: private */
    public void h4(ByteString byteString) {
        byteString.getClass();
        AbstractMessageLite.C(byteString);
        this.jsonName_ = byteString.o0();
    }

    /* access modifiers changed from: private */
    public void i4(Kind kind) {
        kind.getClass();
        this.kind_ = kind.d();
    }

    /* access modifiers changed from: private */
    public void j4(int i2) {
        this.kind_ = i2;
    }

    /* access modifiers changed from: private */
    public void k4(String str) {
        str.getClass();
        this.name_ = str;
    }

    /* access modifiers changed from: private */
    public void l4(ByteString byteString) {
        byteString.getClass();
        AbstractMessageLite.C(byteString);
        this.name_ = byteString.o0();
    }

    /* access modifiers changed from: private */
    public void m4(int i2) {
        this.number_ = i2;
    }

    /* access modifiers changed from: private */
    public void n4(int i2) {
        this.oneofIndex_ = i2;
    }

    /* access modifiers changed from: private */
    public void o4(int i2, Option.Builder builder) {
        I3();
        this.options_.set(i2, builder.build());
    }

    /* access modifiers changed from: private */
    public void p4(int i2, Option option) {
        option.getClass();
        I3();
        this.options_.set(i2, option);
    }

    /* access modifiers changed from: private */
    public void q4(boolean z) {
        this.packed_ = z;
    }

    /* access modifiers changed from: private */
    public void r4(String str) {
        str.getClass();
        this.typeUrl_ = str;
    }

    /* access modifiers changed from: private */
    public void s4(ByteString byteString) {
        byteString.getClass();
        AbstractMessageLite.C(byteString);
        this.typeUrl_ = byteString.o0();
    }

    /* access modifiers changed from: private */
    public void t3(Iterable<? extends Option> iterable) {
        I3();
        AbstractMessageLite.k(iterable, this.options_);
    }

    /* access modifiers changed from: private */
    public void u3(int i2, Option.Builder builder) {
        I3();
        this.options_.add(i2, builder.build());
    }

    /* access modifiers changed from: private */
    public void v3(int i2, Option option) {
        option.getClass();
        I3();
        this.options_.add(i2, option);
    }

    /* access modifiers changed from: private */
    public void w3(Option.Builder builder) {
        I3();
        this.options_.add(builder.build());
    }

    /* access modifiers changed from: private */
    public void x3(Option option) {
        option.getClass();
        I3();
        this.options_.add(option);
    }

    /* access modifiers changed from: private */
    public void y3() {
        this.cardinality_ = 0;
    }

    /* access modifiers changed from: private */
    public void z3() {
        this.defaultValue_ = J3().n();
    }

    /* access modifiers changed from: protected */
    public final Object B0(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        switch (AnonymousClass1.f7122a[methodToInvoke.ordinal()]) {
            case 1:
                return new Field();
            case 2:
                return new Builder((AnonymousClass1) null);
            case 3:
                return GeneratedMessageLite.J1(DEFAULT_INSTANCE, "\u0000\n\u0000\u0000\u0001\u000b\n\u0000\u0001\u0000\u0001\f\u0002\f\u0003\u0004\u0004Ȉ\u0006Ȉ\u0007\u0004\b\u0007\t\u001b\nȈ\u000bȈ", new Object[]{"kind_", "cardinality_", "number_", "name_", "typeUrl_", "oneofIndex_", "packed_", "options_", Option.class, "jsonName_", "defaultValue_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<Field> parser = PARSER;
                if (parser == null) {
                    synchronized (Field.class) {
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

    public ByteString B2() {
        return ByteString.B(this.jsonName_);
    }

    public int H0() {
        return this.oneofIndex_;
    }

    public OptionOrBuilder K3(int i2) {
        return this.options_.get(i2);
    }

    public List<? extends OptionOrBuilder> L3() {
        return this.options_;
    }

    public Cardinality M() {
        Cardinality a2 = Cardinality.a(this.cardinality_);
        return a2 == null ? Cardinality.UNRECOGNIZED : a2;
    }

    public String S1() {
        return this.jsonName_;
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

    public int d2() {
        return this.kind_;
    }

    public Option e(int i2) {
        return this.options_.get(i2);
    }

    public boolean f0() {
        return this.packed_;
    }

    public String getName() {
        return this.name_;
    }

    public ByteString h0() {
        return ByteString.B(this.defaultValue_);
    }

    public String n() {
        return this.defaultValue_;
    }

    public ByteString q() {
        return ByteString.B(this.typeUrl_);
    }

    public Kind r() {
        Kind a2 = Kind.a(this.kind_);
        return a2 == null ? Kind.UNRECOGNIZED : a2;
    }

    public int r1() {
        return this.cardinality_;
    }

    public String s() {
        return this.typeUrl_;
    }
}
