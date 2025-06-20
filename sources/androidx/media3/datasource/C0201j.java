package androidx.media3.datasource;

import android.text.TextUtils;
import androidx.media3.common.MimeTypes;
import com.google.common.base.Ascii;
import com.google.common.base.Predicate;
import com.itextpdf.tool.xml.html.HTML;

/* renamed from: androidx.media3.datasource.j  reason: case insensitive filesystem */
public final /* synthetic */ class C0201j {
    static {
        Predicate<String> predicate = HttpDataSource.f9841a;
    }

    public static /* synthetic */ boolean a(String str) {
        if (str == null) {
            return false;
        }
        String g2 = Ascii.g(str);
        if (TextUtils.isEmpty(g2)) {
            return false;
        }
        if ((!g2.contains("text") || g2.contains(MimeTypes.m0)) && !g2.contains(HTML.Tag.y) && !g2.contains(HTML.Tag.f27613a)) {
            return true;
        }
        return false;
    }
}
