package com.google.firebase.crashlytics.internal.common;

import android.content.Context;

class InstallerPackageNameProvider {

    /* renamed from: b  reason: collision with root package name */
    private static final String f23669b = "";

    /* renamed from: a  reason: collision with root package name */
    private String f23670a;

    InstallerPackageNameProvider() {
    }

    private static String b(Context context) {
        String installerPackageName = context.getPackageManager().getInstallerPackageName(context.getPackageName());
        return installerPackageName == null ? "" : installerPackageName;
    }

    /* access modifiers changed from: package-private */
    public synchronized String a(Context context) {
        try {
            if (this.f23670a == null) {
                this.f23670a = b(context);
            }
        } catch (Throwable th) {
            while (true) {
                throw th;
            }
        }
        return "".equals(this.f23670a) ? null : this.f23670a;
    }
}
