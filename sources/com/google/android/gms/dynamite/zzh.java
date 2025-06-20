package com.google.android.gms.dynamite;

import android.content.Context;
import com.google.android.gms.dynamite.DynamiteModule;

final class zzh implements DynamiteModule.VersionPolicy {
    zzh() {
    }

    public final DynamiteModule.VersionPolicy.SelectionResult a(Context context, String str, DynamiteModule.VersionPolicy.IVersions iVersions) throws DynamiteModule.LoadingException {
        DynamiteModule.VersionPolicy.SelectionResult selectionResult = new DynamiteModule.VersionPolicy.SelectionResult();
        int i2 = 0;
        int a2 = iVersions.a(context, str, false);
        selectionResult.f20481b = a2;
        if (a2 != 0) {
            i2 = 1;
        }
        selectionResult.f20482c = i2;
        return selectionResult;
    }
}
