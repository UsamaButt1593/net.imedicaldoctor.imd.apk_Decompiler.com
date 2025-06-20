package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inspector.PropertyMapper;
import android.view.inspector.PropertyReader;
import android.widget.CheckedTextView;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.appcompat.R;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.view.TintableBackgroundView;
import androidx.core.widget.TextViewCompat;
import androidx.core.widget.TintableCheckedTextView;
import androidx.core.widget.TintableCompoundDrawablesView;

public class AppCompatCheckedTextView extends CheckedTextView implements TintableCheckedTextView, TintableBackgroundView, EmojiCompatConfigurationView, TintableCompoundDrawablesView {
    private final AppCompatBackgroundHelper X2;
    private final AppCompatTextHelper Y2;
    @NonNull
    private AppCompatEmojiTextHelper Z2;
    private final AppCompatCheckedTextViewHelper s;

    @RequiresApi(29)
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public final class InspectionCompanion implements android.view.inspector.InspectionCompanion<AppCompatCheckedTextView> {

        /* renamed from: a  reason: collision with root package name */
        private boolean f3055a = false;

        /* renamed from: b  reason: collision with root package name */
        private int f3056b;

        /* renamed from: c  reason: collision with root package name */
        private int f3057c;

        /* renamed from: d  reason: collision with root package name */
        private int f3058d;

        /* renamed from: e  reason: collision with root package name */
        private int f3059e;

        /* renamed from: f  reason: collision with root package name */
        private int f3060f;

        /* renamed from: g  reason: collision with root package name */
        private int f3061g;

        /* renamed from: a */
        public void readProperties(@NonNull AppCompatCheckedTextView appCompatCheckedTextView, @NonNull PropertyReader propertyReader) {
            if (this.f3055a) {
                propertyReader.readObject(this.f3056b, appCompatCheckedTextView.getBackgroundTintList());
                propertyReader.readObject(this.f3057c, appCompatCheckedTextView.getBackgroundTintMode());
                propertyReader.readObject(this.f3058d, appCompatCheckedTextView.getCheckMarkTintList());
                propertyReader.readObject(this.f3059e, appCompatCheckedTextView.getCheckMarkTintMode());
                propertyReader.readObject(this.f3060f, appCompatCheckedTextView.getCompoundDrawableTintList());
                propertyReader.readObject(this.f3061g, appCompatCheckedTextView.getCompoundDrawableTintMode());
                return;
            }
            throw C0004e.a();
        }

        public void mapProperties(@NonNull PropertyMapper propertyMapper) {
            this.f3056b = propertyMapper.mapObject("backgroundTint", R.attr.b0);
            this.f3057c = propertyMapper.mapObject("backgroundTintMode", R.attr.c0);
            this.f3058d = propertyMapper.mapObject("checkMarkTint", R.attr.t0);
            this.f3059e = propertyMapper.mapObject("checkMarkTintMode", R.attr.u0);
            this.f3060f = propertyMapper.mapObject("drawableTint", R.attr.l1);
            this.f3061g = propertyMapper.mapObject("drawableTintMode", R.attr.m1);
            this.f3055a = true;
        }
    }

    public AppCompatCheckedTextView(@NonNull Context context) {
        this(context, (AttributeSet) null);
    }

    @NonNull
    private AppCompatEmojiTextHelper getEmojiTextViewHelper() {
        if (this.Z2 == null) {
            this.Z2 = new AppCompatEmojiTextHelper(this);
        }
        return this.Z2;
    }

    public boolean b() {
        return getEmojiTextViewHelper().b();
    }

    /* access modifiers changed from: protected */
    public void drawableStateChanged() {
        super.drawableStateChanged();
        AppCompatTextHelper appCompatTextHelper = this.Y2;
        if (appCompatTextHelper != null) {
            appCompatTextHelper.b();
        }
        AppCompatBackgroundHelper appCompatBackgroundHelper = this.X2;
        if (appCompatBackgroundHelper != null) {
            appCompatBackgroundHelper.b();
        }
        AppCompatCheckedTextViewHelper appCompatCheckedTextViewHelper = this.s;
        if (appCompatCheckedTextViewHelper != null) {
            appCompatCheckedTextViewHelper.a();
        }
    }

    @Nullable
    public ActionMode.Callback getCustomSelectionActionModeCallback() {
        return TextViewCompat.F(super.getCustomSelectionActionModeCallback());
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public ColorStateList getSupportBackgroundTintList() {
        AppCompatBackgroundHelper appCompatBackgroundHelper = this.X2;
        if (appCompatBackgroundHelper != null) {
            return appCompatBackgroundHelper.c();
        }
        return null;
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public PorterDuff.Mode getSupportBackgroundTintMode() {
        AppCompatBackgroundHelper appCompatBackgroundHelper = this.X2;
        if (appCompatBackgroundHelper != null) {
            return appCompatBackgroundHelper.d();
        }
        return null;
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public ColorStateList getSupportCheckMarkTintList() {
        AppCompatCheckedTextViewHelper appCompatCheckedTextViewHelper = this.s;
        if (appCompatCheckedTextViewHelper != null) {
            return appCompatCheckedTextViewHelper.b();
        }
        return null;
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public PorterDuff.Mode getSupportCheckMarkTintMode() {
        AppCompatCheckedTextViewHelper appCompatCheckedTextViewHelper = this.s;
        if (appCompatCheckedTextViewHelper != null) {
            return appCompatCheckedTextViewHelper.c();
        }
        return null;
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public ColorStateList getSupportCompoundDrawablesTintList() {
        return this.Y2.j();
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public PorterDuff.Mode getSupportCompoundDrawablesTintMode() {
        return this.Y2.k();
    }

    @Nullable
    public InputConnection onCreateInputConnection(@NonNull EditorInfo editorInfo) {
        return AppCompatHintHelper.a(super.onCreateInputConnection(editorInfo), editorInfo, this);
    }

    public void setAllCaps(boolean z) {
        super.setAllCaps(z);
        getEmojiTextViewHelper().d(z);
    }

    public void setBackgroundDrawable(@Nullable Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        AppCompatBackgroundHelper appCompatBackgroundHelper = this.X2;
        if (appCompatBackgroundHelper != null) {
            appCompatBackgroundHelper.f(drawable);
        }
    }

    public void setBackgroundResource(@DrawableRes int i2) {
        super.setBackgroundResource(i2);
        AppCompatBackgroundHelper appCompatBackgroundHelper = this.X2;
        if (appCompatBackgroundHelper != null) {
            appCompatBackgroundHelper.g(i2);
        }
    }

    public void setCheckMarkDrawable(@DrawableRes int i2) {
        setCheckMarkDrawable(AppCompatResources.b(getContext(), i2));
    }

    public void setCompoundDrawables(@Nullable Drawable drawable, @Nullable Drawable drawable2, @Nullable Drawable drawable3, @Nullable Drawable drawable4) {
        super.setCompoundDrawables(drawable, drawable2, drawable3, drawable4);
        AppCompatTextHelper appCompatTextHelper = this.Y2;
        if (appCompatTextHelper != null) {
            appCompatTextHelper.p();
        }
    }

    public void setCompoundDrawablesRelative(@Nullable Drawable drawable, @Nullable Drawable drawable2, @Nullable Drawable drawable3, @Nullable Drawable drawable4) {
        super.setCompoundDrawablesRelative(drawable, drawable2, drawable3, drawable4);
        AppCompatTextHelper appCompatTextHelper = this.Y2;
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

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void setSupportBackgroundTintList(@Nullable ColorStateList colorStateList) {
        AppCompatBackgroundHelper appCompatBackgroundHelper = this.X2;
        if (appCompatBackgroundHelper != null) {
            appCompatBackgroundHelper.i(colorStateList);
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void setSupportBackgroundTintMode(@Nullable PorterDuff.Mode mode) {
        AppCompatBackgroundHelper appCompatBackgroundHelper = this.X2;
        if (appCompatBackgroundHelper != null) {
            appCompatBackgroundHelper.j(mode);
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void setSupportCheckMarkTintList(@Nullable ColorStateList colorStateList) {
        AppCompatCheckedTextViewHelper appCompatCheckedTextViewHelper = this.s;
        if (appCompatCheckedTextViewHelper != null) {
            appCompatCheckedTextViewHelper.f(colorStateList);
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void setSupportCheckMarkTintMode(@Nullable PorterDuff.Mode mode) {
        AppCompatCheckedTextViewHelper appCompatCheckedTextViewHelper = this.s;
        if (appCompatCheckedTextViewHelper != null) {
            appCompatCheckedTextViewHelper.g(mode);
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void setSupportCompoundDrawablesTintList(@Nullable ColorStateList colorStateList) {
        this.Y2.w(colorStateList);
        this.Y2.b();
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void setSupportCompoundDrawablesTintMode(@Nullable PorterDuff.Mode mode) {
        this.Y2.x(mode);
        this.Y2.b();
    }

    public void setTextAppearance(@NonNull Context context, int i2) {
        super.setTextAppearance(context, i2);
        AppCompatTextHelper appCompatTextHelper = this.Y2;
        if (appCompatTextHelper != null) {
            appCompatTextHelper.q(context, i2);
        }
    }

    public AppCompatCheckedTextView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.w0);
    }

    public void setCheckMarkDrawable(@Nullable Drawable drawable) {
        super.setCheckMarkDrawable(drawable);
        AppCompatCheckedTextViewHelper appCompatCheckedTextViewHelper = this.s;
        if (appCompatCheckedTextViewHelper != null) {
            appCompatCheckedTextViewHelper.e();
        }
    }

    public AppCompatCheckedTextView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(TintContextWrapper.b(context), attributeSet, i2);
        ThemeUtils.a(this, getContext());
        AppCompatTextHelper appCompatTextHelper = new AppCompatTextHelper(this);
        this.Y2 = appCompatTextHelper;
        appCompatTextHelper.m(attributeSet, i2);
        appCompatTextHelper.b();
        AppCompatBackgroundHelper appCompatBackgroundHelper = new AppCompatBackgroundHelper(this);
        this.X2 = appCompatBackgroundHelper;
        appCompatBackgroundHelper.e(attributeSet, i2);
        AppCompatCheckedTextViewHelper appCompatCheckedTextViewHelper = new AppCompatCheckedTextViewHelper(this);
        this.s = appCompatCheckedTextViewHelper;
        appCompatCheckedTextViewHelper.d(attributeSet, i2);
        getEmojiTextViewHelper().c(attributeSet, i2);
    }
}
