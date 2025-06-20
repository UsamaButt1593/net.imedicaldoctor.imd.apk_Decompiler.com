package com.google.android.material.shape;

import android.view.View;
import androidx.annotation.NonNull;

class ShapeableDelegateV14 extends ShapeableDelegate {
    ShapeableDelegateV14() {
    }

    /* access modifiers changed from: package-private */
    public void b(@NonNull View view) {
        if (this.f21911c != null && !this.f21912d.isEmpty() && j()) {
            view.invalidate();
        }
    }

    /* access modifiers changed from: package-private */
    public boolean j() {
        return true;
    }
}
