package com.google.android.material.shape;

import android.graphics.Outline;
import android.view.View;
import android.view.ViewOutlineProvider;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;

@RequiresApi(33)
class ShapeableDelegateV33 extends ShapeableDelegate {
    ShapeableDelegateV33(@NonNull View view) {
        l(view);
    }

    @DoNotInline
    private void l(View view) {
        view.setOutlineProvider(new ViewOutlineProvider() {
            public void getOutline(View view, Outline outline) {
                if (!ShapeableDelegateV33.this.f21913e.isEmpty()) {
                    outline.setPath(ShapeableDelegateV33.this.f21913e);
                }
            }
        });
    }

    /* access modifiers changed from: package-private */
    public void b(@NonNull View view) {
        view.setClipToOutline(!j());
        if (j()) {
            view.invalidate();
        } else {
            view.invalidateOutline();
        }
    }

    /* access modifiers changed from: package-private */
    public boolean j() {
        return this.f21909a;
    }
}
