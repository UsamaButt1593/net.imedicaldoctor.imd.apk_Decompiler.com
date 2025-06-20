package com.google.android.material.animation;

import android.util.Property;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import com.google.android.material.R;

public class ChildrenAlphaProperty extends Property<ViewGroup, Float> {

    /* renamed from: a  reason: collision with root package name */
    public static final Property<ViewGroup, Float> f20772a = new ChildrenAlphaProperty("childrenAlpha");

    private ChildrenAlphaProperty(String str) {
        super(Float.class, str);
    }

    @NonNull
    /* renamed from: a */
    public Float get(@NonNull ViewGroup viewGroup) {
        Float f2 = (Float) viewGroup.getTag(R.id.r3);
        return f2 != null ? f2 : Float.valueOf(1.0f);
    }

    /* renamed from: b */
    public void set(@NonNull ViewGroup viewGroup, @NonNull Float f2) {
        float floatValue = f2.floatValue();
        viewGroup.setTag(R.id.r3, f2);
        int childCount = viewGroup.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            viewGroup.getChildAt(i2).setAlpha(floatValue);
        }
    }
}
