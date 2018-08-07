# 服务启动

## 1 单点方式

### 1.1 启动注册中心

```shell
java -jar registry-center-1.0.0.jar
```

### 1.2 启动order-service

```shell
java -jar order-service-1.0.0.jar
```

### 1.3 启动user-service

```shell
java -jar user-service-1.0.0.jar
```

### 1.4 启动API Gateway

```shell
java -jar api-gateway-1.0.0.jar
```



## 2 高可用多节点方式

### 2.1 启动注册中心

```shell
java -jar registry-center-1.0.0.jar --spring.profiles.active=peer1
java -jar registry-center-1.0.0.jar --spring.profiles.active=peer2
java -jar registry-center-1.0.0.jar --spring.profiles.active=peer3
```

### 2.2 启动order-service

```shell
java -jar order-service-1.0.0.jar --spring.profiles.active=peer1
java -jar order-service-1.0.0.jar --spring.profiles.active=peer2
java -jar order-service-1.0.0.jar --spring.profiles.active=peer3
```

### 2.3 启动user-service

```shell
java -jar user-service-1.0.0.jar --spring.profiles.active=peer1
java -jar user-service-1.0.0.jar --spring.profiles.active=peer2
java -jar user-service-1.0.0.jar --spring.profiles.active=peer3
```

### 2.4 启动API Gateway

```shell
java -jar api-gateway-1.0.0.jar
```



# 访问

http://localhost:8000/user/getUserPort
http://localhost:8000/user/getOrderPort
http://localhost:8000/order/getOrderPort