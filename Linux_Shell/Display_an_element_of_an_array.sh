read INPUT
arr[0]=$INPUT

index=1
while [ $INPUT ]
do
    read INPUT
    arr[$index]=$INPUT
    index=`expr $index + 1`
done

echo ${arr[3]}