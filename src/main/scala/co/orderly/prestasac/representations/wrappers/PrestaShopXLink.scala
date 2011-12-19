package co.orderly.prestasac.representations.wrappers

// JAXB
import javax.xml.bind.annotation._

// Narcolepsy
import orderly.narcolepsy._

@XmlAccessorType(XmlAccessType.FIELD)
class PrestaShopXLink extends Representation {

  @XmlAttribute // ID is an attribute not a field
  @BeanProperty
  var id: Long = _

  @BeanProperty // Within the xlink namespace
  var href: String = _
}
