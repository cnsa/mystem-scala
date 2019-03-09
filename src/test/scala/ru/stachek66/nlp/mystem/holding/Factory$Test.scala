package ru.stachek66.nlp.mystem.holding

import org.scalatest.FunSuite
import ru.stachek66.nlp.mystem.model.Info

class Factory$Test extends FunSuite{
  val f = new Factory()
  val p: MyStem = f.newMyStem("3.0").get

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
