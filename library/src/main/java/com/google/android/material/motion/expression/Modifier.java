/*
 * Copyright (C) 2016 The Material Motion Authors. All Rights Reserved.
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
package com.google.android.material.motion.expression;

import com.google.android.material.motion.runtime.Plan;

/**
 * A function object that represents a modification of {@link Plan Plans}.
 *
 * <p>
 * Your custom Term must pass an instance of this class into {@link Term#modify(Modifier)}.
 */
public abstract class Modifier {

  /**
   * Modifies the properties on the given {@link Plan Plans}.
   *
   * @param plans The Plans to modify. Do not add or remove elements from the array.
   */
  abstract void modify(Plan[] plans);

  /**
   * A helper class that makes it easy to implement a simple {@link Modifier} that does the
   * same operation for every {@link Plan}.
   */
  public static abstract class SimpleModifier extends Modifier {

    @Override
    public final void modify(Plan[] plans) {
      for (Plan plan : plans) {
        modify(plan);
      }
    }

    /**
     * Modifies the properties on the given {@link Plan}.
     *
     * @param plan The Plan to modify.
     */
    public abstract void modify(Plan plan);
  }
}
