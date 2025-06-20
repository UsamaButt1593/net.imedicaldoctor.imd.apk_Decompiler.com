package com.google.android.material.shape;

import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.ScrollView;
import androidx.annotation.NonNull;

public class InterpolateOnScrollPositionChangeHelper {

    /* renamed from: a  reason: collision with root package name */
    private View f21796a;

    /* renamed from: b  reason: collision with root package name */
    private MaterialShapeDrawable f21797b;

    /* renamed from: c  reason: collision with root package name */
    private ScrollView f21798c;

    /* renamed from: d  reason: collision with root package name */
    private final int[] f21799d = new int[2];

    /* renamed from: e  reason: collision with root package name */
    private final int[] f21800e = new int[2];

    /* renamed from: f  reason: collision with root package name */
    private final ViewTreeObserver.OnScrollChangedListener f21801f = new ViewTreeObserver.OnScrollChangedListener() {
        public void onScrollChanged() {
            InterpolateOnScrollPositionChangeHelper.this.e();
        }
    };

    public InterpolateOnScrollPositionChangeHelper(View view, MaterialShapeDrawable materialShapeDrawable, ScrollView scrollView) {
        this.f21796a = view;
        this.f21797b = materialShapeDrawable;
        this.f21798c = scrollView;
    }

    public void a(ScrollView scrollView) {
        this.f21798c = scrollView;
    }

    public void b(MaterialShapeDrawable materialShapeDrawable) {
        this.f21797b = materialShapeDrawable;
    }

    public void c(@NonNull ViewTreeObserver viewTreeObserver) {
        viewTreeObserver.addOnScrollChangedListener(this.f21801f);
    }

    public void d(@NonNull ViewTreeObserver viewTreeObserver) {
        viewTreeObserver.removeOnScrollChangedListener(this.f21801f);
    }

    public void e() {
        MaterialShapeDrawable materialShapeDrawable;
        float f2;
        ScrollView scrollView = this.f21798c;
        if (scrollView != null) {
            if (scrollView.getChildCount() != 0) {
                this.f21798c.getLocationInWindow(this.f21799d);
                this.f21798c.getChildAt(0).getLocationInWindow(this.f21800e);
                int top = (this.f21796a.getTop() - this.f21799d[1]) + this.f21800e[1];
                int height = this.f21796a.getHeight();
                int height2 = this.f21798c.getHeight();
                if (top < 0) {
                    materialShapeDrawable = this.f21797b;
                    f2 = (((float) top) / ((float) height)) + 1.0f;
                } else {
                    int i2 = top + height;
                    if (i2 > height2) {
                        int i3 = i2 - height2;
                        materialShapeDrawable = this.f21797b;
                        f2 = 1.0f - (((float) i3) / ((float) height));
                    } else if (this.f21797b.A() != 1.0f) {
                        this.f21797b.q0(1.0f);
                        this.f21796a.invalidate();
                        return;
                    } else {
                        return;
                    }
                }
                materialShapeDrawable.q0(Math.max(0.0f, Math.min(1.0f, f2)));
                this.f21796a.invalidate();
                return;
            }
            throw new IllegalStateException("Scroll bar must contain a child to calculate interpolation.");
        }
    }
}
