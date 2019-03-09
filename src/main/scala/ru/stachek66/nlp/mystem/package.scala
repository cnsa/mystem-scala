package ru.stachek66.nlp

import org.slf4j.{Logger, LoggerFactory}

/**
 * alexeyev
 * 11.09.14.
 */
package object mystem {

  private var log: Logger = LoggerFactory.getLogger(getClass)

  def setLogger(logger: Logger): Unit = {
    log = logger
  }

  val os: Map[(String, String), String] = Map(
    ("Linux", "x86_64") -> "linux64",
    ("Linux", "amd64") -> "linux64",
    ("Linux", "x86") -> "linux32",
    ("Windows7", "x86") -> "win32",
    ("Mac OS X", "x86_64") -> "osx"
  ) withDefault {
    _ =>
      log.warn("Getting default binaries!")
      "win64"
  }
}
