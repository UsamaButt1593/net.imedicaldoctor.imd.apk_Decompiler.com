package com.itextpdf.xmp.impl;

import androidx.exifinterface.media.ExifInterface;
import com.dd.plist.ASCIIPropertyListParser;
import com.itextpdf.text.xml.xmp.DublinCoreProperties;
import com.itextpdf.text.xml.xmp.DublinCoreSchema;
import com.itextpdf.text.xml.xmp.PdfProperties;
import com.itextpdf.text.xml.xmp.PdfSchema;
import com.itextpdf.text.xml.xmp.XmpBasicProperties;
import com.itextpdf.text.xml.xmp.XmpBasicSchema;
import com.itextpdf.text.xml.xmp.XmpMMSchema;
import com.itextpdf.tool.xml.html.HTML;
import com.itextpdf.xmp.XMPConst;
import com.itextpdf.xmp.XMPException;
import com.itextpdf.xmp.XMPSchemaRegistry;
import com.itextpdf.xmp.options.AliasOptions;
import com.itextpdf.xmp.properties.XMPAliasInfo;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.regex.Pattern;

public final class XMPSchemaRegistryImpl implements XMPSchemaRegistry, XMPConst {
    private Map X = new HashMap();
    private Map Y = new HashMap();
    private Pattern Z = Pattern.compile("[/*?\\[\\]]");
    private Map s = new HashMap();

    public XMPSchemaRegistryImpl() {
        try {
            m();
            l();
        } catch (XMPException unused) {
            throw new RuntimeException("The XMPSchemaRegistry cannot be initialized!");
        }
    }

    private void l() throws XMPException {
        AliasOptions x = new AliasOptions().x(true);
        AliasOptions v = new AliasOptions().v(true);
        k("http://ns.adobe.com/xap/1.0/", "Author", "http://purl.org/dc/elements/1.1/", DublinCoreProperties.f27397c, x);
        k("http://ns.adobe.com/xap/1.0/", "Authors", "http://purl.org/dc/elements/1.1/", DublinCoreProperties.f27397c, (AliasOptions) null);
        k("http://ns.adobe.com/xap/1.0/", "Description", "http://purl.org/dc/elements/1.1/", DublinCoreProperties.f27399e, (AliasOptions) null);
        k("http://ns.adobe.com/xap/1.0/", "Format", "http://purl.org/dc/elements/1.1/", DublinCoreProperties.f27400f, (AliasOptions) null);
        k("http://ns.adobe.com/xap/1.0/", PdfProperties.f27409a, "http://purl.org/dc/elements/1.1/", "subject", (AliasOptions) null);
        k("http://ns.adobe.com/xap/1.0/", "Locale", "http://purl.org/dc/elements/1.1/", DublinCoreProperties.f27402h, (AliasOptions) null);
        k("http://ns.adobe.com/xap/1.0/", "Title", "http://purl.org/dc/elements/1.1/", "title", (AliasOptions) null);
        k(XMPConst.p1, ExifInterface.a0, "http://purl.org/dc/elements/1.1/", DublinCoreProperties.f27405k, (AliasOptions) null);
        k("http://ns.adobe.com/pdf/1.3/", "Author", "http://purl.org/dc/elements/1.1/", DublinCoreProperties.f27397c, x);
        k("http://ns.adobe.com/pdf/1.3/", XmpBasicProperties.f27414b, "http://ns.adobe.com/xap/1.0/", XmpBasicProperties.f27414b, (AliasOptions) null);
        k("http://ns.adobe.com/pdf/1.3/", "CreationDate", "http://ns.adobe.com/xap/1.0/", XmpBasicProperties.f27415c, (AliasOptions) null);
        k("http://ns.adobe.com/pdf/1.3/", "Creator", "http://ns.adobe.com/xap/1.0/", XmpBasicProperties.f27416d, (AliasOptions) null);
        k("http://ns.adobe.com/pdf/1.3/", "ModDate", "http://ns.adobe.com/xap/1.0/", XmpBasicProperties.f27419g, (AliasOptions) null);
        AliasOptions aliasOptions = v;
        k("http://ns.adobe.com/pdf/1.3/", "Subject", "http://purl.org/dc/elements/1.1/", DublinCoreProperties.f27399e, aliasOptions);
        k("http://ns.adobe.com/pdf/1.3/", "Title", "http://purl.org/dc/elements/1.1/", "title", aliasOptions);
        k(XMPConst.D1, "Author", "http://purl.org/dc/elements/1.1/", DublinCoreProperties.f27397c, x);
        k(XMPConst.D1, "Caption", "http://purl.org/dc/elements/1.1/", DublinCoreProperties.f27399e, aliasOptions);
        k(XMPConst.D1, ExifInterface.a0, "http://purl.org/dc/elements/1.1/", DublinCoreProperties.f27405k, aliasOptions);
        k(XMPConst.D1, PdfProperties.f27409a, "http://purl.org/dc/elements/1.1/", "subject", (AliasOptions) null);
        k(XMPConst.D1, "Marked", XMPConst.p1, "Marked", (AliasOptions) null);
        k(XMPConst.D1, "Title", "http://purl.org/dc/elements/1.1/", "title", v);
        k(XMPConst.D1, "WebStatement", XMPConst.p1, "WebStatement", (AliasOptions) null);
        k(XMPConst.I1, ExifInterface.Z, "http://purl.org/dc/elements/1.1/", DublinCoreProperties.f27397c, x);
        k(XMPConst.I1, ExifInterface.a0, "http://purl.org/dc/elements/1.1/", DublinCoreProperties.f27405k, (AliasOptions) null);
        k(XMPConst.I1, ExifInterface.U, "http://ns.adobe.com/xap/1.0/", XmpBasicProperties.f27419g, (AliasOptions) null);
        k(XMPConst.I1, ExifInterface.V, "http://purl.org/dc/elements/1.1/", DublinCoreProperties.f27399e, (AliasOptions) null);
        k(XMPConst.I1, ExifInterface.Y, "http://ns.adobe.com/xap/1.0/", XmpBasicProperties.f27416d, (AliasOptions) null);
        k(XMPConst.J1, "Author", "http://purl.org/dc/elements/1.1/", DublinCoreProperties.f27397c, x);
        k(XMPConst.J1, ExifInterface.a0, "http://purl.org/dc/elements/1.1/", DublinCoreProperties.f27405k, v);
        k(XMPConst.J1, "CreationTime", "http://ns.adobe.com/xap/1.0/", XmpBasicProperties.f27415c, (AliasOptions) null);
        k(XMPConst.J1, "Description", "http://purl.org/dc/elements/1.1/", DublinCoreProperties.f27399e, v);
        k(XMPConst.J1, "ModificationTime", "http://ns.adobe.com/xap/1.0/", XmpBasicProperties.f27419g, (AliasOptions) null);
        k(XMPConst.J1, ExifInterface.Y, "http://ns.adobe.com/xap/1.0/", XmpBasicProperties.f27416d, (AliasOptions) null);
        k(XMPConst.J1, "Title", "http://purl.org/dc/elements/1.1/", "title", v);
    }

    private void m() throws XMPException {
        g(XMPConst.f1, HTML.Tag.f27613a);
        g(XMPConst.g1, "rdf");
        g("http://purl.org/dc/elements/1.1/", DublinCoreSchema.Z);
        g(XMPConst.i1, "Iptc4xmpCore");
        g(XMPConst.j1, "Iptc4xmpExt");
        g(XMPConst.k1, "DICOM");
        g(XMPConst.l1, "plus");
        g(XMPConst.m1, "x");
        g(XMPConst.n1, "iX");
        g("http://ns.adobe.com/xap/1.0/", XmpBasicSchema.Z);
        g(XMPConst.p1, "xmpRights");
        g("http://ns.adobe.com/xap/1.0/mm/", XmpMMSchema.Z);
        g(XMPConst.r1, "xmpBJ");
        g(XMPConst.s1, "xmpNote");
        g("http://ns.adobe.com/pdf/1.3/", PdfSchema.Z);
        g(XMPConst.u1, "pdfx");
        g(XMPConst.v1, "pdfxid");
        g(XMPConst.w1, "pdfaSchema");
        g(XMPConst.x1, "pdfaProperty");
        g(XMPConst.y1, "pdfaType");
        g(XMPConst.z1, "pdfaField");
        g(XMPConst.A1, "pdfaid");
        g(XMPConst.B1, "pdfuaid");
        g(XMPConst.C1, "pdfaExtension");
        g(XMPConst.D1, "photoshop");
        g(XMPConst.E1, "album");
        g(XMPConst.F1, "exif");
        g(XMPConst.G1, "exifEX");
        g(XMPConst.H1, "aux");
        g(XMPConst.I1, "tiff");
        g(XMPConst.J1, "png");
        g(XMPConst.K1, "jpeg");
        g(XMPConst.L1, "jp2k");
        g(XMPConst.M1, "crs");
        g(XMPConst.N1, "bmsp");
        g(XMPConst.O1, "creatorAtom");
        g(XMPConst.P1, "asf");
        g(XMPConst.Q1, "wav");
        g(XMPConst.R1, "bext");
        g(XMPConst.S1, "riffinfo");
        g(XMPConst.T1, "xmpScript");
        g(XMPConst.U1, "txmp");
        g(XMPConst.V1, "swf");
        g(XMPConst.W1, "xmpDM");
        g(XMPConst.X1, "xmpx");
        g(XMPConst.b2, "xmpT");
        g(XMPConst.c2, "xmpTPg");
        g(XMPConst.d2, "xmpG");
        g(XMPConst.e2, "xmpGImg");
        g(XMPConst.f2, "stFnt");
        g(XMPConst.a2, "stDim");
        g(XMPConst.g2, "stEvt");
        g(XMPConst.h2, "stRef");
        g(XMPConst.i2, "stVer");
        g(XMPConst.j2, "stJob");
        g(XMPConst.k2, "stMfs");
        g(XMPConst.Z1, "xmpidq");
    }

    public synchronized Map a() {
        return Collections.unmodifiableMap(new TreeMap(this.s));
    }

    public synchronized String b(String str) {
        return (String) this.s.get(str);
    }

    public synchronized String c(String str) {
        if (str != null) {
            try {
                if (!str.endsWith(":")) {
                    str = str + ":";
                }
            } catch (Throwable th) {
                while (true) {
                    throw th;
                }
            }
        }
        return (String) this.X.get(str);
    }

    public synchronized XMPAliasInfo d(String str, String str2) {
        String b2 = b(str);
        if (b2 == null) {
            return null;
        }
        Map map = this.Y;
        return (XMPAliasInfo) map.get(b2 + str2);
    }

    public synchronized void e(String str) {
        String b2 = b(str);
        if (b2 != null) {
            this.s.remove(str);
            this.X.remove(b2);
        }
    }

    public synchronized Map f() {
        return Collections.unmodifiableMap(new TreeMap(this.Y));
    }

    public synchronized String g(String str, String str2) throws XMPException {
        try {
            ParameterAsserts.f(str);
            ParameterAsserts.d(str2);
            if (str2.charAt(str2.length() - 1) != ':') {
                str2 = str2 + ASCIIPropertyListParser.A;
            }
            if (Utils.i(str2.substring(0, str2.length() - 1))) {
                String str3 = (String) this.s.get(str);
                String str4 = (String) this.X.get(str2);
                if (str3 != null) {
                    return str3;
                }
                if (str4 != null) {
                    String str5 = str2;
                    int i2 = 1;
                    while (this.X.containsKey(str5)) {
                        str5 = str2.substring(0, str2.length() - 1) + "_" + i2 + "_:";
                        i2++;
                    }
                    str2 = str5;
                }
                this.X.put(str2, str);
                this.s.put(str, str2);
                return str2;
            }
            throw new XMPException("The prefix is a bad XML name", 201);
        } finally {
        }
    }

    public synchronized XMPAliasInfo h(String str) {
        return (XMPAliasInfo) this.Y.get(str);
    }

    public synchronized XMPAliasInfo[] i(String str) {
        ArrayList arrayList;
        try {
            String b2 = b(str);
            arrayList = new ArrayList();
            if (b2 != null) {
                for (String str2 : this.Y.keySet()) {
                    if (str2.startsWith(b2)) {
                        arrayList.add(h(str2));
                    }
                }
            }
        } finally {
            while (true) {
            }
        }
        return (XMPAliasInfo[]) arrayList.toArray(new XMPAliasInfo[arrayList.size()]);
    }

    public synchronized Map j() {
        return Collections.unmodifiableMap(new TreeMap(this.X));
    }

    /* access modifiers changed from: package-private */
    public synchronized void k(String str, String str2, String str3, String str4, AliasOptions aliasOptions) throws XMPException {
        try {
            ParameterAsserts.f(str);
            ParameterAsserts.e(str2);
            ParameterAsserts.f(str3);
            ParameterAsserts.e(str4);
            final AliasOptions aliasOptions2 = aliasOptions != null ? new AliasOptions(XMPNodeUtils.r(aliasOptions.y(), (Object) null).i()) : new AliasOptions();
            if (this.Z.matcher(str2).find() || this.Z.matcher(str4).find()) {
                throw new XMPException("Alias and actual property names must be simple", 102);
            }
            String b2 = b(str);
            final String b3 = b(str3);
            if (b2 == null) {
                throw new XMPException("Alias namespace is not registered", 101);
            } else if (b3 != null) {
                String str5 = b2 + str2;
                if (!this.Y.containsKey(str5)) {
                    if (!this.Y.containsKey(b3 + str4)) {
                        final String str6 = str3;
                        final String str7 = str4;
                        this.Y.put(str5, new XMPAliasInfo() {
                            public String a() {
                                return str6;
                            }

                            public String b() {
                                return b3;
                            }

                            public String c() {
                                return str7;
                            }

                            public AliasOptions d() {
                                return aliasOptions2;
                            }

                            public String toString() {
                                return b3 + str7 + " NS(" + str6 + "), FORM (" + d() + ")";
                            }
                        });
                    } else {
                        throw new XMPException("Actual property is already an alias, use the base property", 4);
                    }
                } else {
                    throw new XMPException("Alias is already existing", 4);
                }
            } else {
                throw new XMPException("Actual namespace is not registered", 101);
            }
        } catch (Throwable th) {
            throw th;
        }
    }
}
