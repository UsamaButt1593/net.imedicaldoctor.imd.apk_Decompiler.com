package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlinx.coroutines.internal.Symbol;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000 \n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a\u0017\u0010\u0001\u001a\u0004\u0018\u00010\u0000*\u0004\u0018\u00010\u0000H\u0000¢\u0006\u0004\b\u0001\u0010\u0002\u001a\u0017\u0010\u0003\u001a\u0004\u0018\u00010\u0000*\u0004\u0018\u00010\u0000H\u0000¢\u0006\u0004\b\u0003\u0010\u0002\"\u001a\u0010\t\u001a\u00020\u00048\u0002X\u0004¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u0012\u0004\b\u0007\u0010\b\"\u001a\u0010\f\u001a\u00020\u00048\u0000X\u0004¢\u0006\f\n\u0004\b\n\u0010\u0006\u0012\u0004\b\u000b\u0010\b\"\u001a\u0010\u000f\u001a\u00020\u00048\u0002X\u0004¢\u0006\f\n\u0004\b\r\u0010\u0006\u0012\u0004\b\u000e\u0010\b\"\u001a\u0010\u0012\u001a\u00020\u00048\u0002X\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u0006\u0012\u0004\b\u0011\u0010\b\"\u0014\u0010\u0016\u001a\u00020\u00138\u0002XT¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015\"\u0014\u0010\u0018\u001a\u00020\u00138\u0002XT¢\u0006\u0006\n\u0004\b\u0017\u0010\u0015\"\u0014\u0010\u0019\u001a\u00020\u00138\u0002XT¢\u0006\u0006\n\u0004\b\u0001\u0010\u0015\"\u001a\u0010\u001b\u001a\u00020\u00048\u0002X\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0006\u0012\u0004\b\u001a\u0010\b\"\u001a\u0010\u001f\u001a\u00020\u001c8\u0002X\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u001d\u0012\u0004\b\u001e\u0010\b\"\u001a\u0010!\u001a\u00020\u001c8\u0002X\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u001d\u0012\u0004\b \u0010\b¨\u0006\""}, d2 = {"", "g", "(Ljava/lang/Object;)Ljava/lang/Object;", "o", "Lkotlinx/coroutines/internal/Symbol;", "a", "Lkotlinx/coroutines/internal/Symbol;", "h", "()V", "COMPLETING_ALREADY", "b", "j", "COMPLETING_WAITING_CHILDREN", "c", "i", "COMPLETING_RETRY", "d", "n", "TOO_LATE_TO_CANCEL", "", "e", "I", "RETRY", "f", "FALSE", "TRUE", "m", "SEALED", "Lkotlinx/coroutines/Empty;", "Lkotlinx/coroutines/Empty;", "l", "EMPTY_NEW", "k", "EMPTY_ACTIVE", "kotlinx-coroutines-core"}, k = 2, mv = {1, 6, 0})
public final class JobSupportKt {
    /* access modifiers changed from: private */
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    public static final Symbol f29207a = new Symbol("COMPLETING_ALREADY");
    @NotNull
    @JvmField

    /* renamed from: b  reason: collision with root package name */
    public static final Symbol f29208b = new Symbol("COMPLETING_WAITING_CHILDREN");
    /* access modifiers changed from: private */
    @NotNull

    /* renamed from: c  reason: collision with root package name */
    public static final Symbol f29209c = new Symbol("COMPLETING_RETRY");
    /* access modifiers changed from: private */
    @NotNull

    /* renamed from: d  reason: collision with root package name */
    public static final Symbol f29210d = new Symbol("TOO_LATE_TO_CANCEL");

    /* renamed from: e  reason: collision with root package name */
    private static final int f29211e = -1;

    /* renamed from: f  reason: collision with root package name */
    private static final int f29212f = 0;

    /* renamed from: g  reason: collision with root package name */
    private static final int f29213g = 1;
    /* access modifiers changed from: private */
    @NotNull

    /* renamed from: h  reason: collision with root package name */
    public static final Symbol f29214h = new Symbol("SEALED");
    /* access modifiers changed from: private */
    @NotNull

    /* renamed from: i  reason: collision with root package name */
    public static final Empty f29215i = new Empty(false);
    /* access modifiers changed from: private */
    @NotNull

    /* renamed from: j  reason: collision with root package name */
    public static final Empty f29216j = new Empty(true);

    @Nullable
    public static final Object g(@Nullable Object obj) {
        return obj instanceof Incomplete ? new IncompleteStateBox((Incomplete) obj) : obj;
    }

    private static /* synthetic */ void h() {
    }

    private static /* synthetic */ void i() {
    }

    public static /* synthetic */ void j() {
    }

    private static /* synthetic */ void k() {
    }

    private static /* synthetic */ void l() {
    }

    private static /* synthetic */ void m() {
    }

    private static /* synthetic */ void n() {
    }

    @Nullable
    public static final Object o(@Nullable Object obj) {
        Incomplete incomplete;
        IncompleteStateBox incompleteStateBox = obj instanceof IncompleteStateBox ? (IncompleteStateBox) obj : null;
        return (incompleteStateBox == null || (incomplete = incompleteStateBox.f29200a) == null) ? obj : incomplete;
    }
}
