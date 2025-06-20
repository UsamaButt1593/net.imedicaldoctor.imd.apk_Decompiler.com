package okhttp3;

import java.nio.charset.Charset;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import javax.annotation.Nullable;
import okhttp3.internal.Util;

public final class Challenge {

    /* renamed from: a  reason: collision with root package name */
    private final String f30787a;

    /* renamed from: b  reason: collision with root package name */
    private final Map<String, String> f30788b;

    public Challenge(String str, String str2) {
        if (str == null) {
            throw new NullPointerException("scheme == null");
        } else if (str2 != null) {
            this.f30787a = str;
            this.f30788b = Collections.singletonMap("realm", str2);
        } else {
            throw new NullPointerException("realm == null");
        }
    }

    public Map<String, String> a() {
        return this.f30788b;
    }

    public Charset b() {
        String str = this.f30788b.get("charset");
        if (str != null) {
            try {
                return Charset.forName(str);
            } catch (Exception unused) {
            }
        }
        return Util.f30980k;
    }

    public String c() {
        return this.f30788b.get("realm");
    }

    public String d() {
        return this.f30787a;
    }

    public Challenge e(Charset charset) {
        if (charset != null) {
            LinkedHashMap linkedHashMap = new LinkedHashMap(this.f30788b);
            linkedHashMap.put("charset", charset.name());
            return new Challenge(this.f30787a, (Map<String, String>) linkedHashMap);
        }
        throw new NullPointerException("charset == null");
    }

    public boolean equals(@Nullable Object obj) {
        if (obj instanceof Challenge) {
            Challenge challenge = (Challenge) obj;
            return challenge.f30787a.equals(this.f30787a) && challenge.f30788b.equals(this.f30788b);
        }
    }

    public int hashCode() {
        return ((899 + this.f30787a.hashCode()) * 31) + this.f30788b.hashCode();
    }

    public String toString() {
        return this.f30787a + " authParams=" + this.f30788b;
    }

    public Challenge(String str, Map<String, String> map) {
        if (str == null) {
            throw new NullPointerException("scheme == null");
        } else if (map != null) {
            this.f30787a = str;
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            for (Map.Entry next : map.entrySet()) {
                linkedHashMap.put(next.getKey() == null ? null : ((String) next.getKey()).toLowerCase(Locale.US), next.getValue());
            }
            this.f30788b = Collections.unmodifiableMap(linkedHashMap);
        } else {
            throw new NullPointerException("authParams == null");
        }
    }
}
