package org.bots4j.utils.json;

/*
 * Copyright (C) 2016 Adam J Chesney
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import com.google.api.client.json.gson.GsonFactory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by ajchesney on 13/04/2016.
 */
public class GsonUtils {

    /**
     * Serialize object to json string
     */
    public static String toJson(Object obj){
        try {
            return GsonFactory.getDefaultInstance().toString(obj);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Deserialize from json string to object
     */
    public static <E> E fromJson(String json, Class<E> targetType){
        try {
            return GsonFactory.getDefaultInstance().createJsonParser(json).parse(targetType);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Convert the given json array into an ArrayList containing items of the given type
     */
    public static <E> List<E> fromJsonArray(String json, Class<E> targetItemType){
        try {
            ArrayList<E> result = new ArrayList<>();
            GsonFactory.getDefaultInstance().createJsonParser(json).parseArray(result,targetItemType);
            return result;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }



    /**
     * Use Gson to convert the given object into the required type
     * by serializing to JSON and then deserialising into a new object of the
     * given type
     */
    public static <E> E convertIfRequired(Object obj, Class<E> targetType) {
        if ( obj == null ){
            return null;
        }
        if ( targetType.isAssignableFrom( obj.getClass() ) ){
            return (E) obj;
        }
        else{
            return fromJson(toJson(obj),targetType);
        }
    }

    /**
     * Convert a JSON array into an ArrayList of objects of the required type
     */
    public static <E> List<E> convertArrayToList(Object obj, Class<E> targetItemType) {
        if ( obj == null ){
            return null;
        }
        return fromJsonArray(toJson(obj),targetItemType);
    }
}
