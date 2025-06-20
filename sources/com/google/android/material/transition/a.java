package com.google.android.material.transition;

import android.graphics.RectF;
import com.google.android.material.shape.CornerSize;
import com.google.android.material.shape.RelativeCornerSize;
import com.google.android.material.shape.ShapeAppearanceModel;

public final /* synthetic */ class a implements ShapeAppearanceModel.CornerSizeUnaryOperator {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ RectF f22155a;

    public /* synthetic */ a(RectF rectF) {
        this.f22155a = rectF;
    }

    public final CornerSize a(CornerSize cornerSize) {
        return RelativeCornerSize.b(this.f22155a, cornerSize);
    }
}
