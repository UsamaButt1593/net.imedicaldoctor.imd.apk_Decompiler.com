package com.google.android.material.datepicker;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.Arrays;
import java.util.Calendar;
import java.util.GregorianCalendar;

final class Month implements Comparable<Month>, Parcelable {
    public static final Parcelable.Creator<Month> CREATOR = new Parcelable.Creator<Month>() {
        @NonNull
        /* renamed from: a */
        public Month createFromParcel(@NonNull Parcel parcel) {
            return Month.b(parcel.readInt(), parcel.readInt());
        }

        @NonNull
        /* renamed from: b */
        public Month[] newArray(int i2) {
            return new Month[i2];
        }
    };
    final int X;
    final int X2;
    final int Y;
    final long Y2;
    final int Z;
    @Nullable
    private String Z2;
    @NonNull
    private final Calendar s;

    private Month(@NonNull Calendar calendar) {
        calendar.set(5, 1);
        Calendar f2 = UtcDates.f(calendar);
        this.s = f2;
        this.X = f2.get(2);
        this.Y = f2.get(1);
        this.Z = f2.getMaximum(7);
        this.X2 = f2.getActualMaximum(5);
        this.Y2 = f2.getTimeInMillis();
    }

    @NonNull
    static Month b(int i2, int i3) {
        Calendar x = UtcDates.x();
        x.set(1, i2);
        x.set(2, i3);
        return new Month(x);
    }

    @NonNull
    static Month c(long j2) {
        Calendar x = UtcDates.x();
        x.setTimeInMillis(j2);
        return new Month(x);
    }

    @NonNull
    static Month g() {
        return new Month(UtcDates.v());
    }

    /* renamed from: a */
    public int compareTo(@NonNull Month month) {
        return this.s.compareTo(month.s);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Month)) {
            return false;
        }
        Month month = (Month) obj;
        return this.X == month.X && this.Y == month.Y;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.X), Integer.valueOf(this.Y)});
    }

    /* access modifiers changed from: package-private */
    public int j(int i2) {
        int i3 = this.s.get(7);
        if (i2 <= 0) {
            i2 = this.s.getFirstDayOfWeek();
        }
        int i4 = i3 - i2;
        return i4 < 0 ? i4 + this.Z : i4;
    }

    /* access modifiers changed from: package-private */
    public long k(int i2) {
        Calendar f2 = UtcDates.f(this.s);
        f2.set(5, i2);
        return f2.getTimeInMillis();
    }

    /* access modifiers changed from: package-private */
    public int l(long j2) {
        Calendar f2 = UtcDates.f(this.s);
        f2.setTimeInMillis(j2);
        return f2.get(5);
    }

    /* access modifiers changed from: package-private */
    @NonNull
    public String m() {
        if (this.Z2 == null) {
            this.Z2 = DateStrings.l(this.s.getTimeInMillis());
        }
        return this.Z2;
    }

    /* access modifiers changed from: package-private */
    public long o() {
        return this.s.getTimeInMillis();
    }

    /* access modifiers changed from: package-private */
    @NonNull
    public Month p(int i2) {
        Calendar f2 = UtcDates.f(this.s);
        f2.add(2, i2);
        return new Month(f2);
    }

    /* access modifiers changed from: package-private */
    public int v(@NonNull Month month) {
        if (this.s instanceof GregorianCalendar) {
            return ((month.Y - this.Y) * 12) + (month.X - this.X);
        }
        throw new IllegalArgumentException("Only Gregorian calendars are supported.");
    }

    public void writeToParcel(@NonNull Parcel parcel, int i2) {
        parcel.writeInt(this.Y);
        parcel.writeInt(this.X);
    }
}
