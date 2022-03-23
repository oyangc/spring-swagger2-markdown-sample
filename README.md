# swagger2生成markdown

## 1、生成swagger文档
pom.xml加入
```xml
<!-- Swagger-->
<dependency>
    <groupId>io.springfox</groupId>
    <artifactId>springfox-swagger2</artifactId>
    <version>2.9.2</version>
</dependency>
<dependency>
    <groupId>io.springfox</groupId>
    <artifactId>springfox-swagger-ui</artifactId>
    <version>2.9.2</version>
</dependency>
```

```java
@Bean
public Docket docket() {
   return new Docket(DocumentationType.SWAGGER_2)
                 .apiInfo(apiInfo())
                 /*		扫描接口配置		*/
                 .select()
                 .apis(RequestHandlerSelectors.basePackage("com.oyangc.swaggersample.comtroller"))
                 .paths(PathSelectors.ant("/**"))
                 .build();
                  /*		扫描接口配置		*/
}
```
启动服务之后可以访问
http://localhost:8080/swagger-ui.html

做好了Swagger的配置，有相关的接口内容，开始生成markdown。
## 2、生成markdown文档
### 方式一、java swagger-ui基础上，使用swagger2markup代码生成文档
pom.xml加入
```xml
<dependency>
    <groupId>io.github.swagger2markup</groupId>
    <artifactId>swagger2markup</artifactId>
    <version>1.3.3</version>
    <scope>test</scope>
</dependency>
<dependency>
    <groupId>org.springframework.restdocs</groupId>
    <artifactId>spring-restdocs-mockmvc</artifactId>
    <version>2.0.3.RELEASE</version>
    <scope>test</scope>
</dependency>
<dependency>
    <groupId>io.springfox</groupId>
    <artifactId>springfox-staticdocs</artifactId>
    <version>2.6.1</version>
    <scope>test</scope>
</dependency>
```

- 1、运行测试类SwaggerToMarkdownTest中的swaggerGenMd方法，直接生成当前工程的md文档
- 2、运行测试类SwaggerToMarkdownTest中的mdByUrl方法，通过制定url生成md文档

### 方式二、使用npm的swagger-markdown生成markdown
官网：https://www.npmjs.com/package/swagger-markdown

http://localhost:8080/swagger-ui.html

方式一、在线json生成markdown
复制http://localhost:8080/v2/api-docs 内容
使用https://swagger-markdown-ui.netlify.app/ 生成md文件

方式二、本地安装swagger-markdown
复制http://localhost:8080/v2/api-docs内容
在线json转成yml（https://www.bejson.com/json/json2yaml/）
存到本地文件test.yml

安装：swagger-markdown
$ npm install -g swagger-markdown
生成md文件
$ swagger-markdown -i test.yml -o test.md
或
$ swagger-markdown.cmd -i test.yml -o test.md

完成。


直接使用方式一方式即可。