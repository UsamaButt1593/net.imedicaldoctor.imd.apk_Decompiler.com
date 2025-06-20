package com.google.firebase.crashlytics.internal.model.serialization;

import android.util.JsonReader;
import com.google.firebase.crashlytics.internal.model.serialization.CrashlyticsReportJsonTransform;

public final /* synthetic */ class g implements CrashlyticsReportJsonTransform.ObjectParser {
    public final Object a(JsonReader jsonReader) {
        return CrashlyticsReportJsonTransform.v(jsonReader);
    }
}
