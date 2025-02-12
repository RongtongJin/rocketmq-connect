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
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */

package org.apache.rocketmq.connect.runtime.utils.datasync;

import org.apache.rocketmq.connect.runtime.utils.Callback;


/**
 * Synchronize data between workers in a same cluster.
 * @param <K>
 * @param <V>
 */
public interface DataSynchronizer<K, V> {

    /**
     * Start the synchronizer.
     */
    void start();

    /**
     * Stop the synchronizer.
     */
    void stop();

    /**
     * Send data to all workers.
     * @param key
     * @param value
     */
    void send(K key, V value);

    /**
     * send data to all workers
     * @param key
     * @param value
     * @param callback
     */
    void send(K key, V value, Callback callback);
}
