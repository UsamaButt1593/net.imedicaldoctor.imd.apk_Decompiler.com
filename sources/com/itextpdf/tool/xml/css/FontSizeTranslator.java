package com.itextpdf.tool.xml.css;

import com.itextpdf.tool.xml.Tag;
import com.itextpdf.tool.xml.css.CSS;

public class FontSizeTranslator {

    /* renamed from: a  reason: collision with root package name */
    public static final float f27513a = 12.0f;

    /* renamed from: b  reason: collision with root package name */
    private static CssUtils f27514b = CssUtils.g();

    /* renamed from: c  reason: collision with root package name */
    private static FontSizeTranslator f27515c;

    public static synchronized FontSizeTranslator b() {
        FontSizeTranslator fontSizeTranslator;
        synchronized (FontSizeTranslator.class) {
            try {
                if (f27515c == null) {
                    f27515c = new FontSizeTranslator();
                }
                fontSizeTranslator = f27515c;
            } catch (Throwable th) {
                while (true) {
                    throw th;
                }
            }
        }
        return fontSizeTranslator;
    }

    public float a(Tag tag) {
        String str = tag.g().get("font-size");
        if (str != null) {
            return Float.parseFloat(str.replace(CSS.Value.l0, ""));
        }
        return -1.0f;
    }

    public float c(Tag tag) {
        if (tag.g().get("font-size") == null) {
            return -1.0f;
        }
        String str = tag.g().get("font-size");
        if (!str.equalsIgnoreCase(CSS.Value.Z)) {
            if (!str.equalsIgnoreCase(CSS.Value.a0)) {
                if (!str.equalsIgnoreCase("small")) {
                    float f2 = 12.0f;
                    if (!str.equalsIgnoreCase("medium")) {
                        if (!str.equalsIgnoreCase(CSS.Value.c0)) {
                            if (!str.equalsIgnoreCase(CSS.Value.d0)) {
                                if (!str.equalsIgnoreCase(CSS.Value.e0)) {
                                    if (str.equalsIgnoreCase(CSS.Value.f0)) {
                                        if (tag.r() != null) {
                                            float a2 = a(tag.r());
                                            if (a2 != -1.0f) {
                                                if (a2 <= 6.75f) {
                                                    return a2 - 1.0f;
                                                }
                                                if (a2 != 7.5f) {
                                                    if (a2 != 9.75f) {
                                                        if (a2 != 12.0f) {
                                                            if (a2 != 13.5f) {
                                                                if (a2 != 18.0f) {
                                                                    int i2 = (a2 > 24.0f ? 1 : (a2 == 24.0f ? 0 : -1));
                                                                    if (i2 != 0) {
                                                                        if (a2 < 24.0f) {
                                                                            return a2 * 0.85f;
                                                                        }
                                                                        if (i2 >= 0) {
                                                                            return (a2 * 2.0f) / 3.0f;
                                                                        }
                                                                        return -1.0f;
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    } else if (str.equalsIgnoreCase(CSS.Value.g0)) {
                                        if (tag.r() != null) {
                                            float a3 = a(tag.r());
                                            if (a3 != -1.0f) {
                                                if (a3 != 6.75f) {
                                                    if (a3 != 7.5f) {
                                                        if (a3 != 9.75f) {
                                                            if (a3 != 12.0f) {
                                                                if (a3 != 13.5f) {
                                                                    if (a3 != 18.0f) {
                                                                        return a3 * 1.5f;
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    } else if (f27514b.i(str) || f27514b.j(str)) {
                                        return f27514b.p(str);
                                    } else {
                                        if (!f27514b.k(str)) {
                                            return -1.0f;
                                        }
                                        float a4 = tag.r() != null ? a(tag.r()) : -1.0f;
                                        if (a4 != -1.0f) {
                                            f2 = a4;
                                        }
                                        return f27514b.r(str, f2);
                                    }
                                }
                                return 24.0f;
                            }
                            return 18.0f;
                        }
                        return 13.5f;
                    }
                    return 12.0f;
                }
                return 9.75f;
            }
            return 7.5f;
        }
        return 6.75f;
    }
}
