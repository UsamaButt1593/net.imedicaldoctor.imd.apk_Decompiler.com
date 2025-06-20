package com.itextpdf.text.pdf;

import com.itextpdf.text.error_messages.MessageLocalization;
import com.itextpdf.text.xml.simpleparser.SimpleXMLDocHandler;
import com.itextpdf.text.xml.simpleparser.SimpleXMLParser;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class XfdfReader implements SimpleXMLDocHandler {
    private final Stack<String> X;
    protected HashMap<String, List<String>> X2;
    private final Stack<String> Y;
    String Y2;
    HashMap<String, String> Z;
    private boolean s;

    public XfdfReader(InputStream inputStream) throws IOException {
        this.s = false;
        this.X = new Stack<>();
        this.Y = new Stack<>();
        SimpleXMLParser.h(this, inputStream);
    }

    public void a(String str) {
        if (!this.X.isEmpty() && !this.Y.isEmpty()) {
            this.Y.push(this.Y.pop() + str);
        }
    }

    public String b(String str) {
        return this.Z.get(str);
    }

    public String c(String str) {
        String str2 = this.Z.get(str);
        if (str2 == null) {
            return null;
        }
        return str2;
    }

    public void d(String str) {
        if (str.equals("value")) {
            String str2 = "";
            for (int i2 = 0; i2 < this.X.size(); i2++) {
                str2 = str2 + "." + this.X.elementAt(i2);
            }
            if (str2.startsWith(".")) {
                str2 = str2.substring(1);
            }
            String pop = this.Y.pop();
            String put = this.Z.put(str2, pop);
            if (put != null) {
                List list = this.X2.get(str2);
                if (list == null) {
                    list = new ArrayList();
                    list.add(put);
                }
                list.add(pop);
                this.X2.put(str2, list);
            }
        } else if (str.equals("field") && !this.X.isEmpty()) {
            this.X.pop();
        }
    }

    public void e(String str, Map<String, String> map) {
        if (!this.s) {
            if (str.equals("xfdf")) {
                this.s = true;
            } else {
                throw new RuntimeException(MessageLocalization.b("root.element.is.not.xfdf.1", str));
            }
        }
        if (!str.equals("xfdf")) {
            if (str.equals("f")) {
                this.Y2 = map.get("href");
            } else if (str.equals("fields")) {
                this.Z = new HashMap<>();
                this.X2 = new HashMap<>();
            } else if (str.equals("field")) {
                this.X.push(map.get("name"));
            } else if (str.equals("value")) {
                this.Y.push("");
            }
        }
    }

    public void endDocument() {
    }

    public HashMap<String, String> f() {
        return this.Z;
    }

    public String g() {
        return this.Y2;
    }

    public List<String> h(String str) {
        return this.X2.get(str);
    }

    public void startDocument() {
        this.Y2 = "";
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0027 A[SYNTHETIC, Splitter:B:12:0x0027] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public XfdfReader(java.lang.String r3) throws java.io.IOException {
        /*
            r2 = this;
            r2.<init>()
            r0 = 0
            r2.s = r0
            java.util.Stack r0 = new java.util.Stack
            r0.<init>()
            r2.X = r0
            java.util.Stack r0 = new java.util.Stack
            r0.<init>()
            r2.Y = r0
            r0 = 0
            java.io.FileInputStream r1 = new java.io.FileInputStream     // Catch:{ all -> 0x0024 }
            r1.<init>(r3)     // Catch:{ all -> 0x0024 }
            com.itextpdf.text.xml.simpleparser.SimpleXMLParser.h(r2, r1)     // Catch:{ all -> 0x0021 }
            r1.close()     // Catch:{ Exception -> 0x0020 }
        L_0x0020:
            return
        L_0x0021:
            r3 = move-exception
            r0 = r1
            goto L_0x0025
        L_0x0024:
            r3 = move-exception
        L_0x0025:
            if (r0 == 0) goto L_0x002a
            r0.close()     // Catch:{ Exception -> 0x002a }
        L_0x002a:
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.itextpdf.text.pdf.XfdfReader.<init>(java.lang.String):void");
    }

    public XfdfReader(byte[] bArr) throws IOException {
        this((InputStream) new ByteArrayInputStream(bArr));
    }
}
