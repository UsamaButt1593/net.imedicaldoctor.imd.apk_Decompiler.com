package com.google.firebase.installations.remote;

import android.content.Context;
import android.content.pm.PackageManager;
import android.net.TrafficStats;
import android.text.TextUtils;
import android.util.JsonReader;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.AndroidUtilsLight;
import com.google.android.gms.common.util.Hex;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.heartbeatinfo.HeartBeatController;
import com.google.firebase.inject.Provider;
import com.google.firebase.installations.FirebaseInstallationsException;
import com.google.firebase.installations.remote.InstallationResponse;
import com.google.firebase.installations.remote.TokenResult;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.Charset;
import java.util.concurrent.ExecutionException;
import java.util.regex.Pattern;
import java.util.zip.GZIPOutputStream;
import org.json.JSONException;
import org.json.JSONObject;

public class FirebaseInstallationServiceClient {
    private static final String A = "x-goog-api-key";
    private static final int B = 10000;
    private static final Pattern C = Pattern.compile("[0-9]+s");
    private static final int D = 1;
    private static final Charset E = Charset.forName("UTF-8");
    private static final String F = "a:";
    private static final String G = "Firebase-Installations";
    @VisibleForTesting
    static final String H = "Invalid Expiration Timestamp.";

    /* renamed from: e  reason: collision with root package name */
    private static final int f24587e = 32768;

    /* renamed from: f  reason: collision with root package name */
    private static final int f24588f = 32769;

    /* renamed from: g  reason: collision with root package name */
    private static final int f24589g = 32770;

    /* renamed from: h  reason: collision with root package name */
    private static final int f24590h = 32771;

    /* renamed from: i  reason: collision with root package name */
    private static final String f24591i = "firebaseinstallations.googleapis.com";

    /* renamed from: j  reason: collision with root package name */
    private static final String f24592j = "projects/%s/installations";

    /* renamed from: k  reason: collision with root package name */
    private static final String f24593k = "projects/%s/installations/%s/authTokens:generate";

    /* renamed from: l  reason: collision with root package name */
    private static final String f24594l = "projects/%s/installations/%s";

    /* renamed from: m  reason: collision with root package name */
    private static final String f24595m = "v1";

    /* renamed from: n  reason: collision with root package name */
    private static final String f24596n = "FIS_v2";
    private static final String o = "Content-Type";
    private static final String p = "Accept";
    private static final String q = "application/json";
    private static final String r = "Content-Encoding";
    private static final String s = "gzip";
    private static final String t = "Cache-Control";
    private static final String u = "no-cache";
    private static final String v = "fire-installations-id";
    private static final String w = "x-firebase-client";
    private static final String x = "X-Android-Package";
    private static final String y = "X-Android-Cert";
    private static final String z = "x-goog-fis-android-iid-migration-auth";

    /* renamed from: a  reason: collision with root package name */
    private boolean f24597a;

    /* renamed from: b  reason: collision with root package name */
    private final Context f24598b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<HeartBeatController> f24599c;

    /* renamed from: d  reason: collision with root package name */
    private final RequestLimiter f24600d = new RequestLimiter();

    public FirebaseInstallationServiceClient(@NonNull Context context, @NonNull Provider<HeartBeatController> provider) {
        this.f24598b = context;
        this.f24599c = provider;
    }

    private static String a(@Nullable String str, @NonNull String str2, @NonNull String str3) {
        String str4;
        if (TextUtils.isEmpty(str)) {
            str4 = "";
        } else {
            str4 = ", " + str;
        }
        return String.format("Firebase options used while communicating with Firebase server APIs: %s, %s%s", new Object[]{str2, str3, str4});
    }

    private static JSONObject b(@Nullable String str, @NonNull String str2) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("fid", str);
            jSONObject.put("appId", str2);
            jSONObject.put("authVersion", f24596n);
            jSONObject.put("sdkVersion", "a:18.0.0");
            return jSONObject;
        } catch (JSONException e2) {
            throw new IllegalStateException(e2);
        }
    }

    private static JSONObject c() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("sdkVersion", "a:18.0.0");
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("installation", jSONObject);
            return jSONObject2;
        } catch (JSONException e2) {
            throw new IllegalStateException(e2);
        }
    }

    private String g() {
        try {
            Context context = this.f24598b;
            byte[] a2 = AndroidUtilsLight.a(context, context.getPackageName());
            if (a2 != null) {
                return Hex.c(a2, false);
            }
            Log.e("ContentValues", "Could not get fingerprint hash for package: " + this.f24598b.getPackageName());
            return null;
        } catch (PackageManager.NameNotFoundException e2) {
            Log.e("ContentValues", "No such package: " + this.f24598b.getPackageName(), e2);
            return null;
        }
    }

    private URL h(String str) throws FirebaseInstallationsException {
        try {
            return new URL(String.format("https://%s/%s/%s", new Object[]{f24591i, f24595m, str}));
        } catch (MalformedURLException e2) {
            throw new FirebaseInstallationsException(e2.getMessage(), FirebaseInstallationsException.Status.UNAVAILABLE);
        }
    }

    private static byte[] i(JSONObject jSONObject) throws IOException {
        return jSONObject.toString().getBytes("UTF-8");
    }

    private static boolean j(int i2) {
        return i2 >= 200 && i2 < 300;
    }

    private static void k() {
        Log.e(G, "Firebase Installations can not communicate with Firebase server APIs due to invalid configuration. Please update your Firebase initialization process and set valid Firebase options (API key, Project ID, Application ID) when initializing Firebase.");
    }

    private static void l(HttpURLConnection httpURLConnection, @Nullable String str, @NonNull String str2, @NonNull String str3) {
        String p2 = p(httpURLConnection);
        if (!TextUtils.isEmpty(p2)) {
            Log.w(G, p2);
            Log.w(G, a(str, str2, str3));
        }
    }

    private HttpURLConnection m(URL url, String str) throws FirebaseInstallationsException {
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setConnectTimeout(10000);
            httpURLConnection.setUseCaches(false);
            httpURLConnection.setReadTimeout(10000);
            httpURLConnection.addRequestProperty("Content-Type", q);
            httpURLConnection.addRequestProperty("Accept", q);
            httpURLConnection.addRequestProperty("Content-Encoding", s);
            httpURLConnection.addRequestProperty("Cache-Control", u);
            httpURLConnection.addRequestProperty(x, this.f24598b.getPackageName());
            HeartBeatController heartBeatController = this.f24599c.get();
            if (heartBeatController != null) {
                try {
                    httpURLConnection.addRequestProperty(w, (String) Tasks.a(heartBeatController.a()));
                } catch (ExecutionException e2) {
                    e = e2;
                } catch (InterruptedException e3) {
                    e = e3;
                    Thread.currentThread().interrupt();
                }
            }
            httpURLConnection.addRequestProperty(y, g());
            httpURLConnection.addRequestProperty(A, str);
            return httpURLConnection;
            Log.w("ContentValues", "Failed to get heartbeats header", e);
            httpURLConnection.addRequestProperty(y, g());
            httpURLConnection.addRequestProperty(A, str);
            return httpURLConnection;
        } catch (IOException unused) {
            throw new FirebaseInstallationsException("Firebase Installations Service is unavailable. Please try again later.", FirebaseInstallationsException.Status.UNAVAILABLE);
        }
    }

    @VisibleForTesting
    static long n(String str) {
        Preconditions.b(C.matcher(str).matches(), H);
        if (str == null || str.length() == 0) {
            return 0;
        }
        return Long.parseLong(str.substring(0, str.length() - 1));
    }

    private InstallationResponse o(HttpURLConnection httpURLConnection) throws AssertionError, IOException {
        InputStream inputStream = httpURLConnection.getInputStream();
        JsonReader jsonReader = new JsonReader(new InputStreamReader(inputStream, E));
        TokenResult.Builder a2 = TokenResult.a();
        InstallationResponse.Builder a3 = InstallationResponse.a();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            if (nextName.equals("name")) {
                a3.f(jsonReader.nextString());
            } else if (nextName.equals("fid")) {
                a3.c(jsonReader.nextString());
            } else if (nextName.equals("refreshToken")) {
                a3.d(jsonReader.nextString());
            } else if (nextName.equals("authToken")) {
                jsonReader.beginObject();
                while (jsonReader.hasNext()) {
                    String nextName2 = jsonReader.nextName();
                    if (nextName2.equals("token")) {
                        a2.c(jsonReader.nextString());
                    } else if (nextName2.equals("expiresIn")) {
                        a2.d(n(jsonReader.nextString()));
                    } else {
                        jsonReader.skipValue();
                    }
                }
                a3.b(a2.a());
                jsonReader.endObject();
            } else {
                jsonReader.skipValue();
            }
        }
        jsonReader.endObject();
        jsonReader.close();
        inputStream.close();
        return a3.e(InstallationResponse.ResponseCode.OK).a();
    }

    /* JADX WARNING: Missing exception handler attribute for start block: B:20:0x0050 */
    @androidx.annotation.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.lang.String p(java.net.HttpURLConnection r7) {
        /*
            java.io.InputStream r0 = r7.getErrorStream()
            r1 = 0
            if (r0 != 0) goto L_0x0008
            return r1
        L_0x0008:
            java.io.BufferedReader r2 = new java.io.BufferedReader
            java.io.InputStreamReader r3 = new java.io.InputStreamReader
            java.nio.charset.Charset r4 = E
            r3.<init>(r0, r4)
            r2.<init>(r3)
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x0050, all -> 0x0028 }
            r0.<init>()     // Catch:{ IOException -> 0x0050, all -> 0x0028 }
        L_0x0019:
            java.lang.String r3 = r2.readLine()     // Catch:{ IOException -> 0x0050, all -> 0x0028 }
            if (r3 == 0) goto L_0x002a
            r0.append(r3)     // Catch:{ IOException -> 0x0050, all -> 0x0028 }
            r3 = 10
            r0.append(r3)     // Catch:{ IOException -> 0x0050, all -> 0x0028 }
            goto L_0x0019
        L_0x0028:
            r7 = move-exception
            goto L_0x004c
        L_0x002a:
            java.lang.String r3 = "Error when communicating with the Firebase Installations server API. HTTP response: [%d %s: %s]"
            int r4 = r7.getResponseCode()     // Catch:{ IOException -> 0x0050, all -> 0x0028 }
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)     // Catch:{ IOException -> 0x0050, all -> 0x0028 }
            java.lang.String r7 = r7.getResponseMessage()     // Catch:{ IOException -> 0x0050, all -> 0x0028 }
            r5 = 3
            java.lang.Object[] r5 = new java.lang.Object[r5]     // Catch:{ IOException -> 0x0050, all -> 0x0028 }
            r6 = 0
            r5[r6] = r4     // Catch:{ IOException -> 0x0050, all -> 0x0028 }
            r4 = 1
            r5[r4] = r7     // Catch:{ IOException -> 0x0050, all -> 0x0028 }
            r7 = 2
            r5[r7] = r0     // Catch:{ IOException -> 0x0050, all -> 0x0028 }
            java.lang.String r7 = java.lang.String.format(r3, r5)     // Catch:{ IOException -> 0x0050, all -> 0x0028 }
            r2.close()     // Catch:{ IOException -> 0x004b }
        L_0x004b:
            return r7
        L_0x004c:
            r2.close()     // Catch:{ IOException -> 0x004f }
        L_0x004f:
            throw r7
        L_0x0050:
            r2.close()     // Catch:{ IOException -> 0x0053 }
        L_0x0053:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.installations.remote.FirebaseInstallationServiceClient.p(java.net.HttpURLConnection):java.lang.String");
    }

    private TokenResult q(HttpURLConnection httpURLConnection) throws AssertionError, IOException {
        InputStream inputStream = httpURLConnection.getInputStream();
        JsonReader jsonReader = new JsonReader(new InputStreamReader(inputStream, E));
        TokenResult.Builder a2 = TokenResult.a();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            if (nextName.equals("token")) {
                a2.c(jsonReader.nextString());
            } else if (nextName.equals("expiresIn")) {
                a2.d(n(jsonReader.nextString()));
            } else {
                jsonReader.skipValue();
            }
        }
        jsonReader.endObject();
        jsonReader.close();
        inputStream.close();
        return a2.b(TokenResult.ResponseCode.OK).a();
    }

    private void r(HttpURLConnection httpURLConnection, @Nullable String str, @NonNull String str2) throws IOException {
        t(httpURLConnection, i(b(str, str2)));
    }

    private void s(HttpURLConnection httpURLConnection) throws IOException {
        t(httpURLConnection, i(c()));
    }

    private static void t(URLConnection uRLConnection, byte[] bArr) throws IOException {
        OutputStream outputStream = uRLConnection.getOutputStream();
        if (outputStream != null) {
            GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(outputStream);
            try {
                gZIPOutputStream.write(bArr);
            } finally {
                try {
                    gZIPOutputStream.close();
                    outputStream.close();
                } catch (IOException unused) {
                }
            }
        } else {
            throw new IOException("Cannot send request to FIS servers. No OutputStream available.");
        }
    }

    @NonNull
    public InstallationResponse d(@NonNull String str, @Nullable String str2, @NonNull String str3, @NonNull String str4, @Nullable String str5) throws FirebaseInstallationsException {
        InstallationResponse o2;
        int i2 = 0;
        if (this.f24600d.b()) {
            URL h2 = h(String.format(f24592j, new Object[]{str3}));
            while (i2 <= 1) {
                TrafficStats.setThreadStatsTag(f24588f);
                HttpURLConnection m2 = m(h2, str);
                try {
                    m2.setRequestMethod("POST");
                    m2.setDoOutput(true);
                    if (str5 != null) {
                        m2.addRequestProperty(z, str5);
                    }
                    r(m2, str2, str4);
                    int responseCode = m2.getResponseCode();
                    this.f24600d.f(responseCode);
                    if (j(responseCode)) {
                        o2 = o(m2);
                    } else {
                        l(m2, str4, str, str3);
                        if (responseCode != 429) {
                            if (responseCode < 500 || responseCode >= 600) {
                                k();
                                o2 = InstallationResponse.a().e(InstallationResponse.ResponseCode.BAD_CONFIG).a();
                            }
                            m2.disconnect();
                            TrafficStats.clearThreadStatsTag();
                            i2++;
                        } else {
                            throw new FirebaseInstallationsException("Firebase servers have received too many requests from this client in a short period of time. Please try again later.", FirebaseInstallationsException.Status.TOO_MANY_REQUESTS);
                        }
                    }
                    m2.disconnect();
                    TrafficStats.clearThreadStatsTag();
                    return o2;
                } catch (IOException | AssertionError unused) {
                } catch (Throwable th) {
                    m2.disconnect();
                    TrafficStats.clearThreadStatsTag();
                    throw th;
                }
            }
            throw new FirebaseInstallationsException("Firebase Installations Service is unavailable. Please try again later.", FirebaseInstallationsException.Status.UNAVAILABLE);
        }
        throw new FirebaseInstallationsException("Firebase Installations Service is unavailable. Please try again later.", FirebaseInstallationsException.Status.UNAVAILABLE);
    }

    @NonNull
    public void e(@NonNull String str, @NonNull String str2, @NonNull String str3, @NonNull String str4) throws FirebaseInstallationsException {
        int i2 = 0;
        URL h2 = h(String.format(f24594l, new Object[]{str3, str2}));
        while (i2 <= 1) {
            TrafficStats.setThreadStatsTag(f24589g);
            HttpURLConnection m2 = m(h2, str);
            try {
                m2.setRequestMethod("DELETE");
                m2.addRequestProperty("Authorization", "FIS_v2 " + str4);
                int responseCode = m2.getResponseCode();
                if (!(responseCode == 200 || responseCode == 401)) {
                    if (responseCode != 404) {
                        l(m2, (String) null, str, str3);
                        if (responseCode == 429) {
                            continue;
                        } else if (responseCode < 500 || responseCode >= 600) {
                            k();
                            throw new FirebaseInstallationsException("Bad config while trying to delete FID", FirebaseInstallationsException.Status.BAD_CONFIG);
                        }
                        i2++;
                        m2.disconnect();
                        TrafficStats.clearThreadStatsTag();
                    }
                }
                m2.disconnect();
                TrafficStats.clearThreadStatsTag();
                return;
            } catch (IOException unused) {
            } catch (Throwable th) {
                m2.disconnect();
                TrafficStats.clearThreadStatsTag();
                throw th;
            }
        }
        throw new FirebaseInstallationsException("Firebase Installations Service is unavailable. Please try again later.", FirebaseInstallationsException.Status.UNAVAILABLE);
    }

    @NonNull
    public TokenResult f(@NonNull String str, @NonNull String str2, @NonNull String str3, @NonNull String str4) throws FirebaseInstallationsException {
        TokenResult q2;
        TokenResult.Builder b2;
        int i2 = 0;
        if (this.f24600d.b()) {
            URL h2 = h(String.format(f24593k, new Object[]{str3, str2}));
            while (i2 <= 1) {
                TrafficStats.setThreadStatsTag(32771);
                HttpURLConnection m2 = m(h2, str);
                try {
                    m2.setRequestMethod("POST");
                    m2.addRequestProperty("Authorization", "FIS_v2 " + str4);
                    m2.setDoOutput(true);
                    s(m2);
                    int responseCode = m2.getResponseCode();
                    this.f24600d.f(responseCode);
                    if (j(responseCode)) {
                        q2 = q(m2);
                    } else {
                        l(m2, (String) null, str, str3);
                        if (responseCode == 401 || responseCode == 404) {
                            b2 = TokenResult.a().b(TokenResult.ResponseCode.AUTH_ERROR);
                        } else if (responseCode != 429) {
                            if (responseCode < 500 || responseCode >= 600) {
                                k();
                                b2 = TokenResult.a().b(TokenResult.ResponseCode.BAD_CONFIG);
                            }
                            m2.disconnect();
                            TrafficStats.clearThreadStatsTag();
                            i2++;
                        } else {
                            throw new FirebaseInstallationsException("Firebase servers have received too many requests from this client in a short period of time. Please try again later.", FirebaseInstallationsException.Status.TOO_MANY_REQUESTS);
                        }
                        q2 = b2.a();
                    }
                    m2.disconnect();
                    TrafficStats.clearThreadStatsTag();
                    return q2;
                } catch (IOException | AssertionError unused) {
                } catch (Throwable th) {
                    m2.disconnect();
                    TrafficStats.clearThreadStatsTag();
                    throw th;
                }
            }
            throw new FirebaseInstallationsException("Firebase Installations Service is unavailable. Please try again later.", FirebaseInstallationsException.Status.UNAVAILABLE);
        }
        throw new FirebaseInstallationsException("Firebase Installations Service is unavailable. Please try again later.", FirebaseInstallationsException.Status.UNAVAILABLE);
    }
}
