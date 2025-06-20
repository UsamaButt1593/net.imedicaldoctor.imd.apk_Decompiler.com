package com.google.android.material.textview;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StyleableRes;
import androidx.appcompat.widget.AppCompatTextView;
import com.google.android.material.R;
import com.google.android.material.resources.MaterialAttributes;
import com.google.android.material.resources.MaterialResources;
import com.google.android.material.theme.overlay.MaterialThemeOverlay;

public class MaterialTextView extends AppCompatTextView {
    public MaterialTextView(@NonNull Context context) {
        this(context, (AttributeSet) null);
    }

    private static boolean A(@NonNull Context context, @NonNull Resources.Theme theme, @Nullable AttributeSet attributeSet, int i2, int i3) {
        TypedArray obtainStyledAttributes = theme.obtainStyledAttributes(attributeSet, R.styleable.eo, i2, i3);
        int z = z(context, obtainStyledAttributes, R.styleable.go, R.styleable.ho);
        obtainStyledAttributes.recycle();
        return z != -1;
    }

    private void v(@NonNull Resources.Theme theme, int i2) {
        TypedArray obtainStyledAttributes = theme.obtainStyledAttributes(i2, R.styleable.Zn);
        int z = z(getContext(), obtainStyledAttributes, R.styleable.bo, R.styleable.co);
        obtainStyledAttributes.recycle();
        if (z >= 0) {
            setLineHeight(z);
        }
    }

    private static boolean w(Context context) {
        return MaterialAttributes.b(context, R.attr.Li, true);
    }

    private static int x(@NonNull Resources.Theme theme, @Nullable AttributeSet attributeSet, int i2, int i3) {
        TypedArray obtainStyledAttributes = theme.obtainStyledAttributes(attributeSet, R.styleable.eo, i2, i3);
        int resourceId = obtainStyledAttributes.getResourceId(R.styleable.fo, -1);
        obtainStyledAttributes.recycle();
        return resourceId;
    }

    private void y(@Nullable AttributeSet attributeSet, int i2, int i3) {
        int x;
        Context context = getContext();
        if (w(context)) {
            Resources.Theme theme = context.getTheme();
            if (!A(context, theme, attributeSet, i2, i3) && (x = x(theme, attributeSet, i2, i3)) != -1) {
                v(theme, x);
            }
        }
    }

    private static int z(@NonNull Context context, @NonNull TypedArray typedArray, @StyleableRes @NonNull int... iArr) {
        int i2 = -1;
        for (int i3 = 0; i3 < iArr.length && i2 < 0; i3++) {
            i2 = MaterialResources.d(context, typedArray, iArr[i3], -1);
        }
        return i2;
    }

    public void setTextAppearance(@NonNull Context context, int i2) {
        super.setTextAppearance(context, i2);
        if (w(context)) {
            v(context.getTheme(), i2);
        }
    }

    public MaterialTextView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 16842884);
    }

    public MaterialTextView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(MaterialThemeOverlay.c(context, attributeSet, i2, 0), attributeSet, i2);
        y(attributeSet, i2, 0);
    }

    @Deprecated
    public MaterialTextView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i2, int i3) {
        super(MaterialThemeOverlay.c(context, attributeSet, i2, i3), attributeSet, i2);
        y(attributeSet, i2, i3);
    }
}
