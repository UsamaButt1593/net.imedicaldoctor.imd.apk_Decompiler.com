package com.google.firebase.encoders.json;

import android.util.Base64;
import android.util.JsonWriter;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.firebase.encoders.EncodingException;
import com.google.firebase.encoders.FieldDescriptor;
import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;
import com.google.firebase.encoders.ValueEncoder;
import com.google.firebase.encoders.ValueEncoderContext;
import java.io.IOException;
import java.io.Writer;
import java.util.Collection;
import java.util.Date;
import java.util.Map;

final class JsonValueObjectEncoderContext implements ObjectEncoderContext, ValueEncoderContext {

    /* renamed from: a  reason: collision with root package name */
    private JsonValueObjectEncoderContext f24346a = null;

    /* renamed from: b  reason: collision with root package name */
    private boolean f24347b = true;

    /* renamed from: c  reason: collision with root package name */
    private final JsonWriter f24348c;

    /* renamed from: d  reason: collision with root package name */
    private final Map<Class<?>, ObjectEncoder<?>> f24349d;

    /* renamed from: e  reason: collision with root package name */
    private final Map<Class<?>, ValueEncoder<?>> f24350e;

    /* renamed from: f  reason: collision with root package name */
    private final ObjectEncoder<Object> f24351f;

    /* renamed from: g  reason: collision with root package name */
    private final boolean f24352g;

    private JsonValueObjectEncoderContext(JsonValueObjectEncoderContext jsonValueObjectEncoderContext) {
        this.f24348c = jsonValueObjectEncoderContext.f24348c;
        this.f24349d = jsonValueObjectEncoderContext.f24349d;
        this.f24350e = jsonValueObjectEncoderContext.f24350e;
        this.f24351f = jsonValueObjectEncoderContext.f24351f;
        this.f24352g = jsonValueObjectEncoderContext.f24352g;
    }

    private boolean H(Object obj) {
        return obj == null || obj.getClass().isArray() || (obj instanceof Collection) || (obj instanceof Date) || (obj instanceof Enum) || (obj instanceof Number);
    }

    private JsonValueObjectEncoderContext K(@NonNull String str, @Nullable Object obj) throws IOException, EncodingException {
        M();
        this.f24348c.name(str);
        if (obj != null) {
            return y(obj, false);
        }
        this.f24348c.nullValue();
        return this;
    }

    private JsonValueObjectEncoderContext L(@NonNull String str, @Nullable Object obj) throws IOException, EncodingException {
        if (obj == null) {
            return this;
        }
        M();
        this.f24348c.name(str);
        return y(obj, false);
    }

    private void M() throws IOException {
        if (this.f24347b) {
            JsonValueObjectEncoderContext jsonValueObjectEncoderContext = this.f24346a;
            if (jsonValueObjectEncoderContext != null) {
                jsonValueObjectEncoderContext.M();
                this.f24346a.f24347b = false;
                this.f24346a = null;
                this.f24348c.endObject();
                return;
            }
            return;
        }
        throw new IllegalStateException("Parent context used since this context was created. Cannot use this context anymore.");
    }

    @NonNull
    /* renamed from: A */
    public JsonValueObjectEncoderContext j(@NonNull String str, double d2) throws IOException {
        M();
        this.f24348c.name(str);
        return p(d2);
    }

    @NonNull
    /* renamed from: B */
    public JsonValueObjectEncoderContext l(@NonNull String str, int i2) throws IOException {
        M();
        this.f24348c.name(str);
        return add(i2);
    }

    @NonNull
    /* renamed from: C */
    public JsonValueObjectEncoderContext k(@NonNull String str, long j2) throws IOException {
        M();
        this.f24348c.name(str);
        return a(j2);
    }

    @NonNull
    /* renamed from: D */
    public JsonValueObjectEncoderContext o(@NonNull String str, @Nullable Object obj) throws IOException {
        return this.f24352g ? L(str, obj) : K(str, obj);
    }

    @NonNull
    /* renamed from: E */
    public JsonValueObjectEncoderContext i(@NonNull String str, boolean z) throws IOException {
        M();
        this.f24348c.name(str);
        return n(z);
    }

    @NonNull
    /* renamed from: F */
    public JsonValueObjectEncoderContext n(boolean z) throws IOException {
        M();
        this.f24348c.value(z);
        return this;
    }

    @NonNull
    /* renamed from: G */
    public JsonValueObjectEncoderContext u(@Nullable byte[] bArr) throws IOException {
        M();
        if (bArr == null) {
            this.f24348c.nullValue();
        } else {
            this.f24348c.value(Base64.encodeToString(bArr, 2));
        }
        return this;
    }

    /* access modifiers changed from: package-private */
    public void I() throws IOException {
        M();
        this.f24348c.flush();
    }

    /* access modifiers changed from: package-private */
    public JsonValueObjectEncoderContext J(ObjectEncoder<Object> objectEncoder, Object obj, boolean z) throws IOException {
        if (!z) {
            this.f24348c.beginObject();
        }
        objectEncoder.a(obj, this);
        if (!z) {
            this.f24348c.endObject();
        }
        return this;
    }

    @NonNull
    public ObjectEncoderContext b(@NonNull FieldDescriptor fieldDescriptor, boolean z) throws IOException {
        return i(fieldDescriptor.b(), z);
    }

    @NonNull
    public ObjectEncoderContext c(@NonNull FieldDescriptor fieldDescriptor, long j2) throws IOException {
        return k(fieldDescriptor.b(), j2);
    }

    @NonNull
    public ObjectEncoderContext d(@NonNull FieldDescriptor fieldDescriptor, int i2) throws IOException {
        return l(fieldDescriptor.b(), i2);
    }

    @NonNull
    public ObjectEncoderContext e(@NonNull FieldDescriptor fieldDescriptor, float f2) throws IOException {
        return j(fieldDescriptor.b(), (double) f2);
    }

    @NonNull
    public ObjectEncoderContext f(@NonNull FieldDescriptor fieldDescriptor) throws IOException {
        return r(fieldDescriptor.b());
    }

    @NonNull
    public ObjectEncoderContext g(@NonNull FieldDescriptor fieldDescriptor, double d2) throws IOException {
        return j(fieldDescriptor.b(), d2);
    }

    @NonNull
    public ObjectEncoderContext h(@Nullable Object obj) throws IOException {
        return y(obj, true);
    }

    @NonNull
    public ObjectEncoderContext r(@NonNull String str) throws IOException {
        M();
        this.f24346a = new JsonValueObjectEncoderContext(this);
        this.f24348c.name(str);
        this.f24348c.beginObject();
        return this.f24346a;
    }

    @NonNull
    public ObjectEncoderContext s(@NonNull FieldDescriptor fieldDescriptor, @Nullable Object obj) throws IOException {
        return o(fieldDescriptor.b(), obj);
    }

    @NonNull
    /* renamed from: t */
    public JsonValueObjectEncoderContext p(double d2) throws IOException {
        M();
        this.f24348c.value(d2);
        return this;
    }

    @NonNull
    /* renamed from: v */
    public JsonValueObjectEncoderContext q(float f2) throws IOException {
        M();
        this.f24348c.value((double) f2);
        return this;
    }

    @NonNull
    /* renamed from: w */
    public JsonValueObjectEncoderContext add(int i2) throws IOException {
        M();
        this.f24348c.value((long) i2);
        return this;
    }

    @NonNull
    /* renamed from: x */
    public JsonValueObjectEncoderContext a(long j2) throws IOException {
        M();
        this.f24348c.value(j2);
        return this;
    }

    /* access modifiers changed from: package-private */
    @NonNull
    public JsonValueObjectEncoderContext y(@Nullable Object obj, boolean z) throws IOException {
        int i2 = 0;
        if (z && H(obj)) {
            throw new EncodingException(String.format("%s cannot be encoded inline", new Object[]{obj == null ? null : obj.getClass()}));
        } else if (obj == null) {
            this.f24348c.nullValue();
            return this;
        } else if (obj instanceof Number) {
            this.f24348c.value((Number) obj);
            return this;
        } else if (obj.getClass().isArray()) {
            if (obj instanceof byte[]) {
                return u((byte[]) obj);
            }
            this.f24348c.beginArray();
            if (obj instanceof int[]) {
                int[] iArr = (int[]) obj;
                int length = iArr.length;
                while (i2 < length) {
                    this.f24348c.value((long) iArr[i2]);
                    i2++;
                }
            } else if (obj instanceof long[]) {
                long[] jArr = (long[]) obj;
                int length2 = jArr.length;
                while (i2 < length2) {
                    a(jArr[i2]);
                    i2++;
                }
            } else if (obj instanceof double[]) {
                double[] dArr = (double[]) obj;
                int length3 = dArr.length;
                while (i2 < length3) {
                    this.f24348c.value(dArr[i2]);
                    i2++;
                }
            } else if (obj instanceof boolean[]) {
                boolean[] zArr = (boolean[]) obj;
                int length4 = zArr.length;
                while (i2 < length4) {
                    this.f24348c.value(zArr[i2]);
                    i2++;
                }
            } else if (obj instanceof Number[]) {
                for (Number y : (Number[]) obj) {
                    y(y, false);
                }
            } else {
                for (Object y2 : (Object[]) obj) {
                    y(y2, false);
                }
            }
            this.f24348c.endArray();
            return this;
        } else if (obj instanceof Collection) {
            this.f24348c.beginArray();
            for (Object y3 : (Collection) obj) {
                y(y3, false);
            }
            this.f24348c.endArray();
            return this;
        } else if (obj instanceof Map) {
            this.f24348c.beginObject();
            for (Map.Entry entry : ((Map) obj).entrySet()) {
                Object key = entry.getKey();
                try {
                    o((String) key, entry.getValue());
                } catch (ClassCastException e2) {
                    throw new EncodingException(String.format("Only String keys are currently supported in maps, got %s of type %s instead.", new Object[]{key, key.getClass()}), e2);
                }
            }
            this.f24348c.endObject();
            return this;
        } else {
            ObjectEncoder objectEncoder = this.f24349d.get(obj.getClass());
            if (objectEncoder != null) {
                return J(objectEncoder, obj, z);
            }
            ValueEncoder valueEncoder = this.f24350e.get(obj.getClass());
            if (valueEncoder != null) {
                valueEncoder.a(obj, this);
                return this;
            } else if (!(obj instanceof Enum)) {
                return J(this.f24351f, obj, z);
            } else {
                if (obj instanceof NumberedEnum) {
                    add(((NumberedEnum) obj).d());
                } else {
                    m(((Enum) obj).name());
                }
                return this;
            }
        }
    }

    @NonNull
    /* renamed from: z */
    public JsonValueObjectEncoderContext m(@Nullable String str) throws IOException {
        M();
        this.f24348c.value(str);
        return this;
    }

    JsonValueObjectEncoderContext(@NonNull Writer writer, @NonNull Map<Class<?>, ObjectEncoder<?>> map, @NonNull Map<Class<?>, ValueEncoder<?>> map2, ObjectEncoder<Object> objectEncoder, boolean z) {
        this.f24348c = new JsonWriter(writer);
        this.f24349d = map;
        this.f24350e = map2;
        this.f24351f = objectEncoder;
        this.f24352g = z;
    }
}
