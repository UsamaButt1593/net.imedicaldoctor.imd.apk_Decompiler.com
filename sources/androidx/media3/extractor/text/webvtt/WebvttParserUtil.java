package androidx.media3.extractor.text.webvtt;

import androidx.annotation.Nullable;
import androidx.media3.common.ParserException;
import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;
import com.itextpdf.tool.xml.css.CSS;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@UnstableApi
public final class WebvttParserUtil {

    /* renamed from: a  reason: collision with root package name */
    private static final Pattern f14164a = Pattern.compile("^NOTE([ \t].*)?$");

    /* renamed from: b  reason: collision with root package name */
    private static final String f14165b = "WEBVTT";

    private WebvttParserUtil() {
    }

    @Nullable
    public static Matcher a(ParsableByteArray parsableByteArray) {
        String u;
        while (true) {
            String u2 = parsableByteArray.u();
            if (u2 == null) {
                return null;
            }
            if (f14164a.matcher(u2).matches()) {
                do {
                    u = parsableByteArray.u();
                    if (u == null) {
                        break;
                    }
                } while (u.isEmpty());
            } else {
                Matcher matcher = WebvttCueParser.f14127f.matcher(u2);
                if (matcher.matches()) {
                    return matcher;
                }
            }
        }
    }

    public static boolean b(ParsableByteArray parsableByteArray) {
        String u = parsableByteArray.u();
        return u != null && u.startsWith(f14165b);
    }

    public static float c(String str) throws NumberFormatException {
        if (str.endsWith(CSS.Value.n0)) {
            return Float.parseFloat(str.substring(0, str.length() - 1)) / 100.0f;
        }
        throw new NumberFormatException("Percentages must end with %");
    }

    public static long d(String str) throws NumberFormatException {
        String[] q2 = Util.q2(str, "\\.");
        long j2 = 0;
        for (String parseLong : Util.p2(q2[0], ":")) {
            j2 = (j2 * 60) + Long.parseLong(parseLong);
        }
        long j3 = j2 * 1000;
        if (q2.length == 2) {
            j3 += Long.parseLong(q2[1]);
        }
        return j3 * 1000;
    }

    public static void e(ParsableByteArray parsableByteArray) throws ParserException {
        int f2 = parsableByteArray.f();
        if (!b(parsableByteArray)) {
            parsableByteArray.Y(f2);
            throw ParserException.a("Expected WEBVTT. Got " + parsableByteArray.u(), (Throwable) null);
        }
    }
}
