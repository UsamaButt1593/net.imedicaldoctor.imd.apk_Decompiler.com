package com.google.firebase.sessions;

import android.util.Log;
import androidx.datastore.core.CorruptionException;
import androidx.datastore.preferences.core.Preferences;
import androidx.datastore.preferences.core.PreferencesFactory;
import com.itextpdf.tool.xml.css.CSS;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.apache.commons.lang3.ClassUtils;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroidx/datastore/core/CorruptionException;", "ex", "Landroidx/datastore/preferences/core/Preferences;", "b", "(Landroidx/datastore/core/CorruptionException;)Landroidx/datastore/preferences/core/Preferences;"}, k = 3, mv = {1, 8, 0})
final class SessionDatastoreImpl$Companion$dataStore$2 extends Lambda implements Function1<CorruptionException, Preferences> {
    public static final SessionDatastoreImpl$Companion$dataStore$2 X = new SessionDatastoreImpl$Companion$dataStore$2();

    SessionDatastoreImpl$Companion$dataStore$2() {
        super(1);
    }

    @NotNull
    /* renamed from: b */
    public final Preferences f(@NotNull CorruptionException corruptionException) {
        Intrinsics.p(corruptionException, CSS.Value.p0);
        Log.w("FirebaseSessionsRepo", "CorruptionException in sessions DataStore in " + ProcessDetailsProvider.f25074a.e() + ClassUtils.PACKAGE_SEPARATOR_CHAR, corruptionException);
        return PreferencesFactory.b();
    }
}
