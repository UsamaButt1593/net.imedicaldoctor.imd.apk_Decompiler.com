package com.google.android.gms.common.internal;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import com.google.android.gms.common.api.internal.LifecycleFragment;

public abstract class zag implements DialogInterface.OnClickListener {
    public static zag b(Activity activity, @Nullable Intent intent, int i2) {
        return new zad(intent, activity, i2);
    }

    public static zag c(@NonNull Fragment fragment, @Nullable Intent intent, int i2) {
        return new zae(intent, fragment, i2);
    }

    public static zag d(@NonNull LifecycleFragment lifecycleFragment, @Nullable Intent intent, int i2) {
        return new zaf(intent, lifecycleFragment, 2);
    }

    /* access modifiers changed from: protected */
    public abstract void a();

    public final void onClick(DialogInterface dialogInterface, int i2) {
        try {
            a();
        } catch (ActivityNotFoundException e2) {
            String str = "Failed to start resolution intent.";
            if (true == Build.FINGERPRINT.contains("generic")) {
                str = "Failed to start resolution intent. This may occur when resolving Google Play services connection issues on emulators with Google APIs but not Google Play Store.";
            }
            Log.e("DialogRedirect", str, e2);
        } finally {
            dialogInterface.dismiss();
        }
    }
}
