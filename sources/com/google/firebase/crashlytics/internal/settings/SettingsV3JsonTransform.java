package com.google.firebase.crashlytics.internal.settings;

import com.google.firebase.crashlytics.internal.common.CurrentTimeProvider;
import com.google.firebase.crashlytics.internal.settings.Settings;
import org.json.JSONException;
import org.json.JSONObject;

class SettingsV3JsonTransform implements SettingsJsonTransform {
    SettingsV3JsonTransform() {
    }

    private static Settings.FeatureFlagData b(JSONObject jSONObject) {
        return new Settings.FeatureFlagData(jSONObject.optBoolean("collect_reports", true), jSONObject.optBoolean("collect_anrs", false), jSONObject.optBoolean("collect_build_ids", false));
    }

    private static Settings.SessionData c(JSONObject jSONObject) {
        return new Settings.SessionData(jSONObject.optInt("max_custom_exception_events", 8), 4);
    }

    private static long d(CurrentTimeProvider currentTimeProvider, long j2, JSONObject jSONObject) {
        return jSONObject.has("expires_at") ? jSONObject.optLong("expires_at") : currentTimeProvider.a() + (j2 * 1000);
    }

    public Settings a(CurrentTimeProvider currentTimeProvider, JSONObject jSONObject) throws JSONException {
        JSONObject jSONObject2 = jSONObject;
        int optInt = jSONObject2.optInt("settings_version", 0);
        int optInt2 = jSONObject2.optInt("cache_duration", 3600);
        return new Settings(d(currentTimeProvider, (long) optInt2, jSONObject2), c(jSONObject2.has("session") ? jSONObject2.getJSONObject("session") : new JSONObject()), b(jSONObject2.getJSONObject("features")), optInt, optInt2, jSONObject2.optDouble("on_demand_upload_rate_per_minute", 10.0d), jSONObject2.optDouble("on_demand_backoff_base", 1.2d), jSONObject2.optInt("on_demand_backoff_step_duration_seconds", 60));
    }
}
