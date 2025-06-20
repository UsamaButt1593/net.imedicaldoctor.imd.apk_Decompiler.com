package com.google.gson;

import com.google.gson.internal.Streams;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.MalformedJsonException;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.util.Iterator;
import java.util.NoSuchElementException;

public final class JsonStreamParser implements Iterator<JsonElement> {
    private final Object lock;
    private final JsonReader parser;

    public JsonStreamParser(Reader reader) {
        JsonReader jsonReader = new JsonReader(reader);
        this.parser = jsonReader;
        jsonReader.setLenient(true);
        this.lock = new Object();
    }

    public boolean hasNext() {
        boolean z;
        synchronized (this.lock) {
            try {
                z = this.parser.peek() != JsonToken.END_DOCUMENT;
            } catch (MalformedJsonException e2) {
                throw new JsonSyntaxException((Throwable) e2);
            } catch (IOException e3) {
                throw new JsonIOException((Throwable) e3);
            } catch (Throwable th) {
                throw th;
            }
        }
        return z;
    }

    public JsonElement next() throws JsonParseException {
        if (hasNext()) {
            try {
                return Streams.parse(this.parser);
            } catch (StackOverflowError e2) {
                throw new JsonParseException("Failed parsing JSON source to Json", e2);
            } catch (OutOfMemoryError e3) {
                throw new JsonParseException("Failed parsing JSON source to Json", e3);
            }
        } else {
            throw new NoSuchElementException();
        }
    }

    public void remove() {
        throw new UnsupportedOperationException();
    }

    public JsonStreamParser(String str) {
        this((Reader) new StringReader(str));
    }
}
