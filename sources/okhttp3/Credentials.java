package okhttp3;

import java.nio.charset.Charset;
import okhttp3.internal.Util;
import okio.ByteString;

public final class Credentials {
    private Credentials() {
    }

    public static String a(String str, String str2) {
        return b(str, str2, Util.f30980k);
    }

    public static String b(String str, String str2, Charset charset) {
        String e2 = ByteString.m(str + ":" + str2, charset).e();
        return "Basic " + e2;
    }
}
