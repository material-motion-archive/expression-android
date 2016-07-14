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

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.google.android.material.motion.expression.Term;
import com.google.android.material.motion.runtime.Plan;
import com.google.android.material.motion.runtime.Scheduler;
import com.google.android.material.motion.runtime.Transaction;

/**
 * Material Motion Android Expression Sample {@link AppCompatActivity}.
 */
public class MainActivity extends AppCompatActivity {

  private final Scheduler scheduler = new Scheduler();

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    setContentView(R.layout.main_activity);

    findViewById(R.id.start)
        .setOnClickListener(
            new OnClickListener() {
              @Override
              public void onClick(View v) {
                runDemos();
              }
            });

    runDemos();
  }

  private void runDemos() {
    textDemo();
  }

  private void textDemo() {
    TextView text1 = (TextView) findViewById(R.id.text1);
    TextView text2 = (TextView) findViewById(R.id.text2);
    TextView text3 = (TextView) findViewById(R.id.text3);
    TextView text4 = (TextView) findViewById(R.id.text4);
    TextView text5 = (TextView) findViewById(R.id.text5);

    text1.setText("");
    text2.setText("");
    text3.setText("");
    text4.setText("");
    text5.setText("");

    CustomLanguage exp1 = new CustomLanguage();
    CustomTerm<?> exp2 = exp1.term();
    CustomTerm<?> exp3 = exp2.modifier("foobar");
    CustomTerm<?> exp4 = exp2.modifier("baz");
    CustomTerm<?> exp5 = exp3.and.term().modifier("qux").and.term().and.term().and.term();

    // Can't call plans() on exp1 since it's not a Term.
    // executeText(exp1, text1); // nothing
    executeText(exp2, text2); // default
    executeText(exp3, text3); // foobar
    executeText(exp4, text4); // baz
    executeText(exp5, text5); // foobar, qux, default, default, default
  }

  private void executeText(Term term, TextView text) {
    Transaction transaction = new Transaction();

    Plan[] plans = term.plans();
    for (Plan plan : plans) {
      transaction.addPlan(plan, text);
    }

    scheduler.commitTransaction(transaction);
  }
}
