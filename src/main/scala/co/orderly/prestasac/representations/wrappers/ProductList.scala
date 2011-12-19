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
class ProductList extends RepresentationWrapper[ProductXLink] {

  private var products: Buffer[ProductXLink] = ArrayBuffer[ProductXLink]()

  @XmlElement(name = "product", required = true)
  def getProducts: JList[ProductXLink] = this.products

  def setProducts(products: JList[ProductXLink]) {
    this.products = products
  }

  def toList: List[ProductXLink] = this.products.toList

  def fromList(products: List[ProductXLink]) {
    this.products = arrayBufferFromList[ProductXLink](products)
  }
}
