package androidx.media3.datasource;

import androidx.annotation.Nullable;
import androidx.media3.common.util.UnstableApi;
import java.io.IOException;
import java.util.Arrays;

@UnstableApi
public final class DataSourceUtil {
    private DataSourceUtil() {
    }

    public static void a(@Nullable DataSource dataSource) {
        if (dataSource != null) {
            try {
                dataSource.close();
            } catch (IOException unused) {
            }
        }
    }

    public static byte[] b(DataSource dataSource, int i2) throws IOException {
        byte[] bArr = new byte[i2];
        int i3 = 0;
        while (i3 < i2) {
            int read = dataSource.read(bArr, i3, i2 - i3);
            if (read != -1) {
                i3 += read;
            } else {
                throw new IllegalStateException("Not enough data could be read: " + i3 + " < " + i2);
            }
        }
        return bArr;
    }

    public static byte[] c(DataSource dataSource) throws IOException {
        byte[] bArr = new byte[1024];
        int i2 = 0;
        int i3 = 0;
        while (i2 != -1) {
            if (i3 == bArr.length) {
                bArr = Arrays.copyOf(bArr, bArr.length * 2);
            }
            i2 = dataSource.read(bArr, i3, bArr.length - i3);
            if (i2 != -1) {
                i3 += i2;
            }
        }
        return Arrays.copyOf(bArr, i3);
    }
}
