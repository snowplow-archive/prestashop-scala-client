package co.orderly.prestasac.representations.wrappers

// Java
import java.util.{List => JList}

// Scala
import scala.collection.mutable.{Buffer, ArrayBuffer}
import scala.collection.JavaConversions._

// JAXB
import javax.xml.bind.annotation._

// Narcolepsy
import orderly.narcolepsy._

@XmlRootElement(name = "product")
@XmlAccessorType(XmlAccessType.FIELD)
class ProductXLink extends PrestaShopXLink

@XmlType(name = "")
@XmlRootElement(name = "products")
class ProductList extends RepresentationWrapper[ProductLink] {

  private var products: Buffer[ProductLink] = ArrayBuffer[ProductLink]()

  @XmlElement(name = "product", required = true)
  def getProducts: JList[ProductLink] = this.products

  def setProducts(products: JList[ProductLink]) {
    this.products = products
  }

  def toList: List[ProductLink] = this.products.toList

  def fromList(merchants: List[ProductLink]) {
    this.products = arrayBufferFromList[ProductLink](products)
  }
}
