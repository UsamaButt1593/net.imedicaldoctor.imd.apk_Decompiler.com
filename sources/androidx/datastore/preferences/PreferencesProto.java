package androidx.datastore.preferences;

import androidx.datastore.preferences.protobuf.AbstractMessageLite;
import androidx.datastore.preferences.protobuf.ByteString;
import androidx.datastore.preferences.protobuf.CodedInputStream;
import androidx.datastore.preferences.protobuf.ExtensionRegistryLite;
import androidx.datastore.preferences.protobuf.GeneratedMessageLite;
import androidx.datastore.preferences.protobuf.Internal;
import androidx.datastore.preferences.protobuf.InvalidProtocolBufferException;
import androidx.datastore.preferences.protobuf.MapEntryLite;
import androidx.datastore.preferences.protobuf.MapFieldLite;
import androidx.datastore.preferences.protobuf.MessageLite;
import androidx.datastore.preferences.protobuf.MessageLiteOrBuilder;
import androidx.datastore.preferences.protobuf.Parser;
import androidx.datastore.preferences.protobuf.WireFormat;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public final class PreferencesProto {

    /* renamed from: androidx.datastore.preferences.PreferencesProto$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f6952a;

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
                f6952a = r0
                androidx.datastore.preferences.protobuf.GeneratedMessageLite$MethodToInvoke r1 = androidx.datastore.preferences.protobuf.GeneratedMessageLite.MethodToInvoke.NEW_MUTABLE_INSTANCE     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f6952a     // Catch:{ NoSuchFieldError -> 0x001d }
                androidx.datastore.preferences.protobuf.GeneratedMessageLite$MethodToInvoke r1 = androidx.datastore.preferences.protobuf.GeneratedMessageLite.MethodToInvoke.NEW_BUILDER     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f6952a     // Catch:{ NoSuchFieldError -> 0x0028 }
                androidx.datastore.preferences.protobuf.GeneratedMessageLite$MethodToInvoke r1 = androidx.datastore.preferences.protobuf.GeneratedMessageLite.MethodToInvoke.BUILD_MESSAGE_INFO     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f6952a     // Catch:{ NoSuchFieldError -> 0x0033 }
                androidx.datastore.preferences.protobuf.GeneratedMessageLite$MethodToInvoke r1 = androidx.datastore.preferences.protobuf.GeneratedMessageLite.MethodToInvoke.GET_DEFAULT_INSTANCE     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = f6952a     // Catch:{ NoSuchFieldError -> 0x003e }
                androidx.datastore.preferences.protobuf.GeneratedMessageLite$MethodToInvoke r1 = androidx.datastore.preferences.protobuf.GeneratedMessageLite.MethodToInvoke.GET_PARSER     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = f6952a     // Catch:{ NoSuchFieldError -> 0x0049 }
                androidx.datastore.preferences.protobuf.GeneratedMessageLite$MethodToInvoke r1 = androidx.datastore.preferences.protobuf.GeneratedMessageLite.MethodToInvoke.GET_MEMOIZED_IS_INITIALIZED     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                int[] r0 = f6952a     // Catch:{ NoSuchFieldError -> 0x0054 }
                androidx.datastore.preferences.protobuf.GeneratedMessageLite$MethodToInvoke r1 = androidx.datastore.preferences.protobuf.GeneratedMessageLite.MethodToInvoke.SET_MEMOIZED_IS_INITIALIZED     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.PreferencesProto.AnonymousClass1.<clinit>():void");
        }
    }

    public static final class PreferenceMap extends GeneratedMessageLite<PreferenceMap, Builder> implements PreferenceMapOrBuilder {
        /* access modifiers changed from: private */
        public static final PreferenceMap DEFAULT_INSTANCE;
        private static volatile Parser<PreferenceMap> PARSER = null;
        public static final int PREFERENCES_FIELD_NUMBER = 1;
        private MapFieldLite<String, Value> preferences_ = MapFieldLite.f();

        public static final class Builder extends GeneratedMessageLite.Builder<PreferenceMap, Builder> implements PreferenceMapOrBuilder {
            private Builder() {
                super(PreferenceMap.DEFAULT_INSTANCE);
            }

            public int F() {
                return ((PreferenceMap) this.X).w2().size();
            }

            @Deprecated
            public Map<String, Value> K0() {
                return w2();
            }

            public boolean o0(String str) {
                str.getClass();
                return ((PreferenceMap) this.X).w2().containsKey(str);
            }

            public Builder o3() {
                g3();
                ((PreferenceMap) this.X).O2().clear();
                return this;
            }

            public Builder p3(Map<String, Value> map) {
                g3();
                ((PreferenceMap) this.X).O2().putAll(map);
                return this;
            }

            public Builder q3(String str, Value value) {
                str.getClass();
                value.getClass();
                g3();
                ((PreferenceMap) this.X).O2().put(str, value);
                return this;
            }

            public Value r0(String str, Value value) {
                str.getClass();
                Map<String, Value> w2 = ((PreferenceMap) this.X).w2();
                return w2.containsKey(str) ? w2.get(str) : value;
            }

            public Builder r3(String str) {
                str.getClass();
                g3();
                ((PreferenceMap) this.X).O2().remove(str);
                return this;
            }

            public Map<String, Value> w2() {
                return Collections.unmodifiableMap(((PreferenceMap) this.X).w2());
            }

            public Value z1(String str) {
                str.getClass();
                Map<String, Value> w2 = ((PreferenceMap) this.X).w2();
                if (w2.containsKey(str)) {
                    return w2.get(str);
                }
                throw new IllegalArgumentException();
            }

            /* synthetic */ Builder(AnonymousClass1 r1) {
                this();
            }
        }

        private static final class PreferencesDefaultEntryHolder {

            /* renamed from: a  reason: collision with root package name */
            static final MapEntryLite<String, Value> f6953a = MapEntryLite.f(WireFormat.FieldType.STRING, "", WireFormat.FieldType.MESSAGE, Value.m3());

            private PreferencesDefaultEntryHolder() {
            }
        }

        static {
            PreferenceMap preferenceMap = new PreferenceMap();
            DEFAULT_INSTANCE = preferenceMap;
            GeneratedMessageLite.J2(PreferenceMap.class, preferenceMap);
        }

        private PreferenceMap() {
        }

        public static PreferenceMap N2() {
            return DEFAULT_INSTANCE;
        }

        /* access modifiers changed from: private */
        public Map<String, Value> O2() {
            return P2();
        }

        private MapFieldLite<String, Value> P2() {
            if (!this.preferences_.l()) {
                this.preferences_ = this.preferences_.o();
            }
            return this.preferences_;
        }

        private MapFieldLite<String, Value> Q2() {
            return this.preferences_;
        }

        public static Builder R2() {
            return (Builder) DEFAULT_INSTANCE.i0();
        }

        public static Builder S2(PreferenceMap preferenceMap) {
            return (Builder) DEFAULT_INSTANCE.j0(preferenceMap);
        }

        public static PreferenceMap T2(InputStream inputStream) throws IOException {
            return (PreferenceMap) GeneratedMessageLite.N1(DEFAULT_INSTANCE, inputStream);
        }

        public static PreferenceMap U2(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (PreferenceMap) GeneratedMessageLite.P1(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static PreferenceMap V2(ByteString byteString) throws InvalidProtocolBufferException {
            return (PreferenceMap) GeneratedMessageLite.V1(DEFAULT_INSTANCE, byteString);
        }

        public static PreferenceMap W2(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (PreferenceMap) GeneratedMessageLite.W1(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static PreferenceMap X2(CodedInputStream codedInputStream) throws IOException {
            return (PreferenceMap) GeneratedMessageLite.X1(DEFAULT_INSTANCE, codedInputStream);
        }

        public static PreferenceMap Y2(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (PreferenceMap) GeneratedMessageLite.Y1(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }

        public static PreferenceMap Z2(InputStream inputStream) throws IOException {
            return (PreferenceMap) GeneratedMessageLite.Z1(DEFAULT_INSTANCE, inputStream);
        }

        public static PreferenceMap a3(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (PreferenceMap) GeneratedMessageLite.c2(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static PreferenceMap b3(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (PreferenceMap) GeneratedMessageLite.h2(DEFAULT_INSTANCE, byteBuffer);
        }

        public static PreferenceMap c3(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (PreferenceMap) GeneratedMessageLite.l2(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        public static PreferenceMap d3(byte[] bArr) throws InvalidProtocolBufferException {
            return (PreferenceMap) GeneratedMessageLite.o2(DEFAULT_INSTANCE, bArr);
        }

        public static PreferenceMap e3(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (PreferenceMap) GeneratedMessageLite.s2(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static Parser<PreferenceMap> f3() {
            return DEFAULT_INSTANCE.q2();
        }

        /* access modifiers changed from: protected */
        public final Object B0(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            switch (AnonymousClass1.f6952a[methodToInvoke.ordinal()]) {
                case 1:
                    return new PreferenceMap();
                case 2:
                    return new Builder((AnonymousClass1) null);
                case 3:
                    return GeneratedMessageLite.J1(DEFAULT_INSTANCE, "\u0001\u0001\u0000\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u00012", new Object[]{"preferences_", PreferencesDefaultEntryHolder.f6953a});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<PreferenceMap> parser = PARSER;
                    if (parser == null) {
                        synchronized (PreferenceMap.class) {
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

        public int F() {
            return Q2().size();
        }

        @Deprecated
        public Map<String, Value> K0() {
            return w2();
        }

        public boolean o0(String str) {
            str.getClass();
            return Q2().containsKey(str);
        }

        public Value r0(String str, Value value) {
            str.getClass();
            MapFieldLite<String, Value> Q2 = Q2();
            return Q2.containsKey(str) ? Q2.get(str) : value;
        }

        public Map<String, Value> w2() {
            return Collections.unmodifiableMap(Q2());
        }

        public Value z1(String str) {
            str.getClass();
            MapFieldLite<String, Value> Q2 = Q2();
            if (Q2.containsKey(str)) {
                return Q2.get(str);
            }
            throw new IllegalArgumentException();
        }
    }

    public interface PreferenceMapOrBuilder extends MessageLiteOrBuilder {
        int F();

        @Deprecated
        Map<String, Value> K0();

        boolean o0(String str);

        Value r0(String str, Value value);

        Map<String, Value> w2();

        Value z1(String str);
    }

    public static final class StringSet extends GeneratedMessageLite<StringSet, Builder> implements StringSetOrBuilder {
        /* access modifiers changed from: private */
        public static final StringSet DEFAULT_INSTANCE;
        private static volatile Parser<StringSet> PARSER = null;
        public static final int STRINGS_FIELD_NUMBER = 1;
        private Internal.ProtobufList<String> strings_ = GeneratedMessageLite.U0();

        public static final class Builder extends GeneratedMessageLite.Builder<StringSet, Builder> implements StringSetOrBuilder {
            private Builder() {
                super(StringSet.DEFAULT_INSTANCE);
            }

            public ByteString S(int i2) {
                return ((StringSet) this.X).S(i2);
            }

            public int U() {
                return ((StringSet) this.X).U();
            }

            public Builder o3(Iterable<String> iterable) {
                g3();
                ((StringSet) this.X).R2(iterable);
                return this;
            }

            public Builder p3(String str) {
                g3();
                ((StringSet) this.X).S2(str);
                return this;
            }

            public Builder q3(ByteString byteString) {
                g3();
                ((StringSet) this.X).T2(byteString);
                return this;
            }

            public Builder r3() {
                g3();
                ((StringSet) this.X).U2();
                return this;
            }

            public Builder s3(int i2, String str) {
                g3();
                ((StringSet) this.X).m3(i2, str);
                return this;
            }

            public String t1(int i2) {
                return ((StringSet) this.X).t1(i2);
            }

            public List<String> y1() {
                return Collections.unmodifiableList(((StringSet) this.X).y1());
            }

            /* synthetic */ Builder(AnonymousClass1 r1) {
                this();
            }
        }

        static {
            StringSet stringSet = new StringSet();
            DEFAULT_INSTANCE = stringSet;
            GeneratedMessageLite.J2(StringSet.class, stringSet);
        }

        private StringSet() {
        }

        /* access modifiers changed from: private */
        public void R2(Iterable<String> iterable) {
            V2();
            AbstractMessageLite.k(iterable, this.strings_);
        }

        /* access modifiers changed from: private */
        public void S2(String str) {
            str.getClass();
            V2();
            this.strings_.add(str);
        }

        /* access modifiers changed from: private */
        public void T2(ByteString byteString) {
            byteString.getClass();
            V2();
            this.strings_.add(byteString.o0());
        }

        /* access modifiers changed from: private */
        public void U2() {
            this.strings_ = GeneratedMessageLite.U0();
        }

        private void V2() {
            if (!this.strings_.P2()) {
                this.strings_ = GeneratedMessageLite.G1(this.strings_);
            }
        }

        public static StringSet W2() {
            return DEFAULT_INSTANCE;
        }

        public static Builder X2() {
            return (Builder) DEFAULT_INSTANCE.i0();
        }

        public static Builder Y2(StringSet stringSet) {
            return (Builder) DEFAULT_INSTANCE.j0(stringSet);
        }

        public static StringSet Z2(InputStream inputStream) throws IOException {
            return (StringSet) GeneratedMessageLite.N1(DEFAULT_INSTANCE, inputStream);
        }

        public static StringSet a3(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (StringSet) GeneratedMessageLite.P1(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static StringSet b3(ByteString byteString) throws InvalidProtocolBufferException {
            return (StringSet) GeneratedMessageLite.V1(DEFAULT_INSTANCE, byteString);
        }

        public static StringSet c3(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (StringSet) GeneratedMessageLite.W1(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static StringSet d3(CodedInputStream codedInputStream) throws IOException {
            return (StringSet) GeneratedMessageLite.X1(DEFAULT_INSTANCE, codedInputStream);
        }

        public static StringSet e3(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (StringSet) GeneratedMessageLite.Y1(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }

        public static StringSet f3(InputStream inputStream) throws IOException {
            return (StringSet) GeneratedMessageLite.Z1(DEFAULT_INSTANCE, inputStream);
        }

        public static StringSet g3(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (StringSet) GeneratedMessageLite.c2(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static StringSet h3(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (StringSet) GeneratedMessageLite.h2(DEFAULT_INSTANCE, byteBuffer);
        }

        public static StringSet i3(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (StringSet) GeneratedMessageLite.l2(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        public static StringSet j3(byte[] bArr) throws InvalidProtocolBufferException {
            return (StringSet) GeneratedMessageLite.o2(DEFAULT_INSTANCE, bArr);
        }

        public static StringSet k3(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (StringSet) GeneratedMessageLite.s2(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static Parser<StringSet> l3() {
            return DEFAULT_INSTANCE.q2();
        }

        /* access modifiers changed from: private */
        public void m3(int i2, String str) {
            str.getClass();
            V2();
            this.strings_.set(i2, str);
        }

        /* access modifiers changed from: protected */
        public final Object B0(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            switch (AnonymousClass1.f6952a[methodToInvoke.ordinal()]) {
                case 1:
                    return new StringSet();
                case 2:
                    return new Builder((AnonymousClass1) null);
                case 3:
                    return GeneratedMessageLite.J1(DEFAULT_INSTANCE, "\u0001\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001a", new Object[]{"strings_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<StringSet> parser = PARSER;
                    if (parser == null) {
                        synchronized (StringSet.class) {
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

        public ByteString S(int i2) {
            return ByteString.B(this.strings_.get(i2));
        }

        public int U() {
            return this.strings_.size();
        }

        public String t1(int i2) {
            return this.strings_.get(i2);
        }

        public List<String> y1() {
            return this.strings_;
        }
    }

    public interface StringSetOrBuilder extends MessageLiteOrBuilder {
        ByteString S(int i2);

        int U();

        String t1(int i2);

        List<String> y1();
    }

    public static final class Value extends GeneratedMessageLite<Value, Builder> implements ValueOrBuilder {
        public static final int BOOLEAN_FIELD_NUMBER = 1;
        /* access modifiers changed from: private */
        public static final Value DEFAULT_INSTANCE;
        public static final int DOUBLE_FIELD_NUMBER = 7;
        public static final int FLOAT_FIELD_NUMBER = 2;
        public static final int INTEGER_FIELD_NUMBER = 3;
        public static final int LONG_FIELD_NUMBER = 4;
        private static volatile Parser<Value> PARSER = null;
        public static final int STRING_FIELD_NUMBER = 5;
        public static final int STRING_SET_FIELD_NUMBER = 6;
        private int bitField0_;
        private int valueCase_ = 0;
        private Object value_;

        public static final class Builder extends GeneratedMessageLite.Builder<Value, Builder> implements ValueOrBuilder {
            private Builder() {
                super(Value.DEFAULT_INSTANCE);
            }

            public boolean A1() {
                return ((Value) this.X).A1();
            }

            public Builder A3(int i2) {
                g3();
                ((Value) this.X).G3(i2);
                return this;
            }

            public ByteString B() {
                return ((Value) this.X).B();
            }

            public Builder B3(long j2) {
                g3();
                ((Value) this.X).H3(j2);
                return this;
            }

            public Builder C3(String str) {
                g3();
                ((Value) this.X).I3(str);
                return this;
            }

            public Builder D3(ByteString byteString) {
                g3();
                ((Value) this.X).J3(byteString);
                return this;
            }

            public ValueCase E0() {
                return ((Value) this.X).E0();
            }

            public Builder E3(StringSet.Builder builder) {
                g3();
                ((Value) this.X).K3(builder);
                return this;
            }

            public Builder F3(StringSet stringSet) {
                g3();
                ((Value) this.X).L3(stringSet);
                return this;
            }

            public double G() {
                return ((Value) this.X).G();
            }

            public boolean H1() {
                return ((Value) this.X).H1();
            }

            public boolean L() {
                return ((Value) this.X).L();
            }

            public boolean O0() {
                return ((Value) this.X).O0();
            }

            public boolean O1() {
                return ((Value) this.X).O1();
            }

            public String Q() {
                return ((Value) this.X).Q();
            }

            public boolean V() {
                return ((Value) this.X).V();
            }

            public long Y() {
                return ((Value) this.X).Y();
            }

            public boolean f2() {
                return ((Value) this.X).f2();
            }

            public boolean n0() {
                return ((Value) this.X).n0();
            }

            public Builder o3() {
                g3();
                ((Value) this.X).e3();
                return this;
            }

            public Builder p3() {
                g3();
                ((Value) this.X).f3();
                return this;
            }

            public Builder q3() {
                g3();
                ((Value) this.X).g3();
                return this;
            }

            public Builder r3() {
                g3();
                ((Value) this.X).h3();
                return this;
            }

            public Builder s3() {
                g3();
                ((Value) this.X).i3();
                return this;
            }

            public Builder t3() {
                g3();
                ((Value) this.X).j3();
                return this;
            }

            public float u1() {
                return ((Value) this.X).u1();
            }

            public Builder u3() {
                g3();
                ((Value) this.X).k3();
                return this;
            }

            public Builder v3() {
                g3();
                ((Value) this.X).l3();
                return this;
            }

            public Builder w3(StringSet stringSet) {
                g3();
                ((Value) this.X).n3(stringSet);
                return this;
            }

            public Builder x3(boolean z) {
                g3();
                ((Value) this.X).D3(z);
                return this;
            }

            public int y() {
                return ((Value) this.X).y();
            }

            public Builder y3(double d2) {
                g3();
                ((Value) this.X).E3(d2);
                return this;
            }

            public StringSet z() {
                return ((Value) this.X).z();
            }

            public Builder z3(float f2) {
                g3();
                ((Value) this.X).F3(f2);
                return this;
            }

            /* synthetic */ Builder(AnonymousClass1 r1) {
                this();
            }
        }

        public enum ValueCase {
            BOOLEAN(1),
            FLOAT(2),
            INTEGER(3),
            LONG(4),
            STRING(5),
            STRING_SET(6),
            DOUBLE(7),
            VALUE_NOT_SET(0);
            
            private final int s;

            private ValueCase(int i2) {
                this.s = i2;
            }

            public static ValueCase a(int i2) {
                switch (i2) {
                    case 0:
                        return VALUE_NOT_SET;
                    case 1:
                        return BOOLEAN;
                    case 2:
                        return FLOAT;
                    case 3:
                        return INTEGER;
                    case 4:
                        return LONG;
                    case 5:
                        return STRING;
                    case 6:
                        return STRING_SET;
                    case 7:
                        return DOUBLE;
                    default:
                        return null;
                }
            }

            @Deprecated
            public static ValueCase b(int i2) {
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

        public static Value A3(byte[] bArr) throws InvalidProtocolBufferException {
            return (Value) GeneratedMessageLite.o2(DEFAULT_INSTANCE, bArr);
        }

        public static Value B3(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (Value) GeneratedMessageLite.s2(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static Parser<Value> C3() {
            return DEFAULT_INSTANCE.q2();
        }

        /* access modifiers changed from: private */
        public void D3(boolean z) {
            this.valueCase_ = 1;
            this.value_ = Boolean.valueOf(z);
        }

        /* access modifiers changed from: private */
        public void E3(double d2) {
            this.valueCase_ = 7;
            this.value_ = Double.valueOf(d2);
        }

        /* access modifiers changed from: private */
        public void F3(float f2) {
            this.valueCase_ = 2;
            this.value_ = Float.valueOf(f2);
        }

        /* access modifiers changed from: private */
        public void G3(int i2) {
            this.valueCase_ = 3;
            this.value_ = Integer.valueOf(i2);
        }

        /* access modifiers changed from: private */
        public void H3(long j2) {
            this.valueCase_ = 4;
            this.value_ = Long.valueOf(j2);
        }

        /* access modifiers changed from: private */
        public void I3(String str) {
            str.getClass();
            this.valueCase_ = 5;
            this.value_ = str;
        }

        /* access modifiers changed from: private */
        public void J3(ByteString byteString) {
            byteString.getClass();
            this.valueCase_ = 5;
            this.value_ = byteString.o0();
        }

        /* access modifiers changed from: private */
        public void K3(StringSet.Builder builder) {
            this.value_ = builder.build();
            this.valueCase_ = 6;
        }

        /* access modifiers changed from: private */
        public void L3(StringSet stringSet) {
            stringSet.getClass();
            this.value_ = stringSet;
            this.valueCase_ = 6;
        }

        /* access modifiers changed from: private */
        public void e3() {
            if (this.valueCase_ == 1) {
                this.valueCase_ = 0;
                this.value_ = null;
            }
        }

        /* access modifiers changed from: private */
        public void f3() {
            if (this.valueCase_ == 7) {
                this.valueCase_ = 0;
                this.value_ = null;
            }
        }

        /* access modifiers changed from: private */
        public void g3() {
            if (this.valueCase_ == 2) {
                this.valueCase_ = 0;
                this.value_ = null;
            }
        }

        /* access modifiers changed from: private */
        public void h3() {
            if (this.valueCase_ == 3) {
                this.valueCase_ = 0;
                this.value_ = null;
            }
        }

        /* access modifiers changed from: private */
        public void i3() {
            if (this.valueCase_ == 4) {
                this.valueCase_ = 0;
                this.value_ = null;
            }
        }

        /* access modifiers changed from: private */
        public void j3() {
            if (this.valueCase_ == 5) {
                this.valueCase_ = 0;
                this.value_ = null;
            }
        }

        /* access modifiers changed from: private */
        public void k3() {
            if (this.valueCase_ == 6) {
                this.valueCase_ = 0;
                this.value_ = null;
            }
        }

        /* access modifiers changed from: private */
        public void l3() {
            this.valueCase_ = 0;
            this.value_ = null;
        }

        public static Value m3() {
            return DEFAULT_INSTANCE;
        }

        /* access modifiers changed from: private */
        public void n3(StringSet stringSet) {
            stringSet.getClass();
            MessageLite messageLite = stringSet;
            if (this.valueCase_ == 6) {
                messageLite = stringSet;
                if (this.value_ != StringSet.W2()) {
                    messageLite = ((StringSet.Builder) StringSet.Y2((StringSet) this.value_).k3(stringSet)).M1();
                }
            }
            this.value_ = messageLite;
            this.valueCase_ = 6;
        }

        public static Builder o3() {
            return (Builder) DEFAULT_INSTANCE.i0();
        }

        public static Builder p3(Value value) {
            return (Builder) DEFAULT_INSTANCE.j0(value);
        }

        public static Value q3(InputStream inputStream) throws IOException {
            return (Value) GeneratedMessageLite.N1(DEFAULT_INSTANCE, inputStream);
        }

        public static Value r3(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (Value) GeneratedMessageLite.P1(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static Value s3(ByteString byteString) throws InvalidProtocolBufferException {
            return (Value) GeneratedMessageLite.V1(DEFAULT_INSTANCE, byteString);
        }

        public static Value t3(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (Value) GeneratedMessageLite.W1(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static Value u3(CodedInputStream codedInputStream) throws IOException {
            return (Value) GeneratedMessageLite.X1(DEFAULT_INSTANCE, codedInputStream);
        }

        public static Value v3(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (Value) GeneratedMessageLite.Y1(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }

        public static Value w3(InputStream inputStream) throws IOException {
            return (Value) GeneratedMessageLite.Z1(DEFAULT_INSTANCE, inputStream);
        }

        public static Value x3(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (Value) GeneratedMessageLite.c2(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static Value y3(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (Value) GeneratedMessageLite.h2(DEFAULT_INSTANCE, byteBuffer);
        }

        public static Value z3(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (Value) GeneratedMessageLite.l2(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        public boolean A1() {
            return this.valueCase_ == 5;
        }

        public ByteString B() {
            return ByteString.B(this.valueCase_ == 5 ? (String) this.value_ : "");
        }

        /* access modifiers changed from: protected */
        public final Object B0(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            switch (AnonymousClass1.f6952a[methodToInvoke.ordinal()]) {
                case 1:
                    return new Value();
                case 2:
                    return new Builder((AnonymousClass1) null);
                case 3:
                    return GeneratedMessageLite.J1(DEFAULT_INSTANCE, "\u0001\u0007\u0001\u0001\u0001\u0007\u0007\u0000\u0000\u0000\u0001:\u0000\u00024\u0000\u00037\u0000\u00045\u0000\u0005;\u0000\u0006<\u0000\u00073\u0000", new Object[]{"value_", "valueCase_", "bitField0_", StringSet.class});
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

        public ValueCase E0() {
            return ValueCase.a(this.valueCase_);
        }

        public double G() {
            if (this.valueCase_ == 7) {
                return ((Double) this.value_).doubleValue();
            }
            return 0.0d;
        }

        public boolean H1() {
            return this.valueCase_ == 3;
        }

        public boolean L() {
            return this.valueCase_ == 1;
        }

        public boolean O0() {
            return this.valueCase_ == 7;
        }

        public boolean O1() {
            return this.valueCase_ == 2;
        }

        public String Q() {
            return this.valueCase_ == 5 ? (String) this.value_ : "";
        }

        public boolean V() {
            return this.valueCase_ == 4;
        }

        public long Y() {
            if (this.valueCase_ == 4) {
                return ((Long) this.value_).longValue();
            }
            return 0;
        }

        public boolean f2() {
            return this.valueCase_ == 6;
        }

        public boolean n0() {
            if (this.valueCase_ == 1) {
                return ((Boolean) this.value_).booleanValue();
            }
            return false;
        }

        public float u1() {
            if (this.valueCase_ == 2) {
                return ((Float) this.value_).floatValue();
            }
            return 0.0f;
        }

        public int y() {
            if (this.valueCase_ == 3) {
                return ((Integer) this.value_).intValue();
            }
            return 0;
        }

        public StringSet z() {
            return this.valueCase_ == 6 ? (StringSet) this.value_ : StringSet.W2();
        }
    }

    public interface ValueOrBuilder extends MessageLiteOrBuilder {
        boolean A1();

        ByteString B();

        Value.ValueCase E0();

        double G();

        boolean H1();

        boolean L();

        boolean O0();

        boolean O1();

        String Q();

        boolean V();

        long Y();

        boolean f2();

        boolean n0();

        float u1();

        int y();

        StringSet z();
    }

    private PreferencesProto() {
    }

    public static void a(ExtensionRegistryLite extensionRegistryLite) {
    }
}
