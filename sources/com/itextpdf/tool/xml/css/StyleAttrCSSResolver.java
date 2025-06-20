package com.itextpdf.tool.xml.css;

import androidx.exifinterface.media.ExifInterface;
import androidx.media3.extractor.metadata.icy.IcyHeaders;
import com.itextpdf.tool.xml.Tag;
import com.itextpdf.tool.xml.css.CSS;
import com.itextpdf.tool.xml.exceptions.CssResolverException;
import com.itextpdf.tool.xml.html.HTML;
import com.itextpdf.tool.xml.net.FileRetrieve;
import com.itextpdf.tool.xml.net.FileRetrieveImpl;
import com.itextpdf.tool.xml.pipeline.css.CSSResolver;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeSet;

public class StyleAttrCSSResolver implements CSSResolver {

    /* renamed from: e  reason: collision with root package name */
    public static final String f27517e = "style";

    /* renamed from: a  reason: collision with root package name */
    private final CssUtils f27518a;

    /* renamed from: b  reason: collision with root package name */
    private CssInheritanceRules f27519b;

    /* renamed from: c  reason: collision with root package name */
    private final CssFiles f27520c;

    /* renamed from: d  reason: collision with root package name */
    private FileRetrieve f27521d;

    public StyleAttrCSSResolver() {
        this((CssFiles) new CssFilesImpl(), CssUtils.g());
    }

    private boolean g(Tag tag, String str) {
        CssInheritanceRules cssInheritanceRules = this.f27519b;
        if (cssInheritanceRules != null) {
            return cssInheritanceRules.a(tag, str);
        }
        return true;
    }

    private String h(String str, String str2) {
        if ("none".equals(str2)) {
            return str2;
        }
        TreeSet treeSet = new TreeSet();
        if (str != null) {
            Collections.addAll(treeSet, str.split("\\s+"));
        }
        if (str2 != null) {
            Collections.addAll(treeSet, str2.split("\\s+"));
        }
        StringBuilder sb = new StringBuilder();
        Iterator it2 = treeSet.iterator();
        while (it2.hasNext()) {
            String str3 = (String) it2.next();
            if (!str3.equals("none") && !str3.equals(CSS.Value.N)) {
                if (sb.length() > 0) {
                    sb.append(' ');
                }
                sb.append(str3);
            }
        }
        if (sb.length() == 0) {
            return null;
        }
        return sb.toString();
    }

    private boolean i(String str) {
        CssInheritanceRules cssInheritanceRules = this.f27519b;
        if (cssInheritanceRules != null) {
            return cssInheritanceRules.b(str);
        }
        return true;
    }

    private void l(Map<String, String> map, String str, String str2) {
        Map<String, String> v;
        CssUtils cssUtils;
        String str3;
        CssUtils cssUtils2;
        String str4;
        if ("border".equalsIgnoreCase(str)) {
            v = this.f27518a.l(str2);
        } else {
            String str5 = CSS.Property.s;
            if (!str5.equalsIgnoreCase(str)) {
                str5 = CSS.Property.u;
                if (!str5.equalsIgnoreCase(str)) {
                    str5 = CSS.Property.r;
                    if (!str5.equalsIgnoreCase(str)) {
                        str5 = CSS.Property.t;
                        if (!str5.equalsIgnoreCase(str)) {
                            if (CSS.Property.f27468k.equalsIgnoreCase(str)) {
                                cssUtils = this.f27518a;
                                str3 = "margin-";
                            } else {
                                if (CSS.Property.v.equalsIgnoreCase(str)) {
                                    cssUtils2 = this.f27518a;
                                    str4 = "-width";
                                } else if (CSS.Property.w.equalsIgnoreCase(str)) {
                                    cssUtils2 = this.f27518a;
                                    str4 = "-style";
                                } else if (CSS.Property.x.equalsIgnoreCase(str)) {
                                    cssUtils2 = this.f27518a;
                                    str4 = "-color";
                                } else if (CSS.Property.M.equalsIgnoreCase(str)) {
                                    cssUtils = this.f27518a;
                                    str3 = "padding-";
                                } else if ("font".equalsIgnoreCase(str)) {
                                    v = this.f27518a.u(str2);
                                } else if (CSS.Property.f27464g.equalsIgnoreCase(str)) {
                                    v = this.f27518a.v(str2);
                                } else if (str.toLowerCase().contains(CSS.Property.f27458a)) {
                                    Map<String, String> t = this.f27518a.t(str2);
                                    for (String next : t.keySet()) {
                                        if (!map.containsKey(next)) {
                                            map.put(next, t.get(next));
                                        }
                                    }
                                    return;
                                } else {
                                    map.put(str, str2);
                                    return;
                                }
                                v = cssUtils2.n(str2, "border-", str4);
                            }
                            v = cssUtils.n(str2, str3, "");
                        }
                    }
                }
            }
            v = this.f27518a.m(str2, str5);
        }
        map.putAll(v);
    }

    public void a(CssFile cssFile) {
        this.f27520c.a(cssFile);
    }

    public void b(Tag tag) {
        String str;
        String str2;
        String str3;
        String str4;
        Map linkedHashMap = new LinkedHashMap();
        CssFiles cssFiles = this.f27520c;
        Map<String, String> map = null;
        if (cssFiles != null && cssFiles.c()) {
            linkedHashMap = this.f27520c.b(tag);
            if (tag.o().equalsIgnoreCase("p") || tag.o().equalsIgnoreCase("td")) {
                map = this.f27520c.b(new Tag("ul"));
            }
        }
        if (tag.d() != null && !tag.d().isEmpty()) {
            if (tag.d().get("cellpadding") != null) {
                linkedHashMap.putAll(this.f27518a.n(tag.d().get("cellpadding"), "cellpadding-", ""));
            }
            if (tag.d().get(HTML.Attribute.f27592c) != null) {
                linkedHashMap.putAll(this.f27518a.n(tag.d().get(HTML.Attribute.f27592c), "cellspacing-", ""));
            }
            String str5 = tag.d().get("style");
            if (str5 != null && str5.length() > 0) {
                LinkedHashMap linkedHashMap2 = new LinkedHashMap();
                for (String split : str5.split(";")) {
                    String[] split2 = split.split(":", 2);
                    if (split2.length == 2) {
                        l(linkedHashMap2, this.f27518a.y(split2[0]), this.f27518a.x(split2[1]));
                    }
                }
                for (Map.Entry entry : linkedHashMap2.entrySet()) {
                    linkedHashMap.put(entry.getKey(), entry.getValue());
                }
            }
        }
        Map<String, String> g2 = tag.g();
        if (tag.o() != null) {
            if (tag.o().equalsIgnoreCase("i") || tag.o().equalsIgnoreCase(HTML.Tag.l0) || tag.o().equalsIgnoreCase("em") || tag.o().equalsIgnoreCase(HTML.Tag.R0) || tag.o().equalsIgnoreCase(HTML.Tag.j0) || tag.o().equalsIgnoreCase(HTML.Tag.F)) {
                str2 = "font-style";
                str3 = "italic";
            } else if (tag.o().equalsIgnoreCase("b") || tag.o().equalsIgnoreCase("strong")) {
                str2 = "font-weight";
                str3 = "bold";
            } else if (tag.o().equalsIgnoreCase("u") || tag.o().equalsIgnoreCase(HTML.Tag.s0)) {
                linkedHashMap.put("text-decoration", "underline");
            } else if (tag.o().equalsIgnoreCase("s") || tag.o().equalsIgnoreCase("strike") || tag.o().equalsIgnoreCase(HTML.Tag.h0)) {
                linkedHashMap.put("text-decoration", "line-through");
            } else {
                if (tag.o().equalsIgnoreCase(HTML.Tag.T0)) {
                    str4 = CSS.Value.g0;
                } else if (tag.o().equalsIgnoreCase("small")) {
                    str4 = CSS.Value.f0;
                }
                linkedHashMap.put("font-size", str4);
            }
            linkedHashMap.put(str2, str3);
        }
        if (map != null && map.containsKey(CSS.Property.f27465h)) {
            g2.put(CSS.Property.f27465h, map.get(CSS.Property.f27465h));
        }
        if (!(!i(tag.o()) || tag.r() == null || tag.r().g() == null)) {
            if (this.f27519b != null) {
                for (Map.Entry next : tag.r().g().entrySet()) {
                    String str6 = (String) next.getKey();
                    if ((linkedHashMap.containsKey(str6) && CSS.Value.N.equals(linkedHashMap.get(str6))) || g(tag, str6)) {
                        if (!str6.contains("cellpadding") || (!"td".equals(tag.o()) && !"th".equals(tag.o()))) {
                            g2.put(str6, next.getValue());
                        } else {
                            linkedHashMap.put(str6.replace("cellpadding", CSS.Property.M), next.getValue());
                        }
                    }
                }
            } else {
                g2.putAll(tag.r().g());
            }
        }
        if (tag.o() != null) {
            if (tag.o().equals("font")) {
                String str7 = tag.d().get("face");
                if (str7 != null) {
                    g2.put("font-family", str7);
                }
                String str8 = tag.d().get("color");
                if (str8 != null) {
                    g2.put("color", str8);
                }
                String str9 = tag.d().get("size");
                if (str9 != null) {
                    if (str9.equals(IcyHeaders.a3)) {
                        str = CSS.Value.Z;
                    } else if (str9.equals(ExifInterface.Y4)) {
                        str = CSS.Value.a0;
                    } else if (str9.equals(ExifInterface.Z4)) {
                        g2.put("font-size", "small");
                    } else if (str9.equals("4")) {
                        str = "medium";
                    } else if (str9.equals("5")) {
                        str = CSS.Value.c0;
                    } else if (str9.equals("6")) {
                        str = CSS.Value.d0;
                    } else if (str9.equals("7")) {
                        str = CSS.Value.e0;
                    }
                    g2.put("font-size", str);
                }
            } else if (tag.o().equals("a")) {
                g2.put("text-decoration", "underline");
                g2.put("color", "blue");
            }
        }
        for (Map.Entry entry2 : linkedHashMap.entrySet()) {
            if (!CSS.Value.N.equalsIgnoreCase((String) entry2.getValue())) {
                if (((String) entry2.getKey()).equals("text-decoration")) {
                    g2.put(entry2.getKey(), h(g2.get(entry2.getKey()), (String) entry2.getValue()));
                } else {
                    g2.put(entry2.getKey(), entry2.getValue());
                }
            }
        }
    }

    public void c(FileRetrieve fileRetrieve) {
        this.f27521d = fileRetrieve;
    }

    public CSSResolver clear() throws CssResolverException {
        this.f27520c.clear();
        return this;
    }

    public void d(String str, boolean z) throws CssResolverException {
        CssFileProcessor cssFileProcessor = new CssFileProcessor();
        try {
            this.f27521d.b(str, cssFileProcessor);
            CssFile b2 = cssFileProcessor.b();
            b2.b(z);
            this.f27520c.a(b2);
        } catch (IOException e2) {
            throw new CssResolverException((Throwable) e2);
        }
    }

    public void e(String str, boolean z) throws CssResolverException {
        CssFileProcessor cssFileProcessor = new CssFileProcessor();
        try {
            new FileRetrieveImpl().a(new ByteArrayInputStream(str.getBytes()), cssFileProcessor);
            CssFile b2 = cssFileProcessor.b();
            b2.b(z);
            this.f27520c.a(b2);
        } catch (UnsupportedEncodingException e2) {
            throw new CssResolverException((Throwable) e2);
        } catch (IOException e3) {
            throw new CssResolverException((Throwable) e3);
        }
    }

    public void f(String str, String str2, boolean z) throws CssResolverException {
        CssFileProcessor cssFileProcessor = new CssFileProcessor();
        try {
            this.f27521d.a(new ByteArrayInputStream(str.getBytes(str2)), cssFileProcessor);
            CssFile b2 = cssFileProcessor.b();
            b2.b(z);
            this.f27520c.a(b2);
        } catch (UnsupportedEncodingException e2) {
            throw new CssResolverException((Throwable) e2);
        } catch (IOException e3) {
            throw new CssResolverException((Throwable) e3);
        }
    }

    public void j(CssInheritanceRules cssInheritanceRules) {
        this.f27519b = cssInheritanceRules;
    }

    public void k(CssInheritanceRules cssInheritanceRules) {
        this.f27519b = cssInheritanceRules;
    }

    public StyleAttrCSSResolver(CssFiles cssFiles) {
        this(cssFiles, CssUtils.g());
    }

    public StyleAttrCSSResolver(CssFiles cssFiles, CssUtils cssUtils) {
        this(new DefaultCssInheritanceRules(), cssFiles, cssUtils);
    }

    public StyleAttrCSSResolver(CssFiles cssFiles, FileRetrieve fileRetrieve) {
        this(new DefaultCssInheritanceRules(), cssFiles, CssUtils.g(), fileRetrieve);
    }

    public StyleAttrCSSResolver(CssInheritanceRules cssInheritanceRules, CssFiles cssFiles, CssUtils cssUtils) {
        this(cssInheritanceRules, cssFiles, cssUtils, new FileRetrieveImpl());
    }

    public StyleAttrCSSResolver(CssInheritanceRules cssInheritanceRules, CssFiles cssFiles, CssUtils cssUtils, FileRetrieve fileRetrieve) {
        this.f27518a = cssUtils;
        this.f27520c = cssFiles;
        this.f27519b = cssInheritanceRules;
        this.f27521d = fileRetrieve;
    }
}
