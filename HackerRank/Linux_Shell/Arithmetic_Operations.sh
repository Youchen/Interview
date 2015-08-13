read EXPR

# echo "scale = 3; $EXPR" | bc -l
printf "%.3f\n" $(echo $EXPR | bc -l)