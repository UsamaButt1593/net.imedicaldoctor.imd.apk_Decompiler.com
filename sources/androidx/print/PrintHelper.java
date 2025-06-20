package androidx.print;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.os.CancellationSignal;
import android.os.ParcelFileDescriptor;
import android.print.PageRange;
import android.print.PrintAttributes;
import android.print.PrintDocumentAdapter;
import android.print.PrintDocumentInfo;
import android.print.PrintManager;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import java.io.FileNotFoundException;

public final class PrintHelper {

    /* renamed from: g  reason: collision with root package name */
    private static final String f15020g = "PrintHelper";

    /* renamed from: h  reason: collision with root package name */
    private static final int f15021h = 3500;

    /* renamed from: i  reason: collision with root package name */
    static final boolean f15022i;

    /* renamed from: j  reason: collision with root package name */
    static final boolean f15023j;

    /* renamed from: k  reason: collision with root package name */
    public static final int f15024k = 1;

    /* renamed from: l  reason: collision with root package name */
    public static final int f15025l = 2;
    @SuppressLint({"InlinedApi"})

    /* renamed from: m  reason: collision with root package name */
    public static final int f15026m = 1;
    @SuppressLint({"InlinedApi"})

    /* renamed from: n  reason: collision with root package name */
    public static final int f15027n = 2;
    public static final int o = 1;
    public static final int p = 2;

    /* renamed from: a  reason: collision with root package name */
    final Context f15028a;

    /* renamed from: b  reason: collision with root package name */
    BitmapFactory.Options f15029b = null;

    /* renamed from: c  reason: collision with root package name */
    final Object f15030c = new Object();

    /* renamed from: d  reason: collision with root package name */
    int f15031d = 2;

    /* renamed from: e  reason: collision with root package name */
    int f15032e = 2;

    /* renamed from: f  reason: collision with root package name */
    int f15033f = 1;

    public interface OnPrintFinishCallback {
        void a();
    }

    @RequiresApi(19)
    private class PrintBitmapAdapter extends PrintDocumentAdapter {

        /* renamed from: a  reason: collision with root package name */
        private final String f15042a;

        /* renamed from: b  reason: collision with root package name */
        private final int f15043b;

        /* renamed from: c  reason: collision with root package name */
        private final Bitmap f15044c;

        /* renamed from: d  reason: collision with root package name */
        private final OnPrintFinishCallback f15045d;

        /* renamed from: e  reason: collision with root package name */
        private PrintAttributes f15046e;

        PrintBitmapAdapter(String str, int i2, Bitmap bitmap, OnPrintFinishCallback onPrintFinishCallback) {
            this.f15042a = str;
            this.f15043b = i2;
            this.f15044c = bitmap;
            this.f15045d = onPrintFinishCallback;
        }

        public void onFinish() {
            OnPrintFinishCallback onPrintFinishCallback = this.f15045d;
            if (onPrintFinishCallback != null) {
                onPrintFinishCallback.a();
            }
        }

        public void onLayout(PrintAttributes printAttributes, PrintAttributes printAttributes2, CancellationSignal cancellationSignal, PrintDocumentAdapter.LayoutResultCallback layoutResultCallback, Bundle bundle) {
            this.f15046e = printAttributes2;
            layoutResultCallback.onLayoutFinished(new PrintDocumentInfo.Builder(this.f15042a).setContentType(1).setPageCount(1).build(), !printAttributes2.equals(printAttributes));
        }

        public void onWrite(PageRange[] pageRangeArr, ParcelFileDescriptor parcelFileDescriptor, CancellationSignal cancellationSignal, PrintDocumentAdapter.WriteResultCallback writeResultCallback) {
            PrintHelper.this.r(this.f15046e, this.f15043b, this.f15044c, parcelFileDescriptor, cancellationSignal, writeResultCallback);
        }
    }

    @RequiresApi(19)
    private class PrintUriAdapter extends PrintDocumentAdapter {

        /* renamed from: a  reason: collision with root package name */
        final String f15048a;

        /* renamed from: b  reason: collision with root package name */
        final Uri f15049b;

        /* renamed from: c  reason: collision with root package name */
        final OnPrintFinishCallback f15050c;

        /* renamed from: d  reason: collision with root package name */
        final int f15051d;

        /* renamed from: e  reason: collision with root package name */
        PrintAttributes f15052e;

        /* renamed from: f  reason: collision with root package name */
        AsyncTask<Uri, Boolean, Bitmap> f15053f;

        /* renamed from: g  reason: collision with root package name */
        Bitmap f15054g = null;

        PrintUriAdapter(String str, Uri uri, OnPrintFinishCallback onPrintFinishCallback, int i2) {
            this.f15048a = str;
            this.f15049b = uri;
            this.f15050c = onPrintFinishCallback;
            this.f15051d = i2;
        }

        /* access modifiers changed from: package-private */
        public void a() {
            synchronized (PrintHelper.this.f15030c) {
                try {
                    BitmapFactory.Options options = PrintHelper.this.f15029b;
                    if (options != null) {
                        if (Build.VERSION.SDK_INT < 24) {
                            options.requestCancelDecode();
                        }
                        PrintHelper.this.f15029b = null;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        public void onFinish() {
            super.onFinish();
            a();
            AsyncTask<Uri, Boolean, Bitmap> asyncTask = this.f15053f;
            if (asyncTask != null) {
                asyncTask.cancel(true);
            }
            OnPrintFinishCallback onPrintFinishCallback = this.f15050c;
            if (onPrintFinishCallback != null) {
                onPrintFinishCallback.a();
            }
            Bitmap bitmap = this.f15054g;
            if (bitmap != null) {
                bitmap.recycle();
                this.f15054g = null;
            }
        }

        public void onLayout(PrintAttributes printAttributes, PrintAttributes printAttributes2, CancellationSignal cancellationSignal, PrintDocumentAdapter.LayoutResultCallback layoutResultCallback, Bundle bundle) {
            synchronized (this) {
                this.f15052e = printAttributes2;
            }
            if (cancellationSignal.isCanceled()) {
                layoutResultCallback.onLayoutCancelled();
            } else if (this.f15054g != null) {
                layoutResultCallback.onLayoutFinished(new PrintDocumentInfo.Builder(this.f15048a).setContentType(1).setPageCount(1).build(), !printAttributes2.equals(printAttributes));
            } else {
                final CancellationSignal cancellationSignal2 = cancellationSignal;
                final PrintAttributes printAttributes3 = printAttributes2;
                final PrintAttributes printAttributes4 = printAttributes;
                final PrintDocumentAdapter.LayoutResultCallback layoutResultCallback2 = layoutResultCallback;
                this.f15053f = new AsyncTask<Uri, Boolean, Bitmap>() {
                    /* access modifiers changed from: protected */
                    /* renamed from: a */
                    public Bitmap doInBackground(Uri... uriArr) {
                        try {
                            PrintUriAdapter printUriAdapter = PrintUriAdapter.this;
                            return PrintHelper.this.i(printUriAdapter.f15049b);
                        } catch (FileNotFoundException unused) {
                            return null;
                        }
                    }

                    /* access modifiers changed from: protected */
                    /* renamed from: b */
                    public void onCancelled(Bitmap bitmap) {
                        layoutResultCallback2.onLayoutCancelled();
                        PrintUriAdapter.this.f15053f = null;
                    }

                    /* access modifiers changed from: protected */
                    /* renamed from: c */
                    public void onPostExecute(Bitmap bitmap) {
                        PrintAttributes.MediaSize mediaSize;
                        super.onPostExecute(bitmap);
                        if (bitmap != null && (!PrintHelper.f15022i || PrintHelper.this.f15033f == 0)) {
                            synchronized (this) {
                                mediaSize = PrintUriAdapter.this.f15052e.getMediaSize();
                            }
                            if (!(mediaSize == null || mediaSize.isPortrait() == PrintHelper.g(bitmap))) {
                                Matrix matrix = new Matrix();
                                matrix.postRotate(90.0f);
                                bitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
                            }
                        }
                        PrintUriAdapter.this.f15054g = bitmap;
                        if (bitmap != null) {
                            layoutResultCallback2.onLayoutFinished(new PrintDocumentInfo.Builder(PrintUriAdapter.this.f15048a).setContentType(1).setPageCount(1).build(), true ^ printAttributes3.equals(printAttributes4));
                        } else {
                            layoutResultCallback2.onLayoutFailed((CharSequence) null);
                        }
                        PrintUriAdapter.this.f15053f = null;
                    }

                    /* access modifiers changed from: protected */
                    public void onPreExecute() {
                        cancellationSignal2.setOnCancelListener(new CancellationSignal.OnCancelListener() {
                            public void onCancel() {
                                PrintUriAdapter.this.a();
                                AnonymousClass1.this.cancel(false);
                            }
                        });
                    }
                }.execute(new Uri[0]);
            }
        }

        public void onWrite(PageRange[] pageRangeArr, ParcelFileDescriptor parcelFileDescriptor, CancellationSignal cancellationSignal, PrintDocumentAdapter.WriteResultCallback writeResultCallback) {
            PrintHelper.this.r(this.f15052e, this.f15051d, this.f15054g, parcelFileDescriptor, cancellationSignal, writeResultCallback);
        }
    }

    static {
        int i2 = Build.VERSION.SDK_INT;
        boolean z = true;
        f15022i = i2 > 23;
        if (i2 == 23) {
            z = false;
        }
        f15023j = z;
    }

    public PrintHelper(@NonNull Context context) {
        this.f15028a = context;
    }

    static Bitmap a(Bitmap bitmap, int i2) {
        if (i2 != 1) {
            return bitmap;
        }
        Bitmap createBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        Paint paint = new Paint();
        ColorMatrix colorMatrix = new ColorMatrix();
        colorMatrix.setSaturation(0.0f);
        paint.setColorFilter(new ColorMatrixColorFilter(colorMatrix));
        canvas.drawBitmap(bitmap, 0.0f, 0.0f, paint);
        canvas.setBitmap((Bitmap) null);
        return createBitmap;
    }

    @RequiresApi(19)
    private static PrintAttributes.Builder b(PrintAttributes printAttributes) {
        PrintAttributes.Builder minMargins = new PrintAttributes.Builder().setMediaSize(printAttributes.getMediaSize()).setResolution(printAttributes.getResolution()).setMinMargins(printAttributes.getMinMargins());
        if (printAttributes.getColorMode() != 0) {
            minMargins.setColorMode(printAttributes.getColorMode());
        }
        if (Build.VERSION.SDK_INT >= 23 && printAttributes.getDuplexMode() != 0) {
            PrintAttributes.Builder unused = minMargins.setDuplexMode(printAttributes.getDuplexMode());
        }
        return minMargins;
    }

    static Matrix d(int i2, int i3, RectF rectF, int i4) {
        Matrix matrix = new Matrix();
        float f2 = (float) i2;
        float width = rectF.width() / f2;
        float max = i4 == 2 ? Math.max(width, rectF.height() / ((float) i3)) : Math.min(width, rectF.height() / ((float) i3));
        matrix.postScale(max, max);
        matrix.postTranslate((rectF.width() - (f2 * max)) / 2.0f, (rectF.height() - (((float) i3) * max)) / 2.0f);
        return matrix;
    }

    static boolean g(Bitmap bitmap) {
        return bitmap.getWidth() <= bitmap.getHeight();
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x0028 A[SYNTHETIC, Splitter:B:19:0x0028] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private android.graphics.Bitmap h(android.net.Uri r5, android.graphics.BitmapFactory.Options r6) throws java.io.FileNotFoundException {
        /*
            r4 = this;
            java.lang.String r0 = "close fail "
            java.lang.String r1 = "PrintHelper"
            if (r5 == 0) goto L_0x0031
            android.content.Context r2 = r4.f15028a
            if (r2 == 0) goto L_0x0031
            r3 = 0
            android.content.ContentResolver r2 = r2.getContentResolver()     // Catch:{ all -> 0x0025 }
            java.io.InputStream r5 = r2.openInputStream(r5)     // Catch:{ all -> 0x0025 }
            android.graphics.Bitmap r6 = android.graphics.BitmapFactory.decodeStream(r5, r3, r6)     // Catch:{ all -> 0x0022 }
            if (r5 == 0) goto L_0x0021
            r5.close()     // Catch:{ IOException -> 0x001d }
            goto L_0x0021
        L_0x001d:
            r5 = move-exception
            android.util.Log.w(r1, r0, r5)
        L_0x0021:
            return r6
        L_0x0022:
            r6 = move-exception
            r3 = r5
            goto L_0x0026
        L_0x0025:
            r6 = move-exception
        L_0x0026:
            if (r3 == 0) goto L_0x0030
            r3.close()     // Catch:{ IOException -> 0x002c }
            goto L_0x0030
        L_0x002c:
            r5 = move-exception
            android.util.Log.w(r1, r0, r5)
        L_0x0030:
            throw r6
        L_0x0031:
            java.lang.IllegalArgumentException r5 = new java.lang.IllegalArgumentException
            java.lang.String r6 = "bad argument to loadBitmap"
            r5.<init>(r6)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.print.PrintHelper.h(android.net.Uri, android.graphics.BitmapFactory$Options):android.graphics.Bitmap");
    }

    public static boolean q() {
        return true;
    }

    public int c() {
        return this.f15032e;
    }

    public int e() {
        int i2 = this.f15033f;
        if (i2 == 0) {
            return 1;
        }
        return i2;
    }

    public int f() {
        return this.f15031d;
    }

    /* access modifiers changed from: package-private */
    public Bitmap i(Uri uri) throws FileNotFoundException {
        BitmapFactory.Options options;
        if (uri == null || this.f15028a == null) {
            throw new IllegalArgumentException("bad argument to getScaledBitmap");
        }
        BitmapFactory.Options options2 = new BitmapFactory.Options();
        options2.inJustDecodeBounds = true;
        h(uri, options2);
        int i2 = options2.outWidth;
        int i3 = options2.outHeight;
        if (i2 > 0 && i3 > 0) {
            int max = Math.max(i2, i3);
            int i4 = 1;
            while (max > f15021h) {
                max >>>= 1;
                i4 <<= 1;
            }
            if (i4 > 0 && Math.min(i2, i3) / i4 > 0) {
                synchronized (this.f15030c) {
                    options = new BitmapFactory.Options();
                    this.f15029b = options;
                    options.inMutable = true;
                    options.inSampleSize = i4;
                }
                try {
                    Bitmap h2 = h(uri, options);
                    synchronized (this.f15030c) {
                        this.f15029b = null;
                    }
                    return h2;
                } catch (Throwable th) {
                    synchronized (this.f15030c) {
                        this.f15029b = null;
                        throw th;
                    }
                }
            }
        }
        return null;
    }

    public void j(@NonNull String str, @NonNull Bitmap bitmap) {
        k(str, bitmap, (OnPrintFinishCallback) null);
    }

    public void k(@NonNull String str, @NonNull Bitmap bitmap, @Nullable OnPrintFinishCallback onPrintFinishCallback) {
        if (bitmap != null) {
            ((PrintManager) this.f15028a.getSystemService("print")).print(str, new PrintBitmapAdapter(str, this.f15031d, bitmap, onPrintFinishCallback), new PrintAttributes.Builder().setMediaSize(g(bitmap) ? PrintAttributes.MediaSize.UNKNOWN_PORTRAIT : PrintAttributes.MediaSize.UNKNOWN_LANDSCAPE).setColorMode(this.f15032e).build());
        }
    }

    public void l(@NonNull String str, @NonNull Uri uri) throws FileNotFoundException {
        m(str, uri, (OnPrintFinishCallback) null);
    }

    public void m(@NonNull String str, @NonNull Uri uri, @Nullable OnPrintFinishCallback onPrintFinishCallback) throws FileNotFoundException {
        PrintAttributes.MediaSize mediaSize;
        PrintUriAdapter printUriAdapter = new PrintUriAdapter(str, uri, onPrintFinishCallback, this.f15031d);
        PrintManager printManager = (PrintManager) this.f15028a.getSystemService("print");
        PrintAttributes.Builder builder = new PrintAttributes.Builder();
        builder.setColorMode(this.f15032e);
        int i2 = this.f15033f;
        if (i2 == 1 || i2 == 0) {
            mediaSize = PrintAttributes.MediaSize.UNKNOWN_LANDSCAPE;
        } else {
            if (i2 == 2) {
                mediaSize = PrintAttributes.MediaSize.UNKNOWN_PORTRAIT;
            }
            printManager.print(str, printUriAdapter, builder.build());
        }
        builder.setMediaSize(mediaSize);
        printManager.print(str, printUriAdapter, builder.build());
    }

    public void n(int i2) {
        this.f15032e = i2;
    }

    public void o(int i2) {
        this.f15033f = i2;
    }

    public void p(int i2) {
        this.f15031d = i2;
    }

    /* access modifiers changed from: package-private */
    @RequiresApi(19)
    public void r(PrintAttributes printAttributes, int i2, Bitmap bitmap, ParcelFileDescriptor parcelFileDescriptor, CancellationSignal cancellationSignal, PrintDocumentAdapter.WriteResultCallback writeResultCallback) {
        final PrintAttributes build = f15023j ? printAttributes : b(printAttributes).setMinMargins(new PrintAttributes.Margins(0, 0, 0, 0)).build();
        final CancellationSignal cancellationSignal2 = cancellationSignal;
        final Bitmap bitmap2 = bitmap;
        final PrintAttributes printAttributes2 = printAttributes;
        final int i3 = i2;
        final ParcelFileDescriptor parcelFileDescriptor2 = parcelFileDescriptor;
        final PrintDocumentAdapter.WriteResultCallback writeResultCallback2 = writeResultCallback;
        new AsyncTask<Void, Void, Throwable>() {
            /* access modifiers changed from: protected */
            /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
            /* JADX WARNING: Missing exception handler attribute for start block: B:27:0x00a5 */
            /* JADX WARNING: Missing exception handler attribute for start block: B:39:0x00c5 */
            /* JADX WARNING: Missing exception handler attribute for start block: B:48:0x00d7 */
            /* JADX WARNING: Removed duplicated region for block: B:30:0x00a9 A[Catch:{ all -> 0x0041, all -> 0x00a3 }] */
            /* JADX WARNING: Removed duplicated region for block: B:42:0x00c9 A[Catch:{ all -> 0x0041, all -> 0x00a3 }] */
            /* JADX WARNING: Removed duplicated region for block: B:51:0x00db A[Catch:{ all -> 0x0041, all -> 0x00a3 }] */
            /* renamed from: a */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public java.lang.Throwable doInBackground(java.lang.Void... r9) {
                /*
                    r8 = this;
                    android.os.CancellationSignal r9 = r4     // Catch:{ all -> 0x00a3 }
                    boolean r9 = r9.isCanceled()     // Catch:{ all -> 0x00a3 }
                    r0 = 0
                    if (r9 == 0) goto L_0x000a
                    return r0
                L_0x000a:
                    android.print.pdf.PrintedPdfDocument r9 = new android.print.pdf.PrintedPdfDocument     // Catch:{ all -> 0x00a3 }
                    androidx.print.PrintHelper r1 = androidx.print.PrintHelper.this     // Catch:{ all -> 0x00a3 }
                    android.content.Context r1 = r1.f15028a     // Catch:{ all -> 0x00a3 }
                    android.print.PrintAttributes r2 = r5     // Catch:{ all -> 0x00a3 }
                    r9.<init>(r1, r2)     // Catch:{ all -> 0x00a3 }
                    android.graphics.Bitmap r1 = r6     // Catch:{ all -> 0x00a3 }
                    android.print.PrintAttributes r2 = r5     // Catch:{ all -> 0x00a3 }
                    int r2 = r2.getColorMode()     // Catch:{ all -> 0x00a3 }
                    android.graphics.Bitmap r1 = androidx.print.PrintHelper.a(r1, r2)     // Catch:{ all -> 0x00a3 }
                    android.os.CancellationSignal r2 = r4     // Catch:{ all -> 0x00a3 }
                    boolean r2 = r2.isCanceled()     // Catch:{ all -> 0x00a3 }
                    if (r2 == 0) goto L_0x002a
                    return r0
                L_0x002a:
                    r2 = 1
                    android.graphics.pdf.PdfDocument$Page r3 = r9.startPage(r2)     // Catch:{ all -> 0x0041 }
                    boolean r4 = androidx.print.PrintHelper.f15023j     // Catch:{ all -> 0x0041 }
                    if (r4 == 0) goto L_0x0044
                    android.graphics.RectF r2 = new android.graphics.RectF     // Catch:{ all -> 0x0041 }
                    android.graphics.pdf.PdfDocument$PageInfo r5 = r3.getInfo()     // Catch:{ all -> 0x0041 }
                    android.graphics.Rect r5 = r5.getContentRect()     // Catch:{ all -> 0x0041 }
                    r2.<init>(r5)     // Catch:{ all -> 0x0041 }
                    goto L_0x0067
                L_0x0041:
                    r0 = move-exception
                    goto L_0x00cd
                L_0x0044:
                    android.print.pdf.PrintedPdfDocument r5 = new android.print.pdf.PrintedPdfDocument     // Catch:{ all -> 0x0041 }
                    androidx.print.PrintHelper r6 = androidx.print.PrintHelper.this     // Catch:{ all -> 0x0041 }
                    android.content.Context r6 = r6.f15028a     // Catch:{ all -> 0x0041 }
                    android.print.PrintAttributes r7 = r7     // Catch:{ all -> 0x0041 }
                    r5.<init>(r6, r7)     // Catch:{ all -> 0x0041 }
                    android.graphics.pdf.PdfDocument$Page r2 = r5.startPage(r2)     // Catch:{ all -> 0x0041 }
                    android.graphics.RectF r6 = new android.graphics.RectF     // Catch:{ all -> 0x0041 }
                    android.graphics.pdf.PdfDocument$PageInfo r7 = r2.getInfo()     // Catch:{ all -> 0x0041 }
                    android.graphics.Rect r7 = r7.getContentRect()     // Catch:{ all -> 0x0041 }
                    r6.<init>(r7)     // Catch:{ all -> 0x0041 }
                    r5.finishPage(r2)     // Catch:{ all -> 0x0041 }
                    r5.close()     // Catch:{ all -> 0x0041 }
                    r2 = r6
                L_0x0067:
                    int r5 = r1.getWidth()     // Catch:{ all -> 0x0041 }
                    int r6 = r1.getHeight()     // Catch:{ all -> 0x0041 }
                    int r7 = r8     // Catch:{ all -> 0x0041 }
                    android.graphics.Matrix r5 = androidx.print.PrintHelper.d(r5, r6, r2, r7)     // Catch:{ all -> 0x0041 }
                    if (r4 == 0) goto L_0x0078
                    goto L_0x0086
                L_0x0078:
                    float r4 = r2.left     // Catch:{ all -> 0x0041 }
                    float r6 = r2.top     // Catch:{ all -> 0x0041 }
                    r5.postTranslate(r4, r6)     // Catch:{ all -> 0x0041 }
                    android.graphics.Canvas r4 = r3.getCanvas()     // Catch:{ all -> 0x0041 }
                    r4.clipRect(r2)     // Catch:{ all -> 0x0041 }
                L_0x0086:
                    android.graphics.Canvas r2 = r3.getCanvas()     // Catch:{ all -> 0x0041 }
                    r2.drawBitmap(r1, r5, r0)     // Catch:{ all -> 0x0041 }
                    r9.finishPage(r3)     // Catch:{ all -> 0x0041 }
                    android.os.CancellationSignal r2 = r4     // Catch:{ all -> 0x0041 }
                    boolean r2 = r2.isCanceled()     // Catch:{ all -> 0x0041 }
                    if (r2 == 0) goto L_0x00ad
                    r9.close()     // Catch:{ all -> 0x00a3 }
                    android.os.ParcelFileDescriptor r9 = r9     // Catch:{ all -> 0x00a3 }
                    if (r9 == 0) goto L_0x00a5
                    r9.close()     // Catch:{ IOException -> 0x00a5 }
                    goto L_0x00a5
                L_0x00a3:
                    r9 = move-exception
                    goto L_0x00df
                L_0x00a5:
                    android.graphics.Bitmap r9 = r6     // Catch:{ all -> 0x00a3 }
                    if (r1 == r9) goto L_0x00ac
                    r1.recycle()     // Catch:{ all -> 0x00a3 }
                L_0x00ac:
                    return r0
                L_0x00ad:
                    java.io.FileOutputStream r2 = new java.io.FileOutputStream     // Catch:{ all -> 0x0041 }
                    android.os.ParcelFileDescriptor r3 = r9     // Catch:{ all -> 0x0041 }
                    java.io.FileDescriptor r3 = r3.getFileDescriptor()     // Catch:{ all -> 0x0041 }
                    r2.<init>(r3)     // Catch:{ all -> 0x0041 }
                    r9.writeTo(r2)     // Catch:{ all -> 0x0041 }
                    r9.close()     // Catch:{ all -> 0x00a3 }
                    android.os.ParcelFileDescriptor r9 = r9     // Catch:{ all -> 0x00a3 }
                    if (r9 == 0) goto L_0x00c5
                    r9.close()     // Catch:{ IOException -> 0x00c5 }
                L_0x00c5:
                    android.graphics.Bitmap r9 = r6     // Catch:{ all -> 0x00a3 }
                    if (r1 == r9) goto L_0x00cc
                    r1.recycle()     // Catch:{ all -> 0x00a3 }
                L_0x00cc:
                    return r0
                L_0x00cd:
                    r9.close()     // Catch:{ all -> 0x00a3 }
                    android.os.ParcelFileDescriptor r9 = r9     // Catch:{ all -> 0x00a3 }
                    if (r9 == 0) goto L_0x00d7
                    r9.close()     // Catch:{ IOException -> 0x00d7 }
                L_0x00d7:
                    android.graphics.Bitmap r9 = r6     // Catch:{ all -> 0x00a3 }
                    if (r1 == r9) goto L_0x00de
                    r1.recycle()     // Catch:{ all -> 0x00a3 }
                L_0x00de:
                    throw r0     // Catch:{ all -> 0x00a3 }
                L_0x00df:
                    return r9
                */
                throw new UnsupportedOperationException("Method not decompiled: androidx.print.PrintHelper.AnonymousClass1.doInBackground(java.lang.Void[]):java.lang.Throwable");
            }

            /* access modifiers changed from: protected */
            /* renamed from: b */
            public void onPostExecute(Throwable th) {
                if (cancellationSignal2.isCanceled()) {
                    writeResultCallback2.onWriteCancelled();
                } else if (th == null) {
                    writeResultCallback2.onWriteFinished(new PageRange[]{PageRange.ALL_PAGES});
                } else {
                    Log.e(PrintHelper.f15020g, "Error writing printed content", th);
                    writeResultCallback2.onWriteFailed((CharSequence) null);
                }
            }
        }.execute(new Void[0]);
    }
}
