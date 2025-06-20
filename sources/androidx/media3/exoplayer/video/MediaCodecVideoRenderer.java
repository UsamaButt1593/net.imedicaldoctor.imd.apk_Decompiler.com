package androidx.media3.exoplayer.video;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Point;
import android.hardware.display.DisplayManager;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Pair;
import android.view.Display;
import android.view.Surface;
import androidx.annotation.CallSuper;
import androidx.annotation.DoNotInline;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.media3.common.C;
import androidx.media3.common.Effect;
import androidx.media3.common.Format;
import androidx.media3.common.MimeTypes;
import androidx.media3.common.PlaybackException;
import androidx.media3.common.VideoSize;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Clock;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.MediaFormatUtil;
import androidx.media3.common.util.Size;
import androidx.media3.common.util.TraceUtil;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;
import androidx.media3.decoder.DecoderInputBuffer;
import androidx.media3.exoplayer.DecoderCounters;
import androidx.media3.exoplayer.DecoderReuseEvaluation;
import androidx.media3.exoplayer.ExoPlaybackException;
import androidx.media3.exoplayer.FormatHolder;
import androidx.media3.exoplayer.audio.SilenceSkippingAudioProcessor;
import androidx.media3.exoplayer.mediacodec.MediaCodecAdapter;
import androidx.media3.exoplayer.mediacodec.MediaCodecDecoderException;
import androidx.media3.exoplayer.mediacodec.MediaCodecInfo;
import androidx.media3.exoplayer.mediacodec.MediaCodecRenderer;
import androidx.media3.exoplayer.mediacodec.MediaCodecSelector;
import androidx.media3.exoplayer.mediacodec.MediaCodecUtil;
import androidx.media3.exoplayer.mediacodec.j;
import androidx.media3.exoplayer.video.CompositingVideoSinkProvider;
import androidx.media3.exoplayer.video.VideoFrameReleaseControl;
import androidx.media3.exoplayer.video.VideoRendererEventListener;
import androidx.media3.exoplayer.video.VideoSink;
import com.google.android.gms.common.Scopes;
import com.google.common.collect.ImmutableList;
import com.google.common.util.concurrent.MoreExecutors;
import com.itextpdf.text.Annotation;
import com.itextpdf.tool.xml.css.CSS;
import java.nio.ByteBuffer;
import java.util.List;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

@UnstableApi
public class MediaCodecVideoRenderer extends MediaCodecRenderer implements VideoFrameReleaseControl.FrameTimingEvaluator {
    private static final int[] A5 = {1920, 1600, 1440, 1280, 960, 854, 640, 540, 480};
    private static final float B5 = 1.5f;
    private static final long C5 = Long.MAX_VALUE;
    private static final int D5 = 2097152;
    private static final long E5 = -30000;
    private static final long F5 = -500000;
    private static boolean G5 = false;
    private static boolean H5 = false;
    private static final String v5 = "MediaCodecVideoRenderer";
    private static final String w5 = "crop-left";
    private static final String x5 = "crop-right";
    private static final String y5 = "crop-bottom";
    private static final String z5 = "crop-top";
    private final Context Q4;
    private final VideoSinkProvider R4;
    private final VideoRendererEventListener.EventDispatcher S4;
    private final int T4;
    private final boolean U4;
    private final VideoFrameReleaseControl V4;
    private final VideoFrameReleaseControl.FrameReleaseInfo W4;
    private CodecMaxValues X4;
    private boolean Y4;
    private boolean Z4;
    /* access modifiers changed from: private */
    @Nullable
    public Surface a5;
    @Nullable
    private Size b5;
    @Nullable
    private PlaceholderSurface c5;
    private boolean d5;
    private int e5;
    private long f5;
    private int g5;
    private int h5;
    private int i5;
    private long j5;
    private int k5;
    private long l5;
    private VideoSize m5;
    @Nullable
    private VideoSize n5;
    private boolean o5;
    private boolean p5;
    private boolean q5;
    private int r5;
    @Nullable
    OnFrameRenderedListenerV23 s5;
    @Nullable
    private VideoFrameMetadataListener t5;
    @Nullable
    private VideoSink u5;

    @RequiresApi(26)
    private static final class Api26 {
        private Api26() {
        }

        @DoNotInline
        public static boolean a(Context context) {
            DisplayManager displayManager = (DisplayManager) context.getSystemService("display");
            Display display = displayManager != null ? displayManager.getDisplay(0) : null;
            if (display == null || !display.isHdr()) {
                return false;
            }
            for (int i2 : display.getHdrCapabilities().getSupportedHdrTypes()) {
                if (i2 == 1) {
                    return true;
                }
            }
            return false;
        }
    }

    protected static final class CodecMaxValues {

        /* renamed from: a  reason: collision with root package name */
        public final int f12768a;

        /* renamed from: b  reason: collision with root package name */
        public final int f12769b;

        /* renamed from: c  reason: collision with root package name */
        public final int f12770c;

        public CodecMaxValues(int i2, int i3, int i4) {
            this.f12768a = i2;
            this.f12769b = i3;
            this.f12770c = i4;
        }
    }

    @RequiresApi(23)
    private final class OnFrameRenderedListenerV23 implements MediaCodecAdapter.OnFrameRenderedListener, Handler.Callback {
        private static final int Y = 0;
        private final Handler s;

        public OnFrameRenderedListenerV23(MediaCodecAdapter mediaCodecAdapter) {
            Handler I = Util.I(this);
            this.s = I;
            mediaCodecAdapter.g(this, I);
        }

        private void b(long j2) {
            MediaCodecVideoRenderer mediaCodecVideoRenderer = MediaCodecVideoRenderer.this;
            if (this == mediaCodecVideoRenderer.s5 && mediaCodecVideoRenderer.E0() != null) {
                if (j2 == Long.MAX_VALUE) {
                    MediaCodecVideoRenderer.this.x2();
                    return;
                }
                try {
                    MediaCodecVideoRenderer.this.w2(j2);
                } catch (ExoPlaybackException e2) {
                    MediaCodecVideoRenderer.this.C1(e2);
                }
            }
        }

        public void a(MediaCodecAdapter mediaCodecAdapter, long j2, long j3) {
            if (Util.f9646a < 30) {
                this.s.sendMessageAtFrontOfQueue(Message.obtain(this.s, 0, (int) (j2 >> 32), (int) j2));
                return;
            }
            b(j2);
        }

        public boolean handleMessage(Message message) {
            if (message.what != 0) {
                return false;
            }
            b(Util.D2(message.arg1, message.arg2));
            return true;
        }
    }

    public MediaCodecVideoRenderer(Context context, MediaCodecAdapter.Factory factory, MediaCodecSelector mediaCodecSelector, long j2, boolean z, @Nullable Handler handler, @Nullable VideoRendererEventListener videoRendererEventListener, int i2) {
        this(context, factory, mediaCodecSelector, j2, z, handler, videoRendererEventListener, i2, 30.0f);
    }

    private void B2(MediaCodecAdapter mediaCodecAdapter, int i2, long j2, long j3) {
        if (Util.f9646a >= 21) {
            C2(mediaCodecAdapter, i2, j2, j3);
        } else {
            A2(mediaCodecAdapter, i2, j2);
        }
    }

    @RequiresApi(29)
    private static void D2(MediaCodecAdapter mediaCodecAdapter, byte[] bArr) {
        Bundle bundle = new Bundle();
        bundle.putByteArray("hdr10-plus-info", bArr);
        mediaCodecAdapter.b(bundle);
    }

    /* JADX WARNING: Failed to insert additional move for type inference */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void E2(@androidx.annotation.Nullable java.lang.Object r6) throws androidx.media3.exoplayer.ExoPlaybackException {
        /*
            r5 = this;
            boolean r0 = r6 instanceof android.view.Surface
            r1 = 0
            if (r0 == 0) goto L_0x0008
            android.view.Surface r6 = (android.view.Surface) r6
            goto L_0x0009
        L_0x0008:
            r6 = r1
        L_0x0009:
            if (r6 != 0) goto L_0x0027
            androidx.media3.exoplayer.video.PlaceholderSurface r0 = r5.c5
            if (r0 == 0) goto L_0x0011
            r6 = r0
            goto L_0x0027
        L_0x0011:
            androidx.media3.exoplayer.mediacodec.MediaCodecInfo r0 = r5.G0()
            if (r0 == 0) goto L_0x0027
            boolean r2 = r5.L2(r0)
            if (r2 == 0) goto L_0x0027
            android.content.Context r6 = r5.Q4
            boolean r0 = r0.f11699g
            androidx.media3.exoplayer.video.PlaceholderSurface r6 = androidx.media3.exoplayer.video.PlaceholderSurface.c(r6, r0)
            r5.c5 = r6
        L_0x0027:
            android.view.Surface r0 = r5.a5
            if (r0 == r6) goto L_0x0091
            r5.a5 = r6
            androidx.media3.exoplayer.video.VideoFrameReleaseControl r0 = r5.V4
            r0.q(r6)
            r0 = 0
            r5.d5 = r0
            int r0 = r5.getState()
            androidx.media3.exoplayer.mediacodec.MediaCodecAdapter r2 = r5.E0()
            if (r2 == 0) goto L_0x005d
            androidx.media3.exoplayer.video.VideoSinkProvider r3 = r5.R4
            boolean r3 = r3.m()
            if (r3 != 0) goto L_0x005d
            int r3 = androidx.media3.common.util.Util.f9646a
            r4 = 23
            if (r3 < r4) goto L_0x0057
            if (r6 == 0) goto L_0x0057
            boolean r3 = r5.Y4
            if (r3 != 0) goto L_0x0057
            r5.F2(r2, r6)
            goto L_0x005d
        L_0x0057:
            r5.t1()
            r5.c1()
        L_0x005d:
            if (r6 == 0) goto L_0x007e
            androidx.media3.exoplayer.video.PlaceholderSurface r2 = r5.c5
            if (r6 == r2) goto L_0x007e
            r5.r2()
            r1 = 2
            if (r0 != r1) goto L_0x006e
            androidx.media3.exoplayer.video.VideoFrameReleaseControl r0 = r5.V4
            r0.e()
        L_0x006e:
            androidx.media3.exoplayer.video.VideoSinkProvider r0 = r5.R4
            boolean r0 = r0.m()
            if (r0 == 0) goto L_0x008d
            androidx.media3.exoplayer.video.VideoSinkProvider r0 = r5.R4
            androidx.media3.common.util.Size r1 = androidx.media3.common.util.Size.f9620c
            r0.h(r6, r1)
            goto L_0x008d
        L_0x007e:
            r5.n5 = r1
            androidx.media3.exoplayer.video.VideoSinkProvider r6 = r5.R4
            boolean r6 = r6.m()
            if (r6 == 0) goto L_0x008d
            androidx.media3.exoplayer.video.VideoSinkProvider r6 = r5.R4
            r6.n()
        L_0x008d:
            r5.t2()
            goto L_0x009d
        L_0x0091:
            if (r6 == 0) goto L_0x009d
            androidx.media3.exoplayer.video.PlaceholderSurface r0 = r5.c5
            if (r6 == r0) goto L_0x009d
            r5.r2()
            r5.q2()
        L_0x009d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.exoplayer.video.MediaCodecVideoRenderer.E2(java.lang.Object):void");
    }

    private boolean L2(MediaCodecInfo mediaCodecInfo) {
        return Util.f9646a >= 23 && !this.q5 && !X1(mediaCodecInfo.f11693a) && (!mediaCodecInfo.f11699g || PlaceholderSurface.b(this.Q4));
    }

    private static boolean W1() {
        return Util.f9646a >= 21;
    }

    @RequiresApi(21)
    private static void Y1(MediaFormat mediaFormat, int i2) {
        mediaFormat.setFeatureEnabled("tunneled-playback", true);
        mediaFormat.setInteger("audio-session-id", i2);
    }

    private static boolean Z1() {
        return "NVIDIA".equals(Util.f9648c);
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:410:0x073f, code lost:
        if (r11.equals("A10-70L") == false) goto L_0x0111;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:492:0x08ad, code lost:
        return true;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static boolean b2() {
        /*
            r0 = 26
            r1 = 8
            r2 = 27
            r3 = 7
            r4 = 6
            r5 = 5
            r6 = 4
            r7 = 3
            r8 = 2
            r9 = -1
            r10 = 0
            int r11 = androidx.media3.common.util.Util.f9646a
            r12 = 28
            r13 = 1
            if (r11 > r12) goto L_0x0080
            java.lang.String r14 = androidx.media3.common.util.Util.f9647b
            r14.hashCode()
            int r15 = r14.hashCode()
            switch(r15) {
                case -1339091551: goto L_0x0071;
                case -1220081023: goto L_0x0066;
                case -1220066608: goto L_0x005b;
                case -1012436106: goto L_0x0050;
                case -760312546: goto L_0x0045;
                case -64886864: goto L_0x003a;
                case 3415681: goto L_0x002f;
                case 825323514: goto L_0x0024;
                default: goto L_0x0021;
            }
        L_0x0021:
            r14 = -1
            goto L_0x007b
        L_0x0024:
            java.lang.String r15 = "machuca"
            boolean r14 = r14.equals(r15)
            if (r14 != 0) goto L_0x002d
            goto L_0x0021
        L_0x002d:
            r14 = 7
            goto L_0x007b
        L_0x002f:
            java.lang.String r15 = "once"
            boolean r14 = r14.equals(r15)
            if (r14 != 0) goto L_0x0038
            goto L_0x0021
        L_0x0038:
            r14 = 6
            goto L_0x007b
        L_0x003a:
            java.lang.String r15 = "magnolia"
            boolean r14 = r14.equals(r15)
            if (r14 != 0) goto L_0x0043
            goto L_0x0021
        L_0x0043:
            r14 = 5
            goto L_0x007b
        L_0x0045:
            java.lang.String r15 = "aquaman"
            boolean r14 = r14.equals(r15)
            if (r14 != 0) goto L_0x004e
            goto L_0x0021
        L_0x004e:
            r14 = 4
            goto L_0x007b
        L_0x0050:
            java.lang.String r15 = "oneday"
            boolean r14 = r14.equals(r15)
            if (r14 != 0) goto L_0x0059
            goto L_0x0021
        L_0x0059:
            r14 = 3
            goto L_0x007b
        L_0x005b:
            java.lang.String r15 = "dangalUHD"
            boolean r14 = r14.equals(r15)
            if (r14 != 0) goto L_0x0064
            goto L_0x0021
        L_0x0064:
            r14 = 2
            goto L_0x007b
        L_0x0066:
            java.lang.String r15 = "dangalFHD"
            boolean r14 = r14.equals(r15)
            if (r14 != 0) goto L_0x006f
            goto L_0x0021
        L_0x006f:
            r14 = 1
            goto L_0x007b
        L_0x0071:
            java.lang.String r15 = "dangal"
            boolean r14 = r14.equals(r15)
            if (r14 != 0) goto L_0x007a
            goto L_0x0021
        L_0x007a:
            r14 = 0
        L_0x007b:
            switch(r14) {
                case 0: goto L_0x007f;
                case 1: goto L_0x007f;
                case 2: goto L_0x007f;
                case 3: goto L_0x007f;
                case 4: goto L_0x007f;
                case 5: goto L_0x007f;
                case 6: goto L_0x007f;
                case 7: goto L_0x007f;
                default: goto L_0x007e;
            }
        L_0x007e:
            goto L_0x0080
        L_0x007f:
            return r13
        L_0x0080:
            if (r11 > r2) goto L_0x008d
            java.lang.String r14 = "HWEML"
            java.lang.String r15 = androidx.media3.common.util.Util.f9647b
            boolean r14 = r14.equals(r15)
            if (r14 == 0) goto L_0x008d
            return r13
        L_0x008d:
            java.lang.String r14 = androidx.media3.common.util.Util.f9649d
            r14.hashCode()
            int r15 = r14.hashCode()
            switch(r15) {
                case -349662828: goto L_0x00f6;
                case -321033677: goto L_0x00eb;
                case 2006354: goto L_0x00e0;
                case 2006367: goto L_0x00d5;
                case 2006371: goto L_0x00ca;
                case 1785421873: goto L_0x00bf;
                case 1785421876: goto L_0x00b4;
                case 1798172390: goto L_0x00a9;
                case 2119412532: goto L_0x009c;
                default: goto L_0x0099;
            }
        L_0x0099:
            r15 = -1
            goto L_0x0100
        L_0x009c:
            java.lang.String r15 = "AFTEUFF014"
            boolean r15 = r14.equals(r15)
            if (r15 != 0) goto L_0x00a5
            goto L_0x0099
        L_0x00a5:
            r15 = 8
            goto L_0x0100
        L_0x00a9:
            java.lang.String r15 = "AFTSO001"
            boolean r15 = r14.equals(r15)
            if (r15 != 0) goto L_0x00b2
            goto L_0x0099
        L_0x00b2:
            r15 = 7
            goto L_0x0100
        L_0x00b4:
            java.lang.String r15 = "AFTEU014"
            boolean r15 = r14.equals(r15)
            if (r15 != 0) goto L_0x00bd
            goto L_0x0099
        L_0x00bd:
            r15 = 6
            goto L_0x0100
        L_0x00bf:
            java.lang.String r15 = "AFTEU011"
            boolean r15 = r14.equals(r15)
            if (r15 != 0) goto L_0x00c8
            goto L_0x0099
        L_0x00c8:
            r15 = 5
            goto L_0x0100
        L_0x00ca:
            java.lang.String r15 = "AFTR"
            boolean r15 = r14.equals(r15)
            if (r15 != 0) goto L_0x00d3
            goto L_0x0099
        L_0x00d3:
            r15 = 4
            goto L_0x0100
        L_0x00d5:
            java.lang.String r15 = "AFTN"
            boolean r15 = r14.equals(r15)
            if (r15 != 0) goto L_0x00de
            goto L_0x0099
        L_0x00de:
            r15 = 3
            goto L_0x0100
        L_0x00e0:
            java.lang.String r15 = "AFTA"
            boolean r15 = r14.equals(r15)
            if (r15 != 0) goto L_0x00e9
            goto L_0x0099
        L_0x00e9:
            r15 = 2
            goto L_0x0100
        L_0x00eb:
            java.lang.String r15 = "AFTKMST12"
            boolean r15 = r14.equals(r15)
            if (r15 != 0) goto L_0x00f4
            goto L_0x0099
        L_0x00f4:
            r15 = 1
            goto L_0x0100
        L_0x00f6:
            java.lang.String r15 = "AFTJMST12"
            boolean r15 = r14.equals(r15)
            if (r15 != 0) goto L_0x00ff
            goto L_0x0099
        L_0x00ff:
            r15 = 0
        L_0x0100:
            switch(r15) {
                case 0: goto L_0x08af;
                case 1: goto L_0x08af;
                case 2: goto L_0x08af;
                case 3: goto L_0x08af;
                case 4: goto L_0x08af;
                case 5: goto L_0x08af;
                case 6: goto L_0x08af;
                case 7: goto L_0x08af;
                case 8: goto L_0x08af;
                default: goto L_0x0103;
            }
        L_0x0103:
            if (r11 > r0) goto L_0x08ae
            java.lang.String r11 = androidx.media3.common.util.Util.f9647b
            r11.hashCode()
            int r15 = r11.hashCode()
            switch(r15) {
                case -2144781245: goto L_0x0893;
                case -2144781185: goto L_0x0887;
                case -2144781160: goto L_0x087b;
                case -2097309513: goto L_0x086f;
                case -2022874474: goto L_0x0863;
                case -1978993182: goto L_0x0857;
                case -1978990237: goto L_0x084b;
                case -1936688988: goto L_0x083f;
                case -1936688066: goto L_0x0831;
                case -1936688065: goto L_0x0823;
                case -1931988508: goto L_0x0815;
                case -1885099851: goto L_0x0807;
                case -1696512866: goto L_0x07f9;
                case -1680025915: goto L_0x07eb;
                case -1615810839: goto L_0x07dd;
                case -1600724499: goto L_0x07cf;
                case -1554255044: goto L_0x07c1;
                case -1481772737: goto L_0x07b3;
                case -1481772730: goto L_0x07a5;
                case -1481772729: goto L_0x0797;
                case -1320080169: goto L_0x0789;
                case -1217592143: goto L_0x077b;
                case -1180384755: goto L_0x076d;
                case -1139198265: goto L_0x075f;
                case -1052835013: goto L_0x0751;
                case -993250464: goto L_0x0743;
                case -993250458: goto L_0x0739;
                case -965403638: goto L_0x072b;
                case -958336948: goto L_0x071d;
                case -879245230: goto L_0x070f;
                case -842500323: goto L_0x0701;
                case -821392978: goto L_0x06f3;
                case -797483286: goto L_0x06e5;
                case -794946968: goto L_0x06d7;
                case -788334647: goto L_0x06c9;
                case -782144577: goto L_0x06bb;
                case -575125681: goto L_0x06ad;
                case -521118391: goto L_0x069f;
                case -430914369: goto L_0x0691;
                case -290434366: goto L_0x0683;
                case -282781963: goto L_0x0675;
                case -277133239: goto L_0x0667;
                case -173639913: goto L_0x0659;
                case -56598463: goto L_0x064b;
                case 2126: goto L_0x063d;
                case 2564: goto L_0x062f;
                case 2715: goto L_0x0621;
                case 2719: goto L_0x0613;
                case 3091: goto L_0x0605;
                case 3483: goto L_0x05f7;
                case 73405: goto L_0x05e9;
                case 75537: goto L_0x05db;
                case 75739: goto L_0x05cd;
                case 76779: goto L_0x05bf;
                case 78669: goto L_0x05b1;
                case 79305: goto L_0x05a3;
                case 80618: goto L_0x0595;
                case 88274: goto L_0x0587;
                case 98846: goto L_0x0579;
                case 98848: goto L_0x056b;
                case 99329: goto L_0x055d;
                case 101481: goto L_0x054f;
                case 1513190: goto L_0x0541;
                case 1514184: goto L_0x0533;
                case 1514185: goto L_0x0525;
                case 2133089: goto L_0x0517;
                case 2133091: goto L_0x0509;
                case 2133120: goto L_0x04fb;
                case 2133151: goto L_0x04ed;
                case 2133182: goto L_0x04df;
                case 2133184: goto L_0x04d1;
                case 2436959: goto L_0x04c3;
                case 2463773: goto L_0x04b5;
                case 2464648: goto L_0x04a7;
                case 2689555: goto L_0x0499;
                case 3154429: goto L_0x048b;
                case 3284551: goto L_0x047d;
                case 3351335: goto L_0x046f;
                case 3386211: goto L_0x0461;
                case 41325051: goto L_0x0453;
                case 51349633: goto L_0x0445;
                case 51350594: goto L_0x0437;
                case 55178625: goto L_0x0429;
                case 61542055: goto L_0x041b;
                case 65355429: goto L_0x040d;
                case 66214468: goto L_0x03ff;
                case 66214470: goto L_0x03f1;
                case 66214473: goto L_0x03e3;
                case 66215429: goto L_0x03d5;
                case 66215431: goto L_0x03c7;
                case 66215433: goto L_0x03b9;
                case 66216390: goto L_0x03ab;
                case 76402249: goto L_0x039d;
                case 76404105: goto L_0x038f;
                case 76404911: goto L_0x0381;
                case 80963634: goto L_0x0373;
                case 82882791: goto L_0x0365;
                case 98715550: goto L_0x0357;
                case 101370885: goto L_0x0349;
                case 102844228: goto L_0x033b;
                case 165221241: goto L_0x032d;
                case 182191441: goto L_0x031f;
                case 245388979: goto L_0x0311;
                case 287431619: goto L_0x0303;
                case 307593612: goto L_0x02f5;
                case 308517133: goto L_0x02e7;
                case 316215098: goto L_0x02d9;
                case 316215116: goto L_0x02cb;
                case 316246811: goto L_0x02bd;
                case 316246818: goto L_0x02af;
                case 407160593: goto L_0x02a1;
                case 507412548: goto L_0x0293;
                case 793982701: goto L_0x0285;
                case 794038622: goto L_0x0277;
                case 794040393: goto L_0x0269;
                case 835649806: goto L_0x025b;
                case 917340916: goto L_0x024d;
                case 958008161: goto L_0x023f;
                case 1060579533: goto L_0x0231;
                case 1150207623: goto L_0x0223;
                case 1176899427: goto L_0x0215;
                case 1280332038: goto L_0x0207;
                case 1306947716: goto L_0x01f9;
                case 1349174697: goto L_0x01eb;
                case 1522194893: goto L_0x01dd;
                case 1691543273: goto L_0x01cf;
                case 1691544261: goto L_0x01c1;
                case 1709443163: goto L_0x01b3;
                case 1865889110: goto L_0x01a5;
                case 1906253259: goto L_0x0197;
                case 1977196784: goto L_0x0189;
                case 2006372676: goto L_0x017c;
                case 2019281702: goto L_0x016f;
                case 2029784656: goto L_0x0162;
                case 2030379515: goto L_0x0155;
                case 2033393791: goto L_0x0148;
                case 2047190025: goto L_0x013b;
                case 2047252157: goto L_0x012e;
                case 2048319463: goto L_0x0121;
                case 2048855701: goto L_0x0114;
                default: goto L_0x0111;
            }
        L_0x0111:
            r0 = -1
            goto L_0x089e
        L_0x0114:
            java.lang.String r0 = "HWWAS-H"
            boolean r0 = r11.equals(r0)
            if (r0 != 0) goto L_0x011d
            goto L_0x0111
        L_0x011d:
            r0 = 139(0x8b, float:1.95E-43)
            goto L_0x089e
        L_0x0121:
            java.lang.String r0 = "HWVNS-H"
            boolean r0 = r11.equals(r0)
            if (r0 != 0) goto L_0x012a
            goto L_0x0111
        L_0x012a:
            r0 = 138(0x8a, float:1.93E-43)
            goto L_0x089e
        L_0x012e:
            java.lang.String r0 = "ELUGA_Prim"
            boolean r0 = r11.equals(r0)
            if (r0 != 0) goto L_0x0137
            goto L_0x0111
        L_0x0137:
            r0 = 137(0x89, float:1.92E-43)
            goto L_0x089e
        L_0x013b:
            java.lang.String r0 = "ELUGA_Note"
            boolean r0 = r11.equals(r0)
            if (r0 != 0) goto L_0x0144
            goto L_0x0111
        L_0x0144:
            r0 = 136(0x88, float:1.9E-43)
            goto L_0x089e
        L_0x0148:
            java.lang.String r0 = "ASUS_X00AD_2"
            boolean r0 = r11.equals(r0)
            if (r0 != 0) goto L_0x0151
            goto L_0x0111
        L_0x0151:
            r0 = 135(0x87, float:1.89E-43)
            goto L_0x089e
        L_0x0155:
            java.lang.String r0 = "HWCAM-H"
            boolean r0 = r11.equals(r0)
            if (r0 != 0) goto L_0x015e
            goto L_0x0111
        L_0x015e:
            r0 = 134(0x86, float:1.88E-43)
            goto L_0x089e
        L_0x0162:
            java.lang.String r0 = "HWBLN-H"
            boolean r0 = r11.equals(r0)
            if (r0 != 0) goto L_0x016b
            goto L_0x0111
        L_0x016b:
            r0 = 133(0x85, float:1.86E-43)
            goto L_0x089e
        L_0x016f:
            java.lang.String r0 = "DM-01K"
            boolean r0 = r11.equals(r0)
            if (r0 != 0) goto L_0x0178
            goto L_0x0111
        L_0x0178:
            r0 = 132(0x84, float:1.85E-43)
            goto L_0x089e
        L_0x017c:
            java.lang.String r0 = "BRAVIA_ATV3_4K"
            boolean r0 = r11.equals(r0)
            if (r0 != 0) goto L_0x0185
            goto L_0x0111
        L_0x0185:
            r0 = 131(0x83, float:1.84E-43)
            goto L_0x089e
        L_0x0189:
            java.lang.String r0 = "Infinix-X572"
            boolean r0 = r11.equals(r0)
            if (r0 != 0) goto L_0x0193
            goto L_0x0111
        L_0x0193:
            r0 = 130(0x82, float:1.82E-43)
            goto L_0x089e
        L_0x0197:
            java.lang.String r0 = "PB2-670M"
            boolean r0 = r11.equals(r0)
            if (r0 != 0) goto L_0x01a1
            goto L_0x0111
        L_0x01a1:
            r0 = 129(0x81, float:1.81E-43)
            goto L_0x089e
        L_0x01a5:
            java.lang.String r0 = "santoni"
            boolean r0 = r11.equals(r0)
            if (r0 != 0) goto L_0x01af
            goto L_0x0111
        L_0x01af:
            r0 = 128(0x80, float:1.794E-43)
            goto L_0x089e
        L_0x01b3:
            java.lang.String r0 = "iball8735_9806"
            boolean r0 = r11.equals(r0)
            if (r0 != 0) goto L_0x01bd
            goto L_0x0111
        L_0x01bd:
            r0 = 127(0x7f, float:1.78E-43)
            goto L_0x089e
        L_0x01c1:
            java.lang.String r0 = "CPH1715"
            boolean r0 = r11.equals(r0)
            if (r0 != 0) goto L_0x01cb
            goto L_0x0111
        L_0x01cb:
            r0 = 126(0x7e, float:1.77E-43)
            goto L_0x089e
        L_0x01cf:
            java.lang.String r0 = "CPH1609"
            boolean r0 = r11.equals(r0)
            if (r0 != 0) goto L_0x01d9
            goto L_0x0111
        L_0x01d9:
            r0 = 125(0x7d, float:1.75E-43)
            goto L_0x089e
        L_0x01dd:
            java.lang.String r0 = "woods_f"
            boolean r0 = r11.equals(r0)
            if (r0 != 0) goto L_0x01e7
            goto L_0x0111
        L_0x01e7:
            r0 = 124(0x7c, float:1.74E-43)
            goto L_0x089e
        L_0x01eb:
            java.lang.String r0 = "htc_e56ml_dtul"
            boolean r0 = r11.equals(r0)
            if (r0 != 0) goto L_0x01f5
            goto L_0x0111
        L_0x01f5:
            r0 = 123(0x7b, float:1.72E-43)
            goto L_0x089e
        L_0x01f9:
            java.lang.String r0 = "EverStar_S"
            boolean r0 = r11.equals(r0)
            if (r0 != 0) goto L_0x0203
            goto L_0x0111
        L_0x0203:
            r0 = 122(0x7a, float:1.71E-43)
            goto L_0x089e
        L_0x0207:
            java.lang.String r0 = "hwALE-H"
            boolean r0 = r11.equals(r0)
            if (r0 != 0) goto L_0x0211
            goto L_0x0111
        L_0x0211:
            r0 = 121(0x79, float:1.7E-43)
            goto L_0x089e
        L_0x0215:
            java.lang.String r0 = "itel_S41"
            boolean r0 = r11.equals(r0)
            if (r0 != 0) goto L_0x021f
            goto L_0x0111
        L_0x021f:
            r0 = 120(0x78, float:1.68E-43)
            goto L_0x089e
        L_0x0223:
            java.lang.String r0 = "LS-5017"
            boolean r0 = r11.equals(r0)
            if (r0 != 0) goto L_0x022d
            goto L_0x0111
        L_0x022d:
            r0 = 119(0x77, float:1.67E-43)
            goto L_0x089e
        L_0x0231:
            java.lang.String r0 = "panell_d"
            boolean r0 = r11.equals(r0)
            if (r0 != 0) goto L_0x023b
            goto L_0x0111
        L_0x023b:
            r0 = 118(0x76, float:1.65E-43)
            goto L_0x089e
        L_0x023f:
            java.lang.String r0 = "j2xlteins"
            boolean r0 = r11.equals(r0)
            if (r0 != 0) goto L_0x0249
            goto L_0x0111
        L_0x0249:
            r0 = 117(0x75, float:1.64E-43)
            goto L_0x089e
        L_0x024d:
            java.lang.String r0 = "A7000plus"
            boolean r0 = r11.equals(r0)
            if (r0 != 0) goto L_0x0257
            goto L_0x0111
        L_0x0257:
            r0 = 116(0x74, float:1.63E-43)
            goto L_0x089e
        L_0x025b:
            java.lang.String r0 = "manning"
            boolean r0 = r11.equals(r0)
            if (r0 != 0) goto L_0x0265
            goto L_0x0111
        L_0x0265:
            r0 = 115(0x73, float:1.61E-43)
            goto L_0x089e
        L_0x0269:
            java.lang.String r0 = "GIONEE_WBL7519"
            boolean r0 = r11.equals(r0)
            if (r0 != 0) goto L_0x0273
            goto L_0x0111
        L_0x0273:
            r0 = 114(0x72, float:1.6E-43)
            goto L_0x089e
        L_0x0277:
            java.lang.String r0 = "GIONEE_WBL7365"
            boolean r0 = r11.equals(r0)
            if (r0 != 0) goto L_0x0281
            goto L_0x0111
        L_0x0281:
            r0 = 113(0x71, float:1.58E-43)
            goto L_0x089e
        L_0x0285:
            java.lang.String r0 = "GIONEE_WBL5708"
            boolean r0 = r11.equals(r0)
            if (r0 != 0) goto L_0x028f
            goto L_0x0111
        L_0x028f:
            r0 = 112(0x70, float:1.57E-43)
            goto L_0x089e
        L_0x0293:
            java.lang.String r0 = "QM16XE_U"
            boolean r0 = r11.equals(r0)
            if (r0 != 0) goto L_0x029d
            goto L_0x0111
        L_0x029d:
            r0 = 111(0x6f, float:1.56E-43)
            goto L_0x089e
        L_0x02a1:
            java.lang.String r0 = "Pixi5-10_4G"
            boolean r0 = r11.equals(r0)
            if (r0 != 0) goto L_0x02ab
            goto L_0x0111
        L_0x02ab:
            r0 = 110(0x6e, float:1.54E-43)
            goto L_0x089e
        L_0x02af:
            java.lang.String r0 = "TB3-850M"
            boolean r0 = r11.equals(r0)
            if (r0 != 0) goto L_0x02b9
            goto L_0x0111
        L_0x02b9:
            r0 = 109(0x6d, float:1.53E-43)
            goto L_0x089e
        L_0x02bd:
            java.lang.String r0 = "TB3-850F"
            boolean r0 = r11.equals(r0)
            if (r0 != 0) goto L_0x02c7
            goto L_0x0111
        L_0x02c7:
            r0 = 108(0x6c, float:1.51E-43)
            goto L_0x089e
        L_0x02cb:
            java.lang.String r0 = "TB3-730X"
            boolean r0 = r11.equals(r0)
            if (r0 != 0) goto L_0x02d5
            goto L_0x0111
        L_0x02d5:
            r0 = 107(0x6b, float:1.5E-43)
            goto L_0x089e
        L_0x02d9:
            java.lang.String r0 = "TB3-730F"
            boolean r0 = r11.equals(r0)
            if (r0 != 0) goto L_0x02e3
            goto L_0x0111
        L_0x02e3:
            r0 = 106(0x6a, float:1.49E-43)
            goto L_0x089e
        L_0x02e7:
            java.lang.String r0 = "A7020a48"
            boolean r0 = r11.equals(r0)
            if (r0 != 0) goto L_0x02f1
            goto L_0x0111
        L_0x02f1:
            r0 = 105(0x69, float:1.47E-43)
            goto L_0x089e
        L_0x02f5:
            java.lang.String r0 = "A7010a48"
            boolean r0 = r11.equals(r0)
            if (r0 != 0) goto L_0x02ff
            goto L_0x0111
        L_0x02ff:
            r0 = 104(0x68, float:1.46E-43)
            goto L_0x089e
        L_0x0303:
            java.lang.String r0 = "griffin"
            boolean r0 = r11.equals(r0)
            if (r0 != 0) goto L_0x030d
            goto L_0x0111
        L_0x030d:
            r0 = 103(0x67, float:1.44E-43)
            goto L_0x089e
        L_0x0311:
            java.lang.String r0 = "marino_f"
            boolean r0 = r11.equals(r0)
            if (r0 != 0) goto L_0x031b
            goto L_0x0111
        L_0x031b:
            r0 = 102(0x66, float:1.43E-43)
            goto L_0x089e
        L_0x031f:
            java.lang.String r0 = "CPY83_I00"
            boolean r0 = r11.equals(r0)
            if (r0 != 0) goto L_0x0329
            goto L_0x0111
        L_0x0329:
            r0 = 101(0x65, float:1.42E-43)
            goto L_0x089e
        L_0x032d:
            java.lang.String r0 = "A2016a40"
            boolean r0 = r11.equals(r0)
            if (r0 != 0) goto L_0x0337
            goto L_0x0111
        L_0x0337:
            r0 = 100
            goto L_0x089e
        L_0x033b:
            java.lang.String r0 = "le_x6"
            boolean r0 = r11.equals(r0)
            if (r0 != 0) goto L_0x0345
            goto L_0x0111
        L_0x0345:
            r0 = 99
            goto L_0x089e
        L_0x0349:
            java.lang.String r0 = "l5460"
            boolean r0 = r11.equals(r0)
            if (r0 != 0) goto L_0x0353
            goto L_0x0111
        L_0x0353:
            r0 = 98
            goto L_0x089e
        L_0x0357:
            java.lang.String r0 = "i9031"
            boolean r0 = r11.equals(r0)
            if (r0 != 0) goto L_0x0361
            goto L_0x0111
        L_0x0361:
            r0 = 97
            goto L_0x089e
        L_0x0365:
            java.lang.String r0 = "X3_HK"
            boolean r0 = r11.equals(r0)
            if (r0 != 0) goto L_0x036f
            goto L_0x0111
        L_0x036f:
            r0 = 96
            goto L_0x089e
        L_0x0373:
            java.lang.String r0 = "V23GB"
            boolean r0 = r11.equals(r0)
            if (r0 != 0) goto L_0x037d
            goto L_0x0111
        L_0x037d:
            r0 = 95
            goto L_0x089e
        L_0x0381:
            java.lang.String r0 = "Q4310"
            boolean r0 = r11.equals(r0)
            if (r0 != 0) goto L_0x038b
            goto L_0x0111
        L_0x038b:
            r0 = 94
            goto L_0x089e
        L_0x038f:
            java.lang.String r0 = "Q4260"
            boolean r0 = r11.equals(r0)
            if (r0 != 0) goto L_0x0399
            goto L_0x0111
        L_0x0399:
            r0 = 93
            goto L_0x089e
        L_0x039d:
            java.lang.String r0 = "PRO7S"
            boolean r0 = r11.equals(r0)
            if (r0 != 0) goto L_0x03a7
            goto L_0x0111
        L_0x03a7:
            r0 = 92
            goto L_0x089e
        L_0x03ab:
            java.lang.String r0 = "F3311"
            boolean r0 = r11.equals(r0)
            if (r0 != 0) goto L_0x03b5
            goto L_0x0111
        L_0x03b5:
            r0 = 91
            goto L_0x089e
        L_0x03b9:
            java.lang.String r0 = "F3215"
            boolean r0 = r11.equals(r0)
            if (r0 != 0) goto L_0x03c3
            goto L_0x0111
        L_0x03c3:
            r0 = 90
            goto L_0x089e
        L_0x03c7:
            java.lang.String r0 = "F3213"
            boolean r0 = r11.equals(r0)
            if (r0 != 0) goto L_0x03d1
            goto L_0x0111
        L_0x03d1:
            r0 = 89
            goto L_0x089e
        L_0x03d5:
            java.lang.String r0 = "F3211"
            boolean r0 = r11.equals(r0)
            if (r0 != 0) goto L_0x03df
            goto L_0x0111
        L_0x03df:
            r0 = 88
            goto L_0x089e
        L_0x03e3:
            java.lang.String r0 = "F3116"
            boolean r0 = r11.equals(r0)
            if (r0 != 0) goto L_0x03ed
            goto L_0x0111
        L_0x03ed:
            r0 = 87
            goto L_0x089e
        L_0x03f1:
            java.lang.String r0 = "F3113"
            boolean r0 = r11.equals(r0)
            if (r0 != 0) goto L_0x03fb
            goto L_0x0111
        L_0x03fb:
            r0 = 86
            goto L_0x089e
        L_0x03ff:
            java.lang.String r0 = "F3111"
            boolean r0 = r11.equals(r0)
            if (r0 != 0) goto L_0x0409
            goto L_0x0111
        L_0x0409:
            r0 = 85
            goto L_0x089e
        L_0x040d:
            java.lang.String r0 = "E5643"
            boolean r0 = r11.equals(r0)
            if (r0 != 0) goto L_0x0417
            goto L_0x0111
        L_0x0417:
            r0 = 84
            goto L_0x089e
        L_0x041b:
            java.lang.String r0 = "A1601"
            boolean r0 = r11.equals(r0)
            if (r0 != 0) goto L_0x0425
            goto L_0x0111
        L_0x0425:
            r0 = 83
            goto L_0x089e
        L_0x0429:
            java.lang.String r0 = "Aura_Note_2"
            boolean r0 = r11.equals(r0)
            if (r0 != 0) goto L_0x0433
            goto L_0x0111
        L_0x0433:
            r0 = 82
            goto L_0x089e
        L_0x0437:
            java.lang.String r0 = "602LV"
            boolean r0 = r11.equals(r0)
            if (r0 != 0) goto L_0x0441
            goto L_0x0111
        L_0x0441:
            r0 = 81
            goto L_0x089e
        L_0x0445:
            java.lang.String r0 = "601LV"
            boolean r0 = r11.equals(r0)
            if (r0 != 0) goto L_0x044f
            goto L_0x0111
        L_0x044f:
            r0 = 80
            goto L_0x089e
        L_0x0453:
            java.lang.String r0 = "MEIZU_M5"
            boolean r0 = r11.equals(r0)
            if (r0 != 0) goto L_0x045d
            goto L_0x0111
        L_0x045d:
            r0 = 79
            goto L_0x089e
        L_0x0461:
            java.lang.String r0 = "p212"
            boolean r0 = r11.equals(r0)
            if (r0 != 0) goto L_0x046b
            goto L_0x0111
        L_0x046b:
            r0 = 78
            goto L_0x089e
        L_0x046f:
            java.lang.String r0 = "mido"
            boolean r0 = r11.equals(r0)
            if (r0 != 0) goto L_0x0479
            goto L_0x0111
        L_0x0479:
            r0 = 77
            goto L_0x089e
        L_0x047d:
            java.lang.String r0 = "kate"
            boolean r0 = r11.equals(r0)
            if (r0 != 0) goto L_0x0487
            goto L_0x0111
        L_0x0487:
            r0 = 76
            goto L_0x089e
        L_0x048b:
            java.lang.String r0 = "fugu"
            boolean r0 = r11.equals(r0)
            if (r0 != 0) goto L_0x0495
            goto L_0x0111
        L_0x0495:
            r0 = 75
            goto L_0x089e
        L_0x0499:
            java.lang.String r0 = "XE2X"
            boolean r0 = r11.equals(r0)
            if (r0 != 0) goto L_0x04a3
            goto L_0x0111
        L_0x04a3:
            r0 = 74
            goto L_0x089e
        L_0x04a7:
            java.lang.String r0 = "Q427"
            boolean r0 = r11.equals(r0)
            if (r0 != 0) goto L_0x04b1
            goto L_0x0111
        L_0x04b1:
            r0 = 73
            goto L_0x089e
        L_0x04b5:
            java.lang.String r0 = "Q350"
            boolean r0 = r11.equals(r0)
            if (r0 != 0) goto L_0x04bf
            goto L_0x0111
        L_0x04bf:
            r0 = 72
            goto L_0x089e
        L_0x04c3:
            java.lang.String r0 = "P681"
            boolean r0 = r11.equals(r0)
            if (r0 != 0) goto L_0x04cd
            goto L_0x0111
        L_0x04cd:
            r0 = 71
            goto L_0x089e
        L_0x04d1:
            java.lang.String r0 = "F04J"
            boolean r0 = r11.equals(r0)
            if (r0 != 0) goto L_0x04db
            goto L_0x0111
        L_0x04db:
            r0 = 70
            goto L_0x089e
        L_0x04df:
            java.lang.String r0 = "F04H"
            boolean r0 = r11.equals(r0)
            if (r0 != 0) goto L_0x04e9
            goto L_0x0111
        L_0x04e9:
            r0 = 69
            goto L_0x089e
        L_0x04ed:
            java.lang.String r0 = "F03H"
            boolean r0 = r11.equals(r0)
            if (r0 != 0) goto L_0x04f7
            goto L_0x0111
        L_0x04f7:
            r0 = 68
            goto L_0x089e
        L_0x04fb:
            java.lang.String r0 = "F02H"
            boolean r0 = r11.equals(r0)
            if (r0 != 0) goto L_0x0505
            goto L_0x0111
        L_0x0505:
            r0 = 67
            goto L_0x089e
        L_0x0509:
            java.lang.String r0 = "F01J"
            boolean r0 = r11.equals(r0)
            if (r0 != 0) goto L_0x0513
            goto L_0x0111
        L_0x0513:
            r0 = 66
            goto L_0x089e
        L_0x0517:
            java.lang.String r0 = "F01H"
            boolean r0 = r11.equals(r0)
            if (r0 != 0) goto L_0x0521
            goto L_0x0111
        L_0x0521:
            r0 = 65
            goto L_0x089e
        L_0x0525:
            java.lang.String r0 = "1714"
            boolean r0 = r11.equals(r0)
            if (r0 != 0) goto L_0x052f
            goto L_0x0111
        L_0x052f:
            r0 = 64
            goto L_0x089e
        L_0x0533:
            java.lang.String r0 = "1713"
            boolean r0 = r11.equals(r0)
            if (r0 != 0) goto L_0x053d
            goto L_0x0111
        L_0x053d:
            r0 = 63
            goto L_0x089e
        L_0x0541:
            java.lang.String r0 = "1601"
            boolean r0 = r11.equals(r0)
            if (r0 != 0) goto L_0x054b
            goto L_0x0111
        L_0x054b:
            r0 = 62
            goto L_0x089e
        L_0x054f:
            java.lang.String r0 = "flo"
            boolean r0 = r11.equals(r0)
            if (r0 != 0) goto L_0x0559
            goto L_0x0111
        L_0x0559:
            r0 = 61
            goto L_0x089e
        L_0x055d:
            java.lang.String r0 = "deb"
            boolean r0 = r11.equals(r0)
            if (r0 != 0) goto L_0x0567
            goto L_0x0111
        L_0x0567:
            r0 = 60
            goto L_0x089e
        L_0x056b:
            java.lang.String r0 = "cv3"
            boolean r0 = r11.equals(r0)
            if (r0 != 0) goto L_0x0575
            goto L_0x0111
        L_0x0575:
            r0 = 59
            goto L_0x089e
        L_0x0579:
            java.lang.String r0 = "cv1"
            boolean r0 = r11.equals(r0)
            if (r0 != 0) goto L_0x0583
            goto L_0x0111
        L_0x0583:
            r0 = 58
            goto L_0x089e
        L_0x0587:
            java.lang.String r0 = "Z80"
            boolean r0 = r11.equals(r0)
            if (r0 != 0) goto L_0x0591
            goto L_0x0111
        L_0x0591:
            r0 = 57
            goto L_0x089e
        L_0x0595:
            java.lang.String r0 = "QX1"
            boolean r0 = r11.equals(r0)
            if (r0 != 0) goto L_0x059f
            goto L_0x0111
        L_0x059f:
            r0 = 56
            goto L_0x089e
        L_0x05a3:
            java.lang.String r0 = "PLE"
            boolean r0 = r11.equals(r0)
            if (r0 != 0) goto L_0x05ad
            goto L_0x0111
        L_0x05ad:
            r0 = 55
            goto L_0x089e
        L_0x05b1:
            java.lang.String r0 = "P85"
            boolean r0 = r11.equals(r0)
            if (r0 != 0) goto L_0x05bb
            goto L_0x0111
        L_0x05bb:
            r0 = 54
            goto L_0x089e
        L_0x05bf:
            java.lang.String r0 = "MX6"
            boolean r0 = r11.equals(r0)
            if (r0 != 0) goto L_0x05c9
            goto L_0x0111
        L_0x05c9:
            r0 = 53
            goto L_0x089e
        L_0x05cd:
            java.lang.String r0 = "M5c"
            boolean r0 = r11.equals(r0)
            if (r0 != 0) goto L_0x05d7
            goto L_0x0111
        L_0x05d7:
            r0 = 52
            goto L_0x089e
        L_0x05db:
            java.lang.String r0 = "M04"
            boolean r0 = r11.equals(r0)
            if (r0 != 0) goto L_0x05e5
            goto L_0x0111
        L_0x05e5:
            r0 = 51
            goto L_0x089e
        L_0x05e9:
            java.lang.String r0 = "JGZ"
            boolean r0 = r11.equals(r0)
            if (r0 != 0) goto L_0x05f3
            goto L_0x0111
        L_0x05f3:
            r0 = 50
            goto L_0x089e
        L_0x05f7:
            java.lang.String r0 = "mh"
            boolean r0 = r11.equals(r0)
            if (r0 != 0) goto L_0x0601
            goto L_0x0111
        L_0x0601:
            r0 = 49
            goto L_0x089e
        L_0x0605:
            java.lang.String r0 = "b5"
            boolean r0 = r11.equals(r0)
            if (r0 != 0) goto L_0x060f
            goto L_0x0111
        L_0x060f:
            r0 = 48
            goto L_0x089e
        L_0x0613:
            java.lang.String r0 = "V5"
            boolean r0 = r11.equals(r0)
            if (r0 != 0) goto L_0x061d
            goto L_0x0111
        L_0x061d:
            r0 = 47
            goto L_0x089e
        L_0x0621:
            java.lang.String r0 = "V1"
            boolean r0 = r11.equals(r0)
            if (r0 != 0) goto L_0x062b
            goto L_0x0111
        L_0x062b:
            r0 = 46
            goto L_0x089e
        L_0x062f:
            java.lang.String r0 = "Q5"
            boolean r0 = r11.equals(r0)
            if (r0 != 0) goto L_0x0639
            goto L_0x0111
        L_0x0639:
            r0 = 45
            goto L_0x089e
        L_0x063d:
            java.lang.String r0 = "C1"
            boolean r0 = r11.equals(r0)
            if (r0 != 0) goto L_0x0647
            goto L_0x0111
        L_0x0647:
            r0 = 44
            goto L_0x089e
        L_0x064b:
            java.lang.String r0 = "woods_fn"
            boolean r0 = r11.equals(r0)
            if (r0 != 0) goto L_0x0655
            goto L_0x0111
        L_0x0655:
            r0 = 43
            goto L_0x089e
        L_0x0659:
            java.lang.String r0 = "ELUGA_A3_Pro"
            boolean r0 = r11.equals(r0)
            if (r0 != 0) goto L_0x0663
            goto L_0x0111
        L_0x0663:
            r0 = 42
            goto L_0x089e
        L_0x0667:
            java.lang.String r0 = "Z12_PRO"
            boolean r0 = r11.equals(r0)
            if (r0 != 0) goto L_0x0671
            goto L_0x0111
        L_0x0671:
            r0 = 41
            goto L_0x089e
        L_0x0675:
            java.lang.String r0 = "BLACK-1X"
            boolean r0 = r11.equals(r0)
            if (r0 != 0) goto L_0x067f
            goto L_0x0111
        L_0x067f:
            r0 = 40
            goto L_0x089e
        L_0x0683:
            java.lang.String r0 = "taido_row"
            boolean r0 = r11.equals(r0)
            if (r0 != 0) goto L_0x068d
            goto L_0x0111
        L_0x068d:
            r0 = 39
            goto L_0x089e
        L_0x0691:
            java.lang.String r0 = "Pixi4-7_3G"
            boolean r0 = r11.equals(r0)
            if (r0 != 0) goto L_0x069b
            goto L_0x0111
        L_0x069b:
            r0 = 38
            goto L_0x089e
        L_0x069f:
            java.lang.String r0 = "GIONEE_GBL7360"
            boolean r0 = r11.equals(r0)
            if (r0 != 0) goto L_0x06a9
            goto L_0x0111
        L_0x06a9:
            r0 = 37
            goto L_0x089e
        L_0x06ad:
            java.lang.String r0 = "GiONEE_CBL7513"
            boolean r0 = r11.equals(r0)
            if (r0 != 0) goto L_0x06b7
            goto L_0x0111
        L_0x06b7:
            r0 = 36
            goto L_0x089e
        L_0x06bb:
            java.lang.String r0 = "OnePlus5T"
            boolean r0 = r11.equals(r0)
            if (r0 != 0) goto L_0x06c5
            goto L_0x0111
        L_0x06c5:
            r0 = 35
            goto L_0x089e
        L_0x06c9:
            java.lang.String r0 = "whyred"
            boolean r0 = r11.equals(r0)
            if (r0 != 0) goto L_0x06d3
            goto L_0x0111
        L_0x06d3:
            r0 = 34
            goto L_0x089e
        L_0x06d7:
            java.lang.String r0 = "watson"
            boolean r0 = r11.equals(r0)
            if (r0 != 0) goto L_0x06e1
            goto L_0x0111
        L_0x06e1:
            r0 = 33
            goto L_0x089e
        L_0x06e5:
            java.lang.String r0 = "SVP-DTV15"
            boolean r0 = r11.equals(r0)
            if (r0 != 0) goto L_0x06ef
            goto L_0x0111
        L_0x06ef:
            r0 = 32
            goto L_0x089e
        L_0x06f3:
            java.lang.String r0 = "A7000-a"
            boolean r0 = r11.equals(r0)
            if (r0 != 0) goto L_0x06fd
            goto L_0x0111
        L_0x06fd:
            r0 = 31
            goto L_0x089e
        L_0x0701:
            java.lang.String r0 = "nicklaus_f"
            boolean r0 = r11.equals(r0)
            if (r0 != 0) goto L_0x070b
            goto L_0x0111
        L_0x070b:
            r0 = 30
            goto L_0x089e
        L_0x070f:
            java.lang.String r0 = "tcl_eu"
            boolean r0 = r11.equals(r0)
            if (r0 != 0) goto L_0x0719
            goto L_0x0111
        L_0x0719:
            r0 = 29
            goto L_0x089e
        L_0x071d:
            java.lang.String r0 = "ELUGA_Ray_X"
            boolean r0 = r11.equals(r0)
            if (r0 != 0) goto L_0x0727
            goto L_0x0111
        L_0x0727:
            r0 = 28
            goto L_0x089e
        L_0x072b:
            java.lang.String r0 = "s905x018"
            boolean r0 = r11.equals(r0)
            if (r0 != 0) goto L_0x0735
            goto L_0x0111
        L_0x0735:
            r0 = 27
            goto L_0x089e
        L_0x0739:
            java.lang.String r1 = "A10-70L"
            boolean r1 = r11.equals(r1)
            if (r1 != 0) goto L_0x089e
            goto L_0x0111
        L_0x0743:
            java.lang.String r0 = "A10-70F"
            boolean r0 = r11.equals(r0)
            if (r0 != 0) goto L_0x074d
            goto L_0x0111
        L_0x074d:
            r0 = 25
            goto L_0x089e
        L_0x0751:
            java.lang.String r0 = "namath"
            boolean r0 = r11.equals(r0)
            if (r0 != 0) goto L_0x075b
            goto L_0x0111
        L_0x075b:
            r0 = 24
            goto L_0x089e
        L_0x075f:
            java.lang.String r0 = "Slate_Pro"
            boolean r0 = r11.equals(r0)
            if (r0 != 0) goto L_0x0769
            goto L_0x0111
        L_0x0769:
            r0 = 23
            goto L_0x089e
        L_0x076d:
            java.lang.String r0 = "iris60"
            boolean r0 = r11.equals(r0)
            if (r0 != 0) goto L_0x0777
            goto L_0x0111
        L_0x0777:
            r0 = 22
            goto L_0x089e
        L_0x077b:
            java.lang.String r0 = "BRAVIA_ATV2"
            boolean r0 = r11.equals(r0)
            if (r0 != 0) goto L_0x0785
            goto L_0x0111
        L_0x0785:
            r0 = 21
            goto L_0x089e
        L_0x0789:
            java.lang.String r0 = "GiONEE_GBL7319"
            boolean r0 = r11.equals(r0)
            if (r0 != 0) goto L_0x0793
            goto L_0x0111
        L_0x0793:
            r0 = 20
            goto L_0x089e
        L_0x0797:
            java.lang.String r0 = "panell_dt"
            boolean r0 = r11.equals(r0)
            if (r0 != 0) goto L_0x07a1
            goto L_0x0111
        L_0x07a1:
            r0 = 19
            goto L_0x089e
        L_0x07a5:
            java.lang.String r0 = "panell_ds"
            boolean r0 = r11.equals(r0)
            if (r0 != 0) goto L_0x07af
            goto L_0x0111
        L_0x07af:
            r0 = 18
            goto L_0x089e
        L_0x07b3:
            java.lang.String r0 = "panell_dl"
            boolean r0 = r11.equals(r0)
            if (r0 != 0) goto L_0x07bd
            goto L_0x0111
        L_0x07bd:
            r0 = 17
            goto L_0x089e
        L_0x07c1:
            java.lang.String r0 = "vernee_M5"
            boolean r0 = r11.equals(r0)
            if (r0 != 0) goto L_0x07cb
            goto L_0x0111
        L_0x07cb:
            r0 = 16
            goto L_0x089e
        L_0x07cf:
            java.lang.String r0 = "pacificrim"
            boolean r0 = r11.equals(r0)
            if (r0 != 0) goto L_0x07d9
            goto L_0x0111
        L_0x07d9:
            r0 = 15
            goto L_0x089e
        L_0x07dd:
            java.lang.String r0 = "Phantom6"
            boolean r0 = r11.equals(r0)
            if (r0 != 0) goto L_0x07e7
            goto L_0x0111
        L_0x07e7:
            r0 = 14
            goto L_0x089e
        L_0x07eb:
            java.lang.String r0 = "ComioS1"
            boolean r0 = r11.equals(r0)
            if (r0 != 0) goto L_0x07f5
            goto L_0x0111
        L_0x07f5:
            r0 = 13
            goto L_0x089e
        L_0x07f9:
            java.lang.String r0 = "XT1663"
            boolean r0 = r11.equals(r0)
            if (r0 != 0) goto L_0x0803
            goto L_0x0111
        L_0x0803:
            r0 = 12
            goto L_0x089e
        L_0x0807:
            java.lang.String r0 = "RAIJIN"
            boolean r0 = r11.equals(r0)
            if (r0 != 0) goto L_0x0811
            goto L_0x0111
        L_0x0811:
            r0 = 11
            goto L_0x089e
        L_0x0815:
            java.lang.String r0 = "AquaPowerM"
            boolean r0 = r11.equals(r0)
            if (r0 != 0) goto L_0x081f
            goto L_0x0111
        L_0x081f:
            r0 = 10
            goto L_0x089e
        L_0x0823:
            java.lang.String r0 = "PGN611"
            boolean r0 = r11.equals(r0)
            if (r0 != 0) goto L_0x082d
            goto L_0x0111
        L_0x082d:
            r0 = 9
            goto L_0x089e
        L_0x0831:
            java.lang.String r0 = "PGN610"
            boolean r0 = r11.equals(r0)
            if (r0 != 0) goto L_0x083b
            goto L_0x0111
        L_0x083b:
            r0 = 8
            goto L_0x089e
        L_0x083f:
            java.lang.String r0 = "PGN528"
            boolean r0 = r11.equals(r0)
            if (r0 != 0) goto L_0x0849
            goto L_0x0111
        L_0x0849:
            r0 = 7
            goto L_0x089e
        L_0x084b:
            java.lang.String r0 = "NX573J"
            boolean r0 = r11.equals(r0)
            if (r0 != 0) goto L_0x0855
            goto L_0x0111
        L_0x0855:
            r0 = 6
            goto L_0x089e
        L_0x0857:
            java.lang.String r0 = "NX541J"
            boolean r0 = r11.equals(r0)
            if (r0 != 0) goto L_0x0861
            goto L_0x0111
        L_0x0861:
            r0 = 5
            goto L_0x089e
        L_0x0863:
            java.lang.String r0 = "CP8676_I02"
            boolean r0 = r11.equals(r0)
            if (r0 != 0) goto L_0x086d
            goto L_0x0111
        L_0x086d:
            r0 = 4
            goto L_0x089e
        L_0x086f:
            java.lang.String r0 = "K50a40"
            boolean r0 = r11.equals(r0)
            if (r0 != 0) goto L_0x0879
            goto L_0x0111
        L_0x0879:
            r0 = 3
            goto L_0x089e
        L_0x087b:
            java.lang.String r0 = "GIONEE_SWW1631"
            boolean r0 = r11.equals(r0)
            if (r0 != 0) goto L_0x0885
            goto L_0x0111
        L_0x0885:
            r0 = 2
            goto L_0x089e
        L_0x0887:
            java.lang.String r0 = "GIONEE_SWW1627"
            boolean r0 = r11.equals(r0)
            if (r0 != 0) goto L_0x0891
            goto L_0x0111
        L_0x0891:
            r0 = 1
            goto L_0x089e
        L_0x0893:
            java.lang.String r0 = "GIONEE_SWW1609"
            boolean r0 = r11.equals(r0)
            if (r0 != 0) goto L_0x089d
            goto L_0x0111
        L_0x089d:
            r0 = 0
        L_0x089e:
            switch(r0) {
                case 0: goto L_0x08ad;
                case 1: goto L_0x08ad;
                case 2: goto L_0x08ad;
                case 3: goto L_0x08ad;
                case 4: goto L_0x08ad;
                case 5: goto L_0x08ad;
                case 6: goto L_0x08ad;
                case 7: goto L_0x08ad;
                case 8: goto L_0x08ad;
                case 9: goto L_0x08ad;
                case 10: goto L_0x08ad;
                case 11: goto L_0x08ad;
                case 12: goto L_0x08ad;
                case 13: goto L_0x08ad;
                case 14: goto L_0x08ad;
                case 15: goto L_0x08ad;
                case 16: goto L_0x08ad;
                case 17: goto L_0x08ad;
                case 18: goto L_0x08ad;
                case 19: goto L_0x08ad;
                case 20: goto L_0x08ad;
                case 21: goto L_0x08ad;
                case 22: goto L_0x08ad;
                case 23: goto L_0x08ad;
                case 24: goto L_0x08ad;
                case 25: goto L_0x08ad;
                case 26: goto L_0x08ad;
                case 27: goto L_0x08ad;
                case 28: goto L_0x08ad;
                case 29: goto L_0x08ad;
                case 30: goto L_0x08ad;
                case 31: goto L_0x08ad;
                case 32: goto L_0x08ad;
                case 33: goto L_0x08ad;
                case 34: goto L_0x08ad;
                case 35: goto L_0x08ad;
                case 36: goto L_0x08ad;
                case 37: goto L_0x08ad;
                case 38: goto L_0x08ad;
                case 39: goto L_0x08ad;
                case 40: goto L_0x08ad;
                case 41: goto L_0x08ad;
                case 42: goto L_0x08ad;
                case 43: goto L_0x08ad;
                case 44: goto L_0x08ad;
                case 45: goto L_0x08ad;
                case 46: goto L_0x08ad;
                case 47: goto L_0x08ad;
                case 48: goto L_0x08ad;
                case 49: goto L_0x08ad;
                case 50: goto L_0x08ad;
                case 51: goto L_0x08ad;
                case 52: goto L_0x08ad;
                case 53: goto L_0x08ad;
                case 54: goto L_0x08ad;
                case 55: goto L_0x08ad;
                case 56: goto L_0x08ad;
                case 57: goto L_0x08ad;
                case 58: goto L_0x08ad;
                case 59: goto L_0x08ad;
                case 60: goto L_0x08ad;
                case 61: goto L_0x08ad;
                case 62: goto L_0x08ad;
                case 63: goto L_0x08ad;
                case 64: goto L_0x08ad;
                case 65: goto L_0x08ad;
                case 66: goto L_0x08ad;
                case 67: goto L_0x08ad;
                case 68: goto L_0x08ad;
                case 69: goto L_0x08ad;
                case 70: goto L_0x08ad;
                case 71: goto L_0x08ad;
                case 72: goto L_0x08ad;
                case 73: goto L_0x08ad;
                case 74: goto L_0x08ad;
                case 75: goto L_0x08ad;
                case 76: goto L_0x08ad;
                case 77: goto L_0x08ad;
                case 78: goto L_0x08ad;
                case 79: goto L_0x08ad;
                case 80: goto L_0x08ad;
                case 81: goto L_0x08ad;
                case 82: goto L_0x08ad;
                case 83: goto L_0x08ad;
                case 84: goto L_0x08ad;
                case 85: goto L_0x08ad;
                case 86: goto L_0x08ad;
                case 87: goto L_0x08ad;
                case 88: goto L_0x08ad;
                case 89: goto L_0x08ad;
                case 90: goto L_0x08ad;
                case 91: goto L_0x08ad;
                case 92: goto L_0x08ad;
                case 93: goto L_0x08ad;
                case 94: goto L_0x08ad;
                case 95: goto L_0x08ad;
                case 96: goto L_0x08ad;
                case 97: goto L_0x08ad;
                case 98: goto L_0x08ad;
                case 99: goto L_0x08ad;
                case 100: goto L_0x08ad;
                case 101: goto L_0x08ad;
                case 102: goto L_0x08ad;
                case 103: goto L_0x08ad;
                case 104: goto L_0x08ad;
                case 105: goto L_0x08ad;
                case 106: goto L_0x08ad;
                case 107: goto L_0x08ad;
                case 108: goto L_0x08ad;
                case 109: goto L_0x08ad;
                case 110: goto L_0x08ad;
                case 111: goto L_0x08ad;
                case 112: goto L_0x08ad;
                case 113: goto L_0x08ad;
                case 114: goto L_0x08ad;
                case 115: goto L_0x08ad;
                case 116: goto L_0x08ad;
                case 117: goto L_0x08ad;
                case 118: goto L_0x08ad;
                case 119: goto L_0x08ad;
                case 120: goto L_0x08ad;
                case 121: goto L_0x08ad;
                case 122: goto L_0x08ad;
                case 123: goto L_0x08ad;
                case 124: goto L_0x08ad;
                case 125: goto L_0x08ad;
                case 126: goto L_0x08ad;
                case 127: goto L_0x08ad;
                case 128: goto L_0x08ad;
                case 129: goto L_0x08ad;
                case 130: goto L_0x08ad;
                case 131: goto L_0x08ad;
                case 132: goto L_0x08ad;
                case 133: goto L_0x08ad;
                case 134: goto L_0x08ad;
                case 135: goto L_0x08ad;
                case 136: goto L_0x08ad;
                case 137: goto L_0x08ad;
                case 138: goto L_0x08ad;
                case 139: goto L_0x08ad;
                default: goto L_0x08a1;
            }
        L_0x08a1:
            r14.hashCode()
            java.lang.String r0 = "JSN-L21"
            boolean r0 = r14.equals(r0)
            if (r0 != 0) goto L_0x08ad
            goto L_0x08ae
        L_0x08ad:
            return r13
        L_0x08ae:
            return r10
        L_0x08af:
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.exoplayer.video.MediaCodecVideoRenderer.b2():boolean");
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x0080, code lost:
        if (r8.equals(androidx.media3.common.MimeTypes.f9239n) == false) goto L_0x0045;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0028, code lost:
        r11 = ((java.lang.Integer) r11.first).intValue();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int c2(androidx.media3.exoplayer.mediacodec.MediaCodecInfo r10, androidx.media3.common.Format r11) {
        /*
            r0 = 4
            java.lang.String r1 = "video/hevc"
            java.lang.String r2 = "video/avc"
            r3 = 1
            r4 = 2
            int r5 = r11.k3
            int r6 = r11.l3
            r7 = -1
            if (r5 == r7) goto L_0x00e9
            if (r6 != r7) goto L_0x0012
            goto L_0x00e9
        L_0x0012:
            java.lang.String r8 = r11.f3
            java.lang.Object r8 = androidx.media3.common.util.Assertions.g(r8)
            java.lang.String r8 = (java.lang.String) r8
            java.lang.String r9 = "video/dolby-vision"
            boolean r9 = r9.equals(r8)
            if (r9 == 0) goto L_0x003b
            android.util.Pair r11 = androidx.media3.exoplayer.mediacodec.MediaCodecUtil.s(r11)
            if (r11 == 0) goto L_0x003a
            java.lang.Object r11 = r11.first
            java.lang.Integer r11 = (java.lang.Integer) r11
            int r11 = r11.intValue()
            r8 = 512(0x200, float:7.175E-43)
            if (r11 == r8) goto L_0x0038
            if (r11 == r3) goto L_0x0038
            if (r11 != r4) goto L_0x003a
        L_0x0038:
            r8 = r2
            goto L_0x003b
        L_0x003a:
            r8 = r1
        L_0x003b:
            r8.hashCode()
            int r11 = r8.hashCode()
            switch(r11) {
                case -1664118616: goto L_0x0083;
                case -1662735862: goto L_0x007a;
                case -1662541442: goto L_0x0071;
                case 1187890754: goto L_0x0066;
                case 1331836730: goto L_0x005d;
                case 1599127256: goto L_0x0052;
                case 1599127257: goto L_0x0047;
                default: goto L_0x0045;
            }
        L_0x0045:
            r3 = -1
            goto L_0x008d
        L_0x0047:
            java.lang.String r11 = "video/x-vnd.on2.vp9"
            boolean r11 = r8.equals(r11)
            if (r11 != 0) goto L_0x0050
            goto L_0x0045
        L_0x0050:
            r3 = 6
            goto L_0x008d
        L_0x0052:
            java.lang.String r11 = "video/x-vnd.on2.vp8"
            boolean r11 = r8.equals(r11)
            if (r11 != 0) goto L_0x005b
            goto L_0x0045
        L_0x005b:
            r3 = 5
            goto L_0x008d
        L_0x005d:
            boolean r11 = r8.equals(r2)
            if (r11 != 0) goto L_0x0064
            goto L_0x0045
        L_0x0064:
            r3 = 4
            goto L_0x008d
        L_0x0066:
            java.lang.String r11 = "video/mp4v-es"
            boolean r11 = r8.equals(r11)
            if (r11 != 0) goto L_0x006f
            goto L_0x0045
        L_0x006f:
            r3 = 3
            goto L_0x008d
        L_0x0071:
            boolean r11 = r8.equals(r1)
            if (r11 != 0) goto L_0x0078
            goto L_0x0045
        L_0x0078:
            r3 = 2
            goto L_0x008d
        L_0x007a:
            java.lang.String r11 = "video/av01"
            boolean r11 = r8.equals(r11)
            if (r11 != 0) goto L_0x008d
            goto L_0x0045
        L_0x0083:
            java.lang.String r11 = "video/3gpp"
            boolean r11 = r8.equals(r11)
            if (r11 != 0) goto L_0x008c
            goto L_0x0045
        L_0x008c:
            r3 = 0
        L_0x008d:
            switch(r3) {
                case 0: goto L_0x00e2;
                case 1: goto L_0x00e2;
                case 2: goto L_0x00d5;
                case 3: goto L_0x00e2;
                case 4: goto L_0x0098;
                case 5: goto L_0x00e2;
                case 6: goto L_0x0091;
                default: goto L_0x0090;
            }
        L_0x0090:
            return r7
        L_0x0091:
            int r5 = r5 * r6
            int r10 = h2(r5, r0)
            return r10
        L_0x0098:
            java.lang.String r11 = androidx.media3.common.util.Util.f9649d
            java.lang.String r0 = "BRAVIA 4K 2015"
            boolean r0 = r0.equals(r11)
            if (r0 != 0) goto L_0x00d4
            java.lang.String r0 = "Amazon"
            java.lang.String r1 = androidx.media3.common.util.Util.f9648c
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x00c1
            java.lang.String r0 = "KFSOWI"
            boolean r0 = r0.equals(r11)
            if (r0 != 0) goto L_0x00d4
            java.lang.String r0 = "AFTS"
            boolean r11 = r0.equals(r11)
            if (r11 == 0) goto L_0x00c1
            boolean r10 = r10.f11699g
            if (r10 == 0) goto L_0x00c1
            goto L_0x00d4
        L_0x00c1:
            r10 = 16
            int r11 = androidx.media3.common.util.Util.q(r5, r10)
            int r10 = androidx.media3.common.util.Util.q(r6, r10)
            int r11 = r11 * r10
            int r11 = r11 * 256
            int r10 = h2(r11, r4)
            return r10
        L_0x00d4:
            return r7
        L_0x00d5:
            int r5 = r5 * r6
            int r10 = h2(r5, r4)
            r11 = 2097152(0x200000, float:2.938736E-39)
            int r10 = java.lang.Math.max(r11, r10)
            return r10
        L_0x00e2:
            int r5 = r5 * r6
            int r10 = h2(r5, r4)
            return r10
        L_0x00e9:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.exoplayer.video.MediaCodecVideoRenderer.c2(androidx.media3.exoplayer.mediacodec.MediaCodecInfo, androidx.media3.common.Format):int");
    }

    @Nullable
    private static Point d2(MediaCodecInfo mediaCodecInfo, Format format) {
        int i2 = format.l3;
        int i3 = format.k3;
        boolean z = i2 > i3;
        int i4 = z ? i2 : i3;
        if (z) {
            i2 = i3;
        }
        float f2 = ((float) i2) / ((float) i4);
        for (int i6 : A5) {
            int i7 = (int) (((float) i6) * f2);
            if (i6 <= i4 || i7 <= i2) {
                break;
            }
            if (Util.f9646a >= 21) {
                int i8 = z ? i7 : i6;
                if (!z) {
                    i6 = i7;
                }
                Point b2 = mediaCodecInfo.b(i8, i6);
                float f3 = format.m3;
                if (b2 != null && mediaCodecInfo.y(b2.x, b2.y, (double) f3)) {
                    return b2;
                }
            } else {
                try {
                    int q = Util.q(i6, 16) * 16;
                    int q2 = Util.q(i7, 16) * 16;
                    if (q * q2 <= MediaCodecUtil.Q()) {
                        int i9 = z ? q2 : q;
                        if (!z) {
                            q = q2;
                        }
                        return new Point(i9, q);
                    }
                } catch (MediaCodecUtil.DecoderQueryException unused) {
                }
            }
        }
        return null;
    }

    private static List<MediaCodecInfo> f2(Context context, MediaCodecSelector mediaCodecSelector, Format format, boolean z, boolean z2) throws MediaCodecUtil.DecoderQueryException {
        String str = format.f3;
        if (str == null) {
            return ImmutableList.I();
        }
        if (Util.f9646a >= 26 && MimeTypes.w.equals(str) && !Api26.a(context)) {
            List<MediaCodecInfo> o = MediaCodecUtil.o(mediaCodecSelector, format, z, z2);
            if (!o.isEmpty()) {
                return o;
            }
        }
        return MediaCodecUtil.w(mediaCodecSelector, format, z, z2);
    }

    protected static int g2(MediaCodecInfo mediaCodecInfo, Format format) {
        if (format.g3 == -1) {
            return c2(mediaCodecInfo, format);
        }
        int size = format.h3.size();
        int i2 = 0;
        for (int i3 = 0; i3 < size; i3++) {
            i2 += format.h3.get(i3).length;
        }
        return format.g3 + i2;
    }

    private static int h2(int i2, int i3) {
        return (i2 * 3) / (i3 * 2);
    }

    private void l2() {
        if (this.g5 > 0) {
            long b2 = J().b();
            this.S4.n(this.g5, b2 - this.f5);
            this.g5 = 0;
            this.f5 = b2;
        }
    }

    private void m2() {
        if (this.V4.i() && this.a5 != null) {
            v2();
        }
    }

    private void n2() {
        int i2 = this.k5;
        if (i2 != 0) {
            this.S4.B(this.j5, i2);
            this.j5 = 0;
            this.k5 = 0;
        }
    }

    private void o2(VideoSize videoSize) {
        if (!videoSize.equals(VideoSize.b3) && !videoSize.equals(this.n5)) {
            this.n5 = videoSize;
            this.S4.D(videoSize);
        }
    }

    private boolean p2(MediaCodecAdapter mediaCodecAdapter, int i2, long j2, Format format) {
        long g2 = this.W4.g();
        long f2 = this.W4.f();
        if (Util.f9646a >= 21) {
            if (!K2() || g2 != this.l5) {
                u2(j2, g2, format);
                C2(mediaCodecAdapter, i2, j2, g2);
            } else {
                M2(mediaCodecAdapter, i2, j2);
            }
            O2(f2);
            this.l5 = g2;
            return true;
        } else if (f2 >= 30000) {
            return false;
        } else {
            if (f2 > 11000) {
                try {
                    Thread.sleep((f2 - 10000) / 1000);
                } catch (InterruptedException unused) {
                    Thread.currentThread().interrupt();
                    return false;
                }
            }
            u2(j2, g2, format);
            A2(mediaCodecAdapter, i2, j2);
            O2(f2);
            return true;
        }
    }

    private void q2() {
        Surface surface = this.a5;
        if (surface != null && this.d5) {
            this.S4.A(surface);
        }
    }

    private void r2() {
        VideoSize videoSize = this.n5;
        if (videoSize != null) {
            this.S4.D(videoSize);
        }
    }

    private void s2(MediaFormat mediaFormat) {
        VideoSink videoSink = this.u5;
        if (videoSink != null && !videoSink.h()) {
            mediaFormat.setInteger("allow-frame-drop", 0);
        }
    }

    private void t2() {
        int i2;
        MediaCodecAdapter E0;
        if (this.q5 && (i2 = Util.f9646a) >= 23 && (E0 = E0()) != null) {
            this.s5 = new OnFrameRenderedListenerV23(E0);
            if (i2 >= 33) {
                Bundle bundle = new Bundle();
                bundle.putInt("tunnel-peek", 1);
                E0.b(bundle);
            }
        }
    }

    private void u2(long j2, long j3, Format format) {
        VideoFrameMetadataListener videoFrameMetadataListener = this.t5;
        if (videoFrameMetadataListener != null) {
            videoFrameMetadataListener.j(j2, j3, format, K0());
        }
    }

    /* access modifiers changed from: private */
    @RequiresNonNull({"displaySurface"})
    public void v2() {
        this.S4.A(this.a5);
        this.d5 = true;
    }

    /* access modifiers changed from: private */
    public void x2() {
        B1();
    }

    @RequiresApi(17)
    private void z2() {
        Surface surface = this.a5;
        PlaceholderSurface placeholderSurface = this.c5;
        if (surface == placeholderSurface) {
            this.a5 = null;
        }
        if (placeholderSurface != null) {
            placeholderSurface.release();
            this.c5 = null;
        }
    }

    /* access modifiers changed from: protected */
    public void A2(MediaCodecAdapter mediaCodecAdapter, int i2, long j2) {
        TraceUtil.a("releaseOutputBuffer");
        mediaCodecAdapter.m(i2, true);
        TraceUtil.c();
        this.u4.f10102e++;
        this.h5 = 0;
        if (this.u5 == null) {
            o2(this.m5);
            m2();
        }
    }

    /* access modifiers changed from: protected */
    @RequiresApi(21)
    public void C2(MediaCodecAdapter mediaCodecAdapter, int i2, long j2, long j3) {
        TraceUtil.a("releaseOutputBuffer");
        mediaCodecAdapter.i(i2, j3);
        TraceUtil.c();
        this.u4.f10102e++;
        this.h5 = 0;
        if (this.u5 == null) {
            o2(this.m5);
            m2();
        }
    }

    public boolean D(long j2, long j3) {
        return J2(j2, j3);
    }

    /* access modifiers changed from: protected */
    public int F0(DecoderInputBuffer decoderInputBuffer) {
        return (Util.f9646a < 34 || !this.q5 || decoderInputBuffer.Y2 >= N()) ? 0 : 32;
    }

    /* access modifiers changed from: protected */
    @RequiresApi(23)
    public void F2(MediaCodecAdapter mediaCodecAdapter, Surface surface) {
        mediaCodecAdapter.o(surface);
    }

    /* access modifiers changed from: protected */
    public boolean G1(MediaCodecInfo mediaCodecInfo) {
        return this.a5 != null || L2(mediaCodecInfo);
    }

    public void G2(List<Effect> list) {
        this.R4.K(list);
        this.o5 = true;
    }

    /* access modifiers changed from: protected */
    public boolean H0() {
        return this.q5 && Util.f9646a < 23;
    }

    /* access modifiers changed from: protected */
    public boolean H2(long j2, long j3, boolean z) {
        return j2 < F5 && !z;
    }

    /* access modifiers changed from: protected */
    public boolean I2(long j2, long j3, boolean z) {
        return j2 < E5 && !z;
    }

    /* access modifiers changed from: protected */
    public float J0(float f2, Format format, Format[] formatArr) {
        float f3 = -1.0f;
        for (Format format2 : formatArr) {
            float f4 = format2.m3;
            if (f4 != -1.0f) {
                f3 = Math.max(f3, f4);
            }
        }
        if (f3 == -1.0f) {
            return -1.0f;
        }
        return f3 * f2;
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x006a  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x006c  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0073  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x0076  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x007c  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x007f  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x0082  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x0085  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x00a2  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int J1(androidx.media3.exoplayer.mediacodec.MediaCodecSelector r11, androidx.media3.common.Format r12) throws androidx.media3.exoplayer.mediacodec.MediaCodecUtil.DecoderQueryException {
        /*
            r10 = this;
            java.lang.String r0 = r12.f3
            boolean r0 = androidx.media3.common.MimeTypes.t(r0)
            r1 = 0
            if (r0 != 0) goto L_0x000e
            int r11 = androidx.media3.exoplayer.V0.c(r1)
            return r11
        L_0x000e:
            androidx.media3.common.DrmInitData r0 = r12.i3
            r2 = 1
            if (r0 == 0) goto L_0x0015
            r0 = 1
            goto L_0x0016
        L_0x0015:
            r0 = 0
        L_0x0016:
            android.content.Context r3 = r10.Q4
            java.util.List r3 = f2(r3, r11, r12, r0, r1)
            if (r0 == 0) goto L_0x002a
            boolean r4 = r3.isEmpty()
            if (r4 == 0) goto L_0x002a
            android.content.Context r3 = r10.Q4
            java.util.List r3 = f2(r3, r11, r12, r1, r1)
        L_0x002a:
            boolean r4 = r3.isEmpty()
            if (r4 == 0) goto L_0x0035
            int r11 = androidx.media3.exoplayer.V0.c(r2)
            return r11
        L_0x0035:
            boolean r4 = androidx.media3.exoplayer.mediacodec.MediaCodecRenderer.K1(r12)
            if (r4 != 0) goto L_0x0041
            r11 = 2
            int r11 = androidx.media3.exoplayer.V0.c(r11)
            return r11
        L_0x0041:
            java.lang.Object r4 = r3.get(r1)
            androidx.media3.exoplayer.mediacodec.MediaCodecInfo r4 = (androidx.media3.exoplayer.mediacodec.MediaCodecInfo) r4
            boolean r5 = r4.p(r12)
            if (r5 != 0) goto L_0x0067
            r6 = 1
        L_0x004e:
            int r7 = r3.size()
            if (r6 >= r7) goto L_0x0067
            java.lang.Object r7 = r3.get(r6)
            androidx.media3.exoplayer.mediacodec.MediaCodecInfo r7 = (androidx.media3.exoplayer.mediacodec.MediaCodecInfo) r7
            boolean r8 = r7.p(r12)
            if (r8 == 0) goto L_0x0064
            r4 = r7
            r3 = 0
            r5 = 1
            goto L_0x0068
        L_0x0064:
            int r6 = r6 + 1
            goto L_0x004e
        L_0x0067:
            r3 = 1
        L_0x0068:
            if (r5 == 0) goto L_0x006c
            r6 = 4
            goto L_0x006d
        L_0x006c:
            r6 = 3
        L_0x006d:
            boolean r7 = r4.s(r12)
            if (r7 == 0) goto L_0x0076
            r7 = 16
            goto L_0x0078
        L_0x0076:
            r7 = 8
        L_0x0078:
            boolean r4 = r4.f11700h
            if (r4 == 0) goto L_0x007f
            r4 = 64
            goto L_0x0080
        L_0x007f:
            r4 = 0
        L_0x0080:
            if (r3 == 0) goto L_0x0085
            r3 = 128(0x80, float:1.794E-43)
            goto L_0x0086
        L_0x0085:
            r3 = 0
        L_0x0086:
            int r8 = androidx.media3.common.util.Util.f9646a
            r9 = 26
            if (r8 < r9) goto L_0x00a0
            java.lang.String r8 = "video/dolby-vision"
            java.lang.String r9 = r12.f3
            boolean r8 = r8.equals(r9)
            if (r8 == 0) goto L_0x00a0
            android.content.Context r8 = r10.Q4
            boolean r8 = androidx.media3.exoplayer.video.MediaCodecVideoRenderer.Api26.a(r8)
            if (r8 != 0) goto L_0x00a0
            r3 = 256(0x100, float:3.59E-43)
        L_0x00a0:
            if (r5 == 0) goto L_0x00c6
            android.content.Context r5 = r10.Q4
            java.util.List r11 = f2(r5, r11, r12, r0, r2)
            boolean r0 = r11.isEmpty()
            if (r0 != 0) goto L_0x00c6
            java.util.List r11 = androidx.media3.exoplayer.mediacodec.MediaCodecUtil.x(r11, r12)
            java.lang.Object r11 = r11.get(r1)
            androidx.media3.exoplayer.mediacodec.MediaCodecInfo r11 = (androidx.media3.exoplayer.mediacodec.MediaCodecInfo) r11
            boolean r0 = r11.p(r12)
            if (r0 == 0) goto L_0x00c6
            boolean r11 = r11.s(r12)
            if (r11 == 0) goto L_0x00c6
            r1 = 32
        L_0x00c6:
            int r11 = androidx.media3.exoplayer.V0.f(r6, r7, r1, r4, r3)
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.exoplayer.video.MediaCodecVideoRenderer.J1(androidx.media3.exoplayer.mediacodec.MediaCodecSelector, androidx.media3.common.Format):int");
    }

    /* access modifiers changed from: protected */
    public boolean J2(long j2, long j3) {
        return j2 < E5 && j3 > SilenceSkippingAudioProcessor.A;
    }

    /* access modifiers changed from: protected */
    public boolean K2() {
        return true;
    }

    /* access modifiers changed from: protected */
    public List<MediaCodecInfo> L0(MediaCodecSelector mediaCodecSelector, Format format, boolean z) throws MediaCodecUtil.DecoderQueryException {
        return MediaCodecUtil.x(f2(this.Q4, mediaCodecSelector, format, z, this.q5), format);
    }

    /* access modifiers changed from: protected */
    @TargetApi(17)
    public MediaCodecAdapter.Configuration M0(MediaCodecInfo mediaCodecInfo, Format format, @Nullable MediaCrypto mediaCrypto, float f2) {
        PlaceholderSurface placeholderSurface = this.c5;
        if (!(placeholderSurface == null || placeholderSurface.s == mediaCodecInfo.f11699g)) {
            z2();
        }
        String str = mediaCodecInfo.f11695c;
        CodecMaxValues e2 = e2(mediaCodecInfo, format, P());
        this.X4 = e2;
        MediaFormat i2 = i2(format, str, e2, f2, this.U4, this.q5 ? this.r5 : 0);
        if (this.a5 == null) {
            if (L2(mediaCodecInfo)) {
                if (this.c5 == null) {
                    this.c5 = PlaceholderSurface.c(this.Q4, mediaCodecInfo.f11699g);
                }
                this.a5 = this.c5;
            } else {
                throw new IllegalStateException();
            }
        }
        s2(i2);
        VideoSink videoSink = this.u5;
        return MediaCodecAdapter.Configuration.b(mediaCodecInfo, i2, format, videoSink != null ? videoSink.b() : this.a5, mediaCrypto);
    }

    /* access modifiers changed from: protected */
    public void M2(MediaCodecAdapter mediaCodecAdapter, int i2, long j2) {
        TraceUtil.a("skipVideoBuffer");
        mediaCodecAdapter.m(i2, false);
        TraceUtil.c();
        this.u4.f10103f++;
    }

    /* access modifiers changed from: protected */
    public void N2(int i2, int i3) {
        DecoderCounters decoderCounters = this.u4;
        decoderCounters.f10105h += i2;
        int i4 = i2 + i3;
        decoderCounters.f10104g += i4;
        this.g5 += i4;
        int i6 = this.h5 + i4;
        this.h5 = i6;
        decoderCounters.f10106i = Math.max(i6, decoderCounters.f10106i);
        int i7 = this.T4;
        if (i7 > 0 && this.g5 >= i7) {
            l2();
        }
    }

    /* access modifiers changed from: protected */
    public void O2(long j2) {
        this.u4.a(j2);
        this.j5 += j2;
        this.k5++;
    }

    /* access modifiers changed from: protected */
    @TargetApi(29)
    public void Q0(DecoderInputBuffer decoderInputBuffer) throws ExoPlaybackException {
        if (this.Z4) {
            ByteBuffer byteBuffer = (ByteBuffer) Assertions.g(decoderInputBuffer.Z2);
            if (byteBuffer.remaining() >= 7) {
                byte b2 = byteBuffer.get();
                short s = byteBuffer.getShort();
                short s2 = byteBuffer.getShort();
                byte b3 = byteBuffer.get();
                byte b4 = byteBuffer.get();
                byteBuffer.position(0);
                if (b2 != -75 || s != 60 || s2 != 1 || b3 != 4) {
                    return;
                }
                if (b4 == 0 || b4 == 1) {
                    byte[] bArr = new byte[byteBuffer.remaining()];
                    byteBuffer.get(bArr);
                    byteBuffer.position(0);
                    D2((MediaCodecAdapter) Assertions.g(E0()), bArr);
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public void S() {
        this.n5 = null;
        this.V4.g();
        t2();
        this.d5 = false;
        this.s5 = null;
        try {
            super.S();
        } finally {
            this.S4.m(this.u4);
            this.S4.D(VideoSize.b3);
        }
    }

    /* access modifiers changed from: protected */
    public void T(boolean z, boolean z2) throws ExoPlaybackException {
        super.T(z, z2);
        boolean z3 = K().f10444b;
        Assertions.i(!z3 || this.r5 != 0);
        if (this.q5 != z3) {
            this.q5 = z3;
            t1();
        }
        this.S4.o(this.u4);
        this.V4.h(z2);
    }

    /* access modifiers changed from: protected */
    public void U() {
        super.U();
        Clock J = J();
        this.V4.o(J);
        this.R4.i(J);
    }

    /* access modifiers changed from: protected */
    public void V(long j2, boolean z) throws ExoPlaybackException {
        VideoSink videoSink = this.u5;
        if (videoSink != null) {
            videoSink.flush();
        }
        super.V(j2, z);
        if (this.R4.m()) {
            this.R4.r(N0());
        }
        this.V4.m();
        if (z) {
            this.V4.e();
        }
        t2();
        this.h5 = 0;
    }

    /* access modifiers changed from: protected */
    public void W() {
        super.W();
        if (this.R4.m()) {
            this.R4.a();
        }
    }

    /* access modifiers changed from: protected */
    public boolean X1(String str) {
        if (str.startsWith("OMX.google")) {
            return false;
        }
        synchronized (MediaCodecVideoRenderer.class) {
            try {
                if (!G5) {
                    H5 = b2();
                    G5 = true;
                }
            } catch (Throwable th) {
                while (true) {
                    throw th;
                }
            }
        }
        return H5;
    }

    /* access modifiers changed from: protected */
    @TargetApi(17)
    public void Y() {
        try {
            super.Y();
        } finally {
            this.p5 = false;
            if (this.c5 != null) {
                z2();
            }
        }
    }

    /* access modifiers changed from: protected */
    public void Z() {
        super.Z();
        this.g5 = 0;
        this.f5 = J().b();
        this.j5 = 0;
        this.k5 = 0;
        this.V4.k();
    }

    /* access modifiers changed from: protected */
    public void a0() {
        l2();
        n2();
        this.V4.l();
        super.a0();
    }

    /* access modifiers changed from: protected */
    public void a2(MediaCodecAdapter mediaCodecAdapter, int i2, long j2) {
        TraceUtil.a("dropVideoBuffer");
        mediaCodecAdapter.m(i2, false);
        TraceUtil.c();
        N2(0, 1);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0006, code lost:
        r0 = r1.u5;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean c() {
        /*
            r1 = this;
            boolean r0 = super.c()
            if (r0 == 0) goto L_0x0012
            androidx.media3.exoplayer.video.VideoSink r0 = r1.u5
            if (r0 == 0) goto L_0x0010
            boolean r0 = r0.c()
            if (r0 == 0) goto L_0x0012
        L_0x0010:
            r0 = 1
            goto L_0x0013
        L_0x0012:
            r0 = 0
        L_0x0013:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.exoplayer.video.MediaCodecVideoRenderer.c():boolean");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0007, code lost:
        r0 = r4.u5;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean d() {
        /*
            r4 = this;
            boolean r0 = super.d()
            r1 = 1
            if (r0 == 0) goto L_0x0013
            androidx.media3.exoplayer.video.VideoSink r0 = r4.u5
            if (r0 == 0) goto L_0x0011
            boolean r0 = r0.d()
            if (r0 == 0) goto L_0x0013
        L_0x0011:
            r0 = 1
            goto L_0x0014
        L_0x0013:
            r0 = 0
        L_0x0014:
            if (r0 == 0) goto L_0x0029
            androidx.media3.exoplayer.video.PlaceholderSurface r2 = r4.c5
            if (r2 == 0) goto L_0x001e
            android.view.Surface r3 = r4.a5
            if (r3 == r2) goto L_0x0028
        L_0x001e:
            androidx.media3.exoplayer.mediacodec.MediaCodecAdapter r2 = r4.E0()
            if (r2 == 0) goto L_0x0028
            boolean r2 = r4.q5
            if (r2 == 0) goto L_0x0029
        L_0x0028:
            return r1
        L_0x0029:
            androidx.media3.exoplayer.video.VideoFrameReleaseControl r1 = r4.V4
            boolean r0 = r1.d(r0)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.exoplayer.video.MediaCodecVideoRenderer.d():boolean");
    }

    /* access modifiers changed from: protected */
    public void e1(Exception exc) {
        Log.e(v5, "Video codec error", exc);
        this.S4.C(exc);
    }

    /* access modifiers changed from: protected */
    public CodecMaxValues e2(MediaCodecInfo mediaCodecInfo, Format format, Format[] formatArr) {
        int c2;
        int i2 = format.k3;
        int i3 = format.l3;
        int g2 = g2(mediaCodecInfo, format);
        if (formatArr.length == 1) {
            if (!(g2 == -1 || (c2 = c2(mediaCodecInfo, format)) == -1)) {
                g2 = Math.min((int) (((float) g2) * B5), c2);
            }
            return new CodecMaxValues(i2, i3, g2);
        }
        int length = formatArr.length;
        boolean z = false;
        for (int i4 = 0; i4 < length; i4++) {
            Format format2 = formatArr[i4];
            if (format.r3 != null && format2.r3 == null) {
                format2 = format2.c().N(format.r3).I();
            }
            if (mediaCodecInfo.e(format, format2).f10122d != 0) {
                int i6 = format2.k3;
                z |= i6 == -1 || format2.l3 == -1;
                i2 = Math.max(i2, i6);
                i3 = Math.max(i3, format2.l3);
                g2 = Math.max(g2, g2(mediaCodecInfo, format2));
            }
        }
        if (z) {
            Log.n(v5, "Resolutions unknown. Codec max resolution: " + i2 + "x" + i3);
            Point d2 = d2(mediaCodecInfo, format);
            if (d2 != null) {
                i2 = Math.max(i2, d2.x);
                i3 = Math.max(i3, d2.y);
                g2 = Math.max(g2, c2(mediaCodecInfo, format.c().r0(i2).V(i3).I()));
                Log.n(v5, "Codec max resolution adjusted to: " + i2 + "x" + i3);
            }
        }
        return new CodecMaxValues(i2, i3, g2);
    }

    /* access modifiers changed from: protected */
    public void f1(String str, MediaCodecAdapter.Configuration configuration, long j2, long j3) {
        this.S4.k(str, j2, j3);
        this.Y4 = X1(str);
        this.Z4 = ((MediaCodecInfo) Assertions.g(G0())).q();
        t2();
    }

    @CallSuper
    public void g(long j2, long j3) throws ExoPlaybackException {
        super.g(j2, j3);
        VideoSink videoSink = this.u5;
        if (videoSink != null) {
            try {
                videoSink.g(j2, j3);
            } catch (VideoSink.VideoSinkException e2) {
                throw H(e2, e2.s, PlaybackException.G3);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void g1(String str) {
        this.S4.l(str);
    }

    public String getName() {
        return v5;
    }

    /* access modifiers changed from: protected */
    @Nullable
    public DecoderReuseEvaluation h1(FormatHolder formatHolder) throws ExoPlaybackException {
        DecoderReuseEvaluation h1 = super.h1(formatHolder);
        this.S4.p((Format) Assertions.g(formatHolder.f10226b), h1);
        return h1;
    }

    /* access modifiers changed from: protected */
    public DecoderReuseEvaluation i0(MediaCodecInfo mediaCodecInfo, Format format, Format format2) {
        DecoderReuseEvaluation e2 = mediaCodecInfo.e(format, format2);
        int i2 = e2.f10123e;
        CodecMaxValues codecMaxValues = (CodecMaxValues) Assertions.g(this.X4);
        if (format2.k3 > codecMaxValues.f12768a || format2.l3 > codecMaxValues.f12769b) {
            i2 |= 256;
        }
        if (g2(mediaCodecInfo, format2) > codecMaxValues.f12770c) {
            i2 |= 64;
        }
        int i3 = i2;
        return new DecoderReuseEvaluation(mediaCodecInfo.f11693a, format, format2, i3 != 0 ? 0 : e2.f10122d, i3);
    }

    /* access modifiers changed from: protected */
    public void i1(Format format, @Nullable MediaFormat mediaFormat) {
        int i2;
        int i3;
        MediaCodecAdapter E0 = E0();
        if (E0 != null) {
            E0.l(this.e5);
        }
        int i4 = 0;
        if (this.q5) {
            i3 = format.k3;
            i2 = format.l3;
        } else {
            Assertions.g(mediaFormat);
            boolean z = mediaFormat.containsKey(x5) && mediaFormat.containsKey(w5) && mediaFormat.containsKey(y5) && mediaFormat.containsKey(z5);
            i3 = z ? (mediaFormat.getInteger(x5) - mediaFormat.getInteger(w5)) + 1 : mediaFormat.getInteger("width");
            i2 = z ? (mediaFormat.getInteger(y5) - mediaFormat.getInteger(z5)) + 1 : mediaFormat.getInteger("height");
        }
        float f2 = format.o3;
        if (W1()) {
            int i6 = format.n3;
            if (i6 == 90 || i6 == 270) {
                f2 = 1.0f / f2;
                int i7 = i2;
                i2 = i3;
                i3 = i7;
            }
        } else if (this.u5 == null) {
            i4 = format.n3;
        }
        this.m5 = new VideoSize(i3, i2, i4, f2);
        this.V4.p(format.m3);
        if (this.u5 != null && mediaFormat != null) {
            y2();
            ((VideoSink) Assertions.g(this.u5)).f(1, format.c().r0(i3).V(i2).j0(i4).g0(f2).I());
        }
    }

    /* access modifiers changed from: protected */
    @SuppressLint({"InlinedApi"})
    @TargetApi(21)
    public MediaFormat i2(Format format, String str, CodecMaxValues codecMaxValues, float f2, boolean z, int i2) {
        Pair<Integer, Integer> s;
        MediaFormat mediaFormat = new MediaFormat();
        mediaFormat.setString(Annotation.w3, str);
        mediaFormat.setInteger("width", format.k3);
        mediaFormat.setInteger("height", format.l3);
        MediaFormatUtil.x(mediaFormat, format.h3);
        MediaFormatUtil.r(mediaFormat, "frame-rate", format.m3);
        MediaFormatUtil.s(mediaFormat, "rotation-degrees", format.n3);
        MediaFormatUtil.q(mediaFormat, format.r3);
        if (MimeTypes.w.equals(format.f3) && (s = MediaCodecUtil.s(format)) != null) {
            MediaFormatUtil.s(mediaFormat, Scopes.f19906a, ((Integer) s.first).intValue());
        }
        mediaFormat.setInteger(CSS.Property.E0, codecMaxValues.f12768a);
        mediaFormat.setInteger(CSS.Property.G0, codecMaxValues.f12769b);
        MediaFormatUtil.s(mediaFormat, "max-input-size", codecMaxValues.f12770c);
        if (Util.f9646a >= 23) {
            mediaFormat.setInteger("priority", 0);
            if (f2 != -1.0f) {
                mediaFormat.setFloat("operating-rate", f2);
            }
        }
        if (z) {
            mediaFormat.setInteger("no-post-process", 1);
            mediaFormat.setInteger("auto-frc", 0);
        }
        if (i2 != 0) {
            Y1(mediaFormat, i2);
        }
        return mediaFormat;
    }

    public boolean j(long j2, long j3, long j4, boolean z, boolean z2) throws ExoPlaybackException {
        return H2(j2, j4, z) && k2(j3, z2);
    }

    /* access modifiers changed from: protected */
    @Nullable
    public Surface j2() {
        return this.a5;
    }

    /* access modifiers changed from: protected */
    @CallSuper
    public void k1(long j2) {
        super.k1(j2);
        if (!this.q5) {
            this.i5--;
        }
    }

    /* access modifiers changed from: protected */
    public boolean k2(long j2, boolean z) throws ExoPlaybackException {
        int f0 = f0(j2);
        if (f0 == 0) {
            return false;
        }
        if (z) {
            DecoderCounters decoderCounters = this.u4;
            decoderCounters.f10101d += f0;
            decoderCounters.f10103f += this.i5;
        } else {
            this.u4.f10107j++;
            N2(f0, this.i5);
        }
        B0();
        VideoSink videoSink = this.u5;
        if (videoSink != null) {
            videoSink.flush();
        }
        return true;
    }

    /* access modifiers changed from: protected */
    public void l1() {
        super.l1();
        this.V4.j();
        t2();
        if (this.R4.m()) {
            this.R4.r(N0());
        }
    }

    /* access modifiers changed from: protected */
    @CallSuper
    public void m1(DecoderInputBuffer decoderInputBuffer) throws ExoPlaybackException {
        boolean z = this.q5;
        if (!z) {
            this.i5++;
        }
        if (Util.f9646a < 23 && z) {
            w2(decoderInputBuffer.Y2);
        }
    }

    /* access modifiers changed from: protected */
    @CallSuper
    public void n1(Format format) throws ExoPlaybackException {
        Size size;
        if (this.o5 && !this.p5 && !this.R4.m()) {
            try {
                this.R4.s(format);
                this.R4.r(N0());
                VideoFrameMetadataListener videoFrameMetadataListener = this.t5;
                if (videoFrameMetadataListener != null) {
                    this.R4.b(videoFrameMetadataListener);
                }
                Surface surface = this.a5;
                if (!(surface == null || (size = this.b5) == null)) {
                    this.R4.h(surface, size);
                }
            } catch (VideoSink.VideoSinkException e2) {
                throw H(e2, format, 7000);
            }
        }
        if (this.u5 == null && this.R4.m()) {
            VideoSink p = this.R4.p();
            this.u5 = p;
            p.i(new VideoSink.Listener() {
                public void a(VideoSink videoSink) {
                    Assertions.k(MediaCodecVideoRenderer.this.a5);
                    MediaCodecVideoRenderer.this.v2();
                }

                public void b(VideoSink videoSink, VideoSize videoSize) {
                }

                public void c(VideoSink videoSink, VideoSink.VideoSinkException videoSinkException) {
                    MediaCodecVideoRenderer mediaCodecVideoRenderer = MediaCodecVideoRenderer.this;
                    mediaCodecVideoRenderer.C1(mediaCodecVideoRenderer.H(videoSinkException, videoSinkException.s, PlaybackException.G3));
                }

                public void d(VideoSink videoSink) {
                    MediaCodecVideoRenderer.this.N2(0, 1);
                }
            }, MoreExecutors.c());
        }
        this.p5 = true;
    }

    public void p() {
        this.V4.a();
    }

    /* access modifiers changed from: protected */
    public boolean p1(long j2, long j3, @Nullable MediaCodecAdapter mediaCodecAdapter, @Nullable ByteBuffer byteBuffer, int i2, int i3, int i4, long j4, boolean z, boolean z2, Format format) throws ExoPlaybackException {
        MediaCodecAdapter mediaCodecAdapter2 = mediaCodecAdapter;
        int i6 = i2;
        boolean z3 = z2;
        Assertions.g(mediaCodecAdapter);
        long N0 = j4 - N0();
        int c2 = this.V4.c(j4, j2, j3, O0(), z2, this.W4);
        if (!z || z3) {
            long j6 = N0;
            if (this.a5 != this.c5) {
                VideoSink videoSink = this.u5;
                if (videoSink != null) {
                    try {
                        videoSink.g(j2, j3);
                        long e2 = this.u5.e(j6, z3);
                        if (e2 == C.f9084b) {
                            return false;
                        }
                        B2(mediaCodecAdapter, i2, j6, e2);
                        return true;
                    } catch (VideoSink.VideoSinkException e3) {
                        VideoSink.VideoSinkException videoSinkException = e3;
                        throw H(videoSinkException, videoSinkException.s, PlaybackException.G3);
                    }
                } else if (c2 == 0) {
                    long c3 = J().c();
                    u2(j6, c3, format);
                    B2(mediaCodecAdapter, i2, j6, c3);
                    O2(this.W4.f());
                    return true;
                } else if (c2 == 1) {
                    return p2((MediaCodecAdapter) Assertions.k(mediaCodecAdapter), i2, j6, format);
                } else {
                    if (c2 == 2) {
                        a2(mediaCodecAdapter2, i6, j6);
                        O2(this.W4.f());
                        return true;
                    } else if (c2 == 3) {
                        M2(mediaCodecAdapter2, i6, j6);
                        O2(this.W4.f());
                        return true;
                    } else if (c2 == 4 || c2 == 5) {
                        return false;
                    } else {
                        throw new IllegalStateException(String.valueOf(c2));
                    }
                }
            } else if (this.W4.f() >= 30000) {
                return false;
            } else {
                M2(mediaCodecAdapter2, i6, j6);
                O2(this.W4.f());
                return true;
            }
        } else {
            M2(mediaCodecAdapter2, i6, N0);
            return true;
        }
    }

    /* access modifiers changed from: protected */
    public MediaCodecDecoderException s0(Throwable th, @Nullable MediaCodecInfo mediaCodecInfo) {
        return new MediaCodecVideoDecoderException(th, mediaCodecInfo, this.a5);
    }

    public void v(float f2, float f3) throws ExoPlaybackException {
        super.v(f2, f3);
        this.V4.r(f2);
        VideoSink videoSink = this.u5;
        if (videoSink != null) {
            videoSink.m(f2);
        }
    }

    /* access modifiers changed from: protected */
    @CallSuper
    public void v1() {
        super.v1();
        this.i5 = 0;
    }

    public boolean w(long j2, long j3, boolean z) {
        return I2(j2, j3, z);
    }

    /* access modifiers changed from: protected */
    public void w2(long j2) throws ExoPlaybackException {
        O1(j2);
        o2(this.m5);
        this.u4.f10102e++;
        m2();
        k1(j2);
    }

    /* access modifiers changed from: protected */
    public void y2() {
    }

    public void z(int i2, @Nullable Object obj) throws ExoPlaybackException {
        Surface surface;
        if (i2 == 1) {
            E2(obj);
        } else if (i2 == 7) {
            VideoFrameMetadataListener videoFrameMetadataListener = (VideoFrameMetadataListener) Assertions.g(obj);
            this.t5 = videoFrameMetadataListener;
            this.R4.b(videoFrameMetadataListener);
        } else if (i2 == 10) {
            int intValue = ((Integer) Assertions.g(obj)).intValue();
            if (this.r5 != intValue) {
                this.r5 = intValue;
                if (this.q5) {
                    t1();
                }
            }
        } else if (i2 == 4) {
            this.e5 = ((Integer) Assertions.g(obj)).intValue();
            MediaCodecAdapter E0 = E0();
            if (E0 != null) {
                E0.l(this.e5);
            }
        } else if (i2 == 5) {
            this.V4.n(((Integer) Assertions.g(obj)).intValue());
        } else if (i2 == 13) {
            G2((List) Assertions.g(obj));
        } else if (i2 != 14) {
            super.z(i2, obj);
        } else {
            this.b5 = (Size) Assertions.g(obj);
            if (this.R4.m() && ((Size) Assertions.g(this.b5)).b() != 0 && ((Size) Assertions.g(this.b5)).a() != 0 && (surface = this.a5) != null) {
                this.R4.h(surface, (Size) Assertions.g(this.b5));
            }
        }
    }

    public MediaCodecVideoRenderer(Context context, MediaCodecAdapter.Factory factory, MediaCodecSelector mediaCodecSelector, long j2, boolean z, @Nullable Handler handler, @Nullable VideoRendererEventListener videoRendererEventListener, int i2, float f2) {
        this(context, factory, mediaCodecSelector, j2, z, handler, videoRendererEventListener, i2, f2, (VideoSinkProvider) null);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MediaCodecVideoRenderer(Context context, MediaCodecAdapter.Factory factory, MediaCodecSelector mediaCodecSelector, long j2, boolean z, @Nullable Handler handler, @Nullable VideoRendererEventListener videoRendererEventListener, int i2, float f2, @Nullable VideoSinkProvider videoSinkProvider) {
        super(2, factory, mediaCodecSelector, z, f2);
        this.T4 = i2;
        Context applicationContext = context.getApplicationContext();
        this.Q4 = applicationContext;
        Handler handler2 = handler;
        VideoRendererEventListener videoRendererEventListener2 = videoRendererEventListener;
        this.S4 = new VideoRendererEventListener.EventDispatcher(handler, videoRendererEventListener);
        VideoSinkProvider c2 = videoSinkProvider == null ? new CompositingVideoSinkProvider.Builder(applicationContext).c() : videoSinkProvider;
        if (c2.o() == null) {
            long j3 = j2;
            c2.j(new VideoFrameReleaseControl(applicationContext, this, j2));
        }
        this.R4 = c2;
        this.V4 = (VideoFrameReleaseControl) Assertions.k(c2.o());
        this.W4 = new VideoFrameReleaseControl.FrameReleaseInfo();
        this.U4 = Z1();
        this.e5 = 1;
        this.m5 = VideoSize.b3;
        this.r5 = 0;
        this.n5 = null;
    }

    public MediaCodecVideoRenderer(Context context, MediaCodecSelector mediaCodecSelector) {
        this(context, mediaCodecSelector, 0);
    }

    public MediaCodecVideoRenderer(Context context, MediaCodecSelector mediaCodecSelector, long j2) {
        this(context, mediaCodecSelector, j2, (Handler) null, (VideoRendererEventListener) null, 0);
    }

    public MediaCodecVideoRenderer(Context context, MediaCodecSelector mediaCodecSelector, long j2, @Nullable Handler handler, @Nullable VideoRendererEventListener videoRendererEventListener, int i2) {
        this(context, j.a(context), mediaCodecSelector, j2, false, handler, videoRendererEventListener, i2, 30.0f);
    }

    public MediaCodecVideoRenderer(Context context, MediaCodecSelector mediaCodecSelector, long j2, boolean z, @Nullable Handler handler, @Nullable VideoRendererEventListener videoRendererEventListener, int i2) {
        this(context, j.a(context), mediaCodecSelector, j2, z, handler, videoRendererEventListener, i2, 30.0f);
    }
}
