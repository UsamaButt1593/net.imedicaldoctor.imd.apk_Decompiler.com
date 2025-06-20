package com.google.android.material.switchmaterial;

import android.content.Context;
import android.content.res.ColorStateList;
import android.util.AttributeSet;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.SwitchCompat;
import com.google.android.material.R;
import com.google.android.material.color.MaterialColors;
import com.google.android.material.elevation.ElevationOverlayProvider;
import com.google.android.material.internal.ViewUtils;

public class SwitchMaterial extends SwitchCompat {
    private static final int c4 = R.style.gj;
    private static final int[][] d4 = {new int[]{16842910, 16842912}, new int[]{16842910, -16842912}, new int[]{-16842910, 16842912}, new int[]{-16842910, -16842912}};
    @NonNull
    private final ElevationOverlayProvider Y3;
    @Nullable
    private ColorStateList Z3;
    @Nullable
    private ColorStateList a4;
    private boolean b4;

    public SwitchMaterial(@NonNull Context context) {
        this(context, (AttributeSet) null);
    }

    private ColorStateList getMaterialThemeColorsThumbTintList() {
        if (this.Z3 == null) {
            int d2 = MaterialColors.d(this, R.attr.e4);
            int d3 = MaterialColors.d(this, R.attr.p3);
            float dimension = getResources().getDimension(R.dimen.Fd);
            if (this.Y3.l()) {
                dimension += ViewUtils.p(this);
            }
            int e2 = this.Y3.e(d2, dimension);
            int[][] iArr = d4;
            int[] iArr2 = new int[iArr.length];
            iArr2[0] = MaterialColors.t(d2, d3, 1.0f);
            iArr2[1] = e2;
            iArr2[2] = MaterialColors.t(d2, d3, 0.38f);
            iArr2[3] = e2;
            this.Z3 = new ColorStateList(iArr, iArr2);
        }
        return this.Z3;
    }

    private ColorStateList getMaterialThemeColorsTrackTintList() {
        if (this.a4 == null) {
            int[][] iArr = d4;
            int[] iArr2 = new int[iArr.length];
            int d2 = MaterialColors.d(this, R.attr.e4);
            int d3 = MaterialColors.d(this, R.attr.p3);
            int d5 = MaterialColors.d(this, R.attr.I3);
            iArr2[0] = MaterialColors.t(d2, d3, 0.54f);
            iArr2[1] = MaterialColors.t(d2, d5, 0.32f);
            iArr2[2] = MaterialColors.t(d2, d3, 0.12f);
            iArr2[3] = MaterialColors.t(d2, d5, 0.12f);
            this.a4 = new ColorStateList(iArr, iArr2);
        }
        return this.a4;
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.b4 && getThumbTintList() == null) {
            setThumbTintList(getMaterialThemeColorsThumbTintList());
        }
        if (this.b4 && getTrackTintList() == null) {
            setTrackTintList(getMaterialThemeColorsTrackTintList());
        }
    }

    public boolean s() {
        return this.b4;
    }

    public void setUseMaterialThemeColors(boolean z) {
        ColorStateList colorStateList;
        this.b4 = z;
        if (z) {
            setThumbTintList(getMaterialThemeColorsThumbTintList());
            colorStateList = getMaterialThemeColorsTrackTintList();
        } else {
            colorStateList = null;
            setThumbTintList((ColorStateList) null);
        }
        setTrackTintList(colorStateList);
    }

    public SwitchMaterial(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.Eh);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public SwitchMaterial(@androidx.annotation.NonNull android.content.Context r7, @androidx.annotation.Nullable android.util.AttributeSet r8, int r9) {
        /*
            r6 = this;
            int r4 = c4
            android.content.Context r7 = com.google.android.material.theme.overlay.MaterialThemeOverlay.c(r7, r8, r9, r4)
            r6.<init>(r7, r8, r9)
            android.content.Context r0 = r6.getContext()
            com.google.android.material.elevation.ElevationOverlayProvider r7 = new com.google.android.material.elevation.ElevationOverlayProvider
            r7.<init>(r0)
            r6.Y3 = r7
            int[] r2 = com.google.android.material.R.styleable.rv
            r7 = 0
            int[] r5 = new int[r7]
            r1 = r8
            r3 = r9
            android.content.res.TypedArray r8 = com.google.android.material.internal.ThemeEnforcement.k(r0, r1, r2, r3, r4, r5)
            int r9 = com.google.android.material.R.styleable.sv
            boolean r7 = r8.getBoolean(r9, r7)
            r6.b4 = r7
            r8.recycle()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.switchmaterial.SwitchMaterial.<init>(android.content.Context, android.util.AttributeSet, int):void");
    }
}
