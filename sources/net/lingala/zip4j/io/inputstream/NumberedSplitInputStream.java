package net.lingala.zip4j.io.inputstream;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import net.lingala.zip4j.util.FileUtils;

public class NumberedSplitInputStream extends SplitInputStream {
    public NumberedSplitInputStream(File file, boolean z, int i2) throws FileNotFoundException {
        super(file, z, i2);
    }

    /* access modifiers changed from: protected */
    public File b(int i2) throws IOException {
        String canonicalPath = this.X.getCanonicalPath();
        String substring = canonicalPath.substring(0, canonicalPath.lastIndexOf("."));
        return new File(substring + FileUtils.r(i2));
    }
}
