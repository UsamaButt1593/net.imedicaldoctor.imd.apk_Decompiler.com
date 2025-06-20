package androidx.activity.result;

import android.annotation.SuppressLint;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityOptionsCompat;

public abstract class ActivityResultLauncher<I> {
    @NonNull
    public abstract ActivityResultContract<I, ?> a();

    public void b(@SuppressLint({"UnknownNullness"}) I i2) {
        c(i2, (ActivityOptionsCompat) null);
    }

    public abstract void c(@SuppressLint({"UnknownNullness"}) I i2, @Nullable ActivityOptionsCompat activityOptionsCompat);

    @MainThread
    public abstract void d();
}
