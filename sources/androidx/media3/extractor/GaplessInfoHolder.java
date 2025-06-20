package androidx.media3.extractor;

import androidx.media3.common.Metadata;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;
import androidx.media3.extractor.metadata.id3.CommentFrame;
import androidx.media3.extractor.metadata.id3.InternalFrame;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@UnstableApi
public final class GaplessInfoHolder {

    /* renamed from: c  reason: collision with root package name */
    private static final String f13065c = "com.apple.iTunes";

    /* renamed from: d  reason: collision with root package name */
    private static final String f13066d = "iTunSMPB";

    /* renamed from: e  reason: collision with root package name */
    private static final Pattern f13067e = Pattern.compile("^ [0-9a-fA-F]{8} ([0-9a-fA-F]{8}) ([0-9a-fA-F]{8})");

    /* renamed from: a  reason: collision with root package name */
    public int f13068a = -1;

    /* renamed from: b  reason: collision with root package name */
    public int f13069b = -1;

    private boolean b(String str) {
        Matcher matcher = f13067e.matcher(str);
        if (!matcher.find()) {
            return false;
        }
        try {
            int parseInt = Integer.parseInt((String) Util.o(matcher.group(1)), 16);
            int parseInt2 = Integer.parseInt((String) Util.o(matcher.group(2)), 16);
            if (parseInt <= 0 && parseInt2 <= 0) {
                return false;
            }
            this.f13068a = parseInt;
            this.f13069b = parseInt2;
            return true;
        } catch (NumberFormatException unused) {
            return false;
        }
    }

    public boolean a() {
        return (this.f13068a == -1 || this.f13069b == -1) ? false : true;
    }

    public boolean c(Metadata metadata) {
        for (int i2 = 0; i2 < metadata.g(); i2++) {
            Metadata.Entry d2 = metadata.d(i2);
            if (d2 instanceof CommentFrame) {
                CommentFrame commentFrame = (CommentFrame) d2;
                if (f13066d.equals(commentFrame.Y) && b(commentFrame.Z)) {
                    return true;
                }
            } else if (d2 instanceof InternalFrame) {
                InternalFrame internalFrame = (InternalFrame) d2;
                if (f13065c.equals(internalFrame.X) && f13066d.equals(internalFrame.Y) && b(internalFrame.Z)) {
                    return true;
                }
            } else {
                continue;
            }
        }
        return false;
    }
}
