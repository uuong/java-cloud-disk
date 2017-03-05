function a_login() {

    var inputName = document.getElementById('username');
    var input_pwd = document.getElementById('password');
    var md5_pwd = document.getElementById('md5-password');
    md5_pwd.value = sha256(input_pwd.value + "$%`");
    var reme = document.getElementById("remember-me").checked;


    $.ajax({
        type: "POST",
        url: "user/login/index",
        data: {username: inputName.value, password: md5_pwd.value, remember: reme},
        success: function (msg) {
            if (msg == 'success') {
                $("#div_uname_err_info").hide();
            } else {
                $("#div_uname_err_info").show();
                $("#div_uname_err_info").html("帐号密码错误");
            }
        },
//                    error: function (msg) {
//                        alert("程序出错 请联系管理员");
//                    }
    });

}
;

function checkPass() {
    var input_pwd = document.getElementById('password');
    if (input_pwd.value.length < 5 || input_pwd.value.length > 20) {
        $("#div_uname_err_info").show();
        $("#div_uname_err_info").html("密码长度不对");
        return false;
    } else {
        $("#div_uname_err_info").hide();
        return true;
    }
}
function checkUser() {
    var nameReg = /^[0-9a-zA-Z]{3,10}$/;
    var inputName = document.getElementById('username');

    if (!nameReg.test(inputName.value)) {
        $("#div_uname_err_info").show();
        $("#div_uname_err_info").html("用户名不存在");
        return false;
    }
    $.ajax({
        type: "POST",
        url: "user/login/ajax/name", //访问路径
        data: {username: $("#username").val()}, //参数
        success: function (msg) {
            if (msg == 'success') {
                $("#div_uname_err_info").hide();
                return true;
            } else {
                $("#div_uname_err_info").show();
                $("#div_uname_err_info").html("用户名不存在");
                return false;
            }
        },

    });
}