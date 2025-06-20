package androidx.media3.exoplayer.video;

import android.content.Context;
import android.graphics.Bitmap;
import android.media.MediaFormat;
import android.os.Handler;
import android.os.Looper;
import android.util.Pair;
import android.view.Surface;
import androidx.annotation.FloatRange;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.media3.common.C;
import androidx.media3.common.ColorInfo;
import androidx.media3.common.DebugViewProvider;
import androidx.media3.common.Effect;
import androidx.media3.common.Format;
import androidx.media3.common.FrameInfo;
import androidx.media3.common.MimeTypes;
import androidx.media3.common.PreviewingVideoGraph;
import androidx.media3.common.SurfaceInfo;
import androidx.media3.common.VideoFrameProcessingException;
import androidx.media3.common.VideoFrameProcessor;
import androidx.media3.common.VideoGraph;
import androidx.media3.common.VideoSize;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Clock;
import androidx.media3.common.util.HandlerWrapper;
import androidx.media3.common.util.Size;
import androidx.media3.common.util.TimestampIterator;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;
import androidx.media3.exoplayer.ExoPlaybackException;
import androidx.media3.exoplayer.video.VideoFrameRenderControl;
import androidx.media3.exoplayer.video.VideoSink;
import com.google.common.base.Supplier;
import com.google.common.base.Suppliers;
import com.google.common.collect.ImmutableList;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.Executor;
import org.checkerframework.checker.nullness.qual.EnsuresNonNull;

@UnstableApi
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public final class CompositingVideoSinkProvider implements VideoSinkProvider, VideoGraph.Listener, VideoFrameRenderControl.FrameRenderer {
    private static final int q = 0;
    private static final int r = 1;
    private static final int s = 2;
    private static final Executor t = new f();

    /* renamed from: a  reason: collision with root package name */
    private final Context f12716a;

    /* renamed from: b  reason: collision with root package name */
    private final PreviewingVideoGraph.Factory f12717b;

    /* renamed from: c  reason: collision with root package name */
    private Clock f12718c;

    /* renamed from: d  reason: collision with root package name */
    private VideoFrameReleaseControl f12719d;

    /* renamed from: e  reason: collision with root package name */
    private VideoFrameRenderControl f12720e;

    /* renamed from: f  reason: collision with root package name */
    private Format f12721f;

    /* renamed from: g  reason: collision with root package name */
    private VideoFrameMetadataListener f12722g;

    /* renamed from: h  reason: collision with root package name */
    private HandlerWrapper f12723h;

    /* renamed from: i  reason: collision with root package name */
    private PreviewingVideoGraph f12724i;

    /* renamed from: j  reason: collision with root package name */
    private VideoSinkImpl f12725j;

    /* renamed from: k  reason: collision with root package name */
    private List<Effect> f12726k;
    @Nullable

    /* renamed from: l  reason: collision with root package name */
    private Pair<Surface, Size> f12727l;

    /* renamed from: m  reason: collision with root package name */
    private VideoSink.Listener f12728m;

    /* renamed from: n  reason: collision with root package name */
    private Executor f12729n;
    private int o;
    private int p;

    public static final class Builder {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public final Context f12730a;

        /* renamed from: b  reason: collision with root package name */
        private VideoFrameProcessor.Factory f12731b;
        /* access modifiers changed from: private */

        /* renamed from: c  reason: collision with root package name */
        public PreviewingVideoGraph.Factory f12732c;

        /* renamed from: d  reason: collision with root package name */
        private boolean f12733d;

        public Builder(Context context) {
            this.f12730a = context;
        }

        public CompositingVideoSinkProvider c() {
            Assertions.i(!this.f12733d);
            if (this.f12732c == null) {
                if (this.f12731b == null) {
                    this.f12731b = new ReflectiveDefaultVideoFrameProcessorFactory();
                }
                this.f12732c = new ReflectivePreviewingSingleInputVideoGraphFactory(this.f12731b);
            }
            CompositingVideoSinkProvider compositingVideoSinkProvider = new CompositingVideoSinkProvider(this);
            this.f12733d = true;
            return compositingVideoSinkProvider;
        }

        public Builder d(PreviewingVideoGraph.Factory factory) {
            this.f12732c = factory;
            return this;
        }

        public Builder e(VideoFrameProcessor.Factory factory) {
            this.f12731b = factory;
            return this;
        }
    }

    private static final class ReflectiveDefaultVideoFrameProcessorFactory implements VideoFrameProcessor.Factory {

        /* renamed from: a  reason: collision with root package name */
        private static final Supplier<VideoFrameProcessor.Factory> f12734a = Suppliers.b(new h());

        private ReflectiveDefaultVideoFrameProcessorFactory() {
        }

        /* access modifiers changed from: private */
        public static /* synthetic */ VideoFrameProcessor.Factory c() {
            try {
                Class<?> cls = Class.forName("androidx.media3.effect.DefaultVideoFrameProcessor$Factory$Builder");
                return (VideoFrameProcessor.Factory) Assertions.g(cls.getMethod("build", (Class[]) null).invoke(cls.getConstructor((Class[]) null).newInstance((Object[]) null), (Object[]) null));
            } catch (Exception e2) {
                throw new IllegalStateException(e2);
            }
        }

        public VideoFrameProcessor a(Context context, DebugViewProvider debugViewProvider, ColorInfo colorInfo, boolean z, Executor executor, VideoFrameProcessor.Listener listener) throws VideoFrameProcessingException {
            return f12734a.get().a(context, debugViewProvider, colorInfo, z, executor, listener);
        }
    }

    private static final class ReflectivePreviewingSingleInputVideoGraphFactory implements PreviewingVideoGraph.Factory {

        /* renamed from: a  reason: collision with root package name */
        private final VideoFrameProcessor.Factory f12735a;

        public ReflectivePreviewingSingleInputVideoGraphFactory(VideoFrameProcessor.Factory factory) {
            this.f12735a = factory;
        }

        public PreviewingVideoGraph a(Context context, ColorInfo colorInfo, ColorInfo colorInfo2, DebugViewProvider debugViewProvider, VideoGraph.Listener listener, Executor executor, List<Effect> list, long j2) throws VideoFrameProcessingException {
            try {
                try {
                    return ((PreviewingVideoGraph.Factory) Class.forName("androidx.media3.effect.PreviewingSingleInputVideoGraph$Factory").getConstructor(new Class[]{VideoFrameProcessor.Factory.class}).newInstance(new Object[]{this.f12735a})).a(context, colorInfo, colorInfo2, debugViewProvider, listener, executor, list, j2);
                } catch (Exception e2) {
                    e = e2;
                    throw VideoFrameProcessingException.a(e);
                }
            } catch (Exception e3) {
                e = e3;
                throw VideoFrameProcessingException.a(e);
            }
        }
    }

    private static final class VideoSinkImpl implements VideoSink {

        /* renamed from: c  reason: collision with root package name */
        private final Context f12736c;

        /* renamed from: d  reason: collision with root package name */
        private final CompositingVideoSinkProvider f12737d;

        /* renamed from: e  reason: collision with root package name */
        private final VideoFrameProcessor f12738e;

        /* renamed from: f  reason: collision with root package name */
        private final int f12739f;

        /* renamed from: g  reason: collision with root package name */
        private final ArrayList<Effect> f12740g = new ArrayList<>();
        @Nullable

        /* renamed from: h  reason: collision with root package name */
        private Effect f12741h;
        /* access modifiers changed from: private */
        @Nullable

        /* renamed from: i  reason: collision with root package name */
        public Format f12742i;

        /* renamed from: j  reason: collision with root package name */
        private int f12743j;

        /* renamed from: k  reason: collision with root package name */
        private long f12744k;

        /* renamed from: l  reason: collision with root package name */
        private boolean f12745l;

        /* renamed from: m  reason: collision with root package name */
        private long f12746m = C.f9084b;

        /* renamed from: n  reason: collision with root package name */
        private long f12747n = C.f9084b;
        private boolean o;
        private long p;

        private static final class ScaleAndRotateAccessor {

            /* renamed from: a  reason: collision with root package name */
            private static Constructor<?> f12748a;

            /* renamed from: b  reason: collision with root package name */
            private static Method f12749b;

            /* renamed from: c  reason: collision with root package name */
            private static Method f12750c;

            private ScaleAndRotateAccessor() {
            }

            public static Effect a(float f2) {
                try {
                    b();
                    Object newInstance = f12748a.newInstance((Object[]) null);
                    f12749b.invoke(newInstance, new Object[]{Float.valueOf(f2)});
                    return (Effect) Assertions.g(f12750c.invoke(newInstance, (Object[]) null));
                } catch (Exception e2) {
                    throw new IllegalStateException(e2);
                }
            }

            @EnsuresNonNull({"scaleAndRotateTransformationBuilderConstructor", "setRotationMethod", "buildScaleAndRotateTransformationMethod"})
            private static void b() throws NoSuchMethodException, ClassNotFoundException {
                if (f12748a == null || f12749b == null || f12750c == null) {
                    Class<?> cls = Class.forName("androidx.media3.effect.ScaleAndRotateTransformation$Builder");
                    f12748a = cls.getConstructor((Class[]) null);
                    f12749b = cls.getMethod("setRotationDegrees", new Class[]{Float.TYPE});
                    f12750c = cls.getMethod("build", (Class[]) null);
                }
            }
        }

        public VideoSinkImpl(Context context, CompositingVideoSinkProvider compositingVideoSinkProvider, PreviewingVideoGraph previewingVideoGraph) throws VideoFrameProcessingException {
            this.f12736c = context;
            this.f12737d = compositingVideoSinkProvider;
            this.f12739f = Util.z0(context);
            this.f12738e = previewingVideoGraph.e(previewingVideoGraph.g());
        }

        private void k() {
            if (this.f12742i != null) {
                ArrayList arrayList = new ArrayList();
                Effect effect = this.f12741h;
                if (effect != null) {
                    arrayList.add(effect);
                }
                arrayList.addAll(this.f12740g);
                Format format = (Format) Assertions.g(this.f12742i);
                this.f12738e.f(this.f12743j, arrayList, new FrameInfo.Builder(CompositingVideoSinkProvider.I(format.r3), format.k3, format.l3).e(format.o3).a());
            }
        }

        public boolean a(Bitmap bitmap, TimestampIterator timestampIterator) {
            return ((VideoFrameProcessor) Assertions.k(this.f12738e)).k(bitmap, timestampIterator);
        }

        public Surface b() {
            return this.f12738e.b();
        }

        public boolean c() {
            long j2 = this.f12746m;
            return j2 != C.f9084b && this.f12737d.L(j2);
        }

        public boolean d() {
            return this.f12737d.M();
        }

        public long e(long j2, boolean z) {
            Assertions.i(this.f12739f != -1);
            long j3 = this.p;
            if (j3 != C.f9084b) {
                if (!this.f12737d.L(j3)) {
                    return C.f9084b;
                }
                k();
                this.p = C.f9084b;
            }
            if (this.f12738e.j() >= this.f12739f || !this.f12738e.h()) {
                return C.f9084b;
            }
            long j4 = this.f12744k;
            long j5 = j2 + j4;
            if (this.f12745l) {
                this.f12737d.T(j5, j4);
                this.f12745l = false;
            }
            this.f12747n = j5;
            if (z) {
                this.f12746m = j5;
            }
            return j5 * 1000;
        }

        /* JADX WARNING: Removed duplicated region for block: B:23:0x0050  */
        /* JADX WARNING: Removed duplicated region for block: B:24:0x0058  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void f(int r5, androidx.media3.common.Format r6) {
            /*
                r4 = this;
                r0 = 1
                if (r5 == r0) goto L_0x001e
                r1 = 2
                if (r5 != r1) goto L_0x0007
                goto L_0x001e
            L_0x0007:
                java.lang.UnsupportedOperationException r6 = new java.lang.UnsupportedOperationException
                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                r0.<init>()
                java.lang.String r1 = "Unsupported input type "
                r0.append(r1)
                r0.append(r5)
                java.lang.String r5 = r0.toString()
                r6.<init>(r5)
                throw r6
            L_0x001e:
                if (r5 != r0) goto L_0x0041
                int r1 = androidx.media3.common.util.Util.f9646a
                r2 = 21
                if (r1 >= r2) goto L_0x0041
                int r1 = r6.n3
                r2 = -1
                if (r1 == r2) goto L_0x0041
                if (r1 == 0) goto L_0x0041
                androidx.media3.common.Effect r2 = r4.f12741h
                if (r2 == 0) goto L_0x0039
                androidx.media3.common.Format r2 = r4.f12742i
                if (r2 == 0) goto L_0x0039
                int r2 = r2.n3
                if (r2 == r1) goto L_0x0043
            L_0x0039:
                float r1 = (float) r1
                androidx.media3.common.Effect r1 = androidx.media3.exoplayer.video.CompositingVideoSinkProvider.VideoSinkImpl.ScaleAndRotateAccessor.a(r1)
            L_0x003e:
                r4.f12741h = r1
                goto L_0x0043
            L_0x0041:
                r1 = 0
                goto L_0x003e
            L_0x0043:
                r4.f12743j = r5
                r4.f12742i = r6
                boolean r5 = r4.o
                r1 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
                if (r5 != 0) goto L_0x0058
                r4.k()
                r4.o = r0
                r4.p = r1
                goto L_0x0067
            L_0x0058:
                long r5 = r4.f12747n
                int r3 = (r5 > r1 ? 1 : (r5 == r1 ? 0 : -1))
                if (r3 == 0) goto L_0x005f
                goto L_0x0060
            L_0x005f:
                r0 = 0
            L_0x0060:
                androidx.media3.common.util.Assertions.i(r0)
                long r5 = r4.f12747n
                r4.p = r5
            L_0x0067:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.media3.exoplayer.video.CompositingVideoSinkProvider.VideoSinkImpl.f(int, androidx.media3.common.Format):void");
        }

        public void flush() {
            this.f12738e.flush();
            this.o = false;
            this.f12746m = C.f9084b;
            this.f12747n = C.f9084b;
            this.f12737d.G();
        }

        public void g(long j2, long j3) throws VideoSink.VideoSinkException {
            try {
                this.f12737d.U(j2, j3);
            } catch (ExoPlaybackException e2) {
                Format format = this.f12742i;
                if (format == null) {
                    format = new Format.Builder().I();
                }
                throw new VideoSink.VideoSinkException(e2, format);
            }
        }

        public boolean h() {
            return Util.j1(this.f12736c);
        }

        public void i(VideoSink.Listener listener, Executor executor) {
            this.f12737d.V(listener, executor);
        }

        public void l(List<Effect> list) {
            this.f12740g.clear();
            this.f12740g.addAll(list);
        }

        public void m(@FloatRange(from = 0.0d, fromInclusive = false) float f2) {
            this.f12737d.W(f2);
        }

        public void n(long j2) {
            this.f12745l = this.f12744k != j2;
            this.f12744k = j2;
        }

        public void o(List<Effect> list) {
            l(list);
            k();
        }
    }

    private CompositingVideoSinkProvider(Builder builder) {
        this.f12716a = builder.f12730a;
        this.f12717b = (PreviewingVideoGraph.Factory) Assertions.k(builder.f12732c);
        this.f12718c = Clock.f9502a;
        this.f12728m = VideoSink.Listener.f12818a;
        this.f12729n = t;
        this.p = 0;
    }

    /* access modifiers changed from: private */
    public void G() {
        this.o++;
        ((VideoFrameRenderControl) Assertions.k(this.f12720e)).b();
        ((HandlerWrapper) Assertions.k(this.f12723h)).e(new g(this));
    }

    /* access modifiers changed from: private */
    public void H() {
        int i2 = this.o - 1;
        this.o = i2;
        if (i2 <= 0) {
            if (i2 >= 0) {
                ((VideoFrameRenderControl) Assertions.k(this.f12720e)).b();
                return;
            }
            throw new IllegalStateException(String.valueOf(this.o));
        }
    }

    /* access modifiers changed from: private */
    public static ColorInfo I(@Nullable ColorInfo colorInfo) {
        return (colorInfo == null || !ColorInfo.k(colorInfo)) ? ColorInfo.a3 : colorInfo;
    }

    /* access modifiers changed from: private */
    public boolean L(long j2) {
        return this.o == 0 && ((VideoFrameRenderControl) Assertions.k(this.f12720e)).d(j2);
    }

    /* access modifiers changed from: private */
    public boolean M() {
        return this.o == 0 && ((VideoFrameRenderControl) Assertions.k(this.f12720e)).e();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void N(VideoSink.Listener listener) {
        listener.d((VideoSink) Assertions.k(this.f12725j));
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void O(VideoSink.Listener listener, VideoFrameProcessingException videoFrameProcessingException) {
        VideoSinkImpl videoSinkImpl = (VideoSinkImpl) Assertions.k(this.f12725j);
        listener.c(videoSinkImpl, new VideoSink.VideoSinkException(videoFrameProcessingException, (Format) Assertions.k(videoSinkImpl.f12742i)));
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void R(Runnable runnable) {
    }

    private void S(@Nullable Surface surface, int i2, int i3) {
        if (this.f12724i != null) {
            this.f12724i.c(surface != null ? new SurfaceInfo(surface, i2, i3) : null);
            ((VideoFrameReleaseControl) Assertions.g(this.f12719d)).q(surface);
        }
    }

    /* access modifiers changed from: private */
    public void T(long j2, long j3) {
        ((VideoFrameRenderControl) Assertions.k(this.f12720e)).j(j2, j3);
    }

    /* access modifiers changed from: private */
    public void V(VideoSink.Listener listener, Executor executor) {
        if (Objects.equals(listener, this.f12728m)) {
            Assertions.i(Objects.equals(executor, this.f12729n));
            return;
        }
        this.f12728m = listener;
        this.f12729n = executor;
    }

    /* access modifiers changed from: private */
    public void W(float f2) {
        ((VideoFrameRenderControl) Assertions.k(this.f12720e)).m(f2);
    }

    @Nullable
    public Surface J() {
        Pair<Surface, Size> pair = this.f12727l;
        if (pair != null) {
            return (Surface) pair.first;
        }
        return null;
    }

    public void K(List<Effect> list) {
        this.f12726k = list;
        if (m()) {
            ((VideoSinkImpl) Assertions.k(this.f12725j)).o(list);
        }
    }

    public void U(long j2, long j3) throws ExoPlaybackException {
        if (this.o == 0) {
            ((VideoFrameRenderControl) Assertions.k(this.f12720e)).k(j2, j3);
        }
    }

    public void a() {
        if (this.p != 2) {
            HandlerWrapper handlerWrapper = this.f12723h;
            if (handlerWrapper != null) {
                handlerWrapper.n((Object) null);
            }
            PreviewingVideoGraph previewingVideoGraph = this.f12724i;
            if (previewingVideoGraph != null) {
                previewingVideoGraph.a();
            }
            this.f12727l = null;
            this.p = 2;
        }
    }

    public void b(VideoFrameMetadataListener videoFrameMetadataListener) {
        this.f12722g = videoFrameMetadataListener;
    }

    public void c(VideoSize videoSize) {
        this.f12721f = new Format.Builder().r0(videoSize.s).V(videoSize.X).k0(MimeTypes.C).I();
        this.f12729n.execute(new b(this.f12728m, (VideoSinkImpl) Assertions.k(this.f12725j), videoSize));
    }

    public void d(int i2, int i3) {
        ((VideoFrameRenderControl) Assertions.k(this.f12720e)).i(i2, i3);
    }

    public void e(VideoFrameProcessingException videoFrameProcessingException) {
        this.f12729n.execute(new e(this, this.f12728m, videoFrameProcessingException));
    }

    public void f(long j2) {
        if (this.o <= 0) {
            ((VideoFrameRenderControl) Assertions.k(this.f12720e)).h(j2);
        }
    }

    public void g(long j2, long j3, long j4, boolean z) {
        if (z && this.f12729n != t) {
            this.f12729n.execute(new a(this.f12728m, (VideoSinkImpl) Assertions.k(this.f12725j)));
        }
        if (this.f12722g != null) {
            Format format = this.f12721f;
            if (format == null) {
                format = new Format.Builder().I();
            }
            this.f12722g.j(j3 - j4, this.f12718c.c(), format, (MediaFormat) null);
        }
        ((PreviewingVideoGraph) Assertions.k(this.f12724i)).d(j2);
    }

    public void h(Surface surface, Size size) {
        Pair<Surface, Size> pair = this.f12727l;
        if (pair == null || !((Surface) pair.first).equals(surface) || !((Size) this.f12727l.second).equals(size)) {
            this.f12727l = Pair.create(surface, size);
            S(surface, size.b(), size.a());
        }
    }

    public void i(Clock clock) {
        Assertions.i(!m());
        this.f12718c = clock;
    }

    public void j(VideoFrameReleaseControl videoFrameReleaseControl) {
        Assertions.i(!m());
        this.f12719d = videoFrameReleaseControl;
        this.f12720e = new VideoFrameRenderControl(this, videoFrameReleaseControl);
    }

    public void k() {
        this.f12729n.execute(new c(this, this.f12728m));
        ((PreviewingVideoGraph) Assertions.k(this.f12724i)).d(-2);
    }

    public void l(long j2) {
        throw new UnsupportedOperationException();
    }

    public boolean m() {
        return this.p == 1;
    }

    public void n() {
        Size size = Size.f9620c;
        S((Surface) null, size.b(), size.a());
        this.f12727l = null;
    }

    @Nullable
    public VideoFrameReleaseControl o() {
        return this.f12719d;
    }

    public VideoSink p() {
        return (VideoSink) Assertions.k(this.f12725j);
    }

    public void q(List<Effect> list) {
        this.f12726k = list;
        if (m()) {
            ((VideoSinkImpl) Assertions.k(this.f12725j)).l(list);
        }
    }

    public void r(long j2) {
        ((VideoSinkImpl) Assertions.k(this.f12725j)).n(j2);
    }

    public void s(Format format) throws VideoSink.VideoSinkException {
        boolean z = false;
        Assertions.i(this.p == 0);
        Assertions.k(this.f12726k);
        if (!(this.f12720e == null || this.f12719d == null)) {
            z = true;
        }
        Assertions.i(z);
        this.f12723h = this.f12718c.e((Looper) Assertions.k(Looper.myLooper()), (Handler.Callback) null);
        ColorInfo I = I(format.r3);
        ColorInfo a2 = I.Y == 7 ? I.b().e(6).a() : I;
        try {
            PreviewingVideoGraph.Factory factory = this.f12717b;
            Context context = this.f12716a;
            DebugViewProvider debugViewProvider = DebugViewProvider.f9103a;
            HandlerWrapper handlerWrapper = this.f12723h;
            Objects.requireNonNull(handlerWrapper);
            this.f12724i = factory.a(context, I, a2, debugViewProvider, this, new d(handlerWrapper), ImmutableList.I(), 0);
            Pair<Surface, Size> pair = this.f12727l;
            if (pair != null) {
                Size size = (Size) pair.second;
                S((Surface) pair.first, size.b(), size.a());
            }
            VideoSinkImpl videoSinkImpl = new VideoSinkImpl(this.f12716a, this, this.f12724i);
            this.f12725j = videoSinkImpl;
            videoSinkImpl.o((List) Assertions.g(this.f12726k));
            this.p = 1;
        } catch (VideoFrameProcessingException e2) {
            throw new VideoSink.VideoSinkException(e2, format);
        }
    }
}
