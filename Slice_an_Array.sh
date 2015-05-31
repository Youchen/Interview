read INPUT
arr[0]=$INPUT

index=1
while [ $INPUT ]
do
    read INPUT
    arr[$index]=$INPUT
    index=`expr $index + 1`
done

for IN in $(seq 3 7)
do
    echo -n "${arr[$IN]} "
done