package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import androidx.annotation.DoNotInline;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.annotation.StyleableRes;
import androidx.core.content.res.ResourcesCompat;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class TintTypedArray {

    /* renamed from: a  reason: collision with root package name */
    private final Context f3317a;

    /* renamed from: b  reason: collision with root package name */
    private final TypedArray f3318b;

    /* renamed from: c  reason: collision with root package name */
    private TypedValue f3319c;

    @RequiresApi(21)
    static class Api21Impl {
        private Api21Impl() {
        }

        @DoNotInline
        static int a(TypedArray typedArray) {
            return typedArray.getChangingConfigurations();
        }

        @DoNotInline
        static int b(TypedArray typedArray, int i2) {
            return typedArray.getType(i2);
        }
    }

    private TintTypedArray(Context context, TypedArray typedArray) {
        this.f3317a = context;
        this.f3318b = typedArray;
    }

    public static TintTypedArray E(Context context, int i2, int[] iArr) {
        return new TintTypedArray(context, context.obtainStyledAttributes(i2, iArr));
    }

    public static TintTypedArray F(Context context, AttributeSet attributeSet, int[] iArr) {
        return new TintTypedArray(context, context.obtainStyledAttributes(attributeSet, iArr));
    }

    public static TintTypedArray G(Context context, AttributeSet attributeSet, int[] iArr, int i2, int i3) {
        return new TintTypedArray(context, context.obtainStyledAttributes(attributeSet, iArr, i2, i3));
    }

    public boolean A(int i2, TypedValue typedValue) {
        return this.f3318b.getValue(i2, typedValue);
    }

    public TypedArray B() {
        return this.f3318b;
    }

    public boolean C(int i2) {
        return this.f3318b.hasValue(i2);
    }

    public int D() {
        return this.f3318b.length();
    }

    public TypedValue H(int i2) {
        return this.f3318b.peekValue(i2);
    }

    public void I() {
        this.f3318b.recycle();
    }

    public boolean a(int i2, boolean z) {
        return this.f3318b.getBoolean(i2, z);
    }

    @RequiresApi(21)
    public int b() {
        return Api21Impl.a(this.f3318b);
    }

    public int c(int i2, int i3) {
        return this.f3318b.getColor(i2, i3);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x0011, code lost:
        r0 = androidx.appcompat.content.res.AppCompatResources.a(r2.f3317a, (r0 = r2.f3318b.getResourceId(r3, 0)));
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public android.content.res.ColorStateList d(int r3) {
        /*
            r2 = this;
            android.content.res.TypedArray r0 = r2.f3318b
            boolean r0 = r0.hasValue(r3)
            if (r0 == 0) goto L_0x001a
            android.content.res.TypedArray r0 = r2.f3318b
            r1 = 0
            int r0 = r0.getResourceId(r3, r1)
            if (r0 == 0) goto L_0x001a
            android.content.Context r1 = r2.f3317a
            android.content.res.ColorStateList r0 = androidx.appcompat.content.res.AppCompatResources.a(r1, r0)
            if (r0 == 0) goto L_0x001a
            return r0
        L_0x001a:
            android.content.res.TypedArray r0 = r2.f3318b
            android.content.res.ColorStateList r3 = r0.getColorStateList(r3)
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.TintTypedArray.d(int):android.content.res.ColorStateList");
    }

    public float e(int i2, float f2) {
        return this.f3318b.getDimension(i2, f2);
    }

    public int f(int i2, int i3) {
        return this.f3318b.getDimensionPixelOffset(i2, i3);
    }

    public int g(int i2, int i3) {
        return this.f3318b.getDimensionPixelSize(i2, i3);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0008, code lost:
        r0 = r2.f3318b.getResourceId(r3, 0);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public android.graphics.drawable.Drawable h(int r3) {
        /*
            r2 = this;
            android.content.res.TypedArray r0 = r2.f3318b
            boolean r0 = r0.hasValue(r3)
            if (r0 == 0) goto L_0x0018
            android.content.res.TypedArray r0 = r2.f3318b
            r1 = 0
            int r0 = r0.getResourceId(r3, r1)
            if (r0 == 0) goto L_0x0018
            android.content.Context r3 = r2.f3317a
            android.graphics.drawable.Drawable r3 = androidx.appcompat.content.res.AppCompatResources.b(r3, r0)
            return r3
        L_0x0018:
            android.content.res.TypedArray r0 = r2.f3318b
            android.graphics.drawable.Drawable r3 = r0.getDrawable(r3)
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.TintTypedArray.h(int):android.graphics.drawable.Drawable");
    }

    public Drawable i(int i2) {
        int resourceId;
        if (!this.f3318b.hasValue(i2) || (resourceId = this.f3318b.getResourceId(i2, 0)) == 0) {
            return null;
        }
        return AppCompatDrawableManager.b().d(this.f3317a, resourceId, true);
    }

    public float j(int i2, float f2) {
        return this.f3318b.getFloat(i2, f2);
    }

    @Nullable
    public Typeface k(@StyleableRes int i2, int i3, @Nullable ResourcesCompat.FontCallback fontCallback) {
        int resourceId = this.f3318b.getResourceId(i2, 0);
        if (resourceId == 0) {
            return null;
        }
        if (this.f3319c == null) {
            this.f3319c = new TypedValue();
        }
        return ResourcesCompat.k(this.f3317a, resourceId, this.f3319c, i3, fontCallback);
    }

    public float l(int i2, int i3, int i4, float f2) {
        return this.f3318b.getFraction(i2, i3, i4, f2);
    }

    public int m(int i2) {
        return this.f3318b.getIndex(i2);
    }

    public int n() {
        return this.f3318b.getIndexCount();
    }

    public int o(int i2, int i3) {
        return this.f3318b.getInt(i2, i3);
    }

    public int p(int i2, int i3) {
        return this.f3318b.getInteger(i2, i3);
    }

    public int q(int i2, int i3) {
        return this.f3318b.getLayoutDimension(i2, i3);
    }

    public int r(int i2, String str) {
        return this.f3318b.getLayoutDimension(i2, str);
    }

    public String s(int i2) {
        return this.f3318b.getNonResourceString(i2);
    }

    public String t() {
        return this.f3318b.getPositionDescription();
    }

    public int u(int i2, int i3) {
        return this.f3318b.getResourceId(i2, i3);
    }

    public Resources v() {
        return this.f3318b.getResources();
    }

    public String w(int i2) {
        return this.f3318b.getString(i2);
    }

    public CharSequence x(int i2) {
        return this.f3318b.getText(i2);
    }

    public CharSequence[] y(int i2) {
        return this.f3318b.getTextArray(i2);
    }

    public int z(int i2) {
        return Api21Impl.b(this.f3318b, i2);
    }
}
