package observatory

import java.time.LocalDate

import org.junit.Assert._
import org.junit.Test
import observatory.Extraction._

trait ExtractionTest extends MilestoneSuite {
  private val milestoneTest = namedMilestoneTest("data extraction", 1) _

  // Implement tests for the methods of the `Extraction` object
  def testLocateTemperatures(): Unit = {
    val year: Year = 2015
    val stationsFile: String = "/testStations.csv"
    val temperaturesFile: String = "/test2015.csv"
    val out = locateTemperatures(year, stationsFile, temperaturesFile)
    val expect = Seq(
      (LocalDate.of(2015, 8, 11), Location(37.35, -78.433), 27.3),
      (LocalDate.of(2015, 12, 6), Location(37.358, -78.438), 0.0),
      (LocalDate.of(2015, 1, 29), Location(37.358, -78.438), 2.0)
    )
    assert(assertion = true, s"output $out\n, expect $expect\n")
  }

  @Test def testLocationYearlyAverageRecords(): Unit = {
    val input = Seq(
      (LocalDate.of(2015, 8, 11), Location(37.35, -78.433), 27.3),
      (LocalDate.of(2015, 12, 6), Location(37.358, -78.438), 0.0),
      (LocalDate.of(2015, 1, 29), Location(37.358, -78.438), 2.0)
    )
    val out = locationYearlyAverageRecords(input)
    val expect = Seq(
      (Location(37.35, -78.433), 27.3),
      (Location(37.358, -78.438), 1.0)
    )
    assert(out == expect, s"your output $out\n, expect $expect\n")
  }

  def testLocateTemperaturesRunningTime(): Unit = {
    val year: Year = 2015
    val stationsFile: String = "/stations.csv"
    val temperaturesFile: String = "/2015.csv"

    val records = locateTemperatures(year, stationsFile, temperaturesFile)
    val results = locationYearlyAverageRecords(records)
  }

}
