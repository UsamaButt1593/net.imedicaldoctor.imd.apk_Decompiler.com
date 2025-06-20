package org.apache.commons.httpclient.params;

import com.itextpdf.text.pdf.PdfBoolean;
import java.util.ArrayList;
import java.util.Arrays;
import org.apache.commons.httpclient.DefaultHttpMethodRetryHandler;
import org.apache.commons.httpclient.HttpState;
import org.apache.commons.httpclient.HttpVersion;
import org.apache.commons.httpclient.cookie.CookiePolicy;

public class DefaultHttpParamsFactory implements HttpParamsFactory {
    static /* synthetic */ Class class$org$apache$commons$httpclient$SimpleHttpConnectionManager;
    private HttpParams httpParams;

    static /* synthetic */ Class class$(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e2) {
            throw new NoClassDefFoundError(e2.getMessage());
        }
    }

    /* access modifiers changed from: protected */
    public HttpParams createParams() {
        String str;
        String str2;
        String str3;
        Boolean bool;
        String str4 = null;
        HttpClientParams httpClientParams = new HttpClientParams((HttpParams) null);
        httpClientParams.setParameter(HttpMethodParams.USER_AGENT, "Jakarta Commons-HttpClient/3.1");
        httpClientParams.setVersion(HttpVersion.HTTP_1_1);
        Class cls = class$org$apache$commons$httpclient$SimpleHttpConnectionManager;
        if (cls == null) {
            cls = class$("org.apache.commons.httpclient.SimpleHttpConnectionManager");
            class$org$apache$commons$httpclient$SimpleHttpConnectionManager = cls;
        }
        httpClientParams.setConnectionManagerClass(cls);
        httpClientParams.setCookiePolicy(CookiePolicy.DEFAULT);
        httpClientParams.setHttpElementCharset("US-ASCII");
        httpClientParams.setContentCharset("ISO-8859-1");
        httpClientParams.setParameter(HttpMethodParams.RETRY_HANDLER, new DefaultHttpMethodRetryHandler());
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(Arrays.asList(new String[]{"EEE, dd MMM yyyy HH:mm:ss zzz", "EEEE, dd-MMM-yy HH:mm:ss zzz", "EEE MMM d HH:mm:ss yyyy", "EEE, dd-MMM-yyyy HH:mm:ss z", "EEE, dd-MMM-yyyy HH-mm-ss z", "EEE, dd MMM yy HH:mm:ss z", "EEE dd-MMM-yyyy HH:mm:ss z", "EEE dd MMM yyyy HH:mm:ss z", "EEE dd-MMM-yyyy HH-mm-ss z", "EEE dd-MMM-yy HH:mm:ss z", "EEE dd MMM yy HH:mm:ss z", "EEE,dd-MMM-yy HH:mm:ss z", "EEE,dd-MMM-yyyy HH:mm:ss z", "EEE, dd-MM-yyyy HH:mm:ss z"}));
        httpClientParams.setParameter(HttpMethodParams.DATE_PATTERNS, arrayList);
        try {
            str = System.getProperty("httpclient.useragent");
        } catch (SecurityException unused) {
            str = null;
        }
        if (str != null) {
            httpClientParams.setParameter(HttpMethodParams.USER_AGENT, str);
        }
        try {
            str2 = System.getProperty(HttpState.PREEMPTIVE_PROPERTY);
        } catch (SecurityException unused2) {
            str2 = null;
        }
        if (str2 != null) {
            String lowerCase = str2.trim().toLowerCase();
            if (lowerCase.equals(PdfBoolean.l3)) {
                bool = Boolean.TRUE;
            } else if (lowerCase.equals("false")) {
                bool = Boolean.FALSE;
            }
            httpClientParams.setParameter(HttpClientParams.PREEMPTIVE_AUTHENTICATION, bool);
        }
        try {
            str4 = System.getProperty("apache.commons.httpclient.cookiespec");
        } catch (SecurityException unused3) {
        }
        if (str4 != null) {
            if ("COMPATIBILITY".equalsIgnoreCase(str4)) {
                str3 = CookiePolicy.BROWSER_COMPATIBILITY;
            } else if ("NETSCAPE_DRAFT".equalsIgnoreCase(str4)) {
                str3 = CookiePolicy.NETSCAPE;
            } else if ("RFC2109".equalsIgnoreCase(str4)) {
                str3 = CookiePolicy.RFC_2109;
            }
            httpClientParams.setCookiePolicy(str3);
        }
        return httpClientParams;
    }

    public synchronized HttpParams getDefaultParams() {
        try {
            if (this.httpParams == null) {
                this.httpParams = createParams();
            }
        } catch (Throwable th) {
            while (true) {
                throw th;
            }
        }
        return this.httpParams;
    }
}
