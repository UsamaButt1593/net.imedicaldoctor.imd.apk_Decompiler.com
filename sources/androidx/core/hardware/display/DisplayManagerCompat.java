package androidx.core.hardware.display;

import android.content.Context;
import android.hardware.display.DisplayManager;
import android.view.Display;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public final class DisplayManagerCompat {

    /* renamed from: b  reason: collision with root package name */
    public static final String f5931b = "android.hardware.display.category.PRESENTATION";

    /* renamed from: a  reason: collision with root package name */
    private final Context f5932a;

    private DisplayManagerCompat(Context context) {
        this.f5932a = context;
    }

    @NonNull
    public static DisplayManagerCompat d(@NonNull Context context) {
        return new DisplayManagerCompat(context);
    }

    @Nullable
    public Display a(int i2) {
        return ((DisplayManager) this.f5932a.getSystemService("display")).getDisplay(i2);
    }

    @NonNull
    public Display[] b() {
        return ((DisplayManager) this.f5932a.getSystemService("display")).getDisplays();
    }

    @NonNull
    public Display[] c(@Nullable String str) {
        return ((DisplayManager) this.f5932a.getSystemService("display")).getDisplays();
    }
}
