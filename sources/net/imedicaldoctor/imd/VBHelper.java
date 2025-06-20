package net.imedicaldoctor.imd;

import android.content.Context;
import android.os.Bundle;
import android.provider.Settings;
import android.text.TextUtils;
import androidx.media3.extractor.metadata.icy.IcyHeaders;
import com.dd.plist.ASCIIPropertyListParser;
import com.dd.plist.NSDictionary;
import com.dd.plist.PropertyListParser;
import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import com.google.firebase.crashlytics.FirebaseCrashlytics;
import com.itextpdf.text.DocWriter;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.File;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.UUID;
import javax.crypto.Cipher;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;
import net.imedicaldoctor.imd.Data.CompressHelper;
import org.apache.commons.lang3.StringUtils;

public class VBHelper {

    /* renamed from: d  reason: collision with root package name */
    static String[] f30452d;

    /* renamed from: e  reason: collision with root package name */
    static String f30453e;

    /* renamed from: f  reason: collision with root package name */
    static String f30454f;

    /* renamed from: g  reason: collision with root package name */
    static String f30455g;

    /* renamed from: a  reason: collision with root package name */
    Context f30456a;

    /* renamed from: b  reason: collision with root package name */
    CompressHelper f30457b;

    /* renamed from: c  reason: collision with root package name */
    Bundle f30458c;

    public VBHelper(Context context) {
        this.f30456a = context;
    }

    public byte[] a(String str) {
        if (str == null || str.length() == 0) {
            return null;
        }
        return u(str);
    }

    public String b(String str, String str2) {
        byte[] bArr = {117, 115, 111, 102, 103, 104, 111, 111, 108, 122, 120, 119, 111, 91, 110, 109};
        try {
            return new String(i(str2.toCharArray(), new byte[]{122, 12, 11, 120, 32, DocWriter.e3, 56, 78, Ascii.y, Ascii.B, 76, Ascii.y, 65, 32, 76, Ascii.I, Ascii.B, SignedBytes.f22967a, Ascii.A}, bArr, a(str)));
        } catch (Exception unused) {
            return null;
        }
    }

    public Bundle c(byte[] bArr) {
        return e(bArr, (File) null);
    }

    public Bundle d(File file) {
        try {
            return e(CompressHelper.d2(file), file);
        } catch (Exception e2) {
            FirebaseCrashlytics.d().g(e2);
            iMDLogger.f("analyzeVBE vbeFile", "Error in reading vbe file " + e2);
            e2.printStackTrace();
            return null;
        }
    }

    public Bundle e(byte[] bArr, File file) {
        String str;
        Bundle bundle;
        boolean z = true;
        if (this.f30457b == null) {
            this.f30457b = new CompressHelper(this.f30456a);
        }
        if (file != null) {
            try {
                file.length();
                file.lastModified();
                str = g(file.getAbsolutePath(), (file.length() + file.lastModified()) + "");
            } catch (Exception e2) {
                iMDLogger.f("AnalyzeVBE", "Error in decrypting " + e2.getMessage());
                e2.printStackTrace();
                return null;
            }
        } else {
            str = null;
        }
        if (str == null) {
            char[] charArray = TextUtils.split(x(m()).replace("||", "::"), "::")[1].toCharArray();
            Charset charset = StandardCharsets.UTF_8;
            NSDictionary nSDictionary = (NSDictionary) PropertyListParser.h(new String(i(charArray, "info.vb ".getBytes(charset), new byte[]{17, 115, 105, 102, 103, 104, 111, 107, 108, 122, 120, 119, 118, 98, 110, 109}, bArr)).replace("&", "&amp;").getBytes(charset));
            bundle = new Bundle();
            for (String str2 : nSDictionary.y()) {
                bundle.putString(str2, nSDictionary.N(str2).toString().replace("soheilvb", "&"));
            }
            if (file != null) {
                this.f30457b.z0(file.getAbsolutePath(), w(bundle), (file.length() + file.lastModified()) + "");
            }
        } else {
            bundle = l(str);
        }
        StringBuilder sb = new StringBuilder();
        if (bundle.containsKey("Version")) {
            z = y(bundle.getString("Name"), bundle.getString("Version"), sb);
            if (sb.toString().length() > 0) {
                bundle.putString("ExpDate", sb.toString());
            }
        }
        if (!z) {
            bundle.putString("Inactive", IcyHeaders.a3);
            if (v(bundle.getString("Type"))) {
                bundle.putString("Demo", IcyHeaders.a3);
            }
        }
        return bundle;
    }

    public String f(byte[] bArr) {
        char[] cArr = {'0', '1', PdfWriter.p4, PdfWriter.q4, PdfWriter.r4, PdfWriter.s4, PdfWriter.t4, PdfWriter.u4, '8', '9', 'A', ASCIIPropertyListParser.u, 'C', ASCIIPropertyListParser.t, 'E', 'F'};
        char[] cArr2 = new char[(bArr.length * 2)];
        for (int i2 = 0; i2 < bArr.length; i2++) {
            byte b2 = bArr[i2];
            int i3 = i2 * 2;
            cArr2[i3] = cArr[(b2 & 255) >>> 4];
            cArr2[i3 + 1] = cArr[b2 & 15];
        }
        return new String(cArr2);
    }

    public String g(String str, String str2) {
        Bundle t = t();
        if (t.containsKey(str)) {
            Bundle bundle = t.getBundle(str);
            if (bundle.getString("cachevalidation").equals(str2)) {
                return bundle.getString("cachecontent");
            }
            CompressHelper compressHelper = this.f30457b;
            String D0 = compressHelper.D0();
            compressHelper.q(D0, "Delete from cache where cachekey = '" + str + "'");
        }
        return null;
    }

    public byte[] h(char[] cArr, byte[] bArr, byte[] bArr2, byte[] bArr3) throws Exception {
        SecretKeySpec secretKeySpec = new SecretKeySpec(SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1").generateSecret(new PBEKeySpec(cArr, bArr, 19, 128)).getEncoded(), "AES");
        IvParameterSpec ivParameterSpec = new IvParameterSpec(bArr2);
        Cipher instance = Cipher.getInstance("AES/CBC/PKCS7Padding");
        instance.init(1, secretKeySpec, ivParameterSpec);
        return instance.doFinal(bArr3);
    }

    public byte[] i(char[] cArr, byte[] bArr, byte[] bArr2, byte[] bArr3) throws Exception {
        SecretKeySpec secretKeySpec = new SecretKeySpec(SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1").generateSecret(new PBEKeySpec(cArr, bArr, 19, 128)).getEncoded(), "AES");
        IvParameterSpec ivParameterSpec = new IvParameterSpec(bArr2);
        Cipher instance = Cipher.getInstance("AES/CBC/PKCS7Padding");
        instance.init(2, secretKeySpec, ivParameterSpec);
        return instance.doFinal(bArr3);
    }

    public String j(String str, String str2) {
        if (str == null || str.equals("")) {
            return "";
        }
        if (!str2.equals("127")) {
            return null;
        }
        byte[] bArr = {Ascii.I, 32, 33, DocWriter.e3, 35, 36, 37, 38, 39, Ascii.H, Ascii.I, 32, 33, DocWriter.e3, 35, 36};
        try {
            return new String(i("hs;d,hghdk[;ak".toCharArray(), new byte[]{122, 12, 11, 120, 32, DocWriter.e3, 56, 78, Ascii.y, Ascii.B, 76, Ascii.y, 65, 32, 76, Ascii.I, Ascii.B, SignedBytes.f22967a, Ascii.A}, bArr, u(str)));
        } catch (Exception unused) {
            return null;
        }
    }

    public String k(String str, String str2, String str3) {
        if (str == null) {
            return "";
        }
        if (!str2.equals("127")) {
            return null;
        }
        byte[] bArr = {Ascii.I, 32, 33, DocWriter.e3, 35, 36, 37, 38, 39, Ascii.H, Ascii.I, 32, 33, DocWriter.e3, 35, 36};
        try {
            return new String(i(str3.toCharArray(), new byte[]{122, 12, 11, 120, 32, DocWriter.e3, 56, 78, Ascii.y, Ascii.B, 76, Ascii.y, 65, 32, 76, Ascii.I, Ascii.B, SignedBytes.f22967a, Ascii.A}, bArr, u(str)));
        } catch (Exception unused) {
            return null;
        }
    }

    public Bundle l(String str) {
        String[] splitByWholeSeparator = StringUtils.splitByWholeSeparator(str, "$$$");
        Bundle bundle = new Bundle();
        for (String splitByWholeSeparator2 : splitByWholeSeparator) {
            String[] splitByWholeSeparator3 = StringUtils.splitByWholeSeparator(splitByWholeSeparator2, ":::");
            bundle.putString(splitByWholeSeparator3[0], splitByWholeSeparator3[1]);
        }
        return bundle;
    }

    public String m() {
        int i2;
        try {
            i2 = this.f30456a.getPackageManager().getPackageInfo(this.f30456a.getPackageName(), 0).versionCode;
        } catch (Exception e2) {
            FirebaseCrashlytics.d().g(e2);
            i2 = 0;
        }
        String string = Settings.Secure.getString(this.f30456a.getContentResolver(), "android_id");
        if (string == null) {
            string = "soheilvb";
        }
        if (this.f30456a.getSharedPreferences("default_preferences", 0).contains("DS")) {
            String string2 = this.f30456a.getSharedPreferences("default_preferences", 0).getString("DS", "");
            String k2 = k(string2, "127", string + "30");
            if (k2 != null) {
                return k2;
            }
        }
        byte[] bArr = {Ascii.I, 32, 33, DocWriter.e3, 35, 36, 37, 38, 39, Ascii.H, Ascii.I, 32, 33, DocWriter.e3, 35, 36};
        byte[] bArr2 = {122, 13, 11, 120, 32, DocWriter.e3, 56, 78, Ascii.y, Ascii.B, 76, Ascii.y, 65, 32, 76, Ascii.I, Ascii.B, SignedBytes.f22967a, Ascii.A};
        try {
            String replace = f(h("hs;d,hghdk[;".toCharArray(), bArr2, bArr, (UUID.randomUUID().toString() + ",,,,," + i2).getBytes(StandardCharsets.UTF_8))).replace(StringUtils.LF, "XX");
            String o = o(replace, "127", string + "30");
            if (this.f30456a.getSharedPreferences("default_preferences", 0).contains("DS")) {
                this.f30456a.getSharedPreferences("default_preferences", 0).edit().remove("DS").commit();
            }
            this.f30456a.getSharedPreferences("default_preferences", 0).edit().putString("DS", o).commit();
            return replace;
        } catch (Exception e3) {
            FirebaseCrashlytics.d().g(e3);
            return null;
        }
    }

    public String n(String str, String str2) {
        if (!str2.equals("127")) {
            return null;
        }
        byte[] bArr = {Ascii.I, 32, 33, DocWriter.e3, 35, 36, 37, 38, 39, Ascii.H, Ascii.I, 32, 33, DocWriter.e3, 35, 36};
        try {
            return f(h("hs;d,hghdk[;ak".toCharArray(), new byte[]{122, 12, 11, 120, 32, DocWriter.e3, 56, 78, Ascii.y, Ascii.B, 76, Ascii.y, 65, 32, 76, Ascii.I, Ascii.B, SignedBytes.f22967a, Ascii.A}, bArr, str.getBytes(StandardCharsets.UTF_8)));
        } catch (Exception unused) {
            return null;
        }
    }

    public String o(String str, String str2, String str3) {
        if (!str2.equals("127")) {
            return null;
        }
        byte[] bArr = {Ascii.I, 32, 33, DocWriter.e3, 35, 36, 37, 38, 39, Ascii.H, Ascii.I, 32, 33, DocWriter.e3, 35, 36};
        try {
            return f(h(str3.toCharArray(), new byte[]{122, 12, 11, 120, 32, DocWriter.e3, 56, 78, Ascii.y, Ascii.B, 76, Ascii.y, 65, 32, 76, Ascii.I, Ascii.B, SignedBytes.f22967a, Ascii.A}, bArr, str.getBytes(StandardCharsets.UTF_8)));
        } catch (Exception unused) {
            return null;
        }
    }

    public String p(byte[] bArr, String str) {
        if (!str.equals("127")) {
            return null;
        }
        byte[] bArr2 = {Ascii.I, 32, 33, DocWriter.e3, 35, 36, 37, 38, 39, Ascii.H, Ascii.I, 32, 33, DocWriter.e3, 35, 36};
        try {
            return f(h("hs;d,hghdk[;ak".toCharArray(), new byte[]{122, 12, 11, 120, 32, DocWriter.e3, 56, 78, Ascii.y, Ascii.B, 76, Ascii.y, 65, 32, 76, Ascii.I, Ascii.B, SignedBytes.f22967a, Ascii.A}, bArr2, bArr));
        } catch (Exception unused) {
            return null;
        }
    }

    public String q(String str, String str2) {
        for (int length = str2.length(); length < 8; length++) {
            str2 = str2 + StringUtils.SPACE;
        }
        byte[] bArr = {117, 115, 111, 102, 103, 104, 111, 111, 108, 122, 120, 119, 111, 91, 110, 109};
        try {
            char[] charArray = "soheilvb'ghndhj,v".toCharArray();
            Charset charset = StandardCharsets.UTF_8;
            return f(h(charArray, str2.getBytes(charset), bArr, str.getBytes(charset)));
        } catch (Exception e2) {
            FirebaseCrashlytics.d().g(e2);
            return null;
        }
    }

    public String r() {
        return this.f30456a.getSharedPreferences("default_preferences", 0).getString("ActivationCode", "");
    }

    public void s() {
        String r = r();
        if (r != f30453e) {
            String[] split = TextUtils.split(x(m()).replace("||", "::"), "::");
            String str = split[1];
            String[] split2 = TextUtils.split(split[3], ",");
            f30453e = r;
            f30452d = split2;
        }
    }

    public Bundle t() {
        if (this.f30458c == null) {
            Bundle bundle = new Bundle();
            CompressHelper compressHelper = this.f30457b;
            ArrayList<Bundle> Y = compressHelper.Y(compressHelper.D0(), "Select * from cache");
            if (Y == null) {
                return bundle;
            }
            Iterator<Bundle> it2 = Y.iterator();
            while (it2.hasNext()) {
                Bundle next = it2.next();
                bundle.putBundle(next.getString("cachekey"), next);
            }
            this.f30458c = bundle;
        }
        return this.f30458c;
    }

    public byte[] u(String str) {
        String trim = str.trim();
        int length = trim.length();
        byte[] bArr = new byte[(length / 2)];
        for (int i2 = 0; i2 < length; i2 += 2) {
            bArr[i2 / 2] = (byte) ((Character.digit(trim.charAt(i2), 16) << 4) + Character.digit(trim.charAt(i2 + 1), 16));
        }
        return bArr;
    }

    public boolean v(String str) {
        return TextUtils.split(x(m()).replace("||", "::"), "::")[6].equals("0");
    }

    public String w(Bundle bundle) {
        ArrayList arrayList = new ArrayList();
        for (String next : bundle.keySet()) {
            arrayList.add(next + ":::" + bundle.getString(next));
        }
        return StringUtils.join((Iterable<?>) arrayList, "$$$");
    }

    public String x(String str) {
        String str2;
        String r = r();
        if (f30455g == r) {
            return f30454f;
        }
        try {
            str2 = new String(i(str.toCharArray(), new byte[]{122, 12, 11, 120, 32, DocWriter.e3, 56, 78, Ascii.y, Ascii.B, 76, Ascii.y, 65, 32, 76, Ascii.I, Ascii.B, SignedBytes.f22967a, Ascii.A}, new byte[]{117, 115, 111, 102, 103, 104, 111, 111, 108, 122, 120, 119, 111, 91, 110, 109}, a(r)));
        } catch (Exception unused) {
            str2 = null;
        }
        if (str2 == null) {
            this.f30456a.getSharedPreferences("default_preferences", 0).edit().remove("ActivationCode").commit();
            return null;
        }
        FirebaseCrashlytics.d().r(TextUtils.split(str2.replace("||", "::"), "::")[9]);
        f30454f = str2;
        f30455g = r;
        return str2;
    }

    public boolean y(String str, String str2, StringBuilder sb) {
        ArrayList arrayList = new ArrayList();
        Bundle bundle = new Bundle();
        s();
        for (String str3 : f30452d) {
            if (str3.contains("$$$")) {
                String str4 = StringUtils.splitByWholeSeparator(str3, "$$$")[0];
                if (str4.contains("-expired")) {
                    str4 = str4.replace("-expired", "");
                }
                arrayList.add(str4);
                bundle.putString(str4, StringUtils.splitByWholeSeparator(str3, "$$$")[1]);
            } else {
                arrayList.add(str3);
            }
        }
        if (!arrayList.contains(TtmlNode.r0)) {
            if (!arrayList.contains(str)) {
                return false;
            }
            if (bundle.containsKey(str)) {
                String string = bundle.getString(str);
                String format = new SimpleDateFormat("yyyyMMdd").format(new Date());
                sb.append(string);
                if (str2.length() == 6) {
                    string = string.substring(0, 6);
                    format = format.substring(0, 6);
                }
                if (string.compareTo(str2) >= 0) {
                    return !str.equals("uptodateonline") || string.compareTo(format) >= 0;
                }
                return false;
            }
        }
    }

    public Bundle z() {
        s();
        Bundle bundle = new Bundle();
        for (String str : f30452d) {
            if (str.contains("$$$")) {
                String str2 = StringUtils.splitByWholeSeparator(str, "$$$")[0];
                if (str2.contains("-expired")) {
                    str2 = str2.replace("-expired", "");
                }
                bundle.putString(str2, StringUtils.splitByWholeSeparator(str, "$$$")[1]);
            } else {
                bundle.putString(str, "0");
            }
        }
        return bundle;
    }
}
