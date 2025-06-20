package com.google.android.gms.signin;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.internal.Objects;

public final class SignInOptions implements Api.ApiOptions.Optional {
    @NonNull
    public static final SignInOptions c3 = new SignInOptions(false, false, (String) null, false, (String) null, (String) null, false, (Long) null, (Long) null, (zaf) null);
    private final boolean X = false;
    @Nullable
    private final String X2 = null;
    @Nullable
    private final String Y = null;
    @Nullable
    private final String Y2 = null;
    private final boolean Z = false;
    private final boolean Z2 = false;
    @Nullable
    private final Long a3 = null;
    @Nullable
    private final Long b3 = null;
    private final boolean s = false;

    /* synthetic */ SignInOptions(boolean z, boolean z2, String str, boolean z3, String str2, String str3, boolean z4, Long l2, Long l3, zaf zaf) {
    }

    public final boolean equals(@Nullable Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SignInOptions)) {
            return false;
        }
        boolean z = ((SignInOptions) obj).s;
        return Objects.b((Object) null, (Object) null) && Objects.b((Object) null, (Object) null) && Objects.b((Object) null, (Object) null) && Objects.b((Object) null, (Object) null) && Objects.b((Object) null, (Object) null);
    }

    public final int hashCode() {
        Boolean bool = Boolean.FALSE;
        return Objects.c(bool, bool, null, bool, bool, null, null, null, null);
    }
}
