package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RatingBar;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.R;

public class AppCompatRatingBar extends RatingBar {
    private final AppCompatProgressBarHelper s;

    public AppCompatRatingBar(@NonNull Context context) {
        this(context, (AttributeSet) null);
    }

    /* access modifiers changed from: protected */
    public synchronized void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
        Bitmap b2 = this.s.b();
        if (b2 != null) {
            setMeasuredDimension(View.resolveSizeAndState(b2.getWidth() * getNumStars(), i2, 0), getMeasuredHeight());
        }
    }

    public AppCompatRatingBar(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.I2);
    }

    public AppCompatRatingBar(@NonNull Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        ThemeUtils.a(this, getContext());
        AppCompatProgressBarHelper appCompatProgressBarHelper = new AppCompatProgressBarHelper(this);
        this.s = appCompatProgressBarHelper;
        appCompatProgressBarHelper.c(attributeSet, i2);
    }
}
