package androidx.appcompat.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.appcompat.R;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.core.view.ViewCompat;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class AlertDialogLayout extends LinearLayoutCompat {
    public AlertDialogLayout(@Nullable Context context) {
        super(context);
    }

    private void E(View view, int i2, int i3, int i4, int i5) {
        view.layout(i2, i3, i4 + i2, i5 + i3);
    }

    private static int F(View view) {
        int h0 = ViewCompat.h0(view);
        if (h0 > 0) {
            return h0;
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            if (viewGroup.getChildCount() == 1) {
                return F(viewGroup.getChildAt(0));
            }
        }
        return 0;
    }

    private boolean G(int i2, int i3) {
        int i4;
        int i5;
        int i6;
        int i7;
        int i8 = i2;
        int i9 = i3;
        int childCount = getChildCount();
        View view = null;
        View view2 = null;
        View view3 = null;
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt = getChildAt(i10);
            if (childAt.getVisibility() != 8) {
                int id = childAt.getId();
                if (id == R.id.v0) {
                    view = childAt;
                } else if (id == R.id.q) {
                    view2 = childAt;
                } else if ((id != R.id.u && id != R.id.w) || view3 != null) {
                    return false;
                } else {
                    view3 = childAt;
                }
            }
        }
        int mode = View.MeasureSpec.getMode(i3);
        int size = View.MeasureSpec.getSize(i3);
        int mode2 = View.MeasureSpec.getMode(i2);
        int paddingTop = getPaddingTop() + getPaddingBottom();
        if (view != null) {
            view.measure(i8, 0);
            paddingTop += view.getMeasuredHeight();
            i4 = View.combineMeasuredStates(0, view.getMeasuredState());
        } else {
            i4 = 0;
        }
        if (view2 != null) {
            view2.measure(i8, 0);
            i6 = F(view2);
            i5 = view2.getMeasuredHeight() - i6;
            paddingTop += i6;
            i4 = View.combineMeasuredStates(i4, view2.getMeasuredState());
        } else {
            i6 = 0;
            i5 = 0;
        }
        if (view3 != null) {
            view3.measure(i8, mode == 0 ? 0 : View.MeasureSpec.makeMeasureSpec(Math.max(0, size - paddingTop), mode));
            i7 = view3.getMeasuredHeight();
            paddingTop += i7;
            i4 = View.combineMeasuredStates(i4, view3.getMeasuredState());
        } else {
            i7 = 0;
        }
        int i11 = size - paddingTop;
        if (view2 != null) {
            int i12 = paddingTop - i6;
            int min = Math.min(i11, i5);
            if (min > 0) {
                i11 -= min;
                i6 += min;
            }
            view2.measure(i8, View.MeasureSpec.makeMeasureSpec(i6, 1073741824));
            paddingTop = i12 + view2.getMeasuredHeight();
            i4 = View.combineMeasuredStates(i4, view2.getMeasuredState());
        }
        if (view3 != null && i11 > 0) {
            view3.measure(i8, View.MeasureSpec.makeMeasureSpec(i7 + i11, mode));
            paddingTop = (paddingTop - i7) + view3.getMeasuredHeight();
            i4 = View.combineMeasuredStates(i4, view3.getMeasuredState());
        }
        int i13 = 0;
        for (int i14 = 0; i14 < childCount; i14++) {
            View childAt2 = getChildAt(i14);
            if (childAt2.getVisibility() != 8) {
                i13 = Math.max(i13, childAt2.getMeasuredWidth());
            }
        }
        setMeasuredDimension(View.resolveSizeAndState(i13 + getPaddingLeft() + getPaddingRight(), i8, i4), View.resolveSizeAndState(paddingTop, i9, 0));
        if (mode2 == 1073741824) {
            return true;
        }
        n(childCount, i9);
        return true;
    }

    private void n(int i2, int i3) {
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824);
        for (int i4 = 0; i4 < i2; i4++) {
            View childAt = getChildAt(i4);
            if (childAt.getVisibility() != 8) {
                LinearLayoutCompat.LayoutParams layoutParams = (LinearLayoutCompat.LayoutParams) childAt.getLayoutParams();
                if (layoutParams.width == -1) {
                    int i5 = layoutParams.height;
                    layoutParams.height = childAt.getMeasuredHeight();
                    measureChildWithMargins(childAt, makeMeasureSpec, 0, i3, 0);
                    layoutParams.height = i5;
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x00a7  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onLayout(boolean r18, int r19, int r20, int r21, int r22) {
        /*
            r17 = this;
            r6 = r17
            int r7 = r17.getPaddingLeft()
            int r0 = r21 - r19
            int r1 = r17.getPaddingRight()
            int r8 = r0 - r1
            int r0 = r0 - r7
            int r1 = r17.getPaddingRight()
            int r9 = r0 - r1
            int r0 = r17.getMeasuredHeight()
            int r10 = r17.getChildCount()
            int r1 = r17.getGravity()
            r2 = r1 & 112(0x70, float:1.57E-43)
            r3 = 8388615(0x800007, float:1.1754953E-38)
            r11 = r1 & r3
            r1 = 16
            if (r2 == r1) goto L_0x0040
            r1 = 80
            if (r2 == r1) goto L_0x0035
            int r0 = r17.getPaddingTop()
            goto L_0x004b
        L_0x0035:
            int r1 = r17.getPaddingTop()
            int r1 = r1 + r22
            int r1 = r1 - r20
            int r0 = r1 - r0
            goto L_0x004b
        L_0x0040:
            int r1 = r17.getPaddingTop()
            int r2 = r22 - r20
            int r2 = r2 - r0
            int r2 = r2 / 2
            int r0 = r1 + r2
        L_0x004b:
            android.graphics.drawable.Drawable r1 = r17.getDividerDrawable()
            r2 = 0
            if (r1 != 0) goto L_0x0054
            r12 = 0
            goto L_0x0059
        L_0x0054:
            int r1 = r1.getIntrinsicHeight()
            r12 = r1
        L_0x0059:
            r13 = 0
        L_0x005a:
            if (r13 >= r10) goto L_0x00be
            android.view.View r1 = r6.getChildAt(r13)
            if (r1 == 0) goto L_0x00bb
            int r2 = r1.getVisibility()
            r3 = 8
            if (r2 == r3) goto L_0x00bb
            int r4 = r1.getMeasuredWidth()
            int r14 = r1.getMeasuredHeight()
            android.view.ViewGroup$LayoutParams r2 = r1.getLayoutParams()
            r15 = r2
            androidx.appcompat.widget.LinearLayoutCompat$LayoutParams r15 = (androidx.appcompat.widget.LinearLayoutCompat.LayoutParams) r15
            int r2 = r15.gravity
            if (r2 >= 0) goto L_0x007e
            r2 = r11
        L_0x007e:
            int r3 = r17.getLayoutDirection()
            int r2 = androidx.core.view.GravityCompat.d(r2, r3)
            r2 = r2 & 7
            r3 = 1
            if (r2 == r3) goto L_0x0098
            r3 = 5
            if (r2 == r3) goto L_0x0092
            int r2 = r15.leftMargin
            int r2 = r2 + r7
            goto L_0x00a1
        L_0x0092:
            int r2 = r8 - r4
        L_0x0094:
            int r3 = r15.rightMargin
            int r2 = r2 - r3
            goto L_0x00a1
        L_0x0098:
            int r2 = r9 - r4
            int r2 = r2 / 2
            int r2 = r2 + r7
            int r3 = r15.leftMargin
            int r2 = r2 + r3
            goto L_0x0094
        L_0x00a1:
            boolean r3 = r6.v(r13)
            if (r3 == 0) goto L_0x00a8
            int r0 = r0 + r12
        L_0x00a8:
            int r3 = r15.topMargin
            int r16 = r0 + r3
            r0 = r17
            r3 = r16
            r5 = r14
            r0.E(r1, r2, r3, r4, r5)
            int r0 = r15.bottomMargin
            int r14 = r14 + r0
            int r16 = r16 + r14
            r0 = r16
        L_0x00bb:
            int r13 = r13 + 1
            goto L_0x005a
        L_0x00be:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.AlertDialogLayout.onLayout(boolean, int, int, int, int):void");
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        if (!G(i2, i3)) {
            super.onMeasure(i2, i3);
        }
    }

    public AlertDialogLayout(@Nullable Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
