package androidx.core.net;

import android.net.Uri;
import androidx.annotation.NonNull;
import com.dd.plist.ASCIIPropertyListParser;

public final class UriCompat {
    private UriCompat() {
    }

    @NonNull
    public static String a(@NonNull Uri uri) {
        String scheme = uri.getScheme();
        String schemeSpecificPart = uri.getSchemeSpecificPart();
        if (scheme != null) {
            if (scheme.equalsIgnoreCase("tel") || scheme.equalsIgnoreCase("sip") || scheme.equalsIgnoreCase("sms") || scheme.equalsIgnoreCase("smsto") || scheme.equalsIgnoreCase("mailto") || scheme.equalsIgnoreCase("nfc")) {
                StringBuilder sb = new StringBuilder(64);
                sb.append(scheme);
                sb.append(ASCIIPropertyListParser.A);
                if (schemeSpecificPart != null) {
                    for (int i2 = 0; i2 < schemeSpecificPart.length(); i2++) {
                        char charAt = schemeSpecificPart.charAt(i2);
                        if (!(charAt == '-' || charAt == '@' || charAt == '.')) {
                            charAt = 'x';
                        }
                        sb.append(charAt);
                    }
                }
                return sb.toString();
            } else if (scheme.equalsIgnoreCase("http") || scheme.equalsIgnoreCase("https") || scheme.equalsIgnoreCase("ftp") || scheme.equalsIgnoreCase("rtsp")) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("//");
                String str = "";
                sb2.append(uri.getHost() != null ? uri.getHost() : str);
                if (uri.getPort() != -1) {
                    str = ":" + uri.getPort();
                }
                sb2.append(str);
                sb2.append("/...");
                schemeSpecificPart = sb2.toString();
            }
        }
        StringBuilder sb3 = new StringBuilder(64);
        if (scheme != null) {
            sb3.append(scheme);
            sb3.append(ASCIIPropertyListParser.A);
        }
        if (schemeSpecificPart != null) {
            sb3.append(schemeSpecificPart);
        }
        return sb3.toString();
    }
}
