package kotlinx.coroutines.internal;

import kotlin.Metadata;
import kotlin.jvm.JvmField;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0006\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J \u0010\n\u001a\u00028\u0000\"\u0004\b\u0000\u0010\b2\b\u0010\t\u001a\u0004\u0018\u00010\u0001H\b¢\u0006\u0004\b\n\u0010\u000bR\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0004¢\u0006\u0006\n\u0004\b\n\u0010\f¨\u0006\r"}, d2 = {"Lkotlinx/coroutines/internal/Symbol;", "", "", "symbol", "<init>", "(Ljava/lang/String;)V", "toString", "()Ljava/lang/String;", "T", "value", "a", "(Ljava/lang/Object;)Ljava/lang/Object;", "Ljava/lang/String;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
public final class Symbol {
    @NotNull
    @JvmField

    /* renamed from: a  reason: collision with root package name */
    public final String f29397a;

    public Symbol(@NotNull String str) {
        this.f29397a = str;
    }

    public final <T> T a(@Nullable Object obj) {
        if (obj == this) {
            return null;
        }
        return obj;
    }

    @NotNull
    public String toString() {
        return '<' + this.f29397a + '>';
    }
}
