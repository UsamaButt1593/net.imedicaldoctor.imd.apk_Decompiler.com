package androidx.media3.exoplayer;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import androidx.annotation.Nullable;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.exoplayer.audio.AudioRendererEventListener;
import androidx.media3.exoplayer.audio.AudioSink;
import androidx.media3.exoplayer.audio.DefaultAudioSink;
import androidx.media3.exoplayer.image.ImageDecoder;
import androidx.media3.exoplayer.image.ImageOutput;
import androidx.media3.exoplayer.image.ImageRenderer;
import androidx.media3.exoplayer.mediacodec.DefaultMediaCodecAdapterFactory;
import androidx.media3.exoplayer.mediacodec.MediaCodecAdapter;
import androidx.media3.exoplayer.mediacodec.MediaCodecSelector;
import androidx.media3.exoplayer.metadata.MetadataOutput;
import androidx.media3.exoplayer.metadata.MetadataRenderer;
import androidx.media3.exoplayer.text.TextOutput;
import androidx.media3.exoplayer.text.TextRenderer;
import androidx.media3.exoplayer.video.VideoRendererEventListener;
import androidx.media3.exoplayer.video.spherical.CameraMotionRenderer;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.ArrayList;

@UnstableApi
public class DefaultRenderersFactory implements RenderersFactory {

    /* renamed from: i  reason: collision with root package name */
    public static final long f10168i = 5000;

    /* renamed from: j  reason: collision with root package name */
    public static final int f10169j = 0;

    /* renamed from: k  reason: collision with root package name */
    public static final int f10170k = 1;

    /* renamed from: l  reason: collision with root package name */
    public static final int f10171l = 2;

    /* renamed from: m  reason: collision with root package name */
    public static final int f10172m = 50;

    /* renamed from: n  reason: collision with root package name */
    private static final String f10173n = "DefaultRenderersFactory";

    /* renamed from: a  reason: collision with root package name */
    private final Context f10174a;

    /* renamed from: b  reason: collision with root package name */
    private final DefaultMediaCodecAdapterFactory f10175b;

    /* renamed from: c  reason: collision with root package name */
    private int f10176c = 0;

    /* renamed from: d  reason: collision with root package name */
    private long f10177d = 5000;

    /* renamed from: e  reason: collision with root package name */
    private boolean f10178e;

    /* renamed from: f  reason: collision with root package name */
    private MediaCodecSelector f10179f = MediaCodecSelector.f11713a;

    /* renamed from: g  reason: collision with root package name */
    private boolean f10180g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f10181h;

    @Documented
    @Target({ElementType.TYPE_USE})
    @Retention(RetentionPolicy.SOURCE)
    public @interface ExtensionRendererMode {
    }

    public DefaultRenderersFactory(Context context) {
        this.f10174a = context;
        this.f10175b = new DefaultMediaCodecAdapterFactory(context);
    }

    public Renderer[] a(Handler handler, VideoRendererEventListener videoRendererEventListener, AudioRendererEventListener audioRendererEventListener, TextOutput textOutput, MetadataOutput metadataOutput) {
        ArrayList arrayList = new ArrayList();
        i(this.f10174a, this.f10176c, this.f10179f, this.f10178e, handler, videoRendererEventListener, this.f10177d, arrayList);
        AudioSink c2 = c(this.f10174a, this.f10180g, this.f10181h);
        if (c2 != null) {
            b(this.f10174a, this.f10176c, this.f10179f, this.f10178e, c2, handler, audioRendererEventListener, arrayList);
        }
        ArrayList arrayList2 = arrayList;
        h(this.f10174a, textOutput, handler.getLooper(), this.f10176c, arrayList2);
        f(this.f10174a, metadataOutput, handler.getLooper(), this.f10176c, arrayList2);
        d(this.f10174a, this.f10176c, arrayList);
        e(arrayList);
        Handler handler2 = handler;
        g(this.f10174a, handler, this.f10176c, arrayList);
        return (Renderer[]) arrayList.toArray(new Renderer[0]);
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x005d, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0061, code lost:
        r3 = r17;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0064, code lost:
        r3 = r17;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x006e, code lost:
        throw new java.lang.RuntimeException("Error instantiating MIDI extension", r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x009c, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x009e, code lost:
        r2 = r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x00a7, code lost:
        throw new java.lang.RuntimeException("Error instantiating Opus extension", r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x00d5, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x00d7, code lost:
        r1 = r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x00e0, code lost:
        throw new java.lang.RuntimeException("Error instantiating FLAC extension", r0);
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x005d A[ExcHandler: Exception (r0v23 'e' java.lang.Exception A[CUSTOM_DECLARE]), Splitter:B:7:0x0038] */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x009c A[ExcHandler: Exception (r0v17 'e' java.lang.Exception A[CUSTOM_DECLARE]), Splitter:B:26:0x0072] */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x00d5 A[ExcHandler: Exception (r0v11 'e' java.lang.Exception A[CUSTOM_DECLARE]), Splitter:B:39:0x00ab] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void b(android.content.Context r19, int r20, androidx.media3.exoplayer.mediacodec.MediaCodecSelector r21, boolean r22, androidx.media3.exoplayer.audio.AudioSink r23, android.os.Handler r24, androidx.media3.exoplayer.audio.AudioRendererEventListener r25, java.util.ArrayList<androidx.media3.exoplayer.Renderer> r26) {
        /*
            r18 = this;
            r0 = r20
            r9 = r26
            r11 = 2
            r12 = 0
            r13 = 1
            java.lang.Class<androidx.media3.exoplayer.audio.AudioSink> r14 = androidx.media3.exoplayer.audio.AudioSink.class
            java.lang.Class<androidx.media3.exoplayer.audio.AudioRendererEventListener> r15 = androidx.media3.exoplayer.audio.AudioRendererEventListener.class
            java.lang.Class<android.os.Handler> r16 = android.os.Handler.class
            java.lang.String r8 = "DefaultRenderersFactory"
            androidx.media3.exoplayer.audio.MediaCodecAudioRenderer r7 = new androidx.media3.exoplayer.audio.MediaCodecAudioRenderer
            androidx.media3.exoplayer.mediacodec.MediaCodecAdapter$Factory r3 = r18.m()
            r1 = r7
            r2 = r19
            r4 = r21
            r5 = r22
            r6 = r24
            r10 = r7
            r7 = r25
            r17 = r8
            r8 = r23
            r1.<init>(r2, r3, r4, r5, r6, r7, r8)
            r9.add(r10)
            if (r0 != 0) goto L_0x002e
            return
        L_0x002e:
            int r1 = r26.size()
            if (r0 != r11) goto L_0x0036
            int r1 = r1 + -1
        L_0x0036:
            java.lang.String r0 = "androidx.media3.decoder.midi.MidiRenderer"
            java.lang.Class r0 = java.lang.Class.forName(r0)     // Catch:{ ClassNotFoundException -> 0x0064, Exception -> 0x005d }
            java.lang.Class[] r2 = new java.lang.Class[r13]     // Catch:{ ClassNotFoundException -> 0x0064, Exception -> 0x005d }
            java.lang.Class<android.content.Context> r3 = android.content.Context.class
            r2[r12] = r3     // Catch:{ ClassNotFoundException -> 0x0064, Exception -> 0x005d }
            java.lang.reflect.Constructor r0 = r0.getConstructor(r2)     // Catch:{ ClassNotFoundException -> 0x0064, Exception -> 0x005d }
            java.lang.Object[] r2 = new java.lang.Object[r13]     // Catch:{ ClassNotFoundException -> 0x0064, Exception -> 0x005d }
            r2[r12] = r19     // Catch:{ ClassNotFoundException -> 0x0064, Exception -> 0x005d }
            java.lang.Object r0 = r0.newInstance(r2)     // Catch:{ ClassNotFoundException -> 0x0064, Exception -> 0x005d }
            androidx.media3.exoplayer.Renderer r0 = (androidx.media3.exoplayer.Renderer) r0     // Catch:{ ClassNotFoundException -> 0x0064, Exception -> 0x005d }
            int r2 = r1 + 1
            r9.add(r1, r0)     // Catch:{ ClassNotFoundException -> 0x0061, Exception -> 0x005d }
            java.lang.String r0 = "Loaded MidiRenderer."
            r3 = r17
            androidx.media3.common.util.Log.h(r3, r0)     // Catch:{ ClassNotFoundException -> 0x005f, Exception -> 0x005d }
            goto L_0x0070
        L_0x005d:
            r0 = move-exception
            goto L_0x0067
        L_0x005f:
            r1 = r2
            goto L_0x006f
        L_0x0061:
            r3 = r17
            goto L_0x005f
        L_0x0064:
            r3 = r17
            goto L_0x006f
        L_0x0067:
            java.lang.RuntimeException r1 = new java.lang.RuntimeException
            java.lang.String r2 = "Error instantiating MIDI extension"
            r1.<init>(r2, r0)
            throw r1
        L_0x006f:
            r2 = r1
        L_0x0070:
            java.lang.String r0 = "androidx.media3.decoder.opus.LibopusAudioRenderer"
            java.lang.Class r0 = java.lang.Class.forName(r0)     // Catch:{ ClassNotFoundException -> 0x00a8, Exception -> 0x009c }
            r1 = 3
            java.lang.Class[] r4 = new java.lang.Class[r1]     // Catch:{ ClassNotFoundException -> 0x00a8, Exception -> 0x009c }
            r4[r12] = r16     // Catch:{ ClassNotFoundException -> 0x00a8, Exception -> 0x009c }
            r4[r13] = r15     // Catch:{ ClassNotFoundException -> 0x00a8, Exception -> 0x009c }
            r4[r11] = r14     // Catch:{ ClassNotFoundException -> 0x00a8, Exception -> 0x009c }
            java.lang.reflect.Constructor r0 = r0.getConstructor(r4)     // Catch:{ ClassNotFoundException -> 0x00a8, Exception -> 0x009c }
            java.lang.Object[] r4 = new java.lang.Object[r1]     // Catch:{ ClassNotFoundException -> 0x00a8, Exception -> 0x009c }
            r4[r12] = r24     // Catch:{ ClassNotFoundException -> 0x00a8, Exception -> 0x009c }
            r4[r13] = r25     // Catch:{ ClassNotFoundException -> 0x00a8, Exception -> 0x009c }
            r4[r11] = r23     // Catch:{ ClassNotFoundException -> 0x00a8, Exception -> 0x009c }
            java.lang.Object r0 = r0.newInstance(r4)     // Catch:{ ClassNotFoundException -> 0x00a8, Exception -> 0x009c }
            androidx.media3.exoplayer.Renderer r0 = (androidx.media3.exoplayer.Renderer) r0     // Catch:{ ClassNotFoundException -> 0x00a8, Exception -> 0x009c }
            int r1 = r2 + 1
            r9.add(r2, r0)     // Catch:{ ClassNotFoundException -> 0x009e, Exception -> 0x009c }
            java.lang.String r0 = "Loaded LibopusAudioRenderer."
            androidx.media3.common.util.Log.h(r3, r0)     // Catch:{ ClassNotFoundException -> 0x009e, Exception -> 0x009c }
            goto L_0x00a9
        L_0x009c:
            r0 = move-exception
            goto L_0x00a0
        L_0x009e:
            r2 = r1
            goto L_0x00a8
        L_0x00a0:
            java.lang.RuntimeException r1 = new java.lang.RuntimeException
            java.lang.String r2 = "Error instantiating Opus extension"
            r1.<init>(r2, r0)
            throw r1
        L_0x00a8:
            r1 = r2
        L_0x00a9:
            java.lang.String r0 = "androidx.media3.decoder.flac.LibflacAudioRenderer"
            java.lang.Class r0 = java.lang.Class.forName(r0)     // Catch:{ ClassNotFoundException -> 0x00e1, Exception -> 0x00d5 }
            r2 = 3
            java.lang.Class[] r4 = new java.lang.Class[r2]     // Catch:{ ClassNotFoundException -> 0x00e1, Exception -> 0x00d5 }
            r4[r12] = r16     // Catch:{ ClassNotFoundException -> 0x00e1, Exception -> 0x00d5 }
            r4[r13] = r15     // Catch:{ ClassNotFoundException -> 0x00e1, Exception -> 0x00d5 }
            r4[r11] = r14     // Catch:{ ClassNotFoundException -> 0x00e1, Exception -> 0x00d5 }
            java.lang.reflect.Constructor r0 = r0.getConstructor(r4)     // Catch:{ ClassNotFoundException -> 0x00e1, Exception -> 0x00d5 }
            java.lang.Object[] r4 = new java.lang.Object[r2]     // Catch:{ ClassNotFoundException -> 0x00e1, Exception -> 0x00d5 }
            r4[r12] = r24     // Catch:{ ClassNotFoundException -> 0x00e1, Exception -> 0x00d5 }
            r4[r13] = r25     // Catch:{ ClassNotFoundException -> 0x00e1, Exception -> 0x00d5 }
            r4[r11] = r23     // Catch:{ ClassNotFoundException -> 0x00e1, Exception -> 0x00d5 }
            java.lang.Object r0 = r0.newInstance(r4)     // Catch:{ ClassNotFoundException -> 0x00e1, Exception -> 0x00d5 }
            androidx.media3.exoplayer.Renderer r0 = (androidx.media3.exoplayer.Renderer) r0     // Catch:{ ClassNotFoundException -> 0x00e1, Exception -> 0x00d5 }
            int r2 = r1 + 1
            r9.add(r1, r0)     // Catch:{ ClassNotFoundException -> 0x00d7, Exception -> 0x00d5 }
            java.lang.String r0 = "Loaded LibflacAudioRenderer."
            androidx.media3.common.util.Log.h(r3, r0)     // Catch:{ ClassNotFoundException -> 0x00d7, Exception -> 0x00d5 }
            goto L_0x00e2
        L_0x00d5:
            r0 = move-exception
            goto L_0x00d9
        L_0x00d7:
            r1 = r2
            goto L_0x00e1
        L_0x00d9:
            java.lang.RuntimeException r1 = new java.lang.RuntimeException
            java.lang.String r2 = "Error instantiating FLAC extension"
            r1.<init>(r2, r0)
            throw r1
        L_0x00e1:
            r2 = r1
        L_0x00e2:
            java.lang.String r0 = "androidx.media3.decoder.ffmpeg.FfmpegAudioRenderer"
            java.lang.Class r0 = java.lang.Class.forName(r0)     // Catch:{ ClassNotFoundException -> 0x0115, Exception -> 0x010c }
            r1 = 3
            java.lang.Class[] r4 = new java.lang.Class[r1]     // Catch:{ ClassNotFoundException -> 0x0115, Exception -> 0x010c }
            r4[r12] = r16     // Catch:{ ClassNotFoundException -> 0x0115, Exception -> 0x010c }
            r4[r13] = r15     // Catch:{ ClassNotFoundException -> 0x0115, Exception -> 0x010c }
            r4[r11] = r14     // Catch:{ ClassNotFoundException -> 0x0115, Exception -> 0x010c }
            java.lang.reflect.Constructor r0 = r0.getConstructor(r4)     // Catch:{ ClassNotFoundException -> 0x0115, Exception -> 0x010c }
            java.lang.Object[] r1 = new java.lang.Object[r1]     // Catch:{ ClassNotFoundException -> 0x0115, Exception -> 0x010c }
            r1[r12] = r24     // Catch:{ ClassNotFoundException -> 0x0115, Exception -> 0x010c }
            r1[r13] = r25     // Catch:{ ClassNotFoundException -> 0x0115, Exception -> 0x010c }
            r1[r11] = r23     // Catch:{ ClassNotFoundException -> 0x0115, Exception -> 0x010c }
            java.lang.Object r0 = r0.newInstance(r1)     // Catch:{ ClassNotFoundException -> 0x0115, Exception -> 0x010c }
            androidx.media3.exoplayer.Renderer r0 = (androidx.media3.exoplayer.Renderer) r0     // Catch:{ ClassNotFoundException -> 0x0115, Exception -> 0x010c }
            r9.add(r2, r0)     // Catch:{ ClassNotFoundException -> 0x0115, Exception -> 0x010c }
            java.lang.String r0 = "Loaded FfmpegAudioRenderer."
            androidx.media3.common.util.Log.h(r3, r0)     // Catch:{ ClassNotFoundException -> 0x0115, Exception -> 0x010c }
            goto L_0x0115
        L_0x010c:
            r0 = move-exception
            java.lang.RuntimeException r1 = new java.lang.RuntimeException
            java.lang.String r2 = "Error instantiating FFmpeg extension"
            r1.<init>(r2, r0)
            throw r1
        L_0x0115:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.exoplayer.DefaultRenderersFactory.b(android.content.Context, int, androidx.media3.exoplayer.mediacodec.MediaCodecSelector, boolean, androidx.media3.exoplayer.audio.AudioSink, android.os.Handler, androidx.media3.exoplayer.audio.AudioRendererEventListener, java.util.ArrayList):void");
    }

    /* access modifiers changed from: protected */
    @Nullable
    public AudioSink c(Context context, boolean z, boolean z2) {
        return new DefaultAudioSink.Builder(context).p(z).o(z2).i();
    }

    /* access modifiers changed from: protected */
    public void d(Context context, int i2, ArrayList<Renderer> arrayList) {
        arrayList.add(new CameraMotionRenderer());
    }

    /* access modifiers changed from: protected */
    public void e(ArrayList<Renderer> arrayList) {
        arrayList.add(new ImageRenderer(ImageDecoder.Factory.f11620a, (ImageOutput) null));
    }

    /* access modifiers changed from: protected */
    public void f(Context context, MetadataOutput metadataOutput, Looper looper, int i2, ArrayList<Renderer> arrayList) {
        arrayList.add(new MetadataRenderer(metadataOutput, looper));
    }

    /* access modifiers changed from: protected */
    public void g(Context context, Handler handler, int i2, ArrayList<Renderer> arrayList) {
    }

    /* access modifiers changed from: protected */
    public void h(Context context, TextOutput textOutput, Looper looper, int i2, ArrayList<Renderer> arrayList) {
        arrayList.add(new TextRenderer(textOutput, looper));
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x007b, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x007f, code lost:
        r2 = r20;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0082, code lost:
        r2 = r20;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x008c, code lost:
        throw new java.lang.RuntimeException("Error instantiating VP9 extension", r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x00cb, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x00cd, code lost:
        r3 = r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x00d6, code lost:
        throw new java.lang.RuntimeException("Error instantiating AV1 extension", r0);
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x007b A[ExcHandler: Exception (r0v8 'e' java.lang.Exception A[CUSTOM_DECLARE]), Splitter:B:7:0x003e] */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00cb A[ExcHandler: Exception (r0v7 'e' java.lang.Exception A[CUSTOM_DECLARE]), Splitter:B:26:0x0090] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void i(android.content.Context r22, int r23, androidx.media3.exoplayer.mediacodec.MediaCodecSelector r24, boolean r25, android.os.Handler r26, androidx.media3.exoplayer.video.VideoRendererEventListener r27, long r28, java.util.ArrayList<androidx.media3.exoplayer.Renderer> r30) {
        /*
            r21 = this;
            r0 = r23
            r11 = r30
            r13 = 0
            r14 = 4
            r15 = 2
            r16 = 1
            java.lang.String r10 = "DefaultRenderersFactory"
            java.lang.Class<androidx.media3.exoplayer.video.VideoRendererEventListener> r17 = androidx.media3.exoplayer.video.VideoRendererEventListener.class
            java.lang.Class<android.os.Handler> r18 = android.os.Handler.class
            androidx.media3.exoplayer.video.MediaCodecVideoRenderer r9 = new androidx.media3.exoplayer.video.MediaCodecVideoRenderer
            androidx.media3.exoplayer.mediacodec.MediaCodecAdapter$Factory r3 = r21.m()
            r19 = 50
            r1 = r9
            r2 = r22
            r4 = r24
            r5 = r28
            r7 = r25
            r8 = r26
            r12 = r9
            r9 = r27
            r20 = r10
            r10 = r19
            r1.<init>(r2, r3, r4, r5, r7, r8, r9, r10)
            r11.add(r12)
            if (r0 != 0) goto L_0x0032
            return
        L_0x0032:
            int r1 = r30.size()
            if (r0 != r15) goto L_0x003a
            int r1 = r1 + -1
        L_0x003a:
            r0 = 50
            java.lang.String r2 = "androidx.media3.decoder.vp9.LibvpxVideoRenderer"
            java.lang.Class r2 = java.lang.Class.forName(r2)     // Catch:{ ClassNotFoundException -> 0x0082, Exception -> 0x007b }
            java.lang.Class[] r3 = new java.lang.Class[r14]     // Catch:{ ClassNotFoundException -> 0x0082, Exception -> 0x007b }
            java.lang.Class r4 = java.lang.Long.TYPE     // Catch:{ ClassNotFoundException -> 0x0082, Exception -> 0x007b }
            r3[r13] = r4     // Catch:{ ClassNotFoundException -> 0x0082, Exception -> 0x007b }
            r3[r16] = r18     // Catch:{ ClassNotFoundException -> 0x0082, Exception -> 0x007b }
            r3[r15] = r17     // Catch:{ ClassNotFoundException -> 0x0082, Exception -> 0x007b }
            java.lang.Class r4 = java.lang.Integer.TYPE     // Catch:{ ClassNotFoundException -> 0x0082, Exception -> 0x007b }
            r5 = 3
            r3[r5] = r4     // Catch:{ ClassNotFoundException -> 0x0082, Exception -> 0x007b }
            java.lang.reflect.Constructor r2 = r2.getConstructor(r3)     // Catch:{ ClassNotFoundException -> 0x0082, Exception -> 0x007b }
            java.lang.Long r3 = java.lang.Long.valueOf(r28)     // Catch:{ ClassNotFoundException -> 0x0082, Exception -> 0x007b }
            java.lang.Integer r4 = java.lang.Integer.valueOf(r0)     // Catch:{ ClassNotFoundException -> 0x0082, Exception -> 0x007b }
            java.lang.Object[] r5 = new java.lang.Object[r14]     // Catch:{ ClassNotFoundException -> 0x0082, Exception -> 0x007b }
            r5[r13] = r3     // Catch:{ ClassNotFoundException -> 0x0082, Exception -> 0x007b }
            r5[r16] = r26     // Catch:{ ClassNotFoundException -> 0x0082, Exception -> 0x007b }
            r5[r15] = r27     // Catch:{ ClassNotFoundException -> 0x0082, Exception -> 0x007b }
            r3 = 3
            r5[r3] = r4     // Catch:{ ClassNotFoundException -> 0x0082, Exception -> 0x007b }
            java.lang.Object r2 = r2.newInstance(r5)     // Catch:{ ClassNotFoundException -> 0x0082, Exception -> 0x007b }
            androidx.media3.exoplayer.Renderer r2 = (androidx.media3.exoplayer.Renderer) r2     // Catch:{ ClassNotFoundException -> 0x0082, Exception -> 0x007b }
            int r3 = r1 + 1
            r11.add(r1, r2)     // Catch:{ ClassNotFoundException -> 0x007f, Exception -> 0x007b }
            java.lang.String r1 = "Loaded LibvpxVideoRenderer."
            r2 = r20
            androidx.media3.common.util.Log.h(r2, r1)     // Catch:{ ClassNotFoundException -> 0x007d, Exception -> 0x007b }
            goto L_0x008e
        L_0x007b:
            r0 = move-exception
            goto L_0x0085
        L_0x007d:
            r1 = r3
            goto L_0x008d
        L_0x007f:
            r2 = r20
            goto L_0x007d
        L_0x0082:
            r2 = r20
            goto L_0x008d
        L_0x0085:
            java.lang.RuntimeException r1 = new java.lang.RuntimeException
            java.lang.String r2 = "Error instantiating VP9 extension"
            r1.<init>(r2, r0)
            throw r1
        L_0x008d:
            r3 = r1
        L_0x008e:
            java.lang.String r1 = "androidx.media3.decoder.av1.Libgav1VideoRenderer"
            java.lang.Class r1 = java.lang.Class.forName(r1)     // Catch:{ ClassNotFoundException -> 0x00d7, Exception -> 0x00cb }
            java.lang.Class[] r4 = new java.lang.Class[r14]     // Catch:{ ClassNotFoundException -> 0x00d7, Exception -> 0x00cb }
            java.lang.Class r5 = java.lang.Long.TYPE     // Catch:{ ClassNotFoundException -> 0x00d7, Exception -> 0x00cb }
            r4[r13] = r5     // Catch:{ ClassNotFoundException -> 0x00d7, Exception -> 0x00cb }
            r4[r16] = r18     // Catch:{ ClassNotFoundException -> 0x00d7, Exception -> 0x00cb }
            r4[r15] = r17     // Catch:{ ClassNotFoundException -> 0x00d7, Exception -> 0x00cb }
            java.lang.Class r5 = java.lang.Integer.TYPE     // Catch:{ ClassNotFoundException -> 0x00d7, Exception -> 0x00cb }
            r6 = 3
            r4[r6] = r5     // Catch:{ ClassNotFoundException -> 0x00d7, Exception -> 0x00cb }
            java.lang.reflect.Constructor r1 = r1.getConstructor(r4)     // Catch:{ ClassNotFoundException -> 0x00d7, Exception -> 0x00cb }
            java.lang.Long r4 = java.lang.Long.valueOf(r28)     // Catch:{ ClassNotFoundException -> 0x00d7, Exception -> 0x00cb }
            java.lang.Integer r5 = java.lang.Integer.valueOf(r0)     // Catch:{ ClassNotFoundException -> 0x00d7, Exception -> 0x00cb }
            java.lang.Object[] r6 = new java.lang.Object[r14]     // Catch:{ ClassNotFoundException -> 0x00d7, Exception -> 0x00cb }
            r6[r13] = r4     // Catch:{ ClassNotFoundException -> 0x00d7, Exception -> 0x00cb }
            r6[r16] = r26     // Catch:{ ClassNotFoundException -> 0x00d7, Exception -> 0x00cb }
            r6[r15] = r27     // Catch:{ ClassNotFoundException -> 0x00d7, Exception -> 0x00cb }
            r4 = 3
            r6[r4] = r5     // Catch:{ ClassNotFoundException -> 0x00d7, Exception -> 0x00cb }
            java.lang.Object r1 = r1.newInstance(r6)     // Catch:{ ClassNotFoundException -> 0x00d7, Exception -> 0x00cb }
            androidx.media3.exoplayer.Renderer r1 = (androidx.media3.exoplayer.Renderer) r1     // Catch:{ ClassNotFoundException -> 0x00d7, Exception -> 0x00cb }
            int r4 = r3 + 1
            r11.add(r3, r1)     // Catch:{ ClassNotFoundException -> 0x00cd, Exception -> 0x00cb }
            java.lang.String r1 = "Loaded Libgav1VideoRenderer."
            androidx.media3.common.util.Log.h(r2, r1)     // Catch:{ ClassNotFoundException -> 0x00cd, Exception -> 0x00cb }
            goto L_0x00d8
        L_0x00cb:
            r0 = move-exception
            goto L_0x00cf
        L_0x00cd:
            r3 = r4
            goto L_0x00d7
        L_0x00cf:
            java.lang.RuntimeException r1 = new java.lang.RuntimeException
            java.lang.String r2 = "Error instantiating AV1 extension"
            r1.<init>(r2, r0)
            throw r1
        L_0x00d7:
            r4 = r3
        L_0x00d8:
            java.lang.String r1 = "androidx.media3.decoder.ffmpeg.ExperimentalFfmpegVideoRenderer"
            java.lang.Class r1 = java.lang.Class.forName(r1)     // Catch:{ ClassNotFoundException -> 0x011c, Exception -> 0x0113 }
            java.lang.Class[] r3 = new java.lang.Class[r14]     // Catch:{ ClassNotFoundException -> 0x011c, Exception -> 0x0113 }
            java.lang.Class r5 = java.lang.Long.TYPE     // Catch:{ ClassNotFoundException -> 0x011c, Exception -> 0x0113 }
            r3[r13] = r5     // Catch:{ ClassNotFoundException -> 0x011c, Exception -> 0x0113 }
            r3[r16] = r18     // Catch:{ ClassNotFoundException -> 0x011c, Exception -> 0x0113 }
            r3[r15] = r17     // Catch:{ ClassNotFoundException -> 0x011c, Exception -> 0x0113 }
            java.lang.Class r5 = java.lang.Integer.TYPE     // Catch:{ ClassNotFoundException -> 0x011c, Exception -> 0x0113 }
            r6 = 3
            r3[r6] = r5     // Catch:{ ClassNotFoundException -> 0x011c, Exception -> 0x0113 }
            java.lang.reflect.Constructor r1 = r1.getConstructor(r3)     // Catch:{ ClassNotFoundException -> 0x011c, Exception -> 0x0113 }
            java.lang.Long r3 = java.lang.Long.valueOf(r28)     // Catch:{ ClassNotFoundException -> 0x011c, Exception -> 0x0113 }
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)     // Catch:{ ClassNotFoundException -> 0x011c, Exception -> 0x0113 }
            java.lang.Object[] r5 = new java.lang.Object[r14]     // Catch:{ ClassNotFoundException -> 0x011c, Exception -> 0x0113 }
            r5[r13] = r3     // Catch:{ ClassNotFoundException -> 0x011c, Exception -> 0x0113 }
            r5[r16] = r26     // Catch:{ ClassNotFoundException -> 0x011c, Exception -> 0x0113 }
            r5[r15] = r27     // Catch:{ ClassNotFoundException -> 0x011c, Exception -> 0x0113 }
            r3 = 3
            r5[r3] = r0     // Catch:{ ClassNotFoundException -> 0x011c, Exception -> 0x0113 }
            java.lang.Object r0 = r1.newInstance(r5)     // Catch:{ ClassNotFoundException -> 0x011c, Exception -> 0x0113 }
            androidx.media3.exoplayer.Renderer r0 = (androidx.media3.exoplayer.Renderer) r0     // Catch:{ ClassNotFoundException -> 0x011c, Exception -> 0x0113 }
            r11.add(r4, r0)     // Catch:{ ClassNotFoundException -> 0x011c, Exception -> 0x0113 }
            java.lang.String r0 = "Loaded FfmpegVideoRenderer."
            androidx.media3.common.util.Log.h(r2, r0)     // Catch:{ ClassNotFoundException -> 0x011c, Exception -> 0x0113 }
            goto L_0x011c
        L_0x0113:
            r0 = move-exception
            java.lang.RuntimeException r1 = new java.lang.RuntimeException
            java.lang.String r2 = "Error instantiating FFmpeg extension"
            r1.<init>(r2, r0)
            throw r1
        L_0x011c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.exoplayer.DefaultRenderersFactory.i(android.content.Context, int, androidx.media3.exoplayer.mediacodec.MediaCodecSelector, boolean, android.os.Handler, androidx.media3.exoplayer.video.VideoRendererEventListener, long, java.util.ArrayList):void");
    }

    @CanIgnoreReturnValue
    public final DefaultRenderersFactory j(boolean z) {
        this.f10175b.b(z);
        return this;
    }

    @CanIgnoreReturnValue
    public final DefaultRenderersFactory k() {
        this.f10175b.c();
        return this;
    }

    @CanIgnoreReturnValue
    public final DefaultRenderersFactory l() {
        this.f10175b.d();
        return this;
    }

    /* access modifiers changed from: protected */
    public MediaCodecAdapter.Factory m() {
        return this.f10175b;
    }

    @CanIgnoreReturnValue
    public final DefaultRenderersFactory n(long j2) {
        this.f10177d = j2;
        return this;
    }

    @CanIgnoreReturnValue
    public final DefaultRenderersFactory o(boolean z) {
        this.f10180g = z;
        return this;
    }

    @CanIgnoreReturnValue
    public final DefaultRenderersFactory p(boolean z) {
        this.f10181h = z;
        return this;
    }

    @CanIgnoreReturnValue
    public final DefaultRenderersFactory q(boolean z) {
        this.f10178e = z;
        return this;
    }

    @CanIgnoreReturnValue
    public final DefaultRenderersFactory r(int i2) {
        this.f10176c = i2;
        return this;
    }

    @CanIgnoreReturnValue
    public final DefaultRenderersFactory s(MediaCodecSelector mediaCodecSelector) {
        this.f10179f = mediaCodecSelector;
        return this;
    }
}
