package com.bumptech.glide.module;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.util.Log;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

@Deprecated
public final class ManifestParser {

    /* renamed from: b  reason: collision with root package name */
    private static final String f18425b = "ManifestParser";

    /* renamed from: c  reason: collision with root package name */
    private static final String f18426c = "GlideModule";

    /* renamed from: a  reason: collision with root package name */
    private final Context f18427a;

    public ManifestParser(Context context) {
        this.f18427a = context;
    }

    private static GlideModule b(String str) {
        try {
            Class<?> cls = Class.forName(str);
            Object obj = null;
            try {
                obj = cls.getDeclaredConstructor((Class[]) null).newInstance((Object[]) null);
            } catch (IllegalAccessException | InstantiationException | NoSuchMethodException | InvocationTargetException e2) {
                c(cls, e2);
            }
            if (obj instanceof GlideModule) {
                return (GlideModule) obj;
            }
            throw new RuntimeException("Expected instanceof GlideModule, but found: " + obj);
        } catch (ClassNotFoundException e3) {
            throw new IllegalArgumentException("Unable to find GlideModule implementation", e3);
        }
    }

    private static void c(Class<?> cls, Exception exc) {
        throw new RuntimeException("Unable to instantiate GlideModule implementation for " + cls, exc);
    }

    public List<GlideModule> a() {
        if (Log.isLoggable(f18425b, 3)) {
            Log.d(f18425b, "Loading Glide modules");
        }
        ArrayList arrayList = new ArrayList();
        try {
            ApplicationInfo applicationInfo = this.f18427a.getPackageManager().getApplicationInfo(this.f18427a.getPackageName(), 128);
            if (applicationInfo.metaData == null) {
                if (Log.isLoggable(f18425b, 3)) {
                    Log.d(f18425b, "Got null app info metadata");
                }
                return arrayList;
            }
            if (Log.isLoggable(f18425b, 2)) {
                Log.v(f18425b, "Got app info metadata: " + applicationInfo.metaData);
            }
            for (String next : applicationInfo.metaData.keySet()) {
                if (f18426c.equals(applicationInfo.metaData.get(next))) {
                    arrayList.add(b(next));
                    if (Log.isLoggable(f18425b, 3)) {
                        Log.d(f18425b, "Loaded Glide module: " + next);
                    }
                }
            }
            if (Log.isLoggable(f18425b, 3)) {
                Log.d(f18425b, "Finished loading Glide modules");
            }
            return arrayList;
        } catch (PackageManager.NameNotFoundException e2) {
            throw new RuntimeException("Unable to find metadata to parse GlideModules", e2);
        }
    }
}
