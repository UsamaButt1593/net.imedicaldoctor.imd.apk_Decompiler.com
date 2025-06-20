package androidx.core.graphics.drawable;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

final class WrappedDrawableState extends Drawable.ConstantState {

    /* renamed from: a  reason: collision with root package name */
    int f5927a;

    /* renamed from: b  reason: collision with root package name */
    Drawable.ConstantState f5928b;

    /* renamed from: c  reason: collision with root package name */
    ColorStateList f5929c = null;

    /* renamed from: d  reason: collision with root package name */
    PorterDuff.Mode f5930d = WrappedDrawableApi14.Z2;

    WrappedDrawableState(@Nullable WrappedDrawableState wrappedDrawableState) {
        if (wrappedDrawableState != null) {
            this.f5927a = wrappedDrawableState.f5927a;
            this.f5928b = wrappedDrawableState.f5928b;
            this.f5929c = wrappedDrawableState.f5929c;
            this.f5930d = wrappedDrawableState.f5930d;
        }
    }

    /* access modifiers changed from: package-private */
    public boolean a() {
        return this.f5928b != null;
    }

    public int getChangingConfigurations() {
        int i2 = this.f5927a;
        Drawable.ConstantState constantState = this.f5928b;
        return i2 | (constantState != null ? constantState.getChangingConfigurations() : 0);
    }

    @NonNull
    public Drawable newDrawable() {
        return newDrawable((Resources) null);
    }

    @NonNull
    public Drawable newDrawable(@Nullable Resources resources) {
        return new WrappedDrawableApi21(this, resources);
    }
}
