## Deploying
1. Download project from gitHub
2. Configure rabbit mq server properties in [rabbit mq config file](docker-compose.yml)
3. Configure application properties in [application config file](src/main/resources/application.yml)
4. Run rabit mq server in docker container
```bash
    docker-compose up
```
5. Execute command 
```bash
    ./mvnw install dockerfile:build
```
6. Run generated image 
```bash
   docker run -p 8080:8080 {image name}
```
Note: Use --net="host" option if you use "localhost" in yours application properties