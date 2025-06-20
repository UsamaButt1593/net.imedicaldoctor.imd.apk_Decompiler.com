package androidx.recyclerview.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

public class DividerItemDecoration extends RecyclerView.ItemDecoration {

    /* renamed from: d  reason: collision with root package name */
    public static final int f15325d = 0;

    /* renamed from: e  reason: collision with root package name */
    public static final int f15326e = 1;

    /* renamed from: f  reason: collision with root package name */
    private static final String f15327f = "DividerItem";

    /* renamed from: g  reason: collision with root package name */
    private static final int[] f15328g = {16843284};

    /* renamed from: a  reason: collision with root package name */
    private Drawable f15329a;

    /* renamed from: b  reason: collision with root package name */
    private int f15330b;

    /* renamed from: c  reason: collision with root package name */
    private final Rect f15331c = new Rect();

    @SuppressLint({"UnknownNullness"})
    public DividerItemDecoration(Context context, int i2) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(f15328g);
        Drawable drawable = obtainStyledAttributes.getDrawable(0);
        this.f15329a = drawable;
        if (drawable == null) {
            Log.w(f15327f, "@android:attr/listDivider was not set in the theme used for this DividerItemDecoration. Please set that attribute all call setDrawable()");
        }
        obtainStyledAttributes.recycle();
        p(i2);
    }

    private void l(Canvas canvas, RecyclerView recyclerView) {
        int i2;
        int i3;
        canvas.save();
        if (recyclerView.getClipToPadding()) {
            i3 = recyclerView.getPaddingTop();
            i2 = recyclerView.getHeight() - recyclerView.getPaddingBottom();
            canvas.clipRect(recyclerView.getPaddingLeft(), i3, recyclerView.getWidth() - recyclerView.getPaddingRight(), i2);
        } else {
            i2 = recyclerView.getHeight();
            i3 = 0;
        }
        int childCount = recyclerView.getChildCount();
        for (int i4 = 0; i4 < childCount; i4++) {
            View childAt = recyclerView.getChildAt(i4);
            recyclerView.getLayoutManager().c0(childAt, this.f15331c);
            int round = this.f15331c.right + Math.round(childAt.getTranslationX());
            this.f15329a.setBounds(round - this.f15329a.getIntrinsicWidth(), i3, round, i2);
            this.f15329a.draw(canvas);
        }
        canvas.restore();
    }

    private void m(Canvas canvas, RecyclerView recyclerView) {
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
        int childCount = recyclerView.getChildCount();
        for (int i4 = 0; i4 < childCount; i4++) {
            View childAt = recyclerView.getChildAt(i4);
            recyclerView.A0(childAt, this.f15331c);
            int round = this.f15331c.bottom + Math.round(childAt.getTranslationY());
            this.f15329a.setBounds(i3, round - this.f15329a.getIntrinsicHeight(), i2, round);
            this.f15329a.draw(canvas);
        }
        canvas.restore();
    }

    @SuppressLint({"UnknownNullness"})
    public void g(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
        Drawable drawable = this.f15329a;
        if (drawable == null) {
            rect.set(0, 0, 0, 0);
        } else if (this.f15330b == 1) {
            rect.set(0, 0, 0, drawable.getIntrinsicHeight());
        } else {
            rect.set(0, 0, drawable.getIntrinsicWidth(), 0);
        }
    }

    @SuppressLint({"UnknownNullness"})
    public void i(Canvas canvas, RecyclerView recyclerView, RecyclerView.State state) {
        if (recyclerView.getLayoutManager() != null && this.f15329a != null) {
            if (this.f15330b == 1) {
                m(canvas, recyclerView);
            } else {
                l(canvas, recyclerView);
            }
        }
    }

    @Nullable
    public Drawable n() {
        return this.f15329a;
    }

    public void o(@NonNull Drawable drawable) {
        if (drawable != null) {
            this.f15329a = drawable;
            return;
        }
        throw new IllegalArgumentException("Drawable cannot be null.");
    }

    public void p(int i2) {
        if (i2 == 0 || i2 == 1) {
            this.f15330b = i2;
            return;
        }
        throw new IllegalArgumentException("Invalid orientation. It should be either HORIZONTAL or VERTICAL");
    }
}
