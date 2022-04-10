<details>
  <summary>JPA 시작하기</summary>
  
# 라이브러리 추가
- `pom.xml`(Maven)
- Java11 기준
    
```xml
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>
    <groupId>jpa-basic</groupId>
    <artifactId>ex1-hello-jpa</artifactId>
    <version>1.0.0</version>
    <build>
        <plugins>
            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-compiler-plugin</artifactId>
                <configuration>
                    <source>11</source>
                    <target>11</target>
                </configuration>
            </plugin>
        </plugins>
    </build>
    <dependencies>
        <!-- JPA 하이버네이트 -->
        <dependency>
            <groupId>org.hibernate</groupId>
            <artifactId>hibernate-entitymanager</artifactId>
            <version>5.6.7.Final</version>
        </dependency>
        <!-- H2 데이터베이스 -->
        <dependency>
            <groupId>com.h2database</groupId>
            <artifactId>h2</artifactId>
            <version>2.1.210</version>
        </dependency>
        <dependency>
            <groupId>javax.xml.bind</groupId>
            <artifactId>jaxb-api</artifactId>
            <version>2.3.1</version>
        </dependency>
    </dependencies>
</project>
```

# JPA 설정하기
- `src/main/resources/META-INF/persistence.xml`
- persistence-unit name 으로 이름 지정
    
```xml
<?xml version="1.0" encoding="UTF-8"?>
<persistence version="2.2"
             xmlns="http://xmlns.jcp.org/xml/ns/persistence" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
             xsi:schemaLocation="http://xmlns.jcp.org/xml/ns/persistence http://xmlns.jcp.org/xml/ns/persistence/persistence_2_2.xsd">
    <persistence-unit name="hello">
        <properties>
            <!-- 필수 속성 -->
            <property name="javax.persistence.jdbc.driver" value="org.h2.Driver"/>
            <property name="javax.persistence.jdbc.user" value="sa"/>
            <property name="javax.persistence.jdbc.password" value=""/>
            <property name="javax.persistence.jdbc.url" value="jdbc:h2:tcp://localhost/~/test"/>
            <property name="hibernate.dialect" value="org.hibernate.dialect.H2Dialect"/>
            <!-- 옵션 -->
            <property name="hibernate.show_sql" value="true"/>
            <property name="hibernate.format_sql" value="true"/>
            <property name="hibernate.use_sql_comments" value="true"/>
            <!--<property name="hibernate.jdbc.batch_size" value="10"/>-->
            <!--<property name="hibernate.hbm2ddl.auto" value="create" />-->
        </properties>
    </persistence-unit>
</persistence>
```
    
# DB Dialect
    
```xml
<property name="hibernate.dialect" value="org.hibernate.dialect.H2Dialect"/>
```
    
- JPA는 어플리케이션이 직접 JDBC 레벨에서 SQL을 작성하는 것이 아니라 JPA가 직접 SQL을 작성하고 실행하는 형태이다.
- 각각의 DB가 제공하는 SQL 문법과 함수가 조금씩 다르다.
- JPA에서는 이를 Dialect라는 추상화된 클래스를 제공하고 각 벤더에 맞는 구현체를 제공한다.
- 따라서, 원하는 Dialect만 설정해주면 그에 맞는 쿼리를 생성한다.

<img width="604" alt="image" src="https://user-images.githubusercontent.com/46523628/161376160-14be49bb-58c1-4d7e-9613-426dafcff85c.png">


# JPA 구동 방식
- `EntityManagerFactory`는 하나만 생성해서 애플리케이션 전체에서 공유된다.
- `EntityManager`는 쓰레드간에 공유되지 않는다.
- JPA의 모든 데이터 변경은 `트랜잭션` 안에서 실행된다.
    
<img width="635" alt="image" src="https://user-images.githubusercontent.com/46523628/161376186-3f654a97-e431-4d6c-b235-acaee8e0231c.png">


# 객체와 테이블 매핑
- `@Entitiy`: JPA가 관리할 객체 
- `@Id`: 데이터베이스 PK와 매핑

```java
 import javax.persistence.Entity;
 import javax.persistence.Id;
 
 @Entity
 public class Member {
   @Id
   private Long id;
   private String name;

}
```
    
# JPQL
- JPA를 사용하면 Entity 객체를 중심으로 개발하게 되는데, 검색 시에도 테이블이 아닌 Entity 객체를 대상으로 검색하게 된다.
- JPA는 SQL을 추상화한 JPQL이라는 객체 지향 쿼리 언어를 제공한다.
</details>

