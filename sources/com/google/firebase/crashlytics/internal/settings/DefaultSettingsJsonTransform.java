package com.google.firebase.crashlytics.internal.settings;

import com.google.firebase.crashlytics.internal.common.CurrentTimeProvider;
import com.google.firebase.crashlytics.internal.settings.Settings;
import org.json.JSONObject;

class DefaultSettingsJsonTransform implements SettingsJsonTransform {
    DefaultSettingsJsonTransform() {
    }

    static Settings b(CurrentTimeProvider currentTimeProvider) {
        return new Settings(currentTimeProvider.a() + ((long) 3600000), new Settings.SessionData(8, 4), new Settings.FeatureFlagData(true, false, false), 0, 3600, 10.0d, 1.2d, 60);
    }

    public Settings a(CurrentTimeProvider currentTimeProvider, JSONObject jSONObject) {
        return b(currentTimeProvider);
    }
}
