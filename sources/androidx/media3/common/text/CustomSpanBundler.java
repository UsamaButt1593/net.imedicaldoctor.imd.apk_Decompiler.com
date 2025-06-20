package androidx.media3.common.text;

import android.os.Bundle;
import android.text.Spannable;
import android.text.Spanned;
import androidx.annotation.Nullable;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Util;
import java.util.ArrayList;

final class CustomSpanBundler {

    /* renamed from: a  reason: collision with root package name */
    private static final int f9467a = -1;

    /* renamed from: b  reason: collision with root package name */
    private static final int f9468b = 1;

    /* renamed from: c  reason: collision with root package name */
    private static final int f9469c = 2;

    /* renamed from: d  reason: collision with root package name */
    private static final int f9470d = 3;

    /* renamed from: e  reason: collision with root package name */
    private static final String f9471e = Util.d1(0);

    /* renamed from: f  reason: collision with root package name */
    private static final String f9472f = Util.d1(1);

    /* renamed from: g  reason: collision with root package name */
    private static final String f9473g = Util.d1(2);

    /* renamed from: h  reason: collision with root package name */
    private static final String f9474h = Util.d1(3);

    /* renamed from: i  reason: collision with root package name */
    private static final String f9475i = Util.d1(4);

    private CustomSpanBundler() {
    }

    public static ArrayList<Bundle> a(Spanned spanned) {
        ArrayList<Bundle> arrayList = new ArrayList<>();
        for (RubySpan rubySpan : (RubySpan[]) spanned.getSpans(0, spanned.length(), RubySpan.class)) {
            arrayList.add(b(spanned, rubySpan, 1, rubySpan.b()));
        }
        for (TextEmphasisSpan textEmphasisSpan : (TextEmphasisSpan[]) spanned.getSpans(0, spanned.length(), TextEmphasisSpan.class)) {
            arrayList.add(b(spanned, textEmphasisSpan, 2, textEmphasisSpan.b()));
        }
        for (HorizontalTextInVerticalContextSpan b2 : (HorizontalTextInVerticalContextSpan[]) spanned.getSpans(0, spanned.length(), HorizontalTextInVerticalContextSpan.class)) {
            arrayList.add(b(spanned, b2, 3, (Bundle) null));
        }
        return arrayList;
    }

    private static Bundle b(Spanned spanned, Object obj, int i2, @Nullable Bundle bundle) {
        Bundle bundle2 = new Bundle();
        bundle2.putInt(f9471e, spanned.getSpanStart(obj));
        bundle2.putInt(f9472f, spanned.getSpanEnd(obj));
        bundle2.putInt(f9473g, spanned.getSpanFlags(obj));
        bundle2.putInt(f9474h, i2);
        if (bundle != null) {
            bundle2.putBundle(f9475i, bundle);
        }
        return bundle2;
    }

    public static void c(Bundle bundle, Spannable spannable) {
        Object a2;
        int i2 = bundle.getInt(f9471e);
        int i3 = bundle.getInt(f9472f);
        int i4 = bundle.getInt(f9473g);
        int i5 = bundle.getInt(f9474h, -1);
        Bundle bundle2 = bundle.getBundle(f9475i);
        if (i5 == 1) {
            a2 = RubySpan.a((Bundle) Assertions.g(bundle2));
        } else if (i5 == 2) {
            a2 = TextEmphasisSpan.a((Bundle) Assertions.g(bundle2));
        } else if (i5 == 3) {
            a2 = new HorizontalTextInVerticalContextSpan();
        } else {
            return;
        }
        spannable.setSpan(a2, i2, i3, i4);
    }
}
