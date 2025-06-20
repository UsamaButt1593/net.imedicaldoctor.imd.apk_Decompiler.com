package okhttp3.internal.http;

import java.net.Proxy;
import okhttp3.HttpUrl;
import okhttp3.Request;

public final class RequestLine {
    private RequestLine() {
    }

    public static String a(Request request, Proxy.Type type) {
        StringBuilder sb = new StringBuilder();
        sb.append(request.g());
        sb.append(' ');
        boolean b2 = b(request, type);
        HttpUrl k2 = request.k();
        if (b2) {
            sb.append(k2);
        } else {
            sb.append(c(k2));
        }
        sb.append(" HTTP/1.1");
        return sb.toString();
    }

    private static boolean b(Request request, Proxy.Type type) {
        return !request.f() && type == Proxy.Type.HTTP;
    }

    public static String c(HttpUrl httpUrl) {
        String h2 = httpUrl.h();
        String j2 = httpUrl.j();
        if (j2 == null) {
            return h2;
        }
        return h2 + '?' + j2;
    }
}
