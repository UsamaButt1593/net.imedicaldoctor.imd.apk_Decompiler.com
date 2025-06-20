package com.google.android.material.datepicker;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import com.google.android.material.datepicker.CalendarConstraints;
import java.util.Arrays;

public class DateValidatorPointBackward implements CalendarConstraints.DateValidator {
    public static final Parcelable.Creator<DateValidatorPointBackward> CREATOR = new Parcelable.Creator<DateValidatorPointBackward>() {
        @NonNull
        /* renamed from: a */
        public DateValidatorPointBackward createFromParcel(@NonNull Parcel parcel) {
            return new DateValidatorPointBackward(parcel.readLong());
        }

        @NonNull
        /* renamed from: b */
        public DateValidatorPointBackward[] newArray(int i2) {
            return new DateValidatorPointBackward[i2];
        }
    };
    private final long s;

    private DateValidatorPointBackward(long j2) {
        this.s = j2;
    }

    @NonNull
    public static DateValidatorPointBackward a(long j2) {
        return new DateValidatorPointBackward(j2);
    }

    @NonNull
    public static DateValidatorPointBackward b() {
        return a(UtcDates.v().getTimeInMillis());
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof DateValidatorPointBackward) && this.s == ((DateValidatorPointBackward) obj).s;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Long.valueOf(this.s)});
    }

    public void writeToParcel(@NonNull Parcel parcel, int i2) {
        parcel.writeLong(this.s);
    }

    public boolean y(long j2) {
        return j2 <= this.s;
    }
}
