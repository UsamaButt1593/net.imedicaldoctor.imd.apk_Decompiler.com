package com.google.firebase.crashlytics.internal;

import android.content.Context;
import androidx.annotation.Nullable;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.google.firebase.crashlytics.internal.common.CommonUtils;
import java.io.IOException;
import java.io.InputStream;

public class DevelopmentPlatformProvider {

    /* renamed from: c  reason: collision with root package name */
    private static final String f23495c = "Unity";

    /* renamed from: d  reason: collision with root package name */
    private static final String f23496d = "Flutter";

    /* renamed from: e  reason: collision with root package name */
    private static final String f23497e = "com.google.firebase.crashlytics.unity_version";

    /* renamed from: f  reason: collision with root package name */
    private static final String f23498f = "flutter_assets/NOTICES.Z";
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final Context f23499a;
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    private DevelopmentPlatform f23500b = null;

    private class DevelopmentPlatform {
        /* access modifiers changed from: private */
        @Nullable

        /* renamed from: a  reason: collision with root package name */
        public final String f23501a;
        /* access modifiers changed from: private */
        @Nullable

        /* renamed from: b  reason: collision with root package name */
        public final String f23502b;

        private DevelopmentPlatform() {
            int q = CommonUtils.q(DevelopmentPlatformProvider.this.f23499a, DevelopmentPlatformProvider.f23497e, TypedValues.Custom.f3952e);
            if (q != 0) {
                this.f23501a = DevelopmentPlatformProvider.f23495c;
                String string = DevelopmentPlatformProvider.this.f23499a.getResources().getString(q);
                this.f23502b = string;
                Logger f2 = Logger.f();
                f2.k("Unity Editor version is: " + string);
            } else if (DevelopmentPlatformProvider.this.c(DevelopmentPlatformProvider.f23498f)) {
                this.f23501a = DevelopmentPlatformProvider.f23496d;
                this.f23502b = null;
                Logger.f().k("Development platform is: Flutter");
            } else {
                this.f23501a = null;
                this.f23502b = null;
            }
        }
    }

    public DevelopmentPlatformProvider(Context context) {
        this.f23499a = context;
    }

    /* access modifiers changed from: private */
    public boolean c(String str) {
        if (this.f23499a.getAssets() == null) {
            return false;
        }
        try {
            InputStream open = this.f23499a.getAssets().open(str);
            if (open == null) {
                return true;
            }
            open.close();
            return true;
        } catch (IOException unused) {
            return false;
        }
    }

    private DevelopmentPlatform f() {
        if (this.f23500b == null) {
            this.f23500b = new DevelopmentPlatform();
        }
        return this.f23500b;
    }

    public static boolean g(Context context) {
        return CommonUtils.q(context, f23497e, TypedValues.Custom.f3952e) != 0;
    }

    @Nullable
    public String d() {
        return f().f23501a;
    }

    @Nullable
    public String e() {
        return f().f23502b;
    }
}
