package com.itextpdf.text.pdf;

import com.itextpdf.text.error_messages.MessageLocalization;
import com.itextpdf.text.xml.XMLUtil;
import com.itextpdf.text.xml.simpleparser.IanaEncodings;
import com.itextpdf.text.xml.simpleparser.SimpleXMLDocHandler;
import com.itextpdf.text.xml.simpleparser.SimpleXMLParser;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Stack;
import java.util.StringTokenizer;
import org.apache.commons.lang3.StringUtils;

public final class SimpleBookmark implements SimpleXMLDocHandler {
    private final Stack<HashMap<String, Object>> X = new Stack<>();
    private ArrayList<HashMap<String, Object>> s;

    private SimpleBookmark() {
    }

    private static List<HashMap<String, Object>> b(PdfReader pdfReader, PdfDictionary pdfDictionary, IntHashtable intHashtable, boolean z) {
        String m0;
        String m02;
        String str;
        String a0;
        IntHashtable intHashtable2 = intHashtable;
        ArrayList arrayList = new ArrayList();
        PdfDictionary pdfDictionary2 = pdfDictionary;
        while (pdfDictionary2 != null) {
            HashMap hashMap = new HashMap();
            hashMap.put("Title", ((PdfString) PdfReader.w0(pdfDictionary2.d0(PdfName.ig))).m0());
            PdfArray pdfArray = (PdfArray) PdfReader.w0(pdfDictionary2.d0(PdfName.K4));
            if (pdfArray != null && pdfArray.size() == 3) {
                ByteBuffer byteBuffer = new ByteBuffer();
                byteBuffer.e(pdfArray.J0(0).a0()).c(' ');
                byteBuffer.e(pdfArray.J0(1).a0()).c(' ');
                byteBuffer.e(pdfArray.J0(2).a0());
                hashMap.put("Color", PdfEncodings.d(byteBuffer.F(), (String) null));
            }
            PdfName pdfName = PdfName.F7;
            PdfNumber pdfNumber = (PdfNumber) PdfReader.w0(pdfDictionary2.d0(pdfName));
            if (pdfNumber != null) {
                int e0 = pdfNumber.e0();
                String str2 = "";
                if ((e0 & 1) != 0) {
                    str2 = str2 + "italic ";
                }
                if ((e0 & 2) != 0) {
                    str2 = str2 + "bold ";
                }
                String trim = str2.trim();
                if (trim.length() != 0) {
                    hashMap.put("Style", trim);
                }
            }
            PdfNumber pdfNumber2 = (PdfNumber) PdfReader.w0(pdfDictionary2.d0(PdfName.P5));
            if (pdfNumber2 != null && pdfNumber2.e0() < 0) {
                hashMap.put("Open", "false");
            }
            try {
                PdfObject w0 = PdfReader.w0(pdfDictionary2.d0(PdfName.x6));
                if (w0 != null) {
                    q(hashMap, w0, intHashtable2);
                } else {
                    PdfDictionary pdfDictionary3 = (PdfDictionary) PdfReader.w0(pdfDictionary2.d0(PdfName.k3));
                    if (pdfDictionary3 != null) {
                        PdfName pdfName2 = PdfName.N8;
                        PdfName pdfName3 = PdfName.Ce;
                        if (pdfName2.equals(PdfReader.w0(pdfDictionary3.d0(pdfName3)))) {
                            PdfObject w02 = PdfReader.w0(pdfDictionary3.d0(PdfName.f6));
                            if (w02 != null) {
                                q(hashMap, w02, intHashtable2);
                            }
                        } else {
                            PdfName pdfName4 = PdfName.Yg;
                            if (pdfName4.equals(PdfReader.w0(pdfDictionary3.d0(pdfName3)))) {
                                hashMap.put("Action", "URI");
                                hashMap.put("URI", ((PdfString) PdfReader.w0(pdfDictionary3.d0(pdfName4))).m0());
                            } else if (PdfName.aa.equals(PdfReader.w0(pdfDictionary3.d0(pdfName3)))) {
                                hashMap.put("Action", "JS");
                                hashMap.put("Code", PdfReader.w0(pdfDictionary3.d0(PdfName.ea)).toString());
                            } else if (PdfName.Q8.equals(PdfReader.w0(pdfDictionary3.d0(pdfName3)))) {
                                PdfObject w03 = PdfReader.w0(pdfDictionary3.d0(PdfName.f6));
                                if (w03 != null) {
                                    if (w03.N()) {
                                        str = "Named";
                                        a0 = w03.toString();
                                    } else if (w03.E()) {
                                        str = "NamedN";
                                        a0 = PdfName.a0(w03.toString());
                                    } else if (w03.q()) {
                                        PdfArray pdfArray2 = (PdfArray) w03;
                                        StringBuffer stringBuffer = new StringBuffer();
                                        stringBuffer.append(pdfArray2.T0(0).toString());
                                        stringBuffer.append(' ');
                                        stringBuffer.append(pdfArray2.T0(1).toString());
                                        for (int i2 = 2; i2 < pdfArray2.size(); i2++) {
                                            stringBuffer.append(' ');
                                            stringBuffer.append(pdfArray2.T0(i2).toString());
                                        }
                                        hashMap.put("Page", stringBuffer.toString());
                                    }
                                    hashMap.put(str, a0);
                                }
                                hashMap.put("Action", "GoToR");
                                PdfName pdfName5 = PdfName.F7;
                                PdfObject w04 = PdfReader.w0(pdfDictionary3.d0(pdfName5));
                                if (w04 != null) {
                                    if (w04.N()) {
                                        m02 = ((PdfString) w04).m0();
                                    } else if (w04.z()) {
                                        PdfObject t0 = PdfReader.t0(((PdfDictionary) w04).d0(pdfName5));
                                        if (t0.N()) {
                                            m02 = ((PdfString) t0).m0();
                                        }
                                    }
                                    hashMap.put("File", m02);
                                }
                                PdfObject w05 = PdfReader.w0(pdfDictionary3.d0(PdfName.zb));
                                if (w05 != null) {
                                    hashMap.put("NewWindow", w05.toString());
                                }
                            } else if (PdfName.ra.equals(PdfReader.w0(pdfDictionary3.d0(pdfName3)))) {
                                hashMap.put("Action", "Launch");
                                PdfObject w06 = PdfReader.w0(pdfDictionary3.d0(pdfName));
                                if (w06 == null) {
                                    w06 = PdfReader.w0(pdfDictionary3.d0(PdfName.Lh));
                                }
                                if (w06 != null) {
                                    if (w06.N()) {
                                        m0 = ((PdfString) w06).m0();
                                    } else if (w06.z()) {
                                        PdfObject w07 = PdfReader.w0(((PdfDictionary) w06).d0(pdfName));
                                        if (w07.N()) {
                                            m0 = ((PdfString) w07).m0();
                                        }
                                    }
                                    hashMap.put("File", m0);
                                }
                            }
                        }
                    }
                }
            } catch (Exception unused) {
            }
            PdfDictionary pdfDictionary4 = (PdfDictionary) PdfReader.w0(pdfDictionary2.d0(PdfName.U7));
            if (pdfDictionary4 != null) {
                hashMap.put("Kids", b(pdfReader, pdfDictionary4, intHashtable2, false));
            } else {
                PdfReader pdfReader2 = pdfReader;
            }
            arrayList.add(hashMap);
            pdfDictionary2 = !z ? (PdfDictionary) PdfReader.w0(pdfDictionary2.d0(PdfName.Ab)) : null;
        }
        return arrayList;
    }

    static void c(PdfDictionary pdfDictionary, HashMap<String, Object> hashMap, PdfWriter pdfWriter, boolean z) {
        String str;
        PdfObject pdfObject;
        PdfName pdfName;
        PdfName pdfName2;
        PdfBoolean pdfBoolean;
        PdfName pdfName3;
        PdfObject pdfName4;
        PdfObject pdfObject2;
        try {
            String str2 = (String) hashMap.get("Action");
            int i2 = 0;
            if ("GoTo".equals(str2)) {
                String str3 = (String) hashMap.get("Named");
                if (str3 == null) {
                    String str4 = (String) hashMap.get("Page");
                    if (str4 != null) {
                        PdfArray pdfArray = new PdfArray();
                        StringTokenizer stringTokenizer = new StringTokenizer(str4);
                        pdfArray.a0(pdfWriter.A1(Integer.parseInt(stringTokenizer.nextToken())));
                        if (!stringTokenizer.hasMoreTokens()) {
                            pdfArray.a0(PdfName.f26251fi);
                            pdfArray.d0(new float[]{0.0f, 10000.0f, 0.0f});
                        } else {
                            String nextToken = stringTokenizer.nextToken();
                            if (nextToken.startsWith("/")) {
                                nextToken = nextToken.substring(1);
                            }
                            pdfArray.a0(new PdfName(nextToken));
                            while (i2 < 4 && stringTokenizer.hasMoreTokens()) {
                                String nextToken2 = stringTokenizer.nextToken();
                                if (nextToken2.equals("null")) {
                                    pdfArray.a0(PdfNull.i3);
                                } else {
                                    pdfArray.a0(new PdfNumber(nextToken2));
                                }
                                i2++;
                            }
                        }
                        pdfDictionary.V0(PdfName.x6, pdfArray);
                        return;
                    }
                    return;
                } else if (z) {
                    pdfName = PdfName.x6;
                    pdfObject2 = new PdfName(str3);
                } else {
                    pdfName = PdfName.x6;
                    pdfObject2 = new PdfString(str3, (String) null);
                }
            } else {
                if ("GoToR".equals(str2)) {
                    PdfDictionary pdfDictionary2 = new PdfDictionary();
                    String str5 = (String) hashMap.get("Named");
                    if (str5 != null) {
                        pdfName3 = PdfName.f6;
                        pdfName4 = new PdfString(str5, (String) null);
                    } else {
                        String str6 = (String) hashMap.get("NamedN");
                        if (str6 != null) {
                            pdfName3 = PdfName.f6;
                            pdfName4 = new PdfName(str6);
                        } else {
                            String str7 = (String) hashMap.get("Page");
                            if (str7 != null) {
                                PdfArray pdfArray2 = new PdfArray();
                                StringTokenizer stringTokenizer2 = new StringTokenizer(str7);
                                pdfArray2.a0(new PdfNumber(stringTokenizer2.nextToken()));
                                if (!stringTokenizer2.hasMoreTokens()) {
                                    pdfArray2.a0(PdfName.f26251fi);
                                    pdfArray2.d0(new float[]{0.0f, 10000.0f, 0.0f});
                                } else {
                                    String nextToken3 = stringTokenizer2.nextToken();
                                    if (nextToken3.startsWith("/")) {
                                        nextToken3 = nextToken3.substring(1);
                                    }
                                    pdfArray2.a0(new PdfName(nextToken3));
                                    while (i2 < 4 && stringTokenizer2.hasMoreTokens()) {
                                        String nextToken4 = stringTokenizer2.nextToken();
                                        if (nextToken4.equals("null")) {
                                            pdfArray2.a0(PdfNull.i3);
                                        } else {
                                            pdfArray2.a0(new PdfNumber(nextToken4));
                                        }
                                        i2++;
                                    }
                                }
                                pdfDictionary2.V0(PdfName.f6, pdfArray2);
                            }
                            String str8 = (String) hashMap.get("File");
                            if (pdfDictionary2.size() > 0 && str8 != null) {
                                pdfDictionary2.V0(PdfName.Ce, PdfName.Q8);
                                pdfDictionary2.V0(PdfName.F7, new PdfString(str8));
                                String str9 = (String) hashMap.get("NewWindow");
                                pdfObject = pdfDictionary2;
                                if (str9 != null) {
                                    if (str9.equals(PdfBoolean.l3)) {
                                        pdfName2 = PdfName.zb;
                                        pdfBoolean = PdfBoolean.j3;
                                    } else {
                                        pdfObject = pdfDictionary2;
                                        if (str9.equals("false")) {
                                            pdfName2 = PdfName.zb;
                                            pdfBoolean = PdfBoolean.k3;
                                        }
                                    }
                                    pdfDictionary2.V0(pdfName2, pdfBoolean);
                                    pdfObject = pdfDictionary2;
                                }
                            } else {
                                return;
                            }
                        }
                    }
                    pdfDictionary2.V0(pdfName3, pdfName4);
                    String str82 = (String) hashMap.get("File");
                    if (pdfDictionary2.size() > 0) {
                        return;
                    }
                    return;
                } else if ("URI".equals(str2)) {
                    String str10 = (String) hashMap.get("URI");
                    if (str10 != null) {
                        PdfDictionary pdfDictionary3 = new PdfDictionary();
                        PdfName pdfName5 = PdfName.Ce;
                        PdfName pdfName6 = PdfName.Yg;
                        pdfDictionary3.V0(pdfName5, pdfName6);
                        pdfDictionary3.V0(pdfName6, new PdfString(str10));
                        pdfObject = pdfDictionary3;
                    } else {
                        return;
                    }
                } else if ("JS".equals(str2)) {
                    String str11 = (String) hashMap.get("Code");
                    if (str11 != null) {
                        pdfDictionary.V0(PdfName.k3, PdfAction.I1(str11, pdfWriter));
                        return;
                    }
                    return;
                } else if ("Launch".equals(str2) && (str = (String) hashMap.get("File")) != null) {
                    PdfDictionary pdfDictionary4 = new PdfDictionary();
                    pdfDictionary4.V0(PdfName.Ce, PdfName.ra);
                    pdfDictionary4.V0(PdfName.F7, new PdfString(str));
                    pdfObject = pdfDictionary4;
                } else {
                    return;
                }
                pdfName = PdfName.k3;
                pdfObject2 = pdfObject;
            }
            pdfDictionary.V0(pdfName, pdfObject2);
        } catch (Exception unused) {
        }
    }

    public static void f(List<HashMap<String, Object>> list, int[] iArr) {
        String str;
        if (list != null) {
            ListIterator<HashMap<String, Object>> listIterator = list.listIterator();
            while (listIterator.hasNext()) {
                HashMap next = listIterator.next();
                boolean z = false;
                if ("GoTo".equals(next.get("Action")) && (str = (String) next.get("Page")) != null) {
                    String trim = str.trim();
                    int indexOf = trim.indexOf(32);
                    if (indexOf >= 0) {
                        trim = trim.substring(0, indexOf);
                    }
                    int parseInt = Integer.parseInt(trim);
                    int length = iArr.length & -2;
                    int i2 = 0;
                    while (true) {
                        if (i2 < length) {
                            if (parseInt >= iArr[i2] && parseInt <= iArr[i2 + 1]) {
                                z = true;
                                break;
                            }
                            i2 += 2;
                        } else {
                            break;
                        }
                    }
                }
                List list2 = (List) next.get("Kids");
                if (list2 != null) {
                    f(list2, iArr);
                    if (list2.isEmpty()) {
                        next.remove("Kids");
                        list2 = null;
                    }
                }
                if (z) {
                    if (list2 == null) {
                        listIterator.remove();
                    } else {
                        next.remove("Action");
                        next.remove("Page");
                        next.remove("Named");
                    }
                }
            }
        }
    }

    public static void g(List<HashMap<String, Object>> list, OutputStream outputStream, String str, boolean z) throws IOException {
        h(list, new BufferedWriter(new OutputStreamWriter(outputStream, IanaEncodings.a(str))), str, z);
    }

    public static void h(List<HashMap<String, Object>> list, Writer writer, String str, boolean z) throws IOException {
        writer.write("<?xml version=\"1.0\" encoding=\"");
        writer.write(XMLUtil.a(str, z));
        writer.write("\"?>\n<Bookmark>\n");
        i(list, writer, 1, z);
        writer.write("</Bookmark>\n");
        writer.flush();
    }

    public static void i(List<HashMap<String, Object>> list, Writer writer, int i2, boolean z) throws IOException {
        String str;
        if (i2 != -1) {
            str = "";
            for (int i3 = 0; i3 < i2; i3++) {
                str = str + "  ";
            }
        } else {
            str = "";
        }
        for (HashMap<String, Object> entrySet : list) {
            writer.write(str);
            writer.write("<Title ");
            String str2 = null;
            List list2 = null;
            for (Map.Entry entry : entrySet.entrySet()) {
                String str3 = (String) entry.getKey();
                if (str3.equals("Title")) {
                    str2 = (String) entry.getValue();
                } else if (str3.equals("Kids")) {
                    list2 = (List) entry.getValue();
                } else {
                    writer.write(str3);
                    writer.write("=\"");
                    String str4 = (String) entry.getValue();
                    if (str3.equals("Named") || str3.equals("NamedN")) {
                        str4 = SimpleNamedDestination.c(str4);
                    }
                    writer.write(XMLUtil.a(str4, z));
                    writer.write("\" ");
                }
            }
            writer.write(">");
            if (str2 == null) {
                str2 = "";
            }
            writer.write(XMLUtil.a(str2, z));
            if (list2 != null) {
                writer.write(StringUtils.LF);
                i(list2, writer, i2 == -1 ? i2 : i2 + 1, z);
                writer.write(str);
            }
            writer.write("</Title>\n");
        }
    }

    public static List<HashMap<String, Object>> j(PdfReader pdfReader) {
        PdfObject w0 = PdfReader.w0(pdfReader.F().d0(PdfName.nc));
        if (w0 == null || !w0.z()) {
            return null;
        }
        return k(pdfReader, (PdfDictionary) w0, false);
    }

    public static List<HashMap<String, Object>> k(PdfReader pdfReader, PdfDictionary pdfDictionary, boolean z) {
        pdfReader.F();
        if (pdfDictionary == null) {
            return null;
        }
        IntHashtable intHashtable = new IntHashtable();
        int c0 = pdfReader.c0();
        for (int i2 = 1; i2 <= c0; i2++) {
            intHashtable.l(pdfReader.j0(i2).d(), i2);
            pdfReader.r1(i2);
        }
        return z ? b(pdfReader, pdfDictionary, intHashtable, true) : b(pdfReader, (PdfDictionary) PdfReader.w0(pdfDictionary.d0(PdfName.U7)), intHashtable, false);
    }

    private static int l(PdfIndirectReference pdfIndirectReference) {
        PdfDictionary pdfDictionary = (PdfDictionary) PdfReader.w0(pdfIndirectReference);
        PdfName pdfName = PdfName.Kg;
        if (pdfDictionary.a0(pdfName) && pdfDictionary.d0(pdfName).equals(PdfName.zc)) {
            PdfName pdfName2 = PdfName.ia;
            if (pdfDictionary.a0(pdfName2)) {
                pdfIndirectReference = (PdfIndirectReference) ((PdfArray) pdfDictionary.d0(pdfName2)).T0(0);
            }
        }
        return pdfIndirectReference.d();
    }

    public static List<HashMap<String, Object>> m(InputStream inputStream) throws IOException {
        SimpleBookmark simpleBookmark = new SimpleBookmark();
        SimpleXMLParser.h(simpleBookmark, inputStream);
        return simpleBookmark.s;
    }

    public static List<HashMap<String, Object>> n(Reader reader) throws IOException {
        SimpleBookmark simpleBookmark = new SimpleBookmark();
        SimpleXMLParser.i(simpleBookmark, reader);
        return simpleBookmark.s;
    }

    public static Object[] o(PdfWriter pdfWriter, PdfIndirectReference pdfIndirectReference, List<HashMap<String, Object>> list, boolean z) throws IOException {
        PdfWriter pdfWriter2 = pdfWriter;
        boolean z2 = z;
        int i2 = 3;
        char c2 = 2;
        int size = list.size();
        PdfIndirectReference[] pdfIndirectReferenceArr = new PdfIndirectReference[size];
        char c3 = 0;
        for (int i3 = 0; i3 < size; i3++) {
            pdfIndirectReferenceArr[i3] = pdfWriter.D1();
        }
        ListIterator<HashMap<String, Object>> listIterator = list.listIterator();
        int i4 = 0;
        int i5 = 0;
        while (listIterator.hasNext()) {
            HashMap next = listIterator.next();
            List list2 = (List) next.get("Kids");
            Object[] o = (list2 == null || list2.isEmpty()) ? null : o(pdfWriter2, pdfIndirectReferenceArr[i5], list2, z2);
            PdfDictionary pdfDictionary = new PdfDictionary();
            i4++;
            if (o != null) {
                pdfDictionary.V0(PdfName.U7, (PdfIndirectReference) o[c3]);
                pdfDictionary.V0(PdfName.oa, (PdfIndirectReference) o[1]);
                int intValue = ((Integer) o[c2]).intValue();
                if ("false".equals(next.get("Open"))) {
                    pdfDictionary.V0(PdfName.P5, new PdfNumber(-intValue));
                } else {
                    pdfDictionary.V0(PdfName.P5, new PdfNumber(intValue));
                    i4 += intValue;
                }
            }
            pdfDictionary.V0(PdfName.Dc, pdfIndirectReference);
            if (i5 > 0) {
                pdfDictionary.V0(PdfName.gd, pdfIndirectReferenceArr[i5 - 1]);
            }
            if (i5 < size - 1) {
                pdfDictionary.V0(PdfName.Ab, pdfIndirectReferenceArr[i5 + 1]);
            }
            pdfDictionary.V0(PdfName.ig, new PdfString((String) next.get("Title"), PdfObject.h3));
            String str = (String) next.get("Color");
            if (str != null) {
                try {
                    PdfArray pdfArray = new PdfArray();
                    StringTokenizer stringTokenizer = new StringTokenizer(str);
                    int i6 = 0;
                    while (i6 < i2) {
                        float parseFloat = Float.parseFloat(stringTokenizer.nextToken());
                        if (parseFloat < 0.0f) {
                            parseFloat = 0.0f;
                        }
                        if (parseFloat > 1.0f) {
                            parseFloat = 1.0f;
                        }
                        pdfArray.a0(new PdfNumber(parseFloat));
                        i6++;
                        i2 = 3;
                    }
                    pdfDictionary.V0(PdfName.K4, pdfArray);
                } catch (Exception unused) {
                }
            }
            String str2 = (String) next.get("Style");
            if (str2 != null) {
                String lowerCase = str2.toLowerCase();
                int i7 = lowerCase.indexOf("italic") >= 0 ? 1 : 0;
                if (lowerCase.indexOf("bold") >= 0) {
                    i7 |= 2;
                }
                if (i7 != 0) {
                    pdfDictionary.V0(PdfName.F7, new PdfNumber(i7));
                }
            }
            c(pdfDictionary, next, pdfWriter2, z2);
            pdfWriter2.y0(pdfDictionary, pdfIndirectReferenceArr[i5]);
            i5++;
            i2 = 3;
            c2 = 2;
            c3 = 0;
        }
        return new Object[]{pdfIndirectReferenceArr[0], pdfIndirectReferenceArr[size - 1], Integer.valueOf(i4)};
    }

    private static String p(PdfArray pdfArray, IntHashtable intHashtable) {
        StringBuffer stringBuffer = new StringBuffer();
        PdfObject T0 = pdfArray.T0(0);
        stringBuffer.append(T0.I() ? ((PdfNumber) T0).e0() + 1 : intHashtable.e(l((PdfIndirectReference) T0)));
        stringBuffer.append(' ');
        stringBuffer.append(pdfArray.T0(1).toString().substring(1));
        for (int i2 = 2; i2 < pdfArray.size(); i2++) {
            stringBuffer.append(' ');
            stringBuffer.append(pdfArray.T0(i2).toString());
        }
        return stringBuffer.toString();
    }

    private static void q(HashMap<String, Object> hashMap, PdfObject pdfObject, IntHashtable intHashtable) {
        String a0;
        if (pdfObject.N()) {
            a0 = pdfObject.toString();
        } else if (pdfObject.E()) {
            a0 = PdfName.a0(pdfObject.toString());
        } else {
            if (pdfObject.q()) {
                hashMap.put("Page", p((PdfArray) pdfObject, intHashtable));
            }
            hashMap.put("Action", "GoTo");
        }
        hashMap.put("Named", a0);
        hashMap.put("Action", "GoTo");
    }

    public static void r(List<HashMap<String, Object>> list, int i2, int[] iArr) {
        String str;
        if (list != null) {
            ListIterator<HashMap<String, Object>> listIterator = list.listIterator();
            while (listIterator.hasNext()) {
                HashMap next = listIterator.next();
                if ("GoTo".equals(next.get("Action")) && (str = (String) next.get("Page")) != null) {
                    String trim = str.trim();
                    int indexOf = trim.indexOf(32);
                    int i3 = 0;
                    int parseInt = indexOf < 0 ? Integer.parseInt(trim) : Integer.parseInt(trim.substring(0, indexOf));
                    if (iArr != null) {
                        int length = iArr.length & -2;
                        while (true) {
                            if (i3 < length) {
                                if (parseInt >= iArr[i3] && parseInt <= iArr[i3 + 1]) {
                                    break;
                                }
                                i3 += 2;
                            } else {
                                break;
                            }
                        }
                        next.put("Page", trim);
                    }
                    if (indexOf < 0) {
                        trim = Integer.toString(parseInt + i2);
                    } else {
                        trim = (parseInt + i2) + trim.substring(indexOf);
                    }
                    next.put("Page", trim);
                }
                List list2 = (List) next.get("Kids");
                if (list2 != null) {
                    r(list2, i2, iArr);
                }
            }
        }
    }

    public void a(String str) {
        if (!this.X.isEmpty()) {
            HashMap peek = this.X.peek();
            peek.put("Title", ((String) peek.get("Title")) + str);
        }
    }

    public void d(String str) {
        if (str.equals("Bookmark")) {
            if (!this.X.isEmpty()) {
                throw new RuntimeException(MessageLocalization.b("bookmark.end.tag.out.of.place", new Object[0]));
            }
        } else if (str.equals("Title")) {
            HashMap pop = this.X.pop();
            pop.put("Title", ((String) pop.get("Title")).trim());
            String str2 = (String) pop.get("Named");
            if (str2 != null) {
                pop.put("Named", SimpleNamedDestination.m(str2));
            }
            String str3 = (String) pop.get("NamedN");
            if (str3 != null) {
                pop.put("NamedN", SimpleNamedDestination.m(str3));
            }
            if (this.X.isEmpty()) {
                this.s.add(pop);
                return;
            }
            HashMap peek = this.X.peek();
            List list = (List) peek.get("Kids");
            if (list == null) {
                list = new ArrayList();
                peek.put("Kids", list);
            }
            list.add(pop);
        } else {
            throw new RuntimeException(MessageLocalization.b("invalid.end.tag.1", str));
        }
    }

    public void e(String str, Map<String, String> map) {
        if (this.s == null) {
            if (str.equals("Bookmark")) {
                this.s = new ArrayList<>();
            } else {
                throw new RuntimeException(MessageLocalization.b("root.element.is.not.bookmark.1", str));
            }
        } else if (str.equals("Title")) {
            HashMap hashMap = new HashMap(map);
            hashMap.put("Title", "");
            hashMap.remove("Kids");
            this.X.push(hashMap);
        } else {
            throw new RuntimeException(MessageLocalization.b("tag.1.not.allowed", str));
        }
    }

    public void endDocument() {
    }

    public void startDocument() {
    }
}
