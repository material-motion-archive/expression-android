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

package com.google.android.material.motion.expression.sample;

import com.google.android.material.motion.expression.Initializer;
import com.google.android.material.motion.expression.Initializer.SimpleInitializer;
import com.google.android.material.motion.expression.Language;
import com.google.android.material.motion.expression.Modifier;
import com.google.android.material.motion.expression.Modifier.SimpleModifier;
import com.google.android.material.motion.expression.Term;
import com.google.android.material.motion.expression.Work;
import com.google.android.material.motion.runtime.Plan;

import android.support.annotation.Keep;

/**
 * Required:
 * Your custom class must extend {@link Term}. Your class must follow this specific type parameters
 * template:
 *
 * <ol>
 *   <li>
 *      Declare a type parameter T which extends itself.
 *      Pass T into the first type parameter of the superclass.
 *   </li>
 *   <li>Pass your custom {@link Language} into the second type parameter of the superclass.</li>
 * </ol>
 */
public final class CustomTerm<T extends CustomTerm<?>> extends Term<T, CustomLanguage> {

  /**
   * Required:
   * This is the initializing constructor for this {@link Term}.
   * Your {@link Initializer} must respect your subclass's Initializer, if it exists,
   * by passing it into the constructor.
   */
  CustomTerm(CustomLanguage language) {
    super(
        language,
        new SimpleInitializer(null) {
          @Override
          protected void initialize(Plan plan) {
            CustomPlan i = (CustomPlan) plan;
            i.text = "default";
          }
        },
        new CustomPlan());
  }

  /**
   * Required:
   * This is the chaining constructor for this {@link Term}.
   * It must be annotate with {@link Keep} and have the same parameter types as the superclass
   * so this can be invoked via reflection.
   */
  @Keep
  private CustomTerm(CustomLanguage language, Work work) {
    super(language, work);
  }

  /**
   * Optional:
   * One or more public methods for your custom modifiers.
   * The return type must be T to enable chaining.
   * Your implementation should call {@link #modify(Modifier)}.
   */
  public T modifier(final String text) {
    return modify(
        new SimpleModifier() {
          @Override
          public void modify(Plan plan) {
            CustomPlan i = (CustomPlan) plan;
            i.text = text;
          }
        });
  }
}
