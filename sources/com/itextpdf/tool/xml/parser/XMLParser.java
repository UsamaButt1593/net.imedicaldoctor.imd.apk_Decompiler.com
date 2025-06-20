package com.itextpdf.tool.xml.parser;

import androidx.media3.exoplayer.analytics.AnalyticsListener;
import com.itextpdf.text.xml.XMLUtil;
import com.itextpdf.text.xml.simpleparser.IanaEncodings;
import com.itextpdf.tool.xml.parser.io.EncodingUtil;
import com.itextpdf.tool.xml.parser.io.ParserMonitor;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class XMLParser {

    /* renamed from: a  reason: collision with root package name */
    private State f27669a;

    /* renamed from: b  reason: collision with root package name */
    private final StateController f27670b;

    /* renamed from: c  reason: collision with root package name */
    private final List<XMLParserListener> f27671c;

    /* renamed from: d  reason: collision with root package name */
    private final XMLParserMemory f27672d;

    /* renamed from: e  reason: collision with root package name */
    private ParserMonitor f27673e;

    /* renamed from: f  reason: collision with root package name */
    private String f27674f;

    /* renamed from: g  reason: collision with root package name */
    private TagState f27675g;

    /* renamed from: h  reason: collision with root package name */
    private Charset f27676h;

    public XMLParser() {
        this(true, Charset.defaultCharset());
    }

    private void g() {
        String str = this.f27674f;
        if (str != null && str.length() > 0) {
            for (XMLParserListener a2 : this.f27671c) {
                a2.a(this.f27674f);
            }
            this.f27674f = null;
        }
    }

    private void m(TagState tagState) {
        this.f27675g = tagState;
    }

    /*  JADX ERROR: StackOverflow in pass: MarkFinallyVisitor
        jadx.core.utils.exceptions.JadxOverflowException: 
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
        	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
        */
    private void w(java.io.Reader r4) throws java.io.IOException {
        /*
            r3 = this;
            java.util.List<com.itextpdf.tool.xml.parser.XMLParserListener> r0 = r3.f27671c
            java.util.Iterator r0 = r0.iterator()
        L_0x0006:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x0016
            java.lang.Object r1 = r0.next()
            com.itextpdf.tool.xml.parser.XMLParserListener r1 = (com.itextpdf.tool.xml.parser.XMLParserListener) r1
            r1.e()
            goto L_0x0006
        L_0x0016:
            com.itextpdf.tool.xml.parser.io.ParserMonitor r0 = r3.f27673e
            if (r0 == 0) goto L_0x0022
            com.itextpdf.tool.xml.parser.io.MonitorInputReader r0 = new com.itextpdf.tool.xml.parser.io.MonitorInputReader
            com.itextpdf.tool.xml.parser.io.ParserMonitor r1 = r3.f27673e
            r0.<init>(r4, r1)
            r4 = r0
        L_0x0022:
            r0 = 1
            char[] r0 = new char[r0]
        L_0x0025:
            int r1 = r4.read(r0)     // Catch:{ all -> 0x0035 }
            r2 = -1
            if (r2 == r1) goto L_0x0037
            com.itextpdf.tool.xml.parser.State r1 = r3.f27669a     // Catch:{ all -> 0x0035 }
            r2 = 0
            char r2 = r0[r2]     // Catch:{ all -> 0x0035 }
            r1.a(r2)     // Catch:{ all -> 0x0035 }
            goto L_0x0025
        L_0x0035:
            r0 = move-exception
            goto L_0x0051
        L_0x0037:
            java.util.List<com.itextpdf.tool.xml.parser.XMLParserListener> r0 = r3.f27671c
            java.util.Iterator r0 = r0.iterator()
        L_0x003d:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x004d
            java.lang.Object r1 = r0.next()
            com.itextpdf.tool.xml.parser.XMLParserListener r1 = (com.itextpdf.tool.xml.parser.XMLParserListener) r1
            r1.close()
            goto L_0x003d
        L_0x004d:
            r4.close()
            return
        L_0x0051:
            java.util.List<com.itextpdf.tool.xml.parser.XMLParserListener> r1 = r3.f27671c
            java.util.Iterator r1 = r1.iterator()
        L_0x0057:
            boolean r2 = r1.hasNext()
            if (r2 == 0) goto L_0x0067
            java.lang.Object r2 = r1.next()
            com.itextpdf.tool.xml.parser.XMLParserListener r2 = (com.itextpdf.tool.xml.parser.XMLParserListener) r2
            r2.close()
            goto L_0x0057
        L_0x0067:
            r4.close()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.itextpdf.tool.xml.parser.XMLParser.w(java.io.Reader):void");
    }

    /* access modifiers changed from: protected */
    public void A(State state) {
        this.f27669a = state;
    }

    public void B() {
        m(TagState.OPEN);
        g();
        for (XMLParserListener f2 : this.f27671c) {
            f2.f(this.f27672d.h(), this.f27672d.g(), this.f27672d.i());
        }
        r().f();
    }

    public void C(String str) {
        this.f27674f = str;
    }

    public void D() {
        for (XMLParserListener d2 : this.f27671c) {
            d2.d(this.f27672d.b().toString());
        }
    }

    public XMLParser a(XMLParserListener xMLParserListener) {
        this.f27671c.add(xMLParserListener);
        return this;
    }

    public XMLParser b(char c2) {
        this.f27672d.b().append(c2);
        return this;
    }

    public XMLParser c(String str) {
        this.f27672d.b().append(str);
        return this;
    }

    public XMLParser d(char[] cArr) {
        this.f27672d.b().append(cArr);
        return this;
    }

    public int e() {
        if (this.f27672d.b() != null) {
            return this.f27672d.b().length();
        }
        return 0;
    }

    public String f() {
        return this.f27672d.b().toString();
    }

    public void h() {
        g();
        for (XMLParserListener b2 : this.f27671c) {
            b2.b(this.f27672d.b().toString());
        }
    }

    public String i() {
        return this.f27672d.b().toString();
    }

    public char j() {
        StringBuilder b2 = this.f27672d.b();
        int length = b2.length();
        CharSequence subSequence = b2.subSequence(length - 2, length - 1);
        if (subSequence.length() > 0) {
            return (char) (subSequence.length() - 1);
        }
        return ' ';
    }

    public String k() {
        return this.f27672d.h();
    }

    public TagState l() {
        return this.f27675g;
    }

    public InputStreamReader n(InputStream inputStream) throws IOException, UnsupportedEncodingException {
        String str;
        String a2;
        inputStream.mark(AnalyticsListener.h0);
        byte[] bArr = new byte[4];
        if (inputStream.read(bArr) == 4) {
            String c2 = XMLUtil.c(bArr);
            if (c2.equals("UTF-8")) {
                StringBuffer stringBuffer = new StringBuffer();
                while (true) {
                    int read = inputStream.read();
                    if (read == -1 || read == 62) {
                        str = stringBuffer.toString();
                    } else {
                        stringBuffer.append((char) read);
                    }
                }
                str = stringBuffer.toString();
            } else if (c2.equals("CP037")) {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                while (true) {
                    int read2 = inputStream.read();
                    if (read2 == -1 || read2 == 110) {
                        str = new String(byteArrayOutputStream.toByteArray(), "CP037");
                    } else {
                        byteArrayOutputStream.write(read2);
                    }
                }
                str = new String(byteArrayOutputStream.toByteArray(), "CP037");
            } else {
                str = null;
            }
            if (!(str == null || (a2 = EncodingUtil.a(str)) == null)) {
                c2 = a2;
            }
            inputStream.reset();
            return new InputStreamReader(inputStream, IanaEncodings.a(c2));
        }
        throw new IOException("Insufficient length");
    }

    public void o() {
        m(TagState.CLOSE);
        g();
        for (XMLParserListener c2 : this.f27671c) {
            c2.c(this.f27672d.h(), this.f27672d.i());
        }
    }

    public void p() {
        this.f27672d.p();
    }

    public Charset q() {
        return this.f27676h;
    }

    public XMLParserMemory r() {
        return this.f27672d;
    }

    public void s(InputStream inputStream) throws IOException {
        v(new InputStreamReader(inputStream));
    }

    public void t(InputStream inputStream, Charset charset) throws IOException {
        this.f27676h = charset;
        v(new InputStreamReader(inputStream, charset));
    }

    public void u(InputStream inputStream, boolean z) throws IOException {
        if (z) {
            v(n(new BufferedInputStream(inputStream)));
        } else {
            s(inputStream);
        }
    }

    public void v(Reader reader) throws IOException {
        w(reader);
    }

    public XMLParser x(XMLParserListener xMLParserListener) {
        this.f27671c.remove(xMLParserListener);
        return this;
    }

    public StateController y() {
        return this.f27670b;
    }

    public void z(ParserMonitor parserMonitor) {
        this.f27673e = parserMonitor;
    }

    public XMLParser(XMLParserListener xMLParserListener) {
        this(true, Charset.defaultCharset());
        this.f27671c.add(xMLParserListener);
    }

    public XMLParser(XMLParserListener xMLParserListener, Charset charset) {
        this(true, charset);
        this.f27671c.add(xMLParserListener);
    }

    public XMLParser(boolean z, XMLParserListener xMLParserListener) {
        this(z, Charset.defaultCharset());
        this.f27671c.add(xMLParserListener);
    }

    public XMLParser(boolean z, XMLParserListener xMLParserListener, Charset charset) {
        this(z, charset);
        this.f27671c.add(xMLParserListener);
    }

    public XMLParser(boolean z, Charset charset) {
        this.f27674f = null;
        this.f27676h = charset;
        StateController stateController = new StateController(this, z);
        this.f27670b = stateController;
        stateController.s();
        this.f27672d = new XMLParserMemory(z);
        this.f27671c = new CopyOnWriteArrayList();
    }
}
