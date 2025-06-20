package com.google.firebase;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Build;
import com.google.firebase.components.Component;
import com.google.firebase.components.ComponentRegistrar;
import com.google.firebase.heartbeatinfo.DefaultHeartBeatController;
import com.google.firebase.platforminfo.DefaultUserAgentPublisher;
import com.google.firebase.platforminfo.KotlinDetector;
import com.google.firebase.platforminfo.LibraryVersionComponent;
import java.util.ArrayList;
import java.util.List;

public class FirebaseCommonRegistrar implements ComponentRegistrar {

    /* renamed from: a  reason: collision with root package name */
    private static final String f23296a = "fire-android";

    /* renamed from: b  reason: collision with root package name */
    private static final String f23297b = "fire-core";

    /* renamed from: c  reason: collision with root package name */
    private static final String f23298c = "device-name";

    /* renamed from: d  reason: collision with root package name */
    private static final String f23299d = "device-model";

    /* renamed from: e  reason: collision with root package name */
    private static final String f23300e = "device-brand";

    /* renamed from: f  reason: collision with root package name */
    private static final String f23301f = "android-target-sdk";

    /* renamed from: g  reason: collision with root package name */
    private static final String f23302g = "android-min-sdk";

    /* renamed from: h  reason: collision with root package name */
    private static final String f23303h = "android-platform";

    /* renamed from: i  reason: collision with root package name */
    private static final String f23304i = "android-installer";

    /* renamed from: j  reason: collision with root package name */
    private static final String f23305j = "kotlin";

    /* access modifiers changed from: private */
    public static /* synthetic */ String e(Context context) {
        ApplicationInfo applicationInfo = context.getApplicationInfo();
        return applicationInfo != null ? String.valueOf(applicationInfo.targetSdkVersion) : "";
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ String f(Context context) {
        ApplicationInfo applicationInfo = context.getApplicationInfo();
        return (applicationInfo == null || Build.VERSION.SDK_INT < 24) ? "" : String.valueOf(applicationInfo.minSdkVersion);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ String g(Context context) {
        int i2 = Build.VERSION.SDK_INT;
        if (context.getPackageManager().hasSystemFeature("android.hardware.type.television")) {
            return "tv";
        }
        if (context.getPackageManager().hasSystemFeature("android.hardware.type.watch")) {
            return "watch";
        }
        if (i2 < 23 || !context.getPackageManager().hasSystemFeature("android.hardware.type.automotive")) {
            return (i2 < 26 || !context.getPackageManager().hasSystemFeature("android.hardware.type.embedded")) ? "" : "embedded";
        }
        return "auto";
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ String h(Context context) {
        String installerPackageName = context.getPackageManager().getInstallerPackageName(context.getPackageName());
        return installerPackageName != null ? i(installerPackageName) : "";
    }

    private static String i(String str) {
        return str.replace(' ', '_').replace('/', '_');
    }

    public List<Component<?>> getComponents() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(DefaultUserAgentPublisher.c());
        arrayList.add(DefaultHeartBeatController.g());
        arrayList.add(LibraryVersionComponent.b(f23296a, String.valueOf(Build.VERSION.SDK_INT)));
        arrayList.add(LibraryVersionComponent.b(f23297b, BuildConfig.f23272d));
        arrayList.add(LibraryVersionComponent.b(f23298c, i(Build.PRODUCT)));
        arrayList.add(LibraryVersionComponent.b(f23299d, i(Build.DEVICE)));
        arrayList.add(LibraryVersionComponent.b(f23300e, i(Build.BRAND)));
        arrayList.add(LibraryVersionComponent.c(f23301f, new d()));
        arrayList.add(LibraryVersionComponent.c(f23302g, new e()));
        arrayList.add(LibraryVersionComponent.c(f23303h, new f()));
        arrayList.add(LibraryVersionComponent.c(f23304i, new g()));
        String a2 = KotlinDetector.a();
        if (a2 != null) {
            arrayList.add(LibraryVersionComponent.b(f23305j, a2));
        }
        return arrayList;
    }
}
