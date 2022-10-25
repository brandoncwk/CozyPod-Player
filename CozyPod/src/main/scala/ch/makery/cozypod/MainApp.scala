package ch.makery.cozypod

import scalafx.application.JFXApp
import scalafx.application.JFXApp.PrimaryStage
import scalafx.scene.Scene
import scalafx.Includes._
import scalafxml.core.{NoDependencyResolver, FXMLView, FXMLLoader}
import javafx.{scene => jfxs}
import scalafx.scene.media.{Media, MediaPlayer, MediaView}
import javafx.scene.image.Image
import java.io._
import java.io.File

import ch.makery.cozypod.model.Library
import ch.makery.cozypod.view.CozyPodController
import ch.makery.cozypod.view.LibraryController
import scalafx.scene.control.{ListView}

import scalafx.scene.control.{Button}

/*
Portions of this code adapted from 'AddressApp' application
by code.makery and Dr. Chin Teck Min 
*/

object MainApp extends JFXApp {  

  // transform path of RootLayout.fxml to URI for resource location.
  val rootResource = getClass.getResource("view/RootLayout.fxml")
  // initialize the loader object.
  val loader = new FXMLLoader(rootResource, NoDependencyResolver)
  // Load root layout from fxml file.
  loader.load();
  // retrieve the root component BorderPane from the FXML 
  val roots = loader.getRoot[jfxs.layout.BorderPane]
  // initialize stage
  stage = new PrimaryStage {
    title = "CozyPod Player"
    scene = new Scene {
      root = roots
    }

  }

  // Actions for showing CozyPod Player window 
  def showCozyPodPlayer() = {
    val resource = getClass.getResource("view/CozyPodPlayer.fxml")
    val loader = new FXMLLoader(resource, NoDependencyResolver)
    loader.load();
    val roots = loader.getRoot[jfxs.layout.AnchorPane]
    this.roots.setCenter(roots)
  }

  // Actions for showing CozyPod Player window 
  def showLibrary() = {
    val resource = getClass.getResource("view/Library.fxml")
    val loader = new FXMLLoader(resource, NoDependencyResolver)
    loader.load();
    val roots = loader.getRoot[jfxs.layout.AnchorPane]
    this.roots.setCenter(roots)
    val control = loader.getController[LibraryController#Controller]
  }

// call to display CozyPod Player
showCozyPodPlayer()
}
