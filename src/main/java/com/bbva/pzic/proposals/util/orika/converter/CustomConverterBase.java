/*
 * Orika - simpler, better and faster Java bean mapping
 * 
 * Copyright (C) 2011 Orika authors
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.bbva.pzic.proposals.util.orika.converter;

import com.bbva.pzic.proposals.util.orika.metadata.TypeFactory;
import com.bbva.pzic.proposals.util.orika.MapperFacade;
import com.bbva.pzic.proposals.util.orika.metadata.Type;

import java.lang.reflect.ParameterizedType;

/**
 * CustomConverterBase provides a utility base for creating customized converters,
 * which determines type parameters automatically. <br><br>
 * <p/>
 * It is recommend to extend this class to create your own custom converters.
 *
 * @param <S> the source type
 * @param <D> the destination type
 * @author matt.deboer@gmail.com
 * @deprecated use {@link com.bbva.pzic.proposals.util.orika.CustomConverter} instead
 */
@Deprecated
public abstract class CustomConverterBase<S, D> implements Converter<S, D> {

    protected final Type<S> sourceType;
    protected final Type<D> destinationType;
    protected MapperFacade mapperFacade;

    public CustomConverterBase() {
        java.lang.reflect.Type genericSuperclass = getClass().getGenericSuperclass();
        if (genericSuperclass != null && genericSuperclass instanceof ParameterizedType) {
            ParameterizedType superType = (ParameterizedType) genericSuperclass;
            sourceType = TypeFactory.valueOf(superType.getActualTypeArguments()[0]);
            destinationType = TypeFactory.valueOf(superType.getActualTypeArguments()[1]);
        } else {
            throw new IllegalStateException("When you subclass the ConverterBase S and D type-parameters are required.");
        }
    }

    public boolean canConvert(Class<S> sourceClass, Class<? extends D> destinationClass) {
        return this.sourceType.getRawType().equals(sourceClass)
                && this.destinationType.getRawType().equals(destinationClass);
    }

    public boolean canConvert(Type<?> sourceClass, Type<?> destinationClass) {
        return this.sourceType.equals(sourceClass) && this.destinationType.equals(destinationClass);
    }

    public void setMapperFacade(MapperFacade mapperFacade) {
        this.mapperFacade = mapperFacade;
    }

    public Type<S> getAType() {
        return (Type<S>) sourceType;
    }

    public Type<D> getBType() {
        return (Type<D>) destinationType;
    }
}