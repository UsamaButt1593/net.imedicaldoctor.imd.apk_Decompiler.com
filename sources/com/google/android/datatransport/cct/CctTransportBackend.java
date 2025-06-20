package com.google.android.datatransport.cct;

import android.content.Context;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.telephony.TelephonyManager;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.google.android.datatransport.Encoding;
import com.google.android.datatransport.cct.internal.AndroidClientInfo;
import com.google.android.datatransport.cct.internal.BatchedLogRequest;
import com.google.android.datatransport.cct.internal.ClientInfo;
import com.google.android.datatransport.cct.internal.ComplianceData;
import com.google.android.datatransport.cct.internal.ExperimentIds;
import com.google.android.datatransport.cct.internal.ExternalPRequestContext;
import com.google.android.datatransport.cct.internal.ExternalPrivacyContext;
import com.google.android.datatransport.cct.internal.LogEvent;
import com.google.android.datatransport.cct.internal.LogRequest;
import com.google.android.datatransport.cct.internal.LogResponse;
import com.google.android.datatransport.cct.internal.NetworkConnectionInfo;
import com.google.android.datatransport.cct.internal.QosTier;
import com.google.android.datatransport.runtime.EncodedPayload;
import com.google.android.datatransport.runtime.EventInternal;
import com.google.android.datatransport.runtime.backends.BackendRequest;
import com.google.android.datatransport.runtime.backends.BackendResponse;
import com.google.android.datatransport.runtime.backends.TransportBackend;
import com.google.android.datatransport.runtime.logging.Logging;
import com.google.android.datatransport.runtime.retries.Retries;
import com.google.android.datatransport.runtime.time.Clock;
import com.google.common.net.HttpHeaders;
import com.google.firebase.encoders.DataEncoder;
import com.google.firebase.encoders.EncodingException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ConnectException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.UnknownHostException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

final class CctTransportBackend implements TransportBackend {
    private static final String A = "fingerprint";
    private static final String B = "locale";
    private static final String C = "country";
    private static final String D = "mcc_mnc";
    private static final String E = "tz-offset";
    private static final String F = "application_build";

    /* renamed from: h  reason: collision with root package name */
    private static final String f19223h = "CctTransportBackend";

    /* renamed from: i  reason: collision with root package name */
    private static final int f19224i = 30000;

    /* renamed from: j  reason: collision with root package name */
    private static final int f19225j = 130000;

    /* renamed from: k  reason: collision with root package name */
    private static final int f19226k = -1;

    /* renamed from: l  reason: collision with root package name */
    private static final String f19227l = "Accept-Encoding";

    /* renamed from: m  reason: collision with root package name */
    private static final String f19228m = "Content-Encoding";

    /* renamed from: n  reason: collision with root package name */
    private static final String f19229n = "gzip";
    private static final String o = "Content-Type";
    static final String p = "X-Goog-Api-Key";
    private static final String q = "application/json";
    @VisibleForTesting
    static final String r = "net-type";
    @VisibleForTesting
    static final String s = "mobile-subtype";
    private static final String t = "sdk-version";
    private static final String u = "model";
    private static final String v = "hardware";
    private static final String w = "device";
    private static final String x = "product";
    private static final String y = "os-uild";
    private static final String z = "manufacturer";

    /* renamed from: a  reason: collision with root package name */
    private final DataEncoder f19230a;

    /* renamed from: b  reason: collision with root package name */
    private final ConnectivityManager f19231b;

    /* renamed from: c  reason: collision with root package name */
    private final Context f19232c;

    /* renamed from: d  reason: collision with root package name */
    final URL f19233d;

    /* renamed from: e  reason: collision with root package name */
    private final Clock f19234e;

    /* renamed from: f  reason: collision with root package name */
    private final Clock f19235f;

    /* renamed from: g  reason: collision with root package name */
    private final int f19236g;

    static final class HttpRequest {

        /* renamed from: a  reason: collision with root package name */
        final URL f19237a;

        /* renamed from: b  reason: collision with root package name */
        final BatchedLogRequest f19238b;
        @Nullable

        /* renamed from: c  reason: collision with root package name */
        final String f19239c;

        HttpRequest(URL url, BatchedLogRequest batchedLogRequest, @Nullable String str) {
            this.f19237a = url;
            this.f19238b = batchedLogRequest;
            this.f19239c = str;
        }

        /* access modifiers changed from: package-private */
        public HttpRequest a(URL url) {
            return new HttpRequest(url, this.f19238b, this.f19239c);
        }
    }

    static final class HttpResponse {

        /* renamed from: a  reason: collision with root package name */
        final int f19240a;
        @Nullable

        /* renamed from: b  reason: collision with root package name */
        final URL f19241b;

        /* renamed from: c  reason: collision with root package name */
        final long f19242c;

        HttpResponse(int i2, @Nullable URL url, long j2) {
            this.f19240a = i2;
            this.f19241b = url;
            this.f19242c = j2;
        }
    }

    CctTransportBackend(Context context, Clock clock, Clock clock2) {
        this(context, clock, clock2, f19225j);
    }

    /* access modifiers changed from: private */
    public HttpResponse e(HttpRequest httpRequest) throws IOException {
        OutputStream outputStream;
        GZIPOutputStream gZIPOutputStream;
        InputStream n2;
        Logging.h(f19223h, "Making request to: %s", httpRequest.f19237a);
        HttpURLConnection httpURLConnection = (HttpURLConnection) httpRequest.f19237a.openConnection();
        httpURLConnection.setConnectTimeout(f19224i);
        httpURLConnection.setReadTimeout(this.f19236g);
        httpURLConnection.setDoOutput(true);
        httpURLConnection.setInstanceFollowRedirects(false);
        httpURLConnection.setRequestMethod("POST");
        httpURLConnection.setRequestProperty(HttpHeaders.P, String.format("datatransport/%s android/", new Object[]{"3.3.0"}));
        httpURLConnection.setRequestProperty("Content-Encoding", f19229n);
        httpURLConnection.setRequestProperty("Content-Type", q);
        httpURLConnection.setRequestProperty("Accept-Encoding", f19229n);
        String str = httpRequest.f19239c;
        if (str != null) {
            httpURLConnection.setRequestProperty(p, str);
        }
        try {
            outputStream = httpURLConnection.getOutputStream();
            gZIPOutputStream = new GZIPOutputStream(outputStream);
            this.f19230a.a(httpRequest.f19238b, new BufferedWriter(new OutputStreamWriter(gZIPOutputStream)));
            gZIPOutputStream.close();
            if (outputStream != null) {
                outputStream.close();
            }
            int responseCode = httpURLConnection.getResponseCode();
            Logging.h(f19223h, "Status Code: %d", Integer.valueOf(responseCode));
            Logging.c(f19223h, "Content-Type: %s", httpURLConnection.getHeaderField("Content-Type"));
            Logging.c(f19223h, "Content-Encoding: %s", httpURLConnection.getHeaderField("Content-Encoding"));
            if (responseCode == 302 || responseCode == 301 || responseCode == 307) {
                return new HttpResponse(responseCode, new URL(httpURLConnection.getHeaderField(HttpHeaders.t0)), 0);
            }
            if (responseCode != 200) {
                return new HttpResponse(responseCode, (URL) null, 0);
            }
            InputStream inputStream = httpURLConnection.getInputStream();
            try {
                n2 = n(inputStream, httpURLConnection.getHeaderField("Content-Encoding"));
                HttpResponse httpResponse = new HttpResponse(responseCode, (URL) null, LogResponse.b(new BufferedReader(new InputStreamReader(n2))).c());
                if (n2 != null) {
                    n2.close();
                }
                if (inputStream != null) {
                    inputStream.close();
                }
                return httpResponse;
            } catch (Throwable th) {
                th.addSuppressed(th);
            }
            throw th;
            throw th;
            throw th;
            throw th;
        } catch (ConnectException | UnknownHostException e2) {
            Logging.f(f19223h, "Couldn't open connection, returning with 500", e2);
            return new HttpResponse(500, (URL) null, 0);
        } catch (EncodingException | IOException e3) {
            Logging.f(f19223h, "Couldn't encode request, returning with 400", e3);
            return new HttpResponse(400, (URL) null, 0);
        } catch (Throwable th2) {
            th.addSuppressed(th2);
        }
    }

    private static String f(Context context) {
        String simOperator = k(context).getSimOperator();
        return simOperator != null ? simOperator : "";
    }

    private static int g(NetworkInfo networkInfo) {
        NetworkConnectionInfo.MobileSubtype mobileSubtype;
        if (networkInfo == null) {
            mobileSubtype = NetworkConnectionInfo.MobileSubtype.UNKNOWN_MOBILE_SUBTYPE;
        } else {
            int subtype = networkInfo.getSubtype();
            if (subtype == -1) {
                mobileSubtype = NetworkConnectionInfo.MobileSubtype.COMBINED;
            } else if (NetworkConnectionInfo.MobileSubtype.a(subtype) != null) {
                return subtype;
            } else {
                return 0;
            }
        }
        return mobileSubtype.b();
    }

    private static int h(NetworkInfo networkInfo) {
        return networkInfo == null ? NetworkConnectionInfo.NetworkType.NONE.b() : networkInfo.getType();
    }

    private static int i(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode;
        } catch (PackageManager.NameNotFoundException e2) {
            Logging.f(f19223h, "Unable to find version code for package", e2);
            return -1;
        }
    }

    private BatchedLogRequest j(BackendRequest backendRequest) {
        LogEvent.Builder builder;
        HashMap hashMap = new HashMap();
        for (EventInternal next : backendRequest.c()) {
            String p2 = next.p();
            if (!hashMap.containsKey(p2)) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(next);
                hashMap.put(p2, arrayList);
            } else {
                ((List) hashMap.get(p2)).add(next);
            }
        }
        ArrayList arrayList2 = new ArrayList();
        for (Map.Entry entry : hashMap.entrySet()) {
            EventInternal eventInternal = (EventInternal) ((List) entry.getValue()).get(0);
            LogRequest.Builder b2 = LogRequest.a().f(QosTier.DEFAULT).g(this.f19235f.a()).h(this.f19234e.a()).b(ClientInfo.a().c(ClientInfo.ClientType.ANDROID_FIREBASE).b(AndroidClientInfo.a().m(Integer.valueOf(eventInternal.i(t))).j(eventInternal.b(u)).f(eventInternal.b(v)).d(eventInternal.b(w)).l(eventInternal.b(x)).k(eventInternal.b(y)).h(eventInternal.b(z)).e(eventInternal.b(A)).c(eventInternal.b(C)).g(eventInternal.b(B)).i(eventInternal.b(D)).b(eventInternal.b(F)).a()).a());
            try {
                b2.i(Integer.parseInt((String) entry.getKey()));
            } catch (NumberFormatException unused) {
                b2.j((String) entry.getKey());
            }
            ArrayList arrayList3 = new ArrayList();
            for (EventInternal eventInternal2 : (List) entry.getValue()) {
                EncodedPayload e2 = eventInternal2.e();
                Encoding b3 = e2.b();
                if (b3.equals(Encoding.b("proto"))) {
                    builder = LogEvent.l(e2.a());
                } else if (b3.equals(Encoding.b("json"))) {
                    builder = LogEvent.k(new String(e2.a(), Charset.forName("UTF-8")));
                } else {
                    Logging.i(f19223h, "Received event of unsupported encoding %s. Skipping...", b3);
                }
                builder.d(eventInternal2.f()).e(eventInternal2.q()).j(eventInternal2.j(E)).g(NetworkConnectionInfo.a().c(NetworkConnectionInfo.NetworkType.a(eventInternal2.i(r))).b(NetworkConnectionInfo.MobileSubtype.a(eventInternal2.i(s))).a());
                if (eventInternal2.d() != null) {
                    builder.c(eventInternal2.d());
                }
                if (eventInternal2.n() != null) {
                    builder.b(ComplianceData.a().b(ExternalPrivacyContext.a().b(ExternalPRequestContext.a().b(eventInternal2.n()).a()).a()).c(ComplianceData.ProductIdOrigin.EVENT_OVERRIDE).a());
                }
                if (!(eventInternal2.g() == null && eventInternal2.h() == null)) {
                    ExperimentIds.Builder a2 = ExperimentIds.a();
                    if (eventInternal2.g() != null) {
                        a2.b(eventInternal2.g());
                    }
                    if (eventInternal2.h() != null) {
                        a2.c(eventInternal2.h());
                    }
                    builder.f(a2.a());
                }
                arrayList3.add(builder.a());
            }
            b2.c(arrayList3);
            arrayList2.add(b2.a());
        }
        return BatchedLogRequest.a(arrayList2);
    }

    private static TelephonyManager k(Context context) {
        return (TelephonyManager) context.getSystemService("phone");
    }

    @VisibleForTesting
    static long l() {
        Calendar.getInstance();
        return (long) (TimeZone.getDefault().getOffset(Calendar.getInstance().getTimeInMillis()) / 1000);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ HttpRequest m(HttpRequest httpRequest, HttpResponse httpResponse) {
        URL url = httpResponse.f19241b;
        if (url == null) {
            return null;
        }
        Logging.c(f19223h, "Following redirect to: %s", url);
        return httpRequest.a(httpResponse.f19241b);
    }

    private static InputStream n(InputStream inputStream, String str) throws IOException {
        return f19229n.equals(str) ? new GZIPInputStream(inputStream) : inputStream;
    }

    private static URL o(String str) {
        try {
            return new URL(str);
        } catch (MalformedURLException e2) {
            throw new IllegalArgumentException("Invalid url: " + str, e2);
        }
    }

    public BackendResponse a(BackendRequest backendRequest) {
        BatchedLogRequest j2 = j(backendRequest);
        URL url = this.f19233d;
        String str = null;
        if (backendRequest.d() != null) {
            try {
                CCTDestination e2 = CCTDestination.e(backendRequest.d());
                if (e2.f() != null) {
                    str = e2.f();
                }
                if (e2.g() != null) {
                    url = o(e2.g());
                }
            } catch (IllegalArgumentException unused) {
                return BackendResponse.a();
            }
        }
        try {
            HttpResponse httpResponse = (HttpResponse) Retries.a(5, new HttpRequest(url, j2, str), new a(this), new b());
            int i2 = httpResponse.f19240a;
            if (i2 == 200) {
                return BackendResponse.e(httpResponse.f19242c);
            }
            if (i2 < 500) {
                if (i2 != 404) {
                    return i2 == 400 ? BackendResponse.d() : BackendResponse.a();
                }
            }
            return BackendResponse.f();
        } catch (IOException e3) {
            Logging.f(f19223h, "Could not make request to the backend", e3);
            return BackendResponse.f();
        }
    }

    public EventInternal b(EventInternal eventInternal) {
        NetworkInfo activeNetworkInfo = this.f19231b.getActiveNetworkInfo();
        return eventInternal.r().a(t, Build.VERSION.SDK_INT).c(u, Build.MODEL).c(v, Build.HARDWARE).c(w, Build.DEVICE).c(x, Build.PRODUCT).c(y, Build.ID).c(z, Build.MANUFACTURER).c(A, Build.FINGERPRINT).b(E, l()).a(r, h(activeNetworkInfo)).a(s, g(activeNetworkInfo)).c(C, Locale.getDefault().getCountry()).c(B, Locale.getDefault().getLanguage()).c(D, f(this.f19232c)).c(F, Integer.toString(i(this.f19232c))).d();
    }

    CctTransportBackend(Context context, Clock clock, Clock clock2, int i2) {
        this.f19230a = BatchedLogRequest.b();
        this.f19232c = context;
        this.f19231b = (ConnectivityManager) context.getSystemService("connectivity");
        this.f19233d = o(CCTDestination.f19213d);
        this.f19234e = clock2;
        this.f19235f = clock;
        this.f19236g = i2;
    }
}
