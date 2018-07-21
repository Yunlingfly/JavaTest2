echo "开始程序"

#for((i=1;i<=3;i++));
#do
#    cd Exam"$i"
#    echo "第 $i 个题目："
#    mvn clean
#    mvn compile
#    mvn package
#    cd target
#    java -jar test"$i".jar
#    cd ..
#    cd ..
#done;

cd Exam1
echo "第一个题目"
mvn clean
mvn compile
mvn package
cd target
java -jar test1.jar
cd ..
cd ..

cd Exam2
echo "第二个题目："
mvn clean
mvn compile
mvn package
cd target
# 由于多个main用-cp指定类
java -cp test2.jar "com.hand.Server" &
java -cp test2.jar "com.hand.Cilent"
cd ..
cd ..

cd Exam3
echo "第三个题目："
mvn clean
mvn compile
mvn package
cd target
java -jar test3.jar sz300170
cd ..
cd ..