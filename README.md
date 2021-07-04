# project-airline
After running the project : 

1. H2 in memory : http://localhost:8080/h2
2. Swagger ui : http://localhost:8080/swagger-ui/index.html

1->Create market 
2->create destination ,airplain(in the market already) and aircraft.
3->add destination to market 


Folders : 
1. DOMAIN : The objects that create the base for the system : 
 - Aircraft objecct
 - Airrline
 - Distance : lan,lon and name of position . 
 - market :Singleton Where airline and distance list's supose to be
 - typeDest - enum class with two types .
 
2.Exception class: If object id isn't found in the service it throw's unique exception .

3.DTO class - holds the data from controller and make the conncetion between the layers .

4.Repository : class to encapsulate and retriev the data we collected. 

5.Controllers: mapping - post\get\delete the data. 


