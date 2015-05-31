read NUM1
read NUM2
read NUM3

if [ $NUM1 -ne $NUM2 -a $NUM2 -ne $NUM3 -a $NUM3 -ne $NUM1 ]
then
    echo "SCALENE"
elif [ $NUM1 -eq $NUM2 -a $NUM2 -eq $NUM3 -a $NUM3 -eq $NUM1 ]
then
    echo "EQUILATERAL"
else
    echo "ISOSCELES"
fi