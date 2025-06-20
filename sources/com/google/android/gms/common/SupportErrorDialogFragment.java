package com.google.android.gms.common;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentManager;
import com.google.android.gms.common.internal.Preconditions;

public class SupportErrorDialogFragment extends DialogFragment {
    private Dialog F4;
    private DialogInterface.OnCancelListener G4;
    @Nullable
    private Dialog H4;

    @NonNull
    public static SupportErrorDialogFragment g3(@NonNull Dialog dialog) {
        return h3(dialog, (DialogInterface.OnCancelListener) null);
    }

    @NonNull
    public static SupportErrorDialogFragment h3(@NonNull Dialog dialog, @Nullable DialogInterface.OnCancelListener onCancelListener) {
        SupportErrorDialogFragment supportErrorDialogFragment = new SupportErrorDialogFragment();
        Dialog dialog2 = (Dialog) Preconditions.s(dialog, "Cannot display null dialog");
        dialog2.setOnCancelListener((DialogInterface.OnCancelListener) null);
        dialog2.setOnDismissListener((DialogInterface.OnDismissListener) null);
        supportErrorDialogFragment.F4 = dialog2;
        if (onCancelListener != null) {
            supportErrorDialogFragment.G4 = onCancelListener;
        }
        return supportErrorDialogFragment;
    }

    @NonNull
    public Dialog U2(@Nullable Bundle bundle) {
        Dialog dialog = this.F4;
        if (dialog != null) {
            return dialog;
        }
        a3(false);
        if (this.H4 == null) {
            this.H4 = new AlertDialog.Builder((Context) Preconditions.r(B())).create();
        }
        return this.H4;
    }

    public void e3(@NonNull FragmentManager fragmentManager, @Nullable String str) {
        super.e3(fragmentManager, str);
    }

    public void onCancel(@NonNull DialogInterface dialogInterface) {
        DialogInterface.OnCancelListener onCancelListener = this.G4;
        if (onCancelListener != null) {
            onCancelListener.onCancel(dialogInterface);
        }
    }
}
