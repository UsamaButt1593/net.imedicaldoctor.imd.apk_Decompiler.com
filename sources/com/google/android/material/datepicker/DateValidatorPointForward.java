package com.google.android.material.datepicker;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import com.google.android.material.datepicker.CalendarConstraints;
import java.util.Arrays;

public class DateValidatorPointForward implements CalendarConstraints.DateValidator {
    public static final Parcelable.Creator<DateValidatorPointForward> CREATOR = new Parcelable.Creator<DateValidatorPointForward>() {
        @NonNull
        /* renamed from: a */
        public DateValidatorPointForward createFromParcel(@NonNull Parcel parcel) {
            return new DateValidatorPointForward(parcel.readLong());
        }

        @NonNull
        /* renamed from: b */
        public DateValidatorPointForward[] newArray(int i2) {
            return new DateValidatorPointForward[i2];
        }
    };
    private final long s;

    private DateValidatorPointForward(long j2) {
        this.s = j2;
    }

    @NonNull
    public static DateValidatorPointForward a(long j2) {
        return new DateValidatorPointForward(j2);
    }

    @NonNull
    public static DateValidatorPointForward b() {
        return a(UtcDates.v().getTimeInMillis());
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof DateValidatorPointForward) && this.s == ((DateValidatorPointForward) obj).s;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Long.valueOf(this.s)});
    }

    public void writeToParcel(@NonNull Parcel parcel, int i2) {
        parcel.writeLong(this.s);
    }

    public boolean y(long j2) {
        return j2 >= this.s;
    }
}
