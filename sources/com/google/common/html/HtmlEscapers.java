package com.google.common.html;

import com.google.common.annotations.GwtCompatible;
import com.google.common.escape.Escaper;
import com.google.common.escape.Escapers;
import kotlin.text.Typography;

@GwtCompatible
@ElementTypesAreNonnullByDefault
public final class HtmlEscapers {

    /* renamed from: a  reason: collision with root package name */
    private static final Escaper f22724a = Escapers.b().b('\"', "&quot;").b('\'', "&#39;").b(Typography.f29117d, "&amp;").b('<', "&lt;").b('>', "&gt;").c();

    private HtmlEscapers() {
    }

    public static Escaper a() {
        return f22724a;
    }
}
