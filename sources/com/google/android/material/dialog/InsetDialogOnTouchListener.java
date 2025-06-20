package com.google.android.material.dialog;

import android.app.Dialog;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Build;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class InsetDialogOnTouchListener implements View.OnTouchListener {
    private final int X;
    private final int Y;
    private final int Z;
    @NonNull
    private final Dialog s;

    public InsetDialogOnTouchListener(@NonNull Dialog dialog, @NonNull Rect rect) {
        this.s = dialog;
        this.X = rect.left;
        this.Y = rect.top;
        this.Z = ViewConfiguration.get(dialog.getContext()).getScaledWindowTouchSlop();
    }

    public boolean onTouch(@NonNull View view, @NonNull MotionEvent motionEvent) {
        View findViewById = view.findViewById(16908290);
        int left = this.X + findViewById.getLeft();
        int width = findViewById.getWidth() + left;
        int top = this.Y + findViewById.getTop();
        if (new RectF((float) left, (float) top, (float) width, (float) (findViewById.getHeight() + top)).contains(motionEvent.getX(), motionEvent.getY())) {
            return false;
        }
        MotionEvent obtain = MotionEvent.obtain(motionEvent);
        if (motionEvent.getAction() == 1) {
            obtain.setAction(4);
        }
        if (Build.VERSION.SDK_INT < 28) {
            obtain.setAction(0);
            int i2 = this.Z;
            obtain.setLocation((float) ((-i2) - 1), (float) ((-i2) - 1));
        }
        view.performClick();
        return this.s.onTouchEvent(obtain);
    }
}
