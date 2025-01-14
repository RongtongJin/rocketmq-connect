/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.rocketmq.connect.runtime.converter;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;

public class ListConverterTest {

    private ListConverter listConverter = new ListConverter(Object.class);


    @Test
    public void objectToByteTest() {
        List<String> list = new ArrayList<>();
        list.add("Hello World");
        final byte[] bytes = listConverter.objectToByte(list);
        Assert.assertEquals("[\"Hello World\"]", new String(bytes));
    }

    @Test
    public void byteToObjectTest() {
        List<String> list = new ArrayList<>();
        list.add("Hello World");
        final List actual = listConverter.byteToObject(JSON.toJSONBytes(list));
        Assert.assertEquals("[Hello World]", actual.toString());

    }

}
