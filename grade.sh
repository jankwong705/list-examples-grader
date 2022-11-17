# Create your grading script here

set -e

rm -rf student-submission

mkdir student-submission

git clone $1 student-submission

cp TestListExamples.java student-submission
cd student-submission

CPATH=.:../lib/hamcrest-core-1.3.jar:../lib/junit-4.13.2.jar

if [[ -f ListExamples.java ]];
then 
    echo "File Found!"
else
    echo "File Not Found!"
    exit
fi

set +e

javac -cp $CPATH *.java

if [[ $? -eq 0 ]]
then
    echo "Successful Compile!"
else
    echo "Compile Error!"
    exit
fi

java -cp $CPATH org.junit.runner.JUnitCore TestListExamples > results.txt 2> error.txt

if [[ $? -eq 0 ]]
then
    echo "Test Passed!"
    cat results.txt
    exit
else
    echo "Tests Error!"
    cat error.txt
    exit
fi



