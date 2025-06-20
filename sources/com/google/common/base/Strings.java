package com.google.common.base;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.VisibleForTesting;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.CheckForNull;

@GwtCompatible
@ElementTypesAreNonnullByDefault
public final class Strings {
    private Strings() {
    }

    public static String a(CharSequence charSequence, CharSequence charSequence2) {
        Preconditions.E(charSequence);
        Preconditions.E(charSequence2);
        int min = Math.min(charSequence.length(), charSequence2.length());
        int i2 = 0;
        while (i2 < min && charSequence.charAt(i2) == charSequence2.charAt(i2)) {
            i2++;
        }
        int i3 = i2 - 1;
        if (k(charSequence, i3) || k(charSequence2, i3)) {
            i2--;
        }
        return charSequence.subSequence(0, i2).toString();
    }

    public static String b(CharSequence charSequence, CharSequence charSequence2) {
        Preconditions.E(charSequence);
        Preconditions.E(charSequence2);
        int min = Math.min(charSequence.length(), charSequence2.length());
        int i2 = 0;
        while (i2 < min && charSequence.charAt((charSequence.length() - i2) - 1) == charSequence2.charAt((charSequence2.length() - i2) - 1)) {
            i2++;
        }
        if (k(charSequence, (charSequence.length() - i2) - 1) || k(charSequence2, (charSequence2.length() - i2) - 1)) {
            i2--;
        }
        return charSequence.subSequence(charSequence.length() - i2, charSequence.length()).toString();
    }

    @CheckForNull
    public static String c(@CheckForNull String str) {
        return Platform.b(str);
    }

    public static boolean d(@CheckForNull String str) {
        return Platform.j(str);
    }

    public static String e(@CheckForNull String str, @CheckForNull Object... objArr) {
        int indexOf;
        String valueOf = String.valueOf(str);
        int i2 = 0;
        if (objArr == null) {
            objArr = new Object[]{"(Object[])null"};
        } else {
            for (int i3 = 0; i3 < objArr.length; i3++) {
                objArr[i3] = f(objArr[i3]);
            }
        }
        StringBuilder sb = new StringBuilder(valueOf.length() + (objArr.length * 16));
        int i4 = 0;
        while (i2 < objArr.length && (indexOf = valueOf.indexOf("%s", i4)) != -1) {
            sb.append(valueOf, i4, indexOf);
            sb.append(objArr[i2]);
            int i5 = i2 + 1;
            i4 = indexOf + 2;
            i2 = i5;
        }
        sb.append(valueOf, i4, valueOf.length());
        if (i2 < objArr.length) {
            sb.append(" [");
            sb.append(objArr[i2]);
            for (int i6 = i2 + 1; i6 < objArr.length; i6++) {
                sb.append(", ");
                sb.append(objArr[i6]);
            }
            sb.append(']');
        }
        return sb.toString();
    }

    private static String f(@CheckForNull Object obj) {
        if (obj == null) {
            return "null";
        }
        try {
            return obj.toString();
        } catch (Exception e2) {
            String str = obj.getClass().getName() + '@' + Integer.toHexString(System.identityHashCode(obj));
            Logger.getLogger("com.google.common.base.Strings").log(Level.WARNING, "Exception during lenientFormat for " + str, e2);
            return "<" + str + " threw " + e2.getClass().getName() + ">";
        }
    }

    public static String g(@CheckForNull String str) {
        return Platform.g(str);
    }

    public static String h(String str, int i2, char c2) {
        Preconditions.E(str);
        if (str.length() >= i2) {
            return str;
        }
        StringBuilder sb = new StringBuilder(i2);
        sb.append(str);
        for (int length = str.length(); length < i2; length++) {
            sb.append(c2);
        }
        return sb.toString();
    }

    public static String i(String str, int i2, char c2) {
        Preconditions.E(str);
        if (str.length() >= i2) {
            return str;
        }
        StringBuilder sb = new StringBuilder(i2);
        for (int length = str.length(); length < i2; length++) {
            sb.append(c2);
        }
        sb.append(str);
        return sb.toString();
    }

    public static String j(String str, int i2) {
        Preconditions.E(str);
        boolean z = false;
        if (i2 <= 1) {
            if (i2 >= 0) {
                z = true;
            }
            Preconditions.k(z, "invalid count: %s", i2);
            return i2 == 0 ? "" : str;
        }
        int length = str.length();
        long j2 = ((long) length) * ((long) i2);
        int i3 = (int) j2;
        if (((long) i3) == j2) {
            char[] cArr = new char[i3];
            str.getChars(0, length, cArr, 0);
            while (true) {
                int i4 = i3 - length;
                if (length < i4) {
                    System.arraycopy(cArr, 0, cArr, length, length);
                    length <<= 1;
                } else {
                    System.arraycopy(cArr, 0, cArr, length, i4);
                    return new String(cArr);
                }
            }
        } else {
            throw new ArrayIndexOutOfBoundsException("Required array size too large: " + j2);
        }
    }

    @VisibleForTesting
    static boolean k(CharSequence charSequence, int i2) {
        return i2 >= 0 && i2 <= charSequence.length() + -2 && Character.isHighSurrogate(charSequence.charAt(i2)) && Character.isLowSurrogate(charSequence.charAt(i2 + 1));
    }
}
