package com.itextpdf.text.pdf;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.exifinterface.media.ExifInterface;
import androidx.media3.exoplayer.upstream.CmcdData;
import androidx.media3.extractor.ts.PsExtractor;
import androidx.media3.extractor.ts.TsExtractor;
import androidx.recyclerview.widget.ItemTouchHelper;
import com.itextpdf.text.error_messages.MessageLocalization;
import com.itextpdf.tool.xml.html.HTML;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import kotlinx.coroutines.scheduling.WorkQueueKt;
import net.imedicaldoctor.imd.BuildConfig;
import org.apache.commons.httpclient.HttpStatus;

public final class Pfm2afm {
    private short A;
    private int B;
    private int C;
    private int D;
    private int E;
    private short F;
    private int G;
    private int H;
    private int I;
    private int J;
    private int K;
    private int L;
    private short M;
    private short N;
    private short O;
    private short P;
    private boolean Q;
    private int[] R = {0, 0, 0, 0, 197, 198, 199, 0, 202, 0, HttpStatus.SC_RESET_CONTENT, HttpStatus.SC_PARTIAL_CONTENT, HttpStatus.SC_MULTI_STATUS, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 32, 33, 34, 35, 36, 37, 38, 169, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, 62, 63, 64, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 91, 92, 93, 94, 95, 193, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 123, 124, 125, 126, WorkQueueKt.f29430c, 128, 0, 184, 166, 185, TsExtractor.D, 178, 179, 195, PsExtractor.w, 0, TsExtractor.N, 234, 0, 0, 0, 0, 96, 0, 170, 186, 183, 177, 208, 196, 0, 0, 173, ItemTouchHelper.Callback.f15380c, 0, 0, 0, 0, 161, 162, 163, 168, 165, 0, 167, 200, 0, 227, 171, 0, 0, 0, 197, 0, 0, 0, 0, 194, 0, 182, BuildConfig.f29478d, 203, 0, 235, 187, 0, 0, 0, 191, 0, 0, 0, 0, 0, 0, 225, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 233, 0, 0, 0, 0, 0, 0, 251, 0, 0, 0, 0, 0, 0, 241, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 249, 0, 0, 0, 0, 0, 0, 0};
    private int[] S = {0, 0, 0, 0, 2, 2, 2, 0, 2, 0, 2, 2, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 0, 0, 2, 0, 2, 2, 2, 2, 2, 2, 2, 2, 2, 0, 0, 0, 0, 3, 3, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 0, 0, 2, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
    private String[] T = {"W00", "W01", "W02", "W03", "macron", "breve", "dotaccent", "W07", "ring", "W09", "W0a", "W0b", "W0c", "W0d", "W0e", "W0f", "hungarumlaut", "ogonek", "caron", "W13", "W14", "W15", "W16", "W17", "W18", "W19", "W1a", "W1b", "W1c", "W1d", "W1e", "W1f", "space", "exclam", "quotedbl", "numbersign", "dollar", "percent", "ampersand", "quotesingle", "parenleft", "parenright", "asterisk", "plus", "comma", "hyphen", TypedValues.CycleType.Q, "slash", "zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "colon", "semicolon", "less", "equal", "greater", "question", "at", ExifInterface.W4, "B", "C", "D", ExifInterface.S4, "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", ExifInterface.R4, ExifInterface.d5, "U", ExifInterface.X4, ExifInterface.T4, "X", "Y", "Z", "bracketleft", "backslash", "bracketright", "asciicircum", "underscore", "grave", "a", "b", "c", "d", "e", "f", "g", CmcdData.Factory.f12510n, "i", "j", "k", CmcdData.Factory.q, "m", "n", "o", "p", HTML.Tag.C0, "r", "s", "t", "u", "v", "w", "x", "y", "z", "braceleft", "bar", "braceright", "asciitilde", "W7f", "euro", "W81", "quotesinglbase", "florin", "quotedblbase", "ellipsis", "dagger", "daggerdbl", "circumflex", "perthousand", "Scaron", "guilsinglleft", "OE", "W8d", "Zcaron", "W8f", "W90", "quoteleft", "quoteright", "quotedblleft", "quotedblright", "bullet", "endash", "emdash", "tilde", "trademark", "scaron", "guilsinglright", "oe", "W9d", "zcaron", "Ydieresis", "reqspace", "exclamdown", "cent", "sterling", "currency", "yen", "brokenbar", HTML.Tag.V, "dieresis", "copyright", "ordfeminine", "guillemotleft", "logicalnot", "syllable", "registered", "macron", "degree", "plusminus", "twosuperior", "threesuperior", "acute", "mu", "paragraph", "periodcentered", "cedilla", "onesuperior", "ordmasculine", "guillemotright", "onequarter", "onehalf", "threequarters", "questiondown", "Agrave", "Aacute", "Acircumflex", "Atilde", "Adieresis", "Aring", "AE", "Ccedilla", "Egrave", "Eacute", "Ecircumflex", "Edieresis", "Igrave", "Iacute", "Icircumflex", "Idieresis", "Eth", "Ntilde", "Ograve", "Oacute", "Ocircumflex", "Otilde", "Odieresis", "multiply", "Oslash", "Ugrave", "Uacute", "Ucircumflex", "Udieresis", "Yacute", "Thorn", "germandbls", "agrave", "aacute", "acircumflex", "atilde", "adieresis", "aring", "ae", "ccedilla", "egrave", "eacute", "ecircumflex", "edieresis", "igrave", "iacute", "icircumflex", "idieresis", "eth", "ntilde", "ograve", "oacute", "ocircumflex", "otilde", "odieresis", "divide", "oslash", "ugrave", "uacute", "ucircumflex", "udieresis", "yacute", "thorn", "ydieresis"};

    /* renamed from: a  reason: collision with root package name */
    private RandomAccessFileOrArray f26374a;

    /* renamed from: b  reason: collision with root package name */
    private PrintWriter f26375b;

    /* renamed from: c  reason: collision with root package name */
    private short f26376c;

    /* renamed from: d  reason: collision with root package name */
    private int f26377d;

    /* renamed from: e  reason: collision with root package name */
    private String f26378e;

    /* renamed from: f  reason: collision with root package name */
    private short f26379f;

    /* renamed from: g  reason: collision with root package name */
    private short f26380g;

    /* renamed from: h  reason: collision with root package name */
    private short f26381h;

    /* renamed from: i  reason: collision with root package name */
    private short f26382i;

    /* renamed from: j  reason: collision with root package name */
    private short f26383j;

    /* renamed from: k  reason: collision with root package name */
    private short f26384k;

    /* renamed from: l  reason: collision with root package name */
    private short f26385l;

    /* renamed from: m  reason: collision with root package name */
    private byte f26386m;

    /* renamed from: n  reason: collision with root package name */
    private byte f26387n;
    private byte o;
    private short p;
    private byte q;
    private short r;
    private short s;
    private byte t;
    private short u;
    private short v;
    private int w;
    private int x;
    private byte y;
    private byte z;

    private Pfm2afm(RandomAccessFileOrArray randomAccessFileOrArray, OutputStream outputStream) throws IOException {
        this.f26374a = randomAccessFileOrArray;
        this.f26375b = new PrintWriter(new OutputStreamWriter(outputStream, "ISO-8859-1"));
    }

    public static void a(RandomAccessFileOrArray randomAccessFileOrArray, OutputStream outputStream) throws IOException {
        Pfm2afm pfm2afm = new Pfm2afm(randomAccessFileOrArray, outputStream);
        pfm2afm.b();
        pfm2afm.f();
        pfm2afm.e();
        pfm2afm.g();
        pfm2afm.h();
        pfm2afm.f26375b.flush();
    }

    private void b() throws IOException {
        int i2;
        this.f26374a.r(0);
        this.f26376c = this.f26374a.m();
        this.f26377d = this.f26374a.k();
        this.f26378e = j(60);
        this.f26379f = this.f26374a.m();
        this.f26380g = this.f26374a.m();
        this.f26381h = this.f26374a.m();
        this.f26382i = this.f26374a.m();
        this.f26383j = this.f26374a.m();
        this.f26384k = this.f26374a.m();
        this.f26385l = this.f26374a.m();
        this.f26386m = (byte) this.f26374a.read();
        this.f26387n = (byte) this.f26374a.read();
        this.o = (byte) this.f26374a.read();
        this.p = this.f26374a.m();
        this.q = (byte) this.f26374a.read();
        this.r = this.f26374a.m();
        this.s = this.f26374a.m();
        this.t = (byte) this.f26374a.read();
        this.u = this.f26374a.m();
        this.v = this.f26374a.m();
        this.w = this.f26374a.read();
        this.x = this.f26374a.read();
        this.y = (byte) this.f26374a.read();
        this.z = (byte) this.f26374a.read();
        this.A = this.f26374a.m();
        this.B = this.f26374a.k();
        this.C = this.f26374a.k();
        this.D = this.f26374a.k();
        this.E = this.f26374a.k();
        this.F = this.f26374a.m();
        this.G = this.f26374a.k();
        this.H = this.f26374a.k();
        this.I = this.f26374a.k();
        this.J = this.f26374a.k();
        this.K = this.f26374a.k();
        this.L = this.f26374a.k();
        if (((long) this.f26377d) != this.f26374a.e() || this.F != 30 || (i2 = this.L) < 75 || i2 > 512) {
            throw new IOException(MessageLocalization.b("not.a.valid.pfm.file", new Object[0]));
        }
        this.f26374a.r((long) (this.G + 14));
        this.M = this.f26374a.m();
        this.N = this.f26374a.m();
        this.O = this.f26374a.m();
        this.P = this.f26374a.m();
    }

    private void c(int i2, int i3, String str) {
        this.f26375b.print("C ");
        d(i2);
        this.f26375b.print(" ; WX ");
        d(i3);
        if (str != null) {
            this.f26375b.print(" ; N ");
            this.f26375b.print(str);
        }
        this.f26375b.print(" ;\n");
    }

    private void d(int i2) {
        this.f26375b.print(' ');
        this.f26375b.print(i2);
    }

    private void e() throws IOException {
        int i2 = (this.x - this.w) + 1;
        int[] iArr = new int[i2];
        this.f26374a.r((long) this.H);
        for (int i3 = 0; i3 < i2; i3++) {
            iArr[i3] = this.f26374a.q();
        }
        int[] iArr2 = new int[256];
        if (this.q == 0) {
            for (int i4 = this.w; i4 <= this.x; i4++) {
                int i5 = this.R[i4];
                if (i5 != 0) {
                    iArr2[i5] = i4;
                }
            }
        }
        this.f26375b.print("StartCharMetrics");
        d(i2);
        this.f26375b.print(10);
        if (this.q != 0) {
            for (int i6 = this.w; i6 <= this.x; i6++) {
                int i7 = this.w;
                if (iArr[i6 - i7] != 0) {
                    c(i6, iArr[i6 - i7], (String) null);
                }
            }
        } else {
            for (int i8 = 0; i8 < 256; i8++) {
                int i9 = iArr2[i8];
                if (i9 != 0) {
                    c(i8, iArr[i9 - this.w], this.T[i9]);
                    iArr[i9 - this.w] = 0;
                }
            }
            for (int i10 = this.w; i10 <= this.x; i10++) {
                int i11 = this.w;
                if (iArr[i10 - i11] != 0) {
                    c(-1, iArr[i10 - i11], this.T[i10]);
                }
            }
        }
        this.f26375b.print("EndCharMetrics\n");
    }

    private void f() throws IOException {
        PrintWriter printWriter;
        String str;
        PrintWriter printWriter2;
        String str2;
        PrintWriter printWriter3;
        String str3;
        this.f26375b.print("StartFontMetrics 2.0\n");
        if (this.f26378e.length() > 0) {
            PrintWriter printWriter4 = this.f26375b;
            printWriter4.print("Comment " + this.f26378e + 10);
        }
        this.f26375b.print("FontName ");
        this.f26374a.r((long) this.L);
        String i2 = i();
        this.f26375b.print(i2);
        this.f26375b.print("\nEncodingScheme ");
        if (this.q != 0) {
            printWriter = this.f26375b;
            str = "FontSpecific\n";
        } else {
            printWriter = this.f26375b;
            str = "AdobeStandardEncoding\n";
        }
        printWriter.print(str);
        PrintWriter printWriter5 = this.f26375b;
        printWriter5.print("FullName " + i2.replace('-', ' '));
        int i3 = this.C;
        if (i3 != 0) {
            this.f26374a.r((long) i3);
            PrintWriter printWriter6 = this.f26375b;
            printWriter6.print("\nFamilyName " + i());
        }
        this.f26375b.print("\nWeight ");
        if (this.p > 475 || i2.toLowerCase().indexOf("bold") >= 0) {
            printWriter2 = this.f26375b;
            str2 = "Bold";
        } else {
            short s2 = this.p;
            if ((s2 < 325 && s2 != 0) || i2.toLowerCase().indexOf("light") >= 0) {
                printWriter2 = this.f26375b;
                str2 = "Light";
            } else if (i2.toLowerCase().indexOf("black") >= 0) {
                printWriter2 = this.f26375b;
                str2 = "Black";
            } else {
                printWriter2 = this.f26375b;
                str2 = "Medium";
            }
        }
        printWriter2.print(str2);
        this.f26375b.print("\nItalicAngle ");
        if (this.f26386m != 0 || i2.toLowerCase().indexOf("italic") >= 0) {
            printWriter3 = this.f26375b;
            str3 = "-12.00";
        } else {
            printWriter3 = this.f26375b;
            str3 = "0";
        }
        printWriter3.print(str3);
        this.f26375b.print("\nIsFixedPitch ");
        if ((this.t & 1) == 0 || this.u == this.v) {
            this.f26375b.print(PdfBoolean.l3);
            this.Q = true;
        } else {
            this.f26375b.print("false");
            this.Q = false;
        }
        this.f26375b.print("\nFontBBox");
        d(this.Q ? -20 : -100);
        d(-(this.P + 5));
        d(this.v + 10);
        d(this.f26383j + 5);
        this.f26375b.print("\nCapHeight");
        d(this.M);
        this.f26375b.print("\nXHeight");
        d(this.N);
        this.f26375b.print("\nDescender");
        d(-this.P);
        this.f26375b.print("\nAscender");
        d(this.O);
        this.f26375b.print(10);
    }

    private void g() throws IOException {
        int i2 = this.J;
        if (i2 != 0) {
            this.f26374a.r((long) i2);
            int q2 = this.f26374a.q() * 3;
            int[] iArr = new int[q2];
            int i3 = 0;
            int i4 = 0;
            while (i3 < q2) {
                iArr[i3] = this.f26374a.read();
                int i5 = i3 + 2;
                iArr[i3 + 1] = this.f26374a.read();
                i3 += 3;
                int m2 = this.f26374a.m();
                iArr[i5] = m2;
                if (m2 != 0) {
                    i4++;
                }
            }
            if (i4 != 0) {
                this.f26375b.print("StartKernData\nStartKernPairs");
                d(i4);
                this.f26375b.print(10);
                for (int i6 = 0; i6 < q2; i6 += 3) {
                    int i7 = i6 + 2;
                    if (iArr[i7] != 0) {
                        this.f26375b.print("KPX ");
                        this.f26375b.print(this.T[iArr[i6]]);
                        this.f26375b.print(' ');
                        this.f26375b.print(this.T[iArr[i6 + 1]]);
                        d(iArr[i7]);
                        this.f26375b.print(10);
                    }
                }
                this.f26375b.print("EndKernPairs\nEndKernData\n");
            }
        }
    }

    private void h() {
        this.f26375b.print("EndFontMetrics\n");
    }

    private String i() throws IOException {
        StringBuffer stringBuffer = new StringBuffer();
        while (true) {
            int read = this.f26374a.read();
            if (read <= 0) {
                return stringBuffer.toString();
            }
            stringBuffer.append((char) read);
        }
    }

    private String j(int i2) throws IOException {
        byte[] bArr = new byte[i2];
        this.f26374a.readFully(bArr);
        int i3 = 0;
        while (i3 < i2 && bArr[i3] != 0) {
            i3++;
        }
        return new String(bArr, 0, i3, "ISO-8859-1");
    }
}
