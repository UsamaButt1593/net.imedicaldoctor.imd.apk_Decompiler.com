package com.google.common.net;

import com.google.common.annotations.GwtCompatible;

@GwtCompatible
@ElementTypesAreNonnullByDefault
public final class HttpHeaders {
    public static final String A = "If-None-Match";
    public static final String A0 = "Report-To";
    public static final String A1 = "Sec-CH-UA";
    public static final String B = "If-Range";
    public static final String B0 = "Retry-After";
    public static final String B1 = "Sec-CH-UA-Arch";
    public static final String C = "If-Unmodified-Since";
    public static final String C0 = "Server";
    public static final String C1 = "Sec-CH-UA-Model";
    public static final String D = "Last-Event-ID";
    public static final String D0 = "Server-Timing";
    public static final String D1 = "Sec-CH-UA-Platform";
    public static final String E = "Max-Forwards";
    public static final String E0 = "Service-Worker-Allowed";
    public static final String E1 = "Sec-CH-UA-Platform-Version";
    public static final String F = "Origin";
    public static final String F0 = "Set-Cookie";
    @Deprecated
    public static final String F1 = "Sec-CH-UA-Full-Version";
    public static final String G = "Origin-Isolation";
    public static final String G0 = "Set-Cookie2";
    public static final String G1 = "Sec-CH-UA-Full-Version-List";
    public static final String H = "Proxy-Authorization";
    public static final String H0 = "SourceMap";
    public static final String H1 = "Sec-CH-UA-Mobile";
    public static final String I = "Range";
    public static final String I0 = "Supports-Loading-Mode";
    public static final String I1 = "Sec-CH-UA-WoW64";
    public static final String J = "Referer";
    public static final String J0 = "Strict-Transport-Security";
    public static final String J1 = "Sec-CH-UA-Bitness";
    public static final String K = "Referrer-Policy";
    public static final String K0 = "Timing-Allow-Origin";
    public static final String K1 = "Sec-CH-UA-Form-Factor";
    public static final String L = "Service-Worker";
    public static final String L0 = "Trailer";
    public static final String L1 = "Sec-CH-Viewport-Width";
    public static final String M = "TE";
    public static final String M0 = "Transfer-Encoding";
    public static final String M1 = "Sec-CH-Viewport-Height";
    public static final String N = "Upgrade";
    public static final String N0 = "Vary";
    public static final String N1 = "Sec-CH-DPR";
    public static final String O = "Upgrade-Insecure-Requests";
    public static final String O0 = "WWW-Authenticate";
    public static final String O1 = "Sec-Fetch-Dest";
    public static final String P = "User-Agent";
    public static final String P0 = "DNT";
    public static final String P1 = "Sec-Fetch-Mode";
    public static final String Q = "Accept-Ranges";
    public static final String Q0 = "X-Content-Type-Options";
    public static final String Q1 = "Sec-Fetch-Site";
    public static final String R = "Access-Control-Allow-Headers";
    public static final String R0 = "X-Device-IP";
    public static final String R1 = "Sec-Fetch-User";
    public static final String S = "Access-Control-Allow-Methods";
    public static final String S0 = "X-Device-Referer";
    public static final String S1 = "Sec-Metadata";
    public static final String T = "Access-Control-Allow-Origin";
    public static final String T0 = "X-Device-Accept-Language";
    public static final String T1 = "Sec-Token-Binding";
    public static final String U = "Access-Control-Allow-Private-Network";
    public static final String U0 = "X-Device-Requested-With";
    public static final String U1 = "Sec-Provided-Token-Binding-ID";
    public static final String V = "Access-Control-Allow-Credentials";
    public static final String V0 = "X-Do-Not-Track";
    public static final String V1 = "Sec-Referred-Token-Binding-ID";
    public static final String W = "Access-Control-Expose-Headers";
    public static final String W0 = "X-Forwarded-For";
    public static final String W1 = "Sec-WebSocket-Accept";
    public static final String X = "Access-Control-Max-Age";
    public static final String X0 = "X-Forwarded-Proto";
    public static final String X1 = "Sec-WebSocket-Extensions";
    public static final String Y = "Age";
    public static final String Y0 = "X-Forwarded-Host";
    public static final String Y1 = "Sec-WebSocket-Key";
    public static final String Z = "Allow";
    public static final String Z0 = "X-Forwarded-Port";
    public static final String Z1 = "Sec-WebSocket-Protocol";

    /* renamed from: a  reason: collision with root package name */
    public static final String f22873a = "Cache-Control";
    public static final String a0 = "Content-Disposition";
    public static final String a1 = "X-Frame-Options";
    public static final String a2 = "Sec-WebSocket-Version";

    /* renamed from: b  reason: collision with root package name */
    public static final String f22874b = "Content-Length";
    public static final String b0 = "Content-Encoding";
    public static final String b1 = "X-Powered-By";
    public static final String b2 = "Sec-Browsing-Topics";

    /* renamed from: c  reason: collision with root package name */
    public static final String f22875c = "Content-Type";
    public static final String c0 = "Content-Language";
    public static final String c1 = "Public-Key-Pins";
    public static final String c2 = "Observe-Browsing-Topics";

    /* renamed from: d  reason: collision with root package name */
    public static final String f22876d = "Date";
    public static final String d0 = "Content-Location";
    public static final String d1 = "Public-Key-Pins-Report-Only";
    public static final String d2 = "CDN-Loop";

    /* renamed from: e  reason: collision with root package name */
    public static final String f22877e = "Pragma";
    public static final String e0 = "Content-MD5";
    public static final String e1 = "X-Request-ID";

    /* renamed from: f  reason: collision with root package name */
    public static final String f22878f = "Via";
    public static final String f0 = "Content-Range";
    public static final String f1 = "X-Requested-With";

    /* renamed from: g  reason: collision with root package name */
    public static final String f22879g = "Warning";
    public static final String g0 = "Content-Security-Policy";
    public static final String g1 = "X-User-IP";

    /* renamed from: h  reason: collision with root package name */
    public static final String f22880h = "Accept";
    public static final String h0 = "Content-Security-Policy-Report-Only";
    public static final String h1 = "X-Download-Options";

    /* renamed from: i  reason: collision with root package name */
    public static final String f22881i = "Accept-Charset";
    public static final String i0 = "X-Content-Security-Policy";
    public static final String i1 = "X-XSS-Protection";

    /* renamed from: j  reason: collision with root package name */
    public static final String f22882j = "Accept-Encoding";
    public static final String j0 = "X-Content-Security-Policy-Report-Only";
    public static final String j1 = "X-DNS-Prefetch-Control";

    /* renamed from: k  reason: collision with root package name */
    public static final String f22883k = "Accept-Language";
    public static final String k0 = "X-WebKit-CSP";
    public static final String k1 = "Ping-From";

    /* renamed from: l  reason: collision with root package name */
    public static final String f22884l = "Access-Control-Request-Headers";
    public static final String l0 = "X-WebKit-CSP-Report-Only";
    public static final String l1 = "Ping-To";

    /* renamed from: m  reason: collision with root package name */
    public static final String f22885m = "Access-Control-Request-Method";
    public static final String m0 = "Cross-Origin-Embedder-Policy";
    public static final String m1 = "Purpose";

    /* renamed from: n  reason: collision with root package name */
    public static final String f22886n = "Authorization";
    public static final String n0 = "Cross-Origin-Embedder-Policy-Report-Only";
    public static final String n1 = "X-Purpose";
    public static final String o = "Connection";
    public static final String o0 = "Cross-Origin-Opener-Policy";
    public static final String o1 = "X-Moz";
    public static final String p = "Cookie";
    public static final String p0 = "ETag";
    public static final String p1 = "Device-Memory";
    public static final String q = "Cross-Origin-Resource-Policy";
    public static final String q0 = "Expires";
    public static final String q1 = "Downlink";
    public static final String r = "Early-Data";
    public static final String r0 = "Last-Modified";
    public static final String r1 = "ECT";
    public static final String s = "Expect";
    public static final String s0 = "Link";
    public static final String s1 = "RTT";
    public static final String t = "From";
    public static final String t0 = "Location";
    public static final String t1 = "Save-Data";
    public static final String u = "Forwarded";
    public static final String u0 = "Keep-Alive";
    public static final String u1 = "Viewport-Width";
    public static final String v = "Follow-Only-When-Prerender-Shown";
    public static final String v0 = "No-Vary-Search";
    public static final String v1 = "Width";
    public static final String w = "Host";
    public static final String w0 = "Origin-Trial";
    public static final String w1 = "Permissions-Policy";
    public static final String x = "HTTP2-Settings";
    public static final String x0 = "P3P";
    public static final String x1 = "Sec-CH-Prefers-Color-Scheme";
    public static final String y = "If-Match";
    public static final String y0 = "Proxy-Authenticate";
    public static final String y1 = "Accept-CH";
    public static final String z = "If-Modified-Since";
    public static final String z0 = "Refresh";
    public static final String z1 = "Critical-CH";

    public static final class ReferrerPolicyValues {

        /* renamed from: a  reason: collision with root package name */
        public static final String f22887a = "no-referrer";

        /* renamed from: b  reason: collision with root package name */
        public static final String f22888b = "no-referrer-when-downgrade";

        /* renamed from: c  reason: collision with root package name */
        public static final String f22889c = "same-origin";

        /* renamed from: d  reason: collision with root package name */
        public static final String f22890d = "origin";

        /* renamed from: e  reason: collision with root package name */
        public static final String f22891e = "strict-origin";

        /* renamed from: f  reason: collision with root package name */
        public static final String f22892f = "origin-when-cross-origin";

        /* renamed from: g  reason: collision with root package name */
        public static final String f22893g = "strict-origin-when-cross-origin";

        /* renamed from: h  reason: collision with root package name */
        public static final String f22894h = "unsafe-url";

        private ReferrerPolicyValues() {
        }
    }

    private HttpHeaders() {
    }
}
