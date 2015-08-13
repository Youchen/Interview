a=1
while [ $a -le 99 ]
do
    echo $a
    a=`expr $a + 2`
done