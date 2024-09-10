# redis-service

Downloan stunel for windond https://www.stunnel.org/downloads.html

Then install and start the stunel

Then after downloads Redis and install it

https://redis.io/downloads/

The configure redis path in environmet variable
Then open cmd and run below command
````
-> redis-cli.exe
-> select 0
-> shutdown
-> quit
````
Then goto stunel directory and open cmd the execute below command with specify redis tar directory

C:\Program Files (x86)\stunnel\bin>
````
openssl req -x509 -nodes -days 1826 -newkey rsa:2048 -keyout D:\Test\redis-6.2.14\redis-server.key -out D:\Test\redis-6.2.14\redis-server.cert
````

Then goto java bin drectory and open CMD in administrator the go to jdk bin path and execute below command
````
keytool -list -v -keystore "C:\Program Files\Java\jdk-11.0.12\lib\security\cacerts"
OR
keytool -list -v -keystore "C:\Program Files\Java\jdk-17.0.7\lib\security\cacerts"
````
````
keytool -import -alias redis_localhost_certificate -file D:\Test\redis-6.2.14\redis-server.cert -keystore "C:\Program Files\Java\jdk-11.0.12\lib\security\cacerts" -storepass changeit
OR
keytool -import -alias redis_localhost_certificate -file D:\Test\redis-6.2.14\redis-server.cert -keystore "C:\Program Files\Java\jdk-17.0.7\lib\security\cacerts" -storepass changeit
````

Then copy redis-server.cert and redis-server.key file from D:\Test\redis-6.2.14 and paste into C:\Program Files (x86)\stunnel this path


Then open stunnel.conf file from C:\Program Files (x86)\stunnel\config

Copy and paste in Edit Configartion stunnel File and Remove Other email Setups.
````
[redis-server]
cert = C:\Program Files (x86)\stunnel\redis-server.cert
key = C:\Program Files (x86)\stunnel\redis-server.key
accept = 127.0.0.1:6380
connect = 127.0.0.1:6379

[redis-client]
client = yes
accept = 127.0.0.1:6397
connect = 127.0.0.1:6380
CAfile = C:\Program Files (x86)\stunnel\redis-server.cert
````

Then open new cmd and start redis server with below command
````
redis-server.exe "C:\Program Files\Redis\redis.windows.conf"
````

Extra command for remove alis
````
keytool -list -v -keystore "C:\Program Files\Java\jdk-11.0.12\lib\security\cacerts"
-storepass changeit

keytool -delete -alias redis_localhost_certificate -keystore "C:\Program Files\Java\jdk-11.0.12\lib\security\cacerts"

````
