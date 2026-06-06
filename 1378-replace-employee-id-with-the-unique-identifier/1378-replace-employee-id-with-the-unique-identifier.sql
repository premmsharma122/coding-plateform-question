# Write your MySQL query statement below
select unique_id , name from Employees e
Left join EmployeeUNI eu
on e.id = eu.id;