package com.google.android.material.tabs;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import androidx.appcompat.widget.TintTypedArray;
import com.google.android.material.R;

public class TabItem extends View {
    public final Drawable X2;
    public final int Y2;
    public final CharSequence s;

    public TabItem(Context context) {
        this(context, (AttributeSet) null);
    }

    public TabItem(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TintTypedArray F = TintTypedArray.F(context, attributeSet, R.styleable.tv);
        this.s = F.x(R.styleable.wv);
        this.X2 = F.h(R.styleable.uv);
        this.Y2 = F.u(R.styleable.vv, 0);
        F.I();
    }
}
