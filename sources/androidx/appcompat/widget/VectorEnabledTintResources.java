package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.Movie;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import org.xmlpull.v1.XmlPullParserException;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class VectorEnabledTintResources extends ResourcesWrapper {

    /* renamed from: c  reason: collision with root package name */
    private static boolean f3364c = false;

    /* renamed from: d  reason: collision with root package name */
    public static final int f3365d = 20;

    /* renamed from: b  reason: collision with root package name */
    private final WeakReference<Context> f3366b;

    public VectorEnabledTintResources(@NonNull Context context, @NonNull Resources resources) {
        super(resources);
        this.f3366b = new WeakReference<>(context);
    }

    public static boolean b() {
        return f3364c;
    }

    public static void c(boolean z) {
        f3364c = z;
    }

    public static boolean d() {
        b();
        return false;
    }

    public /* bridge */ /* synthetic */ XmlResourceParser getAnimation(int i2) throws Resources.NotFoundException {
        return super.getAnimation(i2);
    }

    public /* bridge */ /* synthetic */ boolean getBoolean(int i2) throws Resources.NotFoundException {
        return super.getBoolean(i2);
    }

    public /* bridge */ /* synthetic */ int getColor(int i2) throws Resources.NotFoundException {
        return super.getColor(i2);
    }

    public /* bridge */ /* synthetic */ ColorStateList getColorStateList(int i2) throws Resources.NotFoundException {
        return super.getColorStateList(i2);
    }

    public /* bridge */ /* synthetic */ Configuration getConfiguration() {
        return super.getConfiguration();
    }

    public /* bridge */ /* synthetic */ float getDimension(int i2) throws Resources.NotFoundException {
        return super.getDimension(i2);
    }

    public /* bridge */ /* synthetic */ int getDimensionPixelOffset(int i2) throws Resources.NotFoundException {
        return super.getDimensionPixelOffset(i2);
    }

    public /* bridge */ /* synthetic */ int getDimensionPixelSize(int i2) throws Resources.NotFoundException {
        return super.getDimensionPixelSize(i2);
    }

    public /* bridge */ /* synthetic */ DisplayMetrics getDisplayMetrics() {
        return super.getDisplayMetrics();
    }

    public Drawable getDrawable(int i2) throws Resources.NotFoundException {
        Context context = this.f3366b.get();
        return context != null ? ResourceManagerInternal.h().t(context, this, i2) : a(i2);
    }

    public /* bridge */ /* synthetic */ Drawable getDrawableForDensity(int i2, int i3) throws Resources.NotFoundException {
        return super.getDrawableForDensity(i2, i3);
    }

    public /* bridge */ /* synthetic */ float getFraction(int i2, int i3, int i4) {
        return super.getFraction(i2, i3, i4);
    }

    public /* bridge */ /* synthetic */ int getIdentifier(String str, String str2, String str3) {
        return super.getIdentifier(str, str2, str3);
    }

    public /* bridge */ /* synthetic */ int[] getIntArray(int i2) throws Resources.NotFoundException {
        return super.getIntArray(i2);
    }

    public /* bridge */ /* synthetic */ int getInteger(int i2) throws Resources.NotFoundException {
        return super.getInteger(i2);
    }

    public /* bridge */ /* synthetic */ XmlResourceParser getLayout(int i2) throws Resources.NotFoundException {
        return super.getLayout(i2);
    }

    public /* bridge */ /* synthetic */ Movie getMovie(int i2) throws Resources.NotFoundException {
        return super.getMovie(i2);
    }

    public /* bridge */ /* synthetic */ String getQuantityString(int i2, int i3) throws Resources.NotFoundException {
        return super.getQuantityString(i2, i3);
    }

    public /* bridge */ /* synthetic */ CharSequence getQuantityText(int i2, int i3) throws Resources.NotFoundException {
        return super.getQuantityText(i2, i3);
    }

    public /* bridge */ /* synthetic */ String getResourceEntryName(int i2) throws Resources.NotFoundException {
        return super.getResourceEntryName(i2);
    }

    public /* bridge */ /* synthetic */ String getResourceName(int i2) throws Resources.NotFoundException {
        return super.getResourceName(i2);
    }

    public /* bridge */ /* synthetic */ String getResourcePackageName(int i2) throws Resources.NotFoundException {
        return super.getResourcePackageName(i2);
    }

    public /* bridge */ /* synthetic */ String getResourceTypeName(int i2) throws Resources.NotFoundException {
        return super.getResourceTypeName(i2);
    }

    public /* bridge */ /* synthetic */ String getString(int i2) throws Resources.NotFoundException {
        return super.getString(i2);
    }

    public /* bridge */ /* synthetic */ String[] getStringArray(int i2) throws Resources.NotFoundException {
        return super.getStringArray(i2);
    }

    public /* bridge */ /* synthetic */ CharSequence getText(int i2) throws Resources.NotFoundException {
        return super.getText(i2);
    }

    public /* bridge */ /* synthetic */ CharSequence[] getTextArray(int i2) throws Resources.NotFoundException {
        return super.getTextArray(i2);
    }

    public /* bridge */ /* synthetic */ void getValue(int i2, TypedValue typedValue, boolean z) throws Resources.NotFoundException {
        super.getValue(i2, typedValue, z);
    }

    public /* bridge */ /* synthetic */ void getValueForDensity(int i2, int i3, TypedValue typedValue, boolean z) throws Resources.NotFoundException {
        super.getValueForDensity(i2, i3, typedValue, z);
    }

    public /* bridge */ /* synthetic */ XmlResourceParser getXml(int i2) throws Resources.NotFoundException {
        return super.getXml(i2);
    }

    public /* bridge */ /* synthetic */ TypedArray obtainAttributes(AttributeSet attributeSet, int[] iArr) {
        return super.obtainAttributes(attributeSet, iArr);
    }

    public /* bridge */ /* synthetic */ TypedArray obtainTypedArray(int i2) throws Resources.NotFoundException {
        return super.obtainTypedArray(i2);
    }

    public /* bridge */ /* synthetic */ InputStream openRawResource(int i2) throws Resources.NotFoundException {
        return super.openRawResource(i2);
    }

    public /* bridge */ /* synthetic */ AssetFileDescriptor openRawResourceFd(int i2) throws Resources.NotFoundException {
        return super.openRawResourceFd(i2);
    }

    public /* bridge */ /* synthetic */ void parseBundleExtra(String str, AttributeSet attributeSet, Bundle bundle) throws XmlPullParserException {
        super.parseBundleExtra(str, attributeSet, bundle);
    }

    public /* bridge */ /* synthetic */ void parseBundleExtras(XmlResourceParser xmlResourceParser, Bundle bundle) throws XmlPullParserException, IOException {
        super.parseBundleExtras(xmlResourceParser, bundle);
    }

    public /* bridge */ /* synthetic */ void updateConfiguration(Configuration configuration, DisplayMetrics displayMetrics) {
        super.updateConfiguration(configuration, displayMetrics);
    }

    @RequiresApi(21)
    public /* bridge */ /* synthetic */ Drawable getDrawable(int i2, Resources.Theme theme) throws Resources.NotFoundException {
        return super.getDrawable(i2, theme);
    }

    @RequiresApi(21)
    public /* bridge */ /* synthetic */ Drawable getDrawableForDensity(int i2, int i3, Resources.Theme theme) {
        return super.getDrawableForDensity(i2, i3, theme);
    }

    public /* bridge */ /* synthetic */ String getQuantityString(int i2, int i3, Object[] objArr) throws Resources.NotFoundException {
        return super.getQuantityString(i2, i3, objArr);
    }

    public /* bridge */ /* synthetic */ String getString(int i2, Object[] objArr) throws Resources.NotFoundException {
        return super.getString(i2, objArr);
    }

    public /* bridge */ /* synthetic */ CharSequence getText(int i2, CharSequence charSequence) {
        return super.getText(i2, charSequence);
    }

    public /* bridge */ /* synthetic */ void getValue(String str, TypedValue typedValue, boolean z) throws Resources.NotFoundException {
        super.getValue(str, typedValue, z);
    }

    public /* bridge */ /* synthetic */ InputStream openRawResource(int i2, TypedValue typedValue) throws Resources.NotFoundException {
        return super.openRawResource(i2, typedValue);
    }
}
