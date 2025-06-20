package com.google.android.gms.common.images;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.ParcelFileDescriptor;
import android.os.ResultReceiver;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.annotation.KeepName;
import com.google.android.gms.common.internal.Asserts;
import com.google.android.gms.common.internal.Constants;
import com.google.android.gms.internal.base.zak;
import com.google.android.gms.internal.base.zap;
import com.google.android.gms.internal.base.zaq;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.concurrent.ExecutorService;

public final class ImageManager {
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public static final Object f20198h = new Object();
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public static HashSet<Uri> f20199i = new HashSet<>();

    /* renamed from: j  reason: collision with root package name */
    private static ImageManager f20200j;
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final Context f20201a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final Handler f20202b = new zaq(Looper.getMainLooper());
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public final ExecutorService f20203c = zap.zaa().zab(4, 2);
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public final zak f20204d = new zak();
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public final Map<zag, ImageReceiver> f20205e = new HashMap();
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public final Map<Uri, ImageReceiver> f20206f = new HashMap();
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public final Map<Uri, Long> f20207g = new HashMap();

    @KeepName
    private final class ImageReceiver extends ResultReceiver {
        /* access modifiers changed from: private */
        public final ArrayList<zag> X = new ArrayList<>();
        private final Uri s;

        ImageReceiver(Uri uri) {
            super(new zaq(Looper.getMainLooper()));
            this.s = uri;
        }

        public final void b(zag zag) {
            Asserts.a("ImageReceiver.addImageRequest() must be called in the main thread");
            this.X.add(zag);
        }

        public final void c(zag zag) {
            Asserts.a("ImageReceiver.removeImageRequest() must be called in the main thread");
            this.X.remove(zag);
        }

        public final void d() {
            Intent intent = new Intent(Constants.f20237c);
            intent.setPackage("com.google.android.gms");
            intent.putExtra(Constants.f20238d, this.s);
            intent.putExtra(Constants.f20239e, this);
            intent.putExtra(Constants.f20240f, 3);
            ImageManager.this.f20201a.sendBroadcast(intent);
        }

        public final void onReceiveResult(int i2, Bundle bundle) {
            ImageManager imageManager = ImageManager.this;
            imageManager.f20203c.execute(new zaa(imageManager, this.s, (ParcelFileDescriptor) bundle.getParcelable("com.google.android.gms.extra.fileDescriptor")));
        }
    }

    public interface OnImageLoadedListener {
        void a(@NonNull Uri uri, @Nullable Drawable drawable, boolean z);
    }

    private ImageManager(Context context, boolean z) {
        this.f20201a = context.getApplicationContext();
    }

    @NonNull
    public static ImageManager a(@NonNull Context context) {
        if (f20200j == null) {
            f20200j = new ImageManager(context, false);
        }
        return f20200j;
    }

    public void b(@NonNull ImageView imageView, int i2) {
        p(new zae(imageView, i2));
    }

    public void c(@NonNull ImageView imageView, @NonNull Uri uri) {
        p(new zae(imageView, uri));
    }

    public void d(@NonNull ImageView imageView, @NonNull Uri uri, int i2) {
        zae zae = new zae(imageView, uri);
        zae.f20214b = i2;
        p(zae);
    }

    public void e(@NonNull OnImageLoadedListener onImageLoadedListener, @NonNull Uri uri) {
        p(new zaf(onImageLoadedListener, uri));
    }

    public void f(@NonNull OnImageLoadedListener onImageLoadedListener, @NonNull Uri uri, int i2) {
        zaf zaf = new zaf(onImageLoadedListener, uri);
        zaf.f20214b = i2;
        p(zaf);
    }

    public final void p(zag zag) {
        Asserts.a("ImageManager.loadImage() must be called in the main thread");
        new zab(this, zag).run();
    }
}
