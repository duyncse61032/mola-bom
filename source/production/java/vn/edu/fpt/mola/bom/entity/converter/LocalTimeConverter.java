package vn.edu.fpt.mola.bom.entity.converter;

import java.sql.Time;
import java.time.LocalTime;

import javax.persistence.AttributeConverter;

public class LocalTimeConverter implements AttributeConverter<LocalTime, Time>
{

    @Override
    public Time convertToDatabaseColumn(LocalTime localTime)
    {
        return localTime == null ? null : Time.valueOf(localTime);
    }

    @Override
    public LocalTime convertToEntityAttribute(Time time)
    {
        return time == null ? null : time.toLocalTime();
    }

}
