package androidx.core.widget;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.ColorStateList;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.icu.text.DecimalFormatSymbols;
import android.os.Build;
import android.text.Editable;
import android.text.PrecomputedText;
import android.text.TextDirectionHeuristic;
import android.text.TextDirectionHeuristics;
import android.text.TextPaint;
import android.text.method.PasswordTransformationMethod;
import android.util.TypedValue;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import androidx.annotation.DoNotInline;
import androidx.annotation.DrawableRes;
import androidx.annotation.FloatRange;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.annotation.StyleRes;
import androidx.core.text.PrecomputedTextCompat;
import androidx.core.util.Preconditions;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public final class TextViewCompat {

    /* renamed from: a  reason: collision with root package name */
    public static final int f6764a = 0;

    /* renamed from: b  reason: collision with root package name */
    public static final int f6765b = 1;

    @RequiresApi(23)
    static class Api23Impl {
        private Api23Impl() {
        }

        @DoNotInline
        static int a(TextView textView) {
            return textView.getBreakStrategy();
        }

        @DoNotInline
        static ColorStateList b(TextView textView) {
            return textView.getCompoundDrawableTintList();
        }

        @DoNotInline
        static PorterDuff.Mode c(TextView textView) {
            return textView.getCompoundDrawableTintMode();
        }

        @DoNotInline
        static int d(TextView textView) {
            return textView.getHyphenationFrequency();
        }

        @DoNotInline
        static void e(TextView textView, int i2) {
            textView.setBreakStrategy(i2);
        }

        @DoNotInline
        static void f(TextView textView, ColorStateList colorStateList) {
            textView.setCompoundDrawableTintList(colorStateList);
        }

        @DoNotInline
        static void g(TextView textView, PorterDuff.Mode mode) {
            textView.setCompoundDrawableTintMode(mode);
        }

        @DoNotInline
        static void h(TextView textView, int i2) {
            textView.setHyphenationFrequency(i2);
        }
    }

    @RequiresApi(24)
    static class Api24Impl {
        private Api24Impl() {
        }

        @DoNotInline
        static DecimalFormatSymbols a(Locale locale) {
            return DecimalFormatSymbols.getInstance(locale);
        }
    }

    @RequiresApi(26)
    static class Api26Impl {
        private Api26Impl() {
        }

        @DoNotInline
        static int a(TextView textView) {
            return textView.getAutoSizeMaxTextSize();
        }

        @DoNotInline
        static int b(TextView textView) {
            return textView.getAutoSizeMinTextSize();
        }

        @DoNotInline
        static int c(TextView textView) {
            return textView.getAutoSizeStepGranularity();
        }

        @DoNotInline
        static int[] d(TextView textView) {
            return textView.getAutoSizeTextAvailableSizes();
        }

        @DoNotInline
        static int e(TextView textView) {
            return textView.getAutoSizeTextType();
        }

        @DoNotInline
        static void f(TextView textView, int i2, int i3, int i4, int i5) {
            textView.setAutoSizeTextTypeUniformWithConfiguration(i2, i3, i4, i5);
        }

        @DoNotInline
        static void g(TextView textView, int[] iArr, int i2) {
            textView.setAutoSizeTextTypeUniformWithPresetSizes(iArr, i2);
        }

        @DoNotInline
        static void h(TextView textView, int i2) {
            textView.setAutoSizeTextTypeWithDefaults(i2);
        }
    }

    @RequiresApi(28)
    static class Api28Impl {
        private Api28Impl() {
        }

        @DoNotInline
        static CharSequence a(PrecomputedText precomputedText) {
            return precomputedText;
        }

        @DoNotInline
        static String[] b(DecimalFormatSymbols decimalFormatSymbols) {
            return decimalFormatSymbols.getDigitStrings();
        }

        @DoNotInline
        static PrecomputedText.Params c(TextView textView) {
            return textView.getTextMetricsParams();
        }

        @DoNotInline
        static void d(TextView textView, int i2) {
            textView.setFirstBaselineToTopHeight(i2);
        }
    }

    @RequiresApi(34)
    static class Api34Impl {
        private Api34Impl() {
        }

        @DoNotInline
        public static void a(@NonNull TextView textView, int i2, @FloatRange(from = 0.0d) float f2) {
            textView.setLineHeight(i2, f2);
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    @Retention(RetentionPolicy.SOURCE)
    public @interface AutoSizeTextType {
    }

    @RequiresApi(26)
    private static class OreoCallback implements ActionMode.Callback {

        /* renamed from: g  reason: collision with root package name */
        private static final int f6766g = 100;

        /* renamed from: a  reason: collision with root package name */
        private final ActionMode.Callback f6767a;

        /* renamed from: b  reason: collision with root package name */
        private final TextView f6768b;

        /* renamed from: c  reason: collision with root package name */
        private Class<?> f6769c;

        /* renamed from: d  reason: collision with root package name */
        private Method f6770d;

        /* renamed from: e  reason: collision with root package name */
        private boolean f6771e;

        /* renamed from: f  reason: collision with root package name */
        private boolean f6772f = false;

        OreoCallback(ActionMode.Callback callback, TextView textView) {
            this.f6767a = callback;
            this.f6768b = textView;
        }

        private Intent a() {
            return new Intent().setAction("android.intent.action.PROCESS_TEXT").setType("text/plain");
        }

        private Intent b(ResolveInfo resolveInfo, TextView textView) {
            Intent putExtra = a().putExtra("android.intent.extra.PROCESS_TEXT_READONLY", !e(textView));
            ActivityInfo activityInfo = resolveInfo.activityInfo;
            return putExtra.setClassName(activityInfo.packageName, activityInfo.name);
        }

        private List<ResolveInfo> c(Context context, PackageManager packageManager) {
            ArrayList arrayList = new ArrayList();
            if (!(context instanceof Activity)) {
                return arrayList;
            }
            for (ResolveInfo next : packageManager.queryIntentActivities(a(), 0)) {
                if (f(next, context)) {
                    arrayList.add(next);
                }
            }
            return arrayList;
        }

        private boolean e(TextView textView) {
            return (textView instanceof Editable) && textView.onCheckIsTextEditor() && textView.isEnabled();
        }

        private boolean f(ResolveInfo resolveInfo, Context context) {
            if (context.getPackageName().equals(resolveInfo.activityInfo.packageName)) {
                return true;
            }
            ActivityInfo activityInfo = resolveInfo.activityInfo;
            if (!activityInfo.exported) {
                return false;
            }
            String str = activityInfo.permission;
            return str == null || context.checkSelfPermission(str) == 0;
        }

        private void g(Menu menu) {
            Method method;
            Context context = this.f6768b.getContext();
            PackageManager packageManager = context.getPackageManager();
            if (!this.f6772f) {
                this.f6772f = true;
                try {
                    Class<?> cls = Class.forName("com.android.internal.view.menu.MenuBuilder");
                    this.f6769c = cls;
                    this.f6770d = cls.getDeclaredMethod("removeItemAt", new Class[]{Integer.TYPE});
                    this.f6771e = true;
                } catch (ClassNotFoundException | NoSuchMethodException unused) {
                    this.f6769c = null;
                    this.f6770d = null;
                    this.f6771e = false;
                }
            }
            try {
                if (!this.f6771e || !this.f6769c.isInstance(menu)) {
                    method = menu.getClass().getDeclaredMethod("removeItemAt", new Class[]{Integer.TYPE});
                } else {
                    method = this.f6770d;
                }
                for (int size = menu.size() - 1; size >= 0; size--) {
                    MenuItem item = menu.getItem(size);
                    if (item.getIntent() != null && "android.intent.action.PROCESS_TEXT".equals(item.getIntent().getAction())) {
                        method.invoke(menu, new Object[]{Integer.valueOf(size)});
                    }
                }
                List<ResolveInfo> c2 = c(context, packageManager);
                for (int i2 = 0; i2 < c2.size(); i2++) {
                    ResolveInfo resolveInfo = c2.get(i2);
                    menu.add(0, 0, i2 + 100, resolveInfo.loadLabel(packageManager)).setIntent(b(resolveInfo, this.f6768b)).setShowAsAction(1);
                }
            } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException unused2) {
            }
        }

        /* access modifiers changed from: package-private */
        @NonNull
        public ActionMode.Callback d() {
            return this.f6767a;
        }

        public boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
            return this.f6767a.onActionItemClicked(actionMode, menuItem);
        }

        public boolean onCreateActionMode(ActionMode actionMode, Menu menu) {
            return this.f6767a.onCreateActionMode(actionMode, menu);
        }

        public void onDestroyActionMode(ActionMode actionMode) {
            this.f6767a.onDestroyActionMode(actionMode);
        }

        public boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
            g(menu);
            return this.f6767a.onPrepareActionMode(actionMode, menu);
        }
    }

    private TextViewCompat() {
    }

    public static void A(@NonNull TextView textView, @Px @IntRange(from = 0) int i2) {
        Preconditions.i(i2);
        int fontMetricsInt = textView.getPaint().getFontMetricsInt((Paint.FontMetricsInt) null);
        if (i2 != fontMetricsInt) {
            textView.setLineSpacing((float) (i2 - fontMetricsInt), 1.0f);
        }
    }

    public static void B(@NonNull TextView textView, int i2, @FloatRange(from = 0.0d) float f2) {
        if (Build.VERSION.SDK_INT >= 34) {
            Api34Impl.a(textView, i2, f2);
        } else {
            A(textView, Math.round(TypedValue.applyDimension(i2, f2, textView.getResources().getDisplayMetrics())));
        }
    }

    public static void C(@NonNull TextView textView, @NonNull PrecomputedTextCompat precomputedTextCompat) {
        CharSequence charSequence;
        if (Build.VERSION.SDK_INT >= 29) {
            charSequence = Api28Impl.a(precomputedTextCompat.f());
        } else {
            boolean a2 = o(textView).a(precomputedTextCompat.e());
            charSequence = precomputedTextCompat;
            if (!a2) {
                throw new IllegalArgumentException("Given text can not be applied to TextView.");
            }
        }
        textView.setText(charSequence);
    }

    public static void D(@NonNull TextView textView, @StyleRes int i2) {
        if (Build.VERSION.SDK_INT >= 23) {
            textView.setTextAppearance(i2);
        } else {
            textView.setTextAppearance(textView.getContext(), i2);
        }
    }

    public static void E(@NonNull TextView textView, @NonNull PrecomputedTextCompat.Params params) {
        textView.setTextDirection(m(params.d()));
        if (Build.VERSION.SDK_INT < 23) {
            float textScaleX = params.e().getTextScaleX();
            textView.getPaint().set(params.e());
            if (textScaleX == textView.getTextScaleX()) {
                textView.setTextScaleX((textScaleX / 2.0f) + 1.0f);
            }
            textView.setTextScaleX(textScaleX);
            return;
        }
        textView.getPaint().set(params.e());
        Api23Impl.e(textView, params.b());
        Api23Impl.h(textView, params.c());
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static ActionMode.Callback F(@Nullable ActionMode.Callback callback) {
        return (!(callback instanceof OreoCallback) || Build.VERSION.SDK_INT < 26) ? callback : ((OreoCallback) callback).d();
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static ActionMode.Callback G(@NonNull TextView textView, @Nullable ActionMode.Callback callback) {
        int i2 = Build.VERSION.SDK_INT;
        return (i2 < 26 || i2 > 27 || (callback instanceof OreoCallback) || callback == null) ? callback : new OreoCallback(callback, textView);
    }

    public static int a(@NonNull TextView textView) {
        if (Build.VERSION.SDK_INT >= 27) {
            return Api26Impl.a(textView);
        }
        if (textView instanceof AutoSizeableTextView) {
            return ((AutoSizeableTextView) textView).getAutoSizeMaxTextSize();
        }
        return -1;
    }

    public static int b(@NonNull TextView textView) {
        if (Build.VERSION.SDK_INT >= 27) {
            return Api26Impl.b(textView);
        }
        if (textView instanceof AutoSizeableTextView) {
            return ((AutoSizeableTextView) textView).getAutoSizeMinTextSize();
        }
        return -1;
    }

    public static int c(@NonNull TextView textView) {
        if (Build.VERSION.SDK_INT >= 27) {
            return Api26Impl.c(textView);
        }
        if (textView instanceof AutoSizeableTextView) {
            return ((AutoSizeableTextView) textView).getAutoSizeStepGranularity();
        }
        return -1;
    }

    @NonNull
    public static int[] d(@NonNull TextView textView) {
        if (Build.VERSION.SDK_INT >= 27) {
            return Api26Impl.d(textView);
        }
        return textView instanceof AutoSizeableTextView ? ((AutoSizeableTextView) textView).getAutoSizeTextAvailableSizes() : new int[0];
    }

    public static int e(@NonNull TextView textView) {
        if (Build.VERSION.SDK_INT >= 27) {
            return Api26Impl.e(textView);
        }
        if (textView instanceof AutoSizeableTextView) {
            return ((AutoSizeableTextView) textView).getAutoSizeTextType();
        }
        return 0;
    }

    @Nullable
    public static ColorStateList f(@NonNull TextView textView) {
        Preconditions.l(textView);
        if (Build.VERSION.SDK_INT >= 24) {
            return Api23Impl.b(textView);
        }
        if (textView instanceof TintableCompoundDrawablesView) {
            return ((TintableCompoundDrawablesView) textView).getSupportCompoundDrawablesTintList();
        }
        return null;
    }

    @Nullable
    public static PorterDuff.Mode g(@NonNull TextView textView) {
        Preconditions.l(textView);
        if (Build.VERSION.SDK_INT >= 24) {
            return Api23Impl.c(textView);
        }
        if (textView instanceof TintableCompoundDrawablesView) {
            return ((TintableCompoundDrawablesView) textView).getSupportCompoundDrawablesTintMode();
        }
        return null;
    }

    @NonNull
    public static Drawable[] h(@NonNull TextView textView) {
        return textView.getCompoundDrawablesRelative();
    }

    public static int i(@NonNull TextView textView) {
        return textView.getPaddingTop() - textView.getPaint().getFontMetricsInt().top;
    }

    public static int j(@NonNull TextView textView) {
        return textView.getPaddingBottom() + textView.getPaint().getFontMetricsInt().bottom;
    }

    public static int k(@NonNull TextView textView) {
        return textView.getMaxLines();
    }

    public static int l(@NonNull TextView textView) {
        return textView.getMinLines();
    }

    private static int m(@NonNull TextDirectionHeuristic textDirectionHeuristic) {
        TextDirectionHeuristic textDirectionHeuristic2;
        TextDirectionHeuristic textDirectionHeuristic3 = TextDirectionHeuristics.FIRSTSTRONG_RTL;
        if (textDirectionHeuristic == textDirectionHeuristic3 || textDirectionHeuristic == (textDirectionHeuristic2 = TextDirectionHeuristics.FIRSTSTRONG_LTR)) {
            return 1;
        }
        if (textDirectionHeuristic == TextDirectionHeuristics.ANYRTL_LTR) {
            return 2;
        }
        if (textDirectionHeuristic == TextDirectionHeuristics.LTR) {
            return 3;
        }
        if (textDirectionHeuristic == TextDirectionHeuristics.RTL) {
            return 4;
        }
        if (textDirectionHeuristic == TextDirectionHeuristics.LOCALE) {
            return 5;
        }
        if (textDirectionHeuristic == textDirectionHeuristic2) {
            return 6;
        }
        return textDirectionHeuristic == textDirectionHeuristic3 ? 7 : 1;
    }

    private static TextDirectionHeuristic n(@NonNull TextView textView) {
        if (textView.getTransformationMethod() instanceof PasswordTransformationMethod) {
            return TextDirectionHeuristics.LTR;
        }
        boolean z = true;
        if (Build.VERSION.SDK_INT < 28 || (textView.getInputType() & 15) != 3) {
            if (textView.getLayoutDirection() != 1) {
                z = false;
            }
            switch (textView.getTextDirection()) {
                case 2:
                    return TextDirectionHeuristics.ANYRTL_LTR;
                case 3:
                    return TextDirectionHeuristics.LTR;
                case 4:
                    return TextDirectionHeuristics.RTL;
                case 5:
                    return TextDirectionHeuristics.LOCALE;
                case 6:
                    return TextDirectionHeuristics.FIRSTSTRONG_LTR;
                case 7:
                    return TextDirectionHeuristics.FIRSTSTRONG_RTL;
                default:
                    return z ? TextDirectionHeuristics.FIRSTSTRONG_RTL : TextDirectionHeuristics.FIRSTSTRONG_LTR;
            }
        } else {
            byte directionality = Character.getDirectionality(Api28Impl.b(Api24Impl.a(textView.getTextLocale()))[0].codePointAt(0));
            return (directionality == 1 || directionality == 2) ? TextDirectionHeuristics.RTL : TextDirectionHeuristics.LTR;
        }
    }

    @NonNull
    public static PrecomputedTextCompat.Params o(@NonNull TextView textView) {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 28) {
            return new PrecomputedTextCompat.Params(Api28Impl.c(textView));
        }
        PrecomputedTextCompat.Params.Builder builder = new PrecomputedTextCompat.Params.Builder(new TextPaint(textView.getPaint()));
        if (i2 >= 23) {
            builder.b(Api23Impl.a(textView));
            builder.c(Api23Impl.d(textView));
        }
        builder.d(n(textView));
        return builder.a();
    }

    public static void p(@NonNull TextView textView, int i2, int i3, int i4, int i5) throws IllegalArgumentException {
        if (Build.VERSION.SDK_INT >= 27) {
            Api26Impl.f(textView, i2, i3, i4, i5);
        } else if (textView instanceof AutoSizeableTextView) {
            ((AutoSizeableTextView) textView).setAutoSizeTextTypeUniformWithConfiguration(i2, i3, i4, i5);
        }
    }

    public static void q(@NonNull TextView textView, @NonNull int[] iArr, int i2) throws IllegalArgumentException {
        if (Build.VERSION.SDK_INT >= 27) {
            Api26Impl.g(textView, iArr, i2);
        } else if (textView instanceof AutoSizeableTextView) {
            ((AutoSizeableTextView) textView).setAutoSizeTextTypeUniformWithPresetSizes(iArr, i2);
        }
    }

    public static void r(@NonNull TextView textView, int i2) {
        if (Build.VERSION.SDK_INT >= 27) {
            Api26Impl.h(textView, i2);
        } else if (textView instanceof AutoSizeableTextView) {
            ((AutoSizeableTextView) textView).setAutoSizeTextTypeWithDefaults(i2);
        }
    }

    public static void s(@NonNull TextView textView, @Nullable ColorStateList colorStateList) {
        Preconditions.l(textView);
        if (Build.VERSION.SDK_INT >= 24) {
            Api23Impl.f(textView, colorStateList);
        } else if (textView instanceof TintableCompoundDrawablesView) {
            ((TintableCompoundDrawablesView) textView).setSupportCompoundDrawablesTintList(colorStateList);
        }
    }

    public static void t(@NonNull TextView textView, @Nullable PorterDuff.Mode mode) {
        Preconditions.l(textView);
        if (Build.VERSION.SDK_INT >= 24) {
            Api23Impl.g(textView, mode);
        } else if (textView instanceof TintableCompoundDrawablesView) {
            ((TintableCompoundDrawablesView) textView).setSupportCompoundDrawablesTintMode(mode);
        }
    }

    public static void u(@NonNull TextView textView, @Nullable Drawable drawable, @Nullable Drawable drawable2, @Nullable Drawable drawable3, @Nullable Drawable drawable4) {
        textView.setCompoundDrawablesRelative(drawable, drawable2, drawable3, drawable4);
    }

    public static void v(@NonNull TextView textView, @DrawableRes int i2, @DrawableRes int i3, @DrawableRes int i4, @DrawableRes int i5) {
        textView.setCompoundDrawablesRelativeWithIntrinsicBounds(i2, i3, i4, i5);
    }

    public static void w(@NonNull TextView textView, @Nullable Drawable drawable, @Nullable Drawable drawable2, @Nullable Drawable drawable3, @Nullable Drawable drawable4) {
        textView.setCompoundDrawablesRelativeWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
    }

    public static void x(@NonNull TextView textView, @NonNull ActionMode.Callback callback) {
        textView.setCustomSelectionActionModeCallback(G(textView, callback));
    }

    public static void y(@NonNull TextView textView, @Px @IntRange(from = 0) int i2) {
        Preconditions.i(i2);
        if (Build.VERSION.SDK_INT >= 28) {
            Api28Impl.d(textView, i2);
            return;
        }
        Paint.FontMetricsInt fontMetricsInt = textView.getPaint().getFontMetricsInt();
        int i3 = textView.getIncludeFontPadding() ? fontMetricsInt.top : fontMetricsInt.ascent;
        if (i2 > Math.abs(i3)) {
            textView.setPadding(textView.getPaddingLeft(), i2 + i3, textView.getPaddingRight(), textView.getPaddingBottom());
        }
    }

    public static void z(@NonNull TextView textView, @Px @IntRange(from = 0) int i2) {
        Preconditions.i(i2);
        Paint.FontMetricsInt fontMetricsInt = textView.getPaint().getFontMetricsInt();
        int i3 = textView.getIncludeFontPadding() ? fontMetricsInt.bottom : fontMetricsInt.descent;
        if (i2 > Math.abs(i3)) {
            textView.setPadding(textView.getPaddingLeft(), textView.getPaddingTop(), textView.getPaddingRight(), i2 - i3);
        }
    }
}
