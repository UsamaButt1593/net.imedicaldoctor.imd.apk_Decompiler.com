package org.apache.commons.codec.language;

import com.dd.plist.ASCIIPropertyListParser;
import com.itextpdf.text.pdf.Barcode128;
import com.itextpdf.text.pdf.PdfWriter;
import java.util.Locale;
import org.apache.commons.codec.EncoderException;
import org.apache.commons.codec.StringEncoder;

public class ColognePhonetic implements StringEncoder {
    private static final char[] AEIJOUY = {'A', 'E', ASCIIPropertyListParser.x, 'J', 'O', 'U', ASCIIPropertyListParser.v};
    private static final char[] AHKLOQRUX = {'A', 'H', 'K', 'L', 'O', 'Q', ASCIIPropertyListParser.y, 'U', 'X'};
    private static final char[] AHOUKQX = {'A', 'H', 'O', 'U', 'K', 'Q', 'X'};
    private static final char[] CKQ = {'C', 'K', 'Q'};
    private static final char[] GKQ = {'G', 'K', 'Q'};
    private static final char[][] PREPROCESS_MAP = {new char[]{Barcode128.O, 'A'}, new char[]{220, 'U'}, new char[]{214, 'O'}, new char[]{223, 'S'}};
    private static final char[] SCZ = {'S', 'C', ASCIIPropertyListParser.D};
    private static final char[] SZ = {'S', ASCIIPropertyListParser.D};
    private static final char[] TDX = {ASCIIPropertyListParser.C, ASCIIPropertyListParser.t, 'X'};
    private static final char[] WFPV = {'W', 'F', 'P', 'V'};

    private abstract class CologneBuffer {
        protected final char[] data;
        protected int length = 0;

        public CologneBuffer(int i2) {
            this.data = new char[i2];
            this.length = 0;
        }

        /* access modifiers changed from: protected */
        public abstract char[] copyData(int i2, int i3);

        public int length() {
            return this.length;
        }

        public String toString() {
            return new String(copyData(0, this.length));
        }

        public CologneBuffer(char[] cArr) {
            this.data = cArr;
            this.length = cArr.length;
        }
    }

    private class CologneInputBuffer extends CologneBuffer {
        public CologneInputBuffer(char[] cArr) {
            super(cArr);
        }

        public void addLeft(char c2) {
            this.length++;
            this.data[getNextPos()] = c2;
        }

        /* access modifiers changed from: protected */
        public char[] copyData(int i2, int i3) {
            char[] cArr = new char[i3];
            char[] cArr2 = this.data;
            System.arraycopy(cArr2, (cArr2.length - this.length) + i2, cArr, 0, i3);
            return cArr;
        }

        public char getNextChar() {
            return this.data[getNextPos()];
        }

        /* access modifiers changed from: protected */
        public int getNextPos() {
            return this.data.length - this.length;
        }

        public char removeNext() {
            this.length--;
            return getNextChar();
        }
    }

    private class CologneOutputBuffer extends CologneBuffer {
        public CologneOutputBuffer(int i2) {
            super(i2);
        }

        public void addRight(char c2) {
            char[] cArr = this.data;
            int i2 = this.length;
            cArr[i2] = c2;
            this.length = i2 + 1;
        }

        /* access modifiers changed from: protected */
        public char[] copyData(int i2, int i3) {
            char[] cArr = new char[i3];
            System.arraycopy(this.data, i2, cArr, 0, i3);
            return cArr;
        }
    }

    private static boolean arrayContains(char[] cArr, char c2) {
        for (char c3 : cArr) {
            if (c3 == c2) {
                return true;
            }
        }
        return false;
    }

    private String preprocess(String str) {
        char[] charArray = str.toUpperCase(Locale.GERMAN).toCharArray();
        for (int i2 = 0; i2 < charArray.length; i2++) {
            if (charArray[i2] > 'Z') {
                char[][] cArr = PREPROCESS_MAP;
                int length = cArr.length;
                int i3 = 0;
                while (true) {
                    if (i3 >= length) {
                        break;
                    }
                    char[] cArr2 = cArr[i3];
                    if (charArray[i2] == cArr2[0]) {
                        charArray[i2] = cArr2[1];
                        break;
                    }
                    i3++;
                }
            }
        }
        return new String(charArray);
    }

    public String colognePhonetic(String str) {
        char c2;
        if (str == null) {
            return null;
        }
        String preprocess = preprocess(str);
        CologneOutputBuffer cologneOutputBuffer = new CologneOutputBuffer(preprocess.length() * 2);
        CologneInputBuffer cologneInputBuffer = new CologneInputBuffer(preprocess.toCharArray());
        int length = cologneInputBuffer.length();
        char c3 = '/';
        char c4 = '-';
        while (length > 0) {
            char removeNext = cologneInputBuffer.removeNext();
            int length2 = cologneInputBuffer.length();
            char nextChar = length2 > 0 ? cologneInputBuffer.getNextChar() : '-';
            if (arrayContains(AEIJOUY, removeNext)) {
                c2 = '0';
                if (c2 != '-' && ((c3 != c2 && (c2 != '0' || c3 == '/')) || c2 < '0' || c2 > '8')) {
                    cologneOutputBuffer.addRight(c2);
                }
                c3 = c2;
                c4 = removeNext;
            } else if (removeNext == 'H' || removeNext < 'A' || removeNext > 'Z') {
                if (c3 != '/') {
                    c2 = '-';
                    cologneOutputBuffer.addRight(c2);
                    c3 = c2;
                    c4 = removeNext;
                }
            } else if (removeNext == 'B' || (removeNext == 'P' && nextChar != 'H')) {
                c2 = '1';
                cologneOutputBuffer.addRight(c2);
                c3 = c2;
                c4 = removeNext;
            } else if ((removeNext == 'D' || removeNext == 'T') && !arrayContains(SCZ, nextChar)) {
                c2 = PdfWriter.p4;
                cologneOutputBuffer.addRight(c2);
                c3 = c2;
                c4 = removeNext;
            } else {
                if (arrayContains(WFPV, removeNext)) {
                    c2 = PdfWriter.q4;
                } else {
                    if (!arrayContains(GKQ, removeNext)) {
                        if (removeNext != 'X' || arrayContains(CKQ, c4)) {
                            if (!(removeNext == 'S' || removeNext == 'Z')) {
                                if (removeNext == 'C') {
                                    if (c3 != '/') {
                                    }
                                } else if (!arrayContains(TDX, removeNext)) {
                                    c2 = removeNext == 'R' ? PdfWriter.u4 : removeNext == 'L' ? PdfWriter.s4 : (removeNext == 'M' || removeNext == 'N') ? PdfWriter.t4 : removeNext;
                                }
                            }
                            c2 = '8';
                        } else {
                            cologneInputBuffer.addLeft('S');
                            length2++;
                        }
                    }
                    c2 = PdfWriter.r4;
                }
                cologneOutputBuffer.addRight(c2);
                c3 = c2;
                c4 = removeNext;
            }
            length = length2;
        }
        return cologneOutputBuffer.toString();
    }

    public Object encode(Object obj) throws EncoderException {
        if (obj instanceof String) {
            return encode((String) obj);
        }
        throw new EncoderException("This method's parameter was expected to be of the type " + String.class.getName() + ". But actually it was of the type " + obj.getClass().getName() + ".");
    }

    public boolean isEncodeEqual(String str, String str2) {
        return colognePhonetic(str).equals(colognePhonetic(str2));
    }

    public String encode(String str) {
        return colognePhonetic(str);
    }
}
