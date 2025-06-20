package com.google.android.gms.common.internal;

import androidx.annotation.NonNull;
import com.google.android.gms.common.annotation.KeepForSdk;

@KeepForSdk
public final class ServiceSpecificExtraArgs {

    @KeepForSdk
    public interface CastExtraArgs {
        @NonNull
        @KeepForSdk

        /* renamed from: a  reason: collision with root package name */
        public static final String f20260a = "listener";
    }

    @KeepForSdk
    public interface GamesExtraArgs {
        @NonNull
        @KeepForSdk

        /* renamed from: a  reason: collision with root package name */
        public static final String f20261a = "com.google.android.gms.games.key.gamePackageName";
        @NonNull
        @KeepForSdk

        /* renamed from: b  reason: collision with root package name */
        public static final String f20262b = "com.google.android.gms.games.key.desiredLocale";
        @NonNull
        @KeepForSdk

        /* renamed from: c  reason: collision with root package name */
        public static final String f20263c = "com.google.android.gms.games.key.popupWindowToken";
        @NonNull
        @KeepForSdk

        /* renamed from: d  reason: collision with root package name */
        public static final String f20264d = "com.google.android.gms.games.key.signInOptions";
    }

    @KeepForSdk
    public interface PlusExtraArgs {
        @NonNull
        @KeepForSdk

        /* renamed from: a  reason: collision with root package name */
        public static final String f20265a = "auth_package";
    }

    private ServiceSpecificExtraArgs() {
    }
}
