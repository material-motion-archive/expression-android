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

import com.google.android.material.motion.runtime.Performer;
import com.google.android.material.motion.runtime.Performer.PlanPerformance;
import com.google.android.material.motion.runtime.Plan;

import android.widget.TextView;

/**
 * Required:
 * Your custom class must extend {@link Performer}.
 *
 * Optional:
 * Your custom class may implement any optional Performer APIs by implementing one or more
 * <code>*Performance</code> interfaces.
 */
public final class CustomPerformer extends Performer implements PlanPerformance {

  /**
   * Required:
   * Implement any optional Performer APIs you declared support for.
   */
  @Override
  public void addPlan(Plan plan) {
    CustomPlan customPlan = (CustomPlan) plan;
    TextView target = getTarget();

    CharSequence prev = target.getText();
    target.setText(prev + (prev == "" ? "" : ", ") + customPlan.text);
  }
}
