package androidx.appcompat.widget;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Resources;
import android.graphics.Rect;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.appcompat.R;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
class TooltipPopup {

    /* renamed from: h  reason: collision with root package name */
    private static final String f3356h = "TooltipPopup";

    /* renamed from: a  reason: collision with root package name */
    private final Context f3357a;

    /* renamed from: b  reason: collision with root package name */
    private final View f3358b;

    /* renamed from: c  reason: collision with root package name */
    private final TextView f3359c;

    /* renamed from: d  reason: collision with root package name */
    private final WindowManager.LayoutParams f3360d;

    /* renamed from: e  reason: collision with root package name */
    private final Rect f3361e = new Rect();

    /* renamed from: f  reason: collision with root package name */
    private final int[] f3362f = new int[2];

    /* renamed from: g  reason: collision with root package name */
    private final int[] f3363g = new int[2];

    TooltipPopup(@NonNull Context context) {
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        this.f3360d = layoutParams;
        this.f3357a = context;
        View inflate = LayoutInflater.from(context).inflate(R.layout.B, (ViewGroup) null);
        this.f3358b = inflate;
        this.f3359c = (TextView) inflate.findViewById(R.id.I);
        layoutParams.setTitle(getClass().getSimpleName());
        layoutParams.packageName = context.getPackageName();
        layoutParams.type = 1002;
        layoutParams.width = -2;
        layoutParams.height = -2;
        layoutParams.format = -3;
        layoutParams.windowAnimations = R.style.f2666e;
        layoutParams.flags = 24;
    }

    private void a(View view, int i2, int i3, boolean z, WindowManager.LayoutParams layoutParams) {
        int i4;
        int i5;
        layoutParams.token = view.getApplicationWindowToken();
        int dimensionPixelOffset = this.f3357a.getResources().getDimensionPixelOffset(R.dimen.Q0);
        if (view.getWidth() < dimensionPixelOffset) {
            i2 = view.getWidth() / 2;
        }
        if (view.getHeight() >= dimensionPixelOffset) {
            int dimensionPixelOffset2 = this.f3357a.getResources().getDimensionPixelOffset(R.dimen.P0);
            i5 = i3 + dimensionPixelOffset2;
            i4 = i3 - dimensionPixelOffset2;
        } else {
            i5 = view.getHeight();
            i4 = 0;
        }
        layoutParams.gravity = 49;
        int dimensionPixelOffset3 = this.f3357a.getResources().getDimensionPixelOffset(z ? R.dimen.T0 : R.dimen.S0);
        View b2 = b(view);
        if (b2 == null) {
            Log.e(f3356h, "Cannot find app view");
            return;
        }
        b2.getWindowVisibleDisplayFrame(this.f3361e);
        Rect rect = this.f3361e;
        if (rect.left < 0 && rect.top < 0) {
            Resources resources = this.f3357a.getResources();
            int identifier = resources.getIdentifier("status_bar_height", "dimen", "android");
            int dimensionPixelSize = identifier != 0 ? resources.getDimensionPixelSize(identifier) : 0;
            DisplayMetrics displayMetrics = resources.getDisplayMetrics();
            this.f3361e.set(0, dimensionPixelSize, displayMetrics.widthPixels, displayMetrics.heightPixels);
        }
        b2.getLocationOnScreen(this.f3363g);
        view.getLocationOnScreen(this.f3362f);
        int[] iArr = this.f3362f;
        int i6 = iArr[0];
        int[] iArr2 = this.f3363g;
        int i7 = i6 - iArr2[0];
        iArr[0] = i7;
        iArr[1] = iArr[1] - iArr2[1];
        layoutParams.x = (i7 + i2) - (b2.getWidth() / 2);
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        this.f3358b.measure(makeMeasureSpec, makeMeasureSpec);
        int measuredHeight = this.f3358b.getMeasuredHeight();
        int i8 = this.f3362f[1];
        int i9 = ((i4 + i8) - dimensionPixelOffset3) - measuredHeight;
        int i10 = i8 + i5 + dimensionPixelOffset3;
        if (!z ? measuredHeight + i10 > this.f3361e.height() : i9 >= 0) {
            layoutParams.y = i9;
        } else {
            layoutParams.y = i10;
        }
    }

    private static View b(View view) {
        View rootView = view.getRootView();
        ViewGroup.LayoutParams layoutParams = rootView.getLayoutParams();
        if ((layoutParams instanceof WindowManager.LayoutParams) && ((WindowManager.LayoutParams) layoutParams).type == 2) {
            return rootView;
        }
        for (Context context = view.getContext(); context instanceof ContextWrapper; context = ((ContextWrapper) context).getBaseContext()) {
            if (context instanceof Activity) {
                return ((Activity) context).getWindow().getDecorView();
            }
        }
        return rootView;
    }

    /* access modifiers changed from: package-private */
    public void c() {
        if (d()) {
            ((WindowManager) this.f3357a.getSystemService("window")).removeView(this.f3358b);
        }
    }

    /* access modifiers changed from: package-private */
    public boolean d() {
        return this.f3358b.getParent() != null;
    }

    /* access modifiers changed from: package-private */
    public void e(View view, int i2, int i3, boolean z, CharSequence charSequence) {
        if (d()) {
            c();
        }
        this.f3359c.setText(charSequence);
        a(view, i2, i3, z, this.f3360d);
        ((WindowManager) this.f3357a.getSystemService("window")).addView(this.f3358b, this.f3360d);
    }
}
