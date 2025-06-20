package com.google.android.material.button;

import android.content.Context;
import android.graphics.Canvas;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.ToggleButton;
import androidx.annotation.BoolRes;
import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.MarginLayoutParamsCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import com.google.android.material.R;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.shape.AbsoluteCornerSize;
import com.google.android.material.shape.CornerSize;
import com.google.android.material.shape.ShapeAppearanceModel;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeMap;

public class MaterialButtonToggleGroup extends LinearLayout {
    private static final String g3 = "MButtonToggleGroup";
    private static final int h3 = R.style.mj;
    private final PressedStateTracker X2;
    private final LinkedHashSet<OnButtonCheckedListener> Y2;
    private final Comparator<MaterialButton> Z2;
    private Integer[] a3;
    private boolean b3;
    private boolean c3;
    private boolean d3;
    @IdRes
    private final int e3;
    private Set<Integer> f3;
    private final List<CornerData> s;

    private static class CornerData {

        /* renamed from: e  reason: collision with root package name */
        private static final CornerSize f20896e = new AbsoluteCornerSize(0.0f);

        /* renamed from: a  reason: collision with root package name */
        CornerSize f20897a;

        /* renamed from: b  reason: collision with root package name */
        CornerSize f20898b;

        /* renamed from: c  reason: collision with root package name */
        CornerSize f20899c;

        /* renamed from: d  reason: collision with root package name */
        CornerSize f20900d;

        CornerData(CornerSize cornerSize, CornerSize cornerSize2, CornerSize cornerSize3, CornerSize cornerSize4) {
            this.f20897a = cornerSize;
            this.f20898b = cornerSize3;
            this.f20899c = cornerSize4;
            this.f20900d = cornerSize2;
        }

        public static CornerData a(CornerData cornerData) {
            CornerSize cornerSize = f20896e;
            return new CornerData(cornerSize, cornerData.f20900d, cornerSize, cornerData.f20899c);
        }

        public static CornerData b(CornerData cornerData, View view) {
            return ViewUtils.s(view) ? c(cornerData) : d(cornerData);
        }

        public static CornerData c(CornerData cornerData) {
            CornerSize cornerSize = cornerData.f20897a;
            CornerSize cornerSize2 = cornerData.f20900d;
            CornerSize cornerSize3 = f20896e;
            return new CornerData(cornerSize, cornerSize2, cornerSize3, cornerSize3);
        }

        public static CornerData d(CornerData cornerData) {
            CornerSize cornerSize = f20896e;
            return new CornerData(cornerSize, cornerSize, cornerData.f20898b, cornerData.f20899c);
        }

        public static CornerData e(CornerData cornerData, View view) {
            return ViewUtils.s(view) ? d(cornerData) : c(cornerData);
        }

        public static CornerData f(CornerData cornerData) {
            CornerSize cornerSize = cornerData.f20897a;
            CornerSize cornerSize2 = f20896e;
            return new CornerData(cornerSize, cornerSize2, cornerData.f20898b, cornerSize2);
        }
    }

    public interface OnButtonCheckedListener {
        void a(MaterialButtonToggleGroup materialButtonToggleGroup, @IdRes int i2, boolean z);
    }

    private class PressedStateTracker implements MaterialButton.OnPressedChangeListener {
        private PressedStateTracker() {
        }

        public void a(@NonNull MaterialButton materialButton, boolean z) {
            MaterialButtonToggleGroup.this.invalidate();
        }
    }

    public MaterialButtonToggleGroup(@NonNull Context context) {
        this(context, (AttributeSet) null);
    }

    private void c() {
        int firstVisibleChildIndex = getFirstVisibleChildIndex();
        if (firstVisibleChildIndex != -1) {
            for (int i2 = firstVisibleChildIndex + 1; i2 < getChildCount(); i2++) {
                MaterialButton j2 = j(i2);
                int min = Math.min(j2.getStrokeWidth(), j(i2 - 1).getStrokeWidth());
                LinearLayout.LayoutParams d2 = d(j2);
                if (getOrientation() == 0) {
                    MarginLayoutParamsCompat.g(d2, 0);
                    MarginLayoutParamsCompat.h(d2, -min);
                    d2.topMargin = 0;
                } else {
                    d2.bottomMargin = 0;
                    d2.topMargin = -min;
                    MarginLayoutParamsCompat.h(d2, 0);
                }
                j2.setLayoutParams(d2);
            }
            r(firstVisibleChildIndex);
        }
    }

    @NonNull
    private LinearLayout.LayoutParams d(@NonNull View view) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        return layoutParams instanceof LinearLayout.LayoutParams ? (LinearLayout.LayoutParams) layoutParams : new LinearLayout.LayoutParams(layoutParams.width, layoutParams.height);
    }

    private void f(@IdRes int i2, boolean z) {
        if (i2 == -1) {
            Log.e(g3, "Button ID is not valid: " + i2);
            return;
        }
        HashSet hashSet = new HashSet(this.f3);
        if (z && !hashSet.contains(Integer.valueOf(i2))) {
            if (this.c3 && !hashSet.isEmpty()) {
                hashSet.clear();
            }
            hashSet.add(Integer.valueOf(i2));
        } else if (!z && hashSet.contains(Integer.valueOf(i2))) {
            if (!this.d3 || hashSet.size() > 1) {
                hashSet.remove(Integer.valueOf(i2));
            }
        } else {
            return;
        }
        v(hashSet);
    }

    private int getFirstVisibleChildIndex() {
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            if (m(i2)) {
                return i2;
            }
        }
        return -1;
    }

    private int getLastVisibleChildIndex() {
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            if (m(childCount)) {
                return childCount;
            }
        }
        return -1;
    }

    private int getVisibleButtonCount() {
        int i2 = 0;
        for (int i3 = 0; i3 < getChildCount(); i3++) {
            if ((getChildAt(i3) instanceof MaterialButton) && m(i3)) {
                i2++;
            }
        }
        return i2;
    }

    private void i(@IdRes int i2, boolean z) {
        Iterator<OnButtonCheckedListener> it2 = this.Y2.iterator();
        while (it2.hasNext()) {
            it2.next().a(this, i2, z);
        }
    }

    private MaterialButton j(int i2) {
        return (MaterialButton) getChildAt(i2);
    }

    /* access modifiers changed from: private */
    public int k(@Nullable View view) {
        if (!(view instanceof MaterialButton)) {
            return -1;
        }
        int i2 = 0;
        for (int i3 = 0; i3 < getChildCount(); i3++) {
            if (getChildAt(i3) == view) {
                return i2;
            }
            if ((getChildAt(i3) instanceof MaterialButton) && m(i3)) {
                i2++;
            }
        }
        return -1;
    }

    @Nullable
    private CornerData l(int i2, int i3, int i4) {
        CornerData cornerData = this.s.get(i2);
        if (i3 == i4) {
            return cornerData;
        }
        boolean z = getOrientation() == 0;
        if (i2 == i3) {
            return z ? CornerData.e(cornerData, this) : CornerData.f(cornerData);
        }
        if (i2 == i4) {
            return z ? CornerData.b(cornerData, this) : CornerData.a(cornerData);
        }
        return null;
    }

    private boolean m(int i2) {
        return getChildAt(i2).getVisibility() != 8;
    }

    private void r(int i2) {
        if (getChildCount() != 0 && i2 != -1) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) j(i2).getLayoutParams();
            if (getOrientation() == 1) {
                layoutParams.topMargin = 0;
                layoutParams.bottomMargin = 0;
                return;
            }
            MarginLayoutParamsCompat.g(layoutParams, 0);
            MarginLayoutParamsCompat.h(layoutParams, 0);
            layoutParams.leftMargin = 0;
            layoutParams.rightMargin = 0;
        }
    }

    private void s(@IdRes int i2, boolean z) {
        View findViewById = findViewById(i2);
        if (findViewById instanceof MaterialButton) {
            this.b3 = true;
            ((MaterialButton) findViewById).setChecked(z);
            this.b3 = false;
        }
    }

    private void setGeneratedIdIfNeeded(@NonNull MaterialButton materialButton) {
        if (materialButton.getId() == -1) {
            materialButton.setId(ViewCompat.D());
        }
    }

    private void setupButtonChild(@NonNull MaterialButton materialButton) {
        materialButton.setMaxLines(1);
        materialButton.setEllipsize(TextUtils.TruncateAt.END);
        materialButton.setCheckable(true);
        materialButton.setOnPressedChangeListenerInternal(this.X2);
        materialButton.setShouldDrawSurfaceColorStroke(true);
    }

    private static void u(ShapeAppearanceModel.Builder builder, @Nullable CornerData cornerData) {
        if (cornerData == null) {
            builder.o(0.0f);
        } else {
            builder.L(cornerData.f20897a).y(cornerData.f20900d).Q(cornerData.f20898b).D(cornerData.f20899c);
        }
    }

    private void v(Set<Integer> set) {
        Set<Integer> set2 = this.f3;
        this.f3 = new HashSet(set);
        for (int i2 = 0; i2 < getChildCount(); i2++) {
            int id = j(i2).getId();
            s(id, set.contains(Integer.valueOf(id)));
            if (set2.contains(Integer.valueOf(id)) != set.contains(Integer.valueOf(id))) {
                i(id, set.contains(Integer.valueOf(id)));
            }
        }
        invalidate();
    }

    private void w() {
        TreeMap treeMap = new TreeMap(this.Z2);
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            treeMap.put(j(i2), Integer.valueOf(i2));
        }
        this.a3 = (Integer[]) treeMap.values().toArray(new Integer[0]);
    }

    private void y() {
        for (int i2 = 0; i2 < getChildCount(); i2++) {
            j(i2).setA11yClassName((this.c3 ? RadioButton.class : ToggleButton.class).getName());
        }
    }

    public void addView(View view, int i2, ViewGroup.LayoutParams layoutParams) {
        if (!(view instanceof MaterialButton)) {
            Log.e(g3, "Child views must be of type MaterialButton.");
            return;
        }
        super.addView(view, i2, layoutParams);
        MaterialButton materialButton = (MaterialButton) view;
        setGeneratedIdIfNeeded(materialButton);
        setupButtonChild(materialButton);
        f(materialButton.getId(), materialButton.isChecked());
        ShapeAppearanceModel shapeAppearanceModel = materialButton.getShapeAppearanceModel();
        this.s.add(new CornerData(shapeAppearanceModel.r(), shapeAppearanceModel.j(), shapeAppearanceModel.t(), shapeAppearanceModel.l()));
        materialButton.setEnabled(isEnabled());
        ViewCompat.H1(materialButton, new AccessibilityDelegateCompat() {
            public void g(View view, @NonNull AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
                super.g(view, accessibilityNodeInfoCompat);
                accessibilityNodeInfoCompat.m1(AccessibilityNodeInfoCompat.CollectionItemInfoCompat.j(0, 1, MaterialButtonToggleGroup.this.k(view), 1, false, ((MaterialButton) view).isChecked()));
            }
        });
    }

    public void b(@NonNull OnButtonCheckedListener onButtonCheckedListener) {
        this.Y2.add(onButtonCheckedListener);
    }

    /* access modifiers changed from: protected */
    public void dispatchDraw(@NonNull Canvas canvas) {
        w();
        super.dispatchDraw(canvas);
    }

    public void e(@IdRes int i2) {
        f(i2, true);
    }

    public void g() {
        v(new HashSet());
    }

    @IdRes
    public int getCheckedButtonId() {
        if (!this.c3 || this.f3.isEmpty()) {
            return -1;
        }
        return this.f3.iterator().next().intValue();
    }

    @NonNull
    public List<Integer> getCheckedButtonIds() {
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < getChildCount(); i2++) {
            int id = j(i2).getId();
            if (this.f3.contains(Integer.valueOf(id))) {
                arrayList.add(Integer.valueOf(id));
            }
        }
        return arrayList;
    }

    /* access modifiers changed from: protected */
    public int getChildDrawingOrder(int i2, int i3) {
        Integer[] numArr = this.a3;
        if (numArr != null && i3 < numArr.length) {
            return numArr[i3].intValue();
        }
        Log.w(g3, "Child order wasn't updated");
        return i3;
    }

    public void h() {
        this.Y2.clear();
    }

    public boolean n() {
        return this.d3;
    }

    public boolean o() {
        return this.c3;
    }

    /* access modifiers changed from: protected */
    public void onFinishInflate() {
        super.onFinishInflate();
        int i2 = this.e3;
        if (i2 != -1) {
            v(Collections.singleton(Integer.valueOf(i2)));
        }
    }

    public void onInitializeAccessibilityNodeInfo(@NonNull AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        AccessibilityNodeInfoCompat.r2(accessibilityNodeInfo).l1(AccessibilityNodeInfoCompat.CollectionInfoCompat.f(1, getVisibleButtonCount(), false, o() ? 1 : 2));
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        x();
        c();
        super.onMeasure(i2, i3);
    }

    public void onViewRemoved(View view) {
        super.onViewRemoved(view);
        if (view instanceof MaterialButton) {
            ((MaterialButton) view).setOnPressedChangeListenerInternal((MaterialButton.OnPressedChangeListener) null);
        }
        int indexOfChild = indexOfChild(view);
        if (indexOfChild >= 0) {
            this.s.remove(indexOfChild);
        }
        x();
        c();
    }

    /* access modifiers changed from: package-private */
    public void p(@NonNull MaterialButton materialButton, boolean z) {
        if (!this.b3) {
            f(materialButton.getId(), z);
        }
    }

    public void q(@NonNull OnButtonCheckedListener onButtonCheckedListener) {
        this.Y2.remove(onButtonCheckedListener);
    }

    public void setEnabled(boolean z) {
        super.setEnabled(z);
        for (int i2 = 0; i2 < getChildCount(); i2++) {
            j(i2).setEnabled(z);
        }
    }

    public void setSelectionRequired(boolean z) {
        this.d3 = z;
    }

    public void setSingleSelection(@BoolRes int i2) {
        setSingleSelection(getResources().getBoolean(i2));
    }

    public void t(@IdRes int i2) {
        f(i2, false);
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    public void x() {
        int childCount = getChildCount();
        int firstVisibleChildIndex = getFirstVisibleChildIndex();
        int lastVisibleChildIndex = getLastVisibleChildIndex();
        for (int i2 = 0; i2 < childCount; i2++) {
            MaterialButton j2 = j(i2);
            if (j2.getVisibility() != 8) {
                ShapeAppearanceModel.Builder v = j2.getShapeAppearanceModel().v();
                u(v, l(i2, firstVisibleChildIndex, lastVisibleChildIndex));
                j2.setShapeAppearanceModel(v.m());
            }
        }
    }

    public MaterialButtonToggleGroup(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.nc);
    }

    public void setSingleSelection(boolean z) {
        if (this.c3 != z) {
            this.c3 = z;
            g();
        }
        y();
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public MaterialButtonToggleGroup(@androidx.annotation.NonNull android.content.Context r7, @androidx.annotation.Nullable android.util.AttributeSet r8, int r9) {
        /*
            r6 = this;
            int r4 = h3
            android.content.Context r7 = com.google.android.material.theme.overlay.MaterialThemeOverlay.c(r7, r8, r9, r4)
            r6.<init>(r7, r8, r9)
            java.util.ArrayList r7 = new java.util.ArrayList
            r7.<init>()
            r6.s = r7
            com.google.android.material.button.MaterialButtonToggleGroup$PressedStateTracker r7 = new com.google.android.material.button.MaterialButtonToggleGroup$PressedStateTracker
            r0 = 0
            r7.<init>()
            r6.X2 = r7
            java.util.LinkedHashSet r7 = new java.util.LinkedHashSet
            r7.<init>()
            r6.Y2 = r7
            com.google.android.material.button.MaterialButtonToggleGroup$1 r7 = new com.google.android.material.button.MaterialButtonToggleGroup$1
            r7.<init>()
            r6.Z2 = r7
            r7 = 0
            r6.b3 = r7
            java.util.HashSet r0 = new java.util.HashSet
            r0.<init>()
            r6.f3 = r0
            android.content.Context r0 = r6.getContext()
            int[] r2 = com.google.android.material.R.styleable.Am
            int[] r5 = new int[r7]
            r1 = r8
            r3 = r9
            android.content.res.TypedArray r8 = com.google.android.material.internal.ThemeEnforcement.k(r0, r1, r2, r3, r4, r5)
            int r9 = com.google.android.material.R.styleable.Em
            boolean r9 = r8.getBoolean(r9, r7)
            r6.setSingleSelection((boolean) r9)
            int r9 = com.google.android.material.R.styleable.Cm
            r0 = -1
            int r9 = r8.getResourceId(r9, r0)
            r6.e3 = r9
            int r9 = com.google.android.material.R.styleable.Dm
            boolean r7 = r8.getBoolean(r9, r7)
            r6.d3 = r7
            r7 = 1
            r6.setChildrenDrawingOrderEnabled(r7)
            int r9 = com.google.android.material.R.styleable.Bm
            boolean r9 = r8.getBoolean(r9, r7)
            r6.setEnabled(r9)
            r8.recycle()
            androidx.core.view.ViewCompat.Z1(r6, r7)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.button.MaterialButtonToggleGroup.<init>(android.content.Context, android.util.AttributeSet, int):void");
    }
}
