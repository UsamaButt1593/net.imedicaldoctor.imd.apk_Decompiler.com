package kotlin.jvm.internal;

import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.reflect.KDeclarationContainer;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0017\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0011\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lkotlin/jvm/internal/LocalVariableReference;", "Lkotlin/jvm/internal/PropertyReference0;", "<init>", "()V", "Lkotlin/reflect/KDeclarationContainer;", "z0", "()Lkotlin/reflect/KDeclarationContainer;", "", "get", "()Ljava/lang/Object;", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0})
@SinceKotlin(version = "1.1")
public class LocalVariableReference extends PropertyReference0 {
    @Nullable
    public Object get() {
        Void unused = LocalVariableReferencesKt.b();
        throw new KotlinNothingValueException();
    }

    @NotNull
    public KDeclarationContainer z0() {
        Void unused = LocalVariableReferencesKt.b();
        throw new KotlinNothingValueException();
    }
}
