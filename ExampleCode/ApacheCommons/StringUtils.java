public class TestMain {  
    public static void main(String[] args) throws IllegalAccessException {  
        String str = "Hello World";  
        /*  
         * 由于StringUtils拥有100+的方法,笔者不逐一列举用法,  
         * 只列举笔者认为常用的或笔者使用过的  
         */ 
 
        // isEmpty和isBlank的区别在于isEmpty不会忽略空格,  
        // " "<--对于这样的字符串isEmpty会认为不是空,  
        // 而isBlank会认为是空,isBlank更常用  
        StringUtils.isEmpty(str);  
        StringUtils.isNotEmpty(str);  
        StringUtils.isBlank(str);  
        StringUtils.isNotBlank(str);  
 
 
        // strip      --> 去除两端的aa  
        // stripStart --> 去除开始位置的hell  
        // stripEnd   --> 去除结尾位置的orld  
        StringUtils.strip(str, "aa");  
        StringUtils.stripStart(str, "hell");  
        StringUtils.stripEnd(str, "orld");  
 
 
        // 返回字符串在第三次出现A的位置  
        StringUtils.ordinalIndexOf(str, "A", 3);  
 
 
        // 获取str 开始为hello结尾为orld中间的字符串  
        // 注意此方法返回字符串      -->substringBetween  
        // 注意此方法返回字符串数组(多了个s) --> substringsBetween  
        StringUtils.substringBetween(str, "hell", "orld");  
        StringUtils.substringsBetween(str, "hell", "orld");  
 
 
        // 重复字符串,第二种重载形式为在重复中用hahah拼接  
        StringUtils.repeat(str, 3);  
        StringUtils.repeat(str, "hahah", 2);  
 
 
        // 统计参数2在字符串中出现的次数  
        StringUtils.countMatches(str, "l");  
 
 
        // 判断字符串是否全小写或大写  
        StringUtils.isAllLowerCase(str);  
        StringUtils.isAllUpperCase(str);  
 
 
        // isAlpha        --> 全部由字母组成返回true  
        // isNumeric      -->全部由数字组成返回true  
        // isAlphanumeric -->全部由字母或数字组成返回true  
        // isAlphaSpace   -->全部由字母或空格组成返回true  
        // isWhitespace   -->全部由空格组成返回true  
        StringUtils.isAlpha(str);  
        StringUtils.isNumeric(str);  
        StringUtils.isAlphanumeric(str);  
        StringUtils.isAlphaSpace(str);  
        StringUtils.isWhitespace(str);  
 
 
        // 缩进字符串,第二参数最低为 4,要包含...  
        // 现在Hello World输出为H...  
        StringUtils.abbreviate(str, 4);  
 
 
        // 首字母大写或小写  
        StringUtils.capitalize(str);  
        StringUtils.uncapitalize(str);  
 
 
        // 将字符串数组转变为一个字符串,通过","拼接,支持传入iterator和collection  
        StringUtils.join(new String[] { "Hello", "World" }, ",");  
 
        /*  
         * 经常性要把后台的字符串传递到前提作为html代码进行解释,  
         * 可以使用以下方法进行转换,以下方法输出为  
         * <p>Hello</p>  
         */ 
        StringEscapeUtils.escapeHtml("Hello");
    }
}