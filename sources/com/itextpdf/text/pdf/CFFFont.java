package com.itextpdf.text.pdf;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.exifinterface.media.ExifInterface;
import androidx.media3.exoplayer.upstream.CmcdData;
import com.google.common.base.Ascii;
import com.itextpdf.text.ExceptionConverter;
import com.itextpdf.tool.xml.html.HTML;
import java.util.Iterator;
import java.util.LinkedList;
import kotlinx.coroutines.scheduling.WorkQueueKt;

public class CFFFont {
    static final String[] p = {"version", "Notice", "FullName", "FamilyName", "Weight", "FontBBox", "BlueValues", "OtherBlues", "FamilyBlues", "FamilyOtherBlues", "StdHW", "StdVW", "UNKNOWN_12", "UniqueID", "XUID", "charset", "Encoding", "CharStrings", "Private", "Subrs", "defaultWidthX", "nominalWidthX", "UNKNOWN_22", "UNKNOWN_23", "UNKNOWN_24", "UNKNOWN_25", "UNKNOWN_26", "UNKNOWN_27", "UNKNOWN_28", "UNKNOWN_29", "UNKNOWN_30", "UNKNOWN_31", ExifInterface.a0, "isFixedPitch", "ItalicAngle", "UnderlinePosition", "UnderlineThickness", "PaintType", "CharstringType", "FontMatrix", "StrokeWidth", "BlueScale", "BlueShift", "BlueFuzz", "StemSnapH", "StemSnapV", "ForceBold", "UNKNOWN_12_15", "UNKNOWN_12_16", "LanguageGroup", "ExpansionFactor", "initialRandomSeed", "SyntheticBase", "PostScript", "BaseFontName", "BaseFontBlend", "UNKNOWN_12_24", "UNKNOWN_12_25", "UNKNOWN_12_26", "UNKNOWN_12_27", "UNKNOWN_12_28", "UNKNOWN_12_29", "ROS", "CIDFontVersion", "CIDFontRevision", "CIDFontType", "CIDCount", "UIDBase", "FDArray", "FDSelect", "FontName"};
    static final String[] q = {BaseFont.t4, "space", "exclam", "quotedbl", "numbersign", "dollar", "percent", "ampersand", "quoteright", "parenleft", "parenright", "asterisk", "plus", "comma", "hyphen", TypedValues.CycleType.Q, "slash", "zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "colon", "semicolon", "less", "equal", "greater", "question", "at", ExifInterface.W4, "B", "C", "D", ExifInterface.S4, "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", ExifInterface.R4, ExifInterface.d5, "U", ExifInterface.X4, ExifInterface.T4, "X", "Y", "Z", "bracketleft", "backslash", "bracketright", "asciicircum", "underscore", "quoteleft", "a", "b", "c", "d", "e", "f", "g", CmcdData.Factory.f12510n, "i", "j", "k", CmcdData.Factory.q, "m", "n", "o", "p", HTML.Tag.C0, "r", "s", "t", "u", "v", "w", "x", "y", "z", "braceleft", "bar", "braceright", "asciitilde", "exclamdown", "cent", "sterling", "fraction", "yen", "florin", HTML.Tag.V, "currency", "quotesingle", "quotedblleft", "guillemotleft", "guilsinglleft", "guilsinglright", "fi", "fl", "endash", "dagger", "daggerdbl", "periodcentered", "paragraph", "bullet", "quotesinglbase", "quotedblbase", "quotedblright", "guillemotright", "ellipsis", "perthousand", "questiondown", "grave", "acute", "circumflex", "tilde", "macron", "breve", "dotaccent", "dieresis", "ring", "cedilla", "hungarumlaut", "ogonek", "caron", "emdash", "AE", "ordfeminine", "Lslash", "Oslash", "OE", "ordmasculine", "ae", "dotlessi", "lslash", "oslash", "oe", "germandbls", "onesuperior", "logicalnot", "mu", "trademark", "Eth", "onehalf", "plusminus", "Thorn", "onequarter", "divide", "brokenbar", "degree", "thorn", "threequarters", "twosuperior", "registered", "minus", "eth", "multiply", "threesuperior", "copyright", "Aacute", "Acircumflex", "Adieresis", "Agrave", "Aring", "Atilde", "Ccedilla", "Eacute", "Ecircumflex", "Edieresis", "Egrave", "Iacute", "Icircumflex", "Idieresis", "Igrave", "Ntilde", "Oacute", "Ocircumflex", "Odieresis", "Ograve", "Otilde", "Scaron", "Uacute", "Ucircumflex", "Udieresis", "Ugrave", "Yacute", "Ydieresis", "Zcaron", "aacute", "acircumflex", "adieresis", "agrave", "aring", "atilde", "ccedilla", "eacute", "ecircumflex", "edieresis", "egrave", "iacute", "icircumflex", "idieresis", "igrave", "ntilde", "oacute", "ocircumflex", "odieresis", "ograve", "otilde", "scaron", "uacute", "ucircumflex", "udieresis", "ugrave", "yacute", "ydieresis", "zcaron", "exclamsmall", "Hungarumlautsmall", "dollaroldstyle", "dollarsuperior", "ampersandsmall", "Acutesmall", "parenleftsuperior", "parenrightsuperior", "twodotenleader", "onedotenleader", "zerooldstyle", "oneoldstyle", "twooldstyle", "threeoldstyle", "fouroldstyle", "fiveoldstyle", "sixoldstyle", "sevenoldstyle", "eightoldstyle", "nineoldstyle", "commasuperior", "threequartersemdash", "periodsuperior", "questionsmall", "asuperior", "bsuperior", "centsuperior", "dsuperior", "esuperior", "isuperior", "lsuperior", "msuperior", "nsuperior", "osuperior", "rsuperior", "ssuperior", "tsuperior", "ff", "ffi", "ffl", "parenleftinferior", "parenrightinferior", "Circumflexsmall", "hyphensuperior", "Gravesmall", "Asmall", "Bsmall", "Csmall", "Dsmall", "Esmall", "Fsmall", "Gsmall", "Hsmall", "Ismall", "Jsmall", "Ksmall", "Lsmall", "Msmall", "Nsmall", "Osmall", "Psmall", "Qsmall", "Rsmall", "Ssmall", "Tsmall", "Usmall", "Vsmall", "Wsmall", "Xsmall", "Ysmall", "Zsmall", "colonmonetary", "onefitted", "rupiah", "Tildesmall", "exclamdownsmall", "centoldstyle", "Lslashsmall", "Scaronsmall", "Zcaronsmall", "Dieresissmall", "Brevesmall", "Caronsmall", "Dotaccentsmall", "Macronsmall", "figuredash", "hypheninferior", "Ogoneksmall", "Ringsmall", "Cedillasmall", "questiondownsmall", "oneeighth", "threeeighths", "fiveeighths", "seveneighths", "onethird", "twothirds", "zerosuperior", "foursuperior", "fivesuperior", "sixsuperior", "sevensuperior", "eightsuperior", "ninesuperior", "zeroinferior", "oneinferior", "twoinferior", "threeinferior", "fourinferior", "fiveinferior", "sixinferior", "seveninferior", "eightinferior", "nineinferior", "centinferior", "dollarinferior", "periodinferior", "commainferior", "Agravesmall", "Aacutesmall", "Acircumflexsmall", "Atildesmall", "Adieresissmall", "Aringsmall", "AEsmall", "Ccedillasmall", "Egravesmall", "Eacutesmall", "Ecircumflexsmall", "Edieresissmall", "Igravesmall", "Iacutesmall", "Icircumflexsmall", "Idieresissmall", "Ethsmall", "Ntildesmall", "Ogravesmall", "Oacutesmall", "Ocircumflexsmall", "Otildesmall", "Odieresissmall", "OEsmall", "Oslashsmall", "Ugravesmall", "Uacutesmall", "Ucircumflexsmall", "Udieresissmall", "Yacutesmall", "Thornsmall", "Ydieresissmall", "001.000", "001.001", "001.002", "001.003", "Black", "Bold", "Book", "Light", "Medium", "Regular", "Roman", "Semibold"};

    /* renamed from: a  reason: collision with root package name */
    int f25966a;

    /* renamed from: b  reason: collision with root package name */
    protected String f25967b;

    /* renamed from: c  reason: collision with root package name */
    protected Object[] f25968c = new Object[48];

    /* renamed from: d  reason: collision with root package name */
    protected int f25969d = 0;

    /* renamed from: e  reason: collision with root package name */
    protected RandomAccessFileOrArray f25970e;

    /* renamed from: f  reason: collision with root package name */
    private int f25971f;

    /* renamed from: g  reason: collision with root package name */
    protected int f25972g;

    /* renamed from: h  reason: collision with root package name */
    protected int f25973h;

    /* renamed from: i  reason: collision with root package name */
    protected int f25974i;

    /* renamed from: j  reason: collision with root package name */
    protected int f25975j;

    /* renamed from: k  reason: collision with root package name */
    protected int[] f25976k;

    /* renamed from: l  reason: collision with root package name */
    protected int[] f25977l;

    /* renamed from: m  reason: collision with root package name */
    protected int[] f25978m;

    /* renamed from: n  reason: collision with root package name */
    protected int[] f25979n;
    protected Font[] o;

    protected static final class DictNumberItem extends Item {

        /* renamed from: b  reason: collision with root package name */
        public final int f25980b;

        /* renamed from: c  reason: collision with root package name */
        public int f25981c = 5;

        public DictNumberItem(int i2) {
            this.f25980b = i2;
        }

        public void a(byte[] bArr) {
            if (this.f25981c == 5) {
                int i2 = this.f26000a;
                bArr[i2] = Ascii.G;
                int i3 = this.f25980b;
                bArr[i2 + 1] = (byte) ((i3 >>> 24) & 255);
                bArr[i2 + 2] = (byte) ((i3 >>> 16) & 255);
                bArr[i2 + 3] = (byte) ((i3 >>> 8) & 255);
                bArr[i2 + 4] = (byte) (i3 & 255);
            }
        }

        public void b(int[] iArr) {
            super.b(iArr);
            iArr[0] = iArr[0] + this.f25981c;
        }
    }

    protected static final class DictOffsetItem extends OffsetItem {

        /* renamed from: c  reason: collision with root package name */
        public final int f25982c = 5;

        public void a(byte[] bArr) {
            if (this.f25982c == 5) {
                int i2 = this.f26000a;
                bArr[i2] = Ascii.G;
                int i3 = this.f26002b;
                bArr[i2 + 1] = (byte) ((i3 >>> 24) & 255);
                bArr[i2 + 2] = (byte) ((i3 >>> 16) & 255);
                bArr[i2 + 3] = (byte) ((i3 >>> 8) & 255);
                bArr[i2 + 4] = (byte) (i3 & 255);
            }
        }

        public void b(int[] iArr) {
            super.b(iArr);
            iArr[0] = iArr[0] + this.f25982c;
        }
    }

    protected final class Font {
        public int[] A;
        public int[][] B;
        public int[] C;

        /* renamed from: a  reason: collision with root package name */
        public String f25983a;

        /* renamed from: b  reason: collision with root package name */
        public String f25984b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f25985c = false;

        /* renamed from: d  reason: collision with root package name */
        public int f25986d = -1;

        /* renamed from: e  reason: collision with root package name */
        public int f25987e = -1;

        /* renamed from: f  reason: collision with root package name */
        public int f25988f = -1;

        /* renamed from: g  reason: collision with root package name */
        public int f25989g = -1;

        /* renamed from: h  reason: collision with root package name */
        public int f25990h = -1;

        /* renamed from: i  reason: collision with root package name */
        public int f25991i = -1;

        /* renamed from: j  reason: collision with root package name */
        public int f25992j = -1;

        /* renamed from: k  reason: collision with root package name */
        public int f25993k = -1;

        /* renamed from: l  reason: collision with root package name */
        public int[] f25994l;

        /* renamed from: m  reason: collision with root package name */
        public int[] f25995m;

        /* renamed from: n  reason: collision with root package name */
        public int[] f25996n;
        public int o;
        public int p;
        public int q;
        public int[] r;
        public int[] s;
        public int[] t;
        public int u;
        public int v;
        public int w = 2;
        public int x;
        public int y;
        public int[] z;

        protected Font() {
        }
    }

    protected static final class IndexBaseItem extends Item {
    }

    protected static final class IndexMarkerItem extends Item {

        /* renamed from: b  reason: collision with root package name */
        private OffsetItem f25997b;

        /* renamed from: c  reason: collision with root package name */
        private IndexBaseItem f25998c;

        public IndexMarkerItem(OffsetItem offsetItem, IndexBaseItem indexBaseItem) {
            this.f25997b = offsetItem;
            this.f25998c = indexBaseItem;
        }

        public void c() {
            this.f25997b.d((this.f26000a - this.f25998c.f26000a) + 1);
        }
    }

    protected static final class IndexOffsetItem extends OffsetItem {

        /* renamed from: c  reason: collision with root package name */
        public final int f25999c;

        public IndexOffsetItem(int i2) {
            this.f25999c = i2;
        }

        public void a(byte[] bArr) {
            int i2 = this.f25999c;
            int i3 = 0;
            if (i2 != 1) {
                if (i2 != 2) {
                    if (i2 != 3) {
                        if (i2 == 4) {
                            bArr[this.f26000a] = (byte) ((this.f26002b >>> 24) & 255);
                            i3 = 1;
                        } else {
                            return;
                        }
                    }
                    bArr[this.f26000a + i3] = (byte) ((this.f26002b >>> 16) & 255);
                    i3++;
                }
                bArr[this.f26000a + i3] = (byte) ((this.f26002b >>> 8) & 255);
                i3++;
            }
            bArr[this.f26000a + i3] = (byte) (this.f26002b & 255);
        }

        public void b(int[] iArr) {
            super.b(iArr);
            iArr[0] = iArr[0] + this.f25999c;
        }

        public IndexOffsetItem(int i2, int i3) {
            this.f25999c = i2;
            this.f26002b = i3;
        }
    }

    protected static abstract class Item {

        /* renamed from: a  reason: collision with root package name */
        protected int f26000a = -1;

        protected Item() {
        }

        public void a(byte[] bArr) {
        }

        public void b(int[] iArr) {
            this.f26000a = iArr[0];
        }

        public void c() {
        }
    }

    protected static final class MarkerItem extends Item {

        /* renamed from: b  reason: collision with root package name */
        OffsetItem f26001b;

        public MarkerItem(OffsetItem offsetItem) {
            this.f26001b = offsetItem;
        }

        public void c() {
            this.f26001b.d(this.f26000a);
        }
    }

    protected static abstract class OffsetItem extends Item {

        /* renamed from: b  reason: collision with root package name */
        public int f26002b;

        protected OffsetItem() {
        }

        public void d(int i2) {
            this.f26002b = i2;
        }
    }

    protected static final class RangeItem extends Item {

        /* renamed from: b  reason: collision with root package name */
        public int f26003b;

        /* renamed from: c  reason: collision with root package name */
        public int f26004c;

        /* renamed from: d  reason: collision with root package name */
        private RandomAccessFileOrArray f26005d;

        public RangeItem(RandomAccessFileOrArray randomAccessFileOrArray, int i2, int i3) {
            this.f26003b = i2;
            this.f26004c = i3;
            this.f26005d = randomAccessFileOrArray;
        }

        public void a(byte[] bArr) {
            try {
                this.f26005d.r((long) this.f26003b);
                for (int i2 = this.f26000a; i2 < this.f26000a + this.f26004c; i2++) {
                    bArr[i2] = this.f26005d.readByte();
                }
            } catch (Exception e2) {
                throw new ExceptionConverter(e2);
            }
        }

        public void b(int[] iArr) {
            super.b(iArr);
            iArr[0] = iArr[0] + this.f26004c;
        }
    }

    protected static final class StringItem extends Item {

        /* renamed from: b  reason: collision with root package name */
        public String f26006b;

        public StringItem(String str) {
            this.f26006b = str;
        }

        public void a(byte[] bArr) {
            for (int i2 = 0; i2 < this.f26006b.length(); i2++) {
                bArr[this.f26000a + i2] = (byte) (this.f26006b.charAt(i2) & 255);
            }
        }

        public void b(int[] iArr) {
            super.b(iArr);
            iArr[0] = iArr[0] + this.f26006b.length();
        }
    }

    protected static final class SubrMarkerItem extends Item {

        /* renamed from: b  reason: collision with root package name */
        private OffsetItem f26007b;

        /* renamed from: c  reason: collision with root package name */
        private IndexBaseItem f26008c;

        public SubrMarkerItem(OffsetItem offsetItem, IndexBaseItem indexBaseItem) {
            this.f26007b = offsetItem;
            this.f26008c = indexBaseItem;
        }

        public void c() {
            this.f26007b.d(this.f26000a - this.f26008c.f26000a);
        }
    }

    protected static final class UInt16Item extends Item {

        /* renamed from: b  reason: collision with root package name */
        public char f26009b;

        public UInt16Item(char c2) {
            this.f26009b = c2;
        }

        public void a(byte[] bArr) {
            int i2 = this.f26000a;
            char c2 = this.f26009b;
            bArr[i2] = (byte) ((c2 >>> 8) & 255);
            bArr[i2 + 1] = (byte) (c2 & 255);
        }

        public void b(int[] iArr) {
            super.b(iArr);
            iArr[0] = iArr[0] + 2;
        }
    }

    protected static final class UInt24Item extends Item {

        /* renamed from: b  reason: collision with root package name */
        public int f26010b;

        public UInt24Item(int i2) {
            this.f26010b = i2;
        }

        public void a(byte[] bArr) {
            int i2 = this.f26000a;
            int i3 = this.f26010b;
            bArr[i2] = (byte) ((i3 >>> 16) & 255);
            bArr[i2 + 1] = (byte) ((i3 >>> 8) & 255);
            bArr[i2 + 2] = (byte) (i3 & 255);
        }

        public void b(int[] iArr) {
            super.b(iArr);
            iArr[0] = iArr[0] + 3;
        }
    }

    protected static final class UInt32Item extends Item {

        /* renamed from: b  reason: collision with root package name */
        public int f26011b;

        public UInt32Item(int i2) {
            this.f26011b = i2;
        }

        public void a(byte[] bArr) {
            int i2 = this.f26000a;
            int i3 = this.f26011b;
            bArr[i2] = (byte) ((i3 >>> 24) & 255);
            bArr[i2 + 1] = (byte) ((i3 >>> 16) & 255);
            bArr[i2 + 2] = (byte) ((i3 >>> 8) & 255);
            bArr[i2 + 3] = (byte) (i3 & 255);
        }

        public void b(int[] iArr) {
            super.b(iArr);
            iArr[0] = iArr[0] + 4;
        }
    }

    protected static final class UInt8Item extends Item {

        /* renamed from: b  reason: collision with root package name */
        public char f26012b;

        public UInt8Item(char c2) {
            this.f26012b = c2;
        }

        public void a(byte[] bArr) {
            bArr[this.f26000a] = (byte) (this.f26012b & 255);
        }

        public void b(int[] iArr) {
            super.b(iArr);
            iArr[0] = iArr[0] + 1;
        }
    }

    public CFFFont(RandomAccessFileOrArray randomAccessFileOrArray) {
        int i2;
        int i3;
        int i4;
        this.f25970e = randomAccessFileOrArray;
        p(0);
        e();
        e();
        char e2 = e();
        this.f25971f = e();
        this.f25972g = e2;
        int[] h2 = h(e2);
        this.f25976k = h2;
        int i5 = h2[h2.length - 1];
        this.f25973h = i5;
        int[] h3 = h(i5);
        this.f25977l = h3;
        int i6 = h3[h3.length - 1];
        this.f25974i = i6;
        int[] h4 = h(i6);
        this.f25978m = h4;
        int i7 = h4[h4.length - 1];
        this.f25975j = i7;
        this.f25979n = h(i7);
        this.o = new Font[(this.f25976k.length - 1)];
        int i8 = 0;
        while (i8 < this.f25976k.length - 1) {
            this.o[i8] = new Font();
            p(this.f25976k[i8]);
            this.o[i8].f25983a = "";
            int i9 = this.f25976k[i8];
            while (true) {
                i4 = i8 + 1;
                if (i9 >= this.f25976k[i4]) {
                    break;
                }
                StringBuilder sb = new StringBuilder();
                Font font = this.o[i8];
                sb.append(font.f25983a);
                sb.append(e());
                font.f25983a = sb.toString();
                i9++;
            }
            i8 = i4;
        }
        int i10 = 0;
        while (true) {
            int[] iArr = this.f25977l;
            if (i10 < iArr.length - 1) {
                int i11 = iArr[i10];
                while (true) {
                    p(i11);
                    while (true) {
                        i2 = i10 + 1;
                        if (l() >= this.f25977l[i2]) {
                            break;
                        }
                        f();
                        String str = this.f25967b;
                        if (str == "FullName") {
                            this.o[i10].f25984b = n((char) ((Integer) this.f25968c[0]).intValue());
                        } else if (str == "ROS") {
                            this.o[i10].f25985c = true;
                        } else if (str == "Private") {
                            this.o[i10].f25987e = ((Integer) this.f25968c[0]).intValue();
                            this.o[i10].f25986d = ((Integer) this.f25968c[1]).intValue();
                        } else if (str == "charset") {
                            this.o[i10].f25991i = ((Integer) this.f25968c[0]).intValue();
                        } else if (str == "CharStrings") {
                            break;
                        } else if (str == "FDArray") {
                            this.o[i10].f25992j = ((Integer) this.f25968c[0]).intValue();
                        } else if (str == "FDSelect") {
                            this.o[i10].f25993k = ((Integer) this.f25968c[0]).intValue();
                        } else if (str == "CharstringType") {
                            this.o[i10].w = ((Integer) this.f25968c[0]).intValue();
                        }
                    }
                    this.o[i10].f25989g = ((Integer) this.f25968c[0]).intValue();
                    i11 = l();
                    Font font2 = this.o[i10];
                    font2.r = h(font2.f25989g);
                }
                int i12 = this.o[i10].f25986d;
                if (i12 >= 0) {
                    p(i12);
                    while (true) {
                        int l2 = l();
                        Font font3 = this.o[i10];
                        if (l2 >= font3.f25986d + font3.f25987e) {
                            break;
                        }
                        f();
                        if (this.f25967b == "Subrs") {
                            this.o[i10].f25988f = ((Integer) this.f25968c[0]).intValue() + this.o[i10].f25986d;
                        }
                    }
                }
                int i13 = this.o[i10].f25992j;
                if (i13 >= 0) {
                    int[] h5 = h(i13);
                    Font font4 = this.o[i10];
                    font4.f25994l = new int[(h5.length - 1)];
                    font4.f25995m = new int[(h5.length - 1)];
                    int i14 = 0;
                    while (i14 < h5.length - 1) {
                        p(h5[i14]);
                        while (true) {
                            i3 = i14 + 1;
                            if (l() >= h5[i3]) {
                                break;
                            }
                            f();
                            if (this.f25967b == "Private") {
                                this.o[i10].f25995m[i14] = ((Integer) this.f25968c[0]).intValue();
                                this.o[i10].f25994l[i14] = ((Integer) this.f25968c[1]).intValue();
                            }
                        }
                        i14 = i3;
                    }
                }
                i10 = i2;
            } else {
                return;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void a(int i2) {
        p(i2);
        e();
    }

    public boolean b(String str) {
        int i2 = 0;
        while (true) {
            Font[] fontArr = this.o;
            if (i2 >= fontArr.length) {
                return false;
            }
            if (str.equals(fontArr[i2].f25983a)) {
                return true;
            }
            i2++;
        }
    }

    public byte[] c(String str) {
        int i2;
        char c2;
        int i3 = 0;
        while (true) {
            Font[] fontArr = this.o;
            if (i3 >= fontArr.length) {
                break;
            }
            if (str.equals(fontArr[i3].f25983a)) {
                break;
            }
            i3++;
        }
        if (i3 == this.o.length) {
            return null;
        }
        LinkedList linkedList = new LinkedList();
        p(0);
        e();
        e();
        char e2 = e();
        e();
        this.f25966a = e2;
        linkedList.addLast(new RangeItem(this.f25970e, 0, e2));
        Font font = this.o[i3];
        if (!font.f25985c) {
            p(font.f25989g);
            c2 = d();
            p(this.f25974i);
            i2 = d() + q.length;
        } else {
            c2 = 65535;
            i2 = -1;
        }
        linkedList.addLast(new UInt16Item(1));
        linkedList.addLast(new UInt8Item(1));
        linkedList.addLast(new UInt8Item(1));
        linkedList.addLast(new UInt8Item((char) (this.o[i3].f25983a.length() + 1)));
        linkedList.addLast(new StringItem(this.o[i3].f25983a));
        linkedList.addLast(new UInt16Item(1));
        linkedList.addLast(new UInt8Item(2));
        linkedList.addLast(new UInt16Item(1));
        IndexOffsetItem indexOffsetItem = new IndexOffsetItem(2);
        linkedList.addLast(indexOffsetItem);
        IndexBaseItem indexBaseItem = new IndexBaseItem();
        linkedList.addLast(indexBaseItem);
        DictOffsetItem dictOffsetItem = new DictOffsetItem();
        DictOffsetItem dictOffsetItem2 = new DictOffsetItem();
        DictOffsetItem dictOffsetItem3 = new DictOffsetItem();
        DictOffsetItem dictOffsetItem4 = new DictOffsetItem();
        if (!this.o[i3].f25985c) {
            linkedList.addLast(new DictNumberItem(i2));
            linkedList.addLast(new DictNumberItem(i2 + 1));
            linkedList.addLast(new DictNumberItem(0));
            linkedList.addLast(new UInt8Item(12));
            linkedList.addLast(new UInt8Item(30));
            linkedList.addLast(new DictNumberItem(c2));
            linkedList.addLast(new UInt8Item(12));
            linkedList.addLast(new UInt8Item('\"'));
        }
        linkedList.addLast(dictOffsetItem3);
        linkedList.addLast(new UInt8Item(12));
        linkedList.addLast(new UInt8Item('$'));
        linkedList.addLast(dictOffsetItem4);
        linkedList.addLast(new UInt8Item(12));
        linkedList.addLast(new UInt8Item('%'));
        linkedList.addLast(dictOffsetItem);
        linkedList.addLast(new UInt8Item(15));
        linkedList.addLast(dictOffsetItem2);
        linkedList.addLast(new UInt8Item(17));
        p(this.f25977l[i3]);
        while (l() < this.f25977l[i3 + 1]) {
            int l2 = l();
            f();
            int l3 = l();
            String str2 = this.f25967b;
            if (!(str2 == "Encoding" || str2 == "Private" || str2 == "FDSelect" || str2 == "FDArray" || str2 == "charset" || str2 == "CharStrings")) {
                linkedList.add(new RangeItem(this.f25970e, l2, l3 - l2));
            }
        }
        linkedList.addLast(new IndexMarkerItem(indexOffsetItem, indexBaseItem));
        if (this.o[i3].f25985c) {
            linkedList.addLast(g(this.f25974i));
        } else {
            String str3 = this.o[i3].f25983a + "-OneRange";
            if (str3.length() > 127) {
                str3 = str3.substring(0, WorkQueueKt.f29430c);
            }
            String str4 = "AdobeIdentity" + str3;
            int[] iArr = this.f25978m;
            int i4 = iArr[iArr.length - 1];
            int i5 = iArr[0];
            int i6 = i4 - i5;
            int i7 = i5 - 1;
            int i8 = str4.length() + i6 <= 255 ? 1 : str4.length() + i6 <= 65535 ? 2 : str4.length() + i6 <= 16777215 ? 3 : 4;
            linkedList.addLast(new UInt16Item((char) (this.f25978m.length + 2)));
            linkedList.addLast(new UInt8Item((char) i8));
            int[] iArr2 = this.f25978m;
            int i9 = 0;
            for (int length = iArr2.length; i9 < length; length = length) {
                linkedList.addLast(new IndexOffsetItem(i8, iArr2[i9] - i7));
                i9++;
                iArr2 = iArr2;
            }
            int[] iArr3 = this.f25978m;
            int i10 = iArr3[iArr3.length - 1] - i7;
            linkedList.addLast(new IndexOffsetItem(i8, i10 + 5));
            int i11 = i10 + 13;
            linkedList.addLast(new IndexOffsetItem(i8, i11));
            linkedList.addLast(new IndexOffsetItem(i8, i11 + str3.length()));
            linkedList.addLast(new RangeItem(this.f25970e, this.f25978m[0], i6));
            linkedList.addLast(new StringItem(str4));
        }
        linkedList.addLast(g(this.f25975j));
        if (!this.o[i3].f25985c) {
            linkedList.addLast(new MarkerItem(dictOffsetItem4));
            linkedList.addLast(new UInt8Item(3));
            linkedList.addLast(new UInt16Item(1));
            linkedList.addLast(new UInt16Item(0));
            linkedList.addLast(new UInt8Item(0));
            linkedList.addLast(new UInt16Item((char) c2));
            linkedList.addLast(new MarkerItem(dictOffsetItem));
            linkedList.addLast(new UInt8Item(2));
            linkedList.addLast(new UInt16Item(1));
            linkedList.addLast(new UInt16Item((char) (c2 - 1)));
            linkedList.addLast(new MarkerItem(dictOffsetItem3));
            linkedList.addLast(new UInt16Item(1));
            linkedList.addLast(new UInt8Item(1));
            linkedList.addLast(new UInt8Item(1));
            IndexOffsetItem indexOffsetItem2 = new IndexOffsetItem(1);
            linkedList.addLast(indexOffsetItem2);
            IndexBaseItem indexBaseItem2 = new IndexBaseItem();
            linkedList.addLast(indexBaseItem2);
            linkedList.addLast(new DictNumberItem(this.o[i3].f25987e));
            DictOffsetItem dictOffsetItem5 = new DictOffsetItem();
            linkedList.addLast(dictOffsetItem5);
            linkedList.addLast(new UInt8Item(18));
            linkedList.addLast(new IndexMarkerItem(indexOffsetItem2, indexBaseItem2));
            linkedList.addLast(new MarkerItem(dictOffsetItem5));
            RandomAccessFileOrArray randomAccessFileOrArray = this.f25970e;
            Font font2 = this.o[i3];
            linkedList.addLast(new RangeItem(randomAccessFileOrArray, font2.f25986d, font2.f25987e));
            int i12 = this.o[i3].f25988f;
            if (i12 >= 0) {
                linkedList.addLast(g(i12));
            }
        }
        linkedList.addLast(new MarkerItem(dictOffsetItem2));
        linkedList.addLast(g(this.o[i3].f25989g));
        int[] iArr4 = {0};
        Iterator it2 = linkedList.iterator();
        while (it2.hasNext()) {
            ((Item) it2.next()).b(iArr4);
        }
        Iterator it3 = linkedList.iterator();
        while (it3.hasNext()) {
            ((Item) it3.next()).c();
        }
        byte[] bArr = new byte[iArr4[0]];
        Iterator it4 = linkedList.iterator();
        while (it4.hasNext()) {
            ((Item) it4.next()).a(bArr);
        }
        return bArr;
    }

    /* access modifiers changed from: package-private */
    public char d() {
        try {
            return this.f25970e.readChar();
        } catch (Exception e2) {
            throw new ExceptionConverter(e2);
        }
    }

    /* access modifiers changed from: package-private */
    public char e() {
        try {
            return (char) (this.f25970e.readByte() & 255);
        } catch (Exception e2) {
            throw new ExceptionConverter(e2);
        }
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x00ce, code lost:
        r2.append(r8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x00df, code lost:
        r3 = true;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void f() {
        /*
            r9 = this;
            r0 = 0
            r1 = 0
        L_0x0002:
            int r2 = r9.f25969d
            r3 = 0
            if (r1 >= r2) goto L_0x000e
            java.lang.Object[] r2 = r9.f25968c
            r2[r1] = r3
            int r1 = r1 + 1
            goto L_0x0002
        L_0x000e:
            r9.f25969d = r0
            r9.f25967b = r3
            r1 = 0
        L_0x0013:
            if (r1 != 0) goto L_0x0115
            char r2 = r9.e()
            r3 = 29
            r4 = 1
            if (r2 != r3) goto L_0x0032
            int r2 = r9.i()
            java.lang.Object[] r3 = r9.f25968c
            int r5 = r9.f25969d
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            r3[r5] = r2
        L_0x002c:
            int r2 = r9.f25969d
            int r2 = r2 + r4
            r9.f25969d = r2
            goto L_0x0013
        L_0x0032:
            r3 = 28
            if (r2 != r3) goto L_0x0045
            short r2 = r9.m()
            java.lang.Object[] r3 = r9.f25968c
            int r5 = r9.f25969d
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            r3[r5] = r2
            goto L_0x002c
        L_0x0045:
            r3 = 32
            if (r2 < r3) goto L_0x005b
            r5 = 246(0xf6, float:3.45E-43)
            if (r2 > r5) goto L_0x005b
            int r2 = r2 + -139
            byte r2 = (byte) r2
            java.lang.Object[] r3 = r9.f25968c
            int r5 = r9.f25969d
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            r3[r5] = r2
            goto L_0x002c
        L_0x005b:
            r5 = 247(0xf7, float:3.46E-43)
            if (r2 < r5) goto L_0x007a
            r5 = 250(0xfa, float:3.5E-43)
            if (r2 > r5) goto L_0x007a
            char r3 = r9.e()
            int r2 = r2 + -247
            int r2 = r2 * 256
            int r2 = r2 + r3
            int r2 = r2 + 108
            short r2 = (short) r2
            java.lang.Object[] r3 = r9.f25968c
            int r5 = r9.f25969d
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            r3[r5] = r2
            goto L_0x002c
        L_0x007a:
            r5 = 251(0xfb, float:3.52E-43)
            if (r2 < r5) goto L_0x009a
            r5 = 254(0xfe, float:3.56E-43)
            if (r2 > r5) goto L_0x009a
            char r3 = r9.e()
            int r2 = r2 + -251
            int r2 = -r2
            int r2 = r2 * 256
            int r2 = r2 - r3
            int r2 = r2 + -108
            short r2 = (short) r2
            java.lang.Object[] r3 = r9.f25968c
            int r5 = r9.f25969d
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            r3[r5] = r2
            goto L_0x002c
        L_0x009a:
            r5 = 30
            if (r2 != r5) goto L_0x00f9
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r3 = ""
            r2.<init>(r3)
            r3 = 0
            r5 = 0
            r6 = 0
            r7 = 0
        L_0x00a9:
            if (r3 != 0) goto L_0x00ed
            r8 = 2
            if (r5 != 0) goto L_0x00b3
            char r6 = r9.e()
            r5 = 2
        L_0x00b3:
            if (r5 != r4) goto L_0x00ba
            int r7 = r6 / 16
            int r5 = r5 + -1
            byte r5 = (byte) r5
        L_0x00ba:
            if (r5 != r8) goto L_0x00c1
            int r7 = r6 % 16
            int r5 = r5 + -1
            byte r5 = (byte) r5
        L_0x00c1:
            switch(r7) {
                case 10: goto L_0x00ea;
                case 11: goto L_0x00e7;
                case 12: goto L_0x00e4;
                case 13: goto L_0x00c4;
                case 14: goto L_0x00e1;
                case 15: goto L_0x00df;
                default: goto L_0x00c4;
            }
        L_0x00c4:
            if (r7 < 0) goto L_0x00d2
            r8 = 9
            if (r7 > r8) goto L_0x00d2
            java.lang.String r8 = java.lang.String.valueOf(r7)
        L_0x00ce:
            r2.append(r8)
            goto L_0x00a9
        L_0x00d2:
            java.lang.String r3 = "<NIBBLE ERROR: "
            r2.append(r3)
            r2.append(r7)
            r3 = 62
            r2.append(r3)
        L_0x00df:
            r3 = 1
            goto L_0x00a9
        L_0x00e1:
            java.lang.String r8 = "-"
            goto L_0x00ce
        L_0x00e4:
            java.lang.String r8 = "E-"
            goto L_0x00ce
        L_0x00e7:
            java.lang.String r8 = "E"
            goto L_0x00ce
        L_0x00ea:
            java.lang.String r8 = "."
            goto L_0x00ce
        L_0x00ed:
            java.lang.Object[] r3 = r9.f25968c
            int r5 = r9.f25969d
            java.lang.String r2 = r2.toString()
            r3[r5] = r2
            goto L_0x002c
        L_0x00f9:
            r5 = 21
            if (r2 > r5) goto L_0x0013
            r1 = 12
            if (r2 == r1) goto L_0x0108
            java.lang.String[] r1 = p
            r1 = r1[r2]
        L_0x0105:
            r9.f25967b = r1
            goto L_0x0112
        L_0x0108:
            java.lang.String[] r1 = p
            char r2 = r9.e()
            int r2 = r2 + r3
            r1 = r1[r2]
            goto L_0x0105
        L_0x0112:
            r1 = 1
            goto L_0x0013
        L_0x0115:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.itextpdf.text.pdf.CFFFont.f():void");
    }

    /* access modifiers changed from: protected */
    public RangeItem g(int i2) {
        p(i2);
        char d2 = d();
        if (d2 == 0) {
            return new RangeItem(this.f25970e, i2, 2);
        }
        char e2 = e();
        p(i2 + 3 + (d2 * e2));
        return new RangeItem(this.f25970e, i2, ((d2 + 1) * e2) + 3 + (k(e2) - 1));
    }

    /* access modifiers changed from: package-private */
    public int[] h(int i2) {
        p(i2);
        char d2 = d();
        int i3 = d2 + 1;
        int[] iArr = new int[i3];
        if (d2 == 0) {
            iArr[0] = -1;
            return iArr;
        }
        char e2 = e();
        for (int i4 = 0; i4 <= d2; i4++) {
            iArr[i4] = (((i2 + 3) + (i3 * e2)) - 1) + k(e2);
        }
        return iArr;
    }

    /* access modifiers changed from: package-private */
    public int i() {
        try {
            return this.f25970e.readInt();
        } catch (Exception e2) {
            throw new ExceptionConverter(e2);
        }
    }

    public String[] j() {
        String[] strArr = new String[this.o.length];
        int i2 = 0;
        while (true) {
            Font[] fontArr = this.o;
            if (i2 >= fontArr.length) {
                return strArr;
            }
            strArr[i2] = fontArr[i2].f25983a;
            i2++;
        }
    }

    /* access modifiers changed from: package-private */
    public int k(int i2) {
        int i3 = 0;
        for (int i4 = 0; i4 < i2; i4++) {
            i3 = (i3 * 256) + e();
        }
        return i3;
    }

    /* access modifiers changed from: package-private */
    public int l() {
        try {
            return (int) this.f25970e.d();
        } catch (Exception e2) {
            throw new ExceptionConverter(e2);
        }
    }

    /* access modifiers changed from: package-private */
    public short m() {
        try {
            return this.f25970e.readShort();
        } catch (Exception e2) {
            throw new ExceptionConverter(e2);
        }
    }

    public String n(char c2) {
        String[] strArr = q;
        if (c2 < strArr.length) {
            return strArr[c2];
        }
        if (c2 >= (strArr.length + this.f25978m.length) - 1) {
            return null;
        }
        int length = c2 - strArr.length;
        int l2 = l();
        p(this.f25978m[length]);
        StringBuffer stringBuffer = new StringBuffer();
        for (int i2 = this.f25978m[length]; i2 < this.f25978m[length + 1]; i2++) {
            stringBuffer.append(e());
        }
        p(l2);
        return stringBuffer.toString();
    }

    public boolean o(String str) {
        int i2 = 0;
        while (true) {
            Font[] fontArr = this.o;
            if (i2 >= fontArr.length) {
                return false;
            }
            if (str.equals(fontArr[i2].f25983a)) {
                return this.o[i2].f25985c;
            }
            i2++;
        }
    }

    /* access modifiers changed from: package-private */
    public void p(int i2) {
        try {
            this.f25970e.r((long) i2);
        } catch (Exception e2) {
            throw new ExceptionConverter(e2);
        }
    }
}
