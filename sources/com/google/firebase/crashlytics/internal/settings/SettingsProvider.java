package com.google.firebase.crashlytics.internal.settings;

import com.google.android.gms.tasks.Task;

public interface SettingsProvider {
    Task<Settings> a();

    Settings b();
}
