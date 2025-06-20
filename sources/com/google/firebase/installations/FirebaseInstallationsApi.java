package com.google.firebase.installations;

import androidx.annotation.NonNull;
import com.google.android.gms.tasks.Task;
import com.google.firebase.annotations.DeferredApi;
import com.google.firebase.installations.internal.FidListener;
import com.google.firebase.installations.internal.FidListenerHandle;

public interface FirebaseInstallationsApi {
    @NonNull
    Task<Void> a();

    @DeferredApi
    FidListenerHandle b(@NonNull FidListener fidListener);

    @NonNull
    Task<InstallationTokenResult> c(boolean z);

    @NonNull
    Task<String> getId();
}
