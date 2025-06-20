package com.google.firebase.iid.internal;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.tasks.Task;
import java.io.IOException;

@KeepForSdk
public interface FirebaseInstanceIdInternal {

    @KeepForSdk
    public interface NewTokenListener {
        @KeepForSdk
        void a(String str);
    }

    @KeepForSdk
    void a(@NonNull String str, @NonNull String str2) throws IOException;

    @NonNull
    @KeepForSdk
    Task<String> b();

    @KeepForSdk
    void c(NewTokenListener newTokenListener);

    @KeepForSdk
    @Nullable
    String d();

    @KeepForSdk
    String getId();
}
