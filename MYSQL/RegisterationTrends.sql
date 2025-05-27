SELECT DATE_FORMAT(registration_date, '%Y-%m') AS month, COUNT(*) AS registrations_count
FROM Registrations
WHERE registration_date >= CURDATE() - INTERVAL 12 MONTH
GROUP BY month
ORDER BY month;
