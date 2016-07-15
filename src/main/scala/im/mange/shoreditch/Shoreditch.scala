package im.mange.shoreditch

import im.mange.shoreditch.api._
import im.mange.shoreditch.api.liftweb.EnhancedRestHelper._

//TODO: should be no api.liftweb deps in here
case class Shoreditch[Service](base: String,
                               version: String,
                               longName: String,
                               alias: String,
                               checksEnabled: Boolean = true,
                               actionsEnabled: Boolean = true,
                               routes: Seq[Route[Service]])

//TODO: ultimate rename Shoreditch and have one import
object Shoreditch2 {
  implicit class CheckRouteBuildingString(val path: String) extends AnyVal {
    def action(f:                ⇒ Action): Route[Service] = POST0("action/" + path)(f)
    def check(f:                 ⇒ Check): Route[Service]  = GET0("check/" + path)(f)
    def check(f: (String)        ⇒ Check): Route[Service]  = GET1("check/" + path)(f)
    def check(f: (String,String) ⇒ Check): Route[Service]  = GET2("check/" + path)(f)
  }
}
