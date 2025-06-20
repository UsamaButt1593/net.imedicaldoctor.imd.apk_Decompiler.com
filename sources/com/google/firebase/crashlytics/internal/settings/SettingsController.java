package com.google.firebase.crashlytics.internal.settings;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.tasks.SuccessContinuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.crashlytics.internal.Logger;
import com.google.firebase.crashlytics.internal.common.CommonUtils;
import com.google.firebase.crashlytics.internal.common.CurrentTimeProvider;
import com.google.firebase.crashlytics.internal.common.DataCollectionArbiter;
import com.google.firebase.crashlytics.internal.common.DeliveryMechanism;
import com.google.firebase.crashlytics.internal.common.IdManager;
import com.google.firebase.crashlytics.internal.common.SystemCurrentTimeProvider;
import com.google.firebase.crashlytics.internal.network.HttpRequestFactory;
import com.google.firebase.crashlytics.internal.persistence.FileStore;
import java.util.Locale;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicReference;
import org.json.JSONException;
import org.json.JSONObject;

public class SettingsController implements SettingsProvider {

    /* renamed from: j  reason: collision with root package name */
    private static final String f24276j = "existing_instance_identifier";

    /* renamed from: k  reason: collision with root package name */
    private static final String f24277k = "https://firebase-settings.crashlytics.com/spi/v2/platforms/android/gmp/%s/settings";

    /* renamed from: a  reason: collision with root package name */
    private final Context f24278a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final SettingsRequest f24279b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public final SettingsJsonParser f24280c;

    /* renamed from: d  reason: collision with root package name */
    private final CurrentTimeProvider f24281d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public final CachedSettingsIo f24282e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public final SettingsSpiCall f24283f;

    /* renamed from: g  reason: collision with root package name */
    private final DataCollectionArbiter f24284g;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public final AtomicReference<Settings> f24285h;
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public final AtomicReference<TaskCompletionSource<Settings>> f24286i = new AtomicReference<>(new TaskCompletionSource());

    SettingsController(Context context, SettingsRequest settingsRequest, CurrentTimeProvider currentTimeProvider, SettingsJsonParser settingsJsonParser, CachedSettingsIo cachedSettingsIo, SettingsSpiCall settingsSpiCall, DataCollectionArbiter dataCollectionArbiter) {
        AtomicReference<Settings> atomicReference = new AtomicReference<>();
        this.f24285h = atomicReference;
        this.f24278a = context;
        this.f24279b = settingsRequest;
        this.f24281d = currentTimeProvider;
        this.f24280c = settingsJsonParser;
        this.f24282e = cachedSettingsIo;
        this.f24283f = settingsSpiCall;
        this.f24284g = dataCollectionArbiter;
        atomicReference.set(DefaultSettingsJsonTransform.b(currentTimeProvider));
    }

    public static SettingsController l(Context context, String str, IdManager idManager, HttpRequestFactory httpRequestFactory, String str2, String str3, FileStore fileStore, DataCollectionArbiter dataCollectionArbiter) {
        String str4 = str;
        String g2 = idManager.g();
        SystemCurrentTimeProvider systemCurrentTimeProvider = new SystemCurrentTimeProvider();
        SettingsJsonParser settingsJsonParser = new SettingsJsonParser(systemCurrentTimeProvider);
        CachedSettingsIo cachedSettingsIo = new CachedSettingsIo(fileStore);
        DefaultSettingsSpiCall defaultSettingsSpiCall = new DefaultSettingsSpiCall(String.format(Locale.US, f24277k, new Object[]{str4}), httpRequestFactory);
        String str5 = str2;
        String str6 = str3;
        return new SettingsController(context, new SettingsRequest(str4, idManager.h(), idManager.i(), idManager.j(), idManager, CommonUtils.h(CommonUtils.n(context), str4, str6, str5), str6, str5, DeliveryMechanism.b(g2).c()), systemCurrentTimeProvider, settingsJsonParser, cachedSettingsIo, defaultSettingsSpiCall, dataCollectionArbiter);
    }

    private Settings m(SettingsCacheBehavior settingsCacheBehavior) {
        Settings settings = null;
        try {
            if (SettingsCacheBehavior.SKIP_CACHE_LOOKUP.equals(settingsCacheBehavior)) {
                return null;
            }
            JSONObject b2 = this.f24282e.b();
            if (b2 != null) {
                Settings b3 = this.f24280c.b(b2);
                if (b3 != null) {
                    q(b2, "Loaded cached settings: ");
                    long a2 = this.f24281d.a();
                    if (!SettingsCacheBehavior.IGNORE_CACHE_EXPIRATION.equals(settingsCacheBehavior)) {
                        if (b3.a(a2)) {
                            Logger.f().k("Cached settings have expired.");
                            return null;
                        }
                    }
                    try {
                        Logger.f().k("Returning cached settings.");
                        return b3;
                    } catch (Exception e2) {
                        e = e2;
                        settings = b3;
                        Logger.f().e("Failed to get cached settings", e);
                        return settings;
                    }
                } else {
                    Logger.f().e("Failed to parse cached settings data.", (Throwable) null);
                    return null;
                }
            } else {
                Logger.f().b("No cached settings data found.");
                return null;
            }
        } catch (Exception e3) {
            e = e3;
            Logger.f().e("Failed to get cached settings", e);
            return settings;
        }
    }

    private String n() {
        return CommonUtils.r(this.f24278a).getString(f24276j, "");
    }

    /* access modifiers changed from: private */
    public void q(JSONObject jSONObject, String str) throws JSONException {
        Logger f2 = Logger.f();
        f2.b(str + jSONObject.toString());
    }

    /* access modifiers changed from: private */
    @SuppressLint({"CommitPrefEdits"})
    public boolean r(String str) {
        SharedPreferences.Editor edit = CommonUtils.r(this.f24278a).edit();
        edit.putString(f24276j, str);
        edit.apply();
        return true;
    }

    public Task<Settings> a() {
        return this.f24286i.get().a();
    }

    public Settings b() {
        return this.f24285h.get();
    }

    /* access modifiers changed from: package-private */
    public boolean k() {
        return !n().equals(this.f24279b.f24308f);
    }

    public Task<Void> o(SettingsCacheBehavior settingsCacheBehavior, Executor executor) {
        Settings m2;
        if (k() || (m2 = m(settingsCacheBehavior)) == null) {
            Settings m3 = m(SettingsCacheBehavior.IGNORE_CACHE_EXPIRATION);
            if (m3 != null) {
                this.f24285h.set(m3);
                this.f24286i.get().e(m3);
            }
            return this.f24284g.k(executor).x(executor, new SuccessContinuation<Void, Void>() {
                @NonNull
                /* renamed from: b */
                public Task<Void> a(@Nullable Void voidR) throws Exception {
                    JSONObject a2 = SettingsController.this.f24283f.a(SettingsController.this.f24279b, true);
                    if (a2 != null) {
                        Settings b2 = SettingsController.this.f24280c.b(a2);
                        SettingsController.this.f24282e.c(b2.f24265c, a2);
                        SettingsController.this.q(a2, "Loaded settings: ");
                        SettingsController settingsController = SettingsController.this;
                        boolean unused = settingsController.r(settingsController.f24279b.f24308f);
                        SettingsController.this.f24285h.set(b2);
                        ((TaskCompletionSource) SettingsController.this.f24286i.get()).e(b2);
                    }
                    return Tasks.g(null);
                }
            });
        }
        this.f24285h.set(m2);
        this.f24286i.get().e(m2);
        return Tasks.g(null);
    }

    public Task<Void> p(Executor executor) {
        return o(SettingsCacheBehavior.USE_CACHE, executor);
    }
}
