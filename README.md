## Microservices with docker:

Create docker file:
	
	FROM openjdk:8-jdk-alpine
	ADD target/*.jar <jar_name>.jar
	ENTRY_POINT ["java","-jar", "<jar_name>.jar"]

* To integrate it with maven do:
    * `ADD maven/*.jar <jar_name>.jar`
    * Add maven dependency in the `pom.xml` in the `build/plugins` section and change the `username/project` in the image name
    * Build the docker image
        * `$directory/ mvn docker:build`
    * Package the docker image
        * `$directory/ mvn package docker:build`
    * Push the image:
        * `$directory/ mvn docker:push`
    * Or run everything with one single command
        * `$directory/ mvn package docker:build docker:push`

	If anything, relate here: **https://dmp.fabric8.io/**

Build docker image:
`$directory/ docker build . -t <docker_user>/<project_name>`

**Publish docker image:** 

`$directory/ docker build . -t <docker_user>/<project_name>`

`docker run -d -p8080:8080 <docker_user>/<project_name>`

* `-d` runs it as a daemon in the background