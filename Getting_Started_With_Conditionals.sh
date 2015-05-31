read INPUT

if [ "$INPUT" == "y" -o "$INPUT" == "Y" ]
then
    echo "YES"
elif [ "$INPUT" == "n" -o "$INPUT" == "N" ]
then
    echo "NO"
else
    echo
fi