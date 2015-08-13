# Write your MySQL query statement below
# Delete the duplicates, you need to use delete.
# Reference:
#       https://leetcode.com/discuss/29787/simple-solution
# 2015-07-02 12:15:46 - 2015-07-02 12:27:57 (13 min)
DELETE P1
FROM Person P1, Person P2
WHERE P1.Email = P2.Email AND P1.Id > P2.Id