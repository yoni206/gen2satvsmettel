s/^T//g
s/^F//g
s/\r\n/,/g
H;${x;s/\n/,/g;s/^,//;p;};d
