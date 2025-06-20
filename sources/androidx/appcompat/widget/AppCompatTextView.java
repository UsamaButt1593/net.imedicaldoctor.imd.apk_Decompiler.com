package androidx.appcompat.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.InputFilter;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputMethodManager;
import android.view.inspector.PropertyMapper;
import android.view.inspector.PropertyReader;
import android.view.textclassifier.TextClassifier;
import android.widget.TextView;
import androidx.annotation.DrawableRes;
import androidx.annotation.FloatRange;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.annotation.UiThread;
import androidx.appcompat.R;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.graphics.TypefaceCompat;
import androidx.core.text.PrecomputedTextCompat;
import androidx.core.view.TintableBackgroundView;
import androidx.core.widget.AutoSizeableTextView;
import androidx.core.widget.TextViewCompat;
import androidx.core.widget.TintableCompoundDrawablesView;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.function.IntFunction;

public class AppCompatTextView extends TextView implements TintableBackgroundView, TintableCompoundDrawablesView, AutoSizeableTextView, EmojiCompatConfigurationView {
    private final AppCompatTextHelper X2;
    private final AppCompatTextClassifierHelper Y2;
    @NonNull
    private AppCompatEmojiTextHelper Z2;
    private boolean a3;
    @Nullable
    private SuperCaller b3;
    @Nullable
    private Future<PrecomputedTextCompat> c3;
    private final AppCompatBackgroundHelper s;

    @RequiresApi(29)
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public final class InspectionCompanion implements android.view.inspector.InspectionCompanion<AppCompatTextView> {

        /* renamed from: a  reason: collision with root package name */
        private boolean f3157a = false;

        /* renamed from: b  reason: collision with root package name */
        private int f3158b;

        /* renamed from: c  reason: collision with root package name */
        private int f3159c;

        /* renamed from: d  reason: collision with root package name */
        private int f3160d;

        /* renamed from: e  reason: collision with root package name */
        private int f3161e;

        /* renamed from: f  reason: collision with root package name */
        private int f3162f;

        /* renamed from: g  reason: collision with root package name */
        private int f3163g;

        /* renamed from: h  reason: collision with root package name */
        private int f3164h;

        /* renamed from: i  reason: collision with root package name */
        private int f3165i;

        /* renamed from: a */
        public void readProperties(@NonNull AppCompatTextView appCompatTextView, @NonNull PropertyReader propertyReader) {
            if (this.f3157a) {
                propertyReader.readInt(this.f3158b, appCompatTextView.getAutoSizeMaxTextSize());
                propertyReader.readInt(this.f3159c, appCompatTextView.getAutoSizeMinTextSize());
                propertyReader.readInt(this.f3160d, appCompatTextView.getAutoSizeStepGranularity());
                propertyReader.readIntEnum(this.f3161e, appCompatTextView.getAutoSizeTextType());
                propertyReader.readObject(this.f3162f, appCompatTextView.getBackgroundTintList());
                propertyReader.readObject(this.f3163g, appCompatTextView.getBackgroundTintMode());
                propertyReader.readObject(this.f3164h, appCompatTextView.getCompoundDrawableTintList());
                propertyReader.readObject(this.f3165i, appCompatTextView.getCompoundDrawableTintMode());
                return;
            }
            throw C0004e.a();
        }

        public void mapProperties(@NonNull PropertyMapper propertyMapper) {
            this.f3158b = propertyMapper.mapInt("autoSizeMaxTextSize", R.attr.T);
            this.f3159c = propertyMapper.mapInt("autoSizeMinTextSize", R.attr.U);
            this.f3160d = propertyMapper.mapInt("autoSizeStepGranularity", R.attr.W);
            this.f3161e = propertyMapper.mapIntEnum("autoSizeTextType", R.attr.X, new IntFunction<String>() {
                /* renamed from: a */
                public String apply(int i2) {
                    if (i2 != 0) {
                        return i2 != 1 ? String.valueOf(i2) : "uniform";
                    }
                    return "none";
                }
            });
            this.f3162f = propertyMapper.mapObject("backgroundTint", R.attr.b0);
            this.f3163g = propertyMapper.mapObject("backgroundTintMode", R.attr.c0);
            this.f3164h = propertyMapper.mapObject("drawableTint", R.attr.l1);
            this.f3165i = propertyMapper.mapObject("drawableTintMode", R.attr.m1);
            this.f3157a = true;
        }
    }

    private interface SuperCaller {
        TextClassifier a();

        void b(@Nullable TextClassifier textClassifier);

        void c(@Px int i2);

        void d(@Px int i2);

        void e(int i2, @FloatRange(from = 0.0d) float f2);

        int getAutoSizeMaxTextSize();

        int getAutoSizeMinTextSize();

        int getAutoSizeStepGranularity();

        int[] getAutoSizeTextAvailableSizes();

        int getAutoSizeTextType();

        void setAutoSizeTextTypeUniformWithConfiguration(int i2, int i3, int i4, int i5);

        void setAutoSizeTextTypeUniformWithPresetSizes(int[] iArr, int i2);

        void setAutoSizeTextTypeWithDefaults(int i2);
    }

    @RequiresApi(api = 26)
    class SuperCallerApi26 implements SuperCaller {
        SuperCallerApi26() {
        }

        public TextClassifier a() {
            return AppCompatTextView.super.getTextClassifier();
        }

        public void b(@Nullable TextClassifier textClassifier) {
            AppCompatTextView.super.setTextClassifier(textClassifier);
        }

        public void c(int i2) {
        }

        public void d(int i2) {
        }

        public void e(int i2, float f2) {
        }

        public int getAutoSizeMaxTextSize() {
            return AppCompatTextView.super.getAutoSizeMaxTextSize();
        }

        public int getAutoSizeMinTextSize() {
            return AppCompatTextView.super.getAutoSizeMinTextSize();
        }

        public int getAutoSizeStepGranularity() {
            return AppCompatTextView.super.getAutoSizeStepGranularity();
        }

        public int[] getAutoSizeTextAvailableSizes() {
            return AppCompatTextView.super.getAutoSizeTextAvailableSizes();
        }

        public int getAutoSizeTextType() {
            return AppCompatTextView.super.getAutoSizeTextType();
        }

        public void setAutoSizeTextTypeUniformWithConfiguration(int i2, int i3, int i4, int i5) {
            AppCompatTextView.super.setAutoSizeTextTypeUniformWithConfiguration(i2, i3, i4, i5);
        }

        public void setAutoSizeTextTypeUniformWithPresetSizes(int[] iArr, int i2) {
            AppCompatTextView.super.setAutoSizeTextTypeUniformWithPresetSizes(iArr, i2);
        }

        public void setAutoSizeTextTypeWithDefaults(int i2) {
            AppCompatTextView.super.setAutoSizeTextTypeWithDefaults(i2);
        }
    }

    @RequiresApi(api = 28)
    class SuperCallerApi28 extends SuperCallerApi26 {
        SuperCallerApi28() {
            super();
        }

        public void c(@Px int i2) {
            AppCompatTextView.super.setLastBaselineToBottomHeight(i2);
        }

        public void d(@Px int i2) {
            AppCompatTextView.super.setFirstBaselineToTopHeight(i2);
        }
    }

    @RequiresApi(api = 34)
    class SuperCallerApi34 extends SuperCallerApi28 {
        SuperCallerApi34() {
            super();
        }

        public void e(int i2, float f2) {
            AppCompatTextView.super.setLineHeight(i2, f2);
        }
    }

    public AppCompatTextView(@NonNull Context context) {
        this(context, (AttributeSet) null);
    }

    @NonNull
    private AppCompatEmojiTextHelper getEmojiTextViewHelper() {
        if (this.Z2 == null) {
            this.Z2 = new AppCompatEmojiTextHelper(this);
        }
        return this.Z2;
    }

    private void u() {
        Future<PrecomputedTextCompat> future = this.c3;
        if (future != null) {
            try {
                this.c3 = null;
                TextViewCompat.C(this, future.get());
            } catch (InterruptedException | ExecutionException unused) {
            }
        }
    }

    public boolean b() {
        return getEmojiTextViewHelper().b();
    }

    /* access modifiers changed from: protected */
    public void drawableStateChanged() {
        super.drawableStateChanged();
        AppCompatBackgroundHelper appCompatBackgroundHelper = this.s;
        if (appCompatBackgroundHelper != null) {
            appCompatBackgroundHelper.b();
        }
        AppCompatTextHelper appCompatTextHelper = this.X2;
        if (appCompatTextHelper != null) {
            appCompatTextHelper.b();
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public int getAutoSizeMaxTextSize() {
        if (ViewUtils.f3370d) {
            return getSuperCaller().getAutoSizeMaxTextSize();
        }
        AppCompatTextHelper appCompatTextHelper = this.X2;
        if (appCompatTextHelper != null) {
            return appCompatTextHelper.e();
        }
        return -1;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public int getAutoSizeMinTextSize() {
        if (ViewUtils.f3370d) {
            return getSuperCaller().getAutoSizeMinTextSize();
        }
        AppCompatTextHelper appCompatTextHelper = this.X2;
        if (appCompatTextHelper != null) {
            return appCompatTextHelper.f();
        }
        return -1;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public int getAutoSizeStepGranularity() {
        if (ViewUtils.f3370d) {
            return getSuperCaller().getAutoSizeStepGranularity();
        }
        AppCompatTextHelper appCompatTextHelper = this.X2;
        if (appCompatTextHelper != null) {
            return appCompatTextHelper.g();
        }
        return -1;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public int[] getAutoSizeTextAvailableSizes() {
        if (ViewUtils.f3370d) {
            return getSuperCaller().getAutoSizeTextAvailableSizes();
        }
        AppCompatTextHelper appCompatTextHelper = this.X2;
        return appCompatTextHelper != null ? appCompatTextHelper.h() : new int[0];
    }

    @SuppressLint({"WrongConstant"})
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public int getAutoSizeTextType() {
        if (ViewUtils.f3370d) {
            return getSuperCaller().getAutoSizeTextType() == 1 ? 1 : 0;
        }
        AppCompatTextHelper appCompatTextHelper = this.X2;
        if (appCompatTextHelper != null) {
            return appCompatTextHelper.i();
        }
        return 0;
    }

    @Nullable
    public ActionMode.Callback getCustomSelectionActionModeCallback() {
        return TextViewCompat.F(super.getCustomSelectionActionModeCallback());
    }

    public int getFirstBaselineToTopHeight() {
        return TextViewCompat.i(this);
    }

    public int getLastBaselineToBottomHeight() {
        return TextViewCompat.j(this);
    }

    /* access modifiers changed from: package-private */
    @RequiresApi(api = 26)
    @UiThread
    public SuperCaller getSuperCaller() {
        SuperCaller superCallerApi26;
        if (this.b3 == null) {
            int i2 = Build.VERSION.SDK_INT;
            if (i2 >= 34) {
                superCallerApi26 = new SuperCallerApi34();
            } else if (i2 >= 28) {
                superCallerApi26 = new SuperCallerApi28();
            } else if (i2 >= 26) {
                superCallerApi26 = new SuperCallerApi26();
            }
            this.b3 = superCallerApi26;
        }
        return this.b3;
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public ColorStateList getSupportBackgroundTintList() {
        AppCompatBackgroundHelper appCompatBackgroundHelper = this.s;
        if (appCompatBackgroundHelper != null) {
            return appCompatBackgroundHelper.c();
        }
        return null;
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public PorterDuff.Mode getSupportBackgroundTintMode() {
        AppCompatBackgroundHelper appCompatBackgroundHelper = this.s;
        if (appCompatBackgroundHelper != null) {
            return appCompatBackgroundHelper.d();
        }
        return null;
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public ColorStateList getSupportCompoundDrawablesTintList() {
        return this.X2.j();
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public PorterDuff.Mode getSupportCompoundDrawablesTintMode() {
        return this.X2.k();
    }

    public CharSequence getText() {
        u();
        return super.getText();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0006, code lost:
        r0 = r2.Y2;
     */
    @androidx.annotation.RequiresApi(api = 26)
    @androidx.annotation.NonNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public android.view.textclassifier.TextClassifier getTextClassifier() {
        /*
            r2 = this;
            int r0 = android.os.Build.VERSION.SDK_INT
            r1 = 28
            if (r0 >= r1) goto L_0x0010
            androidx.appcompat.widget.AppCompatTextClassifierHelper r0 = r2.Y2
            if (r0 != 0) goto L_0x000b
            goto L_0x0010
        L_0x000b:
            android.view.textclassifier.TextClassifier r0 = r0.a()
            return r0
        L_0x0010:
            androidx.appcompat.widget.AppCompatTextView$SuperCaller r0 = r2.getSuperCaller()
            android.view.textclassifier.TextClassifier r0 = r0.a()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.AppCompatTextView.getTextClassifier():android.view.textclassifier.TextClassifier");
    }

    @NonNull
    public PrecomputedTextCompat.Params getTextMetricsParamsCompat() {
        return TextViewCompat.o(this);
    }

    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        InputConnection onCreateInputConnection = super.onCreateInputConnection(editorInfo);
        this.X2.r(this, onCreateInputConnection, editorInfo);
        return AppCompatHintHelper.a(onCreateInputConnection, editorInfo, this);
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 30 && i2 < 33 && onCheckIsTextEditor()) {
            ((InputMethodManager) getContext().getSystemService("input_method")).isActive(this);
        }
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        super.onLayout(z, i2, i3, i4, i5);
        AppCompatTextHelper appCompatTextHelper = this.X2;
        if (appCompatTextHelper != null) {
            appCompatTextHelper.o(z, i2, i3, i4, i5);
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        u();
        super.onMeasure(i2, i3);
    }

    /* access modifiers changed from: protected */
    public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        super.onTextChanged(charSequence, i2, i3, i4);
        AppCompatTextHelper appCompatTextHelper = this.X2;
        if (appCompatTextHelper != null && !ViewUtils.f3370d && appCompatTextHelper.l()) {
            this.X2.c();
        }
    }

    public void setAllCaps(boolean z) {
        super.setAllCaps(z);
        getEmojiTextViewHelper().d(z);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void setAutoSizeTextTypeUniformWithConfiguration(int i2, int i3, int i4, int i5) throws IllegalArgumentException {
        if (ViewUtils.f3370d) {
            getSuperCaller().setAutoSizeTextTypeUniformWithConfiguration(i2, i3, i4, i5);
            return;
        }
        AppCompatTextHelper appCompatTextHelper = this.X2;
        if (appCompatTextHelper != null) {
            appCompatTextHelper.t(i2, i3, i4, i5);
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void setAutoSizeTextTypeUniformWithPresetSizes(@NonNull int[] iArr, int i2) throws IllegalArgumentException {
        if (ViewUtils.f3370d) {
            getSuperCaller().setAutoSizeTextTypeUniformWithPresetSizes(iArr, i2);
            return;
        }
        AppCompatTextHelper appCompatTextHelper = this.X2;
        if (appCompatTextHelper != null) {
            appCompatTextHelper.u(iArr, i2);
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void setAutoSizeTextTypeWithDefaults(int i2) {
        if (ViewUtils.f3370d) {
            getSuperCaller().setAutoSizeTextTypeWithDefaults(i2);
            return;
        }
        AppCompatTextHelper appCompatTextHelper = this.X2;
        if (appCompatTextHelper != null) {
            appCompatTextHelper.v(i2);
        }
    }

    public void setBackgroundDrawable(@Nullable Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        AppCompatBackgroundHelper appCompatBackgroundHelper = this.s;
        if (appCompatBackgroundHelper != null) {
            appCompatBackgroundHelper.f(drawable);
        }
    }

    public void setBackgroundResource(@DrawableRes int i2) {
        super.setBackgroundResource(i2);
        AppCompatBackgroundHelper appCompatBackgroundHelper = this.s;
        if (appCompatBackgroundHelper != null) {
            appCompatBackgroundHelper.g(i2);
        }
    }

    public void setCompoundDrawables(@Nullable Drawable drawable, @Nullable Drawable drawable2, @Nullable Drawable drawable3, @Nullable Drawable drawable4) {
        super.setCompoundDrawables(drawable, drawable2, drawable3, drawable4);
        AppCompatTextHelper appCompatTextHelper = this.X2;
        if (appCompatTextHelper != null) {
            appCompatTextHelper.p();
        }
    }

    public void setCompoundDrawablesRelative(@Nullable Drawable drawable, @Nullable Drawable drawable2, @Nullable Drawable drawable3, @Nullable Drawable drawable4) {
        super.setCompoundDrawablesRelative(drawable, drawable2, drawable3, drawable4);
        AppCompatTextHelper appCompatTextHelper = this.X2;
        if (appCompatTextHelper != null) {
            appCompatTextHelper.p();
        }
    }

    public void setCompoundDrawablesRelativeWithIntrinsicBounds(int i2, int i3, int i4, int i5) {
        Context context = getContext();
        Drawable drawable = null;
        Drawable b2 = i2 != 0 ? AppCompatResources.b(context, i2) : null;
        Drawable b4 = i3 != 0 ? AppCompatResources.b(context, i3) : null;
        Drawable b5 = i4 != 0 ? AppCompatResources.b(context, i4) : null;
        if (i5 != 0) {
            drawable = AppCompatResources.b(context, i5);
        }
        setCompoundDrawablesRelativeWithIntrinsicBounds(b2, b4, b5, drawable);
        AppCompatTextHelper appCompatTextHelper = this.X2;
        if (appCompatTextHelper != null) {
            appCompatTextHelper.p();
        }
    }

    public void setCompoundDrawablesWithIntrinsicBounds(int i2, int i3, int i4, int i5) {
        Context context = getContext();
        Drawable drawable = null;
        Drawable b2 = i2 != 0 ? AppCompatResources.b(context, i2) : null;
        Drawable b4 = i3 != 0 ? AppCompatResources.b(context, i3) : null;
        Drawable b5 = i4 != 0 ? AppCompatResources.b(context, i4) : null;
        if (i5 != 0) {
            drawable = AppCompatResources.b(context, i5);
        }
        setCompoundDrawablesWithIntrinsicBounds(b2, b4, b5, drawable);
        AppCompatTextHelper appCompatTextHelper = this.X2;
        if (appCompatTextHelper != null) {
            appCompatTextHelper.p();
        }
    }

    public void setCustomSelectionActionModeCallback(@Nullable ActionMode.Callback callback) {
        super.setCustomSelectionActionModeCallback(TextViewCompat.G(this, callback));
    }

    public void setEmojiCompatEnabled(boolean z) {
        getEmojiTextViewHelper().e(z);
    }

    public void setFilters(@NonNull InputFilter[] inputFilterArr) {
        super.setFilters(getEmojiTextViewHelper().a(inputFilterArr));
    }

    public void setFirstBaselineToTopHeight(@Px @IntRange(from = 0) int i2) {
        if (Build.VERSION.SDK_INT >= 28) {
            getSuperCaller().d(i2);
        } else {
            TextViewCompat.y(this, i2);
        }
    }

    public void setLastBaselineToBottomHeight(@Px @IntRange(from = 0) int i2) {
        if (Build.VERSION.SDK_INT >= 28) {
            getSuperCaller().c(i2);
        } else {
            TextViewCompat.z(this, i2);
        }
    }

    public void setLineHeight(@Px @IntRange(from = 0) int i2) {
        TextViewCompat.A(this, i2);
    }

    public void setPrecomputedText(@NonNull PrecomputedTextCompat precomputedTextCompat) {
        TextViewCompat.C(this, precomputedTextCompat);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void setSupportBackgroundTintList(@Nullable ColorStateList colorStateList) {
        AppCompatBackgroundHelper appCompatBackgroundHelper = this.s;
        if (appCompatBackgroundHelper != null) {
            appCompatBackgroundHelper.i(colorStateList);
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void setSupportBackgroundTintMode(@Nullable PorterDuff.Mode mode) {
        AppCompatBackgroundHelper appCompatBackgroundHelper = this.s;
        if (appCompatBackgroundHelper != null) {
            appCompatBackgroundHelper.j(mode);
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void setSupportCompoundDrawablesTintList(@Nullable ColorStateList colorStateList) {
        this.X2.w(colorStateList);
        this.X2.b();
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void setSupportCompoundDrawablesTintMode(@Nullable PorterDuff.Mode mode) {
        this.X2.x(mode);
        this.X2.b();
    }

    public void setTextAppearance(Context context, int i2) {
        super.setTextAppearance(context, i2);
        AppCompatTextHelper appCompatTextHelper = this.X2;
        if (appCompatTextHelper != null) {
            appCompatTextHelper.q(context, i2);
        }
    }

    @RequiresApi(api = 26)
    public void setTextClassifier(@Nullable TextClassifier textClassifier) {
        AppCompatTextClassifierHelper appCompatTextClassifierHelper;
        if (Build.VERSION.SDK_INT >= 28 || (appCompatTextClassifierHelper = this.Y2) == null) {
            getSuperCaller().b(textClassifier);
        } else {
            appCompatTextClassifierHelper.b(textClassifier);
        }
    }

    public void setTextFuture(@Nullable Future<PrecomputedTextCompat> future) {
        this.c3 = future;
        if (future != null) {
            requestLayout();
        }
    }

    public void setTextMetricsParamsCompat(@NonNull PrecomputedTextCompat.Params params) {
        TextViewCompat.E(this, params);
    }

    public void setTextSize(int i2, float f2) {
        if (ViewUtils.f3370d) {
            super.setTextSize(i2, f2);
            return;
        }
        AppCompatTextHelper appCompatTextHelper = this.X2;
        if (appCompatTextHelper != null) {
            appCompatTextHelper.A(i2, f2);
        }
    }

    public void setTypeface(@Nullable Typeface typeface, int i2) {
        if (!this.a3) {
            Typeface b2 = (typeface == null || i2 <= 0) ? null : TypefaceCompat.b(getContext(), typeface, i2);
            this.a3 = true;
            if (b2 != null) {
                typeface = b2;
            }
            try {
                super.setTypeface(typeface, i2);
            } finally {
                this.a3 = false;
            }
        }
    }

    public AppCompatTextView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 16842884);
    }

    public void setCompoundDrawablesRelativeWithIntrinsicBounds(@Nullable Drawable drawable, @Nullable Drawable drawable2, @Nullable Drawable drawable3, @Nullable Drawable drawable4) {
        super.setCompoundDrawablesRelativeWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
        AppCompatTextHelper appCompatTextHelper = this.X2;
        if (appCompatTextHelper != null) {
            appCompatTextHelper.p();
        }
    }

    public void setCompoundDrawablesWithIntrinsicBounds(@Nullable Drawable drawable, @Nullable Drawable drawable2, @Nullable Drawable drawable3, @Nullable Drawable drawable4) {
        super.setCompoundDrawablesWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
        AppCompatTextHelper appCompatTextHelper = this.X2;
        if (appCompatTextHelper != null) {
            appCompatTextHelper.p();
        }
    }

    public void setLineHeight(int i2, @FloatRange(from = 0.0d) float f2) {
        if (Build.VERSION.SDK_INT >= 34) {
            getSuperCaller().e(i2, f2);
        } else {
            TextViewCompat.B(this, i2, f2);
        }
    }

    public AppCompatTextView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(TintContextWrapper.b(context), attributeSet, i2);
        this.a3 = false;
        this.b3 = null;
        ThemeUtils.a(this, getContext());
        AppCompatBackgroundHelper appCompatBackgroundHelper = new AppCompatBackgroundHelper(this);
        this.s = appCompatBackgroundHelper;
        appCompatBackgroundHelper.e(attributeSet, i2);
        AppCompatTextHelper appCompatTextHelper = new AppCompatTextHelper(this);
        this.X2 = appCompatTextHelper;
        appCompatTextHelper.m(attributeSet, i2);
        appCompatTextHelper.b();
        this.Y2 = new AppCompatTextClassifierHelper(this);
        getEmojiTextViewHelper().c(attributeSet, i2);
    }
}
