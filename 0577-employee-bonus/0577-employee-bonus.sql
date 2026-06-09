SELECT e.name, b.bonus
FROM Employee e
left JOIN Bonus b
ON e.empId = b.empId
WHERE b.bonus < 1000 or b.bonus is null;