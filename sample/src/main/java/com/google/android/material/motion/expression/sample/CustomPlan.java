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

import android.widget.TextView;

import com.google.android.material.motion.runtime.Performer;
import com.google.android.material.motion.runtime.Plan;

/**
 * Required:
 * Your custom class must extend {@link Plan}.
 *
 * Optional:
 * Your custom class may implement any optional Plan APIs by implementing one or more
 * <code>*Plan</code> interfaces.
 */
public final class CustomPlan extends Plan<TextView> {

  /**
   * Optional:
   * How you implement your {@link Plan} is up to you.
   */
  public String text;

  /**
   * Required:
   * Your custom {@link Plan} must declare a {@link Performer} that can execute it.
   */
  @Override
  public Class<? extends Performer<TextView>> getPerformerClass() {
    return CustomPerformer.class;
  }
}
