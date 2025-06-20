package androidx.core.text.util;

import android.os.Build;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.text.style.URLSpan;
import android.text.util.Linkify;
import android.webkit.WebView;
import android.widget.TextView;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.core.net.MailTo;
import androidx.core.util.PatternsCompat;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class LinkifyCompat {

    /* renamed from: a  reason: collision with root package name */
    private static final String[] f6237a = new String[0];

    /* renamed from: b  reason: collision with root package name */
    private static final Comparator<LinkSpec> f6238b = new a();

    @RequiresApi(24)
    static class Api24Impl {
        private Api24Impl() {
        }

        @DoNotInline
        static void a(TextView textView, Pattern pattern, String str, String[] strArr, Linkify.MatchFilter matchFilter, Linkify.TransformFilter transformFilter) {
            Linkify.addLinks(textView, pattern, str, strArr, matchFilter, transformFilter);
        }

        @DoNotInline
        static boolean b(Spannable spannable, Pattern pattern, String str, String[] strArr, Linkify.MatchFilter matchFilter, Linkify.TransformFilter transformFilter) {
            return Linkify.addLinks(spannable, pattern, str, strArr, matchFilter, transformFilter);
        }
    }

    private static class LinkSpec {

        /* renamed from: a  reason: collision with root package name */
        URLSpan f6239a;

        /* renamed from: b  reason: collision with root package name */
        String f6240b;

        /* renamed from: c  reason: collision with root package name */
        int f6241c;

        /* renamed from: d  reason: collision with root package name */
        int f6242d;

        LinkSpec() {
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    @Retention(RetentionPolicy.SOURCE)
    public @interface LinkifyMask {
    }

    private LinkifyCompat() {
    }

    private static void b(@NonNull TextView textView) {
        if (!(textView.getMovementMethod() instanceof LinkMovementMethod) && textView.getLinksClickable()) {
            textView.setMovementMethod(LinkMovementMethod.getInstance());
        }
    }

    public static void c(@NonNull TextView textView, @NonNull Pattern pattern, @Nullable String str) {
        if (r()) {
            Linkify.addLinks(textView, pattern, str);
        } else {
            e(textView, pattern, str, (String[]) null, (Linkify.MatchFilter) null, (Linkify.TransformFilter) null);
        }
    }

    public static void d(@NonNull TextView textView, @NonNull Pattern pattern, @Nullable String str, @Nullable Linkify.MatchFilter matchFilter, @Nullable Linkify.TransformFilter transformFilter) {
        if (r()) {
            Linkify.addLinks(textView, pattern, str, matchFilter, transformFilter);
        } else {
            e(textView, pattern, str, (String[]) null, matchFilter, transformFilter);
        }
    }

    public static void e(@NonNull TextView textView, @NonNull Pattern pattern, @Nullable String str, @Nullable String[] strArr, @Nullable Linkify.MatchFilter matchFilter, @Nullable Linkify.TransformFilter transformFilter) {
        if (r()) {
            Api24Impl.a(textView, pattern, str, strArr, matchFilter, transformFilter);
            return;
        }
        SpannableString valueOf = SpannableString.valueOf(textView.getText());
        if (i(valueOf, pattern, str, strArr, matchFilter, transformFilter)) {
            textView.setText(valueOf);
            b(textView);
        }
    }

    public static boolean f(@NonNull Spannable spannable, int i2) {
        if (r()) {
            return Linkify.addLinks(spannable, i2);
        }
        if (i2 == 0) {
            return false;
        }
        URLSpan[] uRLSpanArr = (URLSpan[]) spannable.getSpans(0, spannable.length(), URLSpan.class);
        for (int length = uRLSpanArr.length - 1; length >= 0; length--) {
            spannable.removeSpan(uRLSpanArr[length]);
        }
        if ((i2 & 4) != 0) {
            Linkify.addLinks(spannable, 4);
        }
        ArrayList arrayList = new ArrayList();
        if ((i2 & 1) != 0) {
            m(arrayList, spannable, PatternsCompat.w, new String[]{"http://", "https://", "rtsp://"}, Linkify.sUrlMatchFilter, (Linkify.TransformFilter) null);
        }
        if ((i2 & 2) != 0) {
            m(arrayList, spannable, PatternsCompat.A, new String[]{MailTo.f6037b}, (Linkify.MatchFilter) null, (Linkify.TransformFilter) null);
        }
        if ((i2 & 8) != 0) {
            n(arrayList, spannable);
        }
        q(arrayList, spannable);
        if (arrayList.size() == 0) {
            return false;
        }
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            LinkSpec linkSpec = (LinkSpec) it2.next();
            if (linkSpec.f6239a == null) {
                k(linkSpec.f6240b, linkSpec.f6241c, linkSpec.f6242d, spannable);
            }
        }
        return true;
    }

    public static boolean g(@NonNull Spannable spannable, @NonNull Pattern pattern, @Nullable String str) {
        return r() ? Linkify.addLinks(spannable, pattern, str) : i(spannable, pattern, str, (String[]) null, (Linkify.MatchFilter) null, (Linkify.TransformFilter) null);
    }

    public static boolean h(@NonNull Spannable spannable, @NonNull Pattern pattern, @Nullable String str, @Nullable Linkify.MatchFilter matchFilter, @Nullable Linkify.TransformFilter transformFilter) {
        return r() ? Linkify.addLinks(spannable, pattern, str, matchFilter, transformFilter) : i(spannable, pattern, str, (String[]) null, matchFilter, transformFilter);
    }

    public static boolean i(@NonNull Spannable spannable, @NonNull Pattern pattern, @Nullable String str, @Nullable String[] strArr, @Nullable Linkify.MatchFilter matchFilter, @Nullable Linkify.TransformFilter transformFilter) {
        if (r()) {
            return Api24Impl.b(spannable, pattern, str, strArr, matchFilter, transformFilter);
        }
        if (str == null) {
            str = "";
        }
        if (strArr == null || strArr.length < 1) {
            strArr = f6237a;
        }
        String[] strArr2 = new String[(strArr.length + 1)];
        strArr2[0] = str.toLowerCase(Locale.ROOT);
        int i2 = 0;
        while (i2 < strArr.length) {
            String str2 = strArr[i2];
            i2++;
            strArr2[i2] = str2 == null ? "" : str2.toLowerCase(Locale.ROOT);
        }
        Matcher matcher = pattern.matcher(spannable);
        boolean z = false;
        while (matcher.find()) {
            int start = matcher.start();
            int end = matcher.end();
            String group = matcher.group(0);
            if ((matchFilter != null ? matchFilter.acceptMatch(spannable, start, end) : true) && group != null) {
                k(p(group, strArr2, matcher, transformFilter), start, end, spannable);
                z = true;
            }
        }
        return z;
    }

    public static boolean j(@NonNull TextView textView, int i2) {
        if (r()) {
            return Linkify.addLinks(textView, i2);
        }
        if (i2 == 0) {
            return false;
        }
        CharSequence text = textView.getText();
        if (!(text instanceof Spannable)) {
            SpannableString valueOf = SpannableString.valueOf(text);
            if (f(valueOf, i2)) {
                b(textView);
                textView.setText(valueOf);
                return true;
            }
        } else if (f((Spannable) text, i2)) {
            b(textView);
            return true;
        }
        return false;
    }

    private static void k(String str, int i2, int i3, Spannable spannable) {
        spannable.setSpan(new URLSpan(str), i2, i3, 33);
    }

    private static String l(String str) {
        return Build.VERSION.SDK_INT >= 28 ? WebView.findAddress(str) : FindAddress.c(str);
    }

    private static void m(ArrayList<LinkSpec> arrayList, Spannable spannable, Pattern pattern, String[] strArr, Linkify.MatchFilter matchFilter, Linkify.TransformFilter transformFilter) {
        Matcher matcher = pattern.matcher(spannable);
        while (matcher.find()) {
            int start = matcher.start();
            int end = matcher.end();
            String group = matcher.group(0);
            if ((matchFilter == null || matchFilter.acceptMatch(spannable, start, end)) && group != null) {
                LinkSpec linkSpec = new LinkSpec();
                linkSpec.f6240b = p(group, strArr, matcher, transformFilter);
                linkSpec.f6241c = start;
                linkSpec.f6242d = end;
                arrayList.add(linkSpec);
            }
        }
    }

    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:1:0x0005 */
    /* JADX WARNING: Removed duplicated region for block: B:1:0x0005 A[LOOP:0: B:1:0x0005->B:14:0x0005, LOOP_START, PHI: r0 r6 
      PHI: (r0v1 int) = (r0v0 int), (r0v2 int) binds: [B:0:0x0000, B:14:0x0005] A[DONT_GENERATE, DONT_INLINE]
      PHI: (r6v2 java.lang.String) = (r6v1 java.lang.String), (r6v3 java.lang.String) binds: [B:0:0x0000, B:14:0x0005] A[DONT_GENERATE, DONT_INLINE], SYNTHETIC, Splitter:B:1:0x0005] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void n(java.util.ArrayList<androidx.core.text.util.LinkifyCompat.LinkSpec> r5, android.text.Spannable r6) {
        /*
            java.lang.String r6 = r6.toString()
            r0 = 0
        L_0x0005:
            java.lang.String r1 = l(r6)     // Catch:{ UnsupportedOperationException -> 0x0043 }
            if (r1 == 0) goto L_0x0043
            int r2 = r6.indexOf(r1)     // Catch:{ UnsupportedOperationException -> 0x0043 }
            if (r2 >= 0) goto L_0x0012
            goto L_0x0043
        L_0x0012:
            androidx.core.text.util.LinkifyCompat$LinkSpec r3 = new androidx.core.text.util.LinkifyCompat$LinkSpec     // Catch:{ UnsupportedOperationException -> 0x0043 }
            r3.<init>()     // Catch:{ UnsupportedOperationException -> 0x0043 }
            int r4 = r1.length()     // Catch:{ UnsupportedOperationException -> 0x0043 }
            int r4 = r4 + r2
            int r2 = r2 + r0
            r3.f6241c = r2     // Catch:{ UnsupportedOperationException -> 0x0043 }
            int r0 = r0 + r4
            r3.f6242d = r0     // Catch:{ UnsupportedOperationException -> 0x0043 }
            java.lang.String r6 = r6.substring(r4)     // Catch:{ UnsupportedOperationException -> 0x0043 }
            java.lang.String r2 = "UTF-8"
            java.lang.String r1 = java.net.URLEncoder.encode(r1, r2)     // Catch:{ UnsupportedEncodingException -> 0x0005 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ UnsupportedOperationException -> 0x0043 }
            r2.<init>()     // Catch:{ UnsupportedOperationException -> 0x0043 }
            java.lang.String r4 = "geo:0,0?q="
            r2.append(r4)     // Catch:{ UnsupportedOperationException -> 0x0043 }
            r2.append(r1)     // Catch:{ UnsupportedOperationException -> 0x0043 }
            java.lang.String r1 = r2.toString()     // Catch:{ UnsupportedOperationException -> 0x0043 }
            r3.f6240b = r1     // Catch:{ UnsupportedOperationException -> 0x0043 }
            r5.add(r3)     // Catch:{ UnsupportedOperationException -> 0x0043 }
            goto L_0x0005
        L_0x0043:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.text.util.LinkifyCompat.n(java.util.ArrayList, android.text.Spannable):void");
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ int o(LinkSpec linkSpec, LinkSpec linkSpec2) {
        int i2 = linkSpec.f6241c;
        int i3 = linkSpec2.f6241c;
        if (i2 < i3) {
            return -1;
        }
        if (i2 > i3) {
            return 1;
        }
        return Integer.compare(linkSpec2.f6242d, linkSpec.f6242d);
    }

    private static String p(@NonNull String str, @NonNull String[] strArr, Matcher matcher, @Nullable Linkify.TransformFilter transformFilter) {
        boolean z;
        if (transformFilter != null) {
            str = transformFilter.transformUrl(matcher, str);
        }
        int length = strArr.length;
        int i2 = 0;
        while (true) {
            if (i2 >= length) {
                z = false;
                break;
            }
            String str2 = strArr[i2];
            if (str.regionMatches(true, 0, str2, 0, str2.length())) {
                z = true;
                if (!str.regionMatches(false, 0, str2, 0, str2.length())) {
                    str = str2 + str.substring(str2.length());
                }
            } else {
                i2++;
            }
        }
        if (z || strArr.length <= 0) {
            return str;
        }
        return strArr[0] + str;
    }

    private static void q(ArrayList<LinkSpec> arrayList, Spannable spannable) {
        int i2;
        int i3 = 0;
        for (URLSpan uRLSpan : (URLSpan[]) spannable.getSpans(0, spannable.length(), URLSpan.class)) {
            LinkSpec linkSpec = new LinkSpec();
            linkSpec.f6239a = uRLSpan;
            linkSpec.f6241c = spannable.getSpanStart(uRLSpan);
            linkSpec.f6242d = spannable.getSpanEnd(uRLSpan);
            arrayList.add(linkSpec);
        }
        Collections.sort(arrayList, f6238b);
        int size = arrayList.size();
        while (i3 < size - 1) {
            LinkSpec linkSpec2 = arrayList.get(i3);
            int i4 = i3 + 1;
            LinkSpec linkSpec3 = arrayList.get(i4);
            int i5 = linkSpec2.f6241c;
            int i6 = linkSpec3.f6241c;
            if (i5 <= i6 && (i2 = linkSpec2.f6242d) > i6) {
                int i7 = linkSpec3.f6242d;
                int i8 = (i7 > i2 && i2 - i5 <= i7 - i6) ? i2 - i5 < i7 - i6 ? i3 : -1 : i4;
                if (i8 != -1) {
                    URLSpan uRLSpan2 = arrayList.get(i8).f6239a;
                    if (uRLSpan2 != null) {
                        spannable.removeSpan(uRLSpan2);
                    }
                    arrayList.remove(i8);
                    size--;
                }
            }
            i3 = i4;
        }
    }

    private static boolean r() {
        return Build.VERSION.SDK_INT >= 28;
    }
}
