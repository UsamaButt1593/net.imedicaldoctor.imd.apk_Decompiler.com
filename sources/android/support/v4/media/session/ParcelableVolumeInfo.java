package android.support.v4.media.session;

import android.annotation.SuppressLint;
import android.os.Parcel;
import android.os.Parcelable;

@SuppressLint({"BanParcelableUsage"})
public class ParcelableVolumeInfo implements Parcelable {
    public static final Parcelable.Creator<ParcelableVolumeInfo> CREATOR = new Parcelable.Creator<ParcelableVolumeInfo>() {
        /* renamed from: a */
        public ParcelableVolumeInfo createFromParcel(Parcel parcel) {
            return new ParcelableVolumeInfo(parcel);
        }

        /* renamed from: b */
        public ParcelableVolumeInfo[] newArray(int i2) {
            return new ParcelableVolumeInfo[i2];
        }
    };
    public int X;
    public int X2;
    public int Y;
    public int Z;
    public int s;

    public ParcelableVolumeInfo(int i2, int i3, int i4, int i5, int i6) {
        this.s = i2;
        this.X = i3;
        this.Y = i4;
        this.Z = i5;
        this.X2 = i6;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeInt(this.s);
        parcel.writeInt(this.Y);
        parcel.writeInt(this.Z);
        parcel.writeInt(this.X2);
        parcel.writeInt(this.X);
    }

    public ParcelableVolumeInfo(Parcel parcel) {
        this.s = parcel.readInt();
        this.Y = parcel.readInt();
        this.Z = parcel.readInt();
        this.X2 = parcel.readInt();
        this.X = parcel.readInt();
    }
}
