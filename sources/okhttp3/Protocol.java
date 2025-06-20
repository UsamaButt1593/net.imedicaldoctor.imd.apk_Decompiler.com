package okhttp3;

import java.io.IOException;

public enum Protocol {
    HTTP_1_0("http/1.0"),
    HTTP_1_1("http/1.1"),
    SPDY_3("spdy/3.1"),
    HTTP_2("h2"),
    H2_PRIOR_KNOWLEDGE("h2_prior_knowledge"),
    QUIC("quic");
    
    private final String s;

    private Protocol(String str) {
        this.s = str;
    }

    public static Protocol a(String str) throws IOException {
        Protocol protocol = HTTP_1_0;
        if (str.equals(protocol.s)) {
            return protocol;
        }
        Protocol protocol2 = HTTP_1_1;
        if (str.equals(protocol2.s)) {
            return protocol2;
        }
        Protocol protocol3 = H2_PRIOR_KNOWLEDGE;
        if (str.equals(protocol3.s)) {
            return protocol3;
        }
        Protocol protocol4 = HTTP_2;
        if (str.equals(protocol4.s)) {
            return protocol4;
        }
        Protocol protocol5 = SPDY_3;
        if (str.equals(protocol5.s)) {
            return protocol5;
        }
        Protocol protocol6 = QUIC;
        if (str.equals(protocol6.s)) {
            return protocol6;
        }
        throw new IOException("Unexpected protocol: " + str);
    }

    public String toString() {
        return this.s;
    }
}
