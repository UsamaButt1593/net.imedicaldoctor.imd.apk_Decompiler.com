package com.google.gson;

import com.google.gson.internal.NonNullElementWrapperList;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class JsonArray extends JsonElement implements Iterable<JsonElement> {
    private final ArrayList<JsonElement> elements;

    public JsonArray() {
        this.elements = new ArrayList<>();
    }

    private JsonElement getAsSingleElement() {
        int size = this.elements.size();
        if (size == 1) {
            return this.elements.get(0);
        }
        throw new IllegalStateException("Array must have size 1, but has size " + size);
    }

    public void add(JsonElement jsonElement) {
        if (jsonElement == null) {
            jsonElement = JsonNull.INSTANCE;
        }
        this.elements.add(jsonElement);
    }

    public void addAll(JsonArray jsonArray) {
        this.elements.addAll(jsonArray.elements);
    }

    public List<JsonElement> asList() {
        return new NonNullElementWrapperList(this.elements);
    }

    public boolean contains(JsonElement jsonElement) {
        return this.elements.contains(jsonElement);
    }

    public JsonArray deepCopy() {
        if (this.elements.isEmpty()) {
            return new JsonArray();
        }
        JsonArray jsonArray = new JsonArray(this.elements.size());
        Iterator<JsonElement> it2 = this.elements.iterator();
        while (it2.hasNext()) {
            jsonArray.add(it2.next().deepCopy());
        }
        return jsonArray;
    }

    public boolean equals(Object obj) {
        return obj == this || ((obj instanceof JsonArray) && ((JsonArray) obj).elements.equals(this.elements));
    }

    public JsonElement get(int i2) {
        return this.elements.get(i2);
    }

    public BigDecimal getAsBigDecimal() {
        return getAsSingleElement().getAsBigDecimal();
    }

    public BigInteger getAsBigInteger() {
        return getAsSingleElement().getAsBigInteger();
    }

    public boolean getAsBoolean() {
        return getAsSingleElement().getAsBoolean();
    }

    public byte getAsByte() {
        return getAsSingleElement().getAsByte();
    }

    @Deprecated
    public char getAsCharacter() {
        return getAsSingleElement().getAsCharacter();
    }

    public double getAsDouble() {
        return getAsSingleElement().getAsDouble();
    }

    public float getAsFloat() {
        return getAsSingleElement().getAsFloat();
    }

    public int getAsInt() {
        return getAsSingleElement().getAsInt();
    }

    public long getAsLong() {
        return getAsSingleElement().getAsLong();
    }

    public Number getAsNumber() {
        return getAsSingleElement().getAsNumber();
    }

    public short getAsShort() {
        return getAsSingleElement().getAsShort();
    }

    public String getAsString() {
        return getAsSingleElement().getAsString();
    }

    public int hashCode() {
        return this.elements.hashCode();
    }

    public boolean isEmpty() {
        return this.elements.isEmpty();
    }

    public Iterator<JsonElement> iterator() {
        return this.elements.iterator();
    }

    public JsonElement remove(int i2) {
        return this.elements.remove(i2);
    }

    public JsonElement set(int i2, JsonElement jsonElement) {
        ArrayList<JsonElement> arrayList = this.elements;
        if (jsonElement == null) {
            jsonElement = JsonNull.INSTANCE;
        }
        return arrayList.set(i2, jsonElement);
    }

    public int size() {
        return this.elements.size();
    }

    public JsonArray(int i2) {
        this.elements = new ArrayList<>(i2);
    }

    public void add(Boolean bool) {
        this.elements.add(bool == null ? JsonNull.INSTANCE : new JsonPrimitive(bool));
    }

    public boolean remove(JsonElement jsonElement) {
        return this.elements.remove(jsonElement);
    }

    public void add(Character ch) {
        this.elements.add(ch == null ? JsonNull.INSTANCE : new JsonPrimitive(ch));
    }

    public void add(Number number) {
        this.elements.add(number == null ? JsonNull.INSTANCE : new JsonPrimitive(number));
    }

    public void add(String str) {
        this.elements.add(str == null ? JsonNull.INSTANCE : new JsonPrimitive(str));
    }
}
