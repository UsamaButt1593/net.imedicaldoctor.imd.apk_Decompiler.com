package com.prolificinteractive.materialcalendarview;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import org.threeten.bp.LocalDate;

public final class CalendarDay implements Parcelable {
    public static final Parcelable.Creator<CalendarDay> CREATOR = new Parcelable.Creator<CalendarDay>() {
        /* renamed from: a */
        public CalendarDay createFromParcel(Parcel parcel) {
            return new CalendarDay(parcel);
        }

        /* renamed from: b */
        public CalendarDay[] newArray(int i2) {
            return new CalendarDay[i2];
        }
    };
    @NonNull
    private final LocalDate s;

    private CalendarDay(int i2, int i3, int i4) {
        this.s = LocalDate.r2(i2, i3, i4);
    }

    @NonNull
    public static CalendarDay a(int i2, int i3, int i4) {
        return new CalendarDay(i2, i3, i4);
    }

    public static CalendarDay b(@Nullable LocalDate localDate) {
        if (localDate == null) {
            return null;
        }
        return new CalendarDay(localDate);
    }

    private static int k(int i2, int i3, int i4) {
        return (i2 * 10000) + (i3 * 100) + i4;
    }

    @NonNull
    public static CalendarDay p() {
        return b(LocalDate.n2());
    }

    @NonNull
    public LocalDate c() {
        return this.s;
    }

    public int d() {
        return this.s.h1();
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return (obj instanceof CalendarDay) && this.s.equals(((CalendarDay) obj).c());
    }

    public int g() {
        return this.s.w1();
    }

    public int hashCode() {
        return k(this.s.M0(), this.s.w1(), this.s.h1());
    }

    public int j() {
        return this.s.M0();
    }

    public boolean l(@NonNull CalendarDay calendarDay) {
        return this.s.z(calendarDay.c());
    }

    public boolean m(@NonNull CalendarDay calendarDay) {
        return this.s.A(calendarDay.c());
    }

    public boolean o(@Nullable CalendarDay calendarDay, @Nullable CalendarDay calendarDay2) {
        return (calendarDay == null || !calendarDay.l(this)) && (calendarDay2 == null || !calendarDay2.m(this));
    }

    public String toString() {
        return "CalendarDay{" + this.s.M0() + "-" + this.s.w1() + "-" + this.s.h1() + "}";
    }

    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeInt(this.s.M0());
        parcel.writeInt(this.s.w1());
        parcel.writeInt(this.s.h1());
    }

    public CalendarDay(Parcel parcel) {
        this(parcel.readInt(), parcel.readInt(), parcel.readInt());
    }

    private CalendarDay(@NonNull LocalDate localDate) {
        this.s = localDate;
    }
}
