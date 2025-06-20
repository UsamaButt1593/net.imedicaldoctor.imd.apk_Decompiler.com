package com.google.android.material.timepicker;

import android.content.res.Resources;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.IntRange;
import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import com.google.android.material.R;
import java.util.Arrays;

class TimeModel implements Parcelable {
    public static final Parcelable.Creator<TimeModel> CREATOR = new Parcelable.Creator<TimeModel>() {
        /* renamed from: a */
        public TimeModel createFromParcel(Parcel parcel) {
            return new TimeModel(parcel);
        }

        /* renamed from: b */
        public TimeModel[] newArray(int i2) {
            return new TimeModel[i2];
        }
    };
    public static final String a3 = "%02d";
    public static final String b3 = "%d";
    private final MaxInputValidator X;
    int X2;
    final int Y;
    int Y2;
    int Z;
    int Z2;
    private final MaxInputValidator s;

    public TimeModel() {
        this(0);
    }

    @Nullable
    public static String a(Resources resources, CharSequence charSequence) {
        return b(resources, charSequence, a3);
    }

    @Nullable
    public static String b(Resources resources, CharSequence charSequence, String str) {
        try {
            return String.format(resources.getConfiguration().locale, str, new Object[]{Integer.valueOf(Integer.parseInt(String.valueOf(charSequence)))});
        } catch (NumberFormatException unused) {
            return null;
        }
    }

    private static int k(int i2) {
        return i2 >= 12 ? 1 : 0;
    }

    @StringRes
    public int c() {
        return this.Y == 1 ? R.string.t0 : R.string.v0;
    }

    public int d() {
        if (this.Y == 1) {
            return this.Z % 24;
        }
        int i2 = this.Z;
        if (i2 % 12 == 0) {
            return 12;
        }
        return this.Z2 == 1 ? i2 - 12 : i2;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TimeModel)) {
            return false;
        }
        TimeModel timeModel = (TimeModel) obj;
        return this.Z == timeModel.Z && this.X2 == timeModel.X2 && this.Y == timeModel.Y && this.Y2 == timeModel.Y2;
    }

    public MaxInputValidator g() {
        return this.X;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.Y), Integer.valueOf(this.Z), Integer.valueOf(this.X2), Integer.valueOf(this.Y2)});
    }

    public MaxInputValidator j() {
        return this.s;
    }

    public void l(int i2) {
        if (this.Y == 1) {
            this.Z = i2;
            return;
        }
        int i3 = 12;
        int i4 = i2 % 12;
        if (this.Z2 != 1) {
            i3 = 0;
        }
        this.Z = i4 + i3;
    }

    public void m(int i2) {
        this.Z2 = k(i2);
        this.Z = i2;
    }

    public void o(@IntRange(from = 0, to = 59) int i2) {
        this.X2 = i2 % 60;
    }

    public void p(int i2) {
        int i3;
        if (i2 != this.Z2) {
            this.Z2 = i2;
            int i4 = this.Z;
            if (i4 < 12 && i2 == 1) {
                i3 = i4 + 12;
            } else if (i4 >= 12 && i2 == 0) {
                i3 = i4 - 12;
            } else {
                return;
            }
            this.Z = i3;
        }
    }

    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeInt(this.Z);
        parcel.writeInt(this.X2);
        parcel.writeInt(this.Y2);
        parcel.writeInt(this.Y);
    }

    public TimeModel(int i2) {
        this(0, 0, 10, i2);
    }

    public TimeModel(int i2, int i3, int i4, int i5) {
        this.Z = i2;
        this.X2 = i3;
        this.Y2 = i4;
        this.Y = i5;
        this.Z2 = k(i2);
        this.s = new MaxInputValidator(59);
        this.X = new MaxInputValidator(i5 == 1 ? 23 : 12);
    }

    protected TimeModel(Parcel parcel) {
        this(parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt());
    }
}
