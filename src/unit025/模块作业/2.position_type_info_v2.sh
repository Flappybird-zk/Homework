#!/bin/sh
data_dir=/tmp/data/position_type_info_v2
mysql -uroot -p123456 lagou</tmp/data/position_type_info_v2_DataStructure.sql
ls /tmp/data/position_type_info_v2 |while read sqlfile
do
echo "import sql file<"$sqlfile
mysql -uroot -p123456 lagou</tmp/data/position_type_info_v2/$sqlfile
echo "done"
done
