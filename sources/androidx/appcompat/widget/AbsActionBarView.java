package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.R;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewPropertyAnimatorCompat;
import androidx.core.view.ViewPropertyAnimatorListener;

abstract class AbsActionBarView extends ViewGroup {
    private static final int e3 = 200;
    protected final Context X2;
    protected ActionMenuView Y2;
    protected ActionMenuPresenter Z2;
    protected int a3;
    protected ViewPropertyAnimatorCompat b3;
    private boolean c3;
    private boolean d3;
    protected final VisibilityAnimListener s;

    protected class VisibilityAnimListener implements ViewPropertyAnimatorListener {

        /* renamed from: a  reason: collision with root package name */
        private boolean f2991a = false;

        /* renamed from: b  reason: collision with root package name */
        int f2992b;

        protected VisibilityAnimListener() {
        }

        public void a(View view) {
            this.f2991a = true;
        }

        public void b(View view) {
            if (!this.f2991a) {
                AbsActionBarView absActionBarView = AbsActionBarView.this;
                absActionBarView.b3 = null;
                AbsActionBarView.super.setVisibility(this.f2992b);
            }
        }

        public void c(View view) {
            AbsActionBarView.super.setVisibility(0);
            this.f2991a = false;
        }

        public VisibilityAnimListener d(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, int i2) {
            AbsActionBarView.this.b3 = viewPropertyAnimatorCompat;
            this.f2992b = i2;
            return this;
        }
    }

    AbsActionBarView(@NonNull Context context) {
        this(context, (AttributeSet) null);
    }

    protected static int k(int i2, int i3, boolean z) {
        return z ? i2 - i3 : i2 + i3;
    }

    public void c(int i2) {
        n(i2, 200).y();
    }

    public boolean d() {
        return i() && getVisibility() == 0;
    }

    public void e() {
        ActionMenuPresenter actionMenuPresenter = this.Z2;
        if (actionMenuPresenter != null) {
            actionMenuPresenter.B();
        }
    }

    public boolean f() {
        ActionMenuPresenter actionMenuPresenter = this.Z2;
        if (actionMenuPresenter != null) {
            return actionMenuPresenter.E();
        }
        return false;
    }

    public boolean g() {
        ActionMenuPresenter actionMenuPresenter = this.Z2;
        if (actionMenuPresenter != null) {
            return actionMenuPresenter.G();
        }
        return false;
    }

    public int getAnimatedVisibility() {
        return this.b3 != null ? this.s.f2992b : getVisibility();
    }

    public int getContentHeight() {
        return this.a3;
    }

    public boolean h() {
        ActionMenuPresenter actionMenuPresenter = this.Z2;
        if (actionMenuPresenter != null) {
            return actionMenuPresenter.H();
        }
        return false;
    }

    public boolean i() {
        ActionMenuPresenter actionMenuPresenter = this.Z2;
        return actionMenuPresenter != null && actionMenuPresenter.I();
    }

    /* access modifiers changed from: protected */
    public int j(View view, int i2, int i3, int i4) {
        view.measure(View.MeasureSpec.makeMeasureSpec(i2, Integer.MIN_VALUE), i3);
        return Math.max(0, (i2 - view.getMeasuredWidth()) - i4);
    }

    /* access modifiers changed from: protected */
    public int l(View view, int i2, int i3, int i4, boolean z) {
        int measuredWidth = view.getMeasuredWidth();
        int measuredHeight = view.getMeasuredHeight();
        int i5 = i3 + ((i4 - measuredHeight) / 2);
        if (z) {
            view.layout(i2 - measuredWidth, i5, i2, measuredHeight + i5);
        } else {
            view.layout(i2, i5, i2 + measuredWidth, measuredHeight + i5);
        }
        return z ? -measuredWidth : measuredWidth;
    }

    public void m() {
        post(new Runnable() {
            public void run() {
                AbsActionBarView.this.o();
            }
        });
    }

    public ViewPropertyAnimatorCompat n(int i2, long j2) {
        ViewPropertyAnimatorCompat b2;
        ViewPropertyAnimatorCompat viewPropertyAnimatorCompat = this.b3;
        if (viewPropertyAnimatorCompat != null) {
            viewPropertyAnimatorCompat.d();
        }
        if (i2 == 0) {
            if (getVisibility() != 0) {
                setAlpha(0.0f);
            }
            b2 = ViewCompat.g(this).b(1.0f);
        } else {
            b2 = ViewCompat.g(this).b(0.0f);
        }
        b2.s(j2);
        b2.u(this.s.d(b2, i2));
        return b2;
    }

    public boolean o() {
        ActionMenuPresenter actionMenuPresenter = this.Z2;
        if (actionMenuPresenter != null) {
            return actionMenuPresenter.Q();
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes((AttributeSet) null, R.styleable.f2676a, R.attr.f2556f, 0);
        setContentHeight(obtainStyledAttributes.getLayoutDimension(R.styleable.o, 0));
        obtainStyledAttributes.recycle();
        ActionMenuPresenter actionMenuPresenter = this.Z2;
        if (actionMenuPresenter != null) {
            actionMenuPresenter.J(configuration);
        }
    }

    public boolean onHoverEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 9) {
            this.d3 = false;
        }
        if (!this.d3) {
            boolean onHoverEvent = super.onHoverEvent(motionEvent);
            if (actionMasked == 9 && !onHoverEvent) {
                this.d3 = true;
            }
        }
        if (actionMasked == 10 || actionMasked == 3) {
            this.d3 = false;
        }
        return true;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.c3 = false;
        }
        if (!this.c3) {
            boolean onTouchEvent = super.onTouchEvent(motionEvent);
            if (actionMasked == 0 && !onTouchEvent) {
                this.c3 = true;
            }
        }
        if (actionMasked == 1 || actionMasked == 3) {
            this.c3 = false;
        }
        return true;
    }

    public void setContentHeight(int i2) {
        this.a3 = i2;
        requestLayout();
    }

    public void setVisibility(int i2) {
        if (i2 != getVisibility()) {
            ViewPropertyAnimatorCompat viewPropertyAnimatorCompat = this.b3;
            if (viewPropertyAnimatorCompat != null) {
                viewPropertyAnimatorCompat.d();
            }
            super.setVisibility(i2);
        }
    }

    AbsActionBarView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    AbsActionBarView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.s = new VisibilityAnimListener();
        TypedValue typedValue = new TypedValue();
        if (!context.getTheme().resolveAttribute(R.attr.f2553c, typedValue, true) || typedValue.resourceId == 0) {
            this.X2 = context;
        } else {
            this.X2 = new ContextThemeWrapper(context, typedValue.resourceId);
        }
    }
}
