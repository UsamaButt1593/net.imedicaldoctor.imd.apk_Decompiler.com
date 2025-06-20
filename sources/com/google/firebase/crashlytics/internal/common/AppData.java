package com.google.firebase.crashlytics.internal.common;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import com.google.firebase.crashlytics.internal.DevelopmentPlatformProvider;
import java.util.List;

public class AppData {

    /* renamed from: a  reason: collision with root package name */
    public final String f23528a;

    /* renamed from: b  reason: collision with root package name */
    public final String f23529b;

    /* renamed from: c  reason: collision with root package name */
    public final List<BuildIdInfo> f23530c;

    /* renamed from: d  reason: collision with root package name */
    public final String f23531d;

    /* renamed from: e  reason: collision with root package name */
    public final String f23532e;

    /* renamed from: f  reason: collision with root package name */
    public final String f23533f;

    /* renamed from: g  reason: collision with root package name */
    public final String f23534g;

    /* renamed from: h  reason: collision with root package name */
    public final DevelopmentPlatformProvider f23535h;

    public AppData(String str, String str2, List<BuildIdInfo> list, String str3, String str4, String str5, String str6, DevelopmentPlatformProvider developmentPlatformProvider) {
        this.f23528a = str;
        this.f23529b = str2;
        this.f23530c = list;
        this.f23531d = str3;
        this.f23532e = str4;
        this.f23533f = str5;
        this.f23534g = str6;
        this.f23535h = developmentPlatformProvider;
    }

    public static AppData a(Context context, IdManager idManager, String str, String str2, List<BuildIdInfo> list, DevelopmentPlatformProvider developmentPlatformProvider) throws PackageManager.NameNotFoundException {
        String packageName = context.getPackageName();
        String g2 = idManager.g();
        PackageInfo packageInfo = context.getPackageManager().getPackageInfo(packageName, 0);
        String b2 = b(packageInfo);
        String str3 = packageInfo.versionName;
        if (str3 == null) {
            str3 = IdManager.f23655g;
        }
        return new AppData(str, str2, list, g2, packageName, b2, str3, developmentPlatformProvider);
    }

    private static String b(PackageInfo packageInfo) {
        return Build.VERSION.SDK_INT >= 28 ? Long.toString(packageInfo.getLongVersionCode()) : Integer.toString(packageInfo.versionCode);
    }
}
