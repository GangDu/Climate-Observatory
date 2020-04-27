package observatory

import Extraction.{locateTemperatures, locationYearlyAverageRecords}
import Visualization.{visualize, colorsList}

object Main extends App {
  val year: Year = 2015
  val stationsFile: String = "/stations.csv"
  val temperaturesFile: String = "/2015.csv"

  val records = locateTemperatures(year, stationsFile, temperaturesFile)
  val results = locationYearlyAverageRecords(records).take(300)
  println(s"=====================$year==========================")

//  val myImg = visualize(results, colorsList)
//  myImg.output(new java.io.File("target/my-image.png"))

  val yearlyData = Seq((year, results))
  Interaction.generateTiles(yearlyData, Interaction.generateImage)

}
