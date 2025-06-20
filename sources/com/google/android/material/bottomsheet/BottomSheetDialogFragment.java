package com.google.android.material.bottomsheet;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatDialogFragment;
import com.google.android.material.bottomsheet.BottomSheetBehavior;

public class BottomSheetDialogFragment extends AppCompatDialogFragment {
    private boolean F4;

    private class BottomSheetDismissCallback extends BottomSheetBehavior.BottomSheetCallback {
        private BottomSheetDismissCallback() {
        }

        public void b(@NonNull View view, float f2) {
        }

        public void c(@NonNull View view, int i2) {
            if (i2 == 5) {
                BottomSheetDialogFragment.this.h3();
            }
        }
    }

    public BottomSheetDialogFragment() {
    }

    /* access modifiers changed from: private */
    public void h3() {
        if (this.F4) {
            super.N2();
        } else {
            super.M2();
        }
    }

    private void i3(@NonNull BottomSheetBehavior<?> bottomSheetBehavior, boolean z) {
        this.F4 = z;
        if (bottomSheetBehavior.getState() == 5) {
            h3();
            return;
        }
        if (Q2() instanceof BottomSheetDialog) {
            ((BottomSheetDialog) Q2()).x();
        }
        bottomSheetBehavior.h0(new BottomSheetDismissCallback());
        bottomSheetBehavior.b(5);
    }

    private boolean j3(boolean z) {
        Dialog Q2 = Q2();
        if (!(Q2 instanceof BottomSheetDialog)) {
            return false;
        }
        BottomSheetDialog bottomSheetDialog = (BottomSheetDialog) Q2;
        BottomSheetBehavior<FrameLayout> u = bottomSheetDialog.u();
        if (!u.T0() || !bottomSheetDialog.v()) {
            return false;
        }
        i3(u, z);
        return true;
    }

    public void M2() {
        if (!j3(false)) {
            super.M2();
        }
    }

    public void N2() {
        if (!j3(true)) {
            super.N2();
        }
    }

    @NonNull
    public Dialog U2(@Nullable Bundle bundle) {
        return new BottomSheetDialog(B(), S2());
    }

    @SuppressLint({"ValidFragment"})
    public BottomSheetDialogFragment(@LayoutRes int i2) {
        super(i2);
    }
}
