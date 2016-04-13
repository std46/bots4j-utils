package org.bots4j.utils.json;/*
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

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by ajchesney on 13/04/2016.
 */
public class FlexibleMapTest {

    @Test
    public void testGetAs(){

        FlexibleMap map = new FlexibleMap();
        ExampleObject exampleObject = new ExampleObject().setName("harry").setCount(11);
        map.put("exampleObject", exampleObject);

        ExampleContainer container = new ExampleContainer().setType("example").setContext(map);

        String json = GsonUtils.toJson(container);

        ExampleContainer result = GsonUtils.fromJson(json,ExampleContainer.class);

        ExampleObject eo = result.getContext().getAs("exampleObject", ExampleObject.class);

        assertEquals("harry",eo.getName());
        assertEquals(11l,(long)eo.getCount());
    }

    @Test
    public void testGetAsList(){

        FlexibleMap map = new FlexibleMap();
        List<ExampleObject> list = new ArrayList<>();
        list.add(new ExampleObject().setName("one"));
        list.add(new ExampleObject().setName("two"));
        map.put("list", list);

        ExampleContainer container = new ExampleContainer().setType("example").setContext(map);

        String json = GsonUtils.toJson(container);

        ExampleContainer result = GsonUtils.fromJson(json,ExampleContainer.class);

        List<ExampleObject> exampleList = result.getContext().getAsList("list", ExampleObject.class);
        assertEquals(2,exampleList.size());
        assertEquals("one",exampleList.get(0).getName());
        assertEquals("two",exampleList.get(1).getName());
    }


}
