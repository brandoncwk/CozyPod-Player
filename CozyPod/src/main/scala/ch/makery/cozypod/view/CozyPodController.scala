 package ch.makery.cozypod.view

import ch.makery.cozypod.MainApp
import ch.makery.cozypod.model.Library
import scalafx.scene.control.{TableView, TableColumn, Label, Alert}
import scalafxml.core.macros.sfxml
import scalafx.beans.property.{StringProperty} 
import scalafx.Includes._
import scalafx.event.ActionEvent
import java.io._
import java.io.File
import scalafx.scene.media.{Media, MediaPlayer, MediaView}
import javafx.scene.{media => jfxsm}

@sfxml
class CozyPodController(){
    var i :Int = _
    val libraryPlay = new Library

    MediaPlayer.mediaPlayer.volume = 100

  //Create singleton object such that only one instance of MediaPlayer may run
  object MediaPlayer {
    var audio = new Media(libraryPlay.library(i).toURI().toString())
    var mediaPlayer = new MediaPlayer(audio)
  }

 //Controls for CozyPod Player
  def Stop(){
    MediaPlayer.mediaPlayer.stop()
  }

  def handlePlay(){
    MediaPlayer.mediaPlayer.getMedia
    MediaPlayer.mediaPlayer.play() 
  }

  def handlePause(){
    MediaPlayer.mediaPlayer.getMedia
    MediaPlayer.mediaPlayer.pause();
  }

  def handlePrevious(){
    if (i > 0) {
      i -= 1
      Stop()
      MediaPlayer.audio = new Media(libraryPlay.library(i).toURI().toString())
      MediaPlayer.mediaPlayer = new MediaPlayer(MediaPlayer.audio)
      MediaPlayer.mediaPlayer.play()
    } 
    else {
      Stop()
      i = libraryPlay.library.length - 1
      MediaPlayer.audio = new Media(libraryPlay.library(i).toURI().toString())
      MediaPlayer.mediaPlayer = new MediaPlayer(MediaPlayer.audio)
      MediaPlayer.mediaPlayer.play()
    } 
  }

  def handleNext(){
    if (i < libraryPlay.library.length - 1) {
      i += 1
      Stop()
      MediaPlayer.audio = new Media(libraryPlay.library(i).toURI().toString())
      MediaPlayer.mediaPlayer = new MediaPlayer(MediaPlayer.audio)
      MediaPlayer.mediaPlayer.play()
    } 
    else {
      Stop()
      i = 0
      MediaPlayer.audio = new Media(libraryPlay.library(i).toURI().toString())
      MediaPlayer.mediaPlayer = new MediaPlayer(MediaPlayer.audio)
      MediaPlayer.mediaPlayer.play()
    } 
  }

  def handleArtwork(){}

  def handleLibrary(){
    MainApp.showLibrary()
  }
}  