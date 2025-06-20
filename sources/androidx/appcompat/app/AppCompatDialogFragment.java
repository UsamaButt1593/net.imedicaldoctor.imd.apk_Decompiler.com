package androidx.appcompat.app;

import android.app.Dialog;
import android.os.Bundle;
import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.fragment.app.DialogFragment;

public class AppCompatDialogFragment extends DialogFragment {
    public AppCompatDialogFragment() {
    }

    @NonNull
    public Dialog U2(@Nullable Bundle bundle) {
        return new AppCompatDialog(B(), S2());
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void c3(@NonNull Dialog dialog, int i2) {
        if (dialog instanceof AppCompatDialog) {
            AppCompatDialog appCompatDialog = (AppCompatDialog) dialog;
            if (!(i2 == 1 || i2 == 2)) {
                if (i2 == 3) {
                    dialog.getWindow().addFlags(24);
                } else {
                    return;
                }
            }
            appCompatDialog.o(1);
            return;
        }
        super.c3(dialog, i2);
    }

    public AppCompatDialogFragment(@LayoutRes int i2) {
        super(i2);
    }
}
