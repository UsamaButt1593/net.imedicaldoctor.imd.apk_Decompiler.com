package com.google.android.gms.common.util;

import androidx.annotation.NonNull;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.Preconditions;
import java.util.Set;

@KeepForSdk
public final class ScopeUtil {
    private ScopeUtil() {
    }

    @NonNull
    @KeepForSdk
    public static String[] a(@NonNull Set<Scope> set) {
        Preconditions.s(set, "scopes can't be null.");
        Scope[] scopeArr = (Scope[]) set.toArray(new Scope[set.size()]);
        Preconditions.s(scopeArr, "scopes can't be null.");
        String[] strArr = new String[scopeArr.length];
        for (int i2 = 0; i2 < scopeArr.length; i2++) {
            strArr[i2] = scopeArr[i2].C();
        }
        return strArr;
    }
}
