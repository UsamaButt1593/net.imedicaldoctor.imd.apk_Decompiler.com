package l;

import java.util.function.Predicate;
import net.lingala.zip4j.model.FileHeader;

public final /* synthetic */ class b implements Predicate {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ FileHeader f29471a;

    public /* synthetic */ b(FileHeader fileHeader) {
        this.f29471a = fileHeader;
    }

    public final boolean test(Object obj) {
        return ((FileHeader) obj).k().startsWith(this.f29471a.k());
    }
}
