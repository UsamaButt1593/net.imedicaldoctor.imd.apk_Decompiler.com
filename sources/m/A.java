package m;

import java.io.File;
import java.io.FilenameFilter;

public final /* synthetic */ class A implements FilenameFilter {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f29472a;

    public /* synthetic */ A(String str) {
        this.f29472a = str;
    }

    public final boolean accept(File file, String str) {
        return str.startsWith(this.f29472a + ".");
    }
}
