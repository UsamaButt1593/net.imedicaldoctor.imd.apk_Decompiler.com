package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.GeneratedMessageLite;
import androidx.datastore.preferences.protobuf.Internal;
import androidx.datastore.preferences.protobuf.Value;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.List;

public final class ListValue extends GeneratedMessageLite<ListValue, Builder> implements ListValueOrBuilder {
    /* access modifiers changed from: private */
    public static final ListValue DEFAULT_INSTANCE;
    private static volatile Parser<ListValue> PARSER = null;
    public static final int VALUES_FIELD_NUMBER = 1;
    private Internal.ProtobufList<Value> values_ = GeneratedMessageLite.U0();

    /* renamed from: androidx.datastore.preferences.protobuf.ListValue$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f7183a;

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
                f7183a = r0
                androidx.datastore.preferences.protobuf.GeneratedMessageLite$MethodToInvoke r1 = androidx.datastore.preferences.protobuf.GeneratedMessageLite.MethodToInvoke.NEW_MUTABLE_INSTANCE     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f7183a     // Catch:{ NoSuchFieldError -> 0x001d }
                androidx.datastore.preferences.protobuf.GeneratedMessageLite$MethodToInvoke r1 = androidx.datastore.preferences.protobuf.GeneratedMessageLite.MethodToInvoke.NEW_BUILDER     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f7183a     // Catch:{ NoSuchFieldError -> 0x0028 }
                androidx.datastore.preferences.protobuf.GeneratedMessageLite$MethodToInvoke r1 = androidx.datastore.preferences.protobuf.GeneratedMessageLite.MethodToInvoke.BUILD_MESSAGE_INFO     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f7183a     // Catch:{ NoSuchFieldError -> 0x0033 }
                androidx.datastore.preferences.protobuf.GeneratedMessageLite$MethodToInvoke r1 = androidx.datastore.preferences.protobuf.GeneratedMessageLite.MethodToInvoke.GET_DEFAULT_INSTANCE     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = f7183a     // Catch:{ NoSuchFieldError -> 0x003e }
                androidx.datastore.preferences.protobuf.GeneratedMessageLite$MethodToInvoke r1 = androidx.datastore.preferences.protobuf.GeneratedMessageLite.MethodToInvoke.GET_PARSER     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = f7183a     // Catch:{ NoSuchFieldError -> 0x0049 }
                androidx.datastore.preferences.protobuf.GeneratedMessageLite$MethodToInvoke r1 = androidx.datastore.preferences.protobuf.GeneratedMessageLite.MethodToInvoke.GET_MEMOIZED_IS_INITIALIZED     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                int[] r0 = f7183a     // Catch:{ NoSuchFieldError -> 0x0054 }
                androidx.datastore.preferences.protobuf.GeneratedMessageLite$MethodToInvoke r1 = androidx.datastore.preferences.protobuf.GeneratedMessageLite.MethodToInvoke.SET_MEMOIZED_IS_INITIALIZED     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.ListValue.AnonymousClass1.<clinit>():void");
        }
    }

    public static final class Builder extends GeneratedMessageLite.Builder<ListValue, Builder> implements ListValueOrBuilder {
        private Builder() {
            super(ListValue.DEFAULT_INSTANCE);
        }

        public int i2() {
            return ((ListValue) this.X).i2();
        }

        public Value j2(int i2) {
            return ((ListValue) this.X).j2(i2);
        }

        public Builder o3(Iterable<? extends Value> iterable) {
            g3();
            ((ListValue) this.X).V2(iterable);
            return this;
        }

        public Builder p3(int i2, Value.Builder builder) {
            g3();
            ((ListValue) this.X).W2(i2, builder);
            return this;
        }

        public Builder q3(int i2, Value value) {
            g3();
            ((ListValue) this.X).X2(i2, value);
            return this;
        }

        public Builder r3(Value.Builder builder) {
            g3();
            ((ListValue) this.X).Y2(builder);
            return this;
        }

        public Builder s3(Value value) {
            g3();
            ((ListValue) this.X).Z2(value);
            return this;
        }

        public Builder t3() {
            g3();
            ((ListValue) this.X).a3();
            return this;
        }

        public Builder u3(int i2) {
            g3();
            ((ListValue) this.X).u3(i2);
            return this;
        }

        public Builder v3(int i2, Value.Builder builder) {
            g3();
            ((ListValue) this.X).v3(i2, builder);
            return this;
        }

        public List<Value> w1() {
            return Collections.unmodifiableList(((ListValue) this.X).w1());
        }

        public Builder w3(int i2, Value value) {
            g3();
            ((ListValue) this.X).w3(i2, value);
            return this;
        }

        /* synthetic */ Builder(AnonymousClass1 r1) {
            this();
        }
    }

    static {
        ListValue listValue = new ListValue();
        DEFAULT_INSTANCE = listValue;
        GeneratedMessageLite.J2(ListValue.class, listValue);
    }

    private ListValue() {
    }

    /* access modifiers changed from: private */
    public void V2(Iterable<? extends Value> iterable) {
        b3();
        AbstractMessageLite.k(iterable, this.values_);
    }

    /* access modifiers changed from: private */
    public void W2(int i2, Value.Builder builder) {
        b3();
        this.values_.add(i2, builder.build());
    }

    /* access modifiers changed from: private */
    public void X2(int i2, Value value) {
        value.getClass();
        b3();
        this.values_.add(i2, value);
    }

    /* access modifiers changed from: private */
    public void Y2(Value.Builder builder) {
        b3();
        this.values_.add(builder.build());
    }

    /* access modifiers changed from: private */
    public void Z2(Value value) {
        value.getClass();
        b3();
        this.values_.add(value);
    }

    /* access modifiers changed from: private */
    public void a3() {
        this.values_ = GeneratedMessageLite.U0();
    }

    private void b3() {
        if (!this.values_.P2()) {
            this.values_ = GeneratedMessageLite.G1(this.values_);
        }
    }

    public static ListValue c3() {
        return DEFAULT_INSTANCE;
    }

    public static Builder f3() {
        return (Builder) DEFAULT_INSTANCE.i0();
    }

    public static Builder g3(ListValue listValue) {
        return (Builder) DEFAULT_INSTANCE.j0(listValue);
    }

    public static ListValue h3(InputStream inputStream) throws IOException {
        return (ListValue) GeneratedMessageLite.N1(DEFAULT_INSTANCE, inputStream);
    }

    public static ListValue i3(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (ListValue) GeneratedMessageLite.P1(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static ListValue j3(ByteString byteString) throws InvalidProtocolBufferException {
        return (ListValue) GeneratedMessageLite.V1(DEFAULT_INSTANCE, byteString);
    }

    public static ListValue k3(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (ListValue) GeneratedMessageLite.W1(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static ListValue l3(CodedInputStream codedInputStream) throws IOException {
        return (ListValue) GeneratedMessageLite.X1(DEFAULT_INSTANCE, codedInputStream);
    }

    public static ListValue m3(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (ListValue) GeneratedMessageLite.Y1(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }

    public static ListValue n3(InputStream inputStream) throws IOException {
        return (ListValue) GeneratedMessageLite.Z1(DEFAULT_INSTANCE, inputStream);
    }

    public static ListValue o3(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (ListValue) GeneratedMessageLite.c2(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static ListValue p3(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return (ListValue) GeneratedMessageLite.h2(DEFAULT_INSTANCE, byteBuffer);
    }

    public static ListValue q3(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (ListValue) GeneratedMessageLite.l2(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static ListValue r3(byte[] bArr) throws InvalidProtocolBufferException {
        return (ListValue) GeneratedMessageLite.o2(DEFAULT_INSTANCE, bArr);
    }

    public static ListValue s3(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (ListValue) GeneratedMessageLite.s2(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static Parser<ListValue> t3() {
        return DEFAULT_INSTANCE.q2();
    }

    /* access modifiers changed from: private */
    public void u3(int i2) {
        b3();
        this.values_.remove(i2);
    }

    /* access modifiers changed from: private */
    public void v3(int i2, Value.Builder builder) {
        b3();
        this.values_.set(i2, builder.build());
    }

    /* access modifiers changed from: private */
    public void w3(int i2, Value value) {
        value.getClass();
        b3();
        this.values_.set(i2, value);
    }

    /* access modifiers changed from: protected */
    public final Object B0(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        switch (AnonymousClass1.f7183a[methodToInvoke.ordinal()]) {
            case 1:
                return new ListValue();
            case 2:
                return new Builder((AnonymousClass1) null);
            case 3:
                return GeneratedMessageLite.J1(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"values_", Value.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<ListValue> parser = PARSER;
                if (parser == null) {
                    synchronized (ListValue.class) {
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

    public ValueOrBuilder d3(int i2) {
        return this.values_.get(i2);
    }

    public List<? extends ValueOrBuilder> e3() {
        return this.values_;
    }

    public int i2() {
        return this.values_.size();
    }

    public Value j2(int i2) {
        return this.values_.get(i2);
    }

    public List<Value> w1() {
        return this.values_;
    }
}
