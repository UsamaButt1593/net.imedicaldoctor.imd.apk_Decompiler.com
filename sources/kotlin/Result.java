package kotlin;

import com.dd.plist.ASCIIPropertyListParser;
import java.io.Serializable;
import kotlin.internal.InlineOnly;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmInline;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@JvmInline
@SinceKotlin(version = "1.3")
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000f\b@\u0018\u0000 \u001f*\u0006\b\u0000\u0010\u0001 \u00012\u00060\u0002j\u0002`\u0003:\u0002 !B\u0016\b\u0001\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004ø\u0001\u0000¢\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\b\u001a\u0004\u0018\u00018\u0000H\b¢\u0006\u0004\b\b\u0010\u0007J\u000f\u0010\n\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0010\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0014\u001a\u00020\u00132\b\u0010\u0012\u001a\u0004\u0018\u00010\u0004HÖ\u0003¢\u0006\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0000X\u0004¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u0012\u0004\b\u0018\u0010\u0019R\u0011\u0010\u001c\u001a\u00020\u00138F¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001bR\u0011\u0010\u001e\u001a\u00020\u00138F¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001b\u0001\u0005\u0001\u0004\u0018\u00010\u0004ø\u0001\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\""}, d2 = {"Lkotlin/Result;", "T", "Ljava/io/Serializable;", "Lkotlin/io/Serializable;", "", "value", "b", "(Ljava/lang/Object;)Ljava/lang/Object;", "f", "", "e", "(Ljava/lang/Object;)Ljava/lang/Throwable;", "", "k", "(Ljava/lang/Object;)Ljava/lang/String;", "", "h", "(Ljava/lang/Object;)I", "other", "", "c", "(Ljava/lang/Object;Ljava/lang/Object;)Z", "s", "Ljava/lang/Object;", "g", "()V", "j", "(Ljava/lang/Object;)Z", "isSuccess", "i", "isFailure", "X", "Companion", "Failure", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0})
public final class Result<T> implements Serializable {
    @NotNull
    public static final Companion X = new Companion((DefaultConstructorMarker) null);
    @Nullable
    private final Object s;

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J'\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00010\u0006\"\u0004\b\u0001\u0010\u00042\u0006\u0010\u0005\u001a\u00028\u0001H\bø\u0001\u0000¢\u0006\u0004\b\u0007\u0010\bJ'\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00010\u0006\"\u0004\b\u0001\u0010\u00042\u0006\u0010\n\u001a\u00020\tH\bø\u0001\u0000¢\u0006\u0004\b\u000b\u0010\f\u0002\u0004\n\u0002\b\u0019¨\u0006\r"}, d2 = {"Lkotlin/Result$Companion;", "", "<init>", "()V", "T", "value", "Lkotlin/Result;", "b", "(Ljava/lang/Object;)Ljava/lang/Object;", "", "exception", "a", "(Ljava/lang/Throwable;)Ljava/lang/Object;", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0})
    public static final class Companion {
        private Companion() {
        }

        @InlineOnly
        @JvmName(name = "failure")
        private final <T> Object a(Throwable th) {
            Intrinsics.p(th, "exception");
            return Result.b(ResultKt.a(th));
        }

        @InlineOnly
        @JvmName(name = "success")
        private final <T> Object b(T t) {
            return Result.b(t);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0000\u0018\u00002\u00060\u0001j\u0002`\u0002B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u001a\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0004\u001a\u00020\u00038\u0006X\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2 = {"Lkotlin/Result$Failure;", "Ljava/io/Serializable;", "Lkotlin/io/Serializable;", "", "exception", "<init>", "(Ljava/lang/Throwable;)V", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "s", "Ljava/lang/Throwable;", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0})
    public static final class Failure implements Serializable {
        @NotNull
        @JvmField
        public final Throwable s;

        public Failure(@NotNull Throwable th) {
            Intrinsics.p(th, "exception");
            this.s = th;
        }

        public boolean equals(@Nullable Object obj) {
            return (obj instanceof Failure) && Intrinsics.g(this.s, ((Failure) obj).s);
        }

        public int hashCode() {
            return this.s.hashCode();
        }

        @NotNull
        public String toString() {
            return "Failure(" + this.s + ASCIIPropertyListParser.f18650h;
        }
    }

    @PublishedApi
    private /* synthetic */ Result(Object obj) {
        this.s = obj;
    }

    public static final /* synthetic */ Result a(Object obj) {
        return new Result(obj);
    }

    @NotNull
    @PublishedApi
    public static <T> Object b(@Nullable Object obj) {
        return obj;
    }

    public static boolean c(Object obj, Object obj2) {
        return (obj2 instanceof Result) && Intrinsics.g(obj, ((Result) obj2).l());
    }

    public static final boolean d(Object obj, Object obj2) {
        return Intrinsics.g(obj, obj2);
    }

    @Nullable
    public static final Throwable e(Object obj) {
        if (obj instanceof Failure) {
            return ((Failure) obj).s;
        }
        return null;
    }

    @InlineOnly
    private static final T f(Object obj) {
        if (i(obj)) {
            return null;
        }
        return obj;
    }

    @PublishedApi
    public static /* synthetic */ void g() {
    }

    public static int h(Object obj) {
        if (obj == null) {
            return 0;
        }
        return obj.hashCode();
    }

    public static final boolean i(Object obj) {
        return obj instanceof Failure;
    }

    public static final boolean j(Object obj) {
        return !(obj instanceof Failure);
    }

    @NotNull
    public static String k(Object obj) {
        if (obj instanceof Failure) {
            return ((Failure) obj).toString();
        }
        return "Success(" + obj + ASCIIPropertyListParser.f18650h;
    }

    public boolean equals(Object obj) {
        return c(this.s, obj);
    }

    public int hashCode() {
        return h(this.s);
    }

    public final /* synthetic */ Object l() {
        return this.s;
    }

    @NotNull
    public String toString() {
        return k(this.s);
    }
}
