# JUnit5
## 의존성 추가
maven dependency
```xml
<dependency>
    <groupId>org.junit.jupiter</groupId>
    <artifactId>junit-jupiter-engine</artifactId>
    <version>5.1.0</version>
    <scope>test</scope>
</dependency>
```

gradle dependency
~~~gradle
testCompile group: 'org.junit.jupiter', name: 'junit-jupiter-api', version: '5.1.0'
~~~
주의! ***Java 8***이 필요합니다.

## Architecture
JUnit5는 3개의 서브 프로젝트로 구성되어 있습니다.
1. JUnit Platform
2. JUnit Jupiter
3. Junit Vintage

### JUnit Platform
- JVM 위에서 테스트 프레임워크를 실행하는 역할

### JUnit Jupiter
- JUnit5에서 추가된 Annotation을 제공
    - @TestFactory - dynamic tests를 위한 하나의 test factory 메소드임을 표시
    - @DisplayName - 하나의 테스트 클래스나 혹은 메소드의 display name을 정의
    - @Nested - denotes that the annotated class is a nested, non-static test class
    - @Tag - 테스트를 필터링 하기 위한 Tag를 정의합니다.
    - @ExtendWith - custom extension을 등록하기 위해 사용됩니다.
    - @BeforeEach - 클래스 내의 각 테스트 메소드가 실행되기 전에 실행(이전 @Before와 같음)
    - @AfterEach - 클래스 내의 각 테스트 메소드가 실행된 직후에 실행(이전 @After와 같음)
    - @BeforeAll - 클래스 내의 모든 테스트 메소드가 실행되기 전에 실행(이전 @BeforeClass와 같음)
    - @AfterAll - 클래스 내의 모든 테스트 메소드가 실행된 뒤에 실행(이전 @AfterClass와 같음)
    - @Disable - 테스트 클래스나 메소드를 disable시키는데 사용됩니다.(이전 @Ignore와 같음)
    
어노테이션의 이름이 좀 더 직관적으로 변했다.

### JUnit Vintage
JUnit5 환경에서 JUnit3와 JUnit4 실행을 지원하기 위함

## 기본 Annotations
새로운 어노테이션들을 살펴보기 전에, 위의 어노테이션을 세개의 그룹으로 나눠 봅시다.
1. 실행을 위한 어노테이션
2. 테스트 실행 전
3. 테스트 도중 그리고 테스트 실행 후


## reference
- [A Guide to JUnit 5](https://www.baeldung.com/junit-5)
- [Guide to JUnit 5 Parameterized Tests](https://www.baeldung.com/parameterized-tests-junit-5)