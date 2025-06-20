package com.google.android.gms.common.api;

import androidx.annotation.NonNull;
import com.google.android.gms.common.annotation.KeepForSdk;

public class CommonStatusCodes {

    /* renamed from: a  reason: collision with root package name */
    public static final int f19929a = -1;

    /* renamed from: b  reason: collision with root package name */
    public static final int f19930b = 0;
    @Deprecated

    /* renamed from: c  reason: collision with root package name */
    public static final int f19931c = 2;
    @Deprecated

    /* renamed from: d  reason: collision with root package name */
    public static final int f19932d = 3;

    /* renamed from: e  reason: collision with root package name */
    public static final int f19933e = 4;

    /* renamed from: f  reason: collision with root package name */
    public static final int f19934f = 5;

    /* renamed from: g  reason: collision with root package name */
    public static final int f19935g = 6;

    /* renamed from: h  reason: collision with root package name */
    public static final int f19936h = 7;

    /* renamed from: i  reason: collision with root package name */
    public static final int f19937i = 8;

    /* renamed from: j  reason: collision with root package name */
    public static final int f19938j = 10;

    /* renamed from: k  reason: collision with root package name */
    public static final int f19939k = 13;

    /* renamed from: l  reason: collision with root package name */
    public static final int f19940l = 14;

    /* renamed from: m  reason: collision with root package name */
    public static final int f19941m = 15;

    /* renamed from: n  reason: collision with root package name */
    public static final int f19942n = 16;
    public static final int o = 17;
    public static final int p = 19;
    public static final int q = 20;
    public static final int r = 21;
    public static final int s = 22;

    @KeepForSdk
    protected CommonStatusCodes() {
    }

    @NonNull
    public static String a(int i2) {
        switch (i2) {
            case -1:
                return "SUCCESS_CACHE";
            case 0:
                return "SUCCESS";
            case 2:
                return "SERVICE_VERSION_UPDATE_REQUIRED";
            case 3:
                return "SERVICE_DISABLED";
            case 4:
                return "SIGN_IN_REQUIRED";
            case 5:
                return "INVALID_ACCOUNT";
            case 6:
                return "RESOLUTION_REQUIRED";
            case 7:
                return "NETWORK_ERROR";
            case 8:
                return "INTERNAL_ERROR";
            case 10:
                return "DEVELOPER_ERROR";
            case 13:
                return "ERROR";
            case 14:
                return "INTERRUPTED";
            case 15:
                return "TIMEOUT";
            case 16:
                return "CANCELED";
            case 17:
                return "API_NOT_CONNECTED";
            case 18:
                return "DEAD_CLIENT";
            case 19:
                return "REMOTE_EXCEPTION";
            case 20:
                return "CONNECTION_SUSPENDED_DURING_CALL";
            case 21:
                return "RECONNECTION_TIMED_OUT_DURING_UPDATE";
            case 22:
                return "RECONNECTION_TIMED_OUT";
            default:
                return "unknown status code: " + i2;
        }
    }
}
