package okhttp3;

import java.nio.charset.Charset;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.annotation.Nullable;

public final class MediaType {

    /* renamed from: e  reason: collision with root package name */
    private static final String f30894e = "([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)";

    /* renamed from: f  reason: collision with root package name */
    private static final String f30895f = "\"([^\"]*)\"";

    /* renamed from: g  reason: collision with root package name */
    private static final Pattern f30896g = Pattern.compile("([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)/([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)");

    /* renamed from: h  reason: collision with root package name */
    private static final Pattern f30897h = Pattern.compile(";\\s*(?:([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)=(?:([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)|\"([^\"]*)\"))?");

    /* renamed from: a  reason: collision with root package name */
    private final String f30898a;

    /* renamed from: b  reason: collision with root package name */
    private final String f30899b;

    /* renamed from: c  reason: collision with root package name */
    private final String f30900c;
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    private final String f30901d;

    private MediaType(String str, String str2, String str3, @Nullable String str4) {
        this.f30898a = str;
        this.f30899b = str2;
        this.f30900c = str3;
        this.f30901d = str4;
    }

    public static MediaType c(String str) {
        Matcher matcher = f30896g.matcher(str);
        if (matcher.lookingAt()) {
            String group = matcher.group(1);
            Locale locale = Locale.US;
            String lowerCase = group.toLowerCase(locale);
            String lowerCase2 = matcher.group(2).toLowerCase(locale);
            Matcher matcher2 = f30897h.matcher(str);
            int end = matcher.end();
            String str2 = null;
            while (end < str.length()) {
                matcher2.region(end, str.length());
                if (matcher2.lookingAt()) {
                    String group2 = matcher2.group(1);
                    if (group2 != null && group2.equalsIgnoreCase("charset")) {
                        String group3 = matcher2.group(2);
                        if (group3 == null) {
                            group3 = matcher2.group(3);
                        } else if (group3.startsWith("'") && group3.endsWith("'") && group3.length() > 2) {
                            group3 = group3.substring(1, group3.length() - 1);
                        }
                        if (str2 == null || group3.equalsIgnoreCase(str2)) {
                            str2 = group3;
                        } else {
                            throw new IllegalArgumentException("Multiple charsets defined: \"" + str2 + "\" and: \"" + group3 + "\" for: \"" + str + '\"');
                        }
                    }
                    end = matcher2.end();
                } else {
                    throw new IllegalArgumentException("Parameter is not formatted correctly: \"" + str.substring(end) + "\" for: \"" + str + '\"');
                }
            }
            return new MediaType(str, lowerCase, lowerCase2, str2);
        }
        throw new IllegalArgumentException("No subtype found for: \"" + str + '\"');
    }

    @Nullable
    public static MediaType d(String str) {
        try {
            return c(str);
        } catch (IllegalArgumentException unused) {
            return null;
        }
    }

    @Nullable
    public Charset a() {
        return b((Charset) null);
    }

    @Nullable
    public Charset b(@Nullable Charset charset) {
        try {
            String str = this.f30901d;
            return str != null ? Charset.forName(str) : charset;
        } catch (IllegalArgumentException unused) {
            return charset;
        }
    }

    public String e() {
        return this.f30900c;
    }

    public boolean equals(@Nullable Object obj) {
        return (obj instanceof MediaType) && ((MediaType) obj).f30898a.equals(this.f30898a);
    }

    public String f() {
        return this.f30899b;
    }

    public int hashCode() {
        return this.f30898a.hashCode();
    }

    public String toString() {
        return this.f30898a;
    }
}
