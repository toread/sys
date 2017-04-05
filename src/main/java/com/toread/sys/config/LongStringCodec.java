package com.toread.sys.config;

import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.JSONLexer;
import com.alibaba.fastjson.parser.JSONToken;
import com.alibaba.fastjson.parser.deserializer.ObjectDeserializer;
import com.alibaba.fastjson.serializer.JSONSerializer;
import com.alibaba.fastjson.serializer.ObjectSerializer;
import com.alibaba.fastjson.serializer.SerializeWriter;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.util.TypeUtils;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @author 黎志兵
 */
public class LongStringCodec implements ObjectSerializer, ObjectDeserializer {
  public static LongStringCodec instance = new LongStringCodec();

  public void write(JSONSerializer serializer, Object object, Object fieldName, Type fieldType, int features) throws IOException {
    SerializeWriter out = serializer.out;

    if (object == null) {
      out.writeNull(SerializerFeature.WriteNullNumberAsZero);
    } else {
      long value = ((Long) object).longValue();
      out.write(String.valueOf(value));
    }
  }

  @SuppressWarnings("unchecked")
  public <T> T deserialze(DefaultJSONParser parser, Type clazz, Object fieldName) {
    final JSONLexer lexer = parser.lexer;

    Long longObject;
    if (lexer.token() == JSONToken.LITERAL_STRING) {
      String longValue = lexer.stringVal();
      lexer.nextToken(JSONToken.COMMA);
      longObject = Long.valueOf(longValue);
    } else {
      Object value = parser.parse();
      if (value == null) {
        return null;
      }
      longObject = TypeUtils.castToLong(value);
    }

    return clazz == AtomicLong.class //
            ? (T) new AtomicLong(longObject.longValue()) //
            : (T) longObject;
  }

  public int getFastMatchToken() {
    return JSONToken.LITERAL_STRING;
  }
}
