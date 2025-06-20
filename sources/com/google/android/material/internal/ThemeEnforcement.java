package com.google.android.material.internal;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.TypedValue;
import androidx.annotation.AttrRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.StyleRes;
import androidx.annotation.StyleableRes;
import androidx.appcompat.widget.TintTypedArray;
import com.google.android.material.R;
import com.google.android.material.resources.MaterialAttributes;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public final class ThemeEnforcement {

    /* renamed from: a  reason: collision with root package name */
    private static final int[] f21574a = {R.attr.R3};

    /* renamed from: b  reason: collision with root package name */
    private static final String f21575b = "Theme.AppCompat";

    /* renamed from: c  reason: collision with root package name */
    private static final int[] f21576c = {R.attr.Y3};

    /* renamed from: d  reason: collision with root package name */
    private static final String f21577d = "Theme.MaterialComponents";

    private ThemeEnforcement() {
    }

    public static void a(@NonNull Context context) {
        e(context, f21574a, f21575b);
    }

    private static void b(@NonNull Context context, AttributeSet attributeSet, @AttrRes int i2, @StyleRes int i3) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.Px, i2, i3);
        boolean z = obtainStyledAttributes.getBoolean(R.styleable.Rx, false);
        obtainStyledAttributes.recycle();
        if (z) {
            TypedValue typedValue = new TypedValue();
            if (!context.getTheme().resolveAttribute(R.attr.y9, typedValue, true) || (typedValue.type == 18 && typedValue.data == 0)) {
                c(context);
            }
        }
        a(context);
    }

    public static void c(@NonNull Context context) {
        e(context, f21576c, f21577d);
    }

    private static void d(@NonNull Context context, AttributeSet attributeSet, @StyleableRes @NonNull int[] iArr, @AttrRes int i2, @StyleRes int i3, @StyleableRes @Nullable int... iArr2) {
        boolean z;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.Px, i2, i3);
        boolean z2 = false;
        if (!obtainStyledAttributes.getBoolean(R.styleable.Sx, false)) {
            obtainStyledAttributes.recycle();
            return;
        }
        if (iArr2 == null || iArr2.length == 0) {
            if (obtainStyledAttributes.getResourceId(R.styleable.Qx, -1) != -1) {
                z2 = true;
            }
            z = z2;
        } else {
            z = g(context, attributeSet, iArr, i2, i3, iArr2);
        }
        obtainStyledAttributes.recycle();
        if (!z) {
            throw new IllegalArgumentException("This component requires that you specify a valid TextAppearance attribute. Update your app theme to inherit from Theme.MaterialComponents (or a descendant).");
        }
    }

    private static void e(@NonNull Context context, @NonNull int[] iArr, String str) {
        if (!j(context, iArr)) {
            throw new IllegalArgumentException("The style on this component requires your app theme to be " + str + " (or a descendant).");
        }
    }

    public static boolean f(@NonNull Context context) {
        return j(context, f21574a);
    }

    private static boolean g(@NonNull Context context, AttributeSet attributeSet, @StyleableRes @NonNull int[] iArr, @AttrRes int i2, @StyleRes int i3, @StyleableRes @NonNull int... iArr2) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, iArr, i2, i3);
        for (int resourceId : iArr2) {
            if (obtainStyledAttributes.getResourceId(resourceId, -1) == -1) {
                obtainStyledAttributes.recycle();
                return false;
            }
        }
        obtainStyledAttributes.recycle();
        return true;
    }

    public static boolean h(@NonNull Context context) {
        return MaterialAttributes.b(context, R.attr.x9, false);
    }

    public static boolean i(@NonNull Context context) {
        return j(context, f21576c);
    }

    private static boolean j(@NonNull Context context, @NonNull int[] iArr) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(iArr);
        for (int i2 = 0; i2 < iArr.length; i2++) {
            if (!obtainStyledAttributes.hasValue(i2)) {
                obtainStyledAttributes.recycle();
                return false;
            }
        }
        obtainStyledAttributes.recycle();
        return true;
    }

    @NonNull
    public static TypedArray k(@NonNull Context context, AttributeSet attributeSet, @StyleableRes @NonNull int[] iArr, @AttrRes int i2, @StyleRes int i3, @StyleableRes int... iArr2) {
        b(context, attributeSet, i2, i3);
        d(context, attributeSet, iArr, i2, i3, iArr2);
        return context.obtainStyledAttributes(attributeSet, iArr, i2, i3);
    }

    public static TintTypedArray l(@NonNull Context context, AttributeSet attributeSet, @StyleableRes @NonNull int[] iArr, @AttrRes int i2, @StyleRes int i3, @StyleableRes int... iArr2) {
        b(context, attributeSet, i2, i3);
        d(context, attributeSet, iArr, i2, i3, iArr2);
        return TintTypedArray.G(context, attributeSet, iArr, i2, i3);
    }
}
