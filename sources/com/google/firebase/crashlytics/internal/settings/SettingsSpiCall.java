package com.google.firebase.crashlytics.internal.settings;

import org.json.JSONObject;

interface SettingsSpiCall {
    JSONObject a(SettingsRequest settingsRequest, boolean z);
}
