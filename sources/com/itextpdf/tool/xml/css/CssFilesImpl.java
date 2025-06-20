package com.itextpdf.tool.xml.css;

import com.itextpdf.tool.xml.Tag;
import com.itextpdf.tool.xml.css.CSS;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class CssFilesImpl implements CssFiles {

    /* renamed from: a  reason: collision with root package name */
    private final List<CssFile> f27492a;

    /* renamed from: b  reason: collision with root package name */
    private final CssUtils f27493b;

    public CssFilesImpl() {
        this.f27492a = new ArrayList();
        this.f27493b = CssUtils.g();
    }

    public void a(CssFile cssFile) {
        if (cssFile != null) {
            this.f27492a.add(cssFile);
        }
    }

    public Map<String, String> b(Tag tag) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        d(tag, linkedHashMap);
        return linkedHashMap;
    }

    public boolean c() {
        return !this.f27492a.isEmpty();
    }

    public void clear() {
        Iterator<CssFile> it2 = this.f27492a.iterator();
        while (it2.hasNext()) {
            if (!it2.next().d()) {
                it2.remove();
            }
        }
    }

    public void d(Tag tag, Map<String, String> map) {
        ArrayList<CssRule> arrayList = new ArrayList<>();
        for (CssFile a2 : this.f27492a) {
            arrayList.addAll(a2.a(tag));
        }
        Collections.sort(arrayList);
        for (CssRule c2 : arrayList) {
            e(map, c2.c());
        }
        for (CssRule b2 : arrayList) {
            e(map, b2.b());
        }
    }

    public void e(Map<String, String> map, Map<String, String> map2) {
        Map<String, String> v;
        CssUtils cssUtils;
        String str;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry next : map2.entrySet()) {
            String y = this.f27493b.y((String) next.getKey());
            String x = this.f27493b.x((String) next.getValue());
            if ("border".equalsIgnoreCase(y)) {
                v = this.f27493b.l(x);
            } else {
                String str2 = CSS.Property.s;
                if (!str2.equalsIgnoreCase(y)) {
                    str2 = CSS.Property.u;
                    if (!str2.equalsIgnoreCase(y)) {
                        str2 = CSS.Property.r;
                        if (!str2.equalsIgnoreCase(y)) {
                            str2 = CSS.Property.t;
                            if (!str2.equalsIgnoreCase(y)) {
                                if (CSS.Property.f27468k.equalsIgnoreCase(y)) {
                                    Map<String, String> n2 = this.f27493b.n(x, "margin-", "");
                                    for (String next2 : n2.keySet()) {
                                        if (!linkedHashMap.containsKey(next2)) {
                                            linkedHashMap.put(next2, n2.get(next2));
                                        }
                                    }
                                } else {
                                    if (CSS.Property.v.equalsIgnoreCase(y)) {
                                        cssUtils = this.f27493b;
                                        str = "-width";
                                    } else if (CSS.Property.w.equalsIgnoreCase(y)) {
                                        cssUtils = this.f27493b;
                                        str = "-style";
                                    } else if (CSS.Property.x.equalsIgnoreCase(y)) {
                                        cssUtils = this.f27493b;
                                        str = "-color";
                                    } else if (CSS.Property.M.equalsIgnoreCase(y)) {
                                        Map<String, String> n3 = this.f27493b.n(x, "padding-", "");
                                        for (String next3 : n3.keySet()) {
                                            if (!linkedHashMap.containsKey(next3)) {
                                                linkedHashMap.put(next3, n3.get(next3));
                                            }
                                        }
                                    } else if ("font".equalsIgnoreCase(y)) {
                                        v = this.f27493b.u(x);
                                    } else if (CSS.Property.f27464g.equalsIgnoreCase(y)) {
                                        v = this.f27493b.v(x);
                                    } else if (y.toLowerCase().contains(CSS.Property.f27458a)) {
                                        Map<String, String> t = this.f27493b.t(x);
                                        for (String next4 : t.keySet()) {
                                            if (!linkedHashMap.containsKey(next4)) {
                                                linkedHashMap.put(next4, t.get(next4));
                                            }
                                        }
                                    } else {
                                        linkedHashMap.put(y, x);
                                    }
                                    v = cssUtils.n(x, "border-", str);
                                }
                            }
                        }
                    }
                }
                v = this.f27493b.m(x, str2);
            }
            linkedHashMap.putAll(v);
        }
        map.putAll(linkedHashMap);
    }

    public CssFilesImpl(CssFile cssFile) {
        this();
        a(cssFile);
    }
}
