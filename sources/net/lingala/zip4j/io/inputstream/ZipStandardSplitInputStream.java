package net.lingala.zip4j.io.inputstream;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ZipStandardSplitInputStream extends SplitInputStream {
    private int Y2;

    public ZipStandardSplitInputStream(File file, boolean z, int i2) throws FileNotFoundException {
        super(file, z, i2);
        this.Y2 = i2;
    }

    /* access modifiers changed from: protected */
    public File b(int i2) throws IOException {
        if (i2 == this.Y2) {
            return this.X;
        }
        String canonicalPath = this.X.getCanonicalPath();
        String str = i2 >= 9 ? ".z" : ".z0";
        return new File(canonicalPath.substring(0, canonicalPath.lastIndexOf(".")) + str + (i2 + 1));
    }
}
