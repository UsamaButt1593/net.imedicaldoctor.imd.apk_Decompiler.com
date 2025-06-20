package com.bumptech.glide;

import android.app.Activity;
import android.app.Fragment;
import android.content.ComponentCallbacks2;
import android.content.ContentResolver;
import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import android.view.View;
import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.fragment.app.FragmentActivity;
import com.bumptech.glide.gifdecoder.GifDecoder;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.data.InputStreamRewinder;
import com.bumptech.glide.load.data.ParcelFileDescriptorRewinder;
import com.bumptech.glide.load.engine.Engine;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.engine.cache.MemoryCache;
import com.bumptech.glide.load.engine.prefill.BitmapPreFiller;
import com.bumptech.glide.load.engine.prefill.PreFillType;
import com.bumptech.glide.load.model.AssetUriLoader;
import com.bumptech.glide.load.model.ByteArrayLoader;
import com.bumptech.glide.load.model.ByteBufferEncoder;
import com.bumptech.glide.load.model.ByteBufferFileLoader;
import com.bumptech.glide.load.model.DataUrlLoader;
import com.bumptech.glide.load.model.FileLoader;
import com.bumptech.glide.load.model.GlideUrl;
import com.bumptech.glide.load.model.MediaStoreFileLoader;
import com.bumptech.glide.load.model.ResourceLoader;
import com.bumptech.glide.load.model.StreamEncoder;
import com.bumptech.glide.load.model.StringLoader;
import com.bumptech.glide.load.model.UnitModelLoader;
import com.bumptech.glide.load.model.UriLoader;
import com.bumptech.glide.load.model.UrlUriLoader;
import com.bumptech.glide.load.model.stream.HttpGlideUrlLoader;
import com.bumptech.glide.load.model.stream.HttpUriLoader;
import com.bumptech.glide.load.model.stream.MediaStoreImageThumbLoader;
import com.bumptech.glide.load.model.stream.MediaStoreVideoThumbLoader;
import com.bumptech.glide.load.model.stream.QMediaStoreUriLoader;
import com.bumptech.glide.load.model.stream.UrlLoader;
import com.bumptech.glide.load.resource.bitmap.BitmapDrawableDecoder;
import com.bumptech.glide.load.resource.bitmap.BitmapDrawableEncoder;
import com.bumptech.glide.load.resource.bitmap.BitmapEncoder;
import com.bumptech.glide.load.resource.bitmap.ByteBufferBitmapDecoder;
import com.bumptech.glide.load.resource.bitmap.ByteBufferBitmapImageDecoderResourceDecoder;
import com.bumptech.glide.load.resource.bitmap.DefaultImageHeaderParser;
import com.bumptech.glide.load.resource.bitmap.Downsampler;
import com.bumptech.glide.load.resource.bitmap.ExifInterfaceImageHeaderParser;
import com.bumptech.glide.load.resource.bitmap.InputStreamBitmapImageDecoderResourceDecoder;
import com.bumptech.glide.load.resource.bitmap.ParcelFileDescriptorBitmapDecoder;
import com.bumptech.glide.load.resource.bitmap.ResourceBitmapDecoder;
import com.bumptech.glide.load.resource.bitmap.StreamBitmapDecoder;
import com.bumptech.glide.load.resource.bitmap.UnitBitmapDecoder;
import com.bumptech.glide.load.resource.bitmap.VideoDecoder;
import com.bumptech.glide.load.resource.bytes.ByteBufferRewinder;
import com.bumptech.glide.load.resource.drawable.ResourceDrawableDecoder;
import com.bumptech.glide.load.resource.drawable.UnitDrawableDecoder;
import com.bumptech.glide.load.resource.file.FileDecoder;
import com.bumptech.glide.load.resource.gif.ByteBufferGifDecoder;
import com.bumptech.glide.load.resource.gif.GifDrawable;
import com.bumptech.glide.load.resource.gif.GifDrawableEncoder;
import com.bumptech.glide.load.resource.gif.GifFrameResourceDecoder;
import com.bumptech.glide.load.resource.gif.StreamGifDecoder;
import com.bumptech.glide.load.resource.transcode.BitmapBytesTranscoder;
import com.bumptech.glide.load.resource.transcode.BitmapDrawableTranscoder;
import com.bumptech.glide.load.resource.transcode.DrawableBytesTranscoder;
import com.bumptech.glide.load.resource.transcode.GifDrawableBytesTranscoder;
import com.bumptech.glide.manager.ConnectivityMonitorFactory;
import com.bumptech.glide.manager.RequestManagerRetriever;
import com.bumptech.glide.module.GlideModule;
import com.bumptech.glide.module.ManifestParser;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.ImageViewTargetFactory;
import com.bumptech.glide.request.target.Target;
import com.bumptech.glide.util.Preconditions;
import com.bumptech.glide.util.Util;
import java.io.File;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Glide implements ComponentCallbacks2 {
    private static final String f3 = "image_manager_disk_cache";
    private static final String g3 = "Glide";
    private static volatile Glide h3;
    private static volatile boolean i3;
    private final BitmapPool X;
    private final Registry X2;
    private final MemoryCache Y;
    private final ArrayPool Y2;
    private final GlideContext Z;
    private final RequestManagerRetriever Z2;
    private final ConnectivityMonitorFactory a3;
    private final List<RequestManager> b3 = new ArrayList();
    private final RequestOptionsFactory c3;
    private MemoryCategory d3 = MemoryCategory.NORMAL;
    @GuardedBy("this")
    @Nullable
    private BitmapPreFiller e3;
    private final Engine s;

    public interface RequestOptionsFactory {
        @NonNull
        RequestOptions build();
    }

    Glide(@NonNull Context context, @NonNull Engine engine, @NonNull MemoryCache memoryCache, @NonNull BitmapPool bitmapPool, @NonNull ArrayPool arrayPool, @NonNull RequestManagerRetriever requestManagerRetriever, @NonNull ConnectivityMonitorFactory connectivityMonitorFactory, int i2, @NonNull RequestOptionsFactory requestOptionsFactory, @NonNull Map<Class<?>, TransitionOptions<?, ?>> map, @NonNull List<RequestListener<Object>> list, boolean z, boolean z2) {
        ResourceDecoder resourceDecoder;
        ResourceDecoder resourceDecoder2;
        Registry registry;
        Context context2 = context;
        BitmapPool bitmapPool2 = bitmapPool;
        ArrayPool arrayPool2 = arrayPool;
        this.s = engine;
        this.X = bitmapPool2;
        this.Y2 = arrayPool2;
        this.Y = memoryCache;
        this.Z2 = requestManagerRetriever;
        this.a3 = connectivityMonitorFactory;
        this.c3 = requestOptionsFactory;
        Resources resources = context.getResources();
        Registry registry2 = new Registry();
        this.X2 = registry2;
        registry2.t(new DefaultImageHeaderParser());
        int i4 = Build.VERSION.SDK_INT;
        if (i4 >= 27) {
            registry2.t(new ExifInterfaceImageHeaderParser());
        }
        List<ImageHeaderParser> g2 = registry2.g();
        ByteBufferGifDecoder byteBufferGifDecoder = new ByteBufferGifDecoder(context2, g2, bitmapPool2, arrayPool2);
        ResourceDecoder<ParcelFileDescriptor, Bitmap> h2 = VideoDecoder.h(bitmapPool);
        Downsampler downsampler = new Downsampler(registry2.g(), resources.getDisplayMetrics(), bitmapPool2, arrayPool2);
        if (!z2 || i4 < 28) {
            resourceDecoder = new ByteBufferBitmapDecoder(downsampler);
            resourceDecoder2 = new StreamBitmapDecoder(downsampler, arrayPool2);
        } else {
            resourceDecoder2 = new InputStreamBitmapImageDecoderResourceDecoder();
            resourceDecoder = new ByteBufferBitmapImageDecoderResourceDecoder();
        }
        ResourceDrawableDecoder resourceDrawableDecoder = new ResourceDrawableDecoder(context2);
        ResourceLoader.StreamFactory streamFactory = new ResourceLoader.StreamFactory(resources);
        ResourceLoader.UriFactory uriFactory = new ResourceLoader.UriFactory(resources);
        ResourceLoader.FileDescriptorFactory fileDescriptorFactory = new ResourceLoader.FileDescriptorFactory(resources);
        int i5 = i4;
        ResourceLoader.AssetFileDescriptorFactory assetFileDescriptorFactory = new ResourceLoader.AssetFileDescriptorFactory(resources);
        BitmapEncoder bitmapEncoder = new BitmapEncoder(arrayPool2);
        ResourceLoader.AssetFileDescriptorFactory assetFileDescriptorFactory2 = assetFileDescriptorFactory;
        BitmapBytesTranscoder bitmapBytesTranscoder = new BitmapBytesTranscoder();
        GifDrawableBytesTranscoder gifDrawableBytesTranscoder = new GifDrawableBytesTranscoder();
        ContentResolver contentResolver = context.getContentResolver();
        ResourceLoader.UriFactory uriFactory2 = uriFactory;
        Class<ByteBuffer> cls = ByteBuffer.class;
        ResourceLoader.FileDescriptorFactory fileDescriptorFactory2 = fileDescriptorFactory;
        ResourceLoader.StreamFactory streamFactory2 = streamFactory;
        Class<InputStream> cls2 = InputStream.class;
        ResourceDrawableDecoder resourceDrawableDecoder2 = resourceDrawableDecoder;
        Class<Bitmap> cls3 = Bitmap.class;
        registry2.a(cls, new ByteBufferEncoder()).a(cls2, new StreamEncoder(arrayPool2)).e(Registry.f17724l, cls, cls3, resourceDecoder).e(Registry.f17724l, cls2, cls3, resourceDecoder2);
        Class<ParcelFileDescriptor> cls4 = ParcelFileDescriptor.class;
        if (ParcelFileDescriptorRewinder.c()) {
            registry2.e(Registry.f17724l, cls4, cls3, new ParcelFileDescriptorBitmapDecoder(downsampler));
        }
        Registry registry3 = registry2;
        Class<AssetFileDescriptor> cls5 = AssetFileDescriptor.class;
        Class<AssetFileDescriptor> cls6 = cls5;
        Class<BitmapDrawable> cls7 = BitmapDrawable.class;
        Registry b2 = registry2.e(Registry.f17724l, cls4, cls3, h2).e(Registry.f17724l, cls5, cls3, VideoDecoder.c(bitmapPool)).d(cls3, cls3, UnitModelLoader.Factory.b()).e(Registry.f17724l, cls3, cls3, new UnitBitmapDecoder()).b(cls3, bitmapEncoder).e(Registry.f17725m, cls, cls7, new BitmapDrawableDecoder(resources, resourceDecoder)).e(Registry.f17725m, cls2, cls7, new BitmapDrawableDecoder(resources, resourceDecoder2)).e(Registry.f17725m, cls4, cls7, new BitmapDrawableDecoder(resources, h2)).b(cls7, new BitmapDrawableEncoder(bitmapPool2, bitmapEncoder));
        Class<ParcelFileDescriptor> cls8 = cls4;
        ArrayPool arrayPool3 = arrayPool;
        Class<GifDrawable> cls9 = GifDrawable.class;
        Class<GifDecoder> cls10 = GifDecoder.class;
        Registry e2 = b2.e(Registry.f17723k, cls2, cls9, new StreamGifDecoder(g2, byteBufferGifDecoder, arrayPool3)).e(Registry.f17723k, cls, cls9, byteBufferGifDecoder).b(cls9, new GifDrawableEncoder()).d(cls10, cls10, UnitModelLoader.Factory.b()).e(Registry.f17724l, cls10, cls3, new GifFrameResourceDecoder(bitmapPool2));
        Class<Uri> cls11 = Uri.class;
        Class<Drawable> cls12 = Drawable.class;
        ResourceDrawableDecoder resourceDrawableDecoder3 = resourceDrawableDecoder2;
        Class<File> cls13 = File.class;
        e2.c(cls11, cls12, resourceDrawableDecoder3).c(cls11, cls3, new ResourceBitmapDecoder(resourceDrawableDecoder3, bitmapPool2)).u(new ByteBufferRewinder.Factory()).d(cls13, cls, new ByteBufferFileLoader.Factory()).d(cls13, cls2, new FileLoader.StreamFactory()).c(cls13, cls13, new FileDecoder()).d(cls13, cls8, new FileLoader.FileDescriptorFactory()).d(cls13, cls13, UnitModelLoader.Factory.b()).u(new InputStreamRewinder.Factory(arrayPool3));
        if (ParcelFileDescriptorRewinder.c()) {
            registry = registry3;
            registry.u(new ParcelFileDescriptorRewinder.Factory());
        } else {
            registry = registry3;
        }
        Class cls14 = Integer.TYPE;
        ResourceLoader.StreamFactory streamFactory3 = streamFactory2;
        ResourceLoader.FileDescriptorFactory fileDescriptorFactory3 = fileDescriptorFactory2;
        Class<GifDrawable> cls15 = cls9;
        Class<Integer> cls16 = Integer.class;
        Registry d2 = registry.d(cls14, cls2, streamFactory3).d(cls14, cls8, fileDescriptorFactory3).d(cls16, cls2, streamFactory3).d(cls16, cls8, fileDescriptorFactory3);
        ResourceLoader.UriFactory uriFactory3 = uriFactory2;
        ResourceLoader.AssetFileDescriptorFactory assetFileDescriptorFactory3 = assetFileDescriptorFactory2;
        Class<AssetFileDescriptor> cls17 = cls6;
        Class<String> cls18 = String.class;
        Context context3 = context;
        d2.d(cls16, cls11, uriFactory3).d(cls14, cls17, assetFileDescriptorFactory3).d(cls16, cls17, assetFileDescriptorFactory3).d(cls14, cls11, uriFactory3).d(cls18, cls2, new DataUrlLoader.StreamFactory()).d(cls11, cls2, new DataUrlLoader.StreamFactory()).d(cls18, cls2, new StringLoader.StreamFactory()).d(cls18, cls8, new StringLoader.FileDescriptorFactory()).d(cls18, cls17, new StringLoader.AssetFileDescriptorFactory()).d(cls11, cls2, new HttpUriLoader.Factory()).d(cls11, cls2, new AssetUriLoader.StreamFactory(context.getAssets())).d(cls11, cls8, new AssetUriLoader.FileDescriptorFactory(context.getAssets())).d(cls11, cls2, new MediaStoreImageThumbLoader.Factory(context3)).d(cls11, cls2, new MediaStoreVideoThumbLoader.Factory(context3));
        int i6 = i5;
        if (i6 >= 29) {
            registry.d(cls11, cls2, new QMediaStoreUriLoader.InputStreamFactory(context3));
            registry.d(cls11, cls8, new QMediaStoreUriLoader.FileDescriptorFactory(context3));
        }
        ContentResolver contentResolver2 = contentResolver;
        Class<GlideUrl> cls19 = GlideUrl.class;
        Class<byte[]> cls20 = byte[].class;
        Registry x = registry.d(cls11, cls2, new UriLoader.StreamFactory(contentResolver2)).d(cls11, cls8, new UriLoader.FileDescriptorFactory(contentResolver2)).d(cls11, cls17, new UriLoader.AssetFileDescriptorFactory(contentResolver2)).d(cls11, cls2, new UrlUriLoader.StreamFactory()).d(URL.class, cls2, new UrlLoader.StreamFactory()).d(cls11, cls13, new MediaStoreFileLoader.Factory(context3)).d(cls19, cls2, new HttpGlideUrlLoader.Factory()).d(cls20, cls, new ByteArrayLoader.ByteBufferFactory()).d(cls20, cls2, new ByteArrayLoader.StreamFactory()).d(cls11, cls11, UnitModelLoader.Factory.b()).d(cls12, cls12, UnitModelLoader.Factory.b()).c(cls12, cls12, new UnitDrawableDecoder()).x(cls3, cls7, new BitmapDrawableTranscoder(resources));
        BitmapBytesTranscoder bitmapBytesTranscoder2 = bitmapBytesTranscoder;
        GifDrawableBytesTranscoder gifDrawableBytesTranscoder2 = gifDrawableBytesTranscoder;
        x.x(cls3, cls20, bitmapBytesTranscoder2).x(cls12, cls20, new DrawableBytesTranscoder(bitmapPool, bitmapBytesTranscoder2, gifDrawableBytesTranscoder2)).x(cls15, cls20, gifDrawableBytesTranscoder2);
        if (i6 >= 23) {
            ResourceDecoder<ByteBuffer, Bitmap> d4 = VideoDecoder.d(bitmapPool);
            registry.c(cls, cls3, d4);
            registry.c(cls, cls7, new BitmapDrawableDecoder(resources, d4));
        }
        this.Z = new GlideContext(context, arrayPool, registry, new ImageViewTargetFactory(), requestOptionsFactory, map, list, engine, z, i2);
    }

    @NonNull
    public static RequestManager B(@NonNull Activity activity) {
        return o(activity).i(activity);
    }

    @NonNull
    @Deprecated
    public static RequestManager C(@NonNull Fragment fragment) {
        return o(fragment.getActivity()).j(fragment);
    }

    @NonNull
    public static RequestManager D(@NonNull Context context) {
        return o(context).k(context);
    }

    @NonNull
    public static RequestManager E(@NonNull View view) {
        return o(view.getContext()).l(view);
    }

    @NonNull
    public static RequestManager F(@NonNull androidx.fragment.app.Fragment fragment) {
        return o(fragment.B()).m(fragment);
    }

    @NonNull
    public static RequestManager G(@NonNull FragmentActivity fragmentActivity) {
        return o(fragmentActivity).n(fragmentActivity);
    }

    @GuardedBy("Glide.class")
    private static void a(@NonNull Context context, @Nullable GeneratedAppGlideModule generatedAppGlideModule) {
        if (!i3) {
            i3 = true;
            r(context, generatedAppGlideModule);
            i3 = false;
            return;
        }
        throw new IllegalStateException("You cannot call Glide.get() in registerComponents(), use the provided Glide instance instead");
    }

    @NonNull
    public static Glide d(@NonNull Context context) {
        if (h3 == null) {
            GeneratedAppGlideModule e2 = e(context.getApplicationContext());
            synchronized (Glide.class) {
                try {
                    if (h3 == null) {
                        a(context, e2);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return h3;
    }

    @Nullable
    private static GeneratedAppGlideModule e(Context context) {
        try {
            return (GeneratedAppGlideModule) Class.forName("com.bumptech.glide.GeneratedAppGlideModuleImpl").getDeclaredConstructor(new Class[]{Context.class}).newInstance(new Object[]{context.getApplicationContext()});
        } catch (ClassNotFoundException unused) {
            if (Log.isLoggable(g3, 5)) {
                Log.w(g3, "Failed to find GeneratedAppGlideModule. You should include an annotationProcessor compile dependency on com.github.bumptech.glide:compiler in your application and a @GlideModule annotated AppGlideModule implementation or LibraryGlideModules will be silently ignored");
            }
        } catch (IllegalAccessException | InstantiationException | NoSuchMethodException | InvocationTargetException e2) {
            y(e2);
        }
        return null;
    }

    @Nullable
    public static File k(@NonNull Context context) {
        return l(context, "image_manager_disk_cache");
    }

    @Nullable
    public static File l(@NonNull Context context, @NonNull String str) {
        File cacheDir = context.getCacheDir();
        if (cacheDir != null) {
            File file = new File(cacheDir, str);
            if (file.mkdirs() || (file.exists() && file.isDirectory())) {
                return file;
            }
            return null;
        }
        if (Log.isLoggable(g3, 6)) {
            Log.e(g3, "default disk cache dir is null");
        }
        return null;
    }

    @NonNull
    private static RequestManagerRetriever o(@Nullable Context context) {
        Preconditions.e(context, "You cannot start a load on a not yet attached View or a Fragment where getActivity() returns null (which usually occurs when getActivity() is called before the Fragment is attached or after the Fragment is destroyed).");
        return d(context).n();
    }

    @VisibleForTesting
    public static void p(@NonNull Context context, @NonNull GlideBuilder glideBuilder) {
        GeneratedAppGlideModule e2 = e(context);
        synchronized (Glide.class) {
            try {
                if (h3 != null) {
                    x();
                }
                s(context, glideBuilder, e2);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @VisibleForTesting
    @Deprecated
    public static synchronized void q(Glide glide) {
        synchronized (Glide.class) {
            try {
                if (h3 != null) {
                    x();
                }
                h3 = glide;
            } catch (Throwable th) {
                while (true) {
                    throw th;
                }
            }
        }
    }

    @GuardedBy("Glide.class")
    private static void r(@NonNull Context context, @Nullable GeneratedAppGlideModule generatedAppGlideModule) {
        s(context, new GlideBuilder(), generatedAppGlideModule);
    }

    @GuardedBy("Glide.class")
    private static void s(@NonNull Context context, @NonNull GlideBuilder glideBuilder, @Nullable GeneratedAppGlideModule generatedAppGlideModule) {
        Context applicationContext = context.getApplicationContext();
        List<GlideModule> emptyList = Collections.emptyList();
        if (generatedAppGlideModule == null || generatedAppGlideModule.c()) {
            emptyList = new ManifestParser(applicationContext).a();
        }
        if (generatedAppGlideModule != null && !generatedAppGlideModule.d().isEmpty()) {
            Set<Class<?>> d2 = generatedAppGlideModule.d();
            Iterator<GlideModule> it2 = emptyList.iterator();
            while (it2.hasNext()) {
                GlideModule next = it2.next();
                if (d2.contains(next.getClass())) {
                    if (Log.isLoggable(g3, 3)) {
                        Log.d(g3, "AppGlideModule excludes manifest GlideModule: " + next);
                    }
                    it2.remove();
                }
            }
        }
        if (Log.isLoggable(g3, 3)) {
            for (GlideModule glideModule : emptyList) {
                Log.d(g3, "Discovered GlideModule from manifest: " + glideModule.getClass());
            }
        }
        glideBuilder.t(generatedAppGlideModule != null ? generatedAppGlideModule.e() : null);
        for (GlideModule a2 : emptyList) {
            a2.a(applicationContext, glideBuilder);
        }
        if (generatedAppGlideModule != null) {
            generatedAppGlideModule.a(applicationContext, glideBuilder);
        }
        Glide b2 = glideBuilder.b(applicationContext);
        for (GlideModule next2 : emptyList) {
            try {
                next2.b(applicationContext, b2, b2.X2);
            } catch (AbstractMethodError e2) {
                throw new IllegalStateException("Attempting to register a Glide v3 module. If you see this, you or one of your dependencies may be including Glide v3 even though you're using Glide v4. You'll need to find and remove (or update) the offending dependency. The v3 module name is: " + next2.getClass().getName(), e2);
            }
        }
        if (generatedAppGlideModule != null) {
            generatedAppGlideModule.b(applicationContext, b2, b2.X2);
        }
        applicationContext.registerComponentCallbacks(b2);
        h3 = b2;
    }

    @VisibleForTesting
    public static synchronized void x() {
        synchronized (Glide.class) {
            try {
                if (h3 != null) {
                    h3.i().getApplicationContext().unregisterComponentCallbacks(h3);
                    h3.s.m();
                }
                h3 = null;
            } catch (Throwable th) {
                while (true) {
                    throw th;
                }
            }
        }
    }

    private static void y(Exception exc) {
        throw new IllegalStateException("GeneratedAppGlideModuleImpl is implemented incorrectly. If you've manually implemented this class, remove your implementation. The Annotation processor will generate a correct implementation.", exc);
    }

    /* access modifiers changed from: package-private */
    public void A(RequestManager requestManager) {
        synchronized (this.b3) {
            try {
                if (this.b3.contains(requestManager)) {
                    this.b3.remove(requestManager);
                } else {
                    throw new IllegalStateException("Cannot unregister not yet registered manager");
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void b() {
        Util.a();
        this.s.e();
    }

    public void c() {
        Util.b();
        this.Y.c();
        this.X.c();
        this.Y2.c();
    }

    @NonNull
    public ArrayPool f() {
        return this.Y2;
    }

    @NonNull
    public BitmapPool g() {
        return this.X;
    }

    /* access modifiers changed from: package-private */
    public ConnectivityMonitorFactory h() {
        return this.a3;
    }

    @NonNull
    public Context i() {
        return this.Z.getBaseContext();
    }

    /* access modifiers changed from: package-private */
    @NonNull
    public GlideContext j() {
        return this.Z;
    }

    @NonNull
    public Registry m() {
        return this.X2;
    }

    @NonNull
    public RequestManagerRetriever n() {
        return this.Z2;
    }

    public void onConfigurationChanged(Configuration configuration) {
    }

    public void onLowMemory() {
        c();
    }

    public void onTrimMemory(int i2) {
        z(i2);
    }

    public synchronized void t(@NonNull PreFillType.Builder... builderArr) {
        try {
            if (this.e3 == null) {
                this.e3 = new BitmapPreFiller(this.Y, this.X, (DecodeFormat) this.c3.build().U().c(Downsampler.f18276g));
            }
            this.e3.c(builderArr);
        } catch (Throwable th) {
            while (true) {
                throw th;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void u(RequestManager requestManager) {
        synchronized (this.b3) {
            try {
                if (!this.b3.contains(requestManager)) {
                    this.b3.add(requestManager);
                } else {
                    throw new IllegalStateException("Cannot register already registered manager");
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public boolean v(@NonNull Target<?> target) {
        synchronized (this.b3) {
            try {
                for (RequestManager c0 : this.b3) {
                    if (c0.c0(target)) {
                        return true;
                    }
                }
                return false;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @NonNull
    public MemoryCategory w(@NonNull MemoryCategory memoryCategory) {
        Util.b();
        this.Y.d(memoryCategory.a());
        this.X.d(memoryCategory.a());
        MemoryCategory memoryCategory2 = this.d3;
        this.d3 = memoryCategory;
        return memoryCategory2;
    }

    public void z(int i2) {
        Util.b();
        for (RequestManager onTrimMemory : this.b3) {
            onTrimMemory.onTrimMemory(i2);
        }
        this.Y.b(i2);
        this.X.b(i2);
        this.Y2.b(i2);
    }
}
