package org.apache.commons.lang3;

import java.util.Random;
import kotlinx.coroutines.scheduling.WorkQueueKt;
import okio.Utf8;

public class RandomStringUtils {
    private static final Random RANDOM = new Random();

    public static String random(int i2) {
        return random(i2, false, false);
    }

    public static String randomAlphabetic(int i2) {
        return random(i2, true, false);
    }

    public static String randomAlphanumeric(int i2) {
        return random(i2, true, true);
    }

    public static String randomAscii(int i2) {
        return random(i2, 32, WorkQueueKt.f29430c, false, false);
    }

    public static String randomNumeric(int i2) {
        return random(i2, false, true);
    }

    public static String random(int i2, int i3, int i4, boolean z, boolean z2) {
        return random(i2, i3, i4, z, z2, (char[]) null, RANDOM);
    }

    public static String random(int i2, int i3, int i4, boolean z, boolean z2, char... cArr) {
        return random(i2, i3, i4, z, z2, cArr, RANDOM);
    }

    public static String random(int i2, int i3, int i4, boolean z, boolean z2, char[] cArr, Random random) {
        if (i2 == 0) {
            return "";
        }
        if (i2 < 0) {
            throw new IllegalArgumentException("Requested random string length " + i2 + " is less than 0.");
        } else if (cArr == null || cArr.length != 0) {
            if (i3 == 0 && i4 == 0) {
                if (cArr != null) {
                    i4 = cArr.length;
                } else if (z || z2) {
                    i4 = 123;
                    i3 = 32;
                } else {
                    i4 = Integer.MAX_VALUE;
                }
            } else if (i4 <= i3) {
                throw new IllegalArgumentException("Parameter end (" + i4 + ") must be greater than start (" + i3 + ")");
            }
            char[] cArr2 = new char[i2];
            int i5 = i4 - i3;
            while (true) {
                int i6 = i2 - 1;
                if (i2 == 0) {
                    return new String(cArr2);
                }
                int nextInt = random.nextInt(i5) + i3;
                char c2 = cArr == null ? (char) nextInt : cArr[nextInt];
                if ((z && Character.isLetter(c2)) || ((z2 && Character.isDigit(c2)) || (!z && !z2))) {
                    if (c2 < 56320 || c2 > 57343) {
                        if (c2 < 55296 || c2 > 56191) {
                            if (c2 < 56192 || c2 > 56319) {
                                cArr2[i6] = c2;
                                i2 = i6;
                            }
                        } else if (i6 != 0) {
                            cArr2[i6] = (char) (random.nextInt(128) + Utf8.f31408e);
                            i2 -= 2;
                            cArr2[i2] = c2;
                        }
                    } else if (i6 != 0) {
                        cArr2[i6] = c2;
                        i2 -= 2;
                        cArr2[i2] = (char) (random.nextInt(128) + 55296);
                    }
                }
            }
        } else {
            throw new IllegalArgumentException("The chars array must not be empty");
        }
    }

    public static String random(int i2, String str) {
        if (str != null) {
            return random(i2, str.toCharArray());
        }
        return random(i2, 0, 0, false, false, (char[]) null, RANDOM);
    }

    public static String random(int i2, boolean z, boolean z2) {
        return random(i2, 0, 0, z, z2);
    }

    public static String random(int i2, char... cArr) {
        int length;
        boolean z;
        Random random;
        int i3;
        boolean z2;
        int i4;
        char[] cArr2;
        if (cArr == null) {
            cArr2 = null;
            random = RANDOM;
            i3 = 0;
            length = 0;
            z2 = false;
            z = false;
            i4 = i2;
        } else {
            length = cArr.length;
            z = false;
            random = RANDOM;
            i3 = 0;
            z2 = false;
            i4 = i2;
            cArr2 = cArr;
        }
        return random(i4, i3, length, z2, z, cArr2, random);
    }
}
