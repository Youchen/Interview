# Write your MySQL query statement below
# calculate two date difference
#       you may use DATEDIFF(date1, date2).
# 2015-07-02 11:58:11 - 2015-07-02 12:04:14 (6 min)
select W1.Id
from Weather W1, Weather W2
where DATEDIFF(W1.date, W2.date) = 1 And W1.Temperature > W2.Temperature;