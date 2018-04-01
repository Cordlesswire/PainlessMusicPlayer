/*
 * Copyright (C) 2018 Yaroslav Mytkalyk
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
package com.doctoror.fuckoffmusicplayer.data.lifecycle

abstract class ServiceLifecycleOwner {

    private val lifecycleObservers = mutableListOf<ServiceLifecycleObserver>()

    fun registerLifecycleObserver(observer: ServiceLifecycleObserver) {
        lifecycleObservers.add(observer)
    }

    fun onCreate() {
        lifecycleObservers.forEach { it.onCreate() }
    }

    fun onDestroy() {
        lifecycleObservers.forEach { it.onDestroy() }
        lifecycleObservers.clear()
    }
}