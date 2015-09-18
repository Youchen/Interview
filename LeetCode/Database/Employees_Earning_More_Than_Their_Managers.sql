The Employee table holds all employees including their managers. Every employee has an Id, and there is also a column for the manager Id.

+----+-------+--------+-----------+
| Id | Name  | Salary | ManagerId |
+----+-------+--------+-----------+
| 1  | Joe   | 70000  | 3         |
| 2  | Henry | 80000  | 4         |
| 3  | Sam   | 60000  | NULL      |
| 4  | Max   | 90000  | NULL      |
+----+-------+--------+-----------+
Given the Employee table, write a SQL query that finds out employees who earn more than their managers. 
For the above table, Joe is the only employee who earns more than his manager.

+----------+
| Employee |
+----------+
| Joe      |
+----------+






mysql> select * from
    -> LeetCode_Employees emp INNER JOIN LeetCode_Employees mgr;
+----+-------+--------+-----------+----+-------+--------+-----------+
| Id | Name  | Salary | ManagerId | Id | Name  | Salary | ManagerId |
+----+-------+--------+-----------+----+-------+--------+-----------+
|  1 | Joe   |   7000 |         3 |  1 | Joe   |   7000 |         3 |
|  2 | Henry |   8000 |         4 |  1 | Joe   |   7000 |         3 |
|  3 | Sam   |   6000 |      NULL |  1 | Joe   |   7000 |         3 |
|  4 | Max   |   9000 |      NULL |  1 | Joe   |   7000 |         3 |
|  1 | Joe   |   7000 |         3 |  2 | Henry |   8000 |         4 |
|  2 | Henry |   8000 |         4 |  2 | Henry |   8000 |         4 |
|  3 | Sam   |   6000 |      NULL |  2 | Henry |   8000 |         4 |
|  4 | Max   |   9000 |      NULL |  2 | Henry |   8000 |         4 |
|  1 | Joe   |   7000 |         3 |  3 | Sam   |   6000 |      NULL |
|  2 | Henry |   8000 |         4 |  3 | Sam   |   6000 |      NULL |
|  3 | Sam   |   6000 |      NULL |  3 | Sam   |   6000 |      NULL |
|  4 | Max   |   9000 |      NULL |  3 | Sam   |   6000 |      NULL |
|  1 | Joe   |   7000 |         3 |  4 | Max   |   9000 |      NULL |
|  2 | Henry |   8000 |         4 |  4 | Max   |   9000 |      NULL |
|  3 | Sam   |   6000 |      NULL |  4 | Max   |   9000 |      NULL |
|  4 | Max   |   9000 |      NULL |  4 | Max   |   9000 |      NULL |
+----+-------+--------+-----------+----+-------+--------+-----------+
16 rows in set (0.00 sec)

mysql> select * from LeetCode_Employees emp INNER JOIN LeetCode_Employees mgr on emp.ManagerId = mgr.Id;
+----+-------+--------+-----------+----+------+--------+-----------+
| Id | Name  | Salary | ManagerId | Id | Name | Salary | ManagerId |
+----+-------+--------+-----------+----+------+--------+-----------+
|  1 | Joe   |   7000 |         3 |  3 | Sam  |   6000 |      NULL |
|  2 | Henry |   8000 |         4 |  4 | Max  |   9000 |      NULL |
+----+-------+--------+-----------+----+------+--------+-----------+
2 rows in set (0.01 sec)









# Round 2
# 2015-09-16 00:06:22
# Write your MySQL query statement below
SELECT emp.Name from
Employee emp INNER JOIN Employee mgr
on emp.ManagerId = mgr.Id
where emp.Salary > mgr.Salary





# Write your MySQL query statement below
SELECT emp.Name
From Employee emp INNER JOIN Employee manager
on emp.ManagerId = manager.Id 
Where emp.Salary > manager.Salary







