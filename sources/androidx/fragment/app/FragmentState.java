package androidx.fragment.app;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.lifecycle.Lifecycle;

@SuppressLint({"BanParcelableUsage"})
final class FragmentState implements Parcelable {
    public static final Parcelable.Creator<FragmentState> CREATOR = new Parcelable.Creator<FragmentState>() {
        /* renamed from: a */
        public FragmentState createFromParcel(Parcel parcel) {
            return new FragmentState(parcel);
        }

        /* renamed from: b */
        public FragmentState[] newArray(int i2) {
            return new FragmentState[i2];
        }
    };
    final String X;
    final int X2;
    final boolean Y;
    final String Y2;
    final int Z;
    final boolean Z2;
    final boolean a3;
    final boolean b3;
    final Bundle c3;
    final boolean d3;
    final int e3;
    Bundle f3;
    final String s;

    FragmentState(Parcel parcel) {
        this.s = parcel.readString();
        this.X = parcel.readString();
        boolean z = false;
        this.Y = parcel.readInt() != 0;
        this.Z = parcel.readInt();
        this.X2 = parcel.readInt();
        this.Y2 = parcel.readString();
        this.Z2 = parcel.readInt() != 0;
        this.a3 = parcel.readInt() != 0;
        this.b3 = parcel.readInt() != 0;
        this.c3 = parcel.readBundle();
        this.d3 = parcel.readInt() != 0 ? true : z;
        this.f3 = parcel.readBundle();
        this.e3 = parcel.readInt();
    }

    /* access modifiers changed from: package-private */
    @NonNull
    public Fragment a(@NonNull FragmentFactory fragmentFactory, @NonNull ClassLoader classLoader) {
        Fragment a2 = fragmentFactory.a(classLoader, this.s);
        Bundle bundle = this.c3;
        if (bundle != null) {
            bundle.setClassLoader(classLoader);
        }
        a2.i2(this.c3);
        a2.Y2 = this.X;
        a2.h3 = this.Y;
        a2.j3 = true;
        a2.q3 = this.Z;
        a2.r3 = this.X2;
        a2.s3 = this.Y2;
        a2.v3 = this.Z2;
        a2.f3 = this.a3;
        a2.u3 = this.b3;
        a2.t3 = this.d3;
        a2.K3 = Lifecycle.State.values()[this.e3];
        Bundle bundle2 = this.f3;
        if (bundle2 == null) {
            bundle2 = new Bundle();
        }
        a2.X = bundle2;
        return a2;
    }

    public int describeContents() {
        return 0;
    }

    @NonNull
    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("FragmentState{");
        sb.append(this.s);
        sb.append(" (");
        sb.append(this.X);
        sb.append(")}:");
        if (this.Y) {
            sb.append(" fromLayout");
        }
        if (this.X2 != 0) {
            sb.append(" id=0x");
            sb.append(Integer.toHexString(this.X2));
        }
        String str = this.Y2;
        if (str != null && !str.isEmpty()) {
            sb.append(" tag=");
            sb.append(this.Y2);
        }
        if (this.Z2) {
            sb.append(" retainInstance");
        }
        if (this.a3) {
            sb.append(" removing");
        }
        if (this.b3) {
            sb.append(" detached");
        }
        if (this.d3) {
            sb.append(" hidden");
        }
        return sb.toString();
    }

    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.s);
        parcel.writeString(this.X);
        parcel.writeInt(this.Y ? 1 : 0);
        parcel.writeInt(this.Z);
        parcel.writeInt(this.X2);
        parcel.writeString(this.Y2);
        parcel.writeInt(this.Z2 ? 1 : 0);
        parcel.writeInt(this.a3 ? 1 : 0);
        parcel.writeInt(this.b3 ? 1 : 0);
        parcel.writeBundle(this.c3);
        parcel.writeInt(this.d3 ? 1 : 0);
        parcel.writeBundle(this.f3);
        parcel.writeInt(this.e3);
    }

    FragmentState(Fragment fragment) {
        this.s = fragment.getClass().getName();
        this.X = fragment.Y2;
        this.Y = fragment.h3;
        this.Z = fragment.q3;
        this.X2 = fragment.r3;
        this.Y2 = fragment.s3;
        this.Z2 = fragment.v3;
        this.a3 = fragment.f3;
        this.b3 = fragment.u3;
        this.c3 = fragment.Z2;
        this.d3 = fragment.t3;
        this.e3 = fragment.K3.ordinal();
    }
}
