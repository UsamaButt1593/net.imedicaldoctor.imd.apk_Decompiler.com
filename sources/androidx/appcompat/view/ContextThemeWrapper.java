package androidx.appcompat.view;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.AssetManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.view.LayoutInflater;
import androidx.annotation.RequiresApi;
import androidx.annotation.StyleRes;
import androidx.appcompat.R;

public class ContextThemeWrapper extends ContextWrapper {

    /* renamed from: f  reason: collision with root package name */
    private static Configuration f2906f;

    /* renamed from: a  reason: collision with root package name */
    private int f2907a;

    /* renamed from: b  reason: collision with root package name */
    private Resources.Theme f2908b;

    /* renamed from: c  reason: collision with root package name */
    private LayoutInflater f2909c;

    /* renamed from: d  reason: collision with root package name */
    private Configuration f2910d;

    /* renamed from: e  reason: collision with root package name */
    private Resources f2911e;

    public ContextThemeWrapper() {
        super((Context) null);
    }

    private Resources b() {
        if (this.f2911e == null) {
            Configuration configuration = this.f2910d;
            this.f2911e = (configuration == null || (Build.VERSION.SDK_INT >= 26 && e(configuration))) ? super.getResources() : createConfigurationContext(this.f2910d).getResources();
        }
        return this.f2911e;
    }

    private void d() {
        boolean z = this.f2908b == null;
        if (z) {
            this.f2908b = getResources().newTheme();
            Resources.Theme theme = getBaseContext().getTheme();
            if (theme != null) {
                this.f2908b.setTo(theme);
            }
        }
        f(this.f2908b, this.f2907a, z);
    }

    @RequiresApi(26)
    private static boolean e(Configuration configuration) {
        if (configuration == null) {
            return true;
        }
        if (f2906f == null) {
            Configuration configuration2 = new Configuration();
            configuration2.fontScale = 0.0f;
            f2906f = configuration2;
        }
        return configuration.equals(f2906f);
    }

    public void a(Configuration configuration) {
        if (this.f2911e != null) {
            throw new IllegalStateException("getResources() or getAssets() has already been called");
        } else if (this.f2910d == null) {
            this.f2910d = new Configuration(configuration);
        } else {
            throw new IllegalStateException("Override configuration has already been set");
        }
    }

    /* access modifiers changed from: protected */
    public void attachBaseContext(Context context) {
        super.attachBaseContext(context);
    }

    public int c() {
        return this.f2907a;
    }

    /* access modifiers changed from: protected */
    public void f(Resources.Theme theme, int i2, boolean z) {
        theme.applyStyle(i2, true);
    }

    public AssetManager getAssets() {
        return getResources().getAssets();
    }

    public Resources getResources() {
        return b();
    }

    public Object getSystemService(String str) {
        if (!"layout_inflater".equals(str)) {
            return getBaseContext().getSystemService(str);
        }
        if (this.f2909c == null) {
            this.f2909c = LayoutInflater.from(getBaseContext()).cloneInContext(this);
        }
        return this.f2909c;
    }

    public Resources.Theme getTheme() {
        Resources.Theme theme = this.f2908b;
        if (theme != null) {
            return theme;
        }
        if (this.f2907a == 0) {
            this.f2907a = R.style.c4;
        }
        d();
        return this.f2908b;
    }

    public void setTheme(int i2) {
        if (this.f2907a != i2) {
            this.f2907a = i2;
            d();
        }
    }

    public ContextThemeWrapper(Context context, @StyleRes int i2) {
        super(context);
        this.f2907a = i2;
    }

    public ContextThemeWrapper(Context context, Resources.Theme theme) {
        super(context);
        this.f2908b = theme;
    }
}
