package okhttp3.internal.http;

import java.io.IOException;
import java.net.ProtocolException;
import okhttp3.Protocol;
import okhttp3.Response;

public final class StatusLine {

    /* renamed from: d  reason: collision with root package name */
    public static final int f31097d = 307;

    /* renamed from: e  reason: collision with root package name */
    public static final int f31098e = 308;

    /* renamed from: f  reason: collision with root package name */
    public static final int f31099f = 100;

    /* renamed from: a  reason: collision with root package name */
    public final Protocol f31100a;

    /* renamed from: b  reason: collision with root package name */
    public final int f31101b;

    /* renamed from: c  reason: collision with root package name */
    public final String f31102c;

    public StatusLine(Protocol protocol, int i2, String str) {
        this.f31100a = protocol;
        this.f31101b = i2;
        this.f31102c = str;
    }

    public static StatusLine a(Response response) {
        return new StatusLine(response.x(), response.f(), response.s());
    }

    public static StatusLine b(String str) throws IOException {
        int i2;
        Protocol protocol;
        String str2;
        if (str.startsWith("HTTP/1.")) {
            i2 = 9;
            if (str.length() < 9 || str.charAt(8) != ' ') {
                throw new ProtocolException("Unexpected status line: " + str);
            }
            int charAt = str.charAt(7) - '0';
            if (charAt == 0) {
                protocol = Protocol.HTTP_1_0;
            } else if (charAt == 1) {
                protocol = Protocol.HTTP_1_1;
            } else {
                throw new ProtocolException("Unexpected status line: " + str);
            }
        } else if (str.startsWith("ICY ")) {
            protocol = Protocol.HTTP_1_0;
            i2 = 4;
        } else {
            throw new ProtocolException("Unexpected status line: " + str);
        }
        int i3 = i2 + 3;
        if (str.length() >= i3) {
            try {
                int parseInt = Integer.parseInt(str.substring(i2, i3));
                if (str.length() <= i3) {
                    str2 = "";
                } else if (str.charAt(i3) == ' ') {
                    str2 = str.substring(i2 + 4);
                } else {
                    throw new ProtocolException("Unexpected status line: " + str);
                }
                return new StatusLine(protocol, parseInt, str2);
            } catch (NumberFormatException unused) {
                throw new ProtocolException("Unexpected status line: " + str);
            }
        } else {
            throw new ProtocolException("Unexpected status line: " + str);
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f31100a == Protocol.HTTP_1_0 ? "HTTP/1.0" : "HTTP/1.1");
        sb.append(' ');
        sb.append(this.f31101b);
        if (this.f31102c != null) {
            sb.append(' ');
            sb.append(this.f31102c);
        }
        return sb.toString();
    }
}
