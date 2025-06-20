package androidx.core.app;

import android.app.Person;
import android.os.Bundle;
import android.os.PersistableBundle;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.core.graphics.drawable.IconCompat;
import java.util.Objects;

public class Person {

    /* renamed from: g  reason: collision with root package name */
    private static final String f5549g = "name";

    /* renamed from: h  reason: collision with root package name */
    private static final String f5550h = "icon";

    /* renamed from: i  reason: collision with root package name */
    private static final String f5551i = "uri";

    /* renamed from: j  reason: collision with root package name */
    private static final String f5552j = "key";

    /* renamed from: k  reason: collision with root package name */
    private static final String f5553k = "isBot";

    /* renamed from: l  reason: collision with root package name */
    private static final String f5554l = "isImportant";
    @Nullable

    /* renamed from: a  reason: collision with root package name */
    CharSequence f5555a;
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    IconCompat f5556b;
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    String f5557c;
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    String f5558d;

    /* renamed from: e  reason: collision with root package name */
    boolean f5559e;

    /* renamed from: f  reason: collision with root package name */
    boolean f5560f;

    @RequiresApi(22)
    static class Api22Impl {
        private Api22Impl() {
        }

        @DoNotInline
        static Person a(PersistableBundle persistableBundle) {
            return new Builder().f(persistableBundle.getString("name")).g(persistableBundle.getString(Person.f5551i)).e(persistableBundle.getString(Person.f5552j)).b(persistableBundle.getBoolean(Person.f5553k)).d(persistableBundle.getBoolean(Person.f5554l)).a();
        }

        @DoNotInline
        static PersistableBundle b(Person person) {
            PersistableBundle persistableBundle = new PersistableBundle();
            CharSequence charSequence = person.f5555a;
            persistableBundle.putString("name", charSequence != null ? charSequence.toString() : null);
            persistableBundle.putString(Person.f5551i, person.f5557c);
            persistableBundle.putString(Person.f5552j, person.f5558d);
            persistableBundle.putBoolean(Person.f5553k, person.f5559e);
            persistableBundle.putBoolean(Person.f5554l, person.f5560f);
            return persistableBundle;
        }
    }

    @RequiresApi(28)
    static class Api28Impl {
        private Api28Impl() {
        }

        @DoNotInline
        static Person a(android.app.Person person) {
            return new Builder().f(person.getName()).c(person.getIcon() != null ? IconCompat.m(person.getIcon()) : null).g(person.getUri()).e(person.getKey()).b(person.isBot()).d(person.isImportant()).a();
        }

        @DoNotInline
        static android.app.Person b(Person person) {
            return new Person.Builder().setName(person.f()).setIcon(person.d() != null ? person.d().L() : null).setUri(person.g()).setKey(person.e()).setBot(person.h()).setImportant(person.i()).build();
        }
    }

    public static class Builder {
        @Nullable

        /* renamed from: a  reason: collision with root package name */
        CharSequence f5561a;
        @Nullable

        /* renamed from: b  reason: collision with root package name */
        IconCompat f5562b;
        @Nullable

        /* renamed from: c  reason: collision with root package name */
        String f5563c;
        @Nullable

        /* renamed from: d  reason: collision with root package name */
        String f5564d;

        /* renamed from: e  reason: collision with root package name */
        boolean f5565e;

        /* renamed from: f  reason: collision with root package name */
        boolean f5566f;

        public Builder() {
        }

        @NonNull
        public Person a() {
            return new Person(this);
        }

        @NonNull
        public Builder b(boolean z) {
            this.f5565e = z;
            return this;
        }

        @NonNull
        public Builder c(@Nullable IconCompat iconCompat) {
            this.f5562b = iconCompat;
            return this;
        }

        @NonNull
        public Builder d(boolean z) {
            this.f5566f = z;
            return this;
        }

        @NonNull
        public Builder e(@Nullable String str) {
            this.f5564d = str;
            return this;
        }

        @NonNull
        public Builder f(@Nullable CharSequence charSequence) {
            this.f5561a = charSequence;
            return this;
        }

        @NonNull
        public Builder g(@Nullable String str) {
            this.f5563c = str;
            return this;
        }

        Builder(Person person) {
            this.f5561a = person.f5555a;
            this.f5562b = person.f5556b;
            this.f5563c = person.f5557c;
            this.f5564d = person.f5558d;
            this.f5565e = person.f5559e;
            this.f5566f = person.f5560f;
        }
    }

    Person(Builder builder) {
        this.f5555a = builder.f5561a;
        this.f5556b = builder.f5562b;
        this.f5557c = builder.f5563c;
        this.f5558d = builder.f5564d;
        this.f5559e = builder.f5565e;
        this.f5560f = builder.f5566f;
    }

    @RequiresApi(28)
    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static Person a(@NonNull android.app.Person person) {
        return Api28Impl.a(person);
    }

    @NonNull
    public static Person b(@NonNull Bundle bundle) {
        Bundle bundle2 = bundle.getBundle(f5550h);
        return new Builder().f(bundle.getCharSequence("name")).c(bundle2 != null ? IconCompat.k(bundle2) : null).g(bundle.getString(f5551i)).e(bundle.getString(f5552j)).b(bundle.getBoolean(f5553k)).d(bundle.getBoolean(f5554l)).a();
    }

    @RequiresApi(22)
    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static Person c(@NonNull PersistableBundle persistableBundle) {
        return Api22Impl.a(persistableBundle);
    }

    @Nullable
    public IconCompat d() {
        return this.f5556b;
    }

    @Nullable
    public String e() {
        return this.f5558d;
    }

    public boolean equals(@Nullable Object obj) {
        if (obj == null || !(obj instanceof Person)) {
            return false;
        }
        Person person = (Person) obj;
        String e2 = e();
        String e3 = person.e();
        return (e2 == null && e3 == null) ? Objects.equals(Objects.toString(f()), Objects.toString(person.f())) && Objects.equals(g(), person.g()) && Boolean.valueOf(h()).equals(Boolean.valueOf(person.h())) && Boolean.valueOf(i()).equals(Boolean.valueOf(person.i())) : Objects.equals(e2, e3);
    }

    @Nullable
    public CharSequence f() {
        return this.f5555a;
    }

    @Nullable
    public String g() {
        return this.f5557c;
    }

    public boolean h() {
        return this.f5559e;
    }

    public int hashCode() {
        String e2 = e();
        if (e2 != null) {
            return e2.hashCode();
        }
        return Objects.hash(new Object[]{f(), g(), Boolean.valueOf(h()), Boolean.valueOf(i())});
    }

    public boolean i() {
        return this.f5560f;
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public String j() {
        String str = this.f5557c;
        if (str != null) {
            return str;
        }
        if (this.f5555a == null) {
            return "";
        }
        return "name:" + this.f5555a;
    }

    @RequiresApi(28)
    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public android.app.Person k() {
        return Api28Impl.b(this);
    }

    @NonNull
    public Builder l() {
        return new Builder(this);
    }

    @NonNull
    public Bundle m() {
        Bundle bundle = new Bundle();
        bundle.putCharSequence("name", this.f5555a);
        IconCompat iconCompat = this.f5556b;
        bundle.putBundle(f5550h, iconCompat != null ? iconCompat.K() : null);
        bundle.putString(f5551i, this.f5557c);
        bundle.putString(f5552j, this.f5558d);
        bundle.putBoolean(f5553k, this.f5559e);
        bundle.putBoolean(f5554l, this.f5560f);
        return bundle;
    }

    @RequiresApi(22)
    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public PersistableBundle n() {
        return Api22Impl.b(this);
    }
}
