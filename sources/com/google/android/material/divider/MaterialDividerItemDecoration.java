package com.google.android.material.divider;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.ColorInt;
import androidx.annotation.ColorRes;
import androidx.annotation.DimenRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.R;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.resources.MaterialResources;

public class MaterialDividerItemDecoration extends RecyclerView.ItemDecoration {

    /* renamed from: i  reason: collision with root package name */
    public static final int f21397i = 0;

    /* renamed from: j  reason: collision with root package name */
    public static final int f21398j = 1;

    /* renamed from: k  reason: collision with root package name */
    private static final int f21399k = R.style.Lj;
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private Drawable f21400a;

    /* renamed from: b  reason: collision with root package name */
    private int f21401b;
    @ColorInt

    /* renamed from: c  reason: collision with root package name */
    private int f21402c;

    /* renamed from: d  reason: collision with root package name */
    private int f21403d;

    /* renamed from: e  reason: collision with root package name */
    private int f21404e;

    /* renamed from: f  reason: collision with root package name */
    private int f21405f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f21406g;

    /* renamed from: h  reason: collision with root package name */
    private final Rect f21407h;

    public MaterialDividerItemDecoration(@NonNull Context context, int i2) {
        this(context, (AttributeSet) null, i2);
    }

    private boolean E(@NonNull RecyclerView recyclerView, @NonNull View view) {
        int u0 = recyclerView.u0(view);
        RecyclerView.Adapter adapter = recyclerView.getAdapter();
        boolean z = adapter != null && u0 == adapter.b() - 1;
        if (u0 != -1) {
            return (!z || this.f21406g) && D(u0, adapter);
        }
        return false;
    }

    private void l(@NonNull Canvas canvas, @NonNull RecyclerView recyclerView) {
        int i2;
        int i3;
        int i4;
        int i5;
        canvas.save();
        if (recyclerView.getClipToPadding()) {
            i3 = recyclerView.getPaddingTop();
            i2 = recyclerView.getHeight() - recyclerView.getPaddingBottom();
            canvas.clipRect(recyclerView.getPaddingLeft(), i3, recyclerView.getWidth() - recyclerView.getPaddingRight(), i2);
        } else {
            i2 = recyclerView.getHeight();
            i3 = 0;
        }
        int i6 = i3 + this.f21404e;
        int i7 = i2 - this.f21405f;
        boolean s = ViewUtils.s(recyclerView);
        int childCount = recyclerView.getChildCount();
        for (int i8 = 0; i8 < childCount; i8++) {
            View childAt = recyclerView.getChildAt(i8);
            if (E(recyclerView, childAt)) {
                recyclerView.getLayoutManager().c0(childAt, this.f21407h);
                int round = Math.round(childAt.getTranslationX());
                Rect rect = this.f21407h;
                if (s) {
                    i4 = rect.left + round;
                    i5 = this.f21401b + i4;
                } else {
                    i5 = round + rect.right;
                    i4 = i5 - this.f21401b;
                }
                this.f21400a.setBounds(i4, i6, i5, i7);
                this.f21400a.setAlpha(Math.round(childAt.getAlpha() * 255.0f));
                this.f21400a.draw(canvas);
            }
        }
        canvas.restore();
    }

    private void m(@NonNull Canvas canvas, @NonNull RecyclerView recyclerView) {
        int i2;
        int i3;
        canvas.save();
        if (recyclerView.getClipToPadding()) {
            i3 = recyclerView.getPaddingLeft();
            i2 = recyclerView.getWidth() - recyclerView.getPaddingRight();
            canvas.clipRect(i3, recyclerView.getPaddingTop(), i2, recyclerView.getHeight() - recyclerView.getPaddingBottom());
        } else {
            i2 = recyclerView.getWidth();
            i3 = 0;
        }
        boolean s = ViewUtils.s(recyclerView);
        int i4 = i3 + (s ? this.f21405f : this.f21404e);
        int i5 = i2 - (s ? this.f21404e : this.f21405f);
        int childCount = recyclerView.getChildCount();
        for (int i6 = 0; i6 < childCount; i6++) {
            View childAt = recyclerView.getChildAt(i6);
            if (E(recyclerView, childAt)) {
                recyclerView.getLayoutManager().c0(childAt, this.f21407h);
                int round = this.f21407h.bottom + Math.round(childAt.getTranslationY());
                this.f21400a.setBounds(i4, round - this.f21401b, i5, round);
                this.f21400a.setAlpha(Math.round(childAt.getAlpha() * 255.0f));
                this.f21400a.draw(canvas);
            }
        }
        canvas.restore();
    }

    public void A(@NonNull Context context, @DimenRes int i2) {
        z(context.getResources().getDimensionPixelSize(i2));
    }

    public void B(boolean z) {
        this.f21406g = z;
    }

    public void C(int i2) {
        if (i2 == 0 || i2 == 1) {
            this.f21403d = i2;
            return;
        }
        throw new IllegalArgumentException("Invalid orientation: " + i2 + ". It should be either HORIZONTAL or VERTICAL");
    }

    /* access modifiers changed from: protected */
    public boolean D(int i2, @Nullable RecyclerView.Adapter<?> adapter) {
        return true;
    }

    public void g(@NonNull Rect rect, @NonNull View view, @NonNull RecyclerView recyclerView, @NonNull RecyclerView.State state) {
        rect.set(0, 0, 0, 0);
        if (!E(recyclerView, view)) {
            return;
        }
        if (this.f21403d == 1) {
            rect.bottom = this.f21401b;
        } else if (ViewUtils.s(recyclerView)) {
            rect.left = this.f21401b;
        } else {
            rect.right = this.f21401b;
        }
    }

    public void i(@NonNull Canvas canvas, @NonNull RecyclerView recyclerView, @NonNull RecyclerView.State state) {
        if (recyclerView.getLayoutManager() != null) {
            if (this.f21403d == 1) {
                m(canvas, recyclerView);
            } else {
                l(canvas, recyclerView);
            }
        }
    }

    @ColorInt
    public int n() {
        return this.f21402c;
    }

    @Px
    public int o() {
        return this.f21405f;
    }

    @Px
    public int p() {
        return this.f21404e;
    }

    @Px
    public int q() {
        return this.f21401b;
    }

    public int r() {
        return this.f21403d;
    }

    public boolean s() {
        return this.f21406g;
    }

    public void t(@ColorInt int i2) {
        this.f21402c = i2;
        Drawable r = DrawableCompat.r(this.f21400a);
        this.f21400a = r;
        DrawableCompat.n(r, i2);
    }

    public void u(@NonNull Context context, @ColorRes int i2) {
        t(ContextCompat.g(context, i2));
    }

    public void v(@Px int i2) {
        this.f21405f = i2;
    }

    public void w(@NonNull Context context, @DimenRes int i2) {
        v(context.getResources().getDimensionPixelOffset(i2));
    }

    public void x(@Px int i2) {
        this.f21404e = i2;
    }

    public void y(@NonNull Context context, @DimenRes int i2) {
        x(context.getResources().getDimensionPixelOffset(i2));
    }

    public void z(@Px int i2) {
        this.f21401b = i2;
    }

    public MaterialDividerItemDecoration(@NonNull Context context, @Nullable AttributeSet attributeSet, int i2) {
        this(context, attributeSet, R.attr.Lc, i2);
    }

    public MaterialDividerItemDecoration(@NonNull Context context, @Nullable AttributeSet attributeSet, int i2, int i3) {
        this.f21407h = new Rect();
        TypedArray k2 = ThemeEnforcement.k(context, attributeSet, R.styleable.Fn, i2, f21399k, new int[0]);
        this.f21402c = MaterialResources.a(context, k2, R.styleable.Gn).getDefaultColor();
        this.f21401b = k2.getDimensionPixelSize(R.styleable.Jn, context.getResources().getDimensionPixelSize(R.dimen.Q9));
        this.f21404e = k2.getDimensionPixelOffset(R.styleable.In, 0);
        this.f21405f = k2.getDimensionPixelOffset(R.styleable.Hn, 0);
        this.f21406g = k2.getBoolean(R.styleable.Kn, true);
        k2.recycle();
        this.f21400a = new ShapeDrawable();
        t(this.f21402c);
        C(i3);
    }
}
