package androidx.appcompat.view;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import androidx.annotation.RestrictTo;
import androidx.appcompat.R;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class ActionBarPolicy {

    /* renamed from: a  reason: collision with root package name */
    private Context f2905a;

    private ActionBarPolicy(Context context) {
        this.f2905a = context;
    }

    public static ActionBarPolicy b(Context context) {
        return new ActionBarPolicy(context);
    }

    public boolean a() {
        return this.f2905a.getApplicationInfo().targetSdkVersion < 14;
    }

    public int c() {
        return this.f2905a.getResources().getDisplayMetrics().widthPixels / 2;
    }

    public int d() {
        Configuration configuration = this.f2905a.getResources().getConfiguration();
        int i2 = configuration.screenWidthDp;
        int i3 = configuration.screenHeightDp;
        if (configuration.smallestScreenWidthDp > 600 || i2 > 600) {
            return 5;
        }
        if (i2 > 960 && i3 > 720) {
            return 5;
        }
        if (i2 > 720 && i3 > 960) {
            return 5;
        }
        if (i2 >= 500) {
            return 4;
        }
        if (i2 > 640 && i3 > 480) {
            return 4;
        }
        if (i2 <= 480 || i3 <= 640) {
            return i2 >= 360 ? 3 : 2;
        }
        return 4;
    }

    public int e() {
        return this.f2905a.getResources().getDimensionPixelSize(R.dimen.f2591k);
    }

    public int f() {
        TypedArray obtainStyledAttributes = this.f2905a.obtainStyledAttributes((AttributeSet) null, R.styleable.f2676a, R.attr.f2556f, 0);
        int layoutDimension = obtainStyledAttributes.getLayoutDimension(R.styleable.o, 0);
        Resources resources = this.f2905a.getResources();
        if (!g()) {
            layoutDimension = Math.min(layoutDimension, resources.getDimensionPixelSize(R.dimen.f2590j));
        }
        obtainStyledAttributes.recycle();
        return layoutDimension;
    }

    public boolean g() {
        return this.f2905a.getResources().getBoolean(R.bool.f2565a);
    }

    public boolean h() {
        return true;
    }
}
