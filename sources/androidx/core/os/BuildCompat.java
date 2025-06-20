package androidx.core.os;

import android.os.Build;
import android.os.ext.SdkExtensions;
import androidx.annotation.ChecksSdkIntAtLeast;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.exifinterface.media.ExifInterface;
import java.lang.annotation.RetentionPolicy;
import java.util.Locale;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.RequiresOptIn;
import kotlin.annotation.AnnotationRetention;
import kotlin.annotation.Retention;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0010\b\n\u0002\b\b\bÆ\u0002\u0018\u00002\u00020\u0001:\u0002\u001d\u001eB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001f\u0010\b\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0007H\u0007¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\f\u001a\u00020\u0007H\u0007¢\u0006\u0004\b\f\u0010\u000bJ\u000f\u0010\r\u001a\u00020\u0007H\u0007¢\u0006\u0004\b\r\u0010\u000bJ\u000f\u0010\u000e\u001a\u00020\u0007H\u0007¢\u0006\u0004\b\u000e\u0010\u000bJ\u000f\u0010\u000f\u001a\u00020\u0007H\u0007¢\u0006\u0004\b\u000f\u0010\u000bJ\u000f\u0010\u0010\u001a\u00020\u0007H\u0007¢\u0006\u0004\b\u0010\u0010\u000bJ\u000f\u0010\u0011\u001a\u00020\u0007H\u0007¢\u0006\u0004\b\u0011\u0010\u000bJ\u000f\u0010\u0012\u001a\u00020\u0007H\u0007¢\u0006\u0004\b\u0012\u0010\u000bJ\u000f\u0010\u0013\u001a\u00020\u0007H\u0007¢\u0006\u0004\b\u0013\u0010\u000bJ\u000f\u0010\u0014\u001a\u00020\u0007H\u0007¢\u0006\u0004\b\u0014\u0010\u000bJ\u000f\u0010\u0015\u001a\u00020\u0007H\u0007¢\u0006\u0004\b\u0015\u0010\u000bJ\u000f\u0010\u0016\u001a\u00020\u0007H\u0007¢\u0006\u0004\b\u0016\u0010\u000bR\u0014\u0010\u0019\u001a\u00020\u00178\u0006X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\u0018R\u0014\u0010\u001a\u001a\u00020\u00178\u0006X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u0018R\u0014\u0010\u001b\u001a\u00020\u00178\u0006X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u0018R\u0014\u0010\u001c\u001a\u00020\u00178\u0006X\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0018¨\u0006\u001f"}, d2 = {"Landroidx/core/os/BuildCompat;", "", "<init>", "()V", "", "codename", "buildCodename", "", "f", "(Ljava/lang/String;Ljava/lang/String;)Z", "a", "()Z", "b", "c", "d", "e", "g", "h", "i", "j", "k", "l", "m", "", "I", "R_EXTENSION_INT", "S_EXTENSION_INT", "T_EXTENSION_INT", "AD_SERVICES_EXTENSION_INT", "Api30Impl", "PrereleaseSdkCheck", "core_release"}, k = 1, mv = {1, 8, 0})
public final class BuildCompat {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    public static final BuildCompat f6045a = new BuildCompat();
    @ChecksSdkIntAtLeast(extension = 30)
    @JvmField

    /* renamed from: b  reason: collision with root package name */
    public static final int f6046b;
    @ChecksSdkIntAtLeast(extension = 31)
    @JvmField

    /* renamed from: c  reason: collision with root package name */
    public static final int f6047c;
    @ChecksSdkIntAtLeast(extension = 33)
    @JvmField

    /* renamed from: d  reason: collision with root package name */
    public static final int f6048d;
    @ChecksSdkIntAtLeast(extension = 1000000)
    @JvmField

    /* renamed from: e  reason: collision with root package name */
    public static final int f6049e;

    @RequiresApi(30)
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\bÃ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Landroidx/core/os/BuildCompat$Api30Impl;", "", "<init>", "()V", "", "extension", "a", "(I)I", "core_release"}, k = 1, mv = {1, 8, 0})
    private static final class Api30Impl {
        @NotNull

        /* renamed from: a  reason: collision with root package name */
        public static final Api30Impl f6050a = new Api30Impl();

        private Api30Impl() {
        }

        @DoNotInline
        public final int a(int i2) {
            return SdkExtensions.getExtensionVersion(i2);
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0000¨\u0006\u0002"}, d2 = {"Landroidx/core/os/BuildCompat$PrereleaseSdkCheck;", "", "core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    @RequiresOptIn
    @Retention(AnnotationRetention.X)
    @java.lang.annotation.Retention(RetentionPolicy.CLASS)
    public @interface PrereleaseSdkCheck {
    }

    static {
        int i2 = Build.VERSION.SDK_INT;
        int i3 = 0;
        f6046b = i2 >= 30 ? Api30Impl.f6050a.a(30) : 0;
        f6047c = i2 >= 30 ? Api30Impl.f6050a.a(31) : 0;
        f6048d = i2 >= 30 ? Api30Impl.f6050a.a(33) : 0;
        if (i2 >= 30) {
            i3 = Api30Impl.f6050a.a(1000000);
        }
        f6049e = i3;
    }

    private BuildCompat() {
    }

    @JvmStatic
    @Deprecated(message = "Android N is a finalized release and this method is no longer necessary. It will be removed in a future release of this library. Instead, use `Build.VERSION.SDK_INT >= 24`.", replaceWith = @ReplaceWith(expression = "android.os.Build.VERSION.SDK_INT >= 24", imports = {}))
    @ChecksSdkIntAtLeast(api = 24)
    public static final boolean a() {
        return Build.VERSION.SDK_INT >= 24;
    }

    @JvmStatic
    @Deprecated(message = "Android N MR1 is a finalized release and this method is no longer necessary. It will be removed in a future release of this library. Instead, use `Build.VERSION.SDK_INT >= 25`.", replaceWith = @ReplaceWith(expression = "android.os.Build.VERSION.SDK_INT >= 25", imports = {}))
    @ChecksSdkIntAtLeast(api = 25)
    public static final boolean b() {
        return Build.VERSION.SDK_INT >= 25;
    }

    @JvmStatic
    @Deprecated(message = "Android O is a finalized release and this method is no longer necessary. It will be removed in a future release of this library. Instead use `Build.VERSION.SDK_INT >= 26`.", replaceWith = @ReplaceWith(expression = "android.os.Build.VERSION.SDK_INT >= 26", imports = {}))
    @ChecksSdkIntAtLeast(api = 26)
    public static final boolean c() {
        return Build.VERSION.SDK_INT >= 26;
    }

    @JvmStatic
    @Deprecated(message = "Android O MR1 is a finalized release and this method is no longer necessary. It will be removed in a future release of this library. Instead, use `Build.VERSION.SDK_INT >= 27`.", replaceWith = @ReplaceWith(expression = "android.os.Build.VERSION.SDK_INT >= 27", imports = {}))
    @ChecksSdkIntAtLeast(api = 27)
    public static final boolean d() {
        return Build.VERSION.SDK_INT >= 27;
    }

    @JvmStatic
    @Deprecated(message = "Android P is a finalized release and this method is no longer necessary. It will be removed in a future release of this library. Instead, use `Build.VERSION.SDK_INT >= 28`.", replaceWith = @ReplaceWith(expression = "android.os.Build.VERSION.SDK_INT >= 28", imports = {}))
    @ChecksSdkIntAtLeast(api = 28)
    public static final boolean e() {
        return Build.VERSION.SDK_INT >= 28;
    }

    @JvmStatic
    @VisibleForTesting
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static final boolean f(@NotNull String str, @NotNull String str2) {
        Intrinsics.p(str, "codename");
        Intrinsics.p(str2, "buildCodename");
        if (Intrinsics.g("REL", str2)) {
            return false;
        }
        Locale locale = Locale.ROOT;
        String upperCase = str2.toUpperCase(locale);
        Intrinsics.o(upperCase, "this as java.lang.String).toUpperCase(Locale.ROOT)");
        String upperCase2 = str.toUpperCase(locale);
        Intrinsics.o(upperCase2, "this as java.lang.String).toUpperCase(Locale.ROOT)");
        return upperCase.compareTo(upperCase2) >= 0;
    }

    @JvmStatic
    @Deprecated(message = "Android Q is a finalized release and this method is no longer necessary. It will be removed in a future release of this library. Instead, use `Build.VERSION.SDK_INT >= 29`.", replaceWith = @ReplaceWith(expression = "android.os.Build.VERSION.SDK_INT >= 29", imports = {}))
    @ChecksSdkIntAtLeast(api = 29)
    public static final boolean g() {
        return Build.VERSION.SDK_INT >= 29;
    }

    @JvmStatic
    @Deprecated(message = "Android R is a finalized release and this method is no longer necessary. It will be removed in a future release of this library. Instead, use `Build.VERSION.SDK_INT >= 30`.", replaceWith = @ReplaceWith(expression = "android.os.Build.VERSION.SDK_INT >= 30", imports = {}))
    @ChecksSdkIntAtLeast(api = 30)
    public static final boolean h() {
        return Build.VERSION.SDK_INT >= 30;
    }

    @JvmStatic
    @Deprecated(message = "Android S is a finalized release and this method is no longer necessary. It will be removed in a future release of this library. Instead, use `Build.VERSION.SDK_INT >= 31`.", replaceWith = @ReplaceWith(expression = "android.os.Build.VERSION.SDK_INT >= 31", imports = {}))
    @ChecksSdkIntAtLeast(api = 31, codename = "S")
    public static final boolean i() {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 < 31) {
            if (i2 >= 30) {
                String str = Build.VERSION.CODENAME;
                Intrinsics.o(str, "CODENAME");
                if (f(ExifInterface.R4, str)) {
                    return true;
                }
            }
            return false;
        }
        return true;
    }

    @JvmStatic
    @Deprecated(message = "Android Sv2 is a finalized release and this method is no longer necessary. It will be removed in a future release of this library. Instead, use `Build.VERSION.SDK_INT >= 32`.", replaceWith = @ReplaceWith(expression = "android.os.Build.VERSION.SDK_INT >= 32", imports = {}))
    @ChecksSdkIntAtLeast(api = 32, codename = "Sv2")
    public static final boolean j() {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 < 32) {
            if (i2 >= 31) {
                String str = Build.VERSION.CODENAME;
                Intrinsics.o(str, "CODENAME");
                if (f("Sv2", str)) {
                    return true;
                }
            }
            return false;
        }
        return true;
    }

    @JvmStatic
    @Deprecated(message = "Android Tiramisu is a finalized release and this method is no longer necessary. It will be removed in a future release of this library. Instead, use `Build.VERSION.SDK_INT >= 33`.", replaceWith = @ReplaceWith(expression = "android.os.Build.VERSION.SDK_INT >= 33", imports = {}))
    @ChecksSdkIntAtLeast(api = 33, codename = "Tiramisu")
    public static final boolean k() {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 < 33) {
            if (i2 >= 32) {
                String str = Build.VERSION.CODENAME;
                Intrinsics.o(str, "CODENAME");
                if (f("Tiramisu", str)) {
                    return true;
                }
            }
            return false;
        }
        return true;
    }

    @JvmStatic
    @Deprecated(message = "Android UpsideDownCase is a finalized release and this method is no longer necessary. It will be removed in a future release of this library. Instead, use `Build.VERSION.SDK_INT >= 34`.", replaceWith = @ReplaceWith(expression = "android.os.Build.VERSION.SDK_INT >= 34", imports = {}))
    @ChecksSdkIntAtLeast(api = 34, codename = "UpsideDownCake")
    public static final boolean l() {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 < 34) {
            if (i2 >= 33) {
                String str = Build.VERSION.CODENAME;
                Intrinsics.o(str, "CODENAME");
                if (f("UpsideDownCake", str)) {
                    return true;
                }
            }
            return false;
        }
        return true;
    }

    @JvmStatic
    @ChecksSdkIntAtLeast(codename = "VanillaIceCream")
    @PrereleaseSdkCheck
    public static final boolean m() {
        if (Build.VERSION.SDK_INT >= 34) {
            String str = Build.VERSION.CODENAME;
            Intrinsics.o(str, "CODENAME");
            if (f("VanillaIceCream", str)) {
                return true;
            }
        }
        return false;
    }
}
