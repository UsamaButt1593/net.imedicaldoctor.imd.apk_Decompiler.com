package okhttp3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import javax.annotation.Nullable;
import okhttp3.internal.Util;
import okhttp3.internal.http.HttpDate;
import org.apache.commons.lang3.StringUtils;

public final class Headers {

    /* renamed from: a  reason: collision with root package name */
    private final String[] f30869a;

    public static final class Builder {

        /* renamed from: a  reason: collision with root package name */
        final List<String> f30870a = new ArrayList(20);

        public Builder a(String str) {
            int indexOf = str.indexOf(":");
            if (indexOf != -1) {
                return b(str.substring(0, indexOf).trim(), str.substring(indexOf + 1));
            }
            throw new IllegalArgumentException("Unexpected header: " + str);
        }

        public Builder b(String str, String str2) {
            Headers.b(str);
            Headers.c(str2, str);
            return f(str, str2);
        }

        public Builder c(String str, Date date) {
            if (date != null) {
                b(str, HttpDate.a(date));
                return this;
            }
            throw new NullPointerException("value for name " + str + " == null");
        }

        public Builder d(Headers headers) {
            int l2 = headers.l();
            for (int i2 = 0; i2 < l2; i2++) {
                f(headers.g(i2), headers.n(i2));
            }
            return this;
        }

        /* access modifiers changed from: package-private */
        public Builder e(String str) {
            int indexOf = str.indexOf(":", 1);
            if (indexOf != -1) {
                return f(str.substring(0, indexOf), str.substring(indexOf + 1));
            }
            return str.startsWith(":") ? f("", str.substring(1)) : f("", str);
        }

        /* access modifiers changed from: package-private */
        public Builder f(String str, String str2) {
            this.f30870a.add(str);
            this.f30870a.add(str2.trim());
            return this;
        }

        public Builder g(String str, String str2) {
            Headers.b(str);
            return f(str, str2);
        }

        public Headers h() {
            return new Headers(this);
        }

        public String i(String str) {
            for (int size = this.f30870a.size() - 2; size >= 0; size -= 2) {
                if (str.equalsIgnoreCase(this.f30870a.get(size))) {
                    return this.f30870a.get(size + 1);
                }
            }
            return null;
        }

        public Builder j(String str) {
            int i2 = 0;
            while (i2 < this.f30870a.size()) {
                if (str.equalsIgnoreCase(this.f30870a.get(i2))) {
                    this.f30870a.remove(i2);
                    this.f30870a.remove(i2);
                    i2 -= 2;
                }
                i2 += 2;
            }
            return this;
        }

        public Builder k(String str, String str2) {
            Headers.b(str);
            Headers.c(str2, str);
            j(str);
            f(str, str2);
            return this;
        }

        public Builder l(String str, Date date) {
            if (date != null) {
                k(str, HttpDate.a(date));
                return this;
            }
            throw new NullPointerException("value for name " + str + " == null");
        }
    }

    Headers(Builder builder) {
        List<String> list = builder.f30870a;
        this.f30869a = (String[]) list.toArray(new String[list.size()]);
    }

    static void b(String str) {
        if (str == null) {
            throw new NullPointerException("name == null");
        } else if (!str.isEmpty()) {
            int length = str.length();
            for (int i2 = 0; i2 < length; i2++) {
                char charAt = str.charAt(i2);
                if (charAt <= ' ' || charAt >= 127) {
                    throw new IllegalArgumentException(Util.s("Unexpected char %#04x at %d in header name: %s", Integer.valueOf(charAt), Integer.valueOf(i2), str));
                }
            }
        } else {
            throw new IllegalArgumentException("name is empty");
        }
    }

    static void c(String str, String str2) {
        if (str != null) {
            int length = str.length();
            int i2 = 0;
            while (i2 < length) {
                char charAt = str.charAt(i2);
                if ((charAt > 31 || charAt == 9) && charAt < 127) {
                    i2++;
                } else {
                    throw new IllegalArgumentException(Util.s("Unexpected char %#04x at %d in %s value: %s", Integer.valueOf(charAt), Integer.valueOf(i2), str2, str));
                }
            }
            return;
        }
        throw new NullPointerException("value for name " + str2 + " == null");
    }

    private static String e(String[] strArr, String str) {
        for (int length = strArr.length - 2; length >= 0; length -= 2) {
            if (str.equalsIgnoreCase(strArr[length])) {
                return strArr[length + 1];
            }
        }
        return null;
    }

    public static Headers j(Map<String, String> map) {
        if (map != null) {
            String[] strArr = new String[(map.size() * 2)];
            int i2 = 0;
            for (Map.Entry next : map.entrySet()) {
                if (next.getKey() == null || next.getValue() == null) {
                    throw new IllegalArgumentException("Headers cannot be null");
                }
                String trim = ((String) next.getKey()).trim();
                String trim2 = ((String) next.getValue()).trim();
                b(trim);
                c(trim2, trim);
                strArr[i2] = trim;
                strArr[i2 + 1] = trim2;
                i2 += 2;
            }
            return new Headers(strArr);
        }
        throw new NullPointerException("headers == null");
    }

    public static Headers k(String... strArr) {
        if (strArr == null) {
            throw new NullPointerException("namesAndValues == null");
        } else if (strArr.length % 2 == 0) {
            String[] strArr2 = (String[]) strArr.clone();
            int i2 = 0;
            while (i2 < strArr2.length) {
                String str = strArr2[i2];
                if (str != null) {
                    strArr2[i2] = str.trim();
                    i2++;
                } else {
                    throw new IllegalArgumentException("Headers cannot be null");
                }
            }
            for (int i3 = 0; i3 < strArr2.length; i3 += 2) {
                String str2 = strArr2[i3];
                String str3 = strArr2[i3 + 1];
                b(str2);
                c(str3, str2);
            }
            return new Headers(strArr2);
        } else {
            throw new IllegalArgumentException("Expected alternating header names and values");
        }
    }

    public long a() {
        String[] strArr = this.f30869a;
        long length = (long) (strArr.length * 2);
        int length2 = strArr.length;
        for (int i2 = 0; i2 < length2; i2++) {
            length += (long) this.f30869a[i2].length();
        }
        return length;
    }

    @Nullable
    public String d(String str) {
        return e(this.f30869a, str);
    }

    public boolean equals(@Nullable Object obj) {
        return (obj instanceof Headers) && Arrays.equals(((Headers) obj).f30869a, this.f30869a);
    }

    @Nullable
    public Date f(String str) {
        String d2 = d(str);
        if (d2 != null) {
            return HttpDate.b(d2);
        }
        return null;
    }

    public String g(int i2) {
        return this.f30869a[i2 * 2];
    }

    public Set<String> h() {
        TreeSet treeSet = new TreeSet(String.CASE_INSENSITIVE_ORDER);
        int l2 = l();
        for (int i2 = 0; i2 < l2; i2++) {
            treeSet.add(g(i2));
        }
        return Collections.unmodifiableSet(treeSet);
    }

    public int hashCode() {
        return Arrays.hashCode(this.f30869a);
    }

    public Builder i() {
        Builder builder = new Builder();
        Collections.addAll(builder.f30870a, this.f30869a);
        return builder;
    }

    public int l() {
        return this.f30869a.length / 2;
    }

    public Map<String, List<String>> m() {
        TreeMap treeMap = new TreeMap(String.CASE_INSENSITIVE_ORDER);
        int l2 = l();
        for (int i2 = 0; i2 < l2; i2++) {
            String lowerCase = g(i2).toLowerCase(Locale.US);
            List list = (List) treeMap.get(lowerCase);
            if (list == null) {
                list = new ArrayList(2);
                treeMap.put(lowerCase, list);
            }
            list.add(n(i2));
        }
        return treeMap;
    }

    public String n(int i2) {
        return this.f30869a[(i2 * 2) + 1];
    }

    public List<String> o(String str) {
        int l2 = l();
        ArrayList arrayList = null;
        for (int i2 = 0; i2 < l2; i2++) {
            if (str.equalsIgnoreCase(g(i2))) {
                if (arrayList == null) {
                    arrayList = new ArrayList(2);
                }
                arrayList.add(n(i2));
            }
        }
        return arrayList != null ? Collections.unmodifiableList(arrayList) : Collections.emptyList();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        int l2 = l();
        for (int i2 = 0; i2 < l2; i2++) {
            sb.append(g(i2));
            sb.append(": ");
            sb.append(n(i2));
            sb.append(StringUtils.LF);
        }
        return sb.toString();
    }

    private Headers(String[] strArr) {
        this.f30869a = strArr;
    }
}
