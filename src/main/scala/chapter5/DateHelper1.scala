/*
 * Copyright 2017 pragmatic-scala.reactiveplatform.xyz
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import scala.language.implicitConversions
import java.time.LocalDate

class DateHelper(offset: Int) {
  def days(when: String) = {
    val today = LocalDate.now
    when match {
      case "ago"      ⇒ today.minusDays(offset)
      case "from_now" ⇒ today.plusDays(offset)
      case _          ⇒ today
    }
  }
}

implicit def convertInt2DateHelper(offset: Int): DateHelper = new DateHelper(offset)

val ago = "ago"
val from_now = "from_now"

val past = 2 days ago
val appointment = 5 days from_now

println(past)
println(appointment)
