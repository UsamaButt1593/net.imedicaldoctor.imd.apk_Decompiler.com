package kotlin.math;

import kotlin.Metadata;
import kotlin.jvm.JvmField;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u000e\bÂ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0014\u0010\u0007\u001a\u00020\u00048\u0000X\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0006R\u0014\u0010\t\u001a\u00020\u00048\u0000X\u0004¢\u0006\u0006\n\u0004\b\b\u0010\u0006R\u0014\u0010\u000b\u001a\u00020\u00048\u0000X\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u0006R\u0014\u0010\r\u001a\u00020\u00048\u0000X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\u0006R\u0014\u0010\u000f\u001a\u00020\u00048\u0000X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u0006R\u0014\u0010\u0011\u001a\u00020\u00048\u0000X\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0006¨\u0006\u0012"}, d2 = {"Lkotlin/math/Constants;", "", "<init>", "()V", "", "b", "D", "LN2", "c", "epsilon", "d", "taylor_2_bound", "e", "taylor_n_bound", "f", "upper_taylor_2_bound", "g", "upper_taylor_n_bound", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0})
final class Constants {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    public static final Constants f28974a = new Constants();
    @JvmField

    /* renamed from: b  reason: collision with root package name */
    public static final double f28975b = Math.log(2.0d);
    @JvmField

    /* renamed from: c  reason: collision with root package name */
    public static final double f28976c;
    @JvmField

    /* renamed from: d  reason: collision with root package name */
    public static final double f28977d;
    @JvmField

    /* renamed from: e  reason: collision with root package name */
    public static final double f28978e;
    @JvmField

    /* renamed from: f  reason: collision with root package name */
    public static final double f28979f;
    @JvmField

    /* renamed from: g  reason: collision with root package name */
    public static final double f28980g;

    static {
        double ulp = Math.ulp(1.0d);
        f28976c = ulp;
        double sqrt = Math.sqrt(ulp);
        f28977d = sqrt;
        double sqrt2 = Math.sqrt(sqrt);
        f28978e = sqrt2;
        double d2 = (double) 1;
        f28979f = d2 / sqrt;
        f28980g = d2 / sqrt2;
    }

    private Constants() {
    }
}
