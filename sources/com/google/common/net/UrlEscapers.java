package com.google.common.net;

import com.google.common.annotations.GwtCompatible;
import com.google.common.escape.Escaper;

@GwtCompatible
@ElementTypesAreNonnullByDefault
public final class UrlEscapers {

    /* renamed from: a  reason: collision with root package name */
    static final String f22941a = "-_.*";

    /* renamed from: b  reason: collision with root package name */
    static final String f22942b = "-._~!$'()*,;&=@:";

    /* renamed from: c  reason: collision with root package name */
    private static final Escaper f22943c = new PercentEscaper(f22941a, true);

    /* renamed from: d  reason: collision with root package name */
    private static final Escaper f22944d = new PercentEscaper("-._~!$'()*,;&=@:+", false);

    /* renamed from: e  reason: collision with root package name */
    private static final Escaper f22945e = new PercentEscaper("-._~!$'()*,;&=@:+/?", false);

    private UrlEscapers() {
    }

    public static Escaper a() {
        return f22943c;
    }

    public static Escaper b() {
        return f22945e;
    }

    public static Escaper c() {
        return f22944d;
    }
}
