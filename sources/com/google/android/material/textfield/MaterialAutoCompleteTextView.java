package com.google.android.material.textfield;

import android.accessibilityservice.AccessibilityServiceInfo;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.text.method.KeyListener;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Filterable;
import android.widget.ListAdapter;
import android.widget.TextView;
import androidx.annotation.ArrayRes;
import androidx.annotation.ColorInt;
import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatAutoCompleteTextView;
import androidx.appcompat.widget.ListPopupWindow;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.ViewCompat;
import com.google.android.material.R;
import com.google.android.material.color.MaterialColors;
import com.google.android.material.internal.ManufacturerUtils;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.resources.MaterialResources;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.theme.overlay.MaterialThemeOverlay;
import java.util.List;

public class MaterialAutoCompleteTextView extends AppCompatAutoCompleteTextView {
    private static final int i3 = 15;
    private static final String j3 = "SwitchAccess";
    /* access modifiers changed from: private */
    @NonNull
    public final ListPopupWindow a3;
    @Nullable
    private final AccessibilityManager b3;
    @NonNull
    private final Rect c3;
    @LayoutRes
    private final int d3;
    private final float e3;
    @Nullable
    private ColorStateList f3;
    /* access modifiers changed from: private */
    public int g3;
    /* access modifiers changed from: private */
    @Nullable
    public ColorStateList h3;

    private class MaterialArrayAdapter<T> extends ArrayAdapter<String> {
        @Nullable
        private ColorStateList X;
        @Nullable
        private ColorStateList s;

        MaterialArrayAdapter(@NonNull Context context, int i2, @NonNull String[] strArr) {
            super(context, i2, strArr);
            f();
        }

        @Nullable
        private ColorStateList a() {
            if (!c() || !d()) {
                return null;
            }
            int[] iArr = {16843623, -16842919};
            int[] iArr2 = {16842913, -16842919};
            return new ColorStateList(new int[][]{iArr2, iArr, new int[0]}, new int[]{MaterialColors.s(MaterialAutoCompleteTextView.this.g3, MaterialAutoCompleteTextView.this.h3.getColorForState(iArr2, 0)), MaterialColors.s(MaterialAutoCompleteTextView.this.g3, MaterialAutoCompleteTextView.this.h3.getColorForState(iArr, 0)), MaterialAutoCompleteTextView.this.g3});
        }

        @Nullable
        private Drawable b() {
            if (!c()) {
                return null;
            }
            ColorDrawable colorDrawable = new ColorDrawable(MaterialAutoCompleteTextView.this.g3);
            if (this.X == null) {
                return colorDrawable;
            }
            DrawableCompat.o(colorDrawable, this.s);
            return new RippleDrawable(this.X, colorDrawable, (Drawable) null);
        }

        private boolean c() {
            return MaterialAutoCompleteTextView.this.g3 != 0;
        }

        private boolean d() {
            return MaterialAutoCompleteTextView.this.h3 != null;
        }

        private ColorStateList e() {
            if (!d()) {
                return null;
            }
            int[] iArr = {16842919};
            return new ColorStateList(new int[][]{iArr, new int[0]}, new int[]{MaterialAutoCompleteTextView.this.h3.getColorForState(iArr, 0), 0});
        }

        /* access modifiers changed from: package-private */
        public void f() {
            this.X = e();
            this.s = a();
        }

        public View getView(int i2, @Nullable View view, ViewGroup viewGroup) {
            View view2 = super.getView(i2, view, viewGroup);
            if (view2 instanceof TextView) {
                TextView textView = (TextView) view2;
                ViewCompat.P1(textView, MaterialAutoCompleteTextView.this.getText().toString().contentEquals(textView.getText()) ? b() : null);
            }
            return view2;
        }
    }

    public MaterialAutoCompleteTextView(@NonNull Context context) {
        this(context, (AttributeSet) null);
    }

    @Nullable
    private TextInputLayout g() {
        for (ViewParent parent = getParent(); parent != null; parent = parent.getParent()) {
            if (parent instanceof TextInputLayout) {
                return (TextInputLayout) parent;
            }
        }
        return null;
    }

    private boolean h() {
        return j() || i();
    }

    private boolean i() {
        List<AccessibilityServiceInfo> enabledAccessibilityServiceList;
        AccessibilityManager accessibilityManager = this.b3;
        if (!(accessibilityManager == null || !accessibilityManager.isEnabled() || (enabledAccessibilityServiceList = this.b3.getEnabledAccessibilityServiceList(16)) == null)) {
            for (AccessibilityServiceInfo next : enabledAccessibilityServiceList) {
                if (next.getSettingsActivityName() != null && next.getSettingsActivityName().contains(j3)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean j() {
        AccessibilityManager accessibilityManager = this.b3;
        return accessibilityManager != null && accessibilityManager.isTouchExplorationEnabled();
    }

    private int k() {
        ListAdapter adapter = getAdapter();
        TextInputLayout g2 = g();
        int i2 = 0;
        if (adapter == null || g2 == null) {
            return 0;
        }
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 0);
        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 0);
        int min = Math.min(adapter.getCount(), Math.max(0, this.a3.E()) + 15);
        View view = null;
        int i4 = 0;
        for (int max = Math.max(0, min - 15); max < min; max++) {
            int itemViewType = adapter.getItemViewType(max);
            if (itemViewType != i2) {
                view = null;
                i2 = itemViewType;
            }
            view = adapter.getView(max, view, g2);
            if (view.getLayoutParams() == null) {
                view.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
            }
            view.measure(makeMeasureSpec, makeMeasureSpec2);
            i4 = Math.max(i4, view.getMeasuredWidth());
        }
        Drawable i5 = this.a3.i();
        if (i5 != null) {
            i5.getPadding(this.c3);
            Rect rect = this.c3;
            i4 += rect.left + rect.right;
        }
        return i4 + g2.getEndIconView().getMeasuredWidth();
    }

    private void l() {
        TextInputLayout g2 = g();
        if (g2 != null) {
            g2.L0();
        }
    }

    /* access modifiers changed from: private */
    public <T extends ListAdapter & Filterable> void m(Object obj) {
        setText(convertSelectionToString(obj), false);
    }

    public void dismissDropDown() {
        if (h()) {
            this.a3.dismiss();
        } else {
            super.dismissDropDown();
        }
    }

    @Nullable
    public ColorStateList getDropDownBackgroundTintList() {
        return this.f3;
    }

    @Nullable
    public CharSequence getHint() {
        TextInputLayout g2 = g();
        return (g2 == null || !g2.c0()) ? super.getHint() : g2.getHint();
    }

    public float getPopupElevation() {
        return this.e3;
    }

    public int getSimpleItemSelectedColor() {
        return this.g3;
    }

    @Nullable
    public ColorStateList getSimpleItemSelectedRippleColor() {
        return this.h3;
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        TextInputLayout g2 = g();
        if (g2 != null && g2.c0() && super.getHint() == null && ManufacturerUtils.d()) {
            setHint("");
        }
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.a3.dismiss();
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i4) {
        super.onMeasure(i2, i4);
        if (View.MeasureSpec.getMode(i2) == Integer.MIN_VALUE) {
            setMeasuredDimension(Math.min(Math.max(getMeasuredWidth(), k()), View.MeasureSpec.getSize(i2)), getMeasuredHeight());
        }
    }

    public void onWindowFocusChanged(boolean z) {
        if (!h()) {
            super.onWindowFocusChanged(z);
        }
    }

    public <T extends ListAdapter & Filterable> void setAdapter(@Nullable T t) {
        super.setAdapter(t);
        this.a3.q(getAdapter());
    }

    public void setDropDownBackgroundDrawable(Drawable drawable) {
        super.setDropDownBackgroundDrawable(drawable);
        ListPopupWindow listPopupWindow = this.a3;
        if (listPopupWindow != null) {
            listPopupWindow.c(drawable);
        }
    }

    public void setDropDownBackgroundTint(@ColorInt int i2) {
        setDropDownBackgroundTintList(ColorStateList.valueOf(i2));
    }

    public void setDropDownBackgroundTintList(@Nullable ColorStateList colorStateList) {
        this.f3 = colorStateList;
        Drawable dropDownBackground = getDropDownBackground();
        if (dropDownBackground instanceof MaterialShapeDrawable) {
            ((MaterialShapeDrawable) dropDownBackground).p0(this.f3);
        }
    }

    public void setOnItemSelectedListener(@Nullable AdapterView.OnItemSelectedListener onItemSelectedListener) {
        super.setOnItemSelectedListener(onItemSelectedListener);
        this.a3.g0(getOnItemSelectedListener());
    }

    public void setRawInputType(int i2) {
        super.setRawInputType(i2);
        l();
    }

    public void setSimpleItemSelectedColor(int i2) {
        this.g3 = i2;
        if (getAdapter() instanceof MaterialArrayAdapter) {
            ((MaterialArrayAdapter) getAdapter()).f();
        }
    }

    public void setSimpleItemSelectedRippleColor(@Nullable ColorStateList colorStateList) {
        this.h3 = colorStateList;
        if (getAdapter() instanceof MaterialArrayAdapter) {
            ((MaterialArrayAdapter) getAdapter()).f();
        }
    }

    public void setSimpleItems(@ArrayRes int i2) {
        setSimpleItems(getResources().getStringArray(i2));
    }

    public void showDropDown() {
        if (h()) {
            this.a3.a();
        } else {
            super.showDropDown();
        }
    }

    public MaterialAutoCompleteTextView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.f0);
    }

    public void setSimpleItems(@NonNull String[] strArr) {
        setAdapter(new MaterialArrayAdapter(getContext(), this.d3, strArr));
    }

    public MaterialAutoCompleteTextView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(MaterialThemeOverlay.c(context, attributeSet, i2, 0), attributeSet, i2);
        this.c3 = new Rect();
        Context context2 = getContext();
        TypedArray k2 = ThemeEnforcement.k(context2, attributeSet, R.styleable.Vl, i2, R.style.yd, new int[0]);
        int i4 = R.styleable.Wl;
        if (k2.hasValue(i4) && k2.getInt(i4, 0) == 0) {
            setKeyListener((KeyListener) null);
        }
        this.d3 = k2.getResourceId(R.styleable.Zl, R.layout.t0);
        this.e3 = (float) k2.getDimensionPixelOffset(R.styleable.Xl, R.dimen.Zb);
        int i5 = R.styleable.Yl;
        if (k2.hasValue(i5)) {
            this.f3 = ColorStateList.valueOf(k2.getColor(i5, 0));
        }
        this.g3 = k2.getColor(R.styleable.am, 0);
        this.h3 = MaterialResources.a(context2, k2, R.styleable.bm);
        this.b3 = (AccessibilityManager) context2.getSystemService("accessibility");
        ListPopupWindow listPopupWindow = new ListPopupWindow(context2);
        this.a3 = listPopupWindow;
        listPopupWindow.d0(true);
        listPopupWindow.S(this);
        listPopupWindow.a0(2);
        listPopupWindow.q(getAdapter());
        listPopupWindow.f0(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
                MaterialAutoCompleteTextView materialAutoCompleteTextView = MaterialAutoCompleteTextView.this;
                MaterialAutoCompleteTextView.this.m(i2 < 0 ? materialAutoCompleteTextView.a3.C() : materialAutoCompleteTextView.getAdapter().getItem(i2));
                AdapterView.OnItemClickListener onItemClickListener = MaterialAutoCompleteTextView.this.getOnItemClickListener();
                if (onItemClickListener != null) {
                    if (view == null || i2 < 0) {
                        view = MaterialAutoCompleteTextView.this.a3.F();
                        i2 = MaterialAutoCompleteTextView.this.a3.E();
                        j2 = MaterialAutoCompleteTextView.this.a3.D();
                    }
                    onItemClickListener.onItemClick(MaterialAutoCompleteTextView.this.a3.k(), view, i2, j2);
                }
                MaterialAutoCompleteTextView.this.a3.dismiss();
            }
        });
        int i6 = R.styleable.cm;
        if (k2.hasValue(i6)) {
            setSimpleItems(k2.getResourceId(i6, 0));
        }
        k2.recycle();
    }
}
