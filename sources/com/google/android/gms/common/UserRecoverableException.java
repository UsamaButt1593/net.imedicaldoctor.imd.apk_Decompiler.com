package com.google.android.gms.common;

import android.content.Intent;
import androidx.annotation.NonNull;

public class UserRecoverableException extends Exception {
    private final Intent s;

    public UserRecoverableException(@NonNull String str, @NonNull Intent intent) {
        super(str);
        this.s = intent;
    }

    @NonNull
    public Intent a() {
        return new Intent(this.s);
    }
}
