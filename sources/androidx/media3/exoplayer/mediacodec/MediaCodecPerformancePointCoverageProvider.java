package androidx.media3.exoplayer.mediacodec;

import android.media.MediaCodecInfo;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;
import androidx.media3.common.Format;
import androidx.media3.common.MimeTypes;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;
import androidx.media3.exoplayer.mediacodec.MediaCodecUtil;
import java.util.List;

@UnstableApi
final class MediaCodecPerformancePointCoverageProvider {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public static Boolean f11704a = null;

    /* renamed from: b  reason: collision with root package name */
    static final int f11705b = 0;

    /* renamed from: c  reason: collision with root package name */
    static final int f11706c = 1;

    /* renamed from: d  reason: collision with root package name */
    static final int f11707d = 2;

    @RequiresApi(29)
    private static final class Api29 {
        private Api29() {
        }

        @DoNotInline
        public static int a(MediaCodecInfo.VideoCapabilities videoCapabilities, int i2, int i3, double d2) {
            List a2 = videoCapabilities.getSupportedPerformancePoints();
            if (a2 == null || a2.isEmpty()) {
                return 0;
            }
            p.a();
            int b2 = b(a2, o.a(i2, i3, (int) d2));
            if (b2 == 1 && MediaCodecPerformancePointCoverageProvider.f11704a == null) {
                Boolean unused = MediaCodecPerformancePointCoverageProvider.f11704a = Boolean.valueOf(c());
                if (MediaCodecPerformancePointCoverageProvider.f11704a.booleanValue()) {
                    return 0;
                }
            }
            return b2;
        }

        private static int b(List<MediaCodecInfo.VideoCapabilities.PerformancePoint> list, MediaCodecInfo.VideoCapabilities.PerformancePoint performancePoint) {
            for (int i2 = 0; i2 < list.size(); i2++) {
                if (m.a(list.get(i2)).covers(performancePoint)) {
                    return 2;
                }
            }
            return 1;
        }

        private static boolean c() {
            List a2;
            if (Util.f9646a >= 35) {
                return false;
            }
            try {
                Format I = new Format.Builder().k0(MimeTypes.f9235j).I();
                if (I.f3 != null) {
                    List<MediaCodecInfo> w = MediaCodecUtil.w(MediaCodecSelector.f11713a, I, false, false);
                    int i2 = 0;
                    while (i2 < w.size()) {
                        if (w.get(i2).f11696d == null || w.get(i2).f11696d.getVideoCapabilities() == null || (a2 = w.get(i2).f11696d.getVideoCapabilities().getSupportedPerformancePoints()) == null || a2.isEmpty()) {
                            i2++;
                        } else {
                            p.a();
                            return b(a2, o.a(1280, 720, 60)) == 1;
                        }
                    }
                }
            } catch (MediaCodecUtil.DecoderQueryException unused) {
            }
            return true;
        }
    }

    private MediaCodecPerformancePointCoverageProvider() {
    }

    public static int c(MediaCodecInfo.VideoCapabilities videoCapabilities, int i2, int i3, double d2) {
        if (Util.f9646a < 29) {
            return 0;
        }
        Boolean bool = f11704a;
        if (bool == null || !bool.booleanValue()) {
            return Api29.a(videoCapabilities, i2, i3, d2);
        }
        return 0;
    }
}
