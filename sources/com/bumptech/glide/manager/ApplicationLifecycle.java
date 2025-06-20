package com.bumptech.glide.manager;

import androidx.annotation.NonNull;

class ApplicationLifecycle implements Lifecycle {
    ApplicationLifecycle() {
    }

    public void a(@NonNull LifecycleListener lifecycleListener) {
        lifecycleListener.a();
    }

    public void b(@NonNull LifecycleListener lifecycleListener) {
    }
}
