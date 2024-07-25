# Cache aside patterns 

## About 
This project contain example implementations cache aside pattern using [Spring Data Redis.](https://spring.io/projects/spring-data-redis)\
Use case for this project is inspired by [this redis tutorial article.](https://redis.io/learn/howtos/solutions/microservices/caching) 
## Getting Started
### Pre-setup
Make sure you have installed the following on your machine:
* [Docker](https://docs.docker.com/engine/install/)
### Running the application
1. From the root of this repository, go to cache-aside dir
 ```bash
    cd cache-aside
```
2. Build application jar
 ```bash
    mvn clean install -DskipTests
```
3. Build application image
 ```bash
    docker build --tag cache-aside-patterns .
```
3. Run application and it's dependencies
 ```bash
    docker compose up
```