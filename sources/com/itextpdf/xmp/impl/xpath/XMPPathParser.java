package com.itextpdf.xmp.impl.xpath;

import com.itextpdf.xmp.XMPException;
import com.itextpdf.xmp.XMPMetaFactory;
import com.itextpdf.xmp.impl.Utils;
import com.itextpdf.xmp.properties.XMPAliasInfo;

public final class XMPPathParser {
    private XMPPathParser() {
    }

    public static XMPPath a(String str, String str2) throws XMPException {
        if (str == null || str2 == null) {
            throw new XMPException("Parameter must not be null", 4);
        }
        XMPPath xMPPath = new XMPPath();
        PathPosition pathPosition = new PathPosition();
        pathPosition.f27784a = str2;
        c(str, pathPosition, xMPPath);
        while (pathPosition.f27788e < str2.length()) {
            pathPosition.f27787d = pathPosition.f27788e;
            e(str2, pathPosition);
            int i2 = pathPosition.f27787d;
            pathPosition.f27788e = i2;
            XMPPathSegment d2 = str2.charAt(i2) != '[' ? d(pathPosition) : b(pathPosition);
            if (d2.b() == 1) {
                if (d2.c().charAt(0) == '@') {
                    d2.h("?" + d2.c().substring(1));
                    if (!"?xml:lang".equals(d2.c())) {
                        throw new XMPException("Only xml:lang allowed with '@'", 102);
                    }
                }
                if (d2.c().charAt(0) == '?') {
                    pathPosition.f27785b++;
                    d2.g(2);
                }
            } else {
                if (d2.b() != 6) {
                    continue;
                } else {
                    if (d2.c().charAt(1) == '@') {
                        d2.h("[?" + d2.c().substring(2));
                        if (!d2.c().startsWith("[?xml:lang=")) {
                            throw new XMPException("Only xml:lang allowed with '@'", 102);
                        }
                    }
                    if (d2.c().charAt(1) == '?') {
                        pathPosition.f27785b++;
                        d2.g(5);
                    }
                }
                xMPPath.a(d2);
            }
            f(pathPosition.f27784a.substring(pathPosition.f27785b, pathPosition.f27786c));
            xMPPath.a(d2);
        }
        return xMPPath;
    }

    private static XMPPathSegment b(PathPosition pathPosition) throws XMPException {
        XMPPathSegment xMPPathSegment;
        int i2 = pathPosition.f27788e + 1;
        pathPosition.f27788e = i2;
        if ('0' > pathPosition.f27784a.charAt(i2) || pathPosition.f27784a.charAt(pathPosition.f27788e) > '9') {
            while (pathPosition.f27788e < pathPosition.f27784a.length() && pathPosition.f27784a.charAt(pathPosition.f27788e) != ']' && pathPosition.f27784a.charAt(pathPosition.f27788e) != '=') {
                pathPosition.f27788e++;
            }
            if (pathPosition.f27788e >= pathPosition.f27784a.length()) {
                throw new XMPException("Missing ']' or '=' for array index", 102);
            } else if (pathPosition.f27784a.charAt(pathPosition.f27788e) != ']') {
                pathPosition.f27785b = pathPosition.f27787d + 1;
                int i3 = pathPosition.f27788e;
                pathPosition.f27786c = i3;
                int i4 = i3 + 1;
                pathPosition.f27788e = i4;
                char charAt = pathPosition.f27784a.charAt(i4);
                if (charAt == '\'' || charAt == '\"') {
                    while (true) {
                        pathPosition.f27788e++;
                        if (pathPosition.f27788e < pathPosition.f27784a.length()) {
                            if (pathPosition.f27784a.charAt(pathPosition.f27788e) == charAt) {
                                if (pathPosition.f27788e + 1 >= pathPosition.f27784a.length() || pathPosition.f27784a.charAt(pathPosition.f27788e + 1) != charAt) {
                                    break;
                                }
                                pathPosition.f27788e++;
                            }
                        } else {
                            break;
                        }
                    }
                    if (pathPosition.f27788e < pathPosition.f27784a.length()) {
                        pathPosition.f27788e++;
                        xMPPathSegment = new XMPPathSegment((String) null, 6);
                    } else {
                        throw new XMPException("No terminating quote for array selector", 102);
                    }
                } else {
                    throw new XMPException("Invalid quote in array selector", 102);
                }
            } else if ("[last()".equals(pathPosition.f27784a.substring(pathPosition.f27787d, pathPosition.f27788e))) {
                xMPPathSegment = new XMPPathSegment((String) null, 4);
            } else {
                throw new XMPException("Invalid non-numeric array index", 102);
            }
        } else {
            while (pathPosition.f27788e < pathPosition.f27784a.length() && '0' <= pathPosition.f27784a.charAt(pathPosition.f27788e) && pathPosition.f27784a.charAt(pathPosition.f27788e) <= '9') {
                pathPosition.f27788e++;
            }
            xMPPathSegment = new XMPPathSegment((String) null, 3);
        }
        if (pathPosition.f27788e >= pathPosition.f27784a.length() || pathPosition.f27784a.charAt(pathPosition.f27788e) != ']') {
            throw new XMPException("Missing ']' for array index", 102);
        }
        int i5 = pathPosition.f27788e + 1;
        pathPosition.f27788e = i5;
        xMPPathSegment.h(pathPosition.f27784a.substring(pathPosition.f27787d, i5));
        return xMPPathSegment;
    }

    private static void c(String str, PathPosition pathPosition, XMPPath xMPPath) throws XMPException {
        XMPPathSegment xMPPathSegment;
        while (pathPosition.f27788e < pathPosition.f27784a.length() && "/[*".indexOf(pathPosition.f27784a.charAt(pathPosition.f27788e)) < 0) {
            pathPosition.f27788e++;
        }
        int i2 = pathPosition.f27788e;
        int i3 = pathPosition.f27787d;
        if (i2 != i3) {
            String h2 = h(str, pathPosition.f27784a.substring(i3, i2));
            XMPAliasInfo h3 = XMPMetaFactory.c().h(h2);
            if (h3 == null) {
                xMPPath.a(new XMPPathSegment(str, Integer.MIN_VALUE));
                xMPPathSegment = new XMPPathSegment(h2, 1);
            } else {
                xMPPath.a(new XMPPathSegment(h3.a(), Integer.MIN_VALUE));
                XMPPathSegment xMPPathSegment2 = new XMPPathSegment(h(h3.a(), h3.c()), 1);
                xMPPathSegment2.e(true);
                xMPPathSegment2.f(h3.d().i());
                xMPPath.a(xMPPathSegment2);
                if (h3.d().q()) {
                    xMPPathSegment = new XMPPathSegment("[?xml:lang='x-default']", 5);
                } else if (h3.d().p()) {
                    xMPPathSegment = new XMPPathSegment("[1]", 3);
                } else {
                    return;
                }
                xMPPathSegment.e(true);
                xMPPathSegment.f(h3.d().i());
            }
            xMPPath.a(xMPPathSegment);
            return;
        }
        throw new XMPException("Empty initial XMPPath step", 102);
    }

    private static XMPPathSegment d(PathPosition pathPosition) throws XMPException {
        pathPosition.f27785b = pathPosition.f27787d;
        while (pathPosition.f27788e < pathPosition.f27784a.length() && "/[*".indexOf(pathPosition.f27784a.charAt(pathPosition.f27788e)) < 0) {
            pathPosition.f27788e++;
        }
        int i2 = pathPosition.f27788e;
        pathPosition.f27786c = i2;
        int i3 = pathPosition.f27787d;
        if (i2 != i3) {
            return new XMPPathSegment(pathPosition.f27784a.substring(i3, i2), 1);
        }
        throw new XMPException("Empty XMPPath segment", 102);
    }

    private static void e(String str, PathPosition pathPosition) throws XMPException {
        if (str.charAt(pathPosition.f27787d) == '/') {
            int i2 = pathPosition.f27787d + 1;
            pathPosition.f27787d = i2;
            if (i2 >= str.length()) {
                throw new XMPException("Empty XMPPath segment", 102);
            }
        }
        if (str.charAt(pathPosition.f27787d) == '*') {
            int i3 = pathPosition.f27787d + 1;
            pathPosition.f27787d = i3;
            if (i3 >= str.length() || str.charAt(pathPosition.f27787d) != '[') {
                throw new XMPException("Missing '[' after '*'", 102);
            }
        }
    }

    private static void f(String str) throws XMPException {
        int indexOf = str.indexOf(58);
        if (indexOf > 0) {
            String substring = str.substring(0, indexOf);
            if (Utils.i(substring)) {
                if (XMPMetaFactory.c().c(substring) == null) {
                    throw new XMPException("Unknown namespace prefix for qualified name", 102);
                }
                return;
            }
        }
        throw new XMPException("Ill-formed qualified name", 102);
    }

    private static void g(String str) throws XMPException {
        if (!Utils.h(str)) {
            throw new XMPException("Bad XML name", 102);
        }
    }

    private static String h(String str, String str2) throws XMPException {
        if (str == null || str.length() == 0) {
            throw new XMPException("Schema namespace URI is required", 101);
        } else if (str2.charAt(0) == '?' || str2.charAt(0) == '@') {
            throw new XMPException("Top level name must not be a qualifier", 102);
        } else if (str2.indexOf(47) >= 0 || str2.indexOf(91) >= 0) {
            throw new XMPException("Top level name must be simple", 102);
        } else {
            String b2 = XMPMetaFactory.c().b(str);
            if (b2 != null) {
                int indexOf = str2.indexOf(58);
                if (indexOf < 0) {
                    g(str2);
                    return b2 + str2;
                }
                g(str2.substring(0, indexOf));
                g(str2.substring(indexOf));
                String substring = str2.substring(0, indexOf + 1);
                String b3 = XMPMetaFactory.c().b(str);
                if (b3 == null) {
                    throw new XMPException("Unknown schema namespace prefix", 101);
                } else if (substring.equals(b3)) {
                    return str2;
                } else {
                    throw new XMPException("Schema namespace URI and prefix mismatch", 101);
                }
            } else {
                throw new XMPException("Unregistered schema namespace URI", 101);
            }
        }
    }
}
