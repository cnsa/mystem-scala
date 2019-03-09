package org.nsa.tools

import java.io.{IOException, File, FileOutputStream}

import org.apache.commons.compress.archivers.ArchiveInputStream
import org.apache.commons.io.IOUtils
import org.nsa.nlp.mystem.Properties

/**
 * alexeyev 
 * 11.09.14.
 */
trait Decompressor {

  def traditionalExtension: String

  def unpack(src: File, dst: File): File

  @throws(classOf[IOException])
  private[tools] def copyUncompressedAndClose(stream: ArchiveInputStream, dest: File): File = {
    // must be read
    val entry = stream.getNextEntry
    if (entry.isDirectory)
      throw new IOException("Decompressed entry is a directory (unexpectedly)")

    val os = new FileOutputStream(dest)

    try {
      IOUtils.copy(stream, os)
    } finally {
      os.close()
      stream.close()
    }
    dest
  }
}

object Decompressor {
  def select: Decompressor =
    if (Properties.CurrentOs.contains("win")) Zip else TarGz
}