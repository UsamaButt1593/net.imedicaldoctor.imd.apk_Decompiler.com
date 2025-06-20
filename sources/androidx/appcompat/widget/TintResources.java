package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import androidx.annotation.NonNull;
import java.lang.ref.WeakReference;

class TintResources extends ResourcesWrapper {

    /* renamed from: b  reason: collision with root package name */
    private final WeakReference<Context> f3316b;

    public TintResources(@NonNull Context context, @NonNull Resources resources) {
        super(resources);
        this.f3316b = new WeakReference<>(context);
    }

    public Drawable getDrawable(int i2) throws Resources.NotFoundException {
        Drawable a2 = a(i2);
        Context context = this.f3316b.get();
        if (!(a2 == null || context == null)) {
            ResourceManagerInternal.h().x(context, i2, a2);
        }
        return a2;
    }
}
