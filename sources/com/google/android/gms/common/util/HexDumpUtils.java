package com.google.android.gms.common.util;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.errorprone.annotations.ResultIgnorabilityUnspecified;
import org.apache.commons.lang3.ClassUtils;

@KeepForSdk
public final class HexDumpUtils {
    @ResultIgnorabilityUnspecified
    @KeepForSdk
    @Nullable
    public static String a(@NonNull byte[] bArr, int i2, int i3, boolean z) {
        int length;
        if (bArr == null || (length = bArr.length) == 0 || i2 < 0 || i3 <= 0 || i2 + i3 > length) {
            return null;
        }
        StringBuilder sb = new StringBuilder((z ? 75 : 57) * ((i3 + 15) / 16));
        int i4 = i3;
        int i5 = 0;
        int i6 = 0;
        while (i4 > 0) {
            if (i5 == 0) {
                sb.append(i3 < 65536 ? String.format("%04X:", new Object[]{Integer.valueOf(i2)}) : String.format("%08X:", new Object[]{Integer.valueOf(i2)}));
                i6 = i2;
            } else if (i5 == 8) {
                sb.append(" -");
            }
            sb.append(String.format(" %02X", new Object[]{Integer.valueOf(bArr[i2] & 255)}));
            i4--;
            i5++;
            if (z && (i5 == 16 || i4 == 0)) {
                int i7 = 16 - i5;
                if (i7 > 0) {
                    for (int i8 = 0; i8 < i7; i8++) {
                        sb.append("   ");
                    }
                }
                if (i7 >= 8) {
                    sb.append("  ");
                }
                sb.append("  ");
                for (int i9 = 0; i9 < i5; i9++) {
                    char c2 = (char) bArr[i6 + i9];
                    if (c2 < ' ' || c2 > '~') {
                        c2 = ClassUtils.PACKAGE_SEPARATOR_CHAR;
                    }
                    sb.append(c2);
                }
            }
            if (i5 == 16 || i4 == 0) {
                sb.append(10);
                i5 = 0;
            }
            i2++;
        }
        return sb.toString();
    }
}
