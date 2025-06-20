package com.google.common.base;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.J2ktIncompatible;
import java.nio.charset.Charset;

@GwtCompatible(emulated = true)
@ElementTypesAreNonnullByDefault
public final class Charsets {
    @GwtIncompatible
    @J2ktIncompatible

    /* renamed from: a  reason: collision with root package name */
    public static final Charset f22253a = Charset.forName("US-ASCII");

    /* renamed from: b  reason: collision with root package name */
    public static final Charset f22254b = Charset.forName("ISO-8859-1");

    /* renamed from: c  reason: collision with root package name */
    public static final Charset f22255c = Charset.forName("UTF-8");
    @GwtIncompatible
    @J2ktIncompatible

    /* renamed from: d  reason: collision with root package name */
    public static final Charset f22256d = Charset.forName("UTF-16BE");
    @GwtIncompatible
    @J2ktIncompatible

    /* renamed from: e  reason: collision with root package name */
    public static final Charset f22257e = Charset.forName("UTF-16LE");
    @GwtIncompatible
    @J2ktIncompatible

    /* renamed from: f  reason: collision with root package name */
    public static final Charset f22258f = Charset.forName("UTF-16");

    private Charsets() {
    }
}
