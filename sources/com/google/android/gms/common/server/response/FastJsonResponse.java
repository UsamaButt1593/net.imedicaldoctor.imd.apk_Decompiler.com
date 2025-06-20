package com.google.android.gms.common.server.response;

import android.os.Parcel;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.server.converter.zaa;
import com.google.android.gms.common.util.JsonUtils;
import com.google.android.gms.common.util.VisibleForTesting;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@ShowFirstParty
@KeepForSdk
public abstract class FastJsonResponse {

    @ShowFirstParty
    @SafeParcelable.Class(creator = "FieldCreator")
    @VisibleForTesting
    @KeepForSdk
    public static class Field<I, O> extends AbstractSafeParcelable {
        public static final zaj CREATOR = new zaj();
        @SafeParcelable.Field(getter = "getTypeIn", id = 2)
        protected final int X;
        @SafeParcelable.Field(getter = "isTypeOutArray", id = 5)
        protected final boolean X2;
        @SafeParcelable.Field(getter = "isTypeInArray", id = 3)
        protected final boolean Y;
        @SafeParcelable.Field(getter = "getOutputFieldName", id = 6)
        @NonNull
        protected final String Y2;
        @SafeParcelable.Field(getter = "getTypeOut", id = 4)
        protected final int Z;
        @SafeParcelable.Field(getter = "getSafeParcelableFieldId", id = 7)
        protected final int Z2;
        @Nullable
        protected final Class<? extends FastJsonResponse> a3;
        @SafeParcelable.Field(getter = "getConcreteTypeName", id = 8)
        @Nullable
        protected final String b3;
        private zan c3;
        /* access modifiers changed from: private */
        @SafeParcelable.Field(getter = "getWrappedConverter", id = 9, type = "com.google.android.gms.common.server.converter.ConverterWrapper")
        @Nullable
        public FieldConverter<I, O> d3;
        @SafeParcelable.VersionField(getter = "getVersionCode", id = 1)
        private final int s;

        @SafeParcelable.Constructor
        Field(@SafeParcelable.Param(id = 1) int i2, @SafeParcelable.Param(id = 2) int i3, @SafeParcelable.Param(id = 3) boolean z, @SafeParcelable.Param(id = 4) int i4, @SafeParcelable.Param(id = 5) boolean z2, @SafeParcelable.Param(id = 6) String str, @SafeParcelable.Param(id = 7) int i5, @SafeParcelable.Param(id = 8) @Nullable String str2, @SafeParcelable.Param(id = 9) @Nullable zaa zaa) {
            this.s = i2;
            this.X = i3;
            this.Y = z;
            this.Z = i4;
            this.X2 = z2;
            this.Y2 = str;
            this.Z2 = i5;
            if (str2 == null) {
                this.a3 = null;
                this.b3 = null;
            } else {
                this.a3 = SafeParcelResponse.class;
                this.b3 = str2;
            }
            if (zaa == null) {
                this.d3 = null;
            } else {
                this.d3 = zaa.H();
            }
        }

        @NonNull
        @KeepForSdk
        @VisibleForTesting
        public static Field<byte[], byte[]> C(@NonNull String str, int i2) {
            return new Field(8, false, 8, false, str, i2, (Class<? extends FastJsonResponse>) null, (FieldConverter) null);
        }

        @NonNull
        @KeepForSdk
        public static Field<Boolean, Boolean> H(@NonNull String str, int i2) {
            return new Field(6, false, 6, false, str, i2, (Class<? extends FastJsonResponse>) null, (FieldConverter) null);
        }

        @NonNull
        @KeepForSdk
        public static <T extends FastJsonResponse> Field<T, T> I(@NonNull String str, int i2, @NonNull Class<T> cls) {
            return new Field(11, false, 11, false, str, i2, cls, (FieldConverter) null);
        }

        @NonNull
        @KeepForSdk
        public static <T extends FastJsonResponse> Field<ArrayList<T>, ArrayList<T>> N(@NonNull String str, int i2, @NonNull Class<T> cls) {
            return new Field(11, true, 11, true, str, i2, cls, (FieldConverter) null);
        }

        @NonNull
        @KeepForSdk
        public static Field<Double, Double> O(@NonNull String str, int i2) {
            return new Field(4, false, 4, false, str, i2, (Class<? extends FastJsonResponse>) null, (FieldConverter) null);
        }

        @NonNull
        @KeepForSdk
        public static Field<Float, Float> P(@NonNull String str, int i2) {
            return new Field(3, false, 3, false, str, i2, (Class<? extends FastJsonResponse>) null, (FieldConverter) null);
        }

        @NonNull
        @KeepForSdk
        @VisibleForTesting
        public static Field<Integer, Integer> Q(@NonNull String str, int i2) {
            return new Field(0, false, 0, false, str, i2, (Class<? extends FastJsonResponse>) null, (FieldConverter) null);
        }

        @NonNull
        @KeepForSdk
        public static Field<Long, Long> R(@NonNull String str, int i2) {
            return new Field(2, false, 2, false, str, i2, (Class<? extends FastJsonResponse>) null, (FieldConverter) null);
        }

        @NonNull
        @KeepForSdk
        public static Field<String, String> S(@NonNull String str, int i2) {
            return new Field(7, false, 7, false, str, i2, (Class<? extends FastJsonResponse>) null, (FieldConverter) null);
        }

        @NonNull
        @KeepForSdk
        public static Field<HashMap<String, String>, HashMap<String, String>> T(@NonNull String str, int i2) {
            return new Field(10, false, 10, false, str, i2, (Class<? extends FastJsonResponse>) null, (FieldConverter) null);
        }

        @NonNull
        @KeepForSdk
        public static Field<ArrayList<String>, ArrayList<String>> W(@NonNull String str, int i2) {
            return new Field(7, true, 7, true, str, i2, (Class<? extends FastJsonResponse>) null, (FieldConverter) null);
        }

        @NonNull
        @KeepForSdk
        public static Field a0(@NonNull String str, int i2, @NonNull FieldConverter<?, ?> fieldConverter, boolean z) {
            fieldConverter.b();
            fieldConverter.c();
            return new Field(7, z, 0, false, str, i2, (Class<? extends FastJsonResponse>) null, fieldConverter);
        }

        @KeepForSdk
        public int Z() {
            return this.Z2;
        }

        /* access modifiers changed from: package-private */
        @Nullable
        public final zaa c0() {
            FieldConverter<I, O> fieldConverter = this.d3;
            if (fieldConverter == null) {
                return null;
            }
            return zaa.C(fieldConverter);
        }

        @NonNull
        public final Field<I, O> d0() {
            return new Field(this.s, this.X, this.Y, this.Z, this.X2, this.Y2, this.Z2, this.b3, c0());
        }

        @NonNull
        public final FastJsonResponse g0() throws InstantiationException, IllegalAccessException {
            Preconditions.r(this.a3);
            Class<? extends FastJsonResponse> cls = this.a3;
            if (cls != SafeParcelResponse.class) {
                return (FastJsonResponse) cls.newInstance();
            }
            Preconditions.r(this.b3);
            Preconditions.s(this.c3, "The field mapping dictionary must be set if the concrete type is a SafeParcelResponse object.");
            return new SafeParcelResponse(this.c3, this.b3);
        }

        @NonNull
        public final O h0(@Nullable I i2) {
            Preconditions.r(this.d3);
            return Preconditions.r(this.d3.p(i2));
        }

        @NonNull
        public final I i0(@NonNull O o) {
            Preconditions.r(this.d3);
            return this.d3.k(o);
        }

        /* access modifiers changed from: package-private */
        @Nullable
        public final String j0() {
            String str = this.b3;
            if (str == null) {
                return null;
            }
            return str;
        }

        @NonNull
        public final Map<String, Field<?, ?>> k0() {
            Preconditions.r(this.b3);
            Preconditions.r(this.c3);
            return (Map) Preconditions.r(this.c3.H(this.b3));
        }

        public final void m0(zan zan) {
            this.c3 = zan;
        }

        public final boolean p0() {
            return this.d3 != null;
        }

        @NonNull
        public final String toString() {
            Objects.ToStringHelper a2 = Objects.d(this).a("versionCode", Integer.valueOf(this.s)).a("typeIn", Integer.valueOf(this.X)).a("typeInArray", Boolean.valueOf(this.Y)).a("typeOut", Integer.valueOf(this.Z)).a("typeOutArray", Boolean.valueOf(this.X2)).a("outputFieldName", this.Y2).a("safeParcelFieldId", Integer.valueOf(this.Z2)).a("concreteTypeName", j0());
            Class<? extends FastJsonResponse> cls = this.a3;
            if (cls != null) {
                a2.a("concreteType.class", cls.getCanonicalName());
            }
            FieldConverter<I, O> fieldConverter = this.d3;
            if (fieldConverter != null) {
                a2.a("converterName", fieldConverter.getClass().getCanonicalName());
            }
            return a2.toString();
        }

        public final void writeToParcel(@NonNull Parcel parcel, int i2) {
            int a2 = SafeParcelWriter.a(parcel);
            SafeParcelWriter.F(parcel, 1, this.s);
            SafeParcelWriter.F(parcel, 2, this.X);
            SafeParcelWriter.g(parcel, 3, this.Y);
            SafeParcelWriter.F(parcel, 4, this.Z);
            SafeParcelWriter.g(parcel, 5, this.X2);
            SafeParcelWriter.Y(parcel, 6, this.Y2, false);
            SafeParcelWriter.F(parcel, 7, Z());
            SafeParcelWriter.Y(parcel, 8, j0(), false);
            SafeParcelWriter.S(parcel, 9, c0(), i2, false);
            SafeParcelWriter.b(parcel, a2);
        }

        protected Field(int i2, boolean z, int i3, boolean z2, @NonNull String str, int i4, @Nullable Class<? extends FastJsonResponse> cls, @Nullable FieldConverter<I, O> fieldConverter) {
            this.s = 1;
            this.X = i2;
            this.Y = z;
            this.Z = i3;
            this.X2 = z2;
            this.Y2 = str;
            this.Z2 = i4;
            this.a3 = cls;
            this.b3 = cls == null ? null : cls.getCanonicalName();
            this.d3 = fieldConverter;
        }
    }

    @ShowFirstParty
    public interface FieldConverter<I, O> {
        int b();

        int c();

        @NonNull
        I k(@NonNull O o);

        @Nullable
        O p(@NonNull I i2);
    }

    @NonNull
    protected static final <O, I> I E(@NonNull Field<I, O> field, @Nullable Object obj) {
        return field.d3 != null ? field.i0(obj) : obj;
    }

    private final <I, O> void H(Field<I, O> field, @Nullable I i2) {
        String str = field.Y2;
        O h0 = field.h0(i2);
        int i3 = field.Z;
        switch (i3) {
            case 0:
                if (h0 != null) {
                    o(field, str, ((Integer) h0).intValue());
                    return;
                } else {
                    K(str);
                    return;
                }
            case 1:
                R(field, str, (BigInteger) h0);
                return;
            case 2:
                if (h0 != null) {
                    p(field, str, ((Long) h0).longValue());
                    return;
                } else {
                    K(str);
                    return;
                }
            case 4:
                if (h0 != null) {
                    Z(field, str, ((Double) h0).doubleValue());
                    return;
                } else {
                    K(str);
                    return;
                }
            case 5:
                N(field, str, (BigDecimal) h0);
                return;
            case 6:
                if (h0 != null) {
                    l(field, str, ((Boolean) h0).booleanValue());
                    return;
                } else {
                    K(str);
                    return;
                }
            case 7:
                t(field, str, (String) h0);
                return;
            case 8:
            case 9:
                if (h0 != null) {
                    m(field, str, (byte[]) h0);
                    return;
                } else {
                    K(str);
                    return;
                }
            default:
                StringBuilder sb = new StringBuilder(44);
                sb.append("Unsupported type for conversion: ");
                sb.append(i3);
                throw new IllegalStateException(sb.toString());
        }
    }

    private static final void I(StringBuilder sb, Field field, Object obj) {
        String fastJsonResponse;
        int i2 = field.X;
        if (i2 == 11) {
            Class<? extends FastJsonResponse> cls = field.a3;
            Preconditions.r(cls);
            fastJsonResponse = ((FastJsonResponse) cls.cast(obj)).toString();
        } else if (i2 == 7) {
            fastJsonResponse = "\"";
            sb.append(fastJsonResponse);
            sb.append(JsonUtils.b((String) obj));
        } else {
            sb.append(obj);
            return;
        }
        sb.append(fastJsonResponse);
    }

    private static final <O> void K(String str) {
        if (Log.isLoggable("FastJsonResponse", 6)) {
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 58);
            sb.append("Output field (");
            sb.append(str);
            sb.append(") has a null value, but expected a primitive");
            Log.e("FastJsonResponse", sb.toString());
        }
    }

    public final <O> void B(@NonNull Field<String, O> field, @Nullable String str) {
        if (field.d3 != null) {
            H(field, str);
        } else {
            t(field, field.Y2, str);
        }
    }

    public final <O> void C(@NonNull Field<Map<String, String>, O> field, @Nullable Map<String, String> map) {
        if (field.d3 != null) {
            H(field, map);
        } else {
            v(field, field.Y2, map);
        }
    }

    public final <O> void D(@NonNull Field<ArrayList<String>, O> field, @Nullable ArrayList<String> arrayList) {
        if (field.d3 != null) {
            H(field, arrayList);
        } else {
            z(field, field.Y2, arrayList);
        }
    }

    public final <O> void M(@NonNull Field<BigDecimal, O> field, @Nullable BigDecimal bigDecimal) {
        if (field.d3 != null) {
            H(field, bigDecimal);
        } else {
            N(field, field.Y2, bigDecimal);
        }
    }

    /* access modifiers changed from: protected */
    public void N(@NonNull Field<?, ?> field, @NonNull String str, @Nullable BigDecimal bigDecimal) {
        throw new UnsupportedOperationException("BigDecimal not supported");
    }

    public final <O> void O(@NonNull Field<ArrayList<BigDecimal>, O> field, @Nullable ArrayList<BigDecimal> arrayList) {
        if (field.d3 != null) {
            H(field, arrayList);
        } else {
            P(field, field.Y2, arrayList);
        }
    }

    /* access modifiers changed from: protected */
    public void P(@NonNull Field<?, ?> field, @NonNull String str, @Nullable ArrayList<BigDecimal> arrayList) {
        throw new UnsupportedOperationException("BigDecimal list not supported");
    }

    public final <O> void Q(@NonNull Field<BigInteger, O> field, @Nullable BigInteger bigInteger) {
        if (field.d3 != null) {
            H(field, bigInteger);
        } else {
            R(field, field.Y2, bigInteger);
        }
    }

    /* access modifiers changed from: protected */
    public void R(@NonNull Field<?, ?> field, @NonNull String str, @Nullable BigInteger bigInteger) {
        throw new UnsupportedOperationException("BigInteger not supported");
    }

    public final <O> void S(@NonNull Field<ArrayList<BigInteger>, O> field, @Nullable ArrayList<BigInteger> arrayList) {
        if (field.d3 != null) {
            H(field, arrayList);
        } else {
            T(field, field.Y2, arrayList);
        }
    }

    /* access modifiers changed from: protected */
    public void T(@NonNull Field<?, ?> field, @NonNull String str, @Nullable ArrayList<BigInteger> arrayList) {
        throw new UnsupportedOperationException("BigInteger list not supported");
    }

    public final <O> void U(@NonNull Field<Boolean, O> field, boolean z) {
        if (field.d3 != null) {
            H(field, Boolean.valueOf(z));
        } else {
            l(field, field.Y2, z);
        }
    }

    public final <O> void V(@NonNull Field<ArrayList<Boolean>, O> field, @Nullable ArrayList<Boolean> arrayList) {
        if (field.d3 != null) {
            H(field, arrayList);
        } else {
            W(field, field.Y2, arrayList);
        }
    }

    /* access modifiers changed from: protected */
    public void W(@NonNull Field<?, ?> field, @NonNull String str, @Nullable ArrayList<Boolean> arrayList) {
        throw new UnsupportedOperationException("Boolean list not supported");
    }

    public final <O> void X(@NonNull Field<byte[], O> field, @Nullable byte[] bArr) {
        if (field.d3 != null) {
            H(field, bArr);
        } else {
            m(field, field.Y2, bArr);
        }
    }

    public final <O> void Y(@NonNull Field<Double, O> field, double d2) {
        if (field.d3 != null) {
            H(field, Double.valueOf(d2));
        } else {
            Z(field, field.Y2, d2);
        }
    }

    /* access modifiers changed from: protected */
    public void Z(@NonNull Field<?, ?> field, @NonNull String str, double d2) {
        throw new UnsupportedOperationException("Double not supported");
    }

    @KeepForSdk
    public <T extends FastJsonResponse> void a(@NonNull Field field, @NonNull String str, @Nullable ArrayList<T> arrayList) {
        throw new UnsupportedOperationException("Concrete type array not supported");
    }

    public final <O> void a0(@NonNull Field<ArrayList<Double>, O> field, @Nullable ArrayList<Double> arrayList) {
        if (field.d3 != null) {
            H(field, arrayList);
        } else {
            b0(field, field.Y2, arrayList);
        }
    }

    @KeepForSdk
    public <T extends FastJsonResponse> void b(@NonNull Field field, @NonNull String str, @NonNull T t) {
        throw new UnsupportedOperationException("Concrete type not supported");
    }

    /* access modifiers changed from: protected */
    public void b0(@NonNull Field<?, ?> field, @NonNull String str, @Nullable ArrayList<Double> arrayList) {
        throw new UnsupportedOperationException("Double list not supported");
    }

    @NonNull
    @KeepForSdk
    public abstract Map<String, Field<?, ?>> c();

    public final <O> void c0(@NonNull Field<Float, O> field, float f2) {
        if (field.d3 != null) {
            H(field, Float.valueOf(f2));
        } else {
            d0(field, field.Y2, f2);
        }
    }

    /* access modifiers changed from: protected */
    @KeepForSdk
    @Nullable
    public Object d(@NonNull Field field) {
        String str = field.Y2;
        if (field.a3 == null) {
            return g(str);
        }
        Preconditions.z(g(str) == null, "Concrete field shouldn't be value object: %s", field.Y2);
        try {
            char upperCase = Character.toUpperCase(str.charAt(0));
            String substring = str.substring(1);
            StringBuilder sb = new StringBuilder(String.valueOf(substring).length() + 4);
            sb.append("get");
            sb.append(upperCase);
            sb.append(substring);
            return getClass().getMethod(sb.toString(), (Class[]) null).invoke(this, (Object[]) null);
        } catch (Exception e2) {
            throw new RuntimeException(e2);
        }
    }

    /* access modifiers changed from: protected */
    public void d0(@NonNull Field<?, ?> field, @NonNull String str, float f2) {
        throw new UnsupportedOperationException("Float not supported");
    }

    public final <O> void e0(@NonNull Field<ArrayList<Float>, O> field, @Nullable ArrayList<Float> arrayList) {
        if (field.d3 != null) {
            H(field, arrayList);
        } else {
            f0(field, field.Y2, arrayList);
        }
    }

    /* access modifiers changed from: protected */
    public void f0(@NonNull Field<?, ?> field, @NonNull String str, @Nullable ArrayList<Float> arrayList) {
        throw new UnsupportedOperationException("Float list not supported");
    }

    /* access modifiers changed from: protected */
    @KeepForSdk
    @Nullable
    public abstract Object g(@NonNull String str);

    public final <O> void g0(@NonNull Field<Integer, O> field, int i2) {
        if (field.d3 != null) {
            H(field, Integer.valueOf(i2));
        } else {
            o(field, field.Y2, i2);
        }
    }

    public final <O> void h0(@NonNull Field<ArrayList<Integer>, O> field, @Nullable ArrayList<Integer> arrayList) {
        if (field.d3 != null) {
            H(field, arrayList);
        } else {
            i0(field, field.Y2, arrayList);
        }
    }

    /* access modifiers changed from: protected */
    public void i0(@NonNull Field<?, ?> field, @NonNull String str, @Nullable ArrayList<Integer> arrayList) {
        throw new UnsupportedOperationException("Integer list not supported");
    }

    /* access modifiers changed from: protected */
    @KeepForSdk
    public boolean j(@NonNull Field field) {
        if (field.Z != 11) {
            return k(field.Y2);
        }
        if (field.X2) {
            throw new UnsupportedOperationException("Concrete type arrays not supported");
        }
        throw new UnsupportedOperationException("Concrete types not supported");
    }

    public final <O> void j0(@NonNull Field<Long, O> field, long j2) {
        if (field.d3 != null) {
            H(field, Long.valueOf(j2));
        } else {
            p(field, field.Y2, j2);
        }
    }

    /* access modifiers changed from: protected */
    @KeepForSdk
    public abstract boolean k(@NonNull String str);

    public final <O> void k0(@NonNull Field<ArrayList<Long>, O> field, @Nullable ArrayList<Long> arrayList) {
        if (field.d3 != null) {
            H(field, arrayList);
        } else {
            l0(field, field.Y2, arrayList);
        }
    }

    /* access modifiers changed from: protected */
    @KeepForSdk
    public void l(@NonNull Field<?, ?> field, @NonNull String str, boolean z) {
        throw new UnsupportedOperationException("Boolean not supported");
    }

    /* access modifiers changed from: protected */
    public void l0(@NonNull Field<?, ?> field, @NonNull String str, @Nullable ArrayList<Long> arrayList) {
        throw new UnsupportedOperationException("Long list not supported");
    }

    /* access modifiers changed from: protected */
    @KeepForSdk
    public void m(@NonNull Field<?, ?> field, @NonNull String str, @Nullable byte[] bArr) {
        throw new UnsupportedOperationException("byte[] not supported");
    }

    /* access modifiers changed from: protected */
    @KeepForSdk
    public void o(@NonNull Field<?, ?> field, @NonNull String str, int i2) {
        throw new UnsupportedOperationException("Integer not supported");
    }

    /* access modifiers changed from: protected */
    @KeepForSdk
    public void p(@NonNull Field<?, ?> field, @NonNull String str, long j2) {
        throw new UnsupportedOperationException("Long not supported");
    }

    /* access modifiers changed from: protected */
    @KeepForSdk
    public void t(@NonNull Field<?, ?> field, @NonNull String str, @Nullable String str2) {
        throw new UnsupportedOperationException("String not supported");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0097, code lost:
        r1.append(r3);
        r1.append("\"");
     */
    @androidx.annotation.NonNull
    @com.google.android.gms.common.annotation.KeepForSdk
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String toString() {
        /*
            r9 = this;
            java.util.Map r0 = r9.c()
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r2 = 100
            r1.<init>(r2)
            java.util.Set r2 = r0.keySet()
            java.util.Iterator r2 = r2.iterator()
        L_0x0013:
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto L_0x00a9
            java.lang.Object r3 = r2.next()
            java.lang.String r3 = (java.lang.String) r3
            java.lang.Object r4 = r0.get(r3)
            com.google.android.gms.common.server.response.FastJsonResponse$Field r4 = (com.google.android.gms.common.server.response.FastJsonResponse.Field) r4
            boolean r5 = r9.j(r4)
            if (r5 == 0) goto L_0x0013
            java.lang.Object r5 = r9.d(r4)
            java.lang.Object r5 = E(r4, r5)
            int r6 = r1.length()
            java.lang.String r7 = ","
            if (r6 != 0) goto L_0x0041
            java.lang.String r6 = "{"
            r1.append(r6)
            goto L_0x0044
        L_0x0041:
            r1.append(r7)
        L_0x0044:
            java.lang.String r6 = "\""
            r1.append(r6)
            r1.append(r3)
            java.lang.String r3 = "\":"
            r1.append(r3)
            if (r5 != 0) goto L_0x0059
            java.lang.String r3 = "null"
        L_0x0055:
            r1.append(r3)
            goto L_0x0013
        L_0x0059:
            int r3 = r4.Z
            switch(r3) {
                case 8: goto L_0x009f;
                case 9: goto L_0x008e;
                case 10: goto L_0x0088;
                default: goto L_0x005e;
            }
        L_0x005e:
            boolean r3 = r4.Y
            if (r3 == 0) goto L_0x0084
            java.util.ArrayList r5 = (java.util.ArrayList) r5
            java.lang.String r3 = "["
            r1.append(r3)
            int r3 = r5.size()
            r6 = 0
        L_0x006e:
            if (r6 >= r3) goto L_0x0081
            if (r6 <= 0) goto L_0x0075
            r1.append(r7)
        L_0x0075:
            java.lang.Object r8 = r5.get(r6)
            if (r8 == 0) goto L_0x007e
            I(r1, r4, r8)
        L_0x007e:
            int r6 = r6 + 1
            goto L_0x006e
        L_0x0081:
            java.lang.String r3 = "]"
            goto L_0x0055
        L_0x0084:
            I(r1, r4, r5)
            goto L_0x0013
        L_0x0088:
            java.util.HashMap r5 = (java.util.HashMap) r5
            com.google.android.gms.common.util.MapUtils.a(r1, r5)
            goto L_0x0013
        L_0x008e:
            r1.append(r6)
            byte[] r5 = (byte[]) r5
            java.lang.String r3 = com.google.android.gms.common.util.Base64Utils.e(r5)
        L_0x0097:
            r1.append(r3)
            r1.append(r6)
            goto L_0x0013
        L_0x009f:
            r1.append(r6)
            byte[] r5 = (byte[]) r5
            java.lang.String r3 = com.google.android.gms.common.util.Base64Utils.d(r5)
            goto L_0x0097
        L_0x00a9:
            int r0 = r1.length()
            if (r0 <= 0) goto L_0x00b5
            java.lang.String r0 = "}"
        L_0x00b1:
            r1.append(r0)
            goto L_0x00b8
        L_0x00b5:
            java.lang.String r0 = "{}"
            goto L_0x00b1
        L_0x00b8:
            java.lang.String r0 = r1.toString()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.server.response.FastJsonResponse.toString():java.lang.String");
    }

    /* access modifiers changed from: protected */
    @KeepForSdk
    public void v(@NonNull Field<?, ?> field, @NonNull String str, @Nullable Map<String, String> map) {
        throw new UnsupportedOperationException("String map not supported");
    }

    /* access modifiers changed from: protected */
    @KeepForSdk
    public void z(@NonNull Field<?, ?> field, @NonNull String str, @Nullable ArrayList<String> arrayList) {
        throw new UnsupportedOperationException("String list not supported");
    }
}
