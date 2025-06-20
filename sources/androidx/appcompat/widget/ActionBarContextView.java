package androidx.appcompat.widget;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.appcompat.R;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewPropertyAnimatorCompat;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class ActionBarContextView extends AbsActionBarView {
    private CharSequence f3;
    private CharSequence g3;
    private View h3;
    private View i3;
    private View j3;
    private LinearLayout k3;
    private TextView l3;
    private TextView m3;
    private int n3;
    private int o3;
    private boolean p3;
    private int q3;

    public ActionBarContextView(@NonNull Context context) {
        this(context, (AttributeSet) null);
    }

    private void r() {
        if (this.k3 == null) {
            LayoutInflater.from(getContext()).inflate(R.layout.f2634a, this);
            LinearLayout linearLayout = (LinearLayout) getChildAt(getChildCount() - 1);
            this.k3 = linearLayout;
            this.l3 = (TextView) linearLayout.findViewById(R.id.f2615g);
            this.m3 = (TextView) this.k3.findViewById(R.id.f2614f);
            if (this.n3 != 0) {
                this.l3.setTextAppearance(getContext(), this.n3);
            }
            if (this.o3 != 0) {
                this.m3.setTextAppearance(getContext(), this.o3);
            }
        }
        this.l3.setText(this.f3);
        this.m3.setText(this.g3);
        boolean z = !TextUtils.isEmpty(this.f3);
        boolean z2 = !TextUtils.isEmpty(this.g3);
        int i2 = 8;
        this.m3.setVisibility(z2 ? 0 : 8);
        LinearLayout linearLayout2 = this.k3;
        if (z || z2) {
            i2 = 0;
        }
        linearLayout2.setVisibility(i2);
        if (this.k3.getParent() == null) {
            addView(this.k3);
        }
    }

    public /* bridge */ /* synthetic */ void c(int i2) {
        super.c(i2);
    }

    public /* bridge */ /* synthetic */ boolean d() {
        return super.d();
    }

    public /* bridge */ /* synthetic */ void e() {
        super.e();
    }

    public boolean f() {
        ActionMenuPresenter actionMenuPresenter = this.Z2;
        if (actionMenuPresenter != null) {
            return actionMenuPresenter.E();
        }
        return false;
    }

    public /* bridge */ /* synthetic */ boolean g() {
        return super.g();
    }

    /* access modifiers changed from: protected */
    public ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new ViewGroup.MarginLayoutParams(-1, -2);
    }

    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new ViewGroup.MarginLayoutParams(getContext(), attributeSet);
    }

    public /* bridge */ /* synthetic */ int getAnimatedVisibility() {
        return super.getAnimatedVisibility();
    }

    public /* bridge */ /* synthetic */ int getContentHeight() {
        return super.getContentHeight();
    }

    public CharSequence getSubtitle() {
        return this.g3;
    }

    public CharSequence getTitle() {
        return this.f3;
    }

    public boolean h() {
        ActionMenuPresenter actionMenuPresenter = this.Z2;
        if (actionMenuPresenter != null) {
            return actionMenuPresenter.H();
        }
        return false;
    }

    public /* bridge */ /* synthetic */ boolean i() {
        return super.i();
    }

    public /* bridge */ /* synthetic */ void m() {
        super.m();
    }

    public /* bridge */ /* synthetic */ ViewPropertyAnimatorCompat n(int i2, long j2) {
        return super.n(i2, j2);
    }

    public boolean o() {
        ActionMenuPresenter actionMenuPresenter = this.Z2;
        if (actionMenuPresenter != null) {
            return actionMenuPresenter.Q();
        }
        return false;
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ActionMenuPresenter actionMenuPresenter = this.Z2;
        if (actionMenuPresenter != null) {
            actionMenuPresenter.E();
            this.Z2.F();
        }
    }

    public /* bridge */ /* synthetic */ boolean onHoverEvent(MotionEvent motionEvent) {
        return super.onHoverEvent(motionEvent);
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i2, int i4, int i5, int i6) {
        boolean b2 = ViewUtils.b(this);
        int paddingRight = b2 ? (i5 - i2) - getPaddingRight() : getPaddingLeft();
        int paddingTop = getPaddingTop();
        int paddingTop2 = ((i6 - i4) - getPaddingTop()) - getPaddingBottom();
        View view = this.h3;
        if (!(view == null || view.getVisibility() == 8)) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.h3.getLayoutParams();
            int i7 = b2 ? marginLayoutParams.rightMargin : marginLayoutParams.leftMargin;
            int i8 = b2 ? marginLayoutParams.leftMargin : marginLayoutParams.rightMargin;
            int k2 = AbsActionBarView.k(paddingRight, i7, b2);
            paddingRight = AbsActionBarView.k(k2 + l(this.h3, k2, paddingTop, paddingTop2, b2), i8, b2);
        }
        int i9 = paddingRight;
        LinearLayout linearLayout = this.k3;
        if (!(linearLayout == null || this.j3 != null || linearLayout.getVisibility() == 8)) {
            i9 += l(this.k3, i9, paddingTop, paddingTop2, b2);
        }
        int i10 = i9;
        View view2 = this.j3;
        if (view2 != null) {
            l(view2, i10, paddingTop, paddingTop2, b2);
        }
        int paddingLeft = b2 ? getPaddingLeft() : (i5 - i2) - getPaddingRight();
        ActionMenuView actionMenuView = this.Y2;
        if (actionMenuView != null) {
            l(actionMenuView, paddingLeft, paddingTop, paddingTop2, !b2);
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i4) {
        int i5 = 1073741824;
        if (View.MeasureSpec.getMode(i2) != 1073741824) {
            throw new IllegalStateException(getClass().getSimpleName() + " can only be used with android:layout_width=\"match_parent\" (or fill_parent)");
        } else if (View.MeasureSpec.getMode(i4) != 0) {
            int size = View.MeasureSpec.getSize(i2);
            int i6 = this.a3;
            if (i6 <= 0) {
                i6 = View.MeasureSpec.getSize(i4);
            }
            int paddingTop = getPaddingTop() + getPaddingBottom();
            int paddingLeft = (size - getPaddingLeft()) - getPaddingRight();
            int i7 = i6 - paddingTop;
            int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i7, Integer.MIN_VALUE);
            View view = this.h3;
            if (view != null) {
                int j2 = j(view, paddingLeft, makeMeasureSpec, 0);
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.h3.getLayoutParams();
                paddingLeft = j2 - (marginLayoutParams.leftMargin + marginLayoutParams.rightMargin);
            }
            ActionMenuView actionMenuView = this.Y2;
            if (actionMenuView != null && actionMenuView.getParent() == this) {
                paddingLeft = j(this.Y2, paddingLeft, makeMeasureSpec, 0);
            }
            LinearLayout linearLayout = this.k3;
            if (linearLayout != null && this.j3 == null) {
                if (this.p3) {
                    this.k3.measure(View.MeasureSpec.makeMeasureSpec(0, 0), makeMeasureSpec);
                    int measuredWidth = this.k3.getMeasuredWidth();
                    boolean z = measuredWidth <= paddingLeft;
                    if (z) {
                        paddingLeft -= measuredWidth;
                    }
                    this.k3.setVisibility(z ? 0 : 8);
                } else {
                    paddingLeft = j(linearLayout, paddingLeft, makeMeasureSpec, 0);
                }
            }
            View view2 = this.j3;
            if (view2 != null) {
                ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
                int i8 = layoutParams.width;
                int i9 = i8 != -2 ? 1073741824 : Integer.MIN_VALUE;
                if (i8 >= 0) {
                    paddingLeft = Math.min(i8, paddingLeft);
                }
                int i10 = layoutParams.height;
                if (i10 == -2) {
                    i5 = Integer.MIN_VALUE;
                }
                if (i10 >= 0) {
                    i7 = Math.min(i10, i7);
                }
                this.j3.measure(View.MeasureSpec.makeMeasureSpec(paddingLeft, i9), View.MeasureSpec.makeMeasureSpec(i7, i5));
            }
            if (this.a3 <= 0) {
                int childCount = getChildCount();
                int i11 = 0;
                for (int i12 = 0; i12 < childCount; i12++) {
                    int measuredHeight = getChildAt(i12).getMeasuredHeight() + paddingTop;
                    if (measuredHeight > i11) {
                        i11 = measuredHeight;
                    }
                }
                setMeasuredDimension(size, i11);
                return;
            }
            setMeasuredDimension(size, i6);
        } else {
            throw new IllegalStateException(getClass().getSimpleName() + " can only be used with android:layout_height=\"wrap_content\"");
        }
    }

    public /* bridge */ /* synthetic */ boolean onTouchEvent(MotionEvent motionEvent) {
        return super.onTouchEvent(motionEvent);
    }

    public void p() {
        if (this.h3 == null) {
            t();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:9:0x003e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void q(final androidx.appcompat.view.ActionMode r4) {
        /*
            r3 = this;
            android.view.View r0 = r3.h3
            if (r0 != 0) goto L_0x0019
            android.content.Context r0 = r3.getContext()
            android.view.LayoutInflater r0 = android.view.LayoutInflater.from(r0)
            int r1 = r3.q3
            r2 = 0
            android.view.View r0 = r0.inflate(r1, r3, r2)
            r3.h3 = r0
        L_0x0015:
            r3.addView(r0)
            goto L_0x0022
        L_0x0019:
            android.view.ViewParent r0 = r0.getParent()
            if (r0 != 0) goto L_0x0022
            android.view.View r0 = r3.h3
            goto L_0x0015
        L_0x0022:
            android.view.View r0 = r3.h3
            int r1 = androidx.appcompat.R.id.f2621m
            android.view.View r0 = r0.findViewById(r1)
            r3.i3 = r0
            androidx.appcompat.widget.ActionBarContextView$1 r1 = new androidx.appcompat.widget.ActionBarContextView$1
            r1.<init>(r4)
            r0.setOnClickListener(r1)
            android.view.Menu r4 = r4.e()
            androidx.appcompat.view.menu.MenuBuilder r4 = (androidx.appcompat.view.menu.MenuBuilder) r4
            androidx.appcompat.widget.ActionMenuPresenter r0 = r3.Z2
            if (r0 == 0) goto L_0x0041
            r0.B()
        L_0x0041:
            androidx.appcompat.widget.ActionMenuPresenter r0 = new androidx.appcompat.widget.ActionMenuPresenter
            android.content.Context r1 = r3.getContext()
            r0.<init>(r1)
            r3.Z2 = r0
            r1 = 1
            r0.O(r1)
            android.view.ViewGroup$LayoutParams r0 = new android.view.ViewGroup$LayoutParams
            r1 = -2
            r2 = -1
            r0.<init>(r1, r2)
            androidx.appcompat.widget.ActionMenuPresenter r1 = r3.Z2
            android.content.Context r2 = r3.X2
            r4.c(r1, r2)
            androidx.appcompat.widget.ActionMenuPresenter r4 = r3.Z2
            androidx.appcompat.view.menu.MenuView r4 = r4.m(r3)
            androidx.appcompat.widget.ActionMenuView r4 = (androidx.appcompat.widget.ActionMenuView) r4
            r3.Y2 = r4
            r1 = 0
            r4.setBackground(r1)
            androidx.appcompat.widget.ActionMenuView r4 = r3.Y2
            r3.addView(r4, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.ActionBarContextView.q(androidx.appcompat.view.ActionMode):void");
    }

    public boolean s() {
        return this.p3;
    }

    public void setContentHeight(int i2) {
        this.a3 = i2;
    }

    public void setCustomView(View view) {
        LinearLayout linearLayout;
        View view2 = this.j3;
        if (view2 != null) {
            removeView(view2);
        }
        this.j3 = view;
        if (!(view == null || (linearLayout = this.k3) == null)) {
            removeView(linearLayout);
            this.k3 = null;
        }
        if (view != null) {
            addView(view);
        }
        requestLayout();
    }

    public void setSubtitle(CharSequence charSequence) {
        this.g3 = charSequence;
        r();
    }

    public void setTitle(CharSequence charSequence) {
        this.f3 = charSequence;
        r();
        ViewCompat.K1(this, charSequence);
    }

    public void setTitleOptional(boolean z) {
        if (z != this.p3) {
            requestLayout();
        }
        this.p3 = z;
    }

    public /* bridge */ /* synthetic */ void setVisibility(int i2) {
        super.setVisibility(i2);
    }

    public boolean shouldDelayChildPressedState() {
        return false;
    }

    public void t() {
        removeAllViews();
        this.j3 = null;
        this.Y2 = null;
        this.Z2 = null;
        View view = this.i3;
        if (view != null) {
            view.setOnClickListener((View.OnClickListener) null);
        }
    }

    public ActionBarContextView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.C);
    }

    public ActionBarContextView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        TintTypedArray G = TintTypedArray.G(context, attributeSet, R.styleable.J, i2, 0);
        setBackground(G.h(R.styleable.K));
        this.n3 = G.u(R.styleable.P, 0);
        this.o3 = G.u(R.styleable.O, 0);
        this.a3 = G.q(R.styleable.N, 0);
        this.q3 = G.u(R.styleable.M, R.layout.f2639f);
        G.I();
    }
}
