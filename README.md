# rest-api

<h3> Aufgabenstellung: </h3>

Erstellen Sie ein Programm, das die Daten aus der CSV-Datei einliest und über einen REST-Endpoint zur Verfügung stellt. Der Endpunkt soll mit der Abkürzung einer Betriebsstelle angefragt werden und die Daten der Betriebsstelle als JSON-Objekt zurück liefern.

<h3> Beschreibung  </h3>
Die Rest-Api liest Informationen bezüglich Betriebsstellen der DB mittels einer CSV Datei ein <br>
und gibt den HTTP-Status sowie diese Informationen in JSON Format wieder.

<h3> Ausführung  </h3>
java -jar /path/db_project/rest-service.jar
curl https://localhost:8080/betriebsstelle/{Abkürzung der Betriebsstelle} <br>

Groß-/Kleinschreibung bei der Betriebsstelle unwichtig.
