package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.core.widgets.ConstraintWidgetContainer;
import androidx.constraintlayout.core.widgets.Helper;
import androidx.constraintlayout.core.widgets.HelperWidget;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.constraintlayout.widget.R;
import java.util.Arrays;
import java.util.HashMap;

public abstract class ConstraintHelper extends View {
    protected int X2;
    protected Context Y2;
    protected Helper Z2;
    protected boolean a3 = false;
    protected String b3;
    protected String c3;
    private View[] d3 = null;
    protected HashMap<Integer, String> e3 = new HashMap<>();
    protected int[] s = new int[32];

    public ConstraintHelper(Context context) {
        super(context);
        this.Y2 = context;
        y((AttributeSet) null);
    }

    private void l(String str) {
        if (str != null && str.length() != 0 && this.Y2 != null) {
            String trim = str.trim();
            if (getParent() instanceof ConstraintLayout) {
                ConstraintLayout constraintLayout = (ConstraintLayout) getParent();
            }
            int v = v(trim);
            if (v != 0) {
                this.e3.put(Integer.valueOf(v), trim);
                m(v);
                return;
            }
            Log.w("ConstraintHelper", "Could not find id of \"" + trim + "\"");
        }
    }

    private void m(int i2) {
        if (i2 != getId()) {
            int i3 = this.X2 + 1;
            int[] iArr = this.s;
            if (i3 > iArr.length) {
                this.s = Arrays.copyOf(iArr, iArr.length * 2);
            }
            int[] iArr2 = this.s;
            int i4 = this.X2;
            iArr2[i4] = i2;
            this.X2 = i4 + 1;
        }
    }

    private void n(String str) {
        if (str != null && str.length() != 0 && this.Y2 != null) {
            String trim = str.trim();
            ConstraintLayout constraintLayout = getParent() instanceof ConstraintLayout ? (ConstraintLayout) getParent() : null;
            if (constraintLayout == null) {
                Log.w("ConstraintHelper", "Parent not a ConstraintLayout");
                return;
            }
            int childCount = constraintLayout.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = constraintLayout.getChildAt(i2);
                ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
                if ((layoutParams instanceof ConstraintLayout.LayoutParams) && trim.equals(((ConstraintLayout.LayoutParams) layoutParams).c0)) {
                    if (childAt.getId() == -1) {
                        Log.w("ConstraintHelper", "to use ConstraintTag view " + childAt.getClass().getSimpleName() + " must have an ID");
                    } else {
                        m(childAt.getId());
                    }
                }
            }
        }
    }

    private int[] t(View view, String str) {
        String[] split = str.split(",");
        view.getContext();
        int[] iArr = new int[split.length];
        int i2 = 0;
        for (String trim : split) {
            int v = v(trim.trim());
            if (v != 0) {
                iArr[i2] = v;
                i2++;
            }
        }
        return i2 != split.length ? Arrays.copyOf(iArr, i2) : iArr;
    }

    private int u(ConstraintLayout constraintLayout, String str) {
        Resources resources;
        String str2;
        if (str == null || constraintLayout == null || (resources = this.Y2.getResources()) == null) {
            return 0;
        }
        int childCount = constraintLayout.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = constraintLayout.getChildAt(i2);
            if (childAt.getId() != -1) {
                try {
                    str2 = resources.getResourceEntryName(childAt.getId());
                } catch (Resources.NotFoundException unused) {
                    str2 = null;
                }
                if (str.equals(str2)) {
                    return childAt.getId();
                }
            }
        }
        return 0;
    }

    private int v(String str) {
        ConstraintLayout constraintLayout = getParent() instanceof ConstraintLayout ? (ConstraintLayout) getParent() : null;
        int i2 = 0;
        if (isInEditMode() && constraintLayout != null) {
            Object m2 = constraintLayout.m(0, str);
            if (m2 instanceof Integer) {
                i2 = ((Integer) m2).intValue();
            }
        }
        if (i2 == 0 && constraintLayout != null) {
            i2 = u(constraintLayout, str);
        }
        if (i2 == 0) {
            try {
                i2 = R.id.class.getField(str).getInt((Object) null);
            } catch (Exception unused) {
            }
        }
        return i2 == 0 ? this.Y2.getResources().getIdentifier(str, "id", this.Y2.getPackageName()) : i2;
    }

    public int A(View view) {
        int i2;
        int id = view.getId();
        int i3 = -1;
        if (id == -1) {
            return -1;
        }
        this.b3 = null;
        int i4 = 0;
        while (true) {
            if (i4 >= this.X2) {
                break;
            } else if (this.s[i4] == id) {
                int i5 = i4;
                while (true) {
                    i2 = this.X2;
                    if (i5 >= i2 - 1) {
                        break;
                    }
                    int[] iArr = this.s;
                    int i6 = i5 + 1;
                    iArr[i5] = iArr[i6];
                    i5 = i6;
                }
                this.s[i2 - 1] = 0;
                this.X2 = i2 - 1;
                i3 = i4;
            } else {
                i4++;
            }
        }
        requestLayout();
        return i3;
    }

    public void B(ConstraintWidget constraintWidget, boolean z) {
    }

    public void C(ConstraintLayout constraintLayout) {
    }

    public void D(ConstraintLayout constraintLayout) {
    }

    public void E(ConstraintLayout constraintLayout) {
    }

    public void F(ConstraintLayout constraintLayout) {
    }

    public void G(ConstraintWidgetContainer constraintWidgetContainer, Helper helper, SparseArray<ConstraintWidget> sparseArray) {
        helper.a();
        for (int i2 = 0; i2 < this.X2; i2++) {
            helper.b(sparseArray.get(this.s[i2]));
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0022, code lost:
        r1 = r5.e3.get(java.lang.Integer.valueOf(r1));
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void H(androidx.constraintlayout.widget.ConstraintLayout r6) {
        /*
            r5 = this;
            boolean r0 = r5.isInEditMode()
            if (r0 == 0) goto L_0x000b
            java.lang.String r0 = r5.b3
            r5.setIds(r0)
        L_0x000b:
            androidx.constraintlayout.core.widgets.Helper r0 = r5.Z2
            if (r0 != 0) goto L_0x0010
            return
        L_0x0010:
            r0.a()
            r0 = 0
        L_0x0014:
            int r1 = r5.X2
            if (r0 >= r1) goto L_0x0053
            int[] r1 = r5.s
            r1 = r1[r0]
            android.view.View r2 = r6.o(r1)
            if (r2 != 0) goto L_0x0045
            java.util.HashMap<java.lang.Integer, java.lang.String> r3 = r5.e3
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            java.lang.Object r1 = r3.get(r1)
            java.lang.String r1 = (java.lang.String) r1
            int r3 = r5.u(r6, r1)
            if (r3 == 0) goto L_0x0045
            int[] r2 = r5.s
            r2[r0] = r3
            java.util.HashMap<java.lang.Integer, java.lang.String> r2 = r5.e3
            java.lang.Integer r4 = java.lang.Integer.valueOf(r3)
            r2.put(r4, r1)
            android.view.View r2 = r6.o(r3)
        L_0x0045:
            if (r2 == 0) goto L_0x0050
            androidx.constraintlayout.core.widgets.Helper r1 = r5.Z2
            androidx.constraintlayout.core.widgets.ConstraintWidget r2 = r6.p(r2)
            r1.b(r2)
        L_0x0050:
            int r0 = r0 + 1
            goto L_0x0014
        L_0x0053:
            androidx.constraintlayout.core.widgets.Helper r0 = r5.Z2
            androidx.constraintlayout.core.widgets.ConstraintWidgetContainer r6 = r6.Y2
            r0.c(r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.widget.ConstraintHelper.H(androidx.constraintlayout.widget.ConstraintLayout):void");
    }

    public void I() {
        if (this.Z2 != null) {
            ViewGroup.LayoutParams layoutParams = getLayoutParams();
            if (layoutParams instanceof ConstraintLayout.LayoutParams) {
                ((ConstraintLayout.LayoutParams) layoutParams).v0 = (ConstraintWidget) this.Z2;
            }
        }
    }

    public int[] getReferencedIds() {
        return Arrays.copyOf(this.s, this.X2);
    }

    public void o(View view) {
        if (view != this) {
            if (view.getId() == -1) {
                Log.e("ConstraintHelper", "Views added to a ConstraintHelper need to have an id");
            } else if (view.getParent() == null) {
                Log.e("ConstraintHelper", "Views added to a ConstraintHelper need to have a parent");
            } else {
                this.b3 = null;
                m(view.getId());
                requestLayout();
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        String str = this.b3;
        if (str != null) {
            setIds(str);
        }
        String str2 = this.c3;
        if (str2 != null) {
            setReferenceTags(str2);
        }
    }

    public void onDraw(Canvas canvas) {
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        if (this.a3) {
            super.onMeasure(i2, i3);
        } else {
            setMeasuredDimension(0, 0);
        }
    }

    /* access modifiers changed from: protected */
    public void p() {
        ViewParent parent = getParent();
        if (parent != null && (parent instanceof ConstraintLayout)) {
            q((ConstraintLayout) parent);
        }
    }

    /* access modifiers changed from: protected */
    public void q(ConstraintLayout constraintLayout) {
        int visibility = getVisibility();
        float elevation = getElevation();
        for (int i2 = 0; i2 < this.X2; i2++) {
            View o = constraintLayout.o(this.s[i2]);
            if (o != null) {
                o.setVisibility(visibility);
                if (elevation > 0.0f) {
                    o.setTranslationZ(o.getTranslationZ() + elevation);
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public void r(ConstraintLayout constraintLayout) {
    }

    public boolean s(int i2) {
        for (int i3 : this.s) {
            if (i3 == i2) {
                return true;
            }
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public void setIds(String str) {
        this.b3 = str;
        if (str != null) {
            int i2 = 0;
            this.X2 = 0;
            while (true) {
                int indexOf = str.indexOf(44, i2);
                if (indexOf == -1) {
                    l(str.substring(i2));
                    return;
                } else {
                    l(str.substring(i2, indexOf));
                    i2 = indexOf + 1;
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public void setReferenceTags(String str) {
        this.c3 = str;
        if (str != null) {
            int i2 = 0;
            this.X2 = 0;
            while (true) {
                int indexOf = str.indexOf(44, i2);
                if (indexOf == -1) {
                    n(str.substring(i2));
                    return;
                } else {
                    n(str.substring(i2, indexOf));
                    i2 = indexOf + 1;
                }
            }
        }
    }

    public void setReferencedIds(int[] iArr) {
        this.b3 = null;
        this.X2 = 0;
        for (int m2 : iArr) {
            m(m2);
        }
    }

    public void setTag(int i2, Object obj) {
        super.setTag(i2, obj);
        if (obj == null && this.b3 == null) {
            m(i2);
        }
    }

    /* access modifiers changed from: protected */
    public View[] w(ConstraintLayout constraintLayout) {
        View[] viewArr = this.d3;
        if (viewArr == null || viewArr.length != this.X2) {
            this.d3 = new View[this.X2];
        }
        for (int i2 = 0; i2 < this.X2; i2++) {
            this.d3[i2] = constraintLayout.o(this.s[i2]);
        }
        return this.d3;
    }

    public int x(int i2) {
        int i3 = -1;
        for (int i4 : this.s) {
            i3++;
            if (i4 == i2) {
                return i3;
            }
        }
        return i3;
    }

    /* access modifiers changed from: protected */
    public void y(AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.y6);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i2 = 0; i2 < indexCount; i2++) {
                int index = obtainStyledAttributes.getIndex(i2);
                if (index == R.styleable.i7) {
                    String string = obtainStyledAttributes.getString(index);
                    this.b3 = string;
                    setIds(string);
                } else if (index == R.styleable.j7) {
                    String string2 = obtainStyledAttributes.getString(index);
                    this.c3 = string2;
                    setReferenceTags(string2);
                }
            }
            obtainStyledAttributes.recycle();
        }
    }

    public void z(ConstraintSet.Constraint constraint, HelperWidget helperWidget, ConstraintLayout.LayoutParams layoutParams, SparseArray<ConstraintWidget> sparseArray) {
        ConstraintSet.Layout layout2 = constraint.f4714e;
        int[] iArr = layout2.k0;
        if (iArr != null) {
            setReferencedIds(iArr);
        } else {
            String str = layout2.l0;
            if (str != null) {
                if (str.length() > 0) {
                    ConstraintSet.Layout layout3 = constraint.f4714e;
                    layout3.k0 = t(this, layout3.l0);
                } else {
                    constraint.f4714e.k0 = null;
                }
            }
        }
        if (helperWidget != null) {
            helperWidget.a();
            if (constraint.f4714e.k0 != null) {
                int i2 = 0;
                while (true) {
                    int[] iArr2 = constraint.f4714e.k0;
                    if (i2 < iArr2.length) {
                        ConstraintWidget constraintWidget = sparseArray.get(iArr2[i2]);
                        if (constraintWidget != null) {
                            helperWidget.b(constraintWidget);
                        }
                        i2++;
                    } else {
                        return;
                    }
                }
            }
        }
    }

    public ConstraintHelper(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.Y2 = context;
        y(attributeSet);
    }

    public ConstraintHelper(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.Y2 = context;
        y(attributeSet);
    }
}
