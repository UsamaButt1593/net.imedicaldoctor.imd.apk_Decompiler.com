package kotlin.collections;

import java.util.AbstractList;
import java.util.List;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.jvm.internal.markers.KMutableList;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0003\b'\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u00022\b\u0012\u0004\u0012\u00028\u00000\u0003B\t\b\u0004¢\u0006\u0004\b\u0004\u0010\u0005J \u0010\t\u001a\u00028\u00002\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00028\u0000H¦\u0002¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\u000b\u001a\u00028\u00002\u0006\u0010\u0007\u001a\u00020\u0006H&¢\u0006\u0004\b\u000b\u0010\fJ\u001f\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00028\u0000H&¢\u0006\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lkotlin/collections/AbstractMutableList;", "E", "", "Ljava/util/AbstractList;", "<init>", "()V", "", "index", "element", "set", "(ILjava/lang/Object;)Ljava/lang/Object;", "c", "(I)Ljava/lang/Object;", "", "add", "(ILjava/lang/Object;)V", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0})
@SinceKotlin(version = "1.1")
public abstract class AbstractMutableList<E> extends AbstractList<E> implements List<E>, KMutableList {
    protected AbstractMutableList() {
    }

    public abstract void add(int i2, E e2);

    public abstract int b();

    public abstract E c(int i2);

    public final /* bridge */ E remove(int i2) {
        return c(i2);
    }

    public abstract E set(int i2, E e2);

    public final /* bridge */ int size() {
        return b();
    }
}
