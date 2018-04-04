<%--
  Created by IntelliJ IDEA.
  User: Future
  Date: 2018/3/19
  Time: 10:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE HTML>
<html lang="en-US">

<head>
    <meta charset="UTF-8">
    <title>ueditor demo</title>
</head>
<body>

<!-- 第一步：引入UDEITOR编辑器的js文件 -->
<script type="text/javascript" charset="utf-8" src="/ueditor/ueditor.config.js"></script>
<script type="text/javascript" charset="utf-8" src="/ueditor/ueditor.all.js"></script>

<!-- 第二步：初始化 UDEITOR编辑器，更多的参数可以看说明文档-->
<script type="text/javascript">
    UE.getEditor('myeditor', {initialFrameHeight: 500, initialFrameWidth: 800})
</script>
<script language="javascript">
    function SendForm ()
    {
        if(CheckPost())
        {
            document.addForm.submit();
        }
    }

    function CheckPost ()
    {
        if (addForm.user.value == "")
        {
            alert("请填写用户名！");
            addForm.username.focus();
            return false;
        }
        if (addForm.blogTitle.value.length < 5)
        {
            alert("标题不能少于5个字符！");
            addForm.blogTitle.focus();
            return false;
        }
        return true;
    }
</script>
<form name="addForm" id="addForm" action="/blog/home/savePost.do">
    <input type="hidden" name="standby001" value="${studentUserName}">
    <table align="center" style="border-collapse:separate; border-spacing:0px 10px;">
        <tr>
            <td valign="top">
                <label>标题：</label>
            </td>
            <td>
                <input type="text" name="blogTitle" style="width:400px;">
            </td>
        </tr>
        <tr>
            <td valign="top">
                <label>分类：</label>
            </td>
            <td>
                <input type="text" name="blogSort" style="width:400px;">
            </td>
        </tr>
        <tr>
            <td valign="top">
                <label>主题介绍：</label>
            </td>
            <td>
               <textarea name="standby003" id="standby003" cols="80" rows="6"></textarea>
            </td>
        </tr>
        <tr>
            <td valign="top">
                <label>内容：</label>
            </td>
            <td>
                <!-- 第三步：用于显示UDEITOR编辑器，可以是<textarea>，也可以是<script>... -->
                <textarea name="content" id="myeditor">默认值..</textarea>
            </td>
        </tr>
        <tr>
            <td></td>
            <td>
                <div id="login_click">
                    <input type="submit" id="btlogin" value="提 交"/>
                </div>
            </td>
        </tr>
    </table>


</form>
</body>

<!--这里是处理加载文本编辑器和上传图片路径的脚本-->
<script>
    $(function () {
        //初始化下拉框
        initSelect();
        //初始化富文本
        initUedit();
    })

    //初始化Uedit
    function initUedit() {
        var ue = UE.getEditor('content_ue', {
            toolbars: [[
                'simpleupload', //单图上传
                'insertimage'//多图上传
            ]],
            zIndex: 9010,
            initialFrameWidth: 780,
            initialFrameHeight: 300
        });

        UE.Editor.prototype._bkGetActionUrl = UE.Editor.prototype.getActionUrl;
        UE.Editor.prototype.getActionUrl = function (action) {
            if (action == 'uploadimage') {
                return '/ueditor/uploadImage';
            } else if (action == 'listimage') {
                return '/ueditor/listimage';
            } else {
                return this._bkGetActionUrl.call(this, action);
            }
        }
    }
</script>
<style>

    #login_click {
        margin-top: 32px;
        height: 40px;
    }

    #login_click a {

        text-decoration: none;
        background: #2f435e;
        color: #f2f2f2;

        padding: 10px 30px 10px 30px;
        font-size: 16px;
        font-family: 微软雅黑, 宋体, Arial, Helvetica, Verdana, sans-serif;
        font-weight: bold;
        border-radius: 3px;

        -webkit-transition: all linear 0.30s;
        -moz-transition: all linear 0.30s;
        transition: all linear 0.30s;

    }

    #login_click a:hover {
        background: #385f9e;
    }

</style>
</html>