package org.nsa.nlp.mystem.holding

import org.nsa.nlp.mystem.model.Info
import org.scalatest.FunSuite

class Factory$Test extends FunSuite{
  val f = new Factory()
  val p: MyStem = f.newMyStem("3.1").get

  test("grammar") {
    val value: Response = p.analyze(Request("РЕЛИЗ\nРоссии\nавиаударов\n95МС\nпозициям\nРакки\nподготовки\nзапрещенной\nуправления\nСогласно\nконтроля"))
    value.info.map({
      case Info(initial, lex, rawResponse) =>
        println(initial + "=" + lex)
        ""
      case _ =>
    })
  }
}
