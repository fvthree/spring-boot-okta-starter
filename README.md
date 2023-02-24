# spring-boot-okta-starter

to run:

mvn clean install -DskipTests

run mysql using docker-desktop:

docker run --detach --env MYSQL_ROOT_PASSWORD=password12 --env MYSQL_USER=mysql-user --env MYSQL_PASSWORD=dummypassword --env MYSQL_DATABASE=starter --name mysqlstarter --publish 3306:3306 mysql:8.0

then:

docker container run -p 8080:8080 --link=mysqlstarter -e RDS_HOSTNAME=mysqlstarter  starter/spring-boot-okta-starter:0.0.1-SNAPSHOT
