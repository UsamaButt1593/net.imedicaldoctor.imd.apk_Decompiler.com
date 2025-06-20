package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import android.os.ParcelFileDescriptor;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.ImageHeaderParserUtils;
import com.bumptech.glide.load.data.InputStreamRewinder;
import com.bumptech.glide.load.data.ParcelFileDescriptorRewinder;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import com.bumptech.glide.util.Preconditions;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

interface ImageReader {

    public static final class InputStreamImageReader implements ImageReader {

        /* renamed from: a  reason: collision with root package name */
        private final InputStreamRewinder f18313a;

        /* renamed from: b  reason: collision with root package name */
        private final ArrayPool f18314b;

        /* renamed from: c  reason: collision with root package name */
        private final List<ImageHeaderParser> f18315c;

        InputStreamImageReader(InputStream inputStream, List<ImageHeaderParser> list, ArrayPool arrayPool) {
            this.f18314b = (ArrayPool) Preconditions.d(arrayPool);
            this.f18315c = (List) Preconditions.d(list);
            this.f18313a = new InputStreamRewinder(inputStream, arrayPool);
        }

        public int a() throws IOException {
            return ImageHeaderParserUtils.b(this.f18315c, this.f18313a.a(), this.f18314b);
        }

        @Nullable
        public Bitmap b(BitmapFactory.Options options) throws IOException {
            return BitmapFactory.decodeStream(this.f18313a.a(), (Rect) null, options);
        }

        public void c() {
            this.f18313a.c();
        }

        public ImageHeaderParser.ImageType d() throws IOException {
            return ImageHeaderParserUtils.e(this.f18315c, this.f18313a.a(), this.f18314b);
        }
    }

    @RequiresApi(21)
    public static final class ParcelFileDescriptorImageReader implements ImageReader {

        /* renamed from: a  reason: collision with root package name */
        private final ArrayPool f18316a;

        /* renamed from: b  reason: collision with root package name */
        private final List<ImageHeaderParser> f18317b;

        /* renamed from: c  reason: collision with root package name */
        private final ParcelFileDescriptorRewinder f18318c;

        ParcelFileDescriptorImageReader(ParcelFileDescriptor parcelFileDescriptor, List<ImageHeaderParser> list, ArrayPool arrayPool) {
            this.f18316a = (ArrayPool) Preconditions.d(arrayPool);
            this.f18317b = (List) Preconditions.d(list);
            this.f18318c = new ParcelFileDescriptorRewinder(parcelFileDescriptor);
        }

        public int a() throws IOException {
            return ImageHeaderParserUtils.a(this.f18317b, this.f18318c, this.f18316a);
        }

        @Nullable
        public Bitmap b(BitmapFactory.Options options) throws IOException {
            return BitmapFactory.decodeFileDescriptor(this.f18318c.a().getFileDescriptor(), (Rect) null, options);
        }

        public void c() {
        }

        public ImageHeaderParser.ImageType d() throws IOException {
            return ImageHeaderParserUtils.d(this.f18317b, this.f18318c, this.f18316a);
        }
    }

    int a() throws IOException;

    @Nullable
    Bitmap b(BitmapFactory.Options options) throws IOException;

    void c();

    ImageHeaderParser.ImageType d() throws IOException;
}
