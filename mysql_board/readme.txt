[MySQL 관련자료 ]

pom.xml - dependency

		<!-- https://mvnrepository.com/artifact/com.mysql/mysql-connector-j -->
		<dependency>
		    <groupId>com.mysql</groupId>
		    <artifactId>mysql-connector-j</artifactId>
		    <version>8.0.33</version>
		</dependency>


# scott 에게 권한 상승 
# grant all privileges on [데이터베이스명.테이블명] to [사용자@호스트] identified by '비밀번호' [with grant option];
GRANT ALL privileges on scott.* TO scott@'localhost' identified by 'tiger';

# 데이타베이스 작성(scott DB 생성)
create database scott character set utf8;

# 사용
use scott;

# 데이터베이스 안의 테이블 삭제 
DROP TABLE IF EXISTS `board`;

# 데이터베이스안에 테이블 작성 (실제 사용할 정보 저장되는 공간)
# 키보드 ESC 아래, 1키 왼쪽에 있는 `키 사용(' 키가 아님)
create table `BOARD` ( 
	`MID` INT(4) auto_increment ,
    `MWRITER` VARCHAR(4),
    `MCONTENT` VARCHAR(50),
    PRIMARY KEY(`MID`)
    )ENGINE=innodb DEFAULT CHARSET=utf8;
# MySQL MID -- AutoIncrement 

# 더미데이터  : dummy data     
INSERT INTO `BOARD` (`MWRITER`, `MCONTENT`) VALUES ('D001', '10.1');
INSERT INTO `BOARD` (`MWRITER`, `MCONTENT`) VALUES ('D001', '11.2');
INSERT INTO `BOARD` (`MWRITER`, `MCONTENT`) VALUES ('D002', '12.3');
INSERT INTO `BOARD` (`MWRITER`, `MCONTENT`) VALUES ('D002', '11.4');
INSERT INTO `BOARD` (`MWRITER`, `MCONTENT`) VALUES ('D003', '12.5');
INSERT INTO `BOARD` (`MWRITER`, `MCONTENT`) VALUES ('D003', '11.6');

commit;

select * from board;



servlet-context.xml : Modify & Insert
or root-context.xml : Modify Any of them is OK 

<!-- # MySQL dataSource -->
<!-- jdbc:mysql://127.0.0.1:3306/scott .. scott is DB Name, not Table name --> 
	<beans:bean name="dataSource" class="org.springframework.jdbc.datasource.DriverManagerDataSource" >
		<beans:property name="driverClassName" value="com.mysql.cj.jdbc.Driver" />
		<beans:property name="url" value="jdbc:mysql://127.0.0.1:3306/scott?characterEncoding=utf8" />
		<beans:property name="username" value="scott" />
		<beans:property name="password" value="tiger" />
	</beans:bean>

		
<!-- # mybatis SqlSessionFactoryBean # -->
	<beans:bean id="sqlSessionFactory" class="org.mybatis.spring.SqlSessionFactoryBean">
		<beans:property name="dataSource" ref="dataSource"/>
		<beans:property name="mapperLocations" value="classpath:com/spring/mybatis/dao/mapper/*.xml"/>
	</beans:bean>
	
	<beans:bean id="sqlSession" class="org.mybatis.spring.SqlSessionTemplate">
		<beans:constructor-arg index="0" ref="sqlSessionFactory"/>
	</beans:bean>








# Oracle DB >> MySQL :: Transform


Setting context.xml in Tomcat server.xml (Not in this time)

    <Resource auth="Container"
    driverClassName = "oracle.jdbc.driver.OracleDriver"
    maxActive="50"
    maxWait="1000"
    name="jdbc/Oracle11g"
    username="scott"
    password="tiger"
    type="javax.sql.DataSource"
    url="jdbc:oracle:thin:@localhost:1521:xe"
    />


  
Below is Reference Data in MySQL of Spring      

mySql 설정
1. 톰캣서버에 설정
2. scott_db/scott/tiger
3. LAST_INSERT_ID()+1 로 auto_increment 인 bId 값을 가져와 사용


[MySQL명령]


DROP TABLE IF EXISTS `scott_db.mvc_board`;
CREATE table `scott_db.mvc_board`(
    BID INT(4) auto_increment ,
    BNAME VARCHAR(20),
    BTITLE VARCHAR(100),
    BCONTENT VARCHAR(300),
    BDATE DATETIME DEFAULT NOW(),
    BHIT INT(4) DEFAULT 0,
    BGROUP INT(4),
    BSTEP INT(4),
    BINDENT INT(4),
	PRIMARY KEY (`BID`)
) ENGINE=innodb DEFAULT CHARSET=utf8;


INSERT INTO `mvc_board` (`BNAME`,`BTITLE`, `BCONTENT`, `BHIT`,`BGROUP`, `BSTEP`, `BINDENT`)
  VALUES ('오프라 윈프리', '가장 큰 모험', '여러분이 할 수 있는 가장 큰 모험은 바로 여러분이 꿈꾸는 삶을 사는 것입니다.', 0, LAST_INSERT_ID()+1, 0, 0);

INSERT INTO `mvc_board` (`BNAME`,`BTITLE`, `BCONTENT`, `BHIT`,`BGROUP`, `BSTEP`, `BINDENT`)
  VALUES ('랄프 왈도 에머슨', '도토리', '수천개의 숲도 한개의 도토리 열매에서 만들어진다.', 0, LAST_INSERT_ID()+1, 0, 0);

INSERT INTO `mvc_board` (`BNAME`,`BTITLE`, `BCONTENT`, `BHIT`,`BGROUP`, `BSTEP`, `BINDENT`)
  VALUES ('마이클 J. 폭스', '가족', '가족은 중요한게 아니라 모든 것입니다.', 0, LAST_INSERT_ID()+1, 0, 0);

