package com.daojian

class Queue[T](private val leading: List[T],
               private val trailing: List[T]
              ) {
  private def mirror  =
    if(leading.isEmpty)
      new Queue(trailing.reverse, Nil)
    else
      this

  def head = mirror.leading.head

  def tail = {
    val q = mirror
    new Queue(q.leading.tail, q.trailing)
  }

  def append(x: T) = new Queue(leading, x :: trailing)
}

object Queue {
  def main(args: Array[String]): Unit = {
    val q = new Queue[Int](List.empty, List(6))
    val q2 = q.append(1).append(2).append(3)
    print(q2.head, q2.tail.leading)
  }
}
