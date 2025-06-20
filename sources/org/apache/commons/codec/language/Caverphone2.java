package org.apache.commons.codec.language;

import androidx.exifinterface.media.ExifInterface;
import androidx.media3.exoplayer.upstream.CmcdData;
import com.itextpdf.tool.xml.html.HTML;
import java.util.Locale;

public class Caverphone2 extends AbstractCaverphone {
    private static final String TEN_1 = "1111111111";

    public String encode(String str) {
        if (str == null || str.length() == 0) {
            return TEN_1;
        }
        String replaceAll = str.toLowerCase(Locale.ENGLISH).replaceAll("[^a-z]", "").replaceAll("e$", "").replaceAll("^cough", "cou2f").replaceAll("^rough", "rou2f").replaceAll("^tough", "tou2f").replaceAll("^enough", "enou2f").replaceAll("^trough", "trou2f").replaceAll("^gn", "2n").replaceAll("mb$", "m2").replaceAll("cq", "2q").replaceAll("ci", "si").replaceAll("ce", "se").replaceAll("cy", "sy").replaceAll("tch", "2ch").replaceAll("c", "k").replaceAll(HTML.Tag.C0, "k").replaceAll("x", "k").replaceAll("v", "f").replaceAll("dg", "2g").replaceAll("tio", "sio").replaceAll("tia", "sia").replaceAll("d", "t").replaceAll("ph", "fh").replaceAll("b", "p").replaceAll("sh", "s2").replaceAll("z", "s").replaceAll("^[aeiou]", ExifInterface.W4).replaceAll("[aeiou]", ExifInterface.Z4).replaceAll("j", "y").replaceAll("^y3", "Y3").replaceAll("^y", ExifInterface.W4).replaceAll("y", ExifInterface.Z4).replaceAll("3gh3", "3kh3").replaceAll("gh", "22").replaceAll("g", "k").replaceAll("s+", ExifInterface.R4).replaceAll("t+", ExifInterface.d5).replaceAll("p+", "P").replaceAll("k+", "K").replaceAll("f+", "F").replaceAll("m+", "M").replaceAll("n+", "N").replaceAll("w3", "W3").replaceAll("wh3", "Wh3").replaceAll("w$", ExifInterface.Z4).replaceAll("w", ExifInterface.Y4).replaceAll("^h", ExifInterface.W4).replaceAll(CmcdData.Factory.f12510n, ExifInterface.Y4).replaceAll("r3", "R3").replaceAll("r$", ExifInterface.Z4).replaceAll("r", ExifInterface.Y4).replaceAll("l3", "L3").replaceAll("l$", ExifInterface.Z4).replaceAll(CmcdData.Factory.q, ExifInterface.Y4).replaceAll(ExifInterface.Y4, "").replaceAll("3$", ExifInterface.W4).replaceAll(ExifInterface.Z4, "");
        return (replaceAll + TEN_1).substring(0, 10);
    }
}
