package androidx.fragment.app;

import android.annotation.SuppressLint;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Lifecycle;
import java.util.ArrayList;
import java.util.Map;

@SuppressLint({"BanParcelableUsage"})
final class BackStackRecordState implements Parcelable {
    public static final Parcelable.Creator<BackStackRecordState> CREATOR = new Parcelable.Creator<BackStackRecordState>() {
        /* renamed from: a */
        public BackStackRecordState createFromParcel(Parcel parcel) {
            return new BackStackRecordState(parcel);
        }

        /* renamed from: b */
        public BackStackRecordState[] newArray(int i2) {
            return new BackStackRecordState[i2];
        }
    };
    private static final String h3 = "FragmentManager";
    final ArrayList<String> X;
    final int X2;
    final int[] Y;
    final String Y2;
    final int[] Z;
    final int Z2;
    final int a3;
    final CharSequence b3;
    final int c3;
    final CharSequence d3;
    final ArrayList<String> e3;
    final ArrayList<String> f3;
    final boolean g3;
    final int[] s;

    BackStackRecordState(Parcel parcel) {
        this.s = parcel.createIntArray();
        this.X = parcel.createStringArrayList();
        this.Y = parcel.createIntArray();
        this.Z = parcel.createIntArray();
        this.X2 = parcel.readInt();
        this.Y2 = parcel.readString();
        this.Z2 = parcel.readInt();
        this.a3 = parcel.readInt();
        Parcelable.Creator creator = TextUtils.CHAR_SEQUENCE_CREATOR;
        this.b3 = (CharSequence) creator.createFromParcel(parcel);
        this.c3 = parcel.readInt();
        this.d3 = (CharSequence) creator.createFromParcel(parcel);
        this.e3 = parcel.createStringArrayList();
        this.f3 = parcel.createStringArrayList();
        this.g3 = parcel.readInt() != 0;
    }

    private void a(@NonNull BackStackRecord backStackRecord) {
        int i2 = 0;
        int i3 = 0;
        while (true) {
            boolean z = true;
            if (i2 < this.s.length) {
                FragmentTransaction.Op op = new FragmentTransaction.Op();
                int i4 = i2 + 1;
                op.f8008a = this.s[i2];
                if (FragmentManager.W0(2)) {
                    Log.v("FragmentManager", "Instantiate " + backStackRecord + " op #" + i3 + " base fragment #" + this.s[i4]);
                }
                op.f8015h = Lifecycle.State.values()[this.Y[i3]];
                op.f8016i = Lifecycle.State.values()[this.Z[i3]];
                int[] iArr = this.s;
                int i5 = i2 + 2;
                if (iArr[i4] == 0) {
                    z = false;
                }
                op.f8010c = z;
                int i6 = iArr[i5];
                op.f8011d = i6;
                int i7 = iArr[i2 + 3];
                op.f8012e = i7;
                int i8 = i2 + 5;
                int i9 = iArr[i2 + 4];
                op.f8013f = i9;
                i2 += 6;
                int i10 = iArr[i8];
                op.f8014g = i10;
                backStackRecord.f7997d = i6;
                backStackRecord.f7998e = i7;
                backStackRecord.f7999f = i9;
                backStackRecord.f8000g = i10;
                backStackRecord.m(op);
                i3++;
            } else {
                backStackRecord.f8001h = this.X2;
                backStackRecord.f8004k = this.Y2;
                backStackRecord.f8002i = true;
                backStackRecord.f8005l = this.a3;
                backStackRecord.f8006m = this.b3;
                backStackRecord.f8007n = this.c3;
                backStackRecord.o = this.d3;
                backStackRecord.p = this.e3;
                backStackRecord.q = this.f3;
                backStackRecord.r = this.g3;
                return;
            }
        }
    }

    @NonNull
    public BackStackRecord b(@NonNull FragmentManager fragmentManager) {
        BackStackRecord backStackRecord = new BackStackRecord(fragmentManager);
        a(backStackRecord);
        backStackRecord.P = this.Z2;
        for (int i2 = 0; i2 < this.X.size(); i2++) {
            String str = this.X.get(i2);
            if (str != null) {
                backStackRecord.f7996c.get(i2).f8009b = fragmentManager.o0(str);
            }
        }
        backStackRecord.U(1);
        return backStackRecord;
    }

    @NonNull
    public BackStackRecord c(@NonNull FragmentManager fragmentManager, @NonNull Map<String, Fragment> map) {
        BackStackRecord backStackRecord = new BackStackRecord(fragmentManager);
        a(backStackRecord);
        for (int i2 = 0; i2 < this.X.size(); i2++) {
            String str = this.X.get(i2);
            if (str != null) {
                Fragment fragment = map.get(str);
                if (fragment != null) {
                    backStackRecord.f7996c.get(i2).f8009b = fragment;
                } else {
                    throw new IllegalStateException("Restoring FragmentTransaction " + this.Y2 + " failed due to missing saved state for Fragment (" + str + ")");
                }
            }
        }
        return backStackRecord;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeIntArray(this.s);
        parcel.writeStringList(this.X);
        parcel.writeIntArray(this.Y);
        parcel.writeIntArray(this.Z);
        parcel.writeInt(this.X2);
        parcel.writeString(this.Y2);
        parcel.writeInt(this.Z2);
        parcel.writeInt(this.a3);
        TextUtils.writeToParcel(this.b3, parcel, 0);
        parcel.writeInt(this.c3);
        TextUtils.writeToParcel(this.d3, parcel, 0);
        parcel.writeStringList(this.e3);
        parcel.writeStringList(this.f3);
        parcel.writeInt(this.g3 ? 1 : 0);
    }

    BackStackRecordState(BackStackRecord backStackRecord) {
        int size = backStackRecord.f7996c.size();
        this.s = new int[(size * 6)];
        if (backStackRecord.f8002i) {
            this.X = new ArrayList<>(size);
            this.Y = new int[size];
            this.Z = new int[size];
            int i2 = 0;
            for (int i3 = 0; i3 < size; i3++) {
                FragmentTransaction.Op op = backStackRecord.f7996c.get(i3);
                int i4 = i2 + 1;
                this.s[i2] = op.f8008a;
                ArrayList<String> arrayList = this.X;
                Fragment fragment = op.f8009b;
                arrayList.add(fragment != null ? fragment.Y2 : null);
                int[] iArr = this.s;
                iArr[i4] = op.f8010c;
                iArr[i2 + 2] = op.f8011d;
                iArr[i2 + 3] = op.f8012e;
                int i5 = i2 + 5;
                iArr[i2 + 4] = op.f8013f;
                i2 += 6;
                iArr[i5] = op.f8014g;
                this.Y[i3] = op.f8015h.ordinal();
                this.Z[i3] = op.f8016i.ordinal();
            }
            this.X2 = backStackRecord.f8001h;
            this.Y2 = backStackRecord.f8004k;
            this.Z2 = backStackRecord.P;
            this.a3 = backStackRecord.f8005l;
            this.b3 = backStackRecord.f8006m;
            this.c3 = backStackRecord.f8007n;
            this.d3 = backStackRecord.o;
            this.e3 = backStackRecord.p;
            this.f3 = backStackRecord.q;
            this.g3 = backStackRecord.r;
            return;
        }
        throw new IllegalStateException("Not on back stack");
    }
}
