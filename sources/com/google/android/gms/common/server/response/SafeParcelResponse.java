package com.google.android.gms.common.server.response;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.server.response.FastJsonResponse;
import com.google.android.gms.common.util.Base64Utils;
import com.google.android.gms.common.util.JsonUtils;
import com.google.android.gms.common.util.MapUtils;
import com.google.android.gms.common.util.VisibleForTesting;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@KeepForSdk
@SafeParcelable.Class(creator = "SafeParcelResponseCreator")
@VisibleForTesting
public class SafeParcelResponse extends FastSafeParcelableJsonResponse {
    @NonNull
    @KeepForSdk
    public static final Parcelable.Creator<SafeParcelResponse> CREATOR = new zaq();
    @SafeParcelable.Field(getter = "getParcel", id = 2)
    private final Parcel X;
    @Nullable
    private final String X2;
    private final int Y;
    private int Y2;
    @SafeParcelable.Field(getter = "getFieldMappingDictionary", id = 3)
    private final zan Z;
    private int Z2;
    @SafeParcelable.VersionField(getter = "getVersionCode", id = 1)
    private final int s;

    @SafeParcelable.Constructor
    SafeParcelResponse(@SafeParcelable.Param(id = 1) int i2, @SafeParcelable.Param(id = 2) Parcel parcel, @SafeParcelable.Param(id = 3) zan zan) {
        this.s = i2;
        this.X = (Parcel) Preconditions.r(parcel);
        this.Y = 2;
        this.Z = zan;
        this.X2 = zan == null ? null : zan.C();
        this.Y2 = 2;
    }

    @NonNull
    @KeepForSdk
    public static <T extends FastJsonResponse & SafeParcelable> SafeParcelResponse n0(@NonNull T t) {
        zan zan = new zan(t.getClass());
        p0(zan, t);
        zan.I();
        zan.N();
        return new SafeParcelResponse((SafeParcelable) t, zan, (String) Preconditions.r(t.getClass().getCanonicalName()));
    }

    private static void p0(zan zan, FastJsonResponse fastJsonResponse) {
        Class<?> cls = fastJsonResponse.getClass();
        if (!zan.P(cls)) {
            Map<String, FastJsonResponse.Field<?, ?>> c2 = fastJsonResponse.c();
            zan.O(cls, c2);
            for (String str : c2.keySet()) {
                FastJsonResponse.Field field = c2.get(str);
                Class<? extends FastJsonResponse> cls2 = field.a3;
                if (cls2 != null) {
                    try {
                        p0(zan, (FastJsonResponse) cls2.newInstance());
                    } catch (InstantiationException e2) {
                        String valueOf = String.valueOf(((Class) Preconditions.r(field.a3)).getCanonicalName());
                        throw new IllegalStateException(valueOf.length() != 0 ? "Could not instantiate an object of type ".concat(valueOf) : new String("Could not instantiate an object of type "), e2);
                    } catch (IllegalAccessException e3) {
                        String valueOf2 = String.valueOf(((Class) Preconditions.r(field.a3)).getCanonicalName());
                        throw new IllegalStateException(valueOf2.length() != 0 ? "Could not access object of type ".concat(valueOf2) : new String("Could not access object of type "), e3);
                    }
                }
            }
        }
    }

    private final void q0(FastJsonResponse.Field<?, ?> field) {
        if (field.Z2 != -1) {
            Parcel parcel = this.X;
            if (parcel != null) {
                int i2 = this.Y2;
                if (i2 == 0) {
                    this.Z2 = SafeParcelWriter.a(parcel);
                    this.Y2 = 1;
                } else if (i2 != 1) {
                    throw new IllegalStateException("Attempted to parse JSON with a SafeParcelResponse object that is already filled with data.");
                }
            } else {
                throw new IllegalStateException("Internal Parcel object is null.");
            }
        } else {
            throw new IllegalStateException("Field does not have a valid safe parcelable field id.");
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:73:0x021a, code lost:
        r11.append(r2);
        r11.append("\"");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:78:0x0247, code lost:
        r11.append(r2);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void r0(java.lang.StringBuilder r11, java.util.Map<java.lang.String, com.google.android.gms.common.server.response.FastJsonResponse.Field<?, ?>> r12, android.os.Parcel r13) {
        /*
            r10 = this;
            android.util.SparseArray r0 = new android.util.SparseArray
            r0.<init>()
            java.util.Set r12 = r12.entrySet()
            java.util.Iterator r12 = r12.iterator()
        L_0x000d:
            boolean r1 = r12.hasNext()
            if (r1 == 0) goto L_0x0027
            java.lang.Object r1 = r12.next()
            java.util.Map$Entry r1 = (java.util.Map.Entry) r1
            java.lang.Object r2 = r1.getValue()
            com.google.android.gms.common.server.response.FastJsonResponse$Field r2 = (com.google.android.gms.common.server.response.FastJsonResponse.Field) r2
            int r2 = r2.Z()
            r0.put(r2, r1)
            goto L_0x000d
        L_0x0027:
            r12 = 123(0x7b, float:1.72E-43)
            r11.append(r12)
            int r12 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.i0(r13)
            r1 = 0
            r2 = 0
        L_0x0032:
            int r3 = r13.dataPosition()
            if (r3 >= r12) goto L_0x0275
            int r3 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.X(r13)
            int r4 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.O(r3)
            java.lang.Object r4 = r0.get(r4)
            java.util.Map$Entry r4 = (java.util.Map.Entry) r4
            if (r4 == 0) goto L_0x0032
            java.lang.String r5 = ","
            if (r2 == 0) goto L_0x004f
            r11.append(r5)
        L_0x004f:
            java.lang.Object r2 = r4.getKey()
            java.lang.String r2 = (java.lang.String) r2
            java.lang.Object r4 = r4.getValue()
            com.google.android.gms.common.server.response.FastJsonResponse$Field r4 = (com.google.android.gms.common.server.response.FastJsonResponse.Field) r4
            java.lang.String r6 = "\""
            r11.append(r6)
            r11.append(r2)
            java.lang.String r2 = "\":"
            r11.append(r2)
            boolean r2 = r4.p0()
            r7 = 1
            if (r2 == 0) goto L_0x012f
            int r2 = r4.Z
            switch(r2) {
                case 0: goto L_0x0122;
                case 1: goto L_0x0119;
                case 2: goto L_0x010c;
                case 3: goto L_0x00ff;
                case 4: goto L_0x00f2;
                case 5: goto L_0x00e9;
                case 6: goto L_0x00dc;
                case 7: goto L_0x00d3;
                case 8: goto L_0x00ca;
                case 9: goto L_0x00ca;
                case 10: goto L_0x0095;
                case 11: goto L_0x008d;
                default: goto L_0x0074;
            }
        L_0x0074:
            java.lang.IllegalArgumentException r11 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r12 = new java.lang.StringBuilder
            r13 = 36
            r12.<init>(r13)
            java.lang.String r13 = "Unknown field out type = "
            r12.append(r13)
            r12.append(r2)
            java.lang.String r12 = r12.toString()
            r11.<init>(r12)
            throw r11
        L_0x008d:
            java.lang.IllegalArgumentException r11 = new java.lang.IllegalArgumentException
            java.lang.String r12 = "Method does not accept concrete type."
            r11.<init>(r12)
            throw r11
        L_0x0095:
            android.os.Bundle r2 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.g(r13, r3)
            java.util.HashMap r3 = new java.util.HashMap
            r3.<init>()
            java.util.Set r5 = r2.keySet()
            java.util.Iterator r5 = r5.iterator()
        L_0x00a6:
            boolean r6 = r5.hasNext()
            if (r6 == 0) goto L_0x00c0
            java.lang.Object r6 = r5.next()
            java.lang.String r6 = (java.lang.String) r6
            java.lang.String r8 = r2.getString(r6)
            java.lang.Object r8 = com.google.android.gms.common.internal.Preconditions.r(r8)
            java.lang.String r8 = (java.lang.String) r8
            r3.put(r6, r8)
            goto L_0x00a6
        L_0x00c0:
            java.lang.Object r2 = com.google.android.gms.common.server.response.FastJsonResponse.E(r4, r3)
        L_0x00c4:
            t0(r11, r4, r2)
        L_0x00c7:
            r2 = 1
            goto L_0x0032
        L_0x00ca:
            byte[] r2 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.h(r13, r3)
            java.lang.Object r2 = com.google.android.gms.common.server.response.FastJsonResponse.E(r4, r2)
            goto L_0x00c4
        L_0x00d3:
            java.lang.String r2 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.G(r13, r3)
            java.lang.Object r2 = com.google.android.gms.common.server.response.FastJsonResponse.E(r4, r2)
            goto L_0x00c4
        L_0x00dc:
            boolean r2 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.P(r13, r3)
            java.lang.Boolean r2 = java.lang.Boolean.valueOf(r2)
            java.lang.Object r2 = com.google.android.gms.common.server.response.FastJsonResponse.E(r4, r2)
            goto L_0x00c4
        L_0x00e9:
            java.math.BigDecimal r2 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.a(r13, r3)
            java.lang.Object r2 = com.google.android.gms.common.server.response.FastJsonResponse.E(r4, r2)
            goto L_0x00c4
        L_0x00f2:
            double r2 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.T(r13, r3)
            java.lang.Double r2 = java.lang.Double.valueOf(r2)
            java.lang.Object r2 = com.google.android.gms.common.server.response.FastJsonResponse.E(r4, r2)
            goto L_0x00c4
        L_0x00ff:
            float r2 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.V(r13, r3)
            java.lang.Float r2 = java.lang.Float.valueOf(r2)
            java.lang.Object r2 = com.google.android.gms.common.server.response.FastJsonResponse.E(r4, r2)
            goto L_0x00c4
        L_0x010c:
            long r2 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.c0(r13, r3)
            java.lang.Long r2 = java.lang.Long.valueOf(r2)
            java.lang.Object r2 = com.google.android.gms.common.server.response.FastJsonResponse.E(r4, r2)
            goto L_0x00c4
        L_0x0119:
            java.math.BigInteger r2 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.c(r13, r3)
            java.lang.Object r2 = com.google.android.gms.common.server.response.FastJsonResponse.E(r4, r2)
            goto L_0x00c4
        L_0x0122:
            int r2 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.Z(r13, r3)
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            java.lang.Object r2 = com.google.android.gms.common.server.response.FastJsonResponse.E(r4, r2)
            goto L_0x00c4
        L_0x012f:
            boolean r2 = r4.X2
            if (r2 == 0) goto L_0x01b1
            java.lang.String r2 = "["
            r11.append(r2)
            int r2 = r4.Z
            switch(r2) {
                case 0: goto L_0x01a3;
                case 1: goto L_0x019b;
                case 2: goto L_0x0193;
                case 3: goto L_0x018b;
                case 4: goto L_0x0183;
                case 5: goto L_0x017b;
                case 6: goto L_0x0173;
                case 7: goto L_0x016b;
                case 8: goto L_0x0163;
                case 9: goto L_0x0163;
                case 10: goto L_0x0163;
                case 11: goto L_0x0145;
                default: goto L_0x013d;
            }
        L_0x013d:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r12 = "Unknown field type out."
            r11.<init>(r12)
            throw r11
        L_0x0145:
            android.os.Parcel[] r2 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.z(r13, r3)
            int r3 = r2.length
            r6 = 0
        L_0x014b:
            if (r6 >= r3) goto L_0x01aa
            if (r6 <= 0) goto L_0x0152
            r11.append(r5)
        L_0x0152:
            r8 = r2[r6]
            r8.setDataPosition(r1)
            java.util.Map r8 = r4.k0()
            r9 = r2[r6]
            r10.r0(r11, r8, r9)
            int r6 = r6 + 1
            goto L_0x014b
        L_0x0163:
            java.lang.UnsupportedOperationException r11 = new java.lang.UnsupportedOperationException
            java.lang.String r12 = "List of type BASE64, BASE64_URL_SAFE, or STRING_MAP is not supported"
            r11.<init>(r12)
            throw r11
        L_0x016b:
            java.lang.String[] r2 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.H(r13, r3)
            com.google.android.gms.common.util.ArrayUtils.p(r11, r2)
            goto L_0x01aa
        L_0x0173:
            boolean[] r2 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.e(r13, r3)
            com.google.android.gms.common.util.ArrayUtils.o(r11, r2)
            goto L_0x01aa
        L_0x017b:
            java.math.BigDecimal[] r2 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.b(r13, r3)
            com.google.android.gms.common.util.ArrayUtils.n(r11, r2)
            goto L_0x01aa
        L_0x0183:
            double[] r2 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.l(r13, r3)
            com.google.android.gms.common.util.ArrayUtils.j(r11, r2)
            goto L_0x01aa
        L_0x018b:
            float[] r2 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.o(r13, r3)
            com.google.android.gms.common.util.ArrayUtils.k(r11, r2)
            goto L_0x01aa
        L_0x0193:
            long[] r2 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.w(r13, r3)
            com.google.android.gms.common.util.ArrayUtils.m(r11, r2)
            goto L_0x01aa
        L_0x019b:
            java.math.BigInteger[] r2 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.d(r13, r3)
            com.google.android.gms.common.util.ArrayUtils.n(r11, r2)
            goto L_0x01aa
        L_0x01a3:
            int[] r2 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.u(r13, r3)
            com.google.android.gms.common.util.ArrayUtils.l(r11, r2)
        L_0x01aa:
            java.lang.String r2 = "]"
        L_0x01ac:
            r11.append(r2)
            goto L_0x00c7
        L_0x01b1:
            int r2 = r4.Z
            switch(r2) {
                case 0: goto L_0x026c;
                case 1: goto L_0x0267;
                case 2: goto L_0x025e;
                case 3: goto L_0x0255;
                case 4: goto L_0x024c;
                case 5: goto L_0x0243;
                case 6: goto L_0x023a;
                case 7: goto L_0x022e;
                case 8: goto L_0x0222;
                case 9: goto L_0x020f;
                case 10: goto L_0x01ce;
                case 11: goto L_0x01be;
                default: goto L_0x01b6;
            }
        L_0x01b6:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r12 = "Unknown field type out"
            r11.<init>(r12)
            throw r11
        L_0x01be:
            android.os.Parcel r2 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.y(r13, r3)
            r2.setDataPosition(r1)
            java.util.Map r3 = r4.k0()
            r10.r0(r11, r3, r2)
            goto L_0x00c7
        L_0x01ce:
            android.os.Bundle r2 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.g(r13, r3)
            java.util.Set r3 = r2.keySet()
            java.lang.String r4 = "{"
            r11.append(r4)
            java.util.Iterator r3 = r3.iterator()
            r4 = 1
        L_0x01e0:
            boolean r8 = r3.hasNext()
            if (r8 == 0) goto L_0x020c
            java.lang.Object r8 = r3.next()
            java.lang.String r8 = (java.lang.String) r8
            if (r4 != 0) goto L_0x01f1
            r11.append(r5)
        L_0x01f1:
            r11.append(r6)
            r11.append(r8)
            java.lang.String r4 = "\":\""
            r11.append(r4)
            java.lang.String r4 = r2.getString(r8)
            java.lang.String r4 = com.google.android.gms.common.util.JsonUtils.b(r4)
            r11.append(r4)
            r11.append(r6)
            r4 = 0
            goto L_0x01e0
        L_0x020c:
            java.lang.String r2 = "}"
            goto L_0x01ac
        L_0x020f:
            byte[] r2 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.h(r13, r3)
            r11.append(r6)
            java.lang.String r2 = com.google.android.gms.common.util.Base64Utils.e(r2)
        L_0x021a:
            r11.append(r2)
            r11.append(r6)
            goto L_0x00c7
        L_0x0222:
            byte[] r2 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.h(r13, r3)
            r11.append(r6)
            java.lang.String r2 = com.google.android.gms.common.util.Base64Utils.d(r2)
            goto L_0x021a
        L_0x022e:
            java.lang.String r2 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.G(r13, r3)
            r11.append(r6)
            java.lang.String r2 = com.google.android.gms.common.util.JsonUtils.b(r2)
            goto L_0x021a
        L_0x023a:
            boolean r2 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.P(r13, r3)
            r11.append(r2)
            goto L_0x00c7
        L_0x0243:
            java.math.BigDecimal r2 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.a(r13, r3)
        L_0x0247:
            r11.append(r2)
            goto L_0x00c7
        L_0x024c:
            double r2 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.T(r13, r3)
            r11.append(r2)
            goto L_0x00c7
        L_0x0255:
            float r2 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.V(r13, r3)
            r11.append(r2)
            goto L_0x00c7
        L_0x025e:
            long r2 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.c0(r13, r3)
            r11.append(r2)
            goto L_0x00c7
        L_0x0267:
            java.math.BigInteger r2 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.c(r13, r3)
            goto L_0x0247
        L_0x026c:
            int r2 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.Z(r13, r3)
            r11.append(r2)
            goto L_0x00c7
        L_0x0275:
            int r0 = r13.dataPosition()
            if (r0 != r12) goto L_0x0281
            r12 = 125(0x7d, float:1.75E-43)
            r11.append(r12)
            return
        L_0x0281:
            com.google.android.gms.common.internal.safeparcel.SafeParcelReader$ParseException r11 = new com.google.android.gms.common.internal.safeparcel.SafeParcelReader$ParseException
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r1 = 37
            r0.<init>(r1)
            java.lang.String r1 = "Overread allowed size end="
            r0.append(r1)
            r0.append(r12)
            java.lang.String r12 = r0.toString()
            r11.<init>(r12, r13)
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.server.response.SafeParcelResponse.r0(java.lang.StringBuilder, java.util.Map, android.os.Parcel):void");
    }

    private static final void s0(StringBuilder sb, int i2, @Nullable Object obj) {
        switch (i2) {
            case 0:
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
                sb.append(obj);
                return;
            case 7:
                sb.append("\"");
                sb.append(JsonUtils.b(Preconditions.r(obj).toString()));
                sb.append("\"");
                return;
            case 8:
                sb.append("\"");
                sb.append(Base64Utils.d((byte[]) obj));
                sb.append("\"");
                return;
            case 9:
                sb.append("\"");
                sb.append(Base64Utils.e((byte[]) obj));
                sb.append("\"");
                return;
            case 10:
                MapUtils.a(sb, (HashMap) Preconditions.r(obj));
                return;
            case 11:
                throw new IllegalArgumentException("Method does not accept concrete type.");
            default:
                StringBuilder sb2 = new StringBuilder(26);
                sb2.append("Unknown type = ");
                sb2.append(i2);
                throw new IllegalArgumentException(sb2.toString());
        }
    }

    private static final void t0(StringBuilder sb, FastJsonResponse.Field<?, ?> field, Object obj) {
        if (field.Y) {
            ArrayList arrayList = (ArrayList) obj;
            sb.append("[");
            int size = arrayList.size();
            for (int i2 = 0; i2 < size; i2++) {
                if (i2 != 0) {
                    sb.append(",");
                }
                s0(sb, field.X, arrayList.get(i2));
            }
            sb.append("]");
            return;
        }
        s0(sb, field.X, obj);
    }

    /* access modifiers changed from: protected */
    public final void N(@NonNull FastJsonResponse.Field<?, ?> field, @NonNull String str, @Nullable BigDecimal bigDecimal) {
        q0(field);
        SafeParcelWriter.c(this.X, field.Z(), bigDecimal, true);
    }

    /* access modifiers changed from: protected */
    public final void P(@NonNull FastJsonResponse.Field<?, ?> field, @NonNull String str, @Nullable ArrayList<BigDecimal> arrayList) {
        q0(field);
        int size = ((ArrayList) Preconditions.r(arrayList)).size();
        BigDecimal[] bigDecimalArr = new BigDecimal[size];
        for (int i2 = 0; i2 < size; i2++) {
            bigDecimalArr[i2] = arrayList.get(i2);
        }
        SafeParcelWriter.d(this.X, field.Z(), bigDecimalArr, true);
    }

    /* access modifiers changed from: protected */
    public final void R(@NonNull FastJsonResponse.Field<?, ?> field, @NonNull String str, @Nullable BigInteger bigInteger) {
        q0(field);
        SafeParcelWriter.e(this.X, field.Z(), bigInteger, true);
    }

    /* access modifiers changed from: protected */
    public final void T(@NonNull FastJsonResponse.Field<?, ?> field, @NonNull String str, @Nullable ArrayList<BigInteger> arrayList) {
        q0(field);
        int size = ((ArrayList) Preconditions.r(arrayList)).size();
        BigInteger[] bigIntegerArr = new BigInteger[size];
        for (int i2 = 0; i2 < size; i2++) {
            bigIntegerArr[i2] = arrayList.get(i2);
        }
        SafeParcelWriter.f(this.X, field.Z(), bigIntegerArr, true);
    }

    /* access modifiers changed from: protected */
    public final void W(@NonNull FastJsonResponse.Field<?, ?> field, @NonNull String str, @Nullable ArrayList<Boolean> arrayList) {
        q0(field);
        int size = ((ArrayList) Preconditions.r(arrayList)).size();
        boolean[] zArr = new boolean[size];
        for (int i2 = 0; i2 < size; i2++) {
            zArr[i2] = arrayList.get(i2).booleanValue();
        }
        SafeParcelWriter.h(this.X, field.Z(), zArr, true);
    }

    /* access modifiers changed from: protected */
    public final void Z(@NonNull FastJsonResponse.Field<?, ?> field, @NonNull String str, double d2) {
        q0(field);
        SafeParcelWriter.r(this.X, field.Z(), d2);
    }

    public final <T extends FastJsonResponse> void a(@NonNull FastJsonResponse.Field field, @NonNull String str, @Nullable ArrayList<T> arrayList) {
        q0(field);
        ArrayList arrayList2 = new ArrayList();
        ((ArrayList) Preconditions.r(arrayList)).size();
        int size = arrayList.size();
        for (int i2 = 0; i2 < size; i2++) {
            arrayList2.add(((SafeParcelResponse) ((FastJsonResponse) arrayList.get(i2))).o0());
        }
        SafeParcelWriter.Q(this.X, field.Z(), arrayList2, true);
    }

    public final <T extends FastJsonResponse> void b(@NonNull FastJsonResponse.Field field, @NonNull String str, @NonNull T t) {
        q0(field);
        SafeParcelWriter.O(this.X, field.Z(), ((SafeParcelResponse) t).o0(), true);
    }

    /* access modifiers changed from: protected */
    public final void b0(@NonNull FastJsonResponse.Field<?, ?> field, @NonNull String str, @Nullable ArrayList<Double> arrayList) {
        q0(field);
        int size = ((ArrayList) Preconditions.r(arrayList)).size();
        double[] dArr = new double[size];
        for (int i2 = 0; i2 < size; i2++) {
            dArr[i2] = arrayList.get(i2).doubleValue();
        }
        SafeParcelWriter.s(this.X, field.Z(), dArr, true);
    }

    @Nullable
    public final Map<String, FastJsonResponse.Field<?, ?>> c() {
        zan zan = this.Z;
        if (zan == null) {
            return null;
        }
        return zan.H((String) Preconditions.r(this.X2));
    }

    /* access modifiers changed from: protected */
    public final void d0(@NonNull FastJsonResponse.Field<?, ?> field, @NonNull String str, float f2) {
        q0(field);
        SafeParcelWriter.w(this.X, field.Z(), f2);
    }

    /* access modifiers changed from: protected */
    public final void f0(@NonNull FastJsonResponse.Field<?, ?> field, @NonNull String str, @Nullable ArrayList<Float> arrayList) {
        q0(field);
        int size = ((ArrayList) Preconditions.r(arrayList)).size();
        float[] fArr = new float[size];
        for (int i2 = 0; i2 < size; i2++) {
            fArr[i2] = arrayList.get(i2).floatValue();
        }
        SafeParcelWriter.x(this.X, field.Z(), fArr, true);
    }

    @NonNull
    public final Object g(@NonNull String str) {
        throw new UnsupportedOperationException("Converting to JSON does not require this method.");
    }

    /* access modifiers changed from: protected */
    public final void i0(@NonNull FastJsonResponse.Field<?, ?> field, @NonNull String str, @Nullable ArrayList<Integer> arrayList) {
        q0(field);
        int size = ((ArrayList) Preconditions.r(arrayList)).size();
        int[] iArr = new int[size];
        for (int i2 = 0; i2 < size; i2++) {
            iArr[i2] = arrayList.get(i2).intValue();
        }
        SafeParcelWriter.G(this.X, field.Z(), iArr, true);
    }

    public final boolean k(@NonNull String str) {
        throw new UnsupportedOperationException("Converting to JSON does not require this method.");
    }

    /* access modifiers changed from: protected */
    public final void l(@NonNull FastJsonResponse.Field<?, ?> field, @NonNull String str, boolean z) {
        q0(field);
        SafeParcelWriter.g(this.X, field.Z(), z);
    }

    /* access modifiers changed from: protected */
    public final void l0(@NonNull FastJsonResponse.Field<?, ?> field, @NonNull String str, @Nullable ArrayList<Long> arrayList) {
        q0(field);
        int size = ((ArrayList) Preconditions.r(arrayList)).size();
        long[] jArr = new long[size];
        for (int i2 = 0; i2 < size; i2++) {
            jArr[i2] = arrayList.get(i2).longValue();
        }
        SafeParcelWriter.L(this.X, field.Z(), jArr, true);
    }

    /* access modifiers changed from: protected */
    public final void m(@NonNull FastJsonResponse.Field<?, ?> field, @NonNull String str, @Nullable byte[] bArr) {
        q0(field);
        SafeParcelWriter.m(this.X, field.Z(), bArr, true);
    }

    /* access modifiers changed from: protected */
    public final void o(@NonNull FastJsonResponse.Field<?, ?> field, @NonNull String str, int i2) {
        q0(field);
        SafeParcelWriter.F(this.X, field.Z(), i2);
    }

    @NonNull
    public final Parcel o0() {
        int i2 = this.Y2;
        if (i2 != 0) {
            if (i2 == 1) {
                SafeParcelWriter.b(this.X, this.Z2);
            }
            return this.X;
        }
        int a2 = SafeParcelWriter.a(this.X);
        this.Z2 = a2;
        SafeParcelWriter.b(this.X, a2);
        this.Y2 = 2;
        return this.X;
    }

    /* access modifiers changed from: protected */
    public final void p(@NonNull FastJsonResponse.Field<?, ?> field, @NonNull String str, long j2) {
        q0(field);
        SafeParcelWriter.K(this.X, field.Z(), j2);
    }

    /* access modifiers changed from: protected */
    public final void t(@NonNull FastJsonResponse.Field<?, ?> field, @NonNull String str, @Nullable String str2) {
        q0(field);
        SafeParcelWriter.Y(this.X, field.Z(), str2, true);
    }

    @NonNull
    public final String toString() {
        Preconditions.s(this.Z, "Cannot convert to JSON on client side.");
        Parcel o0 = o0();
        o0.setDataPosition(0);
        StringBuilder sb = new StringBuilder(100);
        r0(sb, (Map) Preconditions.r(this.Z.H((String) Preconditions.r(this.X2))), o0);
        return sb.toString();
    }

    /* access modifiers changed from: protected */
    public final void v(@NonNull FastJsonResponse.Field<?, ?> field, @NonNull String str, @Nullable Map<String, String> map) {
        q0(field);
        Bundle bundle = new Bundle();
        for (String str2 : ((Map) Preconditions.r(map)).keySet()) {
            bundle.putString(str2, map.get(str2));
        }
        SafeParcelWriter.k(this.X, field.Z(), bundle, true);
    }

    public final void writeToParcel(@NonNull Parcel parcel, int i2) {
        int a2 = SafeParcelWriter.a(parcel);
        SafeParcelWriter.F(parcel, 1, this.s);
        SafeParcelWriter.O(parcel, 2, o0(), false);
        SafeParcelWriter.S(parcel, 3, this.Y != 0 ? this.Z : null, i2, false);
        SafeParcelWriter.b(parcel, a2);
    }

    /* access modifiers changed from: protected */
    public final void z(@NonNull FastJsonResponse.Field<?, ?> field, @NonNull String str, @Nullable ArrayList<String> arrayList) {
        q0(field);
        int size = ((ArrayList) Preconditions.r(arrayList)).size();
        String[] strArr = new String[size];
        for (int i2 = 0; i2 < size; i2++) {
            strArr[i2] = arrayList.get(i2);
        }
        SafeParcelWriter.Z(this.X, field.Z(), strArr, true);
    }

    private SafeParcelResponse(SafeParcelable safeParcelable, zan zan, String str) {
        this.s = 1;
        Parcel obtain = Parcel.obtain();
        this.X = obtain;
        safeParcelable.writeToParcel(obtain, 0);
        this.Y = 1;
        this.Z = (zan) Preconditions.r(zan);
        this.X2 = (String) Preconditions.r(str);
        this.Y2 = 2;
    }

    public SafeParcelResponse(zan zan, String str) {
        this.s = 1;
        this.X = Parcel.obtain();
        this.Y = 0;
        this.Z = (zan) Preconditions.r(zan);
        this.X2 = (String) Preconditions.r(str);
        this.Y2 = 0;
    }
}
