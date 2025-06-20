package org.jsoup.parser;

import java.util.Iterator;
import org.jsoup.internal.Normalizer;
import org.jsoup.nodes.Attribute;
import org.jsoup.nodes.Attributes;

public class ParseSettings {

    /* renamed from: c  reason: collision with root package name */
    public static final ParseSettings f31650c = new ParseSettings(false, false);

    /* renamed from: d  reason: collision with root package name */
    public static final ParseSettings f31651d = new ParseSettings(true, true);

    /* renamed from: a  reason: collision with root package name */
    private final boolean f31652a;

    /* renamed from: b  reason: collision with root package name */
    private final boolean f31653b;

    public ParseSettings(boolean z, boolean z2) {
        this.f31652a = z;
        this.f31653b = z2;
    }

    /* access modifiers changed from: package-private */
    public String a(String str) {
        String trim = str.trim();
        return !this.f31653b ? Normalizer.a(trim) : trim;
    }

    /* access modifiers changed from: package-private */
    public Attributes b(Attributes attributes) {
        if (!this.f31653b) {
            Iterator<Attribute> it2 = attributes.iterator();
            while (it2.hasNext()) {
                Attribute next = it2.next();
                next.i(Normalizer.a(next.getKey()));
            }
        }
        return attributes;
    }

    /* access modifiers changed from: package-private */
    public String c(String str) {
        String trim = str.trim();
        return !this.f31652a ? Normalizer.a(trim) : trim;
    }
}
