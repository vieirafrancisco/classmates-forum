run-api:
	cd ./api &&\
	mvn install -DskipTests &&\
	mvn spring-boot:run

run-app:
	cd ./front-end &&\
	npm i -g &&\
	npm run electron:serve