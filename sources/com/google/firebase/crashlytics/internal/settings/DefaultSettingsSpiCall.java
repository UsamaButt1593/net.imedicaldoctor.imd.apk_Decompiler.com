package com.google.firebase.crashlytics.internal.settings;

import android.text.TextUtils;
import com.google.firebase.crashlytics.internal.Logger;
import com.google.firebase.crashlytics.internal.common.CrashlyticsCore;
import com.google.firebase.crashlytics.internal.network.HttpGetRequest;
import com.google.firebase.crashlytics.internal.network.HttpRequestFactory;
import com.google.firebase.crashlytics.internal.network.HttpResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

class DefaultSettingsSpiCall implements SettingsSpiCall {

    /* renamed from: d  reason: collision with root package name */
    static final String f24249d = "X-CRASHLYTICS-GOOGLE-APP-ID";

    /* renamed from: e  reason: collision with root package name */
    static final String f24250e = "X-CRASHLYTICS-API-CLIENT-TYPE";

    /* renamed from: f  reason: collision with root package name */
    static final String f24251f = "X-CRASHLYTICS-API-CLIENT-VERSION";

    /* renamed from: g  reason: collision with root package name */
    static final String f24252g = "User-Agent";

    /* renamed from: h  reason: collision with root package name */
    static final String f24253h = "Accept";

    /* renamed from: i  reason: collision with root package name */
    static final String f24254i = "Crashlytics Android SDK/";

    /* renamed from: j  reason: collision with root package name */
    static final String f24255j = "application/json";

    /* renamed from: k  reason: collision with root package name */
    static final String f24256k = "android";

    /* renamed from: l  reason: collision with root package name */
    static final String f24257l = "build_version";

    /* renamed from: m  reason: collision with root package name */
    static final String f24258m = "display_version";

    /* renamed from: n  reason: collision with root package name */
    static final String f24259n = "instance";
    static final String o = "source";
    static final String p = "X-CRASHLYTICS-DEVICE-MODEL";
    static final String q = "X-CRASHLYTICS-OS-BUILD-VERSION";
    static final String r = "X-CRASHLYTICS-OS-DISPLAY-VERSION";
    static final String s = "X-CRASHLYTICS-INSTALLATION-ID";

    /* renamed from: a  reason: collision with root package name */
    private final String f24260a;

    /* renamed from: b  reason: collision with root package name */
    private final HttpRequestFactory f24261b;

    /* renamed from: c  reason: collision with root package name */
    private final Logger f24262c;

    public DefaultSettingsSpiCall(String str, HttpRequestFactory httpRequestFactory) {
        this(str, httpRequestFactory, Logger.f());
    }

    private HttpGetRequest b(HttpGetRequest httpGetRequest, SettingsRequest settingsRequest) {
        c(httpGetRequest, f24249d, settingsRequest.f24303a);
        c(httpGetRequest, f24250e, f24256k);
        c(httpGetRequest, f24251f, CrashlyticsCore.m());
        c(httpGetRequest, "Accept", f24255j);
        c(httpGetRequest, p, settingsRequest.f24304b);
        c(httpGetRequest, q, settingsRequest.f24305c);
        c(httpGetRequest, r, settingsRequest.f24306d);
        c(httpGetRequest, s, settingsRequest.f24307e.a().c());
        return httpGetRequest;
    }

    private void c(HttpGetRequest httpGetRequest, String str, String str2) {
        if (str2 != null) {
            httpGetRequest.d(str, str2);
        }
    }

    private JSONObject e(String str) {
        try {
            return new JSONObject(str);
        } catch (Exception e2) {
            Logger logger = this.f24262c;
            logger.n("Failed to parse settings JSON from " + this.f24260a, e2);
            Logger logger2 = this.f24262c;
            logger2.m("Settings response " + str);
            return null;
        }
    }

    private Map<String, String> f(SettingsRequest settingsRequest) {
        HashMap hashMap = new HashMap();
        hashMap.put(f24257l, settingsRequest.f24310h);
        hashMap.put(f24258m, settingsRequest.f24309g);
        hashMap.put("source", Integer.toString(settingsRequest.f24311i));
        String str = settingsRequest.f24308f;
        if (!TextUtils.isEmpty(str)) {
            hashMap.put(f24259n, str);
        }
        return hashMap;
    }

    public JSONObject a(SettingsRequest settingsRequest, boolean z) {
        if (z) {
            try {
                Map<String, String> f2 = f(settingsRequest);
                HttpGetRequest b2 = b(d(f2), settingsRequest);
                Logger logger = this.f24262c;
                logger.b("Requesting settings from " + this.f24260a);
                Logger logger2 = this.f24262c;
                logger2.k("Settings query params were: " + f2);
                return g(b2.c());
            } catch (IOException e2) {
                this.f24262c.e("Settings request failed.", e2);
                return null;
            }
        } else {
            throw new RuntimeException("An invalid data collection token was used.");
        }
    }

    /* access modifiers changed from: protected */
    public HttpGetRequest d(Map<String, String> map) {
        HttpGetRequest b2 = this.f24261b.b(this.f24260a, map);
        return b2.d("User-Agent", f24254i + CrashlyticsCore.m()).d("X-CRASHLYTICS-DEVELOPER-TOKEN", "470fa2b4ae81cd56ecbcda9735803434cec591fa");
    }

    /* access modifiers changed from: package-private */
    public JSONObject g(HttpResponse httpResponse) {
        int b2 = httpResponse.b();
        Logger logger = this.f24262c;
        logger.k("Settings response code was: " + b2);
        if (h(b2)) {
            return e(httpResponse.a());
        }
        Logger logger2 = this.f24262c;
        logger2.d("Settings request failed; (status: " + b2 + ") from " + this.f24260a);
        return null;
    }

    /* access modifiers changed from: package-private */
    public boolean h(int i2) {
        return i2 == 200 || i2 == 201 || i2 == 202 || i2 == 203;
    }

    DefaultSettingsSpiCall(String str, HttpRequestFactory httpRequestFactory, Logger logger) {
        if (str != null) {
            this.f24262c = logger;
            this.f24261b = httpRequestFactory;
            this.f24260a = str;
            return;
        }
        throw new IllegalArgumentException("url must not be null.");
    }
}
