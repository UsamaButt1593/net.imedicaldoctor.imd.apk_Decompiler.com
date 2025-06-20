package com.itextpdf.text.error_messages;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.HashMap;

public final class MessageLocalization {

    /* renamed from: a  reason: collision with root package name */
    private static HashMap<String, String> f25737a = null;

    /* renamed from: b  reason: collision with root package name */
    private static HashMap<String, String> f25738b = null;

    /* renamed from: c  reason: collision with root package name */
    private static final String f25739c = "com/itextpdf/text/l10n/error/";

    static {
        f25737a = new HashMap<>();
        try {
            f25737a = c("en", (String) null);
        } catch (Exception unused) {
        }
        if (f25737a == null) {
            f25737a = new HashMap<>();
        }
    }

    private MessageLocalization() {
    }

    public static String a(String str, int i2) {
        return b(str, String.valueOf(i2), null, null, null);
    }

    public static String b(String str, Object... objArr) {
        String d2 = d(str);
        if (objArr != null) {
            int i2 = 1;
            for (Object obj : objArr) {
                if (obj != null) {
                    d2 = d2.replace("{" + i2 + "}", obj.toString());
                }
                i2++;
            }
        }
        return d2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:43:0x00a4 A[SYNTHETIC, Splitter:B:43:0x00a4] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.util.HashMap<java.lang.String, java.lang.String> c(java.lang.String r6, java.lang.String r7) throws java.io.IOException {
        /*
            java.lang.Class<com.itextpdf.text.error_messages.MessageLocalization> r0 = com.itextpdf.text.error_messages.MessageLocalization.class
            java.lang.String r1 = "com/itextpdf/text/l10n/error/"
            if (r6 == 0) goto L_0x00a8
            java.lang.String r2 = ".lng"
            r3 = 0
            if (r7 == 0) goto L_0x0026
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x0023 }
            r4.<init>()     // Catch:{ all -> 0x0023 }
            r4.append(r6)     // Catch:{ all -> 0x0023 }
            java.lang.String r5 = "_"
            r4.append(r5)     // Catch:{ all -> 0x0023 }
            r4.append(r7)     // Catch:{ all -> 0x0023 }
            r4.append(r2)     // Catch:{ all -> 0x0023 }
        L_0x001e:
            java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x0023 }
            goto L_0x0032
        L_0x0023:
            r6 = move-exception
            goto L_0x00a2
        L_0x0026:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x0023 }
            r4.<init>()     // Catch:{ all -> 0x0023 }
            r4.append(r6)     // Catch:{ all -> 0x0023 }
            r4.append(r2)     // Catch:{ all -> 0x0023 }
            goto L_0x001e
        L_0x0032:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x0023 }
            r5.<init>()     // Catch:{ all -> 0x0023 }
            r5.append(r1)     // Catch:{ all -> 0x0023 }
            r5.append(r4)     // Catch:{ all -> 0x0023 }
            java.lang.String r4 = r5.toString()     // Catch:{ all -> 0x0023 }
            com.itextpdf.text.error_messages.MessageLocalization r5 = new com.itextpdf.text.error_messages.MessageLocalization     // Catch:{ all -> 0x0023 }
            r5.<init>()     // Catch:{ all -> 0x0023 }
            java.lang.ClassLoader r5 = r0.getClassLoader()     // Catch:{ all -> 0x0023 }
            java.io.InputStream r4 = com.itextpdf.text.io.StreamUtil.c(r4, r5)     // Catch:{ all -> 0x0023 }
            if (r4 == 0) goto L_0x005b
            java.util.HashMap r6 = f(r4)     // Catch:{ all -> 0x0058 }
            r4.close()     // Catch:{ Exception -> 0x0057 }
        L_0x0057:
            return r6
        L_0x0058:
            r6 = move-exception
            r3 = r4
            goto L_0x00a2
        L_0x005b:
            if (r7 != 0) goto L_0x0063
            if (r4 == 0) goto L_0x0062
            r4.close()     // Catch:{ Exception -> 0x0062 }
        L_0x0062:
            return r3
        L_0x0063:
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ all -> 0x0058 }
            r7.<init>()     // Catch:{ all -> 0x0058 }
            r7.append(r6)     // Catch:{ all -> 0x0058 }
            r7.append(r2)     // Catch:{ all -> 0x0058 }
            java.lang.String r6 = r7.toString()     // Catch:{ all -> 0x0058 }
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ all -> 0x0058 }
            r7.<init>()     // Catch:{ all -> 0x0058 }
            r7.append(r1)     // Catch:{ all -> 0x0058 }
            r7.append(r6)     // Catch:{ all -> 0x0058 }
            java.lang.String r6 = r7.toString()     // Catch:{ all -> 0x0058 }
            com.itextpdf.text.error_messages.MessageLocalization r7 = new com.itextpdf.text.error_messages.MessageLocalization     // Catch:{ all -> 0x0058 }
            r7.<init>()     // Catch:{ all -> 0x0058 }
            java.lang.ClassLoader r7 = r0.getClassLoader()     // Catch:{ all -> 0x0058 }
            java.io.InputStream r6 = com.itextpdf.text.io.StreamUtil.c(r6, r7)     // Catch:{ all -> 0x0058 }
            if (r6 == 0) goto L_0x009c
            java.util.HashMap r7 = f(r6)     // Catch:{ all -> 0x0098 }
            r6.close()     // Catch:{ Exception -> 0x0097 }
        L_0x0097:
            return r7
        L_0x0098:
            r7 = move-exception
            r3 = r6
            r6 = r7
            goto L_0x00a2
        L_0x009c:
            if (r6 == 0) goto L_0x00a1
            r6.close()     // Catch:{ Exception -> 0x00a1 }
        L_0x00a1:
            return r3
        L_0x00a2:
            if (r3 == 0) goto L_0x00a7
            r3.close()     // Catch:{ Exception -> 0x00a7 }
        L_0x00a7:
            throw r6
        L_0x00a8:
            java.lang.IllegalArgumentException r6 = new java.lang.IllegalArgumentException
            java.lang.String r7 = "The language cannot be null."
            r6.<init>(r7)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.itextpdf.text.error_messages.MessageLocalization.c(java.lang.String, java.lang.String):java.util.HashMap");
    }

    public static String d(String str) {
        return e(str, true);
    }

    public static String e(String str, boolean z) {
        String str2;
        String str3;
        HashMap<String, String> hashMap = f25738b;
        if (hashMap != null && (str3 = hashMap.get(str)) != null) {
            return str3;
        }
        if (z && (str2 = f25737a.get(str)) != null) {
            return str2;
        }
        return "No message found for " + str;
    }

    private static HashMap<String, String> f(InputStream inputStream) throws IOException {
        return g(new InputStreamReader(inputStream, "UTF-8"));
    }

    private static HashMap<String, String> g(Reader reader) throws IOException {
        HashMap<String, String> hashMap = new HashMap<>();
        BufferedReader bufferedReader = new BufferedReader(reader);
        while (true) {
            String readLine = bufferedReader.readLine();
            if (readLine == null) {
                return hashMap;
            }
            int indexOf = readLine.indexOf(61);
            if (indexOf >= 0) {
                String trim = readLine.substring(0, indexOf).trim();
                if (!trim.startsWith("#")) {
                    hashMap.put(trim, readLine.substring(indexOf + 1));
                }
            }
        }
    }

    public static boolean h(String str, String str2) throws IOException {
        HashMap<String, String> c2 = c(str, str2);
        if (c2 == null) {
            return false;
        }
        f25738b = c2;
        return true;
    }

    public static void i(Reader reader) throws IOException {
        f25738b = g(reader);
    }
}
