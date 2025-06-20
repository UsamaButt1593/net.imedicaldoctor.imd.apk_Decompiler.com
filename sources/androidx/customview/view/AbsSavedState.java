package androidx.customview.view;

import android.annotation.SuppressLint;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

@SuppressLint({"BanParcelableUsage"})
public abstract class AbsSavedState implements Parcelable {
    public static final Parcelable.Creator<AbsSavedState> CREATOR = new Parcelable.ClassLoaderCreator<AbsSavedState>() {
        /* renamed from: a */
        public AbsSavedState createFromParcel(Parcel parcel) {
            return createFromParcel(parcel, (ClassLoader) null);
        }

        /* renamed from: b */
        public AbsSavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
            if (parcel.readParcelable(classLoader) == null) {
                return AbsSavedState.X;
            }
            throw new IllegalStateException("superState must be null");
        }

        /* renamed from: c */
        public AbsSavedState[] newArray(int i2) {
            return new AbsSavedState[i2];
        }
    };
    public static final AbsSavedState X = new AbsSavedState() {
    };
    private final Parcelable s;

    private AbsSavedState() {
        this.s = null;
    }

    @Nullable
    public final Parcelable a() {
        return this.s;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeParcelable(this.s, i2);
    }

    protected AbsSavedState(@NonNull Parcel parcel) {
        this(parcel, (ClassLoader) null);
    }

    protected AbsSavedState(@NonNull Parcel parcel, @Nullable ClassLoader classLoader) {
        Parcelable readParcelable = parcel.readParcelable(classLoader);
        this.s = readParcelable == null ? X : readParcelable;
    }

    protected AbsSavedState(@NonNull Parcelable parcelable) {
        if (parcelable != null) {
            this.s = parcelable == X ? null : parcelable;
            return;
        }
        throw new IllegalArgumentException("superState must not be null");
    }
}
