package vn.edu.fpt.mola.bom.entity.view;

import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.modelmapper.ModelMapper;


public abstract class BaseEntityView<E> implements EntityView<E>
{
    private static final Logger log = LogManager.getLogger();
    
    protected final Class<E> entityClass;

    public BaseEntityView()
    {
        Type genericSuperclass = this.getClass().getGenericSuperclass();
        while(!(genericSuperclass instanceof ParameterizedType)) {
            if(!(genericSuperclass instanceof Class)) {
                throw new IllegalStateException();
            }
            if(!(genericSuperclass == BaseEntityView.class)) {
                throw new IllegalStateException();
            }
            genericSuperclass = ((Class)genericSuperclass).getGenericSuperclass();
        }
        
        ParameterizedType type = (ParameterizedType) genericSuperclass;
        Type[] arguments = type.getActualTypeArguments();
        this.entityClass = (Class<E>)arguments[0];
    }

    @Override
    public E toEntity()
    {
        ModelMapper modelMapper = new ModelMapper();
        E entity = modelMapper.map(this, entityClass);
        return entity;
    }
    
    @Override
    public void updateEntity(E entity)
    {
        E newEntity = toEntity();
        
        try {
            for(PropertyDescriptor pd : 
                Introspector.getBeanInfo(entityClass).getPropertyDescriptors()){

                String name = pd.getName();
                Object value = pd.getReadMethod().invoke(newEntity);
                // propertyEditor.getReadMethod() exposes the getter
                // btw, this may be null if you have a write-only property
                log.debug(name + ": " + value);
                if(value == null) {  
                } else if("id".equals(name)) {
                    
                } else if (value.getClass().isArray()) {
                    log.debug("Array " + name + ": " + value);
                }
            }
        } catch (IntrospectionException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
