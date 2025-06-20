package androidx.core.graphics.drawable;

import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.Shader;
import android.graphics.drawable.AdaptiveIconDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Icon;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.ColorInt;
import androidx.annotation.DoNotInline;
import androidx.annotation.DrawableRes;
import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.core.content.ContextCompat;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.util.ObjectsCompat;
import androidx.core.util.Preconditions;
import androidx.core.view.ViewCompat;
import androidx.versionedparcelable.CustomVersionedParcelable;
import com.itextpdf.text.Annotation;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.InvocationTargetException;
import java.nio.charset.Charset;
import org.apache.commons.lang3.StringUtils;

public class IconCompat extends CustomVersionedParcelable {
    @VisibleForTesting
    static final String A = "obj";
    @VisibleForTesting
    static final String B = "int1";
    @VisibleForTesting
    static final String C = "int2";
    @VisibleForTesting
    static final String D = "tint_list";
    @VisibleForTesting
    static final String E = "tint_mode";
    @VisibleForTesting
    static final String F = "string1";
    static final PorterDuff.Mode G = PorterDuff.Mode.SRC_IN;

    /* renamed from: k  reason: collision with root package name */
    private static final String f5898k = "IconCompat";

    /* renamed from: l  reason: collision with root package name */
    public static final int f5899l = -1;

    /* renamed from: m  reason: collision with root package name */
    public static final int f5900m = 1;

    /* renamed from: n  reason: collision with root package name */
    public static final int f5901n = 2;
    public static final int o = 3;
    public static final int p = 4;
    public static final int q = 5;
    public static final int r = 6;
    private static final float s = 0.25f;
    private static final float t = 0.6666667f;
    private static final float u = 0.9166667f;
    private static final float v = 0.010416667f;
    private static final float w = 0.020833334f;
    private static final int x = 61;
    private static final int y = 30;
    @VisibleForTesting
    static final String z = "type";
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})

    /* renamed from: a  reason: collision with root package name */
    public int f5902a;

    /* renamed from: b  reason: collision with root package name */
    Object f5903b;
    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY})

    /* renamed from: c  reason: collision with root package name */
    public byte[] f5904c;
    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY})

    /* renamed from: d  reason: collision with root package name */
    public Parcelable f5905d;
    @RestrictTo({RestrictTo.Scope.LIBRARY})

    /* renamed from: e  reason: collision with root package name */
    public int f5906e;
    @RestrictTo({RestrictTo.Scope.LIBRARY})

    /* renamed from: f  reason: collision with root package name */
    public int f5907f;
    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY})

    /* renamed from: g  reason: collision with root package name */
    public ColorStateList f5908g;

    /* renamed from: h  reason: collision with root package name */
    PorterDuff.Mode f5909h;
    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY})

    /* renamed from: i  reason: collision with root package name */
    public String f5910i;
    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY})

    /* renamed from: j  reason: collision with root package name */
    public String f5911j;

    @RequiresApi(23)
    static class Api23Impl {
        private Api23Impl() {
        }

        @Nullable
        static IconCompat a(@NonNull Context context, @NonNull Icon icon) {
            int e2 = e(icon);
            if (e2 == 2) {
                String d2 = d(icon);
                try {
                    return IconCompat.x(IconCompat.B(context, d2), d2, c(icon));
                } catch (Resources.NotFoundException unused) {
                    throw new IllegalArgumentException("Icon resource cannot be found");
                }
            } else if (e2 == 4) {
                return IconCompat.t(f(icon));
            } else {
                if (e2 == 6) {
                    return IconCompat.q(f(icon));
                }
                IconCompat iconCompat = new IconCompat(-1);
                iconCompat.f5903b = icon;
                return iconCompat;
            }
        }

        static IconCompat b(@NonNull Object obj) {
            Preconditions.l(obj);
            int e2 = e(obj);
            if (e2 == 2) {
                return IconCompat.x((Resources) null, d(obj), c(obj));
            }
            if (e2 == 4) {
                return IconCompat.t(f(obj));
            }
            if (e2 == 6) {
                return IconCompat.q(f(obj));
            }
            IconCompat iconCompat = new IconCompat(-1);
            iconCompat.f5903b = obj;
            return iconCompat;
        }

        @IdRes
        @DrawableRes
        static int c(@NonNull Object obj) {
            if (Build.VERSION.SDK_INT >= 28) {
                return Api28Impl.a(obj);
            }
            try {
                return ((Integer) obj.getClass().getMethod("getResId", (Class[]) null).invoke(obj, (Object[]) null)).intValue();
            } catch (IllegalAccessException e2) {
                Log.e(IconCompat.f5898k, "Unable to get icon resource", e2);
                return 0;
            } catch (InvocationTargetException e3) {
                Log.e(IconCompat.f5898k, "Unable to get icon resource", e3);
                return 0;
            } catch (NoSuchMethodException e4) {
                Log.e(IconCompat.f5898k, "Unable to get icon resource", e4);
                return 0;
            }
        }

        @Nullable
        static String d(@NonNull Object obj) {
            if (Build.VERSION.SDK_INT >= 28) {
                return Api28Impl.b(obj);
            }
            try {
                return (String) obj.getClass().getMethod("getResPackage", (Class[]) null).invoke(obj, (Object[]) null);
            } catch (IllegalAccessException e2) {
                Log.e(IconCompat.f5898k, "Unable to get icon package", e2);
                return null;
            } catch (InvocationTargetException e3) {
                Log.e(IconCompat.f5898k, "Unable to get icon package", e3);
                return null;
            } catch (NoSuchMethodException e4) {
                Log.e(IconCompat.f5898k, "Unable to get icon package", e4);
                return null;
            }
        }

        static int e(@NonNull Object obj) {
            StringBuilder sb;
            if (Build.VERSION.SDK_INT >= 28) {
                return Api28Impl.c(obj);
            }
            try {
                return ((Integer) obj.getClass().getMethod("getType", (Class[]) null).invoke(obj, (Object[]) null)).intValue();
            } catch (IllegalAccessException e2) {
                e = e2;
                sb = new StringBuilder();
                sb.append("Unable to get icon type ");
                sb.append(obj);
                Log.e(IconCompat.f5898k, sb.toString(), e);
                return -1;
            } catch (InvocationTargetException e3) {
                e = e3;
                sb = new StringBuilder();
                sb.append("Unable to get icon type ");
                sb.append(obj);
                Log.e(IconCompat.f5898k, sb.toString(), e);
                return -1;
            } catch (NoSuchMethodException e4) {
                e = e4;
                sb = new StringBuilder();
                sb.append("Unable to get icon type ");
                sb.append(obj);
                Log.e(IconCompat.f5898k, sb.toString(), e);
                return -1;
            }
        }

        @DoNotInline
        @Nullable
        static Uri f(@NonNull Object obj) {
            if (Build.VERSION.SDK_INT >= 28) {
                return Api28Impl.d(obj);
            }
            try {
                return (Uri) obj.getClass().getMethod("getUri", (Class[]) null).invoke(obj, (Object[]) null);
            } catch (IllegalAccessException e2) {
                Log.e(IconCompat.f5898k, "Unable to get icon uri", e2);
                return null;
            } catch (InvocationTargetException e3) {
                Log.e(IconCompat.f5898k, "Unable to get icon uri", e3);
                return null;
            } catch (NoSuchMethodException e4) {
                Log.e(IconCompat.f5898k, "Unable to get icon uri", e4);
                return null;
            }
        }

        @DoNotInline
        static Drawable g(Icon icon, Context context) {
            return icon.loadDrawable(context);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:11:0x002c, code lost:
            if (r0 >= 26) goto L_0x002e;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:12:0x002e, code lost:
            r5 = androidx.core.graphics.drawable.IconCompat.Api26Impl.b(r5);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:13:0x0034, code lost:
            r5 = androidx.core.graphics.drawable.IconCompat.o(r5, false);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:14:0x0038, code lost:
            r5 = android.graphics.drawable.Icon.createWithBitmap(r5);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:27:0x00a7, code lost:
            r0 = r4.f5908g;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:28:0x00a9, code lost:
            if (r0 == null) goto L_0x00ae;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:29:0x00ab, code lost:
            r5.setTintList(r0);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:30:0x00ae, code lost:
            r4 = r4.f5909h;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:31:0x00b2, code lost:
            if (r4 == androidx.core.graphics.drawable.IconCompat.G) goto L_0x00b7;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:32:0x00b4, code lost:
            r5.setTintMode(r4);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:33:0x00b7, code lost:
            return r5;
         */
        @androidx.annotation.DoNotInline
        /* Code decompiled incorrectly, please refer to instructions dump. */
        static android.graphics.drawable.Icon h(androidx.core.graphics.drawable.IconCompat r4, android.content.Context r5) {
            /*
                int r0 = r4.f5902a
                r1 = 0
                r2 = 26
                switch(r0) {
                    case -1: goto L_0x00b8;
                    case 0: goto L_0x0008;
                    case 1: goto L_0x00a2;
                    case 2: goto L_0x0097;
                    case 3: goto L_0x008a;
                    case 4: goto L_0x0081;
                    case 5: goto L_0x0073;
                    case 6: goto L_0x0010;
                    default: goto L_0x0008;
                }
            L_0x0008:
                java.lang.IllegalArgumentException r4 = new java.lang.IllegalArgumentException
                java.lang.String r5 = "Unknown type"
                r4.<init>(r5)
                throw r4
            L_0x0010:
                int r0 = android.os.Build.VERSION.SDK_INT
                r3 = 30
                if (r0 < r3) goto L_0x0020
                android.net.Uri r5 = r4.D()
                android.graphics.drawable.Icon r5 = androidx.core.graphics.drawable.IconCompat.Api30Impl.a(r5)
                goto L_0x00a7
            L_0x0020:
                if (r5 == 0) goto L_0x0058
                java.io.InputStream r5 = r4.E(r5)
                if (r5 == 0) goto L_0x003d
                android.graphics.Bitmap r5 = android.graphics.BitmapFactory.decodeStream(r5)
                if (r0 < r2) goto L_0x0034
            L_0x002e:
                android.graphics.drawable.Icon r5 = androidx.core.graphics.drawable.IconCompat.Api26Impl.b(r5)
                goto L_0x00a7
            L_0x0034:
                android.graphics.Bitmap r5 = androidx.core.graphics.drawable.IconCompat.o(r5, r1)
            L_0x0038:
                android.graphics.drawable.Icon r5 = android.graphics.drawable.Icon.createWithBitmap(r5)
                goto L_0x00a7
            L_0x003d:
                java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                r0.<init>()
                java.lang.String r1 = "Cannot load adaptive icon from uri: "
                r0.append(r1)
                android.net.Uri r4 = r4.D()
                r0.append(r4)
                java.lang.String r4 = r0.toString()
                r5.<init>(r4)
                throw r5
            L_0x0058:
                java.lang.IllegalArgumentException r5 = new java.lang.IllegalArgumentException
                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                r0.<init>()
                java.lang.String r1 = "Context is required to resolve the file uri of the icon: "
                r0.append(r1)
                android.net.Uri r4 = r4.D()
                r0.append(r4)
                java.lang.String r4 = r0.toString()
                r5.<init>(r4)
                throw r5
            L_0x0073:
                int r5 = android.os.Build.VERSION.SDK_INT
                if (r5 < r2) goto L_0x007c
                java.lang.Object r5 = r4.f5903b
                android.graphics.Bitmap r5 = (android.graphics.Bitmap) r5
                goto L_0x002e
            L_0x007c:
                java.lang.Object r5 = r4.f5903b
                android.graphics.Bitmap r5 = (android.graphics.Bitmap) r5
                goto L_0x0034
            L_0x0081:
                java.lang.Object r5 = r4.f5903b
                java.lang.String r5 = (java.lang.String) r5
                android.graphics.drawable.Icon r5 = android.graphics.drawable.Icon.createWithContentUri(r5)
                goto L_0x00a7
            L_0x008a:
                java.lang.Object r5 = r4.f5903b
                byte[] r5 = (byte[]) r5
                int r0 = r4.f5906e
                int r1 = r4.f5907f
                android.graphics.drawable.Icon r5 = android.graphics.drawable.Icon.createWithData(r5, r0, r1)
                goto L_0x00a7
            L_0x0097:
                java.lang.String r5 = r4.A()
                int r0 = r4.f5906e
                android.graphics.drawable.Icon r5 = android.graphics.drawable.Icon.createWithResource(r5, r0)
                goto L_0x00a7
            L_0x00a2:
                java.lang.Object r5 = r4.f5903b
                android.graphics.Bitmap r5 = (android.graphics.Bitmap) r5
                goto L_0x0038
            L_0x00a7:
                android.content.res.ColorStateList r0 = r4.f5908g
                if (r0 == 0) goto L_0x00ae
                r5.setTintList(r0)
            L_0x00ae:
                android.graphics.PorterDuff$Mode r4 = r4.f5909h
                android.graphics.PorterDuff$Mode r0 = androidx.core.graphics.drawable.IconCompat.G
                if (r4 == r0) goto L_0x00b7
                r5.setTintMode(r4)
            L_0x00b7:
                return r5
            L_0x00b8:
                java.lang.Object r4 = r4.f5903b
                android.graphics.drawable.Icon r4 = (android.graphics.drawable.Icon) r4
                return r4
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.core.graphics.drawable.IconCompat.Api23Impl.h(androidx.core.graphics.drawable.IconCompat, android.content.Context):android.graphics.drawable.Icon");
        }
    }

    @RequiresApi(26)
    static class Api26Impl {
        private Api26Impl() {
        }

        @DoNotInline
        static Drawable a(Drawable drawable, Drawable drawable2) {
            return new AdaptiveIconDrawable(drawable, drawable2);
        }

        @DoNotInline
        static Icon b(Bitmap bitmap) {
            return Icon.createWithAdaptiveBitmap(bitmap);
        }
    }

    @RequiresApi(28)
    static class Api28Impl {
        private Api28Impl() {
        }

        @DoNotInline
        static int a(Object obj) {
            return ((Icon) obj).getResId();
        }

        @DoNotInline
        static String b(Object obj) {
            return ((Icon) obj).getResPackage();
        }

        @DoNotInline
        static int c(Object obj) {
            return ((Icon) obj).getType();
        }

        @DoNotInline
        static Uri d(Object obj) {
            return ((Icon) obj).getUri();
        }
    }

    @RequiresApi(30)
    static class Api30Impl {
        private Api30Impl() {
        }

        @DoNotInline
        static Icon a(Uri uri) {
            return Icon.createWithAdaptiveBitmapContentUri(uri);
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    @Retention(RetentionPolicy.SOURCE)
    public @interface IconType {
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public IconCompat() {
        this.f5902a = -1;
        this.f5904c = null;
        this.f5905d = null;
        this.f5906e = 0;
        this.f5907f = 0;
        this.f5908g = null;
        this.f5909h = G;
        this.f5910i = null;
    }

    static Resources B(Context context, String str) {
        if ("android".equals(str)) {
            return Resources.getSystem();
        }
        PackageManager packageManager = context.getPackageManager();
        try {
            ApplicationInfo applicationInfo = packageManager.getApplicationInfo(str, 8192);
            if (applicationInfo != null) {
                return packageManager.getResourcesForApplication(applicationInfo);
            }
            return null;
        } catch (PackageManager.NameNotFoundException e2) {
            Log.e(f5898k, String.format("Unable to find pkg=%s for icon", new Object[]{str}), e2);
            return null;
        }
    }

    private Drawable G(Context context) {
        switch (this.f5902a) {
            case 1:
                return new BitmapDrawable(context.getResources(), (Bitmap) this.f5903b);
            case 2:
                String A2 = A();
                if (TextUtils.isEmpty(A2)) {
                    A2 = context.getPackageName();
                }
                try {
                    return ResourcesCompat.g(B(context, A2), this.f5906e, context.getTheme());
                } catch (RuntimeException e2) {
                    Log.e(f5898k, String.format("Unable to load resource 0x%08x from pkg=%s", new Object[]{Integer.valueOf(this.f5906e), this.f5903b}), e2);
                    break;
                }
            case 3:
                return new BitmapDrawable(context.getResources(), BitmapFactory.decodeByteArray((byte[]) this.f5903b, this.f5906e, this.f5907f));
            case 4:
                InputStream E2 = E(context);
                if (E2 != null) {
                    return new BitmapDrawable(context.getResources(), BitmapFactory.decodeStream(E2));
                }
                break;
            case 5:
                return new BitmapDrawable(context.getResources(), o((Bitmap) this.f5903b, false));
            case 6:
                InputStream E3 = E(context);
                if (E3 != null) {
                    return Build.VERSION.SDK_INT >= 26 ? Api26Impl.a((Drawable) null, new BitmapDrawable(context.getResources(), BitmapFactory.decodeStream(E3))) : new BitmapDrawable(context.getResources(), o(BitmapFactory.decodeStream(E3), false));
                }
                break;
        }
        return null;
    }

    private static String N(int i2) {
        switch (i2) {
            case 1:
                return "BITMAP";
            case 2:
                return "RESOURCE";
            case 3:
                return "DATA";
            case 4:
                return "URI";
            case 5:
                return "BITMAP_MASKABLE";
            case 6:
                return "URI_MASKABLE";
            default:
                return "UNKNOWN";
        }
    }

    @Nullable
    public static IconCompat k(@NonNull Bundle bundle) {
        int i2 = bundle.getInt("type");
        IconCompat iconCompat = new IconCompat(i2);
        iconCompat.f5906e = bundle.getInt(B);
        iconCompat.f5907f = bundle.getInt(C);
        iconCompat.f5911j = bundle.getString(F);
        if (bundle.containsKey(D)) {
            iconCompat.f5908g = (ColorStateList) bundle.getParcelable(D);
        }
        if (bundle.containsKey(E)) {
            iconCompat.f5909h = PorterDuff.Mode.valueOf(bundle.getString(E));
        }
        switch (i2) {
            case -1:
            case 1:
            case 5:
                iconCompat.f5903b = bundle.getParcelable(A);
                break;
            case 2:
            case 4:
            case 6:
                iconCompat.f5903b = bundle.getString(A);
                break;
            case 3:
                iconCompat.f5903b = bundle.getByteArray(A);
                break;
            default:
                Log.w(f5898k, "Unknown type " + i2);
                return null;
        }
        return iconCompat;
    }

    @RequiresApi(23)
    @Nullable
    public static IconCompat l(@NonNull Context context, @NonNull Icon icon) {
        Preconditions.l(icon);
        return Api23Impl.a(context, icon);
    }

    @RequiresApi(23)
    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static IconCompat m(@NonNull Icon icon) {
        return Api23Impl.b(icon);
    }

    @RequiresApi(23)
    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static IconCompat n(@NonNull Icon icon) {
        if (Api23Impl.e(icon) == 2 && Api23Impl.c(icon) == 0) {
            return null;
        }
        return Api23Impl.b(icon);
    }

    @VisibleForTesting
    static Bitmap o(Bitmap bitmap, boolean z2) {
        int min = (int) (((float) Math.min(bitmap.getWidth(), bitmap.getHeight())) * t);
        Bitmap createBitmap = Bitmap.createBitmap(min, min, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        Paint paint = new Paint(3);
        float f2 = (float) min;
        float f3 = 0.5f * f2;
        float f4 = u * f3;
        if (z2) {
            float f5 = v * f2;
            paint.setColor(0);
            paint.setShadowLayer(f5, 0.0f, f2 * w, 1023410176);
            canvas.drawCircle(f3, f3, f4, paint);
            paint.setShadowLayer(f5, 0.0f, 0.0f, 503316480);
            canvas.drawCircle(f3, f3, f4, paint);
            paint.clearShadowLayer();
        }
        paint.setColor(ViewCompat.y);
        Shader.TileMode tileMode = Shader.TileMode.CLAMP;
        BitmapShader bitmapShader = new BitmapShader(bitmap, tileMode, tileMode);
        Matrix matrix = new Matrix();
        matrix.setTranslate(((float) (-(bitmap.getWidth() - min))) / 2.0f, ((float) (-(bitmap.getHeight() - min))) / 2.0f);
        bitmapShader.setLocalMatrix(matrix);
        paint.setShader(bitmapShader);
        canvas.drawCircle(f3, f3, f4, paint);
        canvas.setBitmap((Bitmap) null);
        return createBitmap;
    }

    @NonNull
    public static IconCompat p(@NonNull Bitmap bitmap) {
        ObjectsCompat.d(bitmap);
        IconCompat iconCompat = new IconCompat(5);
        iconCompat.f5903b = bitmap;
        return iconCompat;
    }

    @NonNull
    public static IconCompat q(@NonNull Uri uri) {
        ObjectsCompat.d(uri);
        return r(uri.toString());
    }

    @NonNull
    public static IconCompat r(@NonNull String str) {
        ObjectsCompat.d(str);
        IconCompat iconCompat = new IconCompat(6);
        iconCompat.f5903b = str;
        return iconCompat;
    }

    @NonNull
    public static IconCompat s(@NonNull Bitmap bitmap) {
        ObjectsCompat.d(bitmap);
        IconCompat iconCompat = new IconCompat(1);
        iconCompat.f5903b = bitmap;
        return iconCompat;
    }

    @NonNull
    public static IconCompat t(@NonNull Uri uri) {
        ObjectsCompat.d(uri);
        return u(uri.toString());
    }

    @NonNull
    public static IconCompat u(@NonNull String str) {
        ObjectsCompat.d(str);
        IconCompat iconCompat = new IconCompat(4);
        iconCompat.f5903b = str;
        return iconCompat;
    }

    @NonNull
    public static IconCompat v(@NonNull byte[] bArr, int i2, int i3) {
        ObjectsCompat.d(bArr);
        IconCompat iconCompat = new IconCompat(3);
        iconCompat.f5903b = bArr;
        iconCompat.f5906e = i2;
        iconCompat.f5907f = i3;
        return iconCompat;
    }

    @NonNull
    public static IconCompat w(@NonNull Context context, @DrawableRes int i2) {
        ObjectsCompat.d(context);
        return x(context.getResources(), context.getPackageName(), i2);
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static IconCompat x(@Nullable Resources resources, @NonNull String str, @DrawableRes int i2) {
        ObjectsCompat.d(str);
        if (i2 != 0) {
            IconCompat iconCompat = new IconCompat(2);
            iconCompat.f5906e = i2;
            if (resources != null) {
                try {
                    iconCompat.f5903b = resources.getResourceName(i2);
                } catch (Resources.NotFoundException unused) {
                    throw new IllegalArgumentException("Icon resource cannot be found");
                }
            } else {
                iconCompat.f5903b = str;
            }
            iconCompat.f5911j = str;
            return iconCompat;
        }
        throw new IllegalArgumentException("Drawable resource ID must not be 0");
    }

    @NonNull
    public String A() {
        int i2 = this.f5902a;
        if (i2 == -1 && Build.VERSION.SDK_INT >= 23) {
            return Api23Impl.d(this.f5903b);
        }
        if (i2 == 2) {
            String str = this.f5911j;
            return (str == null || TextUtils.isEmpty(str)) ? ((String) this.f5903b).split(":", -1)[0] : this.f5911j;
        }
        throw new IllegalStateException("called getResPackage() on " + this);
    }

    public int C() {
        int i2 = this.f5902a;
        return (i2 != -1 || Build.VERSION.SDK_INT < 23) ? i2 : Api23Impl.e(this.f5903b);
    }

    @NonNull
    public Uri D() {
        int i2 = this.f5902a;
        if (i2 == -1 && Build.VERSION.SDK_INT >= 23) {
            return Api23Impl.f(this.f5903b);
        }
        if (i2 == 4 || i2 == 6) {
            return Uri.parse((String) this.f5903b);
        }
        throw new IllegalStateException("called getUri() on " + this);
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public InputStream E(@NonNull Context context) {
        StringBuilder sb;
        String str;
        Uri D2 = D();
        String scheme = D2.getScheme();
        if (Annotation.i3.equals(scheme) || Annotation.k3.equals(scheme)) {
            try {
                return context.getContentResolver().openInputStream(D2);
            } catch (Exception e2) {
                e = e2;
                sb = new StringBuilder();
                str = "Unable to load image from URI: ";
                sb.append(str);
                sb.append(D2);
                Log.w(f5898k, sb.toString(), e);
                return null;
            }
        } else {
            try {
                return new FileInputStream(new File((String) this.f5903b));
            } catch (FileNotFoundException e3) {
                e = e3;
                sb = new StringBuilder();
                str = "Unable to load image from path: ";
                sb.append(str);
                sb.append(D2);
                Log.w(f5898k, sb.toString(), e);
                return null;
            }
        }
    }

    @Nullable
    public Drawable F(@NonNull Context context) {
        i(context);
        if (Build.VERSION.SDK_INT >= 23) {
            return Api23Impl.g(M(context), context);
        }
        Drawable G2 = G(context);
        if (!(G2 == null || (this.f5908g == null && this.f5909h == G))) {
            G2.mutate();
            DrawableCompat.o(G2, this.f5908g);
            DrawableCompat.p(G2, this.f5909h);
        }
        return G2;
    }

    @NonNull
    public IconCompat H(@ColorInt int i2) {
        return I(ColorStateList.valueOf(i2));
    }

    @NonNull
    public IconCompat I(@Nullable ColorStateList colorStateList) {
        this.f5908g = colorStateList;
        return this;
    }

    @NonNull
    public IconCompat J(@Nullable PorterDuff.Mode mode) {
        this.f5909h = mode;
        return this;
    }

    @NonNull
    public Bundle K() {
        Parcelable parcelable;
        Bundle bundle = new Bundle();
        switch (this.f5902a) {
            case -1:
                parcelable = (Parcelable) this.f5903b;
                break;
            case 1:
            case 5:
                parcelable = (Bitmap) this.f5903b;
                break;
            case 2:
            case 4:
            case 6:
                bundle.putString(A, (String) this.f5903b);
                break;
            case 3:
                bundle.putByteArray(A, (byte[]) this.f5903b);
                break;
            default:
                throw new IllegalArgumentException("Invalid icon");
        }
        bundle.putParcelable(A, parcelable);
        bundle.putInt("type", this.f5902a);
        bundle.putInt(B, this.f5906e);
        bundle.putInt(C, this.f5907f);
        bundle.putString(F, this.f5911j);
        ColorStateList colorStateList = this.f5908g;
        if (colorStateList != null) {
            bundle.putParcelable(D, colorStateList);
        }
        PorterDuff.Mode mode = this.f5909h;
        if (mode != G) {
            bundle.putString(E, mode.name());
        }
        return bundle;
    }

    @RequiresApi(23)
    @NonNull
    @Deprecated
    public Icon L() {
        return M((Context) null);
    }

    @RequiresApi(23)
    @NonNull
    public Icon M(@Nullable Context context) {
        if (Build.VERSION.SDK_INT >= 23) {
            return Api23Impl.h(this, context);
        }
        throw new UnsupportedOperationException("This method is only supported on API level 23+");
    }

    public void a() {
        Parcelable parcelable;
        this.f5909h = PorterDuff.Mode.valueOf(this.f5910i);
        switch (this.f5902a) {
            case -1:
                parcelable = this.f5905d;
                if (parcelable == null) {
                    throw new IllegalArgumentException("Invalid icon");
                }
                break;
            case 1:
            case 5:
                parcelable = this.f5905d;
                if (parcelable == null) {
                    byte[] bArr = this.f5904c;
                    this.f5903b = bArr;
                    this.f5902a = 3;
                    this.f5906e = 0;
                    this.f5907f = bArr.length;
                    return;
                }
                break;
            case 2:
            case 4:
            case 6:
                String str = new String(this.f5904c, Charset.forName("UTF-16"));
                this.f5903b = str;
                if (this.f5902a == 2 && this.f5911j == null) {
                    this.f5911j = str.split(":", -1)[0];
                    return;
                }
                return;
            case 3:
                this.f5903b = this.f5904c;
                return;
            default:
                return;
        }
        this.f5903b = parcelable;
    }

    public void b(boolean z2) {
        this.f5910i = this.f5909h.name();
        switch (this.f5902a) {
            case -1:
                if (z2) {
                    throw new IllegalArgumentException("Can't serialize Icon created with IconCompat#createFromIcon");
                }
                break;
            case 1:
            case 5:
                if (z2) {
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    ((Bitmap) this.f5903b).compress(Bitmap.CompressFormat.PNG, 90, byteArrayOutputStream);
                    this.f5904c = byteArrayOutputStream.toByteArray();
                    return;
                }
                break;
            case 2:
                this.f5904c = ((String) this.f5903b).getBytes(Charset.forName("UTF-16"));
                return;
            case 3:
                this.f5904c = (byte[]) this.f5903b;
                return;
            case 4:
            case 6:
                this.f5904c = this.f5903b.toString().getBytes(Charset.forName("UTF-16"));
                return;
            default:
                return;
        }
        this.f5905d = (Parcelable) this.f5903b;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void c(@NonNull Intent intent, @Nullable Drawable drawable, @NonNull Context context) {
        Bitmap bitmap;
        i(context);
        int i2 = this.f5902a;
        if (i2 == 1) {
            bitmap = (Bitmap) this.f5903b;
            if (drawable != null) {
                bitmap = bitmap.copy(bitmap.getConfig(), true);
            }
        } else if (i2 == 2) {
            try {
                Context createPackageContext = context.createPackageContext(A(), 0);
                if (drawable == null) {
                    intent.putExtra("android.intent.extra.shortcut.ICON_RESOURCE", Intent.ShortcutIconResource.fromContext(createPackageContext, this.f5906e));
                    return;
                }
                Drawable l2 = ContextCompat.l(createPackageContext, this.f5906e);
                if (l2.getIntrinsicWidth() > 0) {
                    if (l2.getIntrinsicHeight() > 0) {
                        bitmap = Bitmap.createBitmap(l2.getIntrinsicWidth(), l2.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
                        l2.setBounds(0, 0, bitmap.getWidth(), bitmap.getHeight());
                        l2.draw(new Canvas(bitmap));
                    }
                }
                int launcherLargeIconSize = ((ActivityManager) createPackageContext.getSystemService("activity")).getLauncherLargeIconSize();
                bitmap = Bitmap.createBitmap(launcherLargeIconSize, launcherLargeIconSize, Bitmap.Config.ARGB_8888);
                l2.setBounds(0, 0, bitmap.getWidth(), bitmap.getHeight());
                l2.draw(new Canvas(bitmap));
            } catch (PackageManager.NameNotFoundException e2) {
                throw new IllegalArgumentException("Can't find package " + this.f5903b, e2);
            }
        } else if (i2 == 5) {
            bitmap = o((Bitmap) this.f5903b, true);
        } else {
            throw new IllegalArgumentException("Icon type not supported for intent shortcuts");
        }
        if (drawable != null) {
            int width = bitmap.getWidth();
            int height = bitmap.getHeight();
            drawable.setBounds(width / 2, height / 2, width, height);
            drawable.draw(new Canvas(bitmap));
        }
        intent.putExtra("android.intent.extra.shortcut.ICON", bitmap);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void i(@NonNull Context context) {
        Object obj;
        if (this.f5902a == 2 && (obj = this.f5903b) != null) {
            String str = (String) obj;
            if (str.contains(":")) {
                String str2 = str.split(":", -1)[1];
                String str3 = str2.split("/", -1)[0];
                String str4 = str2.split("/", -1)[1];
                String str5 = str.split(":", -1)[0];
                if ("0_resource_name_obfuscated".equals(str4)) {
                    Log.i(f5898k, "Found obfuscated resource, not trying to update resource id for it");
                    return;
                }
                String A2 = A();
                int identifier = B(context, A2).getIdentifier(str4, str3, str5);
                if (this.f5906e != identifier) {
                    Log.i(f5898k, "Id has changed for " + A2 + StringUtils.SPACE + str);
                    this.f5906e = identifier;
                }
            }
        }
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    @androidx.annotation.NonNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String toString() {
        /*
            r4 = this;
            int r0 = r4.f5902a
            r1 = -1
            if (r0 != r1) goto L_0x000c
            java.lang.Object r0 = r4.f5903b
            java.lang.String r0 = java.lang.String.valueOf(r0)
            return r0
        L_0x000c:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = "Icon(typ="
            r0.<init>(r1)
            int r1 = r4.f5902a
            java.lang.String r1 = N(r1)
            r0.append(r1)
            int r1 = r4.f5902a
            switch(r1) {
                case 1: goto L_0x006d;
                case 2: goto L_0x0046;
                case 3: goto L_0x002d;
                case 4: goto L_0x0022;
                case 5: goto L_0x006d;
                case 6: goto L_0x0022;
                default: goto L_0x0021;
            }
        L_0x0021:
            goto L_0x008b
        L_0x0022:
            java.lang.String r1 = " uri="
            r0.append(r1)
            java.lang.Object r1 = r4.f5903b
            r0.append(r1)
            goto L_0x008b
        L_0x002d:
            java.lang.String r1 = " len="
            r0.append(r1)
            int r1 = r4.f5906e
            r0.append(r1)
            int r1 = r4.f5907f
            if (r1 == 0) goto L_0x008b
            java.lang.String r1 = " off="
            r0.append(r1)
            int r1 = r4.f5907f
        L_0x0042:
            r0.append(r1)
            goto L_0x008b
        L_0x0046:
            java.lang.String r1 = " pkg="
            r0.append(r1)
            java.lang.String r1 = r4.f5911j
            r0.append(r1)
            java.lang.String r1 = " id="
            r0.append(r1)
            int r1 = r4.z()
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            r2 = 1
            java.lang.Object[] r2 = new java.lang.Object[r2]
            r3 = 0
            r2[r3] = r1
            java.lang.String r1 = "0x%08x"
            java.lang.String r1 = java.lang.String.format(r1, r2)
            r0.append(r1)
            goto L_0x008b
        L_0x006d:
            java.lang.String r1 = " size="
            r0.append(r1)
            java.lang.Object r1 = r4.f5903b
            android.graphics.Bitmap r1 = (android.graphics.Bitmap) r1
            int r1 = r1.getWidth()
            r0.append(r1)
            java.lang.String r1 = "x"
            r0.append(r1)
            java.lang.Object r1 = r4.f5903b
            android.graphics.Bitmap r1 = (android.graphics.Bitmap) r1
            int r1 = r1.getHeight()
            goto L_0x0042
        L_0x008b:
            android.content.res.ColorStateList r1 = r4.f5908g
            if (r1 == 0) goto L_0x0099
            java.lang.String r1 = " tint="
            r0.append(r1)
            android.content.res.ColorStateList r1 = r4.f5908g
            r0.append(r1)
        L_0x0099:
            android.graphics.PorterDuff$Mode r1 = r4.f5909h
            android.graphics.PorterDuff$Mode r2 = G
            if (r1 == r2) goto L_0x00a9
            java.lang.String r1 = " mode="
            r0.append(r1)
            android.graphics.PorterDuff$Mode r1 = r4.f5909h
            r0.append(r1)
        L_0x00a9:
            java.lang.String r1 = ")"
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.graphics.drawable.IconCompat.toString():java.lang.String");
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public Bitmap y() {
        int i2 = this.f5902a;
        if (i2 == -1 && Build.VERSION.SDK_INT >= 23) {
            Object obj = this.f5903b;
            if (obj instanceof Bitmap) {
                return (Bitmap) obj;
            }
            return null;
        } else if (i2 == 1) {
            return (Bitmap) this.f5903b;
        } else {
            if (i2 == 5) {
                return o((Bitmap) this.f5903b, true);
            }
            throw new IllegalStateException("called getBitmap() on " + this);
        }
    }

    @DrawableRes
    public int z() {
        int i2 = this.f5902a;
        if (i2 == -1 && Build.VERSION.SDK_INT >= 23) {
            return Api23Impl.c(this.f5903b);
        }
        if (i2 == 2) {
            return this.f5906e;
        }
        throw new IllegalStateException("called getResId() on " + this);
    }

    IconCompat(int i2) {
        this.f5904c = null;
        this.f5905d = null;
        this.f5906e = 0;
        this.f5907f = 0;
        this.f5908g = null;
        this.f5909h = G;
        this.f5910i = null;
        this.f5902a = i2;
    }
}
