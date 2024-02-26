-- 코드를 입력하세요
SELECT b.BOOK_ID, a.AUTHOR_NAME, DATE_FORMAT(b.PUBLISHED_DATE, '%Y-%m-%d') as PUBLISHED_DATE
FROM BOOK as b
LEFT JOIN AUTHOR as a
ON b.AUTHOR_ID = a.AUTHOR_ID
WHERE b.CATEGORY = '경제'
ORDER BY b.PUBLISHED_DATE;