package com.google.firebase.crashlytics.internal.settings;

import com.google.firebase.crashlytics.internal.Logger;
import com.google.firebase.crashlytics.internal.common.CurrentTimeProvider;
import org.json.JSONException;
import org.json.JSONObject;

public class SettingsJsonParser {

    /* renamed from: a  reason: collision with root package name */
    private final CurrentTimeProvider f24302a;

    SettingsJsonParser(CurrentTimeProvider currentTimeProvider) {
        this.f24302a = currentTimeProvider;
    }

    private static SettingsJsonTransform a(int i2) {
        if (i2 == 3) {
            return new SettingsV3JsonTransform();
        }
        Logger f2 = Logger.f();
        f2.d("Could not determine SettingsJsonTransform for settings version " + i2 + ". Using default settings values.");
        return new DefaultSettingsJsonTransform();
    }

    public Settings b(JSONObject jSONObject) throws JSONException {
        return a(jSONObject.getInt("settings_version")).a(this.f24302a, jSONObject);
    }
}
