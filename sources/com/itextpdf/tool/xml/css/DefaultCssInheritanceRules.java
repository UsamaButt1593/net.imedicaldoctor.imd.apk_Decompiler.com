package com.itextpdf.tool.xml.css;

import com.itextpdf.tool.xml.Tag;
import com.itextpdf.tool.xml.css.CSS;
import java.util.Arrays;
import java.util.List;

public class DefaultCssInheritanceRules implements CssInheritanceRules {

    /* renamed from: a  reason: collision with root package name */
    private static final List<String> f27508a = Arrays.asList(new String[]{"width", "height", CSS.Property.D0, CSS.Property.E0, CSS.Property.F0, CSS.Property.G0, CSS.Property.f27468k, CSS.Property.f27470m, CSS.Property.f27471n, CSS.Property.o, CSS.Property.p, CSS.Property.M, "padding-left", CSS.Property.Q, CSS.Property.N, CSS.Property.O, CSS.Property.A, CSS.Property.I, CSS.Property.E, CSS.Property.B, CSS.Property.J, CSS.Property.F, CSS.Property.C, CSS.Property.K, CSS.Property.G, CSS.Property.D, CSS.Property.L, CSS.Property.H, CSS.Property.w0, CSS.Property.y0, "left", "top", "right", "bottom", CSS.Property.m0});

    /* renamed from: b  reason: collision with root package name */
    private static final List<String> f27509b = Arrays.asList(new String[]{"line-height", "font-size", "font-style", "font-weight", CSS.Property.l0, "cellpadding", CSS.Property.p0, CSS.Property.q0, CSS.Property.r0, CSS.Property.s0, CSS.Property.K0});

    /* renamed from: c  reason: collision with root package name */
    private static final List<String> f27510c = Arrays.asList(new String[]{CSS.Property.f27463f, CSS.Property.K0});

    /* renamed from: d  reason: collision with root package name */
    private static final List<String> f27511d = Arrays.asList(new String[]{CSS.Property.f27458a, CSS.Property.f27463f, "float"});

    /* renamed from: e  reason: collision with root package name */
    private static final List<String> f27512e = Arrays.asList(new String[]{"vertical-align"});

    public boolean a(Tag tag, String str) {
        if (f27508a.contains(str)) {
            return false;
        }
        if ("table".equals(tag.o())) {
            return !f27509b.contains(str);
        }
        if ("table".equals(tag.r().o())) {
            return !f27510c.contains(str);
        }
        if ("td".equalsIgnoreCase(tag.r().o())) {
            return !f27512e.contains(str);
        }
        if ("div".equalsIgnoreCase(tag.r().o())) {
            return !f27511d.contains(str);
        }
        return true;
    }

    public boolean b(String str) {
        return true;
    }
}
