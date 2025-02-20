+ 个人Springboot web项目配置，方便快速开发

---

### 功能说明
#### 1.请求拦截
+ 请求拦截使用的是springboot的拦截器处理，默认拦截所有请求(除了swagger)，可在`/config/InterceptorConfig`中修改配置

#### 2.全局异常处理
+ 只要发生异常，都会经过全局异常处理，接口返回错误信息，可以`/handler/GlobalExceptionHandler`中修改配置
+ 配置了相应的业务异常类`/execption/BusinessExecption`，可以抛出业务异常，进行业务异常处理

#### 3.字段自动填充
+ 数据库表的实体类默认继承`/bean/BaseEntity`，携带**CreateTime**和**UpdateTime**两个参数，建表的时候也应创建这两个字段
+ 因为整合MP的字段自动填充，在数据新增or更新时会自动填补上当前时间，所以业务处理时无需处理这两个参数（仅限调用mp接口，自己手写的sql不触发mp字段自动填充）
+ 若要关闭字段自动填充，可修改`/handler/MybatisFieldFillHandler`

#### 4.请求防抖处理
+ 通过拦截器`/common/interceptor/RepeatRequestInterceptor.java`，拦截所有请求。对get请求，或没有注解`@RepeatLimit`标记的接口，则不进行拦截，直接放行
