package androidx.appcompat.widget;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.AssetManager;
import android.content.res.Resources;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class TintContextWrapper extends ContextWrapper {

    /* renamed from: c  reason: collision with root package name */
    private static final Object f3308c = new Object();

    /* renamed from: d  reason: collision with root package name */
    private static ArrayList<WeakReference<TintContextWrapper>> f3309d;

    /* renamed from: a  reason: collision with root package name */
    private final Resources f3310a;

    /* renamed from: b  reason: collision with root package name */
    private final Resources.Theme f3311b;

    private TintContextWrapper(@NonNull Context context) {
        super(context);
        if (VectorEnabledTintResources.d()) {
            VectorEnabledTintResources vectorEnabledTintResources = new VectorEnabledTintResources(this, context.getResources());
            this.f3310a = vectorEnabledTintResources;
            Resources.Theme newTheme = vectorEnabledTintResources.newTheme();
            this.f3311b = newTheme;
            newTheme.setTo(context.getTheme());
            return;
        }
        this.f3310a = new TintResources(this, context.getResources());
        this.f3311b = null;
    }

    private static boolean a(@NonNull Context context) {
        if ((context instanceof TintContextWrapper) || (context.getResources() instanceof TintResources) || (context.getResources() instanceof VectorEnabledTintResources)) {
            return false;
        }
        return VectorEnabledTintResources.d();
    }

    public static Context b(@NonNull Context context) {
        if (!a(context)) {
            return context;
        }
        synchronized (f3308c) {
            try {
                ArrayList<WeakReference<TintContextWrapper>> arrayList = f3309d;
                if (arrayList == null) {
                    f3309d = new ArrayList<>();
                } else {
                    for (int size = arrayList.size() - 1; size >= 0; size--) {
                        WeakReference weakReference = f3309d.get(size);
                        if (weakReference == null || weakReference.get() == null) {
                            f3309d.remove(size);
                        }
                    }
                    for (int size2 = f3309d.size() - 1; size2 >= 0; size2--) {
                        WeakReference weakReference2 = f3309d.get(size2);
                        TintContextWrapper tintContextWrapper = weakReference2 != null ? (TintContextWrapper) weakReference2.get() : null;
                        if (tintContextWrapper != null && tintContextWrapper.getBaseContext() == context) {
                            return tintContextWrapper;
                        }
                    }
                }
                TintContextWrapper tintContextWrapper2 = new TintContextWrapper(context);
                f3309d.add(new WeakReference(tintContextWrapper2));
                return tintContextWrapper2;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public AssetManager getAssets() {
        return this.f3310a.getAssets();
    }

    public Resources getResources() {
        return this.f3310a;
    }

    public Resources.Theme getTheme() {
        Resources.Theme theme = this.f3311b;
        return theme == null ? super.getTheme() : theme;
    }

    public void setTheme(int i2) {
        Resources.Theme theme = this.f3311b;
        if (theme == null) {
            super.setTheme(i2);
        } else {
            theme.applyStyle(i2, true);
        }
    }
}
