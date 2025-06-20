package com.google.android.material.resources;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.util.TypedValue;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.StyleRes;
import androidx.annotation.StyleableRes;
import com.google.android.material.R;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class MaterialResources {

    /* renamed from: a  reason: collision with root package name */
    private static final float f21704a = 1.3f;

    /* renamed from: b  reason: collision with root package name */
    private static final float f21705b = 2.0f;

    private MaterialResources() {
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x000d, code lost:
        r1 = androidx.appcompat.content.res.AppCompatResources.a(r1, (r0 = r2.getResourceId(r3, 0)));
     */
    @androidx.annotation.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static android.content.res.ColorStateList a(@androidx.annotation.NonNull android.content.Context r1, @androidx.annotation.NonNull android.content.res.TypedArray r2, @androidx.annotation.StyleableRes int r3) {
        /*
            boolean r0 = r2.hasValue(r3)
            if (r0 == 0) goto L_0x0014
            r0 = 0
            int r0 = r2.getResourceId(r3, r0)
            if (r0 == 0) goto L_0x0014
            android.content.res.ColorStateList r1 = androidx.appcompat.content.res.AppCompatResources.a(r1, r0)
            if (r1 == 0) goto L_0x0014
            return r1
        L_0x0014:
            android.content.res.ColorStateList r1 = r2.getColorStateList(r3)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.resources.MaterialResources.a(android.content.Context, android.content.res.TypedArray, int):android.content.res.ColorStateList");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x000d, code lost:
        r1 = androidx.appcompat.content.res.AppCompatResources.a(r1, (r0 = r2.u(r3, 0)));
     */
    @androidx.annotation.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static android.content.res.ColorStateList b(@androidx.annotation.NonNull android.content.Context r1, @androidx.annotation.NonNull androidx.appcompat.widget.TintTypedArray r2, @androidx.annotation.StyleableRes int r3) {
        /*
            boolean r0 = r2.C(r3)
            if (r0 == 0) goto L_0x0014
            r0 = 0
            int r0 = r2.u(r3, r0)
            if (r0 == 0) goto L_0x0014
            android.content.res.ColorStateList r1 = androidx.appcompat.content.res.AppCompatResources.a(r1, r0)
            if (r1 == 0) goto L_0x0014
            return r1
        L_0x0014:
            android.content.res.ColorStateList r1 = r2.d(r3)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.resources.MaterialResources.b(android.content.Context, androidx.appcompat.widget.TintTypedArray, int):android.content.res.ColorStateList");
    }

    private static int c(TypedValue typedValue) {
        return Build.VERSION.SDK_INT >= 22 ? typedValue.getComplexUnit() : typedValue.data & 15;
    }

    public static int d(@NonNull Context context, @NonNull TypedArray typedArray, @StyleableRes int i2, int i3) {
        TypedValue typedValue = new TypedValue();
        if (!typedArray.getValue(i2, typedValue) || typedValue.type != 2) {
            return typedArray.getDimensionPixelSize(i2, i3);
        }
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(new int[]{typedValue.data});
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(0, i3);
        obtainStyledAttributes.recycle();
        return dimensionPixelSize;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x000d, code lost:
        r1 = androidx.appcompat.content.res.AppCompatResources.b(r1, (r0 = r2.getResourceId(r3, 0)));
     */
    @androidx.annotation.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static android.graphics.drawable.Drawable e(@androidx.annotation.NonNull android.content.Context r1, @androidx.annotation.NonNull android.content.res.TypedArray r2, @androidx.annotation.StyleableRes int r3) {
        /*
            boolean r0 = r2.hasValue(r3)
            if (r0 == 0) goto L_0x0014
            r0 = 0
            int r0 = r2.getResourceId(r3, r0)
            if (r0 == 0) goto L_0x0014
            android.graphics.drawable.Drawable r1 = androidx.appcompat.content.res.AppCompatResources.b(r1, r0)
            if (r1 == 0) goto L_0x0014
            return r1
        L_0x0014:
            android.graphics.drawable.Drawable r1 = r2.getDrawable(r3)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.resources.MaterialResources.e(android.content.Context, android.content.res.TypedArray, int):android.graphics.drawable.Drawable");
    }

    public static float f(@NonNull Context context) {
        return context.getResources().getConfiguration().fontScale;
    }

    @StyleableRes
    static int g(@NonNull TypedArray typedArray, @StyleableRes int i2, @StyleableRes int i3) {
        return typedArray.hasValue(i2) ? i2 : i3;
    }

    @Nullable
    public static TextAppearance h(@NonNull Context context, @NonNull TypedArray typedArray, @StyleableRes int i2) {
        int resourceId;
        if (!typedArray.hasValue(i2) || (resourceId = typedArray.getResourceId(i2, 0)) == 0) {
            return null;
        }
        return new TextAppearance(context, resourceId);
    }

    public static int i(@NonNull Context context, @StyleRes int i2, int i3) {
        if (i2 == 0) {
            return i3;
        }
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(i2, R.styleable.Zv);
        TypedValue typedValue = new TypedValue();
        boolean value = obtainStyledAttributes.getValue(R.styleable.aw, typedValue);
        obtainStyledAttributes.recycle();
        if (!value) {
            return i3;
        }
        return c(typedValue) == 2 ? Math.round(TypedValue.complexToFloat(typedValue.data) * context.getResources().getDisplayMetrics().density) : TypedValue.complexToDimensionPixelSize(typedValue.data, context.getResources().getDisplayMetrics());
    }

    public static boolean j(@NonNull Context context) {
        return context.getResources().getConfiguration().fontScale >= f21704a;
    }

    public static boolean k(@NonNull Context context) {
        return context.getResources().getConfiguration().fontScale >= 2.0f;
    }
}
