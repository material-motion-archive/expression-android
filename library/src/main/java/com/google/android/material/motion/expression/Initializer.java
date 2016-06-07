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

import android.support.annotation.Nullable;

/**
 * A function object that represents an initialization of {@link Intention Intentions}.
 *
 * <p>
 * Similar to {@link Modifier}, but allows each {@link Term} subclass to provide its own
 * {@link Initializer} to the superclass.
 *
 * <p>
 * Your custom Term must pass an instance of this class into
 * {@link Term#Term(Language, Initializer, Intention...)}.
 */
public abstract class Initializer {
  @Nullable private final Initializer subclassInitializer;

  /**
   * Creates a new {@link Initializer}.
   *
   * @param subclassInitializer If your subclass provides an Initializer, pass it in here.
   */
  public Initializer(@Nullable Initializer subclassInitializer) {
    this.subclassInitializer = subclassInitializer;
  }

  final void fullInitialize(Intention[] intentions) {
    initialize(intentions);
    if (subclassInitializer != null) {
      subclassInitializer.fullInitialize(intentions);
    }
  }

  /**
   * Initializes the properties on the given {@link Intention Intentions}.
   *
   * @param intentions The Intentions to initialize. Do not add or remove elements from the array.
   */
  protected abstract void initialize(Intention[] intentions);

  /**
   * A helper class that makes it easy to implement a simple {@link Initializer} that does the
   * same operation for every {@link Intention}.
   */
  public static abstract class SimpleInitializer extends Initializer {

    /**
     * Creates a new {@link SimpleInitializer}.
     *
     * @param subclassInitializer If your subclass provides an Initializer, pass it in here.
     */
    public SimpleInitializer(@Nullable Initializer subclassInitializer) {
      super(subclassInitializer);
    }

    @Override
    protected final void initialize(Intention[] intentions) {
      for (Intention intention : intentions) {
        initialize(intention);
      }
    }

    /**
     * Initializes the properties on the given {@link Intention}.
     *
     * @param intention The Intention to initialize.
     */
    protected abstract void initialize(Intention intention);
  }
}
