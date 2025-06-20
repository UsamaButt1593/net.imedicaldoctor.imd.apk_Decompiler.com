package com.google.common.xml;

import com.google.common.annotations.GwtCompatible;
import com.google.common.escape.Escaper;
import com.google.common.escape.Escapers;
import kotlin.text.Typography;
import okio.Utf8;

@GwtCompatible
@ElementTypesAreNonnullByDefault
public class XmlEscapers {

    /* renamed from: a  reason: collision with root package name */
    private static final char f23261a = '\u0000';

    /* renamed from: b  reason: collision with root package name */
    private static final char f23262b = '\u001f';

    /* renamed from: c  reason: collision with root package name */
    private static final Escaper f23263c;

    /* renamed from: d  reason: collision with root package name */
    private static final Escaper f23264d;

    /* renamed from: e  reason: collision with root package name */
    private static final Escaper f23265e;

    static {
        Escapers.Builder b2 = Escapers.b();
        b2.d(0, Utf8.f31405b);
        b2.e("�");
        for (char c2 = 0; c2 <= 31; c2 = (char) (c2 + 1)) {
            if (!(c2 == 9 || c2 == 10 || c2 == 13)) {
                b2.b(c2, "�");
            }
        }
        b2.b(Typography.f29117d, "&amp;");
        b2.b('<', "&lt;");
        b2.b('>', "&gt;");
        f23264d = b2.c();
        b2.b('\'', "&apos;");
        b2.b('\"', "&quot;");
        f23263c = b2.c();
        b2.b(9, "&#x9;");
        b2.b(10, "&#xA;");
        b2.b(13, "&#xD;");
        f23265e = b2.c();
    }

    private XmlEscapers() {
    }

    public static Escaper a() {
        return f23265e;
    }

    public static Escaper b() {
        return f23264d;
    }
}
