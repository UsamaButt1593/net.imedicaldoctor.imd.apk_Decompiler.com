package androidx.core.net;

import android.net.Uri;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.util.Preconditions;
import com.dd.plist.ASCIIPropertyListParser;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import kotlin.text.Typography;

public final class MailTo {

    /* renamed from: b  reason: collision with root package name */
    public static final String f6037b = "mailto:";

    /* renamed from: c  reason: collision with root package name */
    private static final String f6038c = "mailto";

    /* renamed from: d  reason: collision with root package name */
    private static final String f6039d = "to";

    /* renamed from: e  reason: collision with root package name */
    private static final String f6040e = "body";

    /* renamed from: f  reason: collision with root package name */
    private static final String f6041f = "cc";

    /* renamed from: g  reason: collision with root package name */
    private static final String f6042g = "bcc";

    /* renamed from: h  reason: collision with root package name */
    private static final String f6043h = "subject";

    /* renamed from: a  reason: collision with root package name */
    private HashMap<String, String> f6044a = new HashMap<>();

    private MailTo() {
    }

    public static boolean g(@Nullable Uri uri) {
        return uri != null && f6038c.equals(uri.getScheme());
    }

    public static boolean h(@Nullable String str) {
        return str != null && str.startsWith(f6037b);
    }

    @NonNull
    public static MailTo i(@NonNull Uri uri) throws ParseException {
        return j(uri.toString());
    }

    @NonNull
    public static MailTo j(@NonNull String str) throws ParseException {
        String str2;
        String str3;
        Preconditions.l(str);
        if (h(str)) {
            int indexOf = str.indexOf(35);
            if (indexOf != -1) {
                str = str.substring(0, indexOf);
            }
            int indexOf2 = str.indexOf(63);
            if (indexOf2 == -1) {
                str3 = Uri.decode(str.substring(7));
                str2 = null;
            } else {
                str3 = Uri.decode(str.substring(7, indexOf2));
                str2 = str.substring(indexOf2 + 1);
            }
            MailTo mailTo = new MailTo();
            if (str2 != null) {
                for (String split : str2.split("&")) {
                    String[] split2 = split.split("=", 2);
                    if (split2.length != 0) {
                        mailTo.f6044a.put(Uri.decode(split2[0]).toLowerCase(Locale.ROOT), split2.length > 1 ? Uri.decode(split2[1]) : null);
                    }
                }
            }
            String f2 = mailTo.f();
            if (f2 != null) {
                str3 = str3 + ", " + f2;
            }
            mailTo.f6044a.put("to", str3);
            return mailTo;
        }
        throw new ParseException("Not a mailto scheme");
    }

    @Nullable
    public String a() {
        return this.f6044a.get(f6042g);
    }

    @Nullable
    public String b() {
        return this.f6044a.get("body");
    }

    @Nullable
    public String c() {
        return this.f6044a.get(f6041f);
    }

    @Nullable
    public Map<String, String> d() {
        return this.f6044a;
    }

    @Nullable
    public String e() {
        return this.f6044a.get("subject");
    }

    @Nullable
    public String f() {
        return this.f6044a.get("to");
    }

    @NonNull
    public String toString() {
        StringBuilder sb = new StringBuilder(f6037b);
        sb.append('?');
        for (Map.Entry next : this.f6044a.entrySet()) {
            sb.append(Uri.encode((String) next.getKey()));
            sb.append(ASCIIPropertyListParser.f18654l);
            sb.append(Uri.encode((String) next.getValue()));
            sb.append(Typography.f29117d);
        }
        return sb.toString();
    }
}
