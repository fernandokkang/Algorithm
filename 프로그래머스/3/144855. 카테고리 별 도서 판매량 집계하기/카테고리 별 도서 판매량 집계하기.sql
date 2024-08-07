SELECT b.CATEGORY, sum(bs.SALES) as TOTAL_SALES
FROM BOOK b
JOIN BOOK_SALES bs
ON b.BOOK_ID = bs.BOOK_ID
WHERE DATE_FORMAT(bs.SALES_DATE, '%Y-%m') = '2022-01'
GROUP BY b.CATEGORY
ORDER BY b.CATEGORY;