# api
springMvc mybatis redis idea mysql rest风格api

jdbc.properties和 redis.properties 未上传

#redis settings
redis.minIdle=50
redis.maxIdle=100
redis.maxTotal=500
redis.maxWaitMillis=1500
redis.testOnBorrow=true
redis.numTestsPerEvictionRun=1024
redis.timeBetweenEvictionRunsMillis=30000
redis.minEvictableIdleTimeMillis=1800000
redis.softMinEvictableIdleTimeMillis=10000
redis.testWhileIdle=true
redis.blockWhenExhausted=false

#redisConnectionFactory settings
redis.host=*********
redis.port=6379


#mysql settings
jdbc.driverClassName=com.mysql.jdbc.Driver
jdbc.url=jdbc:mysql://*********************/******
jdbc.username=root
jdbc.password=*************