package com.google.firebase.messaging;

import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import androidx.annotation.AnyThread;
import androidx.annotation.VisibleForTesting;
import androidx.media3.exoplayer.dash.offline.a;
import androidx.media3.extractor.metadata.icy.IcyHeaders;
import com.google.android.gms.cloudmessaging.CloudMessage;
import com.google.android.gms.cloudmessaging.Rpc;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.FirebaseApp;
import com.google.firebase.heartbeatinfo.HeartBeatInfo;
import com.google.firebase.inject.Provider;
import com.google.firebase.installations.FirebaseInstallationsApi;
import com.google.firebase.platforminfo.UserAgentPublisher;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.concurrent.ExecutionException;

class GmsRpc {
    private static final String A = "gmp_app_id";
    private static final String B = "gmsv";
    private static final String C = "osv";
    private static final String D = "app_ver";
    private static final String E = "app_ver_name";
    private static final String F = "Goog-Firebase-Installations-Auth";
    private static final String G = "firebase-app-name-hash";
    static final String H = "RST_FULL";
    static final String I = "RST";
    static final String J = "SYNC";
    private static final String K = "*";

    /* renamed from: g  reason: collision with root package name */
    static final String f24776g = "FirebaseMessaging";

    /* renamed from: h  reason: collision with root package name */
    private static final String f24777h = "registration_id";

    /* renamed from: i  reason: collision with root package name */
    private static final String f24778i = "unregistered";

    /* renamed from: j  reason: collision with root package name */
    private static final String f24779j = "error";

    /* renamed from: k  reason: collision with root package name */
    static final String f24780k = "SERVICE_NOT_AVAILABLE";

    /* renamed from: l  reason: collision with root package name */
    static final String f24781l = "INTERNAL_SERVER_ERROR";

    /* renamed from: m  reason: collision with root package name */
    static final String f24782m = "fire-iid";

    /* renamed from: n  reason: collision with root package name */
    static final String f24783n = "InternalServerError";
    private static final String o = "gcm.topic";
    private static final String p = "/topics/";
    static final String q = "INSTANCE_ID_RESET";
    private static final String r = "subtype";
    private static final String s = "sender";
    private static final String t = "scope";
    private static final String u = "delete";
    private static final String v = "iid-operation";
    private static final String w = "appid";
    private static final String x = "Firebase-Client";
    private static final String y = "Firebase-Client-Log-Type";
    private static final String z = "cliv";

    /* renamed from: a  reason: collision with root package name */
    private final FirebaseApp f24784a;

    /* renamed from: b  reason: collision with root package name */
    private final Metadata f24785b;

    /* renamed from: c  reason: collision with root package name */
    private final Rpc f24786c;

    /* renamed from: d  reason: collision with root package name */
    private final Provider<UserAgentPublisher> f24787d;

    /* renamed from: e  reason: collision with root package name */
    private final Provider<HeartBeatInfo> f24788e;

    /* renamed from: f  reason: collision with root package name */
    private final FirebaseInstallationsApi f24789f;

    @VisibleForTesting
    GmsRpc(FirebaseApp firebaseApp, Metadata metadata, Rpc rpc, Provider<UserAgentPublisher> provider, Provider<HeartBeatInfo> provider2, FirebaseInstallationsApi firebaseInstallationsApi) {
        this.f24784a = firebaseApp;
        this.f24785b = metadata;
        this.f24786c = rpc;
        this.f24787d = provider;
        this.f24788e = provider2;
        this.f24789f = firebaseInstallationsApi;
    }

    private static String b(byte[] bArr) {
        return Base64.encodeToString(bArr, 11);
    }

    private Task<String> d(Task<Bundle> task) {
        return task.n(new a(), new z(this));
    }

    private String e() {
        try {
            return b(MessageDigest.getInstance("SHA-1").digest(this.f24784a.r().getBytes()));
        } catch (NoSuchAlgorithmException unused) {
            return "[HASH-ERROR]";
        }
    }

    @AnyThread
    private String h(Bundle bundle) throws IOException {
        if (bundle != null) {
            String string = bundle.getString(f24777h);
            if (string != null) {
                return string;
            }
            String string2 = bundle.getString(f24778i);
            if (string2 != null) {
                return string2;
            }
            String string3 = bundle.getString("error");
            if (I.equals(string3)) {
                throw new IOException(q);
            } else if (string3 != null) {
                throw new IOException(string3);
            } else {
                Log.w("FirebaseMessaging", "Unexpected response: " + bundle, new Throwable());
                throw new IOException(f24780k);
            }
        } else {
            throw new IOException(f24780k);
        }
    }

    static boolean i(String str) {
        return f24780k.equals(str) || f24781l.equals(str) || f24783n.equals(str);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ String j(Task task) throws Exception {
        return h((Bundle) task.s(IOException.class));
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x00c0 A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:18:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void k(java.lang.String r3, java.lang.String r4, android.os.Bundle r5) throws java.util.concurrent.ExecutionException, java.lang.InterruptedException {
        /*
            r2 = this;
            java.lang.String r0 = "FirebaseMessaging"
            java.lang.String r1 = "scope"
            r5.putString(r1, r4)
            java.lang.String r4 = "sender"
            r5.putString(r4, r3)
            java.lang.String r4 = "subtype"
            r5.putString(r4, r3)
            com.google.firebase.FirebaseApp r3 = r2.f24784a
            com.google.firebase.FirebaseOptions r3 = r3.s()
            java.lang.String r3 = r3.j()
            java.lang.String r4 = "gmp_app_id"
            r5.putString(r4, r3)
            com.google.firebase.messaging.Metadata r3 = r2.f24785b
            int r3 = r3.d()
            java.lang.String r3 = java.lang.Integer.toString(r3)
            java.lang.String r4 = "gmsv"
            r5.putString(r4, r3)
            int r3 = android.os.Build.VERSION.SDK_INT
            java.lang.String r3 = java.lang.Integer.toString(r3)
            java.lang.String r4 = "osv"
            r5.putString(r4, r3)
            com.google.firebase.messaging.Metadata r3 = r2.f24785b
            java.lang.String r3 = r3.a()
            java.lang.String r4 = "app_ver"
            r5.putString(r4, r3)
            com.google.firebase.messaging.Metadata r3 = r2.f24785b
            java.lang.String r3 = r3.b()
            java.lang.String r4 = "app_ver_name"
            r5.putString(r4, r3)
            java.lang.String r3 = "firebase-app-name-hash"
            java.lang.String r4 = r2.e()
            r5.putString(r3, r4)
            com.google.firebase.installations.FirebaseInstallationsApi r3 = r2.f24789f     // Catch:{ ExecutionException -> 0x0078, InterruptedException -> 0x0076 }
            r4 = 0
            com.google.android.gms.tasks.Task r3 = r3.c(r4)     // Catch:{ ExecutionException -> 0x0078, InterruptedException -> 0x0076 }
            java.lang.Object r3 = com.google.android.gms.tasks.Tasks.a(r3)     // Catch:{ ExecutionException -> 0x0078, InterruptedException -> 0x0076 }
            com.google.firebase.installations.InstallationTokenResult r3 = (com.google.firebase.installations.InstallationTokenResult) r3     // Catch:{ ExecutionException -> 0x0078, InterruptedException -> 0x0076 }
            java.lang.String r3 = r3.b()     // Catch:{ ExecutionException -> 0x0078, InterruptedException -> 0x0076 }
            boolean r4 = android.text.TextUtils.isEmpty(r3)     // Catch:{ ExecutionException -> 0x0078, InterruptedException -> 0x0076 }
            if (r4 != 0) goto L_0x007a
            java.lang.String r4 = "Goog-Firebase-Installations-Auth"
            r5.putString(r4, r3)     // Catch:{ ExecutionException -> 0x0078, InterruptedException -> 0x0076 }
            goto L_0x0085
        L_0x0076:
            r3 = move-exception
            goto L_0x0080
        L_0x0078:
            r3 = move-exception
            goto L_0x0080
        L_0x007a:
            java.lang.String r3 = "FIS auth token is empty"
            android.util.Log.w(r0, r3)     // Catch:{ ExecutionException -> 0x0078, InterruptedException -> 0x0076 }
            goto L_0x0085
        L_0x0080:
            java.lang.String r4 = "Failed to get FIS auth token"
            android.util.Log.e(r0, r4, r3)
        L_0x0085:
            com.google.firebase.installations.FirebaseInstallationsApi r3 = r2.f24789f
            com.google.android.gms.tasks.Task r3 = r3.getId()
            java.lang.Object r3 = com.google.android.gms.tasks.Tasks.a(r3)
            java.lang.String r3 = (java.lang.String) r3
            java.lang.String r4 = "appid"
            r5.putString(r4, r3)
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "fcm-"
            r3.append(r4)
            java.lang.String r4 = "24.0.0"
            r3.append(r4)
            java.lang.String r3 = r3.toString()
            java.lang.String r4 = "cliv"
            r5.putString(r4, r3)
            com.google.firebase.inject.Provider<com.google.firebase.heartbeatinfo.HeartBeatInfo> r3 = r2.f24788e
            java.lang.Object r3 = r3.get()
            com.google.firebase.heartbeatinfo.HeartBeatInfo r3 = (com.google.firebase.heartbeatinfo.HeartBeatInfo) r3
            com.google.firebase.inject.Provider<com.google.firebase.platforminfo.UserAgentPublisher> r4 = r2.f24787d
            java.lang.Object r4 = r4.get()
            com.google.firebase.platforminfo.UserAgentPublisher r4 = (com.google.firebase.platforminfo.UserAgentPublisher) r4
            if (r3 == 0) goto L_0x00e2
            if (r4 == 0) goto L_0x00e2
            java.lang.String r0 = "fire-iid"
            com.google.firebase.heartbeatinfo.HeartBeatInfo$HeartBeat r3 = r3.b(r0)
            com.google.firebase.heartbeatinfo.HeartBeatInfo$HeartBeat r0 = com.google.firebase.heartbeatinfo.HeartBeatInfo.HeartBeat.NONE
            if (r3 == r0) goto L_0x00e2
            int r3 = r3.b()
            java.lang.String r3 = java.lang.Integer.toString(r3)
            java.lang.String r0 = "Firebase-Client-Log-Type"
            r5.putString(r0, r3)
            java.lang.String r3 = "Firebase-Client"
            java.lang.String r4 = r4.a()
            r5.putString(r3, r4)
        L_0x00e2:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.messaging.GmsRpc.k(java.lang.String, java.lang.String, android.os.Bundle):void");
    }

    private Task<Bundle> m(String str, String str2, Bundle bundle) {
        try {
            k(str, str2, bundle);
            return this.f24786c.c(bundle);
        } catch (InterruptedException | ExecutionException e2) {
            return Tasks.f(e2);
        }
    }

    /* access modifiers changed from: package-private */
    public Task<?> c() {
        Bundle bundle = new Bundle();
        bundle.putString(u, IcyHeaders.a3);
        return d(m(Metadata.c(this.f24784a), K, bundle));
    }

    /* access modifiers changed from: package-private */
    public Task<CloudMessage> f() {
        return this.f24786c.a();
    }

    /* access modifiers changed from: package-private */
    public Task<String> g() {
        return d(m(Metadata.c(this.f24784a), K, new Bundle()));
    }

    /* access modifiers changed from: package-private */
    public Task<Void> l(boolean z2) {
        return this.f24786c.d(z2);
    }

    /* access modifiers changed from: package-private */
    public Task<?> n(String str, String str2) {
        Bundle bundle = new Bundle();
        bundle.putString(o, p + str2);
        return d(m(str, p + str2, bundle));
    }

    /* access modifiers changed from: package-private */
    public Task<?> o(String str, String str2) {
        Bundle bundle = new Bundle();
        bundle.putString(o, p + str2);
        bundle.putString(u, IcyHeaders.a3);
        return d(m(str, p + str2, bundle));
    }

    GmsRpc(FirebaseApp firebaseApp, Metadata metadata, Provider<UserAgentPublisher> provider, Provider<HeartBeatInfo> provider2, FirebaseInstallationsApi firebaseInstallationsApi) {
        this(firebaseApp, metadata, new Rpc(firebaseApp.n()), provider, provider2, firebaseInstallationsApi);
    }
}
