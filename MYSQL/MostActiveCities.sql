SELECT u.city, COUNT(DISTINCT r.user_id) AS active_users
FROM Users u
JOIN Registrations r ON u.user_id = r.user_id
GROUP BY u.city
ORDER BY active_users DESC
LIMIT 5;