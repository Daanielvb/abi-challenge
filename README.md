# abi-challenge
Lightweight APIs to store vehicles and delivery orders. Also capable of
ranking the best vehicles per delivery order


# Docker usage
1-Package the project jar with gradlew
```shell 
./gradlew build && java -jar build/libs/abi-challenge.jar
```
2-Build the docker image
```shell
docker build --build-arg JAR_FILE=build/libs/abi-challenge-0.1.0.jar -t abichallenge-docker .
```
3-Run the image with docker 
```shell
docker run abichallenge-docker
```
