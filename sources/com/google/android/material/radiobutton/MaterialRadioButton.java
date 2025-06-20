package com.google.android.material.radiobutton;

import android.content.Context;
import android.content.res.ColorStateList;
import android.util.AttributeSet;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatRadioButton;
import androidx.core.widget.CompoundButtonCompat;
import com.google.android.material.R;
import com.google.android.material.color.MaterialColors;

public class MaterialRadioButton extends AppCompatRadioButton {
    private static final int c3 = R.style.fj;
    private static final int[][] d3 = {new int[]{16842910, 16842912}, new int[]{16842910, -16842912}, new int[]{-16842910, 16842912}, new int[]{-16842910, -16842912}};
    @Nullable
    private ColorStateList a3;
    private boolean b3;

    public MaterialRadioButton(@NonNull Context context) {
        this(context, (AttributeSet) null);
    }

    private ColorStateList getMaterialThemeColorsTintList() {
        if (this.a3 == null) {
            int d2 = MaterialColors.d(this, R.attr.p3);
            int d4 = MaterialColors.d(this, R.attr.I3);
            int d5 = MaterialColors.d(this, R.attr.e4);
            int[][] iArr = d3;
            int[] iArr2 = new int[iArr.length];
            iArr2[0] = MaterialColors.t(d5, d2, 1.0f);
            iArr2[1] = MaterialColors.t(d5, d4, 0.54f);
            iArr2[2] = MaterialColors.t(d5, d4, 0.38f);
            iArr2[3] = MaterialColors.t(d5, d4, 0.38f);
            this.a3 = new ColorStateList(iArr, iArr2);
        }
        return this.a3;
    }

    public boolean a() {
        return this.b3;
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.b3 && CompoundButtonCompat.b(this) == null) {
            setUseMaterialThemeColors(true);
        }
    }

    public void setUseMaterialThemeColors(boolean z) {
        this.b3 = z;
        CompoundButtonCompat.d(this, z ? getMaterialThemeColorsTintList() : null);
    }

    public MaterialRadioButton(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.xf);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public MaterialRadioButton(@androidx.annotation.NonNull android.content.Context r8, @androidx.annotation.Nullable android.util.AttributeSet r9, int r10) {
        /*
            r7 = this;
            int r4 = c3
            android.content.Context r8 = com.google.android.material.theme.overlay.MaterialThemeOverlay.c(r8, r9, r10, r4)
            r7.<init>(r8, r9, r10)
            android.content.Context r8 = r7.getContext()
            int[] r2 = com.google.android.material.R.styleable.Ln
            r6 = 0
            int[] r5 = new int[r6]
            r0 = r8
            r1 = r9
            r3 = r10
            android.content.res.TypedArray r9 = com.google.android.material.internal.ThemeEnforcement.k(r0, r1, r2, r3, r4, r5)
            int r10 = com.google.android.material.R.styleable.Mn
            boolean r0 = r9.hasValue(r10)
            if (r0 == 0) goto L_0x0028
            android.content.res.ColorStateList r8 = com.google.android.material.resources.MaterialResources.a(r8, r9, r10)
            androidx.core.widget.CompoundButtonCompat.d(r7, r8)
        L_0x0028:
            int r8 = com.google.android.material.R.styleable.Nn
            boolean r8 = r9.getBoolean(r8, r6)
            r7.b3 = r8
            r9.recycle()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.radiobutton.MaterialRadioButton.<init>(android.content.Context, android.util.AttributeSet, int):void");
    }
}
