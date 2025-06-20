package com.itextpdf.text.html;

import androidx.media3.extractor.ts.PsExtractor;
import androidx.media3.extractor.ts.TsExtractor;
import androidx.recyclerview.widget.ItemTouchHelper;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Jpeg;
import com.itextpdf.text.error_messages.MessageLocalization;
import com.itextpdf.tool.xml.css.CSS;
import java.util.HashMap;
import java.util.StringTokenizer;
import kotlinx.coroutines.scheduling.WorkQueueKt;
import net.imedicaldoctor.imd.BuildConfig;
import org.apache.commons.httpclient.HttpStatus;

@Deprecated
public class WebColors extends HashMap<String, int[]> {
    public static final WebColors X;
    private static final long s = 3542523100813372896L;

    static {
        WebColors webColors = new WebColors();
        X = webColors;
        webColors.put("aliceblue", new int[]{PsExtractor.A, 248, 255, 255});
        webColors.put("antiquewhite", new int[]{ItemTouchHelper.Callback.f15380c, 235, 215, 255});
        webColors.put("aqua", new int[]{0, 255, 255, 255});
        webColors.put("aquamarine", new int[]{WorkQueueKt.f29430c, 255, 212, 255});
        webColors.put("azure", new int[]{PsExtractor.A, 255, 255, 255});
        webColors.put("beige", new int[]{245, 245, 220, 255});
        webColors.put("bisque", new int[]{255, 228, 196, 255});
        webColors.put("black", new int[]{0, 0, 0, 255});
        webColors.put("blanchedalmond", new int[]{255, 235, HttpStatus.SC_RESET_CONTENT, 255});
        webColors.put("blue", new int[]{0, 0, 255, 255});
        webColors.put("blueviolet", new int[]{TsExtractor.K, 43, Jpeg.V4, 255});
        webColors.put("brown", new int[]{165, 42, 42, 255});
        webColors.put("burlywood", new int[]{222, 184, TsExtractor.M, 255});
        webColors.put("cadetblue", new int[]{95, 158, 160, 255});
        webColors.put("chartreuse", new int[]{WorkQueueKt.f29430c, 255, 0, 255});
        webColors.put("chocolate", new int[]{210, 105, 30, 255});
        webColors.put("coral", new int[]{255, WorkQueueKt.f29430c, 80, 255});
        webColors.put("cornflowerblue", new int[]{100, 149, Jpeg.X4, 255});
        webColors.put("cornsilk", new int[]{255, 248, 220, 255});
        webColors.put("crimson", new int[]{220, 20, 60, 255});
        webColors.put("cyan", new int[]{0, 255, 255, 255});
        webColors.put("darkblue", new int[]{0, 0, TsExtractor.W, 255});
        webColors.put("darkcyan", new int[]{0, TsExtractor.W, TsExtractor.W, 255});
        webColors.put("darkgoldenrod", new int[]{184, TsExtractor.T, 11, 255});
        webColors.put("darkgray", new int[]{169, 169, 169, 255});
        webColors.put("darkgreen", new int[]{0, 100, 0, 255});
        webColors.put("darkkhaki", new int[]{PsExtractor.w, 183, 107, 255});
        webColors.put("darkmagenta", new int[]{TsExtractor.W, 0, TsExtractor.W, 255});
        webColors.put("darkolivegreen", new int[]{85, 107, 47, 255});
        webColors.put("darkorange", new int[]{255, 140, 0, 255});
        webColors.put("darkorchid", new int[]{153, 50, 204, 255});
        webColors.put("darkred", new int[]{TsExtractor.W, 0, 0, 255});
        webColors.put("darksalmon", new int[]{233, 150, 122, 255});
        webColors.put("darkseagreen", new int[]{143, TsExtractor.D, 143, 255});
        webColors.put("darkslateblue", new int[]{72, 61, TsExtractor.W, 255});
        webColors.put("darkslategray", new int[]{47, 79, 79, 255});
        webColors.put("darkturquoise", new int[]{0, HttpStatus.SC_PARTIAL_CONTENT, 209, 255});
        webColors.put("darkviolet", new int[]{148, 0, 211, 255});
        webColors.put("deeppink", new int[]{255, 20, 147, 255});
        webColors.put("deepskyblue", new int[]{0, 191, 255, 255});
        webColors.put("dimgray", new int[]{105, 105, 105, 255});
        webColors.put("dodgerblue", new int[]{30, 144, 255, 255});
        webColors.put("firebrick", new int[]{178, 34, 34, 255});
        webColors.put("floralwhite", new int[]{255, ItemTouchHelper.Callback.f15380c, PsExtractor.A, 255});
        webColors.put("forestgreen", new int[]{34, TsExtractor.W, 34, 255});
        webColors.put("fuchsia", new int[]{255, 0, 255, 255});
        webColors.put("gainsboro", new int[]{220, 220, 220, 255});
        webColors.put("ghostwhite", new int[]{248, 248, 255, 255});
        webColors.put("gold", new int[]{255, 215, 0, 255});
        webColors.put("goldenrod", new int[]{218, 165, 32, 255});
        webColors.put("gray", new int[]{128, 128, 128, 255});
        webColors.put("green", new int[]{0, 128, 0, 255});
        webColors.put("greenyellow", new int[]{173, 255, 47, 255});
        webColors.put("honeydew", new int[]{PsExtractor.A, 255, PsExtractor.A, 255});
        webColors.put("hotpink", new int[]{255, 105, BuildConfig.f29478d, 255});
        webColors.put("indianred", new int[]{HttpStatus.SC_RESET_CONTENT, 92, 92, 255});
        webColors.put("indigo", new int[]{75, 0, TsExtractor.L, 255});
        webColors.put("ivory", new int[]{255, 255, PsExtractor.A, 255});
        webColors.put("khaki", new int[]{PsExtractor.A, 230, 140, 255});
        webColors.put("lavender", new int[]{230, 230, ItemTouchHelper.Callback.f15380c, 255});
        webColors.put("lavenderblush", new int[]{255, PsExtractor.A, 245, 255});
        webColors.put("lawngreen", new int[]{124, 252, 0, 255});
        webColors.put("lemonchiffon", new int[]{255, ItemTouchHelper.Callback.f15380c, HttpStatus.SC_RESET_CONTENT, 255});
        webColors.put("lightblue", new int[]{173, 216, 230, 255});
        webColors.put("lightcoral", new int[]{PsExtractor.A, 128, 128, 255});
        webColors.put("lightcyan", new int[]{224, 255, 255, 255});
        webColors.put("lightgoldenrodyellow", new int[]{ItemTouchHelper.Callback.f15380c, ItemTouchHelper.Callback.f15380c, 210, 255});
        webColors.put("lightgreen", new int[]{144, Jpeg.W4, 144, 255});
        webColors.put("lightgrey", new int[]{211, 211, 211, 255});
        webColors.put("lightpink", new int[]{255, 182, 193, 255});
        webColors.put("lightsalmon", new int[]{255, 160, 122, 255});
        webColors.put("lightseagreen", new int[]{32, 178, 170, 255});
        webColors.put("lightskyblue", new int[]{TsExtractor.M, HttpStatus.SC_PARTIAL_CONTENT, ItemTouchHelper.Callback.f15380c, 255});
        webColors.put("lightslategray", new int[]{119, TsExtractor.V, 153, 255});
        webColors.put("lightsteelblue", new int[]{176, 196, 222, 255});
        webColors.put("lightyellow", new int[]{255, 255, 224, 255});
        webColors.put("lime", new int[]{0, 255, 0, 255});
        webColors.put("limegreen", new int[]{50, HttpStatus.SC_RESET_CONTENT, 50, 255});
        webColors.put("linen", new int[]{ItemTouchHelper.Callback.f15380c, PsExtractor.A, 230, 255});
        webColors.put("magenta", new int[]{255, 0, 255, 255});
        webColors.put("maroon", new int[]{128, 0, 0, 255});
        webColors.put("mediumaquamarine", new int[]{102, HttpStatus.SC_RESET_CONTENT, 170, 255});
        webColors.put("mediumblue", new int[]{0, 0, HttpStatus.SC_RESET_CONTENT, 255});
        webColors.put("mediumorchid", new int[]{186, 85, 211, 255});
        webColors.put("mediumpurple", new int[]{147, 112, 219, 255});
        webColors.put("mediumseagreen", new int[]{60, 179, 113, 255});
        webColors.put("mediumslateblue", new int[]{123, 104, Jpeg.W4, 255});
        webColors.put("mediumspringgreen", new int[]{0, ItemTouchHelper.Callback.f15380c, 154, 255});
        webColors.put("mediumturquoise", new int[]{72, 209, 204, 255});
        webColors.put("mediumvioletred", new int[]{199, 21, 133, 255});
        webColors.put("midnightblue", new int[]{25, 25, 112, 255});
        webColors.put("mintcream", new int[]{245, 255, ItemTouchHelper.Callback.f15380c, 255});
        webColors.put("mistyrose", new int[]{255, 228, 225, 255});
        webColors.put("moccasin", new int[]{255, 228, 181, 255});
        webColors.put("navajowhite", new int[]{255, 222, 173, 255});
        webColors.put("navy", new int[]{0, 0, 128, 255});
        webColors.put("oldlace", new int[]{253, 245, 230, 255});
        webColors.put("olive", new int[]{128, 128, 0, 255});
        webColors.put("olivedrab", new int[]{107, 142, 35, 255});
        webColors.put("orange", new int[]{255, 165, 0, 255});
        webColors.put("orangered", new int[]{255, 69, 0, 255});
        webColors.put("orchid", new int[]{218, 112, 214, 255});
        webColors.put("palegoldenrod", new int[]{Jpeg.W4, 232, 170, 255});
        webColors.put("palegreen", new int[]{152, 251, 152, 255});
        webColors.put("paleturquoise", new int[]{175, Jpeg.W4, Jpeg.W4, 255});
        webColors.put("palevioletred", new int[]{219, 112, 147, 255});
        webColors.put("papayawhip", new int[]{255, 239, 213, 255});
        webColors.put("peachpuff", new int[]{255, 218, 185, 255});
        webColors.put("peru", new int[]{HttpStatus.SC_RESET_CONTENT, 133, 63, 255});
        webColors.put("pink", new int[]{255, PsExtractor.x, 203, 255});
        webColors.put("plum", new int[]{221, 160, 221, 255});
        webColors.put("powderblue", new int[]{176, 224, 230, 255});
        webColors.put("purple", new int[]{128, 0, 128, 255});
        webColors.put("red", new int[]{255, 0, 0, 255});
        webColors.put("rosybrown", new int[]{TsExtractor.D, 143, 143, 255});
        webColors.put("royalblue", new int[]{65, 105, 225, 255});
        webColors.put("saddlebrown", new int[]{TsExtractor.W, 69, 19, 255});
        webColors.put("salmon", new int[]{ItemTouchHelper.Callback.f15380c, 128, 114, 255});
        webColors.put("sandybrown", new int[]{244, 164, 96, 255});
        webColors.put("seagreen", new int[]{46, TsExtractor.W, 87, 255});
        webColors.put("seashell", new int[]{255, 245, Jpeg.W4, 255});
        webColors.put("sienna", new int[]{160, 82, 45, 255});
        webColors.put("silver", new int[]{PsExtractor.x, PsExtractor.x, PsExtractor.x, 255});
        webColors.put("skyblue", new int[]{TsExtractor.M, HttpStatus.SC_PARTIAL_CONTENT, 235, 255});
        webColors.put("slateblue", new int[]{106, 90, HttpStatus.SC_RESET_CONTENT, 255});
        webColors.put("slategray", new int[]{112, 128, 144, 255});
        webColors.put("snow", new int[]{255, ItemTouchHelper.Callback.f15380c, ItemTouchHelper.Callback.f15380c, 255});
        webColors.put("springgreen", new int[]{0, 255, WorkQueueKt.f29430c, 255});
        webColors.put("steelblue", new int[]{70, TsExtractor.L, BuildConfig.f29478d, 255});
        webColors.put("tan", new int[]{210, BuildConfig.f29478d, 140, 255});
        webColors.put("teal", new int[]{0, 128, 128, 255});
        webColors.put("thistle", new int[]{216, 191, 216, 255});
        webColors.put("tomato", new int[]{255, 99, 71, 255});
        webColors.put("transparent", new int[]{255, 255, 255, 0});
        webColors.put("turquoise", new int[]{64, 224, 208, 255});
        webColors.put("violet", new int[]{Jpeg.W4, TsExtractor.L, Jpeg.W4, 255});
        webColors.put("wheat", new int[]{245, 222, 179, 255});
        webColors.put("white", new int[]{255, 255, 255, 255});
        webColors.put("whitesmoke", new int[]{245, 245, 245, 255});
        webColors.put("yellow", new int[]{255, 255, 0, 255});
        webColors.put("yellowgreen", new int[]{154, HttpStatus.SC_RESET_CONTENT, 50, 255});
    }

    private static int a(String str) {
        return str.endsWith(CSS.Value.n0) ? (Integer.parseInt(str.substring(0, str.length() - 1)) * 255) / 100 : Integer.parseInt(str);
    }

    public static BaseColor b(String str) {
        int[] iArr = {0, 0, 0, 255};
        String lowerCase = str.toLowerCase();
        boolean c2 = c(lowerCase);
        if (lowerCase.startsWith("#") || c2) {
            if (!c2) {
                lowerCase = lowerCase.substring(1);
            }
            if (lowerCase.length() == 3) {
                String substring = lowerCase.substring(0, 1);
                iArr[0] = Integer.parseInt(substring + substring, 16);
                String substring2 = lowerCase.substring(1, 2);
                iArr[1] = Integer.parseInt(substring2 + substring2, 16);
                String substring3 = lowerCase.substring(2);
                iArr[2] = Integer.parseInt(substring3 + substring3, 16);
                return new BaseColor(iArr[0], iArr[1], iArr[2], iArr[3]);
            } else if (lowerCase.length() == 6) {
                iArr[0] = Integer.parseInt(lowerCase.substring(0, 2), 16);
                iArr[1] = Integer.parseInt(lowerCase.substring(2, 4), 16);
                iArr[2] = Integer.parseInt(lowerCase.substring(4), 16);
                return new BaseColor(iArr[0], iArr[1], iArr[2], iArr[3]);
            } else {
                throw new IllegalArgumentException(MessageLocalization.b("unknown.color.format.must.be.rgb.or.rrggbb", new Object[0]));
            }
        } else if (lowerCase.startsWith("rgb(")) {
            StringTokenizer stringTokenizer = new StringTokenizer(lowerCase, "rgb(), \t\r\n\f");
            for (int i2 = 0; i2 < 3; i2++) {
                if (stringTokenizer.hasMoreElements()) {
                    int a2 = a(stringTokenizer.nextToken());
                    iArr[i2] = a2;
                    int max = Math.max(0, a2);
                    iArr[i2] = max;
                    iArr[i2] = Math.min(255, max);
                }
            }
            return new BaseColor(iArr[0], iArr[1], iArr[2], iArr[3]);
        } else if (lowerCase.startsWith("rgba(")) {
            StringTokenizer stringTokenizer2 = new StringTokenizer(lowerCase, "rgba(), \t\r\n\f");
            for (int i3 = 0; i3 < 3; i3++) {
                if (stringTokenizer2.hasMoreElements()) {
                    int a3 = a(stringTokenizer2.nextToken());
                    iArr[i3] = a3;
                    int max2 = Math.max(0, a3);
                    iArr[i3] = max2;
                    iArr[i3] = Math.min(255, max2);
                }
            }
            if (stringTokenizer2.hasMoreElements()) {
                iArr[3] = (int) (((double) (Float.parseFloat(stringTokenizer2.nextToken()) * 255.0f)) + 0.5d);
            }
            return new BaseColor(iArr[0], iArr[1], iArr[2], iArr[3]);
        } else {
            WebColors webColors = X;
            if (webColors.containsKey(lowerCase)) {
                int[] iArr2 = (int[]) webColors.get(lowerCase);
                return new BaseColor(iArr2[0], iArr2[1], iArr2[2], iArr2[3]);
            }
            throw new IllegalArgumentException(MessageLocalization.b("color.not.found", lowerCase));
        }
    }

    private static boolean c(String str) {
        int length = str.length();
        if (length != 3 && length != 6) {
            return false;
        }
        return str.matches("[0-9a-f]{" + length + "}");
    }
}
