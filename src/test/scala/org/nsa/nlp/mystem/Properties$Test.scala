package org.nsa.nlp.mystem

import java.net.URL

import org.scalatest.FunSuite

/**
 * alexeyev 
 * 31.08.14.
 */
class Properties$Test extends FunSuite {

  test("getting-download-url") {
    assert(Properties.getUrl("3.1", "win64") === new URL("http://download.cdn.yandex.net/mystem/mystem-3.1-win-64bit.zip"))
    assert(Properties.getUrl("3.1", "linux64") === new URL("http://download.cdn.yandex.net/mystem/mystem-3.1-linux-64bit.tar.gz"))

  }
}
