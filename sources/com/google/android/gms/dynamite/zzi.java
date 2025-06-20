package com.google.android.gms.dynamite;

import android.content.Context;
import com.google.android.gms.dynamite.DynamiteModule;

final class zzi implements DynamiteModule.VersionPolicy {
    zzi() {
    }

    public final DynamiteModule.VersionPolicy.SelectionResult a(Context context, String str, DynamiteModule.VersionPolicy.IVersions iVersions) throws DynamiteModule.LoadingException {
        DynamiteModule.VersionPolicy.SelectionResult selectionResult = new DynamiteModule.VersionPolicy.SelectionResult();
        selectionResult.f20480a = iVersions.b(context, str);
        int i2 = 1;
        int a2 = iVersions.a(context, str, true);
        selectionResult.f20481b = a2;
        int i3 = selectionResult.f20480a;
        if (i3 == 0) {
            i3 = 0;
            if (a2 == 0) {
                i2 = 0;
                selectionResult.f20482c = i2;
                return selectionResult;
            }
        }
        if (i3 >= a2) {
            i2 = -1;
        }
        selectionResult.f20482c = i2;
        return selectionResult;
    }
}
