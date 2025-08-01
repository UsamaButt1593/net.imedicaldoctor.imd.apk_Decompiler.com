package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.Layout;
import android.util.AttributeSet;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.appcompat.R;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class DialogTitle extends AppCompatTextView {
    public DialogTitle(@NonNull Context context) {
        super(context);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        int lineCount;
        super.onMeasure(i2, i3);
        Layout layout2 = getLayout();
        if (layout2 != null && (lineCount = layout2.getLineCount()) > 0 && layout2.getEllipsisCount(lineCount - 1) > 0) {
            setSingleLine(false);
            setMaxLines(2);
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes((AttributeSet) null, R.styleable.a6, 16842817, 16973892);
            int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(R.styleable.b6, 0);
            if (dimensionPixelSize != 0) {
                setTextSize(0, (float) dimensionPixelSize);
            }
            obtainStyledAttributes.recycle();
            super.onMeasure(i2, i3);
        }
    }

    public DialogTitle(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public DialogTitle(@NonNull Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }
}
