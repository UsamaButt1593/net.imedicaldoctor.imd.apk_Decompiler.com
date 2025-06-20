package com.google.android.material.datepicker;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.RippleDrawable;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StyleRes;
import androidx.core.util.Preconditions;
import androidx.core.view.ViewCompat;
import com.google.android.material.R;
import com.google.android.material.resources.MaterialResources;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.ShapeAppearanceModel;

final class CalendarItemStyle {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final Rect f21335a;

    /* renamed from: b  reason: collision with root package name */
    private final ColorStateList f21336b;

    /* renamed from: c  reason: collision with root package name */
    private final ColorStateList f21337c;

    /* renamed from: d  reason: collision with root package name */
    private final ColorStateList f21338d;

    /* renamed from: e  reason: collision with root package name */
    private final int f21339e;

    /* renamed from: f  reason: collision with root package name */
    private final ShapeAppearanceModel f21340f;

    private CalendarItemStyle(ColorStateList colorStateList, ColorStateList colorStateList2, ColorStateList colorStateList3, int i2, ShapeAppearanceModel shapeAppearanceModel, @NonNull Rect rect) {
        Preconditions.i(rect.left);
        Preconditions.i(rect.top);
        Preconditions.i(rect.right);
        Preconditions.i(rect.bottom);
        this.f21335a = rect;
        this.f21336b = colorStateList2;
        this.f21337c = colorStateList;
        this.f21338d = colorStateList3;
        this.f21339e = i2;
        this.f21340f = shapeAppearanceModel;
    }

    @NonNull
    static CalendarItemStyle a(@NonNull Context context, @StyleRes int i2) {
        Preconditions.b(i2 != 0, "Cannot create a CalendarItemStyle with a styleResId of 0");
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(i2, R.styleable.Rm);
        Rect rect = new Rect(obtainStyledAttributes.getDimensionPixelOffset(R.styleable.Sm, 0), obtainStyledAttributes.getDimensionPixelOffset(R.styleable.Um, 0), obtainStyledAttributes.getDimensionPixelOffset(R.styleable.Tm, 0), obtainStyledAttributes.getDimensionPixelOffset(R.styleable.Vm, 0));
        ColorStateList a2 = MaterialResources.a(context, obtainStyledAttributes, R.styleable.Wm);
        ColorStateList a3 = MaterialResources.a(context, obtainStyledAttributes, R.styleable.bn);
        ColorStateList a4 = MaterialResources.a(context, obtainStyledAttributes, R.styleable.Zm);
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(R.styleable.an, 0);
        ShapeAppearanceModel m2 = ShapeAppearanceModel.b(context, obtainStyledAttributes.getResourceId(R.styleable.Xm, 0), obtainStyledAttributes.getResourceId(R.styleable.Ym, 0)).m();
        obtainStyledAttributes.recycle();
        return new CalendarItemStyle(a2, a3, a4, dimensionPixelSize, m2, rect);
    }

    /* access modifiers changed from: package-private */
    public int b() {
        return this.f21335a.bottom;
    }

    /* access modifiers changed from: package-private */
    public int c() {
        return this.f21335a.left;
    }

    /* access modifiers changed from: package-private */
    public int d() {
        return this.f21335a.right;
    }

    /* access modifiers changed from: package-private */
    public int e() {
        return this.f21335a.top;
    }

    /* access modifiers changed from: package-private */
    public void f(@NonNull TextView textView) {
        g(textView, (ColorStateList) null, (ColorStateList) null);
    }

    /* access modifiers changed from: package-private */
    public void g(@NonNull TextView textView, @Nullable ColorStateList colorStateList, @Nullable ColorStateList colorStateList2) {
        MaterialShapeDrawable materialShapeDrawable = new MaterialShapeDrawable();
        MaterialShapeDrawable materialShapeDrawable2 = new MaterialShapeDrawable();
        materialShapeDrawable.setShapeAppearanceModel(this.f21340f);
        materialShapeDrawable2.setShapeAppearanceModel(this.f21340f);
        if (colorStateList == null) {
            colorStateList = this.f21337c;
        }
        materialShapeDrawable.p0(colorStateList);
        materialShapeDrawable.F0((float) this.f21339e, this.f21338d);
        if (colorStateList2 == null) {
            colorStateList2 = this.f21336b;
        }
        textView.setTextColor(colorStateList2);
        RippleDrawable rippleDrawable = new RippleDrawable(this.f21336b.withAlpha(30), materialShapeDrawable, materialShapeDrawable2);
        Rect rect = this.f21335a;
        ViewCompat.P1(textView, new InsetDrawable(rippleDrawable, rect.left, rect.top, rect.right, rect.bottom));
    }
}
