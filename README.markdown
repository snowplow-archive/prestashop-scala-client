prestasac - a Scala library for accessing the PrestaShop Web Service.

prestasac (PrestaShop Scala API Client) allows you to access the PrestaShop Web Service from Scala. Learn more about the PrestaShop Web Service from the [Official Documentation](https://xxx) and the [CRUD Tutorial](chrome://downloads/home/alex/Downloads/CRUD%20Tutorial%20EN.pdf).

prestasac is a direct port of the official PrestaShop PHP API Client, PSWebServiceLibrary.php. We keep the latest version of this library in the /php folder for reference. As with PSWebServiceLibrary.php, prestasac is a thin wrapper around the PrestaShop Web Service: it takes care of making the call to your PrestaShop instance's Web Service, supports the Web Service's HTTP-based CRUD operations (handling any errors) and then returns the XML ready for you to work with in Scala.

To recap, the Web Service's available operations are as follows:

Operation|HTTP verb|Description 
Get|GET|Retrieves a resource
Add|POST|Adds a new resource
Edit|PUT|Updates an existing resource
Delete|DELETE|Deletes a resource
Head|HEAD|Retrieves a resource (check how this is different from Get) 

#Credits

Thanks to Prestashop SA for their work on PrestaShop and on the reference PHP library, PSWebServiceLibrary.php

#Installation

The latest build of prestasac is always available as a .jar from the Downloads dropdown in GitHub.

#Quick Start

First download and install the prestasac jar. Now fire up scala and load the jar into your classpath (changing the paths as appropriate):

    scala> :cp [YOUR JAR PATH HERE]/prestasac-0.0.1.jar

Now you can import the PrestaShopWebService class:

    scala> import co.orderly.prestasac.PrestaShopWebService

Create a PrestaShopWebService (changing your PrestaShop credentials):

### Rest of quick start still to write ###

#API Documentation

Documentation for the PrestaShop Web Service can be found on the PrestaShop wiki:
[PrestaShop Wiki](http://wiki.prestashop.com/display/enEN/Using+the+REST+webservice)

#Forking 

Forking from GitHub and making changes to the code is easy if you use sbt:

    git clone git://github.com/orderly/scalapac
    tar -xzvf commons-code-1.5-bin.tar.gz
    vi src/main/scala/example.scala
    << Update example.scala to have your own PrestaShop credentials >>     
    cd ..
    sbt
    > run

You should see prestasac compiling main sources, running ExampleOperations and then displaying some XML results.

#Copyright and License

prestasac is copyright (c) 2011 Alex Dean

prestasac is free software: you can redistribute it and/or modify
it under the terms of the GNU Affero General Public License as
published by the Free Software Foundation, either version 3 of
the License, or (at your option) any later version.

prestasac is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
GNU Affero General Public License for more details.

You should have received a copy of the GNU Affero General Public
License along with prestasac. If not, see [GNU licenses](http://www.gnu.org/licenses/).
