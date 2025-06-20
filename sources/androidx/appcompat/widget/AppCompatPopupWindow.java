package androidx.appcompat.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.PopupWindow;
import androidx.annotation.AttrRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StyleRes;
import androidx.appcompat.R;
import androidx.core.widget.PopupWindowCompat;

class AppCompatPopupWindow extends PopupWindow {

    /* renamed from: b  reason: collision with root package name */
    private static final boolean f3115b = false;

    /* renamed from: a  reason: collision with root package name */
    private boolean f3116a;

    public AppCompatPopupWindow(@NonNull Context context, @Nullable AttributeSet attributeSet, @AttrRes int i2) {
        super(context, attributeSet, i2);
        a(context, attributeSet, i2, 0);
    }

    private void a(Context context, AttributeSet attributeSet, int i2, int i3) {
        TintTypedArray G = TintTypedArray.G(context, attributeSet, R.styleable.S4, i2, i3);
        int i4 = R.styleable.V4;
        if (G.C(i4)) {
            b(G.a(i4, false));
        }
        setBackgroundDrawable(G.h(R.styleable.T4));
        G.I();
    }

    private void b(boolean z) {
        if (f3115b) {
            this.f3116a = z;
        } else {
            PopupWindowCompat.c(this, z);
        }
    }

    public void showAsDropDown(View view, int i2, int i3) {
        if (f3115b && this.f3116a) {
            i3 -= view.getHeight();
        }
        super.showAsDropDown(view, i2, i3);
    }

    public void update(View view, int i2, int i3, int i4, int i5) {
        if (f3115b && this.f3116a) {
            i3 -= view.getHeight();
        }
        super.update(view, i2, i3, i4, i5);
    }

    public AppCompatPopupWindow(@NonNull Context context, @Nullable AttributeSet attributeSet, @AttrRes int i2, @StyleRes int i3) {
        super(context, attributeSet, i2, i3);
        a(context, attributeSet, i2, i3);
    }

    public void showAsDropDown(View view, int i2, int i3, int i4) {
        if (f3115b && this.f3116a) {
            i3 -= view.getHeight();
        }
        super.showAsDropDown(view, i2, i3, i4);
    }
}
