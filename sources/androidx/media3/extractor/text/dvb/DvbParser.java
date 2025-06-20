package androidx.media3.extractor.text.dvb;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PathEffect;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.util.SparseArray;
import androidx.annotation.Nullable;
import androidx.core.view.ViewCompat;
import androidx.media3.common.C;
import androidx.media3.common.text.Cue;
import androidx.media3.common.util.Consumer;
import androidx.media3.common.util.ParsableBitArray;
import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;
import androidx.media3.exoplayer.trackselection.AdaptiveTrackSelection;
import androidx.media3.extractor.text.CuesWithTiming;
import androidx.media3.extractor.text.Subtitle;
import androidx.media3.extractor.text.SubtitleParser;
import androidx.media3.extractor.text.e;
import androidx.media3.extractor.ts.TsExtractor;
import com.google.common.collect.ImmutableList;
import com.itextpdf.text.DocWriter;
import java.util.ArrayList;
import java.util.List;
import kotlinx.coroutines.scheduling.WorkQueueKt;

@UnstableApi
public final class DvbParser implements SubtitleParser {
    private static final byte[] A = {0, 7, 8, 15};
    private static final byte[] B = {0, 119, -120, -1};
    private static final byte[] C = {0, 17, DocWriter.e3, 51, 68, 85, 102, 119, -120, -103, -86, -69, -52, -35, -18, -1};

    /* renamed from: h  reason: collision with root package name */
    public static final int f13856h = 2;

    /* renamed from: i  reason: collision with root package name */
    private static final String f13857i = "DvbParser";

    /* renamed from: j  reason: collision with root package name */
    private static final int f13858j = 16;

    /* renamed from: k  reason: collision with root package name */
    private static final int f13859k = 17;

    /* renamed from: l  reason: collision with root package name */
    private static final int f13860l = 18;

    /* renamed from: m  reason: collision with root package name */
    private static final int f13861m = 19;

    /* renamed from: n  reason: collision with root package name */
    private static final int f13862n = 20;
    private static final int o = 0;
    private static final int p = 2;
    private static final int q = 3;
    private static final int r = 0;
    private static final int s = 1;
    private static final int t = 16;
    private static final int u = 17;
    private static final int v = 18;
    private static final int w = 32;
    private static final int x = 33;
    private static final int y = 34;
    private static final int z = 240;

    /* renamed from: a  reason: collision with root package name */
    private final Paint f13863a;

    /* renamed from: b  reason: collision with root package name */
    private final Paint f13864b;

    /* renamed from: c  reason: collision with root package name */
    private final Canvas f13865c = new Canvas();

    /* renamed from: d  reason: collision with root package name */
    private final DisplayDefinition f13866d = new DisplayDefinition(AdaptiveTrackSelection.E, 575, 0, AdaptiveTrackSelection.E, 0, 575);

    /* renamed from: e  reason: collision with root package name */
    private final ClutDefinition f13867e = new ClutDefinition(0, f(), g(), h());

    /* renamed from: f  reason: collision with root package name */
    private final SubtitleService f13868f;

    /* renamed from: g  reason: collision with root package name */
    private Bitmap f13869g;

    private static final class ClutDefinition {

        /* renamed from: a  reason: collision with root package name */
        public final int f13870a;

        /* renamed from: b  reason: collision with root package name */
        public final int[] f13871b;

        /* renamed from: c  reason: collision with root package name */
        public final int[] f13872c;

        /* renamed from: d  reason: collision with root package name */
        public final int[] f13873d;

        public ClutDefinition(int i2, int[] iArr, int[] iArr2, int[] iArr3) {
            this.f13870a = i2;
            this.f13871b = iArr;
            this.f13872c = iArr2;
            this.f13873d = iArr3;
        }
    }

    private static final class DisplayDefinition {

        /* renamed from: a  reason: collision with root package name */
        public final int f13874a;

        /* renamed from: b  reason: collision with root package name */
        public final int f13875b;

        /* renamed from: c  reason: collision with root package name */
        public final int f13876c;

        /* renamed from: d  reason: collision with root package name */
        public final int f13877d;

        /* renamed from: e  reason: collision with root package name */
        public final int f13878e;

        /* renamed from: f  reason: collision with root package name */
        public final int f13879f;

        public DisplayDefinition(int i2, int i3, int i4, int i5, int i6, int i7) {
            this.f13874a = i2;
            this.f13875b = i3;
            this.f13876c = i4;
            this.f13877d = i5;
            this.f13878e = i6;
            this.f13879f = i7;
        }
    }

    private static final class ObjectData {

        /* renamed from: a  reason: collision with root package name */
        public final int f13880a;

        /* renamed from: b  reason: collision with root package name */
        public final boolean f13881b;

        /* renamed from: c  reason: collision with root package name */
        public final byte[] f13882c;

        /* renamed from: d  reason: collision with root package name */
        public final byte[] f13883d;

        public ObjectData(int i2, boolean z, byte[] bArr, byte[] bArr2) {
            this.f13880a = i2;
            this.f13881b = z;
            this.f13882c = bArr;
            this.f13883d = bArr2;
        }
    }

    private static final class PageComposition {

        /* renamed from: a  reason: collision with root package name */
        public final int f13884a;

        /* renamed from: b  reason: collision with root package name */
        public final int f13885b;

        /* renamed from: c  reason: collision with root package name */
        public final int f13886c;

        /* renamed from: d  reason: collision with root package name */
        public final SparseArray<PageRegion> f13887d;

        public PageComposition(int i2, int i3, int i4, SparseArray<PageRegion> sparseArray) {
            this.f13884a = i2;
            this.f13885b = i3;
            this.f13886c = i4;
            this.f13887d = sparseArray;
        }
    }

    private static final class PageRegion {

        /* renamed from: a  reason: collision with root package name */
        public final int f13888a;

        /* renamed from: b  reason: collision with root package name */
        public final int f13889b;

        public PageRegion(int i2, int i3) {
            this.f13888a = i2;
            this.f13889b = i3;
        }
    }

    private static final class RegionComposition {

        /* renamed from: a  reason: collision with root package name */
        public final int f13890a;

        /* renamed from: b  reason: collision with root package name */
        public final boolean f13891b;

        /* renamed from: c  reason: collision with root package name */
        public final int f13892c;

        /* renamed from: d  reason: collision with root package name */
        public final int f13893d;

        /* renamed from: e  reason: collision with root package name */
        public final int f13894e;

        /* renamed from: f  reason: collision with root package name */
        public final int f13895f;

        /* renamed from: g  reason: collision with root package name */
        public final int f13896g;

        /* renamed from: h  reason: collision with root package name */
        public final int f13897h;

        /* renamed from: i  reason: collision with root package name */
        public final int f13898i;

        /* renamed from: j  reason: collision with root package name */
        public final int f13899j;

        /* renamed from: k  reason: collision with root package name */
        public final SparseArray<RegionObject> f13900k;

        public RegionComposition(int i2, boolean z, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, SparseArray<RegionObject> sparseArray) {
            this.f13890a = i2;
            this.f13891b = z;
            this.f13892c = i3;
            this.f13893d = i4;
            this.f13894e = i5;
            this.f13895f = i6;
            this.f13896g = i7;
            this.f13897h = i8;
            this.f13898i = i9;
            this.f13899j = i10;
            this.f13900k = sparseArray;
        }

        public void a(RegionComposition regionComposition) {
            SparseArray<RegionObject> sparseArray = regionComposition.f13900k;
            for (int i2 = 0; i2 < sparseArray.size(); i2++) {
                this.f13900k.put(sparseArray.keyAt(i2), sparseArray.valueAt(i2));
            }
        }
    }

    private static final class RegionObject {

        /* renamed from: a  reason: collision with root package name */
        public final int f13901a;

        /* renamed from: b  reason: collision with root package name */
        public final int f13902b;

        /* renamed from: c  reason: collision with root package name */
        public final int f13903c;

        /* renamed from: d  reason: collision with root package name */
        public final int f13904d;

        /* renamed from: e  reason: collision with root package name */
        public final int f13905e;

        /* renamed from: f  reason: collision with root package name */
        public final int f13906f;

        public RegionObject(int i2, int i3, int i4, int i5, int i6, int i7) {
            this.f13901a = i2;
            this.f13902b = i3;
            this.f13903c = i4;
            this.f13904d = i5;
            this.f13905e = i6;
            this.f13906f = i7;
        }
    }

    private static final class SubtitleService {

        /* renamed from: a  reason: collision with root package name */
        public final int f13907a;

        /* renamed from: b  reason: collision with root package name */
        public final int f13908b;

        /* renamed from: c  reason: collision with root package name */
        public final SparseArray<RegionComposition> f13909c = new SparseArray<>();

        /* renamed from: d  reason: collision with root package name */
        public final SparseArray<ClutDefinition> f13910d = new SparseArray<>();

        /* renamed from: e  reason: collision with root package name */
        public final SparseArray<ObjectData> f13911e = new SparseArray<>();

        /* renamed from: f  reason: collision with root package name */
        public final SparseArray<ClutDefinition> f13912f = new SparseArray<>();

        /* renamed from: g  reason: collision with root package name */
        public final SparseArray<ObjectData> f13913g = new SparseArray<>();
        @Nullable

        /* renamed from: h  reason: collision with root package name */
        public DisplayDefinition f13914h;
        @Nullable

        /* renamed from: i  reason: collision with root package name */
        public PageComposition f13915i;

        public SubtitleService(int i2, int i3) {
            this.f13907a = i2;
            this.f13908b = i3;
        }

        public void a() {
            this.f13909c.clear();
            this.f13910d.clear();
            this.f13911e.clear();
            this.f13912f.clear();
            this.f13913g.clear();
            this.f13914h = null;
            this.f13915i = null;
        }
    }

    public DvbParser(List<byte[]> list) {
        ParsableByteArray parsableByteArray = new ParsableByteArray(list.get(0));
        int R = parsableByteArray.R();
        int R2 = parsableByteArray.R();
        Paint paint = new Paint();
        this.f13863a = paint;
        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC));
        paint.setPathEffect((PathEffect) null);
        Paint paint2 = new Paint();
        this.f13864b = paint2;
        paint2.setStyle(Paint.Style.FILL);
        paint2.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OVER));
        paint2.setPathEffect((PathEffect) null);
        this.f13868f = new SubtitleService(R, R2);
    }

    private static byte[] e(int i2, int i3, ParsableBitArray parsableBitArray) {
        byte[] bArr = new byte[i2];
        for (int i4 = 0; i4 < i2; i4++) {
            bArr[i4] = (byte) parsableBitArray.h(i3);
        }
        return bArr;
    }

    private static int[] f() {
        return new int[]{0, -1, ViewCompat.y, -8421505};
    }

    private static int[] g() {
        int[] iArr = new int[16];
        iArr[0] = 0;
        for (int i2 = 1; i2 < 16; i2++) {
            if (i2 < 8) {
                iArr[i2] = i(255, (i2 & 1) != 0 ? 255 : 0, (i2 & 2) != 0 ? 255 : 0, (i2 & 4) != 0 ? 255 : 0);
            } else {
                int i3 = i2 & 1;
                int i4 = WorkQueueKt.f29430c;
                int i5 = i3 != 0 ? WorkQueueKt.f29430c : 0;
                int i6 = (i2 & 2) != 0 ? WorkQueueKt.f29430c : 0;
                if ((i2 & 4) == 0) {
                    i4 = 0;
                }
                iArr[i2] = i(255, i5, i6, i4);
            }
        }
        return iArr;
    }

    private static int[] h() {
        int[] iArr = new int[256];
        iArr[0] = 0;
        for (int i2 = 0; i2 < 256; i2++) {
            int i3 = 255;
            if (i2 < 8) {
                int i4 = (i2 & 1) != 0 ? 255 : 0;
                int i5 = (i2 & 2) != 0 ? 255 : 0;
                if ((i2 & 4) == 0) {
                    i3 = 0;
                }
                iArr[i2] = i(63, i4, i5, i3);
            } else {
                int i6 = i2 & TsExtractor.V;
                int i7 = 170;
                int i8 = 85;
                if (i6 == 0) {
                    int i9 = ((i2 & 1) != 0 ? 85 : 0) + ((i2 & 16) != 0 ? 170 : 0);
                    int i10 = ((i2 & 2) != 0 ? 85 : 0) + ((i2 & 32) != 0 ? 170 : 0);
                    if ((i2 & 4) == 0) {
                        i8 = 0;
                    }
                    if ((i2 & 64) == 0) {
                        i7 = 0;
                    }
                    iArr[i2] = i(255, i9, i10, i8 + i7);
                } else if (i6 != 8) {
                    int i11 = 43;
                    if (i6 == 128) {
                        int i12 = ((i2 & 1) != 0 ? 43 : 0) + WorkQueueKt.f29430c + ((i2 & 16) != 0 ? 85 : 0);
                        int i13 = ((i2 & 2) != 0 ? 43 : 0) + WorkQueueKt.f29430c + ((i2 & 32) != 0 ? 85 : 0);
                        if ((i2 & 4) == 0) {
                            i11 = 0;
                        }
                        int i14 = i11 + WorkQueueKt.f29430c;
                        if ((i2 & 64) == 0) {
                            i8 = 0;
                        }
                        iArr[i2] = i(255, i12, i13, i14 + i8);
                    } else if (i6 == 136) {
                        int i15 = ((i2 & 1) != 0 ? 43 : 0) + ((i2 & 16) != 0 ? 85 : 0);
                        int i16 = ((i2 & 2) != 0 ? 43 : 0) + ((i2 & 32) != 0 ? 85 : 0);
                        if ((i2 & 4) == 0) {
                            i11 = 0;
                        }
                        if ((i2 & 64) == 0) {
                            i8 = 0;
                        }
                        iArr[i2] = i(255, i15, i16, i11 + i8);
                    }
                } else {
                    int i17 = ((i2 & 1) != 0 ? 85 : 0) + ((i2 & 16) != 0 ? 170 : 0);
                    int i18 = ((i2 & 2) != 0 ? 85 : 0) + ((i2 & 32) != 0 ? 170 : 0);
                    if ((i2 & 4) == 0) {
                        i8 = 0;
                    }
                    if ((i2 & 64) == 0) {
                        i7 = 0;
                    }
                    iArr[i2] = i(WorkQueueKt.f29430c, i17, i18, i8 + i7);
                }
            }
        }
        return iArr;
    }

    private static int i(int i2, int i3, int i4, int i5) {
        return (i2 << 24) | (i3 << 16) | (i4 << 8) | i5;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v24, resolved type: byte} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x005f  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x007b A[LOOP:0: B:1:0x0009->B:31:0x007b, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x007a A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static int j(androidx.media3.common.util.ParsableBitArray r13, int[] r14, @androidx.annotation.Nullable byte[] r15, int r16, int r17, @androidx.annotation.Nullable android.graphics.Paint r18, android.graphics.Canvas r19) {
        /*
            r0 = r13
            r1 = r17
            r8 = r18
            r9 = 0
            r10 = r16
            r2 = 0
        L_0x0009:
            r3 = 2
            int r4 = r13.h(r3)
            r5 = 1
            if (r4 == 0) goto L_0x0014
            r11 = r2
        L_0x0012:
            r12 = 1
            goto L_0x0059
        L_0x0014:
            boolean r4 = r13.g()
            r6 = 3
            if (r4 == 0) goto L_0x0028
            int r4 = r13.h(r6)
            int r4 = r4 + r6
        L_0x0020:
            int r3 = r13.h(r3)
            r11 = r2
            r12 = r4
            r4 = r3
            goto L_0x0059
        L_0x0028:
            boolean r4 = r13.g()
            if (r4 == 0) goto L_0x0031
            r11 = r2
            r4 = 0
            goto L_0x0012
        L_0x0031:
            int r4 = r13.h(r3)
            if (r4 == 0) goto L_0x0056
            if (r4 == r5) goto L_0x0052
            if (r4 == r3) goto L_0x004a
            if (r4 == r6) goto L_0x0041
            r11 = r2
            r4 = 0
        L_0x003f:
            r12 = 0
            goto L_0x0059
        L_0x0041:
            r4 = 8
            int r4 = r13.h(r4)
            int r4 = r4 + 29
            goto L_0x0020
        L_0x004a:
            r4 = 4
            int r4 = r13.h(r4)
            int r4 = r4 + 12
            goto L_0x0020
        L_0x0052:
            r11 = r2
            r4 = 0
            r12 = 2
            goto L_0x0059
        L_0x0056:
            r4 = 0
            r11 = 1
            goto L_0x003f
        L_0x0059:
            if (r12 == 0) goto L_0x0077
            if (r8 == 0) goto L_0x0077
            if (r15 == 0) goto L_0x0061
            byte r4 = r15[r4]
        L_0x0061:
            r2 = r14[r4]
            r8.setColor(r2)
            float r3 = (float) r10
            float r4 = (float) r1
            int r2 = r10 + r12
            float r6 = (float) r2
            int r2 = r1 + 1
            float r7 = (float) r2
            r2 = r19
            r5 = r6
            r6 = r7
            r7 = r18
            r2.drawRect(r3, r4, r5, r6, r7)
        L_0x0077:
            int r10 = r10 + r12
            if (r11 == 0) goto L_0x007b
            return r10
        L_0x007b:
            r2 = r11
            goto L_0x0009
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.extractor.text.dvb.DvbParser.j(androidx.media3.common.util.ParsableBitArray, int[], byte[], int, int, android.graphics.Paint, android.graphics.Canvas):int");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v24, resolved type: byte} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x006b  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0087 A[LOOP:0: B:1:0x0009->B:34:0x0087, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0086 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static int k(androidx.media3.common.util.ParsableBitArray r13, int[] r14, @androidx.annotation.Nullable byte[] r15, int r16, int r17, @androidx.annotation.Nullable android.graphics.Paint r18, android.graphics.Canvas r19) {
        /*
            r0 = r13
            r1 = r17
            r8 = r18
            r9 = 0
            r10 = r16
            r2 = 0
        L_0x0009:
            r3 = 4
            int r4 = r13.h(r3)
            r5 = 1
            if (r4 == 0) goto L_0x0014
            r11 = r2
        L_0x0012:
            r12 = 1
            goto L_0x0065
        L_0x0014:
            boolean r4 = r13.g()
            r6 = 3
            if (r4 != 0) goto L_0x002b
            int r3 = r13.h(r6)
            if (r3 == 0) goto L_0x0027
            int r3 = r3 + 2
            r11 = r2
            r12 = r3
            r4 = 0
            goto L_0x0065
        L_0x0027:
            r4 = 0
            r11 = 1
        L_0x0029:
            r12 = 0
            goto L_0x0065
        L_0x002b:
            boolean r4 = r13.g()
            r7 = 2
            if (r4 != 0) goto L_0x003f
            int r4 = r13.h(r7)
            int r4 = r4 + r3
        L_0x0037:
            int r3 = r13.h(r3)
            r11 = r2
            r12 = r4
            r4 = r3
            goto L_0x0065
        L_0x003f:
            int r4 = r13.h(r7)
            if (r4 == 0) goto L_0x0062
            if (r4 == r5) goto L_0x005e
            if (r4 == r7) goto L_0x0057
            if (r4 == r6) goto L_0x004e
            r11 = r2
            r4 = 0
            goto L_0x0029
        L_0x004e:
            r4 = 8
            int r4 = r13.h(r4)
            int r4 = r4 + 25
            goto L_0x0037
        L_0x0057:
            int r4 = r13.h(r3)
            int r4 = r4 + 9
            goto L_0x0037
        L_0x005e:
            r11 = r2
            r4 = 0
            r12 = 2
            goto L_0x0065
        L_0x0062:
            r11 = r2
            r4 = 0
            goto L_0x0012
        L_0x0065:
            if (r12 == 0) goto L_0x0083
            if (r8 == 0) goto L_0x0083
            if (r15 == 0) goto L_0x006d
            byte r4 = r15[r4]
        L_0x006d:
            r2 = r14[r4]
            r8.setColor(r2)
            float r3 = (float) r10
            float r4 = (float) r1
            int r2 = r10 + r12
            float r6 = (float) r2
            int r2 = r1 + 1
            float r7 = (float) r2
            r2 = r19
            r5 = r6
            r6 = r7
            r7 = r18
            r2.drawRect(r3, r4, r5, r6, r7)
        L_0x0083:
            int r10 = r10 + r12
            if (r11 == 0) goto L_0x0087
            return r10
        L_0x0087:
            r2 = r11
            goto L_0x0009
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.extractor.text.dvb.DvbParser.k(androidx.media3.common.util.ParsableBitArray, int[], byte[], int, int, android.graphics.Paint, android.graphics.Canvas):int");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v10, resolved type: byte} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static int l(androidx.media3.common.util.ParsableBitArray r13, int[] r14, @androidx.annotation.Nullable byte[] r15, int r16, int r17, @androidx.annotation.Nullable android.graphics.Paint r18, android.graphics.Canvas r19) {
        /*
            r0 = r13
            r1 = r17
            r8 = r18
            r9 = 0
            r10 = r16
            r2 = 0
        L_0x0009:
            r3 = 8
            int r4 = r13.h(r3)
            r5 = 1
            if (r4 == 0) goto L_0x0015
            r11 = r2
            r12 = 1
            goto L_0x0035
        L_0x0015:
            boolean r4 = r13.g()
            r6 = 7
            if (r4 != 0) goto L_0x002a
            int r3 = r13.h(r6)
            if (r3 == 0) goto L_0x0026
            r11 = r2
            r12 = r3
            r4 = 0
            goto L_0x0035
        L_0x0026:
            r4 = 0
            r11 = 1
            r12 = 0
            goto L_0x0035
        L_0x002a:
            int r4 = r13.h(r6)
            int r3 = r13.h(r3)
            r11 = r2
            r12 = r4
            r4 = r3
        L_0x0035:
            if (r12 == 0) goto L_0x0053
            if (r8 == 0) goto L_0x0053
            if (r15 == 0) goto L_0x003d
            byte r4 = r15[r4]
        L_0x003d:
            r2 = r14[r4]
            r8.setColor(r2)
            float r3 = (float) r10
            float r4 = (float) r1
            int r2 = r10 + r12
            float r6 = (float) r2
            int r2 = r1 + 1
            float r7 = (float) r2
            r2 = r19
            r5 = r6
            r6 = r7
            r7 = r18
            r2.drawRect(r3, r4, r5, r6, r7)
        L_0x0053:
            int r10 = r10 + r12
            if (r11 == 0) goto L_0x0057
            return r10
        L_0x0057:
            r2 = r11
            goto L_0x0009
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.extractor.text.dvb.DvbParser.l(androidx.media3.common.util.ParsableBitArray, int[], byte[], int, int, android.graphics.Paint, android.graphics.Canvas):int");
    }

    private static void m(byte[] bArr, int[] iArr, int i2, int i3, int i4, @Nullable Paint paint, Canvas canvas) {
        byte[] bArr2;
        byte[] bArr3;
        byte[] bArr4;
        int i5 = i2;
        byte[] bArr5 = bArr;
        ParsableBitArray parsableBitArray = new ParsableBitArray(bArr);
        int i6 = i3;
        int i7 = i4;
        byte[] bArr6 = null;
        byte[] bArr7 = null;
        byte[] bArr8 = null;
        while (parsableBitArray.b() != 0) {
            int h2 = parsableBitArray.h(8);
            if (h2 != 240) {
                switch (h2) {
                    case 16:
                        if (i5 != 3) {
                            if (i5 != 2) {
                                bArr2 = null;
                                i6 = j(parsableBitArray, iArr, bArr2, i6, i7, paint, canvas);
                                break;
                            } else {
                                bArr3 = bArr8 == null ? A : bArr8;
                            }
                        } else {
                            bArr3 = bArr6 == null ? B : bArr6;
                        }
                        bArr2 = bArr3;
                        i6 = j(parsableBitArray, iArr, bArr2, i6, i7, paint, canvas);
                    case 17:
                        if (i5 == 3) {
                            bArr4 = bArr7 == null ? C : bArr7;
                        } else {
                            bArr4 = null;
                        }
                        i6 = k(parsableBitArray, iArr, bArr4, i6, i7, paint, canvas);
                        break;
                    case 18:
                        i6 = l(parsableBitArray, iArr, (byte[]) null, i6, i7, paint, canvas);
                        continue;
                    default:
                        switch (h2) {
                            case 32:
                                bArr8 = e(4, 4, parsableBitArray);
                                break;
                            case 33:
                                bArr6 = e(4, 8, parsableBitArray);
                                break;
                            case 34:
                                bArr7 = e(16, 8, parsableBitArray);
                                break;
                            default:
                                continue;
                        }
                }
                parsableBitArray.c();
            } else {
                i7 += 2;
                i6 = i3;
            }
        }
    }

    private static void n(ObjectData objectData, ClutDefinition clutDefinition, int i2, int i3, int i4, @Nullable Paint paint, Canvas canvas) {
        int[] iArr = i2 == 3 ? clutDefinition.f13873d : i2 == 2 ? clutDefinition.f13872c : clutDefinition.f13871b;
        int i5 = i2;
        int i6 = i3;
        Paint paint2 = paint;
        Canvas canvas2 = canvas;
        m(objectData.f13882c, iArr, i5, i6, i4, paint2, canvas2);
        m(objectData.f13883d, iArr, i5, i6, i4 + 1, paint2, canvas2);
    }

    private CuesWithTiming o(ParsableBitArray parsableBitArray) {
        int i2;
        SparseArray<RegionObject> sparseArray;
        ParsableBitArray parsableBitArray2 = parsableBitArray;
        while (parsableBitArray.b() >= 48 && parsableBitArray2.h(8) == 15) {
            u(parsableBitArray2, this.f13868f);
        }
        SubtitleService subtitleService = this.f13868f;
        PageComposition pageComposition = subtitleService.f13915i;
        if (pageComposition == null) {
            return new CuesWithTiming(ImmutableList.I(), C.f9084b, C.f9084b);
        }
        DisplayDefinition displayDefinition = subtitleService.f13914h;
        if (displayDefinition == null) {
            displayDefinition = this.f13866d;
        }
        Bitmap bitmap = this.f13869g;
        if (!(bitmap != null && displayDefinition.f13874a + 1 == bitmap.getWidth() && displayDefinition.f13875b + 1 == this.f13869g.getHeight())) {
            Bitmap createBitmap = Bitmap.createBitmap(displayDefinition.f13874a + 1, displayDefinition.f13875b + 1, Bitmap.Config.ARGB_8888);
            this.f13869g = createBitmap;
            this.f13865c.setBitmap(createBitmap);
        }
        ArrayList arrayList = new ArrayList();
        SparseArray<PageRegion> sparseArray2 = pageComposition.f13887d;
        for (int i3 = 0; i3 < sparseArray2.size(); i3++) {
            this.f13865c.save();
            PageRegion valueAt = sparseArray2.valueAt(i3);
            RegionComposition regionComposition = this.f13868f.f13909c.get(sparseArray2.keyAt(i3));
            int i4 = valueAt.f13888a + displayDefinition.f13876c;
            int i5 = valueAt.f13889b + displayDefinition.f13878e;
            this.f13865c.clipRect(i4, i5, Math.min(regionComposition.f13892c + i4, displayDefinition.f13877d), Math.min(regionComposition.f13893d + i5, displayDefinition.f13879f));
            ClutDefinition clutDefinition = this.f13868f.f13910d.get(regionComposition.f13896g);
            if (clutDefinition == null && (clutDefinition = this.f13868f.f13912f.get(regionComposition.f13896g)) == null) {
                clutDefinition = this.f13867e;
            }
            SparseArray<RegionObject> sparseArray3 = regionComposition.f13900k;
            int i6 = 0;
            while (i6 < sparseArray3.size()) {
                int keyAt = sparseArray3.keyAt(i6);
                RegionObject valueAt2 = sparseArray3.valueAt(i6);
                ObjectData objectData = this.f13868f.f13911e.get(keyAt);
                ObjectData objectData2 = objectData == null ? this.f13868f.f13913g.get(keyAt) : objectData;
                if (objectData2 != null) {
                    i2 = i6;
                    sparseArray = sparseArray3;
                    n(objectData2, clutDefinition, regionComposition.f13895f, valueAt2.f13903c + i4, i5 + valueAt2.f13904d, objectData2.f13881b ? null : this.f13863a, this.f13865c);
                } else {
                    i2 = i6;
                    sparseArray = sparseArray3;
                }
                i6 = i2 + 1;
                sparseArray3 = sparseArray;
            }
            if (regionComposition.f13891b) {
                int i7 = regionComposition.f13895f;
                this.f13864b.setColor(i7 == 3 ? clutDefinition.f13873d[regionComposition.f13897h] : i7 == 2 ? clutDefinition.f13872c[regionComposition.f13898i] : clutDefinition.f13871b[regionComposition.f13899j]);
                this.f13865c.drawRect((float) i4, (float) i5, (float) (regionComposition.f13892c + i4), (float) (regionComposition.f13893d + i5), this.f13864b);
            }
            arrayList.add(new Cue.Builder().r(Bitmap.createBitmap(this.f13869g, i4, i5, regionComposition.f13892c, regionComposition.f13893d)).w(((float) i4) / ((float) displayDefinition.f13874a)).x(0).t(((float) i5) / ((float) displayDefinition.f13875b), 0).u(0).z(((float) regionComposition.f13892c) / ((float) displayDefinition.f13874a)).s(((float) regionComposition.f13893d) / ((float) displayDefinition.f13875b)).a());
            this.f13865c.drawColor(0, PorterDuff.Mode.CLEAR);
            this.f13865c.restore();
        }
        return new CuesWithTiming(arrayList, C.f9084b, C.f9084b);
    }

    private static ClutDefinition p(ParsableBitArray parsableBitArray, int i2) {
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        ParsableBitArray parsableBitArray2 = parsableBitArray;
        int i8 = 8;
        int h2 = parsableBitArray2.h(8);
        parsableBitArray2.s(8);
        int i9 = 2;
        int i10 = i2 - 2;
        int[] f2 = f();
        int[] g2 = g();
        int[] h3 = h();
        while (i10 > 0) {
            int h4 = parsableBitArray2.h(i8);
            int h5 = parsableBitArray2.h(i8);
            int[] iArr = (h5 & 128) != 0 ? f2 : (h5 & 64) != 0 ? g2 : h3;
            if ((h5 & 1) != 0) {
                i6 = parsableBitArray2.h(i8);
                i5 = parsableBitArray2.h(i8);
                i4 = parsableBitArray2.h(i8);
                i3 = parsableBitArray2.h(i8);
                i7 = i10 - 6;
            } else {
                i4 = parsableBitArray2.h(4) << 4;
                i7 = i10 - 4;
                int h6 = parsableBitArray2.h(4) << 4;
                i3 = parsableBitArray2.h(i9) << 6;
                i6 = parsableBitArray2.h(6) << i9;
                i5 = h6;
            }
            if (i6 == 0) {
                i5 = 0;
                i4 = 0;
                i3 = 255;
            }
            double d2 = (double) i6;
            double d3 = (double) (i5 - 128);
            double d4 = (double) (i4 - 128);
            iArr[h4] = i((byte) (255 - (i3 & 255)), Util.w((int) (d2 + (1.402d * d3)), 0, 255), Util.w((int) ((d2 - (0.34414d * d4)) - (d3 * 0.71414d)), 0, 255), Util.w((int) (d2 + (d4 * 1.772d)), 0, 255));
            i10 = i7;
            h2 = h2;
            i8 = 8;
            i9 = 2;
        }
        return new ClutDefinition(h2, f2, g2, h3);
    }

    private static DisplayDefinition q(ParsableBitArray parsableBitArray) {
        int i2;
        int i3;
        int i4;
        int i5;
        parsableBitArray.s(4);
        boolean g2 = parsableBitArray.g();
        parsableBitArray.s(3);
        int h2 = parsableBitArray.h(16);
        int h3 = parsableBitArray.h(16);
        if (g2) {
            int h4 = parsableBitArray.h(16);
            int h5 = parsableBitArray.h(16);
            int h6 = parsableBitArray.h(16);
            i2 = parsableBitArray.h(16);
            i4 = h5;
            i3 = h6;
            i5 = h4;
        } else {
            i4 = h2;
            i2 = h3;
            i5 = 0;
            i3 = 0;
        }
        return new DisplayDefinition(h2, h3, i5, i4, i3, i2);
    }

    private static ObjectData r(ParsableBitArray parsableBitArray) {
        byte[] bArr;
        int h2 = parsableBitArray.h(16);
        parsableBitArray.s(4);
        int h3 = parsableBitArray.h(2);
        boolean g2 = parsableBitArray.g();
        parsableBitArray.s(1);
        byte[] bArr2 = Util.f9651f;
        if (h3 == 1) {
            parsableBitArray.s(parsableBitArray.h(8) * 16);
        } else if (h3 == 0) {
            int h4 = parsableBitArray.h(16);
            int h5 = parsableBitArray.h(16);
            if (h4 > 0) {
                bArr2 = new byte[h4];
                parsableBitArray.k(bArr2, 0, h4);
            }
            if (h5 > 0) {
                bArr = new byte[h5];
                parsableBitArray.k(bArr, 0, h5);
                return new ObjectData(h2, g2, bArr2, bArr);
            }
        }
        bArr = bArr2;
        return new ObjectData(h2, g2, bArr2, bArr);
    }

    private static PageComposition s(ParsableBitArray parsableBitArray, int i2) {
        int h2 = parsableBitArray.h(8);
        int h3 = parsableBitArray.h(4);
        int h4 = parsableBitArray.h(2);
        parsableBitArray.s(2);
        int i3 = i2 - 2;
        SparseArray sparseArray = new SparseArray();
        while (i3 > 0) {
            int h5 = parsableBitArray.h(8);
            parsableBitArray.s(8);
            i3 -= 6;
            sparseArray.put(h5, new PageRegion(parsableBitArray.h(16), parsableBitArray.h(16)));
        }
        return new PageComposition(h2, h3, h4, sparseArray);
    }

    private static RegionComposition t(ParsableBitArray parsableBitArray, int i2) {
        int i3;
        int i4;
        ParsableBitArray parsableBitArray2 = parsableBitArray;
        int h2 = parsableBitArray2.h(8);
        parsableBitArray2.s(4);
        boolean g2 = parsableBitArray.g();
        parsableBitArray2.s(3);
        int i5 = 16;
        int h3 = parsableBitArray2.h(16);
        int h4 = parsableBitArray2.h(16);
        int h5 = parsableBitArray2.h(3);
        int h6 = parsableBitArray2.h(3);
        int i6 = 2;
        parsableBitArray2.s(2);
        int h7 = parsableBitArray2.h(8);
        int h8 = parsableBitArray2.h(8);
        int h9 = parsableBitArray2.h(4);
        int h10 = parsableBitArray2.h(2);
        parsableBitArray2.s(2);
        int i7 = i2 - 10;
        SparseArray sparseArray = new SparseArray();
        while (i7 > 0) {
            int h11 = parsableBitArray2.h(i5);
            int h12 = parsableBitArray2.h(i6);
            int h13 = parsableBitArray2.h(i6);
            int h14 = parsableBitArray2.h(12);
            int i8 = h10;
            parsableBitArray2.s(4);
            int h15 = parsableBitArray2.h(12);
            int i9 = i7 - 6;
            if (h12 != 1) {
                if (h12 != 2) {
                    i7 = i9;
                    i4 = 0;
                    i3 = 0;
                    sparseArray.put(h11, new RegionObject(h12, h13, h14, h15, i4, i3));
                    h10 = i8;
                    i6 = 2;
                    i5 = 16;
                }
            }
            i7 -= 8;
            i4 = parsableBitArray2.h(8);
            i3 = parsableBitArray2.h(8);
            sparseArray.put(h11, new RegionObject(h12, h13, h14, h15, i4, i3));
            h10 = i8;
            i6 = 2;
            i5 = 16;
        }
        return new RegionComposition(h2, g2, h3, h4, h5, h6, h7, h8, h9, h10, sparseArray);
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0049, code lost:
        r7.put(r1, r0);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void u(androidx.media3.common.util.ParsableBitArray r6, androidx.media3.extractor.text.dvb.DvbParser.SubtitleService r7) {
        /*
            r0 = 8
            int r0 = r6.h(r0)
            r1 = 16
            int r2 = r6.h(r1)
            int r1 = r6.h(r1)
            int r3 = r6.d()
            int r3 = r3 + r1
            int r4 = r1 * 8
            int r5 = r6.b()
            if (r4 <= r5) goto L_0x002c
            java.lang.String r7 = "DvbParser"
            java.lang.String r0 = "Data field length exceeds limit"
            androidx.media3.common.util.Log.n(r7, r0)
            int r7 = r6.b()
            r6.s(r7)
            return
        L_0x002c:
            switch(r0) {
                case 16: goto L_0x0098;
                case 17: goto L_0x0071;
                case 18: goto L_0x0059;
                case 19: goto L_0x003d;
                case 20: goto L_0x0031;
                default: goto L_0x002f;
            }
        L_0x002f:
            goto L_0x00c2
        L_0x0031:
            int r0 = r7.f13907a
            if (r2 != r0) goto L_0x00c2
            androidx.media3.extractor.text.dvb.DvbParser$DisplayDefinition r0 = q(r6)
            r7.f13914h = r0
            goto L_0x00c2
        L_0x003d:
            int r0 = r7.f13907a
            if (r2 != r0) goto L_0x004e
            androidx.media3.extractor.text.dvb.DvbParser$ObjectData r0 = r(r6)
            android.util.SparseArray<androidx.media3.extractor.text.dvb.DvbParser$ObjectData> r7 = r7.f13911e
        L_0x0047:
            int r1 = r0.f13880a
        L_0x0049:
            r7.put(r1, r0)
            goto L_0x00c2
        L_0x004e:
            int r0 = r7.f13908b
            if (r2 != r0) goto L_0x00c2
            androidx.media3.extractor.text.dvb.DvbParser$ObjectData r0 = r(r6)
            android.util.SparseArray<androidx.media3.extractor.text.dvb.DvbParser$ObjectData> r7 = r7.f13913g
            goto L_0x0047
        L_0x0059:
            int r0 = r7.f13907a
            if (r2 != r0) goto L_0x0066
            androidx.media3.extractor.text.dvb.DvbParser$ClutDefinition r0 = p(r6, r1)
            android.util.SparseArray<androidx.media3.extractor.text.dvb.DvbParser$ClutDefinition> r7 = r7.f13910d
        L_0x0063:
            int r1 = r0.f13870a
            goto L_0x0049
        L_0x0066:
            int r0 = r7.f13908b
            if (r2 != r0) goto L_0x00c2
            androidx.media3.extractor.text.dvb.DvbParser$ClutDefinition r0 = p(r6, r1)
            android.util.SparseArray<androidx.media3.extractor.text.dvb.DvbParser$ClutDefinition> r7 = r7.f13912f
            goto L_0x0063
        L_0x0071:
            androidx.media3.extractor.text.dvb.DvbParser$PageComposition r0 = r7.f13915i
            int r4 = r7.f13907a
            if (r2 != r4) goto L_0x00c2
            if (r0 == 0) goto L_0x00c2
            androidx.media3.extractor.text.dvb.DvbParser$RegionComposition r1 = t(r6, r1)
            int r0 = r0.f13886c
            if (r0 != 0) goto L_0x0090
            android.util.SparseArray<androidx.media3.extractor.text.dvb.DvbParser$RegionComposition> r0 = r7.f13909c
            int r2 = r1.f13890a
            java.lang.Object r0 = r0.get(r2)
            androidx.media3.extractor.text.dvb.DvbParser$RegionComposition r0 = (androidx.media3.extractor.text.dvb.DvbParser.RegionComposition) r0
            if (r0 == 0) goto L_0x0090
            r1.a(r0)
        L_0x0090:
            android.util.SparseArray<androidx.media3.extractor.text.dvb.DvbParser$RegionComposition> r7 = r7.f13909c
            int r0 = r1.f13890a
            r7.put(r0, r1)
            goto L_0x00c2
        L_0x0098:
            int r0 = r7.f13907a
            if (r2 != r0) goto L_0x00c2
            androidx.media3.extractor.text.dvb.DvbParser$PageComposition r0 = r7.f13915i
            androidx.media3.extractor.text.dvb.DvbParser$PageComposition r1 = s(r6, r1)
            int r2 = r1.f13886c
            if (r2 == 0) goto L_0x00b8
            r7.f13915i = r1
            android.util.SparseArray<androidx.media3.extractor.text.dvb.DvbParser$RegionComposition> r0 = r7.f13909c
            r0.clear()
            android.util.SparseArray<androidx.media3.extractor.text.dvb.DvbParser$ClutDefinition> r0 = r7.f13910d
            r0.clear()
            android.util.SparseArray<androidx.media3.extractor.text.dvb.DvbParser$ObjectData> r7 = r7.f13911e
            r7.clear()
            goto L_0x00c2
        L_0x00b8:
            if (r0 == 0) goto L_0x00c2
            int r0 = r0.f13885b
            int r2 = r1.f13885b
            if (r0 == r2) goto L_0x00c2
            r7.f13915i = r1
        L_0x00c2:
            int r7 = r6.d()
            int r3 = r3 - r7
            r6.t(r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.extractor.text.dvb.DvbParser.u(androidx.media3.common.util.ParsableBitArray, androidx.media3.extractor.text.dvb.DvbParser$SubtitleService):void");
    }

    public void a(byte[] bArr, int i2, int i3, SubtitleParser.OutputOptions outputOptions, Consumer<CuesWithTiming> consumer) {
        ParsableBitArray parsableBitArray = new ParsableBitArray(bArr, i3 + i2);
        parsableBitArray.q(i2);
        consumer.accept(o(parsableBitArray));
    }

    public /* synthetic */ Subtitle b(byte[] bArr, int i2, int i3) {
        return e.b(this, bArr, i2, i3);
    }

    public /* synthetic */ void c(byte[] bArr, SubtitleParser.OutputOptions outputOptions, Consumer consumer) {
        e.a(this, bArr, outputOptions, consumer);
    }

    public int d() {
        return 2;
    }

    public void reset() {
        this.f13868f.a();
    }
}
