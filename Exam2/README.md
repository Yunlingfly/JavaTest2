cd test2

echo "第二个题目："

mvn clean

mvn compile

mvn package

cd target

#### 后台运行
java -cp test2.jar "com.hand.Server" &

#### 如果上一个jar还在运行，就再开一个窗口运行这个jar
java -cp test2.jar "com.hand.Cilent"

cd ..

cd ..