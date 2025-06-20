package androidx.versionedparcelable;

import android.annotation.SuppressLint;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.RestrictTo;

@SuppressLint({"BanParcelableUsage"})
@RestrictTo({RestrictTo.Scope.LIBRARY})
public class ParcelImpl implements Parcelable {
    public static final Parcelable.Creator<ParcelImpl> CREATOR = new Parcelable.Creator<ParcelImpl>() {
        /* renamed from: a */
        public ParcelImpl createFromParcel(Parcel parcel) {
            return new ParcelImpl(parcel);
        }

        /* renamed from: b */
        public ParcelImpl[] newArray(int i2) {
            return new ParcelImpl[i2];
        }
    };
    private final VersionedParcelable s;

    protected ParcelImpl(Parcel parcel) {
        this.s = new VersionedParcelParcel(parcel).g0();
    }

    public <T extends VersionedParcelable> T a() {
        return this.s;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        new VersionedParcelParcel(parcel).l1(this.s);
    }

    public ParcelImpl(VersionedParcelable versionedParcelable) {
        this.s = versionedParcelable;
    }
}
