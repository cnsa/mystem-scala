package org.nsa.nlp.mystem.parsing

import org.scalatest.FunSuite

/**
 * alexeyev 
 * 01.09.14.
 */
class GrammarInfoParsing$Test extends FunSuite {

    test("g-i-p-t-королевский") {
      val testString = "A=acc,sg,plen,m,inan"
      import org.nsa.nlp.mystem.parsing.GrammarInfoParsing._
      assert(toGrammarInfo(testString) === toGrammarInfo(toStringRepresentation(toGrammarInfo(testString))))
    }
}
