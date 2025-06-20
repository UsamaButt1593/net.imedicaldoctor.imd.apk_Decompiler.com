package com.google.android.gms.common.data;

import android.content.ContentValues;
import android.database.CharArrayBuffer;
import android.database.CursorIndexOutOfBoundsException;
import android.database.CursorWindow;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.annotation.KeepName;
import com.google.android.gms.common.internal.Asserts;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.io.Closeable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@KeepName
@KeepForSdk
@SafeParcelable.Class(creator = "DataHolderCreator", validate = true)
public final class DataHolder extends AbstractSafeParcelable implements Closeable {
    @NonNull
    @KeepForSdk
    public static final Parcelable.Creator<DataHolder> CREATOR = new zaf();
    private static final Builder d3 = new zab(new String[0], (String) null);
    @SafeParcelable.Field(getter = "getColumns", id = 1)
    private final String[] X;
    @SafeParcelable.Field(getter = "getStatusCode", id = 3)
    private final int X2;
    Bundle Y;
    @SafeParcelable.Field(getter = "getMetadata", id = 4)
    @Nullable
    private final Bundle Y2;
    @SafeParcelable.Field(getter = "getWindows", id = 2)
    private final CursorWindow[] Z;
    int[] Z2;
    int a3;
    boolean b3;
    private boolean c3;
    @SafeParcelable.VersionField(id = 1000)
    final int s;

    @KeepForSdk
    public static class Builder {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public final String[] f20195a;
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public final ArrayList<HashMap<String, Object>> f20196b = new ArrayList<>();

        /* renamed from: c  reason: collision with root package name */
        private final HashMap<Object, Integer> f20197c = new HashMap<>();

        /* synthetic */ Builder(String[] strArr, String str, zac zac) {
            this.f20195a = (String[]) Preconditions.r(strArr);
        }

        @NonNull
        @KeepForSdk
        public DataHolder a(int i2) {
            return new DataHolder(this, i2);
        }

        @NonNull
        @KeepForSdk
        public DataHolder b(int i2, @NonNull Bundle bundle) {
            return new DataHolder(this, i2, bundle);
        }

        @NonNull
        @KeepForSdk
        public Builder c(@NonNull ContentValues contentValues) {
            Asserts.c(contentValues);
            HashMap hashMap = new HashMap(contentValues.size());
            for (Map.Entry next : contentValues.valueSet()) {
                hashMap.put((String) next.getKey(), next.getValue());
            }
            return d(hashMap);
        }

        @NonNull
        public Builder d(@NonNull HashMap<String, Object> hashMap) {
            Asserts.c(hashMap);
            this.f20196b.add(hashMap);
            return this;
        }
    }

    @SafeParcelable.Constructor
    DataHolder(@SafeParcelable.Param(id = 1000) int i2, @SafeParcelable.Param(id = 1) String[] strArr, @SafeParcelable.Param(id = 2) CursorWindow[] cursorWindowArr, @SafeParcelable.Param(id = 3) int i3, @SafeParcelable.Param(id = 4) @Nullable Bundle bundle) {
        this.b3 = false;
        this.c3 = true;
        this.s = i2;
        this.X = strArr;
        this.Z = cursorWindowArr;
        this.X2 = i3;
        this.Y2 = bundle;
    }

    @NonNull
    @KeepForSdk
    public static Builder C(@NonNull String[] strArr) {
        return new Builder(strArr, (String) null, (zac) null);
    }

    @NonNull
    @KeepForSdk
    public static DataHolder H(int i2) {
        return new DataHolder(d3, i2, (Bundle) null);
    }

    private final void e0(String str, int i2) {
        Bundle bundle = this.Y;
        if (bundle == null || !bundle.containsKey(str)) {
            String valueOf = String.valueOf(str);
            throw new IllegalArgumentException(valueOf.length() != 0 ? "No such column: ".concat(valueOf) : new String("No such column: "));
        } else if (isClosed()) {
            throw new IllegalArgumentException("Buffer is closed.");
        } else if (i2 < 0 || i2 >= this.a3) {
            throw new CursorIndexOutOfBoundsException(i2, this.a3);
        }
    }

    private static CursorWindow[] g0(Builder builder, int i2) {
        long j2;
        if (builder.f20195a.length == 0) {
            return new CursorWindow[0];
        }
        ArrayList e2 = builder.f20196b;
        int size = e2.size();
        CursorWindow cursorWindow = new CursorWindow(false);
        ArrayList arrayList = new ArrayList();
        arrayList.add(cursorWindow);
        cursorWindow.setNumColumns(builder.f20195a.length);
        int i3 = 0;
        boolean z = false;
        while (i3 < size) {
            try {
                if (!cursorWindow.allocRow()) {
                    StringBuilder sb = new StringBuilder(72);
                    sb.append("Allocating additional cursor window for large data set (row ");
                    sb.append(i3);
                    sb.append(")");
                    Log.d("DataHolder", sb.toString());
                    cursorWindow = new CursorWindow(false);
                    cursorWindow.setStartPosition(i3);
                    cursorWindow.setNumColumns(builder.f20195a.length);
                    arrayList.add(cursorWindow);
                    if (!cursorWindow.allocRow()) {
                        Log.e("DataHolder", "Unable to allocate row to hold data.");
                        arrayList.remove(cursorWindow);
                        return (CursorWindow[]) arrayList.toArray(new CursorWindow[arrayList.size()]);
                    }
                }
                Map map = (Map) e2.get(i3);
                int i4 = 0;
                boolean z2 = true;
                while (true) {
                    if (i4 < builder.f20195a.length) {
                        if (!z2) {
                            break;
                        }
                        String str = builder.f20195a[i4];
                        Object obj = map.get(str);
                        if (obj == null) {
                            z2 = cursorWindow.putNull(i3, i4);
                        } else if (obj instanceof String) {
                            z2 = cursorWindow.putString((String) obj, i3, i4);
                        } else {
                            if (obj instanceof Long) {
                                j2 = ((Long) obj).longValue();
                            } else if (obj instanceof Integer) {
                                z2 = cursorWindow.putLong((long) ((Integer) obj).intValue(), i3, i4);
                            } else if (obj instanceof Boolean) {
                                j2 = true != ((Boolean) obj).booleanValue() ? 0 : 1;
                            } else if (obj instanceof byte[]) {
                                z2 = cursorWindow.putBlob((byte[]) obj, i3, i4);
                            } else if (obj instanceof Double) {
                                z2 = cursorWindow.putDouble(((Double) obj).doubleValue(), i3, i4);
                            } else if (obj instanceof Float) {
                                z2 = cursorWindow.putDouble((double) ((Float) obj).floatValue(), i3, i4);
                            } else {
                                String obj2 = obj.toString();
                                StringBuilder sb2 = new StringBuilder(String.valueOf(str).length() + 32 + obj2.length());
                                sb2.append("Unsupported object for column ");
                                sb2.append(str);
                                sb2.append(": ");
                                sb2.append(obj2);
                                throw new IllegalArgumentException(sb2.toString());
                            }
                            z2 = cursorWindow.putLong(j2, i3, i4);
                        }
                        i4++;
                    } else if (z2) {
                        z = false;
                    }
                }
                if (!z) {
                    StringBuilder sb3 = new StringBuilder(74);
                    sb3.append("Couldn't populate window data for row ");
                    sb3.append(i3);
                    sb3.append(" - allocating new window.");
                    Log.d("DataHolder", sb3.toString());
                    cursorWindow.freeLastRow();
                    cursorWindow = new CursorWindow(false);
                    cursorWindow.setStartPosition(i3);
                    cursorWindow.setNumColumns(builder.f20195a.length);
                    arrayList.add(cursorWindow);
                    i3--;
                    z = true;
                    i3++;
                } else {
                    throw new zad("Could not add the value to a new CursorWindow. The size of value may be larger than what a CursorWindow can handle.");
                }
            } catch (RuntimeException e3) {
                int size2 = arrayList.size();
                for (int i5 = 0; i5 < size2; i5++) {
                    ((CursorWindow) arrayList.get(i5)).close();
                }
                throw e3;
            }
        }
        return (CursorWindow[]) arrayList.toArray(new CursorWindow[arrayList.size()]);
    }

    @KeepForSdk
    public boolean I(@NonNull String str, int i2, int i3) {
        e0(str, i2);
        return this.Z[i3].getLong(i2, this.Y.getInt(str)) == 1;
    }

    @NonNull
    @KeepForSdk
    public byte[] N(@NonNull String str, int i2, int i3) {
        e0(str, i2);
        return this.Z[i3].getBlob(i2, this.Y.getInt(str));
    }

    @KeepForSdk
    public int O(@NonNull String str, int i2, int i3) {
        e0(str, i2);
        return this.Z[i3].getInt(i2, this.Y.getInt(str));
    }

    @KeepForSdk
    public long P(@NonNull String str, int i2, int i3) {
        e0(str, i2);
        return this.Z[i3].getLong(i2, this.Y.getInt(str));
    }

    @KeepForSdk
    public int Q() {
        return this.X2;
    }

    @NonNull
    @KeepForSdk
    public String R(@NonNull String str, int i2, int i3) {
        e0(str, i2);
        return this.Z[i3].getString(i2, this.Y.getInt(str));
    }

    @KeepForSdk
    public int S(int i2) {
        int length;
        int i3 = 0;
        Preconditions.x(i2 >= 0 && i2 < this.a3);
        while (true) {
            int[] iArr = this.Z2;
            length = iArr.length;
            if (i3 >= length) {
                break;
            } else if (i2 < iArr[i3]) {
                i3--;
                break;
            } else {
                i3++;
            }
        }
        return i3 == length ? i3 - 1 : i3;
    }

    @KeepForSdk
    public boolean T(@NonNull String str) {
        return this.Y.containsKey(str);
    }

    @KeepForSdk
    public boolean W(@NonNull String str, int i2, int i3) {
        e0(str, i2);
        return this.Z[i3].isNull(i2, this.Y.getInt(str));
    }

    public final double Z(@NonNull String str, int i2, int i3) {
        e0(str, i2);
        return this.Z[i3].getDouble(i2, this.Y.getInt(str));
    }

    public final float a0(@NonNull String str, int i2, int i3) {
        e0(str, i2);
        return this.Z[i3].getFloat(i2, this.Y.getInt(str));
    }

    public final void c0(@NonNull String str, int i2, int i3, @NonNull CharArrayBuffer charArrayBuffer) {
        e0(str, i2);
        this.Z[i3].copyStringToBuffer(i2, this.Y.getInt(str), charArrayBuffer);
    }

    @KeepForSdk
    public void close() {
        synchronized (this) {
            try {
                if (!this.b3) {
                    this.b3 = true;
                    int i2 = 0;
                    while (true) {
                        CursorWindow[] cursorWindowArr = this.Z;
                        if (i2 >= cursorWindowArr.length) {
                            break;
                        }
                        cursorWindowArr[i2].close();
                        i2++;
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void d0() {
        this.Y = new Bundle();
        int i2 = 0;
        int i3 = 0;
        while (true) {
            String[] strArr = this.X;
            if (i3 >= strArr.length) {
                break;
            }
            this.Y.putInt(strArr[i3], i3);
            i3++;
        }
        this.Z2 = new int[this.Z.length];
        int i4 = 0;
        while (true) {
            CursorWindow[] cursorWindowArr = this.Z;
            if (i2 < cursorWindowArr.length) {
                this.Z2[i2] = i4;
                i4 += this.Z[i2].getNumRows() - (i4 - cursorWindowArr[i2].getStartPosition());
                i2++;
            } else {
                this.a3 = i4;
                return;
            }
        }
    }

    /* access modifiers changed from: protected */
    public final void finalize() throws Throwable {
        try {
            if (this.c3 && this.Z.length > 0 && !isClosed()) {
                close();
                String obj = toString();
                StringBuilder sb = new StringBuilder(String.valueOf(obj).length() + 178);
                sb.append("Internal data leak within a DataBuffer object detected!  Be sure to explicitly call release() on all DataBuffer extending objects when you are done with them. (internal object: ");
                sb.append(obj);
                sb.append(")");
                Log.e("DataBuffer", sb.toString());
            }
        } finally {
            super.finalize();
        }
    }

    @KeepForSdk
    public int getCount() {
        return this.a3;
    }

    @KeepForSdk
    public boolean isClosed() {
        boolean z;
        synchronized (this) {
            z = this.b3;
        }
        return z;
    }

    @KeepForSdk
    @Nullable
    public Bundle l() {
        return this.Y2;
    }

    public final void writeToParcel(@NonNull Parcel parcel, int i2) {
        int a2 = SafeParcelWriter.a(parcel);
        SafeParcelWriter.Z(parcel, 1, this.X, false);
        SafeParcelWriter.c0(parcel, 2, this.Z, i2, false);
        SafeParcelWriter.F(parcel, 3, Q());
        SafeParcelWriter.k(parcel, 4, l(), false);
        SafeParcelWriter.F(parcel, 1000, this.s);
        SafeParcelWriter.b(parcel, a2);
        if ((i2 & 1) != 0) {
            close();
        }
    }

    /* JADX INFO: finally extract failed */
    /* JADX WARNING: Illegal instructions before constructor call */
    @com.google.android.gms.common.annotation.KeepForSdk
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public DataHolder(@androidx.annotation.NonNull android.database.Cursor r8, int r9, @androidx.annotation.Nullable android.os.Bundle r10) {
        /*
            r7 = this;
            com.google.android.gms.common.sqlite.CursorWrapper r0 = new com.google.android.gms.common.sqlite.CursorWrapper
            r0.<init>(r8)
            java.lang.String[] r8 = r0.getColumnNames()
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            int r2 = r0.getCount()     // Catch:{ all -> 0x002e }
            android.database.CursorWindow r3 = r0.getWindow()     // Catch:{ all -> 0x002e }
            r4 = 0
            r5 = 0
            if (r3 == 0) goto L_0x0030
            int r6 = r3.getStartPosition()     // Catch:{ all -> 0x002e }
            if (r6 != 0) goto L_0x0030
            r3.acquireReference()     // Catch:{ all -> 0x002e }
            r0.b(r4)     // Catch:{ all -> 0x002e }
            r1.add(r3)     // Catch:{ all -> 0x002e }
            int r3 = r3.getNumRows()     // Catch:{ all -> 0x002e }
            goto L_0x0031
        L_0x002e:
            r8 = move-exception
            goto L_0x0078
        L_0x0030:
            r3 = 0
        L_0x0031:
            if (r3 >= r2) goto L_0x0065
            boolean r6 = r0.moveToPosition(r3)     // Catch:{ all -> 0x002e }
            if (r6 == 0) goto L_0x0065
            android.database.CursorWindow r6 = r0.getWindow()     // Catch:{ all -> 0x002e }
            if (r6 == 0) goto L_0x0046
            r6.acquireReference()     // Catch:{ all -> 0x002e }
            r0.b(r4)     // Catch:{ all -> 0x002e }
            goto L_0x0051
        L_0x0046:
            android.database.CursorWindow r6 = new android.database.CursorWindow     // Catch:{ all -> 0x002e }
            r6.<init>(r5)     // Catch:{ all -> 0x002e }
            r6.setStartPosition(r3)     // Catch:{ all -> 0x002e }
            r0.fillWindow(r3, r6)     // Catch:{ all -> 0x002e }
        L_0x0051:
            int r3 = r6.getNumRows()     // Catch:{ all -> 0x002e }
            if (r3 != 0) goto L_0x0058
            goto L_0x0065
        L_0x0058:
            r1.add(r6)     // Catch:{ all -> 0x002e }
            int r3 = r6.getStartPosition()     // Catch:{ all -> 0x002e }
            int r6 = r6.getNumRows()     // Catch:{ all -> 0x002e }
            int r3 = r3 + r6
            goto L_0x0031
        L_0x0065:
            r0.close()
            int r0 = r1.size()
            android.database.CursorWindow[] r0 = new android.database.CursorWindow[r0]
            java.lang.Object[] r0 = r1.toArray(r0)
            android.database.CursorWindow[] r0 = (android.database.CursorWindow[]) r0
            r7.<init>((java.lang.String[]) r8, (android.database.CursorWindow[]) r0, (int) r9, (android.os.Bundle) r10)
            return
        L_0x0078:
            r0.close()
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.data.DataHolder.<init>(android.database.Cursor, int, android.os.Bundle):void");
    }

    private DataHolder(Builder builder, int i2, @Nullable Bundle bundle) {
        this(builder.f20195a, g0(builder, -1), i2, (Bundle) null);
    }

    @KeepForSdk
    public DataHolder(@NonNull String[] strArr, @NonNull CursorWindow[] cursorWindowArr, int i2, @Nullable Bundle bundle) {
        this.b3 = false;
        this.c3 = true;
        this.s = 1;
        this.X = (String[]) Preconditions.r(strArr);
        this.Z = (CursorWindow[]) Preconditions.r(cursorWindowArr);
        this.X2 = i2;
        this.Y2 = bundle;
        d0();
    }
}
