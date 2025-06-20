package com.google.firebase.crashlytics.internal.network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

public class HttpGetRequest {

    /* renamed from: d  reason: collision with root package name */
    private static final String f24185d = "GET";

    /* renamed from: e  reason: collision with root package name */
    private static final int f24186e = 10000;

    /* renamed from: f  reason: collision with root package name */
    private static final int f24187f = 8192;

    /* renamed from: a  reason: collision with root package name */
    private final String f24188a;

    /* renamed from: b  reason: collision with root package name */
    private final Map<String, String> f24189b;

    /* renamed from: c  reason: collision with root package name */
    private final Map<String, String> f24190c = new HashMap();

    public HttpGetRequest(String str, Map<String, String> map) {
        this.f24188a = str;
        this.f24189b = map;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:1:0x0029, code lost:
        if (r1.getValue() != null) goto L_0x002b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:2:0x002b, code lost:
        r1 = java.net.URLEncoder.encode((java.lang.String) r1.getValue(), "UTF-8");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0036, code lost:
        r1 = "";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:4:0x0037, code lost:
        r0.append(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:5:0x003e, code lost:
        if (r7.hasNext() == false) goto L_0x005e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0040, code lost:
        r1 = r7.next();
        r0.append("&");
        r0.append((java.lang.String) r1.getKey());
        r0.append("=");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x005b, code lost:
        if (r1.getValue() == null) goto L_0x0036;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0062, code lost:
        return r0.toString();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.lang.String a(java.util.Map<java.lang.String, java.lang.String> r7) throws java.io.UnsupportedEncodingException {
        /*
            r6 = this;
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.util.Set r7 = r7.entrySet()
            java.util.Iterator r7 = r7.iterator()
            java.lang.Object r1 = r7.next()
            java.util.Map$Entry r1 = (java.util.Map.Entry) r1
            java.lang.Object r2 = r1.getKey()
            java.lang.String r2 = (java.lang.String) r2
            r0.append(r2)
            java.lang.String r2 = "="
            r0.append(r2)
            java.lang.Object r3 = r1.getValue()
            java.lang.String r4 = ""
            java.lang.String r5 = "UTF-8"
            if (r3 == 0) goto L_0x0036
        L_0x002b:
            java.lang.Object r1 = r1.getValue()
            java.lang.String r1 = (java.lang.String) r1
            java.lang.String r1 = java.net.URLEncoder.encode(r1, r5)
            goto L_0x0037
        L_0x0036:
            r1 = r4
        L_0x0037:
            r0.append(r1)
            boolean r1 = r7.hasNext()
            if (r1 == 0) goto L_0x005e
            java.lang.Object r1 = r7.next()
            java.util.Map$Entry r1 = (java.util.Map.Entry) r1
            java.lang.String r3 = "&"
            r0.append(r3)
            java.lang.Object r3 = r1.getKey()
            java.lang.String r3 = (java.lang.String) r3
            r0.append(r3)
            r0.append(r2)
            java.lang.Object r3 = r1.getValue()
            if (r3 == 0) goto L_0x0036
            goto L_0x002b
        L_0x005e:
            java.lang.String r7 = r0.toString()
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.crashlytics.internal.network.HttpGetRequest.a(java.util.Map):java.lang.String");
    }

    private String b(String str, Map<String, String> map) throws UnsupportedEncodingException {
        String a2 = a(map);
        if (a2.isEmpty()) {
            return str;
        }
        if (str.contains("?")) {
            if (!str.endsWith("&")) {
                a2 = "&" + a2;
            }
            return str + a2;
        }
        return str + "?" + a2;
    }

    private String f(InputStream inputStream) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
        char[] cArr = new char[8192];
        StringBuilder sb = new StringBuilder();
        while (true) {
            int read = bufferedReader.read(cArr);
            if (read == -1) {
                return sb.toString();
            }
            sb.append(cArr, 0, read);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v2, resolved type: java.lang.String} */
    /* JADX WARNING: type inference failed for: r0v0 */
    /* JADX WARNING: type inference failed for: r0v1, types: [java.io.InputStream] */
    /* JADX WARNING: type inference failed for: r0v3 */
    /* JADX WARNING: type inference failed for: r0v5 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0088  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x008d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.google.firebase.crashlytics.internal.network.HttpResponse c() throws java.io.IOException {
        /*
            r5 = this;
            r0 = 0
            java.lang.String r1 = r5.f24188a     // Catch:{ all -> 0x0084 }
            java.util.Map<java.lang.String, java.lang.String> r2 = r5.f24189b     // Catch:{ all -> 0x0084 }
            java.lang.String r1 = r5.b(r1, r2)     // Catch:{ all -> 0x0084 }
            com.google.firebase.crashlytics.internal.Logger r2 = com.google.firebase.crashlytics.internal.Logger.f()     // Catch:{ all -> 0x0084 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x0084 }
            r3.<init>()     // Catch:{ all -> 0x0084 }
            java.lang.String r4 = "GET Request URL: "
            r3.append(r4)     // Catch:{ all -> 0x0084 }
            r3.append(r1)     // Catch:{ all -> 0x0084 }
            java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x0084 }
            r2.k(r3)     // Catch:{ all -> 0x0084 }
            java.net.URL r2 = new java.net.URL     // Catch:{ all -> 0x0084 }
            r2.<init>(r1)     // Catch:{ all -> 0x0084 }
            java.net.URLConnection r1 = r2.openConnection()     // Catch:{ all -> 0x0084 }
            javax.net.ssl.HttpsURLConnection r1 = (javax.net.ssl.HttpsURLConnection) r1     // Catch:{ all -> 0x0084 }
            r2 = 10000(0x2710, float:1.4013E-41)
            r1.setReadTimeout(r2)     // Catch:{ all -> 0x005f }
            r1.setConnectTimeout(r2)     // Catch:{ all -> 0x005f }
            java.lang.String r2 = "GET"
            r1.setRequestMethod(r2)     // Catch:{ all -> 0x005f }
            java.util.Map<java.lang.String, java.lang.String> r2 = r5.f24190c     // Catch:{ all -> 0x005f }
            java.util.Set r2 = r2.entrySet()     // Catch:{ all -> 0x005f }
            java.util.Iterator r2 = r2.iterator()     // Catch:{ all -> 0x005f }
        L_0x0043:
            boolean r3 = r2.hasNext()     // Catch:{ all -> 0x005f }
            if (r3 == 0) goto L_0x0061
            java.lang.Object r3 = r2.next()     // Catch:{ all -> 0x005f }
            java.util.Map$Entry r3 = (java.util.Map.Entry) r3     // Catch:{ all -> 0x005f }
            java.lang.Object r4 = r3.getKey()     // Catch:{ all -> 0x005f }
            java.lang.String r4 = (java.lang.String) r4     // Catch:{ all -> 0x005f }
            java.lang.Object r3 = r3.getValue()     // Catch:{ all -> 0x005f }
            java.lang.String r3 = (java.lang.String) r3     // Catch:{ all -> 0x005f }
            r1.addRequestProperty(r4, r3)     // Catch:{ all -> 0x005f }
            goto L_0x0043
        L_0x005f:
            r2 = move-exception
            goto L_0x0086
        L_0x0061:
            r1.connect()     // Catch:{ all -> 0x005f }
            int r2 = r1.getResponseCode()     // Catch:{ all -> 0x005f }
            java.io.InputStream r3 = r1.getInputStream()     // Catch:{ all -> 0x005f }
            if (r3 == 0) goto L_0x0076
            java.lang.String r0 = r5.f(r3)     // Catch:{ all -> 0x0073 }
            goto L_0x0076
        L_0x0073:
            r2 = move-exception
            r0 = r3
            goto L_0x0086
        L_0x0076:
            if (r3 == 0) goto L_0x007b
            r3.close()
        L_0x007b:
            r1.disconnect()
            com.google.firebase.crashlytics.internal.network.HttpResponse r1 = new com.google.firebase.crashlytics.internal.network.HttpResponse
            r1.<init>(r2, r0)
            return r1
        L_0x0084:
            r2 = move-exception
            r1 = r0
        L_0x0086:
            if (r0 == 0) goto L_0x008b
            r0.close()
        L_0x008b:
            if (r1 == 0) goto L_0x0090
            r1.disconnect()
        L_0x0090:
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.crashlytics.internal.network.HttpGetRequest.c():com.google.firebase.crashlytics.internal.network.HttpResponse");
    }

    public HttpGetRequest d(String str, String str2) {
        this.f24190c.put(str, str2);
        return this;
    }

    public HttpGetRequest e(Map.Entry<String, String> entry) {
        return d(entry.getKey(), entry.getValue());
    }
}
