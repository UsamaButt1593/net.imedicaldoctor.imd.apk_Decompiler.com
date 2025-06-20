package com.google.android.gms.common;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.app.FragmentManager;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.Preconditions;

public class ErrorDialogFragment extends DialogFragment {
    private DialogInterface.OnCancelListener X;
    @Nullable
    private Dialog Y;
    private Dialog s;

    @NonNull
    public static ErrorDialogFragment a(@NonNull Dialog dialog) {
        return b(dialog, (DialogInterface.OnCancelListener) null);
    }

    @NonNull
    public static ErrorDialogFragment b(@NonNull Dialog dialog, @Nullable DialogInterface.OnCancelListener onCancelListener) {
        ErrorDialogFragment errorDialogFragment = new ErrorDialogFragment();
        Dialog dialog2 = (Dialog) Preconditions.s(dialog, "Cannot display null dialog");
        dialog2.setOnCancelListener((DialogInterface.OnCancelListener) null);
        dialog2.setOnDismissListener((DialogInterface.OnDismissListener) null);
        errorDialogFragment.s = dialog2;
        if (onCancelListener != null) {
            errorDialogFragment.X = onCancelListener;
        }
        return errorDialogFragment;
    }

    public void onCancel(@NonNull DialogInterface dialogInterface) {
        DialogInterface.OnCancelListener onCancelListener = this.X;
        if (onCancelListener != null) {
            onCancelListener.onCancel(dialogInterface);
        }
    }

    @NonNull
    public Dialog onCreateDialog(@Nullable Bundle bundle) {
        Dialog dialog = this.s;
        if (dialog != null) {
            return dialog;
        }
        setShowsDialog(false);
        if (this.Y == null) {
            this.Y = new AlertDialog.Builder((Context) Preconditions.r(getActivity())).create();
        }
        return this.Y;
    }

    public void show(@NonNull FragmentManager fragmentManager, @Nullable String str) {
        super.show(fragmentManager, str);
    }
}
