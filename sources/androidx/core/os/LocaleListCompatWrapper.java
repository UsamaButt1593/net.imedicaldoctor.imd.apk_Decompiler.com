package androidx.core.os;

import androidx.annotation.DoNotInline;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.VisibleForTesting;
import com.dd.plist.ASCIIPropertyListParser;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Locale;

final class LocaleListCompatWrapper implements LocaleListInterface {

    /* renamed from: c  reason: collision with root package name */
    private static final Locale[] f6061c = new Locale[0];

    /* renamed from: d  reason: collision with root package name */
    private static final Locale f6062d = new Locale("en", "XA");

    /* renamed from: e  reason: collision with root package name */
    private static final Locale f6063e = new Locale("ar", "XB");

    /* renamed from: f  reason: collision with root package name */
    private static final Locale f6064f = LocaleListCompat.b("en-Latn");

    /* renamed from: a  reason: collision with root package name */
    private final Locale[] f6065a;
    @NonNull

    /* renamed from: b  reason: collision with root package name */
    private final String f6066b;

    @RequiresApi(21)
    static class Api21Impl {
        private Api21Impl() {
        }

        @DoNotInline
        static String a(Locale locale) {
            return locale.getScript();
        }
    }

    LocaleListCompatWrapper(@NonNull Locale... localeArr) {
        String sb;
        if (localeArr.length == 0) {
            this.f6065a = f6061c;
            sb = "";
        } else {
            ArrayList arrayList = new ArrayList();
            HashSet hashSet = new HashSet();
            StringBuilder sb2 = new StringBuilder();
            int i2 = 0;
            while (i2 < localeArr.length) {
                Locale locale = localeArr[i2];
                if (locale != null) {
                    if (!hashSet.contains(locale)) {
                        Locale locale2 = (Locale) locale.clone();
                        arrayList.add(locale2);
                        k(sb2, locale2);
                        if (i2 < localeArr.length - 1) {
                            sb2.append(ASCIIPropertyListParser.f18651i);
                        }
                        hashSet.add(locale2);
                    }
                    i2++;
                } else {
                    throw new NullPointerException("list[" + i2 + "] is null");
                }
            }
            this.f6065a = (Locale[]) arrayList.toArray(new Locale[0]);
            sb = sb2.toString();
        }
        this.f6066b = sb;
    }

    private Locale e(Collection<String> collection, boolean z) {
        int f2 = f(collection, z);
        if (f2 == -1) {
            return null;
        }
        return this.f6065a[f2];
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x001b, code lost:
        if (r6 < Integer.MAX_VALUE) goto L_0x0021;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private int f(java.util.Collection<java.lang.String> r5, boolean r6) {
        /*
            r4 = this;
            java.util.Locale[] r0 = r4.f6065a
            int r1 = r0.length
            r2 = 1
            r3 = 0
            if (r1 != r2) goto L_0x0008
            return r3
        L_0x0008:
            int r0 = r0.length
            if (r0 != 0) goto L_0x000d
            r5 = -1
            return r5
        L_0x000d:
            r0 = 2147483647(0x7fffffff, float:NaN)
            if (r6 == 0) goto L_0x001e
            java.util.Locale r6 = f6064f
            int r6 = r4.g(r6)
            if (r6 != 0) goto L_0x001b
            return r3
        L_0x001b:
            if (r6 >= r0) goto L_0x001e
            goto L_0x0021
        L_0x001e:
            r6 = 2147483647(0x7fffffff, float:NaN)
        L_0x0021:
            java.util.Iterator r5 = r5.iterator()
        L_0x0025:
            boolean r1 = r5.hasNext()
            if (r1 == 0) goto L_0x0040
            java.lang.Object r1 = r5.next()
            java.lang.String r1 = (java.lang.String) r1
            java.util.Locale r1 = androidx.core.os.LocaleListCompat.b(r1)
            int r1 = r4.g(r1)
            if (r1 != 0) goto L_0x003c
            return r3
        L_0x003c:
            if (r1 >= r6) goto L_0x0025
            r6 = r1
            goto L_0x0025
        L_0x0040:
            if (r6 != r0) goto L_0x0043
            return r3
        L_0x0043:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.os.LocaleListCompatWrapper.f(java.util.Collection, boolean):int");
    }

    private int g(Locale locale) {
        int i2 = 0;
        while (true) {
            Locale[] localeArr = this.f6065a;
            if (i2 >= localeArr.length) {
                return Integer.MAX_VALUE;
            }
            if (j(locale, localeArr[i2]) > 0) {
                return i2;
            }
            i2++;
        }
    }

    private static String h(Locale locale) {
        String a2 = Api21Impl.a(locale);
        return !a2.isEmpty() ? a2 : "";
    }

    private static boolean i(Locale locale) {
        return f6062d.equals(locale) || f6063e.equals(locale);
    }

    @IntRange(from = 0, to = 1)
    private static int j(Locale locale, Locale locale2) {
        if (locale.equals(locale2)) {
            return 1;
        }
        if (!locale.getLanguage().equals(locale2.getLanguage()) || i(locale) || i(locale2)) {
            return 0;
        }
        String h2 = h(locale);
        if (!h2.isEmpty()) {
            return h2.equals(h(locale2)) ? 1 : 0;
        }
        String country = locale.getCountry();
        return (country.isEmpty() || country.equals(locale2.getCountry())) ? 1 : 0;
    }

    @VisibleForTesting
    static void k(StringBuilder sb, Locale locale) {
        sb.append(locale.getLanguage());
        String country = locale.getCountry();
        if (country != null && !country.isEmpty()) {
            sb.append('-');
            sb.append(locale.getCountry());
        }
    }

    public int a(Locale locale) {
        int i2 = 0;
        while (true) {
            Locale[] localeArr = this.f6065a;
            if (i2 >= localeArr.length) {
                return -1;
            }
            if (localeArr[i2].equals(locale)) {
                return i2;
            }
            i2++;
        }
    }

    public String b() {
        return this.f6066b;
    }

    @Nullable
    public Object c() {
        return null;
    }

    public Locale d(@NonNull String[] strArr) {
        return e(Arrays.asList(strArr), false);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof LocaleListCompatWrapper)) {
            return false;
        }
        Locale[] localeArr = ((LocaleListCompatWrapper) obj).f6065a;
        if (this.f6065a.length != localeArr.length) {
            return false;
        }
        int i2 = 0;
        while (true) {
            Locale[] localeArr2 = this.f6065a;
            if (i2 >= localeArr2.length) {
                return true;
            }
            if (!localeArr2[i2].equals(localeArr[i2])) {
                return false;
            }
            i2++;
        }
    }

    public Locale get(int i2) {
        if (i2 >= 0) {
            Locale[] localeArr = this.f6065a;
            if (i2 < localeArr.length) {
                return localeArr[i2];
            }
        }
        return null;
    }

    public int hashCode() {
        int i2 = 1;
        for (Locale hashCode : this.f6065a) {
            i2 = (i2 * 31) + hashCode.hashCode();
        }
        return i2;
    }

    public boolean isEmpty() {
        return this.f6065a.length == 0;
    }

    public int size() {
        return this.f6065a.length;
    }

    @NonNull
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        int i2 = 0;
        while (true) {
            Locale[] localeArr = this.f6065a;
            if (i2 < localeArr.length) {
                sb.append(localeArr[i2]);
                if (i2 < this.f6065a.length - 1) {
                    sb.append(ASCIIPropertyListParser.f18651i);
                }
                i2++;
            } else {
                sb.append("]");
                return sb.toString();
            }
        }
    }
}
