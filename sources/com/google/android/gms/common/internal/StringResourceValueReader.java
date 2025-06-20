package com.google.android.gms.common.internal;

import android.content.Context;
import android.content.res.Resources;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.google.android.gms.common.R;
import com.google.android.gms.common.annotation.KeepForSdk;

@KeepForSdk
public class StringResourceValueReader {

    /* renamed from: a  reason: collision with root package name */
    private final Resources f20266a;

    /* renamed from: b  reason: collision with root package name */
    private final String f20267b;

    public StringResourceValueReader(@NonNull Context context) {
        Preconditions.r(context);
        Resources resources = context.getResources();
        this.f20266a = resources;
        this.f20267b = resources.getResourcePackageName(R.string.f19905a);
    }

    @KeepForSdk
    @Nullable
    public String a(@NonNull String str) {
        int identifier = this.f20266a.getIdentifier(str, TypedValues.Custom.f3952e, this.f20267b);
        if (identifier == 0) {
            return null;
        }
        return this.f20266a.getString(identifier);
    }
}
