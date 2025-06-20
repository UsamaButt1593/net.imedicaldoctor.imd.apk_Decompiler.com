package com.google.android.gms.dynamite;

import android.content.Context;
import com.google.android.gms.dynamite.DynamiteModule;

final class zzf implements DynamiteModule.VersionPolicy {
    zzf() {
    }

    public final DynamiteModule.VersionPolicy.SelectionResult a(Context context, String str, DynamiteModule.VersionPolicy.IVersions iVersions) throws DynamiteModule.LoadingException {
        DynamiteModule.VersionPolicy.SelectionResult selectionResult = new DynamiteModule.VersionPolicy.SelectionResult();
        int a2 = iVersions.a(context, str, true);
        selectionResult.f20481b = a2;
        if (a2 != 0) {
            selectionResult.f20482c = 1;
        } else {
            int b2 = iVersions.b(context, str);
            selectionResult.f20480a = b2;
            if (b2 != 0) {
                selectionResult.f20482c = -1;
            }
        }
        return selectionResult;
    }
}
