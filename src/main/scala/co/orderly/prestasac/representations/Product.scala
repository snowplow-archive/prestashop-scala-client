package co.orderly.prestasac.representations

// Java
import java.util.{Date => JDate}

// Scala
import scala.reflect.BeanProperty

// JAXB
import javax.xml.bind.annotation._

// Narcolepsy
import orderly.narcolepsy._

/**
 * Product representation holds the information pertaining to a
 * product in the PrestaShop catalogue.
 *
 * This is a placeholder for now.
 */
@XmlRootElement(name = "product")
@XmlAccessorType(XmlAccessType.FIELD)
class Product extends Representation {

  @BeanProperty
  var title: String = _

  @XmlElement(nillable = true)
  @BeanProperty
  var merchantRef: String = _

  @XmlElement(nillable = true)
  @BeanProperty
  var gtin: String = _
}
