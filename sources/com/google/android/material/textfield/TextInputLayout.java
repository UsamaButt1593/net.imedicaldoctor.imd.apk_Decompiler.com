package com.google.android.material.textfield;

import android.animation.ValueAnimator;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStructure;
import android.view.ViewTreeObserver;
import android.view.accessibility.AccessibilityEvent;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.ColorInt;
import androidx.annotation.ColorRes;
import androidx.annotation.DimenRes;
import androidx.annotation.DrawableRes;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.annotation.StringRes;
import androidx.annotation.StyleRes;
import androidx.annotation.VisibleForTesting;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.widget.AppCompatDrawableManager;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.DrawableUtils;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.text.BidiFormatter;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.MarginLayoutParamsCompat;
import androidx.core.view.ViewCompat;
import androidx.core.widget.TextViewCompat;
import androidx.customview.view.AbsSavedState;
import androidx.transition.Fade;
import androidx.transition.TransitionManager;
import com.google.android.material.R;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.color.MaterialColors;
import com.google.android.material.internal.CheckableImageButton;
import com.google.android.material.internal.CollapsingTextHelper;
import com.google.android.material.internal.DescendantOffsetUtils;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.motion.MotionUtils;
import com.google.android.material.resources.MaterialResources;
import com.google.android.material.shape.CornerTreatment;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.ShapeAppearanceModel;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Iterator;
import java.util.LinkedHashSet;

public class TextInputLayout extends LinearLayout implements ViewTreeObserver.OnGlobalLayoutListener {
    private static final int A4 = -1;
    private static final int[][] B4 = {new int[]{16842919}, new int[0]};
    private static final String C4 = "TextInputLayout";
    public static final int D4 = 0;
    public static final int E4 = 1;
    public static final int F4 = 2;
    public static final int G4 = -1;
    public static final int H4 = 0;
    public static final int I4 = 1;
    public static final int J4 = 2;
    public static final int K4 = 3;
    private static final int v4 = R.style.Ve;
    private static final int w4 = 167;
    private static final int x4 = 87;
    private static final int y4 = 67;
    private static final int z4 = -1;
    private boolean A3;
    @Nullable
    private MaterialShapeDrawable B3;
    private MaterialShapeDrawable C3;
    private StateListDrawable D3;
    private boolean E3;
    @Nullable
    private MaterialShapeDrawable F3;
    @Nullable
    private MaterialShapeDrawable G3;
    @NonNull
    private ShapeAppearanceModel H3;
    private boolean I3;
    private final int J3;
    private int K3;
    private int L3;
    private int M3;
    private int N3;
    private int O3;
    @ColorInt
    private int P3;
    @ColorInt
    private int Q3;
    private final Rect R3;
    private final Rect S3;
    private final RectF T3;
    private Typeface U3;
    @Nullable
    private Drawable V3;
    private int W3;
    /* access modifiers changed from: private */
    @NonNull
    public final StartCompoundLayout X2;
    private final LinkedHashSet<OnEditTextAttachedListener> X3;
    /* access modifiers changed from: private */
    @NonNull
    public final EndCompoundLayout Y2;
    @Nullable
    private Drawable Y3;
    EditText Z2;
    private int Z3;
    private CharSequence a3;
    private Drawable a4;
    private int b3;
    private ColorStateList b4;
    private int c3;
    private ColorStateList c4;
    private int d3;
    @ColorInt
    private int d4;
    private int e3;
    @ColorInt
    private int e4;
    /* access modifiers changed from: private */
    public final IndicatorViewController f3;
    @ColorInt
    private int f4;
    boolean g3;
    private ColorStateList g4;
    private int h3;
    @ColorInt
    private int h4;
    private boolean i3;
    @ColorInt
    private int i4;
    @NonNull
    private LengthCounter j3;
    @ColorInt
    private int j4;
    @Nullable
    private TextView k3;
    @ColorInt
    private int k4;
    private int l3;
    @ColorInt
    private int l4;
    private int m3;
    int m4;
    private CharSequence n3;
    private boolean n4;
    /* access modifiers changed from: private */
    public boolean o3;
    final CollapsingTextHelper o4;
    private TextView p3;
    private boolean p4;
    @Nullable
    private ColorStateList q3;
    private boolean q4;
    private int r3;
    private ValueAnimator r4;
    @NonNull
    private final FrameLayout s;
    @Nullable
    private Fade s3;
    private boolean s4;
    @Nullable
    private Fade t3;
    /* access modifiers changed from: private */
    public boolean t4;
    @Nullable
    private ColorStateList u3;
    private boolean u4;
    @Nullable
    private ColorStateList v3;
    @Nullable
    private ColorStateList w3;
    @Nullable
    private ColorStateList x3;
    private boolean y3;
    private CharSequence z3;

    public static class AccessibilityDelegate extends AccessibilityDelegateCompat {

        /* renamed from: d  reason: collision with root package name */
        private final TextInputLayout f22062d;

        public AccessibilityDelegate(@NonNull TextInputLayout textInputLayout) {
            this.f22062d = textInputLayout;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:22:0x008e, code lost:
            if (r3 != null) goto L_0x008a;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void g(@androidx.annotation.NonNull android.view.View r14, @androidx.annotation.NonNull androidx.core.view.accessibility.AccessibilityNodeInfoCompat r15) {
            /*
                r13 = this;
                super.g(r14, r15)
                com.google.android.material.textfield.TextInputLayout r0 = r13.f22062d
                android.widget.EditText r0 = r0.getEditText()
                if (r0 == 0) goto L_0x0010
                android.text.Editable r0 = r0.getText()
                goto L_0x0011
            L_0x0010:
                r0 = 0
            L_0x0011:
                com.google.android.material.textfield.TextInputLayout r1 = r13.f22062d
                java.lang.CharSequence r1 = r1.getHint()
                com.google.android.material.textfield.TextInputLayout r2 = r13.f22062d
                java.lang.CharSequence r2 = r2.getError()
                com.google.android.material.textfield.TextInputLayout r3 = r13.f22062d
                java.lang.CharSequence r3 = r3.getPlaceholderText()
                com.google.android.material.textfield.TextInputLayout r4 = r13.f22062d
                int r4 = r4.getCounterMaxLength()
                com.google.android.material.textfield.TextInputLayout r5 = r13.f22062d
                java.lang.CharSequence r5 = r5.getCounterOverflowDescription()
                boolean r6 = android.text.TextUtils.isEmpty(r0)
                r7 = r6 ^ 1
                boolean r8 = android.text.TextUtils.isEmpty(r1)
                r9 = 1
                r8 = r8 ^ r9
                com.google.android.material.textfield.TextInputLayout r10 = r13.f22062d
                boolean r10 = r10.Z()
                r10 = r10 ^ r9
                boolean r11 = android.text.TextUtils.isEmpty(r2)
                r11 = r11 ^ r9
                if (r11 != 0) goto L_0x0051
                boolean r12 = android.text.TextUtils.isEmpty(r5)
                if (r12 != 0) goto L_0x0050
                goto L_0x0051
            L_0x0050:
                r9 = 0
            L_0x0051:
                if (r8 == 0) goto L_0x0058
                java.lang.String r1 = r1.toString()
                goto L_0x005a
            L_0x0058:
                java.lang.String r1 = ""
            L_0x005a:
                com.google.android.material.textfield.TextInputLayout r8 = r13.f22062d
                com.google.android.material.textfield.StartCompoundLayout r8 = r8.X2
                r8.B(r15)
                java.lang.String r8 = ", "
                if (r7 == 0) goto L_0x006b
                r15.d2(r0)
                goto L_0x0091
            L_0x006b:
                boolean r12 = android.text.TextUtils.isEmpty(r1)
                if (r12 != 0) goto L_0x008e
                r15.d2(r1)
                if (r10 == 0) goto L_0x0091
                if (r3 == 0) goto L_0x0091
                java.lang.StringBuilder r10 = new java.lang.StringBuilder
                r10.<init>()
                r10.append(r1)
                r10.append(r8)
                r10.append(r3)
                java.lang.String r3 = r10.toString()
            L_0x008a:
                r15.d2(r3)
                goto L_0x0091
            L_0x008e:
                if (r3 == 0) goto L_0x0091
                goto L_0x008a
            L_0x0091:
                boolean r3 = android.text.TextUtils.isEmpty(r1)
                if (r3 != 0) goto L_0x00bb
                int r3 = android.os.Build.VERSION.SDK_INT
                r10 = 26
                if (r3 < r10) goto L_0x00a1
                r15.A1(r1)
                goto L_0x00b8
            L_0x00a1:
                if (r7 == 0) goto L_0x00b5
                java.lang.StringBuilder r3 = new java.lang.StringBuilder
                r3.<init>()
                r3.append(r0)
                r3.append(r8)
                r3.append(r1)
                java.lang.String r1 = r3.toString()
            L_0x00b5:
                r15.d2(r1)
            L_0x00b8:
                r15.Z1(r6)
            L_0x00bb:
                if (r0 == 0) goto L_0x00c4
                int r0 = r0.length()
                if (r0 != r4) goto L_0x00c4
                goto L_0x00c5
            L_0x00c4:
                r4 = -1
            L_0x00c5:
                r15.J1(r4)
                if (r9 == 0) goto L_0x00d1
                if (r11 == 0) goto L_0x00cd
                goto L_0x00ce
            L_0x00cd:
                r2 = r5
            L_0x00ce:
                r15.v1(r2)
            L_0x00d1:
                com.google.android.material.textfield.TextInputLayout r0 = r13.f22062d
                com.google.android.material.textfield.IndicatorViewController r0 = r0.f3
                android.view.View r0 = r0.u()
                if (r0 == 0) goto L_0x00e0
                r15.D1(r0)
            L_0x00e0:
                com.google.android.material.textfield.TextInputLayout r0 = r13.f22062d
                com.google.android.material.textfield.EndCompoundLayout r0 = r0.Y2
                com.google.android.material.textfield.EndIconDelegate r0 = r0.o()
                r0.o(r14, r15)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.textfield.TextInputLayout.AccessibilityDelegate.g(android.view.View, androidx.core.view.accessibility.AccessibilityNodeInfoCompat):void");
        }

        public void h(@NonNull View view, @NonNull AccessibilityEvent accessibilityEvent) {
            super.h(view, accessibilityEvent);
            this.f22062d.Y2.o().p(view, accessibilityEvent);
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface BoxBackgroundMode {
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    @Retention(RetentionPolicy.SOURCE)
    public @interface EndIconMode {
    }

    public interface LengthCounter {
        int a(@Nullable Editable editable);
    }

    public interface OnEditTextAttachedListener {
        void a(@NonNull TextInputLayout textInputLayout);
    }

    public interface OnEndIconChangedListener {
        void a(@NonNull TextInputLayout textInputLayout, int i2);
    }

    static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.ClassLoaderCreator<SavedState>() {
            @Nullable
            /* renamed from: a */
            public SavedState createFromParcel(@NonNull Parcel parcel) {
                return new SavedState(parcel, (ClassLoader) null);
            }

            @NonNull
            /* renamed from: b */
            public SavedState createFromParcel(@NonNull Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, classLoader);
            }

            @NonNull
            /* renamed from: c */
            public SavedState[] newArray(int i2) {
                return new SavedState[i2];
            }
        };
        @Nullable
        CharSequence Y;
        boolean Z;

        SavedState(@NonNull Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.Y = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
            this.Z = parcel.readInt() != 1 ? false : true;
        }

        @NonNull
        public String toString() {
            return "TextInputLayout.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " error=" + this.Y + "}";
        }

        public void writeToParcel(@NonNull Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
            TextUtils.writeToParcel(this.Y, parcel, i2);
            parcel.writeInt(this.Z ? 1 : 0);
        }

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }
    }

    public TextInputLayout(@NonNull Context context) {
        this(context, (AttributeSet) null);
    }

    private void A0() {
        if (this.p3 != null && this.o3 && !TextUtils.isEmpty(this.n3)) {
            this.p3.setText(this.n3);
            TransitionManager.b(this.s, this.s3);
            this.p3.setVisibility(0);
            this.p3.bringToFront();
            announceForAccessibility(this.n3);
        }
    }

    private void B() {
        if (E()) {
            ((CutoutDrawable) this.B3).U0();
        }
    }

    private void B0() {
        Resources resources;
        int i2;
        if (this.K3 == 1) {
            if (MaterialResources.k(getContext())) {
                resources = getResources();
                i2 = R.dimen.aa;
            } else if (MaterialResources.j(getContext())) {
                resources = getResources();
                i2 = R.dimen.Z9;
            } else {
                return;
            }
            this.L3 = resources.getDimensionPixelSize(i2);
        }
    }

    private void C(boolean z) {
        ValueAnimator valueAnimator = this.r4;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            this.r4.cancel();
        }
        if (!z || !this.q4) {
            this.o4.A0(1.0f);
        } else {
            m(1.0f);
        }
        this.n4 = false;
        if (E()) {
            j0();
        }
        R0();
        this.X2.m(false);
        this.Y2.L(false);
    }

    private void C0(@NonNull Rect rect) {
        MaterialShapeDrawable materialShapeDrawable = this.F3;
        if (materialShapeDrawable != null) {
            int i2 = rect.bottom;
            materialShapeDrawable.setBounds(rect.left, i2 - this.N3, rect.right, i2);
        }
        MaterialShapeDrawable materialShapeDrawable2 = this.G3;
        if (materialShapeDrawable2 != null) {
            int i5 = rect.bottom;
            materialShapeDrawable2.setBounds(rect.left, i5 - this.O3, rect.right, i5);
        }
    }

    private Fade D() {
        Fade fade = new Fade();
        fade.k1((long) MotionUtils.f(getContext(), R.attr.Nd, 87));
        fade.r1(MotionUtils.g(getContext(), R.attr.Xd, AnimationUtils.f20766a));
        return fade;
    }

    private void D0() {
        if (this.k3 != null) {
            EditText editText = this.Z2;
            E0(editText == null ? null : editText.getText());
        }
    }

    private boolean E() {
        return this.y3 && !TextUtils.isEmpty(this.z3) && (this.B3 instanceof CutoutDrawable);
    }

    private static void F0(@NonNull Context context, @NonNull TextView textView, int i2, int i5, boolean z) {
        textView.setContentDescription(context.getString(z ? R.string.Q : R.string.P, new Object[]{Integer.valueOf(i2), Integer.valueOf(i5)}));
    }

    private void G() {
        Iterator<OnEditTextAttachedListener> it2 = this.X3.iterator();
        while (it2.hasNext()) {
            it2.next().a(this);
        }
    }

    private void G0() {
        ColorStateList colorStateList;
        ColorStateList colorStateList2;
        TextView textView = this.k3;
        if (textView != null) {
            w0(textView, this.i3 ? this.l3 : this.m3);
            if (!this.i3 && (colorStateList2 = this.u3) != null) {
                this.k3.setTextColor(colorStateList2);
            }
            if (this.i3 && (colorStateList = this.v3) != null) {
                this.k3.setTextColor(colorStateList);
            }
        }
    }

    private void H(Canvas canvas) {
        MaterialShapeDrawable materialShapeDrawable;
        if (this.G3 != null && (materialShapeDrawable = this.F3) != null) {
            materialShapeDrawable.draw(canvas);
            if (this.Z2.isFocused()) {
                Rect bounds = this.G3.getBounds();
                Rect bounds2 = this.F3.getBounds();
                float G = this.o4.G();
                int centerX = bounds2.centerX();
                bounds.left = AnimationUtils.c(centerX, bounds2.left, G);
                bounds.right = AnimationUtils.c(centerX, bounds2.right, G);
                this.G3.draw(canvas);
            }
        }
    }

    @RequiresApi(29)
    private void H0() {
        ColorStateList colorStateList;
        ColorStateList colorStateList2 = this.w3;
        if (colorStateList2 == null) {
            colorStateList2 = MaterialColors.l(getContext(), R.attr.p3);
        }
        EditText editText = this.Z2;
        if (editText != null && editText.getTextCursorDrawable() != null) {
            Drawable mutate = DrawableCompat.r(this.Z2.getTextCursorDrawable()).mutate();
            if (a0() && (colorStateList = this.x3) != null) {
                colorStateList2 = colorStateList;
            }
            DrawableCompat.o(mutate, colorStateList2);
        }
    }

    private void I(@NonNull Canvas canvas) {
        if (this.y3) {
            this.o4.l(canvas);
        }
    }

    private void J(boolean z) {
        ValueAnimator valueAnimator = this.r4;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            this.r4.cancel();
        }
        if (!z || !this.q4) {
            this.o4.A0(0.0f);
        } else {
            m(0.0f);
        }
        if (E() && ((CutoutDrawable) this.B3).T0()) {
            B();
        }
        this.n4 = true;
        P();
        this.X2.m(true);
        this.Y2.L(true);
    }

    private MaterialShapeDrawable K(boolean z) {
        float dimensionPixelOffset = (float) getResources().getDimensionPixelOffset(R.dimen.md);
        float f2 = z ? dimensionPixelOffset : 0.0f;
        EditText editText = this.Z2;
        float popupElevation = editText instanceof MaterialAutoCompleteTextView ? ((MaterialAutoCompleteTextView) editText).getPopupElevation() : (float) getResources().getDimensionPixelOffset(R.dimen.v5);
        int dimensionPixelOffset2 = getResources().getDimensionPixelOffset(R.dimen.bc);
        ShapeAppearanceModel m2 = ShapeAppearanceModel.a().K(f2).P(f2).x(dimensionPixelOffset).C(dimensionPixelOffset).m();
        EditText editText2 = this.Z2;
        MaterialShapeDrawable o = MaterialShapeDrawable.o(getContext(), popupElevation, editText2 instanceof MaterialAutoCompleteTextView ? ((MaterialAutoCompleteTextView) editText2).getDropDownBackgroundTintList() : null);
        o.setShapeAppearanceModel(m2);
        o.r0(0, dimensionPixelOffset2, 0, dimensionPixelOffset2);
        return o;
    }

    private void K0() {
        ViewCompat.P1(this.Z2, getEditTextBoxBackground());
    }

    private static Drawable L(MaterialShapeDrawable materialShapeDrawable, int i2, int i5, int[][] iArr) {
        return new RippleDrawable(new ColorStateList(iArr, new int[]{MaterialColors.t(i5, i2, 0.1f), i2}), materialShapeDrawable, materialShapeDrawable);
    }

    private int M(int i2, boolean z) {
        return i2 + ((z || getPrefixText() == null) ? (!z || getSuffixText() == null) ? this.Z2.getCompoundPaddingLeft() : this.Y2.A() : this.X2.c());
    }

    private boolean M0() {
        int max;
        if (this.Z2 == null || this.Z2.getMeasuredHeight() >= (max = Math.max(this.Y2.getMeasuredHeight(), this.X2.getMeasuredHeight()))) {
            return false;
        }
        this.Z2.setMinimumHeight(max);
        return true;
    }

    private int N(int i2, boolean z) {
        return i2 - ((z || getSuffixText() == null) ? (!z || getPrefixText() == null) ? this.Z2.getCompoundPaddingRight() : this.X2.c() : this.Y2.A());
    }

    private void N0() {
        if (this.K3 != 1) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.s.getLayoutParams();
            int w = w();
            if (w != layoutParams.topMargin) {
                layoutParams.topMargin = w;
                this.s.requestLayout();
            }
        }
    }

    private static Drawable O(Context context, MaterialShapeDrawable materialShapeDrawable, int i2, int[][] iArr) {
        int c2 = MaterialColors.c(context, R.attr.e4, C4);
        MaterialShapeDrawable materialShapeDrawable2 = new MaterialShapeDrawable(materialShapeDrawable.getShapeAppearanceModel());
        int t = MaterialColors.t(i2, c2, 0.1f);
        materialShapeDrawable2.p0(new ColorStateList(iArr, new int[]{t, 0}));
        materialShapeDrawable2.setTint(c2);
        ColorStateList colorStateList = new ColorStateList(iArr, new int[]{t, c2});
        MaterialShapeDrawable materialShapeDrawable3 = new MaterialShapeDrawable(materialShapeDrawable.getShapeAppearanceModel());
        materialShapeDrawable3.setTint(-1);
        return new LayerDrawable(new Drawable[]{new RippleDrawable(colorStateList, materialShapeDrawable2, materialShapeDrawable3), materialShapeDrawable});
    }

    private void P() {
        TextView textView = this.p3;
        if (textView != null && this.o3) {
            textView.setText((CharSequence) null);
            TransitionManager.b(this.s, this.t3);
            this.p3.setVisibility(4);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:46:0x0096  */
    /* JADX WARNING: Removed duplicated region for block: B:50:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void P0(boolean r6, boolean r7) {
        /*
            r5 = this;
            boolean r0 = r5.isEnabled()
            android.widget.EditText r1 = r5.Z2
            r2 = 0
            r3 = 1
            if (r1 == 0) goto L_0x0016
            android.text.Editable r1 = r1.getText()
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            if (r1 != 0) goto L_0x0016
            r1 = 1
            goto L_0x0017
        L_0x0016:
            r1 = 0
        L_0x0017:
            android.widget.EditText r4 = r5.Z2
            if (r4 == 0) goto L_0x0022
            boolean r4 = r4.hasFocus()
            if (r4 == 0) goto L_0x0022
            r2 = 1
        L_0x0022:
            android.content.res.ColorStateList r3 = r5.b4
            if (r3 == 0) goto L_0x002b
            com.google.android.material.internal.CollapsingTextHelper r4 = r5.o4
            r4.f0(r3)
        L_0x002b:
            if (r0 != 0) goto L_0x004b
            android.content.res.ColorStateList r0 = r5.b4
            if (r0 == 0) goto L_0x003f
            r3 = -16842910(0xfffffffffefeff62, float:-1.6947497E38)
            int[] r3 = new int[]{r3}
            int r4 = r5.l4
            int r0 = r0.getColorForState(r3, r4)
            goto L_0x0041
        L_0x003f:
            int r0 = r5.l4
        L_0x0041:
            com.google.android.material.internal.CollapsingTextHelper r3 = r5.o4
            android.content.res.ColorStateList r0 = android.content.res.ColorStateList.valueOf(r0)
        L_0x0047:
            r3.f0(r0)
            goto L_0x0077
        L_0x004b:
            boolean r0 = r5.x0()
            if (r0 == 0) goto L_0x005d
            com.google.android.material.internal.CollapsingTextHelper r0 = r5.o4
            com.google.android.material.textfield.IndicatorViewController r3 = r5.f3
            android.content.res.ColorStateList r3 = r3.s()
            r0.f0(r3)
            goto L_0x0077
        L_0x005d:
            boolean r0 = r5.i3
            if (r0 == 0) goto L_0x006c
            android.widget.TextView r0 = r5.k3
            if (r0 == 0) goto L_0x006c
            com.google.android.material.internal.CollapsingTextHelper r3 = r5.o4
            android.content.res.ColorStateList r0 = r0.getTextColors()
            goto L_0x0047
        L_0x006c:
            if (r2 == 0) goto L_0x0077
            android.content.res.ColorStateList r0 = r5.c4
            if (r0 == 0) goto L_0x0077
            com.google.android.material.internal.CollapsingTextHelper r3 = r5.o4
            r3.k0(r0)
        L_0x0077:
            if (r1 != 0) goto L_0x0090
            boolean r0 = r5.p4
            if (r0 == 0) goto L_0x0090
            boolean r0 = r5.isEnabled()
            if (r0 == 0) goto L_0x0086
            if (r2 == 0) goto L_0x0086
            goto L_0x0090
        L_0x0086:
            if (r7 != 0) goto L_0x008c
            boolean r7 = r5.n4
            if (r7 != 0) goto L_0x0099
        L_0x008c:
            r5.J(r6)
            goto L_0x0099
        L_0x0090:
            if (r7 != 0) goto L_0x0096
            boolean r7 = r5.n4
            if (r7 == 0) goto L_0x0099
        L_0x0096:
            r5.C(r6)
        L_0x0099:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.textfield.TextInputLayout.P0(boolean, boolean):void");
    }

    private void Q0() {
        EditText editText;
        if (this.p3 != null && (editText = this.Z2) != null) {
            this.p3.setGravity(editText.getGravity());
            this.p3.setPadding(this.Z2.getCompoundPaddingLeft(), this.Z2.getCompoundPaddingTop(), this.Z2.getCompoundPaddingRight(), this.Z2.getCompoundPaddingBottom());
        }
    }

    private void R0() {
        EditText editText = this.Z2;
        S0(editText == null ? null : editText.getText());
    }

    /* access modifiers changed from: private */
    public void S0(@Nullable Editable editable) {
        if (this.j3.a(editable) != 0 || this.n4) {
            P();
        } else {
            A0();
        }
    }

    private void T0(boolean z, boolean z2) {
        int defaultColor = this.g4.getDefaultColor();
        int colorForState = this.g4.getColorForState(new int[]{16843623, 16842910}, defaultColor);
        int colorForState2 = this.g4.getColorForState(new int[]{16843518, 16842910}, defaultColor);
        if (z) {
            this.P3 = colorForState2;
        } else if (z2) {
            this.P3 = colorForState;
        } else {
            this.P3 = defaultColor;
        }
    }

    private boolean a0() {
        return x0() || (this.k3 != null && this.i3);
    }

    private boolean d0() {
        return this.K3 == 1 && this.Z2.getMinLines() <= 1;
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ int g0(Editable editable) {
        if (editable != null) {
            return editable.length();
        }
        return 0;
    }

    @Nullable
    private Drawable getEditTextBoxBackground() {
        EditText editText = this.Z2;
        if (!(editText instanceof AutoCompleteTextView) || EditTextUtils.a(editText)) {
            return this.B3;
        }
        int d2 = MaterialColors.d(this.Z2, R.attr.q3);
        int i2 = this.K3;
        if (i2 == 2) {
            return O(getContext(), this.B3, d2, B4);
        }
        if (i2 == 1) {
            return L(this.B3, this.Q3, d2, B4);
        }
        return null;
    }

    private Drawable getOrCreateFilledDropDownMenuBackground() {
        if (this.D3 == null) {
            StateListDrawable stateListDrawable = new StateListDrawable();
            this.D3 = stateListDrawable;
            stateListDrawable.addState(new int[]{16842922}, getOrCreateOutlinedDropDownMenuBackground());
            this.D3.addState(new int[0], K(false));
        }
        return this.D3;
    }

    private Drawable getOrCreateOutlinedDropDownMenuBackground() {
        if (this.C3 == null) {
            this.C3 = K(true);
        }
        return this.C3;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void h0() {
        this.Z2.requestLayout();
    }

    private void i0() {
        q();
        L0();
        U0();
        B0();
        l();
        if (this.K3 != 0) {
            N0();
        }
        v0();
    }

    private void j0() {
        if (E()) {
            RectF rectF = this.T3;
            this.o4.o(rectF, this.Z2.getWidth(), this.Z2.getGravity());
            if (rectF.width() > 0.0f && rectF.height() > 0.0f) {
                p(rectF);
                rectF.offset((float) (-getPaddingLeft()), (((float) (-getPaddingTop())) - (rectF.height() / 2.0f)) + ((float) this.M3));
                ((CutoutDrawable) this.B3).W0(rectF);
            }
        }
    }

    private void k() {
        TextView textView = this.p3;
        if (textView != null) {
            this.s.addView(textView);
            this.p3.setVisibility(0);
        }
    }

    private void l() {
        EditText editText;
        int n0;
        int dimensionPixelSize;
        int m0;
        Resources resources;
        int i2;
        if (this.Z2 != null && this.K3 == 1) {
            if (MaterialResources.k(getContext())) {
                editText = this.Z2;
                n0 = ViewCompat.n0(editText);
                dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.Y9);
                m0 = ViewCompat.m0(this.Z2);
                resources = getResources();
                i2 = R.dimen.X9;
            } else if (MaterialResources.j(getContext())) {
                editText = this.Z2;
                n0 = ViewCompat.n0(editText);
                dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.W9);
                m0 = ViewCompat.m0(this.Z2);
                resources = getResources();
                i2 = R.dimen.V9;
            } else {
                return;
            }
            ViewCompat.n2(editText, n0, dimensionPixelSize, m0, resources.getDimensionPixelSize(i2));
        }
    }

    private void l0() {
        if (E() && !this.n4) {
            B();
            j0();
        }
    }

    private static void m0(@NonNull ViewGroup viewGroup, boolean z) {
        int childCount = viewGroup.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = viewGroup.getChildAt(i2);
            childAt.setEnabled(z);
            if (childAt instanceof ViewGroup) {
                m0((ViewGroup) childAt, z);
            }
        }
    }

    private void n() {
        MaterialShapeDrawable materialShapeDrawable = this.B3;
        if (materialShapeDrawable != null) {
            ShapeAppearanceModel shapeAppearanceModel = materialShapeDrawable.getShapeAppearanceModel();
            ShapeAppearanceModel shapeAppearanceModel2 = this.H3;
            if (shapeAppearanceModel != shapeAppearanceModel2) {
                this.B3.setShapeAppearanceModel(shapeAppearanceModel2);
            }
            if (x()) {
                this.B3.E0((float) this.M3, this.P3);
            }
            int r = r();
            this.Q3 = r;
            this.B3.p0(ColorStateList.valueOf(r));
            o();
            L0();
        }
    }

    private void o() {
        if (this.F3 != null && this.G3 != null) {
            if (y()) {
                this.F3.p0(ColorStateList.valueOf(this.Z2.isFocused() ? this.d4 : this.P3));
                this.G3.p0(ColorStateList.valueOf(this.P3));
            }
            invalidate();
        }
    }

    private void p(@NonNull RectF rectF) {
        float f2 = rectF.left;
        int i2 = this.J3;
        rectF.left = f2 - ((float) i2);
        rectF.right += (float) i2;
    }

    private void q() {
        int i2 = this.K3;
        if (i2 == 0) {
            this.B3 = null;
        } else if (i2 == 1) {
            this.B3 = new MaterialShapeDrawable(this.H3);
            this.F3 = new MaterialShapeDrawable();
            this.G3 = new MaterialShapeDrawable();
            return;
        } else if (i2 == 2) {
            this.B3 = (!this.y3 || (this.B3 instanceof CutoutDrawable)) ? new MaterialShapeDrawable(this.H3) : CutoutDrawable.R0(this.H3);
        } else {
            throw new IllegalArgumentException(this.K3 + " is illegal; only @BoxBackgroundMode constants are supported.");
        }
        this.F3 = null;
        this.G3 = null;
    }

    private int r() {
        return this.K3 == 1 ? MaterialColors.s(MaterialColors.e(this, R.attr.e4, 0), this.Q3) : this.Q3;
    }

    @NonNull
    private Rect s(@NonNull Rect rect) {
        int i2;
        int i5;
        if (this.Z2 != null) {
            Rect rect2 = this.S3;
            boolean s2 = ViewUtils.s(this);
            rect2.bottom = rect.bottom;
            int i6 = this.K3;
            if (i6 == 1) {
                rect2.left = M(rect.left, s2);
                i2 = rect.top + this.L3;
            } else if (i6 != 2) {
                rect2.left = M(rect.left, s2);
                i2 = getPaddingTop();
            } else {
                rect2.left = rect.left + this.Z2.getPaddingLeft();
                rect2.top = rect.top - w();
                i5 = rect.right - this.Z2.getPaddingRight();
                rect2.right = i5;
                return rect2;
            }
            rect2.top = i2;
            i5 = N(rect.right, s2);
            rect2.right = i5;
            return rect2;
        }
        throw new IllegalStateException();
    }

    private void s0() {
        TextView textView = this.p3;
        if (textView != null) {
            textView.setVisibility(8);
        }
    }

    private void setEditText(EditText editText) {
        if (this.Z2 == null) {
            if (getEndIconMode() != 3 && !(editText instanceof TextInputEditText)) {
                Log.i(C4, "EditText added is not a TextInputEditText. Please switch to using that class instead.");
            }
            this.Z2 = editText;
            int i2 = this.b3;
            if (i2 != -1) {
                setMinEms(i2);
            } else {
                setMinWidth(this.d3);
            }
            int i5 = this.c3;
            if (i5 != -1) {
                setMaxEms(i5);
            } else {
                setMaxWidth(this.e3);
            }
            this.E3 = false;
            i0();
            setTextInputAccessibilityDelegate(new AccessibilityDelegate(this));
            this.o4.P0(this.Z2.getTypeface());
            this.o4.x0(this.Z2.getTextSize());
            int i6 = Build.VERSION.SDK_INT;
            this.o4.s0(this.Z2.getLetterSpacing());
            int gravity = this.Z2.getGravity();
            this.o4.l0((gravity & -113) | 48);
            this.o4.w0(gravity);
            this.m4 = ViewCompat.h0(editText);
            this.Z2.addTextChangedListener(new TextWatcher(editText) {
                final /* synthetic */ EditText X;
                int s;

                {
                    this.X = r2;
                    this.s = r2.getLineCount();
                }

                public void afterTextChanged(@NonNull Editable editable) {
                    int i2;
                    TextInputLayout textInputLayout = TextInputLayout.this;
                    textInputLayout.O0(!textInputLayout.t4);
                    TextInputLayout textInputLayout2 = TextInputLayout.this;
                    if (textInputLayout2.g3) {
                        textInputLayout2.E0(editable);
                    }
                    if (TextInputLayout.this.o3) {
                        TextInputLayout.this.S0(editable);
                    }
                    int lineCount = this.X.getLineCount();
                    int i3 = this.s;
                    if (lineCount != i3) {
                        if (lineCount < i3 && ViewCompat.h0(this.X) != (i2 = TextInputLayout.this.m4)) {
                            this.X.setMinimumHeight(i2);
                        }
                        this.s = lineCount;
                    }
                }

                public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                }

                public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                }
            });
            if (this.b4 == null) {
                this.b4 = this.Z2.getHintTextColors();
            }
            if (this.y3) {
                if (TextUtils.isEmpty(this.z3)) {
                    CharSequence hint = this.Z2.getHint();
                    this.a3 = hint;
                    setHint(hint);
                    this.Z2.setHint((CharSequence) null);
                }
                this.A3 = true;
            }
            if (i6 >= 29) {
                H0();
            }
            if (this.k3 != null) {
                E0(this.Z2.getText());
            }
            J0();
            this.f3.f();
            this.X2.bringToFront();
            this.Y2.bringToFront();
            G();
            this.Y2.D0();
            if (!isEnabled()) {
                editText.setEnabled(false);
            }
            P0(false, true);
            return;
        }
        throw new IllegalArgumentException("We already have an EditText, can only have one");
    }

    private void setHintInternal(CharSequence charSequence) {
        if (!TextUtils.equals(charSequence, this.z3)) {
            this.z3 = charSequence;
            this.o4.M0(charSequence);
            if (!this.n4) {
                j0();
            }
        }
    }

    private void setPlaceholderTextEnabled(boolean z) {
        if (this.o3 != z) {
            if (z) {
                k();
            } else {
                s0();
                this.p3 = null;
            }
            this.o3 = z;
        }
    }

    private int t(@NonNull Rect rect, @NonNull Rect rect2, float f2) {
        return d0() ? (int) (((float) rect2.top) + f2) : rect.bottom - this.Z2.getCompoundPaddingBottom();
    }

    private int u(@NonNull Rect rect, float f2) {
        return d0() ? (int) (((float) rect.centerY()) - (f2 / 2.0f)) : rect.top + this.Z2.getCompoundPaddingTop();
    }

    @NonNull
    private Rect v(@NonNull Rect rect) {
        if (this.Z2 != null) {
            Rect rect2 = this.S3;
            float D = this.o4.D();
            rect2.left = rect.left + this.Z2.getCompoundPaddingLeft();
            rect2.top = u(rect, D);
            rect2.right = rect.right - this.Z2.getCompoundPaddingRight();
            rect2.bottom = t(rect, rect2, D);
            return rect2;
        }
        throw new IllegalStateException();
    }

    private void v0() {
        Drawable orCreateFilledDropDownMenuBackground;
        EditText editText = this.Z2;
        if (editText instanceof AutoCompleteTextView) {
            AutoCompleteTextView autoCompleteTextView = (AutoCompleteTextView) editText;
            if (autoCompleteTextView.getDropDownBackground() == null) {
                int i2 = this.K3;
                if (i2 == 2) {
                    orCreateFilledDropDownMenuBackground = getOrCreateOutlinedDropDownMenuBackground();
                } else if (i2 == 1) {
                    orCreateFilledDropDownMenuBackground = getOrCreateFilledDropDownMenuBackground();
                } else {
                    return;
                }
                autoCompleteTextView.setDropDownBackgroundDrawable(orCreateFilledDropDownMenuBackground);
            }
        }
    }

    private int w() {
        float r;
        if (!this.y3) {
            return 0;
        }
        int i2 = this.K3;
        if (i2 == 0) {
            r = this.o4.r();
        } else if (i2 != 2) {
            return 0;
        } else {
            r = this.o4.r() / 2.0f;
        }
        return (int) r;
    }

    private boolean x() {
        return this.K3 == 2 && y();
    }

    private boolean y() {
        return this.M3 > -1 && this.P3 != 0;
    }

    private boolean y0() {
        return (this.Y2.J() || ((this.Y2.C() && S()) || this.Y2.y() != null)) && this.Y2.getMeasuredWidth() > 0;
    }

    private boolean z0() {
        return (getStartIconDrawable() != null || (getPrefixText() != null && getPrefixTextView().getVisibility() == 0)) && this.X2.getMeasuredWidth() > 0;
    }

    public void A() {
        this.Y2.j();
    }

    /* access modifiers changed from: package-private */
    public void E0(@Nullable Editable editable) {
        int a2 = this.j3.a(editable);
        boolean z = this.i3;
        int i2 = this.h3;
        if (i2 == -1) {
            this.k3.setText(String.valueOf(a2));
            this.k3.setContentDescription((CharSequence) null);
            this.i3 = false;
        } else {
            this.i3 = a2 > i2;
            F0(getContext(), this.k3, a2, this.h3, this.i3);
            if (z != this.i3) {
                G0();
            }
            this.k3.setText(BidiFormatter.c().q(getContext().getString(R.string.R, new Object[]{Integer.valueOf(a2), Integer.valueOf(this.h3)})));
        }
        if (this.Z2 != null && z != this.i3) {
            O0(false);
            U0();
            J0();
        }
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    public boolean F() {
        return E() && ((CutoutDrawable) this.B3).T0();
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0069  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00d5  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean I0() {
        /*
            r10 = this;
            android.widget.EditText r0 = r10.Z2
            r1 = 0
            if (r0 != 0) goto L_0x0006
            return r1
        L_0x0006:
            boolean r0 = r10.z0()
            r2 = 0
            r3 = 2
            r4 = 3
            r5 = 1
            if (r0 == 0) goto L_0x0049
            com.google.android.material.textfield.StartCompoundLayout r0 = r10.X2
            int r0 = r0.getMeasuredWidth()
            android.widget.EditText r6 = r10.Z2
            int r6 = r6.getPaddingLeft()
            int r0 = r0 - r6
            android.graphics.drawable.Drawable r6 = r10.V3
            if (r6 == 0) goto L_0x0025
            int r6 = r10.W3
            if (r6 == r0) goto L_0x0031
        L_0x0025:
            android.graphics.drawable.ColorDrawable r6 = new android.graphics.drawable.ColorDrawable
            r6.<init>()
            r10.V3 = r6
            r10.W3 = r0
            r6.setBounds(r1, r1, r0, r5)
        L_0x0031:
            android.widget.EditText r0 = r10.Z2
            android.graphics.drawable.Drawable[] r0 = androidx.core.widget.TextViewCompat.h(r0)
            r6 = r0[r1]
            android.graphics.drawable.Drawable r7 = r10.V3
            if (r6 == r7) goto L_0x0062
            android.widget.EditText r6 = r10.Z2
            r8 = r0[r5]
            r9 = r0[r3]
            r0 = r0[r4]
            androidx.core.widget.TextViewCompat.u(r6, r7, r8, r9, r0)
            goto L_0x0060
        L_0x0049:
            android.graphics.drawable.Drawable r0 = r10.V3
            if (r0 == 0) goto L_0x0062
            android.widget.EditText r0 = r10.Z2
            android.graphics.drawable.Drawable[] r0 = androidx.core.widget.TextViewCompat.h(r0)
            android.widget.EditText r6 = r10.Z2
            r7 = r0[r5]
            r8 = r0[r3]
            r0 = r0[r4]
            androidx.core.widget.TextViewCompat.u(r6, r2, r7, r8, r0)
            r10.V3 = r2
        L_0x0060:
            r0 = 1
            goto L_0x0063
        L_0x0062:
            r0 = 0
        L_0x0063:
            boolean r6 = r10.y0()
            if (r6 == 0) goto L_0x00d5
            com.google.android.material.textfield.EndCompoundLayout r2 = r10.Y2
            android.widget.TextView r2 = r2.B()
            int r2 = r2.getMeasuredWidth()
            android.widget.EditText r6 = r10.Z2
            int r6 = r6.getPaddingRight()
            int r2 = r2 - r6
            com.google.android.material.textfield.EndCompoundLayout r6 = r10.Y2
            com.google.android.material.internal.CheckableImageButton r6 = r6.m()
            if (r6 == 0) goto L_0x0092
            int r7 = r6.getMeasuredWidth()
            int r2 = r2 + r7
            android.view.ViewGroup$LayoutParams r6 = r6.getLayoutParams()
            android.view.ViewGroup$MarginLayoutParams r6 = (android.view.ViewGroup.MarginLayoutParams) r6
            int r6 = androidx.core.view.MarginLayoutParamsCompat.c(r6)
            int r2 = r2 + r6
        L_0x0092:
            android.widget.EditText r6 = r10.Z2
            android.graphics.drawable.Drawable[] r6 = androidx.core.widget.TextViewCompat.h(r6)
            android.graphics.drawable.Drawable r7 = r10.Y3
            if (r7 == 0) goto L_0x00b3
            int r8 = r10.Z3
            if (r8 == r2) goto L_0x00b3
            r10.Z3 = r2
            r7.setBounds(r1, r1, r2, r5)
            android.widget.EditText r0 = r10.Z2
            r1 = r6[r1]
            r2 = r6[r5]
            android.graphics.drawable.Drawable r3 = r10.Y3
            r4 = r6[r4]
        L_0x00af:
            androidx.core.widget.TextViewCompat.u(r0, r1, r2, r3, r4)
            goto L_0x00d3
        L_0x00b3:
            if (r7 != 0) goto L_0x00c1
            android.graphics.drawable.ColorDrawable r7 = new android.graphics.drawable.ColorDrawable
            r7.<init>()
            r10.Y3 = r7
            r10.Z3 = r2
            r7.setBounds(r1, r1, r2, r5)
        L_0x00c1:
            r2 = r6[r3]
            android.graphics.drawable.Drawable r3 = r10.Y3
            if (r2 == r3) goto L_0x00d2
            r10.a4 = r2
            android.widget.EditText r0 = r10.Z2
            r1 = r6[r1]
            r2 = r6[r5]
            r4 = r6[r4]
            goto L_0x00af
        L_0x00d2:
            r5 = r0
        L_0x00d3:
            r0 = r5
            goto L_0x00f7
        L_0x00d5:
            android.graphics.drawable.Drawable r6 = r10.Y3
            if (r6 == 0) goto L_0x00f7
            android.widget.EditText r6 = r10.Z2
            android.graphics.drawable.Drawable[] r6 = androidx.core.widget.TextViewCompat.h(r6)
            r3 = r6[r3]
            android.graphics.drawable.Drawable r7 = r10.Y3
            if (r3 != r7) goto L_0x00f3
            android.widget.EditText r0 = r10.Z2
            r1 = r6[r1]
            r3 = r6[r5]
            android.graphics.drawable.Drawable r7 = r10.a4
            r4 = r6[r4]
            androidx.core.widget.TextViewCompat.u(r0, r1, r3, r7, r4)
            goto L_0x00f4
        L_0x00f3:
            r5 = r0
        L_0x00f4:
            r10.Y3 = r2
            goto L_0x00d3
        L_0x00f7:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.textfield.TextInputLayout.I0():boolean");
    }

    /* access modifiers changed from: package-private */
    public void J0() {
        Drawable background;
        TextView textView;
        int currentTextColor;
        EditText editText = this.Z2;
        if (editText != null && this.K3 == 0 && (background = editText.getBackground()) != null) {
            if (DrawableUtils.a(background)) {
                background = background.mutate();
            }
            if (x0()) {
                currentTextColor = getErrorCurrentTextColors();
            } else if (!this.i3 || (textView = this.k3) == null) {
                DrawableCompat.c(background);
                this.Z2.refreshDrawableState();
                return;
            } else {
                currentTextColor = textView.getCurrentTextColor();
            }
            background.setColorFilter(AppCompatDrawableManager.e(currentTextColor, PorterDuff.Mode.SRC_IN));
        }
    }

    /* access modifiers changed from: package-private */
    public void L0() {
        EditText editText = this.Z2;
        if (editText != null && this.B3 != null) {
            if ((this.E3 || editText.getBackground() == null) && this.K3 != 0) {
                K0();
                this.E3 = true;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void O0(boolean z) {
        P0(z, false);
    }

    public boolean Q() {
        return this.g3;
    }

    public boolean R() {
        return this.Y2.G();
    }

    public boolean S() {
        return this.Y2.I();
    }

    public boolean T() {
        return this.f3.F();
    }

    public boolean U() {
        return this.p4;
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0012, code lost:
        r0 = r5.Z2;
     */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x0074  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0084  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x00a1  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void U0() {
        /*
            r5 = this;
            com.google.android.material.shape.MaterialShapeDrawable r0 = r5.B3
            if (r0 == 0) goto L_0x00be
            int r0 = r5.K3
            if (r0 != 0) goto L_0x000a
            goto L_0x00be
        L_0x000a:
            boolean r0 = r5.isFocused()
            r1 = 0
            r2 = 1
            if (r0 != 0) goto L_0x001f
            android.widget.EditText r0 = r5.Z2
            if (r0 == 0) goto L_0x001d
            boolean r0 = r0.hasFocus()
            if (r0 == 0) goto L_0x001d
            goto L_0x001f
        L_0x001d:
            r0 = 0
            goto L_0x0020
        L_0x001f:
            r0 = 1
        L_0x0020:
            boolean r3 = r5.isHovered()
            if (r3 != 0) goto L_0x0030
            android.widget.EditText r3 = r5.Z2
            if (r3 == 0) goto L_0x0031
            boolean r3 = r3.isHovered()
            if (r3 == 0) goto L_0x0031
        L_0x0030:
            r1 = 1
        L_0x0031:
            boolean r3 = r5.isEnabled()
            if (r3 != 0) goto L_0x003c
            int r3 = r5.l4
        L_0x0039:
            r5.P3 = r3
            goto L_0x006e
        L_0x003c:
            boolean r3 = r5.x0()
            if (r3 == 0) goto L_0x004f
            android.content.res.ColorStateList r3 = r5.g4
            if (r3 == 0) goto L_0x004a
        L_0x0046:
            r5.T0(r0, r1)
            goto L_0x006e
        L_0x004a:
            int r3 = r5.getErrorCurrentTextColors()
            goto L_0x0039
        L_0x004f:
            boolean r3 = r5.i3
            if (r3 == 0) goto L_0x0061
            android.widget.TextView r3 = r5.k3
            if (r3 == 0) goto L_0x0061
            android.content.res.ColorStateList r4 = r5.g4
            if (r4 == 0) goto L_0x005c
            goto L_0x0046
        L_0x005c:
            int r3 = r3.getCurrentTextColor()
            goto L_0x0039
        L_0x0061:
            if (r0 == 0) goto L_0x0066
            int r3 = r5.f4
            goto L_0x0039
        L_0x0066:
            if (r1 == 0) goto L_0x006b
            int r3 = r5.e4
            goto L_0x0039
        L_0x006b:
            int r3 = r5.d4
            goto L_0x0039
        L_0x006e:
            int r3 = android.os.Build.VERSION.SDK_INT
            r4 = 29
            if (r3 < r4) goto L_0x0077
            r5.H0()
        L_0x0077:
            com.google.android.material.textfield.EndCompoundLayout r3 = r5.Y2
            r3.M()
            r5.p0()
            int r3 = r5.K3
            r4 = 2
            if (r3 != r4) goto L_0x009d
            int r3 = r5.M3
            if (r0 == 0) goto L_0x0093
            boolean r4 = r5.isEnabled()
            if (r4 == 0) goto L_0x0093
            int r4 = r5.O3
        L_0x0090:
            r5.M3 = r4
            goto L_0x0096
        L_0x0093:
            int r4 = r5.N3
            goto L_0x0090
        L_0x0096:
            int r4 = r5.M3
            if (r4 == r3) goto L_0x009d
            r5.l0()
        L_0x009d:
            int r3 = r5.K3
            if (r3 != r2) goto L_0x00bb
            boolean r2 = r5.isEnabled()
            if (r2 != 0) goto L_0x00ac
            int r0 = r5.i4
        L_0x00a9:
            r5.Q3 = r0
            goto L_0x00bb
        L_0x00ac:
            if (r1 == 0) goto L_0x00b3
            if (r0 != 0) goto L_0x00b3
            int r0 = r5.k4
            goto L_0x00a9
        L_0x00b3:
            if (r0 == 0) goto L_0x00b8
            int r0 = r5.j4
            goto L_0x00a9
        L_0x00b8:
            int r0 = r5.h4
            goto L_0x00a9
        L_0x00bb:
            r5.n()
        L_0x00be:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.textfield.TextInputLayout.U0():void");
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    public final boolean V() {
        return this.f3.y();
    }

    public boolean W() {
        return this.f3.G();
    }

    public boolean X() {
        return this.q4;
    }

    public boolean Y() {
        return this.y3;
    }

    /* access modifiers changed from: package-private */
    public final boolean Z() {
        return this.n4;
    }

    public void addView(@NonNull View view, int i2, @NonNull ViewGroup.LayoutParams layoutParams) {
        if (view instanceof EditText) {
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(layoutParams);
            layoutParams2.gravity = (layoutParams2.gravity & -113) | 16;
            this.s.addView(view, layoutParams2);
            this.s.setLayoutParams(layoutParams);
            N0();
            setEditText((EditText) view);
            return;
        }
        super.addView(view, i2, layoutParams);
    }

    @Deprecated
    public boolean b0() {
        return this.Y2.K();
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public boolean c0() {
        return this.A3;
    }

    @TargetApi(26)
    public void dispatchProvideAutofillStructure(@NonNull ViewStructure viewStructure, int i2) {
        EditText editText = this.Z2;
        if (editText == null) {
            super.dispatchProvideAutofillStructure(viewStructure, i2);
            return;
        }
        if (this.a3 != null) {
            boolean z = this.A3;
            this.A3 = false;
            CharSequence hint = editText.getHint();
            this.Z2.setHint(this.a3);
            try {
                super.dispatchProvideAutofillStructure(viewStructure, i2);
            } finally {
                this.Z2.setHint(hint);
                this.A3 = z;
            }
        } else {
            viewStructure.setAutofillId(getAutofillId());
            onProvideAutofillStructure(viewStructure, i2);
            onProvideAutofillVirtualStructure(viewStructure, i2);
            viewStructure.setChildCount(this.s.getChildCount());
            for (int i5 = 0; i5 < this.s.getChildCount(); i5++) {
                View childAt = this.s.getChildAt(i5);
                ViewStructure a2 = viewStructure.newChild(i5);
                childAt.dispatchProvideAutofillStructure(a2, i2);
                if (childAt == this.Z2) {
                    a2.setHint(getHint());
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public void dispatchRestoreInstanceState(@NonNull SparseArray<Parcelable> sparseArray) {
        this.t4 = true;
        super.dispatchRestoreInstanceState(sparseArray);
        this.t4 = false;
    }

    public void draw(@NonNull Canvas canvas) {
        super.draw(canvas);
        I(canvas);
        H(canvas);
    }

    /* access modifiers changed from: protected */
    public void drawableStateChanged() {
        if (!this.s4) {
            boolean z = true;
            this.s4 = true;
            super.drawableStateChanged();
            int[] drawableState = getDrawableState();
            CollapsingTextHelper collapsingTextHelper = this.o4;
            boolean K0 = collapsingTextHelper != null ? collapsingTextHelper.K0(drawableState) : false;
            if (this.Z2 != null) {
                if (!ViewCompat.Y0(this) || !isEnabled()) {
                    z = false;
                }
                O0(z);
            }
            J0();
            U0();
            if (K0) {
                invalidate();
            }
            this.s4 = false;
        }
    }

    public boolean e0() {
        return this.X2.k();
    }

    public boolean f0() {
        return this.X2.l();
    }

    public int getBaseline() {
        EditText editText = this.Z2;
        return editText != null ? editText.getBaseline() + getPaddingTop() + w() : super.getBaseline();
    }

    /* access modifiers changed from: package-private */
    @NonNull
    public MaterialShapeDrawable getBoxBackground() {
        int i2 = this.K3;
        if (i2 == 1 || i2 == 2) {
            return this.B3;
        }
        throw new IllegalStateException();
    }

    public int getBoxBackgroundColor() {
        return this.Q3;
    }

    public int getBoxBackgroundMode() {
        return this.K3;
    }

    public int getBoxCollapsedPaddingTop() {
        return this.L3;
    }

    public float getBoxCornerRadiusBottomEnd() {
        return (ViewUtils.s(this) ? this.H3.j() : this.H3.l()).a(this.T3);
    }

    public float getBoxCornerRadiusBottomStart() {
        return (ViewUtils.s(this) ? this.H3.l() : this.H3.j()).a(this.T3);
    }

    public float getBoxCornerRadiusTopEnd() {
        return (ViewUtils.s(this) ? this.H3.r() : this.H3.t()).a(this.T3);
    }

    public float getBoxCornerRadiusTopStart() {
        return (ViewUtils.s(this) ? this.H3.t() : this.H3.r()).a(this.T3);
    }

    public int getBoxStrokeColor() {
        return this.f4;
    }

    @Nullable
    public ColorStateList getBoxStrokeErrorColor() {
        return this.g4;
    }

    public int getBoxStrokeWidth() {
        return this.N3;
    }

    public int getBoxStrokeWidthFocused() {
        return this.O3;
    }

    public int getCounterMaxLength() {
        return this.h3;
    }

    /* access modifiers changed from: package-private */
    @Nullable
    public CharSequence getCounterOverflowDescription() {
        TextView textView;
        if (!this.g3 || !this.i3 || (textView = this.k3) == null) {
            return null;
        }
        return textView.getContentDescription();
    }

    @Nullable
    public ColorStateList getCounterOverflowTextColor() {
        return this.v3;
    }

    @Nullable
    public ColorStateList getCounterTextColor() {
        return this.u3;
    }

    @RequiresApi(29)
    @Nullable
    public ColorStateList getCursorColor() {
        return this.w3;
    }

    @RequiresApi(29)
    @Nullable
    public ColorStateList getCursorErrorColor() {
        return this.x3;
    }

    @Nullable
    public ColorStateList getDefaultHintTextColor() {
        return this.b4;
    }

    @Nullable
    public EditText getEditText() {
        return this.Z2;
    }

    @Nullable
    public CharSequence getEndIconContentDescription() {
        return this.Y2.n();
    }

    @Nullable
    public Drawable getEndIconDrawable() {
        return this.Y2.p();
    }

    public int getEndIconMinSize() {
        return this.Y2.q();
    }

    public int getEndIconMode() {
        return this.Y2.r();
    }

    @NonNull
    public ImageView.ScaleType getEndIconScaleType() {
        return this.Y2.s();
    }

    /* access modifiers changed from: package-private */
    @NonNull
    public CheckableImageButton getEndIconView() {
        return this.Y2.t();
    }

    @Nullable
    public CharSequence getError() {
        if (this.f3.F()) {
            return this.f3.q();
        }
        return null;
    }

    public int getErrorAccessibilityLiveRegion() {
        return this.f3.o();
    }

    @Nullable
    public CharSequence getErrorContentDescription() {
        return this.f3.p();
    }

    @ColorInt
    public int getErrorCurrentTextColors() {
        return this.f3.r();
    }

    @Nullable
    public Drawable getErrorIconDrawable() {
        return this.Y2.u();
    }

    @Nullable
    public CharSequence getHelperText() {
        if (this.f3.G()) {
            return this.f3.t();
        }
        return null;
    }

    @ColorInt
    public int getHelperTextCurrentTextColor() {
        return this.f3.w();
    }

    @Nullable
    public CharSequence getHint() {
        if (this.y3) {
            return this.z3;
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    public final float getHintCollapsedTextHeight() {
        return this.o4.r();
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    public final int getHintCurrentCollapsedTextColor() {
        return this.o4.w();
    }

    @Nullable
    public ColorStateList getHintTextColor() {
        return this.c4;
    }

    @NonNull
    public LengthCounter getLengthCounter() {
        return this.j3;
    }

    public int getMaxEms() {
        return this.c3;
    }

    @Px
    public int getMaxWidth() {
        return this.e3;
    }

    public int getMinEms() {
        return this.b3;
    }

    @Px
    public int getMinWidth() {
        return this.d3;
    }

    @Deprecated
    @Nullable
    public CharSequence getPasswordVisibilityToggleContentDescription() {
        return this.Y2.w();
    }

    @Deprecated
    @Nullable
    public Drawable getPasswordVisibilityToggleDrawable() {
        return this.Y2.x();
    }

    @Nullable
    public CharSequence getPlaceholderText() {
        if (this.o3) {
            return this.n3;
        }
        return null;
    }

    @StyleRes
    public int getPlaceholderTextAppearance() {
        return this.r3;
    }

    @Nullable
    public ColorStateList getPlaceholderTextColor() {
        return this.q3;
    }

    @Nullable
    public CharSequence getPrefixText() {
        return this.X2.a();
    }

    @Nullable
    public ColorStateList getPrefixTextColor() {
        return this.X2.b();
    }

    @NonNull
    public TextView getPrefixTextView() {
        return this.X2.d();
    }

    @NonNull
    public ShapeAppearanceModel getShapeAppearanceModel() {
        return this.H3;
    }

    @Nullable
    public CharSequence getStartIconContentDescription() {
        return this.X2.e();
    }

    @Nullable
    public Drawable getStartIconDrawable() {
        return this.X2.f();
    }

    public int getStartIconMinSize() {
        return this.X2.g();
    }

    @NonNull
    public ImageView.ScaleType getStartIconScaleType() {
        return this.X2.h();
    }

    @Nullable
    public CharSequence getSuffixText() {
        return this.Y2.y();
    }

    @Nullable
    public ColorStateList getSuffixTextColor() {
        return this.Y2.z();
    }

    @NonNull
    public TextView getSuffixTextView() {
        return this.Y2.B();
    }

    @Nullable
    public Typeface getTypeface() {
        return this.U3;
    }

    public void i(@NonNull OnEditTextAttachedListener onEditTextAttachedListener) {
        this.X3.add(onEditTextAttachedListener);
        if (this.Z2 != null) {
            onEditTextAttachedListener.a(this);
        }
    }

    public void j(@NonNull OnEndIconChangedListener onEndIconChangedListener) {
        this.Y2.g(onEndIconChangedListener);
    }

    @Deprecated
    public void k0(boolean z) {
        this.Y2.A0(z);
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    public void m(float f2) {
        if (this.o4.G() != f2) {
            if (this.r4 == null) {
                ValueAnimator valueAnimator = new ValueAnimator();
                this.r4 = valueAnimator;
                valueAnimator.setInterpolator(MotionUtils.g(getContext(), R.attr.Vd, AnimationUtils.f20767b));
                this.r4.setDuration((long) MotionUtils.f(getContext(), R.attr.Ld, w4));
                this.r4.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                    public void onAnimationUpdate(@NonNull ValueAnimator valueAnimator) {
                        TextInputLayout.this.o4.A0(((Float) valueAnimator.getAnimatedValue()).floatValue());
                    }
                });
            }
            this.r4.setFloatValues(new float[]{this.o4.G(), f2});
            this.r4.start();
        }
    }

    public void n0() {
        this.Y2.N();
    }

    public void o0() {
        this.Y2.O();
    }

    /* access modifiers changed from: protected */
    public void onConfigurationChanged(@NonNull Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.o4.a0(configuration);
    }

    public void onGlobalLayout() {
        this.Y2.getViewTreeObserver().removeOnGlobalLayoutListener(this);
        this.u4 = false;
        boolean M0 = M0();
        boolean I0 = I0();
        if (M0 || I0) {
            this.Z2.post(new y(this));
        }
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i2, int i5, int i6, int i7) {
        super.onLayout(z, i2, i5, i6, i7);
        EditText editText = this.Z2;
        if (editText != null) {
            Rect rect = this.R3;
            DescendantOffsetUtils.a(this, editText, rect);
            C0(rect);
            if (this.y3) {
                this.o4.x0(this.Z2.getTextSize());
                int gravity = this.Z2.getGravity();
                this.o4.l0((gravity & -113) | 48);
                this.o4.w0(gravity);
                this.o4.h0(s(rect));
                this.o4.r0(v(rect));
                this.o4.c0();
                if (E() && !this.n4) {
                    j0();
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i5) {
        super.onMeasure(i2, i5);
        if (!this.u4) {
            this.Y2.getViewTreeObserver().addOnGlobalLayoutListener(this);
            this.u4 = true;
        }
        Q0();
        this.Y2.D0();
    }

    /* access modifiers changed from: protected */
    public void onRestoreInstanceState(@Nullable Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.a());
        setError(savedState.Y);
        if (savedState.Z) {
            post(new Runnable() {
                public void run() {
                    TextInputLayout.this.Y2.i();
                }
            });
        }
        requestLayout();
    }

    public void onRtlPropertiesChanged(int i2) {
        super.onRtlPropertiesChanged(i2);
        boolean z = true;
        if (i2 != 1) {
            z = false;
        }
        if (z != this.I3) {
            float a2 = this.H3.r().a(this.T3);
            float a5 = this.H3.t().a(this.T3);
            float a6 = this.H3.j().a(this.T3);
            float a7 = this.H3.l().a(this.T3);
            CornerTreatment q = this.H3.q();
            CornerTreatment s2 = this.H3.s();
            ShapeAppearanceModel m2 = ShapeAppearanceModel.a().J(s2).O(q).w(this.H3.k()).B(this.H3.i()).K(a5).P(a2).x(a7).C(a6).m();
            this.I3 = z;
            setShapeAppearanceModel(m2);
        }
    }

    @Nullable
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        if (x0()) {
            savedState.Y = getError();
        }
        savedState.Z = this.Y2.H();
        return savedState;
    }

    public void p0() {
        this.X2.n();
    }

    public void q0(@NonNull OnEditTextAttachedListener onEditTextAttachedListener) {
        this.X3.remove(onEditTextAttachedListener);
    }

    public void r0(@NonNull OnEndIconChangedListener onEndIconChangedListener) {
        this.Y2.Q(onEndIconChangedListener);
    }

    public void setBoxBackgroundColor(@ColorInt int i2) {
        if (this.Q3 != i2) {
            this.Q3 = i2;
            this.h4 = i2;
            this.j4 = i2;
            this.k4 = i2;
            n();
        }
    }

    public void setBoxBackgroundColorResource(@ColorRes int i2) {
        setBoxBackgroundColor(ContextCompat.g(getContext(), i2));
    }

    public void setBoxBackgroundColorStateList(@NonNull ColorStateList colorStateList) {
        int defaultColor = colorStateList.getDefaultColor();
        this.h4 = defaultColor;
        this.Q3 = defaultColor;
        this.i4 = colorStateList.getColorForState(new int[]{-16842910}, -1);
        this.j4 = colorStateList.getColorForState(new int[]{16842908, 16842910}, -1);
        this.k4 = colorStateList.getColorForState(new int[]{16843623, 16842910}, -1);
        n();
    }

    public void setBoxBackgroundMode(int i2) {
        if (i2 != this.K3) {
            this.K3 = i2;
            if (this.Z2 != null) {
                i0();
            }
        }
    }

    public void setBoxCollapsedPaddingTop(int i2) {
        this.L3 = i2;
    }

    public void setBoxCornerFamily(int i2) {
        this.H3 = this.H3.v().I(i2, this.H3.r()).N(i2, this.H3.t()).v(i2, this.H3.j()).A(i2, this.H3.l()).m();
        n();
    }

    public void setBoxStrokeColor(@ColorInt int i2) {
        if (this.f4 != i2) {
            this.f4 = i2;
            U0();
        }
    }

    public void setBoxStrokeColorStateList(@NonNull ColorStateList colorStateList) {
        int defaultColor;
        if (colorStateList.isStateful()) {
            this.d4 = colorStateList.getDefaultColor();
            this.l4 = colorStateList.getColorForState(new int[]{-16842910}, -1);
            this.e4 = colorStateList.getColorForState(new int[]{16843623, 16842910}, -1);
            defaultColor = colorStateList.getColorForState(new int[]{16842908, 16842910}, -1);
        } else {
            if (this.f4 != colorStateList.getDefaultColor()) {
                defaultColor = colorStateList.getDefaultColor();
            }
            U0();
        }
        this.f4 = defaultColor;
        U0();
    }

    public void setBoxStrokeErrorColor(@Nullable ColorStateList colorStateList) {
        if (this.g4 != colorStateList) {
            this.g4 = colorStateList;
            U0();
        }
    }

    public void setBoxStrokeWidth(int i2) {
        this.N3 = i2;
        U0();
    }

    public void setBoxStrokeWidthFocused(int i2) {
        this.O3 = i2;
        U0();
    }

    public void setBoxStrokeWidthFocusedResource(@DimenRes int i2) {
        setBoxStrokeWidthFocused(getResources().getDimensionPixelSize(i2));
    }

    public void setBoxStrokeWidthResource(@DimenRes int i2) {
        setBoxStrokeWidth(getResources().getDimensionPixelSize(i2));
    }

    public void setCounterEnabled(boolean z) {
        if (this.g3 != z) {
            if (z) {
                AppCompatTextView appCompatTextView = new AppCompatTextView(getContext());
                this.k3 = appCompatTextView;
                appCompatTextView.setId(R.id.Z5);
                Typeface typeface = this.U3;
                if (typeface != null) {
                    this.k3.setTypeface(typeface);
                }
                this.k3.setMaxLines(1);
                this.f3.e(this.k3, 2);
                MarginLayoutParamsCompat.h((ViewGroup.MarginLayoutParams) this.k3.getLayoutParams(), getResources().getDimensionPixelOffset(R.dimen.Pd));
                G0();
                D0();
            } else {
                this.f3.H(this.k3, 2);
                this.k3 = null;
            }
            this.g3 = z;
        }
    }

    public void setCounterMaxLength(int i2) {
        if (this.h3 != i2) {
            if (i2 <= 0) {
                i2 = -1;
            }
            this.h3 = i2;
            if (this.g3) {
                D0();
            }
        }
    }

    public void setCounterOverflowTextAppearance(int i2) {
        if (this.l3 != i2) {
            this.l3 = i2;
            G0();
        }
    }

    public void setCounterOverflowTextColor(@Nullable ColorStateList colorStateList) {
        if (this.v3 != colorStateList) {
            this.v3 = colorStateList;
            G0();
        }
    }

    public void setCounterTextAppearance(int i2) {
        if (this.m3 != i2) {
            this.m3 = i2;
            G0();
        }
    }

    public void setCounterTextColor(@Nullable ColorStateList colorStateList) {
        if (this.u3 != colorStateList) {
            this.u3 = colorStateList;
            G0();
        }
    }

    @RequiresApi(29)
    public void setCursorColor(@Nullable ColorStateList colorStateList) {
        if (this.w3 != colorStateList) {
            this.w3 = colorStateList;
            H0();
        }
    }

    @RequiresApi(29)
    public void setCursorErrorColor(@Nullable ColorStateList colorStateList) {
        if (this.x3 != colorStateList) {
            this.x3 = colorStateList;
            if (a0()) {
                H0();
            }
        }
    }

    public void setDefaultHintTextColor(@Nullable ColorStateList colorStateList) {
        this.b4 = colorStateList;
        this.c4 = colorStateList;
        if (this.Z2 != null) {
            O0(false);
        }
    }

    public void setEnabled(boolean z) {
        m0(this, z);
        super.setEnabled(z);
    }

    public void setEndIconActivated(boolean z) {
        this.Y2.S(z);
    }

    public void setEndIconCheckable(boolean z) {
        this.Y2.T(z);
    }

    public void setEndIconContentDescription(@StringRes int i2) {
        this.Y2.U(i2);
    }

    public void setEndIconDrawable(@DrawableRes int i2) {
        this.Y2.W(i2);
    }

    public void setEndIconMinSize(@IntRange(from = 0) int i2) {
        this.Y2.Y(i2);
    }

    public void setEndIconMode(int i2) {
        this.Y2.Z(i2);
    }

    public void setEndIconOnClickListener(@Nullable View.OnClickListener onClickListener) {
        this.Y2.a0(onClickListener);
    }

    public void setEndIconOnLongClickListener(@Nullable View.OnLongClickListener onLongClickListener) {
        this.Y2.b0(onLongClickListener);
    }

    public void setEndIconScaleType(@NonNull ImageView.ScaleType scaleType) {
        this.Y2.c0(scaleType);
    }

    public void setEndIconTintList(@Nullable ColorStateList colorStateList) {
        this.Y2.d0(colorStateList);
    }

    public void setEndIconTintMode(@Nullable PorterDuff.Mode mode) {
        this.Y2.e0(mode);
    }

    public void setEndIconVisible(boolean z) {
        this.Y2.f0(z);
    }

    public void setError(@Nullable CharSequence charSequence) {
        if (!this.f3.F()) {
            if (!TextUtils.isEmpty(charSequence)) {
                setErrorEnabled(true);
            } else {
                return;
            }
        }
        if (!TextUtils.isEmpty(charSequence)) {
            this.f3.V(charSequence);
        } else {
            this.f3.A();
        }
    }

    public void setErrorAccessibilityLiveRegion(int i2) {
        this.f3.J(i2);
    }

    public void setErrorContentDescription(@Nullable CharSequence charSequence) {
        this.f3.K(charSequence);
    }

    public void setErrorEnabled(boolean z) {
        this.f3.L(z);
    }

    public void setErrorIconDrawable(@DrawableRes int i2) {
        this.Y2.g0(i2);
    }

    public void setErrorIconOnClickListener(@Nullable View.OnClickListener onClickListener) {
        this.Y2.i0(onClickListener);
    }

    public void setErrorIconOnLongClickListener(@Nullable View.OnLongClickListener onLongClickListener) {
        this.Y2.j0(onLongClickListener);
    }

    public void setErrorIconTintList(@Nullable ColorStateList colorStateList) {
        this.Y2.k0(colorStateList);
    }

    public void setErrorIconTintMode(@Nullable PorterDuff.Mode mode) {
        this.Y2.l0(mode);
    }

    public void setErrorTextAppearance(@StyleRes int i2) {
        this.f3.M(i2);
    }

    public void setErrorTextColor(@Nullable ColorStateList colorStateList) {
        this.f3.N(colorStateList);
    }

    public void setExpandedHintEnabled(boolean z) {
        if (this.p4 != z) {
            this.p4 = z;
            O0(false);
        }
    }

    public void setHelperText(@Nullable CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            if (!W()) {
                setHelperTextEnabled(true);
            }
            this.f3.W(charSequence);
        } else if (W()) {
            setHelperTextEnabled(false);
        }
    }

    public void setHelperTextColor(@Nullable ColorStateList colorStateList) {
        this.f3.Q(colorStateList);
    }

    public void setHelperTextEnabled(boolean z) {
        this.f3.P(z);
    }

    public void setHelperTextTextAppearance(@StyleRes int i2) {
        this.f3.O(i2);
    }

    public void setHint(@StringRes int i2) {
        setHint(i2 != 0 ? getResources().getText(i2) : null);
    }

    public void setHintAnimationEnabled(boolean z) {
        this.q4 = z;
    }

    public void setHintEnabled(boolean z) {
        if (z != this.y3) {
            this.y3 = z;
            if (!z) {
                this.A3 = false;
                if (!TextUtils.isEmpty(this.z3) && TextUtils.isEmpty(this.Z2.getHint())) {
                    this.Z2.setHint(this.z3);
                }
                setHintInternal((CharSequence) null);
            } else {
                CharSequence hint = this.Z2.getHint();
                if (!TextUtils.isEmpty(hint)) {
                    if (TextUtils.isEmpty(this.z3)) {
                        setHint(hint);
                    }
                    this.Z2.setHint((CharSequence) null);
                }
                this.A3 = true;
            }
            if (this.Z2 != null) {
                N0();
            }
        }
    }

    public void setHintTextAppearance(@StyleRes int i2) {
        this.o4.i0(i2);
        this.c4 = this.o4.p();
        if (this.Z2 != null) {
            O0(false);
            N0();
        }
    }

    public void setHintTextColor(@Nullable ColorStateList colorStateList) {
        if (this.c4 != colorStateList) {
            if (this.b4 == null) {
                this.o4.k0(colorStateList);
            }
            this.c4 = colorStateList;
            if (this.Z2 != null) {
                O0(false);
            }
        }
    }

    public void setLengthCounter(@NonNull LengthCounter lengthCounter) {
        this.j3 = lengthCounter;
    }

    public void setMaxEms(int i2) {
        this.c3 = i2;
        EditText editText = this.Z2;
        if (editText != null && i2 != -1) {
            editText.setMaxEms(i2);
        }
    }

    public void setMaxWidth(@Px int i2) {
        this.e3 = i2;
        EditText editText = this.Z2;
        if (editText != null && i2 != -1) {
            editText.setMaxWidth(i2);
        }
    }

    public void setMaxWidthResource(@DimenRes int i2) {
        setMaxWidth(getContext().getResources().getDimensionPixelSize(i2));
    }

    public void setMinEms(int i2) {
        this.b3 = i2;
        EditText editText = this.Z2;
        if (editText != null && i2 != -1) {
            editText.setMinEms(i2);
        }
    }

    public void setMinWidth(@Px int i2) {
        this.d3 = i2;
        EditText editText = this.Z2;
        if (editText != null && i2 != -1) {
            editText.setMinWidth(i2);
        }
    }

    public void setMinWidthResource(@DimenRes int i2) {
        setMinWidth(getContext().getResources().getDimensionPixelSize(i2));
    }

    @Deprecated
    public void setPasswordVisibilityToggleContentDescription(@StringRes int i2) {
        this.Y2.n0(i2);
    }

    @Deprecated
    public void setPasswordVisibilityToggleDrawable(@DrawableRes int i2) {
        this.Y2.p0(i2);
    }

    @Deprecated
    public void setPasswordVisibilityToggleEnabled(boolean z) {
        this.Y2.r0(z);
    }

    @Deprecated
    public void setPasswordVisibilityToggleTintList(@Nullable ColorStateList colorStateList) {
        this.Y2.s0(colorStateList);
    }

    @Deprecated
    public void setPasswordVisibilityToggleTintMode(@Nullable PorterDuff.Mode mode) {
        this.Y2.t0(mode);
    }

    public void setPlaceholderText(@Nullable CharSequence charSequence) {
        if (this.p3 == null) {
            AppCompatTextView appCompatTextView = new AppCompatTextView(getContext());
            this.p3 = appCompatTextView;
            appCompatTextView.setId(R.id.c6);
            ViewCompat.Z1(this.p3, 2);
            Fade D = D();
            this.s3 = D;
            D.y1(67);
            this.t3 = D();
            setPlaceholderTextAppearance(this.r3);
            setPlaceholderTextColor(this.q3);
        }
        if (TextUtils.isEmpty(charSequence)) {
            setPlaceholderTextEnabled(false);
        } else {
            if (!this.o3) {
                setPlaceholderTextEnabled(true);
            }
            this.n3 = charSequence;
        }
        R0();
    }

    public void setPlaceholderTextAppearance(@StyleRes int i2) {
        this.r3 = i2;
        TextView textView = this.p3;
        if (textView != null) {
            TextViewCompat.D(textView, i2);
        }
    }

    public void setPlaceholderTextColor(@Nullable ColorStateList colorStateList) {
        if (this.q3 != colorStateList) {
            this.q3 = colorStateList;
            TextView textView = this.p3;
            if (textView != null && colorStateList != null) {
                textView.setTextColor(colorStateList);
            }
        }
    }

    public void setPrefixText(@Nullable CharSequence charSequence) {
        this.X2.o(charSequence);
    }

    public void setPrefixTextAppearance(@StyleRes int i2) {
        this.X2.p(i2);
    }

    public void setPrefixTextColor(@NonNull ColorStateList colorStateList) {
        this.X2.q(colorStateList);
    }

    public void setShapeAppearanceModel(@NonNull ShapeAppearanceModel shapeAppearanceModel) {
        MaterialShapeDrawable materialShapeDrawable = this.B3;
        if (materialShapeDrawable != null && materialShapeDrawable.getShapeAppearanceModel() != shapeAppearanceModel) {
            this.H3 = shapeAppearanceModel;
            n();
        }
    }

    public void setStartIconCheckable(boolean z) {
        this.X2.r(z);
    }

    public void setStartIconContentDescription(@StringRes int i2) {
        setStartIconContentDescription(i2 != 0 ? getResources().getText(i2) : null);
    }

    public void setStartIconDrawable(@DrawableRes int i2) {
        setStartIconDrawable(i2 != 0 ? AppCompatResources.b(getContext(), i2) : null);
    }

    public void setStartIconMinSize(@IntRange(from = 0) int i2) {
        this.X2.u(i2);
    }

    public void setStartIconOnClickListener(@Nullable View.OnClickListener onClickListener) {
        this.X2.v(onClickListener);
    }

    public void setStartIconOnLongClickListener(@Nullable View.OnLongClickListener onLongClickListener) {
        this.X2.w(onLongClickListener);
    }

    public void setStartIconScaleType(@NonNull ImageView.ScaleType scaleType) {
        this.X2.x(scaleType);
    }

    public void setStartIconTintList(@Nullable ColorStateList colorStateList) {
        this.X2.y(colorStateList);
    }

    public void setStartIconTintMode(@Nullable PorterDuff.Mode mode) {
        this.X2.z(mode);
    }

    public void setStartIconVisible(boolean z) {
        this.X2.A(z);
    }

    public void setSuffixText(@Nullable CharSequence charSequence) {
        this.Y2.u0(charSequence);
    }

    public void setSuffixTextAppearance(@StyleRes int i2) {
        this.Y2.v0(i2);
    }

    public void setSuffixTextColor(@NonNull ColorStateList colorStateList) {
        this.Y2.w0(colorStateList);
    }

    public void setTextInputAccessibilityDelegate(@Nullable AccessibilityDelegate accessibilityDelegate) {
        EditText editText = this.Z2;
        if (editText != null) {
            ViewCompat.H1(editText, accessibilityDelegate);
        }
    }

    public void setTypeface(@Nullable Typeface typeface) {
        if (typeface != this.U3) {
            this.U3 = typeface;
            this.o4.P0(typeface);
            this.f3.S(typeface);
            TextView textView = this.k3;
            if (textView != null) {
                textView.setTypeface(typeface);
            }
        }
    }

    public void t0(float f2, float f5, float f6, float f7) {
        boolean s2 = ViewUtils.s(this);
        this.I3 = s2;
        float f8 = s2 ? f5 : f2;
        if (!s2) {
            f2 = f5;
        }
        float f9 = s2 ? f7 : f6;
        if (!s2) {
            f6 = f7;
        }
        MaterialShapeDrawable materialShapeDrawable = this.B3;
        if (materialShapeDrawable == null || materialShapeDrawable.T() != f8 || this.B3.U() != f2 || this.B3.u() != f9 || this.B3.v() != f6) {
            this.H3 = this.H3.v().K(f8).P(f2).x(f9).C(f6).m();
            n();
        }
    }

    public void u0(@DimenRes int i2, @DimenRes int i5, @DimenRes int i6, @DimenRes int i7) {
        t0(getContext().getResources().getDimension(i2), getContext().getResources().getDimension(i5), getContext().getResources().getDimension(i7), getContext().getResources().getDimension(i6));
    }

    /* access modifiers changed from: package-private */
    public void w0(@NonNull TextView textView, @StyleRes int i2) {
        try {
            TextViewCompat.D(textView, i2);
            if (Build.VERSION.SDK_INT < 23 || textView.getTextColors().getDefaultColor() != -65281) {
                return;
            }
        } catch (Exception unused) {
        }
        TextViewCompat.D(textView, R.style.R6);
        textView.setTextColor(ContextCompat.g(getContext(), R.color.x0));
    }

    /* access modifiers changed from: package-private */
    public boolean x0() {
        return this.f3.m();
    }

    public void z() {
        this.X3.clear();
    }

    public TextInputLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.jj);
    }

    public void setEndIconContentDescription(@Nullable CharSequence charSequence) {
        this.Y2.V(charSequence);
    }

    public void setEndIconDrawable(@Nullable Drawable drawable) {
        this.Y2.X(drawable);
    }

    public void setErrorIconDrawable(@Nullable Drawable drawable) {
        this.Y2.h0(drawable);
    }

    public void setHint(@Nullable CharSequence charSequence) {
        if (this.y3) {
            setHintInternal(charSequence);
            sendAccessibilityEvent(2048);
        }
    }

    @Deprecated
    public void setPasswordVisibilityToggleContentDescription(@Nullable CharSequence charSequence) {
        this.Y2.o0(charSequence);
    }

    @Deprecated
    public void setPasswordVisibilityToggleDrawable(@Nullable Drawable drawable) {
        this.Y2.q0(drawable);
    }

    public void setStartIconContentDescription(@Nullable CharSequence charSequence) {
        this.X2.s(charSequence);
    }

    public void setStartIconDrawable(@Nullable Drawable drawable) {
        this.X2.t(drawable);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public TextInputLayout(@androidx.annotation.NonNull android.content.Context r22, @androidx.annotation.Nullable android.util.AttributeSet r23, int r24) {
        /*
            r21 = this;
            r0 = r21
            r7 = r23
            r8 = r24
            int r9 = v4
            r1 = r22
            android.content.Context r1 = com.google.android.material.theme.overlay.MaterialThemeOverlay.c(r1, r7, r8, r9)
            r0.<init>(r1, r7, r8)
            r10 = -1
            r0.b3 = r10
            r0.c3 = r10
            r0.d3 = r10
            r0.e3 = r10
            com.google.android.material.textfield.IndicatorViewController r1 = new com.google.android.material.textfield.IndicatorViewController
            r1.<init>(r0)
            r0.f3 = r1
            com.google.android.material.textfield.x r1 = new com.google.android.material.textfield.x
            r1.<init>()
            r0.j3 = r1
            android.graphics.Rect r1 = new android.graphics.Rect
            r1.<init>()
            r0.R3 = r1
            android.graphics.Rect r1 = new android.graphics.Rect
            r1.<init>()
            r0.S3 = r1
            android.graphics.RectF r1 = new android.graphics.RectF
            r1.<init>()
            r0.T3 = r1
            java.util.LinkedHashSet r1 = new java.util.LinkedHashSet
            r1.<init>()
            r0.X3 = r1
            com.google.android.material.internal.CollapsingTextHelper r1 = new com.google.android.material.internal.CollapsingTextHelper
            r1.<init>(r0)
            r0.o4 = r1
            r11 = 0
            r0.u4 = r11
            android.content.Context r12 = r21.getContext()
            r13 = 1
            r0.setOrientation(r13)
            r0.setWillNotDraw(r11)
            r0.setAddStatesFromChildren(r13)
            android.widget.FrameLayout r14 = new android.widget.FrameLayout
            r14.<init>(r12)
            r0.s = r14
            r14.setAddStatesFromChildren(r13)
            android.animation.TimeInterpolator r2 = com.google.android.material.animation.AnimationUtils.f20766a
            r1.N0(r2)
            r1.I0(r2)
            r2 = 8388659(0x800033, float:1.1755015E-38)
            r1.l0(r2)
            int[] r3 = com.google.android.material.R.styleable.sw
            int r15 = com.google.android.material.R.styleable.Pw
            int r6 = com.google.android.material.R.styleable.Nw
            int r5 = com.google.android.material.R.styleable.hx
            int r4 = com.google.android.material.R.styleable.mx
            int r2 = com.google.android.material.R.styleable.qx
            int[] r16 = new int[]{r15, r6, r5, r4, r2}
            r1 = r12
            r17 = r2
            r2 = r23
            r18 = r4
            r4 = r24
            r19 = r5
            r5 = r9
            r20 = r6
            r6 = r16
            androidx.appcompat.widget.TintTypedArray r1 = com.google.android.material.internal.ThemeEnforcement.l(r1, r2, r3, r4, r5, r6)
            com.google.android.material.textfield.StartCompoundLayout r2 = new com.google.android.material.textfield.StartCompoundLayout
            r2.<init>(r0, r1)
            r0.X2 = r2
            int r3 = com.google.android.material.R.styleable.px
            boolean r3 = r1.a(r3, r13)
            r0.y3 = r3
            int r3 = com.google.android.material.R.styleable.xw
            java.lang.CharSequence r3 = r1.x(r3)
            r0.setHint((java.lang.CharSequence) r3)
            int r3 = com.google.android.material.R.styleable.ox
            boolean r3 = r1.a(r3, r13)
            r0.q4 = r3
            int r3 = com.google.android.material.R.styleable.jx
            boolean r3 = r1.a(r3, r13)
            r0.p4 = r3
            int r3 = com.google.android.material.R.styleable.zw
            boolean r4 = r1.C(r3)
            if (r4 == 0) goto L_0x00d0
            int r3 = r1.o(r3, r10)
            r0.setMinEms(r3)
            goto L_0x00df
        L_0x00d0:
            int r3 = com.google.android.material.R.styleable.ww
            boolean r4 = r1.C(r3)
            if (r4 == 0) goto L_0x00df
            int r3 = r1.g(r3, r10)
            r0.setMinWidth(r3)
        L_0x00df:
            int r3 = com.google.android.material.R.styleable.yw
            boolean r4 = r1.C(r3)
            if (r4 == 0) goto L_0x00ef
            int r3 = r1.o(r3, r10)
            r0.setMaxEms(r3)
            goto L_0x00fe
        L_0x00ef:
            int r3 = com.google.android.material.R.styleable.vw
            boolean r4 = r1.C(r3)
            if (r4 == 0) goto L_0x00fe
            int r3 = r1.g(r3, r10)
            r0.setMaxWidth(r3)
        L_0x00fe:
            com.google.android.material.shape.ShapeAppearanceModel$Builder r3 = com.google.android.material.shape.ShapeAppearanceModel.e(r12, r7, r8, r9)
            com.google.android.material.shape.ShapeAppearanceModel r3 = r3.m()
            r0.H3 = r3
            android.content.res.Resources r3 = r12.getResources()
            int r4 = com.google.android.material.R.dimen.Md
            int r3 = r3.getDimensionPixelOffset(r4)
            r0.J3 = r3
            int r3 = com.google.android.material.R.styleable.Cw
            int r3 = r1.f(r3, r11)
            r0.L3 = r3
            int r3 = com.google.android.material.R.styleable.Jw
            android.content.res.Resources r4 = r12.getResources()
            int r5 = com.google.android.material.R.dimen.Nd
            int r4 = r4.getDimensionPixelSize(r5)
            int r3 = r1.g(r3, r4)
            r0.N3 = r3
            int r3 = com.google.android.material.R.styleable.Kw
            android.content.res.Resources r4 = r12.getResources()
            int r5 = com.google.android.material.R.dimen.Od
            int r4 = r4.getDimensionPixelSize(r5)
            int r3 = r1.g(r3, r4)
            r0.O3 = r3
            int r3 = r0.N3
            r0.M3 = r3
            int r3 = com.google.android.material.R.styleable.Gw
            r4 = -1082130432(0xffffffffbf800000, float:-1.0)
            float r3 = r1.e(r3, r4)
            int r5 = com.google.android.material.R.styleable.Fw
            float r5 = r1.e(r5, r4)
            int r6 = com.google.android.material.R.styleable.Dw
            float r6 = r1.e(r6, r4)
            int r7 = com.google.android.material.R.styleable.Ew
            float r4 = r1.e(r7, r4)
            com.google.android.material.shape.ShapeAppearanceModel r7 = r0.H3
            com.google.android.material.shape.ShapeAppearanceModel$Builder r7 = r7.v()
            r8 = 0
            int r9 = (r3 > r8 ? 1 : (r3 == r8 ? 0 : -1))
            if (r9 < 0) goto L_0x016c
            r7.K(r3)
        L_0x016c:
            int r3 = (r5 > r8 ? 1 : (r5 == r8 ? 0 : -1))
            if (r3 < 0) goto L_0x0173
            r7.P(r5)
        L_0x0173:
            int r3 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r3 < 0) goto L_0x017a
            r7.C(r6)
        L_0x017a:
            int r3 = (r4 > r8 ? 1 : (r4 == r8 ? 0 : -1))
            if (r3 < 0) goto L_0x0181
            r7.x(r4)
        L_0x0181:
            com.google.android.material.shape.ShapeAppearanceModel r3 = r7.m()
            r0.H3 = r3
            int r3 = com.google.android.material.R.styleable.Aw
            android.content.res.ColorStateList r3 = com.google.android.material.resources.MaterialResources.b(r12, r1, r3)
            if (r3 == 0) goto L_0x01e5
            int r4 = r3.getDefaultColor()
            r0.h4 = r4
            r0.Q3 = r4
            boolean r4 = r3.isStateful()
            r5 = 16843623(0x1010367, float:2.3696E-38)
            r6 = -16842910(0xfffffffffefeff62, float:-1.6947497E38)
            if (r4 == 0) goto L_0x01c8
            int[] r4 = new int[]{r6}
            int r4 = r3.getColorForState(r4, r10)
            r0.i4 = r4
            r4 = 16842908(0x101009c, float:2.3693995E-38)
            r6 = 16842910(0x101009e, float:2.3694E-38)
            int[] r4 = new int[]{r4, r6}
            int r4 = r3.getColorForState(r4, r10)
            r0.j4 = r4
            int[] r4 = new int[]{r5, r6}
            int r3 = r3.getColorForState(r4, r10)
        L_0x01c5:
            r0.k4 = r3
            goto L_0x01ef
        L_0x01c8:
            int r3 = r0.h4
            r0.j4 = r3
            int r3 = com.google.android.material.R.color.Pc
            android.content.res.ColorStateList r3 = androidx.appcompat.content.res.AppCompatResources.a(r12, r3)
            int[] r4 = new int[]{r6}
            int r4 = r3.getColorForState(r4, r10)
            r0.i4 = r4
            int[] r4 = new int[]{r5}
            int r3 = r3.getColorForState(r4, r10)
            goto L_0x01c5
        L_0x01e5:
            r0.Q3 = r11
            r0.h4 = r11
            r0.i4 = r11
            r0.j4 = r11
            r0.k4 = r11
        L_0x01ef:
            int r3 = com.google.android.material.R.styleable.uw
            boolean r4 = r1.C(r3)
            if (r4 == 0) goto L_0x01ff
            android.content.res.ColorStateList r3 = r1.d(r3)
            r0.c4 = r3
            r0.b4 = r3
        L_0x01ff:
            int r3 = com.google.android.material.R.styleable.Hw
            android.content.res.ColorStateList r4 = com.google.android.material.resources.MaterialResources.b(r12, r1, r3)
            int r3 = r1.c(r3, r11)
            r0.f4 = r3
            int r3 = com.google.android.material.R.color.qd
            int r3 = androidx.core.content.ContextCompat.g(r12, r3)
            r0.d4 = r3
            int r3 = com.google.android.material.R.color.rd
            int r3 = androidx.core.content.ContextCompat.g(r12, r3)
            r0.l4 = r3
            int r3 = com.google.android.material.R.color.ud
            int r3 = androidx.core.content.ContextCompat.g(r12, r3)
            r0.e4 = r3
            if (r4 == 0) goto L_0x0228
            r0.setBoxStrokeColorStateList(r4)
        L_0x0228:
            int r3 = com.google.android.material.R.styleable.Iw
            boolean r4 = r1.C(r3)
            if (r4 == 0) goto L_0x0237
            android.content.res.ColorStateList r3 = com.google.android.material.resources.MaterialResources.b(r12, r1, r3)
            r0.setBoxStrokeErrorColor(r3)
        L_0x0237:
            r3 = r17
            int r4 = r1.u(r3, r10)
            if (r4 == r10) goto L_0x0246
            int r3 = r1.u(r3, r11)
            r0.setHintTextAppearance(r3)
        L_0x0246:
            int r3 = com.google.android.material.R.styleable.Rw
            android.content.res.ColorStateList r3 = r1.d(r3)
            r0.w3 = r3
            int r3 = com.google.android.material.R.styleable.Sw
            android.content.res.ColorStateList r3 = r1.d(r3)
            r0.x3 = r3
            r3 = r19
            int r3 = r1.u(r3, r11)
            int r4 = com.google.android.material.R.styleable.cx
            java.lang.CharSequence r4 = r1.x(r4)
            int r5 = com.google.android.material.R.styleable.bx
            int r5 = r1.o(r5, r13)
            int r6 = com.google.android.material.R.styleable.dx
            boolean r6 = r1.a(r6, r11)
            r7 = r18
            int r7 = r1.u(r7, r11)
            int r8 = com.google.android.material.R.styleable.lx
            boolean r8 = r1.a(r8, r11)
            int r9 = com.google.android.material.R.styleable.kx
            java.lang.CharSequence r9 = r1.x(r9)
            int r12 = com.google.android.material.R.styleable.yx
            int r12 = r1.u(r12, r11)
            int r13 = com.google.android.material.R.styleable.xx
            java.lang.CharSequence r13 = r1.x(r13)
            int r10 = com.google.android.material.R.styleable.Lw
            boolean r10 = r1.a(r10, r11)
            int r11 = com.google.android.material.R.styleable.Mw
            r23 = r9
            r9 = -1
            int r9 = r1.o(r11, r9)
            r0.setCounterMaxLength(r9)
            r9 = 0
            int r11 = r1.u(r15, r9)
            r0.m3 = r11
            r11 = r20
            int r11 = r1.u(r11, r9)
            r0.l3 = r11
            int r11 = com.google.android.material.R.styleable.Bw
            int r9 = r1.o(r11, r9)
            r0.setBoxBackgroundMode(r9)
            r0.setErrorContentDescription(r4)
            r0.setErrorAccessibilityLiveRegion(r5)
            int r4 = r0.l3
            r0.setCounterOverflowTextAppearance(r4)
            r0.setHelperTextTextAppearance(r7)
            r0.setErrorTextAppearance(r3)
            int r3 = r0.m3
            r0.setCounterTextAppearance(r3)
            r0.setPlaceholderText(r13)
            r0.setPlaceholderTextAppearance(r12)
            int r3 = com.google.android.material.R.styleable.ix
            boolean r4 = r1.C(r3)
            if (r4 == 0) goto L_0x02e1
            android.content.res.ColorStateList r3 = r1.d(r3)
            r0.setErrorTextColor(r3)
        L_0x02e1:
            int r3 = com.google.android.material.R.styleable.nx
            boolean r4 = r1.C(r3)
            if (r4 == 0) goto L_0x02f0
            android.content.res.ColorStateList r3 = r1.d(r3)
            r0.setHelperTextColor(r3)
        L_0x02f0:
            int r3 = com.google.android.material.R.styleable.rx
            boolean r4 = r1.C(r3)
            if (r4 == 0) goto L_0x02ff
            android.content.res.ColorStateList r3 = r1.d(r3)
            r0.setHintTextColor(r3)
        L_0x02ff:
            int r3 = com.google.android.material.R.styleable.Qw
            boolean r4 = r1.C(r3)
            if (r4 == 0) goto L_0x030e
            android.content.res.ColorStateList r3 = r1.d(r3)
            r0.setCounterTextColor(r3)
        L_0x030e:
            int r3 = com.google.android.material.R.styleable.Ow
            boolean r4 = r1.C(r3)
            if (r4 == 0) goto L_0x031d
            android.content.res.ColorStateList r3 = r1.d(r3)
            r0.setCounterOverflowTextColor(r3)
        L_0x031d:
            int r3 = com.google.android.material.R.styleable.zx
            boolean r4 = r1.C(r3)
            if (r4 == 0) goto L_0x032c
            android.content.res.ColorStateList r3 = r1.d(r3)
            r0.setPlaceholderTextColor(r3)
        L_0x032c:
            com.google.android.material.textfield.EndCompoundLayout r3 = new com.google.android.material.textfield.EndCompoundLayout
            r3.<init>(r0, r1)
            r0.Y2 = r3
            int r4 = com.google.android.material.R.styleable.tw
            r5 = 1
            boolean r4 = r1.a(r4, r5)
            r1.I()
            r1 = 2
            androidx.core.view.ViewCompat.Z1(r0, r1)
            int r1 = android.os.Build.VERSION.SDK_INT
            r7 = 26
            if (r1 < r7) goto L_0x034a
            androidx.core.view.ViewCompat.b2(r0, r5)
        L_0x034a:
            r14.addView(r2)
            r14.addView(r3)
            r0.addView(r14)
            r0.setEnabled(r4)
            r0.setHelperTextEnabled(r8)
            r0.setErrorEnabled(r6)
            r0.setCounterEnabled(r10)
            r1 = r23
            r0.setHelperText(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.textfield.TextInputLayout.<init>(android.content.Context, android.util.AttributeSet, int):void");
    }
}
