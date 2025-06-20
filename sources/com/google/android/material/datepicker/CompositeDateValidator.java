package com.google.android.material.datepicker;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.core.util.Preconditions;
import com.google.android.material.datepicker.CalendarConstraints;
import java.util.ArrayList;
import java.util.List;

public final class CompositeDateValidator implements CalendarConstraints.DateValidator {
    public static final Parcelable.Creator<CompositeDateValidator> CREATOR = new Parcelable.Creator<CompositeDateValidator>() {
        @NonNull
        /* renamed from: a */
        public CompositeDateValidator createFromParcel(@NonNull Parcel parcel) {
            ArrayList readArrayList = parcel.readArrayList(CalendarConstraints.DateValidator.class.getClassLoader());
            int readInt = parcel.readInt();
            return new CompositeDateValidator((List) Preconditions.l(readArrayList), (readInt != 2 && readInt == 1) ? CompositeDateValidator.X2 : CompositeDateValidator.Y2);
        }

        @NonNull
        /* renamed from: b */
        public CompositeDateValidator[] newArray(int i2) {
            return new CompositeDateValidator[i2];
        }
    };
    /* access modifiers changed from: private */
    public static final Operator X2 = new Operator() {
        public boolean a(@NonNull List<CalendarConstraints.DateValidator> list, long j2) {
            for (CalendarConstraints.DateValidator next : list) {
                if (next != null && next.y(j2)) {
                    return true;
                }
            }
            return false;
        }

        public int getId() {
            return 1;
        }
    };
    private static final int Y = 1;
    /* access modifiers changed from: private */
    public static final Operator Y2 = new Operator() {
        public boolean a(@NonNull List<CalendarConstraints.DateValidator> list, long j2) {
            for (CalendarConstraints.DateValidator next : list) {
                if (next != null && !next.y(j2)) {
                    return false;
                }
            }
            return true;
        }

        public int getId() {
            return 2;
        }
    };
    private static final int Z = 2;
    @NonNull
    private final List<CalendarConstraints.DateValidator> X;
    @NonNull
    private final Operator s;

    private interface Operator {
        boolean a(@NonNull List<CalendarConstraints.DateValidator> list, long j2);

        int getId();
    }

    private CompositeDateValidator(@NonNull List<CalendarConstraints.DateValidator> list, Operator operator) {
        this.X = list;
        this.s = operator;
    }

    @NonNull
    public static CalendarConstraints.DateValidator c(@NonNull List<CalendarConstraints.DateValidator> list) {
        return new CompositeDateValidator(list, Y2);
    }

    @NonNull
    public static CalendarConstraints.DateValidator d(@NonNull List<CalendarConstraints.DateValidator> list) {
        return new CompositeDateValidator(list, X2);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CompositeDateValidator)) {
            return false;
        }
        CompositeDateValidator compositeDateValidator = (CompositeDateValidator) obj;
        return this.X.equals(compositeDateValidator.X) && this.s.getId() == compositeDateValidator.s.getId();
    }

    public int hashCode() {
        return this.X.hashCode();
    }

    public void writeToParcel(@NonNull Parcel parcel, int i2) {
        parcel.writeList(this.X);
        parcel.writeInt(this.s.getId());
    }

    public boolean y(long j2) {
        return this.s.a(this.X, j2);
    }
}
