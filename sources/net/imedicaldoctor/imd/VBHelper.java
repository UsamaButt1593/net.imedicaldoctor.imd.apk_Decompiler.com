package net.imedicaldoctor.imd;

import android.content.Context;
import android.os.Bundle;
import android.provider.Settings;
import android.text.TextUtils;

import androidx.media3.extractor.metadata.icy.IcyHeaders;

import com.dd.plist.NSDictionary;
import com.dd.plist.PropertyListParser;
import com.google.firebase.crashlytics.FirebaseCrashlytics;

import java.io.File;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.Objects;
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
    static String activationCode;

    /* renamed from: f  reason: collision with root package name */
    static String f30454f;

    /* renamed from: g  reason: collision with root package name */
    static String f30455g;

    /* renamed from: a  reason: collision with root package name */
    Context context;

    /* renamed from: b  reason: collision with root package name */
    CompressHelper compressHelper;

    /* renamed from: c  reason: collision with root package name */
    Bundle f30458c;

    private static final byte[] SALT = {122, 12, 11, 120, 32, 34, 56, 78, 21, 24, 76, 21, 65, 32, 76, 31, 24, 64, 23};

    private static final byte[] IV1 = {31, 32, 33, 34, 35, 36, 37, 38, 39, 30, 31, 32, 33, 34, 35, 36};

    private static final byte[] IV2 = {117, 115, 111, 102, 103, 104, 111, 111, 108, 122, 120, 119, 111, 91, 110, 109};

    private static final String PASSWORD1 = "hs;d,hghdk[;ak";

    private static final char[] HEX_CHAR_ARRAY =
            {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    private static final String PAIR_SEPARATOR = "$$$";
    private static final String KEY_VALUE_SEPARATOR = ":::";



    public VBHelper(Context context) {
        this.context = context;
    }

    public byte[] decodeHexActivationCode(String activationCodeHex) {
        if (activationCodeHex == null || activationCodeHex.isEmpty()) {
            return null;
        }
        return decodeHexActivationCodeInternal(activationCodeHex);
    }

    public String decryptString(String activationCodeHex, String string) {
        try {
            return new String(performAesDecryption(string.toCharArray(), SALT, IV2, decodeHexActivationCode(activationCodeHex)));
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
        if (this.compressHelper == null) {
            this.compressHelper = new CompressHelper(this.context);
        }
        if (file != null) {
            try {
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
            NSDictionary nSDictionary = (NSDictionary) PropertyListParser.h(new String(performAesDecryption(charArray, "info.vb ".getBytes(charset), new byte[]{17, 115, 105, 102, 103, 104, 111, 107, 108, 122, 120, 119, 118, 98, 110, 109}, bArr)).replace("&", "&amp;").getBytes(charset));
            bundle = new Bundle();
            for (String str2 : nSDictionary.y()) {
                bundle.putString(str2, nSDictionary.N(str2).toString().replace("soheilvb", "&"));
            }
            if (file != null) {
                this.compressHelper.z0(file.getAbsolutePath(), w(bundle), (file.length() + file.lastModified()) + "");
            }
        } else {
            bundle = parseFormattedStringToBundle(str);
        }
        StringBuilder sb = new StringBuilder();
        if (bundle.containsKey("Version")) {
            z = y(bundle.getString("Name"), bundle.getString("Version"), sb);
            if (!sb.toString().isEmpty()) {
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

    /**
     * Converts a byte array to its uppercase hexadecimal string representation.
     *
     * @param bytes The byte array to convert.
     * @return The hexadecimal string representation of the byte array,
     * or an empty string if the input array is null or empty.
     */
    public String encodeActivationCodeToHexInternal(byte[] bytes) {
        // Each byte is represented by two hex characters
        char[] hexChars = new char[bytes.length * 2];

        for (int i = 0; i < bytes.length; i++) {
            byte currentByte = bytes[i];

            // Calculate the index in the hexChars array for the current byte's representation
            int charIndex = i * 2;

            // Get the most significant nibble (first 4 bits)
            // (currentByte & 0xFF) ensures the byte is treated as an unsigned value (0-255)
            // before the right shift.
            int mostSignificantNibble = (currentByte & 0xFF) >>> 4;
            hexChars[charIndex] = HEX_CHAR_ARRAY[mostSignificantNibble];

            // Get the least significant nibble (last 4 bits)
            int leastSignificantNibble = currentByte & 0x0F; // 0x0F is 15 in decimal
            hexChars[charIndex + 1] = HEX_CHAR_ARRAY[leastSignificantNibble];
        }

        return new String(hexChars);
    }

    public String g(String str, String str2) {
        Bundle t = t();
        if (t.containsKey(str)) {
            Bundle bundle = t.getBundle(str);
            if (Objects.equals(bundle.getString("cachevalidation"), str2)) {
                return bundle.getString("cachecontent");
            }
            CompressHelper compressHelper = this.compressHelper;
            String D0 = compressHelper.D0();
            compressHelper.q(D0, "Delete from cache where cachekey = '" + str + "'");
        }
        return null;
    }

    /**
     * Performs AES/CBC/PKCS7Padding encryption using a key derived via PBKDF2WithHmacSHA1.
     *
     * @param passwordChars The password characters for key derivation.
     * @param saltBytes     The salt for key derivation.
     * @param ivBytes       The initialization vector.
     * @param cipherText    The data to encrypt.
     * @return The encrypted byte array.
     * @throws Exception If any cryptographic error occurs.
     */
    public byte[] performAesEncryption(char[] passwordChars, byte[] saltBytes, byte[] ivBytes, byte[] cipherText) throws Exception {
        SecretKeySpec secretKeySpec = new SecretKeySpec(SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1").generateSecret(new PBEKeySpec(passwordChars, saltBytes, 19, 128)).getEncoded(), "AES");
        IvParameterSpec ivParameterSpec = new IvParameterSpec(ivBytes);
        Cipher instance = Cipher.getInstance("AES/CBC/PKCS7Padding");
        instance.init(1, secretKeySpec, ivParameterSpec);
        return instance.doFinal(cipherText);
    }

    /**
     * Performs AES/CBC/PKCS7Padding decryption using a key derived via PBKDF2WithHmacSHA1.
     *
     * @param passwordChars The password characters for key derivation.
     * @param saltBytes     The salt for key derivation.
     * @param ivBytes       The initialization vector.
     * @param cipherText    The encrypted data to decrypt.
     * @return The decrypted byte array.
     * @throws Exception If any cryptographic error occurs.
     */
    public byte[] performAesDecryption(char[] passwordChars, byte[] saltBytes, byte[] ivBytes, byte[] cipherText) throws Exception {
        SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
        PBEKeySpec spec = new PBEKeySpec(passwordChars, saltBytes, 19, 128); // Iteration count and key length
        SecretKeySpec secretKey = new SecretKeySpec(factory.generateSecret(spec).getEncoded(), "AES");

        IvParameterSpec ivParameterSpec = new IvParameterSpec(ivBytes);
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS7Padding");
        cipher.init(Cipher.DECRYPT_MODE, secretKey, ivParameterSpec);
        return cipher.doFinal(cipherText);
    }

    /**
     * Decrypts a hex-encoded string if the provided access key is correct.
     *
     * @param hexEncodedData The hex-encoded string to decrypt.
     * @return The decrypted string, or an empty string if hexEncodedData is empty,
     * or null if accessKey is incorrect or decryption fails.
     */
    public String decryptHexEncodedStringForKey(String hexEncodedData) {
        if (hexEncodedData == null || hexEncodedData.isEmpty()) {
            return "";
        }

        try {
            // Consider making the password and salt class constants if they are fixed
            char[] password = PASSWORD1.toCharArray();
            byte[] cipherText = decodeHexActivationCodeInternal(hexEncodedData); // Renamed 'u'

            byte[] decryptedBytes = performAesDecryption(password, SALT, IV1, cipherText);
            return new String(decryptedBytes, StandardCharsets.UTF_8); // Specify charset
        } catch (Exception unused) {
            // Log the exception here for better debugging
            return null;
        }
    }

    public String decryptStringWithIv1(String activationCodeHex, String string) {
        if (activationCodeHex == null) {
            return "";
        }

        try {
            return new String(performAesDecryption(string.toCharArray(), SALT, IV1, decodeHexActivationCodeInternal(activationCodeHex)));
        } catch (Exception unused) {
            return null;
        }
    }

    /**
     * Parses a specially formatted string into an Android Bundle.
     * The input string is expected to contain key-value pairs.
     * Pairs are separated by "$$$".
     * Within each pair, the key and value are separated by ":::".
     * <p>
     * Example input string: "key1:::value1$$$key2:::value2"
     *
     * @param formattedString The input string containing key-value pairs.
     * @return A Bundle populated with the parsed key-value pairs.
     * Returns an empty Bundle if the input string is null, empty,
     * or does not contain valid pairs.
     */
    public Bundle parseFormattedStringToBundle(String formattedString) {
        Bundle bundle = new Bundle();

        if (StringUtils.isBlank(formattedString)) {
            return bundle; // Return an empty bundle if input is null or blank
        }

        // Split the input string into individual key-value pair strings
        // e.g., ["key1:::value1", "key2:::value2"]
        String[] keyValuePairs = StringUtils.splitByWholeSeparator(formattedString, PAIR_SEPARATOR);

        for (String pairString : keyValuePairs) {
            if (StringUtils.isBlank(pairString)) {
                continue; // Skip if a pair string is blank
            }

            // Split each pair string into key and value
            // e.g., ["key1", "value1"]
            String[] keyAndValue = StringUtils.splitByWholeSeparator(pairString, KEY_VALUE_SEPARATOR);

            // Ensure the split resulted in exactly two parts (key and value)
            if (keyAndValue != null && keyAndValue.length == 2) {
                String key = keyAndValue[0];
                String value = keyAndValue[1];

                // It's good practice to ensure the key is not blank before putting it into the bundle
                if (StringUtils.isNotBlank(key)) {
                    bundle.putString(key, value);
                } else {
                    // Optionally log a warning or handle cases where key is blank
                    System.err.println("Warning: Encountered a blank key in formatted string: " + pairString);
                }
            } else {
                // Optionally log a warning or handle malformed pair strings
                System.err.println("Warning: Malformed key-value pair encountered: " + pairString);
            }
        }
        return bundle;
    }


    public String m() {
        int versionCode;
        try {
            versionCode = this.context.getPackageManager().getPackageInfo(this.context.getPackageName(), 0).versionCode;
        } catch (Exception e2) {
            FirebaseCrashlytics.d().g(e2);
            versionCode = 0;
        }

        String androidId = Settings.Secure.getString(this.context.getContentResolver(), "android_id");
        if (androidId == null) {
            androidId = "soheilvb";
        }

        if (this.context.getSharedPreferences("default_preferences", 0).contains("DS")) {
            String string2 = this.context.getSharedPreferences("default_preferences", 0).getString("DS", "");
            String k2 = decryptStringWithIv1(string2, androidId + "30");
            if (k2 != null) {
                return k2;
            }
        }

        byte[] bArr2 = {122, 13, 11, 120, 32, 34, 56, 78, 21, 24, 76, 21, 65, 32, 76, 31, 24, 64, 23};
        try {
            String replace = encodeActivationCodeToHexInternal(
                    performAesEncryption(
                            "hs;d,hghdk[;".toCharArray(),
                            bArr2,
                            IV1,
                            (UUID.randomUUID().toString() + ",,,,," + versionCode).getBytes(StandardCharsets.UTF_8)
                    )
            ).replace(StringUtils.LF, "XX");

            String encodedActivationCode = encodeActivationCodeToHexWithPassword(replace, androidId + "30");
            if (this.context.getSharedPreferences("default_preferences", 0).contains("DS")) {
                this.context.getSharedPreferences("default_preferences", 0).edit().remove("DS").commit();
            }
            this.context.getSharedPreferences("default_preferences", 0).edit().putString("DS", encodedActivationCode).commit();
            return replace;
        } catch (Exception e3) {
            FirebaseCrashlytics.d().g(e3);
            return null;
        }
    }

    public String encodeActivationCodeToHex(String string) {
        return encodeActivationCodeToHexWithPassword(string, PASSWORD1);
    }

    public String encodeActivationCodeToHexWithPassword(String string, String password) {
        try {
            return encodeActivationCodeToHexInternal(performAesEncryption(password.toCharArray(), SALT, IV1, string.getBytes(StandardCharsets.UTF_8)));
        } catch (Exception unused) {
            return null;
        }
    }

    public String encodeActivationCodeBytesToHex(byte[] bytes) {
        try {
            return encodeActivationCodeToHexInternal(performAesEncryption(PASSWORD1.toCharArray(), SALT, IV1, bytes));
        } catch (Exception unused) {
            return null;
        }
    }

    public String q(String str, String str2) {
        StringBuilder str2Builder = new StringBuilder(str2);
        for (int length = str2Builder.length(); length < 8; length++) {
            str2Builder.append(StringUtils.SPACE);
        }
        str2 = str2Builder.toString();

        try {
            return encodeActivationCodeToHexInternal(
                    performAesEncryption(
                            "soheilvb'ghndhj,v".toCharArray(),
                            str2.getBytes(StandardCharsets.UTF_8),
                            IV2,
                            str.getBytes(StandardCharsets.UTF_8)
                    )
            );
        } catch (Exception e2) {
            FirebaseCrashlytics.d().g(e2);
            return null;
        }
    }

    public String getActivationCode() {
        return this.context.getSharedPreferences("default_preferences", 0).getString("ActivationCode", "");
    }

    public void s() {
        String r = getActivationCode();
        if (!Objects.equals(r, activationCode)) {
            String[] split = TextUtils.split(x(m()).replace("||", "::"), "::");
            String str = split[1];
            String[] split2 = TextUtils.split(split[3], ",");
            activationCode = r;
            f30452d = split2;
        }
    }

    public Bundle t() {
        if (this.f30458c == null) {
            Bundle bundle = new Bundle();
            CompressHelper compressHelper = this.compressHelper;
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

    public byte[] decodeHexActivationCodeInternal(String activationCode) {
        String trimmedActivationCode = activationCode.trim();
        int length = trimmedActivationCode.length();
        byte[] bArr = new byte[(length / 2)];
        for (int i2 = 0; i2 < length; i2 += 2) {
            bArr[i2 / 2] = (byte) ((Character.digit(trimmedActivationCode.charAt(i2), 16) << 4) + Character.digit(trimmedActivationCode.charAt(i2 + 1), 16));
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
        String r = getActivationCode();
        if (f30455g == r) {
            return f30454f;
        }
        try {
            str2 = new String(performAesDecryption(str.toCharArray(), SALT, IV2, decodeHexActivationCode(r)));
        } catch (Exception unused) {
            str2 = null;
        }
        if (str2 == null) {
            this.context.getSharedPreferences("default_preferences", 0).edit().remove("ActivationCode").commit();
            return null;
        }
        FirebaseCrashlytics.d().r(TextUtils.split(str2.replace("||", "::"), "::")[9]);
        f30454f = str2;
        f30455g = r;
        return str2;
    }

    public boolean y(String str, String str2, StringBuilder sb) {
        ArrayList<String> arrayList = new ArrayList<>();
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
        if (!arrayList.contains("all")) {
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
