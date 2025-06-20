package com.google.android.gms.dynamite;

import android.content.Context;
import com.google.android.gms.dynamite.DynamiteModule;

final class zzl implements DynamiteModule.VersionPolicy {
    zzl() {
    }

    public final DynamiteModule.VersionPolicy.SelectionResult a(Context context, String str, DynamiteModule.VersionPolicy.IVersions iVersions) throws DynamiteModule.LoadingException {
        DynamiteModule.VersionPolicy.SelectionResult selectionResult = new DynamiteModule.VersionPolicy.SelectionResult();
        int b2 = iVersions.b(context, str);
        selectionResult.f20480a = b2;
        int i2 = 1;
        int i3 = 0;
        int a2 = b2 != 0 ? iVersions.a(context, str, false) : iVersions.a(context, str, true);
        selectionResult.f20481b = a2;
        int i4 = selectionResult.f20480a;
        if (i4 != 0) {
            i3 = i4;
        } else if (a2 == 0) {
            i2 = 0;
            selectionResult.f20482c = i2;
            return selectionResult;
        }
        if (a2 < i3) {
            i2 = -1;
        }
        selectionResult.f20482c = i2;
        return selectionResult;
    }
}
