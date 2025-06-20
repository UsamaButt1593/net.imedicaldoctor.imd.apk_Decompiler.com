package androidx.versionedparcelable;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.SparseIntArray;
import androidx.annotation.RestrictTo;
import androidx.collection.ArrayMap;
import java.lang.reflect.Method;

@RestrictTo({RestrictTo.Scope.LIBRARY})
class VersionedParcelParcel extends VersionedParcel {
    private static final boolean B = false;
    private static final String C = "VersionedParcelParcel";
    private int A;
    private final SparseIntArray t;
    private final Parcel u;
    private final int v;
    private final int w;
    private final String x;
    private int y;
    private int z;

    VersionedParcelParcel(Parcel parcel) {
        this(parcel, parcel.dataPosition(), parcel.dataSize(), "", new ArrayMap(), new ArrayMap(), new ArrayMap());
    }

    public void C0(double d2) {
        this.u.writeDouble(d2);
    }

    public boolean F(int i2) {
        while (this.z < this.w) {
            int i3 = this.A;
            if (i3 == i2) {
                return true;
            }
            if (String.valueOf(i3).compareTo(String.valueOf(i2)) > 0) {
                return false;
            }
            this.u.setDataPosition(this.z);
            int readInt = this.u.readInt();
            this.A = this.u.readInt();
            this.z += readInt;
        }
        return this.A == i2;
    }

    public float G() {
        return this.u.readFloat();
    }

    public void H0(float f2) {
        this.u.writeFloat(f2);
    }

    public int L() {
        return this.u.readInt();
    }

    public void L0(int i2) {
        this.u.writeInt(i2);
    }

    public long Q() {
        return this.u.readLong();
    }

    public void Q0(long j2) {
        this.u.writeLong(j2);
    }

    public <T extends Parcelable> T V() {
        return this.u.readParcelable(getClass().getClassLoader());
    }

    public void W0(Parcelable parcelable) {
        this.u.writeParcelable(parcelable, 0);
    }

    public void a() {
        int i2 = this.y;
        if (i2 >= 0) {
            int i3 = this.t.get(i2);
            int dataPosition = this.u.dataPosition();
            this.u.setDataPosition(i3);
            this.u.writeInt(dataPosition - i3);
            this.u.setDataPosition(dataPosition);
        }
    }

    /* access modifiers changed from: protected */
    public VersionedParcel c() {
        Parcel parcel = this.u;
        int dataPosition = parcel.dataPosition();
        int i2 = this.z;
        if (i2 == this.v) {
            i2 = this.w;
        }
        int i3 = i2;
        return new VersionedParcelParcel(parcel, dataPosition, i3, this.x + "  ", this.f16417a, this.f16418b, this.f16419c);
    }

    public String c0() {
        return this.u.readString();
    }

    public IBinder e0() {
        return this.u.readStrongBinder();
    }

    public void e1(String str) {
        this.u.writeString(str);
    }

    public void g1(IBinder iBinder) {
        this.u.writeStrongBinder(iBinder);
    }

    public void i0(int i2) {
        a();
        this.y = i2;
        this.t.put(i2, this.u.dataPosition());
        L0(0);
        L0(i2);
    }

    public void i1(IInterface iInterface) {
        this.u.writeStrongInterface(iInterface);
    }

    public boolean l() {
        return this.u.readInt() != 0;
    }

    public void m0(boolean z2) {
        this.u.writeInt(z2 ? 1 : 0);
    }

    public Bundle p() {
        return this.u.readBundle(getClass().getClassLoader());
    }

    public void q0(Bundle bundle) {
        this.u.writeBundle(bundle);
    }

    public byte[] s() {
        int readInt = this.u.readInt();
        if (readInt < 0) {
            return null;
        }
        byte[] bArr = new byte[readInt];
        this.u.readByteArray(bArr);
        return bArr;
    }

    public void t0(byte[] bArr) {
        if (bArr != null) {
            this.u.writeInt(bArr.length);
            this.u.writeByteArray(bArr);
            return;
        }
        this.u.writeInt(-1);
    }

    /* access modifiers changed from: protected */
    public CharSequence v() {
        return (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(this.u);
    }

    public void v0(byte[] bArr, int i2, int i3) {
        if (bArr != null) {
            this.u.writeInt(bArr.length);
            this.u.writeByteArray(bArr, i2, i3);
            return;
        }
        this.u.writeInt(-1);
    }

    public double y() {
        return this.u.readDouble();
    }

    /* access modifiers changed from: protected */
    public void y0(CharSequence charSequence) {
        TextUtils.writeToParcel(charSequence, this.u, 0);
    }

    private VersionedParcelParcel(Parcel parcel, int i2, int i3, String str, ArrayMap<String, Method> arrayMap, ArrayMap<String, Method> arrayMap2, ArrayMap<String, Class> arrayMap3) {
        super(arrayMap, arrayMap2, arrayMap3);
        this.t = new SparseIntArray();
        this.y = -1;
        this.A = -1;
        this.u = parcel;
        this.v = i2;
        this.w = i3;
        this.z = i2;
        this.x = str;
    }
}
