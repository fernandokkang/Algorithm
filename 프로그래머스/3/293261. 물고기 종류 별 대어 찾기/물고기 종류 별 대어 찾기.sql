select fi.ID, fni.FISH_NAME, fi.LENGTH
from FISH_INFO fi
inner join FISH_NAME_INFO fni
on fni.FISH_TYPE = fi.FISH_TYPE
WHERE (fi.FISH_TYPE, fi.LENGTH) IN (SELECT FISH_TYPE, MAX(LENGTH)
                                    FROM FISH_INFO
                                    GROUP BY FISH_TYPE);
