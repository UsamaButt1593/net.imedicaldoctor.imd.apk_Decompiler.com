package androidx.media3.common;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;

@UnstableApi
public final class StreamKey implements Comparable<StreamKey>, Parcelable, Bundleable {
    public static final Parcelable.Creator<StreamKey> CREATOR = new Parcelable.Creator<StreamKey>() {
        /* renamed from: a */
        public StreamKey createFromParcel(Parcel parcel) {
            return new StreamKey(parcel);
        }

        /* renamed from: b */
        public StreamKey[] newArray(int i2) {
            return new StreamKey[i2];
        }
    };
    private static final String X2 = Util.d1(1);
    private static final String Y2 = Util.d1(2);
    private static final String Z = Util.d1(0);
    public final int X;
    public final int Y;
    public final int s;

    public StreamKey(int i2, int i3) {
        this(0, i2, i3);
    }

    public static StreamKey c(Bundle bundle) {
        return new StreamKey(bundle.getInt(Z, 0), bundle.getInt(X2, 0), bundle.getInt(Y2, 0));
    }

    public Bundle a() {
        Bundle bundle = new Bundle();
        int i2 = this.s;
        if (i2 != 0) {
            bundle.putInt(Z, i2);
        }
        int i3 = this.X;
        if (i3 != 0) {
            bundle.putInt(X2, i3);
        }
        int i4 = this.Y;
        if (i4 != 0) {
            bundle.putInt(Y2, i4);
        }
        return bundle;
    }

    /* renamed from: b */
    public int compareTo(StreamKey streamKey) {
        int i2 = this.s - streamKey.s;
        if (i2 != 0) {
            return i2;
        }
        int i3 = this.X - streamKey.X;
        return i3 == 0 ? this.Y - streamKey.Y : i3;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || StreamKey.class != obj.getClass()) {
            return false;
        }
        StreamKey streamKey = (StreamKey) obj;
        return this.s == streamKey.s && this.X == streamKey.X && this.Y == streamKey.Y;
    }

    public int hashCode() {
        return (((this.s * 31) + this.X) * 31) + this.Y;
    }

    public String toString() {
        return this.s + "." + this.X + "." + this.Y;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeInt(this.s);
        parcel.writeInt(this.X);
        parcel.writeInt(this.Y);
    }

    public StreamKey(int i2, int i3, int i4) {
        this.s = i2;
        this.X = i3;
        this.Y = i4;
    }

    StreamKey(Parcel parcel) {
        this.s = parcel.readInt();
        this.X = parcel.readInt();
        this.Y = parcel.readInt();
    }
}
