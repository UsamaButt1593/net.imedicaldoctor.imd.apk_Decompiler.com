package com.google.gson;

import com.google.gson.internal.LazilyParsedNumber;
import com.google.gson.stream.JsonReader;
import java.io.IOException;
import java.math.BigDecimal;

public enum ToNumberPolicy implements ToNumberStrategy {
    DOUBLE {
        public Double readNumber(JsonReader jsonReader) throws IOException {
            return Double.valueOf(jsonReader.nextDouble());
        }
    },
    LAZILY_PARSED_NUMBER {
        public Number readNumber(JsonReader jsonReader) throws IOException {
            return new LazilyParsedNumber(jsonReader.nextString());
        }
    },
    LONG_OR_DOUBLE {
        /* JADX WARNING: Code restructure failed: missing block: B:10:0x0020, code lost:
            r2 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:13:0x0026, code lost:
            if (r7.isLenient() == false) goto L_0x0029;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:14:0x0028, code lost:
            return r2;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:16:0x0049, code lost:
            throw new com.google.gson.stream.MalformedJsonException("JSON forbids NaN and infinities: " + r2 + "; at path " + r7.getPreviousPath());
         */
        /* JADX WARNING: Code restructure failed: missing block: B:18:0x006a, code lost:
            throw new com.google.gson.JsonParseException("Cannot parse " + r1 + "; at path " + r7.getPreviousPath(), r2);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:5:?, code lost:
            r2 = java.lang.Double.valueOf(r1);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:6:0x0017, code lost:
            if (r2.isInfinite() == false) goto L_0x0019;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:8:0x001d, code lost:
            if (r2.isNaN() != false) goto L_0x001f;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:4:0x000f */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public java.lang.Number readNumber(com.google.gson.stream.JsonReader r7) throws java.io.IOException, com.google.gson.JsonParseException {
            /*
                r6 = this;
                java.lang.String r0 = "; at path "
                java.lang.String r1 = r7.nextString()
                long r2 = java.lang.Long.parseLong(r1)     // Catch:{ NumberFormatException -> 0x000f }
                java.lang.Long r7 = java.lang.Long.valueOf(r2)     // Catch:{ NumberFormatException -> 0x000f }
                return r7
            L_0x000f:
                java.lang.Double r2 = java.lang.Double.valueOf(r1)     // Catch:{ NumberFormatException -> 0x0020 }
                boolean r3 = r2.isInfinite()     // Catch:{ NumberFormatException -> 0x0020 }
                if (r3 != 0) goto L_0x0022
                boolean r3 = r2.isNaN()     // Catch:{ NumberFormatException -> 0x0020 }
                if (r3 == 0) goto L_0x0028
                goto L_0x0022
            L_0x0020:
                r2 = move-exception
                goto L_0x004a
            L_0x0022:
                boolean r3 = r7.isLenient()     // Catch:{ NumberFormatException -> 0x0020 }
                if (r3 == 0) goto L_0x0029
            L_0x0028:
                return r2
            L_0x0029:
                com.google.gson.stream.MalformedJsonException r3 = new com.google.gson.stream.MalformedJsonException     // Catch:{ NumberFormatException -> 0x0020 }
                java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ NumberFormatException -> 0x0020 }
                r4.<init>()     // Catch:{ NumberFormatException -> 0x0020 }
                java.lang.String r5 = "JSON forbids NaN and infinities: "
                r4.append(r5)     // Catch:{ NumberFormatException -> 0x0020 }
                r4.append(r2)     // Catch:{ NumberFormatException -> 0x0020 }
                r4.append(r0)     // Catch:{ NumberFormatException -> 0x0020 }
                java.lang.String r2 = r7.getPreviousPath()     // Catch:{ NumberFormatException -> 0x0020 }
                r4.append(r2)     // Catch:{ NumberFormatException -> 0x0020 }
                java.lang.String r2 = r4.toString()     // Catch:{ NumberFormatException -> 0x0020 }
                r3.<init>((java.lang.String) r2)     // Catch:{ NumberFormatException -> 0x0020 }
                throw r3     // Catch:{ NumberFormatException -> 0x0020 }
            L_0x004a:
                com.google.gson.JsonParseException r3 = new com.google.gson.JsonParseException
                java.lang.StringBuilder r4 = new java.lang.StringBuilder
                r4.<init>()
                java.lang.String r5 = "Cannot parse "
                r4.append(r5)
                r4.append(r1)
                r4.append(r0)
                java.lang.String r7 = r7.getPreviousPath()
                r4.append(r7)
                java.lang.String r7 = r4.toString()
                r3.<init>(r7, r2)
                throw r3
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.gson.ToNumberPolicy.AnonymousClass3.readNumber(com.google.gson.stream.JsonReader):java.lang.Number");
        }
    },
    BIG_DECIMAL {
        public BigDecimal readNumber(JsonReader jsonReader) throws IOException {
            String nextString = jsonReader.nextString();
            try {
                return new BigDecimal(nextString);
            } catch (NumberFormatException e2) {
                throw new JsonParseException("Cannot parse " + nextString + "; at path " + jsonReader.getPreviousPath(), e2);
            }
        }
    }
}
