package com.trachoma.boot.converter;

import com.trachoma.boot.bean.Person;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;

import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

/**
 * @author Administrator
 * @create 2022-02-20 3:21
 */
public class TrachomaConverter implements HttpMessageConverter<Person> {
    @Override
    public boolean canRead(Class<?> clazz, MediaType mediaType) {
        return false;
    }

    @Override
    public boolean canWrite(Class<?> clazz, MediaType mediaType) {
        return clazz.isAssignableFrom(Person.class);
    }

    /**
     * 该MessageConvert写出的内容类型
     * application/x-trachoma
     * @return
     */
    @Override
    public List<MediaType> getSupportedMediaTypes() {
        return MediaType.parseMediaTypes("application/x-trachoma");
    }

    @Override
    public Person read(Class<? extends Person> clazz, HttpInputMessage inputMessage) throws IOException, HttpMessageNotReadableException {
        return null;
    }

    @Override
    public void write(Person person, MediaType contentType, HttpOutputMessage outputMessage) throws IOException, HttpMessageNotWritableException {
        // 自定义协议数据的写出
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(person.getUserName()).append(";")
                .append(person.getAge()).append(";")
                .append(person.getBirth()).append(";")
                .append(person.getPet());
        OutputStream body = outputMessage.getBody();
        body.write(stringBuilder.toString().getBytes());
    }
}
