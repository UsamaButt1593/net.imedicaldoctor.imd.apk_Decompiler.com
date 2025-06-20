package com.google.android.material.shape;

import android.graphics.Outline;
import android.graphics.RectF;
import android.view.View;
import android.view.ViewOutlineProvider;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.annotation.VisibleForTesting;

@RequiresApi(22)
class ShapeableDelegateV22 extends ShapeableDelegate {

    /* renamed from: f  reason: collision with root package name */
    private boolean f21914f = false;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public float f21915g = 0.0f;

    ShapeableDelegateV22(@NonNull View view) {
        o(view);
    }

    private float n() {
        RectF rectF;
        ShapeAppearanceModel shapeAppearanceModel = this.f21911c;
        if (shapeAppearanceModel == null || (rectF = this.f21912d) == null) {
            return 0.0f;
        }
        return shapeAppearanceModel.f21828f.a(rectF);
    }

    @DoNotInline
    private void o(View view) {
        view.setOutlineProvider(new ViewOutlineProvider() {
            public void getOutline(View view, Outline outline) {
                ShapeableDelegateV22 shapeableDelegateV22 = ShapeableDelegateV22.this;
                if (shapeableDelegateV22.f21911c != null && !shapeableDelegateV22.f21912d.isEmpty()) {
                    ShapeableDelegateV22 shapeableDelegateV222 = ShapeableDelegateV22.this;
                    RectF rectF = shapeableDelegateV222.f21912d;
                    outline.setRoundRect((int) rectF.left, (int) rectF.top, (int) rectF.right, (int) rectF.bottom, shapeableDelegateV222.f21915g);
                }
            }
        });
    }

    private boolean p() {
        ShapeAppearanceModel shapeAppearanceModel;
        if (this.f21912d.isEmpty() || (shapeAppearanceModel = this.f21911c) == null) {
            return false;
        }
        return shapeAppearanceModel.u(this.f21912d);
    }

    private boolean q() {
        ShapeAppearanceModel shapeAppearanceModel;
        RectF rectF;
        float f2;
        float f3;
        float f4;
        float f5;
        if (!this.f21912d.isEmpty() && (shapeAppearanceModel = this.f21911c) != null && this.f21910b && !shapeAppearanceModel.u(this.f21912d) && r(this.f21911c)) {
            float a2 = this.f21911c.r().a(this.f21912d);
            float a3 = this.f21911c.t().a(this.f21912d);
            float a4 = this.f21911c.j().a(this.f21912d);
            float a5 = this.f21911c.l().a(this.f21912d);
            int i2 = (a2 > 0.0f ? 1 : (a2 == 0.0f ? 0 : -1));
            if (i2 == 0 && a4 == 0.0f && a3 == a5) {
                RectF rectF2 = this.f21912d;
                rectF2.set(rectF2.left - a3, rectF2.top, rectF2.right, rectF2.bottom);
                this.f21915g = a3;
                return true;
            } else if (i2 == 0 && a3 == 0.0f && a4 == a5) {
                RectF rectF3 = this.f21912d;
                rectF3.set(rectF3.left, rectF3.top - a4, rectF3.right, rectF3.bottom);
                this.f21915g = a4;
                return true;
            } else {
                if (a3 == 0.0f && a5 == 0.0f && a2 == a4) {
                    rectF = this.f21912d;
                    f2 = rectF.left;
                    f3 = rectF.top;
                    f4 = rectF.right + a2;
                    f5 = rectF.bottom;
                } else if (a4 == 0.0f && a5 == 0.0f && a2 == a3) {
                    rectF = this.f21912d;
                    f2 = rectF.left;
                    f3 = rectF.top;
                    f4 = rectF.right;
                    f5 = rectF.bottom + a2;
                }
                rectF.set(f2, f3, f4, f5);
                this.f21915g = a2;
                return true;
            }
        }
        return false;
    }

    private static boolean r(ShapeAppearanceModel shapeAppearanceModel) {
        return (shapeAppearanceModel.q() instanceof RoundedCornerTreatment) && (shapeAppearanceModel.s() instanceof RoundedCornerTreatment) && (shapeAppearanceModel.i() instanceof RoundedCornerTreatment) && (shapeAppearanceModel.k() instanceof RoundedCornerTreatment);
    }

    /* access modifiers changed from: package-private */
    public void b(@NonNull View view) {
        this.f21915g = n();
        this.f21914f = p() || q();
        view.setClipToOutline(!j());
        if (j()) {
            view.invalidate();
        } else {
            view.invalidateOutline();
        }
    }

    /* access modifiers changed from: package-private */
    public boolean j() {
        return !this.f21914f || this.f21909a;
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    public float m() {
        return this.f21915g;
    }
}
