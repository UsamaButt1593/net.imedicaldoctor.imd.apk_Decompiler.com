package com.itextpdf.text.pdf.hyphenation;

import com.itextpdf.text.ExceptionConverter;
import com.itextpdf.text.xml.simpleparser.SimpleXMLDocHandler;
import com.itextpdf.text.xml.simpleparser.SimpleXMLParser;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Map;
import java.util.StringTokenizer;

public class SimplePatternParser implements SimpleXMLDocHandler, PatternConsumer {
    static final int Z2 = 1;
    static final int a3 = 2;
    static final int b3 = 3;
    static final int c3 = 4;
    PatternConsumer X;
    char X2 = '-';
    StringBuffer Y = new StringBuffer();
    SimpleXMLParser Y2;
    ArrayList<Object> Z;
    int s;

    protected static String h(String str) {
        StringBuffer stringBuffer = new StringBuffer();
        String str2 = str + "a";
        int length = str2.length();
        int i2 = 0;
        while (i2 < length) {
            char charAt = str2.charAt(i2);
            if (Character.isDigit(charAt)) {
                stringBuffer.append(charAt);
                i2++;
            } else {
                stringBuffer.append('0');
            }
            i2++;
        }
        return stringBuffer.toString();
    }

    protected static String i(String str) {
        StringBuffer stringBuffer = new StringBuffer();
        int length = str.length();
        for (int i2 = 0; i2 < length; i2++) {
            if (!Character.isDigit(str.charAt(i2))) {
                stringBuffer.append(str.charAt(i2));
            }
        }
        return stringBuffer.toString();
    }

    public void a(String str) {
        StringTokenizer stringTokenizer = new StringTokenizer(str);
        while (stringTokenizer.hasMoreTokens()) {
            String nextToken = stringTokenizer.nextToken();
            int i2 = this.s;
            if (i2 == 1) {
                this.X.f(nextToken);
            } else if (i2 == 2) {
                this.Z.add(nextToken);
                ArrayList<Object> j2 = j(this.Z);
                this.Z = j2;
                this.X.c(g(j2), (ArrayList) this.Z.clone());
                this.Z.clear();
            } else if (i2 == 3) {
                this.X.b(i(nextToken), h(nextToken));
            }
        }
    }

    public void b(String str, String str2) {
        PrintStream printStream = System.out;
        printStream.println("pattern: " + str + " : " + str2);
    }

    public void c(String str, ArrayList<Object> arrayList) {
        PrintStream printStream = System.out;
        printStream.println("exception: " + str + " : " + arrayList.toString());
    }

    public void d(String str) {
        if (this.Y.length() > 0) {
            String stringBuffer = this.Y.toString();
            int i2 = this.s;
            if (i2 == 1) {
                this.X.f(stringBuffer);
            } else if (i2 == 2) {
                this.Z.add(stringBuffer);
                ArrayList<Object> j2 = j(this.Z);
                this.Z = j2;
                this.X.c(g(j2), (ArrayList) this.Z.clone());
            } else if (i2 == 3) {
                this.X.b(i(stringBuffer), h(stringBuffer));
            }
            if (this.s != 4) {
                this.Y.setLength(0);
            }
        }
        if (this.s == 4) {
            this.s = 2;
        } else {
            this.s = 0;
        }
    }

    public void e(String str, Map<String, String> map) {
        int i2;
        if (str.equals("hyphen-char")) {
            String str2 = map.get("value");
            if (str2 != null && str2.length() == 1) {
                this.X2 = str2.charAt(0);
            }
        } else if (str.equals("classes")) {
            this.s = 1;
        } else {
            if (str.equals("patterns")) {
                i2 = 3;
            } else if (str.equals("exceptions")) {
                this.s = 2;
                this.Z = new ArrayList<>();
            } else if (str.equals("hyphen")) {
                if (this.Y.length() > 0) {
                    this.Z.add(this.Y.toString());
                }
                this.Z.add(new Hyphen(map.get("pre"), map.get("no"), map.get("post")));
                i2 = 4;
            }
            this.s = i2;
        }
        this.Y.setLength(0);
    }

    public void endDocument() {
    }

    public void f(String str) {
        PrintStream printStream = System.out;
        printStream.println("class: " + str);
    }

    /* access modifiers changed from: protected */
    public String g(ArrayList<Object> arrayList) {
        String str;
        StringBuffer stringBuffer = new StringBuffer();
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            Object obj = arrayList.get(i2);
            if (obj instanceof String) {
                str = (String) obj;
            } else {
                str = ((Hyphen) obj).X;
                if (str == null) {
                }
            }
            stringBuffer.append(str);
        }
        return stringBuffer.toString();
    }

    /* access modifiers changed from: protected */
    public ArrayList<Object> j(ArrayList<Object> arrayList) {
        ArrayList<Object> arrayList2 = new ArrayList<>();
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            Object obj = arrayList.get(i2);
            if (obj instanceof String) {
                String str = (String) obj;
                StringBuffer stringBuffer = new StringBuffer();
                for (int i3 = 0; i3 < str.length(); i3++) {
                    char charAt = str.charAt(i3);
                    if (charAt != this.X2) {
                        stringBuffer.append(charAt);
                    } else {
                        arrayList2.add(stringBuffer.toString());
                        stringBuffer.setLength(0);
                        arrayList2.add(new Hyphen(new String(new char[]{this.X2}), (String) null, (String) null));
                    }
                }
                if (stringBuffer.length() > 0) {
                    obj = stringBuffer.toString();
                }
            }
            arrayList2.add(obj);
        }
        return arrayList2;
    }

    public void k(InputStream inputStream, PatternConsumer patternConsumer) {
        this.X = patternConsumer;
        try {
            SimpleXMLParser.h(this, inputStream);
            try {
                inputStream.close();
            } catch (Exception unused) {
            }
        } catch (IOException e2) {
            throw new ExceptionConverter(e2);
        } catch (Throwable th) {
            try {
                inputStream.close();
            } catch (Exception unused2) {
            }
            throw th;
        }
    }

    public void startDocument() {
    }
}
