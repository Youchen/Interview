# read INPUT
# count=$INPUT

# index=0
# while [ $INPUT ]
# do
#     read INPUT
#     arr[$index]=$INPUT
#     index=`expr $index + 1`
# done

# total=0
# for VAR in ${arr[*]}
# do
#     total=`expr $total + $VAR`
# done

# printf "%.3f\n" $(echo $total / $count | bc -l)


read INPUT
count=$INPUT

total=0
for VAR in $(seq 1 $count)
do
    read INPUT
    total=`expr $total + $INPUT`
done

printf "%.3f\n" $(echo $total / $count | bc -l)

