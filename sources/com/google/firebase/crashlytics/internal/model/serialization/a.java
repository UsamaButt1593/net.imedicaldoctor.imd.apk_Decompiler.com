package com.google.firebase.crashlytics.internal.model.serialization;

import android.util.JsonReader;
import com.google.firebase.crashlytics.internal.model.serialization.CrashlyticsReportJsonTransform;

public final /* synthetic */ class a implements CrashlyticsReportJsonTransform.ObjectParser {
    public final Object a(JsonReader jsonReader) {
        return CrashlyticsReportJsonTransform.z(jsonReader);
    }
}
