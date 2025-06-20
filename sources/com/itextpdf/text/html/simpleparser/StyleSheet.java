package com.itextpdf.text.html.simpleparser;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.html.HtmlTags;
import com.itextpdf.text.html.HtmlUtilities;
import com.itextpdf.tool.xml.css.CSS;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

@Deprecated
public class StyleSheet {

    /* renamed from: a  reason: collision with root package name */
    protected Map<String, Map<String, String>> f25767a = new HashMap();

    /* renamed from: b  reason: collision with root package name */
    protected Map<String, Map<String, String>> f25768b = new HashMap();

    public static void f(Map<String, String> map, ChainedProperties chainedProperties) {
        String str;
        String str2;
        String str3;
        StringBuilder sb;
        String str4;
        String str5;
        String str6 = map.get("style");
        if (str6 != null) {
            Properties e2 = HtmlUtilities.e(str6);
            for (String str7 : e2.keySet()) {
                if (str7.equals("font-family")) {
                    str = "face";
                    str2 = e2.getProperty(str7);
                } else {
                    String str8 = "size";
                    float f2 = 12.0f;
                    if (str7.equals("font-size")) {
                        float g2 = HtmlUtilities.g(chainedProperties.c(str8), 12.0f);
                        if (g2 > 0.0f) {
                            f2 = g2;
                        }
                        sb = new StringBuilder();
                        sb.append(Float.toString(HtmlUtilities.g(e2.getProperty(str7), f2)));
                        str4 = CSS.Value.l0;
                    } else {
                        if (str7.equals("font-style")) {
                            String lowerCase = e2.getProperty(str7).trim().toLowerCase();
                            if (lowerCase.equals("italic") || lowerCase.equals("oblique")) {
                                str5 = "i";
                            }
                        } else if (str7.equals("font-weight")) {
                            String lowerCase2 = e2.getProperty(str7).trim().toLowerCase();
                            if (lowerCase2.equals("bold") || lowerCase2.equals("700") || lowerCase2.equals("800") || lowerCase2.equals("900")) {
                                str5 = "b";
                            }
                        } else if (!str7.equals("text-decoration")) {
                            str = "color";
                            if (str7.equals(str)) {
                                BaseColor b2 = HtmlUtilities.b(e2.getProperty(str7));
                                if (b2 != null) {
                                    String str9 = "000000" + Integer.toHexString(b2.f());
                                    str2 = "#" + str9.substring(str9.length() - 6);
                                }
                            } else if (str7.equals("line-height")) {
                                String trim = e2.getProperty(str7).trim();
                                float g3 = HtmlUtilities.g(chainedProperties.c(str8), 12.0f);
                                if (g3 > 0.0f) {
                                    f2 = g3;
                                }
                                float g4 = HtmlUtilities.g(e2.getProperty(str7), f2);
                                boolean endsWith = trim.endsWith(CSS.Value.n0);
                                str8 = HtmlTags.U;
                                if (endsWith) {
                                    str3 = "0," + (g4 / 100.0f);
                                } else if (HtmlTags.y0.equalsIgnoreCase(trim)) {
                                    str3 = "0,1.5";
                                } else {
                                    sb = new StringBuilder();
                                    sb.append(g4);
                                    str4 = ",0";
                                }
                                map.put(str8, str3);
                                return;
                            } else if (str7.equals("text-align")) {
                                str2 = e2.getProperty(str7).trim().toLowerCase();
                                str = "align";
                            } else if (str7.equals("padding-left")) {
                                str2 = Float.toString(HtmlUtilities.f(e2.getProperty(str7).trim().toLowerCase()));
                                str = "indent";
                            }
                        } else if (e2.getProperty(str7).trim().toLowerCase().equals("underline")) {
                            str5 = "u";
                        }
                        map.put(str5, (Object) null);
                    }
                    sb.append(str4);
                    map.put(str8, sb.toString());
                }
                map.put(str, str2);
            }
        }
    }

    public void a(String str, Map<String, String> map) {
        Map map2;
        Map map3 = this.f25767a.get(str.toLowerCase());
        if (map3 != null) {
            HashMap hashMap = new HashMap(map3);
            hashMap.putAll(map);
            map.putAll(hashMap);
        }
        String str2 = map.get("class");
        if (str2 != null && (map2 = this.f25768b.get(str2.toLowerCase())) != null) {
            map.remove("class");
            HashMap hashMap2 = new HashMap(map2);
            hashMap2.putAll(map);
            map.putAll(hashMap2);
        }
    }

    public void b(String str, String str2, String str3) {
        String lowerCase = str.toLowerCase();
        Map map = this.f25768b.get(lowerCase);
        if (map == null) {
            map = new HashMap();
            this.f25768b.put(lowerCase, map);
        }
        map.put(str2, str3);
    }

    public void c(String str, HashMap<String, String> hashMap) {
        this.f25768b.put(str.toLowerCase(), hashMap);
    }

    public void d(String str, String str2, String str3) {
        String lowerCase = str.toLowerCase();
        Map map = this.f25767a.get(lowerCase);
        if (map == null) {
            map = new HashMap();
            this.f25767a.put(lowerCase, map);
        }
        map.put(str2, str3);
    }

    public void e(String str, Map<String, String> map) {
        this.f25767a.put(str.toLowerCase(), map);
    }
}
