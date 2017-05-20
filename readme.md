## Beschreibung

Dieses Projekt ist ein Beispiel Projekt f�r die Verwendung von Selenium Webdriver, welches im Rahmen 
von "EMQ und QUS - Entwicklungsmethoden und Qualit�tssicherung" im Themenbereich "Web-Test" verwendet werden kann.
Dazu wird im Folgenden die Installation sovie Verwendung beschrieben.

## Ben�tigte Software
Um das Projekt installieren und starten zu k�nnen wird folgendes ben�tigt.
1. [Apache Maven](https://maven.apache.org/) 
2. Java JDK 1.8

## Installation

Das Beispielprojekt kann entweder �ber CMD oder in einer Entwicklungsumgebung installiert werden.
�ber CMD muss zum Projektordner navigiert werden, wo auch die Pom.xml liegt und folgendes Kommando ausgef�hrt werden.
`mvn install`
In einer Entwicklungsumgebung kann das Projekt als ein Mavenprojekt eingebunden werden und dort als `mvn install` ausgef�hrt werden. Dabei werden die ben�tigten Dependencies heruntergeladen, wie die verschiedenen Webdriver und andere Bibliotheken.

## Benutzung
Da bei der Installation die ausf�hrbaren Dateien der einzelnen Webdriver f�r das jeweilige System heruntergeladen werden, m�ssen diese, um diese Verwenden zu k�nnen in den Ordner \target\resources kopiert werden. Die einzelnen ausf�hrbaren Dateien der Webdriver sind auch in Unterordnern in \target\resources zu finden.


In der Klasse src\test\java\emq\webdriver\example\AbstractEMQ kann der zu benutzende Webdriver, also Chrome, Firefox und weitere ausgew�hlt werden.

```
/**
* Definiert den zu verwenden Webdriver
*/
@BeforeClass
public static void setDriver() {
	ConfigDrivers conf = new ConfigDrivers();
	driver = conf.getChrome();
	driver.manage().window().maximize();
}
```
In diesem Codebeispiel wird der Webdriver f�r Google Chrome verwendet, was durch `driver = conf.getChrome();`
definiert wird.
Die folgenden Webdriver k�nnen momentan durch die ConfigDrivers Klasse verwendet werden:
* getFirefox();  --> F�r Firefox
* getChrome();   --> F�r Google Chrome

Every Testcase needs to extends the AbstractEMQ class in order to use the webdriver




