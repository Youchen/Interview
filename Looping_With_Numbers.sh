value=1
index=0
while [ $index -le 49 ]
do
    a[$index]=$value
    value=`expr $value + 1`
    index=`expr $index + 1`
done


for VAR in ${a[*]}
do
    echo $VAR
done