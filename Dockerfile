FROM openjdk:17
VOLUME /tmp
COPY build/libs/order-service-1.0.jar JimartOrderService.jar
ENTRYPOINT ["java", "-jar", "-Dspring.profiles.active=dev", "JimartOrderService.jar"]