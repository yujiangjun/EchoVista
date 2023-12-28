# EchoVista
调查之翼


### 使用`@EnableDiscoveryClient`完成读取k8s集群的service列表
1. 首先在集群内创建discoveryServer服务 
   具体清单文件如下


```yaml
---
apiVersion: v1
kind: List
items:
  - apiVersion: v1
    kind: Service
    metadata:
      labels:
        app: spring-cloud-kubernetes-discoveryserver
      name: spring-cloud-kubernetes-discoveryserver
    spec:
      ports:
        - name: http
          port: 80
          targetPort: 8761
      selector:
        app: spring-cloud-kubernetes-discoveryserver
      type: ClusterIP
  - apiVersion: v1
    kind: ServiceAccount
    metadata:
      labels:
        app: spring-cloud-kubernetes-discoveryserver
      name: spring-cloud-kubernetes-discoveryserver
  - apiVersion: rbac.authorization.k8s.io/v1
    kind: RoleBinding
    metadata:
      labels:
        app: spring-cloud-kubernetes-discoveryserver
      name: spring-cloud-kubernetes-discoveryserver:view
    roleRef:
      kind: Role
      apiGroup: rbac.authorization.k8s.io
      name: namespace-reader
    subjects:
      - kind: ServiceAccount
        name: spring-cloud-kubernetes-discoveryserver
  - apiVersion: rbac.authorization.k8s.io/v1
    kind: Role
    metadata:
      namespace: default
      name: namespace-reader
    rules:
      - apiGroups: ["", "extensions", "apps"]
        resources: ["services", "endpoints","deployments","pods"]
        verbs: ["get", "list", "watch"]
  - apiVersion: apps/v1
    kind: Deployment
    metadata:
      name: spring-cloud-kubernetes-discoveryserver-deployment
    spec:
      selector:
        matchLabels:
          app: spring-cloud-kubernetes-discoveryserver
      template:
        metadata:
          labels:
            app: spring-cloud-kubernetes-discoveryserver
        spec:
          serviceAccount: spring-cloud-kubernetes-discoveryserver
          containers:
          - name: spring-cloud-kubernetes-discoveryserver
            image: springcloud/spring-cloud-kubernetes-discoveryserver:3.0.0-SNAPSHOT
            imagePullPolicy: IfNotPresent
            readinessProbe:
              httpGet:
                port: 8761
                path: /actuator/health/readiness
            livenessProbe:
              httpGet:
                port: 8761
                path: /actuator/health/liveness
            ports:
            - containerPort: 8761
```
2. 开启discover Server 集群外访问
3. 在自己项目里的application.yaml\propertie 文件中开启如下配置
    ```yaml
   spring:
    cloud:
      kubernetes:
        discovery:
          enabled: true
          discovery-server-url: http://127.0.0.1:14567/
   ```
   4. 在自己的代码中就可以注入自己`DiscoveryClient`
       ```java
      @RestController
       @RequestMapping("/")
       @Slf4j
       @AllArgsConstructor
       public class IndexController {

       private final DiscoveryClient discoveryClient;

       private final MyConfig myConfig;

       @GetMapping("/getServices")
       public List<String> getServiceList(){
           String description = discoveryClient.description();
           log.info("description:{}",description);
           return discoveryClient.getServices();
       }

       @GetMapping("/getCm")
       public String getCm(){
           log.info("description:{}",myConfig.getMessage());
           return myConfig.getMessage();
       }
       }
5. 请求接口就可以看到了对应的k8s里的接口列表
   