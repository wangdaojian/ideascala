package com.daojian

import java.io

import scala.io.Source
import scala.reflect.io.File

object LongLines {
  def processFile(filename: String, width: Int) = {
    val source = Source.fromFile(filename)
    for (line <- source.getLines())
      processLine(filename, width, line)
  }

  private def processLine(filename: String,
                          width: Int, line: String) = {

    if (line.length > width)
      println(filename + ": " + line.trim)
  }

  def main(args: Array[String]): Unit = {
      val width = args(0).toInt
      println(args.toList)
      println(args.drop(1).toList)
      //println(new io.File(".").listFiles().toList)
      for (arg <- args.drop(1))
        LongLines.processFile(arg, width)
  }
}
