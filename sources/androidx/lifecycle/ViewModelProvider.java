package androidx.lifecycle;

import android.app.Application;
import androidx.annotation.MainThread;
import androidx.annotation.RestrictTo;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.lifecycle.viewmodel.InitializerViewModelFactory;
import androidx.lifecycle.viewmodel.MutableCreationExtras;
import androidx.lifecycle.viewmodel.ViewModelInitializer;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@SourceDebugExtension({"SMAP\nViewModelProvider.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ViewModelProvider.kt\nandroidx/lifecycle/ViewModelProvider\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,375:1\n1#2:376\n*E\n"})
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\f\b\u0016\u0018\u00002\u00020\u0001:\u0004\u001c\u001d\u001e\u001fB#\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tB\u0011\b\u0016\u0012\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\b\u0010\fB\u0019\b\u0016\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\b\u0010\rJ(\u0010\u0012\u001a\u00028\u0000\"\b\b\u0000\u0010\u000f*\u00020\u000e2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00028\u00000\u0010H\u0002¢\u0006\u0004\b\u0012\u0010\u0013J0\u0010\u0016\u001a\u00028\u0000\"\b\b\u0000\u0010\u000f*\u00020\u000e2\u0006\u0010\u0015\u001a\u00020\u00142\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00028\u00000\u0010H\u0002¢\u0006\u0004\b\u0016\u0010\u0017R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0018R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0019R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001b¨\u0006 "}, d2 = {"Landroidx/lifecycle/ViewModelProvider;", "", "Landroidx/lifecycle/ViewModelStore;", "store", "Landroidx/lifecycle/ViewModelProvider$Factory;", "factory", "Landroidx/lifecycle/viewmodel/CreationExtras;", "defaultCreationExtras", "<init>", "(Landroidx/lifecycle/ViewModelStore;Landroidx/lifecycle/ViewModelProvider$Factory;Landroidx/lifecycle/viewmodel/CreationExtras;)V", "Landroidx/lifecycle/ViewModelStoreOwner;", "owner", "(Landroidx/lifecycle/ViewModelStoreOwner;)V", "(Landroidx/lifecycle/ViewModelStoreOwner;Landroidx/lifecycle/ViewModelProvider$Factory;)V", "Landroidx/lifecycle/ViewModel;", "T", "Ljava/lang/Class;", "modelClass", "a", "(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "", "key", "b", "(Ljava/lang/String;Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "Landroidx/lifecycle/ViewModelStore;", "Landroidx/lifecycle/ViewModelProvider$Factory;", "c", "Landroidx/lifecycle/viewmodel/CreationExtras;", "AndroidViewModelFactory", "Factory", "NewInstanceFactory", "OnRequeryFactory", "lifecycle-viewmodel_release"}, k = 1, mv = {1, 8, 0})
public class ViewModelProvider {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private final ViewModelStore f8608a;
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    private final Factory f8609b;
    @NotNull

    /* renamed from: c  reason: collision with root package name */
    private final CreationExtras f8610c;

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\b\u0016\u0018\u0000 \u00192\u00020\u0001:\u0001\u001aB\u001b\b\u0002\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007B\t\b\u0016¢\u0006\u0004\b\u0006\u0010\bB\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0006\u0010\tJ/\u0010\u000f\u001a\u00028\u0000\"\b\b\u0000\u0010\u000b*\u00020\n2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00000\f2\u0006\u0010\u000e\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u000f\u0010\u0010J/\u0010\u0013\u001a\u00028\u0000\"\b\b\u0000\u0010\u000b*\u00020\n2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00000\f2\u0006\u0010\u0012\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J'\u0010\u0015\u001a\u00028\u0000\"\b\b\u0000\u0010\u000b*\u00020\n2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00000\fH\u0016¢\u0006\u0004\b\u0015\u0010\u0016R\u0016\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018¨\u0006\u001b"}, d2 = {"Landroidx/lifecycle/ViewModelProvider$AndroidViewModelFactory;", "Landroidx/lifecycle/ViewModelProvider$NewInstanceFactory;", "Landroid/app/Application;", "application", "", "unused", "<init>", "(Landroid/app/Application;I)V", "()V", "(Landroid/app/Application;)V", "Landroidx/lifecycle/ViewModel;", "T", "Ljava/lang/Class;", "modelClass", "app", "h", "(Ljava/lang/Class;Landroid/app/Application;)Landroidx/lifecycle/ViewModel;", "Landroidx/lifecycle/viewmodel/CreationExtras;", "extras", "b", "(Ljava/lang/Class;Landroidx/lifecycle/viewmodel/CreationExtras;)Landroidx/lifecycle/ViewModel;", "a", "(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "e", "Landroid/app/Application;", "f", "Companion", "lifecycle-viewmodel_release"}, k = 1, mv = {1, 8, 0})
    public static class AndroidViewModelFactory extends NewInstanceFactory {
        @NotNull

        /* renamed from: f  reason: collision with root package name */
        public static final Companion f8611f = new Companion((DefaultConstructorMarker) null);
        @NotNull

        /* renamed from: g  reason: collision with root package name */
        public static final String f8612g = "androidx.lifecycle.ViewModelProvider.DefaultKey";
        /* access modifiers changed from: private */
        @Nullable

        /* renamed from: h  reason: collision with root package name */
        public static AndroidViewModelFactory f8613h;
        @NotNull
        @JvmField

        /* renamed from: i  reason: collision with root package name */
        public static final CreationExtras.Key<Application> f8614i = Companion.ApplicationKeyImpl.f8616a;
        @Nullable

        /* renamed from: e  reason: collision with root package name */
        private final Application f8615e;

        @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0003\u0018\u00002\u00020\u0001:\u0001\u0016B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0000¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tH\u0007¢\u0006\u0004\b\f\u0010\rR\u001a\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\t0\u000e8\u0006X\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0012\u001a\u00020\u00118\u0000XT¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0018\u0010\u0014\u001a\u0004\u0018\u00010\u000b8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015¨\u0006\u0017"}, d2 = {"Landroidx/lifecycle/ViewModelProvider$AndroidViewModelFactory$Companion;", "", "<init>", "()V", "Landroidx/lifecycle/ViewModelStoreOwner;", "owner", "Landroidx/lifecycle/ViewModelProvider$Factory;", "a", "(Landroidx/lifecycle/ViewModelStoreOwner;)Landroidx/lifecycle/ViewModelProvider$Factory;", "Landroid/app/Application;", "application", "Landroidx/lifecycle/ViewModelProvider$AndroidViewModelFactory;", "b", "(Landroid/app/Application;)Landroidx/lifecycle/ViewModelProvider$AndroidViewModelFactory;", "Landroidx/lifecycle/viewmodel/CreationExtras$Key;", "APPLICATION_KEY", "Landroidx/lifecycle/viewmodel/CreationExtras$Key;", "", "DEFAULT_KEY", "Ljava/lang/String;", "sInstance", "Landroidx/lifecycle/ViewModelProvider$AndroidViewModelFactory;", "ApplicationKeyImpl", "lifecycle-viewmodel_release"}, k = 1, mv = {1, 8, 0})
        public static final class Companion {

            @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÂ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Landroidx/lifecycle/ViewModelProvider$AndroidViewModelFactory$Companion$ApplicationKeyImpl;", "Landroidx/lifecycle/viewmodel/CreationExtras$Key;", "Landroid/app/Application;", "()V", "lifecycle-viewmodel_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
            private static final class ApplicationKeyImpl implements CreationExtras.Key<Application> {
                @NotNull

                /* renamed from: a  reason: collision with root package name */
                public static final ApplicationKeyImpl f8616a = new ApplicationKeyImpl();

                private ApplicationKeyImpl() {
                }
            }

            private Companion() {
            }

            @NotNull
            public final Factory a(@NotNull ViewModelStoreOwner viewModelStoreOwner) {
                Intrinsics.p(viewModelStoreOwner, "owner");
                return viewModelStoreOwner instanceof HasDefaultViewModelProviderFactory ? ((HasDefaultViewModelProviderFactory) viewModelStoreOwner).n() : NewInstanceFactory.f8619b.a();
            }

            @JvmStatic
            @NotNull
            public final AndroidViewModelFactory b(@NotNull Application application) {
                Intrinsics.p(application, "application");
                if (AndroidViewModelFactory.f8613h == null) {
                    AndroidViewModelFactory.f8613h = new AndroidViewModelFactory(application);
                }
                AndroidViewModelFactory f2 = AndroidViewModelFactory.f8613h;
                Intrinsics.m(f2);
                return f2;
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        public AndroidViewModelFactory() {
            this((Application) null, 0);
        }

        private final <T extends ViewModel> T h(Class<T> cls, Application application) {
            if (!AndroidViewModel.class.isAssignableFrom(cls)) {
                return super.a(cls);
            }
            try {
                T t = (ViewModel) cls.getConstructor(new Class[]{Application.class}).newInstance(new Object[]{application});
                Intrinsics.o(t, "{\n                try {\n…          }\n            }");
                return t;
            } catch (NoSuchMethodException e2) {
                throw new RuntimeException("Cannot create an instance of " + cls, e2);
            } catch (IllegalAccessException e3) {
                throw new RuntimeException("Cannot create an instance of " + cls, e3);
            } catch (InstantiationException e4) {
                throw new RuntimeException("Cannot create an instance of " + cls, e4);
            } catch (InvocationTargetException e5) {
                throw new RuntimeException("Cannot create an instance of " + cls, e5);
            }
        }

        @JvmStatic
        @NotNull
        public static final AndroidViewModelFactory i(@NotNull Application application) {
            return f8611f.b(application);
        }

        @NotNull
        public <T extends ViewModel> T a(@NotNull Class<T> cls) {
            Intrinsics.p(cls, "modelClass");
            Application application = this.f8615e;
            if (application != null) {
                return h(cls, application);
            }
            throw new UnsupportedOperationException("AndroidViewModelFactory constructed with empty constructor works only with create(modelClass: Class<T>, extras: CreationExtras).");
        }

        @NotNull
        public <T extends ViewModel> T b(@NotNull Class<T> cls, @NotNull CreationExtras creationExtras) {
            Intrinsics.p(cls, "modelClass");
            Intrinsics.p(creationExtras, "extras");
            if (this.f8615e != null) {
                return a(cls);
            }
            Application application = (Application) creationExtras.a(f8614i);
            if (application != null) {
                return h(cls, application);
            }
            if (!AndroidViewModel.class.isAssignableFrom(cls)) {
                return super.a(cls);
            }
            throw new IllegalArgumentException("CreationExtras must have an application by `APPLICATION_KEY`");
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public AndroidViewModelFactory(@NotNull Application application) {
            this(application, 0);
            Intrinsics.p(application, "application");
        }

        private AndroidViewModelFactory(Application application, int i2) {
            this.f8615e = application;
        }
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u0000 \u00062\u00020\u0001:\u0001\fJ'\u0010\u0006\u001a\u00028\u0000\"\b\b\u0000\u0010\u0003*\u00020\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J/\u0010\n\u001a\u00028\u0000\"\b\b\u0000\u0010\u0003*\u00020\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u00042\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\n\u0010\u000bø\u0001\u0000\u0002\u0006\n\u0004\b!0\u0001¨\u0006\rÀ\u0006\u0001"}, d2 = {"Landroidx/lifecycle/ViewModelProvider$Factory;", "", "Landroidx/lifecycle/ViewModel;", "T", "Ljava/lang/Class;", "modelClass", "a", "(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "Landroidx/lifecycle/viewmodel/CreationExtras;", "extras", "b", "(Ljava/lang/Class;Landroidx/lifecycle/viewmodel/CreationExtras;)Landroidx/lifecycle/ViewModel;", "Companion", "lifecycle-viewmodel_release"}, k = 1, mv = {1, 8, 0})
    public interface Factory {
        @NotNull

        /* renamed from: a  reason: collision with root package name */
        public static final Companion f8617a = Companion.f8618a;

        @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J+\u0010\b\u001a\u00020\u00072\u001a\u0010\u0006\u001a\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030\u00050\u0004\"\u0006\u0012\u0002\b\u00030\u0005H\u0007¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Landroidx/lifecycle/ViewModelProvider$Factory$Companion;", "", "<init>", "()V", "", "Landroidx/lifecycle/viewmodel/ViewModelInitializer;", "initializers", "Landroidx/lifecycle/ViewModelProvider$Factory;", "a", "([Landroidx/lifecycle/viewmodel/ViewModelInitializer;)Landroidx/lifecycle/ViewModelProvider$Factory;", "lifecycle-viewmodel_release"}, k = 1, mv = {1, 8, 0})
        public static final class Companion {

            /* renamed from: a  reason: collision with root package name */
            static final /* synthetic */ Companion f8618a = new Companion();

            private Companion() {
            }

            @JvmStatic
            @NotNull
            public final Factory a(@NotNull ViewModelInitializer<?>... viewModelInitializerArr) {
                Intrinsics.p(viewModelInitializerArr, "initializers");
                return new InitializerViewModelFactory((ViewModelInitializer[]) Arrays.copyOf(viewModelInitializerArr, viewModelInitializerArr.length));
            }
        }

        @NotNull
        <T extends ViewModel> T a(@NotNull Class<T> cls);

        @NotNull
        <T extends ViewModel> T b(@NotNull Class<T> cls, @NotNull CreationExtras creationExtras);
    }

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0016\u0018\u0000 \n2\u00020\u0001:\u0001\u000bB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J'\u0010\b\u001a\u00028\u0000\"\b\b\u0000\u0010\u0005*\u00020\u00042\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006H\u0016¢\u0006\u0004\b\b\u0010\t¨\u0006\f"}, d2 = {"Landroidx/lifecycle/ViewModelProvider$NewInstanceFactory;", "Landroidx/lifecycle/ViewModelProvider$Factory;", "<init>", "()V", "Landroidx/lifecycle/ViewModel;", "T", "Ljava/lang/Class;", "modelClass", "a", "(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "b", "Companion", "lifecycle-viewmodel_release"}, k = 1, mv = {1, 8, 0})
    public static class NewInstanceFactory implements Factory {
        @NotNull

        /* renamed from: b  reason: collision with root package name */
        public static final Companion f8619b = new Companion((DefaultConstructorMarker) null);
        /* access modifiers changed from: private */
        @Nullable

        /* renamed from: c  reason: collision with root package name */
        public static NewInstanceFactory f8620c;
        @NotNull
        @JvmField

        /* renamed from: d  reason: collision with root package name */
        public static final CreationExtras.Key<String> f8621d = Companion.ViewModelKeyImpl.f8622a;

        @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0003\u0018\u00002\u00020\u0001:\u0001\u000fB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001a\u0010\b\u001a\u00020\u00048GX\u0004¢\u0006\f\u0012\u0004\b\u0007\u0010\u0003\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0006X\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0018\u0010\r\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\r\u0010\u000e¨\u0006\u0010"}, d2 = {"Landroidx/lifecycle/ViewModelProvider$NewInstanceFactory$Companion;", "", "<init>", "()V", "Landroidx/lifecycle/ViewModelProvider$NewInstanceFactory;", "a", "()Landroidx/lifecycle/ViewModelProvider$NewInstanceFactory;", "b", "instance", "Landroidx/lifecycle/viewmodel/CreationExtras$Key;", "", "VIEW_MODEL_KEY", "Landroidx/lifecycle/viewmodel/CreationExtras$Key;", "sInstance", "Landroidx/lifecycle/ViewModelProvider$NewInstanceFactory;", "ViewModelKeyImpl", "lifecycle-viewmodel_release"}, k = 1, mv = {1, 8, 0})
        public static final class Companion {

            @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\bÂ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Landroidx/lifecycle/ViewModelProvider$NewInstanceFactory$Companion$ViewModelKeyImpl;", "Landroidx/lifecycle/viewmodel/CreationExtras$Key;", "", "()V", "lifecycle-viewmodel_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
            private static final class ViewModelKeyImpl implements CreationExtras.Key<String> {
                @NotNull

                /* renamed from: a  reason: collision with root package name */
                public static final ViewModelKeyImpl f8622a = new ViewModelKeyImpl();

                private ViewModelKeyImpl() {
                }
            }

            private Companion() {
            }

            @JvmStatic
            public static /* synthetic */ void b() {
            }

            @NotNull
            @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
            public final NewInstanceFactory a() {
                if (NewInstanceFactory.f8620c == null) {
                    NewInstanceFactory.f8620c = new NewInstanceFactory();
                }
                NewInstanceFactory c2 = NewInstanceFactory.f8620c;
                Intrinsics.m(c2);
                return c2;
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        @NotNull
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public static final NewInstanceFactory e() {
            return f8619b.a();
        }

        @NotNull
        public <T extends ViewModel> T a(@NotNull Class<T> cls) {
            Intrinsics.p(cls, "modelClass");
            try {
                T newInstance = cls.getDeclaredConstructor((Class[]) null).newInstance((Object[]) null);
                Intrinsics.o(newInstance, "{\n                modelC…wInstance()\n            }");
                return (ViewModel) newInstance;
            } catch (NoSuchMethodException e2) {
                throw new RuntimeException("Cannot create an instance of " + cls, e2);
            } catch (InstantiationException e3) {
                throw new RuntimeException("Cannot create an instance of " + cls, e3);
            } catch (IllegalAccessException e4) {
                throw new RuntimeException("Cannot create an instance of " + cls, e4);
            }
        }

        public /* synthetic */ ViewModel b(Class cls, CreationExtras creationExtras) {
            return l.b(this, cls, creationExtras);
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0017\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Landroidx/lifecycle/ViewModelProvider$OnRequeryFactory;", "", "<init>", "()V", "Landroidx/lifecycle/ViewModel;", "viewModel", "", "c", "(Landroidx/lifecycle/ViewModel;)V", "lifecycle-viewmodel_release"}, k = 1, mv = {1, 8, 0})
    public static class OnRequeryFactory {
        public void c(@NotNull ViewModel viewModel) {
            Intrinsics.p(viewModel, "viewModel");
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public ViewModelProvider(@NotNull ViewModelStore viewModelStore, @NotNull Factory factory) {
        this(viewModelStore, factory, (CreationExtras) null, 4, (DefaultConstructorMarker) null);
        Intrinsics.p(viewModelStore, "store");
        Intrinsics.p(factory, "factory");
    }

    @NotNull
    @MainThread
    public <T extends ViewModel> T a(@NotNull Class<T> cls) {
        Intrinsics.p(cls, "modelClass");
        String canonicalName = cls.getCanonicalName();
        if (canonicalName != null) {
            return b("androidx.lifecycle.ViewModelProvider.DefaultKey:" + canonicalName, cls);
        }
        throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
    }

    @NotNull
    @MainThread
    public <T extends ViewModel> T b(@NotNull String str, @NotNull Class<T> cls) {
        T t;
        Intrinsics.p(str, "key");
        Intrinsics.p(cls, "modelClass");
        T b2 = this.f8608a.b(str);
        if (cls.isInstance(b2)) {
            Factory factory = this.f8609b;
            OnRequeryFactory onRequeryFactory = factory instanceof OnRequeryFactory ? (OnRequeryFactory) factory : null;
            if (onRequeryFactory != null) {
                Intrinsics.m(b2);
                onRequeryFactory.c(b2);
            }
            Intrinsics.n(b2, "null cannot be cast to non-null type T of androidx.lifecycle.ViewModelProvider.get");
            return b2;
        }
        MutableCreationExtras mutableCreationExtras = new MutableCreationExtras(this.f8610c);
        mutableCreationExtras.c(NewInstanceFactory.f8621d, str);
        try {
            t = this.f8609b.b(cls, mutableCreationExtras);
        } catch (AbstractMethodError unused) {
            t = this.f8609b.a(cls);
        }
        this.f8608a.d(str, t);
        return t;
    }

    @JvmOverloads
    public ViewModelProvider(@NotNull ViewModelStore viewModelStore, @NotNull Factory factory, @NotNull CreationExtras creationExtras) {
        Intrinsics.p(viewModelStore, "store");
        Intrinsics.p(factory, "factory");
        Intrinsics.p(creationExtras, "defaultCreationExtras");
        this.f8608a = viewModelStore;
        this.f8609b = factory;
        this.f8610c = creationExtras;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ViewModelProvider(ViewModelStore viewModelStore, Factory factory, CreationExtras creationExtras, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(viewModelStore, factory, (i2 & 4) != 0 ? CreationExtras.Empty.f8714b : creationExtras);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public ViewModelProvider(@NotNull ViewModelStoreOwner viewModelStoreOwner) {
        this(viewModelStoreOwner.w(), AndroidViewModelFactory.f8611f.a(viewModelStoreOwner), ViewModelProviderGetKt.a(viewModelStoreOwner));
        Intrinsics.p(viewModelStoreOwner, "owner");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public ViewModelProvider(@NotNull ViewModelStoreOwner viewModelStoreOwner, @NotNull Factory factory) {
        this(viewModelStoreOwner.w(), factory, ViewModelProviderGetKt.a(viewModelStoreOwner));
        Intrinsics.p(viewModelStoreOwner, "owner");
        Intrinsics.p(factory, "factory");
    }
}
