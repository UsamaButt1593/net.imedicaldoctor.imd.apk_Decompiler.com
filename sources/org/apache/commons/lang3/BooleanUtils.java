package org.apache.commons.lang3;

import com.itextpdf.text.pdf.PdfBoolean;
import kotlinx.coroutines.DebugKt;
import org.apache.commons.lang3.math.NumberUtils;

public class BooleanUtils {
    public static Boolean and(Boolean... boolArr) {
        if (boolArr == null) {
            throw new IllegalArgumentException("The Array must not be null");
        } else if (boolArr.length != 0) {
            try {
                return and(ArrayUtils.toPrimitive(boolArr)) ? Boolean.TRUE : Boolean.FALSE;
            } catch (NullPointerException unused) {
                throw new IllegalArgumentException("The array must not contain any null elements");
            }
        } else {
            throw new IllegalArgumentException("Array is empty");
        }
    }

    public static boolean isFalse(Boolean bool) {
        return Boolean.FALSE.equals(bool);
    }

    public static boolean isNotFalse(Boolean bool) {
        return !isFalse(bool);
    }

    public static boolean isNotTrue(Boolean bool) {
        return !isTrue(bool);
    }

    public static boolean isTrue(Boolean bool) {
        return Boolean.TRUE.equals(bool);
    }

    public static Boolean negate(Boolean bool) {
        if (bool == null) {
            return null;
        }
        return bool.booleanValue() ? Boolean.FALSE : Boolean.TRUE;
    }

    public static Boolean or(Boolean... boolArr) {
        if (boolArr == null) {
            throw new IllegalArgumentException("The Array must not be null");
        } else if (boolArr.length != 0) {
            try {
                return or(ArrayUtils.toPrimitive(boolArr)) ? Boolean.TRUE : Boolean.FALSE;
            } catch (NullPointerException unused) {
                throw new IllegalArgumentException("The array must not contain any null elements");
            }
        } else {
            throw new IllegalArgumentException("Array is empty");
        }
    }

    public static boolean toBoolean(int i2) {
        return i2 != 0;
    }

    public static boolean toBooleanDefaultIfNull(Boolean bool, boolean z) {
        return bool == null ? z : bool.booleanValue();
    }

    public static Boolean toBooleanObject(int i2) {
        return i2 == 0 ? Boolean.FALSE : Boolean.TRUE;
    }

    public static int toInteger(Boolean bool, int i2, int i3, int i4) {
        if (bool == null) {
            return i4;
        }
        return bool.booleanValue() ? i2 : i3;
    }

    public static Integer toIntegerObject(Boolean bool) {
        if (bool == null) {
            return null;
        }
        return bool.booleanValue() ? NumberUtils.INTEGER_ONE : NumberUtils.INTEGER_ZERO;
    }

    public static String toString(Boolean bool, String str, String str2, String str3) {
        if (bool == null) {
            return str3;
        }
        return bool.booleanValue() ? str : str2;
    }

    public static String toStringOnOff(Boolean bool) {
        return toString(bool, DebugKt.f29173d, DebugKt.f29174e, (String) null);
    }

    public static String toStringTrueFalse(Boolean bool) {
        return toString(bool, PdfBoolean.l3, "false", (String) null);
    }

    public static String toStringYesNo(Boolean bool) {
        return toString(bool, "yes", "no", (String) null);
    }

    public static Boolean xor(Boolean... boolArr) {
        if (boolArr == null) {
            throw new IllegalArgumentException("The Array must not be null");
        } else if (boolArr.length != 0) {
            try {
                return xor(ArrayUtils.toPrimitive(boolArr)) ? Boolean.TRUE : Boolean.FALSE;
            } catch (NullPointerException unused) {
                throw new IllegalArgumentException("The array must not contain any null elements");
            }
        } else {
            throw new IllegalArgumentException("Array is empty");
        }
    }

    public static boolean and(boolean... zArr) {
        if (zArr == null) {
            throw new IllegalArgumentException("The Array must not be null");
        } else if (zArr.length != 0) {
            for (boolean z : zArr) {
                if (!z) {
                    return false;
                }
            }
            return true;
        } else {
            throw new IllegalArgumentException("Array is empty");
        }
    }

    public static boolean or(boolean... zArr) {
        if (zArr == null) {
            throw new IllegalArgumentException("The Array must not be null");
        } else if (zArr.length != 0) {
            for (boolean z : zArr) {
                if (z) {
                    return true;
                }
            }
            return false;
        } else {
            throw new IllegalArgumentException("Array is empty");
        }
    }

    public static boolean toBoolean(int i2, int i3, int i4) {
        if (i2 == i3) {
            return true;
        }
        if (i2 == i4) {
            return false;
        }
        throw new IllegalArgumentException("The Integer did not match either specified value");
    }

    public static Boolean toBooleanObject(int i2, int i3, int i4, int i5) {
        if (i2 == i3) {
            return Boolean.TRUE;
        }
        if (i2 == i4) {
            return Boolean.FALSE;
        }
        if (i2 == i5) {
            return null;
        }
        throw new IllegalArgumentException("The Integer did not match any specified value");
    }

    public static int toInteger(boolean z) {
        return z ? 1 : 0;
    }

    public static Integer toIntegerObject(Boolean bool, Integer num, Integer num2, Integer num3) {
        if (bool == null) {
            return num3;
        }
        return bool.booleanValue() ? num : num2;
    }

    public static String toString(boolean z, String str, String str2) {
        return z ? str : str2;
    }

    public static String toStringOnOff(boolean z) {
        return toString(z, DebugKt.f29173d, DebugKt.f29174e);
    }

    public static String toStringTrueFalse(boolean z) {
        return toString(z, PdfBoolean.l3, "false");
    }

    public static String toStringYesNo(boolean z) {
        return toString(z, "yes", "no");
    }

    public static boolean xor(boolean... zArr) {
        if (zArr == null) {
            throw new IllegalArgumentException("The Array must not be null");
        } else if (zArr.length != 0) {
            boolean z = false;
            for (boolean z2 : zArr) {
                z ^= z2;
            }
            return z;
        } else {
            throw new IllegalArgumentException("Array is empty");
        }
    }

    public static boolean toBoolean(Boolean bool) {
        return bool != null && bool.booleanValue();
    }

    public static Boolean toBooleanObject(Integer num) {
        if (num == null) {
            return null;
        }
        return num.intValue() == 0 ? Boolean.FALSE : Boolean.TRUE;
    }

    public static int toInteger(boolean z, int i2, int i3) {
        return z ? i2 : i3;
    }

    public static Integer toIntegerObject(boolean z) {
        return z ? NumberUtils.INTEGER_ONE : NumberUtils.INTEGER_ZERO;
    }

    public static boolean toBoolean(Integer num, Integer num2, Integer num3) {
        if (num == null) {
            if (num2 == null) {
                return true;
            }
            if (num3 == null) {
                return false;
            }
        } else if (num.equals(num2)) {
            return true;
        } else {
            if (num.equals(num3)) {
                return false;
            }
        }
        throw new IllegalArgumentException("The Integer did not match either specified value");
    }

    public static Boolean toBooleanObject(Integer num, Integer num2, Integer num3, Integer num4) {
        if (num == null) {
            if (num2 == null) {
                return Boolean.TRUE;
            }
            if (num3 == null) {
                return Boolean.FALSE;
            }
            if (num4 == null) {
                return null;
            }
        } else if (num.equals(num2)) {
            return Boolean.TRUE;
        } else {
            if (num.equals(num3)) {
                return Boolean.FALSE;
            }
            if (num.equals(num4)) {
                return null;
            }
        }
        throw new IllegalArgumentException("The Integer did not match any specified value");
    }

    public static Integer toIntegerObject(boolean z, Integer num, Integer num2) {
        return z ? num : num2;
    }

    public static boolean toBoolean(String str) {
        return toBooleanObject(str) == Boolean.TRUE;
    }

    public static Boolean toBooleanObject(String str) {
        String str2 = str;
        if (str2 == PdfBoolean.l3) {
            return Boolean.TRUE;
        }
        if (str2 == null) {
            return null;
        }
        int length = str.length();
        if (length == 1) {
            char charAt = str2.charAt(0);
            if (charAt == 'y' || charAt == 'Y' || charAt == 't' || charAt == 'T') {
                return Boolean.TRUE;
            }
            if (charAt == 'n' || charAt == 'N' || charAt == 'f' || charAt == 'F') {
                return Boolean.FALSE;
            }
            return null;
        } else if (length == 2) {
            char charAt2 = str2.charAt(0);
            char charAt3 = str2.charAt(1);
            if ((charAt2 == 'o' || charAt2 == 'O') && (charAt3 == 'n' || charAt3 == 'N')) {
                return Boolean.TRUE;
            }
            if (charAt2 != 'n' && charAt2 != 'N') {
                return null;
            }
            if (charAt3 == 'o' || charAt3 == 'O') {
                return Boolean.FALSE;
            }
            return null;
        } else if (length == 3) {
            char charAt4 = str2.charAt(0);
            char charAt5 = str2.charAt(1);
            char charAt6 = str2.charAt(2);
            if ((charAt4 == 'y' || charAt4 == 'Y') && ((charAt5 == 'e' || charAt5 == 'E') && (charAt6 == 's' || charAt6 == 'S'))) {
                return Boolean.TRUE;
            }
            if (charAt4 != 'o' && charAt4 != 'O') {
                return null;
            }
            if (charAt5 != 'f' && charAt5 != 'F') {
                return null;
            }
            if (charAt6 == 'f' || charAt6 == 'F') {
                return Boolean.FALSE;
            }
            return null;
        } else if (length == 4) {
            char charAt7 = str2.charAt(0);
            char charAt8 = str2.charAt(1);
            char charAt9 = str2.charAt(2);
            char charAt10 = str2.charAt(3);
            if (charAt7 != 't' && charAt7 != 'T') {
                return null;
            }
            if (charAt8 != 'r' && charAt8 != 'R') {
                return null;
            }
            if (charAt9 != 'u' && charAt9 != 'U') {
                return null;
            }
            if (charAt10 == 'e' || charAt10 == 'E') {
                return Boolean.TRUE;
            }
            return null;
        } else if (length != 5) {
            return null;
        } else {
            char charAt11 = str2.charAt(0);
            char charAt12 = str2.charAt(1);
            char charAt13 = str2.charAt(2);
            char charAt14 = str2.charAt(3);
            char charAt15 = str2.charAt(4);
            if (charAt11 != 'f' && charAt11 != 'F') {
                return null;
            }
            if (charAt12 != 'a' && charAt12 != 'A') {
                return null;
            }
            if (charAt13 != 'l' && charAt13 != 'L') {
                return null;
            }
            if (charAt14 != 's' && charAt14 != 'S') {
                return null;
            }
            if (charAt15 == 'e' || charAt15 == 'E') {
                return Boolean.FALSE;
            }
            return null;
        }
    }

    public static boolean toBoolean(String str, String str2, String str3) {
        if (str == str2) {
            return true;
        }
        if (str == str3) {
            return false;
        }
        if (str != null) {
            if (str.equals(str2)) {
                return true;
            }
            if (str.equals(str3)) {
                return false;
            }
        }
        throw new IllegalArgumentException("The String did not match either specified value");
    }

    public static Boolean toBooleanObject(String str, String str2, String str3, String str4) {
        if (str == null) {
            if (str2 == null) {
                return Boolean.TRUE;
            }
            if (str3 == null) {
                return Boolean.FALSE;
            }
            if (str4 == null) {
                return null;
            }
        } else if (str.equals(str2)) {
            return Boolean.TRUE;
        } else {
            if (str.equals(str3)) {
                return Boolean.FALSE;
            }
            if (str.equals(str4)) {
                return null;
            }
        }
        throw new IllegalArgumentException("The String did not match any specified value");
    }
}
