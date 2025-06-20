package com.google.android.material.sidesheet;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.GravityInt;
import androidx.annotation.IdRes;
import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StyleRes;
import com.google.android.material.R;

public class SideSheetDialog extends SheetDialog<SideSheetCallback> {
    private static final int i3 = R.attr.wg;
    private static final int j3 = R.style.sc;

    public SideSheetDialog(@NonNull Context context) {
        this(context, 0);
    }

    public /* bridge */ /* synthetic */ boolean C() {
        return super.C();
    }

    public /* bridge */ /* synthetic */ void F(boolean z) {
        super.F(z);
    }

    public /* bridge */ /* synthetic */ void G(@GravityInt int i2) {
        super.G(i2);
    }

    @NonNull
    /* renamed from: K */
    public SideSheetBehavior<? extends View> s() {
        Sheet s = super.s();
        if (s instanceof SideSheetBehavior) {
            return (SideSheetBehavior) s;
        }
        throw new IllegalStateException("The view is not associated with SideSheetBehavior");
    }

    public /* bridge */ /* synthetic */ void cancel() {
        super.cancel();
    }

    public /* bridge */ /* synthetic */ void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    public /* bridge */ /* synthetic */ void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }

    /* access modifiers changed from: package-private */
    public void q(Sheet<SideSheetCallback> sheet) {
        sheet.a(new SideSheetCallback() {
            public void a(@NonNull View view, int i2) {
                if (i2 == 5) {
                    SideSheetDialog.this.cancel();
                }
            }

            public void b(@NonNull View view, float f2) {
            }
        });
    }

    public /* bridge */ /* synthetic */ void setCancelable(boolean z) {
        super.setCancelable(z);
    }

    public /* bridge */ /* synthetic */ void setCanceledOnTouchOutside(boolean z) {
        super.setCanceledOnTouchOutside(z);
    }

    public /* bridge */ /* synthetic */ void setContentView(@LayoutRes int i2) {
        super.setContentView(i2);
    }

    /* access modifiers changed from: package-private */
    @NonNull
    public Sheet<SideSheetCallback> t(@NonNull FrameLayout frameLayout) {
        return SideSheetBehavior.j0(frameLayout);
    }

    /* access modifiers changed from: package-private */
    @IdRes
    public int v() {
        return R.id.x2;
    }

    /* access modifiers changed from: package-private */
    @LayoutRes
    public int w() {
        return R.layout.Y;
    }

    /* access modifiers changed from: package-private */
    public int z() {
        return 3;
    }

    public SideSheetDialog(@NonNull Context context, @StyleRes int i2) {
        super(context, i2, i3, j3);
    }

    public /* bridge */ /* synthetic */ void setContentView(@Nullable View view) {
        super.setContentView(view);
    }

    public /* bridge */ /* synthetic */ void setContentView(@Nullable View view, @Nullable ViewGroup.LayoutParams layoutParams) {
        super.setContentView(view, layoutParams);
    }
}
