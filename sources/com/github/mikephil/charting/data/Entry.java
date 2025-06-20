package com.github.mikephil.charting.data;

import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.ParcelFormatException;
import android.os.Parcelable;
import com.github.mikephil.charting.utils.Utils;

public class Entry extends BaseEntry implements Parcelable {
    public static final Parcelable.Creator<Entry> CREATOR = new Parcelable.Creator<Entry>() {
        /* renamed from: a */
        public Entry createFromParcel(Parcel parcel) {
            return new Entry(parcel);
        }

        /* renamed from: b */
        public Entry[] newArray(int i2) {
            return new Entry[i2];
        }
    };
    private float Z;

    public Entry() {
        this.Z = 0.0f;
    }

    public int describeContents() {
        return 0;
    }

    public Entry k() {
        return new Entry(this.Z, c(), a());
    }

    public boolean l(Entry entry) {
        if (entry == null || entry.a() != a()) {
            return false;
        }
        float abs = Math.abs(entry.Z - this.Z);
        float f2 = Utils.f19169g;
        return abs <= f2 && Math.abs(entry.c() - c()) <= f2;
    }

    public float m() {
        return this.Z;
    }

    public void o(float f2) {
        this.Z = f2;
    }

    public String toString() {
        return "Entry, x: " + this.Z + " y: " + c();
    }

    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeFloat(this.Z);
        parcel.writeFloat(c());
        if (a() == null) {
            parcel.writeInt(0);
        } else if (a() instanceof Parcelable) {
            parcel.writeInt(1);
            parcel.writeParcelable((Parcelable) a(), i2);
        } else {
            throw new ParcelFormatException("Cannot parcel an Entry with non-parcelable data");
        }
    }

    public Entry(float f2, float f3) {
        super(f3);
        this.Z = f2;
    }

    public Entry(float f2, float f3, Drawable drawable) {
        super(f3, drawable);
        this.Z = f2;
    }

    public Entry(float f2, float f3, Drawable drawable, Object obj) {
        super(f3, drawable, obj);
        this.Z = f2;
    }

    public Entry(float f2, float f3, Object obj) {
        super(f3, obj);
        this.Z = f2;
    }

    protected Entry(Parcel parcel) {
        this.Z = 0.0f;
        this.Z = parcel.readFloat();
        j(parcel.readFloat());
        if (parcel.readInt() == 1) {
            d(parcel.readParcelable(Object.class.getClassLoader()));
        }
    }
}
