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

import com.google.android.material.motion.expression.Language;
import com.google.android.material.motion.expression.Term;

import android.support.annotation.Keep;
import android.support.annotation.NonNull;

/**
 * Required:
 * Your custom class must extend {@link Language}, passing in itself as the type parameter.
 */
public final class CustomLanguage extends Language<CustomLanguage> {

  /**
   * Required:
   * This is the initializing constructor for this {@link Language}.
   */
  public CustomLanguage() {
    super();
  }

  /**
   * Required:
   * This is the chaining constructor for this {@link Language}.
   * It must be annotate with {@link Keep} and have the same parameter types as the superclass
   * so this can be invoked via reflection.
   */
  @Keep
  private CustomLanguage(@NonNull Term<?, CustomLanguage> previousTerm) {
    super(previousTerm);
  }

  /**
   * Optional:
   * One or more methods for your custom {@link Term Terms}. Always pass in this {@link Language}
   * so it can be provided to the Term base class.
   * The return value should be the most specific type possible, and must be a generic type if
   * possible.
   */
  public CustomTerm<?> term() {
    return new CustomTerm<>(this);
  }
}
