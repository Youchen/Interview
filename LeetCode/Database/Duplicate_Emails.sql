-- Round 2
-- 2015-09-16 00:45:33
# Write your MySQL query statement below
select p.Email
from Person p
group by p.Email
having count(p.Email) >= 2






# Write your MySQL query statement below
SELECT Email
from Person
group by Email
having count(Email) > 1