package androidx.viewpager2.adapter;

import android.os.Parcelable;
import androidx.annotation.NonNull;

public interface StatefulAdapter {
    @NonNull
    Parcelable a();

    void d(@NonNull Parcelable parcelable);
}
