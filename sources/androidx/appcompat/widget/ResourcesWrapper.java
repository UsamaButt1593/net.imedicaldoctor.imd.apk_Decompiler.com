package androidx.appcompat.widget;

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
import androidx.annotation.RequiresApi;
import androidx.core.content.res.ResourcesCompat;
import java.io.IOException;
import java.io.InputStream;
import org.xmlpull.v1.XmlPullParserException;

class ResourcesWrapper extends Resources {

    /* renamed from: a  reason: collision with root package name */
    private final Resources f3238a;

    public ResourcesWrapper(Resources resources) {
        super(resources.getAssets(), resources.getDisplayMetrics(), resources.getConfiguration());
        this.f3238a = resources;
    }

    /* access modifiers changed from: package-private */
    public final Drawable a(int i2) throws Resources.NotFoundException {
        return super.getDrawable(i2);
    }

    public XmlResourceParser getAnimation(int i2) throws Resources.NotFoundException {
        return this.f3238a.getAnimation(i2);
    }

    public boolean getBoolean(int i2) throws Resources.NotFoundException {
        return this.f3238a.getBoolean(i2);
    }

    public int getColor(int i2) throws Resources.NotFoundException {
        return this.f3238a.getColor(i2);
    }

    public ColorStateList getColorStateList(int i2) throws Resources.NotFoundException {
        return this.f3238a.getColorStateList(i2);
    }

    public Configuration getConfiguration() {
        return this.f3238a.getConfiguration();
    }

    public float getDimension(int i2) throws Resources.NotFoundException {
        return this.f3238a.getDimension(i2);
    }

    public int getDimensionPixelOffset(int i2) throws Resources.NotFoundException {
        return this.f3238a.getDimensionPixelOffset(i2);
    }

    public int getDimensionPixelSize(int i2) throws Resources.NotFoundException {
        return this.f3238a.getDimensionPixelSize(i2);
    }

    public DisplayMetrics getDisplayMetrics() {
        return this.f3238a.getDisplayMetrics();
    }

    public Drawable getDrawable(int i2) throws Resources.NotFoundException {
        return this.f3238a.getDrawable(i2);
    }

    public Drawable getDrawableForDensity(int i2, int i3) throws Resources.NotFoundException {
        return ResourcesCompat.h(this.f3238a, i2, i3, (Resources.Theme) null);
    }

    public float getFraction(int i2, int i3, int i4) {
        return this.f3238a.getFraction(i2, i3, i4);
    }

    public int getIdentifier(String str, String str2, String str3) {
        return this.f3238a.getIdentifier(str, str2, str3);
    }

    public int[] getIntArray(int i2) throws Resources.NotFoundException {
        return this.f3238a.getIntArray(i2);
    }

    public int getInteger(int i2) throws Resources.NotFoundException {
        return this.f3238a.getInteger(i2);
    }

    public XmlResourceParser getLayout(int i2) throws Resources.NotFoundException {
        return this.f3238a.getLayout(i2);
    }

    public Movie getMovie(int i2) throws Resources.NotFoundException {
        return this.f3238a.getMovie(i2);
    }

    public String getQuantityString(int i2, int i3) throws Resources.NotFoundException {
        return this.f3238a.getQuantityString(i2, i3);
    }

    public CharSequence getQuantityText(int i2, int i3) throws Resources.NotFoundException {
        return this.f3238a.getQuantityText(i2, i3);
    }

    public String getResourceEntryName(int i2) throws Resources.NotFoundException {
        return this.f3238a.getResourceEntryName(i2);
    }

    public String getResourceName(int i2) throws Resources.NotFoundException {
        return this.f3238a.getResourceName(i2);
    }

    public String getResourcePackageName(int i2) throws Resources.NotFoundException {
        return this.f3238a.getResourcePackageName(i2);
    }

    public String getResourceTypeName(int i2) throws Resources.NotFoundException {
        return this.f3238a.getResourceTypeName(i2);
    }

    public String getString(int i2) throws Resources.NotFoundException {
        return this.f3238a.getString(i2);
    }

    public String[] getStringArray(int i2) throws Resources.NotFoundException {
        return this.f3238a.getStringArray(i2);
    }

    public CharSequence getText(int i2) throws Resources.NotFoundException {
        return this.f3238a.getText(i2);
    }

    public CharSequence[] getTextArray(int i2) throws Resources.NotFoundException {
        return this.f3238a.getTextArray(i2);
    }

    public void getValue(int i2, TypedValue typedValue, boolean z) throws Resources.NotFoundException {
        this.f3238a.getValue(i2, typedValue, z);
    }

    public void getValueForDensity(int i2, int i3, TypedValue typedValue, boolean z) throws Resources.NotFoundException {
        this.f3238a.getValueForDensity(i2, i3, typedValue, z);
    }

    public XmlResourceParser getXml(int i2) throws Resources.NotFoundException {
        return this.f3238a.getXml(i2);
    }

    public TypedArray obtainAttributes(AttributeSet attributeSet, int[] iArr) {
        return this.f3238a.obtainAttributes(attributeSet, iArr);
    }

    public TypedArray obtainTypedArray(int i2) throws Resources.NotFoundException {
        return this.f3238a.obtainTypedArray(i2);
    }

    public InputStream openRawResource(int i2) throws Resources.NotFoundException {
        return this.f3238a.openRawResource(i2);
    }

    public AssetFileDescriptor openRawResourceFd(int i2) throws Resources.NotFoundException {
        return this.f3238a.openRawResourceFd(i2);
    }

    public void parseBundleExtra(String str, AttributeSet attributeSet, Bundle bundle) throws XmlPullParserException {
        this.f3238a.parseBundleExtra(str, attributeSet, bundle);
    }

    public void parseBundleExtras(XmlResourceParser xmlResourceParser, Bundle bundle) throws XmlPullParserException, IOException {
        this.f3238a.parseBundleExtras(xmlResourceParser, bundle);
    }

    public void updateConfiguration(Configuration configuration, DisplayMetrics displayMetrics) {
        super.updateConfiguration(configuration, displayMetrics);
        Resources resources = this.f3238a;
        if (resources != null) {
            resources.updateConfiguration(configuration, displayMetrics);
        }
    }

    @RequiresApi(21)
    public Drawable getDrawable(int i2, Resources.Theme theme) throws Resources.NotFoundException {
        return ResourcesCompat.g(this.f3238a, i2, theme);
    }

    @RequiresApi(21)
    public Drawable getDrawableForDensity(int i2, int i3, Resources.Theme theme) {
        return ResourcesCompat.h(this.f3238a, i2, i3, theme);
    }

    public String getQuantityString(int i2, int i3, Object... objArr) throws Resources.NotFoundException {
        return this.f3238a.getQuantityString(i2, i3, objArr);
    }

    public String getString(int i2, Object... objArr) throws Resources.NotFoundException {
        return this.f3238a.getString(i2, objArr);
    }

    public CharSequence getText(int i2, CharSequence charSequence) {
        return this.f3238a.getText(i2, charSequence);
    }

    public void getValue(String str, TypedValue typedValue, boolean z) throws Resources.NotFoundException {
        this.f3238a.getValue(str, typedValue, z);
    }

    public InputStream openRawResource(int i2, TypedValue typedValue) throws Resources.NotFoundException {
        return this.f3238a.openRawResource(i2, typedValue);
    }
}
