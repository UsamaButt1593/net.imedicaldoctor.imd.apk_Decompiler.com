package com.google.firebase.crashlytics.internal.analytics;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.firebase.crashlytics.internal.Logger;
import com.google.firebase.crashlytics.internal.breadcrumbs.BreadcrumbHandler;
import com.google.firebase.crashlytics.internal.breadcrumbs.BreadcrumbSource;
import org.json.JSONException;
import org.json.JSONObject;

public class BreadcrumbAnalyticsEventReceiver implements AnalyticsEventReceiver, BreadcrumbSource {

    /* renamed from: b  reason: collision with root package name */
    private static final String f23518b = "name";

    /* renamed from: c  reason: collision with root package name */
    private static final String f23519c = "parameters";

    /* renamed from: d  reason: collision with root package name */
    private static final String f23520d = "$A$:";
    @Nullable

    /* renamed from: a  reason: collision with root package name */
    private BreadcrumbHandler f23521a;

    @NonNull
    private static String b(@NonNull String str, @NonNull Bundle bundle) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        for (String next : bundle.keySet()) {
            jSONObject2.put(next, bundle.get(next));
        }
        jSONObject.put("name", str);
        jSONObject.put("parameters", jSONObject2);
        return jSONObject.toString();
    }

    public void a(@Nullable BreadcrumbHandler breadcrumbHandler) {
        this.f23521a = breadcrumbHandler;
        Logger.f().b("Registered Firebase Analytics event receiver for breadcrumbs");
    }

    public void y(@NonNull String str, @NonNull Bundle bundle) {
        BreadcrumbHandler breadcrumbHandler = this.f23521a;
        if (breadcrumbHandler != null) {
            try {
                breadcrumbHandler.a(f23520d + b(str, bundle));
            } catch (JSONException unused) {
                Logger.f().m("Unable to serialize Firebase Analytics event to breadcrumb.");
            }
        }
    }
}
