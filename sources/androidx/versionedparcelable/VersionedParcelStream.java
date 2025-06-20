package androidx.versionedparcelable;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcelable;
import androidx.annotation.RestrictTo;
import androidx.collection.ArrayMap;
import androidx.versionedparcelable.VersionedParcel;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.Method;
import java.nio.charset.Charset;
import java.util.Set;

@RestrictTo({RestrictTo.Scope.LIBRARY})
class VersionedParcelStream extends VersionedParcel {
    private static final Charset C = Charset.forName("UTF-16");
    private static final int D = 0;
    private static final int E = 1;
    private static final int F = 2;
    private static final int G = 3;
    private static final int H = 4;
    private static final int I = 5;
    private static final int J = 6;
    private static final int K = 7;
    private static final int L = 8;
    private static final int M = 9;
    private static final int N = 10;
    private static final int O = 11;
    private static final int P = 12;
    private static final int Q = 13;
    private static final int R = 14;
    private int A;
    int B;
    private final DataInputStream t;
    private final DataOutputStream u;
    private DataInputStream v;
    private DataOutputStream w;
    private FieldBuffer x;
    private boolean y;
    int z;

    private static class FieldBuffer {

        /* renamed from: a  reason: collision with root package name */
        final ByteArrayOutputStream f16420a;

        /* renamed from: b  reason: collision with root package name */
        final DataOutputStream f16421b;

        /* renamed from: c  reason: collision with root package name */
        private final int f16422c;

        /* renamed from: d  reason: collision with root package name */
        private final DataOutputStream f16423d;

        FieldBuffer(int i2, DataOutputStream dataOutputStream) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            this.f16420a = byteArrayOutputStream;
            this.f16421b = new DataOutputStream(byteArrayOutputStream);
            this.f16422c = i2;
            this.f16423d = dataOutputStream;
        }

        /* access modifiers changed from: package-private */
        public void a() throws IOException {
            this.f16421b.flush();
            int size = this.f16420a.size();
            this.f16423d.writeInt((this.f16422c << 16) | (size >= 65535 ? 65535 : size));
            if (size >= 65535) {
                this.f16423d.writeInt(size);
            }
            this.f16420a.writeTo(this.f16423d);
        }
    }

    public VersionedParcelStream(InputStream inputStream, OutputStream outputStream) {
        this(inputStream, outputStream, new ArrayMap(), new ArrayMap(), new ArrayMap());
    }

    private void o1(int i2, String str, Bundle bundle) {
        switch (i2) {
            case 0:
                bundle.putParcelable(str, (Parcelable) null);
                return;
            case 1:
            case 2:
                bundle.putBundle(str, p());
                return;
            case 3:
                bundle.putString(str, c0());
                return;
            case 4:
                bundle.putStringArray(str, (String[]) j(new String[0]));
                return;
            case 5:
                bundle.putBoolean(str, l());
                return;
            case 6:
                bundle.putBooleanArray(str, n());
                return;
            case 7:
                bundle.putDouble(str, y());
                return;
            case 8:
                bundle.putDoubleArray(str, A());
                return;
            case 9:
                bundle.putInt(str, L());
                return;
            case 10:
                bundle.putIntArray(str, N());
                return;
            case 11:
                bundle.putLong(str, Q());
                return;
            case 12:
                bundle.putLongArray(str, S());
                return;
            case 13:
                bundle.putFloat(str, G());
                return;
            case 14:
                bundle.putFloatArray(str, I());
                return;
            default:
                throw new RuntimeException("Unknown type " + i2);
        }
    }

    private void p1(Object obj) {
        int intValue;
        if (obj == null) {
            intValue = 0;
        } else if (obj instanceof Bundle) {
            L0(1);
            q0((Bundle) obj);
            return;
        } else if (obj instanceof String) {
            L0(3);
            e1((String) obj);
            return;
        } else if (obj instanceof String[]) {
            L0(4);
            k0((String[]) obj);
            return;
        } else if (obj instanceof Boolean) {
            L0(5);
            m0(((Boolean) obj).booleanValue());
            return;
        } else if (obj instanceof boolean[]) {
            L0(6);
            o0((boolean[]) obj);
            return;
        } else if (obj instanceof Double) {
            L0(7);
            C0(((Double) obj).doubleValue());
            return;
        } else if (obj instanceof double[]) {
            L0(8);
            E0((double[]) obj);
            return;
        } else if (obj instanceof Integer) {
            L0(9);
            intValue = ((Integer) obj).intValue();
        } else if (obj instanceof int[]) {
            L0(10);
            N0((int[]) obj);
            return;
        } else if (obj instanceof Long) {
            L0(11);
            Q0(((Long) obj).longValue());
            return;
        } else if (obj instanceof long[]) {
            L0(12);
            S0((long[]) obj);
            return;
        } else if (obj instanceof Float) {
            L0(13);
            H0(((Float) obj).floatValue());
            return;
        } else if (obj instanceof float[]) {
            L0(14);
            J0((float[]) obj);
            return;
        } else {
            throw new IllegalArgumentException("Unsupported type " + obj.getClass());
        }
        L0(intValue);
    }

    public void C0(double d2) {
        try {
            this.w.writeDouble(d2);
        } catch (IOException e2) {
            throw new VersionedParcel.ParcelException(e2);
        }
    }

    public boolean F(int i2) {
        while (true) {
            try {
                int i3 = this.A;
                if (i3 == i2) {
                    return true;
                }
                if (String.valueOf(i3).compareTo(String.valueOf(i2)) > 0) {
                    return false;
                }
                int i4 = this.z;
                int i5 = this.B;
                if (i4 < i5) {
                    this.t.skip((long) (i5 - i4));
                }
                this.B = -1;
                int readInt = this.t.readInt();
                this.z = 0;
                int i6 = readInt & 65535;
                if (i6 == 65535) {
                    i6 = this.t.readInt();
                }
                this.A = (readInt >> 16) & 65535;
                this.B = i6;
            } catch (IOException unused) {
                return false;
            }
        }
    }

    public float G() {
        try {
            return this.v.readFloat();
        } catch (IOException e2) {
            throw new VersionedParcel.ParcelException(e2);
        }
    }

    public void H0(float f2) {
        try {
            this.w.writeFloat(f2);
        } catch (IOException e2) {
            throw new VersionedParcel.ParcelException(e2);
        }
    }

    public int L() {
        try {
            return this.v.readInt();
        } catch (IOException e2) {
            throw new VersionedParcel.ParcelException(e2);
        }
    }

    public void L0(int i2) {
        try {
            this.w.writeInt(i2);
        } catch (IOException e2) {
            throw new VersionedParcel.ParcelException(e2);
        }
    }

    public long Q() {
        try {
            return this.v.readLong();
        } catch (IOException e2) {
            throw new VersionedParcel.ParcelException(e2);
        }
    }

    public void Q0(long j2) {
        try {
            this.w.writeLong(j2);
        } catch (IOException e2) {
            throw new VersionedParcel.ParcelException(e2);
        }
    }

    public <T extends Parcelable> T V() {
        return null;
    }

    public void W0(Parcelable parcelable) {
        if (!this.y) {
            throw new RuntimeException("Parcelables cannot be written to an OutputStream");
        }
    }

    public void a() {
        FieldBuffer fieldBuffer = this.x;
        if (fieldBuffer != null) {
            try {
                if (fieldBuffer.f16420a.size() != 0) {
                    this.x.a();
                }
                this.x = null;
            } catch (IOException e2) {
                throw new VersionedParcel.ParcelException(e2);
            }
        }
    }

    /* access modifiers changed from: protected */
    public VersionedParcel c() {
        return new VersionedParcelStream(this.v, this.w, this.f16417a, this.f16418b, this.f16419c);
    }

    public String c0() {
        try {
            int readInt = this.v.readInt();
            if (readInt <= 0) {
                return null;
            }
            byte[] bArr = new byte[readInt];
            this.v.readFully(bArr);
            return new String(bArr, C);
        } catch (IOException e2) {
            throw new VersionedParcel.ParcelException(e2);
        }
    }

    public IBinder e0() {
        return null;
    }

    public void e1(String str) {
        if (str != null) {
            try {
                byte[] bytes = str.getBytes(C);
                this.w.writeInt(bytes.length);
                this.w.write(bytes);
            } catch (IOException e2) {
                throw new VersionedParcel.ParcelException(e2);
            }
        } else {
            this.w.writeInt(-1);
        }
    }

    public void g1(IBinder iBinder) {
        if (!this.y) {
            throw new RuntimeException("Binders cannot be written to an OutputStream");
        }
    }

    public boolean i() {
        return true;
    }

    public void i0(int i2) {
        a();
        FieldBuffer fieldBuffer = new FieldBuffer(i2, this.u);
        this.x = fieldBuffer;
        this.w = fieldBuffer.f16421b;
    }

    public void i1(IInterface iInterface) {
        if (!this.y) {
            throw new RuntimeException("Binders cannot be written to an OutputStream");
        }
    }

    public void j0(boolean z2, boolean z3) {
        if (z2) {
            this.y = z3;
            return;
        }
        throw new RuntimeException("Serialization of this object is not allowed");
    }

    public boolean l() {
        try {
            return this.v.readBoolean();
        } catch (IOException e2) {
            throw new VersionedParcel.ParcelException(e2);
        }
    }

    public void m0(boolean z2) {
        try {
            this.w.writeBoolean(z2);
        } catch (IOException e2) {
            throw new VersionedParcel.ParcelException(e2);
        }
    }

    public Bundle p() {
        int L2 = L();
        if (L2 < 0) {
            return null;
        }
        Bundle bundle = new Bundle();
        for (int i2 = 0; i2 < L2; i2++) {
            o1(L(), c0(), bundle);
        }
        return bundle;
    }

    public void q0(Bundle bundle) {
        if (bundle != null) {
            try {
                Set<String> keySet = bundle.keySet();
                this.w.writeInt(keySet.size());
                for (String next : keySet) {
                    e1(next);
                    p1(bundle.get(next));
                }
            } catch (IOException e2) {
                throw new VersionedParcel.ParcelException(e2);
            }
        } else {
            this.w.writeInt(-1);
        }
    }

    public byte[] s() {
        try {
            int readInt = this.v.readInt();
            if (readInt <= 0) {
                return null;
            }
            byte[] bArr = new byte[readInt];
            this.v.readFully(bArr);
            return bArr;
        } catch (IOException e2) {
            throw new VersionedParcel.ParcelException(e2);
        }
    }

    public void t0(byte[] bArr) {
        if (bArr != null) {
            try {
                this.w.writeInt(bArr.length);
                this.w.write(bArr);
            } catch (IOException e2) {
                throw new VersionedParcel.ParcelException(e2);
            }
        } else {
            this.w.writeInt(-1);
        }
    }

    /* access modifiers changed from: protected */
    public CharSequence v() {
        return null;
    }

    public void v0(byte[] bArr, int i2, int i3) {
        if (bArr != null) {
            try {
                this.w.writeInt(i3);
                this.w.write(bArr, i2, i3);
            } catch (IOException e2) {
                throw new VersionedParcel.ParcelException(e2);
            }
        } else {
            this.w.writeInt(-1);
        }
    }

    public double y() {
        try {
            return this.v.readDouble();
        } catch (IOException e2) {
            throw new VersionedParcel.ParcelException(e2);
        }
    }

    /* access modifiers changed from: protected */
    public void y0(CharSequence charSequence) {
        if (!this.y) {
            throw new RuntimeException("CharSequence cannot be written to an OutputStream");
        }
    }

    private VersionedParcelStream(InputStream inputStream, OutputStream outputStream, ArrayMap<String, Method> arrayMap, ArrayMap<String, Method> arrayMap2, ArrayMap<String, Class> arrayMap3) {
        super(arrayMap, arrayMap2, arrayMap3);
        this.z = 0;
        this.A = -1;
        this.B = -1;
        DataOutputStream dataOutputStream = null;
        DataInputStream dataInputStream = inputStream != null ? new DataInputStream(new FilterInputStream(inputStream) {
            public int read() throws IOException {
                VersionedParcelStream versionedParcelStream = VersionedParcelStream.this;
                int i2 = versionedParcelStream.B;
                if (i2 == -1 || versionedParcelStream.z < i2) {
                    int read = super.read();
                    VersionedParcelStream.this.z++;
                    return read;
                }
                throw new IOException();
            }

            public long skip(long j2) throws IOException {
                VersionedParcelStream versionedParcelStream = VersionedParcelStream.this;
                int i2 = versionedParcelStream.B;
                if (i2 == -1 || versionedParcelStream.z < i2) {
                    long skip = super.skip(j2);
                    if (skip > 0) {
                        VersionedParcelStream.this.z += (int) skip;
                    }
                    return skip;
                }
                throw new IOException();
            }

            public int read(byte[] bArr, int i2, int i3) throws IOException {
                VersionedParcelStream versionedParcelStream = VersionedParcelStream.this;
                int i4 = versionedParcelStream.B;
                if (i4 == -1 || versionedParcelStream.z < i4) {
                    int read = super.read(bArr, i2, i3);
                    if (read > 0) {
                        VersionedParcelStream.this.z += read;
                    }
                    return read;
                }
                throw new IOException();
            }
        }) : null;
        this.t = dataInputStream;
        dataOutputStream = outputStream != null ? new DataOutputStream(outputStream) : dataOutputStream;
        this.u = dataOutputStream;
        this.v = dataInputStream;
        this.w = dataOutputStream;
    }
}
