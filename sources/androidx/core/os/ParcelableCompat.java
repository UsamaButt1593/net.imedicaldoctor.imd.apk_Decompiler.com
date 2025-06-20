package androidx.core.os;

import android.os.Parcel;
import android.os.Parcelable;

@Deprecated
public final class ParcelableCompat {

    static class ParcelableCompatCreatorHoneycombMR2<T> implements Parcelable.ClassLoaderCreator<T> {

        /* renamed from: a  reason: collision with root package name */
        private final ParcelableCompatCreatorCallbacks<T> f6070a;

        ParcelableCompatCreatorHoneycombMR2(ParcelableCompatCreatorCallbacks<T> parcelableCompatCreatorCallbacks) {
            this.f6070a = parcelableCompatCreatorCallbacks;
        }

        public T createFromParcel(Parcel parcel) {
            return this.f6070a.createFromParcel(parcel, (ClassLoader) null);
        }

        public T[] newArray(int i2) {
            return this.f6070a.newArray(i2);
        }

        public T createFromParcel(Parcel parcel, ClassLoader classLoader) {
            return this.f6070a.createFromParcel(parcel, classLoader);
        }
    }

    private ParcelableCompat() {
    }

    @Deprecated
    public static <T> Parcelable.Creator<T> a(ParcelableCompatCreatorCallbacks<T> parcelableCompatCreatorCallbacks) {
        return new ParcelableCompatCreatorHoneycombMR2(parcelableCompatCreatorCallbacks);
    }
}
