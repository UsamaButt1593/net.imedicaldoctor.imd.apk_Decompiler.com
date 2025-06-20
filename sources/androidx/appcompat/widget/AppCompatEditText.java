package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.Editable;
import android.text.method.KeyListener;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.DragEvent;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputMethodManager;
import android.view.inspector.PropertyMapper;
import android.view.inspector.PropertyReader;
import android.view.textclassifier.TextClassifier;
import android.widget.EditText;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.annotation.UiThread;
import androidx.appcompat.R;
import androidx.core.view.ContentInfoCompat;
import androidx.core.view.OnReceiveContentViewBehavior;
import androidx.core.view.TintableBackgroundView;
import androidx.core.view.ViewCompat;
import androidx.core.view.inputmethod.EditorInfoCompat;
import androidx.core.view.inputmethod.InputConnectionCompat;
import androidx.core.widget.TextViewCompat;
import androidx.core.widget.TextViewOnReceiveContentListener;
import androidx.core.widget.TintableCompoundDrawablesView;

public class AppCompatEditText extends EditText implements TintableBackgroundView, OnReceiveContentViewBehavior, EmojiCompatConfigurationView, TintableCompoundDrawablesView {
    private final AppCompatTextHelper X2;
    private final AppCompatTextClassifierHelper Y2;
    private final TextViewOnReceiveContentListener Z2;
    @NonNull
    private final AppCompatEmojiEditTextHelper a3;
    @Nullable
    private SuperCaller b3;
    private final AppCompatBackgroundHelper s;

    @RequiresApi(29)
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public final class InspectionCompanion implements android.view.inspector.InspectionCompanion<AppCompatEditText> {

        /* renamed from: a  reason: collision with root package name */
        private boolean f3085a = false;

        /* renamed from: b  reason: collision with root package name */
        private int f3086b;

        /* renamed from: c  reason: collision with root package name */
        private int f3087c;

        /* renamed from: d  reason: collision with root package name */
        private int f3088d;

        /* renamed from: e  reason: collision with root package name */
        private int f3089e;

        /* renamed from: a */
        public void readProperties(@NonNull AppCompatEditText appCompatEditText, @NonNull PropertyReader propertyReader) {
            if (this.f3085a) {
                propertyReader.readObject(this.f3086b, appCompatEditText.getBackgroundTintList());
                propertyReader.readObject(this.f3087c, appCompatEditText.getBackgroundTintMode());
                propertyReader.readObject(this.f3088d, appCompatEditText.getCompoundDrawableTintList());
                propertyReader.readObject(this.f3089e, appCompatEditText.getCompoundDrawableTintMode());
                return;
            }
            throw C0004e.a();
        }

        public void mapProperties(@NonNull PropertyMapper propertyMapper) {
            this.f3086b = propertyMapper.mapObject("backgroundTint", R.attr.b0);
            this.f3087c = propertyMapper.mapObject("backgroundTintMode", R.attr.c0);
            this.f3088d = propertyMapper.mapObject("drawableTint", R.attr.l1);
            this.f3089e = propertyMapper.mapObject("drawableTintMode", R.attr.m1);
            this.f3085a = true;
        }
    }

    @RequiresApi(api = 26)
    class SuperCaller {
        SuperCaller() {
        }

        @Nullable
        public TextClassifier a() {
            return AppCompatEditText.super.getTextClassifier();
        }

        public void b(TextClassifier textClassifier) {
            AppCompatEditText.super.setTextClassifier(textClassifier);
        }
    }

    public AppCompatEditText(@NonNull Context context) {
        this(context, (AttributeSet) null);
    }

    @RequiresApi(26)
    @UiThread
    @NonNull
    private SuperCaller getSuperCaller() {
        if (this.b3 == null) {
            this.b3 = new SuperCaller();
        }
        return this.b3;
    }

    @Nullable
    public ContentInfoCompat a(@NonNull ContentInfoCompat contentInfoCompat) {
        return this.Z2.a(this, contentInfoCompat);
    }

    public boolean b() {
        return this.a3.c();
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

    /* access modifiers changed from: package-private */
    public void e(AppCompatEmojiEditTextHelper appCompatEmojiEditTextHelper) {
        KeyListener keyListener = getKeyListener();
        if (appCompatEmojiEditTextHelper.b(keyListener)) {
            boolean isFocusable = super.isFocusable();
            boolean isClickable = super.isClickable();
            boolean isLongClickable = super.isLongClickable();
            int inputType = super.getInputType();
            KeyListener a2 = appCompatEmojiEditTextHelper.a(keyListener);
            if (a2 != keyListener) {
                super.setKeyListener(a2);
                super.setRawInputType(inputType);
                super.setFocusable(isFocusable);
                super.setClickable(isClickable);
                super.setLongClickable(isLongClickable);
            }
        }
    }

    @Nullable
    public ActionMode.Callback getCustomSelectionActionModeCallback() {
        return TextViewCompat.F(super.getCustomSelectionActionModeCallback());
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

    @Nullable
    public Editable getText() {
        return Build.VERSION.SDK_INT >= 28 ? super.getText() : super.getEditableText();
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
            androidx.appcompat.widget.AppCompatEditText$SuperCaller r0 = r2.getSuperCaller()
            android.view.textclassifier.TextClassifier r0 = r0.a()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.AppCompatEditText.getTextClassifier():android.view.textclassifier.TextClassifier");
    }

    @Nullable
    public InputConnection onCreateInputConnection(@NonNull EditorInfo editorInfo) {
        String[] k0;
        InputConnection onCreateInputConnection = super.onCreateInputConnection(editorInfo);
        this.X2.r(this, onCreateInputConnection, editorInfo);
        InputConnection a2 = AppCompatHintHelper.a(onCreateInputConnection, editorInfo, this);
        if (!(a2 == null || Build.VERSION.SDK_INT > 30 || (k0 = ViewCompat.k0(this)) == null)) {
            EditorInfoCompat.i(editorInfo, k0);
            a2 = InputConnectionCompat.d(this, a2, editorInfo);
        }
        return this.a3.e(a2, editorInfo);
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 30 && i2 < 33) {
            ((InputMethodManager) getContext().getSystemService("input_method")).isActive(this);
        }
    }

    public boolean onDragEvent(DragEvent dragEvent) {
        if (AppCompatReceiveContentHelper.a(this, dragEvent)) {
            return true;
        }
        return super.onDragEvent(dragEvent);
    }

    public boolean onTextContextMenuItem(int i2) {
        if (AppCompatReceiveContentHelper.b(this, i2)) {
            return true;
        }
        return super.onTextContextMenuItem(i2);
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

    public void setCustomSelectionActionModeCallback(@Nullable ActionMode.Callback callback) {
        super.setCustomSelectionActionModeCallback(TextViewCompat.G(this, callback));
    }

    public void setEmojiCompatEnabled(boolean z) {
        this.a3.f(z);
    }

    public void setKeyListener(@Nullable KeyListener keyListener) {
        super.setKeyListener(this.a3.a(keyListener));
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

    public AppCompatEditText(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.t1);
    }

    public AppCompatEditText(@NonNull Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(TintContextWrapper.b(context), attributeSet, i2);
        ThemeUtils.a(this, getContext());
        AppCompatBackgroundHelper appCompatBackgroundHelper = new AppCompatBackgroundHelper(this);
        this.s = appCompatBackgroundHelper;
        appCompatBackgroundHelper.e(attributeSet, i2);
        AppCompatTextHelper appCompatTextHelper = new AppCompatTextHelper(this);
        this.X2 = appCompatTextHelper;
        appCompatTextHelper.m(attributeSet, i2);
        appCompatTextHelper.b();
        this.Y2 = new AppCompatTextClassifierHelper(this);
        this.Z2 = new TextViewOnReceiveContentListener();
        AppCompatEmojiEditTextHelper appCompatEmojiEditTextHelper = new AppCompatEmojiEditTextHelper(this);
        this.a3 = appCompatEmojiEditTextHelper;
        appCompatEmojiEditTextHelper.d(attributeSet, i2);
        e(appCompatEmojiEditTextHelper);
    }
}
