package kotlinx.coroutines;

import com.dd.plist.ASCIIPropertyListParser;
import com.google.firebase.sessions.j;
import kotlin.Metadata;
import kotlin.coroutines.AbstractCoroutineContextElement;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.codehaus.mojo.animal_sniffer.IgnoreJRERequirement;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\b\b\u0018\u0000 !2\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0001\"B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\b\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\f\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\f\u0010\rJ\u001f\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0012\u001a\u00020\u0004HÆ\u0003¢\u0006\u0004\b\u0012\u0010\u0013J\u001a\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u0004HÆ\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0017\u001a\u00020\u0016HÖ\u0001¢\u0006\u0004\b\u0017\u0010\u0018J\u001a\u0010\u001c\u001a\u00020\u001b2\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019HÖ\u0003¢\u0006\u0004\b\u001c\u0010\u001dR\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010\u0013¨\u0006#"}, d2 = {"Lkotlinx/coroutines/CoroutineId;", "Lkotlinx/coroutines/ThreadContextElement;", "", "Lkotlin/coroutines/AbstractCoroutineContextElement;", "", "id", "<init>", "(J)V", "toString", "()Ljava/lang/String;", "Lkotlin/coroutines/CoroutineContext;", "context", "i0", "(Lkotlin/coroutines/CoroutineContext;)Ljava/lang/String;", "oldState", "", "g0", "(Lkotlin/coroutines/CoroutineContext;Ljava/lang/String;)V", "R", "()J", "S", "(J)Lkotlinx/coroutines/CoroutineId;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "X", "J", "W", "Y", "Key", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
@IgnoreJRERequirement
public final class CoroutineId extends AbstractCoroutineContextElement implements ThreadContextElement<String> {
    @NotNull
    public static final Key Y = new Key((DefaultConstructorMarker) null);
    private final long X;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lkotlinx/coroutines/CoroutineId$Key;", "Lkotlin/coroutines/CoroutineContext$Key;", "Lkotlinx/coroutines/CoroutineId;", "()V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Key implements CoroutineContext.Key<CoroutineId> {
        private Key() {
        }

        public /* synthetic */ Key(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public CoroutineId(long j2) {
        super(Y);
        this.X = j2;
    }

    public static /* synthetic */ CoroutineId T(CoroutineId coroutineId, long j2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            j2 = coroutineId.X;
        }
        return coroutineId.S(j2);
    }

    public final long R() {
        return this.X;
    }

    @NotNull
    public final CoroutineId S(long j2) {
        return new CoroutineId(j2);
    }

    public final long W() {
        return this.X;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof CoroutineId) && this.X == ((CoroutineId) obj).X;
    }

    /* renamed from: g0 */
    public void c0(@NotNull CoroutineContext coroutineContext, @NotNull String str) {
        Thread.currentThread().setName(str);
    }

    public int hashCode() {
        return j.a(this.X);
    }

    @NotNull
    /* renamed from: i0 */
    public String k0(@NotNull CoroutineContext coroutineContext) {
        String str;
        CoroutineName coroutineName = (CoroutineName) coroutineContext.e(CoroutineName.Y);
        if (coroutineName == null || (str = coroutineName.W()) == null) {
            str = "coroutine";
        }
        Thread currentThread = Thread.currentThread();
        String name = currentThread.getName();
        int D3 = StringsKt.D3(name, " @", 0, false, 6, (Object) null);
        if (D3 < 0) {
            D3 = name.length();
        }
        StringBuilder sb = new StringBuilder(str.length() + D3 + 10);
        String substring = name.substring(0, D3);
        Intrinsics.o(substring, "this as java.lang.String…ing(startIndex, endIndex)");
        sb.append(substring);
        sb.append(" @");
        sb.append(str);
        sb.append('#');
        sb.append(this.X);
        String sb2 = sb.toString();
        Intrinsics.o(sb2, "StringBuilder(capacity).…builderAction).toString()");
        currentThread.setName(sb2);
        return name;
    }

    @NotNull
    public String toString() {
        return "CoroutineId(" + this.X + ASCIIPropertyListParser.f18650h;
    }
}
