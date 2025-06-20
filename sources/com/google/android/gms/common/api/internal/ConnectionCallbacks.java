package com.google.android.gms.common.api.internal;

import android.os.Bundle;
import androidx.annotation.Nullable;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.ShowFirstParty;

@KeepForSdk
public interface ConnectionCallbacks {
    @ShowFirstParty
    @KeepForSdk
    void e(int i2);

    @ShowFirstParty
    @KeepForSdk
    void z(@Nullable Bundle bundle);
}
