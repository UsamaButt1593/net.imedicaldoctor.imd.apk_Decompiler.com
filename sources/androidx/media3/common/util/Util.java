package androidx.media3.common.util;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Notification;
import android.app.Service;
import android.app.UiModeManager;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Point;
import android.graphics.drawable.Drawable;
import android.media.AudioFormat;
import android.media.AudioManager;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcel;
import android.os.SystemClock;
import android.security.NetworkSecurityPolicy;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Base64;
import android.util.SparseArray;
import android.util.SparseLongArray;
import android.view.Display;
import androidx.annotation.ChecksSdkIntAtLeast;
import androidx.annotation.DoNotInline;
import androidx.annotation.DrawableRes;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.media3.common.C;
import androidx.media3.common.Format;
import androidx.media3.common.MediaItem;
import androidx.media3.common.MediaLibraryInfo;
import androidx.media3.common.MimeTypes;
import androidx.media3.common.ParserException;
import androidx.media3.common.PlaybackException;
import androidx.media3.common.Player;
import androidx.media3.common.audio.AudioProcessor;
import androidx.media3.exoplayer.upstream.CmcdConfiguration;
import androidx.media3.extractor.ts.PsExtractor;
import androidx.media3.extractor.ts.TsExtractor;
import androidx.recyclerview.widget.ItemTouchHelper;
import com.google.common.base.Ascii;
import com.google.common.base.Charsets;
import com.google.common.collect.ImmutableList;
import com.google.common.math.DoubleMath;
import com.google.common.math.LongMath;
import com.google.common.primitives.UnsignedBytes;
import com.google.common.util.concurrent.AsyncFunction;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.common.util.concurrent.SettableFuture;
import com.itextpdf.text.Annotation;
import com.itextpdf.text.Jpeg;
import com.itextpdf.text.pdf.codec.TIFFConstants;
import com.itextpdf.text.pdf.codec.wmf.MetaDo;
import com.itextpdf.tool.xml.css.CSS;
import com.itextpdf.tool.xml.html.HTML;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Formatter;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.MissingResourceException;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.TimeZone;
import java.util.UUID;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.DataFormatException;
import java.util.zip.GZIPOutputStream;
import java.util.zip.Inflater;
import kotlinx.coroutines.scheduling.WorkQueueKt;
import net.imedicaldoctor.imd.BuildConfig;
import net.lingala.zip4j.util.InternalZipConstants;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.cookie.CookiePolicy;
import org.checkerframework.checker.nullness.qual.EnsuresNonNull;
import org.checkerframework.checker.nullness.qual.EnsuresNonNullIf;

public final class Util {
    @UnstableApi

    /* renamed from: a  reason: collision with root package name */
    public static final int f9646a;
    @UnstableApi

    /* renamed from: b  reason: collision with root package name */
    public static final String f9647b;
    @UnstableApi

    /* renamed from: c  reason: collision with root package name */
    public static final String f9648c;
    @UnstableApi

    /* renamed from: d  reason: collision with root package name */
    public static final String f9649d;
    @UnstableApi

    /* renamed from: e  reason: collision with root package name */
    public static final String f9650e;
    @UnstableApi

    /* renamed from: f  reason: collision with root package name */
    public static final byte[] f9651f = new byte[0];
    @UnstableApi

    /* renamed from: g  reason: collision with root package name */
    public static final long[] f9652g = new long[0];

    /* renamed from: h  reason: collision with root package name */
    private static final String f9653h = "Util";

    /* renamed from: i  reason: collision with root package name */
    private static final Pattern f9654i = Pattern.compile("(\\d\\d\\d\\d)\\-(\\d\\d)\\-(\\d\\d)[Tt](\\d\\d):(\\d\\d):(\\d\\d)([\\.,](\\d+))?([Zz]|((\\+|\\-)(\\d?\\d):?(\\d\\d)))?");

    /* renamed from: j  reason: collision with root package name */
    private static final Pattern f9655j = Pattern.compile("^(-)?P(([0-9]*)Y)?(([0-9]*)M)?(([0-9]*)D)?(T(([0-9]*)H)?(([0-9]*)M)?(([0-9.]*)S)?)?$");

    /* renamed from: k  reason: collision with root package name */
    private static final Pattern f9656k = Pattern.compile("%([A-Fa-f0-9]{2})");

    /* renamed from: l  reason: collision with root package name */
    private static final Pattern f9657l = Pattern.compile("(?:.*\\.)?isml?(?:/(manifest(.*))?)?", 2);

    /* renamed from: m  reason: collision with root package name */
    private static final String f9658m = "format=m3u8-aapl";

    /* renamed from: n  reason: collision with root package name */
    private static final String f9659n = "format=mpd-time-csf";
    @Nullable
    private static HashMap<String, String> o;
    private static final String[] p = {"alb", "sq", "arm", "hy", "baq", "eu", "bur", "my", "tib", "bo", "chi", "zh", "cze", "cs", "dut", "nl", "ger", "de", "gre", "el", "fre", "fr", "geo", "ka", "ice", "is", "mac", "mk", "mao", "mi", "may", "ms", "per", "fa", "rum", "ro", "scc", "hbs-srp", "slo", "sk", "wel", "cy", "id", "ms-ind", "iw", "he", "heb", "he", "ji", "yi", "arb", "ar-arb", CSS.Value.i0, "ms-ind", "ind", "ms-ind", "nb", "no-nob", "nob", "no-nob", "nn", "no-nno", "nno", "no-nno", "tw", "ak-twi", "twi", "ak-twi", CmcdConfiguration.w, "hbs-bos", "bos", "hbs-bos", "hr", "hbs-hrv", "hrv", "hbs-hrv", "sr", "hbs-srp", "srp", "hbs-srp", "cmn", "zh-cmn", "hak", "zh-hak", "nan", "zh-nan", "hsn", "zh-hsn"};
    private static final String[] q = {"i-lux", "lb", "i-hak", "zh-hak", "i-navajo", "nv", "no-bok", "no-nob", "no-nyn", "no-nno", "zh-guoyu", "zh-cmn", "zh-hakka", "zh-hak", "zh-min-nan", "zh-nan", "zh-xiang", "zh-hsn"};
    private static final int[] r = {0, 79764919, 159529838, 222504665, 319059676, 398814059, 445009330, 507990021, 638119352, 583659535, 797628118, 726387553, 890018660, 835552979, 1015980042, 944750013, 1276238704, 1221641927, 1167319070, 1095957929, 1595256236, 1540665371, 1452775106, 1381403509, 1780037320, 1859660671, 1671105958, 1733955601, 2031960084, 2111593891, 1889500026, 1952343757, -1742489888, -1662866601, -1851683442, -1788833735, -1960329156, -1880695413, -2103051438, -2040207643, -1104454824, -1159051537, -1213636554, -1284997759, -1389417084, -1444007885, -1532160278, -1603531939, -734892656, -789352409, -575645954, -646886583, -952755380, -1007220997, -827056094, -898286187, -231047128, -151282273, -71779514, -8804623, -515967244, -436212925, -390279782, -327299027, 881225847, 809987520, 1023691545, 969234094, 662832811, 591600412, 771767749, 717299826, 311336399, 374308984, 453813921, 533576470, 25881363, 88864420, 134795389, 214552010, 2023205639, 2086057648, 1897238633, 1976864222, 1804852699, 1867694188, 1645340341, 1724971778, 1587496639, 1516133128, 1461550545, 1406951526, 1302016099, 1230646740, 1142491917, 1087903418, -1398421865, -1469785312, -1524105735, -1578704818, -1079922613, -1151291908, -1239184603, -1293773166, -1968362705, -1905510760, -2094067647, -2014441994, -1716953613, -1654112188, -1876203875, -1796572374, -525066777, -462094256, -382327159, -302564546, -206542021, -143559028, -97365931, -17609246, -960696225, -1031934488, -817968335, -872425850, -709327229, -780559564, -600130067, -654598054, 1762451694, 1842216281, 1619975040, 1682949687, 2047383090, 2127137669, 1938468188, 2001449195, 1325665622, 1271206113, 1183200824, 1111960463, 1543535498, 1489069629, 1434599652, 1363369299, 622672798, 568075817, 748617968, 677256519, 907627842, 853037301, 1067152940, 995781531, 51762726, 131386257, 177728840, 240578815, 269590778, 349224269, 429104020, 491947555, -248556018, -168932423, -122852000, -60002089, -500490030, -420856475, -341238852, -278395381, -685261898, -739858943, -559578920, -630940305, -1004286614, -1058877219, -845023740, -916395085, -1119974018, -1174433591, -1262701040, -1333941337, -1371866206, -1426332139, -1481064244, -1552294533, -1690935098, -1611170447, -1833673816, -1770699233, -2009983462, -1930228819, -2119160460, -2056179517, 1569362073, 1498123566, 1409854455, 1355396672, 1317987909, 1246755826, 1192025387, 1137557660, 2072149281, 2135122070, 1912620623, 1992383480, 1753615357, 1816598090, 1627664531, 1707420964, 295390185, 358241886, 404320391, 483945776, 43990325, 106832002, 186451547, 266083308, 932423249, 861060070, 1041341759, 986742920, 613929101, 542559546, 756411363, 701822548, -978770311, -1050133554, -869589737, -924188512, -693284699, -764654318, -550540341, -605129092, -475935807, -413084042, -366743377, -287118056, -257573603, -194731862, -114850189, -35218492, -1984365303, -1921392450, -2143631769, -2063868976, -1698919467, -1635936670, -1824608069, -1744851700, -1347415887, -1418654458, -1506661409, -1561119128, -1129027987, -1200260134, -1254728445, -1309196108};
    private static final int[] s = {0, 4129, 8258, 12387, 16516, 20645, 24774, 28903, 33032, 37161, 41290, 45419, 49548, 53677, 57806, 61935};
    private static final int[] t = {0, 7, 14, 9, 28, 27, 18, 21, 56, 63, 54, 49, 36, 35, 42, 45, 112, 119, 126, 121, 108, 107, 98, 101, 72, 79, 70, 65, 84, 83, 90, 93, 224, 231, Jpeg.W4, 233, 252, 251, 242, 245, 216, 223, 214, 209, 196, 195, 202, HttpStatus.SC_RESET_CONTENT, 144, 151, 158, 153, 140, TsExtractor.W, TsExtractor.L, 133, 168, 175, 166, 161, BuildConfig.f29478d, 179, 186, PsExtractor.w, 199, PsExtractor.x, 201, HttpStatus.SC_PARTIAL_CONTENT, 219, 220, 213, 210, 255, 248, 241, 246, 227, 228, Jpeg.X4, 234, 183, 176, 185, 190, 171, TsExtractor.N, 165, 162, 143, TsExtractor.V, TsExtractor.J, TsExtractor.T, 147, 148, 157, 154, 39, 32, 41, 46, 59, 60, 53, 50, 31, 24, 17, 22, 3, 4, 13, 10, 87, 80, 89, 94, 75, 76, 69, 66, 111, 104, 97, 102, 115, 116, 125, 122, 137, 142, TsExtractor.M, 128, 149, 146, 155, 156, 177, 182, 191, 184, 173, 170, 163, 164, 249, TIFFConstants.f26648a, MetaDo.s0, PsExtractor.A, 229, Jpeg.V4, 235, 236, 193, 198, HttpStatus.SC_MULTI_STATUS, 200, 221, 218, 211, 212, 105, 110, 103, 96, 117, 114, 123, 124, 81, 86, 95, 88, 77, 74, 67, 68, 25, 30, 23, 16, 5, 2, 11, 12, 33, 38, 47, 40, 61, 58, 51, 52, 78, 73, 64, 71, 82, 85, 92, 91, 118, 113, 120, WorkQueueKt.f29430c, 106, 109, 100, 99, 62, 57, 48, 55, 34, 37, 44, 43, 6, 1, 8, 15, 26, 29, 20, 19, 174, 169, 160, 167, 178, 181, TsExtractor.D, 187, 150, 145, 152, 159, TsExtractor.K, 141, 132, 131, 222, 217, 208, 215, 194, 197, 204, 203, 230, 225, 232, 239, ItemTouchHelper.Callback.f15380c, 253, 244, 243};

    @RequiresApi(21)
    private static final class Api21 {
        private Api21() {
        }

        @DoNotInline
        public static Drawable a(Context context, Resources resources, @DrawableRes int i2) {
            return resources.getDrawable(i2, context.getTheme());
        }
    }

    @RequiresApi(29)
    private static class Api29 {
        private Api29() {
        }

        @DoNotInline
        public static void a(Service service, int i2, Notification notification, int i3, String str) {
            try {
                service.startForeground(i2, notification, i3);
            } catch (RuntimeException e2) {
                Log.d(Util.f9653h, "The service must be declared with a foregroundServiceType that includes " + str);
                throw e2;
            }
        }
    }

    static {
        int i2 = Build.VERSION.SDK_INT;
        f9646a = i2;
        String str = Build.DEVICE;
        f9647b = str;
        String str2 = Build.MANUFACTURER;
        f9648c = str2;
        String str3 = Build.MODEL;
        f9649d = str3;
        f9650e = str + ", " + str3 + ", " + str2 + ", " + i2;
    }

    private Util() {
    }

    @UnstableApi
    public static <T> boolean A(@Nullable SparseArray<T> sparseArray, @Nullable SparseArray<T> sparseArray2) {
        if (sparseArray == null) {
            return sparseArray2 == null;
        }
        if (sparseArray2 == null) {
            return false;
        }
        if (f9646a >= 31) {
            return sparseArray.contentEquals(sparseArray2);
        }
        int size = sparseArray.size();
        if (size != sparseArray2.size()) {
            return false;
        }
        for (int i2 = 0; i2 < size; i2++) {
            if (!Objects.equals(sparseArray.valueAt(i2), sparseArray2.get(sparseArray.keyAt(i2)))) {
                return false;
            }
        }
        return true;
    }

    @UnstableApi
    public static long A0(long j2, float f2) {
        return f2 == 1.0f ? j2 : Math.round(((double) j2) * ((double) f2));
    }

    @RequiresApi(18)
    @UnstableApi
    public static long A1(SparseLongArray sparseLongArray) {
        if (sparseLongArray.size() != 0) {
            long j2 = Long.MIN_VALUE;
            for (int i2 = 0; i2 < sparseLongArray.size(); i2++) {
                j2 = Math.max(j2, sparseLongArray.valueAt(i2));
            }
            return j2;
        }
        throw new NoSuchElementException();
    }

    @UnstableApi
    public static float A2(byte[] bArr) {
        Assertions.a(bArr.length == 4);
        return Float.intBitsToFloat((bArr[3] & 255) | (bArr[0] << Ascii.B) | ((bArr[1] & 255) << 16) | ((bArr[2] & 255) << 8));
    }

    @UnstableApi
    public static <T> int B(SparseArray<T> sparseArray) {
        if (f9646a >= 31) {
            return sparseArray.contentHashCode();
        }
        int i2 = 17;
        for (int i3 = 0; i3 < sparseArray.size(); i3++) {
            i2 = (((i2 * 31) + sparseArray.keyAt(i3)) * 31) + Objects.hashCode(sparseArray.valueAt(i3));
        }
        return i2;
    }

    @UnstableApi
    public static long B0(long j2) {
        return j2 == C.f9084b ? System.currentTimeMillis() : j2 + SystemClock.elapsedRealtime();
    }

    private static String B1(String str) {
        int i2 = 0;
        while (true) {
            String[] strArr = q;
            if (i2 >= strArr.length) {
                return str;
            }
            if (str.startsWith(strArr[i2])) {
                return strArr[i2 + 1] + str.substring(strArr[i2].length());
            }
            i2 += 2;
        }
    }

    @UnstableApi
    public static String B2(byte[] bArr) {
        StringBuilder sb = new StringBuilder(bArr.length * 2);
        for (int i2 = 0; i2 < bArr.length; i2++) {
            sb.append(Character.forDigit((bArr[i2] >> 4) & 15, 16));
            sb.append(Character.forDigit(bArr[i2] & 15, 16));
        }
        return sb.toString();
    }

    @UnstableApi
    public static int C(byte[] bArr, int i2, int i3, int i4) {
        while (i2 < i3) {
            int p2 = UnsignedBytes.p(bArr[i2]);
            i4 = D(p2 & 15, D(p2 >> 4, i4));
            i2++;
        }
        return i4;
    }

    @UnstableApi
    public static int C0(int i2) {
        if (i2 == 8) {
            return 3;
        }
        if (i2 == 16) {
            return 2;
        }
        if (i2 != 24) {
            return i2 != 32 ? 0 : 22;
        }
        return 21;
    }

    @Deprecated
    public static boolean C1(Activity activity, Uri... uriArr) {
        for (Uri E1 : uriArr) {
            if (E1(activity, E1)) {
                return true;
            }
        }
        return false;
    }

    @UnstableApi
    public static int C2(byte[] bArr) {
        Assertions.a(bArr.length == 4);
        return bArr[3] | (bArr[0] << Ascii.B) | (bArr[1] << 16) | (bArr[2] << 8);
    }

    private static int D(int i2, int i3) {
        return (s[(i2 ^ ((i3 >> 12) & 255)) & 255] ^ ((i3 << 4) & 65535)) & 65535;
    }

    @UnstableApi
    public static Format D0(int i2, int i3, int i4) {
        return new Format.Builder().k0(MimeTypes.N).L(i3).l0(i4).e0(i2).I();
    }

    @Deprecated
    public static boolean D1(Activity activity, MediaItem... mediaItemArr) {
        return F1(activity, mediaItemArr);
    }

    @UnstableApi
    public static long D2(int i2, int i3) {
        return E2(i3) | (E2(i2) << 32);
    }

    @UnstableApi
    public static int E(byte[] bArr, int i2, int i3, int i4) {
        while (i2 < i3) {
            i4 = r[((i4 >>> 24) ^ (bArr[i2] & 255)) & 255] ^ (i4 << 8);
            i2++;
        }
        return i4;
    }

    @UnstableApi
    public static Format E0(AudioProcessor.AudioFormat audioFormat) {
        return D0(audioFormat.f9384c, audioFormat.f9383b, audioFormat.f9382a);
    }

    private static boolean E1(Activity activity, Uri uri) {
        if (!n1(activity, uri)) {
            return false;
        }
        return f9646a < 33 ? Z1(activity) : a2(activity);
    }

    @UnstableApi
    public static long E2(int i2) {
        return ((long) i2) & InternalZipConstants.f30717k;
    }

    @UnstableApi
    public static int F(byte[] bArr, int i2, int i3, int i4) {
        while (i2 < i3) {
            i4 = t[i4 ^ (bArr[i2] & 255)];
            i2++;
        }
        return i4;
    }

    @UnstableApi
    public static int F0(int i2, int i3) {
        if (i2 != 2) {
            if (i2 == 3) {
                return i3;
            }
            if (i2 != 4) {
                if (i2 != 21) {
                    if (i2 != 22) {
                        if (i2 != 268435456) {
                            if (i2 != 1342177280) {
                                if (i2 != 1610612736) {
                                    throw new IllegalArgumentException();
                                }
                            }
                        }
                    }
                }
                return i3 * 3;
            }
            return i3 * 4;
        }
        return i3 * 2;
    }

    public static boolean F1(Activity activity, MediaItem... mediaItemArr) {
        if (f9646a < 23) {
            return false;
        }
        for (MediaItem mediaItem : mediaItemArr) {
            MediaItem.LocalConfiguration localConfiguration = mediaItem.X;
            if (localConfiguration != null) {
                if (E1(activity, localConfiguration.s)) {
                    return true;
                }
                ImmutableList<MediaItem.SubtitleConfiguration> immutableList = mediaItem.X.Z2;
                for (int i2 = 0; i2 < immutableList.size(); i2++) {
                    if (E1(activity, immutableList.get(i2).s)) {
                        return true;
                    }
                }
                continue;
            }
        }
        return false;
    }

    @UnstableApi
    public static <T, U> ListenableFuture<T> F2(ListenableFuture<U> listenableFuture, AsyncFunction<U, T> asyncFunction) {
        SettableFuture F = SettableFuture.F();
        F.a0(new z(F, listenableFuture), MoreExecutors.c());
        listenableFuture.a0(new A(listenableFuture, F, asyncFunction), MoreExecutors.c());
        return F;
    }

    @UnstableApi
    public static Handler G(Looper looper, @Nullable Handler.Callback callback) {
        return new Handler(looper, callback);
    }

    @UnstableApi
    public static long G0(long j2, float f2) {
        return f2 == 1.0f ? j2 : Math.round(((double) j2) / ((double) f2));
    }

    @RequiresApi(18)
    @UnstableApi
    public static long G1(SparseLongArray sparseLongArray) {
        if (sparseLongArray.size() != 0) {
            long j2 = Long.MAX_VALUE;
            for (int i2 = 0; i2 < sparseLongArray.size(); i2++) {
                j2 = Math.min(j2, sparseLongArray.valueAt(i2));
            }
            return j2;
        }
        throw new NoSuchElementException();
    }

    @UnstableApi
    @Nullable
    public static String G2(String str) {
        int length = str.length();
        int i2 = 0;
        int i3 = 0;
        for (int i4 = 0; i4 < length; i4++) {
            if (str.charAt(i4) == '%') {
                i3++;
            }
        }
        if (i3 == 0) {
            return str;
        }
        int i5 = length - (i3 * 2);
        StringBuilder sb = new StringBuilder(i5);
        Matcher matcher = f9656k.matcher(str);
        while (i3 > 0 && matcher.find()) {
            sb.append(str, i2, matcher.start());
            sb.append((char) Integer.parseInt((String) Assertions.g(matcher.group(1)), 16));
            i2 = matcher.end();
            i3--;
        }
        if (i2 < length) {
            sb.append(str, i2, length);
        }
        if (sb.length() != i5) {
            return null;
        }
        return sb.toString();
    }

    @UnstableApi
    public static Handler H() {
        return I((Handler.Callback) null);
    }

    @UnstableApi
    public static List<String> H0(int i2) {
        ArrayList arrayList = new ArrayList();
        if ((i2 & 1) != 0) {
            arrayList.add("main");
        }
        if ((i2 & 2) != 0) {
            arrayList.add(HTML.Attribute.f27590a);
        }
        if ((i2 & 4) != 0) {
            arrayList.add("supplementary");
        }
        if ((i2 & 8) != 0) {
            arrayList.add("commentary");
        }
        if ((i2 & 16) != 0) {
            arrayList.add("dub");
        }
        if ((i2 & 32) != 0) {
            arrayList.add("emergency");
        }
        if ((i2 & 64) != 0) {
            arrayList.add(HTML.Tag.f27619g);
        }
        if ((i2 & 128) != 0) {
            arrayList.add("subtitle");
        }
        if ((i2 & 256) != 0) {
            arrayList.add("sign");
        }
        if ((i2 & 512) != 0) {
            arrayList.add("describes-video");
        }
        if ((i2 & 1024) != 0) {
            arrayList.add("describes-music");
        }
        if ((i2 & 2048) != 0) {
            arrayList.add("enhanced-intelligibility");
        }
        if ((i2 & 4096) != 0) {
            arrayList.add("transcribes-dialog");
        }
        if ((i2 & 8192) != 0) {
            arrayList.add("easy-read");
        }
        if ((i2 & 16384) != 0) {
            arrayList.add("trick-play");
        }
        return arrayList;
    }

    @UnstableApi
    public static <T> void H1(List<T> list, int i2, int i3, int i4) {
        ArrayDeque arrayDeque = new ArrayDeque();
        for (int i5 = (i3 - i2) - 1; i5 >= 0; i5--) {
            arrayDeque.addFirst(list.remove(i2 + i5));
        }
        list.addAll(Math.min(i4, list.size()), arrayDeque);
    }

    @UnstableApi
    public static long H2(long j2) {
        return (j2 == C.f9084b || j2 == Long.MIN_VALUE) ? j2 : j2 / 1000;
    }

    @UnstableApi
    public static Handler I(@Nullable Handler.Callback callback) {
        return G((Looper) Assertions.k(Looper.myLooper()), callback);
    }

    @UnstableApi
    public static List<String> I0(int i2) {
        ArrayList arrayList = new ArrayList();
        if ((i2 & 4) != 0) {
            arrayList.add("auto");
        }
        if ((i2 & 1) != 0) {
            arrayList.add(CookiePolicy.DEFAULT);
        }
        if ((i2 & 2) != 0) {
            arrayList.add("forced");
        }
        return arrayList;
    }

    @UnstableApi
    public static long I1(long j2) {
        return (j2 == C.f9084b || j2 == Long.MIN_VALUE) ? j2 : j2 * 1000;
    }

    @UnstableApi
    public static void I2(Parcel parcel, boolean z) {
        parcel.writeInt(z ? 1 : 0);
    }

    @UnstableApi
    public static Handler J() {
        return K((Handler.Callback) null);
    }

    @UnstableApi
    public static int J0(int i2) {
        if (i2 == 13) {
            return 1;
        }
        switch (i2) {
            case 2:
                return 0;
            case 3:
                return 8;
            case 4:
                return 4;
            case 5:
            case 7:
            case 8:
            case 9:
            case 10:
                return 5;
            case 6:
                return 2;
            default:
                return 3;
        }
    }

    @UnstableApi
    public static ExecutorService J1(String str) {
        return Executors.newSingleThreadExecutor(new B(str));
    }

    @UnstableApi
    public static Handler K(@Nullable Handler.Callback callback) {
        return G(l0(), callback);
    }

    @UnstableApi
    public static String K0(StringBuilder sb, Formatter formatter, long j2) {
        Formatter formatter2 = formatter;
        long j3 = j2 == C.f9084b ? 0 : j2;
        String str = j3 < 0 ? "-" : "";
        long abs = (Math.abs(j3) + 500) / 1000;
        long j4 = abs % 60;
        long j5 = (abs / 60) % 60;
        long j6 = abs / 3600;
        sb.setLength(0);
        return (j6 > 0 ? formatter2.format("%s%d:%02d:%02d", new Object[]{str, Long.valueOf(j6), Long.valueOf(j5), Long.valueOf(j4)}) : formatter2.format("%s%02d:%02d", new Object[]{str, Long.valueOf(j5), Long.valueOf(j4)})).toString();
    }

    @UnstableApi
    public static ScheduledExecutorService K1(String str) {
        return Executors.newSingleThreadScheduledExecutor(new D(str));
    }

    private static HashMap<String, String> L() {
        String[] iSOLanguages = Locale.getISOLanguages();
        HashMap<String, String> hashMap = new HashMap<>(iSOLanguages.length + p.length);
        int i2 = 0;
        for (String str : iSOLanguages) {
            try {
                String iSO3Language = new Locale(str).getISO3Language();
                if (!TextUtils.isEmpty(iSO3Language)) {
                    hashMap.put(iSO3Language, str);
                }
            } catch (MissingResourceException unused) {
            }
        }
        while (true) {
            String[] strArr = p;
            if (i2 >= strArr.length) {
                return hashMap;
            }
            hashMap.put(strArr[i2], strArr[i2 + 1]);
            i2 += 2;
        }
    }

    @UnstableApi
    public static String[] L0() {
        String[] M0 = M0();
        for (int i2 = 0; i2 < M0.length; i2++) {
            M0[i2] = L1(M0[i2]);
        }
        return M0;
    }

    @UnstableApi
    public static String L1(String str) {
        if (str == null) {
            return null;
        }
        String replace = str.replace('_', '-');
        if (!replace.isEmpty() && !replace.equals(C.k1)) {
            str = replace;
        }
        String g2 = Ascii.g(str);
        String str2 = q2(g2, "-")[0];
        if (o == null) {
            o = L();
        }
        String str3 = o.get(str2);
        if (str3 != null) {
            g2 = str3 + g2.substring(str2.length());
            str2 = str3;
        }
        return ("no".equals(str2) || "i".equals(str2) || "zh".equals(str2)) ? B1(g2) : g2;
    }

    @UnstableApi
    public static ByteBuffer M(ByteBuffer byteBuffer) {
        return byteBuffer.asReadOnlyBuffer().order(byteBuffer.order());
    }

    private static String[] M0() {
        Configuration configuration = Resources.getSystem().getConfiguration();
        if (f9646a >= 24) {
            return N0(configuration);
        }
        return new String[]{x0(configuration.locale)};
    }

    @UnstableApi
    public static <T> T[] M1(T[] tArr, T t2) {
        Object[] copyOf = Arrays.copyOf(tArr, tArr.length + 1);
        copyOf[tArr.length] = t2;
        return p(copyOf);
    }

    @UnstableApi
    public static File N(Context context, String str) throws IOException {
        File O = O(context, str);
        O.delete();
        O.mkdir();
        return O;
    }

    @RequiresApi(24)
    private static String[] N0(Configuration configuration) {
        return p2(configuration.getLocales().toLanguageTags(), ",");
    }

    @UnstableApi
    public static <T> T[] N1(T[] tArr, T[] tArr2) {
        T[] copyOf = Arrays.copyOf(tArr, tArr.length + tArr2.length);
        System.arraycopy(tArr2, 0, copyOf, tArr.length, tArr2.length);
        return copyOf;
    }

    @UnstableApi
    public static File O(Context context, String str) throws IOException {
        return File.createTempFile(str, (String) null, (File) Assertions.g(context.getCacheDir()));
    }

    @Nullable
    private static String O0(String str) {
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            return (String) cls.getMethod("get", new Class[]{String.class}).invoke(cls, new Object[]{str});
        } catch (Exception e2) {
            Log.e(f9653h, "Failed to read system property " + str, e2);
            return null;
        }
    }

    @UnstableApi
    public static <T> T[] O1(T[] tArr, int i2) {
        Assertions.a(i2 <= tArr.length);
        return Arrays.copyOf(tArr, i2);
    }

    @UnstableApi
    public static long P(long j2, int i2) {
        return f2(j2, (long) i2, 1000000, RoundingMode.CEILING);
    }

    @UnstableApi
    public static String P0(int i2) {
        switch (i2) {
            case -2:
                return "none";
            case -1:
                return "unknown";
            case 0:
                return CookiePolicy.DEFAULT;
            case 1:
                return "audio";
            case 2:
                return "video";
            case 3:
                return "text";
            case 4:
                return "image";
            case 5:
                return TtmlNode.y;
            case 6:
                return "camera motion";
            default:
                if (i2 < 10000) {
                    return "?";
                }
                return "custom (" + i2 + ")";
        }
    }

    @UnstableApi
    public static <T> T[] P1(T[] tArr, int i2, int i3) {
        boolean z = false;
        Assertions.a(i2 >= 0);
        if (i3 <= tArr.length) {
            z = true;
        }
        Assertions.a(z);
        return Arrays.copyOfRange(tArr, i2, i3);
    }

    @UnstableApi
    public static String Q(String str) {
        int length = str.length();
        int i2 = 0;
        int i3 = 0;
        for (int i4 = 0; i4 < length; i4++) {
            if (k2(str.charAt(i4))) {
                i3++;
            }
        }
        if (i3 == 0) {
            return str;
        }
        StringBuilder sb = new StringBuilder((i3 * 2) + length);
        while (i3 > 0) {
            int i5 = i2 + 1;
            char charAt = str.charAt(i2);
            if (k2(charAt)) {
                sb.append('%');
                sb.append(Integer.toHexString(charAt));
                i3--;
            } else {
                sb.append(charAt);
            }
            i2 = i5;
        }
        if (i2 < length) {
            sb.append(str, i2, length);
        }
        return sb.toString();
    }

    @UnstableApi
    public static String Q0(Context context, String str) {
        String str2;
        try {
            str2 = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (PackageManager.NameNotFoundException unused) {
            str2 = "?";
        }
        return str + "/" + str2 + " (Linux;Android " + Build.VERSION.RELEASE + ") " + MediaLibraryInfo.f9206c;
    }

    @UnstableApi
    public static <T> void Q1(List<T> list, T[] tArr) {
        Assertions.i(list.size() == tArr.length);
        list.toArray(tArr);
    }

    @UnstableApi
    public static Uri R(Uri uri) {
        String path = uri.getPath();
        if (path == null) {
            return uri;
        }
        Matcher matcher = f9657l.matcher(path);
        return (!matcher.matches() || matcher.group(1) != null) ? uri : Uri.withAppendedPath(uri, "Manifest");
    }

    @UnstableApi
    public static byte[] R0(String str) {
        return str.getBytes(Charsets.f22255c);
    }

    @UnstableApi
    public static long R1(String str) throws ParserException {
        Matcher matcher = f9654i.matcher(str);
        if (matcher.matches()) {
            int i2 = 0;
            if (matcher.group(9) != null && !matcher.group(9).equalsIgnoreCase("Z")) {
                i2 = (Integer.parseInt(matcher.group(12)) * 60) + Integer.parseInt(matcher.group(13));
                if ("-".equals(matcher.group(11))) {
                    i2 *= -1;
                }
            }
            GregorianCalendar gregorianCalendar = new GregorianCalendar(TimeZone.getTimeZone("GMT"));
            gregorianCalendar.clear();
            gregorianCalendar.set(Integer.parseInt(matcher.group(1)), Integer.parseInt(matcher.group(2)) - 1, Integer.parseInt(matcher.group(3)), Integer.parseInt(matcher.group(4)), Integer.parseInt(matcher.group(5)), Integer.parseInt(matcher.group(6)));
            if (!TextUtils.isEmpty(matcher.group(8))) {
                gregorianCalendar.set(14, new BigDecimal("0." + matcher.group(8)).movePointRight(3).intValue());
            }
            long timeInMillis = gregorianCalendar.getTimeInMillis();
            return i2 != 0 ? timeInMillis - (((long) i2) * 60000) : timeInMillis;
        }
        throw ParserException.a("Invalid date/time format: " + str, (Throwable) null);
    }

    @UnstableApi
    public static String S(String str, Object... objArr) {
        return String.format(Locale.US, str, objArr);
    }

    @UnstableApi
    public static byte[] S0(byte[] bArr) {
        GZIPOutputStream gZIPOutputStream;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
            gZIPOutputStream.write(bArr);
            gZIPOutputStream.close();
            return byteArrayOutputStream.toByteArray();
        } catch (IOException e2) {
            throw new IllegalStateException(e2);
        } catch (Throwable th) {
            th.addSuppressed(th);
        }
        throw th;
    }

    @UnstableApi
    public static long S1(String str) {
        Matcher matcher = f9655j.matcher(str);
        if (!matcher.matches()) {
            return (long) (Double.parseDouble(str) * 3600.0d * 1000.0d);
        }
        boolean isEmpty = true ^ TextUtils.isEmpty(matcher.group(1));
        String group = matcher.group(3);
        double d2 = 0.0d;
        double parseDouble = group != null ? Double.parseDouble(group) * 3.1556908E7d : 0.0d;
        String group2 = matcher.group(5);
        double parseDouble2 = parseDouble + (group2 != null ? Double.parseDouble(group2) * 2629739.0d : 0.0d);
        String group3 = matcher.group(7);
        double parseDouble3 = parseDouble2 + (group3 != null ? Double.parseDouble(group3) * 86400.0d : 0.0d);
        String group4 = matcher.group(10);
        double parseDouble4 = parseDouble3 + (group4 != null ? Double.parseDouble(group4) * 3600.0d : 0.0d);
        String group5 = matcher.group(12);
        double parseDouble5 = parseDouble4 + (group5 != null ? Double.parseDouble(group5) * 60.0d : 0.0d);
        String group6 = matcher.group(14);
        if (group6 != null) {
            d2 = Double.parseDouble(group6);
        }
        long j2 = (long) ((parseDouble5 + d2) * 1000.0d);
        return isEmpty ? -j2 : j2;
    }

    @UnstableApi
    public static String T(byte[] bArr) {
        return new String(bArr, Charsets.f22255c);
    }

    public static boolean T0(@Nullable Player player) {
        if (player == null || !player.R1(1)) {
            return false;
        }
        player.h();
        return true;
    }

    @UnstableApi
    public static boolean T1(Handler handler, Runnable runnable) {
        if (!handler.getLooper().getThread().isAlive()) {
            return false;
        }
        if (handler.getLooper() != Looper.myLooper()) {
            return handler.post(runnable);
        }
        runnable.run();
        return true;
    }

    @UnstableApi
    public static String U(byte[] bArr, int i2, int i3) {
        return new String(bArr, i2, i3, Charsets.f22255c);
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x002a  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x002e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean U0(@androidx.annotation.Nullable androidx.media3.common.Player r4) {
        /*
            r0 = 0
            if (r4 != 0) goto L_0x0004
            return r0
        L_0x0004:
            int r1 = r4.i()
            r2 = 1
            if (r1 != r2) goto L_0x0017
            r3 = 2
            boolean r3 = r4.R1(r3)
            if (r3 == 0) goto L_0x0017
            r4.k()
        L_0x0015:
            r0 = 1
            goto L_0x0024
        L_0x0017:
            r3 = 4
            if (r1 != r3) goto L_0x0024
            boolean r1 = r4.R1(r3)
            if (r1 == 0) goto L_0x0024
            r4.E0()
            goto L_0x0015
        L_0x0024:
            boolean r1 = r4.R1(r2)
            if (r1 == 0) goto L_0x002e
            r4.o()
            goto L_0x002f
        L_0x002e:
            r2 = r0
        L_0x002f:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.common.util.Util.U0(androidx.media3.common.Player):boolean");
    }

    @UnstableApi
    public static <T> ListenableFuture<T> U1(Handler handler, Runnable runnable, T t2) {
        SettableFuture F = SettableFuture.F();
        T1(handler, new C(F, runnable, t2));
        return F;
    }

    @RequiresApi(21)
    @UnstableApi
    public static int V(Context context) {
        AudioManager audioManager = (AudioManager) context.getSystemService("audio");
        if (audioManager == null) {
            return -1;
        }
        return audioManager.generateAudioSessionId();
    }

    public static boolean V0(@Nullable Player player) {
        return W0(player, true);
    }

    @UnstableApi
    public static boolean V1(Parcel parcel) {
        return parcel.readInt() != 0;
    }

    @Nullable
    public static String W(int i2) {
        if (i2 == 0) {
            return MimeTypes.s0;
        }
        if (i2 == 1) {
            return MimeTypes.u0;
        }
        if (i2 != 2) {
            return null;
        }
        return MimeTypes.t0;
    }

    @UnstableApi
    public static boolean W0(@Nullable Player player, boolean z) {
        return m2(player, z) ? U0(player) : T0(player);
    }

    @UnstableApi
    public static void W1(File file) {
        File[] listFiles = file.listFiles();
        if (listFiles != null) {
            for (File W1 : listFiles) {
                W1(W1);
            }
        }
        file.delete();
    }

    @UnstableApi
    public static int X(int i2) {
        if (i2 == 20) {
            return 30;
        }
        if (i2 == 22) {
            return 31;
        }
        if (i2 == 30) {
            return 34;
        }
        switch (i2) {
            case 2:
            case 3:
                return 3;
            case 4:
            case 5:
            case 6:
                return 21;
            case 7:
            case 8:
                return 23;
            case 9:
            case 10:
            case 11:
            case 12:
                return 28;
            default:
                switch (i2) {
                    case 14:
                        return 25;
                    case 15:
                    case 16:
                    case 17:
                    case 18:
                        return 28;
                    default:
                        return Integer.MAX_VALUE;
                }
        }
    }

    public static int X0(Uri uri) {
        int a1;
        String scheme = uri.getScheme();
        if (scheme != null && Ascii.a("rtsp", scheme)) {
            return 3;
        }
        String lastPathSegment = uri.getLastPathSegment();
        if (lastPathSegment == null) {
            return 4;
        }
        int lastIndexOf = lastPathSegment.lastIndexOf(46);
        if (lastIndexOf >= 0 && (a1 = a1(lastPathSegment.substring(lastIndexOf + 1))) != 4) {
            return a1;
        }
        Matcher matcher = f9657l.matcher((CharSequence) Assertions.g(uri.getPath()));
        if (!matcher.matches()) {
            return 4;
        }
        String group = matcher.group(2);
        if (group != null) {
            if (group.contains(f9659n)) {
                return 0;
            }
            if (group.contains(f9658m)) {
                return 2;
            }
        }
        return 1;
    }

    @UnstableApi
    @Nullable
    public static Intent X1(Context context, @Nullable BroadcastReceiver broadcastReceiver, IntentFilter intentFilter) {
        return f9646a < 33 ? context.registerReceiver(broadcastReceiver, intentFilter) : context.registerReceiver(broadcastReceiver, intentFilter, 4);
    }

    @UnstableApi
    @Deprecated
    public static int Y(int i2) {
        if (i2 != 0) {
            return (i2 == 1 || i2 == 2 || i2 == 4 || i2 == 5 || i2 == 8) ? 4 : 2;
        }
        return 1;
    }

    @UnstableApi
    @Deprecated
    public static int Y0(Uri uri, @Nullable String str) {
        return TextUtils.isEmpty(str) ? X0(uri) : a1(str);
    }

    @UnstableApi
    public static <T> void Y1(List<T> list, int i2, int i3) {
        if (i2 < 0 || i3 > list.size() || i2 > i3) {
            throw new IllegalArgumentException();
        } else if (i2 != i3) {
            list.subList(i2, i3).clear();
        }
    }

    @RequiresApi(21)
    @UnstableApi
    public static AudioFormat Z(int i2, int i3, int i4) {
        return new AudioFormat.Builder().setSampleRate(i2).setChannelMask(i3).setEncoding(i4).build();
    }

    @UnstableApi
    @Deprecated
    public static int Z0(String str) {
        return X0(Uri.parse("file:///" + str));
    }

    @RequiresApi(api = 23)
    private static boolean Z1(Activity activity) {
        if (activity.checkSelfPermission("android.permission.READ_EXTERNAL_STORAGE") == 0) {
            return false;
        }
        activity.requestPermissions(new String[]{"android.permission.READ_EXTERNAL_STORAGE"}, 0);
        return true;
    }

    @UnstableApi
    @SuppressLint({"InlinedApi"})
    public static int a0(int i2) {
        switch (i2) {
            case 1:
                return 4;
            case 2:
                return 12;
            case 3:
                return 28;
            case 4:
                return 204;
            case 5:
                return 220;
            case 6:
                return 252;
            case 7:
                return 1276;
            case 8:
                break;
            case 10:
                if (f9646a >= 32) {
                    return 737532;
                }
                break;
            case 12:
                return 743676;
            default:
                return 0;
        }
        return 6396;
    }

    public static int a1(String str) {
        String g2 = Ascii.g(str);
        g2.hashCode();
        char c2 = 65535;
        switch (g2.hashCode()) {
            case 104579:
                if (g2.equals("ism")) {
                    c2 = 0;
                    break;
                }
                break;
            case 108321:
                if (g2.equals("mpd")) {
                    c2 = 1;
                    break;
                }
                break;
            case 3242057:
                if (g2.equals("isml")) {
                    c2 = 2;
                    break;
                }
                break;
            case 3299913:
                if (g2.equals("m3u8")) {
                    c2 = 3;
                    break;
                }
                break;
        }
        switch (c2) {
            case 0:
            case 2:
                return 1;
            case 1:
                return 0;
            case 3:
                return 2;
            default:
                return 4;
        }
    }

    @RequiresApi(api = 33)
    private static boolean a2(Activity activity) {
        if (activity.checkSelfPermission("android.permission.READ_MEDIA_AUDIO") == 0 && activity.checkSelfPermission("android.permission.READ_MEDIA_VIDEO") == 0 && activity.checkSelfPermission("android.permission.READ_MEDIA_IMAGES") == 0) {
            return false;
        }
        activity.requestPermissions(new String[]{"android.permission.READ_MEDIA_AUDIO", "android.permission.READ_MEDIA_IMAGES", "android.permission.READ_MEDIA_VIDEO"}, 0);
        return true;
    }

    @UnstableApi
    public static int b0(int i2) {
        if (i2 == 0) {
            return 2;
        }
        if (i2 == 1) {
            return 13;
        }
        if (i2 == 2) {
            return 6;
        }
        int i3 = 4;
        if (i2 != 4) {
            i3 = 5;
            if (i2 != 5) {
                return i2 != 8 ? 1 : 3;
            }
        }
        return i3;
    }

    public static int b1(Uri uri, @Nullable String str) {
        if (str == null) {
            return X0(uri);
        }
        char c2 = 65535;
        switch (str.hashCode()) {
            case -979127466:
                if (str.equals(MimeTypes.t0)) {
                    c2 = 0;
                    break;
                }
                break;
            case -156749520:
                if (str.equals(MimeTypes.u0)) {
                    c2 = 1;
                    break;
                }
                break;
            case 64194685:
                if (str.equals(MimeTypes.s0)) {
                    c2 = 2;
                    break;
                }
                break;
            case 1154777587:
                if (str.equals(MimeTypes.N0)) {
                    c2 = 3;
                    break;
                }
                break;
        }
        switch (c2) {
            case 0:
                return 2;
            case 1:
                return 1;
            case 2:
                return 0;
            case 3:
                return 3;
            default:
                return 4;
        }
    }

    @UnstableApi
    public static long b2(long j2, int i2) {
        return f2(j2, 1000000, (long) i2, RoundingMode.FLOOR);
    }

    @UnstableApi
    public static Player.Commands c0(Player player, Player.Commands commands) {
        boolean c0 = player.c0();
        boolean w1 = player.w1();
        boolean L0 = player.L0();
        boolean H1 = player.H1();
        boolean B2 = player.B2();
        boolean e2 = player.e2();
        boolean x = player.j2().x();
        boolean z = false;
        Player.Commands.Builder e3 = new Player.Commands.Builder().b(commands).e(4, !c0).e(5, w1 && !c0).e(6, L0 && !c0).e(7, !x && (L0 || !B2 || w1) && !c0).e(8, H1 && !c0).e(9, !x && (H1 || (B2 && e2)) && !c0).e(10, !c0).e(11, w1 && !c0);
        if (w1 && !c0) {
            z = true;
        }
        return e3.e(12, z).f();
    }

    @UnstableApi
    public static boolean c1(ParsableByteArray parsableByteArray, ParsableByteArray parsableByteArray2, @Nullable Inflater inflater) {
        if (parsableByteArray.a() <= 0) {
            return false;
        }
        if (parsableByteArray2.b() < parsableByteArray.a()) {
            parsableByteArray2.c(parsableByteArray.a() * 2);
        }
        if (inflater == null) {
            inflater = new Inflater();
        }
        inflater.setInput(parsableByteArray.e(), parsableByteArray.f(), parsableByteArray.a());
        int i2 = 0;
        while (true) {
            try {
                i2 += inflater.inflate(parsableByteArray2.e(), i2, parsableByteArray2.b() - i2);
                if (inflater.finished()) {
                    parsableByteArray2.X(i2);
                    inflater.reset();
                    return true;
                } else if (inflater.needsDictionary()) {
                    break;
                } else if (inflater.needsInput()) {
                    break;
                } else if (i2 == parsableByteArray2.b()) {
                    parsableByteArray2.c(parsableByteArray2.b() * 2);
                }
            } catch (DataFormatException unused) {
                return false;
            } finally {
                inflater.reset();
            }
        }
        return false;
    }

    @UnstableApi
    public static long c2(long j2, long j3, long j4) {
        return f2(j2, j3, j4, RoundingMode.FLOOR);
    }

    @UnstableApi
    public static int d0(ByteBuffer byteBuffer, int i2) {
        int i3 = byteBuffer.getInt(i2);
        return byteBuffer.order() == ByteOrder.BIG_ENDIAN ? i3 : Integer.reverseBytes(i3);
    }

    @UnstableApi
    public static String d1(int i2) {
        return Integer.toString(i2, 36);
    }

    @UnstableApi
    public static long[] d2(List<Long> list, long j2, long j3) {
        return h2(list, j2, j3, RoundingMode.FLOOR);
    }

    @UnstableApi
    public static byte[] e0(String str) {
        int length = str.length() / 2;
        byte[] bArr = new byte[length];
        for (int i2 = 0; i2 < length; i2++) {
            int i3 = i2 * 2;
            bArr[i2] = (byte) ((Character.digit(str.charAt(i3), 16) << 4) + Character.digit(str.charAt(i3 + 1), 16));
        }
        return bArr;
    }

    private static boolean e1(Activity activity, Uri uri) {
        try {
            String path = uri.getPath();
            if (path == null) {
                return false;
            }
            String canonicalPath = new File(path).getCanonicalPath();
            String canonicalPath2 = activity.getFilesDir().getCanonicalPath();
            String str = null;
            File externalFilesDir = activity.getExternalFilesDir((String) null);
            if (externalFilesDir != null) {
                str = externalFilesDir.getCanonicalPath();
            }
            return canonicalPath.startsWith(canonicalPath2) || (str != null && canonicalPath.startsWith(str));
        } catch (IOException unused) {
            return false;
        }
    }

    @UnstableApi
    public static void e2(long[] jArr, long j2, long j3) {
        i2(jArr, j2, j3, RoundingMode.FLOOR);
    }

    @UnstableApi
    public static long f(long j2, long j3, long j4) {
        long j5 = j2 + j3;
        return ((j2 ^ j5) & (j3 ^ j5)) < 0 ? j4 : j5;
    }

    @UnstableApi
    public static int f0(@Nullable String str, int i2) {
        int i3 = 0;
        for (String n2 : r2(str)) {
            if (i2 == MimeTypes.n(n2)) {
                i3++;
            }
        }
        return i3;
    }

    @UnstableApi
    public static boolean f1(Context context) {
        return f9646a >= 23 && context.getPackageManager().hasSystemFeature("android.hardware.type.automotive");
    }

    @UnstableApi
    public static long f2(long j2, long j3, long j4, RoundingMode roundingMode) {
        if (j2 == 0 || j3 == 0) {
            return 0;
        }
        int i2 = (j4 > j3 ? 1 : (j4 == j3 ? 0 : -1));
        if (i2 >= 0 && j4 % j3 == 0) {
            return LongMath.g(j2, LongMath.g(j4, j3, RoundingMode.UNNECESSARY), roundingMode);
        }
        if (i2 < 0 && j3 % j4 == 0) {
            return LongMath.y(j2, LongMath.g(j3, j4, RoundingMode.UNNECESSARY));
        }
        int i3 = (j4 > j2 ? 1 : (j4 == j2 ? 0 : -1));
        if (i3 < 0 || j4 % j2 != 0) {
            return (i3 >= 0 || j2 % j4 != 0) ? g2(j2, j3, j4, roundingMode) : LongMath.y(j3, LongMath.g(j2, j4, RoundingMode.UNNECESSARY));
        }
        return LongMath.g(j3, LongMath.g(j4, j2, RoundingMode.UNNECESSARY), roundingMode);
    }

    @UnstableApi
    public static boolean g(@Nullable Object obj, @Nullable Object obj2) {
        if (obj == null) {
            return obj2 == null;
        }
        return obj.equals(obj2);
    }

    @UnstableApi
    @Nullable
    public static String g0(@Nullable String str, int i2) {
        String[] r2 = r2(str);
        if (r2.length == 0) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        for (String str2 : r2) {
            if (i2 == MimeTypes.n(str2)) {
                if (sb.length() > 0) {
                    sb.append(",");
                }
                sb.append(str2);
            }
        }
        if (sb.length() > 0) {
            return sb.toString();
        }
        return null;
    }

    @UnstableApi
    public static boolean g1(String str) {
        str.hashCode();
        char c2 = 65535;
        switch (str.hashCode()) {
            case -1487464690:
                if (str.equals(MimeTypes.S0)) {
                    c2 = 0;
                    break;
                }
                break;
            case -1487394660:
                if (str.equals(MimeTypes.Q0)) {
                    c2 = 1;
                    break;
                }
                break;
            case -1487018032:
                if (str.equals(MimeTypes.U0)) {
                    c2 = 2;
                    break;
                }
                break;
            case -879272239:
                if (str.equals(MimeTypes.T0)) {
                    c2 = 3;
                    break;
                }
                break;
            case -879258763:
                if (str.equals(MimeTypes.R0)) {
                    c2 = 4;
                    break;
                }
                break;
        }
        switch (c2) {
            case 0:
                return f9646a >= 26;
            case 1:
            case 2:
            case 3:
            case 4:
                return true;
            default:
                return false;
        }
    }

    private static long g2(long j2, long j3, long j4, RoundingMode roundingMode) {
        long y = LongMath.y(j2, j3);
        if (y != Long.MAX_VALUE && y != Long.MIN_VALUE) {
            return LongMath.g(y, j4, roundingMode);
        }
        long k2 = LongMath.k(Math.abs(j3), Math.abs(j4));
        RoundingMode roundingMode2 = RoundingMode.UNNECESSARY;
        long g2 = LongMath.g(j3, k2, roundingMode2);
        long g3 = LongMath.g(j4, k2, roundingMode2);
        long k3 = LongMath.k(Math.abs(j2), Math.abs(g3));
        long g4 = LongMath.g(j2, k3, roundingMode2);
        long g5 = LongMath.g(g3, k3, roundingMode2);
        long y2 = LongMath.y(g4, g2);
        if (y2 != Long.MAX_VALUE && y2 != Long.MIN_VALUE) {
            return LongMath.g(y2, g5, roundingMode);
        }
        double d2 = ((double) g4) * (((double) g2) / ((double) g5));
        if (d2 > 9.223372036854776E18d) {
            return Long.MAX_VALUE;
        }
        if (d2 < -9.223372036854776E18d) {
            return Long.MIN_VALUE;
        }
        return DoubleMath.q(d2, roundingMode);
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0020  */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x0022  */
    @androidx.media3.common.util.UnstableApi
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static <T extends java.lang.Comparable<? super T>> int h(java.util.List<? extends java.lang.Comparable<? super T>> r4, T r5, boolean r6, boolean r7) {
        /*
            int r0 = java.util.Collections.binarySearch(r4, r5)
            if (r0 >= 0) goto L_0x0008
            int r5 = ~r0
            goto L_0x0023
        L_0x0008:
            int r1 = r4.size()
        L_0x000c:
            int r2 = r0 + 1
            if (r2 >= r1) goto L_0x001e
            java.lang.Object r3 = r4.get(r2)
            java.lang.Comparable r3 = (java.lang.Comparable) r3
            int r3 = r3.compareTo(r5)
            if (r3 != 0) goto L_0x001e
            r0 = r2
            goto L_0x000c
        L_0x001e:
            if (r6 == 0) goto L_0x0022
            r5 = r0
            goto L_0x0023
        L_0x0022:
            r5 = r2
        L_0x0023:
            if (r7 == 0) goto L_0x002f
            int r4 = r4.size()
            int r4 = r4 + -1
            int r5 = java.lang.Math.min(r4, r5)
        L_0x002f:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.common.util.Util.h(java.util.List, java.lang.Comparable, boolean, boolean):int");
    }

    @UnstableApi
    public static String h0(Object[] objArr) {
        StringBuilder sb = new StringBuilder();
        for (int i2 = 0; i2 < objArr.length; i2++) {
            sb.append(objArr[i2].getClass().getSimpleName());
            if (i2 < objArr.length - 1) {
                sb.append(", ");
            }
        }
        return sb.toString();
    }

    @UnstableApi
    public static boolean h1(int i2) {
        return i2 == 21 || i2 == 1342177280 || i2 == 22 || i2 == 1610612736 || i2 == 4;
    }

    @UnstableApi
    public static long[] h2(List<Long> list, long j2, long j3, RoundingMode roundingMode) {
        int i2;
        List<Long> list2 = list;
        long j4 = j2;
        long j5 = j3;
        RoundingMode roundingMode2 = roundingMode;
        int size = list.size();
        long[] jArr = new long[size];
        if (j4 == 0) {
            return jArr;
        }
        int i3 = 0;
        int i4 = (j5 > j4 ? 1 : (j5 == j4 ? 0 : -1));
        if (i4 >= 0 && j5 % j4 == 0) {
            long g2 = LongMath.g(j5, j4, RoundingMode.UNNECESSARY);
            while (i3 < size) {
                jArr[i3] = LongMath.g(list2.get(i3).longValue(), g2, roundingMode2);
                i3++;
            }
            return jArr;
        } else if (i4 >= 0 || j4 % j5 != 0) {
            int i5 = 0;
            while (i5 < size) {
                long longValue = list2.get(i5).longValue();
                if (longValue != 0) {
                    int i6 = (j5 > longValue ? 1 : (j5 == longValue ? 0 : -1));
                    if (i6 >= 0 && j5 % longValue == 0) {
                        jArr[i5] = LongMath.g(j4, LongMath.g(j5, longValue, RoundingMode.UNNECESSARY), roundingMode2);
                    } else if (i6 >= 0 || longValue % j5 != 0) {
                        i2 = i5;
                        jArr[i2] = g2(longValue, j2, j3, roundingMode);
                        i5 = i2 + 1;
                    } else {
                        jArr[i5] = LongMath.y(j4, LongMath.g(longValue, j5, RoundingMode.UNNECESSARY));
                    }
                }
                i2 = i5;
                i5 = i2 + 1;
            }
            return jArr;
        } else {
            long g3 = LongMath.g(j4, j5, RoundingMode.UNNECESSARY);
            while (i3 < size) {
                jArr[i3] = LongMath.y(list2.get(i3).longValue(), g3);
                i3++;
            }
            return jArr;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0017  */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x0015  */
    @androidx.media3.common.util.UnstableApi
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int i(int[] r3, int r4, boolean r5, boolean r6) {
        /*
            int r0 = java.util.Arrays.binarySearch(r3, r4)
            if (r0 >= 0) goto L_0x0008
            int r4 = ~r0
            goto L_0x0018
        L_0x0008:
            int r1 = r0 + 1
            int r2 = r3.length
            if (r1 >= r2) goto L_0x0013
            r2 = r3[r1]
            if (r2 != r4) goto L_0x0013
            r0 = r1
            goto L_0x0008
        L_0x0013:
            if (r5 == 0) goto L_0x0017
            r4 = r0
            goto L_0x0018
        L_0x0017:
            r4 = r1
        L_0x0018:
            if (r6 == 0) goto L_0x0021
            int r3 = r3.length
            int r3 = r3 + -1
            int r4 = java.lang.Math.min(r3, r4)
        L_0x0021:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.common.util.Util.i(int[], int, boolean, boolean):int");
    }

    @UnstableApi
    public static String i0(@Nullable Context context) {
        TelephonyManager telephonyManager;
        if (!(context == null || (telephonyManager = (TelephonyManager) context.getSystemService("phone")) == null)) {
            String networkCountryIso = telephonyManager.getNetworkCountryIso();
            if (!TextUtils.isEmpty(networkCountryIso)) {
                return Ascii.j(networkCountryIso);
            }
        }
        return Ascii.j(Locale.getDefault().getCountry());
    }

    @UnstableApi
    public static boolean i1(int i2) {
        return i2 == 3 || i2 == 2 || i2 == 268435456 || i2 == 21 || i2 == 1342177280 || i2 == 22 || i2 == 1610612736 || i2 == 4;
    }

    @UnstableApi
    public static void i2(long[] jArr, long j2, long j3, RoundingMode roundingMode) {
        long[] jArr2 = jArr;
        long j4 = j2;
        long j5 = j3;
        RoundingMode roundingMode2 = roundingMode;
        if (j4 == 0) {
            Arrays.fill(jArr2, 0);
            return;
        }
        int i2 = 0;
        int i3 = (j5 > j4 ? 1 : (j5 == j4 ? 0 : -1));
        if (i3 >= 0 && j5 % j4 == 0) {
            long g2 = LongMath.g(j5, j4, RoundingMode.UNNECESSARY);
            while (i2 < jArr2.length) {
                jArr2[i2] = LongMath.g(jArr2[i2], g2, roundingMode2);
                i2++;
            }
        } else if (i3 >= 0 || j4 % j5 != 0) {
            for (int i4 = 0; i4 < jArr2.length; i4++) {
                long j6 = jArr2[i4];
                if (j6 != 0) {
                    if (j5 >= j6 && j5 % j6 == 0) {
                        jArr2[i4] = LongMath.g(j4, LongMath.g(j5, j6, RoundingMode.UNNECESSARY), roundingMode2);
                    } else if (j5 >= j6 || j6 % j5 != 0) {
                        jArr2[i4] = g2(j6, j2, j3, roundingMode);
                    } else {
                        jArr2[i4] = LongMath.y(j4, LongMath.g(j6, j5, RoundingMode.UNNECESSARY));
                    }
                }
            }
        } else {
            long g3 = LongMath.g(j4, j5, RoundingMode.UNNECESSARY);
            while (i2 < jArr2.length) {
                jArr2[i2] = LongMath.y(jArr2[i2], g3);
                i2++;
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0019  */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x0017  */
    @androidx.media3.common.util.UnstableApi
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int j(long[] r5, long r6, boolean r8, boolean r9) {
        /*
            int r0 = java.util.Arrays.binarySearch(r5, r6)
            if (r0 >= 0) goto L_0x0008
            int r6 = ~r0
            goto L_0x001a
        L_0x0008:
            int r1 = r0 + 1
            int r2 = r5.length
            if (r1 >= r2) goto L_0x0015
            r2 = r5[r1]
            int r4 = (r2 > r6 ? 1 : (r2 == r6 ? 0 : -1))
            if (r4 != 0) goto L_0x0015
            r0 = r1
            goto L_0x0008
        L_0x0015:
            if (r8 == 0) goto L_0x0019
            r6 = r0
            goto L_0x001a
        L_0x0019:
            r6 = r1
        L_0x001a:
            if (r9 == 0) goto L_0x0023
            int r5 = r5.length
            int r5 = r5 + -1
            int r6 = java.lang.Math.min(r5, r6)
        L_0x0023:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.common.util.Util.j(long[], long, boolean, boolean):int");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0006, code lost:
        r0 = (android.hardware.display.DisplayManager) r2.getSystemService("display");
     */
    @androidx.media3.common.util.UnstableApi
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static android.graphics.Point j0(android.content.Context r2) {
        /*
            int r0 = f9646a
            r1 = 17
            if (r0 < r1) goto L_0x0016
            java.lang.String r0 = "display"
            java.lang.Object r0 = r2.getSystemService(r0)
            android.hardware.display.DisplayManager r0 = (android.hardware.display.DisplayManager) r0
            if (r0 == 0) goto L_0x0016
            r1 = 0
            android.view.Display r0 = r0.getDisplay(r1)
            goto L_0x0017
        L_0x0016:
            r0 = 0
        L_0x0017:
            if (r0 != 0) goto L_0x002b
            java.lang.String r0 = "window"
            java.lang.Object r0 = r2.getSystemService(r0)
            android.view.WindowManager r0 = (android.view.WindowManager) r0
            java.lang.Object r0 = androidx.media3.common.util.Assertions.g(r0)
            android.view.WindowManager r0 = (android.view.WindowManager) r0
            android.view.Display r0 = r0.getDefaultDisplay()
        L_0x002b:
            android.graphics.Point r2 = k0(r2, r0)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.common.util.Util.j0(android.content.Context):android.graphics.Point");
    }

    @UnstableApi
    public static boolean j1(Context context) {
        int i2 = f9646a;
        if (i2 >= 29 && context.getApplicationInfo().targetSdkVersion >= 29) {
            if (i2 == 30) {
                String str = f9649d;
                if (Ascii.a(str, "moto g(20)") || Ascii.a(str, "rmx3231")) {
                    return true;
                }
            }
            return false;
        }
        return true;
    }

    @UnstableApi
    public static void j2(Service service, int i2, Notification notification, int i3, String str) {
        if (f9646a >= 29) {
            Api29.a(service, i2, notification, i3, str);
        } else {
            service.startForeground(i2, notification);
        }
    }

    @UnstableApi
    public static int k(LongArray longArray, long j2, boolean z, boolean z2) {
        int i2;
        int c2 = longArray.c() - 1;
        int i3 = 0;
        while (i3 <= c2) {
            int i4 = (i3 + c2) >>> 1;
            if (longArray.b(i4) < j2) {
                i3 = i4 + 1;
            } else {
                c2 = i4 - 1;
            }
        }
        if (z && (i2 = c2 + 1) < longArray.c() && longArray.b(i2) == j2) {
            return i2;
        }
        if (!z2 || c2 != -1) {
            return c2;
        }
        return 0;
    }

    @UnstableApi
    public static Point k0(Context context, Display display) {
        if (display.getDisplayId() == 0 && q1(context)) {
            String O0 = O0(f9646a < 28 ? "sys.display-size" : "vendor.display-size");
            if (!TextUtils.isEmpty(O0)) {
                try {
                    String[] p2 = p2(O0.trim(), "x");
                    if (p2.length == 2) {
                        int parseInt = Integer.parseInt(p2[0]);
                        int parseInt2 = Integer.parseInt(p2[1]);
                        if (parseInt > 0 && parseInt2 > 0) {
                            return new Point(parseInt, parseInt2);
                        }
                    }
                } catch (NumberFormatException unused) {
                }
                Log.d(f9653h, "Invalid display size: " + O0);
            }
            if ("Sony".equals(f9648c) && f9649d.startsWith("BRAVIA") && context.getPackageManager().hasSystemFeature("com.sony.dtv.hardware.panel.qfhd")) {
                return new Point(3840, 2160);
            }
        }
        Point point = new Point();
        int i2 = f9646a;
        if (i2 >= 23) {
            q0(display, point);
        } else if (i2 >= 17) {
            p0(display, point);
        } else {
            o0(display, point);
        }
        return point;
    }

    @UnstableApi
    public static boolean k1(int i2) {
        return i2 == 10 || i2 == 13;
    }

    private static boolean k2(char c2) {
        return c2 == '\"' || c2 == '%' || c2 == '*' || c2 == '/' || c2 == ':' || c2 == '<' || c2 == '\\' || c2 == '|' || c2 == '>' || c2 == '?';
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0020  */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x001e  */
    @androidx.media3.common.util.UnstableApi
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static <T extends java.lang.Comparable<? super T>> int l(java.util.List<? extends java.lang.Comparable<? super T>> r3, T r4, boolean r5, boolean r6) {
        /*
            int r0 = java.util.Collections.binarySearch(r3, r4)
            if (r0 >= 0) goto L_0x000a
            int r0 = r0 + 2
            int r3 = -r0
            goto L_0x0021
        L_0x000a:
            int r1 = r0 + -1
            if (r1 < 0) goto L_0x001c
            java.lang.Object r2 = r3.get(r1)
            java.lang.Comparable r2 = (java.lang.Comparable) r2
            int r2 = r2.compareTo(r4)
            if (r2 != 0) goto L_0x001c
            r0 = r1
            goto L_0x000a
        L_0x001c:
            if (r5 == 0) goto L_0x0020
            r3 = r0
            goto L_0x0021
        L_0x0020:
            r3 = r1
        L_0x0021:
            if (r6 == 0) goto L_0x0028
            r4 = 0
            int r3 = java.lang.Math.max(r4, r3)
        L_0x0028:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.common.util.Util.l(java.util.List, java.lang.Comparable, boolean, boolean):int");
    }

    @UnstableApi
    public static Looper l0() {
        Looper myLooper = Looper.myLooper();
        return myLooper != null ? myLooper : Looper.getMainLooper();
    }

    @UnstableApi
    public static boolean l1(Uri uri) {
        String scheme = uri.getScheme();
        return TextUtils.isEmpty(scheme) || Annotation.k3.equals(scheme);
    }

    @EnsuresNonNullIf(expression = {"#1"}, result = false)
    public static boolean l2(@Nullable Player player) {
        return m2(player, true);
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0018  */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x0016  */
    @androidx.media3.common.util.UnstableApi
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int m(int[] r3, int r4, boolean r5, boolean r6) {
        /*
            int r0 = java.util.Arrays.binarySearch(r3, r4)
            if (r0 >= 0) goto L_0x000a
            int r0 = r0 + 2
            int r3 = -r0
            goto L_0x0019
        L_0x000a:
            int r1 = r0 + -1
            if (r1 < 0) goto L_0x0014
            r2 = r3[r1]
            if (r2 != r4) goto L_0x0014
            r0 = r1
            goto L_0x000a
        L_0x0014:
            if (r5 == 0) goto L_0x0018
            r3 = r0
            goto L_0x0019
        L_0x0018:
            r3 = r1
        L_0x0019:
            if (r6 == 0) goto L_0x0020
            r4 = 0
            int r3 = java.lang.Math.max(r4, r3)
        L_0x0020:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.common.util.Util.m(int[], int, boolean, boolean):int");
    }

    @UnstableApi
    public static Uri m0(String str, String str2) {
        return Uri.parse("data:" + str + ";base64," + Base64.encodeToString(str2.getBytes(), 2));
    }

    private static boolean m1(Uri uri) {
        if (!Annotation.i3.equals(uri.getScheme()) || !"media".equals(uri.getAuthority())) {
            return false;
        }
        List<String> pathSegments = uri.getPathSegments();
        if (pathSegments.isEmpty()) {
            return false;
        }
        String str = pathSegments.get(0);
        return "external".equals(str) || "external_primary".equals(str);
    }

    @UnstableApi
    @EnsuresNonNullIf(expression = {"#1"}, result = false)
    public static boolean m2(@Nullable Player player, boolean z) {
        if (player == null || !player.m0() || player.i() == 1 || player.i() == 4) {
            return true;
        }
        return z && player.g2() != 0;
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x001a  */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x0018  */
    @androidx.media3.common.util.UnstableApi
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int n(long[] r5, long r6, boolean r8, boolean r9) {
        /*
            int r0 = java.util.Arrays.binarySearch(r5, r6)
            if (r0 >= 0) goto L_0x000a
            int r0 = r0 + 2
            int r5 = -r0
            goto L_0x001b
        L_0x000a:
            int r1 = r0 + -1
            if (r1 < 0) goto L_0x0016
            r2 = r5[r1]
            int r4 = (r2 > r6 ? 1 : (r2 == r6 ? 0 : -1))
            if (r4 != 0) goto L_0x0016
            r0 = r1
            goto L_0x000a
        L_0x0016:
            if (r8 == 0) goto L_0x001a
            r5 = r0
            goto L_0x001b
        L_0x001a:
            r5 = r1
        L_0x001b:
            if (r9 == 0) goto L_0x0022
            r6 = 0
            int r5 = java.lang.Math.max(r6, r5)
        L_0x0022:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.common.util.Util.n(long[], long, boolean, boolean):int");
    }

    @UnstableApi
    public static Locale n0() {
        return f9646a >= 24 ? Locale.getDefault(Locale.Category.DISPLAY) : Locale.getDefault();
    }

    @ChecksSdkIntAtLeast(api = 23)
    private static boolean n1(Activity activity, Uri uri) {
        if (f9646a < 23) {
            return false;
        }
        if (l1(uri)) {
            return !e1(activity, uri);
        }
        return m1(uri);
    }

    @UnstableApi
    public static void n2(Throwable th) {
        o2(th);
    }

    @UnstableApi
    @EnsuresNonNull({"#1"})
    public static <T> T o(@Nullable T t2) {
        return t2;
    }

    private static void o0(Display display, Point point) {
        display.getSize(point);
    }

    @UnstableApi
    public static boolean o1() {
        String g2 = Ascii.g(f9647b);
        return g2.contains("emulator") || g2.contains("emu64a") || g2.contains("generic");
    }

    private static <T extends Throwable> void o2(Throwable th) throws Throwable {
        throw th;
    }

    @UnstableApi
    @EnsuresNonNull({"#1"})
    public static <T> T[] p(T[] tArr) {
        return tArr;
    }

    @RequiresApi(17)
    private static void p0(Display display, Point point) {
        display.getRealSize(point);
    }

    @RequiresApi(api = 24)
    private static boolean p1(Uri uri) {
        return "http".equals(uri.getScheme()) && !NetworkSecurityPolicy.getInstance().isCleartextTrafficPermitted((String) Assertions.g(uri.getHost()));
    }

    @UnstableApi
    public static String[] p2(String str, String str2) {
        return str.split(str2, -1);
    }

    @UnstableApi
    public static int q(int i2, int i3) {
        return ((i2 + i3) - 1) / i3;
    }

    @RequiresApi(23)
    private static void q0(Display display, Point point) {
        Display.Mode a2 = display.getMode();
        point.x = a2.getPhysicalWidth();
        point.y = a2.getPhysicalHeight();
    }

    @UnstableApi
    public static boolean q1(Context context) {
        UiModeManager uiModeManager = (UiModeManager) context.getApplicationContext().getSystemService("uimode");
        return uiModeManager != null && uiModeManager.getCurrentModeType() == 4;
    }

    @UnstableApi
    public static String[] q2(String str, String str2) {
        return str.split(str2, 2);
    }

    @UnstableApi
    public static long r(long j2, long j3) {
        return ((j2 + j3) - 1) / j3;
    }

    @UnstableApi
    public static Drawable r0(Context context, Resources resources, @DrawableRes int i2) {
        return f9646a >= 21 ? Api21.a(context, resources, i2) : resources.getDrawable(i2);
    }

    @UnstableApi
    public static boolean r1(Context context) {
        return f9646a >= 20 && context.getPackageManager().hasSystemFeature("android.hardware.type.watch");
    }

    @UnstableApi
    public static String[] r2(@Nullable String str) {
        return TextUtils.isEmpty(str) ? new String[0] : p2(str.trim(), "(\\s*,\\s*)");
    }

    public static boolean s(MediaItem... mediaItemArr) {
        if (f9646a < 24) {
            return true;
        }
        for (MediaItem mediaItem : mediaItemArr) {
            MediaItem.LocalConfiguration localConfiguration = mediaItem.X;
            if (localConfiguration != null) {
                if (p1(localConfiguration.s)) {
                    return false;
                }
                for (int i2 = 0; i2 < mediaItem.X.Z2.size(); i2++) {
                    if (p1(mediaItem.X.Z2.get(i2).s)) {
                        return false;
                    }
                }
                continue;
            }
        }
        return true;
    }

    @Nullable
    public static UUID s0(String str) {
        String g2 = Ascii.g(str);
        g2.hashCode();
        char c2 = 65535;
        switch (g2.hashCode()) {
            case -1860423953:
                if (g2.equals("playready")) {
                    c2 = 0;
                    break;
                }
                break;
            case -1400551171:
                if (g2.equals("widevine")) {
                    c2 = 1;
                    break;
                }
                break;
            case 790309106:
                if (g2.equals("clearkey")) {
                    c2 = 2;
                    break;
                }
                break;
        }
        switch (c2) {
            case 0:
                return C.l2;
            case 1:
                return C.k2;
            case 2:
                return C.j2;
            default:
                try {
                    return UUID.fromString(str);
                } catch (RuntimeException unused) {
                    return null;
                }
        }
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ Thread s1(String str, Runnable runnable) {
        return new Thread(runnable, str);
    }

    @UnstableApi
    @Nullable
    public static ComponentName s2(Context context, Intent intent) {
        return f9646a >= 26 ? context.startForegroundService(intent) : context.startService(intent);
    }

    @UnstableApi
    public static void t(@Nullable Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException unused) {
            }
        }
    }

    @UnstableApi
    public static int t0(int i2) {
        if (i2 == 2 || i2 == 4) {
            return PlaybackException.B3;
        }
        if (i2 == 10) {
            return PlaybackException.A3;
        }
        if (i2 == 7) {
            return PlaybackException.B3;
        }
        if (i2 == 8) {
            return PlaybackException.z3;
        }
        switch (i2) {
            case 15:
                return PlaybackException.z3;
            case 16:
            case 18:
                return PlaybackException.B3;
            case 17:
            case 19:
            case 20:
            case 21:
            case 22:
                return PlaybackException.A3;
            default:
                switch (i2) {
                    case 24:
                    case 25:
                    case 26:
                    case 27:
                    case 28:
                        return PlaybackException.y3;
                    default:
                        return PlaybackException.C3;
                }
        }
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ Thread t1(String str, Runnable runnable) {
        return new Thread(runnable, str);
    }

    @UnstableApi
    public static long t2(long j2, long j3, long j4) {
        long j5 = j2 - j3;
        return ((j2 ^ j5) & (j3 ^ j2)) < 0 ? j4 : j5;
    }

    @UnstableApi
    public static int u(long j2, long j3) {
        int i2 = (j2 > j3 ? 1 : (j2 == j3 ? 0 : -1));
        if (i2 < 0) {
            return -1;
        }
        return i2 == 0 ? 0 : 1;
    }

    @UnstableApi
    public static int u0(@Nullable String str) {
        String[] p2;
        int length;
        if (str == null || (length = p2.length) < 2) {
            return 0;
        }
        String str2 = (p2 = p2(str, "_"))[length - 1];
        boolean z = length >= 3 && "neg".equals(p2[length - 2]);
        try {
            int parseInt = Integer.parseInt((String) Assertions.g(str2));
            return z ? -parseInt : parseInt;
        } catch (NumberFormatException unused) {
            return 0;
        }
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void u1(SettableFuture settableFuture, Runnable runnable, Object obj) {
        try {
            if (!settableFuture.isCancelled()) {
                runnable.run();
                settableFuture.B(obj);
            }
        } catch (Throwable th) {
            settableFuture.C(th);
        }
    }

    @UnstableApi
    public static long u2(long... jArr) {
        long j2 = 0;
        for (long j3 : jArr) {
            j2 += j3;
        }
        return j2;
    }

    @UnstableApi
    public static float v(float f2, float f3, float f4) {
        return Math.max(f3, Math.min(f2, f4));
    }

    @UnstableApi
    public static String v0(int i2) {
        if (i2 == 0) {
            return "NO";
        }
        if (i2 == 1) {
            return "NO_UNSUPPORTED_TYPE";
        }
        if (i2 == 2) {
            return "NO_UNSUPPORTED_DRM";
        }
        if (i2 == 3) {
            return "NO_EXCEEDS_CAPABILITIES";
        }
        if (i2 == 4) {
            return "YES";
        }
        throw new IllegalStateException();
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void v1(SettableFuture settableFuture, ListenableFuture listenableFuture) {
        if (settableFuture.isCancelled()) {
            listenableFuture.cancel(false);
        }
    }

    @UnstableApi
    public static boolean v2(SQLiteDatabase sQLiteDatabase, String str) {
        return DatabaseUtils.queryNumEntries(sQLiteDatabase, "sqlite_master", "tbl_name = ?", new String[]{str}) > 0;
    }

    @UnstableApi
    public static int w(int i2, int i3, int i4) {
        return Math.max(i3, Math.min(i2, i4));
    }

    @UnstableApi
    public static int w0(String str) {
        int length = str.length();
        Assertions.a(length <= 4);
        char c2 = 0;
        for (int i2 = 0; i2 < length; i2++) {
            c2 = (c2 << 8) | str.charAt(i2);
        }
        return c2;
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void w1(ListenableFuture listenableFuture, SettableFuture settableFuture, AsyncFunction asyncFunction) {
        try {
            try {
                settableFuture.D(asyncFunction.apply(Futures.j(listenableFuture)));
            } catch (Throwable th) {
                settableFuture.C(th);
            }
        } catch (CancellationException unused) {
            settableFuture.cancel(false);
        } catch (ExecutionException e2) {
            e = e2;
            Throwable cause = e.getCause();
            if (cause != null) {
                e = cause;
            }
            settableFuture.C(e);
        } catch (Error | RuntimeException e3) {
            settableFuture.C(e3);
        }
    }

    @UnstableApi
    public static byte[] w2(float f2) {
        return x2(Float.floatToIntBits(f2));
    }

    @UnstableApi
    public static long x(long j2, long j3, long j4) {
        return Math.max(j3, Math.min(j2, j4));
    }

    @UnstableApi
    public static String x0(Locale locale) {
        return f9646a >= 21 ? y0(locale) : locale.toString();
    }

    @UnstableApi
    public static int x1(int[] iArr, int i2) {
        for (int i3 = 0; i3 < iArr.length; i3++) {
            if (iArr[i3] == i2) {
                return i3;
            }
        }
        return -1;
    }

    @UnstableApi
    public static byte[] x2(int i2) {
        return new byte[]{(byte) (i2 >> 24), (byte) (i2 >> 16), (byte) (i2 >> 8), (byte) i2};
    }

    @UnstableApi
    public static <T> boolean y(SparseArray<T> sparseArray, int i2) {
        return sparseArray.indexOfKey(i2) >= 0;
    }

    @RequiresApi(21)
    private static String y0(Locale locale) {
        return locale.toLanguageTag();
    }

    @UnstableApi
    public static int y1(long[] jArr, long j2) {
        for (int i2 = 0; i2 < jArr.length; i2++) {
            if (jArr[i2] == j2) {
                return i2;
            }
        }
        return -1;
    }

    @UnstableApi
    public static byte[] y2(InputStream inputStream) throws IOException {
        byte[] bArr = new byte[4096];
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        while (true) {
            int read = inputStream.read(bArr);
            if (read == -1) {
                return byteArrayOutputStream.toByteArray();
            }
            byteArrayOutputStream.write(bArr, 0, read);
        }
    }

    @UnstableApi
    public static boolean z(Object[] objArr, @Nullable Object obj) {
        for (Object g2 : objArr) {
            if (g(g2, obj)) {
                return true;
            }
        }
        return false;
    }

    @UnstableApi
    public static int z0(Context context) {
        return j1(context) ? 1 : 5;
    }

    @UnstableApi
    public static String z1(Context context, String str) throws IOException {
        InputStream inputStream = null;
        try {
            inputStream = context.getAssets().open(str);
            return T(y2(inputStream));
        } finally {
            t(inputStream);
        }
    }

    @UnstableApi
    public static byte[] z2(int... iArr) {
        byte[] bArr = new byte[(iArr.length * 4)];
        int i2 = 0;
        for (int x2 : iArr) {
            byte[] x22 = x2(x2);
            bArr[i2] = x22[0];
            bArr[i2 + 1] = x22[1];
            int i3 = i2 + 3;
            bArr[i2 + 2] = x22[2];
            i2 += 4;
            bArr[i3] = x22[3];
        }
        return bArr;
    }
}
