package com.itextpdf.text.pdf.hyphenation;

import com.dd.plist.ASCIIPropertyListParser;
import java.io.Serializable;

public class Hyphen implements Serializable {
    private static final long Z = -7666138517324763063L;
    public String X;
    public String Y;
    public String s;

    Hyphen(String str) {
        this.s = str;
        this.X = null;
        this.Y = null;
    }

    public String toString() {
        String str;
        if (this.X == null && this.Y == null && (str = this.s) != null && str.equals("-")) {
            return "-";
        }
        StringBuffer stringBuffer = new StringBuffer("{");
        stringBuffer.append(this.s);
        stringBuffer.append("}{");
        stringBuffer.append(this.Y);
        stringBuffer.append("}{");
        stringBuffer.append(this.X);
        stringBuffer.append(ASCIIPropertyListParser.f18653k);
        return stringBuffer.toString();
    }

    Hyphen(String str, String str2, String str3) {
        this.s = str;
        this.X = str2;
        this.Y = str3;
    }
}
