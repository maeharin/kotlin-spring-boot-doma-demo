# Kotlin demo application using Spring Boot & Doma2

run db (postgresql with docker)

```
$ docker-machine start
$ eval $(docker-machine env default)
$ docker-compose up
```

run app (kotlin with Spring Boot & Doma2)

```
$ source .env.dev
$ ./gradlew clean bootRun
```

http://localhost:8080
