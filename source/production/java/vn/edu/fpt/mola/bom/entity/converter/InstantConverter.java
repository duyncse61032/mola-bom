package vn.edu.fpt.mola.bom.entity.converter;

import java.sql.Timestamp;
import java.time.Instant;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter
public class InstantConverter implements AttributeConverter<Instant, Timestamp>
{

    @Override
    public Timestamp convertToDatabaseColumn(Instant instant)
    {
        return instant == null ? null : new Timestamp(instant.toEpochMilli());
    }

    @Override
    public Instant convertToEntityAttribute(Timestamp timestamp)
    {
        return timestamp == null ? null : Instant.ofEpochMilli(timestamp.getTime());
    }

}
