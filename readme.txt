http://localhost/temp/complaint/complaintform.php?consumerno=45
http://localhost/temp/complaint/complaintsingleandro.php?consumerno=45
http://localhost/temp/application/applicationform.php?consumerno=45



code to access lineman databse

$connection5 = mysql_connect("localhost", "root", "nbuser");
$db5 = mysql_select_db("lineman", $connection5);

$querycreate=mysql_query("INSERT INTO `lineman`.`123` (`serialno`, `consumerno`, `complaint`, `status`, `transformer`, `postno`) VALUES (NULL, '5465', '', '', '', '');",$connection5);
mysql_close($connection5);


http://localhost/eba/android/notifications.php?consumerno=45
http://localhost/eba/android/linemanwork.php?empno=123
http://localhost/eba/android/linemanhistory.php?empno=123

http://localhost/EBA/android/billhistory.php?consumerno=1
http://localhost/eba/android/billnew.php?consumerno=1
http://localhost/eba/android/consumerdetails.php?consumerno=1



























http://localhost/eba/android/applicationsinglestatus.php?consumerno=1