package ch.makery.cozypod.view

import ch.makery.cozypod.model.Library
import ch.makery.cozypod.MainApp
import scalafx.scene.control.{_}
import scalafxml.core.macros.sfxml
import scalafx.beans.property.{StringProperty} 
import scalafx.Includes._
import scalafx.event.ActionEvent
import java.io.File
import scalafx.collections.ObservableBuffer
import scalafx.scene.control.ListView

@sfxml
class LibraryController{
  
  val libraryShow = new Library

  object LibraryList {

    val libraryListView = new ListView[String]
    libraryListView.getItems().add(libraryShow.library.toString)
  }

  def handleCancel() = {
    MainApp.showCozyPodPlayer
  }
  
  def handlePlaySelection() = {
   } 
}