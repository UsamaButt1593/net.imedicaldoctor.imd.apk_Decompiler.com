package com.google.firebase.remoteconfig.interop;

import androidx.annotation.NonNull;
import com.google.firebase.remoteconfig.interop.rollouts.RolloutsStateSubscriber;

public interface FirebaseRemoteConfigInterop {
    void a(@NonNull String str, @NonNull RolloutsStateSubscriber rolloutsStateSubscriber);
}
