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

import android.support.annotation.IntDef;
import android.support.annotation.Nullable;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Locale;

/**
 * An {@link Expression} is a chain of {@link Intention} definitions. Expressions are immutable,
 * and can be built upon with chaining to create longer Expressions.
 *
 * <p>
 * Start an Expression by creating an instance of a {@link Language}.
 *
 * <p>
 * An Expression chain alternates between a Language and a {@link Term}.
 * A representative Expression chain looks like:
 * <p>
 * <code>
 *   Language                                               &larr;<sub>new</sub>&larr;
 *   <span style='text-decoration:line-through'>Term</span> &larr;<sub>modify</sub>&larr;
 *   Term                                                   &larr;<sub>and</sub>&larr;
 *   Language                                               &larr;<sub>new</sub>&larr;
 *   Term
 * </code>
 *
 * <p>
 * For more details, see the javadoc for Language and Term.
 */
public abstract class Expression {

  /**
   * A {@link RuntimeException} that is thrown when an {@link Expression} subclass cannot be
   * instantiated via reflection due to a bad implementation of its required constructors.
   */
  static class BadImplementationException extends RuntimeException {

    static final int MISSING_CONSTRUCTOR = 0;

    @IntDef({MISSING_CONSTRUCTOR})
    @Retention(RetentionPolicy.SOURCE)
    @interface Reason {}

    BadImplementationException(Expression expression, @Reason int reason, Throwable throwable) {
      super(createMessage(expression, reason), throwable);
    }

    @Nullable
    private static String createMessage(Expression expression, @Reason int reason) {
      switch (reason) {
        case MISSING_CONSTRUCTOR:
          return String.format(
              Locale.US,
              "%s does not correctly implement a chaining constructor with the required "
                  + "parameters, or did not annotate it with @Keep. See the constructor javadoc "
                  + "for Language or Term.",
              expression.getClass().getName());
      }

      return null;
    }
  }
}
