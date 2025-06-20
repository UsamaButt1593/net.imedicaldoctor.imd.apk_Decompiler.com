package kotlin.properties;

import com.dd.plist.ASCIIPropertyListParser;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KProperty;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0002\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0012\u0004\u0012\u00028\u00000\u0003B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J&\u0010\t\u001a\u00028\u00002\b\u0010\u0006\u001a\u0004\u0018\u00010\u00012\n\u0010\b\u001a\u0006\u0012\u0002\b\u00030\u0007H\u0002¢\u0006\u0004\b\t\u0010\nJ.\u0010\r\u001a\u00020\f2\b\u0010\u0006\u001a\u0004\u0018\u00010\u00012\n\u0010\b\u001a\u0006\u0012\u0002\b\u00030\u00072\u0006\u0010\u000b\u001a\u00028\u0000H\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0010\u0010\u0011R\u0018\u0010\u000b\u001a\u0004\u0018\u00018\u00008\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\t\u0010\u0012¨\u0006\u0013"}, d2 = {"Lkotlin/properties/NotNullVar;", "", "T", "Lkotlin/properties/ReadWriteProperty;", "<init>", "()V", "thisRef", "Lkotlin/reflect/KProperty;", "property", "a", "(Ljava/lang/Object;Lkotlin/reflect/KProperty;)Ljava/lang/Object;", "value", "", "b", "(Ljava/lang/Object;Lkotlin/reflect/KProperty;Ljava/lang/Object;)V", "", "toString", "()Ljava/lang/String;", "Ljava/lang/Object;", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0})
final class NotNullVar<T> implements ReadWriteProperty<Object, T> {
    @Nullable

    /* renamed from: a  reason: collision with root package name */
    private T f28986a;

    @NotNull
    public T a(@Nullable Object obj, @NotNull KProperty<?> kProperty) {
        Intrinsics.p(kProperty, "property");
        T t = this.f28986a;
        if (t != null) {
            return t;
        }
        throw new IllegalStateException("Property " + kProperty.getName() + " should be initialized before get.");
    }

    public void b(@Nullable Object obj, @NotNull KProperty<?> kProperty, @NotNull T t) {
        Intrinsics.p(kProperty, "property");
        Intrinsics.p(t, "value");
        this.f28986a = t;
    }

    @NotNull
    public String toString() {
        String str;
        StringBuilder sb = new StringBuilder();
        sb.append("NotNullProperty(");
        if (this.f28986a != null) {
            str = "value=" + this.f28986a;
        } else {
            str = "value not initialized yet";
        }
        sb.append(str);
        sb.append(ASCIIPropertyListParser.f18650h);
        return sb.toString();
    }
}
