i=0
while read WORD
do
    words[i]=$WORD
    i=`expr $i + 1`
done

index=0
while [ $index -lt ${#words[@]} ]
do
    echo -n ".${words[$index]:1:(${#words[$index]})} "
    index=`expr $index + 1`
done