package androidx.media3.extractor;

import android.net.Uri;
import androidx.annotation.GuardedBy;
import androidx.annotation.Nullable;
import androidx.media3.common.FileTypes;
import androidx.media3.common.Format;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.extractor.avi.AviExtractor;
import androidx.media3.extractor.mkv.MatroskaExtractor;
import androidx.media3.extractor.mp4.FragmentedMp4Extractor;
import androidx.media3.extractor.mp4.Mp4Extractor;
import androidx.media3.extractor.text.DefaultSubtitleParserFactory;
import androidx.media3.extractor.text.SubtitleParser;
import androidx.media3.extractor.text.SubtitleTranscodingExtractor;
import androidx.media3.extractor.ts.TsExtractor;
import com.google.common.collect.ImmutableList;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

@UnstableApi
public final class DefaultExtractorsFactory implements ExtractorsFactory {
    private static final int[] r = {5, 4, 12, 8, 3, 10, 9, 11, 6, 2, 0, 1, 7, 16, 15, 14, 17, 18, 19, 20};
    private static final ExtensionLoader s = new ExtensionLoader(new b());
    private static final ExtensionLoader t = new ExtensionLoader(new c());

    /* renamed from: b  reason: collision with root package name */
    private boolean f12996b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f12997c;

    /* renamed from: d  reason: collision with root package name */
    private int f12998d;

    /* renamed from: e  reason: collision with root package name */
    private int f12999e;

    /* renamed from: f  reason: collision with root package name */
    private int f13000f;

    /* renamed from: g  reason: collision with root package name */
    private int f13001g;

    /* renamed from: h  reason: collision with root package name */
    private int f13002h;

    /* renamed from: i  reason: collision with root package name */
    private int f13003i;

    /* renamed from: j  reason: collision with root package name */
    private int f13004j;

    /* renamed from: k  reason: collision with root package name */
    private int f13005k = 1;

    /* renamed from: l  reason: collision with root package name */
    private int f13006l;
    @Nullable

    /* renamed from: m  reason: collision with root package name */
    private ImmutableList<Format> f13007m;

    /* renamed from: n  reason: collision with root package name */
    private int f13008n = TsExtractor.E;
    private boolean o;
    private SubtitleParser.Factory p = new DefaultSubtitleParserFactory();
    private int q;

    private static final class ExtensionLoader {

        /* renamed from: a  reason: collision with root package name */
        private final ConstructorSupplier f13009a;

        /* renamed from: b  reason: collision with root package name */
        private final AtomicBoolean f13010b = new AtomicBoolean(false);
        @GuardedBy("extensionLoaded")
        @Nullable

        /* renamed from: c  reason: collision with root package name */
        private Constructor<? extends Extractor> f13011c;

        public interface ConstructorSupplier {
            @Nullable
            Constructor<? extends Extractor> a() throws InvocationTargetException, IllegalAccessException, NoSuchMethodException, ClassNotFoundException;
        }

        public ExtensionLoader(ConstructorSupplier constructorSupplier) {
            this.f13009a = constructorSupplier;
        }

        @Nullable
        private Constructor<? extends Extractor> b() {
            synchronized (this.f13010b) {
                if (this.f13010b.get()) {
                    Constructor<? extends Extractor> constructor = this.f13011c;
                    return constructor;
                }
                try {
                    Constructor<? extends Extractor> a2 = this.f13009a.a();
                    return a2;
                } catch (ClassNotFoundException unused) {
                    this.f13010b.set(true);
                    return this.f13011c;
                } catch (Exception e2) {
                    throw new RuntimeException("Error instantiating extension", e2);
                }
            }
        }

        @Nullable
        public Extractor a(Object... objArr) {
            Constructor<? extends Extractor> b2 = b();
            if (b2 == null) {
                return null;
            }
            try {
                return (Extractor) b2.newInstance(objArr);
            } catch (Exception e2) {
                throw new IllegalStateException("Unexpected error creating extractor", e2);
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v1, resolved type: androidx.media3.extractor.ts.Ac3Extractor} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v2, resolved type: androidx.media3.extractor.ts.Ac4Extractor} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v3, resolved type: androidx.media3.extractor.ts.AdtsExtractor} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v4, resolved type: androidx.media3.extractor.amr.AmrExtractor} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v6, resolved type: androidx.media3.extractor.Extractor} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v7, resolved type: androidx.media3.extractor.flac.FlacExtractor} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v8, resolved type: androidx.media3.extractor.flv.FlvExtractor} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v9, resolved type: androidx.media3.extractor.mkv.MatroskaExtractor} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v10, resolved type: androidx.media3.extractor.mp3.Mp3Extractor} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v12, resolved type: androidx.media3.extractor.mp4.Mp4Extractor} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v13, resolved type: androidx.media3.extractor.ogg.OggExtractor} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v14, resolved type: androidx.media3.extractor.ts.PsExtractor} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v18, resolved type: androidx.media3.extractor.wav.WavExtractor} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v19, resolved type: androidx.media3.extractor.jpeg.JpegExtractor} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v21, resolved type: androidx.media3.extractor.Extractor} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v22, resolved type: androidx.media3.extractor.avi.AviExtractor} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v23, resolved type: androidx.media3.extractor.png.PngExtractor} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v24, resolved type: androidx.media3.extractor.webp.WebpExtractor} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v25, resolved type: androidx.media3.extractor.bmp.BmpExtractor} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v26, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v29, resolved type: androidx.media3.extractor.heif.HeifExtractor} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v30, resolved type: androidx.media3.extractor.ts.TsExtractor} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v31, resolved type: androidx.media3.extractor.ts.TsExtractor} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v32, resolved type: androidx.media3.extractor.ts.TsExtractor} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v33, resolved type: androidx.media3.extractor.ts.TsExtractor} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v34, resolved type: androidx.media3.extractor.ts.TsExtractor} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v35, resolved type: androidx.media3.extractor.ts.TsExtractor} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v36, resolved type: androidx.media3.extractor.ts.TsExtractor} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v37, resolved type: androidx.media3.extractor.ts.TsExtractor} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v38, resolved type: androidx.media3.extractor.ts.TsExtractor} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v39, resolved type: androidx.media3.extractor.ts.TsExtractor} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v40, resolved type: androidx.media3.extractor.ts.TsExtractor} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v41, resolved type: androidx.media3.extractor.ts.TsExtractor} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v21, resolved type: androidx.media3.extractor.ts.TsExtractor} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v42, resolved type: androidx.media3.extractor.ts.TsExtractor} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v43, resolved type: androidx.media3.extractor.ts.TsExtractor} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v44, resolved type: androidx.media3.extractor.ts.TsExtractor} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v45, resolved type: androidx.media3.extractor.ts.TsExtractor} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v46, resolved type: androidx.media3.extractor.ts.TsExtractor} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v47, resolved type: androidx.media3.extractor.ts.TsExtractor} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v48, resolved type: androidx.media3.extractor.ts.TsExtractor} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v49, resolved type: androidx.media3.extractor.ts.TsExtractor} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void g(int r9, java.util.List<androidx.media3.extractor.Extractor> r10) {
        /*
            r8 = this;
            r0 = 1
            r1 = 2
            r2 = 0
            switch(r9) {
                case 0: goto L_0x0126;
                case 1: goto L_0x011f;
                case 2: goto L_0x010c;
                case 3: goto L_0x00f9;
                case 4: goto L_0x00dc;
                case 5: goto L_0x00d5;
                case 6: goto L_0x00c4;
                case 7: goto L_0x00b1;
                case 8: goto L_0x0089;
                case 9: goto L_0x0083;
                case 10: goto L_0x007d;
                case 11: goto L_0x0052;
                case 12: goto L_0x004c;
                case 13: goto L_0x0006;
                case 14: goto L_0x0044;
                case 15: goto L_0x0039;
                case 16: goto L_0x002e;
                case 17: goto L_0x0028;
                case 18: goto L_0x0022;
                case 19: goto L_0x001c;
                case 20: goto L_0x0008;
                default: goto L_0x0006;
            }
        L_0x0006:
            goto L_0x012d
        L_0x0008:
            int r9 = r8.f13002h
            r0 = r9 & 2
            if (r0 != 0) goto L_0x012d
            r9 = r9 & 4
            if (r9 != 0) goto L_0x012d
            androidx.media3.extractor.heif.HeifExtractor r9 = new androidx.media3.extractor.heif.HeifExtractor
            r9.<init>()
        L_0x0017:
            r10.add(r9)
            goto L_0x012d
        L_0x001c:
            androidx.media3.extractor.bmp.BmpExtractor r9 = new androidx.media3.extractor.bmp.BmpExtractor
            r9.<init>()
            goto L_0x0017
        L_0x0022:
            androidx.media3.extractor.webp.WebpExtractor r9 = new androidx.media3.extractor.webp.WebpExtractor
            r9.<init>()
            goto L_0x0017
        L_0x0028:
            androidx.media3.extractor.png.PngExtractor r9 = new androidx.media3.extractor.png.PngExtractor
            r9.<init>()
            goto L_0x0017
        L_0x002e:
            androidx.media3.extractor.avi.AviExtractor r9 = new androidx.media3.extractor.avi.AviExtractor
            boolean r1 = r8.o
            r0 = r0 ^ r1
            androidx.media3.extractor.text.SubtitleParser$Factory r1 = r8.p
            r9.<init>(r0, r1)
            goto L_0x0017
        L_0x0039:
            androidx.media3.extractor.DefaultExtractorsFactory$ExtensionLoader r9 = t
            java.lang.Object[] r0 = new java.lang.Object[r2]
            androidx.media3.extractor.Extractor r9 = r9.a(r0)
            if (r9 == 0) goto L_0x012d
        L_0x0043:
            goto L_0x0017
        L_0x0044:
            androidx.media3.extractor.jpeg.JpegExtractor r9 = new androidx.media3.extractor.jpeg.JpegExtractor
            int r0 = r8.q
            r9.<init>(r0)
            goto L_0x0017
        L_0x004c:
            androidx.media3.extractor.wav.WavExtractor r9 = new androidx.media3.extractor.wav.WavExtractor
            r9.<init>()
            goto L_0x0017
        L_0x0052:
            com.google.common.collect.ImmutableList<androidx.media3.common.Format> r9 = r8.f13007m
            if (r9 != 0) goto L_0x005c
            com.google.common.collect.ImmutableList r9 = com.google.common.collect.ImmutableList.I()
            r8.f13007m = r9
        L_0x005c:
            androidx.media3.extractor.ts.TsExtractor r9 = new androidx.media3.extractor.ts.TsExtractor
            int r2 = r8.f13005k
            boolean r1 = r8.o
            r3 = r1 ^ 1
            androidx.media3.extractor.text.SubtitleParser$Factory r4 = r8.p
            androidx.media3.common.util.TimestampAdjuster r5 = new androidx.media3.common.util.TimestampAdjuster
            r0 = 0
            r5.<init>(r0)
            androidx.media3.extractor.ts.DefaultTsPayloadReaderFactory r6 = new androidx.media3.extractor.ts.DefaultTsPayloadReaderFactory
            int r0 = r8.f13006l
            com.google.common.collect.ImmutableList<androidx.media3.common.Format> r1 = r8.f13007m
            r6.<init>(r0, r1)
            int r7 = r8.f13008n
            r1 = r9
            r1.<init>(r2, r3, r4, r5, r6, r7)
            goto L_0x0017
        L_0x007d:
            androidx.media3.extractor.ts.PsExtractor r9 = new androidx.media3.extractor.ts.PsExtractor
            r9.<init>()
            goto L_0x0017
        L_0x0083:
            androidx.media3.extractor.ogg.OggExtractor r9 = new androidx.media3.extractor.ogg.OggExtractor
            r9.<init>()
            goto L_0x0017
        L_0x0089:
            androidx.media3.extractor.mp4.FragmentedMp4Extractor r9 = new androidx.media3.extractor.mp4.FragmentedMp4Extractor
            androidx.media3.extractor.text.SubtitleParser$Factory r0 = r8.p
            int r1 = r8.f13003i
            boolean r3 = r8.o
            if (r3 == 0) goto L_0x0095
            r3 = 0
            goto L_0x0097
        L_0x0095:
            r3 = 32
        L_0x0097:
            r1 = r1 | r3
            r9.<init>((androidx.media3.extractor.text.SubtitleParser.Factory) r0, (int) r1)
            r10.add(r9)
            androidx.media3.extractor.mp4.Mp4Extractor r9 = new androidx.media3.extractor.mp4.Mp4Extractor
            androidx.media3.extractor.text.SubtitleParser$Factory r0 = r8.p
            int r1 = r8.f13002h
            boolean r3 = r8.o
            if (r3 == 0) goto L_0x00a9
            goto L_0x00ab
        L_0x00a9:
            r2 = 16
        L_0x00ab:
            r1 = r1 | r2
            r9.<init>(r0, r1)
            goto L_0x0017
        L_0x00b1:
            androidx.media3.extractor.mp3.Mp3Extractor r9 = new androidx.media3.extractor.mp3.Mp3Extractor
            int r0 = r8.f13004j
            boolean r3 = r8.f12996b
            r0 = r0 | r3
            boolean r3 = r8.f12997c
            if (r3 == 0) goto L_0x00bd
            goto L_0x00be
        L_0x00bd:
            r1 = 0
        L_0x00be:
            r0 = r0 | r1
            r9.<init>(r0)
            goto L_0x0017
        L_0x00c4:
            androidx.media3.extractor.mkv.MatroskaExtractor r9 = new androidx.media3.extractor.mkv.MatroskaExtractor
            androidx.media3.extractor.text.SubtitleParser$Factory r0 = r8.p
            int r3 = r8.f13001g
            boolean r4 = r8.o
            if (r4 == 0) goto L_0x00cf
            r1 = 0
        L_0x00cf:
            r1 = r1 | r3
            r9.<init>(r0, r1)
            goto L_0x0017
        L_0x00d5:
            androidx.media3.extractor.flv.FlvExtractor r9 = new androidx.media3.extractor.flv.FlvExtractor
            r9.<init>()
            goto L_0x0017
        L_0x00dc:
            androidx.media3.extractor.DefaultExtractorsFactory$ExtensionLoader r9 = s
            int r1 = r8.f13000f
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            java.lang.Object[] r0 = new java.lang.Object[r0]
            r0[r2] = r1
            androidx.media3.extractor.Extractor r9 = r9.a(r0)
            if (r9 == 0) goto L_0x00f0
            goto L_0x0043
        L_0x00f0:
            androidx.media3.extractor.flac.FlacExtractor r9 = new androidx.media3.extractor.flac.FlacExtractor
            int r0 = r8.f13000f
            r9.<init>(r0)
            goto L_0x0017
        L_0x00f9:
            androidx.media3.extractor.amr.AmrExtractor r9 = new androidx.media3.extractor.amr.AmrExtractor
            int r0 = r8.f12999e
            boolean r3 = r8.f12996b
            r0 = r0 | r3
            boolean r3 = r8.f12997c
            if (r3 == 0) goto L_0x0105
            goto L_0x0106
        L_0x0105:
            r1 = 0
        L_0x0106:
            r0 = r0 | r1
            r9.<init>(r0)
            goto L_0x0017
        L_0x010c:
            androidx.media3.extractor.ts.AdtsExtractor r9 = new androidx.media3.extractor.ts.AdtsExtractor
            int r0 = r8.f12998d
            boolean r3 = r8.f12996b
            r0 = r0 | r3
            boolean r3 = r8.f12997c
            if (r3 == 0) goto L_0x0118
            goto L_0x0119
        L_0x0118:
            r1 = 0
        L_0x0119:
            r0 = r0 | r1
            r9.<init>(r0)
            goto L_0x0017
        L_0x011f:
            androidx.media3.extractor.ts.Ac4Extractor r9 = new androidx.media3.extractor.ts.Ac4Extractor
            r9.<init>()
            goto L_0x0017
        L_0x0126:
            androidx.media3.extractor.ts.Ac3Extractor r9 = new androidx.media3.extractor.ts.Ac3Extractor
            r9.<init>()
            goto L_0x0017
        L_0x012d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.extractor.DefaultExtractorsFactory.g(int, java.util.List):void");
    }

    /* access modifiers changed from: private */
    @Nullable
    public static Constructor<? extends Extractor> i() throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        if (!Boolean.TRUE.equals(Class.forName("androidx.media3.decoder.flac.FlacLibrary").getMethod("isAvailable", (Class[]) null).invoke((Object) null, (Object[]) null))) {
            return null;
        }
        return Class.forName("androidx.media3.decoder.flac.FlacExtractor").asSubclass(Extractor.class).getConstructor(new Class[]{Integer.TYPE});
    }

    /* access modifiers changed from: private */
    public static Constructor<? extends Extractor> j() throws ClassNotFoundException, NoSuchMethodException {
        return Class.forName("androidx.media3.decoder.midi.MidiExtractor").asSubclass(Extractor.class).getConstructor((Class[]) null);
    }

    public synchronized Extractor[] b() {
        return d(Uri.EMPTY, new HashMap());
    }

    public synchronized Extractor[] d(Uri uri, Map<String, List<String>> map) {
        Extractor[] extractorArr;
        try {
            int[] iArr = r;
            ArrayList arrayList = new ArrayList(iArr.length);
            int b2 = FileTypes.b(map);
            if (b2 != -1) {
                g(b2, arrayList);
            }
            int c2 = FileTypes.c(uri);
            if (!(c2 == -1 || c2 == b2)) {
                g(c2, arrayList);
            }
            for (int i2 : iArr) {
                if (!(i2 == b2 || i2 == c2)) {
                    g(i2, arrayList);
                }
            }
            extractorArr = new Extractor[arrayList.size()];
            for (int i3 = 0; i3 < arrayList.size(); i3++) {
                Extractor extractor = (Extractor) arrayList.get(i3);
                if (this.o && !(extractor.e() instanceof FragmentedMp4Extractor) && !(extractor.e() instanceof Mp4Extractor) && !(extractor.e() instanceof TsExtractor) && !(extractor.e() instanceof AviExtractor) && !(extractor.e() instanceof MatroskaExtractor)) {
                    extractor = new SubtitleTranscodingExtractor(extractor, this.p);
                }
                extractorArr[i3] = extractor;
            }
        } catch (Throwable th) {
            while (true) {
                throw th;
            }
        }
        return extractorArr;
    }

    /* renamed from: h */
    public synchronized DefaultExtractorsFactory c(boolean z) {
        this.o = z;
        return this;
    }

    @CanIgnoreReturnValue
    public synchronized DefaultExtractorsFactory k(int i2) {
        this.f12998d = i2;
        return this;
    }

    @CanIgnoreReturnValue
    public synchronized DefaultExtractorsFactory l(int i2) {
        this.f12999e = i2;
        return this;
    }

    @CanIgnoreReturnValue
    public synchronized DefaultExtractorsFactory m(boolean z) {
        this.f12997c = z;
        return this;
    }

    @CanIgnoreReturnValue
    public synchronized DefaultExtractorsFactory n(boolean z) {
        this.f12996b = z;
        return this;
    }

    @CanIgnoreReturnValue
    public synchronized DefaultExtractorsFactory o(int i2) {
        this.f13000f = i2;
        return this;
    }

    @CanIgnoreReturnValue
    public synchronized DefaultExtractorsFactory p(int i2) {
        this.f13003i = i2;
        return this;
    }

    @CanIgnoreReturnValue
    public synchronized DefaultExtractorsFactory q(int i2) {
        this.q = i2;
        return this;
    }

    @CanIgnoreReturnValue
    public synchronized DefaultExtractorsFactory r(int i2) {
        this.f13001g = i2;
        return this;
    }

    @CanIgnoreReturnValue
    public synchronized DefaultExtractorsFactory s(int i2) {
        this.f13004j = i2;
        return this;
    }

    @CanIgnoreReturnValue
    public synchronized DefaultExtractorsFactory t(int i2) {
        this.f13002h = i2;
        return this;
    }

    @CanIgnoreReturnValue
    /* renamed from: u */
    public synchronized DefaultExtractorsFactory a(SubtitleParser.Factory factory) {
        this.p = factory;
        return this;
    }

    @CanIgnoreReturnValue
    @Deprecated
    public synchronized DefaultExtractorsFactory v(boolean z) {
        return c(z);
    }

    @CanIgnoreReturnValue
    public synchronized DefaultExtractorsFactory w(int i2) {
        this.f13006l = i2;
        return this;
    }

    @CanIgnoreReturnValue
    public synchronized DefaultExtractorsFactory x(int i2) {
        this.f13005k = i2;
        return this;
    }

    @CanIgnoreReturnValue
    public synchronized DefaultExtractorsFactory y(int i2) {
        this.f13008n = i2;
        return this;
    }

    @CanIgnoreReturnValue
    public synchronized DefaultExtractorsFactory z(List<Format> list) {
        this.f13007m = ImmutableList.B(list);
        return this;
    }
}
