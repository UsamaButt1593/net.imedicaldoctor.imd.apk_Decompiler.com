package com.google.android.gms.common.internal;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.Button;
import androidx.annotation.Nullable;

public final class zaaa extends Button {
    public zaaa(Context context, @Nullable AttributeSet attributeSet) {
        super(context, (AttributeSet) null, 16842824);
    }

    private static final int b(int i2, int i3, int i4, int i5) {
        if (i2 == 0) {
            return i3;
        }
        if (i2 == 1) {
            return i4;
        }
        if (i2 == 2) {
            return i5;
        }
        StringBuilder sb = new StringBuilder(33);
        sb.append("Unknown color scheme: ");
        sb.append(i2);
        throw new IllegalStateException(sb.toString());
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x00b9  */
    /* JADX WARNING: Removed duplicated region for block: B:21:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(android.content.res.Resources r7, int r8, int r9) {
        /*
            r6 = this;
            android.graphics.Typeface r0 = android.graphics.Typeface.DEFAULT_BOLD
            r6.setTypeface(r0)
            r0 = 1096810496(0x41600000, float:14.0)
            r6.setTextSize(r0)
            android.util.DisplayMetrics r0 = r7.getDisplayMetrics()
            float r0 = r0.density
            r1 = 1111490560(0x42400000, float:48.0)
            float r0 = r0 * r1
            r1 = 1056964608(0x3f000000, float:0.5)
            float r0 = r0 + r1
            int r0 = (int) r0
            r6.setMinHeight(r0)
            r6.setMinWidth(r0)
            int r0 = com.google.android.gms.base.R.drawable.f19756b
            int r1 = com.google.android.gms.base.R.drawable.f19761g
            int r0 = b(r9, r0, r1, r1)
            int r1 = com.google.android.gms.base.R.drawable.f19765k
            int r2 = com.google.android.gms.base.R.drawable.p
            int r1 = b(r9, r1, r2, r2)
            java.lang.String r2 = "Unknown button size: "
            r3 = 32
            r4 = 2
            r5 = 1
            if (r8 == 0) goto L_0x0050
            if (r8 == r5) goto L_0x0050
            if (r8 != r4) goto L_0x003b
            goto L_0x0051
        L_0x003b:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>(r3)
            r9.append(r2)
            r9.append(r8)
            java.lang.String r8 = r9.toString()
            r7.<init>(r8)
            throw r7
        L_0x0050:
            r0 = r1
        L_0x0051:
            android.graphics.drawable.Drawable r0 = r7.getDrawable(r0)
            android.graphics.drawable.Drawable r0 = androidx.core.graphics.drawable.DrawableCompat.r(r0)
            int r1 = com.google.android.gms.base.R.color.f19754k
            android.content.res.ColorStateList r1 = r7.getColorStateList(r1)
            androidx.core.graphics.drawable.DrawableCompat.o(r0, r1)
            android.graphics.PorterDuff$Mode r1 = android.graphics.PorterDuff.Mode.SRC_ATOP
            androidx.core.graphics.drawable.DrawableCompat.p(r0, r1)
            r6.setBackgroundDrawable(r0)
            int r0 = com.google.android.gms.base.R.color.f19744a
            int r1 = com.google.android.gms.base.R.color.f19749f
            int r9 = b(r9, r0, r1, r1)
            android.content.res.ColorStateList r9 = r7.getColorStateList(r9)
            java.lang.Object r9 = com.google.android.gms.common.internal.Preconditions.r(r9)
            android.content.res.ColorStateList r9 = (android.content.res.ColorStateList) r9
            r6.setTextColor(r9)
            r9 = 0
            if (r8 == 0) goto L_0x00a9
            if (r8 == r5) goto L_0x009f
            if (r8 != r4) goto L_0x008a
            r6.setText(r9)
            goto L_0x00ac
        L_0x008a:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>(r3)
            r9.append(r2)
            r9.append(r8)
            java.lang.String r8 = r9.toString()
            r7.<init>(r8)
            throw r7
        L_0x009f:
            int r8 = com.google.android.gms.base.R.string.q
        L_0x00a1:
            java.lang.String r7 = r7.getString(r8)
            r6.setText(r7)
            goto L_0x00ac
        L_0x00a9:
            int r8 = com.google.android.gms.base.R.string.p
            goto L_0x00a1
        L_0x00ac:
            r6.setTransformationMethod(r9)
            android.content.Context r7 = r6.getContext()
            boolean r7 = com.google.android.gms.common.util.DeviceProperties.l(r7)
            if (r7 == 0) goto L_0x00be
            r7 = 19
            r6.setGravity(r7)
        L_0x00be:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.internal.zaaa.a(android.content.res.Resources, int, int):void");
    }
}
