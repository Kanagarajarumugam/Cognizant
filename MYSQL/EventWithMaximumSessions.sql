SELECT e.event_id, e.title, COUNT(s.session_id) AS sessions_count
FROM Events e
JOIN Sessions s ON e.event_id = s.event_id
GROUP BY e.event_id, e.title
ORDER BY sessions_count DESC
LIMIT 1;
