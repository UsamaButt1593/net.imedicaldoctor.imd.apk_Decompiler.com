package com.google.android.material.datepicker;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.util.ObjectsCompat;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.Arrays;
import java.util.Objects;

public final class CalendarConstraints implements Parcelable {
    public static final Parcelable.Creator<CalendarConstraints> CREATOR = new Parcelable.Creator<CalendarConstraints>() {
        @NonNull
        /* renamed from: a */
        public CalendarConstraints createFromParcel(@NonNull Parcel parcel) {
            Class<Month> cls = Month.class;
            return new CalendarConstraints((Month) parcel.readParcelable(cls.getClassLoader()), (Month) parcel.readParcelable(cls.getClassLoader()), (DateValidator) parcel.readParcelable(DateValidator.class.getClassLoader()), (Month) parcel.readParcelable(cls.getClassLoader()), parcel.readInt());
        }

        @NonNull
        /* renamed from: b */
        public CalendarConstraints[] newArray(int i2) {
            return new CalendarConstraints[i2];
        }
    };
    /* access modifiers changed from: private */
    @NonNull
    public final Month X;
    /* access modifiers changed from: private */
    public final int X2;
    /* access modifiers changed from: private */
    @NonNull
    public final DateValidator Y;
    private final int Y2;
    /* access modifiers changed from: private */
    @Nullable
    public Month Z;
    private final int Z2;
    /* access modifiers changed from: private */
    @NonNull
    public final Month s;

    public static final class Builder {

        /* renamed from: f  reason: collision with root package name */
        static final long f21327f = UtcDates.a(Month.b(1900, 0).Y2);

        /* renamed from: g  reason: collision with root package name */
        static final long f21328g = UtcDates.a(Month.b(2100, 11).Y2);

        /* renamed from: h  reason: collision with root package name */
        private static final String f21329h = "DEEP_COPY_VALIDATOR_KEY";

        /* renamed from: a  reason: collision with root package name */
        private long f21330a = f21327f;

        /* renamed from: b  reason: collision with root package name */
        private long f21331b = f21328g;

        /* renamed from: c  reason: collision with root package name */
        private Long f21332c;

        /* renamed from: d  reason: collision with root package name */
        private int f21333d;

        /* renamed from: e  reason: collision with root package name */
        private DateValidator f21334e = DateValidatorPointForward.a(Long.MIN_VALUE);

        public Builder() {
        }

        @NonNull
        public CalendarConstraints a() {
            Bundle bundle = new Bundle();
            bundle.putParcelable(f21329h, this.f21334e);
            Month c2 = Month.c(this.f21330a);
            Month c3 = Month.c(this.f21331b);
            DateValidator dateValidator = (DateValidator) bundle.getParcelable(f21329h);
            Long l2 = this.f21332c;
            return new CalendarConstraints(c2, c3, dateValidator, l2 == null ? null : Month.c(l2.longValue()), this.f21333d);
        }

        @NonNull
        @CanIgnoreReturnValue
        public Builder b(long j2) {
            this.f21331b = j2;
            return this;
        }

        @NonNull
        @CanIgnoreReturnValue
        public Builder c(int i2) {
            this.f21333d = i2;
            return this;
        }

        @NonNull
        @CanIgnoreReturnValue
        public Builder d(long j2) {
            this.f21332c = Long.valueOf(j2);
            return this;
        }

        @NonNull
        @CanIgnoreReturnValue
        public Builder e(long j2) {
            this.f21330a = j2;
            return this;
        }

        @NonNull
        @CanIgnoreReturnValue
        public Builder f(@NonNull DateValidator dateValidator) {
            Objects.requireNonNull(dateValidator, "validator cannot be null");
            this.f21334e = dateValidator;
            return this;
        }

        Builder(@NonNull CalendarConstraints calendarConstraints) {
            this.f21330a = calendarConstraints.s.Y2;
            this.f21331b = calendarConstraints.X.Y2;
            this.f21332c = Long.valueOf(calendarConstraints.Z.Y2);
            this.f21333d = calendarConstraints.X2;
            this.f21334e = calendarConstraints.Y;
        }
    }

    public interface DateValidator extends Parcelable {
        boolean y(long j2);
    }

    private CalendarConstraints(@NonNull Month month, @NonNull Month month2, @NonNull DateValidator dateValidator, @Nullable Month month3, int i2) {
        Objects.requireNonNull(month, "start cannot be null");
        Objects.requireNonNull(month2, "end cannot be null");
        Objects.requireNonNull(dateValidator, "validator cannot be null");
        this.s = month;
        this.X = month2;
        this.Z = month3;
        this.X2 = i2;
        this.Y = dateValidator;
        if (month3 != null && month.compareTo(month3) > 0) {
            throw new IllegalArgumentException("start Month cannot be after current Month");
        } else if (month3 != null && month3.compareTo(month2) > 0) {
            throw new IllegalArgumentException("current Month cannot be after end Month");
        } else if (i2 < 0 || i2 > UtcDates.x().getMaximum(7)) {
            throw new IllegalArgumentException("firstDayOfWeek is not valid");
        } else {
            this.Z2 = month.v(month2) + 1;
            this.Y2 = (month2.Y - month.Y) + 1;
        }
    }

    public long B() {
        return this.s.Y2;
    }

    /* access modifiers changed from: package-private */
    public int C() {
        return this.Y2;
    }

    /* access modifiers changed from: package-private */
    public boolean D(long j2) {
        if (this.s.k(1) <= j2) {
            Month month = this.X;
            if (j2 <= month.k(month.X2)) {
                return true;
            }
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public void E(@Nullable Month month) {
        this.Z = month;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CalendarConstraints)) {
            return false;
        }
        CalendarConstraints calendarConstraints = (CalendarConstraints) obj;
        return this.s.equals(calendarConstraints.s) && this.X.equals(calendarConstraints.X) && ObjectsCompat.a(this.Z, calendarConstraints.Z) && this.X2 == calendarConstraints.X2 && this.Y.equals(calendarConstraints.Y);
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.s, this.X, this.Z, Integer.valueOf(this.X2), this.Y});
    }

    /* access modifiers changed from: package-private */
    public Month j(Month month) {
        if (month.compareTo(this.s) < 0) {
            return this.s;
        }
        return month.compareTo(this.X) > 0 ? this.X : month;
    }

    public DateValidator k() {
        return this.Y;
    }

    /* access modifiers changed from: package-private */
    @NonNull
    public Month l() {
        return this.X;
    }

    public long m() {
        return this.X.Y2;
    }

    /* access modifiers changed from: package-private */
    public int o() {
        return this.X2;
    }

    /* access modifiers changed from: package-private */
    public int p() {
        return this.Z2;
    }

    /* access modifiers changed from: package-private */
    @Nullable
    public Month t() {
        return this.Z;
    }

    @Nullable
    public Long v() {
        Month month = this.Z;
        if (month == null) {
            return null;
        }
        return Long.valueOf(month.Y2);
    }

    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeParcelable(this.s, 0);
        parcel.writeParcelable(this.X, 0);
        parcel.writeParcelable(this.Z, 0);
        parcel.writeParcelable(this.Y, 0);
        parcel.writeInt(this.X2);
    }

    /* access modifiers changed from: package-private */
    @NonNull
    public Month z() {
        return this.s;
    }
}
