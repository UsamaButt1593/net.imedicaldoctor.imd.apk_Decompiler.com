package com.google.android.material.datepicker;

import android.app.DatePickerDialog;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.AttributeSet;
import androidx.annotation.AttrRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.StyleRes;
import com.google.android.material.R;
import com.google.android.material.dialog.InsetDialogOnTouchListener;
import com.google.android.material.dialog.MaterialDialogs;
import com.google.android.material.resources.MaterialAttributes;
import com.google.android.material.shape.MaterialShapeDrawable;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP, RestrictTo.Scope.TESTS})
public class MaterialStyledDatePickerDialog extends DatePickerDialog {
    @AttrRes
    private static final int Y = 16843612;
    @StyleRes
    private static final int Z = R.style.R4;
    @NonNull
    private final Rect X;
    @NonNull
    private final Drawable s;

    public MaterialStyledDatePickerDialog(@NonNull Context context) {
        this(context, 0);
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getWindow().setBackgroundDrawable(this.s);
        getWindow().getDecorView().setOnTouchListener(new InsetDialogOnTouchListener(this, this.X));
    }

    public MaterialStyledDatePickerDialog(@NonNull Context context, int i2) {
        this(context, i2, (DatePickerDialog.OnDateSetListener) null, -1, -1, -1);
    }

    public MaterialStyledDatePickerDialog(@NonNull Context context, int i2, @Nullable DatePickerDialog.OnDateSetListener onDateSetListener, int i3, int i4, int i5) {
        super(context, i2, onDateSetListener, i3, i4, i5);
        Context context2 = getContext();
        int g2 = MaterialAttributes.g(getContext(), R.attr.e4, getClass().getCanonicalName());
        int i6 = Z;
        MaterialShapeDrawable materialShapeDrawable = new MaterialShapeDrawable(context2, (AttributeSet) null, Y, i6);
        materialShapeDrawable.p0(ColorStateList.valueOf(g2));
        Rect a2 = MaterialDialogs.a(context2, Y, i6);
        this.X = a2;
        this.s = MaterialDialogs.b(materialShapeDrawable, a2);
    }

    public MaterialStyledDatePickerDialog(@NonNull Context context, @Nullable DatePickerDialog.OnDateSetListener onDateSetListener, int i2, int i3, int i4) {
        this(context, 0, onDateSetListener, i2, i3, i4);
    }
}
