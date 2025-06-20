package androidx.appcompat.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.RectF;
import android.os.Build;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextDirectionHeuristic;
import android.text.TextDirectionHeuristics;
import android.text.TextPaint;
import android.text.method.TransformationMethod;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.TypedValue;
import android.widget.TextView;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.appcompat.R;
import androidx.core.view.ViewCompat;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.concurrent.ConcurrentHashMap;

class AppCompatTextViewAutoSizeHelper {

    /* renamed from: l  reason: collision with root package name */
    private static final String f3170l = "ACTVAutoSizeHelper";

    /* renamed from: m  reason: collision with root package name */
    private static final RectF f3171m = new RectF();

    /* renamed from: n  reason: collision with root package name */
    private static final int f3172n = 12;
    private static final int o = 112;
    private static final int p = 1;
    @SuppressLint({"BanConcurrentHashMap"})
    private static ConcurrentHashMap<String, Method> q = new ConcurrentHashMap<>();
    static final float r = -1.0f;
    private static final int s = 1048576;

    /* renamed from: a  reason: collision with root package name */
    private int f3173a = 0;

    /* renamed from: b  reason: collision with root package name */
    private boolean f3174b = false;

    /* renamed from: c  reason: collision with root package name */
    private float f3175c = r;

    /* renamed from: d  reason: collision with root package name */
    private float f3176d = r;

    /* renamed from: e  reason: collision with root package name */
    private float f3177e = r;

    /* renamed from: f  reason: collision with root package name */
    private int[] f3178f = new int[0];

    /* renamed from: g  reason: collision with root package name */
    private boolean f3179g = false;

    /* renamed from: h  reason: collision with root package name */
    private TextPaint f3180h;
    @NonNull

    /* renamed from: i  reason: collision with root package name */
    private final TextView f3181i;

    /* renamed from: j  reason: collision with root package name */
    private final Context f3182j;

    /* renamed from: k  reason: collision with root package name */
    private final Impl f3183k;

    @RequiresApi(23)
    private static final class Api23Impl {
        private Api23Impl() {
        }

        @DoNotInline
        @NonNull
        static StaticLayout a(@NonNull CharSequence charSequence, @NonNull Layout.Alignment alignment, int i2, int i3, @NonNull TextView textView, @NonNull TextPaint textPaint, @NonNull Impl impl) {
            StaticLayout.Builder obtain = StaticLayout.Builder.obtain(charSequence, 0, charSequence.length(), textPaint, i2);
            StaticLayout.Builder hyphenationFrequency = obtain.setAlignment(alignment).setLineSpacing(textView.getLineSpacingExtra(), textView.getLineSpacingMultiplier()).setIncludePad(textView.getIncludeFontPadding()).setBreakStrategy(textView.getBreakStrategy()).setHyphenationFrequency(textView.getHyphenationFrequency());
            if (i3 == -1) {
                i3 = Integer.MAX_VALUE;
            }
            hyphenationFrequency.setMaxLines(i3);
            try {
                impl.a(obtain, textView);
            } catch (ClassCastException unused) {
                Log.w(AppCompatTextViewAutoSizeHelper.f3170l, "Failed to obtain TextDirectionHeuristic, auto size may be incorrect");
            }
            return obtain.build();
        }
    }

    private static class Impl {
        Impl() {
        }

        /* access modifiers changed from: package-private */
        public void a(StaticLayout.Builder builder, TextView textView) {
        }

        /* access modifiers changed from: package-private */
        public boolean b(TextView textView) {
            return ((Boolean) AppCompatTextViewAutoSizeHelper.m(textView, "getHorizontallyScrolling", Boolean.FALSE)).booleanValue();
        }
    }

    @RequiresApi(23)
    private static class Impl23 extends Impl {
        Impl23() {
        }

        /* access modifiers changed from: package-private */
        public void a(StaticLayout.Builder builder, TextView textView) {
            StaticLayout.Builder unused = builder.setTextDirection((TextDirectionHeuristic) AppCompatTextViewAutoSizeHelper.m(textView, "getTextDirectionHeuristic", TextDirectionHeuristics.FIRSTSTRONG_LTR));
        }
    }

    @RequiresApi(29)
    private static class Impl29 extends Impl23 {
        Impl29() {
        }

        /* access modifiers changed from: package-private */
        public void a(StaticLayout.Builder builder, TextView textView) {
            StaticLayout.Builder unused = builder.setTextDirection(textView.getTextDirectionHeuristic());
        }

        /* access modifiers changed from: package-private */
        public boolean b(TextView textView) {
            return textView.isHorizontallyScrollable();
        }
    }

    AppCompatTextViewAutoSizeHelper(@NonNull TextView textView) {
        this.f3181i = textView;
        this.f3182j = textView.getContext();
        int i2 = Build.VERSION.SDK_INT;
        this.f3183k = i2 >= 29 ? new Impl29() : i2 >= 23 ? new Impl23() : new Impl();
    }

    private int[] b(int[] iArr) {
        if (r0 == 0) {
            return iArr;
        }
        Arrays.sort(iArr);
        ArrayList arrayList = new ArrayList();
        for (int i2 : iArr) {
            if (i2 > 0 && Collections.binarySearch(arrayList, Integer.valueOf(i2)) < 0) {
                arrayList.add(Integer.valueOf(i2));
            }
        }
        if (r0 == arrayList.size()) {
            return iArr;
        }
        int size = arrayList.size();
        int[] iArr2 = new int[size];
        for (int i3 = 0; i3 < size; i3++) {
            iArr2[i3] = ((Integer) arrayList.get(i3)).intValue();
        }
        return iArr2;
    }

    private void c() {
        this.f3173a = 0;
        this.f3176d = r;
        this.f3177e = r;
        this.f3175c = r;
        this.f3178f = new int[0];
        this.f3174b = false;
    }

    private int e(RectF rectF) {
        int length = this.f3178f.length;
        if (length != 0) {
            int i2 = 1;
            int i3 = length - 1;
            int i4 = 0;
            while (i2 <= i3) {
                int i5 = (i2 + i3) / 2;
                if (x(this.f3178f[i5], rectF)) {
                    int i6 = i5 + 1;
                    i4 = i2;
                    i2 = i6;
                } else {
                    i4 = i5 - 1;
                    i3 = i4;
                }
            }
            return this.f3178f[i4];
        }
        throw new IllegalStateException("No available text sizes to choose from.");
    }

    @Nullable
    private static Method k(@NonNull String str) {
        try {
            Method method = q.get(str);
            if (method == null && (method = TextView.class.getDeclaredMethod(str, (Class[]) null)) != null) {
                method.setAccessible(true);
                q.put(str, method);
            }
            return method;
        } catch (Exception e2) {
            Log.w(f3170l, "Failed to retrieve TextView#" + str + "() method", e2);
            return null;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x000c, code lost:
        r3 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:5:0x000f, code lost:
        android.util.Log.w(f3170l, "Failed to invoke TextView#" + r4 + "() method", r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:?, code lost:
        return r5;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    @android.annotation.SuppressLint({"BanUncheckedReflection"})
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static <T> T m(@androidx.annotation.NonNull java.lang.Object r3, @androidx.annotation.NonNull java.lang.String r4, @androidx.annotation.NonNull T r5) {
        /*
            java.lang.reflect.Method r0 = k(r4)     // Catch:{ Exception -> 0x000c, all -> 0x000a }
            r1 = 0
            java.lang.Object r5 = r0.invoke(r3, r1)     // Catch:{ Exception -> 0x000c, all -> 0x000a }
            goto L_0x002a
        L_0x000a:
            r3 = move-exception
            goto L_0x000e
        L_0x000c:
            r3 = move-exception
            goto L_0x000f
        L_0x000e:
            throw r3
        L_0x000f:
            java.lang.String r0 = "ACTVAutoSizeHelper"
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Failed to invoke TextView#"
            r1.append(r2)
            r1.append(r4)
            java.lang.String r4 = "() method"
            r1.append(r4)
            java.lang.String r4 = r1.toString()
            android.util.Log.w(r0, r4, r3)
        L_0x002a:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.AppCompatTextViewAutoSizeHelper.m(java.lang.Object, java.lang.String, java.lang.Object):java.lang.Object");
    }

    @SuppressLint({"BanUncheckedReflection"})
    private void s(float f2) {
        if (f2 != this.f3181i.getPaint().getTextSize()) {
            this.f3181i.getPaint().setTextSize(f2);
            boolean isInLayout = this.f3181i.isInLayout();
            if (this.f3181i.getLayout() != null) {
                this.f3174b = false;
                try {
                    Method k2 = k("nullLayouts");
                    if (k2 != null) {
                        k2.invoke(this.f3181i, (Object[]) null);
                    }
                } catch (Exception e2) {
                    Log.w(f3170l, "Failed to invoke TextView#nullLayouts() method", e2);
                }
                if (!isInLayout) {
                    this.f3181i.requestLayout();
                } else {
                    this.f3181i.forceLayout();
                }
                this.f3181i.invalidate();
            }
        }
    }

    private boolean u() {
        if (!y() || this.f3173a != 1) {
            this.f3174b = false;
        } else {
            if (!this.f3179g || this.f3178f.length == 0) {
                int floor = ((int) Math.floor((double) ((this.f3177e - this.f3176d) / this.f3175c))) + 1;
                int[] iArr = new int[floor];
                for (int i2 = 0; i2 < floor; i2++) {
                    iArr[i2] = Math.round(this.f3176d + (((float) i2) * this.f3175c));
                }
                this.f3178f = b(iArr);
            }
            this.f3174b = true;
        }
        return this.f3174b;
    }

    private void v(TypedArray typedArray) {
        int length = typedArray.length();
        int[] iArr = new int[length];
        if (length > 0) {
            for (int i2 = 0; i2 < length; i2++) {
                iArr[i2] = typedArray.getDimensionPixelSize(i2, -1);
            }
            this.f3178f = b(iArr);
            w();
        }
    }

    private boolean w() {
        int[] iArr = this.f3178f;
        int length = iArr.length;
        boolean z = length > 0;
        this.f3179g = z;
        if (z) {
            this.f3173a = 1;
            this.f3176d = (float) iArr[0];
            this.f3177e = (float) iArr[length - 1];
            this.f3175c = r;
        }
        return z;
    }

    private boolean x(int i2, RectF rectF) {
        CharSequence transformation;
        CharSequence text = this.f3181i.getText();
        TransformationMethod transformationMethod = this.f3181i.getTransformationMethod();
        if (!(transformationMethod == null || (transformation = transformationMethod.getTransformation(text, this.f3181i)) == null)) {
            text = transformation;
        }
        int maxLines = this.f3181i.getMaxLines();
        l(i2);
        StaticLayout d2 = d(text, (Layout.Alignment) m(this.f3181i, "getLayoutAlignment", Layout.Alignment.ALIGN_NORMAL), Math.round(rectF.right), maxLines);
        return (maxLines == -1 || (d2.getLineCount() <= maxLines && d2.getLineEnd(d2.getLineCount() - 1) == text.length())) && ((float) d2.getHeight()) <= rectF.bottom;
    }

    private boolean y() {
        return !(this.f3181i instanceof AppCompatEditText);
    }

    private void z(float f2, float f3, float f4) throws IllegalArgumentException {
        if (f2 <= 0.0f) {
            throw new IllegalArgumentException("Minimum auto-size text size (" + f2 + "px) is less or equal to (0px)");
        } else if (f3 <= f2) {
            throw new IllegalArgumentException("Maximum auto-size text size (" + f3 + "px) is less or equal to minimum auto-size text size (" + f2 + "px)");
        } else if (f4 > 0.0f) {
            this.f3173a = 1;
            this.f3176d = f2;
            this.f3177e = f3;
            this.f3175c = f4;
            this.f3179g = false;
        } else {
            throw new IllegalArgumentException("The auto-size step granularity (" + f4 + "px) is less or equal to (0px)");
        }
    }

    /* access modifiers changed from: package-private */
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void a() {
        if (n()) {
            if (this.f3174b) {
                if (this.f3181i.getMeasuredHeight() > 0 && this.f3181i.getMeasuredWidth() > 0) {
                    int measuredWidth = this.f3183k.b(this.f3181i) ? 1048576 : (this.f3181i.getMeasuredWidth() - this.f3181i.getTotalPaddingLeft()) - this.f3181i.getTotalPaddingRight();
                    int height = (this.f3181i.getHeight() - this.f3181i.getCompoundPaddingBottom()) - this.f3181i.getCompoundPaddingTop();
                    if (measuredWidth > 0 && height > 0) {
                        RectF rectF = f3171m;
                        synchronized (rectF) {
                            try {
                                rectF.setEmpty();
                                rectF.right = (float) measuredWidth;
                                rectF.bottom = (float) height;
                                float e2 = (float) e(rectF);
                                if (e2 != this.f3181i.getTextSize()) {
                                    t(0, e2);
                                }
                            } catch (Throwable th) {
                                throw th;
                            }
                        }
                    } else {
                        return;
                    }
                } else {
                    return;
                }
            }
            this.f3174b = true;
        }
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    @NonNull
    public StaticLayout d(@NonNull CharSequence charSequence, @NonNull Layout.Alignment alignment, int i2, int i3) {
        if (Build.VERSION.SDK_INT >= 23) {
            return Api23Impl.a(charSequence, alignment, i2, i3, this.f3181i, this.f3180h, this.f3183k);
        }
        return new StaticLayout(charSequence, this.f3180h, i2, alignment, this.f3181i.getLineSpacingMultiplier(), this.f3181i.getLineSpacingExtra(), this.f3181i.getIncludeFontPadding());
    }

    /* access modifiers changed from: package-private */
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public int f() {
        return Math.round(this.f3177e);
    }

    /* access modifiers changed from: package-private */
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public int g() {
        return Math.round(this.f3176d);
    }

    /* access modifiers changed from: package-private */
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public int h() {
        return Math.round(this.f3175c);
    }

    /* access modifiers changed from: package-private */
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public int[] i() {
        return this.f3178f;
    }

    /* access modifiers changed from: package-private */
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public int j() {
        return this.f3173a;
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    public void l(int i2) {
        TextPaint textPaint = this.f3180h;
        if (textPaint == null) {
            this.f3180h = new TextPaint();
        } else {
            textPaint.reset();
        }
        this.f3180h.set(this.f3181i.getPaint());
        this.f3180h.setTextSize((float) i2);
    }

    /* access modifiers changed from: package-private */
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public boolean n() {
        return y() && this.f3173a != 0;
    }

    /* access modifiers changed from: package-private */
    public void o(@Nullable AttributeSet attributeSet, int i2) {
        int resourceId;
        Context context = this.f3182j;
        int[] iArr = R.styleable.v0;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, iArr, i2, 0);
        TextView textView = this.f3181i;
        ViewCompat.F1(textView, textView.getContext(), iArr, attributeSet, obtainStyledAttributes, i2, 0);
        int i3 = R.styleable.B0;
        if (obtainStyledAttributes.hasValue(i3)) {
            this.f3173a = obtainStyledAttributes.getInt(i3, 0);
        }
        int i4 = R.styleable.A0;
        float dimension = obtainStyledAttributes.hasValue(i4) ? obtainStyledAttributes.getDimension(i4, r) : r;
        int i5 = R.styleable.y0;
        float dimension2 = obtainStyledAttributes.hasValue(i5) ? obtainStyledAttributes.getDimension(i5, r) : r;
        int i6 = R.styleable.x0;
        float dimension3 = obtainStyledAttributes.hasValue(i6) ? obtainStyledAttributes.getDimension(i6, r) : r;
        int i7 = R.styleable.z0;
        if (obtainStyledAttributes.hasValue(i7) && (resourceId = obtainStyledAttributes.getResourceId(i7, 0)) > 0) {
            TypedArray obtainTypedArray = obtainStyledAttributes.getResources().obtainTypedArray(resourceId);
            v(obtainTypedArray);
            obtainTypedArray.recycle();
        }
        obtainStyledAttributes.recycle();
        if (!y()) {
            this.f3173a = 0;
        } else if (this.f3173a == 1) {
            if (!this.f3179g) {
                DisplayMetrics displayMetrics = this.f3182j.getResources().getDisplayMetrics();
                if (dimension2 == r) {
                    dimension2 = TypedValue.applyDimension(2, 12.0f, displayMetrics);
                }
                if (dimension3 == r) {
                    dimension3 = TypedValue.applyDimension(2, 112.0f, displayMetrics);
                }
                if (dimension == r) {
                    dimension = 1.0f;
                }
                z(dimension2, dimension3, dimension);
            }
            u();
        }
    }

    /* access modifiers changed from: package-private */
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void p(int i2, int i3, int i4, int i5) throws IllegalArgumentException {
        if (y()) {
            DisplayMetrics displayMetrics = this.f3182j.getResources().getDisplayMetrics();
            z(TypedValue.applyDimension(i5, (float) i2, displayMetrics), TypedValue.applyDimension(i5, (float) i3, displayMetrics), TypedValue.applyDimension(i5, (float) i4, displayMetrics));
            if (u()) {
                a();
            }
        }
    }

    /* access modifiers changed from: package-private */
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void q(@NonNull int[] iArr, int i2) throws IllegalArgumentException {
        if (y()) {
            int length = iArr.length;
            if (length > 0) {
                int[] iArr2 = new int[length];
                if (i2 == 0) {
                    iArr2 = Arrays.copyOf(iArr, length);
                } else {
                    DisplayMetrics displayMetrics = this.f3182j.getResources().getDisplayMetrics();
                    for (int i3 = 0; i3 < length; i3++) {
                        iArr2[i3] = Math.round(TypedValue.applyDimension(i2, (float) iArr[i3], displayMetrics));
                    }
                }
                this.f3178f = b(iArr2);
                if (!w()) {
                    throw new IllegalArgumentException("None of the preset sizes is valid: " + Arrays.toString(iArr));
                }
            } else {
                this.f3179g = false;
            }
            if (u()) {
                a();
            }
        }
    }

    /* access modifiers changed from: package-private */
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void r(int i2) {
        if (!y()) {
            return;
        }
        if (i2 == 0) {
            c();
        } else if (i2 == 1) {
            DisplayMetrics displayMetrics = this.f3182j.getResources().getDisplayMetrics();
            z(TypedValue.applyDimension(2, 12.0f, displayMetrics), TypedValue.applyDimension(2, 112.0f, displayMetrics), 1.0f);
            if (u()) {
                a();
            }
        } else {
            throw new IllegalArgumentException("Unknown auto-size text type: " + i2);
        }
    }

    /* access modifiers changed from: package-private */
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void t(int i2, float f2) {
        Context context = this.f3182j;
        s(TypedValue.applyDimension(i2, f2, (context == null ? Resources.getSystem() : context.getResources()).getDisplayMetrics()));
    }
}
