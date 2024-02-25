/* Run this code after the first code to check whether your database catches repeated payments*/

/*ERROR: Payment for order_id x0000004 has already been made*/
CALL process_payment ("x0000004","CREDIT CARD","12345","05/02/2025","TestTest","NINJAVAN","TPY");