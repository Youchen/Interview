# Be careful with the syntax.
#       left join ... on ...
# It's "on" not "where".
# 2015-07-02 11:45:57 - 2015-07-02 11:55:36 (10 min)
select Person.FirstName, Person.LastName, Address.City, Address.State
from Person left join Address
on Person.PersonId = Address.PersonId;