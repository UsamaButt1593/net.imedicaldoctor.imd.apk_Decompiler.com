package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.appcompat.R;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class ActionBarContainer extends FrameLayout {
    private View X2;
    private View Y2;
    private View Z2;
    Drawable a3;
    Drawable b3;
    Drawable c3;
    boolean d3;
    boolean e3;
    private int f3;
    private boolean s;

    @RequiresApi(21)
    private static class Api21Impl {
        private Api21Impl() {
        }

        public static void a(ActionBarContainer actionBarContainer) {
            actionBarContainer.invalidateOutline();
        }
    }

    public ActionBarContainer(Context context) {
        this(context, (AttributeSet) null);
    }

    private int a(View view) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) view.getLayoutParams();
        return view.getMeasuredHeight() + layoutParams.topMargin + layoutParams.bottomMargin;
    }

    private boolean b(View view) {
        return view == null || view.getVisibility() == 8 || view.getMeasuredHeight() == 0;
    }

    /* access modifiers changed from: protected */
    public void drawableStateChanged() {
        super.drawableStateChanged();
        Drawable drawable = this.a3;
        if (drawable != null && drawable.isStateful()) {
            this.a3.setState(getDrawableState());
        }
        Drawable drawable2 = this.b3;
        if (drawable2 != null && drawable2.isStateful()) {
            this.b3.setState(getDrawableState());
        }
        Drawable drawable3 = this.c3;
        if (drawable3 != null && drawable3.isStateful()) {
            this.c3.setState(getDrawableState());
        }
    }

    public View getTabContainer() {
        return this.X2;
    }

    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        Drawable drawable = this.a3;
        if (drawable != null) {
            drawable.jumpToCurrentState();
        }
        Drawable drawable2 = this.b3;
        if (drawable2 != null) {
            drawable2.jumpToCurrentState();
        }
        Drawable drawable3 = this.c3;
        if (drawable3 != null) {
            drawable3.jumpToCurrentState();
        }
    }

    public void onFinishInflate() {
        super.onFinishInflate();
        this.Y2 = findViewById(R.id.f2609a);
        this.Z2 = findViewById(R.id.f2616h);
    }

    public boolean onHoverEvent(MotionEvent motionEvent) {
        super.onHoverEvent(motionEvent);
        return true;
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return this.s || super.onInterceptTouchEvent(motionEvent);
    }

    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        Drawable drawable;
        Drawable drawable2;
        int left;
        int top;
        int right;
        View view;
        super.onLayout(z, i2, i3, i4, i5);
        View view2 = this.X2;
        boolean z2 = true;
        boolean z3 = false;
        boolean z4 = (view2 == null || view2.getVisibility() == 8) ? false : true;
        if (!(view2 == null || view2.getVisibility() == 8)) {
            int measuredHeight = getMeasuredHeight();
            int i6 = ((FrameLayout.LayoutParams) view2.getLayoutParams()).bottomMargin;
            view2.layout(i2, (measuredHeight - view2.getMeasuredHeight()) - i6, i4, measuredHeight - i6);
        }
        if (this.d3) {
            Drawable drawable3 = this.c3;
            if (drawable3 != null) {
                drawable3.setBounds(0, 0, getMeasuredWidth(), getMeasuredHeight());
            } else {
                z2 = false;
            }
        } else {
            if (this.a3 != null) {
                if (this.Y2.getVisibility() == 0) {
                    drawable2 = this.a3;
                    left = this.Y2.getLeft();
                    top = this.Y2.getTop();
                    right = this.Y2.getRight();
                    view = this.Y2;
                } else {
                    View view3 = this.Z2;
                    if (view3 == null || view3.getVisibility() != 0) {
                        this.a3.setBounds(0, 0, 0, 0);
                        z3 = true;
                    } else {
                        drawable2 = this.a3;
                        left = this.Z2.getLeft();
                        top = this.Z2.getTop();
                        right = this.Z2.getRight();
                        view = this.Z2;
                    }
                }
                drawable2.setBounds(left, top, right, view.getBottom());
                z3 = true;
            }
            this.e3 = z4;
            if (!z4 || (drawable = this.b3) == null) {
                z2 = z3;
            } else {
                drawable.setBounds(view2.getLeft(), view2.getTop(), view2.getRight(), view2.getBottom());
            }
        }
        if (z2) {
            invalidate();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:25:0x0055  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x005a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onMeasure(int r4, int r5) {
        /*
            r3 = this;
            android.view.View r0 = r3.Y2
            r1 = -2147483648(0xffffffff80000000, float:-0.0)
            if (r0 != 0) goto L_0x001c
            int r0 = android.view.View.MeasureSpec.getMode(r5)
            if (r0 != r1) goto L_0x001c
            int r0 = r3.f3
            if (r0 < 0) goto L_0x001c
            int r5 = android.view.View.MeasureSpec.getSize(r5)
            int r5 = java.lang.Math.min(r0, r5)
            int r5 = android.view.View.MeasureSpec.makeMeasureSpec(r5, r1)
        L_0x001c:
            super.onMeasure(r4, r5)
            android.view.View r4 = r3.Y2
            if (r4 != 0) goto L_0x0024
            return
        L_0x0024:
            int r4 = android.view.View.MeasureSpec.getMode(r5)
            android.view.View r0 = r3.X2
            if (r0 == 0) goto L_0x006f
            int r0 = r0.getVisibility()
            r2 = 8
            if (r0 == r2) goto L_0x006f
            r0 = 1073741824(0x40000000, float:2.0)
            if (r4 == r0) goto L_0x006f
            android.view.View r0 = r3.Y2
            boolean r0 = r3.b(r0)
            if (r0 != 0) goto L_0x0047
            android.view.View r0 = r3.Y2
        L_0x0042:
            int r0 = r3.a(r0)
            goto L_0x0053
        L_0x0047:
            android.view.View r0 = r3.Z2
            boolean r0 = r3.b(r0)
            if (r0 != 0) goto L_0x0052
            android.view.View r0 = r3.Z2
            goto L_0x0042
        L_0x0052:
            r0 = 0
        L_0x0053:
            if (r4 != r1) goto L_0x005a
            int r4 = android.view.View.MeasureSpec.getSize(r5)
            goto L_0x005d
        L_0x005a:
            r4 = 2147483647(0x7fffffff, float:NaN)
        L_0x005d:
            int r5 = r3.getMeasuredWidth()
            android.view.View r1 = r3.X2
            int r1 = r3.a(r1)
            int r0 = r0 + r1
            int r4 = java.lang.Math.min(r0, r4)
            r3.setMeasuredDimension(r5, r4)
        L_0x006f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.ActionBarContainer.onMeasure(int, int):void");
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        super.onTouchEvent(motionEvent);
        return true;
    }

    public void setPrimaryBackground(Drawable drawable) {
        Drawable drawable2 = this.a3;
        if (drawable2 != null) {
            drawable2.setCallback((Drawable.Callback) null);
            unscheduleDrawable(this.a3);
        }
        this.a3 = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
            View view = this.Y2;
            if (view != null) {
                this.a3.setBounds(view.getLeft(), this.Y2.getTop(), this.Y2.getRight(), this.Y2.getBottom());
            }
        }
        boolean z = false;
        if (!this.d3 ? this.a3 == null && this.b3 == null : this.c3 == null) {
            z = true;
        }
        setWillNotDraw(z);
        invalidate();
        Api21Impl.a(this);
    }

    public void setSplitBackground(Drawable drawable) {
        Drawable drawable2;
        Drawable drawable3 = this.c3;
        if (drawable3 != null) {
            drawable3.setCallback((Drawable.Callback) null);
            unscheduleDrawable(this.c3);
        }
        this.c3 = drawable;
        boolean z = false;
        if (drawable != null) {
            drawable.setCallback(this);
            if (this.d3 && (drawable2 = this.c3) != null) {
                drawable2.setBounds(0, 0, getMeasuredWidth(), getMeasuredHeight());
            }
        }
        if (!this.d3 ? this.a3 == null && this.b3 == null : this.c3 == null) {
            z = true;
        }
        setWillNotDraw(z);
        invalidate();
        Api21Impl.a(this);
    }

    public void setStackedBackground(Drawable drawable) {
        Drawable drawable2;
        Drawable drawable3 = this.b3;
        if (drawable3 != null) {
            drawable3.setCallback((Drawable.Callback) null);
            unscheduleDrawable(this.b3);
        }
        this.b3 = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
            if (this.e3 && (drawable2 = this.b3) != null) {
                drawable2.setBounds(this.X2.getLeft(), this.X2.getTop(), this.X2.getRight(), this.X2.getBottom());
            }
        }
        boolean z = false;
        if (!this.d3 ? this.a3 == null && this.b3 == null : this.c3 == null) {
            z = true;
        }
        setWillNotDraw(z);
        invalidate();
        Api21Impl.a(this);
    }

    public void setTabContainer(ScrollingTabContainerView scrollingTabContainerView) {
        View view = this.X2;
        if (view != null) {
            removeView(view);
        }
        this.X2 = scrollingTabContainerView;
        if (scrollingTabContainerView != null) {
            addView(scrollingTabContainerView);
            ViewGroup.LayoutParams layoutParams = scrollingTabContainerView.getLayoutParams();
            layoutParams.width = -1;
            layoutParams.height = -2;
            scrollingTabContainerView.setAllowCollapse(false);
        }
    }

    public void setTransitioning(boolean z) {
        this.s = z;
        setDescendantFocusability(z ? 393216 : 262144);
    }

    public void setVisibility(int i2) {
        super.setVisibility(i2);
        boolean z = i2 == 0;
        Drawable drawable = this.a3;
        if (drawable != null) {
            drawable.setVisible(z, false);
        }
        Drawable drawable2 = this.b3;
        if (drawable2 != null) {
            drawable2.setVisible(z, false);
        }
        Drawable drawable3 = this.c3;
        if (drawable3 != null) {
            drawable3.setVisible(z, false);
        }
    }

    public ActionMode startActionModeForChild(View view, ActionMode.Callback callback) {
        return null;
    }

    /* access modifiers changed from: protected */
    public boolean verifyDrawable(@NonNull Drawable drawable) {
        return (drawable == this.a3 && !this.d3) || (drawable == this.b3 && this.e3) || ((drawable == this.c3 && this.d3) || super.verifyDrawable(drawable));
    }

    public ActionBarContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setBackground(new ActionBarBackgroundDrawable(this));
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.f2676a);
        this.a3 = obtainStyledAttributes.getDrawable(R.styleable.f2677b);
        this.b3 = obtainStyledAttributes.getDrawable(R.styleable.f2679d);
        this.f3 = obtainStyledAttributes.getDimensionPixelSize(R.styleable.o, -1);
        boolean z = true;
        if (getId() == R.id.j0) {
            this.d3 = true;
            this.c3 = obtainStyledAttributes.getDrawable(R.styleable.f2678c);
        }
        obtainStyledAttributes.recycle();
        if (!this.d3 ? !(this.a3 == null && this.b3 == null) : this.c3 != null) {
            z = false;
        }
        setWillNotDraw(z);
    }

    public ActionMode startActionModeForChild(View view, ActionMode.Callback callback, int i2) {
        if (i2 != 0) {
            return super.startActionModeForChild(view, callback, i2);
        }
        return null;
    }
}
