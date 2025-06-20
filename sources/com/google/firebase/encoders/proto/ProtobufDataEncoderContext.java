package com.google.firebase.encoders.proto;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.firebase.encoders.EncodingException;
import com.google.firebase.encoders.FieldDescriptor;
import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;
import com.google.firebase.encoders.ValueEncoder;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import java.util.Collection;
import java.util.Map;
import kotlinx.coroutines.scheduling.WorkQueueKt;

final class ProtobufDataEncoderContext implements ObjectEncoderContext {

    /* renamed from: f  reason: collision with root package name */
    private static final Charset f24355f = Charset.forName("UTF-8");

    /* renamed from: g  reason: collision with root package name */
    private static final FieldDescriptor f24356g = FieldDescriptor.a("key").b(AtProtobuf.b().d(1).a()).a();

    /* renamed from: h  reason: collision with root package name */
    private static final FieldDescriptor f24357h = FieldDescriptor.a("value").b(AtProtobuf.b().d(2).a()).a();

    /* renamed from: i  reason: collision with root package name */
    private static final ObjectEncoder<Map.Entry<Object, Object>> f24358i = new a();

    /* renamed from: a  reason: collision with root package name */
    private OutputStream f24359a;

    /* renamed from: b  reason: collision with root package name */
    private final Map<Class<?>, ObjectEncoder<?>> f24360b;

    /* renamed from: c  reason: collision with root package name */
    private final Map<Class<?>, ValueEncoder<?>> f24361c;

    /* renamed from: d  reason: collision with root package name */
    private final ObjectEncoder<Object> f24362d;

    /* renamed from: e  reason: collision with root package name */
    private final ProtobufValueEncoderContext f24363e = new ProtobufValueEncoderContext(this);

    /* renamed from: com.google.firebase.encoders.proto.ProtobufDataEncoderContext$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f24364a;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|(3:5|6|8)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        static {
            /*
                com.google.firebase.encoders.proto.Protobuf$IntEncoding[] r0 = com.google.firebase.encoders.proto.Protobuf.IntEncoding.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f24364a = r0
                com.google.firebase.encoders.proto.Protobuf$IntEncoding r1 = com.google.firebase.encoders.proto.Protobuf.IntEncoding.DEFAULT     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f24364a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.google.firebase.encoders.proto.Protobuf$IntEncoding r1 = com.google.firebase.encoders.proto.Protobuf.IntEncoding.SIGNED     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f24364a     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.google.firebase.encoders.proto.Protobuf$IntEncoding r1 = com.google.firebase.encoders.proto.Protobuf.IntEncoding.FIXED     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.encoders.proto.ProtobufDataEncoderContext.AnonymousClass1.<clinit>():void");
        }
    }

    ProtobufDataEncoderContext(OutputStream outputStream, Map<Class<?>, ObjectEncoder<?>> map, Map<Class<?>, ValueEncoder<?>> map2, ObjectEncoder<Object> objectEncoder) {
        this.f24359a = outputStream;
        this.f24360b = map;
        this.f24361c = map2;
        this.f24362d = objectEncoder;
    }

    private <T> ProtobufDataEncoderContext A(ObjectEncoder<T> objectEncoder, FieldDescriptor fieldDescriptor, T t, boolean z) throws IOException {
        long z2 = z(objectEncoder, t);
        if (z && z2 == 0) {
            return this;
        }
        G((E(fieldDescriptor) << 3) | 2);
        H(z2);
        objectEncoder.a(t, this);
        return this;
    }

    private <T> ProtobufDataEncoderContext B(ValueEncoder<T> valueEncoder, FieldDescriptor fieldDescriptor, T t, boolean z) throws IOException {
        this.f24363e.c(fieldDescriptor, z);
        valueEncoder.a(t, this.f24363e);
        return this;
    }

    private static Protobuf D(FieldDescriptor fieldDescriptor) {
        Protobuf protobuf = (Protobuf) fieldDescriptor.c(Protobuf.class);
        if (protobuf != null) {
            return protobuf;
        }
        throw new EncodingException("Field has no @Protobuf config");
    }

    private static int E(FieldDescriptor fieldDescriptor) {
        Protobuf protobuf = (Protobuf) fieldDescriptor.c(Protobuf.class);
        if (protobuf != null) {
            return protobuf.tag();
        }
        throw new EncodingException("Field has no @Protobuf config");
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void F(Map.Entry entry, ObjectEncoderContext objectEncoderContext) throws IOException {
        objectEncoderContext.s(f24356g, entry.getKey());
        objectEncoderContext.s(f24357h, entry.getValue());
    }

    private void G(int i2) throws IOException {
        while (true) {
            int i3 = (((long) (i2 & -128)) > 0 ? 1 : (((long) (i2 & -128)) == 0 ? 0 : -1));
            OutputStream outputStream = this.f24359a;
            if (i3 != 0) {
                outputStream.write((i2 & WorkQueueKt.f29430c) | 128);
                i2 >>>= 7;
            } else {
                outputStream.write(i2 & WorkQueueKt.f29430c);
                return;
            }
        }
    }

    private void H(long j2) throws IOException {
        while (true) {
            int i2 = ((-128 & j2) > 0 ? 1 : ((-128 & j2) == 0 ? 0 : -1));
            OutputStream outputStream = this.f24359a;
            if (i2 != 0) {
                outputStream.write((((int) j2) & WorkQueueKt.f29430c) | 128);
                j2 >>>= 7;
            } else {
                outputStream.write(((int) j2) & WorkQueueKt.f29430c);
                return;
            }
        }
    }

    private static ByteBuffer y(int i2) {
        return ByteBuffer.allocate(i2).order(ByteOrder.LITTLE_ENDIAN);
    }

    private <T> long z(ObjectEncoder<T> objectEncoder, T t) throws IOException {
        OutputStream outputStream;
        LengthCountingOutputStream lengthCountingOutputStream = new LengthCountingOutputStream();
        try {
            outputStream = this.f24359a;
            this.f24359a = lengthCountingOutputStream;
            objectEncoder.a(t, this);
            this.f24359a = outputStream;
            long b2 = lengthCountingOutputStream.b();
            lengthCountingOutputStream.close();
            return b2;
        } catch (Throwable th) {
            th.addSuppressed(th);
        }
        throw th;
    }

    /* access modifiers changed from: package-private */
    public ProtobufDataEncoderContext C(@Nullable Object obj) throws IOException {
        if (obj == null) {
            return this;
        }
        ObjectEncoder objectEncoder = this.f24360b.get(obj.getClass());
        if (objectEncoder != null) {
            objectEncoder.a(obj, this);
            return this;
        }
        throw new EncodingException("No encoder for " + obj.getClass());
    }

    @NonNull
    public ObjectEncoderContext e(@NonNull FieldDescriptor fieldDescriptor, float f2) throws IOException {
        return n(fieldDescriptor, f2, true);
    }

    @NonNull
    public ObjectEncoderContext f(@NonNull FieldDescriptor fieldDescriptor) throws IOException {
        throw new EncodingException("nested() is not implemented for protobuf encoding.");
    }

    @NonNull
    public ObjectEncoderContext g(@NonNull FieldDescriptor fieldDescriptor, double d2) throws IOException {
        return m(fieldDescriptor, d2, true);
    }

    @NonNull
    public ObjectEncoderContext h(@Nullable Object obj) throws IOException {
        return C(obj);
    }

    @NonNull
    public ObjectEncoderContext i(@NonNull String str, boolean z) throws IOException {
        return b(FieldDescriptor.d(str), z);
    }

    @NonNull
    public ObjectEncoderContext j(@NonNull String str, double d2) throws IOException {
        return g(FieldDescriptor.d(str), d2);
    }

    @NonNull
    public ObjectEncoderContext k(@NonNull String str, long j2) throws IOException {
        return c(FieldDescriptor.d(str), j2);
    }

    @NonNull
    public ObjectEncoderContext l(@NonNull String str, int i2) throws IOException {
        return d(FieldDescriptor.d(str), i2);
    }

    /* access modifiers changed from: package-private */
    public ObjectEncoderContext m(@NonNull FieldDescriptor fieldDescriptor, double d2, boolean z) throws IOException {
        if (z && d2 == 0.0d) {
            return this;
        }
        G((E(fieldDescriptor) << 3) | 1);
        this.f24359a.write(y(8).putDouble(d2).array());
        return this;
    }

    /* access modifiers changed from: package-private */
    public ObjectEncoderContext n(@NonNull FieldDescriptor fieldDescriptor, float f2, boolean z) throws IOException {
        if (z && f2 == 0.0f) {
            return this;
        }
        G((E(fieldDescriptor) << 3) | 5);
        this.f24359a.write(y(4).putFloat(f2).array());
        return this;
    }

    @NonNull
    public ObjectEncoderContext o(@NonNull String str, @Nullable Object obj) throws IOException {
        return s(FieldDescriptor.d(str), obj);
    }

    /* access modifiers changed from: package-private */
    public ObjectEncoderContext p(@NonNull FieldDescriptor fieldDescriptor, @Nullable Object obj, boolean z) throws IOException {
        if (obj == null) {
            return this;
        }
        if (obj instanceof CharSequence) {
            CharSequence charSequence = (CharSequence) obj;
            if (z && charSequence.length() == 0) {
                return this;
            }
            G((E(fieldDescriptor) << 3) | 2);
            byte[] bytes = charSequence.toString().getBytes(f24355f);
            G(bytes.length);
            this.f24359a.write(bytes);
            return this;
        } else if (obj instanceof Collection) {
            for (Object p : (Collection) obj) {
                p(fieldDescriptor, p, false);
            }
            return this;
        } else if (obj instanceof Map) {
            for (Map.Entry A : ((Map) obj).entrySet()) {
                A(f24358i, fieldDescriptor, A, false);
            }
            return this;
        } else if (obj instanceof Double) {
            return m(fieldDescriptor, ((Double) obj).doubleValue(), z);
        } else {
            if (obj instanceof Float) {
                return n(fieldDescriptor, ((Float) obj).floatValue(), z);
            }
            if (obj instanceof Number) {
                return v(fieldDescriptor, ((Number) obj).longValue(), z);
            }
            if (obj instanceof Boolean) {
                return x(fieldDescriptor, ((Boolean) obj).booleanValue(), z);
            }
            if (obj instanceof byte[]) {
                byte[] bArr = (byte[]) obj;
                if (z && bArr.length == 0) {
                    return this;
                }
                G((E(fieldDescriptor) << 3) | 2);
                G(bArr.length);
                this.f24359a.write(bArr);
                return this;
            }
            ObjectEncoder objectEncoder = this.f24360b.get(obj.getClass());
            if (objectEncoder != null) {
                return A(objectEncoder, fieldDescriptor, obj, z);
            }
            ValueEncoder valueEncoder = this.f24361c.get(obj.getClass());
            if (valueEncoder != null) {
                return B(valueEncoder, fieldDescriptor, obj, z);
            }
            if (obj instanceof ProtoEnum) {
                return d(fieldDescriptor, ((ProtoEnum) obj).d());
            }
            return obj instanceof Enum ? d(fieldDescriptor, ((Enum) obj).ordinal()) : A(this.f24362d, fieldDescriptor, obj, z);
        }
    }

    @NonNull
    /* renamed from: q */
    public ProtobufDataEncoderContext d(@NonNull FieldDescriptor fieldDescriptor, int i2) throws IOException {
        return t(fieldDescriptor, i2, true);
    }

    @NonNull
    public ObjectEncoderContext r(@NonNull String str) throws IOException {
        return f(FieldDescriptor.d(str));
    }

    @NonNull
    public ObjectEncoderContext s(@NonNull FieldDescriptor fieldDescriptor, @Nullable Object obj) throws IOException {
        return p(fieldDescriptor, obj, true);
    }

    /* access modifiers changed from: package-private */
    public ProtobufDataEncoderContext t(@NonNull FieldDescriptor fieldDescriptor, int i2, boolean z) throws IOException {
        if (z && i2 == 0) {
            return this;
        }
        Protobuf D = D(fieldDescriptor);
        int i3 = AnonymousClass1.f24364a[D.intEncoding().ordinal()];
        if (i3 == 1) {
            G(D.tag() << 3);
            G(i2);
        } else if (i3 == 2) {
            G(D.tag() << 3);
            G((i2 << 1) ^ (i2 >> 31));
        } else if (i3 == 3) {
            G((D.tag() << 3) | 5);
            this.f24359a.write(y(4).putInt(i2).array());
        }
        return this;
    }

    @NonNull
    /* renamed from: u */
    public ProtobufDataEncoderContext c(@NonNull FieldDescriptor fieldDescriptor, long j2) throws IOException {
        return v(fieldDescriptor, j2, true);
    }

    /* access modifiers changed from: package-private */
    public ProtobufDataEncoderContext v(@NonNull FieldDescriptor fieldDescriptor, long j2, boolean z) throws IOException {
        if (z && j2 == 0) {
            return this;
        }
        Protobuf D = D(fieldDescriptor);
        int i2 = AnonymousClass1.f24364a[D.intEncoding().ordinal()];
        if (i2 == 1) {
            G(D.tag() << 3);
            H(j2);
        } else if (i2 == 2) {
            G(D.tag() << 3);
            H((j2 >> 63) ^ (j2 << 1));
        } else if (i2 == 3) {
            G((D.tag() << 3) | 1);
            this.f24359a.write(y(8).putLong(j2).array());
        }
        return this;
    }

    @NonNull
    /* renamed from: w */
    public ProtobufDataEncoderContext b(@NonNull FieldDescriptor fieldDescriptor, boolean z) throws IOException {
        return x(fieldDescriptor, z, true);
    }

    /* access modifiers changed from: package-private */
    public ProtobufDataEncoderContext x(@NonNull FieldDescriptor fieldDescriptor, boolean z, boolean z2) throws IOException {
        return t(fieldDescriptor, z ? 1 : 0, z2);
    }
}
