package com.google.firebase.crashlytics.internal.settings;

import com.google.firebase.crashlytics.internal.Logger;
import com.google.firebase.crashlytics.internal.common.CommonUtils;
import com.google.firebase.crashlytics.internal.persistence.FileStore;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import org.json.JSONObject;

public class CachedSettingsIo {

    /* renamed from: b  reason: collision with root package name */
    private static final String f24247b = "com.crashlytics.settings.json";

    /* renamed from: a  reason: collision with root package name */
    private final File f24248a;

    public CachedSettingsIo(FileStore fileStore) {
        this.f24248a = fileStore.h(f24247b);
    }

    private File a() {
        return this.f24248a;
    }

    public JSONObject b() {
        FileInputStream fileInputStream;
        JSONObject jSONObject;
        Logger.f().b("Checking for cached settings...");
        FileInputStream fileInputStream2 = null;
        try {
            File a2 = a();
            if (a2.exists()) {
                fileInputStream = new FileInputStream(a2);
                try {
                    jSONObject = new JSONObject(CommonUtils.D(fileInputStream));
                    fileInputStream2 = fileInputStream;
                } catch (Exception e2) {
                    e = e2;
                    try {
                        Logger.f().e("Failed to fetch cached settings", e);
                        CommonUtils.f(fileInputStream, "Error while closing settings cache file.");
                        return null;
                    } catch (Throwable th) {
                        th = th;
                        CommonUtils.f(fileInputStream, "Error while closing settings cache file.");
                        throw th;
                    }
                }
            } else {
                Logger.f().k("Settings file does not exist.");
                jSONObject = null;
            }
            CommonUtils.f(fileInputStream2, "Error while closing settings cache file.");
            return jSONObject;
        } catch (Exception e3) {
            e = e3;
            fileInputStream = null;
            Logger.f().e("Failed to fetch cached settings", e);
            CommonUtils.f(fileInputStream, "Error while closing settings cache file.");
            return null;
        } catch (Throwable th2) {
            fileInputStream = null;
            th = th2;
            CommonUtils.f(fileInputStream, "Error while closing settings cache file.");
            throw th;
        }
    }

    public void c(long j2, JSONObject jSONObject) {
        Logger.f().k("Writing settings to cache file...");
        if (jSONObject != null) {
            FileWriter fileWriter = null;
            try {
                jSONObject.put("expires_at", j2);
                FileWriter fileWriter2 = new FileWriter(a());
                try {
                    fileWriter2.write(jSONObject.toString());
                    fileWriter2.flush();
                    CommonUtils.f(fileWriter2, "Failed to close settings writer.");
                } catch (Exception e2) {
                    e = e2;
                    fileWriter = fileWriter2;
                    try {
                        Logger.f().e("Failed to cache settings", e);
                        CommonUtils.f(fileWriter, "Failed to close settings writer.");
                    } catch (Throwable th) {
                        th = th;
                        CommonUtils.f(fileWriter, "Failed to close settings writer.");
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    fileWriter = fileWriter2;
                    CommonUtils.f(fileWriter, "Failed to close settings writer.");
                    throw th;
                }
            } catch (Exception e3) {
                e = e3;
                Logger.f().e("Failed to cache settings", e);
                CommonUtils.f(fileWriter, "Failed to close settings writer.");
            }
        }
    }
}
