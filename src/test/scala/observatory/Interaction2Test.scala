package observatory

import org.junit.Assert._
import org.junit.Test

trait Interaction2Test extends MilestoneSuite {
  private val milestoneTest = namedMilestoneTest("interactive user interface", 6) _

  val layer: Signal[Layer] = Signal(Layer(LayerName.Temperatures, Seq(), 1975 to 2015))

  // Implement tests for methods of the `Interaction2` object
  @Test def testYearSelection(): Unit = {
    for (year <- 1900 to 2025) {
      val in = Signal(year)
      val out = Interaction2.yearSelection(layer, in)
      val expect = Signal(
        if (year < 1975) 1975
        else if (year > 2015) 2015
        else year
      )
      assert(out() == expect(), s"output: ${out()}, expect: ${expect()}")
    }
  }
}
