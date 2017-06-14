<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: 冰封承諾Andy
  Date: 2017/6/14
  Time: 18:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>标签测试</title>
    <style>
        .even{
            background-color: royalblue;
        }
        .odd{
            background-color: antiquewhite;
        }
    </style>
</head>
<body>
    <s:debug/> <br>
    request.name:<s:property value="#request.name"/> <br>
    session.name:<s:property value="#session.name"/> <br>
    application.name:<s:property value="#application.name"/> <br>
    <%-- 从小到大依次搜索 --%>
    attr.name:<s:property value="#attr.name"/> <br>
    parameters.name:<s:property value="#parameters.name"/> <br>
    <%-- 值栈 --%>
    vs.name:<s:property value="name"/> <br>
    强制表达式解析： <s:textfield label="%{#request.name}"/> <br>
    <%-- 使用单引号输出常量 --%>
    输出常量：<s:property value="'is constant'"/> <br>
    <%-- 关闭自动转义 --%>
    <s:property value="<hr>" escape="false"/>
    <hr>

    关于设置值的标签....<br>
    s:set(如果没有指定范围则默认保存在 ActionContext 的大 Map 中)---><s:set var="s-setName" value="loli"/>
    <%-- 无论是从那个域取数据，如果找不到最终都会到这个大 Map 自身中去找 --%>
    <s:property value="s-setName"/> <br>
    <hr>

    s:push(将对象放到值栈的栈顶，标签结束后会自动删除)---><br>
    <s:push value="Lolicon">
        <%-- 默认取栈顶的对象，并且调用 toString 方法 --%>
        <s:property/>
    </s:push>
    <hr>

    s:bean(创建新的 javabean 到栈顶；如果指定 var 会保存到 ActionContext 中，如果不指定，在标签结束后从值栈移除引用后就无法取得数据)---->
    <s:bean name="com.bfchengnuo.domain.User" var="mybean">
        <%-- 属性赋值 --%>
        <s:param name="name" value="奏"/>
        <s:property value="name"/>
    </s:bean>
    <br>
    <%-- # 就代表从大 Map 中找吧 --%>
    <s:property value="#mybean.name"/>
    <hr>

    s:action(在 JSP 中直接调用某个 Action)----->
    <%-- executeResult 属性可以指定是否把页面包含进来 --%>
    <s:action name="HelloWorldAction" namespace="/one" executeResult="true"/>
    <hr>

    s:iterator(迭代器，每次迭代会把数据放在栈顶)---> <br>
    <table border="0" cellspacing="1">
        <tr>
            <td>姓名</td>
            <td>年龄</td>
            <td>编号</td>
            <td>索引</td>
            <td>是否偶数</td>
        </tr>
        <s:iterator value="nameList" status="st">
            <tr class="<s:property value="#st.even?'even':'odd'"/>">
                <td><s:property value="name"/></td>
                <td><s:property value="age"/></td>
                <td><s:property value="#st.count"/></td>
                <td><s:property value="#st.index"/></td>
                <td><s:property value="#st.even"/></td>
                <%-- 状态还可以是 isFirst isLast 等 --%>
            </tr>
        </s:iterator>
    </table>
    <hr>

    s:if(支持elseif)----><br>
    age:
    <s:if test="age < 10">小于10</s:if>
    <s:elseif test="age > 20">大于20</s:elseif>
    <s:else>10-20</s:else>
    <hr>

    s:url----> <br>
    <%-- 如果加 var 属性就会存到大 Map 中去 --%>
    当前地址（带参数）：<s:url includeParams="all"/> <br>
    <s:url action="WaitAction" namespace="/reg" var="waitUrl">
        <%-- 如果有参数的话可以这样赋值 --%>
        <%--<s:param name="key" value="lalala"/>--%>
    </s:url>
    <a href="<s:property value="#waitUrl"/>">跳转等待页</a>
    <%-- 除了访问 Action 可以直接在 value 属性里写 http 地址 --%>
    <hr>

    定义集合,使用迭代器 {}---> <br>
    <s:iterator value="{'loli','2','ll','gt'}">
        <s:property /> <br>
    </s:iterator>
    <%--
        定义 Map： #{'key':'val','key2':'val'} ；需要加 # 哦
        property 取的时候直接 =key 、 =value 就行了
        因为放在栈顶的就是 Entry
    --%>

</body>
</html>
