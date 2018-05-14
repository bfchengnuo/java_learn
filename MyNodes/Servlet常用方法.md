# Servlet 中常见的对象

## ServletConfig  

封装了所有 servlet 私有的参数设置

- getServletName
  获取 Servlet 的全类名
- getServletContext
  获取 ServletContext 对象
- getInitParameter
  获取 Servlet 配置的初始化参数
- getInitParameterNames
  获取 Servlet 配置的初始化参数的 String 类型的枚举集合


## ServletContext

封装了所有本工程（应用）所有 servlet 的参数设置

- setAttribute
  设置临时属性
- getAttribute
  获取临时属性
- getAttributeNames
  获取设置的临时属性的枚举集合
- getInitParameter
  获取配置的全局初始化配置
- getInitParameterNames
  获取配置的全局初始化配置的 String 值枚举集合
- getRealPath
  获取绝对路径（真实路径）

## HttpServletRequest

封装了所有 请求过来的方法

### 与路径有关

- getMethod
  获取请求的方法（Get、Post）
- getQueryString
  获取 url 路径后面的查询字符串，也就是请求参数字符串
- getContextPath
  获取应用路径名 /app_name
- getRequestURI
  获取请求标识符
- getRequestURL
  获取请求地址（定位符）
- getServletPath
  获取调用 servlet 的部分 url（比如：xxx.jsp）
### 与字符和MIME类型有关

- setCharacterEncoding
  设置请求的编码
- getContentType 
  设置请求的类型
- getRequestedSessionId
  获取请求的 SessionId
  
### 与属性值有关

- setAttribute
  设置临时属性
- removeAttribute
  删除临时属性
- getAttribute
  获取设置的临时属性
- getAttributeNames
  获取设置的临时属性枚举集合
  
### 与主机信息有关

- getLocalPort
  获取本地端口
  
### 与参数有关

- getParameterNames
  返回请求参数的 String 类型的枚举集合
- getParameter
  获取请求参数的值
- getParameterValues
  获取请求某一参数的值集合（同一 key 有多个值）

## HttpServletResponse

封装了所有响应过去的方法


### 与输出有关

- getOutputStream
  获取标准输出流（字节流）
- getWriter
  获取字符流

### 与字符和MIME了下有关

- setCharacterEncoding
  设置输出流的编码
- setContentType
  设置输出流的类型

## 补充

调用 `getServletContext()` 方法的时候可能会出现 NPE，原因在于：

重写了 `init(ServletConfig)`，但第一行没有调用 `super.init(config);` 就是这导致了错误！
父类的 init(ServletConfig) 有处理获取 ServletContext 对象的引用，所以才能在 doGet() 等方法中才能够通过 getServletContext() 方法获取到 SeverletContext 对象！！ 