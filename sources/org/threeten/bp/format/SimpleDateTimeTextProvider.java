package org.threeten.bp.format;

import java.text.DateFormatSymbols;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import org.threeten.bp.temporal.ChronoField;
import org.threeten.bp.temporal.IsoFields;
import org.threeten.bp.temporal.TemporalField;

final class SimpleDateTimeTextProvider extends DateTimeTextProvider {
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public static final Comparator<Map.Entry<String, Long>> f31848c = new Comparator<Map.Entry<String, Long>>() {
        /* renamed from: a */
        public int compare(Map.Entry<String, Long> entry, Map.Entry<String, Long> entry2) {
            return entry2.getKey().length() - entry.getKey().length();
        }
    };

    /* renamed from: b  reason: collision with root package name */
    private final ConcurrentMap<Map.Entry<TemporalField, Locale>, Object> f31849b = new ConcurrentHashMap(16, 0.75f, 2);

    static final class LocaleStore {

        /* renamed from: a  reason: collision with root package name */
        private final Map<TextStyle, Map<Long, String>> f31850a;

        /* renamed from: b  reason: collision with root package name */
        private final Map<TextStyle, List<Map.Entry<String, Long>>> f31851b;

        LocaleStore(Map<TextStyle, Map<Long, String>> map) {
            this.f31850a = map;
            HashMap hashMap = new HashMap();
            ArrayList arrayList = new ArrayList();
            for (TextStyle next : map.keySet()) {
                HashMap hashMap2 = new HashMap();
                for (Map.Entry entry : map.get(next).entrySet()) {
                    hashMap2.put(entry.getValue(), SimpleDateTimeTextProvider.h(entry.getValue(), entry.getKey()));
                }
                ArrayList arrayList2 = new ArrayList(hashMap2.values());
                Collections.sort(arrayList2, SimpleDateTimeTextProvider.f31848c);
                hashMap.put(next, arrayList2);
                arrayList.addAll(arrayList2);
                hashMap.put((Object) null, arrayList);
            }
            Collections.sort(arrayList, SimpleDateTimeTextProvider.f31848c);
            this.f31851b = hashMap;
        }

        /* access modifiers changed from: package-private */
        public String a(long j2, TextStyle textStyle) {
            Map map = this.f31850a.get(textStyle);
            if (map != null) {
                return (String) map.get(Long.valueOf(j2));
            }
            return null;
        }

        /* access modifiers changed from: package-private */
        public Iterator<Map.Entry<String, Long>> b(TextStyle textStyle) {
            List list = this.f31851b.get(textStyle);
            if (list != null) {
                return list.iterator();
            }
            return null;
        }
    }

    SimpleDateTimeTextProvider() {
    }

    /* access modifiers changed from: private */
    public static <A, B> Map.Entry<A, B> h(A a2, B b2) {
        return new AbstractMap.SimpleImmutableEntry(a2, b2);
    }

    private static LocaleStore i(Map<TextStyle, Map<Long, String>> map) {
        map.put(TextStyle.FULL_STANDALONE, map.get(TextStyle.FULL));
        map.put(TextStyle.SHORT_STANDALONE, map.get(TextStyle.SHORT));
        TextStyle textStyle = TextStyle.NARROW;
        if (map.containsKey(textStyle)) {
            TextStyle textStyle2 = TextStyle.NARROW_STANDALONE;
            if (!map.containsKey(textStyle2)) {
                map.put(textStyle2, map.get(textStyle));
            }
        }
        return new LocaleStore(map);
    }

    private Object j(TemporalField temporalField, Locale locale) {
        TemporalField temporalField2 = temporalField;
        if (temporalField2 == ChronoField.MONTH_OF_YEAR) {
            DateFormatSymbols instance = DateFormatSymbols.getInstance(locale);
            HashMap hashMap = new HashMap();
            String[] months = instance.getMonths();
            HashMap hashMap2 = new HashMap();
            DateFormatSymbols dateFormatSymbols = instance;
            hashMap2.put(1L, months[0]);
            hashMap2.put(2L, months[1]);
            hashMap2.put(3L, months[2]);
            hashMap2.put(4L, months[3]);
            hashMap2.put(5L, months[4]);
            hashMap2.put(6L, months[5]);
            hashMap2.put(7L, months[6]);
            hashMap2.put(8L, months[7]);
            hashMap2.put(9L, months[8]);
            hashMap2.put(10L, months[9]);
            hashMap2.put(11L, months[10]);
            hashMap2.put(12L, months[11]);
            hashMap.put(TextStyle.FULL, hashMap2);
            HashMap hashMap3 = new HashMap();
            hashMap3.put(1L, months[0].substring(0, 1));
            hashMap3.put(2L, months[1].substring(0, 1));
            hashMap3.put(3L, months[2].substring(0, 1));
            hashMap3.put(4L, months[3].substring(0, 1));
            hashMap3.put(5L, months[4].substring(0, 1));
            hashMap3.put(6L, months[5].substring(0, 1));
            hashMap3.put(7L, months[6].substring(0, 1));
            hashMap3.put(8L, months[7].substring(0, 1));
            hashMap3.put(9L, months[8].substring(0, 1));
            hashMap3.put(10L, months[9].substring(0, 1));
            hashMap3.put(11L, months[10].substring(0, 1));
            hashMap3.put(12L, months[11].substring(0, 1));
            HashMap hashMap4 = hashMap;
            hashMap4.put(TextStyle.NARROW, hashMap3);
            String[] shortMonths = dateFormatSymbols.getShortMonths();
            HashMap hashMap5 = new HashMap();
            hashMap5.put(1L, shortMonths[0]);
            hashMap5.put(2, shortMonths[1]);
            hashMap5.put(3L, shortMonths[2]);
            hashMap5.put(4L, shortMonths[3]);
            hashMap5.put(5L, shortMonths[4]);
            hashMap5.put(6L, shortMonths[5]);
            hashMap5.put(7L, shortMonths[6]);
            hashMap5.put(8L, shortMonths[7]);
            hashMap5.put(9L, shortMonths[8]);
            hashMap5.put(10L, shortMonths[9]);
            hashMap5.put(11L, shortMonths[10]);
            hashMap5.put(12L, shortMonths[11]);
            hashMap4.put(TextStyle.SHORT, hashMap5);
            return i(hashMap4);
        } else if (temporalField2 == ChronoField.DAY_OF_WEEK) {
            DateFormatSymbols instance2 = DateFormatSymbols.getInstance(locale);
            HashMap hashMap6 = new HashMap();
            String[] weekdays = instance2.getWeekdays();
            HashMap hashMap7 = new HashMap();
            hashMap7.put(1L, weekdays[2]);
            hashMap7.put(2, weekdays[3]);
            hashMap7.put(3L, weekdays[4]);
            hashMap7.put(4L, weekdays[5]);
            hashMap7.put(5L, weekdays[6]);
            hashMap7.put(6L, weekdays[7]);
            hashMap7.put(7L, weekdays[1]);
            hashMap6.put(TextStyle.FULL, hashMap7);
            HashMap hashMap8 = new HashMap();
            hashMap8.put(1L, weekdays[2].substring(0, 1));
            hashMap8.put(2, weekdays[3].substring(0, 1));
            hashMap8.put(3L, weekdays[4].substring(0, 1));
            hashMap8.put(4L, weekdays[5].substring(0, 1));
            hashMap8.put(5L, weekdays[6].substring(0, 1));
            hashMap8.put(6L, weekdays[7].substring(0, 1));
            hashMap8.put(7L, weekdays[1].substring(0, 1));
            hashMap6.put(TextStyle.NARROW, hashMap8);
            String[] shortWeekdays = instance2.getShortWeekdays();
            HashMap hashMap9 = new HashMap();
            hashMap9.put(1L, shortWeekdays[2]);
            hashMap9.put(2, shortWeekdays[3]);
            hashMap9.put(3L, shortWeekdays[4]);
            hashMap9.put(4L, shortWeekdays[5]);
            hashMap9.put(5L, shortWeekdays[6]);
            hashMap9.put(6L, shortWeekdays[7]);
            hashMap9.put(7L, shortWeekdays[1]);
            hashMap6.put(TextStyle.SHORT, hashMap9);
            return i(hashMap6);
        } else if (temporalField2 == ChronoField.AMPM_OF_DAY) {
            DateFormatSymbols instance3 = DateFormatSymbols.getInstance(locale);
            HashMap hashMap10 = new HashMap();
            String[] amPmStrings = instance3.getAmPmStrings();
            HashMap hashMap11 = new HashMap();
            hashMap11.put(0L, amPmStrings[0]);
            hashMap11.put(1L, amPmStrings[1]);
            hashMap10.put(TextStyle.FULL, hashMap11);
            hashMap10.put(TextStyle.SHORT, hashMap11);
            return i(hashMap10);
        } else if (temporalField2 == ChronoField.ERA) {
            DateFormatSymbols instance4 = DateFormatSymbols.getInstance(locale);
            HashMap hashMap12 = new HashMap();
            String[] eras = instance4.getEras();
            HashMap hashMap13 = new HashMap();
            hashMap13.put(0L, eras[0]);
            hashMap13.put(1L, eras[1]);
            hashMap12.put(TextStyle.SHORT, hashMap13);
            if (locale.getLanguage().equals(Locale.ENGLISH.getLanguage())) {
                hashMap13 = new HashMap();
                hashMap13.put(0L, "Before Christ");
                hashMap13.put(1L, "Anno Domini");
            }
            hashMap12.put(TextStyle.FULL, hashMap13);
            HashMap hashMap14 = new HashMap();
            hashMap14.put(0L, eras[0].substring(0, 1));
            hashMap14.put(1L, eras[1].substring(0, 1));
            hashMap12.put(TextStyle.NARROW, hashMap14);
            return i(hashMap12);
        } else if (temporalField2 != IsoFields.f31853b) {
            return "";
        } else {
            HashMap hashMap15 = new HashMap();
            HashMap hashMap16 = new HashMap();
            hashMap16.put(1L, "Q1");
            hashMap16.put(2, "Q2");
            hashMap16.put(3L, "Q3");
            hashMap16.put(4L, "Q4");
            hashMap15.put(TextStyle.SHORT, hashMap16);
            HashMap hashMap17 = new HashMap();
            hashMap17.put(1L, "1st quarter");
            hashMap17.put(2, "2nd quarter");
            hashMap17.put(3L, "3rd quarter");
            hashMap17.put(4L, "4th quarter");
            hashMap15.put(TextStyle.FULL, hashMap17);
            return i(hashMap15);
        }
    }

    private Object k(TemporalField temporalField, Locale locale) {
        Map.Entry h2 = h(temporalField, locale);
        Object obj = this.f31849b.get(h2);
        if (obj != null) {
            return obj;
        }
        this.f31849b.putIfAbsent(h2, j(temporalField, locale));
        return this.f31849b.get(h2);
    }

    public String c(TemporalField temporalField, long j2, TextStyle textStyle, Locale locale) {
        Object k2 = k(temporalField, locale);
        if (k2 instanceof LocaleStore) {
            return ((LocaleStore) k2).a(j2, textStyle);
        }
        return null;
    }

    public Iterator<Map.Entry<String, Long>> d(TemporalField temporalField, TextStyle textStyle, Locale locale) {
        Object k2 = k(temporalField, locale);
        if (k2 instanceof LocaleStore) {
            return ((LocaleStore) k2).b(textStyle);
        }
        return null;
    }
}
