function login() {
    var ret = chkUsername();
    var retpass = chkpass();
    var reme = document.getElementById("remember-me").checked;

    if (ret === 1 && retpass === 1) {
        $.ajax({
            type: "POST",
            url: "user/login/ajax", //访问路径
            data: {username: $("#name").val(), password: $("#pass").val(), remember: reme}, //参数
            success: function (msg) {
                if (msg == 'success') {
                    $(".logintable").hide();
                } else {
                    $("#div_uname_err_info").show();
                    $("#div_uname_err_info").html("帐号或者密码错误");
                }
            },
            error: function (msg) {
                alert("程序出错 请联系管理员");
            }
        });
    }

}
function chkUsername() {
    var username = $.trim($("#name").val());
    if (username === "") {
        return 0;
    } else if (username.length < 4 || username.length > 18) {
        //合法长度为6-18个字符
        return -1;
    } else if (!/^\w+$/.test(username)) {
        //用户名只能包含_,英文字母，数字
        return -2;
    }
    return 1;
}
function chkpass() {
    var username = $.trim($("#pass").val());
    if (username === "") {
        return 0;
    } else if (username.length < 5 || username.length > 18) {
        //合法长度为6-18个字符
        return -1;
    }
    return 1;
}
/** ----------- 用户名输入框事件 ----------- */
$(document).ready(function () {
    //当文本框失去焦点时
    $("#name").bind("blur", function () {
        var ret = chkUsername();
        if (ret == 1) {
            $("#div_uname_err_info").hide();
        }
        else {
            $("#div_uname_err_info").show();
            if (ret == 0) {
                $("#div_uname_err_info").html("用户名不能为空");
            } else if (ret == -1) {
                $("#div_uname_err_info").html("合法长度为5-18个字符");
            }
            else if (ret == -2) {
                $("#div_uname_err_info").html("用户名只能包含_,英文字母,数字 ");
            }
        }
        return false;
    });

    $("#pass").bind("blur", function () {
        var ret = chkpass();
        if (ret == 0) {
            $("#div_mm").html("密码不能为空");
        } else if (ret == -1) {
            $("#div_mm").html("合法长度为5-18个字符");
        }
        return false;
    });

    $("#rname").bind("blur", function () {
        var ret = chkUsername();
        if (ret == 1) {
            $("#div_uname_err_info").hide();
        }
        else {
            $("#div_uname_err_info").show();
            if (ret == 0) {
                $("#div_uname_err_info").html("用户名不能为空");
            } else if (ret == -1) {
                $("#div_uname_err_info").html("合法长度为5-18个字符");
            }
            else if (ret == -2) {
                $("#div_uname_err_info").html("用户名只能包含_,英文字母,数字 ");
            }
        }
        return false;
    });

    $("#rpass").bind("blur", function () {
        var ret = chkpass();
        if (ret == 0) {
            $("#div_mm").html("密码不能为空");
        } else if (ret == -1) {
            $("#div_mm").html("合法长度为5-18个字符");
        }
        return false;
    });
});
