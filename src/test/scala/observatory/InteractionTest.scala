package observatory

import scala.collection.concurrent.TrieMap
import org.junit.Assert._
import org.junit.Test
import Interaction._

trait InteractionTest extends MilestoneSuite {
  private val milestoneTest = namedMilestoneTest("interactive visualization", 3) _

}
