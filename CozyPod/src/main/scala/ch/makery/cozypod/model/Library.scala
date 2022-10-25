package ch.makery.cozypod.model

import scalafx.beans.property.{StringProperty, IntegerProperty, ObjectProperty}
import java.io.File
import java.io._
import scalafx.scene.media.{Media, MediaPlayer, MediaView}

class Library {

    /*File handling method adapted from 
    "How to list files in a directory in Scala (and filter the list)"
    from Scala Cookbook by Alvin Alexander*/

    def library = new File("./src/main/resources/ch/makery/cozypod/library").listFiles
}
