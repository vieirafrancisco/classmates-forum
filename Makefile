run-api:
	cd ./api &&\
			mvn spring-boot:run

build-api:
	cd ./api &&\
			mvn install -DskipTests
run-app:
	cd ./front-end &&\
	npm i -g &&\
	npm run electron:serve

build-app:
	cd ./front-end &&\
			npm i -g &&\
			npm run electron:build
