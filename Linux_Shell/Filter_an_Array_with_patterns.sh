read INPUT

while [ $INPUT ]
do
    if [[ "$INPUT" != *"a"* ]]
    then
        echo $INPUT
    fi
    read INPUT
done