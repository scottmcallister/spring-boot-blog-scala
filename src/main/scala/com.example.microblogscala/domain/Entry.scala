package com.example.microblogscala.domain

import javax.persistence._

import scala.beans.BeanProperty


/**
  * Created by scottmcallister on 2017-07-19.
  */
@Entity
class Entry(t: String, c: String) extends Serializable {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @BeanProperty
  var id: Long = _

  @BeanProperty
  @Column(nullable = false)
  var title: String = t

  @BeanProperty
  @Column(nullable = false)
  var content: String = c

  def this() = {
    this(null, null)
  }

}

object Entry {
  def apply(title: String, content: String): Entry = {
    new Entry(title, content)
  }

  def unapply(arg: Entry): Option[(String, String)] = {
    Some(arg.title, arg.content)
  }
}
