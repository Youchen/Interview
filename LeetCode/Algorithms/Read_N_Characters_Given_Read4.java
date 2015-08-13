/**
 * The problem description is confused me.
 * 
 * It's means that 
 *      - read4(char[] buf) could read the file(not given, exists somewhere) and store
 *          4 chars at most a time into the "buf" char array.
 *      - given a destination buffer - char[] buf2 (the one inside the parameter of method read)
 *          and you need to read n chars from file and store these n chars to this given buf2 char array.
 *      - return the actual chars that system has read.
 * 
 * Reference:
 * 
 *      Problem description inspired via:
 *           http://blog.csdn.net/u013325815/article/details/41892135
 *      Code inspired via:
 *           http://leetcode0.blogspot.com/2015/03/read-n-characters-given-read4.html
 */


/* The read4 API is defined in the parent class Reader4.
      int read4(char[] buf); */

public class Solution extends Reader4 {
    /**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return    The number of characters read
     */
    public int read(char[] buf, int n) {
        //2015-06-29 15:25:02 -1h  2015-06-29 17:08:29 (43 min)
        if(buf == null || buf.length == 0)
            return 0;
        
        char[] readChar = new char[4];
        int count = 0;
        
        while( count < n ){
            int c = read4(readChar);
            //system read c chars of file and wrote these c chars into readChar.
            
            for(int i = 0; i < Math.min(c, n - count); i++)
                buf[count + i] = readChar[i];
            
            count += Math.min(c, n - count);
            if(c < 4)
                break;
        }
        return count;
    }
}