# 1 运行环境

## 1.1 采用docker方式运行

### 1.1.1 docker安装

​	docker安装见 https://store.docker.com/search?type=edition&offering=community

### 1.1.2 docker网络配置

查看网络

```shell
docker network ls # 查看网络
```

创建网络	

```shell
docker network create \
  --driver=bridge \
  --subnet=172.28.0.0/16 \
  --ip-range=172.28.1.1/24 \
  --gateway=172.28.1.254 \
  mynet 
```

删除网络

```shell
docker network rm mynet # 删除网段
```



## 1.2 端口及ip说明

### 1.2.1 注册中心

```
172.28.1.11
172.28.1.12
172.28.1.13

端口： 5000
```

### 1.2.2 API Gateway

```
172.28.1.20:8000
```

### 1.2.3 rder service

```
172.28.1.21
172.28.1.22
172.28.1.23

端口： 9001
```

### 1.2.4 user service

```
172.28.1.31
172.28.1.32
172.28.1.33

端口： 9002
```



# 2 服务启动

### 2.1 启动注册中心

节点1

```shell
docker run -it --rm -v /ez:/opt --net mynet --ip 172.28.1.11  --name registry_11 java:8u111 java -jar /opt/registry-server-1.0.0.jar --spring.profiles.active=peer1
```

节点2

```shell
docker run -it --rm -v /ez:/opt --net mynet --ip 172.28.1.12  --name registry_12 java:8u111 java -jar /opt/registry-server-1.0.0.jar --spring.profiles.active=peer2
```

节点3

```shell
docker run -it --rm -v /ez:/opt --net mynet --ip 172.28.1.13  --name registry_13 java:8u111 java -jar /opt/registry-server-1.0.0.jar --spring.profiles.active=peer3
```



### 2.2 启动order-service

节点1

```shell
docker run -it --rm -v /ez:/opt --net mynet --ip 172.28.1.21  --name order_21 java:8u111 java -jar /opt/order-service-1.0.0.jar --spring.profiles.active=peer1
```

节点2

```shell
docker run -it --rm -v /ez:/opt --net mynet --ip 172.28.1.22  --name order_22 java:8u111 java -jar /opt/order-service-1.0.0.jar --spring.profiles.active=peer2
```

节点3

```shell
docker run -it --rm -v /ez:/opt --net mynet --ip 172.28.1.23  --name order_23 java:8u111 java -jar /opt/order-service-1.0.0.jar --spring.profiles.active=peer3
```

### 2.3 启动user-service

节点1

```shell
docker run -it --rm -v /ez:/opt --net mynet --ip 172.28.1.31  --name user_31 java:8u111 java -jar /opt/user-service-1.0.0.jar --spring.profiles.active=peer1
```

节点2

```shell
docker run -it --rm -v /ez:/opt --net mynet --ip 172.28.1.32  --name user_32 java:8u111 java -jar /opt/user-service-1.0.0.jar --spring.profiles.active=peer2
```

节点3

```shell
docker run -it --rm -v /ez:/opt --net mynet --ip 172.28.1.33  --name user_33 java:8u111 java -jar /opt/user-service-1.0.0.jar --spring.profiles.active=peer3
```

### 2.4 启动API Gateway

```shell
docker run -it --rm -v /ez:/opt --net mynet --ip 172.28.1.20  --name gateway_20 java:8u111 java -jar /opt/api-gateway-1.0.0.jar
```



# 访问

http://172.28.1.20:8000/user/getUserPort

http://172.28.1.20:8000/user/getOrderPort

http://172.28.1.20:8000/order/getOrderPort