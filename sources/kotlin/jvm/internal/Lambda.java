package kotlin.jvm.internal;

import java.io.Serializable;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\b&\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00012\b\u0012\u0004\u0012\u00028\u00000\u00022\u00020\u0003B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\t\u0010\nR\u001a\u0010\u0005\u001a\u00020\u00048\u0016X\u0004¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lkotlin/jvm/internal/Lambda;", "R", "Lkotlin/jvm/internal/FunctionBase;", "Ljava/io/Serializable;", "", "arity", "<init>", "(I)V", "", "toString", "()Ljava/lang/String;", "s", "I", "e", "()I", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0})
public abstract class Lambda<R> implements FunctionBase<R>, Serializable {
    private final int s;

    public Lambda(int i2) {
        this.s = i2;
    }

    public int e() {
        return this.s;
    }

    @NotNull
    public String toString() {
        String x = Reflection.x(this);
        Intrinsics.o(x, "renderLambdaToString(this)");
        return x;
    }
}
